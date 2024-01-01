import java.util.*
import kotlin.math.abs
import kotlin.math.roundToInt

fun Int.pow(exp: Int): Int {
    if (exp == 0)
        return 1
    if (exp == 1)
        return this
    var result = this
    repeat(exp) {
        result *= this
    }
    return result
}

fun Int.countDigits(): Int = kotlin.math.ceil(kotlin.math.log10(this.toDouble())).toInt()

data class State(val doneMoves: List<String>, val value: Int, val availableMoves: List<NamedMove>)
data class Portal(val drop: Int, val inject: Int)

abstract class NamedMove(val name: String)
open class SingleMove(name: String, val move: (Int) -> Int) : NamedMove(name)
class NumberedSingleMove(
    name: String,
    val value: Int,
    val moveFunc: (Int) -> ((Int) -> Int),
    val nameCompositor: (Int) -> String
) :
    SingleMove(name, moveFunc(value))

class RangedMove(name: String, val move: (Int) -> List<Pair<String, Int>>) : NamedMove(name)
class ButtonChangeMove(name: String, val move: (Int) -> Int) : NamedMove(name)
class StoreMove : NamedMove("store")
class RestoreMove(name: String, move: (Int) -> Int) : SingleMove(name, move)

infix fun String.singleMove(move: (Int) -> Int) = SingleMove(this, move)
infix fun String.rangedMove(move: (Int) -> List<Pair<String, Int>>) = RangedMove(this, move)

infix fun List<String>.appendCopy(value: String): List<String> {
    val copy = this.toMutableList()
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
fun fSubst(from: String, to: String): (Int) -> Int = { it.toString().replace(from, to).toInt() }
fun fAddDigits(x: Int): (Int) -> Int = { (it.toString() + x.toString()).toIntOrNull() ?: Int.MIN_VALUE }
fun fSquare(): (Int) -> Int = { it * it }
fun fCube(): (Int) -> Int = { it * it * it }
fun fInv(): (Int) -> Int = { it * -1 }
fun fRev(): (Int) -> Int = { if (it >= 0) it.toString().reversed().toInt() else fRev()(abs(it)) * -1 }
fun fDigitSum(): (Int) -> Int = { DigitSum(it) * (if (it < 0) -1 else 1) }
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

fun fRemove(x: Int): (Int) -> Int = {
    it.toString().replace(x.toString(), "").toIntOrNull() ?: 0
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
fun fMirror(): (Int) -> Int = {
    val str = it.toString()
    (str + str.reversed()).toIntOrNull() ?: Int.MIN_VALUE
}

fun fShift2L(): (Int) -> Int = {
    if (it < 10)
        it
    else {
        val str = it.toString()
        val prefix = str.first()
        val suffix = str.substring(1)
        (suffix + prefix).toInt()
    }
}

fun fShift2R(): (Int) -> Int = {
    if (it < 10)
        it
    else {
        val str = it.toString()
        val prefix = str.substring(0, str.length - 1)
        val suffix = str.substring(str.length - 1)
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

fun fInv10(): (Int) -> Int = {
    it.toString()
        .map {
            when (it) {
                '0' -> '0'
                '1' -> '9'
                '2' -> '8'
                '3' -> '7'
                '4' -> '6'
                '5' -> '5'
                '6' -> '4'
                '7' -> '3'
                '8' -> '2'
                '9' -> '1'
                else -> it
            }
        }
        .joinToString("").toInt()
}

data class Cfg(
    val target: Int,
    val start: Int,
    val max: Int,
    val portal: Portal?,
    val moves: List<NamedMove>
)

fun decode(input: String): Cfg {
    val inputs = input.split(',').map { it.trim() }

    val target = inputs[0].toInt()
    val start = inputs[1].toInt()
    val max = inputs[2].toInt()
    val portal: Portal? =
        if (inputs[3].isEmpty()) null else Portal(inputs[3].first().digitToInt(), inputs[3].last().digitToInt())

    val removeList = listOf("del", "delete", "rem", "remove")

    val moves = inputs.subList(4, inputs.size).map { token ->
        when {
            token.startsWith("p+") -> token rangedMove fAddXAtDigit(token.substring(2).toInt())
            token.startsWith("p-") -> token rangedMove fSubtractXAtDigit(token.substring(2).toInt())
            token.startsWith('+') -> NumberedSingleMove(
                token,
                token.substring(1).toInt(),
                ::fAddX,
                { token.substring(0, 1) + it })

            token.startsWith('-') -> NumberedSingleMove(
                token,
                token.substring(1).toInt(),
                ::fMinusX,
                { token.substring(0, 1) + it })

            token.startsWith('*') || token.startsWith('x', true) -> NumberedSingleMove(
                token,
                token.substring(1).toInt(),
                ::fMulX, { token.substring(0, 1) + it }
            )

            token.startsWith('/') -> NumberedSingleMove(
                token,
                token.substring(1).toInt(),
                ::fDivX,
                { token.substring(0, 1) + it })

            token.startsWith("c") -> NumberedSingleMove(
                token,
                token.substring(1).toInt(),
                ::fRemove,
                { "c" + it }) //token singleMove fRemove(token.substring(1))
            token == "shift" -> token rangedMove fShiftRanged()
            token == "shift2l" || token == "shift2L" || token == "shift2<" -> token singleMove fShift2L()
            token == "shift2r" || token == "shift2R" || token == "shift2>" -> token singleMove fShift2R()
            token == "flip" || token == "+/-" -> token singleMove fFlipSign()
            token == "<<" -> token singleMove fLShift()
            token == "^2" || token == "p2" -> token singleMove fSquare()
            token == "^3" || token == "p3" -> token singleMove fCube()
            token == "su" || token == "sa" || token == "s>" -> token singleMove fSortAsc()
            token == "sd" || token == "s<" -> token singleMove fSortDesc()
            token == "q" || token == "d" || token == "sum" -> token singleMove fDigitSum()
            token == "store" -> StoreMove()
            token.startsWith('s', true) -> {
                val nums = token.substring(1).split('.')
                token singleMove fSubst(nums[0], nums[1])
            }

            token == "i" || token == "inv" -> token singleMove fInv()
            token == "r" || token == "rev" -> token singleMove fRev()
            token == "tl" -> token singleMove fDigitSwapL()
            token == "tr" -> token singleMove fDigitSwapR()
            token == "rnd" || token == "round" -> token rangedMove fRound()
            token == "m" || token == "mir" || token == "mirror" -> token singleMove fMirror()
            token == "inv10" -> token singleMove fInv10()
            token in removeList -> token rangedMove fDel()
            token.startsWith("ins") -> token rangedMove fInsert(token.substring(3))
            token.startsWith("b+") -> ButtonChangeMove(token, fAddX(token.substring(2).toInt()))
            else -> NumberedSingleMove(token, token.toInt(), ::fAddDigits, { it.toString() })
        }
    }

    return Cfg(
        target,
        start,
        max,
        portal,
        moves
    )
}

fun operate(cfg: Cfg) {
    val maxdepth = cfg.max
    val target = cfg.target
    val start = cfg.start
    val intialMoves = cfg.moves

    val queue: Queue<State> = LinkedList()
    queue += State(emptyList(), start, intialMoves)

    while (queue.isNotEmpty()) {
        val current = queue.poll()
        //println(current)
        if (current.value == Int.MIN_VALUE)
            continue
        if (current.value >= 1_000_000)
            continue
        if (current.value == target) {
            println(current.doneMoves.joinToString(", "))
//            current.moves.forEach(::println)
            return
        }

        val portalized = portalize(current.value, cfg.portal)
        if (portalized != current.value) {
            queue.offer(State(current.doneMoves, portalized, current.availableMoves))
            continue
        }
        if (current.doneMoves.size == maxdepth)
            continue

        val moves = current.availableMoves.filterIsInstance<SingleMove>()
        moves.forEach {
            queue.offer(State(current.doneMoves appendCopy it.name, it.move(current.value), current.availableMoves))
        }

        val rangedMoves = current.availableMoves.filterIsInstance<RangedMove>()
        rangedMoves.map { it.move(current.value) }.flatten().forEach {
            queue.offer(State(current.doneMoves appendCopy it.first, it.second, current.availableMoves))
        }

        val buttonChangeMoves = current.availableMoves.filterIsInstance<ButtonChangeMove>()
        buttonChangeMoves.map { btnMove ->
            btnMove to current.availableMoves.map {
                if (it is NumberedSingleMove) {
                    val newBtnNum = btnMove.move(it.value)
                    NumberedSingleMove(it.nameCompositor(newBtnNum), newBtnNum, it.moveFunc, it.nameCompositor)
                } else
                    it
            }
        }.forEach {
            queue.offer(State(current.doneMoves appendCopy it.first.name, current.value, it.second))
        }

        val storeMove = current.availableMoves.filterIsInstance<StoreMove>().firstOrNull()
        if (storeMove != null) {
            val newMoves = current.availableMoves.toMutableList()
            newMoves.removeIf { it is RestoreMove }
            newMoves.add(RestoreMove("rest${current.value}", fAddDigits(current.value)))
            queue.offer(State(current.doneMoves appendCopy storeMove.name, current.value, newMoves))
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

fun portalize(num: Int, portal: Portal?): Int {
    if (portal == null)
        return num

    val numCharDigits = num.toString().filter { it.isDigit() }.map { it.digitToInt() }.toMutableList()
    if (numCharDigits.size < portal.drop)
        return num

    val dropped = numCharDigits.removeAt(numCharDigits.size - portal.drop)
    val remainder = numCharDigits.joinToString("").toInt()

    val outExp = 10.pow(portal.inject - 1)
    val sum = remainder + dropped * outExp

    return if (num < 0)
        sum * -1
    else
        sum
}

fun main() {
    val portal = Portal(3, 1)
    val cases = listOf(
        99 to 99,
        98 to 98,
        981 to 90,
        90 to 90,
        991 to 100,
        100 to 1
    )
    cases.forEach {
        println("${it.first} IS ${portalize(it.first, portal)} OUGHT ${it.second}")
    }
    val p2 = Portal(3, 2)
    val cases2 = listOf(
        966 to 156,
        156 to 66,
        944 to 134,
        134 to 44,
        946 to 136,
        136 to 46,
        964 to 154,
        154 to 64
    )
    cases2.forEach {
        println("${it.first} IS ${portalize(it.first, p2)} OUGHT ${it.second}")
    }
    val p3 = Portal(4, 1)
    val cases3 = listOf(
        30110 to 3110,
        3110 to 113,
        3013 to 16,
        29910 to 2919,
        2919 to 921,
    )

    cases3.forEach {
        println("${it.first} IS ${portalize(it.first, p3)} OUGHT ${it.second}")
    }

    val input = "6,13,5,,b+1,p+1,s43.2"
    //val input = "36,13,5,,b+1,p+1,s43.2"
    println(input)
    //val input =  "1199, 90, 5, m, shift2, 10"
    val cfg = decode(input)
    operate(cfg)
}
