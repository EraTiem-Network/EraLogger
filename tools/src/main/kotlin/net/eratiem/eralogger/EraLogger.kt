package net.eratiem.eralogger

import java.util.logging.Logger


fun Logger.addToEraLogger() {
  addHandler(EraHandler())
}