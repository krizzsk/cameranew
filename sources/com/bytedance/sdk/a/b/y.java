package com.bytedance.sdk.a.b;

import com.bytedance.sdk.a.b.r;
import java.net.URL;
import java.util.Objects;
/* compiled from: Request.java */
/* loaded from: classes.dex */
public final class y {
    final s a;
    final String b;
    final r c;

    /* renamed from: d  reason: collision with root package name */
    final z f1153d;

    /* renamed from: e  reason: collision with root package name */
    final Object f1154e;

    /* renamed from: f  reason: collision with root package name */
    private volatile d f1155f;

    /* compiled from: Request.java */
    /* loaded from: classes.dex */
    public static class a {
        s a;
        String b;
        r.a c;

        /* renamed from: d  reason: collision with root package name */
        z f1156d;

        /* renamed from: e  reason: collision with root package name */
        Object f1157e;

        public a() {
            this.b = "GET";
            this.c = new r.a();
        }

        public a a(s sVar) {
            Objects.requireNonNull(sVar, "url == null");
            this.a = sVar;
            return this;
        }

        public a b(String str, String str2) {
            this.c.a(str, str2);
            return this;
        }

        public a c() {
            return b(com.bytedance.sdk.a.b.a.c.f909d);
        }

        public a d(z zVar) {
            return a("PATCH", zVar);
        }

        public a b(String str) {
            this.c.b(str);
            return this;
        }

        public a c(z zVar) {
            return a("PUT", zVar);
        }

        public y d() {
            if (this.a != null) {
                return new y(this);
            }
            throw new IllegalStateException("url == null");
        }

        public a a(String str) {
            Objects.requireNonNull(str, "url == null");
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str = "http:" + str.substring(3);
            } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                str = "https:" + str.substring(4);
            }
            s e2 = s.e(str);
            if (e2 != null) {
                return a(e2);
            }
            throw new IllegalArgumentException("unexpected url: " + str);
        }

        public a b() {
            return a("HEAD", (z) null);
        }

        a(y yVar) {
            this.a = yVar.a;
            this.b = yVar.b;
            this.f1156d = yVar.f1153d;
            this.f1157e = yVar.f1154e;
            this.c = yVar.c.b();
        }

        public a b(z zVar) {
            return a("DELETE", zVar);
        }

        public a a(URL url) {
            Objects.requireNonNull(url, "url == null");
            s a = s.a(url);
            if (a != null) {
                return a(a);
            }
            throw new IllegalArgumentException("unexpected url: " + url);
        }

        public a a(String str, String str2) {
            this.c.c(str, str2);
            return this;
        }

        public a a(r rVar) {
            this.c = rVar.b();
            return this;
        }

        public a a() {
            return a("GET", (z) null);
        }

        public a a(z zVar) {
            return a("POST", zVar);
        }

        public a a(String str, z zVar) {
            Objects.requireNonNull(str, "method == null");
            if (str.length() != 0) {
                if (zVar != null && !com.bytedance.sdk.a.b.a.c.f.c(str)) {
                    throw new IllegalArgumentException("method " + str + " must not have a request body.");
                } else if (zVar == null && com.bytedance.sdk.a.b.a.c.f.b(str)) {
                    throw new IllegalArgumentException("method " + str + " must have a request body.");
                } else {
                    this.b = str;
                    this.f1156d = zVar;
                    return this;
                }
            }
            throw new IllegalArgumentException("method.length() == 0");
        }
    }

    y(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c.a();
        this.f1153d = aVar.f1156d;
        Object obj = aVar.f1157e;
        this.f1154e = obj == null ? this : obj;
    }

    public s a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public r c() {
        return this.c;
    }

    public z d() {
        return this.f1153d;
    }

    public a e() {
        return new a(this);
    }

    public d f() {
        d dVar = this.f1155f;
        if (dVar != null) {
            return dVar;
        }
        d a2 = d.a(this.c);
        this.f1155f = a2;
        return a2;
    }

    public boolean g() {
        return this.a.c();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request{method=");
        sb.append(this.b);
        sb.append(", url=");
        sb.append(this.a);
        sb.append(", tag=");
        Object obj = this.f1154e;
        if (obj == this) {
            obj = null;
        }
        sb.append(obj);
        sb.append('}');
        return sb.toString();
    }

    public String a(String str) {
        return this.c.a(str);
    }
}
