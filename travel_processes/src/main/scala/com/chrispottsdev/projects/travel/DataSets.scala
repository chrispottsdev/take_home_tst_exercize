package com.chrispottsdev.projects.travel

/**
 * Name: DataSets.scala
 * Author: ChrisPotts
 * Description: Object Singleton created to house the creation of the test datasets
 */

object DataSets {

  def getProblem1DataSets():(Seq[Rate], Seq[CabinPrice]) ={
    val rates = Seq(
      Rate("M1", "Military"),
      Rate("M2", "Military"),
      Rate("S1", "Senior"),
      Rate("S2", "Senior"))

    val cabinPrice = Seq(
      CabinPrice("CA", "M1", 200.00),
      CabinPrice("CA", "M2", 250.00),
      CabinPrice("CA", "S1", 225.00),
      CabinPrice("CA", "S2", 260.00),
      CabinPrice("CB", "M1", 230.00),
      CabinPrice("CB", "M2", 260.00),
      CabinPrice("CB", "S1", 245.00),
      CabinPrice("CB", "S2", 270.00))

    (rates, cabinPrice)
  }

  def getProblem2DataSets():Seq[Promotion] ={
    Seq(Promotion("P1", Seq("P3")),
      Promotion("P2", Seq("P4", "P5")),
      Promotion("P3", Seq("P1")),
      Promotion("P4", Seq("P2")),
      Promotion("P5", Seq("P2")))
  }
}
