package us.pinguo.edit2020.viewmodel.module;

import android.graphics.PointF;
import androidx.databinding.ObservableBoolean;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.c0;
import kotlin.jvm.b.q;
import kotlin.jvm.b.r;
import kotlin.jvm.internal.s;
import kotlinx.coroutines.l;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.z0;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.bean.i0;
import us.pinguo.edit2020.bean.j0;
import us.pinguo.edit2020.bean.s0;
import us.pinguo.edit2020.bean.x;
import us.pinguo.edit2020.model.EditRender;
import us.pinguo.repository2020.database.makeup.MaterialDetailTable;
import us.pinguo.repository2020.database.makeup.MaterialItemTable;
import us.pinguo.repository2020.entity.MaterialColor;
import us.pinguo.repository2020.entity.MaterialDetail;
import us.pinguo.repository2020.entity.MaterialResponse;
import us.pinguo.repository2020.entity.SelfDefMakeup;
import us.pinguo.repository2020.entity.SelfDefMakeupMaterial;
import us.pinguo.repository2020.entity.SelfDefMakeupResponse;
import us.pinguo.repository2020.entity.StyleMakeup;
import us.pinguo.repository2020.entity.Topic;
import us.pinguo.repository2020.manager.BeautyDataManager;
import us.pinguo.repository2020.u;
import us.pinguo.repository2020.utils.BeautyDataUtils;
import us.pinguo.repository2020.utils.n;
import us.pinguo.u3dengine.api.MakeupMaterial;
import us.pinguo.u3dengine.edit.UnityEditCaller;
/* compiled from: EditMakeupModule.kt */
/* loaded from: classes4.dex */
public final class EditMakeupModule {
    private final EditRender a;
    private StyleMakeup b;
    private u<StyleMakeup> c;

    /* renamed from: d  reason: collision with root package name */
    private u<StyleMakeup> f10863d;

    /* renamed from: e  reason: collision with root package name */
    private ObservableBoolean f10864e;

    /* renamed from: f  reason: collision with root package name */
    private int f10865f;

    /* renamed from: g  reason: collision with root package name */
    private SelfDefMakeup f10866g;

    /* renamed from: h  reason: collision with root package name */
    private SelfDefMakeup[][] f10867h;

    /* renamed from: i  reason: collision with root package name */
    private MaterialColor[][] f10868i;

    /* renamed from: j  reason: collision with root package name */
    private SelfDefMakeup[][] f10869j;

    /* renamed from: k  reason: collision with root package name */
    private MaterialColor[][] f10870k;

    /* renamed from: l  reason: collision with root package name */
    private Boolean[] f10871l;
    private int m;
    private int n;
    private int o;
    private Long[] p;
    private r<? super PointF, ? super Float, ? super PointF, ? super Integer, kotlin.u> q;
    private StyleMakeup[] r;

    public EditMakeupModule(EditRender unityRender) {
        s.h(unityRender, "unityRender");
        this.a = unityRender;
        this.c = new u<>(null);
        this.f10863d = new u<>(null);
        this.f10864e = new ObservableBoolean(true);
        this.m = -1;
        this.n = -1;
        this.o = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String M(SelfDefMakeup selfDefMakeup) {
        String pid;
        if (((selfDefMakeup == null || (pid = selfDefMakeup.getPid()) == null) ? null : us.pinguo.repository2020.database.a.a().z().b(pid)) == null) {
            return null;
        }
        return n.a.g(selfDefMakeup.getPid());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String N(StyleMakeup styleMakeup) {
        String pid;
        MaterialDetailTable b = (styleMakeup == null || (pid = styleMakeup.getPid()) == null) ? null : us.pinguo.repository2020.database.a.a().z().b(pid);
        if (b == null) {
            return null;
        }
        List<MaterialItemTable> a = us.pinguo.repository2020.database.a.a().A().a(b.getId());
        if (a == null || a.isEmpty()) {
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
        sb.append((Object) a.get(0).getId());
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z(int i2, String str, SelfDefMakeup selfDefMakeup) {
        if (str == null || selfDefMakeup == null) {
            return;
        }
        l.d(n0.a(z0.b()), null, null, new EditMakeupModule$renderEditSelfDefMakeup$1(str, selfDefMakeup, this, i2, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b0(String str, StyleMakeup styleMakeup) {
        if (str == null) {
            return;
        }
        l.d(n0.a(z0.b()), null, null, new EditMakeupModule$renderEditStyleMakeup$1(str, styleMakeup, this, null), 3, null);
    }

    private final void e0(int i2) {
        if (i2 != -1) {
            StyleMakeup[] styleMakeupArr = this.r;
            if (styleMakeupArr == null) {
                return;
            }
            styleMakeupArr[i2] = null;
            return;
        }
        StyleMakeup[] styleMakeupArr2 = this.r;
        if (styleMakeupArr2 == null) {
            return;
        }
        int length = styleMakeupArr2.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            StyleMakeup styleMakeup = styleMakeupArr2[i3];
            int i5 = i4 + 1;
            StyleMakeup[] Q = Q();
            if (Q != null) {
                Q[i4] = null;
            }
            i3++;
            i4 = i5;
        }
    }

    private final void i(PointF pointF, float f2, PointF pointF2, int i2) {
        this.a.l(pointF, f2, pointF2, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t0(int i2, List<MakeupMaterial> list, StyleMakeup styleMakeup, String str) {
        Integer num;
        Integer num2;
        Integer num3;
        EditRender editRender = this.a;
        Integer makeupDefaultValue = styleMakeup.getMakeupDefaultValue();
        int i3 = 80;
        float intValue = (makeupDefaultValue == null ? 80 : makeupDefaultValue.intValue()) / 100.0f;
        Integer skinWhiteDefaultValue = styleMakeup.getSkinWhiteDefaultValue();
        int i4 = 0;
        float intValue2 = (skinWhiteDefaultValue == null ? 0 : skinWhiteDefaultValue.intValue()) / 100.0f;
        Integer[] editMakeupCurrentValues = styleMakeup.getEditMakeupCurrentValues();
        editRender.H0(i2, intValue, intValue2, 0.8f, ((editMakeupCurrentValues == null || (num = editMakeupCurrentValues[C()]) == null) ? 80 : num.intValue()) / 100.0f);
        if ((i2 == S(this.p) && !R(this.p)) || this.m == -1) {
            Integer isRenderFilter = styleMakeup.isRenderFilter();
            if (isRenderFilter == null || isRenderFilter.intValue() != 0) {
                EditRender editRender2 = this.a;
                String b = BeautyDataUtils.a.b(str);
                Integer filterDefaultValue = styleMakeup.getFilterDefaultValue();
                int i5 = 50;
                float intValue3 = (filterDefaultValue == null ? 50 : filterDefaultValue.intValue()) / 100.0f;
                Integer[] editFilterCurrentValues = styleMakeup.getEditFilterCurrentValues();
                if (editFilterCurrentValues != null && (num3 = editFilterCurrentValues[C()]) != null) {
                    i5 = num3.intValue();
                }
                float f2 = i5 / 100.0f;
                Integer filterLayer = styleMakeup.getFilterLayer();
                editRender2.t0(b, intValue3, f2, filterLayer == null ? 0 : filterLayer.intValue(), false);
            } else {
                this.a.t0("", 0.0f, 0.0f, 0, false);
            }
            us.pinguo.common.log.a.k("设置滤镜成功啦", new Object[0]);
        }
        StyleMakeup[] styleMakeupArr = this.r;
        boolean z = true;
        if (styleMakeupArr != null) {
            if (!(styleMakeupArr.length == 0)) {
                z = false;
            }
        }
        if (!z) {
            if (i2 == -1) {
                if (styleMakeupArr != null) {
                    int length = styleMakeupArr.length;
                    int i6 = 0;
                    while (i4 < length) {
                        StyleMakeup styleMakeup2 = styleMakeupArr[i4];
                        int i7 = i6 + 1;
                        StyleMakeup[] Q = Q();
                        if (Q != null) {
                            Q[i6] = styleMakeup;
                        }
                        i4++;
                        i6 = i7;
                    }
                }
            } else if (styleMakeupArr != null) {
                styleMakeupArr[C()] = styleMakeup;
            }
        }
        EditRender editRender3 = this.a;
        Integer[] editMakeupCurrentValues2 = styleMakeup.getEditMakeupCurrentValues();
        if (editMakeupCurrentValues2 != null && (num2 = editMakeupCurrentValues2[C()]) != null) {
            i3 = num2.intValue();
        }
        editRender3.U(i2, list, i3 / 100.0f);
        Integer[] editFilterCurrentValues2 = styleMakeup.getEditFilterCurrentValues();
        u0(editFilterCurrentValues2 == null ? null : editFilterCurrentValues2[C()]);
    }

    private final void u0(Integer num) {
        if (num != null) {
            l(num.intValue(), false);
        }
    }

    public final int A() {
        List<StyleMakeup> suites;
        int F;
        MaterialResponse<StyleMakeup> value = BeautyDataManager.a.p().getValue();
        if (value == null || (suites = value.getSuites()) == null) {
            return -1;
        }
        F = c0.F(suites, this.c.getValue());
        return F;
    }

    public final int B() {
        return this.o;
    }

    public final int C() {
        int i2 = this.m;
        if (i2 == -1) {
            return 0;
        }
        return i2;
    }

    public final Long[] D() {
        return this.p;
    }

    public final int E() {
        return this.n;
    }

    public final int F() {
        int i2 = this.n;
        if (i2 == -1) {
            return 0;
        }
        return i2;
    }

    public final MaterialColor[][] G() {
        return this.f10870k;
    }

    public final SelfDefMakeup[][] H() {
        return this.f10869j;
    }

    public final u<StyleMakeup> I() {
        return this.f10863d;
    }

    public final String[] J() {
        ArrayList<Topic> topics;
        ArrayList<Topic> topics2;
        Topic topic;
        String name;
        SelfDefMakeupResponse o = BeautyDataManager.a.o();
        int size = ((o == null || (topics = o.getTopics()) == null) ? 0 : topics.size()) + 1;
        String[] strArr = new String[size];
        for (int i2 = 0; i2 < size; i2++) {
            String str = "";
            if (i2 == 0) {
                str = us.pinguo.foundation.e.b().getResources().getString(R.string.beauty_style_makeup);
            } else {
                SelfDefMakeupResponse o2 = BeautyDataManager.a.o();
                if (o2 != null && (topics2 = o2.getTopics()) != null && (topic = topics2.get(i2 - 1)) != null && (name = topic.getName()) != null) {
                    str = name;
                }
            }
            s.g(str, "if (index == 0) Foundati…et(index - 1)?.name ?: \"\"");
            strArr[i2] = str;
        }
        return strArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0079, code lost:
        if (r2 == true) goto L17;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<us.pinguo.repository2020.entity.MaterialColor> K(int r9) {
        /*
            r8 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            us.pinguo.repository2020.manager.BeautyDataManager r1 = us.pinguo.repository2020.manager.BeautyDataManager.a
            us.pinguo.repository2020.entity.SelfDefMakeupResponse r1 = r1.o()
            if (r1 != 0) goto Lf
            goto Lb5
        Lf:
            java.util.ArrayList r1 = r1.getTopics()
            if (r1 != 0) goto L17
            goto Lb5
        L17:
            java.lang.Object r9 = r1.get(r9)
            us.pinguo.repository2020.entity.Topic r9 = (us.pinguo.repository2020.entity.Topic) r9
            if (r9 != 0) goto L21
            goto Lb5
        L21:
            java.util.List r9 = r9.getCids()
            if (r9 != 0) goto L29
            goto Lb5
        L29:
            java.util.Iterator r9 = r9.iterator()
            r1 = 0
            r2 = 0
        L2f:
            boolean r3 = r9.hasNext()
            if (r3 == 0) goto Lb5
            java.lang.Object r3 = r9.next()
            int r4 = r2 + 1
            r5 = 0
            if (r2 < 0) goto Lb1
            java.lang.String r3 = (java.lang.String) r3
            us.pinguo.repository2020.manager.BeautyDataManager r2 = us.pinguo.repository2020.manager.BeautyDataManager.a
            us.pinguo.repository2020.entity.SelfDefMakeupResponse r2 = r2.o()
            r6 = 1
            if (r2 != 0) goto L4b
        L49:
            r6 = 0
            goto L7b
        L4b:
            java.util.ArrayList r2 = r2.getColors()
            if (r2 != 0) goto L52
            goto L49
        L52:
            boolean r7 = r2 instanceof java.util.Collection
            if (r7 == 0) goto L5e
            boolean r7 = r2.isEmpty()
            if (r7 == 0) goto L5e
        L5c:
            r2 = 0
            goto L79
        L5e:
            java.util.Iterator r2 = r2.iterator()
        L62:
            boolean r7 = r2.hasNext()
            if (r7 == 0) goto L5c
            java.lang.Object r7 = r2.next()
            us.pinguo.repository2020.entity.MaterialColor r7 = (us.pinguo.repository2020.entity.MaterialColor) r7
            java.lang.String r7 = r7.getCid()
            boolean r7 = kotlin.jvm.internal.s.c(r7, r3)
            if (r7 == 0) goto L62
            r2 = 1
        L79:
            if (r2 != r6) goto L49
        L7b:
            if (r6 == 0) goto Lae
            us.pinguo.repository2020.manager.BeautyDataManager r2 = us.pinguo.repository2020.manager.BeautyDataManager.a
            us.pinguo.repository2020.entity.SelfDefMakeupResponse r2 = r2.o()
            if (r2 != 0) goto L86
            goto Lab
        L86:
            java.util.ArrayList r2 = r2.getColors()
            if (r2 != 0) goto L8d
            goto Lab
        L8d:
            java.util.Iterator r2 = r2.iterator()
        L91:
            boolean r6 = r2.hasNext()
            if (r6 == 0) goto La9
            java.lang.Object r6 = r2.next()
            r7 = r6
            us.pinguo.repository2020.entity.MaterialColor r7 = (us.pinguo.repository2020.entity.MaterialColor) r7
            java.lang.String r7 = r7.getCid()
            boolean r7 = kotlin.jvm.internal.s.c(r7, r3)
            if (r7 == 0) goto L91
            r5 = r6
        La9:
            us.pinguo.repository2020.entity.MaterialColor r5 = (us.pinguo.repository2020.entity.MaterialColor) r5
        Lab:
            r0.add(r5)
        Lae:
            r2 = r4
            goto L2f
        Lb1:
            kotlin.collections.s.n()
            throw r5
        Lb5:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.viewmodel.module.EditMakeupModule.K(int):java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0079, code lost:
        if (r6 == true) goto L17;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<us.pinguo.repository2020.entity.SelfDefMakeup> L(int r10) {
        /*
            Method dump skipped, instructions count: 260
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.viewmodel.module.EditMakeupModule.L(int):java.util.List");
    }

    public final List<Topic> O() {
        SelfDefMakeupResponse o = BeautyDataManager.a.o();
        if (o == null) {
            return null;
        }
        return o.getTopics();
    }

    public final ArrayList<x> P() {
        SelfDefMakeup[] selfDefMakeupArr;
        SelfDefMakeup selfDefMakeup;
        Topic topic;
        String tag;
        SelfDefMakeup[] selfDefMakeupArr2;
        Topic topic2;
        String tag2;
        ArrayList<x> arrayList = this.o > 0 ? new ArrayList<>() : null;
        StyleMakeup[] styleMakeupArr = this.r;
        if (styleMakeupArr != null) {
            for (StyleMakeup styleMakeup : styleMakeupArr) {
                if (styleMakeup != null && arrayList != null) {
                    arrayList.add(new s0(styleMakeup));
                }
            }
        }
        SelfDefMakeup[][] selfDefMakeupArr3 = this.f10867h;
        if (selfDefMakeupArr3 != null) {
            int length = selfDefMakeupArr3.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                int i4 = i3 + 1;
                for (SelfDefMakeup selfDefMakeup2 : selfDefMakeupArr3[i2]) {
                    if (selfDefMakeup2 != null && arrayList != null) {
                        List<Topic> O = O();
                        if (O == null || (topic2 = O.get(i3)) == null || (tag2 = topic2.getTag()) == null) {
                            tag2 = "";
                        }
                        arrayList.add(new j0(selfDefMakeup2, tag2));
                    }
                }
                i2++;
                i3 = i4;
            }
        }
        MaterialColor[][] materialColorArr = this.f10868i;
        if (materialColorArr != null) {
            int length2 = materialColorArr.length;
            int i5 = 0;
            int i6 = 0;
            while (i5 < length2) {
                MaterialColor[] materialColorArr2 = materialColorArr[i5];
                int i7 = i6 + 1;
                int length3 = materialColorArr2.length;
                int i8 = 0;
                int i9 = 0;
                while (i8 < length3) {
                    MaterialColor materialColor = materialColorArr2[i8];
                    int i10 = i9 + 1;
                    if (materialColor != null) {
                        SelfDefMakeup[][] x = x();
                        materialColor.setVip((x == null || (selfDefMakeupArr = x[i6]) == null || (selfDefMakeup = selfDefMakeupArr[i9]) == null) ? null : selfDefMakeup.getVip());
                        if (arrayList != null) {
                            List<Topic> O2 = O();
                            if (O2 == null || (topic = O2.get(i6)) == null || (tag = topic.getTag()) == null) {
                                tag = "";
                            }
                            arrayList.add(new i0(materialColor, tag));
                        }
                    }
                    i8++;
                    i9 = i10;
                }
                i5++;
                i6 = i7;
            }
        }
        return arrayList == null ? new ArrayList<>() : arrayList;
    }

    public final StyleMakeup[] Q() {
        return this.r;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0014 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean R(java.lang.Long[] r17) {
        /*
            r16 = this;
            r0 = r17
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L11
            int r3 = r0.length
            if (r3 != 0) goto Lb
            r3 = 1
            goto Lc
        Lb:
            r3 = 0
        Lc:
            if (r3 == 0) goto Lf
            goto L11
        Lf:
            r3 = 0
            goto L12
        L11:
            r3 = 1
        L12:
            if (r3 == 0) goto L15
            return r2
        L15:
            int r3 = r0.length
            r4 = 0
            r5 = 0
        L18:
            if (r4 >= r3) goto L3e
            r6 = r0[r4]
            int r7 = r5 + 1
            long r8 = r6.longValue()
            int r6 = r0.length
            r10 = 0
            r11 = 0
        L25:
            if (r10 >= r6) goto L3a
            r12 = r0[r10]
            int r13 = r11 + 1
            long r14 = r12.longValue()
            if (r5 == r11) goto L36
            int r11 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r11 != 0) goto L36
            return r1
        L36:
            int r10 = r10 + 1
            r11 = r13
            goto L25
        L3a:
            int r4 = r4 + 1
            r5 = r7
            goto L18
        L3e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.viewmodel.module.EditMakeupModule.R(java.lang.Long[]):boolean");
    }

    public final int S(Long[] lArr) {
        int v;
        boolean z = true;
        if (lArr != null) {
            if (!(lArr.length == 0)) {
                z = false;
            }
        }
        if (z) {
            return -1;
        }
        long longValue = lArr[0].longValue();
        for (Long l2 : lArr) {
            long longValue2 = l2.longValue();
            if (longValue > longValue2) {
                longValue = longValue2;
            }
        }
        v = kotlin.collections.n.v(lArr, Long.valueOf(longValue));
        return v;
    }

    public final Boolean[] T() {
        return this.f10871l;
    }

    public final boolean U(int i2) {
        List<MaterialColor> K = K(i2);
        return !(K == null || K.isEmpty());
    }

    public final boolean V(SelfDefMakeup selfDefMakeup) {
        String M = M(selfDefMakeup);
        if (M == null) {
            return false;
        }
        return (selfDefMakeup != null && selfDefMakeup.isInstalled()) && new File(M).exists();
    }

    public final ObservableBoolean W() {
        return this.f10864e;
    }

    public final boolean X(StyleMakeup styleMakeup) {
        String N = N(styleMakeup);
        if (N == null) {
            return false;
        }
        return (styleMakeup != null && styleMakeup.isInstalled()) && new File(N).exists();
    }

    public final void Y() {
        i(new PointF(0.5f, 0.5f), 1.0f, new PointF(0.0f, 0.0f), 200);
    }

    public final void a0(int i2, SelfDefMakeup selfDefMakeup, kotlin.jvm.b.l<? super Boolean, kotlin.u> lVar) {
        l.d(n0.a(z0.b()), null, null, new EditMakeupModule$renderEditSelfDefMakeup$2(this, selfDefMakeup, i2, lVar, null), 3, null);
    }

    public final void c0(StyleMakeup styleMakeup, kotlin.jvm.b.l<? super Boolean, kotlin.u> lVar) {
        l.d(n0.a(z0.b()), null, null, new EditMakeupModule$renderEditStyleMakeup$2(this, styleMakeup, lVar, null), 3, null);
    }

    public final void d0() {
        Integer[] editMakeupCurrentValues;
        Integer[] editMakeupCurrentValues2;
        List<StyleMakeup> suites;
        MaterialResponse<StyleMakeup> value = BeautyDataManager.a.p().getValue();
        if (value != null && (suites = value.getSuites()) != null) {
            for (StyleMakeup styleMakeup : suites) {
                Integer[] editMakeupCurrentValues3 = styleMakeup.getEditMakeupCurrentValues();
                if (editMakeupCurrentValues3 != null) {
                    int length = editMakeupCurrentValues3.length;
                    int i2 = 0;
                    int i3 = 0;
                    while (i2 < length) {
                        int i4 = i3 + 1;
                        editMakeupCurrentValues3[i2].intValue();
                        Integer[] editMakeupCurrentValues4 = styleMakeup.getEditMakeupCurrentValues();
                        if (editMakeupCurrentValues4 != null) {
                            editMakeupCurrentValues4[i3] = 80;
                        }
                        i2++;
                        i3 = i4;
                    }
                }
                Integer[] editFilterCurrentValues = styleMakeup.getEditFilterCurrentValues();
                if (editFilterCurrentValues != null) {
                    int length2 = editFilterCurrentValues.length;
                    int i5 = 0;
                    int i6 = 0;
                    while (i5 < length2) {
                        int i7 = i6 + 1;
                        editFilterCurrentValues[i5].intValue();
                        Integer[] editFilterCurrentValues2 = styleMakeup.getEditFilterCurrentValues();
                        if (editFilterCurrentValues2 != null) {
                            editFilterCurrentValues2[i6] = 50;
                        }
                        i5++;
                        i6 = i7;
                    }
                }
                Integer[] editMakeupLastValues = styleMakeup.getEditMakeupLastValues();
                if (editMakeupLastValues != null) {
                    int length3 = editMakeupLastValues.length;
                    int i8 = 0;
                    int i9 = 0;
                    while (i8 < length3) {
                        int i10 = i9 + 1;
                        editMakeupLastValues[i8].intValue();
                        Integer[] editMakeupLastValues2 = styleMakeup.getEditMakeupLastValues();
                        if (editMakeupLastValues2 != null) {
                            editMakeupLastValues2[i9] = 80;
                        }
                        i8++;
                        i9 = i10;
                    }
                }
                Integer[] editFilterLastValues = styleMakeup.getEditFilterLastValues();
                if (editFilterLastValues != null) {
                    int length4 = editFilterLastValues.length;
                    int i11 = 0;
                    int i12 = 0;
                    while (i11 < length4) {
                        int i13 = i12 + 1;
                        editFilterLastValues[i11].intValue();
                        Integer[] editFilterLastValues2 = styleMakeup.getEditFilterLastValues();
                        if (editFilterLastValues2 != null) {
                            editFilterLastValues2[i12] = 50;
                        }
                        i11++;
                        i12 = i13;
                    }
                }
            }
        }
        SelfDefMakeup[][] selfDefMakeupArr = this.f10867h;
        if (selfDefMakeupArr != null) {
            for (SelfDefMakeup[] selfDefMakeupArr2 : selfDefMakeupArr) {
                int length5 = selfDefMakeupArr2.length;
                int i14 = 0;
                int i15 = 0;
                while (i14 < length5) {
                    SelfDefMakeup selfDefMakeup = selfDefMakeupArr2[i14];
                    int i16 = i15 + 1;
                    SelfDefMakeup selfDefMakeup2 = selfDefMakeupArr2[i15];
                    if (selfDefMakeup2 != null && (editMakeupCurrentValues2 = selfDefMakeup2.getEditMakeupCurrentValues()) != null) {
                        editMakeupCurrentValues2[i15] = 80;
                    }
                    selfDefMakeupArr2[i15] = null;
                    i14++;
                    i15 = i16;
                }
            }
        }
        SelfDefMakeup[][] selfDefMakeupArr3 = this.f10869j;
        if (selfDefMakeupArr3 != null) {
            for (SelfDefMakeup[] selfDefMakeupArr4 : selfDefMakeupArr3) {
                int length6 = selfDefMakeupArr4.length;
                int i17 = 0;
                int i18 = 0;
                while (i17 < length6) {
                    SelfDefMakeup selfDefMakeup3 = selfDefMakeupArr4[i17];
                    int i19 = i18 + 1;
                    SelfDefMakeup selfDefMakeup4 = selfDefMakeupArr4[i18];
                    if (selfDefMakeup4 != null && (editMakeupCurrentValues = selfDefMakeup4.getEditMakeupCurrentValues()) != null) {
                        editMakeupCurrentValues[i18] = 80;
                    }
                    selfDefMakeupArr4[i18] = null;
                    i17++;
                    i18 = i19;
                }
            }
        }
        MaterialColor[][] materialColorArr = this.f10868i;
        if (materialColorArr != null) {
            for (MaterialColor[] materialColorArr2 : materialColorArr) {
                int length7 = materialColorArr2.length;
                int i20 = 0;
                int i21 = 0;
                while (i20 < length7) {
                    MaterialColor materialColor = materialColorArr2[i20];
                    materialColorArr2[i21] = null;
                    i20++;
                    i21++;
                }
            }
        }
        MaterialColor[][] materialColorArr3 = this.f10870k;
        if (materialColorArr3 != null) {
            for (MaterialColor[] materialColorArr4 : materialColorArr3) {
                int length8 = materialColorArr4.length;
                int i22 = 0;
                int i23 = 0;
                while (i22 < length8) {
                    MaterialColor materialColor2 = materialColorArr4[i22];
                    materialColorArr4[i23] = null;
                    i22++;
                    i23++;
                }
            }
        }
        this.f10865f = 0;
        this.m = -1;
        e0(-1);
        this.n = -1;
        this.c.setValue(null);
        this.f10863d.setValue(null);
    }

    public final void f0(r<? super PointF, ? super Float, ? super PointF, ? super Integer, kotlin.u> rVar) {
        this.q = rVar;
    }

    public final void g(int i2, int i3) {
        this.a.j(i2, i3);
    }

    public final void g0(SelfDefMakeup selfDefMakeup) {
        this.f10866g = selfDefMakeup;
    }

    public final void h(int i2) {
        if (i2 == -1 || this.o == 1 || (this.m == S(this.p) && !R(this.p))) {
            this.a.t0("", 0.0f, 0.0f, 0, false);
        }
        this.a.k(i2);
        e0(i2);
    }

    public final void h0(StyleMakeup styleMakeup) {
        this.b = styleMakeup;
    }

    public final void i0(int i2) {
        this.m = i2;
    }

    public final void j(int i2, String colorHex, SelfDefMakeup selfDefMakeup) {
        s.h(colorHex, "colorHex");
        if (i2 >= 0) {
            if ((colorHex.length() == 0) || selfDefMakeup == null) {
                return;
            }
            us.pinguo.common.log.a.k(s.q("EditMakeupModule.changeSelfMakeupColor:", colorHex), new Object[0]);
            this.a.f1(i2, colorHex, selfDefMakeup.getType());
        }
    }

    public final void j0(MaterialColor[][] materialColorArr) {
        this.f10868i = materialColorArr;
    }

    public final void k(int i2, boolean z) {
        Integer num;
        SelfDefMakeup[] selfDefMakeupArr;
        us.pinguo.common.log.a.k(s.q("EditMakeupModule.changeSelfMakeupValue:", Integer.valueOf(i2)), new Object[0]);
        SelfDefMakeup[][] selfDefMakeupArr2 = this.f10867h;
        SelfDefMakeup selfDefMakeup = null;
        if (selfDefMakeupArr2 != null && (selfDefMakeupArr = selfDefMakeupArr2[o()]) != null) {
            selfDefMakeup = selfDefMakeupArr[C()];
        }
        if (selfDefMakeup == null) {
            return;
        }
        EditRender editRender = this.a;
        int C = C();
        int type = selfDefMakeup.getType();
        Integer[] editMakeupLastValues = selfDefMakeup.getEditMakeupLastValues();
        int i3 = 80;
        if (editMakeupLastValues != null && (num = editMakeupLastValues[C()]) != null) {
            i3 = num.intValue();
        }
        editRender.g1(C, type, i3, i2, z);
    }

    public final void k0(SelfDefMakeup[][] selfDefMakeupArr) {
        this.f10867h = selfDefMakeupArr;
    }

    public final void l(int i2, boolean z) {
        Integer[] editFilterLastValues;
        Integer num;
        EditRender editRender = this.a;
        StyleMakeup value = this.c.getValue();
        int i3 = 50;
        if (value != null && (editFilterLastValues = value.getEditFilterLastValues()) != null && (num = editFilterLastValues[C()]) != null) {
            i3 = num.intValue();
        }
        editRender.l1(i3 / 100.0f, i2 / 100.0f, z);
    }

    public final void l0(int i2) {
        this.f10865f = i2;
    }

    public final void m(int i2, boolean z) {
        Integer[] editMakeupLastValues;
        Integer num;
        us.pinguo.common.log.a.k(s.q("EditMakeupModule.changeStyleMakeupValue:", Integer.valueOf(i2)), new Object[0]);
        float f2 = i2 / 100.0f;
        EditRender editRender = this.a;
        int i3 = this.m;
        StyleMakeup value = this.c.getValue();
        int i4 = 80;
        if (value != null && (editMakeupLastValues = value.getEditMakeupLastValues()) != null && (num = editMakeupLastValues[C()]) != null) {
            i4 = num.intValue();
        }
        editRender.m1(i3, i4 / 100.0f, f2, z);
    }

    public final void m0(int i2) {
        this.o = i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void n(HashMap<Integer, PointF[]> hashMap, HashMap<Integer, PointF[]> hashMap2) {
        if (hashMap == null || hashMap2 == 0) {
            return;
        }
        Set<Map.Entry<Integer, PointF[]>> entrySet = hashMap.entrySet();
        s.g(entrySet, "srcFacePoints.entries");
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            int length = ((Object[]) entry.getValue()).length;
            PointF[] pointFArr = new PointF[length];
            for (int i2 = 0; i2 < length; i2++) {
                pointFArr[i2] = new PointF(((PointF[]) entry.getValue())[i2].x, ((PointF[]) entry.getValue())[i2].y);
            }
            Object key = entry.getKey();
            s.g(key, "entry.key");
            hashMap2.put(key, pointFArr);
        }
    }

    public final void n0(Long[] lArr) {
        this.p = lArr;
    }

    public final int o() {
        int i2 = this.f10865f;
        if (i2 > 0) {
            return i2 - 1;
        }
        return 0;
    }

    public final void o0(int i2) {
        this.n = i2;
    }

    public final void p(SelfDefMakeupMaterial selfDefMakeupMaterial, q<? super Boolean, ? super SelfDefMakeupMaterial, ? super String, kotlin.u> downloadAction) {
        s.h(selfDefMakeupMaterial, "selfDefMakeupMaterial");
        s.h(downloadAction, "downloadAction");
        BeautyDataManager.a.j(selfDefMakeupMaterial, downloadAction);
    }

    public final void p0(MaterialColor[][] materialColorArr) {
        this.f10870k = materialColorArr;
    }

    public final void q(String styleMakeupId, q<? super Boolean, ? super MaterialDetail, ? super String, kotlin.u> downloadAction) {
        s.h(styleMakeupId, "styleMakeupId");
        s.h(downloadAction, "downloadAction");
        BeautyDataManager.a.k(styleMakeupId, downloadAction);
    }

    public final void q0(SelfDefMakeup[][] selfDefMakeupArr) {
        this.f10869j = selfDefMakeupArr;
    }

    public final void r(boolean z) {
        UnityEditCaller.Common.INSTANCE.enableCanvasSinglePointMove(z);
    }

    public final void r0(float f2, float f3) {
        UnityEditCaller.Common common = UnityEditCaller.Common.INSTANCE;
        common.setMagnifierRenderUpdateMode(1);
        common.setMagnifierPosition(f2, f3);
        common.setMagnifierRenderUpdateMode(0);
    }

    public final r<PointF, Float, PointF, Integer, kotlin.u> s() {
        return this.q;
    }

    public final void s0(Boolean[] boolArr) {
        this.f10871l = boolArr;
    }

    public final SelfDefMakeup t() {
        return this.f10866g;
    }

    public final StyleMakeup u() {
        return this.b;
    }

    public final int v() {
        return this.m;
    }

    public final void v0(StyleMakeup[] styleMakeupArr) {
        this.r = styleMakeupArr;
    }

    public final MaterialColor[][] w() {
        return this.f10868i;
    }

    public final void w0(int i2, int i3, PointF pointF) {
        s.h(pointF, "pointF");
        UnityEditCaller.Makeup.updateMakeupFaceMeshVertices(i2, i3, pointF);
    }

    public final SelfDefMakeup[][] x() {
        return this.f10867h;
    }

    public final u<StyleMakeup> y() {
        return this.c;
    }

    public final int z() {
        return this.f10865f;
    }
}
