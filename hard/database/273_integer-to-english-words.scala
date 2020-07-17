
object Solution {
    val group_type = Array(10, 100, 1000, 1000000, 1000000000)
    val digit_type = Array("Hundred", "Thousand", "Million", "Billion")

    val number_type_1 = Array("", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen")
    val number_type_2 = Array("", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety")

    val floor_division = (i: Int, j: Int) ⇒ Math.ceil(i / j).toInt

    def numberToWords(number: Int): String = {
        def run(number: Int): String = {
            if(number < 20)
                number_type_1(number)
            else if (number < group_type(1)) {
                s"${number_type_2(floor_division(number, group_type(0)))} ${run(number % group_type(0))}"
            }
            else if (number < group_type(2)) {
                s"${run(floor_division(number, group_type(1)))} ${digit_type(0)} ${run(number % group_type(1))}"
            }
            else if (number < group_type(3)) {
                s"${run(floor_division(number, group_type(2)))} ${digit_type(1)} ${run(number % group_type(2))}"
            }
            else if (number < group_type(4)) {
                s"${run(floor_division(number, group_type(3)))} ${digit_type(2)} ${run(number % group_type(3))}"
            }
            else {
                s"${run(floor_division(number, group_type(4)))} ${digit_type(3)} ${run(number % group_type(4))}"
            }
        }

        if(number == 0)
            "Zero"
        else
            run(number).split(" ").filterNot(_.isEmpty).mkString(" ")
    }
}
