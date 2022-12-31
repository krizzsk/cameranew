package us.pinguo.repository2020.manager;

import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.databinding.ObservableBoolean;
import com.pinguo.camera360.effect.model.entity.Effect;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.c0;
import kotlin.collections.v;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.s;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.sync.MutexKt;
import kotlinx.coroutines.z0;
import us.pinguo.foundation.R;
import us.pinguo.repository2020.FilterConstants;
import us.pinguo.repository2020.database.filter.FilterParamsTable;
import us.pinguo.repository2020.entity.BaseFilter;
import us.pinguo.repository2020.entity.CategoryItem;
import us.pinguo.repository2020.entity.ChildComponent;
import us.pinguo.repository2020.entity.FilterEntry;
import us.pinguo.repository2020.entity.FilterItem;
import us.pinguo.repository2020.entity.FilterPackage;
import us.pinguo.repository2020.entity.Package;
import us.pinguo.repository2020.entity.PackageItem;
import us.pinguo.repository2020.entity.Scene;
import us.pinguo.repository2020.entity.SkyEffect;
import us.pinguo.repository2020.entity.UnityFilterItemTemplateIndex;
import us.pinguo.repository2020.manager.FilterInstallManager;
import us.pinguo.repository2020.q;
import us.pinguo.repository2020.u;
import us.pinguo.repository2020.utils.o;
/* compiled from: FilterRepository.kt */
/* loaded from: classes6.dex */
public final class FilterRepository {
    public static final FilterRepository a;
    private static final boolean b;
    private static final l c;

    /* renamed from: d  reason: collision with root package name */
    private static final FilterLocalDataManager f11912d;

    /* renamed from: e  reason: collision with root package name */
    private static final a f11913e;

    /* renamed from: f  reason: collision with root package name */
    private static final FilterInstallManager f11914f;

    /* renamed from: g  reason: collision with root package name */
    private static boolean f11915g;

    /* renamed from: h  reason: collision with root package name */
    private static final u<FilterEntry> f11916h;

    /* renamed from: i  reason: collision with root package name */
    private static FilterInstallManager.a f11917i;

    /* renamed from: j  reason: collision with root package name */
    private static volatile boolean f11918j;

    /* renamed from: k  reason: collision with root package name */
    private static final kotlinx.coroutines.sync.c f11919k;

    /* compiled from: FilterRepository.kt */
    /* loaded from: classes6.dex */
    public static final class a implements FilterInstallManager.a {
        a() {
        }

        @Override // us.pinguo.repository2020.manager.FilterInstallManager.a
        public void a() {
            FilterRepository filterRepository = FilterRepository.a;
            FilterInstallManager.a v = filterRepository.v();
            if (v != null) {
                v.a();
            }
            filterRepository.J(true);
        }
    }

    /* compiled from: Comparisons.kt */
    /* loaded from: classes6.dex */
    public static final class b<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int a;
            a = kotlin.w.b.a(((Scene) t2).getEditPriority(), ((Scene) t).getEditPriority());
            return a;
        }
    }

    static {
        FilterRepository filterRepository = new FilterRepository();
        a = filterRepository;
        b = s.c(us.pinguo.foundation.e.b().getResources().getString(R.string.filter_lang), "cn");
        l lVar = new l();
        c = lVar;
        f11912d = new FilterLocalDataManager();
        a aVar = new a();
        f11913e = aVar;
        f11914f = new FilterInstallManager(aVar);
        f11915g = lVar.f();
        f11916h = new u<>();
        f11919k = MutexKt.b(false, 1, null);
        filterRepository.A();
    }

    private FilterRepository() {
    }

    public static /* synthetic */ void K(FilterRepository filterRepository, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        filterRepository.J(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(FilterEntry filterEntry) {
        StringBuilder sb = new StringBuilder();
        sb.append((Object) filterEntry.getCategoryId());
        sb.append('|');
        sb.append((Object) filterEntry.getPkgId());
        sb.append('|');
        sb.append((Object) filterEntry.getItemId());
        o.v(o.a, "current_filter_entry", sb.toString(), null, 4, null);
    }

    private final List<PackageItem> q(CategoryItem categoryItem, ObservableBoolean observableBoolean, boolean z, boolean z2) {
        Integer unity_engine_filter;
        Integer camera_support;
        ArrayList arrayList = new ArrayList();
        List<Package> e2 = c.e(categoryItem.getCategoryId(), z2);
        if (e2 != null) {
            ArrayList<Package> arrayList2 = new ArrayList();
            for (Object obj : e2) {
                Package r7 = (Package) obj;
                if ((TextUtils.isEmpty(r7.getIcon()) || TextUtils.isEmpty(r7.getPid()) || TextUtils.isEmpty(r7.getName()) || !(z || (unity_engine_filter = r7.getUnity_engine_filter()) == null || unity_engine_filter.intValue() != 1 || ((camera_support = r7.getCamera_support()) != null && camera_support.intValue() == 1))) ? false : true) {
                    arrayList2.add(obj);
                }
            }
            for (Package r3 : arrayList2) {
                String categoryId = categoryItem.getCategoryId();
                String pid = r3.getPid();
                String str = pid == null ? "" : pid;
                String icon = r3.getIcon();
                String str2 = icon == null ? "" : icon;
                String name = r3.getName();
                String str3 = name == null ? "" : name;
                Integer vip = r3.getVip();
                boolean z3 = vip != null && vip.intValue() == 1;
                Integer unity_engine_filter2 = r3.getUnity_engine_filter();
                int intValue = unity_engine_filter2 == null ? 0 : unity_engine_filter2.intValue();
                Integer camera_support2 = r3.getCamera_support();
                int intValue2 = camera_support2 == null ? 0 : camera_support2.intValue();
                FilterLocalDataManager filterLocalDataManager = f11912d;
                String pid2 = r3.getPid();
                boolean t = filterLocalDataManager.t(pid2 == null ? "" : pid2);
                String pid3 = r3.getPid();
                boolean u = filterLocalDataManager.u(pid3 != null ? pid3 : "");
                Integer tagContent = r3.getTagContent();
                int intValue3 = tagContent == null ? 0 : tagContent.intValue();
                Long tagOnTime = r3.getTagOnTime();
                long j2 = 0;
                long longValue = tagOnTime == null ? 0L : tagOnTime.longValue();
                Long tagOffTime = r3.getTagOffTime();
                if (tagOffTime != null) {
                    j2 = tagOffTime.longValue();
                }
                PackageItem packageItem = new PackageItem(categoryId, str, str2, str3, z3, intValue, intValue2, t, u, 0, intValue3, longValue, j2, 512, null);
                packageItem.setAfterCapture(observableBoolean);
                packageItem.setFromEdit(z);
                arrayList.add(packageItem);
            }
        }
        return arrayList;
    }

    public final void A() {
        if (f11918j) {
            return;
        }
        f11918j = true;
        kotlinx.coroutines.j.d(n0.a(z0.b()), null, null, new FilterRepository$initInnerFilter$1(null), 3, null);
    }

    public final boolean B() {
        return b;
    }

    public final boolean C() {
        return f11915g;
    }

    public final int D(String filterId) {
        FilterPackage l2;
        s.h(filterId, "filterId");
        FilterLocalDataManager filterLocalDataManager = f11912d;
        BaseFilter j2 = filterLocalDataManager.j(filterId);
        String packageId = j2 == null ? null : j2.getPackageId();
        if (packageId == null || (l2 = filterLocalDataManager.l(packageId)) == null) {
            return 0;
        }
        return l2.getVip();
    }

    public final boolean E(String filterId) {
        s.h(filterId, "filterId");
        return FilterConstants.a.g().contains(filterId);
    }

    public final boolean F(String packageId) {
        s.h(packageId, "packageId");
        return FilterConstants.a.h().contains(packageId);
    }

    public final boolean G(String packageId) {
        s.h(packageId, "packageId");
        return f11912d.u(packageId);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object H(java.lang.String r11, java.lang.String r12, kotlin.coroutines.Continuation<? super java.lang.Boolean> r13) {
        /*
            Method dump skipped, instructions count: 213
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.manager.FilterRepository.H(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void J(boolean z) {
        f11912d.z(z);
    }

    public final void L() {
        f11912d.C();
    }

    public final void M(FilterInstallManager.a aVar) {
        f11917i = aVar;
    }

    public final void N(List<String> packageIds) {
        s.h(packageIds, "packageIds");
        f11912d.D(packageIds);
    }

    public final boolean b(String filterId, boolean z) {
        s.h(filterId, "filterId");
        return f11912d.a(filterId, z);
    }

    public final void c(q listener) {
        s.h(listener, "listener");
        f11914f.q(listener);
    }

    public final void d() {
        c.b();
    }

    public final List<CategoryItem> e(ObservableBoolean isAfterCapture, boolean z, boolean z2) {
        s.h(isAfterCapture, "isAfterCapture");
        ArrayList arrayList = new ArrayList();
        String string = us.pinguo.foundation.e.b().getString(us.pinguo.repository2020.R.string.filter_collect);
        s.g(string, "getAppContext().getString(R.string.filter_collect)");
        arrayList.add(new CategoryItem("category_collect", string, false));
        List<Scene> c2 = c.c(z2);
        if (z) {
            c2 = c0.R(c2, new b());
        }
        ArrayList<Scene> arrayList2 = new ArrayList();
        Iterator<T> it = c2.iterator();
        while (true) {
            boolean z3 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            Scene scene = (Scene) next;
            if ((scene.getId() == null || TextUtils.isEmpty(scene.getName())) ? false : false) {
                arrayList2.add(next);
            }
        }
        for (Scene scene2 : arrayList2) {
            String id = scene2.getId();
            s.e(id);
            String name = scene2.getName();
            s.e(name);
            CategoryItem categoryItem = new CategoryItem(id, name, scene2.getVip() == 1);
            if (!a.q(categoryItem, isAfterCapture, z, z2).isEmpty()) {
                arrayList.add(categoryItem);
            }
        }
        return arrayList;
    }

    public final HashSet<String> f(boolean z) {
        return f11912d.d(z);
    }

    public final BaseFilter g(String filterId) {
        s.h(filterId, "filterId");
        return f11912d.j(filterId);
    }

    public final Object h(String str, String str2, Continuation<? super ChildComponent[]> continuation) {
        return f11912d.e(str, str2, continuation);
    }

    public final List<PackageItem> i(boolean z) {
        Integer unity_engine_filter;
        Integer camera_support;
        ArrayList arrayList = new ArrayList();
        for (FilterPackage filterPackage : f11912d.h()) {
            Package d2 = c.d(filterPackage.getKey());
            if (!z) {
                if (!((d2 == null || (unity_engine_filter = d2.getUnity_engine_filter()) == null || unity_engine_filter.intValue() != 0) ? false : true)) {
                    if ((d2 == null || (camera_support = d2.getCamera_support()) == null || camera_support.intValue() != 1) ? false : true) {
                    }
                }
            }
            String key = filterPackage.getKey();
            String icon = d2 == null ? null : d2.getIcon();
            if (icon == null) {
                icon = filterPackage.getIcon();
            }
            String str = icon;
            String name = filterPackage.getName();
            boolean z2 = filterPackage.getVip() == 1;
            Integer tagContent = filterPackage.getPackageBean().getTagContent();
            int intValue = tagContent == null ? 0 : tagContent.intValue();
            Long tagOnTime = filterPackage.getPackageBean().getTagOnTime();
            long longValue = tagOnTime == null ? 0L : tagOnTime.longValue();
            Long tagOffTime = filterPackage.getPackageBean().getTagOffTime();
            arrayList.add(new PackageItem("category_collect", key, str, name, z2, 0, 0, true, true, 0, intValue, longValue, tagOffTime == null ? 0L : tagOffTime.longValue(), TypedValues.MotionType.TYPE_DRAW_PATH, null));
        }
        return arrayList;
    }

    public final u<FilterEntry> j() {
        List p0;
        u<FilterEntry> uVar = f11916h;
        if (uVar.getValue() == null) {
            String j2 = o.j(o.a, "current_filter_entry", null, null, 6, null);
            if (j2 == null) {
                uVar.setValue(b ? FilterConstants.d() : FilterConstants.e());
            } else {
                p0 = StringsKt__StringsKt.p0(j2, new String[]{Effect.DIVIDER}, false, 0, 6, null);
                uVar.setValue(new FilterEntry((String) p0.get(0), (String) p0.get(1), (String) p0.get(2)));
            }
            uVar.observeForever(e.a);
        }
        return uVar;
    }

    public final Object l(String str, String str2, Continuation<? super Integer> continuation) {
        return f11912d.i(str, str2, continuation);
    }

    public final FilterItem m(String packageId, String filterId) {
        FilterPackage l2;
        int vip;
        s.h(packageId, "packageId");
        s.h(filterId, "filterId");
        if (s.c(filterId, Effect.EFFECT_FILTER_NONE_KEY)) {
            return FilterConstants.a.b();
        }
        if (s.c(filterId, Effect.EFFECT_FILTER_AUTO_KEY)) {
            return FilterConstants.a.a();
        }
        FilterLocalDataManager filterLocalDataManager = f11912d;
        BaseFilter j2 = filterLocalDataManager.j(filterId);
        FilterItem filterItem = null;
        if (j2 == null || (l2 = filterLocalDataManager.l(packageId)) == null) {
            return null;
        }
        if (s.c(packageId, "collect_filter_package")) {
            vip = D(filterId);
        } else {
            Package d2 = c.d(l2.getKey());
            Integer vip2 = d2 == null ? null : d2.getVip();
            vip = vip2 == null ? l2.getVip() : vip2.intValue();
        }
        if (j2.getPackageId() != null && j2.getFilterId() != null) {
            String packageId2 = j2.getPackageId();
            s.e(packageId2);
            String filterId2 = j2.getFilterId();
            s.e(filterId2);
            String filterIcon = j2.getFilterIcon();
            String name = j2.getName();
            boolean isCollect = j2.isCollect();
            boolean z = vip == 1;
            int unity_engine_filter = j2.getUnity_engine_filter();
            int camera_support = j2.getCamera_support();
            int enableGesture = j2.getEnableGesture();
            Integer tagContent = l2.getPackageBean().getTagContent();
            int intValue = tagContent == null ? 0 : tagContent.intValue();
            Long tagOnTime = l2.getPackageBean().getTagOnTime();
            long longValue = tagOnTime == null ? 0L : tagOnTime.longValue();
            Long tagOffTime = l2.getPackageBean().getTagOffTime();
            filterItem = new FilterItem(packageId2, filterId2, filterIcon, name, isCollect, z, unity_engine_filter, camera_support, enableGesture, intValue, longValue, tagOffTime == null ? 0L : tagOffTime.longValue());
        }
        return filterItem;
    }

    public final String n(String packagePath, String filterId) {
        s.h(packagePath, "packagePath");
        s.h(filterId, "filterId");
        return f11912d.k(packagePath, filterId);
    }

    public final String o(String filterId) {
        s.h(filterId, "filterId");
        BaseFilter j2 = f11912d.j(filterId);
        if (j2 == null) {
            return null;
        }
        return j2.getPackageId();
    }

    public final Object p(String str, Continuation<? super String> continuation) {
        return f11912d.m(str);
    }

    public final FilterParamsTable r(String filterId) {
        s.h(filterId, "filterId");
        return f11912d.n(filterId);
    }

    public final FilterPackage s(String str) {
        if (str == null) {
            return null;
        }
        return f11912d.l(str);
    }

    public final List<String> t() {
        return f11912d.q();
    }

    public final int u(String str) {
        Integer unity_engine_filter;
        if (str == null) {
            return 0;
        }
        Package d2 = c.d(str);
        if (d2 != null) {
            Integer unity_engine_filter2 = d2.getUnity_engine_filter();
            if (unity_engine_filter2 == null) {
                return 0;
            }
            return unity_engine_filter2.intValue();
        }
        FilterPackage l2 = f11912d.l(str);
        if (l2 == null || (unity_engine_filter = l2.getUnity_engine_filter()) == null) {
            return 0;
        }
        return unity_engine_filter.intValue();
    }

    public final FilterInstallManager.a v() {
        return f11917i;
    }

    public final List<FilterItem> w(String packageId) {
        int o;
        int intValue;
        s.h(packageId, "packageId");
        FilterPackage l2 = f11912d.l(packageId);
        if (l2 == null) {
            return null;
        }
        List<BaseFilter> filters = l2.getFilters(new FilterConstants.FilterType[0]);
        ArrayList<BaseFilter> arrayList = new ArrayList();
        Iterator<T> it = filters.iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            BaseFilter baseFilter = (BaseFilter) next;
            if ((baseFilter.getPackageId() == null || baseFilter.getFilterId() == null) ? false : false) {
                arrayList.add(next);
            }
        }
        o = v.o(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(o);
        for (BaseFilter baseFilter2 : arrayList) {
            Package d2 = c.d(l2.getKey());
            Integer vip = d2 == null ? null : d2.getVip();
            if (vip == null) {
                intValue = l2.getVip();
            } else {
                intValue = vip.intValue();
            }
            String packageId2 = baseFilter2.getPackageId();
            s.e(packageId2);
            String filterId = baseFilter2.getFilterId();
            s.e(filterId);
            String filterIcon = baseFilter2.getFilterIcon();
            String name = baseFilter2.getName();
            boolean isCollect = baseFilter2.isCollect();
            boolean z2 = intValue == 1;
            int unity_engine_filter = baseFilter2.getUnity_engine_filter();
            int camera_support = baseFilter2.getCamera_support();
            int enableGesture = baseFilter2.getEnableGesture();
            Integer tagContent = l2.getPackageBean().getTagContent();
            int intValue2 = tagContent == null ? 0 : tagContent.intValue();
            Long tagOnTime = l2.getPackageBean().getTagOnTime();
            long j2 = 0;
            long longValue = tagOnTime == null ? 0L : tagOnTime.longValue();
            Long tagOffTime = l2.getPackageBean().getTagOffTime();
            if (tagOffTime != null) {
                j2 = tagOffTime.longValue();
            }
            arrayList2.add(new FilterItem(packageId2, filterId, filterIcon, name, isCollect, z2, unity_engine_filter, camera_support, enableGesture, intValue2, longValue, j2));
        }
        return arrayList2;
    }

    public final List<PackageItem> x(List<CategoryItem> categoryList, ObservableBoolean isAfterCapture, boolean z, boolean z2) {
        s.h(categoryList, "categoryList");
        s.h(isAfterCapture, "isAfterCapture");
        ArrayList arrayList = new ArrayList();
        for (CategoryItem categoryItem : categoryList) {
            arrayList.addAll(a.q(categoryItem, isAfterCapture, z, z2));
        }
        return arrayList;
    }

    public final Object y(String str, Continuation<? super SkyEffect[]> continuation) {
        return f11912d.r(str, continuation);
    }

    public final Object z(String str, Continuation<? super UnityFilterItemTemplateIndex> continuation) {
        return f11912d.s(str, continuation);
    }
}
