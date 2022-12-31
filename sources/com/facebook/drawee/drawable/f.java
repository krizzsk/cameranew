package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import androidx.annotation.VisibleForTesting;
import java.util.Arrays;
import javax.annotation.Nullable;
/* compiled from: FadeDrawable.java */
/* loaded from: classes.dex */
public class f extends com.facebook.drawee.drawable.a {

    /* renamed from: i  reason: collision with root package name */
    private final Drawable[] f2522i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f2523j;

    /* renamed from: k  reason: collision with root package name */
    private final int f2524k;

    /* renamed from: l  reason: collision with root package name */
    private final int f2525l;
    @VisibleForTesting
    int m;
    @VisibleForTesting
    int n;
    @VisibleForTesting
    long o;
    @VisibleForTesting
    int[] p;
    @VisibleForTesting
    int[] q;
    @VisibleForTesting
    int r;
    @VisibleForTesting
    boolean[] s;
    @VisibleForTesting
    int t;
    @Nullable
    private a u;
    private boolean v;
    private boolean w;
    private boolean x;

    /* compiled from: FadeDrawable.java */
    /* loaded from: classes.dex */
    public interface a {
        void a();

        void b();

        void c();
    }

    public f(Drawable[] drawableArr, boolean z, int i2) {
        super(drawableArr);
        this.x = true;
        com.facebook.common.internal.h.j(drawableArr.length >= 1, "At least one layer required!");
        this.f2522i = drawableArr;
        this.p = new int[drawableArr.length];
        this.q = new int[drawableArr.length];
        this.r = 255;
        this.s = new boolean[drawableArr.length];
        this.t = 0;
        this.f2523j = z;
        this.f2524k = z ? 255 : 0;
        this.f2525l = i2;
        t();
    }

    private void i(Canvas canvas, Drawable drawable, int i2) {
        if (drawable == null || i2 <= 0) {
            return;
        }
        this.t++;
        if (this.x) {
            drawable.mutate();
        }
        drawable.setAlpha(i2);
        this.t--;
        drawable.draw(canvas);
    }

    private void q() {
        if (this.v) {
            this.v = false;
            a aVar = this.u;
            if (aVar != null) {
                aVar.c();
            }
        }
    }

    private void r() {
        int i2;
        if (!this.v && (i2 = this.f2525l) >= 0) {
            boolean[] zArr = this.s;
            if (i2 < zArr.length && zArr[i2]) {
                this.v = true;
                a aVar = this.u;
                if (aVar != null) {
                    aVar.a();
                }
            }
        }
    }

    private void s() {
        if (this.w && this.m == 2 && this.s[this.f2525l]) {
            a aVar = this.u;
            if (aVar != null) {
                aVar.b();
            }
            this.w = false;
        }
    }

    private void t() {
        this.m = 2;
        Arrays.fill(this.p, this.f2524k);
        this.p[0] = 255;
        Arrays.fill(this.q, this.f2524k);
        this.q[0] = 255;
        Arrays.fill(this.s, this.f2523j);
        this.s[0] = true;
    }

    private boolean w(float f2) {
        boolean z = true;
        for (int i2 = 0; i2 < this.f2522i.length; i2++) {
            boolean[] zArr = this.s;
            int i3 = zArr[i2] ? 1 : -1;
            int[] iArr = this.q;
            iArr[i2] = (int) (this.p[i2] + (i3 * 255 * f2));
            if (iArr[i2] < 0) {
                iArr[i2] = 0;
            }
            if (iArr[i2] > 255) {
                iArr[i2] = 255;
            }
            if (zArr[i2] && iArr[i2] < 255) {
                z = false;
            }
            if (!zArr[i2] && iArr[i2] > 0) {
                z = false;
            }
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0056 A[LOOP:0: B:25:0x0051->B:27:0x0056, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0072 A[EDGE_INSN: B:32:0x0072->B:28:0x0072 ?: BREAK  , SYNTHETIC] */
    @Override // com.facebook.drawee.drawable.a, android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void draw(android.graphics.Canvas r9) {
        /*
            r8 = this;
            int r0 = r8.m
            r1 = 2
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L2b
            if (r0 == r3) goto La
            goto L51
        La:
            int r0 = r8.n
            if (r0 <= 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            com.facebook.common.internal.h.i(r0)
            long r4 = r8.p()
            long r6 = r8.o
            long r4 = r4 - r6
            float r0 = (float) r4
            int r4 = r8.n
            float r4 = (float) r4
            float r0 = r0 / r4
            boolean r0 = r8.w(r0)
            if (r0 == 0) goto L27
            goto L28
        L27:
            r1 = 1
        L28:
            r8.m = r1
            goto L50
        L2b:
            int[] r0 = r8.q
            int[] r4 = r8.p
            android.graphics.drawable.Drawable[] r5 = r8.f2522i
            int r5 = r5.length
            java.lang.System.arraycopy(r0, r2, r4, r2, r5)
            long r4 = r8.p()
            r8.o = r4
            int r0 = r8.n
            if (r0 != 0) goto L42
            r0 = 1065353216(0x3f800000, float:1.0)
            goto L43
        L42:
            r0 = 0
        L43:
            boolean r0 = r8.w(r0)
            r8.r()
            if (r0 == 0) goto L4d
            goto L4e
        L4d:
            r1 = 1
        L4e:
            r8.m = r1
        L50:
            r3 = r0
        L51:
            android.graphics.drawable.Drawable[] r0 = r8.f2522i
            int r1 = r0.length
            if (r2 >= r1) goto L72
            r0 = r0[r2]
            int[] r1 = r8.q
            r1 = r1[r2]
            int r4 = r8.r
            int r1 = r1 * r4
            double r4 = (double) r1
            r6 = 4643176031446892544(0x406fe00000000000, double:255.0)
            double r4 = r4 / r6
            double r4 = java.lang.Math.ceil(r4)
            int r1 = (int) r4
            r8.i(r9, r0, r1)
            int r2 = r2 + 1
            goto L51
        L72:
            if (r3 == 0) goto L7b
            r8.q()
            r8.s()
            goto L7e
        L7b:
            r8.invalidateSelf()
        L7e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.drawee.drawable.f.draw(android.graphics.Canvas):void");
    }

    public void g() {
        this.t++;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.r;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.t == 0) {
            super.invalidateSelf();
        }
    }

    public void j() {
        this.t--;
        invalidateSelf();
    }

    public void l() {
        this.m = 0;
        Arrays.fill(this.s, true);
        invalidateSelf();
    }

    public void m(int i2) {
        this.m = 0;
        this.s[i2] = true;
        invalidateSelf();
    }

    public void n(int i2) {
        this.m = 0;
        this.s[i2] = false;
        invalidateSelf();
    }

    public void o() {
        this.m = 2;
        for (int i2 = 0; i2 < this.f2522i.length; i2++) {
            this.q[i2] = this.s[i2] ? 255 : 0;
        }
        invalidateSelf();
    }

    protected long p() {
        return SystemClock.uptimeMillis();
    }

    @Override // com.facebook.drawee.drawable.a, android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        if (this.r != i2) {
            this.r = i2;
            invalidateSelf();
        }
    }

    public void u(@Nullable a aVar) {
        this.u = aVar;
    }

    public void v(int i2) {
        this.n = i2;
        if (this.m == 1) {
            this.m = 0;
        }
    }
}
