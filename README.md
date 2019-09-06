# advent-code

Contains solutions to problems 1, 2 and 4 of Advent of Code 2018, written in Kotlin.

## Dependencies

Gradle 5+

Java 8+

## Instructions to run

Clone the repository

Go inside repository folder (cd advent-code)

To run all predefined tests, run:

./gradlew clean test

If one wishes to add custom input, the program can be run as follows:

Run command ./gradlew run --args="{problem} {inputFile}"

Where {problem} stands for the problem to execute (including 1A, 1B, 2A, 2B, 4A, 4B)
and {inputFile} the text file path to use as input to the problem.

I included in this repo the original inputs for the problems, so in order to run each problem,
I provide the following commands:

./gradlew run --args="1A input1.txt"
 
./gradlew run --args="1B input1.txt"

./gradlew run --args="2A input2.txt"

./gradlew run --args="2B input2.txt"

./gradlew run --args="4A input4.txt"

./gradlew run --args="4B input4.txt"

