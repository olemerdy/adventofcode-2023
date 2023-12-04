package org.lafeuille.adventofcode.y2023.d04

import org.lafeuille.adventofcode.y2023.d04.{Day04, Part1}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

import scala.io.Source

class Part1Spec extends AnyFlatSpec with should.Matchers {

  private def sampleSource: Source =
    Source.fromURL(getClass.getResource("sample04.txt"))

  private val sample: List[Card] =
    sampleSource.getLines().map(Day04.lineToCard).toList

  val sampleResult = 13

  "Sample example" should s"have result $sampleResult" in {
    Part1.result(sample) shouldBe sampleResult
  }

  val inputResult = 22488

  "My input" should s"have result $inputResult" in {
    Part1.result(Day04.myList()) shouldBe inputResult
  }

}
