package com.hw.photomovie.segment;

import android.graphics.Rect;
import android.graphics.RectF;
import com.hw.photomovie.util.ScaleType;
/* compiled from: BitmapInfo.java */
/* loaded from: classes2.dex */
public class a {
    public com.hw.photomovie.d.b a;
    public Rect b = new Rect();
    public RectF c = new RectF();

    /* renamed from: d  reason: collision with root package name */
    public ScaleType f5218d = ScaleType.CENTER_CROP;

    /* compiled from: BitmapInfo.java */
    /* renamed from: com.hw.photomovie.segment.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class C0202a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ScaleType.values().length];
            a = iArr;
            try {
                iArr[ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ScaleType.FIT_XY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ScaleType.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public void a(RectF rectF) {
        if (rectF == null || rectF.width() <= 0.0f || rectF.height() <= 0.0f) {
            this.c.set(this.b);
        }
        int i2 = C0202a.a[this.f5218d.ordinal()];
        if (i2 == 1) {
            this.c.set(com.hw.photomovie.util.c.a(null, this.b.width(), this.b.height(), rectF.width(), rectF.height()));
        } else if (i2 == 2 || i2 == 3) {
            this.c.set(this.b);
        }
    }

    public boolean b() {
        com.hw.photomovie.d.b bVar = this.a;
        return bVar != null && bVar.k();
    }

    public boolean c(com.hw.photomovie.d.f fVar) {
        com.hw.photomovie.d.b bVar = this.a;
        if (bVar == null) {
            return false;
        }
        if (bVar.k()) {
            return true;
        }
        this.a.w(fVar);
        return this.a.k();
    }
}
