class Player(val name: String) {

    private val _field: Array<CharArray> = Array(10) { CharArray(10) { '.' } }

    private var _shots: Int = 0
    private var _hits: Int = 0

    val shots: Int
        get() = _shots

    val hits: Int
        get() = _hits
    var shipLeft: Int = 20
    var isMyTurn: Boolean = false
    var pastShotsText: String = ""
    fun field(): Array<CharArray> = _field

    fun placeShip(row: Int, col: Int) {
        if (row in 0..9 && col in 0..9) {
            _field[row][col] = '#'
        }
    }
    fun registerShot(hit: Boolean) {
        _shots++
        if (hit) _hits++
    }

    fun isAlive(): Boolean {
        if (shipLeft > 0) {
            return true
        } else {
            return false
        }
    }

    fun accuracy(): Double {
        if (shots == 0) {
            return 0.0
        }
        val percent = (hits * 100.0) / shots
        return percent
    }

    fun status() {
        println("Игрок $name: палуб осталось: $shipLeft, выстрелов: $shots, попаданий: $hits, точность: ${accuracy()}%")
    }

    fun takeDamage(): Boolean {
        shipLeft = shipLeft - 1
        val alive = isAlive()
        return alive
    }

    fun reset() {
        _shots = 0
        _hits = 0
        shipLeft = 20
        isMyTurn = false
        pastShotsText = ""

        for (r in 0..9) {
            for (c in 0..9) {
                _field[r][c] = '.'
            }
        }
        println("=== Поле игрока $name очищено ===")
        printField()
    }

    fun printField() {
        println("=== Поле игрока $name ===")
        println("  0 1 2 3 4 5 6 7 8 9")
        for (r in 0..9) {
            print("$r ")
            for (c in 0..9) {
                print("${_field[r][c]} ")
            }
            println()
        }
    }

    fun printStats() {
        status()
    }

    fun whereDidIShoot() {
        if (pastShotsText == "") {
            println("Игрок $name еще ни разу не стрелял")
        } else {
            println("Игрок $name стрелял в клетки: $pastShotsText")
        }
    }

    fun isItMyTurnNow() {
        if (isMyTurn == true) {
            println("Сейчас ходит: $name")
        } else {
            println("Сейчас ходит соперник игрока $name")
        }
    }

    fun makeShot(row: Int, col: Int) {
        pastShotsText = pastShotsText + "[$row,$col] "
    }
}
