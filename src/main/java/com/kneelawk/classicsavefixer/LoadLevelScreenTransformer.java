package com.kneelawk.classicsavefixer;

import nilloader.api.lib.mini.MiniTransformer;
import nilloader.api.lib.mini.PatchContext;
import nilloader.api.lib.mini.annotation.Patch;

import com.mojang.minecraft.gui.LoadLevelScreen;

@Patch.Class("com.mojang.minecraft.gui.LoadLevelScreen")
public class LoadLevelScreenTransformer extends MiniTransformer {
    public static class Hooks {
        public static void onRun(LoadLevelScreen screen) {
            ClassicSaveFixerPremain.log.info("Fixing load/save dialog...");
            screen.o = true;
        }
    }

    @Patch.Method("run()V")
    public void patchRun(PatchContext ctx) {
        // prevent LoadLevelScreen from attempting to contact minecraft.net while also fixing the load/save dialog
        ctx.jumpToStart();
        ctx.add(
            ALOAD(0),
            INVOKESTATIC("com/kneelawk/classicsavefixer/LoadLevelScreenTransformer$Hooks", "onRun",
                "(Lcom/mojang/minecraft/gui/LoadLevelScreen;)V"),
            RETURN()
        );
    }
}
