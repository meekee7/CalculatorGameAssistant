package calc

import io.kotest.core.spec.style.StringSpec


//All levels from Genius Calculator as test cases

class GeniusCalculatorGameTest : StringSpec({
    "L1" { "4,2,1,,+2" shouldMakeG listOf("+2") }
    "L2" { "2,5,1,,-3" shouldMakeG listOf("-3") }
    "L3" { "6,3,1,,x2" shouldMakeG listOf("x2") }
    "L4" { "5,10,1,,÷2" shouldMakeG listOf("÷2") }
    "L5" { "3,4,2,,+2,-3" shouldMakeG listOf("+2", "-3") }
    "L6" { "2,3,2,,+2,÷2" shouldMakeG listOf("+2", "÷2") }
    "L7" { "4,5,3,,-2,x3,÷3" shouldMakeG listOf("x3", "-2", "÷3") }
    "L8" { "4,3,2,,x3,÷2" shouldMakeG listOf("x3", "÷2") }
    "L9" { "3,8,3,,-3,x2,÷3" shouldMakeG listOf("-3", "x2", "÷3") }
    "L10" { "1,10,1,,%3" shouldMakeG listOf("%3") }

    "L11" { "1,5,3,,+4,-2,%2" shouldMakeG listOf("%2") }
    "L12" { "10,3,3,,x4,+3,-5" shouldMakeG listOf("x4", "+3", "-5") }
    "L13" { "11,1,3,,+3,-5,x4" shouldMakeG listOf("+3", "x4", "-5") }
    "L14" { "6,2,3,,x11,%10,x3" shouldMakeG listOf("x3") }
    "L15" { "10,3,3,,x5,+5,%10" shouldMakeG listOf("x5", "%10", "+5") }
    "L16" { "10,3,3,,x3,%4,x10" shouldMakeG listOf("x3", "%4", "x10") }
    "L17" { "0,5,4,,-4,%4,+5,-2" shouldMakeG listOf("+5", "%4", "-2") }
    "L18" { "6,4,4,,-3,x2,x4,%10" shouldMakeG listOf("x4", "%10") }
    "L19" { "16,5,4,,+2,-3,x3" shouldMakeG listOf("x3", "+2", "+2", "-3") }
    "L20" { "222,111,1,,↑1" shouldMakeG listOf("↑1") }

    "L21" { "23,3,2,,x4,↑1" shouldMakeG listOf("x4", "↑1") }
    "L22" { "38,10,3,,-1,↑1,x3" shouldMakeG listOf("-1", "x3", "↑1") }
    "L23" { "10,5,4,,÷2,↑9,-3,+3" shouldMakeG listOf("÷2", "÷2", "↑9") }
    "L24" { "11,2,3,,%3,↑10,x5" shouldMakeG listOf("x5", "%3", "↑10") }
    "L25" { "3,11,5,,%11,+1,↑1" shouldMakeG listOf("%11", "+1", "+1", "+1") }
    "L26" { "6,3,4,,↑2,+5,%15,x3" shouldMakeG listOf("↑2", "↑2", "x3", "%15") }
    "L27" { "45,5,4,,x3,-5,+4,↑3" shouldMakeG listOf("x3", "x3") }
    "L28" { "26,6,6,,+1,x3,÷2,↑1" shouldMakeG listOf("+1", "+1", "x3", "+1", "+1") }
    "L29" { "9,123,3,,÷5,%10,↑2" shouldMakeG listOf("÷5", "↑2", "÷5") }
    "L30" { "234,345,1,,↓1" shouldMakeG listOf("↓1") }

    "L31" { "36,5,3,,x5,↑2,↓1" shouldMakeG listOf("x5", "↑2", "↓1") }
    "L32" { "23,2,6,,+3,-1,x2,↑2,↓1" shouldMakeG listOf("+3", "x2", "x2", "+3") }
    "L33" { "30,22,5,,%5,-8,↑2,x4" shouldMakeG listOf("%5", "↑2", "x4", "↑2", "-8") }
    "L34" { "6,10,4,,÷2,%2,↑11" shouldMakeG listOf("÷2", "÷2", "↑11", "÷2") }
    "L35" { "31,543,4,,%10,x10,↓1,↑1" shouldMakeG listOf("%10", "x10", "↓1", "↑1") }
    "L36" { "12,123,4,,↑2,↓1,↑3,↓5" shouldMakeG listOf("↓1") }
    "L37" { "14,5,4,,x3,+2,-1,↓2" shouldMakeG listOf("x3", "-1") }
    "L38" { "16,10,4,,÷2,x3,↓1,+4" shouldMakeG listOf("÷2", "↓1", "x3", "+4") }
    "L39" { "310,23,4,,↑2,÷5,x2" shouldMakeG listOf("↑2", "÷5", "x2", "↑2") }
    "L40" { "34,345,1,,<<" shouldMakeG listOf("<<") }

    "L41" { "61,10,4,,↑5,x2,-5,<<" shouldMakeG listOf("x2", "-5", "↑5", "<<") }
    "L42" { "34,234,3,,↑2,↓1,<<" shouldMakeG listOf("↑2", "↓1", "<<") }
    "L43" { "42,3,5,,-2,x2,↑1" shouldMakeG listOf("x2", "x2", "-2", "↑1", "x2") }
    "L44" { "32,3,5,,-1,↑1,x3" shouldMakeG listOf("x3", "↑1", "↑1", "↑1") }
    "L45" { "6,55,4,,x3,÷5,↑1,<<" shouldMakeG listOf("↑1", "<<") }
    "L46" { "51,20,5,,-1,%10,↑3,x3,<<" shouldMakeG listOf("↑3", "-1", "-1") }
    "L47" { "23,11,4,,↑2,↓1,%8,x4" shouldMakeG listOf("%8", "x4", "↑2", "↓1") }
    "L48" { "4,233,4,,↑3,↓1,<<" shouldMakeG listOf("↑3", "↓1", "<<", "<<") }
    "L49" { "3,45,3,,<<,↑1,↓2" shouldMakeG listOf("<<", "↑1", "↓2") }
    "L50" { "34,234,1,,>>" shouldMakeG listOf(">>") }

    "L51" { "4,345,2,,<<,>>" shouldMakeG listOf("<<", ">>") }
    "L52" { "25,12,4,,>>,x5,x2,↑1" shouldMakeG listOf(">>", "x2", "↑1", "x5") }
    "L53" { "61,4,5,,x8,+3,÷10,-1,↑2" shouldMakeG listOf("↑2", "x8", "↑2", "÷10") }
    "L54" { "4,123,4,,↑2,↓1,>>" shouldMakeG listOf("↓1", "↑2", ">>") }
    "L55" { "3,5,6,,↑1,+2,>>" shouldMakeG listOf(">>", "+2", "↑1") }
    "L56" { "6,7,4,,x2,+1,÷5,↑1" shouldMakeG listOf("x2", "x2", "÷5", "+1") }
    "L57" { "4,13,4,,↓1,>>,↑1" shouldMakeG listOf(">>", "↑1") }
    "L58" { "16,222,5,,x4,÷11,+1,<<" shouldMakeG listOf("÷11", "÷11", "x4", "x4") }
    "L59" { "3,1,5,,x10,>>,↑11,+3,%5" shouldMakeG listOf(">>", "+3") }
    "L60" { "112,12,1,,+>1" shouldMakeG listOf("+>1") }

    "L61" { "13,234,3,,>>,<<,+>1" shouldMakeG listOf(">>", "<<", "+>1") }
    "L62" { "217,45,4,,+>2,÷2,↑1,↓1" shouldMakeG listOf("↓1", "÷2", "+>2") }
    "L63" { "7,20,3,,+>1,÷2,÷5" shouldMakeG listOf("÷5", "+>1", "÷2") }
    "L64" { "12,33,3,,↓1,%10,+>1" shouldMakeG listOf("↓1", "%10", "+>1") }
    "L65" { "21,12,5,,↓1,+>3,<<,↑2" shouldMakeG listOf("↓1", "↑2", "↓1", "+>3", "↓1") }
    "L66" { "121,34,5,,↑1,+>1,÷9,x2" shouldMakeG listOf("↑1", "÷9", "x2", "↑1", "+>1") }
    "L67" { "20,1,4,,x2,+>1,÷11" shouldMakeG listOf("÷11", "+>1", "x2") }
    "L68" { "11,334,4,,<<,÷3,+>3" shouldMakeG listOf("<<", "÷3") }
    "L69" { "22,4,4,,x2,+>1,x3,<<" shouldMakeG listOf("+>1", "+>1", "x2", "<<") }
    "L70" { "221,22,1,,<+1" shouldMakeG listOf("<+1") }

    "L71" { "121,2,2,,+>1,<+1" shouldMakeG listOf("+>1", "<+1") }
    "L72" { "13,333,3,,<<,+>1,>>" shouldMakeG listOf("<<", "<<", "+>1") }
    "L73" { "10,2,4,,<+1,↑1,+>1,↓2" shouldMakeG listOf("↓2", "+>1") }
    "L74" { "333,1,4,,↑1,+>1" shouldMakeG listOf("+>1", "+>1", "↑1", "↑1") }
    "L75" { "13,22,3,,+>1,<<,↑1" shouldMakeG listOf("<<", "↑1", "+>1") }
    "L76" { "30,45,3,,+>1,+1,÷5" shouldMakeG listOf("+>1", "÷5", "+1") }
    "L77" { "45,234,3,,>>,<+5,↓1" shouldMakeG listOf(">>", ">>", "<+5") }
    "L78" { "3,23,4,,<<,↑1,>>,+>1" shouldMakeG listOf(">>") }
    "L79" { "11,56,4,,<+1,x2,>>,÷11" shouldMakeG listOf("<+1", "<+1", ">>", ">>") }
    "L80" { "333,222,1,,2=>3" shouldMakeG listOf("2=>3") }

    "L81" { "545,34,4,,3=>5,↑1,<+6,↓1" shouldMakeG listOf("3=>5", "↑1", "<+6", "↓1") }
    "L82" { "1000,11,5,,↑1,+>1,3=>0" shouldMakeG listOf("+>1", "↑1", "↑1", "+>1", "3=>0") }
    "L83" { "33,23,4,,2=>3,>>,<+4,↓1" shouldMakeG listOf("2=>3") }
    "L84" { "222,1,3,,+>1,<+2,1=>2" shouldMakeG listOf("+>1", "+>1", "1=>2") }
    "L85" { "999,3,4,,x3,<+1,1=>9,+>1" shouldMakeG listOf("x3", "<+1", "<+1", "1=>9") }
    "L86" { "202,9,4,,-1,1=>2,↑2,<+1" shouldMakeG listOf("-1", "↑2", "<+1", "1=>2") }
    "L87" { "222,55,5,,÷5,3=>2,↑1,+>3" shouldMakeG listOf("÷5", "↑1", "+>3", "3=>2") }
    "L88" { "33,222,4,,>>,↑1,2=>1" shouldMakeG listOf(">>", "↑1") }
    "L89" { "444,3,5,,1=>2,+>1,x2" shouldMakeG listOf("x2", "x2", "+>1", "1=>2", "x2") }
    "L90" { "8,2,1,,^3" shouldMakeG listOf("^3") }

    "L91" { "511,2,4,,x2,-1,^3" shouldMakeG listOf("^3", "^3", "-1") }
    "L92" { "12,3,4,,^3,x2,↓1,>>" shouldMakeG listOf("x2", "x2") }
    "L93" { "131,2,4,,↓1,^2,+>2,<+2" shouldMakeG listOf("^2", "+>2", "<+2", "↓1") }
    "L94" { "100,121,4,,÷11,1=>2,^2,↓1" shouldMakeG listOf("↓1", "^2") }
    "L95" { "22,3,5,,1=>2,↓1,+>2,<+4" shouldMakeG listOf("↓1", "+>2") }
    "L96" { "28,5,5,,<<,>>,^3" shouldMakeG listOf("^3", "<<", "^3", ">>", ">>") }
    "L97" { "24,232,5,,x2,2=>4,>>,↓1" shouldMakeG listOf("2=>4", ">>", "↓1", "↓1", "x2") }
    "L98" { "41,2,6,,+>1,^2,÷3" shouldMakeG listOf("+>1", "+>1", "+>1", "÷3", "÷3", "÷3") }
    "L99" { "36,2,5,,÷2,↑1,+>1,<+2" shouldMakeG listOf("↑1", "↑1", "+>1", "↑1", "↑1") }
    "L100" { "12,-12,1,,+<=>-" shouldMakeG listOf("+<=>-") }

    "L101" { "-9,2,5,,+3,x2,-1,+<=>-" shouldMakeG listOf("+3", "+3", "+<=>-", "-1") }
    "L102" { "-111,12,4,,<+1,+<=>-,÷11" shouldMakeG listOf("<+1", "+<=>-", "÷11", "<+1") }
    "L103" { "5,4,3,,+>1,^2,↓1,x5" shouldMakeG listOf("^2", "↓1") }
    "L104" { "8,223,3,,<<,÷11,^3" shouldMakeG listOf("<<", "<<", "^3") }
})