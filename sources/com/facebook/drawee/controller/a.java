package com.facebook.drawee.controller;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.MotionEvent;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.g;
import com.facebook.common.internal.h;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.drawee.components.DraweeEventTracker;
import com.facebook.drawee.drawable.f;
import com.facebook.drawee.gestures.GestureDetector;
import com.facebook.fresco.ui.common.b;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
/* compiled from: AbstractDraweeController.java */
@NotThreadSafe
/* loaded from: classes.dex */
public abstract class a<T, INFO> implements com.facebook.drawee.b.a, DeferredReleaser.a, GestureDetector.a {
    private static final Map<String, Object> v = ImmutableMap.of("component_tag", "drawee");
    private static final Map<String, Object> w = ImmutableMap.of(FirebaseAnalytics.Param.ORIGIN, "memory_bitmap", "origin_sub", "shortcut");
    private static final Class<?> x = a.class;
    private final DeferredReleaser b;
    private final Executor c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private com.facebook.drawee.components.b f2493d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private GestureDetector f2494e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    protected com.facebook.drawee.controller.c<INFO> f2495f;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    protected com.facebook.fresco.ui.common.e f2497h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private com.facebook.drawee.b.c f2498i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private Drawable f2499j;

    /* renamed from: k  reason: collision with root package name */
    private String f2500k;

    /* renamed from: l  reason: collision with root package name */
    private Object f2501l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    @Nullable
    private String q;
    @Nullable
    private com.facebook.datasource.b<T> r;
    @Nullable
    private T s;
    @Nullable
    protected Drawable u;
    private final DraweeEventTracker a = DraweeEventTracker.a();

    /* renamed from: g  reason: collision with root package name */
    protected com.facebook.fresco.ui.common.d<INFO> f2496g = new com.facebook.fresco.ui.common.d<>();
    private boolean t = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractDraweeController.java */
    /* renamed from: com.facebook.drawee.controller.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0093a implements f.a {
        C0093a() {
        }

        @Override // com.facebook.drawee.drawable.f.a
        public void a() {
            a aVar = a.this;
            com.facebook.fresco.ui.common.e eVar = aVar.f2497h;
            if (eVar != null) {
                eVar.b(aVar.f2500k);
            }
        }

        @Override // com.facebook.drawee.drawable.f.a
        public void b() {
        }

        @Override // com.facebook.drawee.drawable.f.a
        public void c() {
            a aVar = a.this;
            com.facebook.fresco.ui.common.e eVar = aVar.f2497h;
            if (eVar != null) {
                eVar.a(aVar.f2500k);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractDraweeController.java */
    /* loaded from: classes.dex */
    public class b extends com.facebook.datasource.a<T> {
        final /* synthetic */ String a;
        final /* synthetic */ boolean b;

        b(String str, boolean z) {
            this.a = str;
            this.b = z;
        }

        @Override // com.facebook.datasource.a, com.facebook.datasource.d
        public void d(com.facebook.datasource.b<T> bVar) {
            boolean b = bVar.b();
            a.this.L(this.a, bVar, bVar.getProgress(), b);
        }

        @Override // com.facebook.datasource.a
        public void e(com.facebook.datasource.b<T> bVar) {
            a.this.I(this.a, bVar, bVar.c(), true);
        }

        @Override // com.facebook.datasource.a
        public void f(com.facebook.datasource.b<T> bVar) {
            boolean b = bVar.b();
            boolean e2 = bVar.e();
            float progress = bVar.getProgress();
            T result = bVar.getResult();
            if (result != null) {
                a.this.K(this.a, bVar, result, progress, b, this.b, e2);
            } else if (b) {
                a.this.I(this.a, bVar, new NullPointerException(), true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractDraweeController.java */
    /* loaded from: classes.dex */
    public static class c<INFO> extends e<INFO> {
        private c() {
        }

        public static <INFO> c<INFO> j(com.facebook.drawee.controller.c<? super INFO> cVar, com.facebook.drawee.controller.c<? super INFO> cVar2) {
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.a("AbstractDraweeController#createInternal");
            }
            c<INFO> cVar3 = new c<>();
            cVar3.g(cVar);
            cVar3.g(cVar2);
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.b();
            }
            return cVar3;
        }
    }

    public a(DeferredReleaser deferredReleaser, Executor executor, String str, Object obj) {
        this.b = deferredReleaser;
        this.c = executor;
        A(str, obj);
    }

    private synchronized void A(String str, Object obj) {
        DeferredReleaser deferredReleaser;
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.a("AbstractDraweeController#init");
        }
        this.a.b(DraweeEventTracker.Event.ON_INIT_CONTROLLER);
        if (!this.t && (deferredReleaser = this.b) != null) {
            deferredReleaser.a(this);
        }
        this.m = false;
        N();
        this.p = false;
        com.facebook.drawee.components.b bVar = this.f2493d;
        if (bVar != null) {
            bVar.a();
        }
        GestureDetector gestureDetector = this.f2494e;
        if (gestureDetector != null) {
            gestureDetector.a();
            this.f2494e.f(this);
        }
        com.facebook.drawee.controller.c<INFO> cVar = this.f2495f;
        if (cVar instanceof c) {
            ((c) cVar).h();
        } else {
            this.f2495f = null;
        }
        com.facebook.drawee.b.c cVar2 = this.f2498i;
        if (cVar2 != null) {
            cVar2.reset();
            this.f2498i.f(null);
            this.f2498i = null;
        }
        this.f2499j = null;
        if (com.facebook.common.logging.a.m(2)) {
            com.facebook.common.logging.a.r(x, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.f2500k, str);
        }
        this.f2500k = str;
        this.f2501l = obj;
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.b();
        }
        if (this.f2497h != null) {
            b0();
        }
    }

    private boolean C(String str, com.facebook.datasource.b<T> bVar) {
        if (bVar == null && this.r == null) {
            return true;
        }
        return str.equals(this.f2500k) && bVar == this.r && this.n;
    }

    private void D(String str, Throwable th) {
        if (com.facebook.common.logging.a.m(2)) {
            com.facebook.common.logging.a.s(x, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.f2500k, str, th);
        }
    }

    private void E(String str, T t) {
        if (com.facebook.common.logging.a.m(2)) {
            com.facebook.common.logging.a.t(x, "controller %x %s: %s: image: %s %x", Integer.valueOf(System.identityHashCode(this)), this.f2500k, str, v(t), Integer.valueOf(w(t)));
        }
    }

    private b.a F(@Nullable com.facebook.datasource.b<T> bVar, @Nullable INFO info, @Nullable Uri uri) {
        return G(bVar == null ? null : bVar.getExtras(), H(info), uri);
    }

    private b.a G(@Nullable Map<String, Object> map, @Nullable Map<String, Object> map2, @Nullable Uri uri) {
        String str;
        PointF pointF;
        com.facebook.drawee.b.c cVar = this.f2498i;
        if (cVar instanceof com.facebook.drawee.generic.a) {
            String valueOf = String.valueOf(((com.facebook.drawee.generic.a) cVar).m());
            pointF = ((com.facebook.drawee.generic.a) this.f2498i).l();
            str = valueOf;
        } else {
            str = null;
            pointF = null;
        }
        return com.facebook.s.b.a.a(v, w, map, s(), str, pointF, map2, n(), uri);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(String str, com.facebook.datasource.b<T> bVar, Throwable th, boolean z) {
        Drawable drawable;
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.a("AbstractDraweeController#onFailureInternal");
        }
        if (!C(str, bVar)) {
            D("ignore_old_datasource @ onFailure", th);
            bVar.close();
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.b();
                return;
            }
            return;
        }
        this.a.b(z ? DraweeEventTracker.Event.ON_DATASOURCE_FAILURE : DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT);
        if (z) {
            D("final_failed @ onFailure", th);
            this.r = null;
            this.o = true;
            if (this.p && (drawable = this.u) != null) {
                this.f2498i.e(drawable, 1.0f, true);
            } else if (d0()) {
                this.f2498i.a(th);
            } else {
                this.f2498i.b(th);
            }
            Q(th, bVar);
        } else {
            D("intermediate_failed @ onFailure", th);
            R(th);
        }
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(String str, com.facebook.datasource.b<T> bVar, @Nullable T t, float f2, boolean z, boolean z2, boolean z3) {
        try {
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.a("AbstractDraweeController#onNewResultInternal");
            }
            if (!C(str, bVar)) {
                E("ignore_old_datasource @ onNewResult", t);
                O(t);
                bVar.close();
                if (com.facebook.imagepipeline.f.b.d()) {
                    com.facebook.imagepipeline.f.b.b();
                    return;
                }
                return;
            }
            this.a.b(z ? DraweeEventTracker.Event.ON_DATASOURCE_RESULT : DraweeEventTracker.Event.ON_DATASOURCE_RESULT_INT);
            try {
                Drawable l2 = l(t);
                T t2 = this.s;
                Drawable drawable = this.u;
                this.s = t;
                this.u = l2;
                if (z) {
                    E("set_final_result @ onNewResult", t);
                    this.r = null;
                    this.f2498i.e(l2, 1.0f, z2);
                    V(str, t, bVar);
                } else if (z3) {
                    E("set_temporary_result @ onNewResult", t);
                    this.f2498i.e(l2, 1.0f, z2);
                    V(str, t, bVar);
                } else {
                    E("set_intermediate_result @ onNewResult", t);
                    this.f2498i.e(l2, f2, z2);
                    S(str, t);
                }
                if (drawable != null && drawable != l2) {
                    M(drawable);
                }
                if (t2 != null && t2 != t) {
                    E("release_previous_result @ onNewResult", t2);
                    O(t2);
                }
                if (com.facebook.imagepipeline.f.b.d()) {
                    com.facebook.imagepipeline.f.b.b();
                }
            } catch (Exception e2) {
                E("drawable_failed @ onNewResult", t);
                O(t);
                I(str, bVar, e2, z);
                if (com.facebook.imagepipeline.f.b.d()) {
                    com.facebook.imagepipeline.f.b.b();
                }
            }
        } catch (Throwable th) {
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.b();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(String str, com.facebook.datasource.b<T> bVar, float f2, boolean z) {
        if (!C(str, bVar)) {
            D("ignore_old_datasource @ onProgress", null);
            bVar.close();
        } else if (z) {
        } else {
            this.f2498i.c(f2, false);
        }
    }

    private void N() {
        Map<String, Object> map;
        boolean z = this.n;
        this.n = false;
        this.o = false;
        com.facebook.datasource.b<T> bVar = this.r;
        Map<String, Object> map2 = null;
        if (bVar != null) {
            map = bVar.getExtras();
            this.r.close();
            this.r = null;
        } else {
            map = null;
        }
        Drawable drawable = this.u;
        if (drawable != null) {
            M(drawable);
        }
        if (this.q != null) {
            this.q = null;
        }
        this.u = null;
        T t = this.s;
        if (t != null) {
            Map<String, Object> H = H(x(t));
            E("release", this.s);
            O(this.s);
            this.s = null;
            map2 = H;
        }
        if (z) {
            T(map, map2);
        }
    }

    private void Q(Throwable th, @Nullable com.facebook.datasource.b<T> bVar) {
        b.a F = F(bVar, null, null);
        o().b(this.f2500k, th);
        p().i(this.f2500k, th, F);
    }

    private void R(Throwable th) {
        o().f(this.f2500k, th);
        p().d(this.f2500k);
    }

    private void S(String str, @Nullable T t) {
        INFO x2 = x(t);
        o().a(str, x2);
        p().a(str, x2);
    }

    private void T(@Nullable Map<String, Object> map, @Nullable Map<String, Object> map2) {
        o().c(this.f2500k);
        p().e(this.f2500k, G(map, map2, null));
    }

    private void V(String str, @Nullable T t, @Nullable com.facebook.datasource.b<T> bVar) {
        INFO x2 = x(t);
        o().d(str, x2, e());
        p().j(str, x2, F(bVar, x2, null));
    }

    private void b0() {
        com.facebook.drawee.b.c cVar = this.f2498i;
        if (cVar instanceof com.facebook.drawee.generic.a) {
            ((com.facebook.drawee.generic.a) cVar).A(new C0093a());
        }
    }

    private boolean d0() {
        com.facebook.drawee.components.b bVar;
        return this.o && (bVar = this.f2493d) != null && bVar.e();
    }

    @Nullable
    private Rect s() {
        com.facebook.drawee.b.c cVar = this.f2498i;
        if (cVar == null) {
            return null;
        }
        return cVar.getBounds();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B(String str, Object obj) {
        A(str, obj);
        this.t = false;
    }

    @Nullable
    public abstract Map<String, Object> H(INFO info);

    /* JADX INFO: Access modifiers changed from: protected */
    public void J(String str, T t) {
    }

    protected abstract void M(@Nullable Drawable drawable);

    protected abstract void O(@Nullable T t);

    public void P(com.facebook.fresco.ui.common.b<INFO> bVar) {
        this.f2496g.o(bVar);
    }

    protected void U(com.facebook.datasource.b<T> bVar, @Nullable INFO info) {
        o().e(this.f2500k, this.f2501l);
        p().h(this.f2500k, this.f2501l, F(bVar, info, y()));
    }

    public void W(@Nullable String str) {
        this.q = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void X(@Nullable Drawable drawable) {
        this.f2499j = drawable;
        com.facebook.drawee.b.c cVar = this.f2498i;
        if (cVar != null) {
            cVar.f(drawable);
        }
    }

    public void Y(@Nullable d dVar) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Z(@Nullable GestureDetector gestureDetector) {
        this.f2494e = gestureDetector;
        if (gestureDetector != null) {
            gestureDetector.f(this);
        }
    }

    @Override // com.facebook.drawee.b.a
    public void a() {
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.a("AbstractDraweeController#onAttach");
        }
        if (com.facebook.common.logging.a.m(2)) {
            com.facebook.common.logging.a.r(x, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.f2500k, this.n ? "request already submitted" : "request needs submit");
        }
        this.a.b(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        h.g(this.f2498i);
        this.b.a(this);
        this.m = true;
        if (!this.n) {
            e0();
        }
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a0(boolean z) {
        this.p = z;
    }

    @Override // com.facebook.drawee.b.a
    public void b(@Nullable com.facebook.drawee.b.b bVar) {
        if (com.facebook.common.logging.a.m(2)) {
            com.facebook.common.logging.a.r(x, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.f2500k, bVar);
        }
        this.a.b(bVar != null ? DraweeEventTracker.Event.ON_SET_HIERARCHY : DraweeEventTracker.Event.ON_CLEAR_HIERARCHY);
        if (this.n) {
            this.b.a(this);
            release();
        }
        com.facebook.drawee.b.c cVar = this.f2498i;
        if (cVar != null) {
            cVar.f(null);
            this.f2498i = null;
        }
        if (bVar != null) {
            h.b(Boolean.valueOf(bVar instanceof com.facebook.drawee.b.c));
            com.facebook.drawee.b.c cVar2 = (com.facebook.drawee.b.c) bVar;
            this.f2498i = cVar2;
            cVar2.f(this.f2499j);
        }
        if (this.f2497h != null) {
            b0();
        }
    }

    @Override // com.facebook.drawee.b.a
    public void c() {
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.a("AbstractDraweeController#onDetach");
        }
        if (com.facebook.common.logging.a.m(2)) {
            com.facebook.common.logging.a.q(x, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.f2500k);
        }
        this.a.b(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
        this.m = false;
        this.b.c(this);
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.b();
        }
    }

    protected boolean c0() {
        return d0();
    }

    @Override // com.facebook.drawee.b.a
    @Nullable
    public com.facebook.drawee.b.b d() {
        return this.f2498i;
    }

    @Override // com.facebook.drawee.b.a
    @Nullable
    public Animatable e() {
        Drawable drawable = this.u;
        if (drawable instanceof Animatable) {
            return (Animatable) drawable;
        }
        return null;
    }

    protected void e0() {
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.a("AbstractDraweeController#submitRequest");
        }
        T m = m();
        if (m != null) {
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.a("AbstractDraweeController#submitRequest->cache");
            }
            this.r = null;
            this.n = true;
            this.o = false;
            this.a.b(DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT);
            U(this.r, x(m));
            J(this.f2500k, m);
            K(this.f2500k, this.r, m, 1.0f, true, true, true);
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.b();
            }
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.b();
                return;
            }
            return;
        }
        this.a.b(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
        this.f2498i.c(0.0f, true);
        this.n = true;
        this.o = false;
        com.facebook.datasource.b<T> r = r();
        this.r = r;
        U(r, null);
        if (com.facebook.common.logging.a.m(2)) {
            com.facebook.common.logging.a.r(x, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.f2500k, Integer.valueOf(System.identityHashCode(this.r)));
        }
        this.r.d(new b(this.f2500k, this.r.a()), this.c);
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.b();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void j(com.facebook.drawee.controller.c<? super INFO> cVar) {
        h.g(cVar);
        com.facebook.drawee.controller.c<INFO> cVar2 = this.f2495f;
        if (cVar2 instanceof c) {
            ((c) cVar2).g(cVar);
        } else if (cVar2 != null) {
            this.f2495f = c.j(cVar2, cVar);
        } else {
            this.f2495f = cVar;
        }
    }

    public void k(com.facebook.fresco.ui.common.b<INFO> bVar) {
        this.f2496g.m(bVar);
    }

    protected abstract Drawable l(T t);

    @Nullable
    protected T m() {
        return null;
    }

    public Object n() {
        return this.f2501l;
    }

    protected com.facebook.drawee.controller.c<INFO> o() {
        com.facebook.drawee.controller.c<INFO> cVar = this.f2495f;
        return cVar == null ? com.facebook.drawee.controller.b.g() : cVar;
    }

    @Override // com.facebook.drawee.gestures.GestureDetector.a
    public boolean onClick() {
        if (com.facebook.common.logging.a.m(2)) {
            com.facebook.common.logging.a.q(x, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.f2500k);
        }
        if (d0()) {
            this.f2493d.b();
            this.f2498i.reset();
            e0();
            return true;
        }
        return false;
    }

    @Override // com.facebook.drawee.b.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (com.facebook.common.logging.a.m(2)) {
            com.facebook.common.logging.a.r(x, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.f2500k, motionEvent);
        }
        GestureDetector gestureDetector = this.f2494e;
        if (gestureDetector == null) {
            return false;
        }
        if (gestureDetector.b() || c0()) {
            this.f2494e.d(motionEvent);
            return true;
        }
        return false;
    }

    protected com.facebook.fresco.ui.common.b<INFO> p() {
        return this.f2496g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public Drawable q() {
        return this.f2499j;
    }

    protected abstract com.facebook.datasource.b<T> r();

    @Override // com.facebook.drawee.components.DeferredReleaser.a
    public void release() {
        this.a.b(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
        com.facebook.drawee.components.b bVar = this.f2493d;
        if (bVar != null) {
            bVar.c();
        }
        GestureDetector gestureDetector = this.f2494e;
        if (gestureDetector != null) {
            gestureDetector.e();
        }
        com.facebook.drawee.b.c cVar = this.f2498i;
        if (cVar != null) {
            cVar.reset();
        }
        N();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public GestureDetector t() {
        return this.f2494e;
    }

    public String toString() {
        g.b c2 = g.c(this);
        c2.c("isAttached", this.m);
        c2.c("isRequestSubmitted", this.n);
        c2.c("hasFetchFailed", this.o);
        c2.a("fetchedImage", w(this.s));
        c2.b("events", this.a.toString());
        return c2.toString();
    }

    public String u() {
        return this.f2500k;
    }

    protected String v(@Nullable T t) {
        return t != null ? t.getClass().getSimpleName() : "<null>";
    }

    protected int w(@Nullable T t) {
        return System.identityHashCode(t);
    }

    @Nullable
    protected abstract INFO x(T t);

    @Nullable
    protected Uri y() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.facebook.drawee.components.b z() {
        if (this.f2493d == null) {
            this.f2493d = new com.facebook.drawee.components.b();
        }
        return this.f2493d;
    }
}
