package com.facebook.appevents;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
class PersistedEvents implements Serializable {
    private static final long serialVersionUID = 20160629001L;
    private HashMap<AccessTokenAppIdPair, List<AppEvent>> events;

    /* loaded from: classes.dex */
    static class SerializationProxyV1 implements Serializable {
        private static final long serialVersionUID = 20160629001L;
        private final HashMap<AccessTokenAppIdPair, List<AppEvent>> proxyEvents;

        private Object readResolve() {
            return new PersistedEvents(this.proxyEvents);
        }

        private SerializationProxyV1(HashMap<AccessTokenAppIdPair, List<AppEvent>> hashMap) {
            this.proxyEvents = hashMap;
        }
    }

    public PersistedEvents() {
        this.events = new HashMap<>();
    }

    private Object writeReplace() {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return null;
        }
        try {
            return new SerializationProxyV1(this.events);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
            return null;
        }
    }

    public void addEvents(AccessTokenAppIdPair accessTokenAppIdPair, List<AppEvent> list) {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            if (!this.events.containsKey(accessTokenAppIdPair)) {
                this.events.put(accessTokenAppIdPair, list);
            } else {
                this.events.get(accessTokenAppIdPair).addAll(list);
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }

    public boolean containsKey(AccessTokenAppIdPair accessTokenAppIdPair) {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return false;
        }
        try {
            return this.events.containsKey(accessTokenAppIdPair);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
            return false;
        }
    }

    public List<AppEvent> get(AccessTokenAppIdPair accessTokenAppIdPair) {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return null;
        }
        try {
            return this.events.get(accessTokenAppIdPair);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
            return null;
        }
    }

    public Set<AccessTokenAppIdPair> keySet() {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return null;
        }
        try {
            return this.events.keySet();
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
            return null;
        }
    }

    public PersistedEvents(HashMap<AccessTokenAppIdPair, List<AppEvent>> hashMap) {
        HashMap<AccessTokenAppIdPair, List<AppEvent>> hashMap2 = new HashMap<>();
        this.events = hashMap2;
        hashMap2.putAll(hashMap);
    }
}
