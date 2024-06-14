import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

class TransparentCheck {
    fun hasTransparency(imageName: String, directoryPath: String): Boolean {
        val img: BufferedImage = ImageIO.read(File("$directoryPath/$imageName"))
        for (x in 0..<img.width) {
            for (y in 0..<img.height) {
                val pixel = img.getRGB(x, y)
                if ((pixel shr 24) and 0xff < 255) {
                    return true
                }
            }
        }
        return false
    }
}