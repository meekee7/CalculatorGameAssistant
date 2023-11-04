import java.util.*
import kotlin.math.abs
import kotlin.math.roundToInt

fun Int.pow(exp: Int): Int {
    var result = this
    repeat(exp) {
        result *= this
    }
    return result
}

fun Int.countDigits(): Int = kotlin.math.ceil(kotlin.math.log10(this.toDouble())).toInt()

data class State(val moves: List<String>, val value: Int)

abstract class NamedMove(val name: String)
class SingleMove(name: String, val move: (Int) -> Int) : NamedMove(name)
class RangedMove(name: String, val move: (Int) -> List<Pair<String, Int>>) : NamedMove(name)

infix fun String.singleMove(move: (Int) -> Int) = SingleMove(this, move)
infix fun String.rangedMove(move: (Int) -> List<Pair<String, Int>>) = RangedMove(this, move)

fun appendCopy(list: List<String>, value: String): List<String> {
    val copy = list.toMutableList()
    copy.add(value)
    return copy
}

fun DigitSum(x: Int): Int = when {
    x < 0 -> DigitSum(-x)
    x < 10 -> x
    else -> x % 10 + DigitSum(x / 10)
}

fun fAddX(x: Int): (Int) -> Int = { it + x }
fun fMinusX(x: Int): (Int) -> Int = { it - x }
fun fMulX(x: Int): (Int) -> Int = { it * x }
fun fDivX(x: Int): (Int) -> Int = { if (it % x == 0) it / x else Int.MIN_VALUE }
fun fLShift(): (Int) -> Int = { it / 10 }
fun fSubst(from: Int, to: Int): (Int) -> Int = { it.toString().replace(from.toString(), to.toString()).toInt() }
fun fAddDigits(x: Int): (Int) -> Int = { (it.toString() + x.toString()).toIntOrNull() ?: Int.MIN_VALUE }
fun fSquare(): (Int) -> Int = { it * it }
fun fCube(): (Int) -> Int = { it * it * it }
fun fInv(): (Int) -> Int = { it * -1 }
fun fRev(): (Int) -> Int = { if (it >= 0) it.toString().reversed().toInt() else fRev()(abs(it)) * -1 }
fun fDigitSum(): (Int) -> Int = { DigitSum(it) }
fun fDigitSwapL(): (Int) -> Int = {
    val str = it.toString()
    val begin = str.first()
    val main = str.substring(1)
    (main + begin).toInt()
}

fun fDigitSwapR(): (Int) -> Int = {
    val str = it.toString()
    val begin = str.last()
    val main = str.substring(0, str.lastIndex)
    (begin + main).toInt()
}

fun fSortAsc(): (Int) -> Int = {
    if (it == 0)
        0
    else
        String(it.toString().toCharArray().toList().filterNot { it == '0' }.sorted().toCharArray()).toInt()
}

fun fSortDesc(): (Int) -> Int = {
    if (it == 0)
        0
    else
        String(
            it.toString().toCharArray().toList().filterNot { it == '0' }.sortedDescending().toCharArray()
        ).toIntOrNull() ?: 0
}

fun fRemove(x: String): (Int) -> Int = {
    it.toString().replace(x, "").toIntOrNull() ?: 0
}

fun fDel(): (Int) -> List<Pair<String, Int>> = {
    val str = it.toString()
    if (str.length <= 1 || (str.length == 2 && str[0] == '-'))
        emptyList()
    else
        str.indices.filterNot { str[it] == '-' }.map { index ->
            val removed = str.removeRange(index, index + 1)
            val number = if (removed.isNotEmpty()) removed.toInt() else 0
            "d${index + 1}" to number
        }
}

fun fInsert(str: String): (Int) -> List<Pair<String, Int>> = {
    val number = it.toString()
    (0..number.length).map { index ->
        "ins$str.${index + 1}" to (number.substring(0, index) + str + number.substring(index)).toInt()
    }
}

fun fRound(): (Int) -> List<Pair<String, Int>> = { number ->
    val str = number.toString()
    str.indices.map {
        val p = 10.pow(it)
        val r = (number.toDouble() / p).roundToInt() * p
        "rnd${str.length - it - 1}" to r
    }
}

fun fAddXAtDigit(x: Int): (Int) -> List<Pair<String, Int>> = { number ->
    val str = number.toString()
    str.indices.map {
        val array = str.toCharArray()
        val digit = array[it]
        if (!digit.isDigit())
            return@map "INVALID" to Int.MIN_VALUE
        val newdigit = (("$digit".toInt() + x) % 10).digitToChar()
        array[it] = newdigit
        val result = String(array)
        "p+$x.${it + 1}" to result.toInt()
    }
    //(0..number.countDigits()).map { "p+$x@${it + 1}" to number + x * 10.pow(it) }
}

fun fSubtractXAtDigit(x: Int): (Int) -> List<Pair<String, Int>> = { number ->
    val str = number.toString()
    str.indices.map {
        val array = str.toCharArray()
        val digit = array[it]
        var intdigit = "$digit".toInt()
        if (intdigit < x) {
            intdigit += 10
            //println("$intdigit AND $x")
            //return@map "INvALID" to Int.MIN_VALUE
        }
        val newdigit = ((intdigit - x) % 10).digitToChar()
        array[it] = newdigit
        val result = String(array)
        println("$x | $it | $number | $result")
        "p-$x.${it + 1}" to result.toInt()
    }
    //(0..number.countDigits()).map { "p-$x@${it + 1}" to number - x * 10.pow(it) }
}

fun fFlipSign(): (Int) -> Int = { it * -1 }
fun fMirror() : (Int) -> Int = {
    val str = it.toString()
    (str + str.reversed()).toIntOrNull() ?: Int.MIN_VALUE
}

fun fShift2(): (Int) -> Int = {
    if (it < 10)
        it
    else {
        val str = it.toString()
        val prefix = str.first()
        val suffix = str.substring(1)
        (suffix + prefix).toInt()
    }
}

fun fShiftRanged(): (Int) -> List<Pair<String, Int>> = { number ->
    if (number < 10)
        emptyList()

//    (0..number.length).map { index ->
//        "ins$str.${index + 1}" to (number.substring(0, index) + str + number.substring(index)).toInt()
//    }

    else {
        val str = number.toString()
        //val last = str.last()
        //str = str.substring(0, str.length - 1)
        str.indices.map {
            val inv = str.lastIndex - it
            val prefix = str.substring(0, inv)
            val suffix = str.substring(inv)
            "shift${it + 1}" to (suffix + prefix).toInt()
            //if (it == 0)
            //    "shift1" to (last + suffix).toInt()
            //else
            //    "shift${it + 1}" to (suffix + last + prefix).toInt()
        }
       // fInsert("$last")(str.toInt()).map { "shift" + it.first.substringAfter('.') to it.second }
    }
}

data class Cfg(
    val target: Int,
    val start: Int,
    val max: Int,
    val moves: Map<String, (Int) -> Int>,
    val rangedMoves: List<(Int) -> List<Pair<String, Int>>>
)

fun decode(input: String): Cfg {
    val inputs = input.split(',').map { it.trim() }

    val target = inputs[0].toInt()
    val start = inputs[1].toInt()
    val max = inputs[2].toInt()

    val removeList = listOf("del", "delete", "rem", "remove")

    val moves = inputs.subList(3, inputs.size).map { token ->
        when {
            token.startsWith("p+") -> token rangedMove fAddXAtDigit(token.substring(2).toInt())
            token.startsWith("p-") -> token rangedMove fSubtractXAtDigit(token.substring(2).toInt())
            token.startsWith('+') -> token singleMove fAddX(token.substring(1).toInt())
            token.startsWith('-') -> token singleMove fMinusX(token.substring(1).toInt())
            token.startsWith('*') || token.startsWith('x', true) -> token singleMove fMulX(token.substring(1).toInt())
            token.startsWith('/') -> token singleMove fDivX(token.substring(1).toInt())
            token.startsWith("c") -> token singleMove fRemove(token.substring(1))
            token == "shift" -> token rangedMove fShiftRanged()
            token == "shift2" -> token singleMove fShift2()
            token == "flip" || token == "+/-" -> token singleMove fFlipSign()
            token == "<<" -> token singleMove fLShift()
            token == "^2" || token == "p2" -> token singleMove fSquare()
            token == "^3" || token == "p3" -> token singleMove fCube()
            token == "su" || token == "sa" || token == "s>" -> token singleMove fSortAsc()
            token == "sd" || token == "s<" -> token singleMove fSortDesc()
            token == "q" || token == "d" || token == "sum" -> token singleMove fDigitSum()
            token.startsWith('s', true) -> {
                val nums = token.substring(1).split('.')
                token singleMove fSubst(nums[0].toInt(), nums[1].toInt())
            }
            token == "i" || token == "inv" -> token singleMove fInv()
            token == "r" || token == "rev" -> token singleMove fRev()
            token == "tl" -> token singleMove fDigitSwapL()
            token == "tr" -> token singleMove fDigitSwapR()
            token == "rnd" || token == "round" -> token rangedMove fRound()
            token == "m" || token == "mir" || token == "mirror" -> token singleMove fMirror()
            token in removeList -> token rangedMove fDel()
            token.startsWith("ins") -> token rangedMove fInsert(token.substring(3))
            else -> token singleMove fAddDigits(token.toInt())
        }
    }

    return Cfg(
        target,
        start,
        max,
        moves.filterIsInstance<SingleMove>().associate { it.name to it.move },
        moves.filterIsInstance<RangedMove>().map { it.move })
}

fun operate(cfg: Cfg) {
    val maxdepth = cfg.max
    val target = cfg.target
    val start = cfg.start
    val moves = cfg.moves
    val rangedMoves = cfg.rangedMoves

    val queue: Queue<State> = LinkedList()
    queue += State(emptyList(), start)

    while (queue.isNotEmpty()) {
        val current = queue.poll()
//        println(current)
        if (current.value == Int.MIN_VALUE)
            continue
        if (current.value >= 1_000_000)
            continue
        if (current.value == target) {
            println(current.moves.joinToString(", "))
//            current.moves.forEach(::println)
            return
        }
        if (current.moves.size == maxdepth)
            continue

        moves.forEach {
            queue.offer(State(appendCopy(current.moves, it.key), it.value(current.value)))
        }

        rangedMoves.map { it(current.value) }.flatten().forEach {
            queue.offer(State(appendCopy(current.moves, it.first), it.second))
        }
    }

    println("Solution not found")
}

fun exec(input: String) {
    operate(decode(input))
}

fun String.x() {
    exec(this)
}

fun main() {


    /*
    val moves = mapOf<String, (Int) -> Int>(
//        "/2" to { it / 2 },
//        "+6" to { it + 6 },
//        "*7" to { it * 7 },
        "1" to { it * 10 + 1 },
        "2" to { it * 10 + 2 },
//        "5" to { it * 10 + 5 },
//        "10" to { it * 100 + 10 },
//        "<<" to { it / 10 + 0 },
        "s12" to { it.toString().replace('1', '2').toInt() },
        "s23" to { it.toString().replace('2', '3').toInt() },
        "s23" to { it.toString().replace('2', '3').toInt() }
    )
    */

    //Cfg(target, start, max, moves)
//    println(918)
//    println("sh: " + listOf("shift1" to 891, "shift2" to 189) )
//    println("is: " + fShiftRanged()(918))
//    println(9678)
//    println("sh: " + listOf("shift1" to 8967, "shift2" to 7896, "shift3" to 6789) )
//    println("is: " + fShiftRanged()(9678))

    val list = listOf(90, 9, 9010, 910, 109, 91, 19, 9009, 99, 9000910, 9109, 1099)
    println(list.map { String.format("%6d", it) } )
    println(list.map { fShift2()(it) }.map { String.format("%6d", it) } )
    println(listOf(9, 9, 109, 109, 91, 19, 91, 99, 99, 9109, 1099, 991 ).map { String.format("%6d", it) })

    val input = "1199, 90, 5, m, shift2, 10"
    val cfg = decode(input)
    operate(cfg)
}
