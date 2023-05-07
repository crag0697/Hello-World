class Character(
    var name: String = "",
    var race: String = "",
    var stats: MutableList<Int> = mutableListOf(8, 8, 8, 8, 8, 8),
    var bank: Int = 27
) {

    init {

    }

    fun namePick()
    {
        print("Please enter the name for your character: ")
        name = readLine() ?: ""
    }
    fun racePick()
    {
        print("Please choose the race that your character will be: ")
        println("(Human: +1 to all stats. ---- Elf: +2 Dexterity, +1 Wisdom)")
        race = readLine() ?: ""
    }

    fun addStat()
    {
        var usInput: Int = 0
        println("Here you can modify your stats. You have a bank of 27 points.")
        println("Altering a value between 8 and 13 costs 1 point.")
        println("Each stat increase above 13 costs 2 points. When you are out of points,")
        println("your scores are complete. No score may begin above a maximum of 15 before race bonuses.")
        do {
            println("$stats Bank: $bank")

            println("Pick which stat you would like to add to: ")
            println("1. Strength")
            println("2. Dexterity.")
            println("3. Intelligence.")
            println("4. Constitution")
            println("5. Wisdom")
            println("6. Charisma")
            println("7. Return to menu.")
            val userInput = readLine()
            usInput = userInput?.toIntOrNull() ?: 0

                when (usInput) {
                    1 -> if (stats[0] < 15)
                        addOne(0, stats[0])
                    else
                        println("I'm sorry, that stat is already maxed out.")
                    2 -> if (stats[1] < 15)
                        addOne(1, stats[1])
                    else
                        println("I'm sorry, that stat is already maxed out.")
                    3 -> if (stats[2] < 15)
                        addOne(2, stats[2])
                    else
                        println("I'm sorry, that stat is already maxed out.")
                    4 -> if (stats[3] < 15)
                        addOne(3, stats[3])
                    else
                        println("I'm sorry, that stat is already maxed out.")
                    5 -> if (stats[4] < 15)
                        addOne(4, stats[4])
                    else
                        println("I'm sorry, that stat is already maxed out.")
                    6 -> if (stats[5] < 15)
                        addOne(5, stats[5])
                    else
                        println("I'm sorry, that stat is already maxed out.")
            }
        } while (usInput != 7)
    }

    fun subtractStat()
    {
        println("Here you can modify your stats. You can decrease a stat to")
        println("no lower than 8.")
        var usInput: Int = 0
        do {
            println("$stats Bank: $bank")
            println("Pick which stat you would like to subtract from: ")
            println("1. Strength")
            println("2. Dexterity.")
            println("3. Intelligence.")
            println("4. Constitution")
            println("5. Wisdom")
            println("6. Charisma")
            println("7. Return to menu.")
            val userInput = readLine()
            usInput = userInput?.toIntOrNull() ?: 0

            when (usInput) {
                1 -> if (stats[0] > 8)
                    subtractStat(0, stats[0])
                    else
                        println("I'm sorry, that stat is already as low as it can go.")
                2 -> if (stats[1] > 8)
                    subtractStat(1, stats[1])
                else
                    println("I'm sorry, that stat is already as low as it can go.")
                3 -> if (stats[2] > 8)
                    subtractStat(2, stats[2])
                else
                    println("I'm sorry, that stat is already as low as it can go.")
                4 -> if (stats[3] > 8)
                    subtractStat(3, stats[3])
                else
                    println("I'm sorry, that stat is already as low as it can go.")
                5 -> if (stats[4] > 8)
                    subtractStat(4, stats[4])
                else
                    println("I'm sorry, that stat is already as low as it can go.")
                6 -> if (stats[5] > 8)
                    subtractStat(5, stats[5])
                else
                    println("I'm sorry, that stat is already as low as it can go.")
            }
        } while (usInput != 7)
    }

    fun addOne(index: Int, value: Int)
    {
        if (index >= 0 && index < stats.size && value <= 15)
            stats[index] += 1
            if (stats[index] <= 13)
                bank -= 1
            else if (stats[index] > 13)
                bank -= 2
            else
                println("I'm sorry, it looks like your stat is already maxed out.")
    }

    fun subtractStat(index: Int, value: Int)
    {
        if (index >= 0 && index < stats.size && value > 8)
            stats[index] -= 1
        if (stats[index] < 13)
            bank += 1
        else if (stats[index] >= 13)
            bank += 2
    }

    fun displayCharacter()
    {
        println("Name: $name")
        println("Race: $race")

        if (race == "Human") {
            for (i in 0 until stats.size)
                stats[i] += 1
        }
        else if (race == "Elf") {
            stats[1] += 2
            stats[4] += 1
        }

        println("Strength: ${stats[0]}")
        println("Dexterity: ${stats[1]}")
        println("Intelligence: ${stats[2]}")
        println("Constitution: ${stats[3]}")
        println("Wisdom: ${stats[4]}")
        println("Charisma: ${stats[5]}")

    }
}

fun main(args: Array<String>) {
    var option: Int = 0
    val character = Character()
    do {
        println("Welcome to the character builder.")
        println("1. Create New Character.")
        println("2. Increase stats.")
        println("3. Decrease stats.")
        println("4. Display character.")
        println("5. Close Program.")

        val userInput = readLine()
        option = userInput?.toIntOrNull() ?: 0

        when (option) {
            1 -> {
                character.namePick()
                character.racePick()
            }
            2 -> character.addStat()
            3 -> character.subtractStat()
            4 -> character.displayCharacter()
        }

    } while (option != 5)

}