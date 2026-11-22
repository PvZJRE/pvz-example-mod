package io.github.pvzjre.examplemod.mixin;

import io.github.pvzjre.examplemod.ExampleMod;
import io.github.pvzjre.portable.lawn.LawnCommon;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Demonstrates a {@code @Inject} into a static game method.
 *
 * <p>The injected code runs the first time {@code LawnCommon.modInRange(int, int)} is called, which
 * is an asset-free entry point, so the integration test can prove that the mixin engine really
 * transformed a game class loaded through the mod class loader.
 */
@Mixin(LawnCommon.class)
public final class LawnCommonMixin {

    private LawnCommonMixin() {
    }

    @Inject(method = "modInRange(II)Z", at = @At("HEAD"))
    private static void examplemod$markMixinApplied(int theNumber, int theMod,
            CallbackInfoReturnable<Boolean> cir) {
        ExampleMod.mixinApplied = true;
    }
}
