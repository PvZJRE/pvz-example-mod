package io.github.pvzjre.examplemod.mixin;

import io.github.pvzjre.portable.lawn.Board;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

/**
 * Interface-style accessor mixin: the mixin engine adds this interface to {@link Board} and
 * generates the bridge implementation, so mods can read/write the game's internal state without
 * touching the game sources.
 *
 * <pre>{@code
 * Board board = ...;
 * int sun = ((BoardAccessor) (Object) board).examplemod$getSun();
 * }</pre>
 */
@Mixin(Board.class)
public interface BoardAccessor {

    @Accessor("mSunMoney")
    int examplemod$getSun();

    @Accessor("mSunMoney")
    void examplemod$setSun(int value);
}
