package com.ironsource.sdk.controller;

import android.text.TextUtils;
import com.ironsource.sdk.data.ISNEnums$ProductType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
/* compiled from: DemandSourceManager.java */
/* loaded from: classes2.dex */
public class h {
    private Map<String, com.ironsource.sdk.data.b> a = new LinkedHashMap();
    private Map<String, com.ironsource.sdk.data.b> b = new LinkedHashMap();
    private Map<String, com.ironsource.sdk.data.b> c = new LinkedHashMap();

    private void a(ISNEnums$ProductType iSNEnums$ProductType, String str, com.ironsource.sdk.data.b bVar) {
        Map<String, com.ironsource.sdk.data.b> f2;
        if (TextUtils.isEmpty(str) || bVar == null || (f2 = f(iSNEnums$ProductType)) == null) {
            return;
        }
        f2.put(str, bVar);
    }

    private Map<String, com.ironsource.sdk.data.b> f(ISNEnums$ProductType iSNEnums$ProductType) {
        if (iSNEnums$ProductType.name().equalsIgnoreCase(ISNEnums$ProductType.RewardedVideo.name())) {
            return this.a;
        }
        if (iSNEnums$ProductType.name().equalsIgnoreCase(ISNEnums$ProductType.Interstitial.name())) {
            return this.b;
        }
        if (iSNEnums$ProductType.name().equalsIgnoreCase(ISNEnums$ProductType.Banner.name())) {
            return this.c;
        }
        return null;
    }

    public com.ironsource.sdk.data.b b(ISNEnums$ProductType iSNEnums$ProductType, d.e.d.c cVar) {
        String c = cVar.c();
        com.ironsource.sdk.data.b bVar = new com.ironsource.sdk.data.b(c, cVar.d(), cVar.a(), cVar.b());
        a(iSNEnums$ProductType, c, bVar);
        return bVar;
    }

    public com.ironsource.sdk.data.b c(ISNEnums$ProductType iSNEnums$ProductType, String str, Map<String, String> map, d.e.d.n.a aVar) {
        com.ironsource.sdk.data.b bVar = new com.ironsource.sdk.data.b(str, str, map, aVar);
        a(iSNEnums$ProductType, str, bVar);
        return bVar;
    }

    public com.ironsource.sdk.data.b d(ISNEnums$ProductType iSNEnums$ProductType, String str) {
        Map<String, com.ironsource.sdk.data.b> f2;
        if (TextUtils.isEmpty(str) || (f2 = f(iSNEnums$ProductType)) == null) {
            return null;
        }
        return f2.get(str);
    }

    public Collection<com.ironsource.sdk.data.b> e(ISNEnums$ProductType iSNEnums$ProductType) {
        Map<String, com.ironsource.sdk.data.b> f2 = f(iSNEnums$ProductType);
        if (f2 != null) {
            return f2.values();
        }
        return new ArrayList();
    }
}
