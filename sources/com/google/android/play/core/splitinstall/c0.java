package com.google.android.play.core.splitinstall;

import android.content.Context;
/* loaded from: classes2.dex */
public final class c0 {
    private static d0 a;

    private c0() {
    }

    public static synchronized d0 a(Context context) {
        d0 d0Var;
        synchronized (c0.class) {
            if (a == null) {
                t tVar = new t(null);
                tVar.b(new p0(com.google.android.play.core.splitcompat.q.a(context)));
                a = tVar.a();
            }
            d0Var = a;
        }
        return d0Var;
    }
}
