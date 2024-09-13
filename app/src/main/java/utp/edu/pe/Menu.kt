package utp.edu.pe

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Menu : AppCompatActivity() {

    private var selectedImageView: ImageView? = null
    private var selectedCantidad: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btn: Button = findViewById(R.id.button)
        btn.setOnClickListener {
            val intent: Intent = Intent(this, Lanzamiento:: class.java)
            startActivity(intent)
        }


        // Obtener las imagenes
        val dado4 = findViewById<ImageView>(R.id.dado4)
        val dado6 = findViewById<ImageView>(R.id.dado6)
        val dado8 = findViewById<ImageView>(R.id.dado8)
        val dado10 = findViewById<ImageView>(R.id.dado10)
        val dado12 = findViewById<ImageView>(R.id.dado12)
        val dado20 = findViewById<ImageView>(R.id.dado20)
        val undado = findViewById<ImageView>(R.id.undado)
        val dosdados = findViewById<ImageView>(R.id.dosdados)


        // Configurar los listeners
        dado4.setOnClickListener { selectImage(dado4) }
        dado6.setOnClickListener { selectImage(dado6) }
        dado8.setOnClickListener { selectImage(dado8) }
        dado10.setOnClickListener { selectImage(dado10) }
        dado12.setOnClickListener { selectImage(dado12) }
        dado20.setOnClickListener { selectImage(dado20) }
        undado.setOnClickListener { selectCantidad(undado) }
        dosdados.setOnClickListener { selectCantidad(dosdados) }

    }

    private fun selectImage(imageView: ImageView) {
        // Deselecciona la imagen
        selectedImageView?.isSelected = false

        // Selecciona la imagen
        imageView.isSelected = true
        selectedImageView = imageView
    }

    private fun selectCantidad(imageView: ImageView) {
        // Deseleccionar la imagen de cantidad previamente seleccionada
        selectedCantidad?.isSelected = false

        // Seleccionar la nueva imagen de cantidad
        imageView.isSelected = true
        selectedCantidad = imageView
    }
}