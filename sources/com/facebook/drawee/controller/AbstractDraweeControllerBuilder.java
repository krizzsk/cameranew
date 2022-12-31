package com.facebook.drawee.controller;

import android.content.Context;
import android.graphics.drawable.Animatable;
import com.facebook.common.internal.g;
import com.facebook.common.internal.h;
import com.facebook.common.internal.k;
import com.facebook.datasource.f;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.gestures.GestureDetector;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.Nullable;
/* loaded from: classes.dex */
public abstract class AbstractDraweeControllerBuilder<BUILDER extends AbstractDraweeControllerBuilder<BUILDER, REQUEST, IMAGE, INFO>, REQUEST, IMAGE, INFO> implements com.facebook.drawee.b.d {
    private static final c<Object> q = new a();
    private static final NullPointerException r = new NullPointerException("No image request was specified!");
    private static final AtomicLong s = new AtomicLong();
    private final Context a;
    private final Set<c> b;
    private final Set<com.facebook.fresco.ui.common.b> c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private Object f2481d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private REQUEST f2482e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private REQUEST f2483f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private REQUEST[] f2484g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f2485h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private k<com.facebook.datasource.b<IMAGE>> f2486i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private c<? super INFO> f2487j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private d f2488k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f2489l;
    private boolean m;
    private boolean n;
    @Nullable
    private String o;
    @Nullable
    private com.facebook.drawee.b.a p;

    /* loaded from: classes.dex */
    public enum CacheLevel {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    /* loaded from: classes.dex */
    static class a extends com.facebook.drawee.controller.b<Object> {
        a() {
        }

        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void d(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements k<com.facebook.datasource.b<IMAGE>> {
        final /* synthetic */ com.facebook.drawee.b.a a;
        final /* synthetic */ String b;
        final /* synthetic */ Object c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Object f2490d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ CacheLevel f2491e;

        b(com.facebook.drawee.b.a aVar, String str, Object obj, Object obj2, CacheLevel cacheLevel) {
            this.a = aVar;
            this.b = str;
            this.c = obj;
            this.f2490d = obj2;
            this.f2491e = cacheLevel;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.common.internal.k
        /* renamed from: a */
        public com.facebook.datasource.b<IMAGE> get() {
            return AbstractDraweeControllerBuilder.this.i(this.a, this.b, this.c, this.f2490d, this.f2491e);
        }

        public String toString() {
            g.b c = g.c(this);
            c.b(SocialConstants.TYPE_REQUEST, this.c.toString());
            return c.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDraweeControllerBuilder(Context context, Set<c> set, Set<com.facebook.fresco.ui.common.b> set2) {
        this.a = context;
        this.b = set;
        this.c = set2;
        s();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String e() {
        return String.valueOf(s.getAndIncrement());
    }

    private void s() {
        this.f2481d = null;
        this.f2482e = null;
        this.f2483f = null;
        this.f2484g = null;
        this.f2485h = true;
        this.f2487j = null;
        this.f2488k = null;
        this.f2489l = false;
        this.m = false;
        this.p = null;
        this.o = null;
    }

    public BUILDER A(@Nullable c<? super INFO> cVar) {
        this.f2487j = cVar;
        r();
        return this;
    }

    public BUILDER B(@Nullable REQUEST request) {
        this.f2482e = request;
        r();
        return this;
    }

    public BUILDER C(@Nullable com.facebook.drawee.b.a aVar) {
        this.p = aVar;
        r();
        return this;
    }

    protected void D() {
        boolean z = false;
        h.j(this.f2484g == null || this.f2482e == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (this.f2486i == null || (this.f2484g == null && this.f2482e == null && this.f2483f == null)) {
            z = true;
        }
        h.j(z, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
    }

    @Override // com.facebook.drawee.b.d
    public /* bridge */ /* synthetic */ com.facebook.drawee.b.d b(@Nullable com.facebook.drawee.b.a aVar) {
        C(aVar);
        return this;
    }

    @Override // com.facebook.drawee.b.d
    /* renamed from: c */
    public com.facebook.drawee.controller.a build() {
        REQUEST request;
        D();
        if (this.f2482e == null && this.f2484g == null && (request = this.f2483f) != null) {
            this.f2482e = request;
            this.f2483f = null;
        }
        return d();
    }

    protected com.facebook.drawee.controller.a d() {
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.a("AbstractDraweeControllerBuilder#buildController");
        }
        com.facebook.drawee.controller.a w = w();
        w.a0(q());
        w.W(g());
        w.Y(h());
        v(w);
        t(w);
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.b();
        }
        return w;
    }

    @Nullable
    public Object f() {
        return this.f2481d;
    }

    @Nullable
    public String g() {
        return this.o;
    }

    @Nullable
    public d h() {
        return this.f2488k;
    }

    protected abstract com.facebook.datasource.b<IMAGE> i(com.facebook.drawee.b.a aVar, String str, REQUEST request, Object obj, CacheLevel cacheLevel);

    protected k<com.facebook.datasource.b<IMAGE>> j(com.facebook.drawee.b.a aVar, String str, REQUEST request) {
        return k(aVar, str, request, CacheLevel.FULL_FETCH);
    }

    protected k<com.facebook.datasource.b<IMAGE>> k(com.facebook.drawee.b.a aVar, String str, REQUEST request, CacheLevel cacheLevel) {
        return new b(aVar, str, request, f(), cacheLevel);
    }

    protected k<com.facebook.datasource.b<IMAGE>> l(com.facebook.drawee.b.a aVar, String str, REQUEST[] requestArr, boolean z) {
        ArrayList arrayList = new ArrayList(requestArr.length * 2);
        if (z) {
            for (REQUEST request : requestArr) {
                arrayList.add(k(aVar, str, request, CacheLevel.BITMAP_MEMORY_CACHE));
            }
        }
        for (REQUEST request2 : requestArr) {
            arrayList.add(j(aVar, str, request2));
        }
        return com.facebook.datasource.e.b(arrayList);
    }

    @Nullable
    public REQUEST[] m() {
        return this.f2484g;
    }

    @Nullable
    public REQUEST n() {
        return this.f2482e;
    }

    @Nullable
    public REQUEST o() {
        return this.f2483f;
    }

    @Nullable
    public com.facebook.drawee.b.a p() {
        return this.p;
    }

    public boolean q() {
        return this.n;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final BUILDER r() {
        return this;
    }

    protected void t(com.facebook.drawee.controller.a aVar) {
        Set<c> set = this.b;
        if (set != null) {
            for (c cVar : set) {
                aVar.j(cVar);
            }
        }
        Set<com.facebook.fresco.ui.common.b> set2 = this.c;
        if (set2 != null) {
            for (com.facebook.fresco.ui.common.b bVar : set2) {
                aVar.k(bVar);
            }
        }
        c<? super INFO> cVar2 = this.f2487j;
        if (cVar2 != null) {
            aVar.j(cVar2);
        }
        if (this.m) {
            aVar.j(q);
        }
    }

    protected void u(com.facebook.drawee.controller.a aVar) {
        if (aVar.t() == null) {
            aVar.Z(GestureDetector.c(this.a));
        }
    }

    protected void v(com.facebook.drawee.controller.a aVar) {
        if (this.f2489l) {
            aVar.z().d(this.f2489l);
            u(aVar);
        }
    }

    protected abstract com.facebook.drawee.controller.a w();

    /* JADX INFO: Access modifiers changed from: protected */
    public k<com.facebook.datasource.b<IMAGE>> x(com.facebook.drawee.b.a aVar, String str) {
        k<com.facebook.datasource.b<IMAGE>> kVar = this.f2486i;
        if (kVar != null) {
            return kVar;
        }
        k<com.facebook.datasource.b<IMAGE>> kVar2 = null;
        REQUEST request = this.f2482e;
        if (request != null) {
            kVar2 = j(aVar, str, request);
        } else {
            REQUEST[] requestArr = this.f2484g;
            if (requestArr != null) {
                kVar2 = l(aVar, str, requestArr, this.f2485h);
            }
        }
        if (kVar2 != null && this.f2483f != null) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(kVar2);
            arrayList.add(j(aVar, str, this.f2483f));
            kVar2 = f.c(arrayList, false);
        }
        return kVar2 == null ? com.facebook.datasource.c.a(r) : kVar2;
    }

    public BUILDER y(boolean z) {
        this.m = z;
        r();
        return this;
    }

    public BUILDER z(Object obj) {
        this.f2481d = obj;
        r();
        return this;
    }
}
