package com.facebook.s.a.c;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.facebook.drawee.drawable.d;
import javax.annotation.Nullable;
/* compiled from: AnimatedDrawable2.java */
/* loaded from: classes.dex */
public class a extends Drawable implements Animatable, com.facebook.r.a.a {
    private static final Class<?> r = a.class;
    private static final com.facebook.s.a.c.b s = new c();
    @Nullable
    private com.facebook.s.a.a.a a;
    @Nullable
    private com.facebook.s.a.d.b b;
    private volatile boolean c;

    /* renamed from: d  reason: collision with root package name */
    private long f3180d;

    /* renamed from: e  reason: collision with root package name */
    private long f3181e;

    /* renamed from: f  reason: collision with root package name */
    private long f3182f;

    /* renamed from: g  reason: collision with root package name */
    private int f3183g;

    /* renamed from: h  reason: collision with root package name */
    private long f3184h;

    /* renamed from: i  reason: collision with root package name */
    private long f3185i;

    /* renamed from: j  reason: collision with root package name */
    private int f3186j;

    /* renamed from: k  reason: collision with root package name */
    private long f3187k;

    /* renamed from: l  reason: collision with root package name */
    private long f3188l;
    private int m;
    private volatile com.facebook.s.a.c.b n;
    @Nullable
    private volatile b o;
    @Nullable
    private d p;
    private final Runnable q;

    /* compiled from: AnimatedDrawable2.java */
    /* renamed from: com.facebook.s.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class RunnableC0115a implements Runnable {
        RunnableC0115a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            aVar.unscheduleSelf(aVar.q);
            a.this.invalidateSelf();
        }
    }

    /* compiled from: AnimatedDrawable2.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(a aVar, com.facebook.s.a.d.b bVar, int i2, boolean z, boolean z2, long j2, long j3, long j4, long j5, long j6, long j7, long j8);
    }

    public a() {
        this(null);
    }

    @Nullable
    private static com.facebook.s.a.d.b c(@Nullable com.facebook.s.a.a.a aVar) {
        if (aVar == null) {
            return null;
        }
        return new com.facebook.s.a.d.a(aVar);
    }

    private long e() {
        return SystemClock.uptimeMillis();
    }

    private void f() {
        this.m++;
        if (com.facebook.common.logging.a.m(2)) {
            com.facebook.common.logging.a.p(r, "Dropped a frame. Count: %s", Integer.valueOf(this.m));
        }
    }

    private void g(long j2) {
        long j3 = this.f3180d + j2;
        this.f3182f = j3;
        scheduleSelf(this.q, j3);
    }

    @Override // com.facebook.r.a.a
    public void a() {
        com.facebook.s.a.a.a aVar = this.a;
        if (aVar != null) {
            aVar.clear();
        }
    }

    @Nullable
    public com.facebook.s.a.a.a d() {
        return this.a;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        long j2;
        long j3;
        a aVar;
        long j4;
        if (this.a == null || this.b == null) {
            return;
        }
        long e2 = e();
        long max = this.c ? (e2 - this.f3180d) + this.f3188l : Math.max(this.f3181e, 0L);
        int b2 = this.b.b(max, this.f3181e);
        if (b2 == -1) {
            b2 = this.a.a() - 1;
            this.n.b(this);
            this.c = false;
        } else if (b2 == 0 && this.f3183g != -1 && e2 >= this.f3182f) {
            this.n.d(this);
        }
        int i2 = b2;
        boolean g2 = this.a.g(this, canvas, i2);
        if (g2) {
            this.n.c(this, i2);
            this.f3183g = i2;
        }
        if (!g2) {
            f();
        }
        long e3 = e();
        if (this.c) {
            long a = this.b.a(e3 - this.f3180d);
            if (a != -1) {
                long j5 = this.f3187k + a;
                g(j5);
                j3 = j5;
            } else {
                this.n.b(this);
                this.c = false;
                j3 = -1;
            }
            j2 = a;
        } else {
            j2 = -1;
            j3 = -1;
        }
        b bVar = this.o;
        if (bVar != null) {
            bVar.a(this, this.b, i2, g2, this.c, this.f3180d, max, this.f3181e, e2, e3, j2, j3);
            aVar = this;
            j4 = max;
        } else {
            aVar = this;
            j4 = max;
        }
        aVar.f3181e = j4;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        com.facebook.s.a.a.a aVar = this.a;
        if (aVar == null) {
            return super.getIntrinsicHeight();
        }
        return aVar.c();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        com.facebook.s.a.a.a aVar = this.a;
        if (aVar == null) {
            return super.getIntrinsicWidth();
        }
        return aVar.e();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public void h(@Nullable com.facebook.s.a.a.a aVar) {
        this.a = aVar;
        if (aVar != null) {
            this.b = new com.facebook.s.a.d.a(aVar);
            aVar.d(getBounds());
            d dVar = this.p;
            if (dVar != null) {
                dVar.a(this);
            }
        }
        this.b = c(this.a);
        stop();
    }

    public void i(@Nullable com.facebook.s.a.c.b bVar) {
        if (bVar == null) {
            bVar = s;
        }
        this.n = bVar;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.c;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        com.facebook.s.a.a.a aVar = this.a;
        if (aVar != null) {
            aVar.d(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i2) {
        if (this.c) {
            return false;
        }
        long j2 = i2;
        if (this.f3181e != j2) {
            this.f3181e = j2;
            invalidateSelf();
            return true;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        if (this.p == null) {
            this.p = new d();
        }
        this.p.b(i2);
        com.facebook.s.a.a.a aVar = this.a;
        if (aVar != null) {
            aVar.j(i2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        if (this.p == null) {
            this.p = new d();
        }
        this.p.c(colorFilter);
        com.facebook.s.a.a.a aVar = this.a;
        if (aVar != null) {
            aVar.f(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        com.facebook.s.a.a.a aVar;
        if (this.c || (aVar = this.a) == null || aVar.a() <= 1) {
            return;
        }
        this.c = true;
        long e2 = e();
        long j2 = e2 - this.f3184h;
        this.f3180d = j2;
        this.f3182f = j2;
        this.f3181e = e2 - this.f3185i;
        this.f3183g = this.f3186j;
        invalidateSelf();
        this.n.a(this);
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.c) {
            long e2 = e();
            this.f3184h = e2 - this.f3180d;
            this.f3185i = e2 - this.f3181e;
            this.f3186j = this.f3183g;
            this.c = false;
            this.f3180d = 0L;
            this.f3182f = 0L;
            this.f3181e = -1L;
            this.f3183g = -1;
            unscheduleSelf(this.q);
            this.n.b(this);
        }
    }

    public a(@Nullable com.facebook.s.a.a.a aVar) {
        this.f3187k = 8L;
        this.f3188l = 0L;
        this.n = s;
        this.o = null;
        this.q = new RunnableC0115a();
        this.a = aVar;
        this.b = c(aVar);
    }
}
