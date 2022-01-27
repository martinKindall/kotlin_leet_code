package easy

class ReplaceDigitWithChars {

    fun replaceDigits(s: String): String {
        // each character has a numeric value. I guess a was like 34 or something
        // then it is useful to have a method that converts char to int, we sum it
        // with the shifted value, and then convert back the number into a character

        // we do the previous iteration every 2 steps

        val result = StringBuilder()

        for (idx in s.indices step 2) {
            if (idx+1 >= s.length) {
                result.append(s[idx].toString())
                break
            }
            val currCharNum = s[idx].toInt()
            val shiftedCode = currCharNum + s[idx+1].toString().toInt()
            result.append(s[idx].toString(), shiftedCode.toChar())
        }

        return result.toString()
    }
}