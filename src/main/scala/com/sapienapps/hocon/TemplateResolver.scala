package com.sapienapps.hocon

import com.typesafe.config.{ConfigResolver, ConfigValue}
import com.typesafe.config.impl.ConfigValueFactory

trait TemplateResolver extends ConfigResolver {

  def vars: Map[String, Any]

  override def lookup(path: String): ConfigValue = {
    val value: Any = vars.get(path).orNull
    ConfigValueFactory.getValue(value)
  }

  override def withFallback(fallback: ConfigResolver): ConfigResolver = fallback

}
