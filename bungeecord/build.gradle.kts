plugins {
  alias(libs.plugins.run.waterfall)
}

dependencies {
  compileOnly(libs.minecraft.proxy.bungeecord)
}

tasks.runWaterfall {
  waterfallVersion("1.19")
}