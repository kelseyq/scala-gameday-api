package com.xenopsconsulting.gamedayapi

import xml.Node

case class Inning(inningNode: Node, game: Game = null) {

  def top() = {
    try {
      Some(HalfInning((inningNode \ "top").head, this))
    } catch {
      case e => {
        None
      }
    }
  }

  def bottom() = {
    try {
      Some(HalfInning((inningNode \ "bottom").head, this))
    } catch {
      case e => {
        None
      }
    }
  }

  def num = (inningNode \ "@num").text
  def homeTeam = (inningNode \ "@home_team").text
  def awayTeam = (inningNode \ "@away_team").text
  def next = (inningNode \ "@next").text

  /**
   * A convenience method for accessing all at-bats in the inning by both teams, in
   * the order in which they occurred.
   *
   * @return A list of AtBat objects
   */
  def atBats() = {
    top.map(_.atBats).getOrElse(Nil) ++ bottom.map(_.atBats).getOrElse(Nil)
  }

  /**
   * A convenience method for accessing all pitches thrown in the inning by both teams, in
   * the order in which they were thrown.
   *
   * @return A list of Pitch objects
   */
  def pitches() = {
    atBats.flatMap(_.pitches)
  }

}
