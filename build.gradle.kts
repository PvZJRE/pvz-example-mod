// The mod toolchain of this workspace: applying io.github.pvzjre.loom supplies the game
// distribution (the game, the API modules, the real Fabric Loader and Mixin, ASM, SLF4J/Log4j and
// LWJGL, on the compile, test and launch class paths), the launcher class path and JUnit for the
// tests, the runClient task and the publication of the mod jar under mavenLocal coordinates. A mod
// never declares any of those artifacts by hand; see loom.
//
// The version is the plugin's own (every artifact of this workspace is released under one number); the
// plugin itself resolves from the Gradle Plugin Portal, which serves it (settings.gradle.kts lists the
// portal first and keeps mavenLocal after it as an optional fallback for a version the portal does not
// serve yet).
plugins {
    id("io.github.pvzjre.loom") version "1.0.16"
}

dependencies {
    pvz("io.github.pvzjre:pvz-portable:1.2.5")
    // the workspace API the mod is written against (the events the example hooks into)
    compileOnly("io.github.pvzjre:api-events:1.2.2")
    compileOnly("io.github.pvzjre:api-base:1.2.2")
}

group = "io.github.pvzjre"
version = "1.1.0"
description = "Example mod for the pvz-fabric toolchain (API events + mixins)"
