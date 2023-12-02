package org.lafeuille.adventofcode.y2023.d02

import scala.io.Source
import scala.math.max

case class Draw(redCubes: Int = 0, greenCubes: Int = 0, blueCubes: Int = 0)

case class Game(id: Int, draws: List[Draw]) {
  def minimalBag: Bag = draws.foldLeft(Bag()) { (bag, draw) =>
    bag.copy(
      redCubes = max(bag.redCubes, draw.redCubes),
      greenCubes = max(bag.greenCubes, draw.greenCubes),
      blueCubes = max(bag.blueCubes, draw.blueCubes)
    )
  }
}

case class Bag(redCubes: Int = 0, greenCubes: Int = 0, blueCubes: Int = 0) {
  private def isPossible(draw: Draw): Boolean =
    redCubes >= draw.redCubes && greenCubes >= draw.greenCubes && blueCubes >= draw.blueCubes

  def isPossible(game: Game): Boolean =
    game.draws.forall(isPossible)

  def power: Int =
    redCubes * greenCubes * blueCubes
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

  private val bag = Bag(redCubes = 12, greenCubes = 13, blueCubes = 14)

  def result(games: List[Game]): Int = games
    .filter(bag.isPossible)
    .map(_.id)
    .sum

  println(result(Day02.myList()))
}

object Part2 extends App {

  def result(games: List[Game]): Int = games
    .map(_.minimalBag)
    .map(_.power)
    .sum

  println(result(Day02.myList()))
}
