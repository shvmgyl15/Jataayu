package `in`.projecteka.jataayu.consent.viewmodel

import `in`.projecteka.jataayu.util.livedata.SingleLiveEvent
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

class ConsentHostFragmentViewModel() : ViewModel(), SwipeRefreshLayout.OnRefreshListener {

    //refreshDataEvent
    val pullToRefreshEvent = MutableLiveData<Boolean>()
    val isRefreshing = ObservableBoolean(false)

    internal enum class Action {
        SELECT_CONSENTS_TAB
    }

    internal val viewPagerState = SingleLiveEvent<Action>()

    fun setUp(){
        viewPagerState.value = Action.SELECT_CONSENTS_TAB
    }

    override fun onRefresh() {
        isRefreshing.set(true)
        pullToRefreshEvent.value = true
    }

    fun showRefreshing(isRefresh: Boolean){
        isRefreshing.set(isRefresh)
    }

    fun selectConsentsTab(){
        viewPagerState.value = Action.SELECT_CONSENTS_TAB
    }
}