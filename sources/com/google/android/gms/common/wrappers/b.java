package com.google.android.gms.common.wrappers;

import android.content.Context;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public class b {
    private static b b = new b();
    private PackageManagerWrapper a = null;

    public static PackageManagerWrapper a(Context context) {
        return b.b(context);
    }

    private final synchronized PackageManagerWrapper b(Context context) {
        if (this.a == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.a = new PackageManagerWrapper(context);
        }
        return this.a;
    }
}
