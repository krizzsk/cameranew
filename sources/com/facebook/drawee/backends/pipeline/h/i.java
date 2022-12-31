package com.facebook.drawee.backends.pipeline.h;

import com.facebook.fresco.ui.common.b;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* compiled from: ImagePerfState.java */
/* loaded from: classes.dex */
public class i {
    @Nullable
    private String A;
    @Nullable
    private com.facebook.fresco.ui.common.c B;
    @Nullable
    private b.a C;
    @Nullable
    private String a;
    @Nullable
    private String b;
    @Nullable
    private ImageRequest c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private Object f2466d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private com.facebook.imagepipeline.image.g f2467e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private ImageRequest f2468f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private ImageRequest f2469g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private ImageRequest[] f2470h;
    @Nullable
    private String q;
    private boolean r;
    @Nullable
    private Throwable u;

    /* renamed from: i  reason: collision with root package name */
    private long f2471i = -1;

    /* renamed from: j  reason: collision with root package name */
    private long f2472j = -1;

    /* renamed from: k  reason: collision with root package name */
    private long f2473k = -1;

    /* renamed from: l  reason: collision with root package name */
    private long f2474l = -1;
    private long m = -1;
    private long n = -1;
    private long o = -1;
    private int p = 1;
    private int s = -1;
    private int t = -1;
    private int v = -1;
    private int w = -1;
    private long x = -1;
    private long y = -1;
    private long z = -1;

    public void A(boolean z) {
        this.w = z ? 1 : 2;
    }

    public e B() {
        return new e(this.a, this.b, this.c, this.f2466d, this.f2467e, this.f2468f, this.f2469g, this.f2470h, this.f2471i, this.f2472j, this.f2473k, this.f2474l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.w, this.x, this.y, this.A, this.z, this.B, this.C);
    }

    public int a() {
        return this.v;
    }

    public void b() {
        this.b = null;
        this.c = null;
        this.f2466d = null;
        this.f2467e = null;
        this.f2468f = null;
        this.f2469g = null;
        this.f2470h = null;
        this.p = 1;
        this.q = null;
        this.r = false;
        this.s = -1;
        this.t = -1;
        this.u = null;
        this.v = -1;
        this.w = -1;
        this.A = null;
        this.C = null;
        c();
    }

    public void c() {
        this.n = -1L;
        this.o = -1L;
        this.f2471i = -1L;
        this.f2473k = -1L;
        this.f2474l = -1L;
        this.m = -1L;
        this.x = -1L;
        this.y = -1L;
        this.z = -1L;
    }

    public void d(@Nullable Object obj) {
        this.f2466d = obj;
    }

    public void e(long j2) {
        this.m = j2;
    }

    public void f(long j2) {
        this.f2474l = j2;
    }

    public void g(long j2) {
        this.f2473k = j2;
    }

    public void h(@Nullable String str) {
        this.a = str;
    }

    public void i(@Nullable ImageRequest imageRequest, @Nullable ImageRequest imageRequest2, @Nullable ImageRequest[] imageRequestArr) {
        this.f2468f = imageRequest;
        this.f2469g = imageRequest2;
        this.f2470h = imageRequestArr;
    }

    public void j(long j2) {
        this.f2472j = j2;
    }

    public void k(long j2) {
        this.f2471i = j2;
    }

    public void l(@Nullable Throwable th) {
        this.u = th;
    }

    public void m(@Nullable b.a aVar) {
        this.C = aVar;
    }

    public void n(@Nullable com.facebook.imagepipeline.image.g gVar) {
        this.f2467e = gVar;
    }

    public void o(int i2) {
        this.v = i2;
    }

    public void p(int i2) {
        this.p = i2;
    }

    public void q(@Nullable ImageRequest imageRequest) {
        this.c = imageRequest;
    }

    public void r(long j2) {
        this.o = j2;
    }

    public void s(long j2) {
        this.n = j2;
    }

    public void t(long j2) {
        this.y = j2;
    }

    public void u(int i2) {
        this.t = i2;
    }

    public void v(int i2) {
        this.s = i2;
    }

    public void w(boolean z) {
        this.r = z;
    }

    public void x(@Nullable String str) {
        this.b = str;
    }

    public void y(@Nullable String str) {
        this.q = str;
    }

    public void z(long j2) {
        this.x = j2;
    }
}
