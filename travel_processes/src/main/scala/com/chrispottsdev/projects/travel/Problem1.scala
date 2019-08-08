package com.chrispottsdev.projects.travel

/**
 * Name: Problem1.scala
 * Author: ChrisPotts
 * Description: Singleton Object for the execution of Problem 1
 */
object Problem1 {

  //method for use with later reduceLeft in order to find the minimum price in the grouped list of prices
  def minPrice(p1: CabinPrice, p2: CabinPrice): CabinPrice ={
    if (p1.price < p2.price){
      p1
    }else{
      p2
    }
  }

  def getBestGroupPrices(rates: Seq[Rate], prices: Seq[CabinPrice]): Seq[BestGroupPrice] = {
    //Turning the rates into a Map of rateCodes -> rateGroups for easier access later
    val codeGroupMap = rates.map(x => (x.rateCode, x.rateGroup)).toMap

    //grouping the CabinPrices by cabinCode and their corresponding rateGroup
    val grouped = prices.groupBy(x => (x.cabinCode, codeGroupMap.getOrElse(x.rateCode,"MISSING")))

    //using reduceLeft and the above minPrice to filter the prices down to the min price per group
    val filterToMin = grouped.map(grp => (grp._1, (grp._2.reduceLeft(minPrice))))

    //converting the collection of data to the correct datatype for the return
    filterToMin.map{case(keys, price) => BestGroupPrice(price.cabinCode,
      price.rateCode,
      price.price,
      keys._2)}.toSeq
  }

  def main(args: Array[String]): Unit ={
    println("-----------------Running Problem 1-------------------")
    val (rates, cabinPrice) = DataSets.getProblem1DataSets()
    val answer = getBestGroupPrices(rates, cabinPrice)
    println("Answer: ")
    answer.foreach(println(_))
  }
}
