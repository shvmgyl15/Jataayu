package `in`.projecteka.jataayu.presentation.callback

import androidx.databinding.ViewDataBinding

interface ItemClickCallback {
    fun onItemClick(iDataBindingModel : IDataBindingModel, itemViewBinding: ViewDataBinding)
}
