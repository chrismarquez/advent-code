package com.christopher

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.collections.HashMap

data class Log (val date: LocalDateTime, val action: String) {
    companion object {
        fun fromLogText(logText: List<String>): List<Log> {
            val format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
            return logText.map {
                val time = it.substring(1..16)
                val date = LocalDateTime.parse(time, format)
                val action = it.substring(19)
                Log(date, action)
            }.sortedBy { it.date }
        }
    }
}

class SleepHistogram {
    private val asleepAt: IntArray = IntArray(60)

    fun sleepRange(start: Int, end: Int) {
        for (i in start until end) asleepAt[i]++
    }

    private fun mostSlept(): Pair<Int, Int> {
        var index = 0
        var max = asleepAt[0]
        for (i in 1 until asleepAt.size) {
            if (asleepAt[i] > max) {
                index = i
                max = asleepAt[i]
            }
        }
        return Pair(index, max)
    }

    fun mostSleptMin(): Int = mostSlept().first
    fun mostSleptQuantity() = mostSlept().second
    fun totalSlept(): Int = asleepAt.sum()
}

fun findSleepyGuard(guardLog: List<String>): Int {
    val guardSleepFreq = prepareHistogramSet(guardLog)
    val (id, histogram) = guardSleepFreq.maxBy { it.value.totalSlept() }!!
    return histogram.mostSleptMin() * id.substring(1).toInt()
}

fun prepareHistogramSet(guardLog: List<String>): Map<String, SleepHistogram> {
    val sortedLog = Log.fromLogText(guardLog)
    val guardSleepFreq: MutableMap<String, SleepHistogram> = HashMap()
    var sleepStart = 0
    var guardId = ""
    for (entry in sortedLog) {
        when(entry.action[0]) {
            'G' -> {
                guardId = entry.action.split(" ")[1]
                if (guardId !in guardSleepFreq) guardSleepFreq[guardId] = SleepHistogram()
            }
            'f' -> sleepStart = entry.date.minute
            'w' -> {
                val sleepEnd = entry.date.minute
                guardSleepFreq[guardId]?.sleepRange(sleepStart, sleepEnd)
                sleepStart = 0
            }
        }
    }
    return guardSleepFreq
}