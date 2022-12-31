package us.pinguo.camera2020.module.beauty;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.LifecycleObserver;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.b.q;
import kotlin.jvm.internal.s;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.l;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.z0;
import us.pinguo.camera2020.model.render.UnityRender;
import us.pinguo.camera2020.module.ExclusiveEffectType;
import us.pinguo.camera2020.module.b;
import us.pinguo.common.filter.ChangeStatus;
import us.pinguo.foundation.e;
import us.pinguo.processor.d;
import us.pinguo.repository2020.database.makeup.MaterialDetailTable;
import us.pinguo.repository2020.database.makeup.MaterialItemTable;
import us.pinguo.repository2020.entity.BeautyData;
import us.pinguo.repository2020.entity.BeautyUnityEnumData;
import us.pinguo.repository2020.entity.Material;
import us.pinguo.repository2020.entity.MaterialDetail;
import us.pinguo.repository2020.entity.MaterialResponse;
import us.pinguo.repository2020.entity.StyleMakeup;
import us.pinguo.repository2020.manager.BeautyDataManager;
import us.pinguo.repository2020.u;
import us.pinguo.repository2020.utils.g;
import us.pinguo.repository2020.utils.n;
import us.pinguo.u3dengine.api.DeformationParam;
import us.pinguo.u3dengine.api.MakeupMaterial;
import us.pinguo.u3dengine.api.MakeupType;
import us.pinguo.u3dengine.api.SoftSkinParam;
import us.pinguo.u3dengine.api.UnityMethodCaller;
/* compiled from: CameraBeautyModule.kt */
/* loaded from: classes3.dex */
public final class CameraBeautyModule implements LifecycleObserver, us.pinguo.camera2020.module.a {
    private final UnityRender a;
    private final ArrayList<BeautyData> b;
    private final ArrayList<BeautyData> c;

    /* renamed from: d */
    private final ArrayList<BeautyData> f9216d;

    /* renamed from: e */
    private final ArrayList<BeautyData> f9217e;

    /* renamed from: f */
    private ArrayList<BeautyData> f9218f;

    /* renamed from: g */
    private final u<d> f9219g;

    /* renamed from: h */
    private final u<Boolean> f9220h;

    /* renamed from: i */
    private boolean f9221i;

    /* renamed from: j */
    private u<BeautyData> f9222j;

    /* renamed from: k */
    private u<StyleMakeup> f9223k;

    /* renamed from: l */
    private u<StyleMakeup> f9224l;
    private u<BeautyData> m;
    private u<BeautyData> n;
    private int o;
    private ChangeStatus p;
    private ExclusiveEffectType q;
    private ExclusiveEffectType r;
    private ExclusiveEffectType s;
    private final ObservableField<Boolean> t;
    private final ObservableField<Boolean> u;
    private b v;
    private kotlin.jvm.b.a<kotlin.u> w;

    /* compiled from: CameraBeautyModule.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ExclusiveEffectType.values().length];
            iArr[ExclusiveEffectType.EFFECT_STYLED_MAKEUP.ordinal()] = 1;
            iArr[ExclusiveEffectType.EFFECT_CUSTOM_MAKEUP.ordinal()] = 2;
            iArr[ExclusiveEffectType.EFFECT_STICKER.ordinal()] = 3;
            iArr[ExclusiveEffectType.EFFECT_FILTER.ordinal()] = 4;
            a = iArr;
        }
    }

    public CameraBeautyModule(UnityRender unityRender) {
        s.h(unityRender, "unityRender");
        this.a = unityRender;
        BeautyDataManager beautyDataManager = BeautyDataManager.a;
        this.b = beautyDataManager.l().g();
        this.c = beautyDataManager.l().p();
        this.f9216d = beautyDataManager.l().l();
        this.f9217e = beautyDataManager.l().o();
        this.f9218f = beautyDataManager.l().r();
        this.f9219g = new u<>();
        Boolean bool = Boolean.FALSE;
        this.f9220h = new u<>(bool);
        this.f9223k = new u<>(null);
        this.f9224l = beautyDataManager.l().j();
        this.m = beautyDataManager.l().i();
        this.n = beautyDataManager.l().h();
        this.o = beautyDataManager.l().k();
        this.p = ChangeStatus.INIT;
        this.t = new ObservableField<>(bool);
        this.u = new ObservableField<>(bool);
    }

    private final String O(int i2, int i3) {
        List<BeautyData> subList = BeautyDataManager.a.l().p().subList(i2, i3);
        s.g(subList, "BeautyDataManager.beauty…ist(startIndex, endIndex)");
        String str = "";
        for (BeautyData beautyData : subList) {
            if (beautyData.isSelected().get()) {
                str = beautyData.getKey();
            }
        }
        return str;
    }

    public final String R(StyleMakeup styleMakeup) {
        String pid;
        MaterialDetailTable b = (styleMakeup == null || (pid = styleMakeup.getPid()) == null) ? null : us.pinguo.repository2020.database.a.a().z().b(pid);
        if (b == null) {
            return null;
        }
        List<MaterialItemTable> a2 = us.pinguo.repository2020.database.a.a().A().a(b.getId());
        if (a2 == null || a2.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        n nVar = n.a;
        String packageMd5 = b.getPackageMd5();
        if (packageMd5 == null) {
            packageMd5 = "";
        }
        sb.append(nVar.c(packageMd5));
        sb.append((Object) File.separator);
        sb.append((Object) a2.get(0).getId());
        return sb.toString();
    }

    public static /* synthetic */ void U(CameraBeautyModule cameraBeautyModule, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        cameraBeautyModule.T(z);
    }

    private final boolean Y() {
        for (BeautyData beautyData : this.c) {
            if (beautyData.isSelected().get() && beautyData.isVip()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0022, code lost:
        if (((r1 == null || (r1 = r1.getVip()) == null || r1.intValue() != 1) ? false : true) != false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void d0() {
        /*
            r4 = this;
            us.pinguo.camera2020.i.a r0 = us.pinguo.camera2020.i.a.a
            boolean r1 = r4.f9221i
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L25
            us.pinguo.repository2020.u<us.pinguo.repository2020.entity.StyleMakeup> r1 = r4.f9224l
            java.lang.Object r1 = r1.getValue()
            us.pinguo.repository2020.entity.StyleMakeup r1 = (us.pinguo.repository2020.entity.StyleMakeup) r1
            if (r1 != 0) goto L14
        L12:
            r1 = 0
            goto L22
        L14:
            java.lang.Integer r1 = r1.getVip()
            if (r1 != 0) goto L1b
            goto L12
        L1b:
            int r1 = r1.intValue()
            if (r1 != r2) goto L12
            r1 = 1
        L22:
            if (r1 == 0) goto L25
            goto L26
        L25:
            r2 = 0
        L26:
            r0.j(r2)
            us.pinguo.u3dengine.api.UnityMethodCaller.clearAllMakeup()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.camera2020.module.beauty.CameraBeautyModule.d0():void");
    }

    private final void h(ExclusiveEffectType exclusiveEffectType, ExclusiveEffectType exclusiveEffectType2) {
        int i2 = exclusiveEffectType == null ? -1 : a.a[exclusiveEffectType.ordinal()];
        if (i2 == 1) {
            if (exclusiveEffectType2 == ExclusiveEffectType.EFFECT_STICKER || exclusiveEffectType2 == ExclusiveEffectType.EFFECT_FILTER) {
                this.f9224l.postValue(null);
            }
        } else if (i2 != 2) {
            int i3 = exclusiveEffectType2 != null ? a.a[exclusiveEffectType2.ordinal()] : -1;
            if (i3 == 1) {
                d0();
            } else if (i3 == 3) {
                this.f9224l.postValue(null);
                d0();
            } else if (i3 != 4) {
            } else {
                this.f9224l.postValue(null);
            }
        } else if (exclusiveEffectType2 == ExclusiveEffectType.EFFECT_STICKER || exclusiveEffectType2 == ExclusiveEffectType.EFFECT_STYLED_MAKEUP) {
            d0();
        }
    }

    private final void i(BeautyData... beautyDataArr) {
        MakeupType makeupType;
        boolean C;
        for (BeautyData beautyData : beautyDataArr) {
            if (beautyData.getBeautyType() != 1) {
                beautyData.getHasModify().set(beautyData.getCurrentValue().get() != 0);
            }
            BeautyDataManager.a.l().v(beautyData);
            BeautyUnityEnumData unityEnumData = beautyData.getUnityEnumData();
            SoftSkinParam softSkinParam = unityEnumData.getSoftSkinParam();
            if (softSkinParam != null) {
                softSkinParam.setValue(beautyData.getCurrentValue().get() / (beautyData.getMaxValue() - beautyData.getMinValue()));
                UnityMethodCaller.setSoftSkin(softSkinParam);
            }
            DeformationParam deformationParam = unityEnumData.getDeformationParam();
            if (deformationParam != null) {
                deformationParam.setValue(beautyData.getCurrentValue().get() / (beautyData.getMaxValue() - beautyData.getMinValue()));
                UnityMethodCaller.setDeformation(deformationParam);
            }
            if (beautyData.isSelected().get() && (makeupType = unityEnumData.getMakeupType()) != null) {
                String bundlePath = beautyData.getBundlePath();
                C = StringsKt__StringsKt.C(beautyData.getBeautyKey(), Material.MATERIAL_SELECT_NONE_FLAG, false, 2, null);
                UnityMethodCaller.setMakeupMaterial(bundlePath, makeupType, !C ? beautyData.getColorIndex() : -1, beautyData.getCurrentValue().get() / beautyData.getMaxValue());
            }
        }
    }

    public static /* synthetic */ void j0(CameraBeautyModule cameraBeautyModule, String str, Float f2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            f2 = null;
        }
        cameraBeautyModule.i0(str, f2);
    }

    public static /* synthetic */ void k(CameraBeautyModule cameraBeautyModule, BeautyData beautyData, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        cameraBeautyModule.j(beautyData, z);
    }

    public static /* synthetic */ void m0(CameraBeautyModule cameraBeautyModule, String str, StyleMakeup styleMakeup, Float f2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            styleMakeup = null;
        }
        if ((i2 & 4) != 0) {
            f2 = null;
        }
        cameraBeautyModule.k0(str, styleMakeup, f2);
    }

    private final void p0(List<BeautyData> list, boolean z) {
        int i2;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            BeautyData beautyData = (BeautyData) it.next();
            if (beautyData.getBeautyType() == 1) {
                if (beautyData.isGroup() && beautyData.isExtended().get()) {
                    ArrayList<BeautyData> arrayList3 = new ArrayList();
                    for (Object obj : list) {
                        if (beautyData.getGroupId() == ((BeautyData) obj).getGroupId()) {
                            arrayList3.add(obj);
                        }
                    }
                    for (BeautyData beautyData2 : arrayList3) {
                        if (beautyData2.isSelected().get()) {
                            B().setValue(beautyData2);
                        }
                    }
                }
            } else if (beautyData.isSelected().get()) {
                A().postValue(beautyData);
            }
            BeautyUnityEnumData unityEnumData = beautyData.getUnityEnumData();
            SoftSkinParam softSkinParam = unityEnumData.getSoftSkinParam();
            if (softSkinParam != null) {
                softSkinParam.setValue(beautyData.getCurrentValue().get() / 100.0f);
                arrayList.add(softSkinParam);
            }
            DeformationParam deformationParam = unityEnumData.getDeformationParam();
            if (deformationParam != null) {
                deformationParam.setValue(beautyData.getCurrentValue().get() / 100.0f);
                arrayList2.add(deformationParam);
            }
            if (beautyData.isSelected().get() && beautyData.getUnityEnumData().getMakeupType() != null) {
                j(beautyData, z);
            }
        }
        int size = arrayList.size();
        SoftSkinParam[] softSkinParamArr = new SoftSkinParam[size];
        for (int i3 = 0; i3 < size; i3++) {
            softSkinParamArr[i3] = (SoftSkinParam) arrayList.get(i3);
        }
        UnityMethodCaller.setSoftSkin((SoftSkinParam[]) Arrays.copyOf(softSkinParamArr, size));
        int size2 = arrayList2.size();
        DeformationParam[] deformationParamArr = new DeformationParam[size2];
        for (i2 = 0; i2 < size2; i2++) {
            deformationParamArr[i2] = (DeformationParam) arrayList2.get(i2);
        }
        UnityMethodCaller.setDeformation((DeformationParam[]) Arrays.copyOf(deformationParamArr, size2));
    }

    static /* synthetic */ void q0(CameraBeautyModule cameraBeautyModule, List list, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        cameraBeautyModule.p0(list, z);
    }

    private final void u0(float f2) {
        this.a.h0(f2);
    }

    private final void x0(Integer num, SoftSkinParam softSkinParam) {
        if (softSkinParam != null) {
            UnityMethodCaller.setSoftSkin(softSkinParam);
        }
        if (num == null) {
            return;
        }
        n(num.intValue());
    }

    public final void y0(Integer num, SoftSkinParam softSkinParam, Integer num2, List<MakeupMaterial> list) {
        if (num2 != null) {
            UnityMethodCaller.setMakeupTheme(list, num2.intValue() / 100.0f);
        } else {
            UnityMethodCaller.setMakeupTheme$default(list, 0.0f, 2, null);
        }
        x0(num, softSkinParam);
    }

    public final u<BeautyData> A() {
        return this.n;
    }

    public final u<BeautyData> B() {
        return this.m;
    }

    public final u<StyleMakeup> C() {
        return this.f9224l;
    }

    public final String D() {
        return O(26, 31);
    }

    public final String E() {
        return O(22, 26);
    }

    public final String F() {
        return O(18, 22);
    }

    public final ArrayList<BeautyData> G() {
        return this.f9216d;
    }

    public final String H() {
        return O(0, 6);
    }

    public final List<BeautyData> I() {
        ArrayList<BeautyData> arrayList = this.b;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((BeautyData) obj).getCurrentValue().get() != 0) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    public final ObservableField<Boolean> J() {
        return this.u;
    }

    public final ArrayList<BeautyData> K() {
        return this.f9217e;
    }

    public final u<StyleMakeup> L() {
        return this.f9223k;
    }

    public final String M() {
        return O(6, 12);
    }

    public final ArrayList<BeautyData> N() {
        return this.c;
    }

    public final ExclusiveEffectType P() {
        return this.s;
    }

    public final u<d> Q() {
        return this.f9219g;
    }

    public final ArrayList<BeautyData> S() {
        return this.f9218f;
    }

    public final void T(boolean z) {
        p0(BeautyDataManager.a.l().e(), z);
        g0();
        f0();
    }

    public final void V() {
        q0(this, BeautyDataManager.a.l().g(), false, 2, null);
        f0();
    }

    public final ObservableField<Boolean> W() {
        return this.t;
    }

    public final Boolean X() {
        for (BeautyData beautyData : this.b) {
            if (beautyData.getCurrentValue().get() != 0) {
                return Boolean.TRUE;
            }
        }
        return null;
    }

    public final u<Boolean> Z() {
        return this.f9220h;
    }

    @Override // us.pinguo.camera2020.module.a
    public void a(ExclusiveEffectType effectType) {
        s.h(effectType, "effectType");
        if (effectType == ExclusiveEffectType.EFFECT_STICKER || effectType == ExclusiveEffectType.EFFECT_STYLED_MAKEUP) {
            this.r = this.q;
            T(true);
        }
    }

    public final boolean a0() {
        return this.f9221i;
    }

    @Override // us.pinguo.camera2020.module.a
    public boolean b(ExclusiveEffectType effectType) {
        s.h(effectType, "effectType");
        return (this.f9221i && effectType == ExclusiveEffectType.EFFECT_CUSTOM_MAKEUP) ? false : true;
    }

    public final boolean b0(StyleMakeup styleMakeup) {
        String R = R(styleMakeup);
        if (R == null) {
            return false;
        }
        return (styleMakeup != null && styleMakeup.isInstalled()) && new File(R).exists();
    }

    @Override // us.pinguo.camera2020.module.a
    public void c(ExclusiveEffectType effectType) {
        ExclusiveEffectType exclusiveEffectType;
        s.h(effectType, "effectType");
        h(this.r, effectType);
        ExclusiveEffectType exclusiveEffectType2 = this.r;
        ExclusiveEffectType exclusiveEffectType3 = ExclusiveEffectType.EFFECT_SHAPE;
        if (exclusiveEffectType2 == exclusiveEffectType3) {
            h(this.q, effectType);
        }
        ExclusiveEffectType exclusiveEffectType4 = ExclusiveEffectType.EFFECT_STYLED_MAKEUP;
        if ((effectType == exclusiveEffectType4 || effectType == ExclusiveEffectType.EFFECT_CUSTOM_MAKEUP || effectType == exclusiveEffectType3) && effectType != (exclusiveEffectType = this.r)) {
            this.q = exclusiveEffectType;
            this.r = effectType;
        }
        if (effectType == exclusiveEffectType4 || effectType == ExclusiveEffectType.EFFECT_STICKER) {
            this.s = effectType;
        }
    }

    public final void c0(StyleMakeup styleMakeup) {
        List<StyleMakeup> suites;
        StyleMakeup value;
        ObservableBoolean isSelected;
        int i2 = 0;
        if (styleMakeup == null) {
            this.f9221i = false;
            if (this.f9223k.getValue() != null && (value = this.f9223k.getValue()) != null && (isSelected = value.isSelected()) != null) {
                isSelected.set(false);
            }
            ExclusiveEffectType exclusiveEffectType = this.r;
            if (exclusiveEffectType == null || exclusiveEffectType == ExclusiveEffectType.EFFECT_CUSTOM_MAKEUP) {
                return;
            }
            q();
            return;
        }
        BeautyDataManager beautyDataManager = BeautyDataManager.a;
        MaterialResponse<StyleMakeup> value2 = beautyDataManager.p().getValue();
        if (value2 != null && (suites = value2.getSuites()) != null) {
            i2 = suites.indexOf(styleMakeup);
        }
        this.o = i2;
        beautyDataManager.l().y(this.o);
        us.pinguo.camera2020.i.a.a.j(styleMakeup.isVipLabelVisible());
        this.f9221i = true;
    }

    public final void e0(StyleMakeup styleMakeup) {
        ObservableBoolean isSelected;
        ObservableBoolean isSelected2;
        s.h(styleMakeup, "styleMakeup");
        if (this.f9223k.getValue() != null && !s.c(this.f9223k.getValue(), this.f9224l.getValue())) {
            StyleMakeup value = this.f9223k.getValue();
            if (value != null && (isSelected2 = value.isSelected()) != null) {
                isSelected2.set(false);
            }
            BeautyDataManager.a.l().w(this.f9223k.getValue());
        }
        this.f9223k.setValue(styleMakeup);
        StyleMakeup value2 = this.f9224l.getValue();
        if (value2 != null && (isSelected = value2.isSelected()) != null) {
            isSelected.set(true);
        }
        BeautyDataManager.a.l().w(this.f9224l.getValue());
    }

    public final void f0() {
        this.t.set(Boolean.FALSE);
        for (BeautyData beautyData : this.b) {
            if (beautyData.getCurrentValue().get() != beautyData.getDefaultValue()) {
                W().set(Boolean.TRUE);
            }
        }
    }

    public final void g(boolean z) {
        UnityMethodCaller.setFixedMakeupIntensity(z ? 1.0f : 0.0f);
    }

    public final void g0() {
        this.u.set(Boolean.FALSE);
        for (BeautyData beautyData : this.c) {
            if (beautyData.getHasModify().get()) {
                J().set(Boolean.TRUE);
            }
        }
    }

    public final void h0(String beautyParamString) {
        s.h(beautyParamString, "beautyParamString");
        g.a.a(beautyParamString);
        this.t.set(null);
    }

    public final void i0(String makeupDirName, Float f2) {
        s.h(makeupDirName, "makeupDirName");
        StringBuilder sb = new StringBuilder();
        sb.append(e.b().getFilesDir().getAbsolutePath());
        String str = File.separator;
        sb.append((Object) str);
        sb.append("makeup");
        sb.append((Object) str);
        k0(s.q(sb.toString(), makeupDirName), null, f2);
        this.u.set(null);
    }

    public final void j(BeautyData beautyData, boolean z) {
        BeautyData value;
        boolean z2;
        s.h(beautyData, "beautyData");
        u<BeautyData> uVar = this.f9222j;
        if (!s.c(uVar == null ? null : uVar.getValue(), beautyData)) {
            if (beautyData.getBeautyType() == 1) {
                this.m.setValue(beautyData);
            } else {
                this.n.setValue(beautyData);
            }
        }
        u<BeautyData> uVar2 = this.f9222j;
        if (uVar2 == null) {
            this.f9222j = new u<>(beautyData);
        } else if (uVar2 != null) {
            uVar2.setValue(beautyData);
        }
        if (z) {
            if (beautyData.getBeautyType() == 1) {
                b bVar = this.v;
                if (bVar != null) {
                    bVar.a(ExclusiveEffectType.EFFECT_CUSTOM_MAKEUP);
                }
            } else {
                b bVar2 = this.v;
                if (bVar2 != null) {
                    bVar2.a(ExclusiveEffectType.EFFECT_SHAPE);
                }
            }
        }
        u<BeautyData> uVar3 = this.f9222j;
        if ((uVar3 == null || (value = uVar3.getValue()) == null || value.getBeautyType() != 1) ? false : true) {
            us.pinguo.camera2020.i.a aVar = us.pinguo.camera2020.i.a.a;
            if (!Y()) {
                StyleMakeup value2 = this.f9224l.getValue();
                if (!(value2 != null && value2.isVipLabelVisible())) {
                    z2 = false;
                    aVar.j(z2);
                }
            }
            z2 = true;
            aVar.j(z2);
        }
        i(beautyData);
    }

    public final void k0(String str, StyleMakeup styleMakeup, Float f2) {
        if (str == null) {
            return;
        }
        l.d(n0.a(z0.b()), null, null, new CameraBeautyModule$renderStyleMakeup$1(str, this, styleMakeup, f2, null), 3, null);
    }

    public final void l(int i2) {
        u<BeautyData> uVar = this.f9222j;
        BeautyData value = uVar == null ? null : uVar.getValue();
        if (value == null) {
            return;
        }
        value.getCurrentValue().set(i2);
        if (value.getBeautyType() != 1) {
            value.getHasModify().set(value.getCurrentValue().get() != 0);
            k(this, value, false, 2, null);
            return;
        }
        MakeupType makeupType = value.getUnityEnumData().getMakeupType();
        if (makeupType == null) {
            return;
        }
        UnityMethodCaller.setMakeupValue(makeupType, i2 / 100.0f);
    }

    public final void l0(StyleMakeup styleMakeup, kotlin.jvm.b.l<? super Boolean, kotlin.u> lVar) {
        l.d(n0.a(z0.b()), null, null, new CameraBeautyModule$renderStyleMakeup$2(this, styleMakeup, lVar, null), 3, null);
    }

    public final void m(int i2) {
        BeautyData value;
        u<BeautyData> uVar = this.f9222j;
        if (uVar == null || (value = uVar.getValue()) == null) {
            return;
        }
        value.setColorIndex(i2);
        k(this, value, false, 2, null);
    }

    public final void n(int i2) {
        u0(i2 / 100.0f);
    }

    public final void n0() {
        ArrayList<BeautyData> g2 = BeautyDataManager.a.l().g();
        int size = g2.size();
        BeautyData[] beautyDataArr = new BeautyData[size];
        for (int i2 = 0; i2 < size; i2++) {
            BeautyData beautyData = g2.get(i2);
            s.g(beautyData, "beautyDataList[it]");
            BeautyData beautyData2 = beautyData;
            beautyData2.getCurrentValue().set(beautyData2.getDefaultValue());
            beautyDataArr[i2] = g2.get(i2);
        }
        i((BeautyData[]) Arrays.copyOf(beautyDataArr, size));
    }

    public final void o(int i2) {
        float f2 = i2 / 100.0f;
        us.pinguo.common.log.a.k(s.q("CameraBeautyModule.StyleMakeupValueChanged:", Float.valueOf(f2)), new Object[0]);
        UnityMethodCaller.setMakeupThemeValue(f2);
    }

    public final void o0() {
        V();
    }

    public final void p() {
        boolean C;
        for (BeautyData beautyData : this.c) {
            beautyData.getCurrentValue().set(beautyData.getDefaultValue());
            C = StringsKt__StringsKt.C(beautyData.getBeautyKey(), Material.MATERIAL_SELECT_NONE_FLAG, false, 2, null);
            if (C) {
                beautyData.isSelected().set(true);
            } else {
                beautyData.isSelected().set(false);
                beautyData.getHasModify().set(false);
            }
            BeautyDataManager.a.l().v(beautyData);
        }
        d0();
    }

    public final void q() {
        d0();
    }

    public final void r(String selfMakeupId, q<? super Boolean, ? super MaterialDetail, ? super String, kotlin.u> downloadAction) {
        s.h(selfMakeupId, "selfMakeupId");
        s.h(downloadAction, "downloadAction");
        BeautyDataManager.a.k(selfMakeupId, downloadAction);
    }

    public final void r0(kotlin.jvm.b.a<kotlin.u> aVar) {
        this.w = aVar;
    }

    public final void s(Boolean bool, int i2) {
        StyleMakeup styleMakeup;
        boolean z = false;
        us.pinguo.common.log.a.c(s.q("CameraBeautyModule.restCount:", Integer.valueOf(i2)), new Object[0]);
        BeautyDataManager beautyDataManager = BeautyDataManager.a;
        MaterialResponse<StyleMakeup> value = beautyDataManager.p().getValue();
        List<StyleMakeup> suites = value == null ? null : value.getSuites();
        if (((suites == null || suites.isEmpty()) ? true : true) || beautyDataManager.l().n().isEmpty()) {
            return;
        }
        this.f9223k.setValue(this.f9224l.getValue());
        int size = suites.size();
        if (bool == null) {
            styleMakeup = this.f9224l.getValue();
        } else if (bool.booleanValue()) {
            int i3 = this.o - 1;
            this.o = i3;
            int i4 = (i3 + size) % size;
            this.o = i4;
            styleMakeup = suites.get(i4);
        } else {
            int i5 = this.o + 1;
            this.o = i5;
            int i6 = (i5 + size) % size;
            this.o = i6;
            styleMakeup = suites.get(i6);
        }
        l0(styleMakeup, new CameraBeautyModule$flingStyleMakeup$1(bool, i2, this, styleMakeup));
    }

    public final void s0(ChangeStatus changeStatus) {
        s.h(changeStatus, "<set-?>");
        this.p = changeStatus;
    }

    public final ArrayList<BeautyData> t() {
        return this.b;
    }

    public final void t0(b exclusiveEffectManager) {
        s.h(exclusiveEffectManager, "exclusiveEffectManager");
        this.v = exclusiveEffectManager;
    }

    public final String u() {
        return O(12, 18);
    }

    public final kotlin.jvm.b.a<kotlin.u> v() {
        return this.w;
    }

    public final void v0(float f2) {
        SoftSkinParam softSkinParam = SoftSkinParam.SOFT_SKIN;
        softSkinParam.setValue(f2);
        UnityMethodCaller.setSoftSkin(softSkinParam);
    }

    public final ChangeStatus w() {
        return this.p;
    }

    public final void w0(boolean z) {
        this.f9221i = z;
    }

    public final String x() {
        return O(37, 43);
    }

    public final String y() {
        return O(31, 37);
    }

    public final ExclusiveEffectType z() {
        return this.r;
    }
}
