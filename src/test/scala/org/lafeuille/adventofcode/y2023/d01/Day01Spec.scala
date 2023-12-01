package org.lafeuille.adventofcode.y2023.d01


import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.*

class Part1Spec extends AnyFlatSpec with should.Matchers {

  val sample = List(
    "1abc2",
    "pqr3stu8vwx",
    "a1b2c3d4e5f",
    "treb7uchet"
  )

  val sampleResult = 142

  "Sample example" should s"have result $sampleResult" in {
    Part1.result(sample) shouldBe sampleResult
  }

  val inputResult = 53386

  "My input" should s"have result $inputResult" in {
    Part1.result(Day01.myList()) shouldBe inputResult
  }

}


class Part2Spec extends AnyFlatSpec with should.Matchers {

  val sample = List(
    "two1nine",
    "eightwothree",
    "abcone2threexyz",
    "xtwone3four",
    "4nineeightseven2",
    "zoneight234",
    "7pqrstsixteen"
  )

  val sampleResult = 281

  "Sample example" should s"have result $sampleResult" in {
    Part2.result(sample) shouldBe sampleResult
  }

  val inputResult = 53293

  "My input" should s"have result $inputResult" in {
    Part2.result(Day01.myList()) shouldBe inputResult
  }

}
