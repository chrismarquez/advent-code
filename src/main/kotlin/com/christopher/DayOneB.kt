package com.christopher

import java.io.FileReader

fun findDuplicateFreq(freqList: List<Int>): Int {
    val found = HashSet<Int>()
    var freq = 0
    while(true) { // Guaranteed to find at least one duplicate freq per problem statement
        for (newFreq in freqList) {
            freq += newFreq
            if (found.contains(freq)) return freq
            else found.add(freq)
        }
    }
}