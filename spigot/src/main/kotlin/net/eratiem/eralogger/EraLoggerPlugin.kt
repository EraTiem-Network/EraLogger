package net.eratiem.eralogger

import org.bukkit.plugin.java.JavaPlugin

class EraLoggerPlugin : JavaPlugin() {
    override fun onEnable() {
        logger.info("EraLogger can now be used!")
    }

    override fun onDisable() {
        logger.info("EraLogger disabled!")
    }
}