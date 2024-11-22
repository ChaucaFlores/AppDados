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

        historialContent = findViewById(R.id.historial_content)

        val historialResultados = intent.getStringArrayListExtra("historial") ?: arrayListOf()
        val tipoDado = intent.getIntExtra("tipo_dado", 6) 
        val cantidadDados = intent.getIntExtra("cantidad_dados", 1) 

        val tableRowHeader = TableRow(this)
        val textViewHeader = TextView(this)

        textViewHeader.text = " CARAS: $tipoDado    CANTIDAD: $cantidadDados"
        textViewHeader.textSize = 30f
        textViewHeader.setTypeface(null, android.graphics.Typeface.BOLD)
        textViewHeader.setPadding(8, 8, 8, 8)
        textViewHeader.setTextColor(resources.getColor(android.R.color.black))  
        tableRowHeader.addView(textViewHeader)
        historialContent.addView(tableRowHeader)

        
        if (historialResultados.isNotEmpty()) {
            for (resultado in historialResultados) {
                val tableRow = TableRow(this)
                val textView = TextView(this)
                textView.text = resultado
                textView.setPadding(38, 0, 0, 0)
                textView.setTextColor(resources.getColor(android.R.color.black))
                tableRow.addView(textView)
                historialContent.addView(tableRow)
            }
        } else {
            val tableRow = TableRow(this)
            val textView = TextView(this)
            textView.text = "No hay resultados aún."
            textView.setPadding(8, 8, 8, 8)
            textView.setTextColor(resources.getColor(android.R.color.black))  
            tableRow.addView(textView)
            historialContent.addView(tableRow)
        }
        
        btnVolverLanzar = findViewById(R.id.button1)
        btnMenu = findViewById(R.id.button2)
        btnVolverLanzar.setOnClickListener {
            onBackPressed()
        }

        btnMenu.setOnClickListener {
            val intent = Intent(this, Menu::class.java)
            startActivity(intent)  
            finish()  
        }
    }
}



