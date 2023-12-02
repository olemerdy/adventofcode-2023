package org.lafeuille.adventofcode.y2023.d02

import scala.io.Source

case class Draw(redCubes: Int = 0, greenCubes: Int = 0, blueCubes: Int = 0)

case class Game(id: Int, draws: List[Draw])

case class Bag(redCubes: Int = 12, greenCubes: Int = 13, blueCubes: Int = 14) {
  private def isPossible(draw: Draw): Boolean =
    redCubes >= draw.redCubes && greenCubes >= draw.greenCubes && blueCubes >= draw.blueCubes

  def isPossible(game: Game): Boolean =
    game.draws.forall(isPossible)
}

object Day02 {

  private def myInput: Source =
    Source.fromURL(getClass.getResource("input02.txt"))

  private def lineToGame(line: String): Game = {
    val gameIdRegex = "Game (\\d+)".r
    val blueRegex = "(\\d+) blue".r
    val greenRegex = "(\\d+) green".r
    val redRegex = "(\\d+) red".r

    def reduceDraw(draw: Draw, colorString: String): Draw = colorString match {
      case blueRegex(count) => draw.copy(blueCubes = count.toInt)
      case greenRegex(count) => draw.copy(greenCubes = count.toInt)
      case redRegex(count) => draw.copy(redCubes = count.toInt)
      case _ => throw new IllegalStateException()
    }

    val Array(gameString, drawsString) = line.split(": ")
    val gameId: Int = gameString match {
      case gameIdRegex(id) => id.toInt
      case _ => throw new IllegalStateException()
    }
    val draws: List[Draw] = drawsString.split("; ")
      .map {
        _.split(", ")
          .foldLeft(Draw())(reduceDraw)
      }.toList
    Game(id = gameId, draws = draws)
  }

  def myList(): List[Game] = myInput
    .getLines()
    .map(lineToGame)
    .toList

}

object Part1 extends App {

  private val bag = Bag()

  def result(games: List[Game]): Int = games
    .filter(bag.isPossible)
    .map(_.id)
    .sum

  println(result(Day02.myList()))
}

object Part2 extends App {

  def result(list: List[Game]): Int = ???

  println(result(Day02.myList()))
}
