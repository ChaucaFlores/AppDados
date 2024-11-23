// Declaramos el paquete donde se encuentra la clase.
package utp.edu.pe

// Importación de clases necesarias de Android.
import android.content.Intent // Para realizar la transición entre actividades.
import android.os.Bundle // Para pasar datos entre actividades y gestionar el estado.
import android.widget.TableLayout // Para la creación de tablas en la interfaz.
import android.widget.TableRow // Para representar una fila dentro de la tabla.
import android.widget.TextView // Para mostrar texto dentro de la interfaz.
import androidx.appcompat.app.AppCompatActivity // Para actividades con soporte hacia versiones anteriores de Android.
import androidx.appcompat.widget.AppCompatButton // Para botones con soporte de compatibilidad.

class Historial : AppCompatActivity() {

    // Declaración de las variables de interfaz.
    private lateinit var historialContent: TableLayout // Contenedor de la tabla de resultados.
    private lateinit var btnVolverLanzar: AppCompatButton // Botón para volver a la pantalla anterior.
    private lateinit var btnMenu: AppCompatButton // Botón para ir al menú principal.

    // Método llamado cuando la actividad es creada.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // Llamada al método 'onCreate' de la superclase.

        setContentView(R.layout.activity_historial) // Establece el layout de la actividad.

        // Inicializamos la variable que contiene la tabla de resultados.
        historialContent = findViewById(R.id.historial_content)

        // Recuperamos los datos enviados desde la actividad anterior (historial de resultados, tipo de dado y cantidad de dados).
        val historialResultados = intent.getStringArrayListExtra("historial") ?: arrayListOf() // Lista de resultados del historial.
        val tipoDado = intent.getIntExtra("tipo_dado", 6) // Tipo de dado (por defecto 6 caras).
        val cantidadDados = intent.getIntExtra("cantidad_dados", 1) // Cantidad de dados (por defecto 1 dado).

        // Creamos una fila para mostrar el encabezado de la tabla con los datos del tipo de dado y cantidad de dados.
        val tableRowHeader = TableRow(this)
        val textViewHeader = TextView(this)

        // Establecemos el texto del encabezado y su estilo.
        textViewHeader.text = " CARAS: $tipoDado    CANTIDAD: $cantidadDados"
        textViewHeader.textSize = 30f
        textViewHeader.setTypeface(null, android.graphics.Typeface.BOLD) // Texto en negrita.
        textViewHeader.setPadding(8, 8, 8, 8) // Relleno de los márgenes.
        textViewHeader.setTextColor(resources.getColor(android.R.color.black)) // Establecemos el color del texto.
        tableRowHeader.addView(textViewHeader) // Agregamos el encabezado a la fila.
        historialContent.addView(tableRowHeader) // Añadimos la fila al contenedor.

        // Verificamos si hay resultados en el historial.
        if (historialResultados.isNotEmpty()) {
            // Si hay resultados, iteramos sobre ellos y los mostramos en filas de la tabla.
            for (resultado in historialResultados) {
                val tableRow = TableRow(this)
                val textView = TextView(this)
                textView.text = resultado // Establecemos el texto para cada resultado.
                textView.setPadding(38, 0, 0, 0) // Ajustamos el relleno de la celda.
                textView.setTextColor(resources.getColor(android.R.color.black)) // Establecemos el color del texto.
                tableRow.addView(textView) // Agregamos la celda a la fila.
                historialContent.addView(tableRow) // Añadimos la fila al contenedor.
            }
        } else {
            // Si no hay resultados, mostramos un mensaje indicando que no hay resultados.
            val tableRow = TableRow(this)
            val textView = TextView(this)
            textView.text = "No hay resultados aún." // Mensaje informativo.
            textView.setPadding(8, 8, 8, 8) // Relleno de márgenes.
            textView.setTextColor(resources.getColor(android.R.color.black)) // Color del texto.
            tableRow.addView(textView) // Agregamos el mensaje a la fila.
            historialContent.addView(tableRow) // Añadimos la fila al contenedor.
        }

        // Inicialización y asignación de los eventos de los botones.
        btnVolverLanzar = findViewById(R.id.button1) // Botón para volver a la pantalla anterior.
        btnMenu = findViewById(R.id.button2) // Botón para ir al menú principal.

        // Evento para el botón 'Volver a lanzar', que retrocede a la actividad anterior.
        btnVolverLanzar.setOnClickListener {
            onBackPressed() // Retrocede a la actividad anterior.
        }

        // Evento para el botón 'Menú', que redirige al menú principal de la aplicación.
        btnMenu.setOnClickListener {
            val intent = Intent(this, Menu::class.java) // Creamos un intent para ir al menú.
            startActivity(intent) // Iniciamos la actividad 'Menu'.
            finish() // Terminamos la actividad actual ('Historial') para que no se pueda volver a ella.
        }
    }
}
