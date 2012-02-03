package com.xenopsconsulting.gamedayapi

import xml.Node

case class Pitcher(pitcherNode: Node) {
  def id() = pna("@id")
  def name() = pna("@name")
  def nameDisplayFirstLast() = pna("@name_display_first_last")
  def pos() = pna("@pos")
  def out() = pna("@out")
  def bf() = pna("@bf")
  def er() = pna("@er")
  def r() = pna("@r")
  def h() = pna("@h")
  def so() = pna("@so")
  def hr() = pna("@hr")
  def bb() = pna("@bb")
  def w() = pna("@w")
  def l() = pna("@l")
  def sv() = pna("@sv")
  def bs() = pna("@bs")
  def hld() = pna("@hld")
  def era() = pna("@era")
  def note() = pna("@note")

  def inningsPitched() = {
    val actual_innings = (out.toDouble / 3)
    val whole_inning = actual_innings.toInt.toString
    val inning_part = actual_innings.toString.split("""\.""").tail.head.first.toString
    inning_part match {
      case "3" => whole_inning + " 1/3"
      case "6" => whole_inning + " 2/3"
      case _ => whole_inning
    }
  }

  private def pna(attribute: String) = (pitcherNode \ attribute).text
}
