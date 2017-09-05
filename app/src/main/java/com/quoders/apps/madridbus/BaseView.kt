package com.quoders.apps.madridbus

interface BaseView<in T> {
    fun setPresenter(presenter: T)
}
