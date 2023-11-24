package com.kneelawk.classicsavefixer;

import nilloader.api.ClassTransformer;
import nilloader.api.NilLogger;

public class ClassicSaveFixerPremain implements Runnable {
    public static final NilLogger log = NilLogger.get("ClassicSaveFixer");
    @Override
    public void run() {
        ClassTransformer.register(new LoadLevelScreenTransformer());
    }
}
