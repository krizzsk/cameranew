package com.bumptech.glide.request.g;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/* compiled from: ViewTarget.java */
/* loaded from: classes.dex */
public abstract class k<T extends View, Z> extends com.bumptech.glide.request.g.a<Z> {

    /* renamed from: d  reason: collision with root package name */
    private static Integer f835d;
    protected final T b;
    private final a c;

    /* compiled from: ViewTarget.java */
    /* loaded from: classes.dex */
    private static class a {
        private final View a;
        private final List<h> b = new ArrayList();
        private ViewTreeObserver$OnPreDrawListenerC0035a c;

        /* renamed from: d  reason: collision with root package name */
        private Point f836d;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: ViewTarget.java */
        /* renamed from: com.bumptech.glide.request.g.k$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class ViewTreeObserver$OnPreDrawListenerC0035a implements ViewTreeObserver.OnPreDrawListener {
            private final WeakReference<a> a;

            public ViewTreeObserver$OnPreDrawListenerC0035a(a aVar) {
                this.a = new WeakReference<>(aVar);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable("ViewTarget", 2)) {
                    Log.v("ViewTarget", "OnGlobalLayoutListener called listener=" + this);
                }
                a aVar = this.a.get();
                if (aVar != null) {
                    aVar.b();
                    return true;
                }
                return true;
            }
        }

        public a(View view) {
            this.a = view;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            if (this.b.isEmpty()) {
                return;
            }
            int g2 = g();
            int f2 = f();
            if (h(g2) && h(f2)) {
                i(g2, f2);
                ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnPreDrawListener(this.c);
                }
                this.c = null;
            }
        }

        @TargetApi(13)
        private Point c() {
            Point point = this.f836d;
            if (point != null) {
                return point;
            }
            Display defaultDisplay = ((WindowManager) this.a.getContext().getSystemService("window")).getDefaultDisplay();
            if (Build.VERSION.SDK_INT >= 13) {
                Point point2 = new Point();
                this.f836d = point2;
                defaultDisplay.getSize(point2);
            } else {
                this.f836d = new Point(defaultDisplay.getWidth(), defaultDisplay.getHeight());
            }
            return this.f836d;
        }

        private int e(int i2, boolean z) {
            if (i2 == -2) {
                Point c = c();
                return z ? c.y : c.x;
            }
            return i2;
        }

        private int f() {
            ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            if (h(this.a.getHeight())) {
                return this.a.getHeight();
            }
            if (layoutParams != null) {
                return e(layoutParams.height, true);
            }
            return 0;
        }

        private int g() {
            ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            if (h(this.a.getWidth())) {
                return this.a.getWidth();
            }
            if (layoutParams != null) {
                return e(layoutParams.width, false);
            }
            return 0;
        }

        private boolean h(int i2) {
            return i2 > 0 || i2 == -2;
        }

        private void i(int i2, int i3) {
            for (h hVar : this.b) {
                hVar.c(i2, i3);
            }
            this.b.clear();
        }

        public void d(h hVar) {
            int g2 = g();
            int f2 = f();
            if (h(g2) && h(f2)) {
                hVar.c(g2, f2);
                return;
            }
            if (!this.b.contains(hVar)) {
                this.b.add(hVar);
            }
            if (this.c == null) {
                ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
                ViewTreeObserver$OnPreDrawListenerC0035a viewTreeObserver$OnPreDrawListenerC0035a = new ViewTreeObserver$OnPreDrawListenerC0035a(this);
                this.c = viewTreeObserver$OnPreDrawListenerC0035a;
                viewTreeObserver.addOnPreDrawListener(viewTreeObserver$OnPreDrawListenerC0035a);
            }
        }
    }

    public k(T t) {
        Objects.requireNonNull(t, "View must not be null!");
        this.b = t;
        this.c = new a(t);
    }

    private Object j() {
        Integer num = f835d;
        if (num == null) {
            return this.b.getTag();
        }
        return this.b.getTag(num.intValue());
    }

    private void k(Object obj) {
        Integer num = f835d;
        if (num == null) {
            this.b.setTag(obj);
        } else {
            this.b.setTag(num.intValue(), obj);
        }
    }

    @Override // com.bumptech.glide.request.g.a, com.bumptech.glide.request.g.j
    public com.bumptech.glide.request.a e() {
        Object j2 = j();
        if (j2 != null) {
            if (j2 instanceof com.bumptech.glide.request.a) {
                return (com.bumptech.glide.request.a) j2;
            }
            throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
        }
        return null;
    }

    @Override // com.bumptech.glide.request.g.a, com.bumptech.glide.request.g.j
    public void g(com.bumptech.glide.request.a aVar) {
        k(aVar);
    }

    public T getView() {
        return this.b;
    }

    @Override // com.bumptech.glide.request.g.j
    public void i(h hVar) {
        this.c.d(hVar);
    }

    public String toString() {
        return "Target for: " + this.b;
    }
}
