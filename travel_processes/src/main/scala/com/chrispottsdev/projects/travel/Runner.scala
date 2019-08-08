package com.chrispottsdev.projects.travel

/**
 * Name: Runner.scala
 * Author: ChrisPotts
 * Description: Control Singleton Object for the execution of the main classes of the problems
 */
object Runner {

  def main(args: Array[String]): Unit ={
    val action = if(args.size == 0) "DEFAULT" else args(0)
    action match {
      case "PROB1" => Problem1.main(Array[String]())
      case "PROB2" => Problem2.main(Array[String]())
      case _ => {
        Problem1.main(Array[String]())
        Problem2.main(Array[String]())
      }
    }

  }
}
