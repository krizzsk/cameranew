package com.facebook.s.a.b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.IntRange;
import com.facebook.imagepipeline.bitmaps.f;
import com.facebook.s.a.a.c;
import com.facebook.s.a.a.d;
import javax.annotation.Nullable;
/* compiled from: BitmapAnimationBackend.java */
/* loaded from: classes.dex */
public class a implements com.facebook.s.a.a.a, c.b {
    private static final Class<?> m = a.class;
    private final f a;
    private final b b;
    private final d c;

    /* renamed from: d  reason: collision with root package name */
    private final c f3162d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final com.facebook.s.a.b.e.a f3163e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private final com.facebook.s.a.b.e.b f3164f;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private Rect f3166h;

    /* renamed from: i  reason: collision with root package name */
    private int f3167i;

    /* renamed from: j  reason: collision with root package name */
    private int f3168j;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private InterfaceC0114a f3170l;

    /* renamed from: k  reason: collision with root package name */
    private Bitmap.Config f3169k = Bitmap.Config.ARGB_8888;

    /* renamed from: g  reason: collision with root package name */
    private final Paint f3165g = new Paint(6);

    /* compiled from: BitmapAnimationBackend.java */
    /* renamed from: com.facebook.s.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0114a {
        void a(a aVar, int i2, int i3);

        void b(a aVar, int i2);

        void c(a aVar, int i2);
    }

    public a(f fVar, b bVar, d dVar, c cVar, @Nullable com.facebook.s.a.b.e.a aVar, @Nullable com.facebook.s.a.b.e.b bVar2) {
        this.a = fVar;
        this.b = bVar;
        this.c = dVar;
        this.f3162d = cVar;
        this.f3163e = aVar;
        this.f3164f = bVar2;
        n();
    }

    private boolean k(int i2, @Nullable com.facebook.common.references.a<Bitmap> aVar, Canvas canvas, int i3) {
        if (com.facebook.common.references.a.Q(aVar)) {
            if (this.f3166h == null) {
                canvas.drawBitmap(aVar.A(), 0.0f, 0.0f, this.f3165g);
            } else {
                canvas.drawBitmap(aVar.A(), (Rect) null, this.f3166h, this.f3165g);
            }
            if (i3 != 3) {
                this.b.b(i2, aVar, i3);
            }
            InterfaceC0114a interfaceC0114a = this.f3170l;
            if (interfaceC0114a != null) {
                interfaceC0114a.a(this, i2, i3);
                return true;
            }
            return true;
        }
        return false;
    }

    private boolean l(Canvas canvas, int i2, int i3) {
        com.facebook.common.references.a<Bitmap> f2;
        boolean k2;
        int i4 = 3;
        boolean z = false;
        try {
            if (i3 == 0) {
                f2 = this.b.f(i2);
                k2 = k(i2, f2, canvas, 0);
                i4 = 1;
            } else if (i3 == 1) {
                f2 = this.b.d(i2, this.f3167i, this.f3168j);
                if (m(i2, f2) && k(i2, f2, canvas, 1)) {
                    z = true;
                }
                k2 = z;
                i4 = 2;
            } else if (i3 == 2) {
                f2 = this.a.b(this.f3167i, this.f3168j, this.f3169k);
                if (m(i2, f2) && k(i2, f2, canvas, 2)) {
                    z = true;
                }
                k2 = z;
            } else if (i3 != 3) {
                return false;
            } else {
                f2 = this.b.c(i2);
                k2 = k(i2, f2, canvas, 3);
                i4 = -1;
            }
            com.facebook.common.references.a.y(f2);
            return (k2 || i4 == -1) ? k2 : l(canvas, i2, i4);
        } catch (RuntimeException e2) {
            com.facebook.common.logging.a.w(m, "Failed to create frame bitmap", e2);
            return false;
        } finally {
            com.facebook.common.references.a.y(null);
        }
    }

    private boolean m(int i2, @Nullable com.facebook.common.references.a<Bitmap> aVar) {
        if (com.facebook.common.references.a.Q(aVar)) {
            boolean a = this.f3162d.a(i2, aVar.A());
            if (!a) {
                com.facebook.common.references.a.y(aVar);
            }
            return a;
        }
        return false;
    }

    private void n() {
        int e2 = this.f3162d.e();
        this.f3167i = e2;
        if (e2 == -1) {
            Rect rect = this.f3166h;
            this.f3167i = rect == null ? -1 : rect.width();
        }
        int c = this.f3162d.c();
        this.f3168j = c;
        if (c == -1) {
            Rect rect2 = this.f3166h;
            this.f3168j = rect2 != null ? rect2.height() : -1;
        }
    }

    @Override // com.facebook.s.a.a.d
    public int a() {
        return this.c.a();
    }

    @Override // com.facebook.s.a.a.d
    public int b() {
        return this.c.b();
    }

    @Override // com.facebook.s.a.a.a
    public int c() {
        return this.f3168j;
    }

    @Override // com.facebook.s.a.a.a
    public void clear() {
        this.b.clear();
    }

    @Override // com.facebook.s.a.a.a
    public void d(@Nullable Rect rect) {
        this.f3166h = rect;
        this.f3162d.d(rect);
        n();
    }

    @Override // com.facebook.s.a.a.a
    public int e() {
        return this.f3167i;
    }

    @Override // com.facebook.s.a.a.a
    public void f(@Nullable ColorFilter colorFilter) {
        this.f3165g.setColorFilter(colorFilter);
    }

    @Override // com.facebook.s.a.a.a
    public boolean g(Drawable drawable, Canvas canvas, int i2) {
        com.facebook.s.a.b.e.b bVar;
        InterfaceC0114a interfaceC0114a;
        InterfaceC0114a interfaceC0114a2 = this.f3170l;
        if (interfaceC0114a2 != null) {
            interfaceC0114a2.c(this, i2);
        }
        boolean l2 = l(canvas, i2, 0);
        if (!l2 && (interfaceC0114a = this.f3170l) != null) {
            interfaceC0114a.b(this, i2);
        }
        com.facebook.s.a.b.e.a aVar = this.f3163e;
        if (aVar != null && (bVar = this.f3164f) != null) {
            aVar.a(bVar, this.b, this, i2);
        }
        return l2;
    }

    @Override // com.facebook.s.a.a.c.b
    public void h() {
        clear();
    }

    @Override // com.facebook.s.a.a.d
    public int i(int i2) {
        return this.c.i(i2);
    }

    @Override // com.facebook.s.a.a.a
    public void j(@IntRange(from = 0, to = 255) int i2) {
        this.f3165g.setAlpha(i2);
    }
}
