fun printBothFields(player: Player, enemy: Player) {
    println("=== Поле игрока ${player.name} ===       === Поле игрока ${enemy.name} ===")
    print("   ")
    for (l in 0..1) {
        for (c in 0..9) print("$c ")
        print("           ")
    }
    println()

    val pField = player.field()
    val eField = enemy.field()

    for (r in 0..9) {
        print("$r  ")
        for (c in 0..9) print("${pField[r][c]} ")

        print("        ")
        print("$r  ")

        for (c in 0..9) print("${eField[r][c]} ")
        println()
    }
}

fun main() {
    print("Введите имя первого игрока: ")
    val name1 = readln()
    print("Введите имя второго игрока: ")
    val name2 = readln()
    val player = Player(name1)
    val enemy = Player(name2)

    player.placeShip(3, 2)
    player.placeShip(3, 3)
    enemy.placeShip(5, 7)

    player.registerShot(hit = true)
    player.makeShot(5, 7)

    player.registerShot(hit = false)
    player.makeShot(0, 0)

    player.isMyTurn = true

    println()
    player.whereDidIShoot()

    println("Всего выстрелов из свойства shots: ${player.shots}")
    println("Всего попаданий из свойства hits: ${player.hits}")

    player.printStats()
    player.isItMyTurnNow()

    println()
    printBothFields(player, enemy)

}
