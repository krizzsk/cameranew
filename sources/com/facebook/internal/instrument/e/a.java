package com.facebook.internal.instrument.e;

import com.facebook.f;
import com.facebook.internal.instrument.InstrumentData;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
/* compiled from: CrashShieldHandler.java */
/* loaded from: classes.dex */
public class a {
    private static final Set<Object> a = Collections.newSetFromMap(new WeakHashMap());
    private static boolean b = false;

    public static void a() {
        b = true;
    }

    public static void b(Throwable th, Object obj) {
        if (b) {
            a.add(obj);
            if (f.k()) {
                com.facebook.internal.instrument.a.b(th);
                InstrumentData.b.a(th, InstrumentData.Type.CrashShield).h();
            }
            d(th);
        }
    }

    public static boolean c(Object obj) {
        return a.contains(obj);
    }

    private static void d(Throwable th) {
    }
}
