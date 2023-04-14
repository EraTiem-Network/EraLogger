package net.eratiem.eralogger

import com.velocitypowered.api.event.Subscribe
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent
import com.velocitypowered.api.event.proxy.ProxyShutdownEvent
import com.velocitypowered.api.plugin.Dependency
import com.velocitypowered.api.plugin.Plugin
import java.util.logging.Logger
import javax.inject.Inject

@Plugin(
    id = "eralogger",
    name = "EraLogger",
    version = "1.1.0",
    description = "Logger for EraTeam-Networks Plugins",
    authors = ["Motzkiste"],
    dependencies = [Dependency(id = "kotlinprovider")]
)
class EraLoggerPlugin @Inject constructor(
    logger: Logger
) {
    private val name = "EraLogger"
    private var logger: EraLogger = EraLogger.getInstance(name, logger)

    @Subscribe
    fun onInitialize(event: ProxyInitializeEvent) {
        logger.info("EraLogger can now be used!")
    }

    @Subscribe
    fun onShutdown(event: ProxyShutdownEvent) {
        logger.info("EraLogger disabled!")
        EraLogger.destroyInstance(name)
    }
}