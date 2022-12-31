package com.airbnb.lottie.t.c;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
/* compiled from: PathKeyframe.java */
/* loaded from: classes.dex */
public class h extends com.airbnb.lottie.x.a<PointF> {
    @Nullable
    private Path o;
    private final com.airbnb.lottie.x.a<PointF> p;

    public h(com.airbnb.lottie.e eVar, com.airbnb.lottie.x.a<PointF> aVar) {
        super(eVar, aVar.b, aVar.c, aVar.f583d, aVar.f584e, aVar.f585f);
        this.p = aVar;
        i();
    }

    public void i() {
        T t;
        T t2 = this.c;
        boolean z = (t2 == 0 || (t = this.b) == 0 || !((PointF) t).equals(((PointF) t2).x, ((PointF) t2).y)) ? false : true;
        T t3 = this.c;
        if (t3 == 0 || z) {
            return;
        }
        com.airbnb.lottie.x.a<PointF> aVar = this.p;
        this.o = com.airbnb.lottie.w.h.d((PointF) this.b, (PointF) t3, aVar.m, aVar.n);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Path j() {
        return this.o;
    }
}
