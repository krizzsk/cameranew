package com.unity3d.splash.services.core.configuration;

import android.content.SharedPreferences;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class a {
    private String a;
    private String b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private String f8451d;

    /* renamed from: e  reason: collision with root package name */
    private Map f8452e;

    /* renamed from: f  reason: collision with root package name */
    private String[] f8453f = {"com.unity3d.splash.services.core.configuration.CoreModuleConfiguration", "com.unity3d.splash.services.ads.configuration.AdsModuleConfiguration"};

    /* renamed from: g  reason: collision with root package name */
    private Class[] f8454g;

    private void a() {
        ArrayList arrayList = new ArrayList();
        for (String str : c()) {
            c b = b(str);
            if (b != null && b.a() != null) {
                arrayList.addAll(Arrays.asList(b.a()));
            }
        }
        this.f8454g = (Class[]) arrayList.toArray(new Class[arrayList.size()]);
    }

    public c b(String str) {
        Map map = this.f8452e;
        if (map == null || !map.containsKey(str)) {
            try {
                c cVar = (c) Class.forName(str).newInstance();
                if (cVar != null) {
                    if (this.f8452e == null) {
                        HashMap hashMap = new HashMap();
                        this.f8452e = hashMap;
                        hashMap.put(str, cVar);
                    }
                    return cVar;
                }
            } catch (Exception unused) {
            }
            return null;
        }
        return (c) this.f8452e.get(str);
    }

    public String[] c() {
        return this.f8453f;
    }

    public Class[] d() {
        if (this.f8454g == null) {
            a();
        }
        return this.f8454g;
    }

    public String e() {
        return this.f8451d;
    }

    public String f() {
        return this.b;
    }

    public String g() {
        return this.a;
    }

    public String h() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i() {
        SharedPreferences sharedPreferences = com.unity3d.splash.services.c.b.a.b().getSharedPreferences("game_detail", 0);
        this.a = sharedPreferences.getString("url", null);
        this.b = sharedPreferences.getString("hash", null);
        this.c = sharedPreferences.getString("version", null);
        String str = this.a;
        if (str == null || str.isEmpty()) {
            throw new MalformedURLException("Invalid data. Web view URL is null or empty");
        }
    }

    public void j(String str) {
    }

    public void k(String str) {
        this.f8451d = str;
    }
}
