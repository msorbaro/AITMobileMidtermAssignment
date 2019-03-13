package com.example.msorbaro.sorbaromidterm

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toast
import com.example.msorbaro.sorbaromidterm.R.id.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.cost_row.view.*
import android.support.design.widget.Snackbar
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {

    var total = 0
    var income = 0
    var expense = 0

    companion object {
        val INCOME = "INCOME"
        val EXPENSE = "EXPENSE"
        val TOTAL = "TOTAL"
        val REQUEST_DETAILS = 1001
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSave.setOnClickListener{
            insertCost()
        }

        inputType.setOnClickListener{
            if (inputType.text == getString(R.string.IncomeChange)) {
                inputType.text = getString(R.string.ExpenseChange)
            }
            else {
                inputType.text = getString(R.string.IncomeChange)
            }
        }


        totalMoney.text = "Summary: $" + total.toString()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_summary -> {
                var intentStart = Intent()
                intentStart.setClass(this@MainActivity, SummaryActivity:: class.java )
                intentStart.putExtra(TOTAL, total.toString())
                intentStart.putExtra(INCOME, income.toString())
                intentStart.putExtra(EXPENSE, expense.toString())
                startActivityForResult(intentStart, REQUEST_DETAILS)
            }
            R.id.action_delete -> {
                layoutContent.removeAllViews()
            }
        }

        return true
    }


    private fun insertCost() {
        if (itemCost.text.toString()!= "" && itemName.text.toString()!= "")
        {
            val viewCost = layoutInflater.inflate(
                    R.layout.cost_row, null, false
            )

            viewCost.name.text = itemName.text.toString()
            viewCost.cost.text = itemCost.text.toString()

            // Income
            if(inputType.text == getString(R.string.ExpenseChange)){
                viewCost.imageView.setImageResource(R.drawable.money)
                total += (viewCost.cost.text as String).toInt()
                totalMoney.text = "Summary: $" + total.toString()
                income += (viewCost.cost.text as String).toInt()
            }

            // Expense
            else {
                viewCost.imageView.setImageResource(R.drawable.nomoney)
                total -= (viewCost.cost.text as String).toInt()
                totalMoney.text = "Summary: $" + total.toString()
                expense += (viewCost.cost.text as String).toInt()


            }

            layoutContent.addView(viewCost, 0)

        }
        else {
            //Toast.makeText(this, "You did not enter the fields properly", Toast.LENGTH_SHORT).show();
            Snackbar.make( layoutContent, getString(R.string.errorString), Snackbar.LENGTH_LONG).show()
        }


    }

}
