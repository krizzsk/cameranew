package com.bytedance.sdk.a.b;

import com.bytedance.sdk.a.b.r;
import java.io.Closeable;
/* compiled from: Response.java */
/* loaded from: classes.dex */
public final class aa implements Closeable {
    final y a;
    final w b;
    final int c;

    /* renamed from: d  reason: collision with root package name */
    final String f1040d;

    /* renamed from: e  reason: collision with root package name */
    final q f1041e;

    /* renamed from: f  reason: collision with root package name */
    final r f1042f;

    /* renamed from: g  reason: collision with root package name */
    final ab f1043g;

    /* renamed from: h  reason: collision with root package name */
    final aa f1044h;

    /* renamed from: i  reason: collision with root package name */
    final aa f1045i;

    /* renamed from: j  reason: collision with root package name */
    final aa f1046j;

    /* renamed from: k  reason: collision with root package name */
    final long f1047k;

    /* renamed from: l  reason: collision with root package name */
    final long f1048l;
    private volatile d m;

    /* compiled from: Response.java */
    /* loaded from: classes.dex */
    public static class a {
        y a;
        w b;
        int c;

        /* renamed from: d  reason: collision with root package name */
        String f1049d;

        /* renamed from: e  reason: collision with root package name */
        q f1050e;

        /* renamed from: f  reason: collision with root package name */
        r.a f1051f;

        /* renamed from: g  reason: collision with root package name */
        ab f1052g;

        /* renamed from: h  reason: collision with root package name */
        aa f1053h;

        /* renamed from: i  reason: collision with root package name */
        aa f1054i;

        /* renamed from: j  reason: collision with root package name */
        aa f1055j;

        /* renamed from: k  reason: collision with root package name */
        long f1056k;

        /* renamed from: l  reason: collision with root package name */
        long f1057l;

        public a() {
            this.c = -1;
            this.f1051f = new r.a();
        }

        private void d(aa aaVar) {
            if (aaVar.f1043g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public a a(y yVar) {
            this.a = yVar;
            return this;
        }

        public a b(aa aaVar) {
            if (aaVar != null) {
                a("cacheResponse", aaVar);
            }
            this.f1054i = aaVar;
            return this;
        }

        public a c(aa aaVar) {
            if (aaVar != null) {
                d(aaVar);
            }
            this.f1055j = aaVar;
            return this;
        }

        public a a(w wVar) {
            this.b = wVar;
            return this;
        }

        public a a(int i2) {
            this.c = i2;
            return this;
        }

        public a b(long j2) {
            this.f1057l = j2;
            return this;
        }

        a(aa aaVar) {
            this.c = -1;
            this.a = aaVar.a;
            this.b = aaVar.b;
            this.c = aaVar.c;
            this.f1049d = aaVar.f1040d;
            this.f1050e = aaVar.f1041e;
            this.f1051f = aaVar.f1042f.b();
            this.f1052g = aaVar.f1043g;
            this.f1053h = aaVar.f1044h;
            this.f1054i = aaVar.f1045i;
            this.f1055j = aaVar.f1046j;
            this.f1056k = aaVar.f1047k;
            this.f1057l = aaVar.f1048l;
        }

        public a a(String str) {
            this.f1049d = str;
            return this;
        }

        public a a(q qVar) {
            this.f1050e = qVar;
            return this;
        }

        public a a(String str, String str2) {
            this.f1051f.a(str, str2);
            return this;
        }

        public a a(r rVar) {
            this.f1051f = rVar.b();
            return this;
        }

        public a a(ab abVar) {
            this.f1052g = abVar;
            return this;
        }

        public a a(aa aaVar) {
            if (aaVar != null) {
                a("networkResponse", aaVar);
            }
            this.f1053h = aaVar;
            return this;
        }

        private void a(String str, aa aaVar) {
            if (aaVar.f1043g == null) {
                if (aaVar.f1044h == null) {
                    if (aaVar.f1045i == null) {
                        if (aaVar.f1046j == null) {
                            return;
                        }
                        throw new IllegalArgumentException(str + ".priorResponse != null");
                    }
                    throw new IllegalArgumentException(str + ".cacheResponse != null");
                }
                throw new IllegalArgumentException(str + ".networkResponse != null");
            }
            throw new IllegalArgumentException(str + ".body != null");
        }

        public a a(long j2) {
            this.f1056k = j2;
            return this;
        }

        public aa a() {
            if (this.a != null) {
                if (this.b != null) {
                    if (this.c >= 0) {
                        if (this.f1049d != null) {
                            return new aa(this);
                        }
                        throw new IllegalStateException("message == null");
                    }
                    throw new IllegalStateException("code < 0: " + this.c);
                }
                throw new IllegalStateException("protocol == null");
            }
            throw new IllegalStateException("request == null");
        }
    }

    aa(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.f1040d = aVar.f1049d;
        this.f1041e = aVar.f1050e;
        this.f1042f = aVar.f1051f.a();
        this.f1043g = aVar.f1052g;
        this.f1044h = aVar.f1053h;
        this.f1045i = aVar.f1054i;
        this.f1046j = aVar.f1055j;
        this.f1047k = aVar.f1056k;
        this.f1048l = aVar.f1057l;
    }

    public y a() {
        return this.a;
    }

    public w b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ab abVar = this.f1043g;
        if (abVar != null) {
            abVar.close();
            return;
        }
        throw new IllegalStateException("response is not eligible for a body and must not be closed");
    }

    public String d() {
        return this.f1040d;
    }

    public q e() {
        return this.f1041e;
    }

    public r f() {
        return this.f1042f;
    }

    public ab g() {
        return this.f1043g;
    }

    public a h() {
        return new a(this);
    }

    public aa i() {
        return this.f1046j;
    }

    public d j() {
        d dVar = this.m;
        if (dVar != null) {
            return dVar;
        }
        d a2 = d.a(this.f1042f);
        this.m = a2;
        return a2;
    }

    public long k() {
        return this.f1047k;
    }

    public long l() {
        return this.f1048l;
    }

    public String toString() {
        return "Response{protocol=" + this.b + ", code=" + this.c + ", message=" + this.f1040d + ", url=" + this.a.a() + '}';
    }

    public String a(String str) {
        return a(str, null);
    }

    public String a(String str, String str2) {
        String a2 = this.f1042f.a(str);
        return a2 != null ? a2 : str2;
    }
}
