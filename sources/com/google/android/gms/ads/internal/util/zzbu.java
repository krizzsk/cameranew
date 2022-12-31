package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@TargetApi(17)
/* loaded from: classes2.dex */
public final class zzbu {
    private static zzbu b;
    String a;

    private zzbu() {
    }

    public static zzbu zzzr() {
        if (b == null) {
            b = new zzbu();
        }
        return b;
    }
}
