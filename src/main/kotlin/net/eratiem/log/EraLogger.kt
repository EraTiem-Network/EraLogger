package net.eratiem.log

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class EraLogger private constructor(private val module: String) {
    companion object {
        private var application: String = "MainApplication"
        private val timeFormat: DateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyy | HH:mm:ss,SSS")


        @JvmStatic
        fun setApplicationName(name: String) {
            this.application = name
        }

        @JvmStatic
        fun createLogModule(name: String): EraLogger {
            return EraLogger(name)
        }

        /**
         * Main log method that is also used by the modules
         */
        private fun log(level: EraLogLevel, module: String?, msg: String) {
            println("[${LocalDateTime.now().format(timeFormat)}] [$level] [$application] ${module?.plus(": ") ?: ""}$msg")
        }

        fun log(level: EraLogLevel, msg: String) {
            log(level, null, msg)
        }

        fun trace(msg: String) {
            log(EraLogLevel.TRACE, msg)
        }

        fun debug(msg: String) {
            log(EraLogLevel.DEBUG, msg)
        }

        fun info(msg: String) {
            log(EraLogLevel.INFO, msg)
        }

        fun warn(msg: String) {
            log(EraLogLevel.WARN, msg)
        }

        fun error(msg: String) {
            log(EraLogLevel.ERROR, msg)
        }

        fun fatal(msg: String) {
            log(EraLogLevel.FATAL, msg)
        }
    }

    fun log(level: EraLogLevel, msg: String) {
        Companion.log(level, module, msg)
    }

    fun trace(msg: String) {
        log(EraLogLevel.TRACE, msg)
    }

    fun debug(msg: String) {
        log(EraLogLevel.DEBUG, msg)
    }

    fun info(msg: String) {
        log(EraLogLevel.INFO, msg)
    }

    fun warn(msg: String) {
        log(EraLogLevel.WARN, msg)
    }

    fun error(msg: String) {
        log(EraLogLevel.ERROR, msg)
    }

    fun fatal(msg: String) {
        log(EraLogLevel.FATAL, msg)
    }

    enum class EraLogLevel {
        TRACE, DEBUG, INFO, WARN, ERROR, FATAL;

        override fun toString(): String {
            return String.format("%-5s", this.name)
        }
    }
}