package com.google.firebase.analytics.ktx;

import android.os.Bundle;
import kotlin.jvm.internal.s;
/* compiled from: com.google.firebase:firebase-analytics-ktx@@18.0.2 */
/* loaded from: classes2.dex */
public final class ParametersBuilder {
    private final Bundle zza = new Bundle();

    public final Bundle getBundle() {
        return this.zza;
    }

    public final void param(String key, double d2) {
        s.h(key, "key");
        this.zza.putDouble(key, d2);
    }

    public final void param(String key, long j2) {
        s.h(key, "key");
        this.zza.putLong(key, j2);
    }

    public final void param(String key, String value) {
        s.h(key, "key");
        s.h(value, "value");
        this.zza.putString(key, value);
    }

    public final void param(String key, Bundle value) {
        s.h(key, "key");
        s.h(value, "value");
        this.zza.putBundle(key, value);
    }

    public final void param(String key, Bundle[] value) {
        s.h(key, "key");
        s.h(value, "value");
        this.zza.putParcelableArray(key, value);
    }
}
