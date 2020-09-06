var HotdogStand = arrayOf("hot dog", "pretzel", "fries", "corn dog", "ketchup", "mustard", "cans of soda",
        "bottles of juice", "napkins", "paper food trays") // supply of items in hot dog stand
var qty = arrayOf("10", "8", "12", "4", "3", "2", "5", "6", "30", "25") // quantity of items in hot dog stand
var isexit = true  //to end the first loop

fun main() { // main function

    do {  //menu
        for (i in 0..HotdogStand.count() - 1) { //goes through the items in the Hotdogstand
            println("$i -   ${HotdogStand[i]}    ${qty[i]}")  //runs through and prints the index, the item paired with the index, and the quantity of the item

        }

        print("Enter the number of the inventory you want to change: ")  //asks the user a question
        var userAns = readLine()!!.toInt()  // gets the user input and holds it in the userAns variable
        askNext(userAns) // takes the user answer to the next function

    } while (isexit) //ends this loop

}

fun askNext(menuItem: Int){ // The next function that will ask the user for some new information
    println("Would you like to with the ${HotdogStand[menuItem]}?") // a println that asks the user a question about the item they chose in the previous function
        println("1 for add or 2 for subtract from the inventory.") // Asks the user if they want to add or subtract from the inventory of the item they chose
        var inventory = readLine()!!.toInt() // asks user input and holds it in the inventory variable
        when(inventory) { //starts a new menu for a new choice
            1 -> {  // if 1 is chosen
                println("How much do you want to add?")  // asks the user a question
                var amount = readLine()!!.toInt() // gets user input and stores it in the amount variable
                qty[menuItem] = (qty[menuItem].toInt() + amount).toString() // updates the menu to show the new quantity by adding to the quantity

            }
            2 -> { // if 2 is chosen
                println("How much do you want to subtract?") // asks the user a question
                var amount = readLine()!!.toInt() // gets user input and stores it in the amount variable
                if ((qty[menuItem].toInt()) > 0) //checks to make sure the quantity of the item doesn't go below
                    qty[menuItem] = (qty[menuItem].toInt() - amount).toString() // updates the menu to show the new quantity by adding to the quantity
                else println("Error: Inventory can't go below 0")  // prints and error if the amount makes the quantity go below 0
            }
            !in 1..2 -> println("Invalid Option, Please Try Again") // checks to see if the user chose an non-available option and to make them select again
        }
}
