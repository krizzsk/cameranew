package us.pinguo.edit2020.viewmodel.module;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PointF;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.h0;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.bean.f0;
import us.pinguo.edit2020.bean.g0;
import us.pinguo.edit2020.bean.t;
import us.pinguo.edit2020.bean.u0;
import us.pinguo.edit2020.bean.v;
import us.pinguo.edit2020.bean.w;
import us.pinguo.edit2020.model.EditRender;
import us.pinguo.repository2020.manager.AdjustRepository;
import us.pinguo.u3dengine.edit.AdjustRenderData;
import us.pinguo.u3dengine.edit.BaseAdjustType;
import us.pinguo.u3dengine.edit.ColorOptionMode;
import us.pinguo.u3dengine.edit.EditModel;
import us.pinguo.u3dengine.edit.HSLAdjustColor;
import us.pinguo.u3dengine.edit.NativeAdjustEntity;
import us.pinguo.u3dengine.edit.UnityEditCaller;
/* compiled from: AdjustModule.kt */
/* loaded from: classes4.dex */
public final class AdjustModule {
    private final EditRender a;
    private v b;
    private f0 c;

    /* renamed from: d  reason: collision with root package name */
    private final ArrayList<us.pinguo.edit2020.bean.a> f10825d;

    /* renamed from: e  reason: collision with root package name */
    private us.pinguo.edit2020.bean.a f10826e;

    public AdjustModule(EditRender render) {
        s.h(render, "render");
        this.a = render;
        this.f10825d = new ArrayList<>();
    }

    private final void k(v vVar) {
        ArrayList<w> o = vVar.o();
        o.add(new w(Color.parseColor("#e61725"), HSLAdjustColor.Red, new t(Color.parseColor("#e3447c"), Integer.valueOf(Color.parseColor("#f51919")), Color.parseColor("#f57737")), new t(Color.parseColor("#5c5858"), Integer.valueOf(Color.parseColor("#b74747")), Color.parseColor("#ffc5c5")), new t(Color.parseColor("#ffd5d5"), null, Color.parseColor("#e82222"))));
        o.add(new w(Color.parseColor("#f17f45"), HSLAdjustColor.Orange, new t(Color.parseColor("#ee4731"), Integer.valueOf(Color.parseColor("#f17f45")), Color.parseColor("#ffc03e")), new t(Color.parseColor("#5c5958"), Integer.valueOf(Color.parseColor("#b77547")), Color.parseColor("#ffe1c5")), new t(Color.parseColor("#ffe9d5"), null, Color.parseColor("#ff6c21"))));
        o.add(new w(Color.parseColor("#f6e23c"), HSLAdjustColor.Yellow, new t(Color.parseColor("#f1a845"), Integer.valueOf(Color.parseColor("#f7e33c")), Color.parseColor("#aad948")), new t(Color.parseColor("#5c5b58"), Integer.valueOf(Color.parseColor("#b79f47")), Color.parseColor("#fff745")), new t(Color.parseColor("#fff5d5"), null, Color.parseColor("#f4df29"))));
        o.add(new w(Color.parseColor("#47d94f"), HSLAdjustColor.Green, new t(Color.parseColor("#b6f73c"), Integer.valueOf(Color.parseColor("#48d94f")), Color.parseColor("#3fe286")), new t(Color.parseColor("#585c58"), Integer.valueOf(Color.parseColor("#76b747")), Color.parseColor("#d4ffc5")), new t(Color.parseColor("#d5ffdd"), null, Color.parseColor("#48d94f"))));
        o.add(new w(Color.parseColor("#3ee2d0"), HSLAdjustColor.Cyan, new t(Color.parseColor("#48d9a0"), Integer.valueOf(Color.parseColor("#3fe2d1")), Color.parseColor("#36b4d7")), new t(Color.parseColor("#585c58"), Integer.valueOf(Color.parseColor("#47b7b6")), Color.parseColor("#c5fffe")), new t(Color.parseColor("#d4ffff"), null, Color.parseColor("#39e5d3"))));
        o.add(new w(Color.parseColor("#3587d6"), HSLAdjustColor.Blue, new t(Color.parseColor("#3fc0e2"), Integer.valueOf(Color.parseColor("#3687d7")), Color.parseColor("#5245cd")), new t(Color.parseColor("#58595c"), Integer.valueOf(Color.parseColor("#4787b7")), Color.parseColor("#c5e6ff")), new t(Color.parseColor("#bfccf2"), null, Color.parseColor("#017cdf"))));
        o.add(new w(Color.parseColor("#8b45cd"), HSLAdjustColor.Purple, new t(Color.parseColor("#6891f3"), Integer.valueOf(Color.parseColor("#8c45cd")), Color.parseColor("#aa53c9")), new t(Color.parseColor("#5a585c"), Integer.valueOf(Color.parseColor("#8c3db0")), Color.parseColor("#f6c5ff")), new t(Color.parseColor("#eabff2"), null, Color.parseColor("#8c45cd"))));
        o.add(new w(Color.parseColor("#c853b1"), HSLAdjustColor.Magenta, new t(Color.parseColor("#9c45cd"), Integer.valueOf(Color.parseColor("#c953b2")), Color.parseColor("#ee31ab")), new t(Color.parseColor("#5c585b"), Integer.valueOf(Color.parseColor("#b03d96")), Color.parseColor("#ffc5ee")), new t(Color.parseColor("#f3c5dc"), null, Color.parseColor("#c953b2"))));
    }

    private final void l(f0 f0Var) {
        Resources resources = us.pinguo.foundation.e.b().getResources();
        String[] stringArray = resources.getStringArray(R.array.color_id_primary);
        s.g(stringArray, "res.getStringArray(R.array.color_id_primary)");
        String[] stringArray2 = resources.getStringArray(R.array.color_key_primary);
        s.g(stringArray2, "res.getStringArray(R.array.color_key_primary)");
        TypedArray obtainTypedArray = resources.obtainTypedArray(R.array.color_option_primary);
        s.g(obtainTypedArray, "res.obtainTypedArray(R.array.color_option_primary)");
        float[] fArr = {1.0f, 0.5f, 1.0f, 0.5f, 1.0f, 0.5f, 1.0f, 1.0f, 1.0f};
        Iterator<Integer> it = new kotlin.z.d(0, 8).iterator();
        while (it.hasNext()) {
            int nextInt = ((h0) it).nextInt();
            int color = resources.getColor(obtainTypedArray.getResourceId(nextInt, R.color.color_option_primary_0));
            ArrayList<g0> o = f0Var.o();
            String str = stringArray[nextInt];
            s.g(str, "idArray[it]");
            String str2 = stringArray2[nextInt];
            s.g(str2, "keyArray[it]");
            String string = resources.getString(R.string.cyan);
            s.g(string, "res.getString(R.string.cyan)");
            us.pinguo.edit2020.bean.h0 h0Var = new us.pinguo.edit2020.bean.h0(string, f0Var.h());
            String string2 = resources.getString(R.string.magenta);
            s.g(string2, "res.getString(R.string.magenta)");
            us.pinguo.edit2020.bean.h0 h0Var2 = new us.pinguo.edit2020.bean.h0(string2, f0Var.h());
            String string3 = resources.getString(R.string.yellow);
            s.g(string3, "res.getString(R.string.yellow)");
            us.pinguo.edit2020.bean.h0 h0Var3 = new us.pinguo.edit2020.bean.h0(string3, f0Var.h());
            String string4 = resources.getString(R.string.black);
            s.g(string4, "res.getString(R.string.black)");
            o.add(new g0(str, str2, color, color, color, h0Var, h0Var2, h0Var3, new us.pinguo.edit2020.bean.h0(string4, f0Var.h()), fArr[nextInt]));
            stringArray = stringArray;
            resources = resources;
            stringArray2 = stringArray2;
        }
        obtainTypedArray.recycle();
    }

    public final void a(PointF normalizedFocusPoint, float f2, PointF normalizedOffset, int i2) {
        s.h(normalizedFocusPoint, "normalizedFocusPoint");
        s.h(normalizedOffset, "normalizedOffset");
        this.a.l(normalizedFocusPoint, f2, normalizedOffset, i2);
    }

    public final void b() {
        this.a.o(EditModel.Filter);
    }

    public final void c() {
        AdjustRenderData a = AdjustRepository.a.a();
        a.getAdjust().clear();
        for (w wVar : ((v) this.f10825d.get(9)).o()) {
            a.getAdjust().add(new NativeAdjustEntity(0, wVar.m().getColorKey(), wVar.m().getColorKey(), "0,0,0,0", 3));
        }
        UnityEditCaller.Adjustment.setAdjustValue(a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0042, code lost:
        if ((r6 == 0.0f) == false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0086, code lost:
        if ((r6 == 0.0f) == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00c9, code lost:
        if ((r6 == 0.0f) == false) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int d(int r17, int r18, int r19, int r20, int r21, float r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.viewmodel.module.AdjustModule.d(int, int, int, int, int, float, boolean):int");
    }

    public final void e(boolean z) {
        this.a.n1(z);
    }

    public final us.pinguo.edit2020.bean.a f() {
        return this.f10826e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r22v0, types: [us.pinguo.edit2020.viewmodel.module.AdjustModule] */
    /* JADX WARN: Type inference failed for: r7v2, types: [us.pinguo.edit2020.bean.a] */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v5, types: [us.pinguo.edit2020.bean.v, us.pinguo.edit2020.bean.a] */
    /* JADX WARN: Type inference failed for: r7v6, types: [us.pinguo.edit2020.bean.a, us.pinguo.edit2020.bean.f0] */
    /* JADX WARN: Type inference failed for: r7v8, types: [us.pinguo.edit2020.bean.a] */
    /* JADX WARN: Type inference failed for: r7v9, types: [us.pinguo.edit2020.bean.a] */
    public final List<us.pinguo.edit2020.bean.a> g() {
        ?? aVar;
        if (this.f10825d.isEmpty()) {
            Context b = us.pinguo.foundation.e.b();
            String[] stringArray = b.getResources().getStringArray(R.array.adjust_key);
            s.g(stringArray, "context.resources.getStr…Array(R.array.adjust_key)");
            String[] stringArray2 = b.getResources().getStringArray(R.array.adjust_name);
            s.g(stringArray2, "context.resources.getStr…rray(R.array.adjust_name)");
            int i2 = 1;
            BaseAdjustType baseAdjustType = BaseAdjustType.None;
            int i3 = 9;
            BaseAdjustType[] baseAdjustTypeArr = {BaseAdjustType.Exposure, BaseAdjustType.Brightness, BaseAdjustType.Contrast, BaseAdjustType.Highlight, BaseAdjustType.Shadow, BaseAdjustType.ColorTemperature, BaseAdjustType.Tonal, BaseAdjustType.Saturation, BaseAdjustType.Vividness, baseAdjustType, baseAdjustType, BaseAdjustType.Fade, BaseAdjustType.Level, BaseAdjustType.Sharpen, BaseAdjustType.Grain, BaseAdjustType.DarkCornerNew, BaseAdjustType.CenterLight, BaseAdjustType.Chromatic};
            HSLAdjustColor.values();
            TypedArray obtainTypedArray = b.getResources().obtainTypedArray(R.array.adjust_icon);
            s.g(obtainTypedArray, "context.resources.obtain…rray(R.array.adjust_icon)");
            int length = stringArray.length;
            int i4 = 0;
            int i5 = 0;
            while (i4 < length) {
                String k2 = stringArray[i4];
                int i6 = i5 + 1;
                BaseAdjustType baseAdjustType2 = baseAdjustTypeArr[i5];
                if (i5 == 0 || i5 == i2) {
                    s.g(k2, "k");
                    String str = stringArray2[i5];
                    s.g(str, "nameArray[i]");
                    int resourceId = obtainTypedArray.getResourceId(i5, R.drawable.ic_adjust_exposure);
                    Float lower = baseAdjustType2.getRange().getLower();
                    s.g(lower, "type.range.lower");
                    aVar = new us.pinguo.edit2020.bean.a(k2, str, resourceId, 0, lower.floatValue() < 0.0f ? -100 : 0, 100, false);
                    aVar.m(new AdjustModule$functions$1$function$1(baseAdjustType2, aVar));
                } else if (i5 == i3) {
                    s.g(k2, "k");
                    String str2 = stringArray2[i5];
                    s.g(str2, "nameArray[i]");
                    aVar = new v(k2, str2, obtainTypedArray.getResourceId(i5, R.drawable.ic_adjust_exposure), 0, -100, 100, false);
                    k(aVar);
                    aVar.m(new AdjustModule$functions$1$function$2(aVar));
                } else if (i5 == 10) {
                    s.g(k2, "k");
                    String str3 = stringArray2[i5];
                    s.g(str3, "nameArray[i]");
                    aVar = new f0(k2, str3, obtainTypedArray.getResourceId(i5, R.drawable.ic_adjust_exposure), 0, -100, 100, true);
                    l(aVar);
                    aVar.m(new AdjustModule$functions$1$function$3(aVar));
                } else if (i5 != 17) {
                    s.g(k2, "k");
                    String str4 = stringArray2[i5];
                    s.g(str4, "nameArray[i]");
                    int resourceId2 = obtainTypedArray.getResourceId(i5, R.drawable.ic_adjust_exposure);
                    Float lower2 = baseAdjustType2.getRange().getLower();
                    s.g(lower2, "type.range.lower");
                    aVar = new us.pinguo.edit2020.bean.a(k2, str4, resourceId2, 0, lower2.floatValue() < 0.0f ? -100 : 0, 100, false);
                    aVar.m(new AdjustModule$functions$1$function$5(baseAdjustType2, aVar));
                } else {
                    s.g(k2, "k");
                    String str5 = stringArray2[i5];
                    s.g(str5, "nameArray[i]");
                    int resourceId3 = obtainTypedArray.getResourceId(i5, R.drawable.ic_adjust_exposure);
                    Float lower3 = baseAdjustType2.getRange().getLower();
                    s.g(lower3, "type.range.lower");
                    aVar = new us.pinguo.edit2020.bean.a(k2, str5, resourceId3, 0, lower3.floatValue() < 0.0f ? -100 : 0, 100, false);
                    aVar.m(new AdjustModule$functions$1$function$4(baseAdjustType2, aVar));
                }
                this.f10825d.add(aVar);
                i4++;
                i5 = i6;
                i2 = 1;
                i3 = 9;
            }
            obtainTypedArray.recycle();
        }
        return this.f10825d;
    }

    public final f0 h() {
        return this.c;
    }

    public final v i() {
        return this.b;
    }

    public final u0 j() {
        return this.a.L().getValue();
    }

    public final void m() {
        this.f10826e = null;
        this.b = null;
        this.c = null;
        int i2 = 0;
        for (Object obj : this.f10825d) {
            int i3 = i2 + 1;
            if (i2 >= 0) {
                us.pinguo.edit2020.bean.a aVar = (us.pinguo.edit2020.bean.a) obj;
                int h2 = aVar.h();
                if (i2 == 9) {
                    v vVar = (v) aVar;
                    vVar.q(0);
                    for (w wVar : vVar.o()) {
                        wVar.n(h2);
                        wVar.o(h2);
                        wVar.p(h2);
                    }
                } else if (i2 != 10) {
                    aVar.l(h2);
                } else {
                    f0 f0Var = (f0) aVar;
                    f0Var.r(0);
                    f0Var.s(ColorOptionMode.Absolute);
                    for (g0 g0Var : f0Var.o()) {
                        g0Var.e(g0Var.c());
                        g0Var.f(g0Var.c());
                        g0Var.h().c(h2);
                        g0Var.k().c(h2);
                        g0Var.m().c(h2);
                        g0Var.g().c(h2);
                    }
                }
                i2 = i3;
            } else {
                kotlin.collections.s.n();
                throw null;
            }
        }
    }

    public final void n() {
        f0 f0Var = (f0) this.f10825d.get(10);
        f0Var.r(0);
        f0Var.s(ColorOptionMode.Absolute);
        int h2 = f0Var.h();
        for (g0 g0Var : f0Var.o()) {
            g0Var.e(g0Var.c());
            g0Var.f(g0Var.c());
            g0Var.h().c(h2);
            g0Var.k().c(h2);
            g0Var.m().c(h2);
            g0Var.g().c(h2);
        }
    }

    public final void o() {
        v vVar = (v) this.f10825d.get(9);
        vVar.q(0);
        int h2 = vVar.h();
        for (w wVar : vVar.o()) {
            wVar.p(h2);
            wVar.o(h2);
            wVar.n(h2);
        }
    }

    public final void p() {
        f0 f0Var = this.c;
        if (f0Var == null) {
            return;
        }
        f0 f0Var2 = (f0) this.f10825d.get(10);
        f0Var.n(f0Var2);
        kotlin.jvm.b.a<u> k2 = f0Var2.k();
        if (k2 == null) {
            return;
        }
        k2.invoke();
    }

    public final void q() {
        v vVar = this.b;
        if (vVar == null) {
            return;
        }
        v vVar2 = (v) this.f10825d.get(9);
        vVar.n(vVar2);
        AdjustRenderData a = AdjustRepository.a.a();
        a.getAdjust().clear();
        for (w wVar : vVar2.o()) {
            String colorKey = wVar.m().getColorKey();
            String colorKey2 = wVar.m().getColorKey();
            a.getAdjust().add(new NativeAdjustEntity(0, colorKey, colorKey2, (wVar.g() / 100.0f) + ',' + (wVar.i() / 100.0f) + ',' + (wVar.h() / 100.0f) + ",0", 3));
        }
        UnityEditCaller.Adjustment.setAdjustValue(a);
    }

    public final void r(us.pinguo.edit2020.bean.a aVar) {
        this.f10826e = aVar;
    }

    public final void s(boolean z) {
        UnityEditCaller.Adjustment.setIsAdjustPreviewMode(z);
    }

    public final void t() {
        f0 f0Var = (f0) this.f10825d.get(10);
        f0 f0Var2 = this.c;
        if (f0Var2 == null) {
            this.c = new f0(f0Var);
        } else {
            f0Var.n(f0Var2);
        }
    }

    public final void u() {
        v vVar = (v) this.f10825d.get(9);
        v vVar2 = this.b;
        if (vVar2 == null) {
            this.b = new v(vVar);
        } else {
            vVar.n(vVar2);
        }
    }
}
