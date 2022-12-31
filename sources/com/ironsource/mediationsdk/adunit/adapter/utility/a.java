package com.ironsource.mediationsdk.adunit.adapter.utility;

import java.util.Map;
/* compiled from: AdData.java */
/* loaded from: classes2.dex */
public class a {
    private final String a;
    private final Map<String, Object> b;

    public a(String str, Map<String, Object> map) {
        this.a = str;
        this.b = map;
    }

    public String a() {
        return this.a;
    }

    public String b(String str) {
        return (String) this.b.get(str);
    }
}
