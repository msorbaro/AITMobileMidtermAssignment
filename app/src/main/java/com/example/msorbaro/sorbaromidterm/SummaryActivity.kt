package com.example.msorbaro.sorbaromidterm

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.cost_row.view.*
import kotlinx.android.synthetic.main.summary_layout.*

class SummaryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.summary_layout)

        if (intent.hasExtra(MainActivity.TOTAL)) {
            totalSummary.text = "Total: $" + intent.getStringExtra(MainActivity.TOTAL)
        }

        if (intent.hasExtra(MainActivity.EXPENSE)) {
            totalExpense.text = "Expenses: $" + intent.getStringExtra(MainActivity.EXPENSE)
        }

        if (intent.hasExtra(MainActivity.INCOME)) {
            totalIncome.text = "Income: $" + intent.getStringExtra(MainActivity.INCOME)
        }


        back.setOnClickListener {
            var intentResult = Intent()
            intentResult.putExtra("KEY_MY_RESULT", totalSummary.text.toString())
            setResult(Activity.RESULT_OK, intentResult)
            finish()
            }

        }
    }
