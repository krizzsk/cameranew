package com.pinguo.camera360.gallery.ui;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.RectF;
import com.pinguo.camera360.gallery.f0;
import com.pinguo.camera360.gallery.ui.j;
import com.pinguo.camera360.gallery.ui.z;
import vStudio.Android.Camera360.R;
/* compiled from: AbstractSlotRenderer.java */
/* loaded from: classes3.dex */
public abstract class a implements z.e {
    protected final com.pinguo.album.opengles.r b;

    /* renamed from: d  reason: collision with root package name */
    private final com.pinguo.album.opengles.r f6503d;

    /* renamed from: e  reason: collision with root package name */
    protected final com.pinguo.album.opengles.r f6504e;

    /* renamed from: f  reason: collision with root package name */
    protected final com.pinguo.album.opengles.r f6505f;

    /* renamed from: g  reason: collision with root package name */
    private com.pinguo.album.opengles.f f6506g;

    /* renamed from: h  reason: collision with root package name */
    protected final com.pinguo.album.opengles.r f6507h;
    protected int a = 0;

    /* renamed from: i  reason: collision with root package name */
    private final RectF f6508i = new RectF();

    /* renamed from: j  reason: collision with root package name */
    private final RectF f6509j = new RectF();
    protected final com.pinguo.album.opengles.e c = new com.pinguo.album.opengles.e(-3026479);

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context) {
        this.b = new com.pinguo.album.opengles.r(context, R.drawable.gg_album_default_thumnail);
        this.f6503d = new com.pinguo.album.opengles.r(context, R.drawable.gg_grid_pressed);
        this.f6504e = new com.pinguo.album.opengles.r(context, R.drawable.albumset_selected);
        j.d dVar = f0.a(context).b;
        com.pinguo.album.j.c.h(dVar.c, context.getResources().getColor(R.color.album_select_text_color), false).setTextAlign(Paint.Align.LEFT);
        this.f6505f = new com.pinguo.album.opengles.r(context, R.drawable.select_all);
        this.f6507h = new com.pinguo.album.opengles.r(context, R.drawable.favorite_white);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void p(com.pinguo.album.opengles.l lVar, com.pinguo.album.opengles.u uVar, int i2, int i3, int i4, int i5) {
        uVar.a(lVar, i2, i3, i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k(com.pinguo.album.opengles.l lVar, int i2, int i3, int i4, int i5) {
        int width = this.f6505f.getWidth();
        p(lVar, this.f6505f, i2 - width, i5, width, this.f6505f.getHeight());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(com.pinguo.album.opengles.l lVar, int i2, int i3, int i4, int i5) {
        int width = this.f6504e.getWidth();
        p(lVar, this.f6504e, i2 - width, i5, width, this.f6504e.getHeight());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m(com.pinguo.album.opengles.l lVar, int i2, int i3) {
        p(lVar, this.f6504e, 0, 0, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(com.pinguo.album.opengles.l lVar, com.pinguo.album.opengles.u uVar, int i2, int i3, int i4, int i5) {
        lVar.s(2);
        if (i4 != 0) {
            int i6 = i5 / 2;
            int min = Math.min(i2 / 2, i3 / 2) + i6;
            float f2 = min;
            lVar.a(f2, f2);
            lVar.v(i4, 0.0f, 0.0f, 1.0f);
            float f3 = -(min - i6);
            lVar.a(f3, f3);
            if (i4 == 90 || i4 == 270) {
                i3 = i2;
                i2 = i3;
            }
        } else if (i5 > 0) {
            float f4 = i5 / 2;
            lVar.a(f4, f4);
        }
        float min2 = Math.min(i2 / uVar.getWidth(), i3 / uVar.getHeight());
        lVar.k(min2, min2, min2);
        uVar.c(lVar, 0, 0);
        lVar.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void o(com.pinguo.album.opengles.l r9, com.pinguo.album.opengles.u r10, int r11, int r12, int r13) {
        /*
            r8 = this;
            r0 = 2
            r9.s(r0)
            r0 = 0
            if (r13 == 0) goto L31
            int r1 = r11 / 2
            int r2 = r12 / 2
            float r3 = (float) r1
            float r4 = (float) r2
            r9.a(r3, r4)
            float r3 = (float) r13
            r4 = 1065353216(0x3f800000, float:1.0)
            r9.v(r3, r0, r0, r4)
            r3 = 90
            if (r13 == r3) goto L27
            r3 = 270(0x10e, float:3.78E-43)
            if (r13 != r3) goto L1f
            goto L27
        L1f:
            int r13 = -r1
            float r13 = (float) r13
            int r1 = -r2
            float r1 = (float) r1
            r9.a(r13, r1)
            goto L31
        L27:
            int r13 = -r2
            float r13 = (float) r13
            int r1 = -r1
            float r1 = (float) r1
            r9.a(r13, r1)
            r7 = r11
            r6 = r12
            goto L33
        L31:
            r6 = r11
            r7 = r12
        L33:
            boolean r11 = r10 instanceof com.pinguo.album.opengles.a
            if (r11 == 0) goto L68
            float r11 = (float) r6
            int r12 = r10.getWidth()
            float r12 = (float) r12
            float r12 = r11 / r12
            float r13 = (float) r7
            int r1 = r10.getHeight()
            float r1 = (float) r1
            float r1 = r13 / r1
            float r12 = java.lang.Math.max(r12, r1)
            r9.k(r12, r12, r12)
            float r11 = r11 / r12
            int r11 = (int) r11
            float r13 = r13 / r12
            int r12 = (int) r13
            android.graphics.RectF r13 = r8.f6508i
            float r11 = (float) r11
            float r12 = (float) r12
            r13.set(r0, r0, r11, r12)
            android.graphics.RectF r13 = r8.f6509j
            r13.set(r0, r0, r11, r12)
            com.pinguo.album.opengles.a r10 = (com.pinguo.album.opengles.a) r10
            android.graphics.RectF r11 = r8.f6508i
            android.graphics.RectF r12 = r8.f6509j
            r9.i(r10, r11, r12)
            goto L6f
        L68:
            r4 = 0
            r5 = 0
            r2 = r10
            r3 = r9
            r2.a(r3, r4, r5, r6, r7)
        L6f:
            r9.b()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pinguo.camera360.gallery.ui.a.o(com.pinguo.album.opengles.l, com.pinguo.album.opengles.u, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q(com.pinguo.album.opengles.l lVar, com.pinguo.album.opengles.u uVar, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        lVar.s(2);
        if (i4 == 90 || i4 == 270) {
            lVar.a(i2 / 2, i3 / 2);
            lVar.v(i4, 0.0f, 0.0f, 1.0f);
            lVar.a(-i7, -i6);
            int i8 = i2 + i3;
            i3 = i8 - i3;
            i2 = i8 - i3;
        } else if (i5 > 0) {
            float f2 = i5 / 2;
            lVar.a(f2, f2);
        }
        float min = Math.min(i2 / uVar.getWidth(), i3 / uVar.getHeight());
        lVar.k(min, min, min);
        uVar.c(lVar, 0, 0);
        lVar.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void r(com.pinguo.album.opengles.l lVar, int i2, int i3) {
        p(lVar, this.f6503d, 0, 0, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s(com.pinguo.album.opengles.l lVar, int i2, int i3) {
        if (this.f6506g == null) {
            this.f6506g = new com.pinguo.album.opengles.f(this.f6503d);
        }
        com.pinguo.album.opengles.f fVar = this.f6506g;
        int i4 = this.a;
        p(lVar, fVar, 0 - i4, 0 - i4, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t(com.pinguo.album.opengles.l lVar, int i2, int i3) {
        p(lVar, this.f6505f, 0, 0, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean u() {
        com.pinguo.album.opengles.f fVar = this.f6506g;
        if (fVar != null) {
            if (fVar.e()) {
                return false;
            }
            this.f6506g = null;
            return true;
        }
        return true;
    }
}
