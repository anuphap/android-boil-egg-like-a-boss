package com.a3cha.proegg.widget

import android.annotation.SuppressLint
import android.content.Context
import android.os.CountDownTimer
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.a3cha.proegg.R
import com.a3cha.proegg.extension.toTime


class TimerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    private var progressBar: ProgressBar? = null
    private var timerTextView: TextView? = null
    private var countDownTimer: CountDownTimer? = null

    var maxTime: Long = 0L
        set(value) {
            field = value
            timerTextView?.text = value.toTime()
            progressBar?.max = value.toInt()
            progressBar?.progress = value.toInt()

            createTimer()
        }

    init {
        View.inflate(context, R.layout.widget_timer_progress, this)
        progressBar = findViewById(R.id.progressBar)
        timerTextView = findViewById(R.id.timerTextView)
        initAttrs(attrs)
    }

    private fun initAttrs(attrs: AttributeSet?) {
        attrs ?: return

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.TimerView)
        maxTime = typedArray.getInteger(R.styleable.TimerView_maxTime, 0).toLong()

        typedArray.recycle()
    }

    private fun createTimer() {
        // setup timer
        countDownTimer = object : CountDownTimer(maxTime, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                Log.i("Timer", "$millisUntilFinished")
                timerTextView?.text = millisUntilFinished.toTime()
                progressBar?.progress = millisUntilFinished.toInt()
            }

            @SuppressLint("SetTextI18n")
            override fun onFinish() {
                progressBar?.progress = 0
                timerTextView?.text = context.getString(R.string.stop)
            }
        }
    }

    fun startTimer() {
        countDownTimer?.start()
    }

    fun resetTimer() {
        countDownTimer?.cancel()
        timerTextView?.text = maxTime.toTime()
        progressBar?.max = maxTime.toInt()
        progressBar?.progress = maxTime.toInt()
    }
}