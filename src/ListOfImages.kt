import java.io.File

class ListOfImages {
    private val directoryPath = "./static"
    private val files = File(directoryPath).listFiles()?.toList()

    fun getImages(): List<String> {
        return files?.map { it.name }?.sorted() ?: emptyList()
    }
}