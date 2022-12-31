package com.tapjoy.internal;

import android.app.Activity;
/* loaded from: classes3.dex */
public abstract class gt {
    protected static gt a;

    public static void b(Activity activity) {
        gt gtVar = a;
        if (gtVar != null) {
            gtVar.a(activity);
        }
    }

    public abstract void a(Activity activity);
}
