package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* renamed from: com.facebook.ads.redexgen.X.Kn  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0974Kn {
    public static final Set<Object> A00 = Collections.newSetFromMap(new WeakHashMap());
    public static final AtomicBoolean A01 = new AtomicBoolean(true);
    public static final AtomicReference<InterfaceC0972Kl> A02 = new AtomicReference<>();

    @SuppressLint({"RethrownThrowableArgument"})
    public static void A00(Throwable th, Object obj) throws Throwable {
        if (A01.get()) {
            A00.add(obj);
            L2.A00().A8g(3306, th);
            InterfaceC0972Kl interfaceC0972Kl = A02.get();
            if (interfaceC0972Kl != null) {
                interfaceC0972Kl.ADg(th, obj);
                return;
            }
            return;
        }
        throw th;
    }

    public static void A01(boolean z, InterfaceC0972Kl interfaceC0972Kl) {
        A01.set(z);
        A02.set(interfaceC0972Kl);
    }

    public static boolean A02(Object obj) {
        return A00.contains(obj);
    }
}
