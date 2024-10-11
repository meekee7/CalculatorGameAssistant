package calc

import java.util.*
import kotlin.math.abs
import kotlin.math.roundToInt

fun Int.pow(exp: Int): Int {
    if (exp == 0)
        return 1
    var result = this
    repeat(exp - 1) {
        result *= this
    }
    return result
}

fun Int.countDigits(): Int = kotlin.math.ceil(kotlin.math.log10(this.toDouble())).toInt()

data class Fixation(val pos: Int, val value: Int) {
    fun resolve(input: Int): Int {
        val list = input.toString().filter { it.isDigit() }.map { it.digitToInt() }.toMutableList()
        if (this.pos != 1 && this.pos > list.size) {
            return this.value * 10.pow(this.pos - 1) + input
        } else {
            list[list.size - this.pos] = this.value
            val result = list.joinToString("").toInt()
            return if (input < 0) -result else result
        }
    }

    companion object {
        fun fromNumber(pos: Int, number: Int): Fixation? {
            val numStr = number.toString()
            val char = numStr[numStr.length - pos]
            if (!char.isDigit())
                return null
            val digit = char.digitToInt()
            return Fixation(pos, digit)
        }
    }
}

data class State(
    val doneMoves: List<String>,
    val value: Int,
    val availableMoves: List<NamedMove>,
    val fixation: Fixation? = null
)

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

open class RangedMove(name: String, val move: (Int) -> List<Pair<String, Int>>) : NamedMove(name)
class NumberedRangedMove(
    name: String,
    val value: Int,
    val moveFunc: (Int) -> ((Int) -> List<Pair<String, Int>>),
    val nameCompositor: (Int) -> String
) : RangedMove(name, moveFunc(value))

class ButtonChangeMove(name: String, val move: (Int) -> Int) : NamedMove(name)
class StoreMove : NamedMove("store")
class RestoreMove(name: String, move: (Int) -> Int) : SingleMove(name, move)
class FixMove : NamedMove("fix")

infix fun String.singleMove(move: (Int) -> Int) = SingleMove(this, move)
infix fun String.rangedMove(move: (Int) -> List<Pair<String, Int>>) = RangedMove(this, move)

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

fun fInsert(x: Int): (Int) -> List<Pair<String, Int>> = {
    val str = x.toString()
    val number = it.toString()
    (0..number.length).map { index ->
        "ins$str.${index + 1}" to (number.substring(0, index) + str + number.substring(index)).toInt()
    }
}

fun fReplace(x: Int): (Int) -> List<Pair<String, Int>> = {
    val number = it.toString().toCharArray()
    (number.indices).map { index ->
        val mod = number.copyOf()
        mod[index] = x.digitToChar()
        "rep$x.${index + 1}" to mod.joinToString("").toInt()
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
}

fun fSubtractXAtDigit(x: Int): (Int) -> List<Pair<String, Int>> = { number ->
    val str = number.toString()
    str.indices.map {
        val array = str.toCharArray()
        val digit = array[it]
        var intdigit = "$digit".toInt()
        if (intdigit < x) {
            intdigit += 10
        }
        val newdigit = ((intdigit - x) % 10).digitToChar()
        array[it] = newdigit
        val result = String(array)
        "p-$x.${it + 1}" to result.toInt()
    }
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

    else {
        val str = number.toString()
        str.indices.map {
            val inv = str.lastIndex - it
            val prefix = str.substring(0, inv)
            val suffix = str.substring(inv)
            "shift${it + 1}" to (suffix + prefix).toInt()
        }
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
            token.startsWith("p+") -> NumberedRangedMove(
                token,
                token.substring(2).toInt(),
                ::fAddXAtDigit,
                { "p+" + it })// token rangedMove fAddXAtDigit(token.substring(2).toInt())
            token.startsWith("p-") -> NumberedRangedMove(
                token,
                token.substring(2).toInt(),
                ::fSubtractXAtDigit,
                { "p-" + it }) // token rangedMove fSubtractXAtDigit(token.substring(2).toInt())
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
            token == "fix" || token == "lock" -> FixMove()
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
            token.startsWith("ins") -> NumberedRangedMove(
                token,
                token.substring(3).toInt(),
                ::fInsert,
                { "ins" + it })//
            token.startsWith("rep") -> NumberedRangedMove(
                token,
                token.substring(3).toInt(),
                ::fReplace,
                { "rep" + it })// // token rangedMove fInsert(token.substring(3))
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

fun operate(cfg: Cfg) : List<String> {
    val maxdepth = cfg.max
    val target = cfg.target
    val start = cfg.start
    val initialMoves = cfg.moves

    val queue: Queue<State> = LinkedList()
    queue += State(emptyList(), start, initialMoves)

    while (queue.isNotEmpty()) {
        val current = queue.poll()

        if (current.value == Int.MIN_VALUE)
            continue
        if (current.value >= 1_000_000)
            continue

        val portalized = cfg.portal.portalize(current.value)
        if (portalized != current.value && current.doneMoves.isNotEmpty()) {
            queue.offer(State(current.doneMoves, portalized, current.availableMoves))
            continue
        }

        if (current.fixation != null && !current.doneMoves.last().startsWith("fix")) {
            queue.offer(State(current.doneMoves, current.fixation.resolve(current.value), current.availableMoves, null))
            continue
        }

        if (current.value == target)
            return current.doneMoves

        if (current.doneMoves.size == maxdepth)
            continue

        val moves = current.availableMoves.filterIsInstance<SingleMove>()
        moves.forEach {
            queue.offer(State(current.doneMoves + it.name, it.move(current.value), current.availableMoves, current.fixation))
        }

        val rangedMoves = current.availableMoves.filterIsInstance<RangedMove>()
        rangedMoves.map { it.move(current.value) }.flatten().forEach {
            queue.offer(State(current.doneMoves + it.first, it.second, current.availableMoves, current.fixation))
        }

        val buttonChangeMoves = current.availableMoves.filterIsInstance<ButtonChangeMove>()
        buttonChangeMoves.map { btnMove ->
            btnMove to current.availableMoves.map {
                when (it) {
                    is NumberedSingleMove -> {
                        val newBtnNum = btnMove.move(it.value)
                        NumberedSingleMove(it.nameCompositor(newBtnNum), newBtnNum, it.moveFunc, it.nameCompositor)
                    }

                    is NumberedRangedMove -> {
                        val newBtnNum = btnMove.move(it.value)
                        NumberedRangedMove(it.nameCompositor(newBtnNum), newBtnNum, it.moveFunc, it.nameCompositor)
                    }

                    else -> it
                }
            }
        }.forEach {
            queue.offer(State(current.doneMoves + it.first.name, current.value, it.second, current.fixation))
        }

        val storeMove = current.availableMoves.filterIsInstance<StoreMove>().firstOrNull()
        if (storeMove != null) {
            val newMoves = current.availableMoves.toMutableList()
            newMoves.removeIf { it is RestoreMove }
            newMoves.add(RestoreMove("rest${current.value}", fAddDigits(current.value)))
            queue.offer(State(current.doneMoves + storeMove.name, current.value, newMoves, current.fixation))
        }

        if (current.availableMoves.filterIsInstance<FixMove>().any() && current.fixation == null) {
            current.value.toString().indices.map { it + 1 }.forEach {
                queue.offer(
                    State(
                        current.doneMoves + "fix$it",
                        current.value,
                        current.availableMoves,
                        Fixation.fromNumber(it, current.value)
                    )
                )
            }
        }
    }

    throw kotlin.IllegalStateException("Solution not found")
}

fun exec(input: String) {
    println(operate(decode(input)).joinToString(", "))
}

fun String.x() {
    exec(this)
}

fun Portal?.portalize(num: Int): Int {
    if (this == null)
        return num

    val numCharDigits = num.toString().filter { it.isDigit() }.map { it.digitToInt() }.toMutableList()
    if (numCharDigits.size < this.drop)
        return num

    val dropped = numCharDigits.removeAt(numCharDigits.size - this.drop)
    val remainder = numCharDigits.joinToString("").toInt()

    val outExp = 10.pow(this.inject - 1)
    val sum = remainder + dropped * outExp

    return if (num < 0)
        sum * -1
    else
        sum
}

fun main() {
//    val input = "9,35,4,,lock,ins7,sum"
    val input = "5,62,2,21,+2,0,inv10"
    println(input)
    val cfg = decode(input)
    println(operate(cfg).joinToString(", "))
}
