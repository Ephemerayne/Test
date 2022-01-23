package com.nyx.test.domain.main

import com.nyx.test.domain.base.BaseSharedViewModel
import com.nyx.test.domain.main.models.MainAction
import com.nyx.test.domain.main.models.MainEvent
import com.nyx.test.domain.main.models.MainViewState

class MainViewModel : BaseSharedViewModel<MainViewState, MainAction, MainEvent>() {

    init {
        viewState = MainViewState()
    }

    override fun obtainEvent(viewEvent: MainEvent) {
        when (viewEvent) {
            is MainEvent.AddMoneyToWallet -> sumMoney(viewEvent.money)
        }
    }

    private fun sumMoney(money: Int) {
        viewState = viewState.copy(walletSum = viewState.walletSum + money)
    }
}