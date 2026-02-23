package com.example.kmpfirstnews

class NewsPresenter : Presenter {
    override var view: ScreenView? = null

    override fun attach(view: ScreenView) {
        this.view = view
    }

    override fun detach() {
        view = null
    }
}