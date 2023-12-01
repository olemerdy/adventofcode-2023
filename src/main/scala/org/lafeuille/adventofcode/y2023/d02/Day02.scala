package org.lafeuille.adventofcode.y2023.d02

import scala.io.Source

object Day02 {

  private def myInput: Source =
    Source.fromURL(getClass.getResource("input.txt"))

  def myList(): List[String] =
    myInput.getLines().toList

}

object Part1 extends App {

  def result(list: List[String]): Int = ???

  println(result(Day02.myList()))
}

object Part2 extends App {

  def result(list: List[String]): Int = ???

  println(result(Day02.myList()))
}
