package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import com.airbnb.lottie.model.content.j;
import java.util.Collections;
import java.util.List;
/* compiled from: ShapeLayer.java */
/* loaded from: classes.dex */
public class e extends a {
    private final com.airbnb.lottie.t.b.d x;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(com.airbnb.lottie.g gVar, Layer layer) {
        super(gVar, layer);
        com.airbnb.lottie.t.b.d dVar = new com.airbnb.lottie.t.b.d(gVar, this, new j("__container", layer.l(), false));
        this.x = dVar;
        dVar.b(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.airbnb.lottie.model.layer.a
    protected void D(com.airbnb.lottie.model.d dVar, int i2, List<com.airbnb.lottie.model.d> list, com.airbnb.lottie.model.d dVar2) {
        this.x.d(dVar, i2, list, dVar2);
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.t.b.e
    public void e(RectF rectF, Matrix matrix, boolean z) {
        super.e(rectF, matrix, z);
        this.x.e(rectF, this.m, z);
    }

    @Override // com.airbnb.lottie.model.layer.a
    void t(@NonNull Canvas canvas, Matrix matrix, int i2) {
        this.x.g(canvas, matrix, i2);
    }
}
