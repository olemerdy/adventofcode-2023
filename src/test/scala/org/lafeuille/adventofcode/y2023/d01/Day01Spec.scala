package org.lafeuille.adventofcode.y2023.d01


import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.*

val sample = Nil

class Part1Spec extends AnyFlatSpec with should.Matchers {

  val sampleResult = 0

  "Sample example" should s"have result $sampleResult" in {
    Part1.result(sample) shouldBe sampleResult
  }

  val inputResult = 0

  "My input" should s"have result $inputResult" in {
    Part1.result(Day01.myList()) shouldBe inputResult
  }

}
