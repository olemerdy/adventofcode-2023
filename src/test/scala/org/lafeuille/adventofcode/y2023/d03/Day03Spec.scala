package org.lafeuille.adventofcode.y2023.d03

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

val sample: Matrix = ???

class Part1Spec extends AnyFlatSpec with should.Matchers {

  val sampleResult = 8

  "Sample example" should s"have result $sampleResult" in {
    Part1.result(sample) shouldBe sampleResult
  }

  val inputResult = 2679

  "My input" should s"have result $inputResult" in {
    Part1.result(Day03.myMatrix()) shouldBe inputResult
  }

}

class Part2Spec extends AnyFlatSpec with should.Matchers {

  val sampleResult = 0

  "Sample example" should s"have result $sampleResult" in {
    Part2.result(sample) shouldBe sampleResult
  }

  val inputResult = 77607

  "My input" should s"have result $inputResult" in {
    Part2.result(Day03.myMatrix()) shouldBe inputResult
  }
}
