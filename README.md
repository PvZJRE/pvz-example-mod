# pvz-example-mod

PvZ-Portable 的参考模组（独立 Gradle 项目），演示模组作者可用的两类能力：

- **事件**：`ExampleMod` 实现 `net.fabricmc.api.ModInitializer`，监听 `LawnEvents.SUN_COLLECTED`（阳光翻倍）、`PLANT_PLACED`、`ZOMBIE_DEATH`、`LEVEL_START`；
- **Mixin**：`LawnCommonMixin`（静态方法 `modInRange(II)Z` 的 HEAD 注入）、`BoardMixin`（`Board.update()V` 注入 + `@Shadow mSunMoney`）、`BoardAccessor`（为 `Board` 生成的 `@Accessor` 访问器接口）。

## 构建与发布

```bash
./gradlew build publishToMavenLocal   # 发布 io.github.pvzjre:pvz-example-mod:1.1.0
```

构建文件 = 工具链插件加坐标（`plugins { id("io.github.pvzjre.loom") version "1.0.16" }`）：插件从 mavenLocal 或 Gradle Plugin Portal 解析，它把真正的 Fabric Loader、Mixin、ASM、API 与本游戏放上编译类路径，而本项目不列其中任何一项。`./gradlew runClient` 是开发运行：模组自身产物与 API 聚合 jar 在类路径上，loader 以开发模式发现该模组。

## 安装

把 jar 放进游戏目录的 `mods/` 即可。游戏由真正的 Fabric Loader 通过 `KnotClient` 与游戏 jar 携带的 provider 一起启动；loader 在启动时自动发现该 jar。`PvZ-Portable` 的端到端测试也会从 mavenLocal 拉取此构件放进 `build/testmods/`，验证事件链与字节码注入。

## 许可证

MIT（见 `LICENSE`）。游戏本体 `PvZ-Portable` 为 LGPL-3.0-or-later 与 PopCap 框架许可证。
