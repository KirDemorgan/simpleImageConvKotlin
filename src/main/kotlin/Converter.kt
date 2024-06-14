import kotlinx.coroutines.*
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

class Converter {
    fun convertToPng(images: List<String>,
                     directoryPath: String,
                     outputDirectoryPath: String) = runBlocking {
        println("Конвертация изображений в папке $directoryPath в формат png в папку $outputDirectoryPath")
        val newDirectory = File(outputDirectoryPath)
        if (!newDirectory.exists()) {
            newDirectory.mkdir()
        }

        images.forEach { imageName ->
            launch {
                val imagePath: String = "$directoryPath/$imageName"
                val image: BufferedImage = ImageIO.read(File(imagePath))
                val outputfile: File = File("$outputDirectoryPath/${imageName.replace(".jpg", ".png")}")
                ImageIO.write(image, "png", outputfile)
            }
        }
        println("Конвертация завершена")
    }
}