package utp.edu.pe

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class Bienvenida : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenida)

        // Esperar 3 segundos y pasar a la pantalla de inicio de sesión
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, Inicio::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}