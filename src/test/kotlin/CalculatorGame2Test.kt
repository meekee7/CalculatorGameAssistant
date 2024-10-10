package calc

import io.kotest.core.spec.style.StringSpec

class CalculatorGame2Test : StringSpec({
    "L1" { "3,0,3,,+1" shouldMake listOf("+1", "+1", "+1") }
    "L2" { "8,0,3,,+3,+2" shouldMake listOf("+3", "+3", "+2") }
    "L3" { "6,0,4,,+1,x2" shouldMake listOf("+1", "+1", "+1", "x2") }
    "L4" { "200,0,4,,+10,x4" shouldMake listOf("+10", "x4", "+10", "x4") }
    "L5" { "24,2,3,,x2,x3" shouldMake listOf("x2", "x2", "x3") }
    "L6" { "1,1234,3,,<<" shouldMake listOf("<<", "<<", "<<") }
    "L7" { "8,20,3,,<<,x2" shouldMake listOf("<<", "x2", "x2") }
    "L8-1" { "8,10,4,,x2,<<" shouldMake listOf("x2", "x2", "x2", "<<") }
    "L8-2" { "2,10,4,,x2,<<" shouldMake listOf("x2", "<<") }
    "L9-1" { "5,125,4,,x2,<<" shouldMake listOf("x2", "x2", "<<", "<<") }
    "L9-2" { "4,125,4,,x2,<<" shouldMake listOf("x2", "<<", "<<", "x2") }
    "L10" { "321,3,2,,2,1" shouldMake listOf("2", "1") }

    "L11" { "11,100,3,,1,<<" shouldMake listOf("<<", "<<", "1") }
    "L12" { "500,1,4,,0,/2" shouldMake listOf("0", "0", "0", "/2") }
    "L13" { "100,234,4,,x4,5,<<" shouldMake listOf("<<", "<<", "5", "x4") }
    "L14" { "2018,150,3,,18,+5,<<" shouldMake listOf("<<", "+5", "18") }
    "L15-1" { "95,25,3,,5,/5,+4" shouldMake listOf("/5", "+4", "5") }
    "L15-2" { "59,25,3,,5,/5,+4" shouldMake listOf("/5", "5", "+4") }
    "L16-1" { "32,155,4,,2,x2,<<" shouldMake listOf("x2", "<<", "<<", "2") }
    "L16-2" { "24,155,4,,2,x2,<<" shouldMake listOf("<<", "<<", "2", "x2") }
    "L17-1" { "122,11,3,,x12,<<,2" shouldMake listOf("<<", "x12", "2") }
    "L17-2" { "144,11,3,,x12,<<,2" shouldMake listOf("<<", "x12", "x12") }
    "L18" { "3,15,4,,+5,/7,6,<<" shouldMake listOf("+5", "+5", "+5", "<<") }
    "L19-1" { "96,200,4,,+12,x3,1,<<" shouldMake listOf("<<", "+12", "x3") }
    "L19-2" { "63,200,4,,+12,x3,1,<<" shouldMake listOf("+12", "x3", "<<") }
    "L19-3" { "33,200,4,,+12,x3,1,<<" shouldMake listOf("+12", "<<", "+12") }

    "L21" { "555,220,3,,s2.5,+1" shouldMake listOf("+1", "+1", "s2.5") }
    "L22" { "33,21,2,,s1.2,s2.3" shouldMake listOf("s1.2", "s2.3") }
    "L23" { "40,32,2,,s2.1,+9" shouldMake listOf("s2.1", "+9") }
    "L24" { "110,100,3,,s0.1,s2.0,+2" shouldMake listOf("+2", "s0.1", "s2.0") }
    "L25" { "232,40,3,,2,s4.2,s0.3" shouldMake listOf("2", "s4.2", "s0.3") }
    "L26" { "62,550,3,,+6,s1.2,<<" shouldMake listOf("<<", "+6", "s1.2") }
    "L27" { "321,123,4,,s2.3,s13.21" shouldMake listOf("s2.3", "s13.21", "s2.3", "s13.21") }
    "L28-1" { "5,0,4,,x3,s1.3,<<,+4" shouldMake listOf("+4", "x3", "<<", "+4") }
    "L28-2" { "3,0,4,,x3,s1.3,<<,+4" shouldMake listOf("+4", "x3", "x3", "<<") }
    "L29" { "3223,1111,3,,s1.3,s11.12,+9" shouldMake listOf("s11.12", "+9", "s1.3") }
    "L30-1" { "54321,23154,1,,s>,s<" shouldMake listOf("s<") }
    "L30-2" { "12345,23154,1,,s>,s<" shouldMake listOf("s>") }

    "L31" { "125,2048,3,,s>,/2" shouldMake listOf("/2", "/2", "s>") }
    "L32" { "256,215,3,,s>,x5" shouldMake listOf("s>", "x5", "s>") }
    "L33" { "1970,1985,3,,x2,<<,s<" shouldMake listOf("s<", "x2", "<<") }
    "L34" { "1234,16,3,,s<,x2,7" shouldMake listOf("s<", "7", "x2") }
    "L35" { "333,4321,4,,s2.3,s>,s1.3,<<" shouldMake listOf("s2.3", "s>", "s1.3", "<<") }
    "L36-1" { "123,97231,4,,s>,<<,s9.5" shouldMake listOf("s>", "<<", "<<") }
    "L36-2" { "275,97231,4,,s>,<<,s9.5" shouldMake listOf("<<", "<<", "s>", "s9.5") }
    "L37-1" { "19,303,3,,+1,s>,x3" shouldMake listOf("x3", "+1", "s>") }
    "L37-2" { "100,303,3,,+1,s>,x3" shouldMake listOf("s>", "x3", "+1") }
    "L38-1" { "111,423,4,,/2,s>,<<,1" shouldMake listOf("s>", "/2", "<<", "1") }
    "L38-2" { "123,423,4,,/2,s>,<<,1" shouldMake listOf("1", "s>", "<<") }
    "L39-1" { "963,30,5,,+6,/5,3,s<" shouldMake listOf("+6", "3", "+6", "s<") }
    "L39-2" { "321,30,5,,+6,/5,3,s<" shouldMake listOf("/5", "+6", "3", "s<") }

    "L41" { "22,210210,2,,c0,c1" shouldMake listOf("c0", "c1") }
    "L42" { "1,20,3,,c1,x5,+1" shouldMake listOf("x5", "c1", "+1") }
    "L43" { "2,33,3,,c1,+3,x3" shouldMake listOf("x3", "+3", "c1") }
    "L44" { "6,4454,4,,<<,c4,+2,+4" shouldMake listOf("<<", "<<", "<<", "+2") }
    "L45" { "72,6996,3,,+3,c9" shouldMake listOf("c9", "+3", "+3") }
    "L46" { "23,1234,2,,c1,<<" shouldMake listOf("c1", "<<") }
    "L47" { "15,12345,3,,c1,/3" shouldMake listOf("/3", "c1", "/3") }
    "L48" { "22,11,3,,c1,+5,x11,x12" shouldMake listOf("x11", "c1", "x11") }
    "L49" { "2,99999,5,,c1,s9.3,s3.1,-8" shouldMake listOf("-8", "s9.3", "-8", "s3.1", "c1") }
    "L50" { "123,10203,2,,del" shouldMake listOf("d2", "d3") }

    "L51" { "40,55,3,,x2,x4,del" shouldMake listOf("x2", "x4", "d1") }
    "L52" { "10,5,3,,x4,x7,del" shouldMake listOf("x4", "x7", "d2") }
    "L53" { "22,101,2,,x2,del" shouldMake listOf("x2", "d2") }
    "L54-1" { "8,3,3,,del,+1,x5,x4" shouldMake listOf("x4", "x4", "d1") }
    "L54-2" { "6,3,3,,del,+1,x5,x4" shouldMake listOf("+1", "+1", "+1") }
    "L55" { "9,121,3,,/9,del,s12.18" shouldMake listOf("s12.18", "d1", "/9") }
    "L56-1" { "50,56,2,,del,0" shouldMake listOf("0", "d2") }
    "L56-2" { "60,56,2,,del,0" shouldMake listOf("0", "d1") }
    "L57-1" { "42,12,3,,del,1,x2" shouldMake listOf("1", "x2", "d1") }
    "L57-2" { "22,12,3,,del,1,x2" shouldMake listOf("1", "x2", "d2") }
    "L58-1" { "18,120,4,,del,x3" shouldMake listOf("x3", "x3", "d2", "d3") }
    "L58-2" { "9,120,4,,del,x3" shouldMake listOf("x3", "d2", "x3", "d2") }
    "L59-1" { "12,10,4,,/2,x5,del" shouldMake listOf("/2", "x5", "x5", "d3") }
    "L59-2" { "100,10,4,,/2,x5,del" shouldMake listOf("x5", "x5", "d2", "x5") }
    "L59-3" { "15,10,4,,/2,x5,del" shouldMake listOf("/2", "x5", "x5", "d2") }

    "L61" { "234,4,2,,ins2,ins3" shouldMake listOf("ins2.1", "ins3.2") }
    "L62" { "48,14,3,,del,ins2,x2" shouldMake listOf("d1", "ins2.1", "x2") }
    "L63-1" { "21,4,3,,ins1,del,x5" shouldMake listOf("x5", "ins1.2", "d3") }
    "L63-2" { "12,4,3,,ins1,del,x5" shouldMake listOf("x5", "ins1.1", "d3") }
    "L64-1" { "110,2,2,,ins1,+8" shouldMake listOf("+8", "ins1.1") }
    "L64-2" { "20,2,2,,ins1,+8" shouldMake listOf("ins1.1", "+8") }
    "L65-1" { "220,1,3,,ins2,x5,x4" shouldMake listOf("x5", "x4", "ins2.1") }
    "L65-2" { "120,1,3,,ins2,x5,x4" shouldMake listOf("x4", "ins2.1", "x5") }
    "L65-3" { "100,1,3,,ins2,x5,x4" shouldMake listOf("x5", "x5", "x4") }
    "L66-1" { "21,3,3,,+2,x3,ins1" shouldMake listOf("+2", "+2", "x3") }
    "L66-2" { "99,3,3,,+2,x3,ins1" shouldMake listOf("ins1.2", "+2", "x3") }
    "L66-3" { "45,3,3,,+2,x3,ins1" shouldMake listOf("+2", "x3", "x3") }
    "L67-1" { "7,4505,3,,c5,ins2,+2,del" shouldMake listOf("+2", "c5", "d1") }
    "L67-2" { "20,4505,3,,c5,ins2,+2,del" shouldMake listOf("c5", "ins2.1", "d2") }
    "L67-3" { "242,4505,3,,c5,ins2,+2,del" shouldMake listOf("c5", "+2", "ins2.1") }
    "L68-1" { "32,10,3,,ins2,del,x3" shouldMake listOf("x3", "ins2.2", "d3") }
    "L68-2" { "36,10,3,,ins2,del,x3" shouldMake listOf("ins2.2", "x3", "d3") }
    "L68-3" { "60,10,3,,ins2,del,x3" shouldMake listOf("ins2.1", "x3", "d2") }
    "L69-1" { "3003,99,3,,x3,ins1,+1" shouldMake listOf("+1", "ins1.4", "x3") }
    "L69-2" { "3300,99,3,,x3,ins1,+1" shouldMake listOf("+1", "ins1.1", "x3") }
    "L69-3" { "3030,99,3,,x3,ins1,+1" shouldMake listOf("+1", "ins1.3", "x3") }
    "L70" { "202,102,2,,rev,+1" shouldMake listOf("rev", "+1") }

    "L71" { "144,63,3,,rev,ins1,+8" shouldMake listOf("rev", "+8", "ins1.1") }
    "L72" { "21,212,3,,rev,s>,-2" shouldMake listOf("s>", "-2", "rev") }
    "L73" { "59,715,3,,-8,rev,c0" shouldMake listOf("rev", "-8", "c0") }
    "L74-1" { "9,40,3,,x3,rev,-3" shouldMake listOf("rev", "x3", "-3") }
    "L74-2" { "18,40,3,,x3,rev,-3" shouldMake listOf("x3", "rev", "-3") }
    "L75-1" { "144,24,3,,+6,x3,rev" shouldMake listOf("rev", "+6", "x3") }
    "L75-2" { "9,24,3,,+6,x3,rev" shouldMake listOf("+6", "x3", "rev") }
    "L76-1" { "22,64,3,,rev,-2,/2" shouldMake listOf("rev", "-2", "/2") }
    "L76-2" { "3,64,3,,rev,-2,/2" shouldMake listOf("/2", "-2", "rev") }
    "L76-3" { "21,64,3,,rev,-2,/2" shouldMake listOf("rev", "/2", "-2") }
    "L77-1" { "52,12,4,,rev,x5,del" shouldMake listOf("rev", "x5", "x5", "d3") }
    "L77-2" { "3,12,4,,rev,x5,del" shouldMake listOf("x5", "x5", "rev") }
    "L77-3" { "15,12,4,,rev,x5,del" shouldMake listOf("rev", "x5", "d2") }
    "L78-1" { "651,125,3,,rev,s2.5,+1" shouldMake listOf("s2.5", "+1", "rev") }
    "L78-2" { "555,125,3,,rev,s2.5,+1" shouldMake listOf("rev", "+1", "s2.5") }
    "L79-1" { "50,84,4,,+2,rev,c4,ins1" shouldMake listOf("rev", "+2") }
    "L79-2" { "2,84,4,,+2,rev,c4,ins1" shouldMake listOf("c4", "ins1.1", "+2", "rev") }
    "L79-3" { "11,84,4,,+2,rev,c4,ins1" shouldMake listOf("c4", "+2", "rev", "ins1.1") }

    "L81-1" { "120,123,1,,rnd" shouldMake listOf("rnd1") }
    "L81-2" { "100,123,1,,rnd" shouldMake listOf("rnd0") }
    "L82" { "200,10,2,,rnd,ins5" shouldMake listOf("ins5.2", "rnd0") }
    "L83-1" { "40,24,3,,rnd,s4.3,x2" shouldMake listOf("rnd0", "x2") }
    "L83-2" { "50,24,3,,rnd,s4.3,x2" shouldMake listOf("x2", "rnd0") }
    "L84-1" { "500,2150,2,,rnd,rev" shouldMake listOf("rev", "rnd0") }
    "L84-2" { "2,2150,2,,rnd,rev" shouldMake listOf("rnd0", "rev") }
    "L85-1" { "400,3540,3,,rnd,c5,+10" shouldMake listOf("c5", "+10", "rnd0") }
    "L85-2" { "300,3540,3,,rnd,c5,+10" shouldMake listOf("c5", "rnd0") }
    "L86-1" { "300,354,3,,rnd,ins1,s>" shouldMake listOf("s>", "rnd0") }
    "L86-2" { "1000,354,3,,rnd,ins1,s>" shouldMake listOf("ins1.1", "rnd0") }
    "L87-1" { "2000,35,3,,rnd,x5,s5.12" shouldMake listOf("x5", "s5.12", "rnd0") }
    "L87-2" { "1600,35,3,,rnd,x5,s5.12" shouldMake listOf("s5.12", "x5", "rnd1") }
    "L88-1" { "44,352,3,,rnd,rev,s>,4" shouldMake listOf("rnd0", "rev", "4") }
    "L88-2" { "2000,352,3,,rnd,rev,s>,4" shouldMake listOf("s>", "4", "rnd0") }
    "L88-3" { "2500,352,3,,rnd,rev,s>,4" shouldMake listOf("rev", "4", "rnd1") }
    "L89-1" { "10001,2189,3,,rnd,rev,+1" shouldMake listOf("rev", "rnd0", "+1") }
    "L89-2" { "3,2189,3,,rnd,rev,+1" shouldMake listOf("rnd0", "rev", "+1") }
    "L89-3" { "900,2189,3,,rnd,rev,+1" shouldMake listOf("+1", "rev", "rnd0") }
    "L90" { "2222,2024,2,,p+2,p-2" shouldMake listOf("p+2.2", "p-2.4") }

    "L91" { "40,25,2,,p+2,p-5" shouldMake listOf("p+2.1", "p-5.2") }
    "L92" { "18,21,3,,p+2,s4.8,rev" shouldMake listOf("rev", "p+2.2", "s4.8") }
    "L93-1" { "316,100,3,,p+2,+8" shouldMake listOf("+8", "+8", "p+2.1") }
    "L93-2" { "136,100,3,,p+2,+8" shouldMake listOf("+8", "+8", "p+2.2") }
    "L94-1" { "0,25,2,,p+5,+25" shouldMake listOf("+25", "p+5.1") }
    "L94-2" { "100,25,2,,p+5,+25" shouldMake listOf("p+5.1", "+25") }
    "L95-1" { "210,12,3,,p+4,x4,+2" shouldMake listOf("p+4.1", "x4", "+2") }
    "L95-2" { "90,12,3,,p+4,x4,+2" shouldMake listOf("x4", "+2", "p+4.1") }
    "L96-1" { "900,555,3,,p+9,x2" shouldMake listOf("p+9.1", "x2", "p+9.2") }
    "L96-2" { "1000,555,3,,p+9,x2" shouldMake listOf("x2", "p+9.2", "p+9.3") }
    "L97-1" { "250,50,4,,del,p+4,ins1,x4" shouldMake listOf("x4", "d2", "ins1.2", "p+4.2") }
    "L97-2" { "500,50,4,,del,p+4,ins1,x4" shouldMake listOf("x4", "ins1.1", "d2", "p+4.1") }
    "L98-1" { "3456,650,4,,p-2,c6,ins3" shouldMake listOf("p-2.1", "p-2.3", "p-2.3", "ins3.1") }
    "L98-2" { "303,650,4,,p-2,c6,ins3" shouldMake listOf("c6", "p-2.1", "ins3.3") }
    "L99-1" { "1750,1990,4,,del,p+8,p+5,rnd" shouldMake listOf("p+8.2", "p+8.3", "p+8.3") }
    "L99-2" { "150,1990,4,,del,p+8,p+5,rnd" shouldMake listOf("d2", "p+8.2", "p+8.2") }
    "L99-3" { "25,1990,4,,del,p+8,p+5,rnd" shouldMake listOf("d2", "d3", "rnd0", "p+5.2") }

    "L101" { "8,2,3,,flip,+5" shouldMake listOf("flip", "+5", "+5") }
    "L102" { "2,6,4,,flip,+5,x2" shouldMake listOf("flip", "+5", "flip", "x2") }
    "L103" { "-6,62,4,,flip,p+2,-12" shouldMake listOf("flip", "-12", "-12", "p+2.2") }
    "L104" { "-12,208,4,,flip,+2,del,/2" shouldMake listOf("flip", "/2", "+2", "d3") }
    "L105" { "-8,47,5,,flip,+5,/2" shouldMake listOf("flip", "+5", "/2", "+5", "/2") }
    "L106-1" { "14,10,5,,flip,+8,x3" shouldMake listOf("flip", "+8", "+8", "+8") }
    "L106-2" { "66,10,5,,flip,+8,x3" shouldMake listOf("flip", "x3", "+8", "flip", "x3") }
    "L107-1" { "-48,54,4,,flip,-6,+3" shouldMake listOf("-6", "flip") }
    "L107-2" { "66,54,4,,flip,-6,+3" shouldMake listOf("flip", "-6", "-6", "flip") }
    "L108-1" { "182,181,4,,flip,-8,-9" shouldMake listOf("flip", "-9", "flip", "-8") }
    "L108-2" { "180,181,4,,flip,-8,-9" shouldMake listOf("flip", "-8", "flip", "-9") }
    "L109-1" { "40,41,5,,flip,<<,+2,1" shouldMake listOf("flip", "1", "+2", "flip", "<<") }
    "L109-2" { "21,41,5,,flip,<<,+2,1" shouldMake listOf("<<", "<<", "+2", "1") }
    "L110-1" { "312,123,1,,shift" shouldMake listOf("shift1") }
    "L110-2" { "231,123,1,,shift" shouldMake listOf("shift2") }

    "L111" { "151,121,3,,shift,+3" shouldMake listOf("shift1", "+3", "shift2") }
    "L112" { "5,84,3,,shift,+2" shouldMake listOf("shift1", "+2", "shift1") }
    "L113" { "125,215,2,,shift,rev" shouldMake listOf("rev", "shift2") }
    "L114" { "678,918,3,,shift,<<,s1.67" shouldMake listOf("s1.67", "shift3", "<<") }
    "L115" { "306,1206,2,,shift,/2" shouldMake listOf("shift2", "/2") }
    "L116-1" { "101,55,3,,shift,x2" shouldMake listOf("x2", "shift2") }
    "L116-2" { "22,55,3,,shift,x2" shouldMake listOf("x2", "x2", "shift1") }
    "L117-1" { "210,214,4,,shift,-1,/2" shouldMake listOf("shift1", "-1", "/2") }
    "L117-2" { "102,214,4,,shift,-1,/2" shouldMake listOf("shift1", "-1", "/2", "shift2") }
    "L118-1" { "55,5252,4,,c1,shift,s25.15,s52.12" shouldMake listOf("shift1", "s25.15", "c1") }
    "L118-2" { "25,5252,4,,c1,shift,s25.15,s52.12" shouldMake listOf("s25.15", "s52.12", "c1", "shift1") }
    "L119-1" { "305,152,5,,+2,shift,rev,rnd" shouldMake listOf("rnd1", "shift2", "+2", "rev") }
    "L119-2" { "202,152,5,,+2,shift,rev,rnd" shouldMake listOf("rnd0", "+2") }
    "L119-3" { "125,152,5,,+2,shift,rev,rnd" shouldMake listOf("rev", "shift1") }

    "L121" { "10,19,1,,sum" shouldMake listOf("sum") }
    "L122" { "1,19,2,,sum" shouldMake listOf("sum", "sum") }
    "L123" { "7,123,2,,sum,1" shouldMake listOf("1", "sum") }
    "L124" { "11,55,3,,sum,+5" shouldMake listOf("+5", "sum", "+5") }
    "L125" { "7,91,4,,sum,rev,+3" shouldMake listOf("sum", "sum", "+3", "+3") }
    "L126-1" { "0,1213,3,,sum,c1,+4" shouldMake listOf("sum", "+4", "c1") }
    "L126-2" { "9,1213,3,,sum,c1,+4" shouldMake listOf("c1", "sum", "+4") }
    "L127-1" { "12,3,3,,sum,x5" shouldMake listOf("x5", "x5", "sum") }
    "L127-2" { "30,3,3,,sum,x5" shouldMake listOf("x5", "sum", "x5") }
    "L128" { "8,1111,4,,sum,x4,1" shouldMake listOf("sum", "x4", "1", "sum") }
    "L129" { "35,5000,5,,sum,rev,+4" shouldMake listOf("sum", "+4", "+4", "rev", "+4") }
    "L130" { "1221,12,1,,m" shouldMake listOf("m") }

    "L131" { "1331,11,2,,m,+2" shouldMake listOf("+2", "m") }
    "L132" { "2442,42,2,,m,rev" shouldMake listOf("rev", "m") }
    "L133" { "5555,505,2,,m,shift" shouldMake listOf("shift2", "m") }
    "L134" { "22,4,3,,m,c1,x3" shouldMake listOf("x3", "m", "c1") }
    "L135" { "1199,90,5,,m,shift2<,10" shouldMake listOf("10", "shift2<", "shift2<", "m", "shift2<") }
    "L136" { "2112,123,4,,m,sum,rev" shouldMake listOf("m", "sum", "rev", "m") }
    "L137-1" { "1111,201,4,,-1,m,rev,c2" shouldMake listOf("c2", "m", "m") }
    "L137-2" { "1000,201,4,,-1,m,rev,c2" shouldMake listOf("rev", "m", "-1", "c2") }
    "L138-1" { "3333,9933,4,,c1,m,/3,s31.2" shouldMake listOf("/3", "c1", "m") }
    "L138-2" { "3223,9933,4,,c1,m,/3,s31.2" shouldMake listOf("/3", "s31.2", "c1", "m") }
    "L139-1" { "5005,2,5,,m,rev,x5" shouldMake listOf("x5", "m", "x5") }
    "L139-2" { "1001,2,5,,m,rev,x5" shouldMake listOf("x5", "m") }
    "L139-3" { "275,2,5,,m,rev,x5" shouldMake listOf("m", "x5", "rev", "x5", "x5") }

    "L141" { "13,11,2,,b+1,+1" shouldMake listOf("+1", "+1") }
    "L142" { "30,16,3,,b+4,+10" shouldMake listOf("b+4", "+14") }
    "L143" { "20,4,3,,b+3,+5" shouldMake listOf("b+3", "+8", "+8") }
    "L144" { "360,10,5,,b+1,x2" shouldMake listOf("x2", "x2", "b+1", "x3", "x3") }
    "L145" { "15,3,5,,b+1,+2,m,sum" shouldMake listOf("m", "m", "sum", "b+1", "+3") }
    "L146" { "20,10,5,,b+2,x3,c1" shouldMake listOf("b+2", "x5", "x5", "b+2", "c5") }
    "L147" { "123,82,3,,b+1,/2,x2" shouldMake listOf("/2", "b+1", "x3") }
    "L148-1" { "36,13,5,,b+1,p+2,s43.2" shouldMake listOf("p+2.1", "b+1", "p+3.2") }
    "L148-2" { "6,13,5,,b+1,p+2,s43.2" shouldMake listOf("b+1", "p+3.1", "s43.2", "b+1", "p+4.1") }
    "L149-1" { "11,222,5,,b+2,ins3,sum,s56.10" shouldMake listOf("b+2", "ins5.1", "sum") }
    "L149-2" { "1,222,5,,b+2,ins3,sum,s56.10" shouldMake listOf("sum", "b+2", "ins5.1", "s56.10", "sum") }
    "L150" { "501,101,1,,rep5" shouldMake listOf("rep5.1") }

    "L151" { "1337,1347,1,,rep3" shouldMake listOf("rep3.3") }
    "L152" { "12121,11111,2,,rep2" shouldMake listOf("rep2.2", "rep2.4") }
    "L153" { "234,244,2,,rep4,s44.33" shouldMake listOf("s44.33", "rep4.3") }
    "L154-1" { "364,333,3,,rep4,-1,s34.65" shouldMake listOf("rep4.3", "s34.65", "-1") }
    "L154-2" { "652,333,3,,rep4,-1,s34.65" shouldMake listOf("-1", "rep4.2", "s34.65") }
    "L155-1" { "22,65,4,,rep6,p+1,+5,/5" shouldMake listOf("+5", "rep6.1", "/5", "p+1.1") }
    "L155-2" { "72,65,4,,rep6,p+1,+5,/5" shouldMake listOf("+5", "p+1.2", "p+1.2") }
    "L155-3" { "26,65,4,,rep6,p+1,+5,/5" shouldMake listOf("/5", "rep6.2", "p+1.1") }
    "L156-1" { "18,129,3,,rep7,sum" shouldMake listOf("rep7.1", "sum") }
    "L156-2" { "9,129,3,,rep7,sum" shouldMake listOf("sum", "rep7.1", "sum") }
    "L157-1" { "12,20,4,,rep6,m,sum" shouldMake listOf("rep6.1", "m", "sum") }
    "L157-2" { "64,20,4,,rep6,m,sum" shouldMake listOf("m", "sum", "m", "rep6.1") }
    "L158-1" { "332,144,3,,rep1,/3,inv10" shouldMake listOf("rep1.2", "inv10", "/3") }
    "L158-2" { "321,144,3,,rep1,/3,inv10" shouldMake listOf("inv10", "/3", "rep1.3") }
    "L159-1" { "32,108,4,,+2,rep8,sum,m" shouldMake listOf("rep8.1", "m", "sum") }
    "L159-2" { "181,108,4,,+2,rep8,sum,m" shouldMake listOf("sum", "m", "+2", "rep8.2") }
    "L159-3" { "82,108,4,,+2,rep8,sum,m" shouldMake listOf("+2", "sum", "m", "rep8.1") }

    "L161" { "10,2,2,,inv10,+2" shouldMake listOf("inv10", "+2") }
    "L162-1" { "350,35,3,,inv10,x2,p+2" shouldMake listOf("inv10", "x2", "p+2.1") }
    "L162-2" { "10,35,3,,inv10,x2,p+2" shouldMake listOf("x2", "p+2.1", "inv10") }
    "L163" { "9,410,4,,inv10,x3,sum,<<" shouldMake listOf("inv10", "x3", "sum") }
    "L164-1" { "7,13,3,,inv10,/5,s3.5" shouldMake listOf("s3.5", "/5", "inv10") }
    "L164-2" { "19,13,3,,inv10,/5,s3.5" shouldMake listOf("s3.5", "inv10", "/5") }
    "L165-1" { "13,180,4,,s>,inv10,+2,rev" shouldMake listOf("inv10", "s>", "+2", "s>") }
    "L165-2" { "8,180,4,,s>,inv10,+2,rev" shouldMake listOf("s>", "+2", "s>", "inv10") }
    "L166-1" { "50,154,4,,s9.5,inv10,+6,del" shouldMake listOf("+6", "inv10", "s9.5", "d2") }
    "L166-2" { "40,154,4,,s9.5,inv10,+6,del" shouldMake listOf("+6", "inv10", "d1") }
    "L167-1" { "1,369,5,,inv10,sum,+2" shouldMake listOf("sum", "sum", "inv10") }
    "L167-2" { "99,369,5,,inv10,sum,+2" shouldMake listOf("+2", "sum", "inv10") }
    "L167-3" { "80,369,5,,inv10,sum,+2" shouldMake listOf("sum", "+2", "inv10") }
    "L168-1" { "66,145,4,,sum,inv10,x3,rep2" shouldMake listOf("sum", "rep2.1", "rep2.2", "x3") }
    "L168-2" { "40,145,4,,sum,inv10,x3,rep2" shouldMake listOf("sum", "rep2.1", "x3", "inv10") }
    "L169-1" { "70,475,4,,<<,inv10,rep2,rnd" shouldMake listOf("<<", "rep2.1", "rnd0", "inv10") }
    "L169-2" { "60,475,4,,<<,inv10,rep2,rnd" shouldMake listOf("<<", "inv10", "rnd0") }
    "L169-3" { "80,475,4,,<<,inv10,rep2,rnd" shouldMake listOf("<<", "rep2.1", "inv10", "rnd0") }
    "L170" { "11,15,3,,<<,store" shouldMake listOf("<<", "store", "rest1") }

    "L171" { "2222,2,3,,store,2" shouldMake listOf("2", "2", "2") }
    "L172-1" { "18,8,4,,store,+2,<<" shouldMake listOf("store", "+2", "<<", "rest8") }
    "L172-2" { "101,8,4,,store,+2,<<" shouldMake listOf("+2", "store", "rest10", "<<") }
    "L173-1" { "64,4,4,,store,p+1" shouldMake listOf("store", "rest4", "p+1.1", "p+1.1") }
    "L173-2" { "65,4,4,,store,p+1" shouldMake listOf("p+1.1", "store", "rest5", "p+1.1") }
    "L174-1" { "6,2,4,,store,sum" shouldMake listOf("store", "rest2", "rest2", "sum") }
    "L174-2" { "42,2,4,,store,sum" shouldMake listOf("store", "rest2", "sum", "rest2") }
    "L175-1" { "99,11,5,,store,sum,inv10" shouldMake listOf("inv10") }
    "L175-2" { "82,11,5,,store,sum,inv10" shouldMake listOf("sum", "store", "inv10", "rest2") }
    "L176-1" { "126,33,5,,store,sum" shouldMake listOf("sum", "store", "rest6", "sum", "rest6") }
    "L176-2" { "1212,33,5,,store,sum" shouldMake listOf("store", "rest33", "sum", "store", "rest12") }
    "L177-1" { "12,10,5,,store,p+5,sum" shouldMake listOf("p+5.1", "store", "rest60", "sum") }
    "L177-2" { "710,10,5,,store,p+5,sum" shouldMake listOf("store", "rest10", "sum", "rest10", "p+5.1") }
    "L178-1" { "2112,123,5,,store,rev,<<" shouldMake listOf("<<", "store", "rev", "rest12") }
    "L178-2" { "33,123,5,,store,rev,<<" shouldMake listOf("rev", "<<", "<<", "store", "rest3") }
    "L179-1" { "131,118,6,,store,+2,<<" shouldMake listOf("<<", "+2", "store", "rest13", "<<") }
    "L179-2" { "33,118,6,,store,+2,<<" shouldMake listOf("<<", "<<", "+2", "store", "rest3") }
    "L179-3" { "123,118,6,,store,+2,<<" shouldMake listOf("+2", "<<", "store", "rest12", "<<", "+2") }

    "L181" { "25,15,2,,lock,+12" shouldMake listOf("fix1", "+12") }
    "L182" { "55,25,2,,lock,rev" shouldMake listOf("fix1", "rev") }
    "L183-1" { "28,125,2,,lock,sum" shouldMake listOf("fix2", "sum") }
    "L183-2" { "108,125,2,,lock,sum" shouldMake listOf("fix3", "sum") }
    "L184-1" { "49,54,3,,lock,s>,/5" shouldMake listOf("s>", "fix2", "/5") }
    "L184-2" { "11,54,3,,lock,s>,/5" shouldMake listOf("fix2", "s>", "/5") }
    "L185-1" { "2400,1975,3,,lock,rnd,p+5" shouldMake listOf("fix3", "rnd1", "p+5.2") }
    "L185-2" { "7070,1975,3,,lock,rnd,p+5" shouldMake listOf("p+5.1", "fix2", "rnd1") }
    "L186-1" { "2222,12,3,,lock,m,rev" shouldMake listOf("fix1", "rev", "m") }
    "L186-2" { "1111,12,3,,lock,m,rev" shouldMake listOf("fix2", "rev", "m") }
    "L187-1" { "13,35,4,,lock,ins7,sum" shouldMake listOf("ins7.1", "sum", "ins7.1", "sum") }
    "L187-2" { "9,35,4,,lock,ins7,sum" shouldMake listOf("ins7.2", "fix3", "sum", "sum") }
    "L188-1" { "48,2222,5,,lock,c2,/5" shouldMake listOf("fix3", "c2", "/5", "fix2", "/5") }
    "L188-2" { "480,2222,5,,lock,c2,/5" shouldMake listOf("fix4", "c2", "/5", "fix3", "/5") }
    "L189-1" { "4,1750,4,,lock,rnd,x2,s>" shouldMake listOf("x2", "rnd0", "s>") }
    "L189-2" { "45,1750,4,,lock,rnd,x2,s>" shouldMake listOf("x2", "s>", "fix1", "rnd0") }
    "L189-3" { "54,1750,4,,lock,rnd,x2,s>" shouldMake listOf("fix3", "rnd0", "s>", "x2") }
    "L190" { "1,11,2,31,+1,inv10" shouldMake listOf("inv10", "+1") }

    "L191" { "5,1,2,21,1,s2.5" shouldMake listOf("1", "s2.5") }
    "L192-1" { "16,55,2,31,5,x2" shouldMake listOf("x2", "5") }
    "L192-2" { "21,55,2,31,5,x2" shouldMake listOf("5", "x2") }
    "L193-1" { "57,25,2,31,p+2,3" shouldMake listOf("3", "p+2.2") }
    "L193-2" { "75,25,2,31,p+2,3" shouldMake listOf("3", "p+2.1") }
    "L194-1" { "9,62,2,21,+2,0,inv10" shouldMake listOf("+2", "inv10") }
    "L194-2" { "5,62,2,21,+2,0,inv10" shouldMake listOf("inv10", "+2") }
    "L194-3" { "1,62,2,21,+2,0,inv10" shouldMake listOf("+2") }
    "L195-1" { "7,14,4,41,m,1,sum" shouldMake listOf("1", "1", "sum") }
    "L195-2" { "121,14,4,41,m,1,sum" shouldMake listOf("1", "m", "sum", "1") }
    "L195-3" { "111,14,4,41,m,1,sum" shouldMake listOf("m", "1", "sum", "1") }
    "L196-1" { "2,91,4,41,inv10,store,m" shouldMake listOf("m", "inv10", "store", "rest982") }
    "L196-2" { "992,91,4,41,inv10,store,m" shouldMake listOf("inv10", "m") }
    "L196-3" { "920,91,4,41,inv10,store,m" shouldMake listOf("inv10", "store", "rest19") }
    "L197-1" { "525,15,5,41,inv10,store,<<" shouldMake listOf("store", "inv10", "<<", "rest15", "rest15") }
    "L197-2" { "220,15,5,41,inv10,store,<<" shouldMake listOf("store", "inv10", "rest15", "<<", "rest15") }
    "L198-1" { "860,77,4,41,rep4,m,<<,sum" shouldMake listOf("sum", "rep4.1", "m", "m") }
    "L198-2" { "500,77,4,41,rep4,m,<<,sum" shouldMake listOf("m", "rep4.1", "m") }
    "L198-3" { "78,77,4,41,rep4,m,<<,sum" shouldMake listOf("m", "<<") }
    "L198-4" { "444,77,4,41,rep4,m,<<,sum" shouldMake listOf("m", "rep4.1", "rep4.2") }
    "L199-1" { "93,9,6,51,s>,c0,9,1,ins2" shouldMake listOf("9", "9", "1", "ins2.3", "c0") }
    "L199-2" { "131,9,6,51,s>,c0,9,1,ins2" shouldMake listOf("1", "9", "ins2.3", "ins2.5", "c0") }
    "L199-3" { "1,9,6,51,s>,c0,9,1,ins2" shouldMake listOf("9", "9", "9", "1") }
    "L199-4" { "9933,9,6,51,s>,c0,9,1,ins2" shouldMake listOf("9", "9", "ins2.1", "ins2.4", "ins2.1") }
    "L199-5" { "31,9,6,51,s>,c0,9,1,ins2" shouldMake listOf("9", "9", "ins2.1", "ins2.1", "c0") }
})