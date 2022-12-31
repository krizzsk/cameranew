package com.ironsource.mediationsdk.adunit.events;

import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EventCategory.java */
/* loaded from: classes2.dex */
public abstract class d {
    private final AdUnitEventsWrapper a;

    public d(AdUnitEventsWrapper adUnitEventsWrapper) {
        this.a = adUnitEventsWrapper;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(AdUnitEvents adUnitEvents) {
        b(adUnitEvents, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(AdUnitEvents adUnitEvents, Map<String, Object> map) {
        this.a.e(adUnitEvents, map);
    }
}
