package net.eratiem.eralogger

import java.util.logging.Handler
import java.util.logging.LogRecord

internal class EraHandler : Handler() {

  init {
    formatter = EraFormatter()
  }

  override fun publish(record: LogRecord?) {
    println("EraLogger: ${record?.message}")
  }

  override fun flush() {}

  override fun close() {}
}