package org.lafeuille.adventofcode.y2023.d03

import scala.io.Source

sealed abstract class MatrixValue

case class NumberValue(i: Int) extends MatrixValue

case class SymbolValue(c: Char) extends MatrixValue

object EmptyValue extends MatrixValue

case class Matrix(values: Map[Position, MatrixValue]) {

  lazy val maxX: Int = values.foldLeft(0) { case (acc, (position, value)) => math.max(acc, position.x) }
  lazy val maxY: Int = values.foldLeft(0) { case (acc, (position, value)) => math.max(acc, position.y) }

  def hasSymbol(position: Position): Boolean =
    values.get(position).exists {
      case _: SymbolValue => true
      case _ => false
    }

  def hasNumber(position: Position): Boolean =
    values.get(position).exists {
      case _: NumberValue => true
      case _ => false
    }

  def getNumber(position: Position): Int =
    values.get(position).flatMap {
      case NumberValue(i) => Some(i)
      case _ => None
    }.get
}

case class Position(x: Int, y: Int) {
  lazy val neighbors: Set[Position] = (
    for i <- -1 to 1
        j <- -1 to 1 if i != j || i != 0
    yield Position(i, j)).toSet

}

object Day03 {

  private def myInput: Source =
    Source.fromURL(getClass.getResource("input03.txt"))

  def myMatrix(): Matrix = Matrix(
    myInput.getLines().zipWithIndex
      .flatMap((line, y) => line.zipWithIndex.map {
        case (c, x) if c.isDigit => Position(x, y) -> NumberValue(c.toInt)
        case ('.', x) => Position(x, y) -> EmptyValue
        case (c, x) => Position(x, y) -> SymbolValue(c)
      }).toMap
  )

}

object Part1 extends App {

  def result(matrix: Matrix): Int = (
    for x <- 0 to matrix.maxX
        y <- 0 to matrix.maxY
        position = Position(x, y)
        if matrix.hasNumber(position)
        if position.neighbors.exists(matrix.hasSymbol)
    yield matrix.getNumber(position)
    ).sum

  println(result(Day03.myMatrix()))
}

object Part2 extends App {

  def result(matrix: Matrix): Int = ???

  println(result(Day03.myMatrix()))
}
