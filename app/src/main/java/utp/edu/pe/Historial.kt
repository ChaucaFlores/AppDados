package utp.edu.pe

import android.content.Intent
import android.os.Bundle
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class Historial : AppCompatActivity() {

    private lateinit var historialContent: TableLayout
    private lateinit var btnVolverLanzar: AppCompatButton
    private lateinit var btnMenu: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historial)

        // Obtener la referencia del TableLayout
        historialContent = findViewById(R.id.historial_content)

        // Recuperar la lista de resultados enviada desde Lanzamiento
        val historialResultados = intent.getStringArrayListExtra("historial") ?: arrayListOf()
        val tipoDado = intent.getIntExtra("tipo_dado", 6) // Recuperar el tipo de dado
        val cantidadDados = intent.getIntExtra("cantidad_dados", 1) // Recuperar la cantidad de dados

        val tableRowHeader = TableRow(this)
        val textViewHeader = TextView(this)

        textViewHeader.text = " CARAS: $tipoDado    CANTIDAD: $cantidadDados"
        textViewHeader.textSize = 30f
        textViewHeader.setTypeface(null, android.graphics.Typeface.BOLD)
        textViewHeader.setPadding(8, 8, 8, 8)
        textViewHeader.setTextColor(resources.getColor(android.R.color.black))  // Cambiar color del encabezado a negro
        tableRowHeader.addView(textViewHeader)
        historialContent.addView(tableRowHeader)

        // Verifica si la lista tiene resultados y muestra
        if (historialResultados.isNotEmpty()) {
            for (resultado in historialResultados) {
                val tableRow = TableRow(this)

                // Crear un TextView para cada resultado
                val textView = TextView(this)
                textView.text = resultado
                textView.setPadding(38, 0, 0, 0)
                textView.setTextColor(resources.getColor(android.R.color.black))

                // Añadir el TextView a la fila
                tableRow.addView(textView)

                // Añadir la fila al TableLayout
                historialContent.addView(tableRow)
            }
        } else {
            val tableRow = TableRow(this)
            val textView = TextView(this)
            textView.text = "No hay resultados aún."
            textView.setPadding(8, 8, 8, 8)
            textView.setTextColor(resources.getColor(android.R.color.black))  // Cambiar color del texto a negro
            tableRow.addView(textView)
            historialContent.addView(tableRow)
        }

        // Configurar los botones
        btnVolverLanzar = findViewById(R.id.button1)
        btnMenu = findViewById(R.id.button2)

        btnVolverLanzar.setOnClickListener {
            // Volver a la actividad de lanzamiento
            onBackPressed()
        }

        btnMenu.setOnClickListener {
            // Crear un Intent para ir a la actividad Menu
            val intent = Intent(this, Menu::class.java)
            startActivity(intent)  // Iniciar la actividad Menu
            finish()  // Opcional, si quieres cerrar la actividad Historial después de abrir Menu
        }
    }
}



