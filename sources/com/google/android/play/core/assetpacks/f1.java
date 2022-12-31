package com.google.android.play.core.assetpacks;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.HashMap;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class f1 {
    private final Map<String, Double> a = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized double a(String str, y1 y1Var) {
        double d2;
        d2 = (((z0) y1Var).f4844g + 1.0d) / ((z0) y1Var).f4845h;
        this.a.put(str, Double.valueOf(d2));
        return d2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void b(String str) {
        this.a.put(str, Double.valueOf((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized double c(String str) {
        Double d2 = this.a.get(str);
        if (d2 == null) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        return d2.doubleValue();
    }
}
