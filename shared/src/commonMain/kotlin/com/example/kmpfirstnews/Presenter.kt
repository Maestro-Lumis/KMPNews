package com.example.kmpfirstnews

interface Presenter {
    var view: ScreenView?
    fun attach(view: ScreenView)
    fun detach()
}

interface ScreenView {
    var presenter: Presenter?
}