fun main() {
    val myCar = Car("K5", 50, 30, Color.BLACK)
    myCar.printinfo()

    while (myCar.speed < 70) {
        myCar.increaseSpeed()
    }
    myCar.printinfo()

    myCar.addGas(70)
    myCar.printinfo()


    for (color in Color.values()) {
        myCar.changeColor(color)
        myCar.printinfo()
        println()
    }
}


enum class Color {
    BLACK,
    GRAY,
    WHITE
}

class Car(
    val model: String,
    var speed: Int,
    var gas: Int,
    var color: Color,
) {
    fun getSpeeds(): Int {
        return this.speed
    }

    fun increaseSpeed() {
        this.speed++
    }

    fun addGas(newGas: Int): Unit {
        this.gas += newGas
    }

    fun changeColor(newColor: Color) {
        this.color = newColor
    }

    fun printinfo() {
        println("model: $model")
        println("speed: $speed")
        println("gas: $gas")
        println("color: $color")
    }
}
