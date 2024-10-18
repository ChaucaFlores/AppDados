package utp.edu.pe

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class Lanzamiento : AppCompatActivity() {

    private lateinit var historialContent: TextView // TextView para mostrar el historial
    private val historialResultados = mutableListOf<String>() // Lista para almacenar los resultados de los lanzamientos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lanzamiento)

        // Inicializa el TextView para el historial
        historialContent = findViewById(R.id.historial_content)

        val tipoDado = intent.getIntExtra("tipo_dado", 6) // Asigna el número de lados del dado
        val cantidadDados = intent.getIntExtra("cantidad_dados", 1)

        val mensaje = "Tipo de dado: $tipoDado, Cantidad de dados: $cantidadDados"
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()

        // Botón para lanzar el dado
        val btnLanzar: Button = findViewById(R.id.button_lanzar)
        btnLanzar.setOnClickListener {
            lanzarDado(tipoDado, cantidadDados)
        }

        // Botón para ver el historial
        val btnHistorial: Button = findViewById(R.id.button)
        btnHistorial.setOnClickListener {
            verHistorial()
        }
    }

    private fun lanzarDado(tipoDado: Int, cantidadDados: Int) {
        // Genera el número aleatorio para cada dado lanzado
        val resultados = mutableListOf<Int>()
        for (i in 1..cantidadDados) {
            resultados.add((1..tipoDado).random())
        }

        // Obtiene la fecha y hora actuales
        val fechaHora = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault()).format(Date())

        // Construye el string para el historial
        val resultadoTexto = "Lanzado: ${resultados.joinToString(", ")}\nFecha y hora: $fechaHora\n\n"
        historialResultados.add(resultadoTexto) // Añade el resultado a la lista de historial
        historialContent.append(resultadoTexto) // Añade el resultado al TextView de historial
    }

    private fun verHistorial() {
        // Crea el Intent para abrir la actividad Historial
        val intent = Intent(this, Historial::class.java)
        // Pasa el historial como String
        intent.putExtra("historial", historialResultados.joinToString(""))
        startActivity(intent)
    }
}


