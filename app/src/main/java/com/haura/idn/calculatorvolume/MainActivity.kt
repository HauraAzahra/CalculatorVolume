package com.haura.idn.calculatorvolume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_calculate.setOnClickListener(this)

        if (savedInstanceState != null) {
            val result = savedInstanceState.getString(STATE_RESULT) as String
            tv_result.text = result
        }

    }

    companion object {
        private const val STATE_RESULT = "state_result"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, tv_result.text.toString())
    }

    override fun onClick(v: View) {
        if (v.id == R.id.btn_calculate) {
            val inputLength = et_length.text.toString().trim()
            val inputWidth = et_width.text.toString().trim()
            val inputHeight = et_height.text.toString().trim()

            var isEmptyFields = false
            val errorMessage = "Field isn't value"

            if (inputLength.isEmpty()) {
                isEmptyFields = true
                et_length.error = errorMessage
            }
            if (inputWidth.isEmpty()) {
                isEmptyFields = true
                et_width.error = errorMessage
            }
            if (inputHeight.isEmpty()) {
                isEmptyFields = true
                et_height.error = errorMessage
            }
            if (!isEmptyFields) {
                val volume = inputLength.toDouble() * inputWidth.toDouble() * inputHeight.toDouble()
                tv_result.text = volume.toString()
            }
        }
    }

}
