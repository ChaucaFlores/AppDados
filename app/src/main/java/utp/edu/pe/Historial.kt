package utp.edu.pe

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Historial : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_historial)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tipoDado = intent.getIntExtra("tipo_dado", 0)
        val cantidadDados = intent.getIntExtra("cantidad_dados", 0)

        // volver a lanzar
        val btn: Button = findViewById(R.id.button1)
        btn.setOnClickListener {
            val intent = Intent(this, Lanzamiento::class.java)
            intent.putExtra("tipo_dado", tipoDado) // Enviar el tipo de dado
            intent.putExtra("cantidad_dados", cantidadDados) // Enviar la cantidad de dados
            startActivity(intent)
        }

        // menú
        val btn2: Button = findViewById(R.id.button2)
        btn2.setOnClickListener {
            val intent = Intent(this, Menu::class.java)
            startActivity(intent)
        }
    }
}
