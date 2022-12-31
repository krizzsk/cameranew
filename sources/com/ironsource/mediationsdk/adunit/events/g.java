package com.ironsource.mediationsdk.adunit.events;

import java.util.HashMap;
/* compiled from: Troubleshoot.java */
/* loaded from: classes2.dex */
public class g extends d {
    public g(AdUnitEventsWrapper adUnitEventsWrapper) {
        super(adUnitEventsWrapper);
    }

    public void c(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("reason", str);
        b(AdUnitEvents.TROUBLESHOOT_AD_ADAPTER_NOT_AVAILABLE, hashMap);
    }

    public void d(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("reason", str);
        b(AdUnitEvents.TROUBLESHOOT_ADAPTER_BRIDGE_INTERNAL_ERROR, hashMap);
    }

    public void e(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("reason", str);
        b(AdUnitEvents.TROUBLESHOOT_BIDDING_DATA_MISSING, hashMap);
    }

    public void f(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("reason", str);
        b(AdUnitEvents.TROUBLESHOOT_INTERNAL_ERROR, hashMap);
    }

    public void g(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("reason", str);
        b(AdUnitEvents.TROUBLESHOOT_NETWORK_ADAPTER_NOT_AVAILABLE, hashMap);
    }

    public void h(int i2, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("errorCode", Integer.valueOf(i2));
        hashMap.put("ext1", str);
        b(AdUnitEvents.TROUBLESHOOT_NOTIFICATION_ERROR, hashMap);
    }

    public void i(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("reason", str);
        b(AdUnitEvents.TROUBLESHOOT_PROVIDER_SETTINGS_MISSING, hashMap);
    }

    public void j(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("reason", str);
        b(AdUnitEvents.TROUBLESHOOT_UNEXPECTED_AUCTION_FAILED, hashMap);
    }

    public void k(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("reason", str);
        b(AdUnitEvents.TROUBLESHOOT_UNEXPECTED_AUCTION_SUCCESS, hashMap);
    }

    public void l(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("reason", str);
        b(AdUnitEvents.TROUBLESHOOT_UNEXPECTED_INIT_FAILED, hashMap);
    }

    public void m(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("reason", str);
        b(AdUnitEvents.TROUBLESHOOT_UNEXPECTED_INIT_SUCCESS, hashMap);
    }

    public void n(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("reason", str);
        b(AdUnitEvents.TROUBLESHOOT_UNEXPECTED_LOAD_FAILED, hashMap);
    }

    public void o(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("reason", str);
        b(AdUnitEvents.TROUBLESHOOT_UNEXPECTED_LOAD_SUCCESS, hashMap);
    }
}
