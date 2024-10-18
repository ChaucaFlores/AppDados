package utp.edu.pe

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Menu : AppCompatActivity() {

    private var selectedImageView: ImageView? = null
    private var selectedCantidad: ImageView? = null

    private var tipoDadoSeleccionado: Int = 0
    private var cantidadDadosSeleccionada: Int = 0

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
            //verificamos si se ha seleccionado un tipo de dado y cantidad
            if (tipoDadoSeleccionado != 0 && cantidadDadosSeleccionada != 0) {
                val intent = Intent(this, Lanzamiento::class.java)
                // Pasar el tipo de dado y la cantidad de dados
                intent.putExtra("tipo_dado", tipoDadoSeleccionado)
                intent.putExtra("cantidad_dados", cantidadDadosSeleccionada)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Por favor selecciona el tipo y la cantidad de dados.", Toast.LENGTH_SHORT).show()
            }
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
        dado4.setOnClickListener { selectImage(dado4, 4) }
        dado6.setOnClickListener { selectImage(dado6, 6) }
        dado8.setOnClickListener { selectImage(dado8, 8) }
        dado10.setOnClickListener { selectImage(dado10, 10) }
        dado12.setOnClickListener { selectImage(dado12, 12) }
        dado20.setOnClickListener { selectImage(dado20, 20) }
        undado.setOnClickListener { selectCantidad(undado, 1) }
        dosdados.setOnClickListener { selectCantidad(dosdados, 2) }

    }

    private fun selectImage(imageView: ImageView, tipoDado: Int) {
        // Deselecciona la imagen
        selectedImageView?.isSelected = false
        // Selecciona la imagen
        imageView.isSelected = true
        selectedImageView = imageView
        // Guardar el tipo de dado seleccionado
        tipoDadoSeleccionado = tipoDado
    }

    private fun selectCantidad(imageView: ImageView, cantidad: Int) {
        selectedCantidad?.isSelected = false
        imageView.isSelected = true
        selectedCantidad = imageView
        cantidadDadosSeleccionada = cantidad
    }
}