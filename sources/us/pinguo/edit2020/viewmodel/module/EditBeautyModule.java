package us.pinguo.edit2020.viewmodel.module;

import android.content.Context;
import android.util.Log;
import android.view.View;
import com.pinguo.camera360.effect.model.entity.Effect;
import com.pinguo.camera360.effect.model.entity.type.Frame;
import com.tapjoy.TJAdUnitConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.h0;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.s;
import kotlin.text.StringsKt__StringsKt;
import us.pinguo.edit2020.bean.b0;
import us.pinguo.edit2020.bean.d0;
import us.pinguo.edit2020.bean.i;
import us.pinguo.edit2020.bean.k;
import us.pinguo.edit2020.bean.m0;
import us.pinguo.edit2020.bean.n0;
import us.pinguo.edit2020.bean.q;
import us.pinguo.edit2020.bean.r;
import us.pinguo.edit2020.bean.u0;
import us.pinguo.edit2020.bean.x;
import us.pinguo.edit2020.model.EditRender;
import us.pinguo.edit2020.viewmodel.FunctionType;
import us.pinguo.inspire.module.feeds.model.PortalFollowFeeds;
import us.pinguo.repository2020.R;
import us.pinguo.repository2020.entity.BeautyEditData;
import us.pinguo.repository2020.entity.BeautyUnityEnumData;
import us.pinguo.repository2020.manager.BeautyDataManager;
import us.pinguo.repository2020.u;
import us.pinguo.u3dengine.api.DeformationParam;
import us.pinguo.u3dengine.api.Facial3dType;
import us.pinguo.u3dengine.api.SoftSkinParam;
import us.pinguo.u3dengine.edit.BasicBrushMode;
import us.pinguo.u3dengine.edit.EditModel;
import us.pinguo.u3dengine.edit.UnityEditCaller;
import us.pinguo.util.h;
/* compiled from: EditBeautyModule.kt */
/* loaded from: classes4.dex */
public final class EditBeautyModule {
    private final List<Float> A;
    private int B;
    private final EditRender a;
    private final EditAutoBeautifyModule b;
    private final EditBodyShapeModule c;

    /* renamed from: d  reason: collision with root package name */
    private final EditMakeupModule f10851d;

    /* renamed from: e  reason: collision with root package name */
    private final EditLongLegModule f10852e;

    /* renamed from: f  reason: collision with root package name */
    private HashMap<String, ArrayList<r>> f10853f;

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<n0> f10854g;

    /* renamed from: h  reason: collision with root package name */
    private ArrayList<n0> f10855h;

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<q> f10856i;

    /* renamed from: j  reason: collision with root package name */
    private Map<String, List<i>> f10857j;

    /* renamed from: k  reason: collision with root package name */
    private u<BeautyEditData> f10858k;

    /* renamed from: l  reason: collision with root package name */
    private u<FunctionType> f10859l;
    private u<Integer> m;
    private boolean n;
    private final HashMap<Integer, HashMap<String, Integer>> o;
    private ArrayList<m0> p;
    private m0 q;
    private i r;
    private final float s;
    private final String t;
    private final ArrayList<String> u;
    private final String v;
    private final String w;
    private final String x;
    private final String y;
    private n0 z;

    /* compiled from: EditBeautyModule.kt */
    /* loaded from: classes4.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[FunctionType.values().length];
            iArr[FunctionType.AutoBeauty.ordinal()] = 1;
            iArr[FunctionType.SkinRefresh.ordinal()] = 2;
            iArr[FunctionType.FacialFeatures.ordinal()] = 3;
            iArr[FunctionType.BodyShaping.ordinal()] = 4;
            iArr[FunctionType.MakeupMenu.ordinal()] = 5;
            iArr[FunctionType.FACIAL_3D.ordinal()] = 6;
            iArr[FunctionType.NEW_SKIN_REFRESH.ordinal()] = 7;
            iArr[FunctionType.LongLeg.ordinal()] = 8;
            a = iArr;
        }
    }

    public EditBeautyModule(EditRender render) {
        ArrayList<String> f2;
        List<Float> j2;
        s.h(render, "render");
        this.a = render;
        this.b = new EditAutoBeautifyModule(render);
        this.c = new EditBodyShapeModule(render);
        this.f10851d = new EditMakeupModule(render);
        this.f10852e = new EditLongLegModule(render);
        this.f10858k = new u<>();
        this.f10859l = new u<>(null);
        this.m = new u<>(0);
        this.o = new HashMap<>();
        this.s = 1.7f;
        this.t = "jiashen";
        f2 = kotlin.collections.u.f("meimao", "bizi", "zuiba", "etou", "xiahe", "lianjia");
        this.u = f2;
        this.v = "modify";
        this.w = Frame.PARAM_KEY_OPACITY;
        this.x = "type";
        this.y = "0";
        j2 = kotlin.collections.u.j(Float.valueOf(0.09f), Float.valueOf(0.12f), Float.valueOf(0.16f), Float.valueOf(0.21f), Float.valueOf(0.25f));
        this.A = j2;
        this.B = 2;
    }

    private final String D0(q qVar) {
        Facial3dType facial3d = qVar.i().getUnityEnumData().getFacial3d();
        if (facial3d == null) {
            return "";
        }
        float k2 = qVar.k() / qVar.m();
        float j2 = qVar.j() / qVar.m();
        StringBuilder sb = new StringBuilder();
        sb.append(facial3d.getValue());
        sb.append(',');
        sb.append(j2);
        sb.append(',');
        sb.append(k2);
        return sb.toString();
    }

    private final void e() {
        if (this.f10857j == null) {
            this.f10857j = new LinkedHashMap();
        }
    }

    private final void g(String str, int i2, ArrayList<i> arrayList) {
        BeautyEditData beautyEditData = BeautyDataManager.a.m().j().get(str);
        if (beautyEditData == null) {
            return;
        }
        if (i2 != -1) {
            beautyEditData.setBeautyName(i2);
        }
        arrayList.add(new i(beautyEditData, true, false, 4, null));
    }

    static /* synthetic */ void h(EditBeautyModule editBeautyModule, String str, int i2, ArrayList arrayList, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = R.string.mannual;
        }
        editBeautyModule.g(str, i2, arrayList);
    }

    private final void i(String str, int i2, int i3, boolean z, boolean z2, ArrayList<i> arrayList) {
        Object obj;
        BeautyDataManager beautyDataManager = BeautyDataManager.a;
        BeautyEditData beautyEditData = beautyDataManager.m().i().get(str);
        if (beautyEditData == null) {
            Iterator<T> it = beautyDataManager.m().a().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (s.c(((BeautyEditData) obj).getBeautyKey(), str)) {
                    break;
                }
            }
            beautyEditData = (BeautyEditData) obj;
        }
        BeautyEditData beautyEditData2 = beautyEditData;
        if (beautyEditData2 != null) {
            if (i2 != -1) {
                beautyEditData2.setBeautyName(i2);
            }
            if (z2) {
                beautyEditData2.setBeautyIcon(R.drawable.icon_auto_beautify);
            }
            arrayList.add(new i(beautyEditData2, false, false, 4, null));
        }
        if (z) {
            g(str, i3, arrayList);
        }
    }

    static /* synthetic */ void j(EditBeautyModule editBeautyModule, String str, int i2, int i3, boolean z, boolean z2, ArrayList arrayList, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = R.string.auto;
        }
        int i5 = i2;
        if ((i4 & 4) != 0) {
            i3 = R.string.mannual;
        }
        editBeautyModule.i(str, i5, i3, z, (i4 & 16) != 0 ? true : z2, arrayList);
    }

    private final void z0(float f2) {
        UnityEditCaller.SkinColor.setSkinColorOpacity(f2);
    }

    public final String A() {
        return this.t;
    }

    public final void A0(int i2) {
        this.B = i2;
    }

    public final float B() {
        return this.s;
    }

    public final void B0(l<? super String, kotlin.u> lVar) {
        this.a.k1(lVar);
    }

    public final EditLongLegModule C() {
        return this.f10852e;
    }

    public final boolean C0() {
        return this.a.p1();
    }

    public final EditMakeupModule D() {
        return this.f10851d;
    }

    public final String[] E() {
        return new String[]{us.pinguo.edit2020.utils.d.k(R.string.fuse_refresh)};
    }

    public final void E0() {
        if (this.n) {
            Integer value = this.m.getValue();
            s.e(value);
            s.g(value, "currentFaceIndex.value!!");
            UnityEditCaller.AutoDeformation.setAutoDeformationFaceIndex(value.intValue());
        }
    }

    public final List<List<i>> F() {
        Object obj;
        e();
        ArrayList arrayList = new ArrayList();
        Map<String, List<i>> map = this.f10857j;
        if (map != null) {
            List<i> list = map.get("skin_tone");
            Map<String, List<i>> map2 = this.f10857j;
            if (map2 != null) {
                List<i> list2 = map2.get("bottom_color");
                boolean z = false;
                if (!(list == null || list.isEmpty())) {
                    if (!((list2 == null || list2.isEmpty()) ? true : true)) {
                        arrayList.add(list);
                        arrayList.add(list2);
                        return arrayList;
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                arrayList2.add(new i(us.pinguo.repository2020.l.n.a(), false, false, 4, null));
                for (String str : BeautyDataManager.a.m().l()) {
                    Iterator<T> it = BeautyDataManager.a.m().a().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it.next();
                        if (s.c(((BeautyEditData) obj).getBeautyKey(), str)) {
                            break;
                        }
                    }
                    BeautyEditData beautyEditData = (BeautyEditData) obj;
                    if (beautyEditData != null) {
                        arrayList2.add(new i(beautyEditData, false, false, 4, null));
                        arrayList3.add(new i(BeautyDataManager.a.m().h(), false, false, 4, null));
                    }
                }
                arrayList.add(arrayList2);
                arrayList.add(arrayList3);
                Map<String, List<i>> map3 = this.f10857j;
                if (map3 != null) {
                    map3.put("skin_tone", arrayList2);
                    Map<String, List<i>> map4 = this.f10857j;
                    if (map4 != null) {
                        map4.put("bottom_color", arrayList3);
                        return arrayList;
                    }
                    s.z("newBeautyDataMap");
                    throw null;
                }
                s.z("newBeautyDataMap");
                throw null;
            }
            s.z("newBeautyDataMap");
            throw null;
        }
        s.z("newBeautyDataMap");
        throw null;
    }

    public final i G() {
        return this.r;
    }

    public final HashMap<Integer, HashMap<String, Integer>> H() {
        return this.o;
    }

    public final m0 I() {
        return this.q;
    }

    public final ArrayList<m0> J() {
        Object obj;
        if (this.p == null) {
            this.p = new ArrayList<>();
            for (String str : BeautyDataManager.a.m().l()) {
                Iterator<T> it = BeautyDataManager.a.m().a().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (s.c(((BeautyEditData) obj).getBeautyKey(), str)) {
                        break;
                    }
                }
                BeautyEditData beautyEditData = (BeautyEditData) obj;
                if (beautyEditData != null) {
                    ArrayList<m0> arrayList = this.p;
                    s.e(arrayList);
                    arrayList.add(new m0(beautyEditData, false, 2, null));
                }
            }
        }
        ArrayList<m0> arrayList2 = this.p;
        s.e(arrayList2);
        return arrayList2;
    }

    public final List<Float> K() {
        return this.A;
    }

    public final int L() {
        return this.B;
    }

    public final ArrayList<n0> M() {
        Object obj;
        boolean z;
        ArrayList<n0> arrayList = this.f10854g;
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            ArrayList arrayList2 = new ArrayList();
            if (this.a.p1()) {
                arrayList2.add("yunfu");
                arrayList2.add("quban");
            }
            for (String str : BeautyDataManager.a.m().n()) {
                Iterator<T> it = BeautyDataManager.a.m().a().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    BeautyEditData beautyEditData = (BeautyEditData) obj;
                    if (!s.c(beautyEditData.getBeautyKey(), str) || arrayList2.contains(beautyEditData.getBeautyKey())) {
                        z = false;
                        continue;
                    } else {
                        z = true;
                        continue;
                    }
                    if (z) {
                        break;
                    }
                }
                BeautyEditData beautyEditData2 = (BeautyEditData) obj;
                if (beautyEditData2 != null) {
                    arrayList.add(new n0(beautyEditData2));
                }
            }
            this.f10854g = arrayList;
        }
        return arrayList;
    }

    public final ArrayList<n0> N() {
        if (this.f10855h == null) {
            this.f10855h = new ArrayList<>();
            for (BeautyEditData beautyEditData : BeautyDataManager.a.m().m()) {
                ArrayList<n0> arrayList = this.f10855h;
                if (arrayList != null) {
                    arrayList.add(new d0(beautyEditData));
                }
            }
        }
        ArrayList<n0> arrayList2 = this.f10855h;
        s.e(arrayList2);
        return arrayList2;
    }

    public final float O() {
        Context b = us.pinguo.foundation.e.b();
        s.g(b, "getAppContext()");
        return h.i(b) * this.A.get(this.B).floatValue() * 0.3f;
    }

    public final View[] P() {
        View autoView = View.inflate(us.pinguo.foundation.e.b(), us.pinguo.edit2020.R.layout.skin_refresh_tab_auto_item_layout, null);
        View manualView = View.inflate(us.pinguo.foundation.e.b(), us.pinguo.edit2020.R.layout.skin_refresh_tab_manual_item_layout, null);
        s.g(autoView, "autoView");
        s.g(manualView, "manualView");
        return new View[]{autoView, manualView};
    }

    public final ArrayList<r> Q(String groupName) {
        s.h(groupName, "groupName");
        HashMap<String, ArrayList<r>> hashMap = this.f10853f;
        boolean z = false;
        if (hashMap == null || hashMap.isEmpty()) {
            return null;
        }
        HashMap<String, ArrayList<r>> hashMap2 = this.f10853f;
        s.e(hashMap2);
        ArrayList<r> arrayList = hashMap2.get(groupName);
        if ((arrayList == null || arrayList.isEmpty()) ? true : true) {
            return null;
        }
        ArrayList<r> arrayList2 = new ArrayList<>();
        for (r rVar : arrayList) {
            arrayList2.add(rVar);
        }
        return arrayList2;
    }

    public final ArrayList<x> R() {
        ArrayList<x> arrayList = new ArrayList<>();
        List<us.pinguo.edit2020.bean.c> a2 = this.b.a();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : a2) {
            if (((us.pinguo.edit2020.bean.c) obj).e()) {
                arrayList2.add(obj);
            }
        }
        arrayList.addAll(arrayList2);
        for (k kVar : this.c.e()) {
            if (kVar.e()) {
                arrayList.add(kVar);
            }
        }
        HashMap<String, ArrayList<r>> y = y();
        ArrayList arrayList3 = new ArrayList();
        Collection<ArrayList<r>> values = y.values();
        s.g(values, "facialFeatureMap.values");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            arrayList3.addAll((ArrayList) it.next());
        }
        Collection<HashMap<String, Integer>> values2 = this.o.values();
        s.g(values2, "paramsMaps.values");
        Iterator<T> it2 = values2.iterator();
        while (it2.hasNext()) {
            HashMap it3 = (HashMap) it2.next();
            s.g(it3, "it");
            for (Map.Entry entry : it3.entrySet()) {
                if (((Number) entry.getValue()).intValue() != 0) {
                    ArrayList arrayList4 = new ArrayList();
                    for (Object obj2 : arrayList3) {
                        if (s.c(entry.getKey(), ((r) obj2).g().getBeautyKey())) {
                            arrayList4.add(obj2);
                        }
                    }
                    arrayList.addAll(arrayList4);
                }
            }
        }
        ArrayList<x> P = this.f10851d.P();
        ArrayList arrayList5 = new ArrayList();
        for (Object obj3 : P) {
            if (((x) obj3).e()) {
                arrayList5.add(obj3);
            }
        }
        arrayList.addAll(arrayList5);
        ArrayList<q> arrayList6 = this.f10856i;
        if (arrayList6 != null) {
            ArrayList arrayList7 = new ArrayList();
            for (Object obj4 : arrayList6) {
                if (((q) obj4).e()) {
                    arrayList7.add(obj4);
                }
            }
            arrayList.addAll(arrayList7);
        }
        Map<String, List<i>> map = this.f10857j;
        if (map == null) {
            ArrayList<n0> M = M();
            ArrayList arrayList8 = new ArrayList();
            for (Object obj5 : M) {
                if (((n0) obj5).e()) {
                    arrayList8.add(obj5);
                }
            }
            arrayList.addAll(arrayList8);
            ArrayList<n0> arrayList9 = this.f10855h;
            if (arrayList9 != null) {
                ArrayList arrayList10 = new ArrayList();
                for (Object obj6 : arrayList9) {
                    if (((n0) obj6).e()) {
                        arrayList10.add(obj6);
                    }
                }
                arrayList.addAll(arrayList10);
            }
            m0 m0Var = this.q;
            if (m0Var != null) {
                arrayList.add(m0Var);
            }
        } else if (map != null) {
            for (List<i> list : map.values()) {
                for (i iVar : list) {
                    if (!iVar.e()) {
                        String f2 = iVar.f();
                        i G = G();
                        if (s.c(f2, G == null ? null : G.f())) {
                        }
                    }
                    arrayList.add(iVar);
                }
            }
        } else {
            s.z("newBeautyDataMap");
            throw null;
        }
        ArrayList<b0> e2 = this.f10852e.e();
        ArrayList arrayList11 = new ArrayList();
        for (Object obj7 : e2) {
            if (((b0) obj7).e()) {
                arrayList11.add(obj7);
            }
        }
        arrayList.addAll(arrayList11);
        return arrayList;
    }

    public final boolean S() {
        us.pinguo.facedetector.c value = this.a.z().getValue();
        return value != null && value.c() > 0;
    }

    public final boolean T() {
        ArrayList<q> w = w();
        if (w.isEmpty()) {
            return false;
        }
        q qVar = w.get(0);
        s.g(qVar, "facial3DData[0]");
        q qVar2 = qVar;
        Iterator<q> it = w.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            int i3 = i2 + 1;
            q next = it.next();
            if (i2 != 0 && this.u.contains(next.f()) && qVar2.j() != next.j()) {
                return true;
            }
            i2 = i3;
        }
        return false;
    }

    public final boolean U(String beautyKey) {
        s.h(beautyKey, "beautyKey");
        return BeautyDataManager.a.m().o(beautyKey);
    }

    public final boolean V() {
        ArrayList<q> w = w();
        if ((w instanceof Collection) && w.isEmpty()) {
            return false;
        }
        for (q qVar : w) {
            if (qVar.e()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x004c, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean W() {
        /*
            r5 = this;
            java.util.HashMap<java.lang.Integer, java.util.HashMap<java.lang.String, java.lang.Integer>> r0 = r5.o
            java.util.Collection r0 = r0.values()
            java.lang.String r1 = "paramsMaps.values"
            kotlin.jvm.internal.s.g(r0, r1)
            java.util.Iterator r0 = r0.iterator()
        Lf:
            boolean r1 = r0.hasNext()
            r2 = 0
            if (r1 == 0) goto L4f
            java.lang.Object r1 = r0.next()
            java.util.HashMap r1 = (java.util.HashMap) r1
            java.util.Collection r1 = r1.values()
            java.lang.String r3 = "it.values"
            kotlin.jvm.internal.s.g(r1, r3)
            boolean r3 = r1.isEmpty()
            r4 = 1
            if (r3 == 0) goto L2d
            goto L4c
        L2d:
            java.util.Iterator r1 = r1.iterator()
        L31:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L4c
            java.lang.Object r3 = r1.next()
            java.lang.Integer r3 = (java.lang.Integer) r3
            if (r3 != 0) goto L40
            goto L46
        L40:
            int r3 = r3.intValue()
            if (r3 == 0) goto L48
        L46:
            r3 = 1
            goto L49
        L48:
            r3 = 0
        L49:
            if (r3 == 0) goto L31
            r2 = 1
        L4c:
            if (r2 == 0) goto Lf
            return r4
        L4f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.viewmodel.module.EditBeautyModule.W():boolean");
    }

    public final boolean X() {
        ArrayList<b0> f2 = this.f10852e.f();
        if ((f2 instanceof Collection) && f2.isEmpty()) {
            return false;
        }
        for (b0 b0Var : f2) {
            if (b0Var.e()) {
                return true;
            }
        }
        return false;
    }

    public final boolean Y() {
        ArrayList<x> P = this.f10851d.P();
        if ((P instanceof Collection) && P.isEmpty()) {
            return false;
        }
        for (x xVar : P) {
            if (xVar.e()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0046, code lost:
        r2 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean Z(kotlin.jvm.b.l<? super us.pinguo.edit2020.bean.i, java.lang.Boolean> r5) {
        /*
            r4 = this;
            java.lang.String r0 = "predicate"
            kotlin.jvm.internal.s.h(r5, r0)
            java.util.Map<java.lang.String, java.util.List<us.pinguo.edit2020.bean.i>> r0 = r4.f10857j
            if (r0 == 0) goto L49
            java.util.Collection r0 = r0.values()
            java.util.Iterator r0 = r0.iterator()
            r1 = 0
        L12:
            r2 = 0
        L13:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L48
            java.lang.Object r2 = r0.next()
            java.util.List r2 = (java.util.List) r2
            boolean r3 = r2 instanceof java.util.Collection
            if (r3 == 0) goto L2a
            boolean r3 = r2.isEmpty()
            if (r3 == 0) goto L2a
            goto L12
        L2a:
            java.util.Iterator r2 = r2.iterator()
        L2e:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L12
            java.lang.Object r3 = r2.next()
            us.pinguo.edit2020.bean.i r3 = (us.pinguo.edit2020.bean.i) r3
            java.lang.Object r3 = r5.invoke(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L2e
            r2 = 1
            goto L13
        L48:
            return r2
        L49:
            java.lang.String r5 = "newBeautyDataMap"
            kotlin.jvm.internal.s.z(r5)
            r5 = 0
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.viewmodel.module.EditBeautyModule.Z(kotlin.jvm.b.l):boolean");
    }

    public final void a(q function) {
        String i0;
        s.h(function, "function");
        if (function.i().getUnityEnumData().getFacial3d() == null) {
            ArrayList<q> w = w();
            ArrayList<q> arrayList = new ArrayList();
            for (Object obj : w) {
                if (!s.c(((q) obj).f(), function.f())) {
                    arrayList.add(obj);
                }
            }
            String str = "";
            for (q qVar : arrayList) {
                if (this.u.contains(qVar.f())) {
                    qVar.o(function.j());
                }
                str = str + D0(qVar) + '|';
            }
            i0 = StringsKt__StringsKt.i0(str, Effect.DIVIDER);
            this.a.m(i0);
            return;
        }
        this.a.m(D0(function));
    }

    public final boolean a0() {
        boolean z;
        boolean z2;
        m0 m0Var = this.q;
        if (m0Var != null && m0Var.e()) {
            return true;
        }
        ArrayList<n0> M = M();
        if (!(M instanceof Collection) || !M.isEmpty()) {
            for (n0 n0Var : M) {
                if (n0Var.e()) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (z) {
            return true;
        }
        ArrayList<n0> N = N();
        if (!(N instanceof Collection) || !N.isEmpty()) {
            for (n0 n0Var2 : N) {
                if (n0Var2.e()) {
                    z2 = true;
                    break;
                }
            }
        }
        z2 = false;
        return z2;
    }

    public final void b(String mode) {
        s.h(mode, "mode");
        this.a.n(mode);
    }

    public final boolean b0(FunctionType functionType) {
        switch (functionType == null ? -1 : a.a[functionType.ordinal()]) {
            case 1:
                List<us.pinguo.edit2020.bean.c> a2 = this.b.a();
                if (!(a2 instanceof Collection) || !a2.isEmpty()) {
                    for (us.pinguo.edit2020.bean.c cVar : a2) {
                        if (cVar.e()) {
                            return true;
                        }
                    }
                }
                return false;
            case 2:
                return a0();
            case 3:
                return W();
            case 4:
                List<k> e2 = this.c.e();
                if (!(e2 instanceof Collection) || !e2.isEmpty()) {
                    for (k kVar : e2) {
                        if (kVar.e()) {
                            return true;
                        }
                    }
                }
                return false;
            case 5:
                return Y();
            case 6:
                return V();
            case 7:
                return this.r != null || Z(EditBeautyModule$isWorkflowFunItemUsed$3.INSTANCE);
            case 8:
                ArrayList<b0> e3 = this.f10852e.e();
                if (!(e3 instanceof Collection) || !e3.isEmpty()) {
                    for (b0 b0Var : e3) {
                        if (b0Var.e()) {
                            return true;
                        }
                    }
                }
                return false;
            default:
                return false;
        }
    }

    public final boolean c(EditModel model) {
        s.h(model, "model");
        if (this.a.A() != model) {
            return this.a.o(model);
        }
        return true;
    }

    public final void c0(kotlin.jvm.b.a<kotlin.u> callback) {
        s.h(callback, "callback");
        this.a.s0(new EditBeautyModule$onSkinRefreshUnityPrepared$1(callback));
    }

    public final void d() {
        this.a.s0(null);
    }

    public final String d0(String step) {
        List p0;
        List<String> p02;
        List p03;
        s.h(step, "step");
        p0 = StringsKt__StringsKt.p0(step, new String[]{Effect.DIVIDER}, false, 0, 6, null);
        if (!p0.isEmpty()) {
            p02 = StringsKt__StringsKt.p0((CharSequence) p0.get(0), new String[]{","}, false, 0, 6, null);
            for (String str : p02) {
                p03 = StringsKt__StringsKt.p0(str, new String[]{":"}, false, 0, 6, null);
                if (p03.size() == 2 && s.c(p03.get(0), this.x)) {
                    return (String) p03.get(1);
                }
            }
            return null;
        }
        return null;
    }

    public final boolean e0(String step) {
        List p0;
        List<String> p02;
        List p03;
        s.h(step, "step");
        p0 = StringsKt__StringsKt.p0(step, new String[]{Effect.DIVIDER}, false, 0, 6, null);
        if (!p0.isEmpty()) {
            p02 = StringsKt__StringsKt.p0((CharSequence) p0.get(0), new String[]{","}, false, 0, 6, null);
            for (String str : p02) {
                p03 = StringsKt__StringsKt.p0(str, new String[]{":"}, false, 0, 6, null);
                if (p03.size() == 2 && s.c(p03.get(0), this.v)) {
                    return !s.c(p03.get(1), this.y);
                }
            }
        }
        return false;
    }

    public final void f(boolean z) {
        this.a.n1(z);
    }

    public final Float f0(String step) {
        List p0;
        List<String> p02;
        List p03;
        s.h(step, "step");
        p0 = StringsKt__StringsKt.p0(step, new String[]{Effect.DIVIDER}, false, 0, 6, null);
        if (!p0.isEmpty()) {
            p02 = StringsKt__StringsKt.p0((CharSequence) p0.get(0), new String[]{","}, false, 0, 6, null);
            for (String str : p02) {
                p03 = StringsKt__StringsKt.p0(str, new String[]{":"}, false, 0, 6, null);
                if (p03.size() == 2 && s.c(p03.get(0), this.w)) {
                    return Float.valueOf(Float.parseFloat((String) p03.get(1)));
                }
            }
            return null;
        }
        return null;
    }

    public final void g0(String step) {
        List<String> p0;
        List p02;
        Object obj;
        int maxValue;
        int i2;
        List p03;
        s.h(step, "step");
        Log.i(TJAdUnitConstants.String.VIDEO_INFO, s.q("==============parseSkinManualStepResult=", step));
        p0 = StringsKt__StringsKt.p0(step, new String[]{Effect.DIVIDER}, false, 0, 6, null);
        for (String str : p0) {
            float f2 = 0.0f;
            p02 = StringsKt__StringsKt.p0(str, new String[]{","}, false, 0, 6, null);
            Iterator it = p02.iterator();
            Object obj2 = "";
            Object obj3 = "";
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                p03 = StringsKt__StringsKt.p0((String) it.next(), new String[]{":"}, false, 0, 6, null);
                if (p03.size() == 2) {
                    if (s.c(p03.get(0), "type")) {
                        obj2 = p03.get(1);
                    }
                    if (s.c(p03.get(0), "modify")) {
                        obj3 = p03.get(1);
                    }
                    if (s.c(p03.get(0), Frame.PARAM_KEY_OPACITY)) {
                        f2 = Float.parseFloat((String) p03.get(1));
                    }
                }
            }
            ArrayList<n0> arrayList = this.f10855h;
            if (arrayList != null) {
                Iterator<T> it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it2.next();
                    if (s.c(((n0) obj).f(), obj2)) {
                        break;
                    }
                }
                n0 n0Var = (n0) obj;
                if (n0Var != null) {
                    if (s.c(obj3, "0")) {
                        n0Var.h(false);
                    } else {
                        n0Var.h(true);
                    }
                    if (f2 == -1.0f) {
                        i2 = n0Var.g().getDefaultValue();
                    } else {
                        if (s.c(n0Var.f(), A())) {
                            f2 *= B();
                            maxValue = n0Var.g().getMaxValue();
                        } else {
                            maxValue = n0Var.g().getMaxValue();
                        }
                        i2 = (int) (f2 * maxValue);
                    }
                    n0Var.g().setCurrentValue(i2);
                }
            }
        }
    }

    public final void h0() {
        this.a.reportMagnifierRenderer();
    }

    public final void i0() {
        HashMap<String, ArrayList<r>> hashMap = this.f10853f;
        if (hashMap != null) {
            Collection<ArrayList<r>> values = hashMap.values();
            s.g(values, "it.values");
            Iterator<T> it = values.iterator();
            while (it.hasNext()) {
                ArrayList<r> dataList = (ArrayList) it.next();
                s.g(dataList, "dataList");
                for (r rVar : dataList) {
                    rVar.g().setCurrentValue(rVar.g().getDefaultValue());
                }
            }
        }
        this.o.clear();
        ArrayList<n0> arrayList = this.f10854g;
        if (arrayList != null) {
            for (n0 n0Var : arrayList) {
                if (s.c(n0Var.f(), "yunfu")) {
                    n0Var.g().setCurrentValue(-1);
                } else {
                    n0Var.g().setCurrentValue(n0Var.g().getDefaultValue());
                }
            }
        }
        for (n0 n0Var2 : N()) {
            n0Var2.h(false);
            n0Var2.g().setCurrentValue(n0Var2.g().getDefaultValue());
        }
        Map<String, List<i>> map = this.f10857j;
        if (map != null) {
            if (map != null) {
                for (List<i> list : map.values()) {
                    for (i iVar : list) {
                        iVar.l(false);
                        iVar.h(false);
                        if (iVar.i().getBackupValue() != -1) {
                            iVar.i().setCurrentValue(iVar.i().getBackupValue());
                        } else {
                            iVar.i().setCurrentValue(iVar.i().getDefaultValue());
                        }
                    }
                }
                Map<String, List<i>> map2 = this.f10857j;
                if (map2 != null) {
                    map2.clear();
                    return;
                } else {
                    s.z("newBeautyDataMap");
                    throw null;
                }
            }
            s.z("newBeautyDataMap");
            throw null;
        }
    }

    public final void j0() {
        String i0;
        ArrayList<q> w = w();
        if (w.isEmpty()) {
            return;
        }
        q qVar = w.get(0);
        s.g(qVar, "facial3DData[0]");
        q qVar2 = qVar;
        ArrayList<q> w2 = w();
        ArrayList<q> arrayList = new ArrayList();
        for (Object obj : w2) {
            if (!s.c(((q) obj).f(), qVar2.f())) {
                arrayList.add(obj);
            }
        }
        String str = "";
        for (q qVar3 : arrayList) {
            if (this.u.contains(qVar3.f())) {
                qVar3.o(qVar2.j());
                str = str + D0(qVar3) + '|';
            }
        }
        i0 = StringsKt__StringsKt.i0(str, Effect.DIVIDER);
        Iterator<Integer> it = new kotlin.z.d(0, 3).iterator();
        while (it.hasNext()) {
            ((h0) it).nextInt();
            this.a.m(i0);
        }
    }

    public final EditAutoBeautifyModule k() {
        return this.b;
    }

    public final void k0() {
        ArrayList<q> arrayList = this.f10856i;
        if (arrayList == null) {
            return;
        }
        Iterator<q> it = arrayList.iterator();
        while (it.hasNext()) {
            q next = it.next();
            next.p(next.l());
            next.o(next.l());
        }
    }

    public final List<i> l(String key) {
        s.h(key, "key");
        e();
        Map<String, List<i>> map = this.f10857j;
        if (map != null) {
            List<i> list = map.get(key);
            if (list == null || list.isEmpty()) {
                ArrayList<i> arrayList = new ArrayList<>();
                if (us.pinguo.edit2020.repository.a.d().contains(key)) {
                    j(this, key, 0, 0, true, false, arrayList, 22, null);
                } else if (s.c(key, "tiliang")) {
                    j(this, "wuguanliti", 0, 0, false, false, arrayList, 22, null);
                    g("tiliang", -1, arrayList);
                    g("jiashen", -1, arrayList);
                } else if (s.c(key, "mopi")) {
                    j(this, "mopi", 0, -1, false, false, arrayList, 18, null);
                    g("mopi", R.string.mannual, arrayList);
                    g("quheitou", R.string.quheitou, arrayList);
                } else if (s.c(key, "quzhouwen")) {
                    j(this, "falingwen", -1, 0, false, false, arrayList, 4, null);
                    j(this, "yuweiwen", -1, 0, false, false, arrayList, 4, null);
                    h(this, key, 0, arrayList, 2, null);
                }
                Map<String, List<i>> map2 = this.f10857j;
                if (map2 != null) {
                    map2.put(key, arrayList);
                    for (i iVar : arrayList) {
                        us.pinguo.common.log.a.k("functionName==>" + iVar.c() + "==id=" + iVar.f() + "===>" + iVar.j(), new Object[0]);
                    }
                    return arrayList;
                }
                s.z("newBeautyDataMap");
                throw null;
            }
            return list;
        }
        s.z("newBeautyDataMap");
        throw null;
    }

    public final void l0() {
        this.a.r();
    }

    public final ArrayList<us.pinguo.edit2020.bean.h> m() {
        ArrayList<us.pinguo.edit2020.bean.h> f2;
        String a2 = us.pinguo.repository2020.abtest.a.a.a();
        int hashCode = a2.hashCode();
        if (hashCode != -857220509) {
            if (hashCode != 618830207) {
                if (hashCode == 1233949871 && a2.equals("new_portrait_makeup_list")) {
                    return us.pinguo.edit2020.repository.a.b();
                }
            } else if (a2.equals("new_portrait_makeup_smooth")) {
                return us.pinguo.edit2020.repository.a.c();
            }
        } else if (a2.equals("new_portrait_list")) {
            return us.pinguo.edit2020.repository.a.a();
        }
        f2 = kotlin.collections.u.f(new us.pinguo.edit2020.bean.h(null, R.drawable.icon_beauty_workflow_onekeybeauty, R.string.main_menu_beauty_onebtbeauty, 1, null), new us.pinguo.edit2020.bean.h(null, R.drawable.icon_beauty_workflow_skinrefresh, R.string.main_menu_beauty_skinrefresh, 1, null), new us.pinguo.edit2020.bean.h(null, R.drawable.icon_beauty_workflow_facialfeatures, R.string.main_menu_beauty_facialfeatures, 1, null), new us.pinguo.edit2020.bean.h(null, R.drawable.icon_beauty_workflow_longleg, R.string.main_menu_beauty_long_leg, 1, null), new us.pinguo.edit2020.bean.h(null, R.drawable.icon_beauty_workflow_bodyshaping, R.string.main_menu_beauty_handshape, 1, null), new us.pinguo.edit2020.bean.h(null, R.drawable.icon_beauty_workflow_makeup, R.string.main_menu_beauty_makeup, 1, null), new us.pinguo.edit2020.bean.h(null, R.drawable.ic_facial3d, R.string.main_menu_facial_three_dimensional, 1, null));
        return f2;
    }

    public final void m0() {
        ArrayList<m0> arrayList = this.p;
        if (arrayList == null) {
            return;
        }
        for (m0 m0Var : arrayList) {
            m0Var.g().setCurrentValue(50);
            m0Var.i(false);
        }
    }

    public final EditBodyShapeModule n() {
        return this.c;
    }

    public final void n0(BasicBrushMode brushMode, float f2) {
        s.h(brushMode, "brushMode");
        this.a.p0(brushMode, f2);
    }

    public final u<u0> o() {
        return this.a.L();
    }

    public final void o0(BasicBrushMode brushMode) {
        s.h(brushMode, "brushMode");
        this.a.q0(brushMode);
    }

    public final u<BeautyEditData> p() {
        return this.f10858k;
    }

    public final void p0(n0 n0Var) {
        this.z = n0Var;
    }

    public final u<Integer> q() {
        return this.m;
    }

    public final void q0(BeautyEditData beautyData) {
        s.h(beautyData, "beautyData");
        BeautyUnityEnumData unityEnumData = beautyData.getUnityEnumData();
        if (unityEnumData.getDeformationParam() != null) {
            DeformationParam deformationParam = unityEnumData.getDeformationParam();
            if (deformationParam == null) {
                return;
            }
            deformationParam.setValue(beautyData.getCurrentValue() / beautyData.getMaxValue());
            UnityEditCaller.AutoDeformation.setAutoDeformationParam(deformationParam);
        } else if (unityEnumData.getSoftSkinParam() != null) {
            if (s.c(beautyData.getBeautyKey(), "wuguanliti")) {
                float currentValue = beautyData.getCurrentValue();
                SoftSkinParam softSkinParam = SoftSkinParam.YIN_YING;
                softSkinParam.setValue(currentValue / beautyData.getMaxValue());
                Integer value = this.m.getValue();
                s.e(value);
                s.g(value, "currentFaceIndex.value!!");
                UnityEditCaller.SoftSkin.setEditSoftSkinParam(softSkinParam, value.intValue(), false, beautyData.getNeedFace());
                SoftSkinParam softSkinParam2 = SoftSkinParam.GAO_GUANG;
                softSkinParam2.setValue(currentValue / beautyData.getMaxValue());
                Integer value2 = this.m.getValue();
                s.e(value2);
                s.g(value2, "currentFaceIndex.value!!");
                UnityEditCaller.SoftSkin.setEditSoftSkinParam(softSkinParam2, value2.intValue(), false, beautyData.getNeedFace());
            } else if (BeautyDataManager.a.m().o(beautyData.getBeautyKey())) {
                SoftSkinParam softSkinParam3 = unityEnumData.getSoftSkinParam();
                if (softSkinParam3 == null) {
                    return;
                }
                softSkinParam3.setValue(beautyData.getCurrentValue() / beautyData.getMaxValue());
                if (s.c(PortalFollowFeeds.TYPE_NONE, beautyData.getBeautyKey())) {
                    z0(softSkinParam3.getValue());
                    SoftSkinParam softSkinParam4 = SoftSkinParam.FU_SE;
                    softSkinParam4.setValue(0.0f);
                    UnityEditCaller.SoftSkin.setEditSoftSkinParam(softSkinParam4, 0, false, false);
                    return;
                }
                UnityEditCaller.SkinColor.setSkinColor(softSkinParam3.getKey());
                z0(softSkinParam3.getValue());
            } else {
                SoftSkinParam softSkinParam5 = unityEnumData.getSoftSkinParam();
                if (softSkinParam5 == null) {
                    return;
                }
                softSkinParam5.setValue(beautyData.getCurrentValue() / beautyData.getMaxValue());
                Integer value3 = q().getValue();
                s.e(value3);
                s.g(value3, "currentFaceIndex.value!!");
                UnityEditCaller.SoftSkin.setEditSoftSkinParam(softSkinParam5, value3.intValue(), false, beautyData.getNeedFace());
            }
        } else {
            unityEnumData.getMakeupType();
        }
    }

    public final float r(String str) {
        Context b = us.pinguo.foundation.e.b();
        s.g(b, "getAppContext()");
        return h.i(b) * u(str);
    }

    public final void r0(boolean z) {
        this.n = z;
    }

    public final n0 s() {
        return this.z;
    }

    public final void s0(float f2, float f3) {
        UnityEditCaller.Common common = UnityEditCaller.Common.INSTANCE;
        common.setMagnifierRenderUpdateMode(1);
        common.setMagnifierPosition(f2, f3);
        common.setMagnifierRenderUpdateMode(0);
    }

    public final u<FunctionType> t() {
        return this.f10859l;
    }

    public final void t0(i iVar) {
        this.r = iVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0083 A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float u(java.lang.String r4) {
        /*
            r3 = this;
            r0 = 1033476506(0x3d99999a, float:0.075)
            r1 = 1036831949(0x3dcccccd, float:0.1)
            if (r4 == 0) goto L87
            int r2 = r4.hashCode()
            switch(r2) {
                case -1609686080: goto L7a;
                case -1405471708: goto L71;
                case -1314729496: goto L68;
                case -1208883106: goto L5b;
                case -1093229070: goto L52;
                case -705555594: goto L49;
                case -643700056: goto L3c;
                case -511816920: goto L33;
                case 3262204: goto L2a;
                case 3357467: goto L20;
                case 825341869: goto L11;
                default: goto Lf;
            }
        Lf:
            goto L87
        L11:
            java.lang.String r0 = "liangbai"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L1b
            goto L87
        L1b:
            r0 = 1028443341(0x3d4ccccd, float:0.05)
            goto L8a
        L20:
            java.lang.String r0 = "mopi"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L83
            goto L87
        L2a:
            java.lang.String r0 = "jili"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L83
            goto L87
        L33:
            java.lang.String r1 = "jiegoutuchu"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L8a
            goto L87
        L3c:
            java.lang.String r0 = "quzhouwen"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L45
            goto L87
        L45:
            r0 = 1025758986(0x3d23d70a, float:0.04)
            goto L8a
        L49:
            java.lang.String r1 = "zengse"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L8a
            goto L87
        L52:
            java.lang.String r1 = "quheitou"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L8a
            goto L87
        L5b:
            java.lang.String r0 = "hongxuesi"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L64
            goto L87
        L64:
            r0 = 1045220557(0x3e4ccccd, float:0.2)
            goto L8a
        L68:
            java.lang.String r1 = "tiliang"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L8a
            goto L87
        L71:
            java.lang.String r0 = "yaguang"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L83
            goto L87
        L7a:
            java.lang.String r0 = "jiashen"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L83
            goto L87
        L83:
            r0 = 1036831949(0x3dcccccd, float:0.1)
            goto L8a
        L87:
            r0 = 1041865114(0x3e19999a, float:0.15)
        L8a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.viewmodel.module.EditBeautyModule.u(java.lang.String):float");
    }

    public final void u0(kotlin.jvm.b.a<kotlin.u> aVar, kotlin.jvm.b.a<kotlin.u> aVar2) {
        this.a.R0(aVar);
        this.a.Q0(aVar2);
    }

    public final int v() {
        us.pinguo.facedetector.c value = this.a.z().getValue();
        if (value == null) {
            return 0;
        }
        return value.c();
    }

    public final void v0(String key, float f2) {
        s.h(key, "key");
        this.a.Y0(key, f2);
    }

    public final ArrayList<q> w() {
        if (this.f10856i == null) {
            this.f10856i = new ArrayList<>();
            for (BeautyEditData beautyEditData : BeautyDataManager.a.m().b()) {
                ArrayList<q> arrayList = this.f10856i;
                if (arrayList != null) {
                    arrayList.add(new q(beautyEditData));
                }
            }
        }
        ArrayList<q> arrayList2 = this.f10856i;
        s.e(arrayList2);
        return arrayList2;
    }

    public final void w0(kotlin.jvm.b.a<kotlin.u> aVar) {
        this.a.Z0(aVar);
    }

    public final ArrayList<r> x(String groupName) {
        s.h(groupName, "groupName");
        HashMap<String, ArrayList<r>> hashMap = this.f10853f;
        if (hashMap == null) {
            return null;
        }
        return hashMap.get(groupName);
    }

    public final void x0(kotlin.jvm.b.a<kotlin.u> aVar) {
        this.a.a1(aVar);
    }

    public final HashMap<String, ArrayList<r>> y() {
        ArrayList<r> f2;
        ArrayList<r> f3;
        ArrayList<r> f4;
        ArrayList<r> f5;
        ArrayList<r> f6;
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        EditBeautyModule editBeautyModule = this;
        if (editBeautyModule.f10853f == null) {
            r rVar = new r(new BeautyEditData(PortalFollowFeeds.TYPE_NONE, R.string.str_restore, us.pinguo.edit2020.R.drawable.ic_edit_elimination_reset, 0, 100, 0, 0, new BeautyUnityEnumData(SoftSkinParam.ZI_RAN_BAI, null, null, null, 14, null), false, false, 0, 1024, null));
            f2 = kotlin.collections.u.f(rVar);
            f3 = kotlin.collections.u.f(rVar);
            f4 = kotlin.collections.u.f(rVar);
            f5 = kotlin.collections.u.f(rVar);
            f6 = kotlin.collections.u.f(rVar);
            Iterator<T> it = BeautyDataManager.a.m().e().iterator();
            while (true) {
                Object obj5 = null;
                if (!it.hasNext()) {
                    break;
                }
                String str = (String) it.next();
                Iterator<T> it2 = BeautyDataManager.a.m().a().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    Object next = it2.next();
                    if (s.c(((BeautyEditData) next).getBeautyKey(), str)) {
                        obj5 = next;
                        break;
                    }
                }
                BeautyEditData beautyEditData = (BeautyEditData) obj5;
                if (beautyEditData != null) {
                    f2.add(new r(beautyEditData));
                }
            }
            for (String str2 : BeautyDataManager.a.m().c()) {
                Iterator<T> it3 = BeautyDataManager.a.m().a().iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        obj4 = null;
                        break;
                    }
                    obj4 = it3.next();
                    if (s.c(((BeautyEditData) obj4).getBeautyKey(), str2)) {
                        break;
                    }
                }
                BeautyEditData beautyEditData2 = (BeautyEditData) obj4;
                if (beautyEditData2 != null) {
                    f3.add(new r(beautyEditData2));
                }
            }
            for (String str3 : BeautyDataManager.a.m().d()) {
                Iterator<T> it4 = BeautyDataManager.a.m().a().iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        obj3 = null;
                        break;
                    }
                    obj3 = it4.next();
                    if (s.c(((BeautyEditData) obj3).getBeautyKey(), str3)) {
                        break;
                    }
                }
                BeautyEditData beautyEditData3 = (BeautyEditData) obj3;
                if (beautyEditData3 != null) {
                    f4.add(new r(beautyEditData3));
                }
            }
            for (String str4 : BeautyDataManager.a.m().g()) {
                Iterator<T> it5 = BeautyDataManager.a.m().a().iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        obj2 = null;
                        break;
                    }
                    obj2 = it5.next();
                    if (s.c(((BeautyEditData) obj2).getBeautyKey(), str4)) {
                        break;
                    }
                }
                BeautyEditData beautyEditData4 = (BeautyEditData) obj2;
                if (beautyEditData4 != null) {
                    f5.add(new r(beautyEditData4));
                }
            }
            for (String str5 : BeautyDataManager.a.m().f()) {
                Iterator<T> it6 = BeautyDataManager.a.m().a().iterator();
                while (true) {
                    if (!it6.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it6.next();
                    if (s.c(((BeautyEditData) obj).getBeautyKey(), str5)) {
                        break;
                    }
                }
                BeautyEditData beautyEditData5 = (BeautyEditData) obj;
                if (beautyEditData5 != null) {
                    f6.add(new r(beautyEditData5));
                }
            }
            HashMap<String, ArrayList<r>> hashMap = new HashMap<>();
            String string = us.pinguo.foundation.e.b().getString(R.string.edit_facialfeatures_tab_face);
            s.g(string, "getAppContext().getStrin…_facialfeatures_tab_face)");
            hashMap.put(string, f2);
            String string2 = us.pinguo.foundation.e.b().getString(R.string.edit_facialfeatures_tab_eye);
            s.g(string2, "getAppContext().getStrin…t_facialfeatures_tab_eye)");
            hashMap.put(string2, f3);
            String string3 = us.pinguo.foundation.e.b().getString(R.string.edit_facialfeatures_tab_eyebrow);
            s.g(string3, "getAppContext().getStrin…cialfeatures_tab_eyebrow)");
            hashMap.put(string3, f4);
            String string4 = us.pinguo.foundation.e.b().getString(R.string.edit_facialfeatures_tab_nose);
            s.g(string4, "getAppContext().getStrin…_facialfeatures_tab_nose)");
            hashMap.put(string4, f5);
            String string5 = us.pinguo.foundation.e.b().getString(R.string.edit_facialfeatures_tab_mouth);
            s.g(string5, "getAppContext().getStrin…facialfeatures_tab_mouth)");
            hashMap.put(string5, f6);
            editBeautyModule = this;
            editBeautyModule.f10853f = hashMap;
        }
        HashMap<String, ArrayList<r>> hashMap2 = editBeautyModule.f10853f;
        s.e(hashMap2);
        return hashMap2;
    }

    public final void y0(m0 m0Var) {
        this.q = m0Var;
    }

    public final String[] z() {
        String string = us.pinguo.foundation.e.b().getString(R.string.edit_facialfeatures_tab_face);
        s.g(string, "getAppContext().getStrin…_facialfeatures_tab_face)");
        String string2 = us.pinguo.foundation.e.b().getString(R.string.edit_facialfeatures_tab_nose);
        s.g(string2, "getAppContext().getStrin…_facialfeatures_tab_nose)");
        String string3 = us.pinguo.foundation.e.b().getString(R.string.edit_facialfeatures_tab_eye);
        s.g(string3, "getAppContext().getStrin…t_facialfeatures_tab_eye)");
        String string4 = us.pinguo.foundation.e.b().getString(R.string.edit_facialfeatures_tab_eyebrow);
        s.g(string4, "getAppContext().getStrin…cialfeatures_tab_eyebrow)");
        String string5 = us.pinguo.foundation.e.b().getString(R.string.edit_facialfeatures_tab_mouth);
        s.g(string5, "getAppContext().getStrin…facialfeatures_tab_mouth)");
        return new String[]{string, string2, string3, string4, string5};
    }
}
