package com.google.android.material.shape;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
/* loaded from: classes2.dex */
public class ShapeAppearancePathProvider {
    private final n[] a = new n[4];
    private final Matrix[] b = new Matrix[4];
    private final Matrix[] c = new Matrix[4];

    /* renamed from: d  reason: collision with root package name */
    private final PointF f4474d = new PointF();

    /* renamed from: e  reason: collision with root package name */
    private final Path f4475e = new Path();

    /* renamed from: f  reason: collision with root package name */
    private final Path f4476f = new Path();

    /* renamed from: g  reason: collision with root package name */
    private final n f4477g = new n();

    /* renamed from: h  reason: collision with root package name */
    private final float[] f4478h = new float[2];

    /* renamed from: i  reason: collision with root package name */
    private final float[] f4479i = new float[2];

    /* renamed from: j  reason: collision with root package name */
    private final Path f4480j = new Path();

    /* renamed from: k  reason: collision with root package name */
    private final Path f4481k = new Path();

    /* renamed from: l  reason: collision with root package name */
    private boolean f4482l = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        static final ShapeAppearancePathProvider a = new ShapeAppearancePathProvider();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public interface b {
        void a(n nVar, Matrix matrix, int i2);

        void b(n nVar, Matrix matrix, int i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class c {
        @NonNull
        public final m a;
        @NonNull
        public final Path b;
        @NonNull
        public final RectF c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        public final b f4483d;

        /* renamed from: e  reason: collision with root package name */
        public final float f4484e;

        c(@NonNull m mVar, float f2, RectF rectF, @Nullable b bVar, Path path) {
            this.f4483d = bVar;
            this.a = mVar;
            this.f4484e = f2;
            this.c = rectF;
            this.b = path;
        }
    }

    public ShapeAppearancePathProvider() {
        for (int i2 = 0; i2 < 4; i2++) {
            this.a[i2] = new n();
            this.b[i2] = new Matrix();
            this.c[i2] = new Matrix();
        }
    }

    private float a(int i2) {
        return (i2 + 1) * 90;
    }

    private void b(@NonNull c cVar, int i2) {
        this.f4478h[0] = this.a[i2].k();
        this.f4478h[1] = this.a[i2].l();
        this.b[i2].mapPoints(this.f4478h);
        if (i2 == 0) {
            Path path = cVar.b;
            float[] fArr = this.f4478h;
            path.moveTo(fArr[0], fArr[1]);
        } else {
            Path path2 = cVar.b;
            float[] fArr2 = this.f4478h;
            path2.lineTo(fArr2[0], fArr2[1]);
        }
        this.a[i2].d(this.b[i2], cVar.b);
        b bVar = cVar.f4483d;
        if (bVar != null) {
            bVar.a(this.a[i2], this.b[i2], i2);
        }
    }

    private void c(@NonNull c cVar, int i2) {
        int i3 = (i2 + 1) % 4;
        this.f4478h[0] = this.a[i2].i();
        this.f4478h[1] = this.a[i2].j();
        this.b[i2].mapPoints(this.f4478h);
        this.f4479i[0] = this.a[i3].k();
        this.f4479i[1] = this.a[i3].l();
        this.b[i3].mapPoints(this.f4479i);
        float[] fArr = this.f4478h;
        float f2 = fArr[0];
        float[] fArr2 = this.f4479i;
        float max = Math.max(((float) Math.hypot(f2 - fArr2[0], fArr[1] - fArr2[1])) - 0.001f, 0.0f);
        float i4 = i(cVar.c, i2);
        this.f4477g.n(0.0f, 0.0f);
        f j2 = j(i2, cVar.a);
        j2.c(max, i4, cVar.f4484e, this.f4477g);
        this.f4480j.reset();
        this.f4477g.d(this.c[i2], this.f4480j);
        if (this.f4482l && Build.VERSION.SDK_INT >= 19 && (j2.b() || k(this.f4480j, i2) || k(this.f4480j, i3))) {
            Path path = this.f4480j;
            path.op(path, this.f4476f, Path.Op.DIFFERENCE);
            this.f4478h[0] = this.f4477g.k();
            this.f4478h[1] = this.f4477g.l();
            this.c[i2].mapPoints(this.f4478h);
            Path path2 = this.f4475e;
            float[] fArr3 = this.f4478h;
            path2.moveTo(fArr3[0], fArr3[1]);
            this.f4477g.d(this.c[i2], this.f4475e);
        } else {
            this.f4477g.d(this.c[i2], cVar.b);
        }
        b bVar = cVar.f4483d;
        if (bVar != null) {
            bVar.b(this.f4477g, this.c[i2], i2);
        }
    }

    private void f(int i2, @NonNull RectF rectF, @NonNull PointF pointF) {
        if (i2 == 1) {
            pointF.set(rectF.right, rectF.bottom);
        } else if (i2 == 2) {
            pointF.set(rectF.left, rectF.bottom);
        } else if (i2 != 3) {
            pointF.set(rectF.right, rectF.top);
        } else {
            pointF.set(rectF.left, rectF.top);
        }
    }

    private com.google.android.material.shape.c g(int i2, @NonNull m mVar) {
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    return mVar.t();
                }
                return mVar.r();
            }
            return mVar.j();
        }
        return mVar.l();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @UiThread
    public static ShapeAppearancePathProvider getInstance() {
        return a.a;
    }

    private d h(int i2, @NonNull m mVar) {
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    return mVar.s();
                }
                return mVar.q();
            }
            return mVar.i();
        }
        return mVar.k();
    }

    private float i(@NonNull RectF rectF, int i2) {
        float[] fArr = this.f4478h;
        n[] nVarArr = this.a;
        fArr[0] = nVarArr[i2].c;
        fArr[1] = nVarArr[i2].f4521d;
        this.b[i2].mapPoints(fArr);
        if (i2 != 1 && i2 != 3) {
            return Math.abs(rectF.centerY() - this.f4478h[1]);
        }
        return Math.abs(rectF.centerX() - this.f4478h[0]);
    }

    private f j(int i2, @NonNull m mVar) {
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    return mVar.o();
                }
                return mVar.p();
            }
            return mVar.n();
        }
        return mVar.h();
    }

    @RequiresApi(19)
    private boolean k(Path path, int i2) {
        this.f4481k.reset();
        this.a[i2].d(this.b[i2], this.f4481k);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        this.f4481k.computeBounds(rectF, true);
        path.op(this.f4481k, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (rectF.isEmpty()) {
            return rectF.width() > 1.0f && rectF.height() > 1.0f;
        }
        return true;
    }

    private void l(@NonNull c cVar, int i2) {
        h(i2, cVar.a).b(this.a[i2], 90.0f, cVar.f4484e, cVar.c, g(i2, cVar.a));
        float a2 = a(i2);
        this.b[i2].reset();
        f(i2, cVar.c, this.f4474d);
        Matrix matrix = this.b[i2];
        PointF pointF = this.f4474d;
        matrix.setTranslate(pointF.x, pointF.y);
        this.b[i2].preRotate(a2);
    }

    private void m(int i2) {
        this.f4478h[0] = this.a[i2].i();
        this.f4478h[1] = this.a[i2].j();
        this.b[i2].mapPoints(this.f4478h);
        float a2 = a(i2);
        this.c[i2].reset();
        Matrix matrix = this.c[i2];
        float[] fArr = this.f4478h;
        matrix.setTranslate(fArr[0], fArr[1]);
        this.c[i2].preRotate(a2);
    }

    public void d(m mVar, float f2, RectF rectF, @NonNull Path path) {
        e(mVar, f2, rectF, null, path);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void e(m mVar, float f2, RectF rectF, b bVar, @NonNull Path path) {
        path.rewind();
        this.f4475e.rewind();
        this.f4476f.rewind();
        this.f4476f.addRect(rectF, Path.Direction.CW);
        c cVar = new c(mVar, f2, rectF, bVar, path);
        for (int i2 = 0; i2 < 4; i2++) {
            l(cVar, i2);
            m(i2);
        }
        for (int i3 = 0; i3 < 4; i3++) {
            b(cVar, i3);
            c(cVar, i3);
        }
        path.close();
        this.f4475e.close();
        if (Build.VERSION.SDK_INT < 19 || this.f4475e.isEmpty()) {
            return;
        }
        path.op(this.f4475e, Path.Op.UNION);
    }
}
