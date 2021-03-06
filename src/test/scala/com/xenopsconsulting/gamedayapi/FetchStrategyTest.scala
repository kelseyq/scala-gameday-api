package com.xenopsconsulting.gamedayapi

import org.scalatest.junit.AssertionsForJUnit
import org.junit.Test
import org.junit.Assert._
import org.junit.Before
import java.text.SimpleDateFormat
import java.util.Date

class FetchStrategyTest extends AssertionsForJUnit {
  var date: Date = _
  var team: String = _

  @Before def initialize() {
    date = new SimpleDateFormat("yyy-MM-dd").parse("2011-08-13")
    team = "sea"
  }

  @Test def testEpgUrlGeneration() {
    val epgUrl = TestFetchStrategy.epgUrl(date)
    assertEquals("http://gd2.mlb.com/components/game/mlb/year_2011/month_08/day_13/epg.xml", epgUrl)
  }

  @Test def testGameUrlGeneration() {
    val gameUrl = TestFetchStrategy.gameUrl(date, team)
    assertEquals("http://gd2.mlb.com/components/game/mlb/year_2011/month_08/day_13/gid_2011_08_13_bosmlb_seamlb_1/game.xml", gameUrl)
  }

  @Test def testBoxScoreUrlGeneration() {
    val boxScoreUrl = TestFetchStrategy.boxScoreUrl(date, team)
    assertEquals("http://gd2.mlb.com/components/game/mlb/year_2011/month_08/day_13/gid_2011_08_13_bosmlb_seamlb_1/boxscore.xml", boxScoreUrl)
  }
  
  @Test def testLineScoreUrlGeneration() {
    val lineScoreUrl = TestFetchStrategy.lineScoreUrl(date, team)
    assertEquals("http://gd2.mlb.com/components/game/mlb/year_2011/month_08/day_13/gid_2011_08_13_bosmlb_seamlb_1/linescore.xml", lineScoreUrl)
  }
}



