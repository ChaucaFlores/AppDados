package utp.edu.pe

import android.content.Context
import android.view.MotionEvent
import org.rajawali3d.lights.PointLight
import org.rajawali3d.loader.LoaderOBJ
import org.rajawali3d.materials.Material
import org.rajawali3d.math.vector.Vector3
import org.rajawali3d.renderer.Renderer
import org.rajawali3d.Object3D
import javax.microedition.khronos.opengles.GL10

class Dado3D(context: Context) : Renderer(context) {

    private lateinit var dado: Object3D

    override fun initScene() {

        // Configura la luz y la cámara
        val light = PointLight()
        light.position = Vector3(2.0, 2.0, 2.0)
        light.power = 2.0f
        currentScene.addLight(light)

        // Cargar el modelo del dado
        val loader = LoaderOBJ(context.resources, textureManager, R.raw.d4)
        dado = loader.parsedObject // Acceder a la propiedad parsedObject
        dado.isVisible = true
        val material = Material()
        material.color = 0xFF0000
        dado.material = material
        currentScene.addChild(dado)
        currentCamera.position.z = 5.0
    }

    override fun onRenderFrame(glUnused: GL10?) {
        super.onRenderFrame(glUnused)
        if (::dado.isInitialized) {
            dado.rotate(Vector3.Axis.Y, 1.0) // Rotar el dado en el eje Y
        }
    }

    override fun onOffsetsChanged(xOffset: Float, yOffset: Float, xOffsetStep: Float, yOffsetStep: Float, xPixelOffset: Int, yPixelOffset: Int) {
    }

    override fun onTouchEvent(event: MotionEvent?) {
        // Aquí puedes manejar el evento táctil
        if (event != null && event.action == MotionEvent.ACTION_DOWN) {
            dado.rotate(Vector3.Axis.Y, 90.0) // Gira el dado 90 grados al tocar
        }
    }
}












