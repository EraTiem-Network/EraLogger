package net.eratiem.eralogger

import net.md_5.bungee.api.plugin.Plugin

class EraLoggerPlugin : Plugin() {
    override fun onEnable() {
        logger.info("EraLogger can now be used!")
    }

    override fun onDisable() {
        logger.info("EraLogger disabled!")
    }
}