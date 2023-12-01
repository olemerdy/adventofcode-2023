package org.lafeuille.adventofcode.y2023.d01

import scala.io.Source

object Day01 {
  private def myInput: Source =
    Source.fromURL(getClass.getResource("input.txt"))

  def myList(): List[String] =
    myInput.getLines().toList
}

object Part1 extends App {

  def result(list: List[String]): Int = list
    .map(line => line.filter(_.isDigit))
    .map(digits => "" + digits.head + digits.last)
    .map(digits => digits.toInt)
    .sum

  println(result(Day01.myList()))
}

object Part2 extends App {

  def result(list: List[String]): Int = {
    val newList = list.map(_
      .replace("one", "one1one")
      .replace("two", "two2two")
      .replace("three", "three3three")
      .replace("four", "four4four")
      .replace("five", "five5five")
      .replace("six", "six6six")
      .replace("seven", "seven7seven")
      .replace("eight", "eight8eight")
      .replace("nine", "nine9nine")
    )
    Part1.result(newList)
  }

  println(result(Day01.myList()))
}
