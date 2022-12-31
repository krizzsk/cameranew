package com.facebook.imagepipeline.core;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import com.facebook.common.c.b;
import com.facebook.common.memory.NoOpMemoryTrimmableRegistry;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.cache.NoOpImageCacheStatsTracker;
import com.facebook.imagepipeline.cache.i;
import com.facebook.imagepipeline.cache.r;
import com.facebook.imagepipeline.cache.s;
import com.facebook.imagepipeline.core.k;
import com.facebook.imagepipeline.memory.a0;
import com.facebook.imagepipeline.memory.b0;
import com.facebook.imagepipeline.producers.j0;
import com.facebook.imagepipeline.producers.x;
import com.tencent.bugly.BuglyStrategy;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;
/* compiled from: ImagePipelineConfig.java */
/* loaded from: classes.dex */
public class i implements j {
    private static c I = new c(null);
    private final k A;
    private final boolean B;
    @Nullable
    private final com.facebook.callercontext.a C;
    private final com.facebook.imagepipeline.b.a D;
    @Nullable
    private final r<com.facebook.cache.common.b, com.facebook.imagepipeline.image.c> E;
    @Nullable
    private final r<com.facebook.cache.common.b, PooledByteBuffer> F;
    @Nullable
    private final com.facebook.common.executors.e G;
    private final com.facebook.imagepipeline.cache.a H;
    private final com.facebook.common.internal.k<s> a;
    private final r.a b;
    @Nullable
    private final i.b<com.facebook.cache.common.b> c;

    /* renamed from: d  reason: collision with root package name */
    private final com.facebook.imagepipeline.cache.f f2740d;

    /* renamed from: e  reason: collision with root package name */
    private final Context f2741e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f2742f;

    /* renamed from: g  reason: collision with root package name */
    private final g f2743g;

    /* renamed from: h  reason: collision with root package name */
    private final com.facebook.common.internal.k<s> f2744h;

    /* renamed from: i  reason: collision with root package name */
    private final f f2745i;

    /* renamed from: j  reason: collision with root package name */
    private final com.facebook.imagepipeline.cache.n f2746j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private final com.facebook.imagepipeline.decoder.b f2747k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private final com.facebook.imagepipeline.g.d f2748l;
    @Nullable
    private final Integer m;
    private final com.facebook.common.internal.k<Boolean> n;
    private final com.facebook.cache.disk.b o;
    private final com.facebook.common.memory.c p;
    private final int q;
    private final j0 r;
    private final int s;
    private final b0 t;
    private final com.facebook.imagepipeline.decoder.d u;
    private final Set<com.facebook.imagepipeline.e.e> v;
    private final Set<com.facebook.imagepipeline.e.d> w;
    private final boolean x;
    private final com.facebook.cache.disk.b y;
    @Nullable
    private final com.facebook.imagepipeline.decoder.c z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ImagePipelineConfig.java */
    /* loaded from: classes.dex */
    public class a implements com.facebook.common.internal.k<Boolean> {
        a(i iVar) {
        }

        @Override // com.facebook.common.internal.k
        /* renamed from: a */
        public Boolean get() {
            return Boolean.TRUE;
        }
    }

    /* compiled from: ImagePipelineConfig.java */
    /* loaded from: classes.dex */
    public static class b {
        @Nullable
        private com.facebook.imagepipeline.decoder.c A;
        private int B;
        private final k.b C;
        private boolean D;
        @Nullable
        private com.facebook.callercontext.a E;
        private com.facebook.imagepipeline.b.a F;
        @Nullable
        private r<com.facebook.cache.common.b, com.facebook.imagepipeline.image.c> G;
        @Nullable
        private r<com.facebook.cache.common.b, PooledByteBuffer> H;
        @Nullable
        private com.facebook.common.executors.e I;
        @Nullable
        private com.facebook.imagepipeline.cache.a J;
        @Nullable
        private Bitmap.Config a;
        @Nullable
        private com.facebook.common.internal.k<s> b;
        @Nullable
        private i.b<com.facebook.cache.common.b> c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private r.a f2749d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        private com.facebook.imagepipeline.cache.f f2750e;

        /* renamed from: f  reason: collision with root package name */
        private final Context f2751f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f2752g;
        @Nullable

        /* renamed from: h  reason: collision with root package name */
        private com.facebook.common.internal.k<s> f2753h;
        @Nullable

        /* renamed from: i  reason: collision with root package name */
        private f f2754i;
        @Nullable

        /* renamed from: j  reason: collision with root package name */
        private com.facebook.imagepipeline.cache.n f2755j;
        @Nullable

        /* renamed from: k  reason: collision with root package name */
        private com.facebook.imagepipeline.decoder.b f2756k;
        @Nullable

        /* renamed from: l  reason: collision with root package name */
        private com.facebook.imagepipeline.g.d f2757l;
        @Nullable
        private Integer m;
        @Nullable
        private com.facebook.common.internal.k<Boolean> n;
        @Nullable
        private com.facebook.cache.disk.b o;
        @Nullable
        private com.facebook.common.memory.c p;
        @Nullable
        private Integer q;
        @Nullable
        private j0 r;
        @Nullable
        private com.facebook.imagepipeline.bitmaps.f s;
        @Nullable
        private b0 t;
        @Nullable
        private com.facebook.imagepipeline.decoder.d u;
        @Nullable
        private Set<com.facebook.imagepipeline.e.e> v;
        @Nullable
        private Set<com.facebook.imagepipeline.e.d> w;
        private boolean x;
        @Nullable
        private com.facebook.cache.disk.b y;
        @Nullable
        private g z;

        /* synthetic */ b(Context context, a aVar) {
            this(context);
        }

        public i K() {
            return new i(this, null);
        }

        public b L(Set<com.facebook.imagepipeline.e.e> set) {
            this.v = set;
            return this;
        }

        private b(Context context) {
            this.f2752g = false;
            this.m = null;
            this.q = null;
            this.x = true;
            this.B = -1;
            this.C = new k.b(this);
            this.D = true;
            this.F = new com.facebook.imagepipeline.b.b();
            com.facebook.common.internal.h.g(context);
            this.f2751f = context;
        }
    }

    /* compiled from: ImagePipelineConfig.java */
    /* loaded from: classes.dex */
    public static class c {
        private boolean a;

        /* synthetic */ c(a aVar) {
            this();
        }

        public boolean a() {
            return this.a;
        }

        private c() {
            this.a = false;
        }
    }

    /* synthetic */ i(b bVar, a aVar) {
        this(bVar);
    }

    public static c F() {
        return I;
    }

    private static com.facebook.cache.disk.b G(Context context) {
        try {
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.a("DiskCacheConfig.getDefaultMainDiskCacheConfig");
            }
            return com.facebook.cache.disk.b.m(context).n();
        } finally {
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.b();
            }
        }
    }

    @Nullable
    private static com.facebook.imagepipeline.g.d H(b bVar) {
        if (bVar.f2757l == null || bVar.m == null) {
            if (bVar.f2757l != null) {
                return bVar.f2757l;
            }
            return null;
        }
        throw new IllegalStateException("You can't define a custom ImageTranscoderFactory and provide an ImageTranscoderType");
    }

    private static int I(b bVar, k kVar) {
        if (bVar.q != null) {
            return bVar.q.intValue();
        }
        if (kVar.g() != 2 || Build.VERSION.SDK_INT < 27) {
            if (kVar.g() == 1) {
                return 1;
            }
            if (kVar.g() == 0) {
            }
            return 0;
        }
        return 2;
    }

    public static b J(Context context) {
        return new b(context, null);
    }

    private static void K(com.facebook.common.c.b bVar, k kVar, com.facebook.common.c.a aVar) {
        com.facebook.common.c.c.c = bVar;
        b.a n = kVar.n();
        if (n != null) {
            bVar.b(n);
        }
        if (aVar != null) {
            bVar.a(aVar);
        }
    }

    @Override // com.facebook.imagepipeline.core.j
    public com.facebook.imagepipeline.cache.n A() {
        return this.f2746j;
    }

    @Override // com.facebook.imagepipeline.core.j
    public com.facebook.common.memory.c B() {
        return this.p;
    }

    @Override // com.facebook.imagepipeline.core.j
    @Nullable
    public com.facebook.callercontext.a C() {
        return this.C;
    }

    @Override // com.facebook.imagepipeline.core.j
    public k D() {
        return this.A;
    }

    @Override // com.facebook.imagepipeline.core.j
    public f E() {
        return this.f2745i;
    }

    @Override // com.facebook.imagepipeline.core.j
    public Set<com.facebook.imagepipeline.e.d> a() {
        return Collections.unmodifiableSet(this.w);
    }

    @Override // com.facebook.imagepipeline.core.j
    public com.facebook.common.internal.k<Boolean> b() {
        return this.n;
    }

    @Override // com.facebook.imagepipeline.core.j
    public j0 c() {
        return this.r;
    }

    @Override // com.facebook.imagepipeline.core.j
    @Nullable
    public r<com.facebook.cache.common.b, PooledByteBuffer> d() {
        return this.F;
    }

    @Override // com.facebook.imagepipeline.core.j
    public com.facebook.cache.disk.b e() {
        return this.o;
    }

    @Override // com.facebook.imagepipeline.core.j
    public Set<com.facebook.imagepipeline.e.e> f() {
        return Collections.unmodifiableSet(this.v);
    }

    @Override // com.facebook.imagepipeline.core.j
    public r.a g() {
        return this.b;
    }

    @Override // com.facebook.imagepipeline.core.j
    public Context getContext() {
        return this.f2741e;
    }

    @Override // com.facebook.imagepipeline.core.j
    public com.facebook.imagepipeline.decoder.d h() {
        return this.u;
    }

    @Override // com.facebook.imagepipeline.core.j
    public com.facebook.cache.disk.b i() {
        return this.y;
    }

    @Override // com.facebook.imagepipeline.core.j
    @Nullable
    public i.b<com.facebook.cache.common.b> j() {
        return this.c;
    }

    @Override // com.facebook.imagepipeline.core.j
    public boolean k() {
        return this.f2742f;
    }

    @Override // com.facebook.imagepipeline.core.j
    @Nullable
    public com.facebook.common.executors.e l() {
        return this.G;
    }

    @Override // com.facebook.imagepipeline.core.j
    @Nullable
    public Integer m() {
        return this.m;
    }

    @Override // com.facebook.imagepipeline.core.j
    @Nullable
    public com.facebook.imagepipeline.g.d n() {
        return this.f2748l;
    }

    @Override // com.facebook.imagepipeline.core.j
    @Nullable
    public com.facebook.imagepipeline.decoder.c o() {
        return this.z;
    }

    @Override // com.facebook.imagepipeline.core.j
    public boolean p() {
        return this.B;
    }

    @Override // com.facebook.imagepipeline.core.j
    public com.facebook.common.internal.k<s> q() {
        return this.a;
    }

    @Override // com.facebook.imagepipeline.core.j
    @Nullable
    public com.facebook.imagepipeline.decoder.b r() {
        return this.f2747k;
    }

    @Override // com.facebook.imagepipeline.core.j
    public com.facebook.common.internal.k<s> s() {
        return this.f2744h;
    }

    @Override // com.facebook.imagepipeline.core.j
    public b0 t() {
        return this.t;
    }

    @Override // com.facebook.imagepipeline.core.j
    public int u() {
        return this.q;
    }

    @Override // com.facebook.imagepipeline.core.j
    public g v() {
        return this.f2743g;
    }

    @Override // com.facebook.imagepipeline.core.j
    public com.facebook.imagepipeline.b.a w() {
        return this.D;
    }

    @Override // com.facebook.imagepipeline.core.j
    public com.facebook.imagepipeline.cache.a x() {
        return this.H;
    }

    @Override // com.facebook.imagepipeline.core.j
    public com.facebook.imagepipeline.cache.f y() {
        return this.f2740d;
    }

    @Override // com.facebook.imagepipeline.core.j
    public boolean z() {
        return this.x;
    }

    private i(b bVar) {
        com.facebook.common.internal.k<s> kVar;
        com.facebook.imagepipeline.cache.f fVar;
        com.facebook.imagepipeline.cache.n nVar;
        com.facebook.common.memory.c cVar;
        b0 b0Var;
        com.facebook.common.c.b i2;
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.a("ImagePipelineConfig()");
        }
        k s = bVar.C.s();
        this.A = s;
        if (bVar.b == null) {
            Object systemService = bVar.f2751f.getSystemService("activity");
            com.facebook.common.internal.h.g(systemService);
            kVar = new com.facebook.imagepipeline.cache.j((ActivityManager) systemService);
        } else {
            kVar = bVar.b;
        }
        this.a = kVar;
        this.b = bVar.f2749d == null ? new com.facebook.imagepipeline.cache.c() : bVar.f2749d;
        this.c = bVar.c;
        if (bVar.a == null) {
            Bitmap.Config config = Bitmap.Config.ARGB_8888;
        } else {
            Bitmap.Config unused = bVar.a;
        }
        if (bVar.f2750e != null) {
            fVar = bVar.f2750e;
        } else {
            fVar = DefaultCacheKeyFactory.getInstance();
        }
        this.f2740d = fVar;
        Context context = bVar.f2751f;
        com.facebook.common.internal.h.g(context);
        this.f2741e = context;
        this.f2743g = bVar.z == null ? new com.facebook.imagepipeline.core.c(new e()) : bVar.z;
        this.f2742f = bVar.f2752g;
        this.f2744h = bVar.f2753h == null ? new com.facebook.imagepipeline.cache.k() : bVar.f2753h;
        if (bVar.f2755j != null) {
            nVar = bVar.f2755j;
        } else {
            nVar = NoOpImageCacheStatsTracker.getInstance();
        }
        this.f2746j = nVar;
        this.f2747k = bVar.f2756k;
        this.f2748l = H(bVar);
        this.m = bVar.m;
        this.n = bVar.n == null ? new a(this) : bVar.n;
        com.facebook.cache.disk.b G = bVar.o == null ? G(bVar.f2751f) : bVar.o;
        this.o = G;
        if (bVar.p != null) {
            cVar = bVar.p;
        } else {
            cVar = NoOpMemoryTrimmableRegistry.getInstance();
        }
        this.p = cVar;
        this.q = I(bVar, s);
        int i3 = bVar.B < 0 ? BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH : bVar.B;
        this.s = i3;
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.a("ImagePipelineConfig->mNetworkFetcher");
        }
        this.r = bVar.r == null ? new x(i3) : bVar.r;
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.b();
        }
        com.facebook.imagepipeline.bitmaps.f unused2 = bVar.s;
        if (bVar.t != null) {
            b0Var = bVar.t;
        } else {
            b0Var = new b0(a0.n().m());
        }
        this.t = b0Var;
        this.u = bVar.u == null ? new com.facebook.imagepipeline.decoder.f() : bVar.u;
        this.v = bVar.v == null ? new HashSet<>() : bVar.v;
        this.w = bVar.w == null ? new HashSet<>() : bVar.w;
        this.x = bVar.x;
        this.y = bVar.y != null ? bVar.y : G;
        com.facebook.imagepipeline.decoder.c unused3 = bVar.A;
        this.f2745i = bVar.f2754i == null ? new com.facebook.imagepipeline.core.b(b0Var.e()) : bVar.f2754i;
        this.B = bVar.D;
        this.C = bVar.E;
        this.D = bVar.F;
        this.E = bVar.G;
        this.H = bVar.J == null ? new com.facebook.imagepipeline.cache.g() : bVar.J;
        this.F = bVar.H;
        this.G = bVar.I;
        com.facebook.common.c.b m = s.m();
        if (m != null) {
            K(m, s, new com.facebook.imagepipeline.bitmaps.d(t()));
        } else if (s.y() && com.facebook.common.c.c.a && (i2 = com.facebook.common.c.c.i()) != null) {
            K(i2, s, new com.facebook.imagepipeline.bitmaps.d(t()));
        }
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.b();
        }
    }
}
