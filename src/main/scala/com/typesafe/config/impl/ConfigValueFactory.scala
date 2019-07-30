package com.typesafe.config.impl

import com.typesafe.config.ConfigOrigin
import com.typesafe.config.impl.ConfigString.Quoted

/**
 * A simple config value factory to expose Typesafe's Config Objects
 */
object ConfigValueFactory {

  /**
   * Simple matcher based on instance of the value
   * @param value - to be converted to a Typesafe config type
   * @return
   */
  def getValue(value: Any) : AbstractConfigValue = {
    value match {
      case v: String => quoted(v)
      case v: Int => configInt(v)
      case v: Long => configLong(v)
      case v: Double => configDouble(v)
      case v: Float => configDouble(v)
      case v if v == null => configNull()
    }
  }

  def quoted(value: String, origin: Option[ConfigOrigin] = None) : Quoted = {
    new Quoted(origin.orNull, value)
  }

  def configInt(value: Int, originalText: Option[String] = None, origin: Option[ConfigOrigin] = None) : ConfigInt = {
    new ConfigInt(origin.orNull, value, originalText.orNull)
  }

  def configLong(value: Long,  originalText: Option[String] = None, origin: Option[ConfigOrigin] = None) : ConfigLong = {
    new ConfigLong(origin.orNull, value, originalText.orNull)
  }

  def configDouble(value: Double, originalText: Option[String] = None, origin: Option[ConfigOrigin] = None) : ConfigDouble = {
    new ConfigDouble(origin.orNull, value, originalText.orNull)
  }

  def configNull(origin: Option[ConfigOrigin] = None) : ConfigNull = {
    new ConfigNull(origin.orNull)
  }
}
