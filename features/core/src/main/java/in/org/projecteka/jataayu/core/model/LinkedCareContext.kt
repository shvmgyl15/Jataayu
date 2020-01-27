package `in`.org.projecteka.jataayu.core.model

import `in`.org.projecteka.jataayu.core.BR
import `in`.org.projecteka.jataayu.core.R
import `in`.org.projecteka.jataayu.presentation.callback.IDataBindingModel
import com.google.gson.annotations.SerializedName

data class LinkedCareContext(
    @SerializedName("referenceNumber") override val referenceNumber: String,
    @SerializedName("display") override val display: String
) :
    CareContext(referenceNumber, display), IDataBindingModel {

    override fun layoutResId(): Int = R.layout.linked_account_result_item

    override fun dataBindingVariable() = BR.linkedCareContext
}