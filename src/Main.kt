fun main() {
    if (ListOfImages().getImages().isEmpty()) {
        println("В папке нет изображений")
        return
    }
    val userChoice = MainMenu().printMainMenu()
    when (userChoice) {
        1 -> print(ListOfImages().getImages())
        2 -> Converter().convertToPng(ListOfImages().getImages(), "./static", "./static/png")
        0 -> println("Выход")
        else -> println("Неверный пункт меню")
    }
}