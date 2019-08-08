package com.chrispottsdev.projects.travel

import org.scalatest.{FlatSpec, Matchers}


class Problem2Tests extends FlatSpec
  with Matchers {

  "getBestGroupPrices" should "return the Best Group Prices outlined in the requirements" in {
    val promos = DataSets.getProblem2DataSets()

    val answer1 = Problem2.combinablePromotions("P1", promos)

    answer1.size should be(2)

    val p1_p2 = answer1.filter(p => p.promotionCodes.size == 2)(0)
    val p1_p4_p5 = answer1.filter(p => p.promotionCodes.size == 3)(0)

    p1_p2.promotionCodes.contains("P1") should be(true)
    p1_p2.promotionCodes.contains("P2") should be(true)
    p1_p4_p5.promotionCodes.contains("P1") should be(true)
    p1_p4_p5.promotionCodes.contains("P4") should be(true)
    p1_p4_p5.promotionCodes.contains("P5") should be(true)

    val answer2 = Problem2.combinablePromotions("P3", promos)

    answer2.size should be(2)

    val p3_p2 = answer2.filter(p => p.promotionCodes.size == 2)(0)
    val p3_p4_p5 = answer2.filter(p => p.promotionCodes.size == 3)(0)

    p3_p2.promotionCodes.contains("P3") should be(true)
    p3_p2.promotionCodes.contains("P2") should be(true)
    p3_p4_p5.promotionCodes.contains("P3") should be(true)
    p3_p4_p5.promotionCodes.contains("P4") should be(true)
    p3_p4_p5.promotionCodes.contains("P5") should be(true)

  }

}

