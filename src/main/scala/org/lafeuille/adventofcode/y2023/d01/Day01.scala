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

  private def rec(string: String): String = string match {
    case "" => ""
    case s if s.startsWith("one") => "1" + rec(s.substring(3))
    case s if s.startsWith("two") => "2" + rec(s.substring(3))
    case s if s.startsWith("three") => "3" + rec(s.substring(5))
    case s if s.startsWith("four") => "4" + rec(s.substring(4))
    case s if s.startsWith("five") => "5" + rec(s.substring(4))
    case s if s.startsWith("six") => "6" + rec(s.substring(3))
    case s if s.startsWith("seven") => "7" + rec(s.substring(5))
    case s if s.startsWith("eight") => "8" + rec(s.substring(5))
    case s if s.startsWith("nine") => "9" + rec(s.substring(4))
    case s => s.take(1) + rec(s.drop(1))
  }

  def result(list: List[String]): Int =
    Part1.result(list.map(rec))

  println(result(Day01.myList()))
}
