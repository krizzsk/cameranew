package com.ironsource.sdk.service;

import java.util.HashMap;
import kotlin.jvm.internal.s;
/* compiled from: AdInstanceTimingService.kt */
/* loaded from: classes2.dex */
public final class a {
    public static final a b = new a();
    private static final HashMap<String, Long> a = new HashMap<>();

    private a() {
    }

    public final boolean a(String instance, long j2) {
        s.i(instance, "instance");
        if (!(instance.length() == 0)) {
            HashMap<String, Long> hashMap = a;
            if (!hashMap.containsKey(instance)) {
                hashMap.put(instance, Long.valueOf(j2));
                return true;
            }
        }
        return false;
    }

    public final boolean b(String instance) {
        s.i(instance, "instance");
        HashMap<String, Long> hashMap = a;
        if (hashMap.get(instance) != null) {
            hashMap.remove(instance);
            return true;
        }
        return false;
    }

    public final long c(String instance) {
        s.i(instance, "instance");
        Long it = a.get(instance);
        if (it != null) {
            long currentTimeMillis = System.currentTimeMillis();
            s.d(it, "it");
            return currentTimeMillis - it.longValue();
        }
        return -1L;
    }

    public final long d(String instance) {
        s.i(instance, "instance");
        Long it = a.get(instance);
        if (it != null) {
            s.d(it, "it");
            return it.longValue();
        }
        return -1L;
    }
}
