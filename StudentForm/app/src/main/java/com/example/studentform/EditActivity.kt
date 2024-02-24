package com.example.studentform
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Button
import android.content.Intent
import android.widget.EditText
class EditActivity : AppCompatActivity(){
    private lateinit var nameEditText: EditText
    private lateinit var surnameEditText: EditText
    private lateinit var passportEditText: EditText
    private lateinit var phoneEditText: EditText
    private lateinit var saveButton: Button
    private lateinit var cancelButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        nameEditText = findViewById(R.id.nameEditText)
        surnameEditText = findViewById(R.id.surnameEditText)
        passportEditText = findViewById(R.id.passportEditText)
        phoneEditText = findViewById(R.id.phoneEditText)
        saveButton = findViewById(R.id.saveButton)
        cancelButton = findViewById(R.id.cancelButton)

        saveButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val surname = surnameEditText.text.toString()
            val passport = passportEditText.text.toString()
            val phone = phoneEditText.text.toString()
            // Проверка имени
            if (name.isEmpty() || !name.matches(Regex("[A-Z][a-z]+"))) {
                nameEditText.error = "Имя должно начинаться с заглавной буквы и содержать только буквы"
                return@setOnClickListener
            }

            // Проверка фамилии
            if (surname.isEmpty() || !surname.matches(Regex("[A-Z][a-z]+"))) {
                surnameEditText.error = "Фамилия должна начинаться с заглавной буквы и содержать только буквы"
                return@setOnClickListener
            }

            // Проверка паспорта
            if (passport.isEmpty() || !passport.matches(Regex("[0-9]{10}"))) {
                passportEditText.error = "Паспорт должен содержать только цифры и состоять из 10 цифр"
                return@setOnClickListener
            }

            // Проверка телефона
            if (phone.isEmpty() || !phone.matches(Regex("^[+][0-9]{11}"))) {
                phoneEditText.error = "Телефон должен начинаться с + и содержать 10 цифр"
                return@setOnClickListener
            }
            if(phoneEditText.error==null&&passportEditText.error==null&&surnameEditText.error==null&&nameEditText.error==null){
            val intent = Intent()
            intent.putExtra(MainActivity.EXTRA_NAME, name)
            intent.putExtra(MainActivity.EXTRA_SURNAME, surname)
            intent.putExtra(MainActivity.EXTRA_PASSPORT, passport)
            intent.putExtra(MainActivity.EXTRA_PHONE, phone)

            setResult(RESULT_OK, intent)
            finish()}

        }

        cancelButton.setOnClickListener {
            setResult(RESULT_CANCELED)
            finish()
        }
    }
}

