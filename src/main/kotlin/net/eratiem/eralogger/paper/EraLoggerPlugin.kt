package net.eratiem.eralogger.paper

import net.eratiem.eralogger.tools.EraLogger
import org.bukkit.plugin.java.JavaPlugin
import org.slf4j.Logger

class EraLoggerPlugin : JavaPlugin() {
    private lateinit var logger: EraLogger

    override fun onEnable() {
        logger = EraLogger.getInstance(name, getLogger() as Logger)
        logger.info("EraLogger can now be used!")
    }

    override fun onDisable() {
        logger.info("EraLogger disabled!")
        if (this::logger.isInitialized)
            EraLogger.destroyInstance(name)
    }
}