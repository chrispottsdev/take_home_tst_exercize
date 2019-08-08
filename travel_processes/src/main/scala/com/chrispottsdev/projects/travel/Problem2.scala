package com.chrispottsdev.projects.travel

import scala.collection.mutable.ListBuffer

/**
 * Name: Problem2.scala
 * Author: ChrisPotts
 * Description: Singleton Object for the execution of Problem 2
 */

object Problem2 {

  def combinablePromotions( promotionCode: String,
                            allPromotions: Seq[Promotion]): Seq[PromotionCombo] ={
    //Spliting the selected promo code from the rest of the promo pool
    val (active, raw_pool) = allPromotions.partition(x => x.code == promotionCode)
    //Added some error checks for some of the possible edge cases
    if(active.size == 0){
      println("Warning: Promotion Code Not Found in promotion list")
      Seq[PromotionCombo]()
    }else if(active.size > 1){
      println("Error: List contains multiple entries with same promotion code, disambiguation error")
      Seq[PromotionCombo]()
    }else{
      //First doing some prefiltering to get rid of promos that can't be use with the selected promo
      val primeFilters = active(0).notCombinableWith
      val pos_pool = raw_pool
        .filter(x => !primeFilters.contains(x.code))
        .map( x => (x.code, x.notCombinableWith)).toMap

      //Then generation all the possible permutations of different promo combinations
      val all_perm = pos_pool.keySet.subsets.map(_.toList).toList

      //Next, filter out all invalid permutations, and sort the results in descending order of size
      val valid = all_perm.filter(s => s.size != 0).filter{
        list =>
          val excludes = list.map( x => pos_pool(x)).flatten
          //Note: for larger dataset, this approach may be non-viable due to memory concerns (intersect)
          list.intersect(excludes).size == 0
      }.sortBy(x => x.size*(-1))

      //Then, iterate though the list, adding a permutation to the final list if all of the items in that list
      //haven't already been add to the final list
      var maxCombos = new ListBuffer[List[String]]()
      valid.foreach{
        combo =>
          if(maxCombos.flatten.intersect(combo).size == 0){
            maxCombos.append(combo)
          }
      }
      //convert the list of ids to a Seq of PromotionCombo objects
      maxCombos.map(x => PromotionCombo((x.::(promotionCode)).toSeq)).toSeq
    }
  }


  def main(args: Array[String]): Unit ={
    println("-----------------Running Problem 2-------------------")
    val allPromotions = DataSets.getProblem2DataSets()
    println("Answer for P1: ")
    val answer1 = combinablePromotions("P1",allPromotions)
    answer1.foreach(println(_))
    println("Answer for P3: ")
    val answer2 = combinablePromotions("P3",allPromotions)
    answer2.foreach(println(_))
  }
}
