package us.pinguo.edit2020.viewmodel.module;

import android.graphics.Color;
import androidx.databinding.ObservableBoolean;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.s;
import kotlin.text.StringsKt__StringsKt;
import us.pinguo.common.network.common.header.PGTransHeader;
import us.pinguo.edit2020.bean.x;
import us.pinguo.edit2020.model.EditRender;
import us.pinguo.repository2020.entity.Graffiti;
import us.pinguo.repository2020.entity.MaterialResponse;
import us.pinguo.repository2020.manager.MaterialDataManager;
import us.pinguo.repository2020.u;
import us.pinguo.u3dengine.edit.BrushBuilder;
import us.pinguo.u3dengine.edit.EditModel;
/* compiled from: EditGraffitiModule.kt */
/* loaded from: classes4.dex */
public final class d {
    private final EditRender a;
    private final u<Graffiti> b;
    private final u<Graffiti> c;

    /* renamed from: d  reason: collision with root package name */
    private float f10886d;

    /* renamed from: e  reason: collision with root package name */
    private float f10887e;

    /* renamed from: f  reason: collision with root package name */
    private kotlin.jvm.b.a<kotlin.u> f10888f;

    /* renamed from: g  reason: collision with root package name */
    private ObservableBoolean f10889g;

    /* renamed from: h  reason: collision with root package name */
    private ObservableBoolean f10890h;

    /* renamed from: i  reason: collision with root package name */
    private String[] f10891i;

    /* renamed from: j  reason: collision with root package name */
    private String[] f10892j;

    public d(EditRender editRender) {
        s.h(editRender, "editRender");
        this.a = editRender;
        this.b = new u<>(null);
        this.c = new u<>(null);
        this.f10886d = 0.04f;
        this.f10887e = 0.04f;
        this.f10889g = new ObservableBoolean(false);
        this.f10890h = new ObservableBoolean(false);
        this.f10891i = new String[]{"#000000", "#ffffff", "#999999", "#cccccc", "#9d2925", "#c83641", "#ff6566", "#ff9898", "#ffe3f0", "#b84f33", "#ed5f36", "#ff9800", "#f4b225", "#eccc6b", "#394e46", "#676d46", "#948d52", "#828663", "#859f7d", "#cbccbc", "#404b6c", "#859fcb", "#84d5fe", "#cce9fe", "#424ccb", "#3a33fe", "#3d1066", "#8b2c9c", "#cb66fe", "#8c72fe", "#958fae", "#a58ca9"};
        this.f10892j = new String[]{"#ffffff", "#e72119", "#ff5722", "#ff9800", "#ffeb3b", "#cddc39", "#8bc34a", "#4caf50", "#009688", "#7dedc2", "#00bcd4", "#84d5fe", "#03a9f4", "#7a9dfe", "#3f51b5", "#673ab7", "#cb66fe", "#9871fe", "#e91e63", "#f19ec2"};
    }

    public final void a(EditModel editModel) {
        s.h(editModel, "editModel");
        if (this.a.A() != editModel) {
            this.a.o(editModel);
        }
    }

    public final void b(boolean z) {
        this.a.n1(z);
    }

    public final String c() {
        String i0;
        List<Graffiti> packages;
        StringBuilder sb = new StringBuilder();
        MaterialResponse<Graffiti> value = MaterialDataManager.a.b().getValue();
        if (value != null && (packages = value.getPackages()) != null) {
            ArrayList<Graffiti> arrayList = new ArrayList();
            for (Object obj : packages) {
                if (((Graffiti) obj).getApplied()) {
                    arrayList.add(obj);
                }
            }
            for (Graffiti graffiti : arrayList) {
                sb.append(s.q(graffiti.getPid(), PGTransHeader.CONNECTOR));
            }
        }
        String sb2 = sb.toString();
        s.g(sb2, "stringBuilder.toString()");
        i0 = StringsKt__StringsKt.i0(sb2, PGTransHeader.CONNECTOR);
        return i0;
    }

    public final String d() {
        String i0;
        List<Graffiti> packages;
        Integer vip;
        StringBuilder sb = new StringBuilder();
        MaterialResponse<Graffiti> value = MaterialDataManager.a.b().getValue();
        if (value != null && (packages = value.getPackages()) != null) {
            ArrayList<Graffiti> arrayList = new ArrayList();
            for (Object obj : packages) {
                Graffiti graffiti = (Graffiti) obj;
                boolean z = true;
                if ((graffiti.getApplied() && (vip = graffiti.getVip()) != null && vip.intValue() == 1) ? false : false) {
                    arrayList.add(obj);
                }
            }
            for (Graffiti graffiti2 : arrayList) {
                sb.append(s.q(graffiti2.getPid(), PGTransHeader.CONNECTOR));
            }
        }
        String sb2 = sb.toString();
        s.g(sb2, "stringBuilder.toString()");
        i0 = StringsKt__StringsKt.i0(sb2, PGTransHeader.CONNECTOR);
        return i0;
    }

    public final ObservableBoolean e() {
        return this.f10890h;
    }

    public final ObservableBoolean f() {
        return this.f10889g;
    }

    public final float g() {
        return this.f10887e;
    }

    public final float h() {
        return this.f10886d;
    }

    public final u<Graffiti> i() {
        return this.b;
    }

    public final kotlin.jvm.b.a<kotlin.u> j() {
        return this.f10888f;
    }

    public final String[] k() {
        return this.f10892j;
    }

    public final u<Graffiti> l() {
        return this.c;
    }

    public final String[] m() {
        return this.f10891i;
    }

    public final List<x> n() {
        List<Graffiti> packages;
        ArrayList arrayList;
        MaterialResponse<Graffiti> value = MaterialDataManager.a.b().getValue();
        if (value == null || (packages = value.getPackages()) == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (Object obj : packages) {
                if (((Graffiti) obj).getApplied()) {
                    arrayList.add(obj);
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            arrayList2.add(new us.pinguo.edit2020.bean.u((Graffiti) arrayList.get(i2)));
        }
        return arrayList2;
    }

    public final boolean o() {
        return this.a.R();
    }

    public final void p(String records) {
        List o0;
        MaterialResponse<Graffiti> value;
        List<Graffiti> packages;
        s.h(records, "records");
        int i2 = 0;
        o0 = StringsKt__StringsKt.o0(records, new char[]{','}, false, 0, 6, null);
        for (Object obj : o0) {
            int i3 = i2 + 1;
            if (i2 >= 0) {
                String str = (String) obj;
                if (i2 % 2 == 0 && (value = MaterialDataManager.a.b().getValue()) != null && (packages = value.getPackages()) != null) {
                    for (Graffiti graffiti : packages) {
                        if (s.c(graffiti.getPid(), str)) {
                            graffiti.setApplied(true);
                        }
                    }
                }
                i2 = i3;
            } else {
                kotlin.collections.s.n();
                throw null;
            }
        }
    }

    public final void q() {
        List<Graffiti> packages;
        this.b.setValue(null);
        this.c.setValue(null);
        this.f10890h.set(false);
        this.f10889g.set(false);
        MaterialResponse<Graffiti> value = MaterialDataManager.a.b().getValue();
        if (value == null || (packages = value.getPackages()) == null) {
            return;
        }
        for (Graffiti graffiti : packages) {
            graffiti.setBrushEffectIntensity(Float.valueOf(1.0f));
            graffiti.setApplied(false);
            ObservableBoolean isSelected = graffiti.isSelected();
            if (isSelected != null) {
                isSelected.set(false);
            }
            graffiti.setBrushColor("#FFFFFFFF");
        }
    }

    public final void r(String str) {
        Graffiti value = this.b.getValue();
        if (value != null) {
            value.setBrushColor(str);
        }
        this.a.j0(Color.parseColor(str));
    }

    public final void s(Float f2) {
        float floatValue = f2 == null ? 1.0f : f2.floatValue();
        Graffiti value = this.b.getValue();
        if (value != null) {
            value.setBrushEffectIntensity(Float.valueOf(floatValue));
        }
        this.a.k0(floatValue);
    }

    public final void t(float f2) {
        this.a.m0(f2);
    }

    public final void u(float f2) {
        this.f10887e = f2;
    }

    public final void v(float f2) {
        this.f10886d = f2;
    }

    public final void w(kotlin.jvm.b.a<kotlin.u> aVar) {
        this.f10888f = aVar;
    }

    public final void x(BrushBuilder brushBuilder) {
        s.h(brushBuilder, "brushBuilder");
        this.a.K0(brushBuilder);
    }
}
