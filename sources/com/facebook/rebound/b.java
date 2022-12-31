package com.facebook.rebound;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
/* compiled from: OrigamiValueConverter.java */
/* loaded from: classes9.dex */
public class b {
    public static double a(double d2) {
        return d2 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : 25.0d + ((d2 - 8.0d) * 3.0d);
    }

    public static double b(double d2) {
        return d2 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : 194.0d + ((d2 - 30.0d) * 3.62d);
    }
}
