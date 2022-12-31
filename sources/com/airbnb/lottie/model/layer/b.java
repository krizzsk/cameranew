package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.l;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.t.c.p;
import com.airbnb.lottie.w.h;
import java.util.ArrayList;
import java.util.List;
/* compiled from: CompositionLayer.java */
/* loaded from: classes.dex */
public class b extends com.airbnb.lottie.model.layer.a {
    private final RectF A;
    private Paint B;
    @Nullable
    private com.airbnb.lottie.t.c.a<Float, Float> x;
    private final List<com.airbnb.lottie.model.layer.a> y;
    private final RectF z;

    /* compiled from: CompositionLayer.java */
    /* loaded from: classes.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Layer.MatteType.values().length];
            a = iArr;
            try {
                iArr[Layer.MatteType.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Layer.MatteType.INVERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public b(com.airbnb.lottie.g gVar, Layer layer, List<Layer> list, com.airbnb.lottie.e eVar) {
        super(gVar, layer);
        int i2;
        com.airbnb.lottie.model.layer.a aVar;
        this.y = new ArrayList();
        this.z = new RectF();
        this.A = new RectF();
        this.B = new Paint();
        com.airbnb.lottie.model.h.b s = layer.s();
        if (s != null) {
            com.airbnb.lottie.t.c.a<Float, Float> a2 = s.a();
            this.x = a2;
            i(a2);
            this.x.a(this);
        } else {
            this.x = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(eVar.j().size());
        int size = list.size() - 1;
        com.airbnb.lottie.model.layer.a aVar2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            Layer layer2 = list.get(size);
            com.airbnb.lottie.model.layer.a u = com.airbnb.lottie.model.layer.a.u(layer2, gVar, eVar);
            if (u != null) {
                longSparseArray.put(u.v().b(), u);
                if (aVar2 != null) {
                    aVar2.E(u);
                    aVar2 = null;
                } else {
                    this.y.add(0, u);
                    int i3 = a.a[layer2.f().ordinal()];
                    if (i3 == 1 || i3 == 2) {
                        aVar2 = u;
                    }
                }
            }
            size--;
        }
        for (i2 = 0; i2 < longSparseArray.size(); i2++) {
            com.airbnb.lottie.model.layer.a aVar3 = (com.airbnb.lottie.model.layer.a) longSparseArray.get(longSparseArray.keyAt(i2));
            if (aVar3 != null && (aVar = (com.airbnb.lottie.model.layer.a) longSparseArray.get(aVar3.v().h())) != null) {
                aVar3.F(aVar);
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    protected void D(com.airbnb.lottie.model.d dVar, int i2, List<com.airbnb.lottie.model.d> list, com.airbnb.lottie.model.d dVar2) {
        for (int i3 = 0; i3 < this.y.size(); i3++) {
            this.y.get(i3).d(dVar, i2, list, dVar2);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    public void G(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        super.G(f2);
        if (this.x != null) {
            f2 = ((this.x.h().floatValue() * this.o.a().h()) - this.o.a().o()) / (this.n.n().e() + 0.01f);
        }
        if (this.x == null) {
            f2 -= this.o.p();
        }
        if (this.o.t() != 0.0f) {
            f2 /= this.o.t();
        }
        for (int size = this.y.size() - 1; size >= 0; size--) {
            this.y.get(size).G(f2);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.model.e
    public <T> void c(T t, @Nullable com.airbnb.lottie.x.c<T> cVar) {
        super.c(t, cVar);
        if (t == l.A) {
            if (cVar == null) {
                com.airbnb.lottie.t.c.a<Float, Float> aVar = this.x;
                if (aVar != null) {
                    aVar.m(null);
                    return;
                }
                return;
            }
            p pVar = new p(cVar);
            this.x = pVar;
            pVar.a(this);
            i(this.x);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.t.b.e
    public void e(RectF rectF, Matrix matrix, boolean z) {
        super.e(rectF, matrix, z);
        for (int size = this.y.size() - 1; size >= 0; size--) {
            this.z.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.y.get(size).e(this.z, this.m, true);
            rectF.union(this.z);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    void t(Canvas canvas, Matrix matrix, int i2) {
        com.airbnb.lottie.d.a("CompositionLayer#draw");
        this.A.set(0.0f, 0.0f, this.o.j(), this.o.i());
        matrix.mapRect(this.A);
        boolean z = this.n.E() && this.y.size() > 1 && i2 != 255;
        if (z) {
            this.B.setAlpha(i2);
            h.m(canvas, this.A, this.B);
        } else {
            canvas.save();
        }
        if (z) {
            i2 = 255;
        }
        for (int size = this.y.size() - 1; size >= 0; size--) {
            if (!this.A.isEmpty() ? canvas.clipRect(this.A) : true) {
                this.y.get(size).g(canvas, matrix, i2);
            }
        }
        canvas.restore();
        com.airbnb.lottie.d.b("CompositionLayer#draw");
    }
}
