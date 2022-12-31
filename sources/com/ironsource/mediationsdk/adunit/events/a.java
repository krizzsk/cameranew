package com.ironsource.mediationsdk.adunit.events;

import java.util.HashMap;
/* compiled from: AdInteraction.java */
/* loaded from: classes2.dex */
public class a extends d {
    public a(AdUnitEventsWrapper adUnitEventsWrapper) {
        super(adUnitEventsWrapper);
    }

    public void c(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("placement", str);
        b(AdUnitEvents.AD_CLICKED, hashMap);
    }

    public void d(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("placement", str);
        b(AdUnitEvents.AD_CLOSED, hashMap);
    }

    public void e(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("placement", str);
        b(AdUnitEvents.AD_OPENED, hashMap);
    }

    public void f(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("placement", str);
        b(AdUnitEvents.PLACEMENT_CAPPED, hashMap);
    }

    public void g() {
        a(AdUnitEvents.SESSION_CAPPED);
    }

    public void h(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("placement", str);
        b(AdUnitEvents.SHOW_AD, hashMap);
    }

    public void i(String str, int i2, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("placement", str);
        hashMap.put("errorCode", Integer.valueOf(i2));
        hashMap.put("reason", str2);
        b(AdUnitEvents.SHOW_AD_FAILED, hashMap);
    }

    public void j(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("placement", str);
        b(AdUnitEvents.SHOW_AD_SUCCESS, hashMap);
    }
}
