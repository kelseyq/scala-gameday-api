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
  var strategy: TestFetchStrategy = _

  @Before def initialize() {
    date = new SimpleDateFormat("yyy-MM-dd").parse("2011-08-13")
    team = "sea"
    strategy = new TestFetchStrategy
  }

  @Test def testEpgUrlGeneration() {
    assertEquals("http://gd2.mlb.com/components/game/mlb/year_2011/month_08/day_13/epg.xml", strategy.epgUrl(date))
  }

  @Test def testGameUrlGeneration() {
    assertEquals("http://gd2.mlb.com/components/game/mlb/year_2011/month_08/day_13/gid_2011_08_13_bosmlb_seamlb_1" +
      "/game.xml", strategy.gameUrl(date, team))
  }

  @Test def testBoxScoreUrlGeneration() {
    assertEquals("http://gd2.mlb.com/components/game/mlb/year_2011/month_08/day_13/gid_2011_08_13_bosmlb_seamlb_1" +
      "/boxscore.xml", strategy.boxScoreUrl(date, team))
  }
  
  @Test def testLineScoreUrlGeneration() {
    assertEquals("http://gd2.mlb.com/components/game/mlb/year_2011/month_08/day_13/gid_2011_08_13_bosmlb_seamlb_1" +
      "/linescore.xml", strategy.lineScoreUrl(date, team))
  }
}



