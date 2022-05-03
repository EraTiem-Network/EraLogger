package net.eratiem.log

import net.eratiem.log.EraLogger.EraLogLevel
import kotlin.test.Test

internal class EraLoggerTest {

    @Test
    fun testLogger() {
        EraLogger.setApplicationName(this::class.java.simpleName)

        val testLoggerModule: EraLogger = EraLogger.createLogModule("TestLoggerModule1")

        val logLevels: Array<EraLogLevel> = EraLogLevel.values()

        for (i in 1..10) {
            for (logLevel in logLevels) {
                testLoggerModule.log(logLevel, "test")
                EraLogger.log(logLevel, "test")
            }
        }
    }
}