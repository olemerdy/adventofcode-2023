package org.lafeuille.adventofcode.y2023.d03

import scala.io.Source

object Day03 {

  private def myInput: Source =
    Source.fromURL(getClass.getResource("input03.txt"))

  def myList(): List[String] =
    myInput.getLines().toList

}

object Part1 extends App {

  def result(games: List[String]): Int = ???

  println(result(Day03.myList()))
}

object Part2 extends App {

  def result(games: List[String]): Int = ???

  println(result(Day03.myList()))
}
