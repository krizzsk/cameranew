package com.bumptech.glide.load.resource.gif;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.Gravity;
import com.bumptech.glide.h.a;
import com.bumptech.glide.load.resource.gif.f;
import java.util.Objects;
/* compiled from: GifDrawable.java */
/* loaded from: classes.dex */
public class b extends com.bumptech.glide.load.h.e.b implements f.c {
    private final Paint a;
    private final Rect b;
    private final a c;

    /* renamed from: d  reason: collision with root package name */
    private final com.bumptech.glide.h.a f789d;

    /* renamed from: e  reason: collision with root package name */
    private final f f790e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f791f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f792g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f793h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f794i;

    /* renamed from: j  reason: collision with root package name */
    private int f795j;

    /* renamed from: k  reason: collision with root package name */
    private int f796k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f797l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GifDrawable.java */
    /* loaded from: classes.dex */
    public static class a extends Drawable.ConstantState {
        com.bumptech.glide.h.c a;
        byte[] b;
        Context c;

        /* renamed from: d  reason: collision with root package name */
        com.bumptech.glide.load.f<Bitmap> f798d;

        /* renamed from: e  reason: collision with root package name */
        int f799e;

        /* renamed from: f  reason: collision with root package name */
        int f800f;

        /* renamed from: g  reason: collision with root package name */
        a.InterfaceC0026a f801g;

        /* renamed from: h  reason: collision with root package name */
        com.bumptech.glide.load.engine.bitmap_recycle.c f802h;

        /* renamed from: i  reason: collision with root package name */
        Bitmap f803i;

        public a(com.bumptech.glide.h.c cVar, byte[] bArr, Context context, com.bumptech.glide.load.f<Bitmap> fVar, int i2, int i3, a.InterfaceC0026a interfaceC0026a, com.bumptech.glide.load.engine.bitmap_recycle.c cVar2, Bitmap bitmap) {
            Objects.requireNonNull(bitmap, "The first frame of the GIF must not be null");
            this.a = cVar;
            this.b = bArr;
            this.f802h = cVar2;
            this.f803i = bitmap;
            this.c = context.getApplicationContext();
            this.f798d = fVar;
            this.f799e = i2;
            this.f800f = i3;
            this.f801g = interfaceC0026a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new b(this);
        }
    }

    public b(Context context, a.InterfaceC0026a interfaceC0026a, com.bumptech.glide.load.engine.bitmap_recycle.c cVar, com.bumptech.glide.load.f<Bitmap> fVar, int i2, int i3, com.bumptech.glide.h.c cVar2, byte[] bArr, Bitmap bitmap) {
        this(new a(cVar2, bArr, context, fVar, i2, i3, interfaceC0026a, cVar, bitmap));
    }

    private void i() {
        this.f790e.a();
        invalidateSelf();
    }

    private void j() {
        this.f795j = 0;
    }

    private void k() {
        if (this.f789d.f() == 1) {
            invalidateSelf();
        } else if (this.f791f) {
        } else {
            this.f791f = true;
            this.f790e.g();
            invalidateSelf();
        }
    }

    private void l() {
        this.f791f = false;
        this.f790e.h();
    }

    @Override // com.bumptech.glide.load.resource.gif.f.c
    @TargetApi(11)
    public void a(int i2) {
        if (Build.VERSION.SDK_INT >= 11 && getCallback() == null) {
            stop();
            i();
            return;
        }
        invalidateSelf();
        if (i2 == this.f789d.f() - 1) {
            this.f795j++;
        }
        int i3 = this.f796k;
        if (i3 == -1 || this.f795j < i3) {
            return;
        }
        stop();
    }

    @Override // com.bumptech.glide.load.h.e.b
    public boolean b() {
        return true;
    }

    @Override // com.bumptech.glide.load.h.e.b
    public void c(int i2) {
        if (i2 <= 0 && i2 != -1 && i2 != 0) {
            throw new IllegalArgumentException("Loop count must be greater than 0, or equal to GlideDrawable.LOOP_FOREVER, or equal to GlideDrawable.LOOP_INTRINSIC");
        }
        if (i2 == 0) {
            this.f796k = this.f789d.g();
        } else {
            this.f796k = i2;
        }
    }

    public byte[] d() {
        return this.c.b;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f793h) {
            return;
        }
        if (this.f797l) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), this.b);
            this.f797l = false;
        }
        Bitmap b = this.f790e.b();
        if (b == null) {
            b = this.c.f803i;
        }
        canvas.drawBitmap(b, (Rect) null, this.b, this.a);
    }

    public Bitmap e() {
        return this.c.f803i;
    }

    public int f() {
        return this.f789d.f();
    }

    public com.bumptech.glide.load.f<Bitmap> g() {
        return this.c.f798d;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.c.f803i.getHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.c.f803i.getWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    public void h() {
        this.f793h = true;
        a aVar = this.c;
        aVar.f802h.a(aVar.f803i);
        this.f790e.a();
        this.f790e.h();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f791f;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f797l = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.a.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        this.f794i = z;
        if (!z) {
            l();
        } else if (this.f792g) {
            k();
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f792g = true;
        j();
        if (this.f794i) {
            k();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f792g = false;
        l();
        if (Build.VERSION.SDK_INT < 11) {
            i();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public b(com.bumptech.glide.load.resource.gif.b r12, android.graphics.Bitmap r13, com.bumptech.glide.load.f<android.graphics.Bitmap> r14) {
        /*
            r11 = this;
            com.bumptech.glide.load.resource.gif.b$a r10 = new com.bumptech.glide.load.resource.gif.b$a
            com.bumptech.glide.load.resource.gif.b$a r12 = r12.c
            com.bumptech.glide.h.c r1 = r12.a
            byte[] r2 = r12.b
            android.content.Context r3 = r12.c
            int r5 = r12.f799e
            int r6 = r12.f800f
            com.bumptech.glide.h.a$a r7 = r12.f801g
            com.bumptech.glide.load.engine.bitmap_recycle.c r8 = r12.f802h
            r0 = r10
            r4 = r14
            r9 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r11.<init>(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.gif.b.<init>(com.bumptech.glide.load.resource.gif.b, android.graphics.Bitmap, com.bumptech.glide.load.f):void");
    }

    b(a aVar) {
        this.b = new Rect();
        this.f794i = true;
        this.f796k = -1;
        Objects.requireNonNull(aVar, "GifState must not be null");
        this.c = aVar;
        com.bumptech.glide.h.a aVar2 = new com.bumptech.glide.h.a(aVar.f801g);
        this.f789d = aVar2;
        this.a = new Paint();
        aVar2.n(aVar.a, aVar.b);
        f fVar = new f(aVar.c, this, aVar2, aVar.f799e, aVar.f800f);
        this.f790e = fVar;
        fVar.f(aVar.f798d);
    }
}
