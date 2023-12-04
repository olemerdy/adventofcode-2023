package org.lafeuille.adventofcode.y2023.d04

import scala.io.Source

case class Card(id: Int, winningNumbers: Set[Int], actualNumbers: Set[Int]) {
  private lazy val winningActualNumbers: Set[Int] =
    winningNumbers.intersect(actualNumbers)

  lazy val score: Int =
    if winningActualNumbers.isEmpty then 0 else math.pow(2, winningActualNumbers.size - 1).toInt
}

object Day04 {
  private def myInput: Source =
    Source.fromURL(getClass.getResource("input04.txt"))

  def lineToCard(line: String): Card = line match {
    case s"Card ${id}: ${winning} | ${actual}" =>
      Card(
        id = id.trim.toInt,
        winningNumbers = winning.split("\\s+").map(_.trim).filterNot(_.isEmpty).map(_.toInt).toSet,
        actualNumbers = actual.split("\\s+").map(_.trim).filterNot(_.isEmpty).map(_.toInt).toSet
      )
  }

  def myList(): List[Card] =
    myInput.getLines().map(lineToCard).toList
}

object Part1 extends App {

  def result(list: List[Card]): Int =
    list.map(_.score).sum

  println(result(Day04.myList()))
}

object Part2 extends App {

  def result(list: List[Card]): Int = ???

  println(result(Day04.myList()))
}