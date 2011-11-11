package com.xenopsconsulting.gamedayapi

import scala.xml._
import dispatch._
import java.util.Date

object MlbFetchStrategy extends FetchStrategy {
  val http = new Http

  def fetchEpg(date: Date) = {
    XML.loadString(http(url(epgUrl(date)) as_str))
  }

  def fetchGame(date: Date, team: String) = {
    XML.loadString(http(url(gameUrl(date, team)) as_str))
  }

  def fetchBoxScore(date: Date, team: String) = {
    XML.loadString(http(url(boxScoreUrl(date, team)) as_str))
  }

  def fetchLineScore(date: Date, team: String) = {
    XML.loadString(http(url(lineScoreUrl(date, team)) as_str))
  }

  def fetchHitChart(date: Date, team: String) = {
    XML.loadString(http(url(hitChartUrl(date, team)) as_str))
  }

}
