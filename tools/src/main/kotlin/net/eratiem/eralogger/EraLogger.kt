package net.eratiem.eralogger

import org.slf4j.Logger
import java.util.logging.Logger as JLogger

interface EraLogger {
    companion object {
        private val instances: LinkedHashMap<String, EraLogger> = linkedMapOf()

        fun getInstance(plugin: String, logger: JLogger): EraLogger =
            instances.getOrPut(plugin) { EraLoggerImpl(logger as Logger) }

        fun destroyInstance(plugin: String): Boolean =
            instances.remove(plugin) == null
    }

    var debug: Boolean
    fun debug(msg: String)
    fun info(msg: String)
    fun warning(msg: String)
    fun error(msg: String)
    fun error(msg: String, err: Throwable)
    fun severe(msg: String)
    fun severe(msg: String, err: Throwable)

    private class EraLoggerImpl(
        private val logger: Logger,
        override var debug: Boolean = false
    ) : EraLogger {
        override fun debug(msg: String) {
            if (debug)
                logger.info("DEBUG: $msg")
        }

        override fun info(msg: String) {
            logger.info(msg)
        }

        override fun warning(msg: String) {
            logger.warn(msg)
        }

        override fun error(msg: String) {
            logger.error(msg)
        }

        override fun error(msg: String, err: Throwable) {
            logger.error(msg, err)
        }

        override fun severe(msg: String) {
            logger.error(msg)
        }

        override fun severe(msg: String, err: Throwable) {
            logger.error(msg, err)
        }

    }
}