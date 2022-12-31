package us.pinguo.edit2020.viewmodel.module;

import androidx.databinding.ObservableBoolean;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.c0;
import kotlin.jvm.internal.s;
import kotlin.text.StringsKt__StringsKt;
import us.pinguo.common.network.common.header.PGTransHeader;
import us.pinguo.edit2020.bean.e0;
import us.pinguo.edit2020.bean.x;
import us.pinguo.edit2020.model.EditRender;
import us.pinguo.repository2020.entity.MaterialResponse;
import us.pinguo.repository2020.entity.Mosaic;
import us.pinguo.repository2020.manager.MaterialDataManager;
import us.pinguo.repository2020.u;
import us.pinguo.u3dengine.edit.BrushBuilder;
import us.pinguo.u3dengine.edit.EditModel;
/* compiled from: EditMosaicModule.kt */
/* loaded from: classes4.dex */
public final class g {
    private final EditRender a;
    private final u<Mosaic> b;
    private final u<Mosaic> c;

    /* renamed from: d  reason: collision with root package name */
    private float f10902d;

    /* renamed from: e  reason: collision with root package name */
    private float f10903e;

    /* renamed from: f  reason: collision with root package name */
    private kotlin.jvm.b.a<kotlin.u> f10904f;

    /* renamed from: g  reason: collision with root package name */
    private ObservableBoolean f10905g;

    /* renamed from: h  reason: collision with root package name */
    private ObservableBoolean f10906h;

    public g(EditRender editRender) {
        s.h(editRender, "editRender");
        this.a = editRender;
        this.b = new u<>(null);
        this.c = new u<>(null);
        this.f10902d = 0.04f;
        this.f10903e = 0.04f;
        this.f10905g = new ObservableBoolean(false);
        this.f10906h = new ObservableBoolean(false);
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
        List<Mosaic> packages;
        StringBuilder sb = new StringBuilder();
        ArrayList<Mosaic> a = MaterialDataManager.a.d().a();
        ArrayList<Mosaic> arrayList = new ArrayList();
        for (Object obj : a) {
            if (((Mosaic) obj).getApplied()) {
                arrayList.add(obj);
            }
        }
        for (Mosaic mosaic : arrayList) {
            sb.append(s.q(mosaic.getPid(), PGTransHeader.CONNECTOR));
        }
        MaterialResponse<Mosaic> value = MaterialDataManager.a.f().getValue();
        if (value != null && (packages = value.getPackages()) != null) {
            ArrayList<Mosaic> arrayList2 = new ArrayList();
            for (Object obj2 : packages) {
                if (((Mosaic) obj2).getApplied()) {
                    arrayList2.add(obj2);
                }
            }
            for (Mosaic mosaic2 : arrayList2) {
                sb.append(s.q(mosaic2.getPid(), PGTransHeader.CONNECTOR));
            }
        }
        String sb2 = sb.toString();
        s.g(sb2, "stringBuilder.toString()");
        i0 = StringsKt__StringsKt.i0(sb2, PGTransHeader.CONNECTOR);
        return i0;
    }

    public final String d() {
        String i0;
        List<Mosaic> packages;
        Integer vip;
        StringBuilder sb = new StringBuilder();
        MaterialResponse<Mosaic> value = MaterialDataManager.a.f().getValue();
        if (value != null && (packages = value.getPackages()) != null) {
            ArrayList<Mosaic> arrayList = new ArrayList();
            for (Object obj : packages) {
                Mosaic mosaic = (Mosaic) obj;
                boolean z = true;
                if ((mosaic.getApplied() && (vip = mosaic.getVip()) != null && vip.intValue() == 1) ? false : false) {
                    arrayList.add(obj);
                }
            }
            for (Mosaic mosaic2 : arrayList) {
                sb.append(s.q(mosaic2.getPid(), PGTransHeader.CONNECTOR));
            }
        }
        String sb2 = sb.toString();
        s.g(sb2, "stringBuilder.toString()");
        i0 = StringsKt__StringsKt.i0(sb2, PGTransHeader.CONNECTOR);
        return i0;
    }

    public final ObservableBoolean e() {
        return this.f10906h;
    }

    public final ObservableBoolean f() {
        return this.f10905g;
    }

    public final float g() {
        return this.f10903e;
    }

    public final float h() {
        return this.f10902d;
    }

    public final u<Mosaic> i() {
        return this.b;
    }

    public final kotlin.jvm.b.a<kotlin.u> j() {
        return this.f10904f;
    }

    public final u<Mosaic> k() {
        return this.c;
    }

    public final List<x> l() {
        List<Mosaic> packages;
        ArrayList arrayList;
        List W;
        MaterialResponse<Mosaic> value = MaterialDataManager.a.f().getValue();
        if (value == null || (packages = value.getPackages()) == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (Object obj : packages) {
                if (((Mosaic) obj).getApplied()) {
                    arrayList.add(obj);
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        ArrayList<Mosaic> a = MaterialDataManager.a.d().a();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : a) {
            if (((Mosaic) obj2).getApplied()) {
                arrayList2.add(obj2);
            }
        }
        W = c0.W(arrayList2);
        W.addAll(arrayList);
        int size = W.size();
        ArrayList arrayList3 = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            arrayList3.add(new e0((Mosaic) W.get(i2)));
        }
        return arrayList3;
    }

    public final void m(String records) {
        List o0;
        List<Mosaic> packages;
        s.h(records, "records");
        int i2 = 0;
        o0 = StringsKt__StringsKt.o0(records, new char[]{','}, false, 0, 6, null);
        for (Object obj : o0) {
            int i3 = i2 + 1;
            if (i2 >= 0) {
                String str = (String) obj;
                if (i2 % 2 == 0) {
                    MaterialResponse<Mosaic> value = MaterialDataManager.a.f().getValue();
                    if (value != null && (packages = value.getPackages()) != null) {
                        for (Mosaic mosaic : packages) {
                            if (s.c(mosaic.getPid(), str)) {
                                mosaic.setApplied(true);
                            }
                        }
                    }
                    for (Mosaic mosaic2 : MaterialDataManager.a.d().a()) {
                        if (s.c(mosaic2.getPid(), str)) {
                            mosaic2.setApplied(true);
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

    public final void n() {
        List<Mosaic> packages;
        this.b.setValue(null);
        this.c.setValue(null);
        this.f10906h.set(false);
        this.f10905g.set(false);
        ArrayList<Mosaic> a = MaterialDataManager.a.d().a();
        Float valueOf = Float.valueOf(1.0f);
        if (a != null) {
            for (Mosaic mosaic : a) {
                mosaic.setBrushEffectIntensity(valueOf);
                mosaic.setApplied(false);
                ObservableBoolean isSelected = mosaic.isSelected();
                if (isSelected != null) {
                    isSelected.set(false);
                }
            }
        }
        MaterialResponse<Mosaic> value = MaterialDataManager.a.f().getValue();
        if (value == null || (packages = value.getPackages()) == null) {
            return;
        }
        for (Mosaic mosaic2 : packages) {
            mosaic2.setBrushEffectIntensity(valueOf);
            mosaic2.setApplied(false);
            ObservableBoolean isSelected2 = mosaic2.isSelected();
            if (isSelected2 != null) {
                isSelected2.set(false);
            }
        }
    }

    public final void o(Float f2) {
        float floatValue = f2 == null ? 1.0f : f2.floatValue();
        Mosaic value = this.b.getValue();
        if (value != null) {
            value.setBrushEffectIntensity(Float.valueOf(floatValue));
        }
        this.a.k0(floatValue);
    }

    public final void p(float f2) {
        this.a.m0(f2);
    }

    public final void q(float f2) {
        this.f10903e = f2;
    }

    public final void r(float f2) {
        this.f10902d = f2;
    }

    public final void s(kotlin.jvm.b.a<kotlin.u> aVar) {
        this.f10904f = aVar;
    }

    public final void t(BrushBuilder brushBuilder) {
        s.h(brushBuilder, "brushBuilder");
        this.a.K0(brushBuilder);
    }
}
