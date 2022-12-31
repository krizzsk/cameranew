package us.pinguo.edit2020.viewmodel.module;

import android.graphics.RectF;
import android.util.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.b.l;
import kotlin.jvm.b.r;
import kotlin.jvm.internal.s;
import kotlin.text.StringsKt__StringsKt;
import us.pinguo.edit2020.bean.j;
import us.pinguo.edit2020.bean.m;
import us.pinguo.edit2020.bean.n;
import us.pinguo.edit2020.bean.o;
import us.pinguo.edit2020.bean.u0;
import us.pinguo.edit2020.bean.x;
import us.pinguo.edit2020.model.EditRender;
import us.pinguo.edit2020.repository.EditRepository;
import us.pinguo.edit2020.viewmodel.FunctionType;
import us.pinguo.repository2020.u;
import us.pinguo.u3dengine.edit.EditModel;
/* compiled from: EditModule.kt */
/* loaded from: classes4.dex */
public final class f {
    private final EditRender a;
    private u<FunctionType> b;
    private boolean c;

    /* renamed from: d  reason: collision with root package name */
    private final g f10893d;

    /* renamed from: e  reason: collision with root package name */
    private final d f10894e;

    /* renamed from: f  reason: collision with root package name */
    private final EditBlurringModule f10895f;

    /* renamed from: g  reason: collision with root package name */
    private final BackgroundReplacementModule f10896g;

    /* renamed from: h  reason: collision with root package name */
    private final StaticStickerModule f10897h;

    /* renamed from: i  reason: collision with root package name */
    private final EditBackgroundBlurModule f10898i;

    /* renamed from: j  reason: collision with root package name */
    private final EditRepository f10899j;

    /* renamed from: k  reason: collision with root package name */
    private final ArrayList<n> f10900k;

    /* renamed from: l  reason: collision with root package name */
    private final ArrayList<ArrayList<m>> f10901l;
    private final ArrayList<Integer> m;
    private final ArrayList<o> n;
    private boolean o;
    private boolean p;

    /* compiled from: EditModule.kt */
    /* loaded from: classes4.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[FunctionType.values().length];
            iArr[FunctionType.MOSAIC.ordinal()] = 1;
            iArr[FunctionType.GRAFFITI.ordinal()] = 2;
            iArr[FunctionType.CROP.ordinal()] = 3;
            iArr[FunctionType.BLUR.ordinal()] = 4;
            iArr[FunctionType.STICKER.ordinal()] = 5;
            iArr[FunctionType.ELIMINATION.ordinal()] = 6;
            iArr[FunctionType.BACKGROUND_REPLACEMENT.ordinal()] = 7;
            iArr[FunctionType.BACKGROUND_BLUR.ordinal()] = 8;
            a = iArr;
        }
    }

    public f(EditRender render) {
        s.h(render, "render");
        this.a = render;
        this.b = new u<>(null);
        this.f10893d = new g(render);
        this.f10894e = new d(render);
        this.f10895f = new EditBlurringModule(render);
        this.f10896g = new BackgroundReplacementModule(render);
        this.f10897h = new StaticStickerModule(render);
        this.f10898i = new EditBackgroundBlurModule(render);
        EditRepository editRepository = new EditRepository();
        this.f10899j = editRepository;
        this.f10900k = editRepository.k();
        this.f10901l = editRepository.h();
        this.m = editRepository.i();
        this.n = editRepository.l();
    }

    public final void A(float f2, float f3, float f4, float f5) {
        this.a.Z(f2, f3, f4, f5);
    }

    public final void B(float f2, float f3, float f4, float f5) {
        this.a.a0(f2, f3, f4, f5);
    }

    public final void C(boolean z) {
        this.c = z;
    }

    public final void D(float f2, float f3, float f4, float f5, boolean z) {
        this.a.n0(f2, f3, f4, f5, z);
    }

    public final void E(boolean z) {
        this.o = z;
    }

    public final void F(float f2) {
        this.a.o0(f2);
    }

    public final void G(r<? super Float, ? super Float, ? super Float, ? super Float, kotlin.u> rVar) {
        this.a.M0(rVar);
    }

    public final void H(float f2) {
        this.a.V0(f2);
    }

    public final void I(float f2) {
        this.a.W0(f2);
    }

    public final void J(kotlin.jvm.b.a<kotlin.u> aVar) {
        this.a.Z0(aVar);
    }

    public final void K(kotlin.jvm.b.a<kotlin.u> aVar) {
        this.a.a1(aVar);
    }

    public final void L(float f2) {
        this.a.d1(f2);
    }

    public final void M(float f2) {
        this.a.e1(f2);
    }

    public final void a(EditModel mode) {
        s.h(mode, "mode");
        this.a.o(mode);
    }

    public final void b(l<? super EditModel, kotlin.u> prepared) {
        s.h(prepared, "prepared");
        this.a.o(EditModel.Clip);
        this.a.J0(prepared);
    }

    public final void c(boolean z) {
        this.a.n1(z);
    }

    public final void d() {
        this.a.y();
        this.p = !this.p;
    }

    public final boolean e() {
        return this.c;
    }

    public final u<u0> f() {
        return this.a.L();
    }

    public final ArrayList<ArrayList<m>> g() {
        return this.f10901l;
    }

    public final ArrayList<Integer> h() {
        return this.m;
    }

    public final u<FunctionType> i() {
        return this.b;
    }

    public final EditBackgroundBlurModule j() {
        return this.f10898i;
    }

    public final BackgroundReplacementModule k() {
        return this.f10896g;
    }

    public final EditBlurringModule l() {
        return this.f10895f;
    }

    public final ArrayList<n> m() {
        return this.f10900k;
    }

    public final d n() {
        return this.f10894e;
    }

    public final g o() {
        return this.f10893d;
    }

    public final StaticStickerModule p() {
        return this.f10897h;
    }

    public final ArrayList<o> q() {
        return this.n;
    }

    public final int r(String key) {
        s.h(key, "key");
        Iterator<n> it = this.f10899j.k().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            int i3 = i2 + 1;
            if (s.c(key, it.next().h())) {
                return i2;
            }
            i2 = i3;
        }
        return 0;
    }

    public final Size s() {
        return this.a.K();
    }

    public final boolean t() {
        return this.o;
    }

    public final boolean u() {
        return this.p;
    }

    public final boolean v(FunctionType functionType) {
        boolean z = false;
        switch (functionType == null ? -1 : a.a[functionType.ordinal()]) {
            case 1:
                return this.f10893d.f().get();
            case 2:
                return this.f10894e.f().get();
            case 3:
                return this.o;
            case 4:
                List<j> e2 = this.f10895f.e();
                if (!(e2 instanceof Collection) || !e2.isEmpty()) {
                    for (j jVar : e2) {
                        if (jVar.e()) {
                            return true;
                        }
                    }
                }
                return false;
            case 5:
                List<x> V = this.f10897h.V();
                return !((V == null || V.isEmpty()) ? true : true);
            case 6:
                return this.c;
            case 7:
                return this.f10896g.d0();
            case 8:
                List<x> T = this.f10898i.T();
                return !((T == null || T.isEmpty()) ? true : true);
            default:
                return false;
        }
    }

    public final void w() {
        this.f10897h.i0();
    }

    public final void x(String records) {
        List<String> o0;
        Integer h2;
        s.h(records, "records");
        o0 = StringsKt__StringsKt.o0(records, new char[]{','}, false, 0, 6, null);
        for (String str : o0) {
            h2 = kotlin.text.s.h(str);
            if (h2 != null && h2.intValue() == 0) {
                q().get(1).m(true);
            } else if (h2 != null && h2.intValue() == 1) {
                q().get(2).m(true);
            }
        }
    }

    public final void y() {
        this.f10896g.l0();
    }

    public final void z(RectF rectF) {
        s.h(rectF, "rectF");
        this.a.X(rectF);
    }
}
