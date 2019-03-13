package com.example.msorbaro.sorbaromidterm

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.example.msorbaro.sorbaromidterm.R.id.back
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.cost_row.view.*
import kotlinx.android.synthetic.main.new_pin_layout.*
import android.widget.Toast
import android.R.attr.data
import java.security.AccessController.getContext


class pinActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {

            super.onCreate(savedInstanceState)
            setContentView(R.layout.new_pin_layout)


            submitPin.setOnClickListener {
//                var intentResult = Intent()
//              //  intentResult.putExtra("KEY_MY_RESULT", totalSummary.text.toString())
//                setResult(Activity.RESULT_OK, intentResult)
//                finish()

                if(pin.text.toString() == getString(R.string.pin)){
                    var intentStart = Intent()
                    intentStart.setClass(this@pinActivity, MainActivity:: class.java )
                    startActivityForResult(intentStart, MainActivity.REQUEST_DETAILS)
                }

                else {
                    Toast.makeText(getBaseContext(), getString(R.string.pinError), Toast.LENGTH_LONG).show()
                }

            }

        }
    }

