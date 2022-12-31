package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Looper;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class da {
    /* JADX INFO: Access modifiers changed from: package-private */
    public da(Context context) {
    }

    public static final boolean a() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}
