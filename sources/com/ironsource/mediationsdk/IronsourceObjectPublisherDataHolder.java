package com.ironsource.mediationsdk;

import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class IronsourceObjectPublisherDataHolder {
    private static IronsourceObjectPublisherDataHolder c;
    private final HashSet<com.ironsource.mediationsdk.l0.c> a = new HashSet<>();
    private ConcurrentHashMap<String, List<String>> b = new ConcurrentHashMap<>();

    IronsourceObjectPublisherDataHolder() {
    }

    public static synchronized IronsourceObjectPublisherDataHolder getInstance() {
        IronsourceObjectPublisherDataHolder ironsourceObjectPublisherDataHolder;
        synchronized (IronsourceObjectPublisherDataHolder.class) {
            if (c == null) {
                c = new IronsourceObjectPublisherDataHolder();
            }
            ironsourceObjectPublisherDataHolder = c;
        }
        return ironsourceObjectPublisherDataHolder;
    }

    public HashSet<com.ironsource.mediationsdk.l0.c> a() {
        return this.a;
    }

    public ConcurrentHashMap<String, List<String>> b() {
        return this.b;
    }
}
