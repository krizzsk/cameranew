package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* compiled from: LottieDrawable.java */
/* loaded from: classes.dex */
public class g extends Drawable implements Drawable.Callback, Animatable {
    private final Matrix a = new Matrix();
    private com.airbnb.lottie.e b;
    private final com.airbnb.lottie.w.e c;

    /* renamed from: d  reason: collision with root package name */
    private float f350d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f351e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f352f;

    /* renamed from: g  reason: collision with root package name */
    private final ArrayList<q> f353g;

    /* renamed from: h  reason: collision with root package name */
    private final ValueAnimator.AnimatorUpdateListener f354h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private ImageView.ScaleType f355i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private com.airbnb.lottie.u.b f356j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private String f357k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private com.airbnb.lottie.c f358l;
    @Nullable
    private com.airbnb.lottie.u.a m;
    @Nullable
    com.airbnb.lottie.b n;
    @Nullable
    s o;
    private boolean p;
    @Nullable
    private com.airbnb.lottie.model.layer.b q;
    private int r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieDrawable.java */
    /* loaded from: classes.dex */
    public class a implements q {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // com.airbnb.lottie.g.q
        public void a(com.airbnb.lottie.e eVar) {
            g.this.V(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieDrawable.java */
    /* loaded from: classes.dex */
    public class b implements q {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ boolean c;

        b(String str, String str2, boolean z) {
            this.a = str;
            this.b = str2;
            this.c = z;
        }

        @Override // com.airbnb.lottie.g.q
        public void a(com.airbnb.lottie.e eVar) {
            g.this.W(this.a, this.b, this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieDrawable.java */
    /* loaded from: classes.dex */
    public class c implements q {
        final /* synthetic */ int a;
        final /* synthetic */ int b;

        c(int i2, int i3) {
            this.a = i2;
            this.b = i3;
        }

        @Override // com.airbnb.lottie.g.q
        public void a(com.airbnb.lottie.e eVar) {
            g.this.U(this.a, this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieDrawable.java */
    /* loaded from: classes.dex */
    public class d implements q {
        final /* synthetic */ float a;
        final /* synthetic */ float b;

        d(float f2, float f3) {
            this.a = f2;
            this.b = f3;
        }

        @Override // com.airbnb.lottie.g.q
        public void a(com.airbnb.lottie.e eVar) {
            g.this.X(this.a, this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieDrawable.java */
    /* loaded from: classes.dex */
    public class e implements q {
        final /* synthetic */ int a;

        e(int i2) {
            this.a = i2;
        }

        @Override // com.airbnb.lottie.g.q
        public void a(com.airbnb.lottie.e eVar) {
            g.this.O(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieDrawable.java */
    /* loaded from: classes.dex */
    public class f implements q {
        final /* synthetic */ float a;

        f(float f2) {
            this.a = f2;
        }

        @Override // com.airbnb.lottie.g.q
        public void a(com.airbnb.lottie.e eVar) {
            g.this.c0(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieDrawable.java */
    /* renamed from: com.airbnb.lottie.g$g  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0019g implements q {
        final /* synthetic */ com.airbnb.lottie.model.d a;
        final /* synthetic */ Object b;
        final /* synthetic */ com.airbnb.lottie.x.c c;

        C0019g(com.airbnb.lottie.model.d dVar, Object obj, com.airbnb.lottie.x.c cVar) {
            this.a = dVar;
            this.b = obj;
            this.c = cVar;
        }

        @Override // com.airbnb.lottie.g.q
        public void a(com.airbnb.lottie.e eVar) {
            g.this.d(this.a, this.b, this.c);
        }
    }

    /* compiled from: LottieDrawable.java */
    /* loaded from: classes.dex */
    class h implements ValueAnimator.AnimatorUpdateListener {
        h() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (g.this.q != null) {
                g.this.q.G(g.this.c.i());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieDrawable.java */
    /* loaded from: classes.dex */
    public class i implements q {
        i() {
        }

        @Override // com.airbnb.lottie.g.q
        public void a(com.airbnb.lottie.e eVar) {
            g.this.G();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieDrawable.java */
    /* loaded from: classes.dex */
    public class j implements q {
        j() {
        }

        @Override // com.airbnb.lottie.g.q
        public void a(com.airbnb.lottie.e eVar) {
            g.this.K();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieDrawable.java */
    /* loaded from: classes.dex */
    public class k implements q {
        final /* synthetic */ int a;

        k(int i2) {
            this.a = i2;
        }

        @Override // com.airbnb.lottie.g.q
        public void a(com.airbnb.lottie.e eVar) {
            g.this.Y(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieDrawable.java */
    /* loaded from: classes.dex */
    public class l implements q {
        final /* synthetic */ float a;

        l(float f2) {
            this.a = f2;
        }

        @Override // com.airbnb.lottie.g.q
        public void a(com.airbnb.lottie.e eVar) {
            g.this.a0(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieDrawable.java */
    /* loaded from: classes.dex */
    public class m implements q {
        final /* synthetic */ int a;

        m(int i2) {
            this.a = i2;
        }

        @Override // com.airbnb.lottie.g.q
        public void a(com.airbnb.lottie.e eVar) {
            g.this.R(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieDrawable.java */
    /* loaded from: classes.dex */
    public class n implements q {
        final /* synthetic */ float a;

        n(float f2) {
            this.a = f2;
        }

        @Override // com.airbnb.lottie.g.q
        public void a(com.airbnb.lottie.e eVar) {
            g.this.T(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieDrawable.java */
    /* loaded from: classes.dex */
    public class o implements q {
        final /* synthetic */ String a;

        o(String str) {
            this.a = str;
        }

        @Override // com.airbnb.lottie.g.q
        public void a(com.airbnb.lottie.e eVar) {
            g.this.Z(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieDrawable.java */
    /* loaded from: classes.dex */
    public class p implements q {
        final /* synthetic */ String a;

        p(String str) {
            this.a = str;
        }

        @Override // com.airbnb.lottie.g.q
        public void a(com.airbnb.lottie.e eVar) {
            g.this.S(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LottieDrawable.java */
    /* loaded from: classes.dex */
    public interface q {
        void a(com.airbnb.lottie.e eVar);
    }

    public g() {
        com.airbnb.lottie.w.e eVar = new com.airbnb.lottie.w.e();
        this.c = eVar;
        this.f350d = 1.0f;
        this.f351e = true;
        this.f352f = false;
        new HashSet();
        this.f353g = new ArrayList<>();
        h hVar = new h();
        this.f354h = hVar;
        this.r = 255;
        this.u = true;
        this.v = false;
        eVar.addUpdateListener(hVar);
    }

    private void e() {
        this.q = new com.airbnb.lottie.model.layer.b(this, com.airbnb.lottie.v.s.a(this.b), this.b.j(), this.b);
    }

    private void h(@NonNull Canvas canvas) {
        if (ImageView.ScaleType.FIT_XY == this.f355i) {
            i(canvas);
        } else {
            j(canvas);
        }
    }

    private void i(Canvas canvas) {
        float f2;
        if (this.q == null) {
            return;
        }
        int i2 = -1;
        Rect bounds = getBounds();
        float width = bounds.width() / this.b.b().width();
        float height = bounds.height() / this.b.b().height();
        if (this.u) {
            float min = Math.min(width, height);
            if (min < 1.0f) {
                f2 = 1.0f / min;
                width /= f2;
                height /= f2;
            } else {
                f2 = 1.0f;
            }
            if (f2 > 1.0f) {
                i2 = canvas.save();
                float width2 = bounds.width() / 2.0f;
                float height2 = bounds.height() / 2.0f;
                float f3 = width2 * min;
                float f4 = min * height2;
                canvas.translate(width2 - f3, height2 - f4);
                canvas.scale(f2, f2, f3, f4);
            }
        }
        this.a.reset();
        this.a.preScale(width, height);
        this.q.g(canvas, this.a, this.r);
        if (i2 > 0) {
            canvas.restoreToCount(i2);
        }
    }

    private void j(Canvas canvas) {
        float f2;
        if (this.q == null) {
            return;
        }
        float f3 = this.f350d;
        float u = u(canvas);
        if (f3 > u) {
            f2 = this.f350d / u;
        } else {
            u = f3;
            f2 = 1.0f;
        }
        int i2 = -1;
        if (f2 > 1.0f) {
            i2 = canvas.save();
            float width = this.b.b().width() / 2.0f;
            float height = this.b.b().height() / 2.0f;
            float f4 = width * u;
            float f5 = height * u;
            canvas.translate((z() * width) - f4, (z() * height) - f5);
            canvas.scale(f2, f2, f4, f5);
        }
        this.a.reset();
        this.a.preScale(u, u);
        this.q.g(canvas, this.a, this.r);
        if (i2 > 0) {
            canvas.restoreToCount(i2);
        }
    }

    private void l0() {
        if (this.b == null) {
            return;
        }
        float z = z();
        setBounds(0, 0, (int) (this.b.b().width() * z), (int) (this.b.b().height() * z));
    }

    @Nullable
    private Context o() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    private com.airbnb.lottie.u.a p() {
        if (getCallback() == null) {
            return null;
        }
        if (this.m == null) {
            this.m = new com.airbnb.lottie.u.a(getCallback(), this.n);
        }
        return this.m;
    }

    private com.airbnb.lottie.u.b r() {
        if (getCallback() == null) {
            return null;
        }
        com.airbnb.lottie.u.b bVar = this.f356j;
        if (bVar != null && !bVar.b(o())) {
            this.f356j = null;
        }
        if (this.f356j == null) {
            this.f356j = new com.airbnb.lottie.u.b(getCallback(), this.f357k, this.f358l, this.b.i());
        }
        return this.f356j;
    }

    private float u(@NonNull Canvas canvas) {
        return Math.min(canvas.getWidth() / this.b.b().width(), canvas.getHeight() / this.b.b().height());
    }

    public float A() {
        return this.c.n();
    }

    @Nullable
    public s B() {
        return this.o;
    }

    @Nullable
    public Typeface C(String str, String str2) {
        com.airbnb.lottie.u.a p2 = p();
        if (p2 != null) {
            return p2.b(str, str2);
        }
        return null;
    }

    public boolean D() {
        com.airbnb.lottie.w.e eVar = this.c;
        if (eVar == null) {
            return false;
        }
        return eVar.isRunning();
    }

    public boolean E() {
        return this.t;
    }

    public void F() {
        this.f353g.clear();
        this.c.p();
    }

    @MainThread
    public void G() {
        if (this.q == null) {
            this.f353g.add(new i());
            return;
        }
        if (this.f351e || x() == 0) {
            this.c.q();
        }
        if (this.f351e) {
            return;
        }
        O((int) (A() < 0.0f ? v() : t()));
        this.c.h();
    }

    public void H() {
        this.c.removeAllListeners();
    }

    public void I(Animator.AnimatorListener animatorListener) {
        this.c.removeListener(animatorListener);
    }

    public List<com.airbnb.lottie.model.d> J(com.airbnb.lottie.model.d dVar) {
        if (this.q == null) {
            com.airbnb.lottie.w.d.c("Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.q.d(dVar, 0, arrayList, new com.airbnb.lottie.model.d(new String[0]));
        return arrayList;
    }

    @MainThread
    public void K() {
        if (this.q == null) {
            this.f353g.add(new j());
            return;
        }
        if (this.f351e || x() == 0) {
            this.c.u();
        }
        if (this.f351e) {
            return;
        }
        O((int) (A() < 0.0f ? v() : t()));
        this.c.h();
    }

    public void L(boolean z) {
        this.t = z;
    }

    public boolean M(com.airbnb.lottie.e eVar) {
        if (this.b == eVar) {
            return false;
        }
        this.v = false;
        g();
        this.b = eVar;
        e();
        this.c.w(eVar);
        c0(this.c.getAnimatedFraction());
        g0(this.f350d);
        l0();
        Iterator it = new ArrayList(this.f353g).iterator();
        while (it.hasNext()) {
            ((q) it.next()).a(eVar);
            it.remove();
        }
        this.f353g.clear();
        eVar.u(this.s);
        Drawable.Callback callback = getCallback();
        if (callback instanceof ImageView) {
            ImageView imageView = (ImageView) callback;
            imageView.setImageDrawable(null);
            imageView.setImageDrawable(this);
            return true;
        }
        return true;
    }

    public void N(com.airbnb.lottie.b bVar) {
        com.airbnb.lottie.u.a aVar = this.m;
        if (aVar != null) {
            aVar.c(bVar);
        }
    }

    public void O(int i2) {
        if (this.b == null) {
            this.f353g.add(new e(i2));
        } else {
            this.c.x(i2);
        }
    }

    public void P(com.airbnb.lottie.c cVar) {
        this.f358l = cVar;
        com.airbnb.lottie.u.b bVar = this.f356j;
        if (bVar != null) {
            bVar.d(cVar);
        }
    }

    public void Q(@Nullable String str) {
        this.f357k = str;
    }

    public void R(int i2) {
        if (this.b == null) {
            this.f353g.add(new m(i2));
        } else {
            this.c.y(i2 + 0.99f);
        }
    }

    public void S(String str) {
        com.airbnb.lottie.e eVar = this.b;
        if (eVar == null) {
            this.f353g.add(new p(str));
            return;
        }
        com.airbnb.lottie.model.f k2 = eVar.k(str);
        if (k2 != null) {
            R((int) (k2.b + k2.c));
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public void T(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        com.airbnb.lottie.e eVar = this.b;
        if (eVar == null) {
            this.f353g.add(new n(f2));
        } else {
            R((int) com.airbnb.lottie.w.g.j(eVar.o(), this.b.f(), f2));
        }
    }

    public void U(int i2, int i3) {
        if (this.b == null) {
            this.f353g.add(new c(i2, i3));
        } else {
            this.c.z(i2, i3 + 0.99f);
        }
    }

    public void V(String str) {
        com.airbnb.lottie.e eVar = this.b;
        if (eVar == null) {
            this.f353g.add(new a(str));
            return;
        }
        com.airbnb.lottie.model.f k2 = eVar.k(str);
        if (k2 != null) {
            int i2 = (int) k2.b;
            U(i2, ((int) k2.c) + i2);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public void W(String str, String str2, boolean z) {
        com.airbnb.lottie.e eVar = this.b;
        if (eVar == null) {
            this.f353g.add(new b(str, str2, z));
            return;
        }
        com.airbnb.lottie.model.f k2 = eVar.k(str);
        if (k2 != null) {
            int i2 = (int) k2.b;
            com.airbnb.lottie.model.f k3 = this.b.k(str2);
            if (str2 != null) {
                U(i2, (int) (k3.b + (z ? 1.0f : 0.0f)));
                return;
            }
            throw new IllegalArgumentException("Cannot find marker with name " + str2 + ".");
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public void X(@FloatRange(from = 0.0d, to = 1.0d) float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3) {
        com.airbnb.lottie.e eVar = this.b;
        if (eVar == null) {
            this.f353g.add(new d(f2, f3));
        } else {
            U((int) com.airbnb.lottie.w.g.j(eVar.o(), this.b.f(), f2), (int) com.airbnb.lottie.w.g.j(this.b.o(), this.b.f(), f3));
        }
    }

    public void Y(int i2) {
        if (this.b == null) {
            this.f353g.add(new k(i2));
        } else {
            this.c.A(i2);
        }
    }

    public void Z(String str) {
        com.airbnb.lottie.e eVar = this.b;
        if (eVar == null) {
            this.f353g.add(new o(str));
            return;
        }
        com.airbnb.lottie.model.f k2 = eVar.k(str);
        if (k2 != null) {
            Y((int) k2.b);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public void a0(float f2) {
        com.airbnb.lottie.e eVar = this.b;
        if (eVar == null) {
            this.f353g.add(new l(f2));
        } else {
            Y((int) com.airbnb.lottie.w.g.j(eVar.o(), this.b.f(), f2));
        }
    }

    public void b0(boolean z) {
        this.s = z;
        com.airbnb.lottie.e eVar = this.b;
        if (eVar != null) {
            eVar.u(z);
        }
    }

    public void c(Animator.AnimatorListener animatorListener) {
        this.c.addListener(animatorListener);
    }

    public void c0(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        if (this.b == null) {
            this.f353g.add(new f(f2));
            return;
        }
        com.airbnb.lottie.d.a("Drawable#setProgress");
        this.c.x(com.airbnb.lottie.w.g.j(this.b.o(), this.b.f(), f2));
        com.airbnb.lottie.d.b("Drawable#setProgress");
    }

    public <T> void d(com.airbnb.lottie.model.d dVar, T t, com.airbnb.lottie.x.c<T> cVar) {
        if (this.q == null) {
            this.f353g.add(new C0019g(dVar, t, cVar));
            return;
        }
        boolean z = true;
        if (dVar.d() != null) {
            dVar.d().c(t, cVar);
        } else {
            List<com.airbnb.lottie.model.d> J = J(dVar);
            for (int i2 = 0; i2 < J.size(); i2++) {
                J.get(i2).d().c(t, cVar);
            }
            z = true ^ J.isEmpty();
        }
        if (z) {
            invalidateSelf();
            if (t == com.airbnb.lottie.l.A) {
                c0(w());
            }
        }
    }

    public void d0(int i2) {
        this.c.setRepeatCount(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.v = false;
        com.airbnb.lottie.d.a("Drawable#draw");
        if (this.f352f) {
            try {
                h(canvas);
            } catch (Throwable th) {
                com.airbnb.lottie.w.d.b("Lottie crashed in draw!", th);
            }
        } else {
            h(canvas);
        }
        com.airbnb.lottie.d.b("Drawable#draw");
    }

    public void e0(int i2) {
        this.c.setRepeatMode(i2);
    }

    public void f() {
        this.f353g.clear();
        this.c.cancel();
    }

    public void f0(boolean z) {
        this.f352f = z;
    }

    public void g() {
        if (this.c.isRunning()) {
            this.c.cancel();
        }
        this.b = null;
        this.q = null;
        this.f356j = null;
        this.c.g();
        invalidateSelf();
    }

    public void g0(float f2) {
        this.f350d = f2;
        l0();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.r;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        com.airbnb.lottie.e eVar = this.b;
        if (eVar == null) {
            return -1;
        }
        return (int) (eVar.b().height() * z());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        com.airbnb.lottie.e eVar = this.b;
        if (eVar == null) {
            return -1;
        }
        return (int) (eVar.b().width() * z());
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h0(ImageView.ScaleType scaleType) {
        this.f355i = scaleType;
    }

    public void i0(float f2) {
        this.c.B(f2);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.v) {
            return;
        }
        this.v = true;
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return D();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j0(Boolean bool) {
        this.f351e = bool.booleanValue();
    }

    public void k(boolean z) {
        if (this.p == z) {
            return;
        }
        if (Build.VERSION.SDK_INT < 19) {
            com.airbnb.lottie.w.d.c("Merge paths are not supported pre-Kit Kat.");
            return;
        }
        this.p = z;
        if (this.b != null) {
            e();
        }
    }

    public void k0(s sVar) {
    }

    public boolean l() {
        return this.p;
    }

    @MainThread
    public void m() {
        this.f353g.clear();
        this.c.h();
    }

    public boolean m0() {
        return this.o == null && this.b.c().size() > 0;
    }

    public com.airbnb.lottie.e n() {
        return this.b;
    }

    @Nullable
    public Bitmap q(String str) {
        com.airbnb.lottie.u.b r = r();
        if (r != null) {
            return r.a(str);
        }
        return null;
    }

    @Nullable
    public String s() {
        return this.f357k;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j2) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i2) {
        this.r = i2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        com.airbnb.lottie.w.d.c("Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Animatable
    @MainThread
    public void start() {
        G();
    }

    @Override // android.graphics.drawable.Animatable
    @MainThread
    public void stop() {
        m();
    }

    public float t() {
        return this.c.l();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    public float v() {
        return this.c.m();
    }

    @FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, to = 1.0d)
    public float w() {
        return this.c.i();
    }

    public int x() {
        return this.c.getRepeatCount();
    }

    public int y() {
        return this.c.getRepeatMode();
    }

    public float z() {
        return this.f350d;
    }
}
