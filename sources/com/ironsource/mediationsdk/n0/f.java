package com.ironsource.mediationsdk.n0;

import java.util.Map;
import org.json.JSONObject;
/* compiled from: GeneralProperties.java */
/* loaded from: classes2.dex */
public class f {
    private static f b;
    private JSONObject a = new JSONObject();

    private f() {
    }

    public static synchronized f b() {
        f fVar;
        synchronized (f.class) {
            if (b == null) {
                b = new f();
            }
            fVar = b;
        }
        return fVar;
    }

    public synchronized String a(String str) {
        return this.a.optString(str);
    }

    public synchronized void c(String str, Object obj) {
        try {
            this.a.put(str, obj);
        } catch (Exception unused) {
        }
    }

    public synchronized void d(Map<String, Object> map) {
        if (map != null) {
            for (String str : map.keySet()) {
                c(str, map.get(str));
            }
        }
    }

    public synchronized JSONObject e() {
        return this.a;
    }
}
