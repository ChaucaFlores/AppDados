package utp.edu.pe

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Inicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val usernameEditText: EditText = findViewById(R.id.log_usu)
        val passwordEditText: EditText = findViewById(R.id.log_pass)
        val toggleVisibility: ImageView = findViewById(R.id.toggle_password_visibility)
        val loginButton: Button = findViewById(R.id.button)

        var isPasswordVisible = false

        toggleVisibility.setOnClickListener {
            if (isPasswordVisible) {
                // Ocultar contraseña
                passwordEditText.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                toggleVisibility.setImageResource(R.drawable.ocultar)
            } else {
                // Mostrar contraseña
                passwordEditText.inputType = InputType.TYPE_CLASS_TEXT
                toggleVisibility.setImageResource(R.drawable.mostrar)
            }
            passwordEditText.setSelection(passwordEditText.text.length)
            isPasswordVisible = !isPasswordVisible
        }

        // iniciar sesión
        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (username == "admin" && password == "1234") {
                Toast.makeText(this, "Iniciando sesión...", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, Menu::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}