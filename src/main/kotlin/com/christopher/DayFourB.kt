package com.christopher

fun findSleepyGuardAlt(guardLog: List<String>): Int {
    val guardSleepFreq = prepareHistogramSet(guardLog)
    val (id, histogram) = guardSleepFreq.maxBy { it.value.mostSleptQuantity() }!!
    return histogram.mostSleptMin() * id.substring(1).toInt()
}