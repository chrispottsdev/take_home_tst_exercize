package com.chrispottsdev.projects.travel

/**
 * Name: DataStructures.scala
 * Author: ChrisPotts
 * Description: Scala File setup to contain all the case classes for the exercise
 */

case class Rate(rateCode: String, rateGroup: String)

case class CabinPrice(cabinCode: String,
                      rateCode: String,
                      price: BigDecimal)

case class BestGroupPrice(cabinCode: String,
                          rateCode: String,
                          price: BigDecimal,
                          rateGroup: String)

case class Promotion(code: String, notCombinableWith: Seq[String])

case class PromotionCombo(promotionCodes: Seq[String])

