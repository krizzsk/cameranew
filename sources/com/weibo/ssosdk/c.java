package com.weibo.ssosdk;

import android.content.Context;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c implements Cloneable {
    private Context a;
    private String b = "";
    private String c = "";

    /* renamed from: d  reason: collision with root package name */
    private String f8483d = "";

    /* renamed from: e  reason: collision with root package name */
    private String f8484e = "";

    /* renamed from: f  reason: collision with root package name */
    private String f8485f = "";

    /* renamed from: g  reason: collision with root package name */
    private String f8486g = "";

    /* renamed from: h  reason: collision with root package name */
    private HashMap<String, String> f8487h = new HashMap<>();

    private String m(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    public String a(boolean z) {
        if (z) {
            return m(this.b);
        }
        return this.b;
    }

    public Context b() {
        return this.a;
    }

    public String c(boolean z) {
        if (this.f8487h.isEmpty()) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, String> entry : this.f8487h.entrySet()) {
            try {
                jSONObject.put(entry.getKey(), entry.getValue());
            } catch (JSONException unused) {
                return "";
            }
        }
        if (z) {
            return m(jSONObject.toString());
        }
        return jSONObject.toString();
    }

    public Object clone() {
        try {
            c cVar = (c) super.clone();
            HashMap<String, String> hashMap = new HashMap<>();
            for (Map.Entry<String, String> entry : cVar.f8487h.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            cVar.f8487h = hashMap;
            return cVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public String d(boolean z) {
        if (z) {
            return m(this.f8483d);
        }
        return this.f8483d;
    }

    public String e(boolean z) {
        if (z) {
            return m(this.f8485f);
        }
        return this.f8485f;
    }

    public String f(boolean z) {
        if (z) {
            return m(this.c);
        }
        return this.c;
    }

    public String g(boolean z) {
        if (z) {
            return m(this.f8486g);
        }
        return this.f8486g;
    }

    public String h(boolean z) {
        if (z) {
            return m(this.f8484e);
        }
        return this.f8484e;
    }

    public void i(String str) {
        this.b = str;
    }

    public void j(Context context) {
        this.a = context.getApplicationContext();
    }

    public void k(String str) {
        this.f8483d = str;
    }

    public void l(String str) {
        this.f8484e = str;
    }

    public boolean n() {
        return (this.a == null || TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.f8483d) || TextUtils.isEmpty(this.f8484e)) ? false : true;
    }
}
