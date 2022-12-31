package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.common.util.d;
/* loaded from: classes2.dex */
final /* synthetic */ class ConfigGetParameterHandler$$Lambda$1 implements Runnable {
    private final d arg$1;
    private final String arg$2;
    private final ConfigContainer arg$3;

    private ConfigGetParameterHandler$$Lambda$1(d dVar, String str, ConfigContainer configContainer) {
        this.arg$1 = dVar;
        this.arg$2 = str;
        this.arg$3 = configContainer;
    }

    public static Runnable lambdaFactory$(d dVar, String str, ConfigContainer configContainer) {
        return new ConfigGetParameterHandler$$Lambda$1(dVar, str, configContainer);
    }

    @Override // java.lang.Runnable
    public void run() {
        ConfigGetParameterHandler.lambda$callListeners$0(this.arg$1, this.arg$2, this.arg$3);
    }
}
