fun main() {
    val listOfImages = ListOfImages()
    val directoryPath = "./static"
    val outputDirectoryPath = "./static/png"
    val images = ListOfImages().getImages(directoryPath)

    if (ListOfImages().getImages(directoryPath).isEmpty()) {
        println("В папке нет изображений")
        return
    }

    val mainmenu = MainMenu()

    while (true) {
        val userChoice = mainmenu.printMainMenu()
        when (userChoice) {
            1 -> {
                println("Список изображений в папке $directoryPath")
                images.forEach { image ->
                    println("Имя файла: $image, Размер: ${listOfImages.getFileSize(image)} KB, Разрешение: ${listOfImages.getImageResolution(image)}")
                }
            }

            2 -> Converter().convertToPng(ListOfImages().getImages(directoryPath), "./static", "./static/png")

            3 -> {
                val convertedImages = listOfImages.getImages(outputDirectoryPath)
                convertedImages.forEach() { image ->
                    if (TransparentCheck().hasTransparency(image, outputDirectoryPath)) {
                        println("Изображение $image имеет прозрачность")
                    } else {
                        println("Изображение $image не имеет прозрачности")
                    }
                }
            }

            0 -> {
                println("Завершение работы")
                return
            }
            else -> println("Неверный пункт меню")
            }
    }
}