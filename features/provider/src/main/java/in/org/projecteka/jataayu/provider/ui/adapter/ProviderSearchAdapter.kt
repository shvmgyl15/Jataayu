package `in`.org.projecteka.jataayu.provider.ui.adapter

import `in`.org.projecteka.featuresprovider.R
import `in`.org.projecteka.jataayu.presentation.adapter.GenericRecyclerViewAdapter
import `in`.org.projecteka.jataayu.presentation.callback.ItemClickCallback
import `in`.org.projecteka.jataayu.provider.model.ProviderInfo
import `in`.org.projecteka.jataayu.util.extension.findView
import `in`.org.projecteka.jataayu.util.extension.getString
import `in`.org.projecteka.jataayu.util.extension.toNameCase
import android.content.Context
import android.os.Build
import android.text.Html
import android.text.Spanned
import android.widget.TextView

class ProviderSearchAdapter(itemClickCallback: ItemClickCallback, list: List<ProviderInfo>) :
    GenericRecyclerViewAdapter(itemClickCallback, list) {
    constructor(itemClickCallback: ItemClickCallback) : this(itemClickCallback, listOf())

    private var suggestions: List<ProviderInfo> = list
    private var query: CharSequence = ""

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        val viewModel = listOfBinding!![position]
        holder.bind(viewModel)
        val searchResultView = holder.itemView.findView<TextView>(R.id.provider_name)
        val providerInfo = suggestions[position]
        searchResultView.text = highlight(
            query.toString(),
            if (providerInfo.name.isEmpty())
                searchResultView.getString(R.string.no_results_found)
            else providerInfo.nameCityPair(),
            context = searchResultView.context
        )
    }

    private fun highlight(search: String, originalText: String, context: Context): Spanned? {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return Html.fromHtml(
                originalText.replace(
                    search.toNameCase(),
                    formatBold(search, context)
                ), Html.FROM_HTML_MODE_LEGACY
            )
        }
        return Html.fromHtml(originalText.replace(search.toNameCase(), formatBold(search, context)))
    }

    private fun formatBold(search: String, context: Context): String {
        return String.format(context.getString(R.string.boldify), search.toNameCase())
    }

    fun updateData(query: CharSequence, providers: List<ProviderInfo>) {
        super.updateData(providers)
        this.query = query
        suggestions = providers
        notifyDataSetChanged()
    }
}