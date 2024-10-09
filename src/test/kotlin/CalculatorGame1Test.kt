package calc

import io.kotest.core.spec.style.StringSpec


//All levels from Calculator game 1 as test cases

class CalculatorGame1Test : StringSpec({
    "L1" { "2,0,2,,+1" shouldMake listOf("+1", "+1") }
    "L2" { "8,0,3,,+2,+3" shouldMake listOf("+2", "+3", "+3") }
    "L3" { "12,0,3,,x4,+1,+2" shouldMake listOf("+1", "+2", "x4") }
    "L4" { "7,1,3,,+4,-2" shouldMake listOf("+4", "+4", "-2") }
    "L5" { "20,0,3,,x4,+4" shouldMake listOf("+4", "x4", "+4") }
    "L6" { "40,0,4,,+2,x4" shouldMake listOf("+2", "x4", "+2", "x4") }
    "L7" { "10,100,4,,+3,/5" shouldMake listOf("/5", "/5", "+3", "+3") }
    "L8" { "4,4321,3,,<<" shouldMake listOf("<<", "<<", "<<") }
    "L9" { "4,0,3,,<<,+8,x5" shouldMake listOf("+8", "x5", "<<") }
    "L10" {"9,50,4,,<<,/5,x3" shouldMake listOf("<<", "/5", "x3", "x3") }

    "L11" { "100,99,3,,<<,-8,x11" shouldMake listOf("-8", "x11", "<<") }
    "L12" { "404,0,5,,+8,x10,/2" shouldMake listOf("+8", "x10", "x10", "+8", "/2") }
    "L13" { "23,171,4,,x2,-9,<<" shouldMake listOf("-9", "x2", "<<", "-9") }
    "L14" { "21,0,5,,+5,x3,x5,<<" shouldMake listOf("+5", "x3", "x5", "<<", "x3") }
    "L15" { "50,10,3,,x3,x2,-5" shouldMake listOf("x3", "-5", "x2") }
    "L16" { "2,0,5,,+4,x9,<<" shouldMake listOf("+4", "x9", "<<", "x9", "<<") }
    "L17" { "11,0,2,,1" shouldMake listOf("1", "1") }
    "L18" { "101,0,3,,1,0" shouldMake listOf("1", "0", "1") }
    "L19" { "44,0,3,,2,x2" shouldMake listOf("2", "2", "x2") }
    "L20" { "35,0,2,,+3,5" shouldMake listOf("+3", "5") }

    "L21" { "56,0,3,,1,+5" shouldMake listOf("+5", "1", "+5") }
    "L22" { "9,0,4,,+2,/3,1" shouldMake listOf("+2", "1", "/3", "+2") }
    "L23" { "10,15,4,,0,+2,/5" shouldMake listOf("/5", "+2", "0", "/5") }
    "L24" { "210,0,5,,-5,+5,5,2" shouldMake listOf("2", "5", "-5", "5", "+5") }
    "L25" { "2020,40,4,,0,+4,/2" shouldMake listOf("0", "+4", "0", "/2") }
    "L26" { "11,0,4,,12,<<" shouldMake listOf("12", "<<", "12", "<<") }
    "L27" { "102,0,4,,10,+1,<<" shouldMake listOf("10", "10", "<<", "+1") }
    "L28" { "222,0,4,,1,s1.2" shouldMake listOf("1", "1", "1", "s1.2") }
    "L29" { "93,0,4,,+6,x7,s6.9" shouldMake listOf("+6", "s6.9", "x7", "s6.9") }
    "L30" { "2321,0,6,,1,2,s1.2,s2.3" shouldMake listOf("1", "2", "1", "s2.3", "s1.2", "1") }

    "L31" { "24,0,5,,+9,x2,s8.4" shouldMake listOf("+9", "+9", "s8.4", "x2", "s8.4") }
    "L32" { "29,11,5,,/2,+3,s1.2,s2.9" shouldMake listOf("+3", "s1.2", "/2", "s2.9", "s1.2") }
    "L33" { "20,36,5,,+3,/3,s1.2" shouldMake listOf("+3", "+3", "/3", "+3", "+3") }
    "L34" { "15,2,4,,/3,1,x2,s4.5" shouldMake listOf("1", "/3", "x2", "s4.5") }
    "L35" { "414,1234,4,,s23.41,s24.14,s12.24,s14.2" shouldMake listOf("s12.24", "s24.14", "s14.2", "s23.41") }
    "L36" { "-85,0,4,,+6,5,-7" shouldMake listOf("+6", "-7", "-7", "5") }
    "L37" { "9,0,3,,-1,-2,^2" shouldMake listOf("-1", "-2", "^2") }
    "L38" { "-120,0,4,,x5,-6,4" shouldMake listOf("4", "-6", "4", "x5") }
    "L39" { "144,0,3,,-1,2,^2" shouldMake listOf("-1", "2", "^2") }
    "L40" { "5,-5,1,,flip" shouldMake listOf("flip") }

    "L41" { "-6,0,3,,+4,+2,flip" shouldMake listOf("+4", "+2", "flip") }
    "L42" { "-13,0,4,,+3,-7,flip" shouldMake listOf("+3", "+3", "flip", "-7") }
    "L43" { "60,0,4,,+5,-10,x4,flip" shouldMake listOf("+5", "+5", "+5", "x4") }
    "L44" { "52,44,5,,+9,/2,x4,flip" shouldMake listOf("/2", "flip", "+9", "x4", "flip") }
    "L45" { "10,9,5,,+5,x5,flip" shouldMake listOf("flip", "+5", "+5", "x5", "+5") }
    "L46" { "12,14,5,,6,+5,/8,flip" shouldMake listOf("flip", "+5", "6", "/8", "flip") }
    "L47" { "13,55,4,,+9,flip,<<" shouldMake listOf("flip", "<<", "+9", "+9") }
    "L48" { "245,0,5,,-3,5,x4,flip" shouldMake listOf("-3", "-3", "x4", "5", "flip") }
    "L49" { "12,39,4,,x-3,/3,+9,flip" shouldMake listOf("/3", "flip", "+9", "x-3") }
    "L50" { "126,111,6,,x3,-9,flip,<<" shouldMake listOf("x3", "flip", "<<", "-9", "x3", "flip") }

    "L51" { "3,34,5,,-5,+8,/7,flip" shouldMake listOf("-5", "flip", "+8", "/7", "flip") }
    "L52" { "4,25,5,,-4,x-4,/3,/8,flip" shouldMake listOf("-4", "/3", "-4", "-4", "x-4") }
    "L53" { "21,12,1,,rev" shouldMake listOf("rev") }
    "L54" { "51,0,3,,+6,+9,rev" shouldMake listOf("+6", "+9", "rev") }
    "L55" { "101,100,3,,1,+9,rev" shouldMake listOf("1", "+9", "rev") }
    "L56" { "100,1101,4,,-1,rev" shouldMake listOf("rev", "-1", "rev", "-1") }
    "L57" { "58,0,4,,+4,x4,-3,rev" shouldMake listOf("+4", "x4", "rev", "-3") }
    "L58" { "4,6,3,,1,/4,rev" shouldMake listOf("1", "rev", "/4") }
    "L59" { "21,15,3,,+9,x5,rev" shouldMake listOf("+9", "x5", "rev") }
    "L60" { "13,100,5,,/2,rev" shouldMake listOf("/2", "/2", "rev", "/2", "/2") }

    "L61" { "11011,10,4,,1,rev" shouldMake listOf("1", "1", "rev", "1") }
    "L62" { "102,0,4,,10,x4,+5,rev" shouldMake listOf("+5", "x4", "10", "rev") }
    "L63" { "7,0,4,,2,+1,/3,rev" shouldMake listOf("+1", "2", "rev", "/3") }
    "L64" { "4,0,4,,5,x4,x2,rev" shouldMake listOf("5", "x4", "x2", "rev") }
    "L65" { "212,121,3,,2,-1,rev" shouldMake listOf("-1", "rev", "2") }
    "L66" { "9,8,5,,x3,1,/5,rev" shouldMake listOf("1", "rev", "x3", "rev", "/5") }
    "L67" { "13,0,5,,+7,+8,+9,rev" shouldMake listOf("+7", "+7", "+8", "+9", "rev") }
    "L68" { "123,0,6,,+3,1,-2,rev" shouldMake listOf("+3", "1", "+3", "-2", "1", "rev") }
    "L69" { "424,0,5,,6,+8,rev" shouldMake listOf("6", "+8", "rev", "6", "+8") }
    "L70" { "81,7,5,,-9,x3,+4,flip,rev" shouldMake listOf("-9", "x3", "x3", "flip", "rev") }

    "L71" { "-43,0,5,,-5,+7,-9,rev" shouldMake listOf("-5", "-9", "rev", "+7", "-9") }
    "L72" { "28,0,7,,+6,-3,rev,<<" shouldMake listOf("+6", "+6", "<<", "+6", "+6", "rev", "-3") }
    "L73" { "136,0,5,,1,+2,x3,rev" shouldMake listOf("+2", "1", "x3", "1", "rev") }
    "L74" { "-1,0,4,,+5,rev,flip" shouldMake listOf("+5", "+5", "rev", "flip") }
    "L75" { "-25,0,5,,+4,x3,rev,flip" shouldMake listOf("+4", "x3", "rev", "+4", "flip") }
    "L76" { "-5,0,5,,+7,x3,rev,flip" shouldMake listOf("+7", "x3", "rev", "flip", "+7") }
    "L77" { "41,88,4,,/4,-4,rev" shouldMake listOf("/4", "-4", "-4", "rev") }
    "L78" { "101,100,5,,0,x2,rev,s2.10,s0.1" shouldMake listOf("x2", "rev", "0", "s0.1", "s2.10") }
    "L79" { "424,0,7,,/2,5,s5.4,rev" shouldMake listOf("5", "s5.4", "/2", "5", "rev", "5", "s5.4") }
    "L80" { "100,99,5,,9,/9,rev,s1.0" shouldMake listOf("/9", "9", "rev", "s1.0", "/9") }

    "L81" { "30,8,5,,2,-4,s2.3,rev" shouldMake listOf("2", "s2.3", "rev", "-4", "-4") }
    "L82" { "222,101,5,,-1,rev,s0.2" shouldMake listOf("-1", "s0.2", "rev", "-1", "s0.2") }
    "L83" { "500,36,5,,x4,/3,s1.5,rev" shouldMake listOf("/3", "s1.5", "rev", "x4", "s1.5") }
    "L84" { "196,0,8,,1,+12,x13,rev,<<" shouldMake listOf("1", "+12", "x13", "1", "rev", "<<") }
    "L85" { "101,50,5,,s1.10,+50,rev,s5.1" shouldMake listOf("+50", "+50", "rev", "+50") }
    "L86" { "2048,1,6,,2,x4,x10,rev" shouldMake listOf("2", "x4", "rev", "x10", "2", "rev") }
    "L87" { "123,12,5,,12,+1,s12.2,rev" shouldMake listOf("12", "+1", "rev", "s12.2", "rev") }
    "L88" { "55,86,6,,+2,+14,rev,s0.5" shouldMake listOf("+14", "rev", "+14", "rev", "+2", "+2") }
    "L89" { "3,0,4,,1,sum" shouldMake listOf("1", "1", "1", "sum") }
    "L90" { "4,1231,3,,sum,s3.1,s2.3" shouldMake listOf("s2.3", "s3.1", "sum") }

    "L91" { "45,0,5,,x9,4,x3,s3.5,sum" shouldMake listOf("4", "x3", "sum", "s3.5", "x9") }
    "L92" { "28,424,5,,x4,s4.6,sum" shouldMake listOf("x4", "x4", "sum", "sum", "x4") }
    "L93" { "8,3,4,,3,+33,sum,s3.1" shouldMake listOf("3", "s3.1", "+33", "sum") }
    "L94" { "44,24,4,,/2,4,s1.2,sum" shouldMake listOf("/2", "s1.2", "sum", "4") }
    "L95" { "143,142,4,,x9,+9,s44.43,sum" shouldMake listOf("sum", "+9", "x9", "s44.43") }
    "L96" { "1,24,5,,/3,x4,s5.10,sum" shouldMake listOf("/3", "x4", "sum", "s5.10", "sum") }
    "L97" { "100,4,5,,3,x3,+1,sum" shouldMake listOf("x3", "sum", "3", "x3", "+1") }
    "L98" { "8,93,5,,+4,x3,sum" shouldMake listOf("x3", "+4", "+4", "sum", "sum") }
    "L99" { "16,5,5,,x5,/2,sum,s5.2" shouldMake listOf("x5", "sum", "x5", "s5.2", "/2") }
    "L100" { "64,128,4,,x4,/4,sum,s5.16" shouldMake listOf("/4", "sum", "s5.16", "x4") }

    "L101" { "121,59,6,,1,x5,s15.51,sum" shouldMake listOf("1", "sum", "x5", "sum", "1") }
    "L102" { "5,18,6,,x2,/3,s12.21,sum" shouldMake listOf("x2", "/3", "s12.21", "x2", "/3", "sum") }
    "L103" { "30,9,4,,-5,x-6,flip,sum" shouldMake listOf("flip", "-5", "sum", "x-6") }
    "L104" { "-17,105,5,,-5,/5,x4,flip,sum" shouldMake listOf("-5", "x4", "-5", "flip", "sum") }
    "L105" { "11,36,6,,-6,/3,flip,sum" shouldMake listOf("-6", "/3", "sum", "-6", "-6", "flip") }
    "L106" { "64,3,5,,+3,sum,^3,s0.1" shouldMake listOf("^3", "+3", "s0.1", "sum", "^3") }
    "L107" { "11,2,5,,x2,10,sum,^3,s10.1" shouldMake listOf("x2", "^3", "x2", "sum") }
    "L108" { "2311,1123,2,,shift2<" shouldMake listOf("shift2<", "shift2<") }
    "L109" { "3254,5432,2,,shift2>" shouldMake listOf("shift2>", "shift2>") }
    "L110" { "121,101,3,,+2,shift2>,shift2<" shouldMake listOf("shift2>", "+2", "shift2<") }

    "L111" { "1999,98,4,,1,9,s89.99,shift2>" shouldMake listOf("1", "shift2>", "9", "s89.99") }
    "L112" { "129,70,4,,x3,9,shift2>" shouldMake listOf("x3", "shift2>", "shift2>", "9") }
    "L113" { "210,120,5,,+1,shift2<,flip" shouldMake listOf("+1", "shift2<", "flip", "+1", "flip") }
    "L114" { "210,1001,5,,+2,shift2>,s12.0" shouldMake listOf("shift2>", "+2", "shift2>", "+2", "s12.0") }
    "L115" { "501,100,3,,+5,0,shift2<" shouldMake listOf("+5", "0", "shift2<") }
    "L116" { "3,212,4,,+11,s3.1,sum,shift2<" shouldMake listOf("shift2<", "+11", "s3.1", "sum") }
    "L117" { "121,356,4,,-2,/3,shift2>" shouldMake listOf("shift2>", "-2", "/3", "shift2>") }
    "L118" { "13,2152,6,,s25.12,s21.3,s12.5,shift2>,rev" shouldMake listOf("rev", "s25.12", "shift2>", "s12.5", "s25.12", "s21.3") }
    "L119" { "520,1025,5,,shift2>,s50.0,s25.525,s51.5" shouldMake listOf("shift2>", "shift2>", "s25.525", "s51.5", "s50.0") }
    "L120" { "2332,23,1,,m" shouldMake listOf("m") }

    "L121" { "1221,0,3,,1,2,m" shouldMake listOf("1", "2", "m") }
    "L122" { "19,91,6,,+5,m,sum" shouldMake listOf("+5", "+5", "+5", "m", "+5", "sum") }
    "L123" { "116,22,4,,-3,6,m,sum" shouldMake listOf("sum", "-3", "m", "6") }
    "L124" { "20,125,7,,s6.2,0,m,sum" shouldMake listOf("m", "sum", "s6.2", "m", "sum", "s6.2", "0") }
    "L125" { "3,22,4,,sum,/2,m,<<" shouldMake listOf("/2", "m", "<<", "sum") }
    "L126" { "1111,0,5,,+2,x6,m,s21.11" shouldMake listOf("+2", "x6", "m", "s21.11", "s21.11") }
    "L127" { "2020,-1,8,,x3,+8,+2,rev,m" shouldMake listOf("+8", "x3", "rev", "+8", "m", "+8", "+8", "+2") }
    "L128" { "112,13,6,,s99.60,/3,x3,m,shift2>" shouldMake listOf("x3", "m", "s99.60", "/3", "shift2>", "shift2>") }
    "L129" { "18,140,6,,-3,+9,/12,m,<<" shouldMake listOf("<<", "<<", "<<", "+9", "+9") }
    "L130" { "33,17,4,,x2,-4,m,shift2<" shouldMake listOf("x2", "-4", "m", "shift2<") }

    "L131" { "20,125,8,,m,sum" shouldMake listOf("m", "sum", "m", "sum", "sum", "m", "m", "sum") }
    "L132" { "15,10,3,,+2,b+1" shouldMake listOf("+2", "b+1", "+3") }
    "L133" { "14,0,4,,1,+2,b+1" shouldMake listOf("1", "1", "b+1", "+3") }
    "L134" { "34,0,3,,2,3,b+1" shouldMake listOf("3", "b+1", "4") }
    "L135" { "101,0,5,,2,+5,b+2" shouldMake listOf("2", "b+2", "+7", "4", "+7") }
    "L136" { "28,0,5,,1,+2,b+3" shouldMake listOf("+2", "1", "+2", "b+3", "+5") }
    "L137" { "42,0,5,,-2,+5,x2,b+1" shouldMake listOf("+5", "b+1", "x3", "x3", "-3") }
    "L138" { "25,0,5,,+2,x3,-3,b+2" shouldMake listOf("+2", "x3", "b+2", "x5", "-5") }
    "L139" { "41,5,4,,+4,+8,x3,b+2" shouldMake listOf("b+2", "x5", "+6", "+10") }
    "L140" { "31,33,5,,x4,+2,+3,b+1,sum" shouldMake listOf("sum", "x4", "+2", "+2", "+3") }

    "L141" { "268,25,5,,+8,x2,x5,b+1" shouldMake listOf("x2", "x5", "b+1", "+9", "+9") }
    "L142" { "1111,1,4,,store" shouldMake listOf("store", "rest1", "rest1", "rest1") }
    "L143" { "121,0,5,,+1,store" shouldMake listOf("+1", "store", "rest1", "+1", "rest1") }
    "L144" { "122,12,5,,store,rev,<<" shouldMake listOf("rev", "store", "rev", "rest21", "<<") }
    "L145" { "17,10,6,,+2,/3,rev,store" shouldMake listOf("rev", "store", "+2", "+2", "rest1", "/3") }
    "L146" { "1234,23,5,,x2,-5,store,shift2<" shouldMake listOf("store", "x2", "-5", "rest23", "shift2<") }
    "L147" { "1025,125,7,,x2,store,<<" shouldMake listOf("x2", "<<", "store", "x2", "x2", "<<", "rest25") }
    "L148" { "115,23,6,,-8,store,flip" shouldMake listOf("-8", "store", "-8", "-8", "flip", "rest15") }
    "L149" { "16,15,5,,store,s11.33,rev,sum" shouldMake listOf("store", "rev", "rest15", "s11.33", "sum") }
    "L150" { "61,0,8,,5,<<,sum,store" shouldMake listOf("5", "5", "5", "sum", "store", "sum", "rest15", "<<") }

    "L151" { "101,0,6,,x6,5,shift2>,store,s3.1" shouldMake listOf("5", "x6", "s3.1", "store", "rest10", "shift2>") }
    "L152" { "12525,125,6,,1,/5,rev,store" shouldMake listOf("/5", "rev", "store", "rest52", "1", "rev") }
    "L153" { "17,70,7,,s8.1,/2,0,store,sum" shouldMake listOf("/2", "0", "/2", "store", "sum", "rest175", "sum") }
    "L154" { "101,12,5,,s21.0,s12.1,store,m" shouldMake listOf("store", "m", "s21.0", "rest12", "s12.1") }
    "L155" { "3001,9,9,,s39.93,/3,store,s31.00" shouldMake listOf("store", "/3", "rest9", "s39.93", "store", "rest93", "s39.93", "/3", "s31.00") }
    "L156" { "99,0,3,,1,inv10" shouldMake listOf("1", "1", "inv10") }
    "L157" { "2,1,3,,-1,inv10" shouldMake listOf("inv10", "-1", "inv10") }
    "L158" { "15,14,3,,+5,x5,inv10" shouldMake listOf("+5", "x5", "inv10") }
    "L159" { "12,21,3,,-7,x5,inv10" shouldMake listOf("x5", "-7", "inv10") }
    "L160" { "13,67,4,,+3,rev,inv10" shouldMake listOf("+3", "rev", "+3", "+3") }

    "L161" { "88,23,5,,-4,-2,rev,inv10" shouldMake listOf("-2", "rev", "-2", "inv10", "-2") }
    "L162" { "105,5,5,,x3,/9,store,inv10" shouldMake listOf("store", "rest5", "x3", "inv10", "/9") }
    "L163" { "23,24,4,,+6,x3,rev,inv10" shouldMake listOf("x3", "+6", "rev", "inv10") }
    "L164" { "17,7,4,,+3,x3,x4,inv10" shouldMake listOf("+3", "inv10", "+3", "inv10") }
    "L165" { "21,35,5,,x9,/5,s13.10,inv10" shouldMake listOf("inv10", "x9", "/5", "s13.10", "/5") }
    "L166" { "18,9,5,,x3,sum,inv10" shouldMake listOf("x3", "x3", "x3", "x3", "sum") }
    "L167" { "101,12,5,,+4,inv10,sum" shouldMake listOf("+4", "inv10", "sum", "inv10", "+4") }
    "L168" { "99,26,6,,2,sum,inv10" shouldMake listOf("2", "sum", "inv10", "2", "sum", "inv10") }
    "L169" { "13,15,7,,sum,inv10,m" shouldMake listOf("sum", "inv10", "m", "m", "sum", "inv10", "sum") }
    "L170" { "99,78,6,,s1.6,s6.11,/6,inv10,rev" shouldMake listOf("/6", "s1.6", "rev", "/6", "s6.11", "inv10") }

    "L171" { "9,34,4,,x6,inv10,<<" shouldMake listOf("<<", "x6", "inv10", "<<") }
    "L172" { "872,0,8,,8,s88.34,inv10,<<" shouldMake listOf("8", "inv10", "8", "8", "s88.34", "<<", "8", "inv10") }
    "L173" { "33,5,5,,x7,+8,-9,x2" shouldMake listOf("+8", "+8", "x2", "-9") }
    "L174" { "23,12,7,,x5,sum,store,inv10" shouldMake listOf("store", "inv10", "rest12", "rest12", "sum") }
    "L175" { "1991,1,6,,store,inv10" shouldMake listOf("store", "inv10", "rest1", "rest1", "inv10", "rest1") }
    "L176" { "26,12,5,,<<,sum,store,inv10" shouldMake listOf("inv10", "store", "<<", "rest98", "sum") }
    "L177" { "48,51,6,,+6,x3,inv10,rev,s4.6"  shouldMake listOf("+6", "+6", "rev", "+6", "+6") }
    "L178" { "1,0,6,,+5,x3,/6,inv10,rev" shouldMake listOf("+5", "+5", "rev") }
    "L179" { "777,369,5,,s93.63,s63.33,s36.93,s39.33,inv10" shouldMake listOf("s36.93", "s93.63", "s63.33", "s39.33", "inv10") }
    "L180" { "10,99,3,31,1,-1" shouldMake listOf("1", "1", "-1") }

    "L181" { "64,9,2,32,4,6" shouldMake listOf("6", "4") }
    "L182" { "35,50,3,32,+5,x3,x5" shouldMake listOf("x3", "x5", "+5") }
    "L183" { "131,306,4,41,3,+1,x2" shouldMake listOf("x2", "3", "+1", "+1") }
    "L184" { "123,321,5,41,/2,1,3,0" shouldMake listOf("1", "0", "3", "/2", "1") }
    "L185" { "150,525,5,41,+1,6,7,/2" shouldMake listOf("7", "6", "/2", "7") }
    "L186" { "212,301,5,41,10,-2,3" shouldMake listOf("10", "10", "10", "-2") }
    "L187" { "13,99,4,42,sum,m,inv10" shouldMake listOf("sum", "inv10", "m", "sum") }
    "L188" { "822,25,6,42,m,5,store,<<" shouldMake listOf("<<", "store", "5", "m", "5", "rest2") }
    "L189" { "516,45,4,42,+10,m,rev" shouldMake listOf("+10", "m", "+10", "rev") }
    "L190" { "212,238,4,,s28.21,-5,inv10,shift2>" shouldMake listOf("inv10", "shift2>", "s28.21", "-5") }

    "L191" { "90,58,5,,x6,inv10,shift2>" shouldMake listOf("inv10", "shift2>", "x6", "x6", "shift2>") }
    "L192" { "500,189,6,41,+8,x4,9,inv10,s7.0" shouldMake listOf("x4", "s7.0", "9", "+8", "s7.0") }
    "L193" { "321,234,4,41,9,+9,s53.32" shouldMake listOf("+9", "+9", "9", "s53.32") }
    "L194" { "123,333,4,41,1,3,/2,b+1" shouldMake listOf("3", "b+1", "/3", "2") }
    "L195" { "777,613,5,41,5,x2,+3,rev,inv10" shouldMake listOf("x2", "5", "5") }
    "L196" { "550,60,7,42,+5,x5,2,inv10" shouldMake listOf("+5", "+5", "2", "inv10", "x5") }
    "L197" { "4321,1234,5,,s24.13,s12.32,s13.21,s23.32,s23.43" shouldMake listOf("s23.32", "s24.13", "s13.21", "s12.32", "s23.43") }
    "L198" { "750,4,7,42,+6,4,x3,inv10" shouldMake listOf("x3", "x3", "inv10", "4", "+6") }
    "L199" { "3507,3002,6,51,7,s3.5,inv10,shift2>" shouldMake listOf("7", "7", "s3.5", "inv10", "shift2>", "7") }
})