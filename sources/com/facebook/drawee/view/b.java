package com.facebook.drawee.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import com.facebook.common.internal.g;
import com.facebook.common.internal.h;
import com.facebook.drawee.b.b;
import com.facebook.drawee.components.DraweeEventTracker;
import com.facebook.drawee.drawable.s;
import com.facebook.drawee.drawable.t;
import javax.annotation.Nullable;
/* compiled from: DraweeHolder.java */
/* loaded from: classes.dex */
public class b<DH extends com.facebook.drawee.b.b> implements t {
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private DH f2609d;
    private boolean a = false;
    private boolean b = false;
    private boolean c = true;

    /* renamed from: e  reason: collision with root package name */
    private com.facebook.drawee.b.a f2610e = null;

    /* renamed from: f  reason: collision with root package name */
    private final DraweeEventTracker f2611f = DraweeEventTracker.a();

    public b(@Nullable DH dh) {
        if (dh != null) {
            o(dh);
        }
    }

    private void b() {
        if (this.a) {
            return;
        }
        this.f2611f.b(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        this.a = true;
        com.facebook.drawee.b.a aVar = this.f2610e;
        if (aVar == null || aVar.d() == null) {
            return;
        }
        this.f2610e.a();
    }

    private void c() {
        if (this.b && this.c) {
            b();
        } else {
            e();
        }
    }

    public static <DH extends com.facebook.drawee.b.b> b<DH> d(@Nullable DH dh, Context context) {
        b<DH> bVar = new b<>(dh);
        bVar.m(context);
        return bVar;
    }

    private void e() {
        if (this.a) {
            this.f2611f.b(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
            this.a = false;
            if (i()) {
                this.f2610e.c();
            }
        }
    }

    private void p(@Nullable t tVar) {
        Drawable h2 = h();
        if (h2 instanceof s) {
            ((s) h2).l(tVar);
        }
    }

    @Override // com.facebook.drawee.drawable.t
    public void a(boolean z) {
        if (this.c == z) {
            return;
        }
        this.f2611f.b(z ? DraweeEventTracker.Event.ON_DRAWABLE_SHOW : DraweeEventTracker.Event.ON_DRAWABLE_HIDE);
        this.c = z;
        c();
    }

    @Nullable
    public com.facebook.drawee.b.a f() {
        return this.f2610e;
    }

    public DH g() {
        DH dh = this.f2609d;
        h.g(dh);
        return dh;
    }

    @Nullable
    public Drawable h() {
        DH dh = this.f2609d;
        if (dh == null) {
            return null;
        }
        return dh.d();
    }

    public boolean i() {
        com.facebook.drawee.b.a aVar = this.f2610e;
        return aVar != null && aVar.d() == this.f2609d;
    }

    public void j() {
        this.f2611f.b(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
        this.b = true;
        c();
    }

    public void k() {
        this.f2611f.b(DraweeEventTracker.Event.ON_HOLDER_DETACH);
        this.b = false;
        c();
    }

    public boolean l(MotionEvent motionEvent) {
        if (i()) {
            return this.f2610e.onTouchEvent(motionEvent);
        }
        return false;
    }

    public void m(Context context) {
    }

    public void n(@Nullable com.facebook.drawee.b.a aVar) {
        boolean z = this.a;
        if (z) {
            e();
        }
        if (i()) {
            this.f2611f.b(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
            this.f2610e.b(null);
        }
        this.f2610e = aVar;
        if (aVar != null) {
            this.f2611f.b(DraweeEventTracker.Event.ON_SET_CONTROLLER);
            this.f2610e.b(this.f2609d);
        } else {
            this.f2611f.b(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
        }
        if (z) {
            b();
        }
    }

    public void o(DH dh) {
        this.f2611f.b(DraweeEventTracker.Event.ON_SET_HIERARCHY);
        boolean i2 = i();
        p(null);
        h.g(dh);
        DH dh2 = dh;
        this.f2609d = dh2;
        Drawable d2 = dh2.d();
        a(d2 == null || d2.isVisible());
        p(this);
        if (i2) {
            this.f2610e.b(dh);
        }
    }

    @Override // com.facebook.drawee.drawable.t
    public void onDraw() {
        if (this.a) {
            return;
        }
        com.facebook.common.logging.a.x(DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.f2610e)), toString());
        this.b = true;
        this.c = true;
        c();
    }

    public String toString() {
        g.b c = g.c(this);
        c.c("controllerAttached", this.a);
        c.c("holderAttached", this.b);
        c.c("drawableVisible", this.c);
        c.b("events", this.f2611f.toString());
        return c.toString();
    }
}
