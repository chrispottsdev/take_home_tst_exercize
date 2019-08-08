package com.chrispottsdev.projects.travel

import org.scalatest.{FlatSpec, Matchers}


class Problem1Tests extends FlatSpec
  with Matchers {

  "minPrice" should "return the CabinPrice obj with the smallest price" in {
    val cp1 = CabinPrice("CA", "M1", 200.00)
    val cp2 = CabinPrice("CB", "M2", 250.00)

    Problem1.minPrice(cp1,cp2).price should be(200.00)
    Problem1.minPrice(cp2,cp1).price should be(200.00)
  }

  "getBestGroupPrices" should "return the Best Group Prices outlined in the requirements" in {
    val (rates, cabinPrice) = DataSets.getProblem1DataSets()

    val answer = Problem1.getBestGroupPrices(rates, cabinPrice)

    answer.size should be(4)

    val ca_m1_mil = answer.filter(x => (x.price==200))(0)
    val ca_s1_sen = answer.filter(x => (x.price==225))(0)
    val cb_m1_mil = answer.filter(x => (x.price==230))(0)
    val cb_s1_sen = answer.filter(x => (x.price==245))(0)

    ca_m1_mil.cabinCode should be("CA")
    ca_m1_mil.rateCode should be("M1")
    ca_m1_mil.rateGroup should be("Military")

    ca_s1_sen.cabinCode should be("CA")
    ca_s1_sen.rateCode should be("S1")
    ca_s1_sen.rateGroup should be("Senior")

    cb_m1_mil.cabinCode should be("CB")
    cb_m1_mil.rateCode should be("M1")
    cb_m1_mil.rateGroup should be("Military")

    cb_s1_sen.cabinCode should be("CB")
    cb_s1_sen.rateCode should be("S1")
    cb_s1_sen.rateGroup should be("Senior")

  }

}

