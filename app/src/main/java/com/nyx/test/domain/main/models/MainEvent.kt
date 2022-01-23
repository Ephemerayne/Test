package com.nyx.test.domain.main.models

sealed class MainEvent {
    data class AddMoneyToWallet(val money: Int): MainEvent()
}