package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
/* compiled from: NullLayer.java */
/* loaded from: classes.dex */
public class d extends a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public d(com.airbnb.lottie.g gVar, Layer layer) {
        super(gVar, layer);
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.t.b.e
    public void e(RectF rectF, Matrix matrix, boolean z) {
        super.e(rectF, matrix, z);
        rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
    }

    @Override // com.airbnb.lottie.model.layer.a
    void t(Canvas canvas, Matrix matrix, int i2) {
    }
}
