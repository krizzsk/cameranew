package com.bytedance.sdk.a.b.a.c;

import com.bytedance.sdk.a.b.aa;
import com.bytedance.sdk.a.b.p;
import com.bytedance.sdk.a.b.t;
import com.bytedance.sdk.a.b.y;
import java.io.IOException;
import java.util.List;
/* compiled from: RealInterceptorChain.java */
/* loaded from: classes.dex */
public final class g implements t.a {
    private final List<t> a;
    private final com.bytedance.sdk.a.b.a.b.g b;
    private final c c;

    /* renamed from: d  reason: collision with root package name */
    private final com.bytedance.sdk.a.b.a.b.c f918d;

    /* renamed from: e  reason: collision with root package name */
    private final int f919e;

    /* renamed from: f  reason: collision with root package name */
    private final y f920f;

    /* renamed from: g  reason: collision with root package name */
    private final com.bytedance.sdk.a.b.e f921g;

    /* renamed from: h  reason: collision with root package name */
    private final p f922h;

    /* renamed from: i  reason: collision with root package name */
    private final int f923i;

    /* renamed from: j  reason: collision with root package name */
    private final int f924j;

    /* renamed from: k  reason: collision with root package name */
    private final int f925k;

    /* renamed from: l  reason: collision with root package name */
    private int f926l;

    public g(List<t> list, com.bytedance.sdk.a.b.a.b.g gVar, c cVar, com.bytedance.sdk.a.b.a.b.c cVar2, int i2, y yVar, com.bytedance.sdk.a.b.e eVar, p pVar, int i3, int i4, int i5) {
        this.a = list;
        this.f918d = cVar2;
        this.b = gVar;
        this.c = cVar;
        this.f919e = i2;
        this.f920f = yVar;
        this.f921g = eVar;
        this.f922h = pVar;
        this.f923i = i3;
        this.f924j = i4;
        this.f925k = i5;
    }

    @Override // com.bytedance.sdk.a.b.t.a
    public y a() {
        return this.f920f;
    }

    @Override // com.bytedance.sdk.a.b.t.a
    public int b() {
        return this.f923i;
    }

    @Override // com.bytedance.sdk.a.b.t.a
    public int c() {
        return this.f924j;
    }

    @Override // com.bytedance.sdk.a.b.t.a
    public int d() {
        return this.f925k;
    }

    public com.bytedance.sdk.a.b.i e() {
        return this.f918d;
    }

    public com.bytedance.sdk.a.b.a.b.g f() {
        return this.b;
    }

    public c g() {
        return this.c;
    }

    public com.bytedance.sdk.a.b.e h() {
        return this.f921g;
    }

    public p i() {
        return this.f922h;
    }

    @Override // com.bytedance.sdk.a.b.t.a
    public aa a(y yVar) throws IOException {
        return a(yVar, this.b, this.c, this.f918d);
    }

    public aa a(y yVar, com.bytedance.sdk.a.b.a.b.g gVar, c cVar, com.bytedance.sdk.a.b.a.b.c cVar2) throws IOException {
        if (this.f919e < this.a.size()) {
            this.f926l++;
            if (this.c != null && !this.f918d.a(yVar.a())) {
                throw new IllegalStateException("network interceptor " + this.a.get(this.f919e - 1) + " must retain the same host and port");
            } else if (this.c != null && this.f926l > 1) {
                throw new IllegalStateException("network interceptor " + this.a.get(this.f919e - 1) + " must call proceed() exactly once");
            } else {
                g gVar2 = new g(this.a, gVar, cVar, cVar2, this.f919e + 1, yVar, this.f921g, this.f922h, this.f923i, this.f924j, this.f925k);
                t tVar = this.a.get(this.f919e);
                aa a = tVar.a(gVar2);
                if (cVar != null && this.f919e + 1 < this.a.size() && gVar2.f926l != 1) {
                    throw new IllegalStateException("network interceptor " + tVar + " must call proceed() exactly once");
                } else if (a != null) {
                    if (a.g() != null) {
                        return a;
                    }
                    throw new IllegalStateException("interceptor " + tVar + " returned a response with no body");
                } else {
                    throw new NullPointerException("interceptor " + tVar + " returned null");
                }
            }
        }
        throw new AssertionError();
    }
}
