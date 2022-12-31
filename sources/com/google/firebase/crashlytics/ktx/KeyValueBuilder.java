package com.google.firebase.crashlytics.ktx;

import com.google.firebase.crashlytics.FirebaseCrashlytics;
import kotlin.jvm.internal.s;
/* compiled from: KeyValueBuilder.kt */
/* loaded from: classes2.dex */
public final class KeyValueBuilder {
    private final FirebaseCrashlytics crashlytics;

    public KeyValueBuilder(FirebaseCrashlytics crashlytics) {
        s.i(crashlytics, "crashlytics");
        this.crashlytics = crashlytics;
    }

    public final void key(String key, boolean z) {
        s.i(key, "key");
        this.crashlytics.setCustomKey(key, z);
    }

    public final void key(String key, double d2) {
        s.i(key, "key");
        this.crashlytics.setCustomKey(key, d2);
    }

    public final void key(String key, float f2) {
        s.i(key, "key");
        this.crashlytics.setCustomKey(key, f2);
    }

    public final void key(String key, int i2) {
        s.i(key, "key");
        this.crashlytics.setCustomKey(key, i2);
    }

    public final void key(String key, long j2) {
        s.i(key, "key");
        this.crashlytics.setCustomKey(key, j2);
    }

    public final void key(String key, String value) {
        s.i(key, "key");
        s.i(value, "value");
        this.crashlytics.setCustomKey(key, value);
    }
}
