package com.testing.userinput

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import java.lang.NumberFormatException
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    var tipPercent: Double = 0.00
    var totalBillAmount: Double = 0.00
    var tipAmount: Double = 0.00


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val billamount: EditText = findViewById(R.id.txtDollarAmount)
        val group: Spinner = findViewById(R.id.spnGroup)
        val charges: Button = findViewById(R.id.btnCalc)
        val result: TextView = findViewById(R.id.txtTipAmount)
        fun checkSelection(userEntry: String): Double {

            try {
                userEntry.toDouble()
                return userEntry.toDouble()
            } catch(e:NumberFormatException){null}
            return 0.00
        }
        charges.setOnClickListener {
            totalBillAmount = checkSelection(billamount.text.toString())
            val currency = DecimalFormat("$###,###.00")
            tipPercent = checkSelection(group.selectedItem.toString())
            tipAmount = totalBillAmount * (tipPercent *.01)
            val tipAmountFormatted = currency.format(tipAmount)
            result.text ="$tipAmountFormatted"
        }
    }


}