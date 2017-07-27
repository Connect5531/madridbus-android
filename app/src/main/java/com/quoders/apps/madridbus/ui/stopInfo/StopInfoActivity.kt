package com.quoders.apps.madridbus.ui.stopInfo

import android.os.Bundle
import android.support.v4.widget.ContentLoadingProgressBar
import android.view.View
import butterknife.BindView
import butterknife.ButterKnife
import com.quoders.apps.madridbus.BaseActivity
import com.quoders.apps.madridbus.R
import javax.inject.Inject

class StopInfoActivity : BaseActivity(), StopInfoContract.View {

    companion object {
        const val INTENT_EXTRA_STOP_CODE = "com.quoders.apps.madridbus.ui.stopInfo.INTENT_EXTRA_STOP_CODE"
    }

    @Inject
    lateinit var mPresenter: StopInfoContract.Presenter


    @BindView(R.id.progressBarStopInfo)
    internal var mProgressBar: ContentLoadingProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stop_info)
        ButterKnife.bind(this)

        val stopCode = intent.getStringExtra(INTENT_EXTRA_STOP_CODE)
        mPresenter.onViewStart(stopCode)
    }

    override fun showProgressBar() {
        mProgressBar!!.visibility = View.VISIBLE
    }

    override fun dismissProgressBar() {
        mProgressBar!!.visibility = View.INVISIBLE
    }

    override fun showErrorLoadingInfo() {

    }

    override fun setPresenter(presenter: StopInfoContract.Presenter) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
