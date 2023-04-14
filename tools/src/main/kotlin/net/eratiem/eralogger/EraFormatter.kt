package net.eratiem.eralogger

import java.util.logging.Formatter
import java.util.logging.LogRecord

internal class EraFormatter : Formatter() {
  override fun format(record: LogRecord?): String {
    return "TEST"
  }
}