package utp.edu.pe

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.widget.VideoView
import android.media.PlaybackParams
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class Lanzamiento : AppCompatActivity() {

    private lateinit var historialContent: TextView
    private val historialResultados = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lanzamiento)

        val videoView: VideoView = findViewById(R.id.video_view)

        val videoUri = Uri.parse("android.resource://${packageName}/${R.raw.dado_girando}")
        videoView.setVideoURI(videoUri)

        // video
        videoView.setOnPreparedListener { mediaPlayer ->
            mediaPlayer.isLooping = true

            // velocidad
            val playbackParams = PlaybackParams()
            playbackParams.speed = 4.0f
            mediaPlayer.playbackParams = playbackParams

            videoView.start()
            Toast.makeText(this, "Video cargado exitosamente", Toast.LENGTH_SHORT).show()
        }

        videoView.setOnErrorListener { mediaPlayer, what, extra ->
            Toast.makeText(this, "Error al cargar el video: $what, $extra", Toast.LENGTH_LONG).show()
            true
        }

        historialContent = findViewById(R.id.historial_content)

        val tipoDado = intent.getIntExtra("tipo_dado", 6)
        val cantidadDados = intent.getIntExtra("cantidad_dados", 1)

        val mensaje = "Tipo de dado: $tipoDado, Cantidad de dados: $cantidadDados"
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()

        // lanzar el dado
        val btnLanzar: Button = findViewById(R.id.button_lanzar)
        btnLanzar.setOnClickListener {
            lanzarDado(tipoDado, cantidadDados)
        }

        // historial
        val btnHistorial: Button = findViewById(R.id.button)
        btnHistorial.setOnClickListener {
            verHistorial(tipoDado, cantidadDados)
        }
    }

    private fun lanzarDado(tipoDado: Int, cantidadDados: Int) {
        val resultados = mutableListOf<Int>()
        for (i in 1..cantidadDados) {
            resultados.add((1..tipoDado).random())
        }

        val fechaHora = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault()).format(Date())

        val resultadoTexto = "Lanzado: ${resultados.joinToString(", ")}\nFecha y hora: $fechaHora\n\n"
        historialResultados.add(resultadoTexto)
        historialContent.append(resultadoTexto)
    }

    private fun verHistorial(tipoDado: Int, cantidadDados: Int) {
        val intent = Intent(this, Historial::class.java)
        intent.putStringArrayListExtra("historial", ArrayList(historialResultados))
        intent.putExtra("tipo_dado", tipoDado)  // Utiliza la variable tipoDado que ya tienes
        intent.putExtra("cantidad_dados", cantidadDados)  // Utiliza la variable cantidadDados
        startActivity(intent)
    }

}




