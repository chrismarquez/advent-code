package com.christopher

import java.io.FileReader
import java.nio.file.Files
import java.nio.file.Path
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    if (args.size != 2) {
        println("Use advent {1A | 1B | 2A | 2B | 4A | 4B} filePath")
        exitProcess(1)
    }
    val (problem, fileName) = args
    if (!Files.exists(Path.of(fileName))) {
        println("File $fileName was not found")
        exitProcess(2)
    }
    val reader = FileReader(fileName)
    val lines = reader.readLines()
    val solution = when(problem) {
        "1A" -> addFrequencies(lines.map { it.toInt() }).toString()
        "1B" -> findDuplicateFreq(lines.map { it.toInt() }).toString()
        "2A" -> findIdChecksum(lines).toString()
        "2B" -> findCommonIds(lines)
        "4A" -> findSleepyGuard(lines).toString()
        "4B" -> findSleepyGuardAlt(lines).toString()
        else -> {
            println("Available problems are {1A | 1B | 2A | 2B | 4A | 4B}")
            exitProcess(1)
        }
    }
    println("Answer for problem $problem is $solution")
}