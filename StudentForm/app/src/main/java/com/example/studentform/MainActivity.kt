package com.example.studentform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Button
import android.content.Intent
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var nameTextView: TextView
    private lateinit var surnameTextView: TextView
    private lateinit var passportTextView: TextView
    private lateinit var phoneTextView: TextView
    private lateinit var editButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameTextView = findViewById(R.id.nameTextView)
        surnameTextView = findViewById(R.id.surnameTextView)
        passportTextView = findViewById(R.id.passportTextView)
        phoneTextView = findViewById(R.id.phoneTextView)
        editButton = findViewById(R.id.editButton)

        editButton.setOnClickListener {
            val intent = Intent(this, EditActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE_EDIT)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_EDIT && resultCode == RESULT_OK) {
            val name = data?.getStringExtra(EXTRA_NAME)
            val surname = data?.getStringExtra(EXTRA_SURNAME)
            val passport = data?.getStringExtra(EXTRA_PASSPORT)
            val phone = data?.getStringExtra(EXTRA_PHONE)

            nameTextView.text = name
            surnameTextView.text = surname
            passportTextView.text = passport
            phoneTextView.text = phone
        }
    }

    companion object {
        const val REQUEST_CODE_EDIT = 1
        const val EXTRA_NAME = "name"
        const val EXTRA_SURNAME = "surname"
        const val EXTRA_PASSPORT = "passport"
        const val EXTRA_PHONE = "phone"
    }
}