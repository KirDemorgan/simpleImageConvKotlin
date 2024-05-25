class MainMenu {
    fun printMainMenu(): Int {
            println("1. Список изображений")
            println("2. Конвертировать в png")
            println("0. Выход")
            print("Введите необходимы пункт меню: ")
            return readlnOrNull()?.toIntOrNull() ?: 0
        }
}