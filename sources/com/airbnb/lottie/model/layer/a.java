package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import androidx.annotation.CallSuper;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.content.h;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.t.c.a;
import com.airbnb.lottie.t.c.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* compiled from: BaseLayer.java */
/* loaded from: classes.dex */
public abstract class a implements com.airbnb.lottie.t.b.e, a.b, com.airbnb.lottie.model.e {
    private final Path a = new Path();
    private final Matrix b = new Matrix();
    private final Paint c = new com.airbnb.lottie.t.a(1);

    /* renamed from: d  reason: collision with root package name */
    private final Paint f441d = new com.airbnb.lottie.t.a(1, PorterDuff.Mode.DST_IN);

    /* renamed from: e  reason: collision with root package name */
    private final Paint f442e = new com.airbnb.lottie.t.a(1, PorterDuff.Mode.DST_OUT);

    /* renamed from: f  reason: collision with root package name */
    private final Paint f443f;

    /* renamed from: g  reason: collision with root package name */
    private final Paint f444g;

    /* renamed from: h  reason: collision with root package name */
    private final RectF f445h;

    /* renamed from: i  reason: collision with root package name */
    private final RectF f446i;

    /* renamed from: j  reason: collision with root package name */
    private final RectF f447j;

    /* renamed from: k  reason: collision with root package name */
    private final RectF f448k;

    /* renamed from: l  reason: collision with root package name */
    private final String f449l;
    final Matrix m;
    final com.airbnb.lottie.g n;
    final Layer o;
    @Nullable
    private com.airbnb.lottie.t.c.g p;
    @Nullable
    private com.airbnb.lottie.t.c.c q;
    @Nullable
    private a r;
    @Nullable
    private a s;
    private List<a> t;
    private final List<com.airbnb.lottie.t.c.a<?, ?>> u;
    final o v;
    private boolean w;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BaseLayer.java */
    /* renamed from: com.airbnb.lottie.model.layer.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0020a implements a.b {
        C0020a() {
        }

        @Override // com.airbnb.lottie.t.c.a.b
        public void a() {
            a aVar = a.this;
            aVar.H(aVar.q.o() == 1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BaseLayer.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class b {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[Mask.MaskMode.values().length];
            b = iArr;
            try {
                iArr[Mask.MaskMode.MASK_MODE_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[Mask.MaskMode.MASK_MODE_SUBTRACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[Mask.MaskMode.MASK_MODE_INTERSECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[Mask.MaskMode.MASK_MODE_ADD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[Layer.LayerType.values().length];
            a = iArr2;
            try {
                iArr2[Layer.LayerType.SHAPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[Layer.LayerType.PRE_COMP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[Layer.LayerType.SOLID.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[Layer.LayerType.IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[Layer.LayerType.NULL.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[Layer.LayerType.TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[Layer.LayerType.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.airbnb.lottie.g gVar, Layer layer) {
        com.airbnb.lottie.t.a aVar = new com.airbnb.lottie.t.a(1);
        this.f443f = aVar;
        this.f444g = new com.airbnb.lottie.t.a(PorterDuff.Mode.CLEAR);
        this.f445h = new RectF();
        this.f446i = new RectF();
        this.f447j = new RectF();
        this.f448k = new RectF();
        this.m = new Matrix();
        this.u = new ArrayList();
        this.w = true;
        this.n = gVar;
        this.o = layer;
        this.f449l = layer.g() + "#draw";
        if (layer.f() == Layer.MatteType.INVERT) {
            aVar.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            aVar.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        o b2 = layer.u().b();
        this.v = b2;
        b2.b(this);
        if (layer.e() != null && !layer.e().isEmpty()) {
            com.airbnb.lottie.t.c.g gVar2 = new com.airbnb.lottie.t.c.g(layer.e());
            this.p = gVar2;
            for (com.airbnb.lottie.t.c.a<h, Path> aVar2 : gVar2.a()) {
                aVar2.a(this);
            }
            for (com.airbnb.lottie.t.c.a<Integer, Integer> aVar3 : this.p.c()) {
                i(aVar3);
                aVar3.a(this);
            }
        }
        I();
    }

    private void A() {
        this.n.invalidateSelf();
    }

    private void B(float f2) {
        this.n.n().m().a(this.o.g(), f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(boolean z) {
        if (z != this.w) {
            this.w = z;
            A();
        }
    }

    private void I() {
        if (!this.o.c().isEmpty()) {
            com.airbnb.lottie.t.c.c cVar = new com.airbnb.lottie.t.c.c(this.o.c());
            this.q = cVar;
            cVar.k();
            this.q.a(new C0020a());
            H(this.q.h().floatValue() == 1.0f);
            i(this.q);
            return;
        }
        H(true);
    }

    private void j(Canvas canvas, Matrix matrix, Mask mask, com.airbnb.lottie.t.c.a<h, Path> aVar, com.airbnb.lottie.t.c.a<Integer, Integer> aVar2) {
        this.a.set(aVar.h());
        this.a.transform(matrix);
        this.c.setAlpha((int) (aVar2.h().intValue() * 2.55f));
        canvas.drawPath(this.a, this.c);
    }

    private void k(Canvas canvas, Matrix matrix, Mask mask, com.airbnb.lottie.t.c.a<h, Path> aVar, com.airbnb.lottie.t.c.a<Integer, Integer> aVar2) {
        com.airbnb.lottie.w.h.m(canvas, this.f445h, this.f441d);
        this.a.set(aVar.h());
        this.a.transform(matrix);
        this.c.setAlpha((int) (aVar2.h().intValue() * 2.55f));
        canvas.drawPath(this.a, this.c);
        canvas.restore();
    }

    private void l(Canvas canvas, Matrix matrix, Mask mask, com.airbnb.lottie.t.c.a<h, Path> aVar, com.airbnb.lottie.t.c.a<Integer, Integer> aVar2) {
        com.airbnb.lottie.w.h.m(canvas, this.f445h, this.c);
        canvas.drawRect(this.f445h, this.c);
        this.a.set(aVar.h());
        this.a.transform(matrix);
        this.c.setAlpha((int) (aVar2.h().intValue() * 2.55f));
        canvas.drawPath(this.a, this.f442e);
        canvas.restore();
    }

    private void m(Canvas canvas, Matrix matrix, Mask mask, com.airbnb.lottie.t.c.a<h, Path> aVar, com.airbnb.lottie.t.c.a<Integer, Integer> aVar2) {
        com.airbnb.lottie.w.h.m(canvas, this.f445h, this.f441d);
        canvas.drawRect(this.f445h, this.c);
        this.f442e.setAlpha((int) (aVar2.h().intValue() * 2.55f));
        this.a.set(aVar.h());
        this.a.transform(matrix);
        canvas.drawPath(this.a, this.f442e);
        canvas.restore();
    }

    private void n(Canvas canvas, Matrix matrix, Mask mask, com.airbnb.lottie.t.c.a<h, Path> aVar, com.airbnb.lottie.t.c.a<Integer, Integer> aVar2) {
        com.airbnb.lottie.w.h.m(canvas, this.f445h, this.f442e);
        canvas.drawRect(this.f445h, this.c);
        this.f442e.setAlpha((int) (aVar2.h().intValue() * 2.55f));
        this.a.set(aVar.h());
        this.a.transform(matrix);
        canvas.drawPath(this.a, this.f442e);
        canvas.restore();
    }

    private void o(Canvas canvas, Matrix matrix) {
        com.airbnb.lottie.d.a("Layer#saveLayer");
        com.airbnb.lottie.w.h.n(canvas, this.f445h, this.f441d, 19);
        if (Build.VERSION.SDK_INT < 28) {
            s(canvas);
        }
        com.airbnb.lottie.d.b("Layer#saveLayer");
        for (int i2 = 0; i2 < this.p.b().size(); i2++) {
            Mask mask = this.p.b().get(i2);
            com.airbnb.lottie.t.c.a<h, Path> aVar = this.p.a().get(i2);
            com.airbnb.lottie.t.c.a<Integer, Integer> aVar2 = this.p.c().get(i2);
            int i3 = b.b[mask.a().ordinal()];
            if (i3 != 1) {
                if (i3 == 2) {
                    if (i2 == 0) {
                        this.c.setColor(ViewCompat.MEASURED_STATE_MASK);
                        this.c.setAlpha(255);
                        canvas.drawRect(this.f445h, this.c);
                    }
                    if (mask.d()) {
                        n(canvas, matrix, mask, aVar, aVar2);
                    } else {
                        p(canvas, matrix, mask, aVar, aVar2);
                    }
                } else if (i3 != 3) {
                    if (i3 == 4) {
                        if (mask.d()) {
                            l(canvas, matrix, mask, aVar, aVar2);
                        } else {
                            j(canvas, matrix, mask, aVar, aVar2);
                        }
                    }
                } else if (mask.d()) {
                    m(canvas, matrix, mask, aVar, aVar2);
                } else {
                    k(canvas, matrix, mask, aVar, aVar2);
                }
            } else if (q()) {
                this.c.setAlpha(255);
                canvas.drawRect(this.f445h, this.c);
            }
        }
        com.airbnb.lottie.d.a("Layer#restoreLayer");
        canvas.restore();
        com.airbnb.lottie.d.b("Layer#restoreLayer");
    }

    private void p(Canvas canvas, Matrix matrix, Mask mask, com.airbnb.lottie.t.c.a<h, Path> aVar, com.airbnb.lottie.t.c.a<Integer, Integer> aVar2) {
        this.a.set(aVar.h());
        this.a.transform(matrix);
        canvas.drawPath(this.a, this.f442e);
    }

    private boolean q() {
        if (this.p.a().isEmpty()) {
            return false;
        }
        for (int i2 = 0; i2 < this.p.b().size(); i2++) {
            if (this.p.b().get(i2).a() != Mask.MaskMode.MASK_MODE_NONE) {
                return false;
            }
        }
        return true;
    }

    private void r() {
        if (this.t != null) {
            return;
        }
        if (this.s == null) {
            this.t = Collections.emptyList();
            return;
        }
        this.t = new ArrayList();
        for (a aVar = this.s; aVar != null; aVar = aVar.s) {
            this.t.add(aVar);
        }
    }

    private void s(Canvas canvas) {
        com.airbnb.lottie.d.a("Layer#clearLayer");
        RectF rectF = this.f445h;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.f444g);
        com.airbnb.lottie.d.b("Layer#clearLayer");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static a u(Layer layer, com.airbnb.lottie.g gVar, com.airbnb.lottie.e eVar) {
        switch (b.a[layer.d().ordinal()]) {
            case 1:
                return new e(gVar, layer);
            case 2:
                return new com.airbnb.lottie.model.layer.b(gVar, layer, eVar.n(layer.k()), eVar);
            case 3:
                return new f(gVar, layer);
            case 4:
                return new c(gVar, layer);
            case 5:
                return new d(gVar, layer);
            case 6:
                return new g(gVar, layer);
            default:
                com.airbnb.lottie.w.d.c("Unknown layer type " + layer.d());
                return null;
        }
    }

    private void y(RectF rectF, Matrix matrix) {
        this.f446i.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (w()) {
            int size = this.p.b().size();
            for (int i2 = 0; i2 < size; i2++) {
                Mask mask = this.p.b().get(i2);
                this.a.set(this.p.a().get(i2).h());
                this.a.transform(matrix);
                int i3 = b.b[mask.a().ordinal()];
                if (i3 == 1 || i3 == 2) {
                    return;
                }
                if ((i3 == 3 || i3 == 4) && mask.d()) {
                    return;
                }
                this.a.computeBounds(this.f448k, false);
                if (i2 == 0) {
                    this.f446i.set(this.f448k);
                } else {
                    RectF rectF2 = this.f446i;
                    rectF2.set(Math.min(rectF2.left, this.f448k.left), Math.min(this.f446i.top, this.f448k.top), Math.max(this.f446i.right, this.f448k.right), Math.max(this.f446i.bottom, this.f448k.bottom));
                }
            }
            if (rectF.intersect(this.f446i)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    private void z(RectF rectF, Matrix matrix) {
        if (x() && this.o.f() != Layer.MatteType.INVERT) {
            this.f447j.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.r.e(this.f447j, matrix, true);
            if (rectF.intersect(this.f447j)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    public void C(com.airbnb.lottie.t.c.a<?, ?> aVar) {
        this.u.remove(aVar);
    }

    void D(com.airbnb.lottie.model.d dVar, int i2, List<com.airbnb.lottie.model.d> list, com.airbnb.lottie.model.d dVar2) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E(@Nullable a aVar) {
        this.r = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F(@Nullable a aVar) {
        this.s = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.v.j(f2);
        if (this.p != null) {
            for (int i2 = 0; i2 < this.p.a().size(); i2++) {
                this.p.a().get(i2).l(f2);
            }
        }
        if (this.o.t() != 0.0f) {
            f2 /= this.o.t();
        }
        com.airbnb.lottie.t.c.c cVar = this.q;
        if (cVar != null) {
            cVar.l(f2 / this.o.t());
        }
        a aVar = this.r;
        if (aVar != null) {
            this.r.G(aVar.o.t() * f2);
        }
        for (int i3 = 0; i3 < this.u.size(); i3++) {
            this.u.get(i3).l(f2);
        }
    }

    @Override // com.airbnb.lottie.t.c.a.b
    public void a() {
        A();
    }

    @Override // com.airbnb.lottie.t.b.c
    public void b(List<com.airbnb.lottie.t.b.c> list, List<com.airbnb.lottie.t.b.c> list2) {
    }

    @Override // com.airbnb.lottie.model.e
    @CallSuper
    public <T> void c(T t, @Nullable com.airbnb.lottie.x.c<T> cVar) {
        this.v.c(t, cVar);
    }

    @Override // com.airbnb.lottie.model.e
    public void d(com.airbnb.lottie.model.d dVar, int i2, List<com.airbnb.lottie.model.d> list, com.airbnb.lottie.model.d dVar2) {
        if (dVar.g(getName(), i2)) {
            if (!"__container".equals(getName())) {
                dVar2 = dVar2.a(getName());
                if (dVar.c(getName(), i2)) {
                    list.add(dVar2.i(this));
                }
            }
            if (dVar.h(getName(), i2)) {
                D(dVar, i2 + dVar.e(getName(), i2), list, dVar2);
            }
        }
    }

    @Override // com.airbnb.lottie.t.b.e
    @CallSuper
    public void e(RectF rectF, Matrix matrix, boolean z) {
        this.f445h.set(0.0f, 0.0f, 0.0f, 0.0f);
        r();
        this.m.set(matrix);
        if (z) {
            List<a> list = this.t;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.m.preConcat(this.t.get(size).v.f());
                }
            } else {
                a aVar = this.s;
                if (aVar != null) {
                    this.m.preConcat(aVar.v.f());
                }
            }
        }
        this.m.preConcat(this.v.f());
    }

    @Override // com.airbnb.lottie.t.b.e
    public void g(Canvas canvas, Matrix matrix, int i2) {
        com.airbnb.lottie.d.a(this.f449l);
        if (this.w && !this.o.v()) {
            r();
            com.airbnb.lottie.d.a("Layer#parentMatrix");
            this.b.reset();
            this.b.set(matrix);
            for (int size = this.t.size() - 1; size >= 0; size--) {
                this.b.preConcat(this.t.get(size).v.f());
            }
            com.airbnb.lottie.d.b("Layer#parentMatrix");
            int intValue = (int) ((((i2 / 255.0f) * (this.v.h() == null ? 100 : this.v.h().h().intValue())) / 100.0f) * 255.0f);
            if (!x() && !w()) {
                this.b.preConcat(this.v.f());
                com.airbnb.lottie.d.a("Layer#drawLayer");
                t(canvas, this.b, intValue);
                com.airbnb.lottie.d.b("Layer#drawLayer");
                B(com.airbnb.lottie.d.b(this.f449l));
                return;
            }
            com.airbnb.lottie.d.a("Layer#computeBounds");
            e(this.f445h, this.b, false);
            z(this.f445h, matrix);
            this.b.preConcat(this.v.f());
            y(this.f445h, this.b);
            if (!this.f445h.intersect(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight())) {
                this.f445h.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
            com.airbnb.lottie.d.b("Layer#computeBounds");
            if (!this.f445h.isEmpty()) {
                com.airbnb.lottie.d.a("Layer#saveLayer");
                this.c.setAlpha(255);
                com.airbnb.lottie.w.h.m(canvas, this.f445h, this.c);
                com.airbnb.lottie.d.b("Layer#saveLayer");
                s(canvas);
                com.airbnb.lottie.d.a("Layer#drawLayer");
                t(canvas, this.b, intValue);
                com.airbnb.lottie.d.b("Layer#drawLayer");
                if (w()) {
                    o(canvas, this.b);
                }
                if (x()) {
                    com.airbnb.lottie.d.a("Layer#drawMatte");
                    com.airbnb.lottie.d.a("Layer#saveLayer");
                    com.airbnb.lottie.w.h.n(canvas, this.f445h, this.f443f, 19);
                    com.airbnb.lottie.d.b("Layer#saveLayer");
                    s(canvas);
                    this.r.g(canvas, matrix, intValue);
                    com.airbnb.lottie.d.a("Layer#restoreLayer");
                    canvas.restore();
                    com.airbnb.lottie.d.b("Layer#restoreLayer");
                    com.airbnb.lottie.d.b("Layer#drawMatte");
                }
                com.airbnb.lottie.d.a("Layer#restoreLayer");
                canvas.restore();
                com.airbnb.lottie.d.b("Layer#restoreLayer");
            }
            B(com.airbnb.lottie.d.b(this.f449l));
            return;
        }
        com.airbnb.lottie.d.b(this.f449l);
    }

    @Override // com.airbnb.lottie.t.b.c
    public String getName() {
        return this.o.g();
    }

    public void i(@Nullable com.airbnb.lottie.t.c.a<?, ?> aVar) {
        if (aVar == null) {
            return;
        }
        this.u.add(aVar);
    }

    abstract void t(Canvas canvas, Matrix matrix, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public Layer v() {
        return this.o;
    }

    boolean w() {
        com.airbnb.lottie.t.c.g gVar = this.p;
        return (gVar == null || gVar.a().isEmpty()) ? false : true;
    }

    boolean x() {
        return this.r != null;
    }
}
