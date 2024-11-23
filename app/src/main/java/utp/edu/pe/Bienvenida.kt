// Declaramos el paquete donde se encuentra la clase.
package utp.edu.pe

// Importación de las clases necesarias.
import android.content.Intent // Para realizar la transición entre actividades.
import android.os.Bundle // Para pasar datos entre actividades.
import android.os.Handler // Para ejecutar código con retraso.
import android.os.Looper // Para acceder al hilo principal.
import androidx.appcompat.app.AppCompatActivity // Para actividades con compatibilidad retroactiva.

class Bienvenida : AppCompatActivity() { // Clase que extiende de AppCompatActivity.
    
    // Método llamado cuando la actividad se crea.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // Llamada al método 'onCreate' de la superclase.
        
        setContentView(R.layout.activity_bienvenida) // Establece el layout de la actividad.

        // Usamos un Handler para ejecutar el siguiente bloque de código con un retraso de 3 segundos.
        Handler(Looper.getMainLooper()).postDelayed({
            // Creamos un Intent para iniciar la actividad 'Inicio'.
            val intent = Intent(this, Inicio::class.java)
            
            // Iniciamos la actividad 'Inicio'.
            startActivity(intent)
            
            // Finalizamos la actividad actual ('Bienvenida').
            finish()
        }, 3000) // Retraso de 3000 milisegundos (3 segundos).
    }
}
