package com.example.kmpfirstnews

class NewsListVM : ScreenView {
    override var presenter: Presenter? = null

    init {
        presenter = NewsPresenter().apply {
            attach(this@NewsListVM)
        }
    }

    fun loadNews() {}
}