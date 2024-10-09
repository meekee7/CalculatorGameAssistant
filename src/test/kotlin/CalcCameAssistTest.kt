package calc

import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

infix fun String.shouldMake(expected: List<String>) {
    operate(decode(this)) shouldBe expected
}

class PowTest : FunSpec({
    context("pow") {
        forAll(
            row(1, 0, 1),
            row(10, 0, 1),
            row(1, 1, 1),
            row(10, 1, 10)
        ) { a, b, c -> a.pow(b) shouldBe c }
    }
})
