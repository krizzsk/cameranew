package com.google.android.gms.common.util;

import android.os.Looper;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public final class y {
    public static boolean a() {
        return Looper.getMainLooper() == Looper.myLooper();
    }
}