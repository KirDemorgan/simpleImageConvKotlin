import java.io.File
import javax.imageio.ImageIO
import java.awt.image.BufferedImage

class ListOfImages {
    private val directoryPath = "./static"
    fun getImages(directoryPath: String): List<String> {
        val files = File(directoryPath).listFiles()?.toList()
        return files?.map { it.name }?.sorted() ?: emptyList()
    }

    fun getFileSize(fileName: String): Long {
        val file = File("$directoryPath/$fileName")
        return file.length() / 1024
    }

    fun getImageResolution(fileName: String): String {
        val img: BufferedImage = ImageIO.read(File("$directoryPath/$fileName"))
        return "${img.width}x${img.height}"
    }
}
