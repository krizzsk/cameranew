package com.iab.omid.library.ironsrc.adsession;

import android.webkit.WebView;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
/* loaded from: classes2.dex */
public final class d {
    private final e a;
    private final WebView b;
    private final List<f> c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, f> f5302d;

    /* renamed from: e  reason: collision with root package name */
    private final String f5303e;

    /* renamed from: f  reason: collision with root package name */
    private final String f5304f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private final String f5305g;

    /* renamed from: h  reason: collision with root package name */
    private final AdSessionContextType f5306h;

    private d(e eVar, WebView webView, String str, List<f> list, @Nullable String str2, String str3, AdSessionContextType adSessionContextType) {
        ArrayList arrayList = new ArrayList();
        this.c = arrayList;
        this.f5302d = new HashMap();
        this.a = eVar;
        this.b = webView;
        this.f5303e = str;
        this.f5306h = adSessionContextType;
        if (list != null) {
            arrayList.addAll(list);
            for (f fVar : list) {
                String uuid = UUID.randomUUID().toString();
                this.f5302d.put(uuid, fVar);
            }
        }
        this.f5305g = str2;
        this.f5304f = str3;
    }

    public static d a(e eVar, WebView webView, @Nullable String str, String str2) {
        d.d.a.a.a.g.e.c(eVar, "Partner is null");
        d.d.a.a.a.g.e.c(webView, "WebView is null");
        if (str2 != null) {
            d.d.a.a.a.g.e.d(str2, 256, "CustomReferenceData is greater than 256 characters");
        }
        return new d(eVar, webView, null, null, str, str2, AdSessionContextType.HTML);
    }

    public AdSessionContextType b() {
        return this.f5306h;
    }

    @Nullable
    public String c() {
        return this.f5305g;
    }

    public String d() {
        return this.f5304f;
    }

    public Map<String, f> e() {
        return Collections.unmodifiableMap(this.f5302d);
    }

    public String f() {
        return this.f5303e;
    }

    public e g() {
        return this.a;
    }

    public List<f> h() {
        return Collections.unmodifiableList(this.c);
    }

    public WebView i() {
        return this.b;
    }
}
