package com.christopher

fun addFrequencies(freq: List<Int>): Int {
    return freq.reduce { acc, next -> acc + next}
}