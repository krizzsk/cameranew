package com.tapjoy.internal;

import android.content.Context;
import com.tapjoy.TJPlacementListener;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public abstract class gc {
    private static final gc a;
    private static gc b;

    static {
        gd gdVar = new gd();
        a = gdVar;
        b = gdVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static gc a() {
        return b;
    }

    public abstract Object a(Context context, String str, TJPlacementListener tJPlacementListener);

    public abstract Object b();
}
