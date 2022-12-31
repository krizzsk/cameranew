package com.facebook.appevents;

import android.content.Context;
import java.util.HashMap;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppEventCollection.java */
/* loaded from: classes.dex */
public class b {
    private final HashMap<AccessTokenAppIdPair, h> a = new HashMap<>();

    private synchronized h e(AccessTokenAppIdPair accessTokenAppIdPair) {
        h hVar;
        hVar = this.a.get(accessTokenAppIdPair);
        if (hVar == null) {
            Context f2 = com.facebook.f.f();
            hVar = new h(com.facebook.internal.b.h(f2), AppEventsLogger.c(f2));
        }
        this.a.put(accessTokenAppIdPair, hVar);
        return hVar;
    }

    public synchronized void a(AccessTokenAppIdPair accessTokenAppIdPair, AppEvent appEvent) {
        e(accessTokenAppIdPair).a(appEvent);
    }

    public synchronized void b(PersistedEvents persistedEvents) {
        if (persistedEvents == null) {
            return;
        }
        for (AccessTokenAppIdPair accessTokenAppIdPair : persistedEvents.keySet()) {
            h e2 = e(accessTokenAppIdPair);
            for (AppEvent appEvent : persistedEvents.get(accessTokenAppIdPair)) {
                e2.a(appEvent);
            }
        }
    }

    public synchronized h c(AccessTokenAppIdPair accessTokenAppIdPair) {
        return this.a.get(accessTokenAppIdPair);
    }

    public synchronized int d() {
        int i2;
        i2 = 0;
        for (h hVar : this.a.values()) {
            i2 += hVar.c();
        }
        return i2;
    }

    public synchronized Set<AccessTokenAppIdPair> f() {
        return this.a.keySet();
    }
}
