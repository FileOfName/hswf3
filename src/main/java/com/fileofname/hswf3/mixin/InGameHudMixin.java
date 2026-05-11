package com.fileofname.hswf3.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Gui.class)
public class InGameHudMixin {
	@Shadow
	private Minecraft minecraft;

	@Inject(at = @At("HEAD"), method = "displayScoreboardSidebar", cancellable = true)
	private void hideScoreboard(final CallbackInfo info) {
		if (minecraft.getDebugOverlay().showDebugScreen()) info.cancel();
	}
}