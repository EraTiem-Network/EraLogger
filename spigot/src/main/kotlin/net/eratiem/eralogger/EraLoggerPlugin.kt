package net.eratiem.eralogger

import org.bukkit.plugin.java.JavaPlugin

class EraLoggerPlugin : JavaPlugin() {
    private lateinit var logger: EraLogger

    override fun onEnable() {
        logger = EraLogger.getInstance(name, getLogger())
        logger.info("EraLogger can now be used!")
    }

    override fun onDisable() {
        logger.info("EraLogger disabled!")
        if (this::logger.isInitialized)
            EraLogger.destroyInstance(name)
    }
}