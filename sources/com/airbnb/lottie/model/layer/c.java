package com.airbnb.lottie.model.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.l;
import com.airbnb.lottie.t.c.p;
import com.airbnb.lottie.w.h;
/* compiled from: ImageLayer.java */
/* loaded from: classes.dex */
public class c extends a {
    @Nullable
    private com.airbnb.lottie.t.c.a<ColorFilter, ColorFilter> A;
    private final Paint x;
    private final Rect y;
    private final Rect z;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.airbnb.lottie.g gVar, Layer layer) {
        super(gVar, layer);
        this.x = new com.airbnb.lottie.t.a(3);
        this.y = new Rect();
        this.z = new Rect();
    }

    @Nullable
    private Bitmap J() {
        return this.n.q(this.o.k());
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.model.e
    public <T> void c(T t, @Nullable com.airbnb.lottie.x.c<T> cVar) {
        super.c(t, cVar);
        if (t == l.C) {
            if (cVar == null) {
                this.A = null;
            } else {
                this.A = new p(cVar);
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.t.b.e
    public void e(RectF rectF, Matrix matrix, boolean z) {
        super.e(rectF, matrix, z);
        Bitmap J = J();
        if (J != null) {
            rectF.set(0.0f, 0.0f, J.getWidth() * h.e(), J.getHeight() * h.e());
            this.m.mapRect(rectF);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    public void t(@NonNull Canvas canvas, Matrix matrix, int i2) {
        Bitmap J = J();
        if (J == null || J.isRecycled()) {
            return;
        }
        float e2 = h.e();
        this.x.setAlpha(i2);
        com.airbnb.lottie.t.c.a<ColorFilter, ColorFilter> aVar = this.A;
        if (aVar != null) {
            this.x.setColorFilter(aVar.h());
        }
        canvas.save();
        canvas.concat(matrix);
        this.y.set(0, 0, J.getWidth(), J.getHeight());
        this.z.set(0, 0, (int) (J.getWidth() * e2), (int) (J.getHeight() * e2));
        canvas.drawBitmap(J, this.y, this.z, this.x);
        canvas.restore();
    }
}
