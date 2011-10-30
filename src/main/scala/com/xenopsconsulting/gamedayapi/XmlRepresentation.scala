package com.xenopsconsulting.gamedayapi

import xml.{Node, Elem}

@scala.serializable
trait XmlRepresentation {
  protected var _xml:Elem = null
  var fetchStrategy: FetchStrategy = new MlbFetchStrategy

  def xml():Elem = {
    if (_xml == null) fetch
    _xml
  }

  def fetch

  protected def attributeValueEquals(value: String)(node: Node) = node.attributes.exists(_.value.text == value)
}