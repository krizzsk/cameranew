package com.bumptech.glide.load.model;

import android.net.Uri;
import android.text.TextUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
/* compiled from: GlideUrl.java */
/* loaded from: classes.dex */
public class c {
    private final URL a;
    private final d b;
    private final String c;

    /* renamed from: d  reason: collision with root package name */
    private String f772d;

    /* renamed from: e  reason: collision with root package name */
    private URL f773e;

    public c(URL url) {
        this(url, d.a);
    }

    private String c() {
        if (TextUtils.isEmpty(this.f772d)) {
            String str = this.c;
            if (TextUtils.isEmpty(str)) {
                str = this.a.toString();
            }
            this.f772d = Uri.encode(str, "@#&=*+-_.,:!?()/~'%");
        }
        return this.f772d;
    }

    private URL d() throws MalformedURLException {
        if (this.f773e == null) {
            this.f773e = new URL(c());
        }
        return this.f773e;
    }

    public String a() {
        String str = this.c;
        return str != null ? str : this.a.toString();
    }

    public Map<String, String> b() {
        return this.b.a();
    }

    public URL e() throws MalformedURLException {
        return d();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return a().equals(cVar.a()) && this.b.equals(cVar.b);
        }
        return false;
    }

    public int hashCode() {
        return (a().hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return a() + '\n' + this.b.toString();
    }

    public c(String str) {
        this(str, d.a);
    }

    public c(URL url, d dVar) {
        if (url == null) {
            throw new IllegalArgumentException("URL must not be null!");
        }
        if (dVar != null) {
            this.a = url;
            this.c = null;
            this.b = dVar;
            return;
        }
        throw new IllegalArgumentException("Headers must not be null");
    }

    public c(String str, d dVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("String url must not be empty or null: " + str);
        } else if (dVar != null) {
            this.c = str;
            this.a = null;
            this.b = dVar;
        } else {
            throw new IllegalArgumentException("Headers must not be null");
        }
    }
}
