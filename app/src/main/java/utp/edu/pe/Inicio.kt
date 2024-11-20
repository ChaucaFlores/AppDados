package utp.edu.pe

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
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

        // Botón para iniciar sesión
        val btn: Button = findViewById(R.id.button)
        btn.setOnClickListener {
            val intent: Intent = Intent(this, Menu::class.java)
            startActivity(intent)
        }

        // Funcionalidad del campo de contraseña y botón de visibilidad
        val passwordEditText: EditText = findViewById(R.id.log_pass)
        val toggleVisibility: ImageView = findViewById(R.id.toggle_password_visibility)

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
            // Mantener el cursor al final del texto
            passwordEditText.setSelection(passwordEditText.text.length)
            isPasswordVisible = !isPasswordVisible
        }
    }
}
