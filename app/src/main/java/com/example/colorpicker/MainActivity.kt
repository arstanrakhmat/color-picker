package com.example.colorpicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import com.example.colorpicker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val layout = binding.layout

        binding.changeColor.setOnClickListener {
            val view = layoutInflater.inflate(R.layout.dialog_spiner, null)
            val alertDialog = AlertDialog.Builder(this@MainActivity)
                .setTitle("Choose bg Color")

            val spinner = view.findViewById<Spinner>(R.id.spinner1)

            spinnerSettings(spinner)

            alertDialog.setPositiveButton("Yes") { _, _ ->
                setBackground(
                    spinner.selectedItem.toString(),
                    layout
                )
            }

            alertDialog.setView(view)
            alertDialog.show()
            true
        }
    }

    private fun spinnerSettings(spinner: Spinner) {
        val mAdapter = ArrayAdapter(
            this@MainActivity, android.R.layout.simple_spinner_item,
            resources.getStringArray(R.array.colorsss)
        )

        mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = mAdapter
    }

    private fun setBackground(text: String, constraintLayout: ConstraintLayout) {
        when (text) {
            "White" -> constraintLayout.setBackgroundColor(resources.getColor(R.color.white))
            "Black" -> constraintLayout.setBackgroundColor(resources.getColor(R.color.black))
            "Blue" -> constraintLayout.setBackgroundColor(resources.getColor(R.color.blue))
            "Yellow" -> constraintLayout.setBackgroundColor(resources.getColor(R.color.yellow))
            "Red" -> constraintLayout.setBackgroundColor(resources.getColor(R.color.red))
            "Orange" -> constraintLayout.setBackgroundColor(resources.getColor(R.color.orange))
            "Purple" -> constraintLayout.setBackgroundColor(resources.getColor(R.color.purple_500))
            "Brown" -> constraintLayout.setBackgroundColor(resources.getColor(R.color.brown))
            "Pink" -> constraintLayout.setBackgroundColor(resources.getColor(R.color.pink))
        }
    }
}