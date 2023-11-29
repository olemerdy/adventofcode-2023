package org.lafeuille.adventofcode.y2023.d01

import scala.io.Source

object Day01 {
  private def myInput: Source =
    Source.fromURL(getClass.getResource("input.txt"))

  def myList(): List[String] =
    myInput.getLines().toList
}

object Part1 extends App {

  def result(list: List[String]): Int = 0

  println(result(Day01.myList()))
}

object Part2 extends App {

  def result(list: List[String]): Int = 0

  println(result(Day01.myList()))
}
