package com.facebook.imagepipeline.core;

import android.content.Context;
import com.facebook.common.c.b;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.cache.r;
import com.facebook.imagepipeline.core.i;
/* compiled from: ImagePipelineExperiments.java */
/* loaded from: classes.dex */
public class k {
    private final int A;
    private final boolean B;
    private final boolean C;
    private final boolean a;
    private final b.a b;
    private final boolean c;

    /* renamed from: d  reason: collision with root package name */
    private final com.facebook.common.c.b f2758d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f2759e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f2760f;

    /* renamed from: g  reason: collision with root package name */
    private final int f2761g;

    /* renamed from: h  reason: collision with root package name */
    private final int f2762h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f2763i;

    /* renamed from: j  reason: collision with root package name */
    private final int f2764j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f2765k;

    /* renamed from: l  reason: collision with root package name */
    private final boolean f2766l;
    private final d m;
    private final com.facebook.common.internal.k<Boolean> n;
    private final boolean o;
    private final boolean p;
    private final int q;
    private final com.facebook.common.internal.k<Boolean> r;
    private final boolean s;
    private final long t;
    private boolean u;
    private boolean v;
    private boolean w;
    private final boolean x;
    private final boolean y;
    private final boolean z;

    /* compiled from: ImagePipelineExperiments.java */
    /* loaded from: classes.dex */
    public static class b {
        private b.a b;

        /* renamed from: d  reason: collision with root package name */
        private com.facebook.common.c.b f2767d;
        private d m;
        public com.facebook.common.internal.k<Boolean> n;
        public boolean o;
        public boolean p;
        public int q;
        public boolean s;
        private boolean u;
        public boolean v;
        private boolean a = false;
        private boolean c = false;

        /* renamed from: e  reason: collision with root package name */
        private boolean f2768e = false;

        /* renamed from: f  reason: collision with root package name */
        private boolean f2769f = false;

        /* renamed from: g  reason: collision with root package name */
        private int f2770g = 0;

        /* renamed from: h  reason: collision with root package name */
        private int f2771h = 0;

        /* renamed from: i  reason: collision with root package name */
        public boolean f2772i = false;

        /* renamed from: j  reason: collision with root package name */
        private int f2773j = 2048;

        /* renamed from: k  reason: collision with root package name */
        private boolean f2774k = false;

        /* renamed from: l  reason: collision with root package name */
        private boolean f2775l = false;
        public com.facebook.common.internal.k<Boolean> r = com.facebook.common.internal.l.a(Boolean.FALSE);
        public long t = 0;
        public boolean w = true;
        public boolean x = true;
        private boolean y = false;
        private boolean z = false;
        private int A = 20;
        private boolean B = false;
        private boolean C = false;

        public b(i.b bVar) {
        }

        public k s() {
            return new k(this);
        }
    }

    /* compiled from: ImagePipelineExperiments.java */
    /* loaded from: classes.dex */
    public static class c implements d {
        @Override // com.facebook.imagepipeline.core.k.d
        public n a(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, f fVar, com.facebook.common.memory.f fVar2, com.facebook.common.memory.i iVar, r<com.facebook.cache.common.b, com.facebook.imagepipeline.image.c> rVar, r<com.facebook.cache.common.b, PooledByteBuffer> rVar2, com.facebook.imagepipeline.cache.e eVar, com.facebook.imagepipeline.cache.e eVar2, com.facebook.imagepipeline.cache.f fVar3, com.facebook.imagepipeline.bitmaps.f fVar4, int i2, int i3, boolean z4, int i4, com.facebook.imagepipeline.core.a aVar2, boolean z5, int i5) {
            return new n(context, aVar, bVar, dVar, z, z2, z3, fVar, fVar2, rVar, rVar2, eVar, eVar2, fVar3, fVar4, i2, i3, z4, i4, aVar2, z5, i5);
        }
    }

    /* compiled from: ImagePipelineExperiments.java */
    /* loaded from: classes.dex */
    public interface d {
        n a(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, f fVar, com.facebook.common.memory.f fVar2, com.facebook.common.memory.i iVar, r<com.facebook.cache.common.b, com.facebook.imagepipeline.image.c> rVar, r<com.facebook.cache.common.b, PooledByteBuffer> rVar2, com.facebook.imagepipeline.cache.e eVar, com.facebook.imagepipeline.cache.e eVar2, com.facebook.imagepipeline.cache.f fVar3, com.facebook.imagepipeline.bitmaps.f fVar4, int i2, int i3, boolean z4, int i4, com.facebook.imagepipeline.core.a aVar2, boolean z5, int i5);
    }

    public boolean A() {
        return this.p;
    }

    public boolean B() {
        return this.u;
    }

    public boolean C() {
        return this.B;
    }

    public boolean a() {
        return this.C;
    }

    public int b() {
        return this.q;
    }

    public boolean c() {
        return this.f2763i;
    }

    public int d() {
        return this.f2762h;
    }

    public int e() {
        return this.f2761g;
    }

    public int f() {
        return this.f2764j;
    }

    public long g() {
        return this.t;
    }

    public d h() {
        return this.m;
    }

    public com.facebook.common.internal.k<Boolean> i() {
        return this.r;
    }

    public int j() {
        return this.A;
    }

    public boolean k() {
        return this.f2760f;
    }

    public boolean l() {
        return this.f2759e;
    }

    public com.facebook.common.c.b m() {
        return this.f2758d;
    }

    public b.a n() {
        return this.b;
    }

    public boolean o() {
        return this.c;
    }

    public boolean p() {
        return this.z;
    }

    public boolean q() {
        return this.w;
    }

    public boolean r() {
        return this.y;
    }

    public boolean s() {
        return this.x;
    }

    public boolean t() {
        return this.s;
    }

    public boolean u() {
        return this.o;
    }

    public com.facebook.common.internal.k<Boolean> v() {
        return this.n;
    }

    public boolean w() {
        return this.f2765k;
    }

    public boolean x() {
        return this.f2766l;
    }

    public boolean y() {
        return this.a;
    }

    public boolean z() {
        return this.v;
    }

    private k(b bVar) {
        this.a = bVar.a;
        this.b = bVar.b;
        this.c = bVar.c;
        this.f2758d = bVar.f2767d;
        this.f2759e = bVar.f2768e;
        this.f2760f = bVar.f2769f;
        this.f2761g = bVar.f2770g;
        this.f2762h = bVar.f2771h;
        this.f2763i = bVar.f2772i;
        this.f2764j = bVar.f2773j;
        this.f2765k = bVar.f2774k;
        this.f2766l = bVar.f2775l;
        if (bVar.m != null) {
            this.m = bVar.m;
        } else {
            this.m = new c();
        }
        this.n = bVar.n;
        this.o = bVar.o;
        this.p = bVar.p;
        this.q = bVar.q;
        this.r = bVar.r;
        this.s = bVar.s;
        this.t = bVar.t;
        this.u = bVar.u;
        this.v = bVar.v;
        this.w = bVar.w;
        this.x = bVar.x;
        this.y = bVar.y;
        this.z = bVar.z;
        this.A = bVar.A;
        this.B = bVar.B;
        this.C = bVar.C;
    }
}
