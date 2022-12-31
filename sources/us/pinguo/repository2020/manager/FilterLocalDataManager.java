package us.pinguo.repository2020.manager;

import android.util.LruCache;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.collections.c0;
import kotlin.collections.y;
import kotlin.jvm.internal.s;
import us.pinguo.repository2020.FilterConstants;
import us.pinguo.repository2020.database.filter.FilterParamsTable;
import us.pinguo.repository2020.entity.BaseFilter;
import us.pinguo.repository2020.entity.FilterPackage;
/* compiled from: FilterLocalDataManager.kt */
/* loaded from: classes6.dex */
public final class FilterLocalDataManager {
    private final HashMap<String, FilterPackage> a = new HashMap<>();
    private final HashMap<String, BaseFilter> b = new HashMap<>();
    private ArrayList<BaseFilter> c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<FilterPackage> f11906d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    private final HashMap<String, FilterParamsTable> f11907e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    private final HashSet<String> f11908f = new HashSet<>();

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<String> f11909g = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    private LruCache<String, Integer> f11910h = new LruCache<>(64);

    /* compiled from: FilterLocalDataManager.kt */
    /* loaded from: classes6.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[FilterConstants.FilterType.values().length];
            iArr[FilterConstants.FilterType.Loc.ordinal()] = 1;
            iArr[FilterConstants.FilterType.Effect.ordinal()] = 2;
            a = iArr;
        }
    }

    /* compiled from: Comparisons.kt */
    /* loaded from: classes6.dex */
    public static final class b<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int a;
            a = kotlin.w.b.a(Integer.valueOf(((BaseFilter) t).getSortInPackage()), Integer.valueOf(((BaseFilter) t2).getSortInPackage()));
            return a;
        }
    }

    /* compiled from: Comparisons.kt */
    /* loaded from: classes6.dex */
    public static final class c<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int a;
            a = kotlin.w.b.a(Long.valueOf(((FilterPackage) t2).getMaxCollectTime()), Long.valueOf(((FilterPackage) t).getMaxCollectTime()));
            return a;
        }
    }

    public static /* synthetic */ void A(FilterLocalDataManager filterLocalDataManager, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        filterLocalDataManager.z(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int B(FilterParamsTable filterParamsTable, FilterParamsTable filterParamsTable2) {
        int intValue;
        Integer version = filterParamsTable.getVersion();
        if (version == null) {
            Integer version2 = filterParamsTable2.getVersion();
            intValue = 0 - (version2 == null ? 0 : version2.intValue());
        } else {
            intValue = version.intValue();
        }
        int i2 = (intValue > 0L ? 1 : (intValue == 0L ? 0 : -1));
        if (i2 > 0) {
            return 1;
        }
        return i2 == 0 ? 0 : -1;
    }

    private final void E() {
        FilterPackage filterPackage;
        this.c.clear();
        this.c.addAll(f());
        this.f11906d.clear();
        for (BaseFilter baseFilter : this.c) {
            if (this.a.containsKey(baseFilter.getPackageId()) && (filterPackage = this.a.get(baseFilter.getPackageId())) != null && !this.f11906d.contains(filterPackage)) {
                this.f11906d.add(filterPackage);
            }
        }
        for (FilterPackage filterPackage2 : this.f11906d) {
            List<BaseFilter> filters = filterPackage2.getFilters(new FilterConstants.FilterType[0]);
            ArrayList arrayList = new ArrayList();
            for (Object obj : filters) {
                if (((BaseFilter) obj).isCollect()) {
                    arrayList.add(obj);
                }
            }
            Iterator it = arrayList.iterator();
            if (it.hasNext()) {
                long collectTime = ((BaseFilter) it.next()).getCollectTime();
                while (it.hasNext()) {
                    long collectTime2 = ((BaseFilter) it.next()).getCollectTime();
                    if (collectTime < collectTime2) {
                        collectTime = collectTime2;
                    }
                }
                filterPackage2.setMaxCollectTime(collectTime);
            } else {
                throw new NoSuchElementException();
            }
        }
        ArrayList<FilterPackage> arrayList2 = this.f11906d;
        if (arrayList2.size() > 1) {
            y.p(arrayList2, new c());
        }
    }

    private final synchronized void b(boolean z) {
        if (this.a.isEmpty() || this.b.isEmpty() || this.f11907e.isEmpty() || z) {
            A(this, false, 1, null);
        }
    }

    static /* synthetic */ void c(FilterLocalDataManager filterLocalDataManager, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        filterLocalDataManager.b(z);
    }

    private final List<BaseFilter> f() {
        List<BaseFilter> R;
        Collection<BaseFilter> values = this.b.values();
        s.g(values, "filterMap.values");
        ArrayList arrayList = new ArrayList();
        for (Object obj : values) {
            if (((BaseFilter) obj).isCollect()) {
                arrayList.add(obj);
            }
        }
        R = c0.R(arrayList, us.pinguo.repository2020.manager.b.a);
        return R;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int g(BaseFilter baseFilter, BaseFilter baseFilter2) {
        int i2 = ((baseFilter.getCollectTime() - baseFilter2.getCollectTime()) > 0L ? 1 : ((baseFilter.getCollectTime() - baseFilter2.getCollectTime()) == 0L ? 0 : -1));
        if (i2 > 0) {
            return -1;
        }
        return i2 == 0 ? 0 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int p(FilterPackage filterPackage, FilterPackage filterPackage2) {
        int i2 = ((filterPackage.getPackageBean().getSort() - filterPackage2.getPackageBean().getSort()) > 0L ? 1 : ((filterPackage.getPackageBean().getSort() - filterPackage2.getPackageBean().getSort()) == 0L ? 0 : -1));
        if (i2 > 0) {
            return -1;
        }
        return i2 == 0 ? 0 : 1;
    }

    public final void C() {
        Collection<BaseFilter> values = this.b.values();
        s.g(values, "filterMap.values");
        for (BaseFilter baseFilter : values) {
            baseFilter.setOpacityOnlyMemory(-1);
        }
    }

    public final void D(List<String> packageIds) {
        s.h(packageIds, "packageIds");
        for (String str : packageIds) {
            this.a.remove(str);
        }
    }

    public final boolean a(String filterId, boolean z) {
        s.h(filterId, "filterId");
        Object obj = null;
        c(this, false, 1, null);
        long currentTimeMillis = System.currentTimeMillis();
        Collection<BaseFilter> values = this.b.values();
        s.g(values, "filterMap.values");
        Iterator<T> it = values.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (s.c(((BaseFilter) next).getFilterId(), filterId)) {
                obj = next;
                break;
            }
        }
        BaseFilter baseFilter = (BaseFilter) obj;
        if (baseFilter != null) {
            if (z) {
                baseFilter.setCollectTime(currentTimeMillis);
            }
            baseFilter.collect(z);
            us.pinguo.repository2020.database.a.a().w().e(baseFilter.getItemBean());
        }
        E();
        return true;
    }

    public final HashSet<String> d(boolean z) {
        b(z);
        return this.f11908f;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(java.lang.String r6, java.lang.String r7, kotlin.coroutines.Continuation<? super us.pinguo.repository2020.entity.ChildComponent[]> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof us.pinguo.repository2020.manager.FilterLocalDataManager$getChildComponents$1
            if (r0 == 0) goto L13
            r0 = r8
            us.pinguo.repository2020.manager.FilterLocalDataManager$getChildComponents$1 r0 = (us.pinguo.repository2020.manager.FilterLocalDataManager$getChildComponents$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.repository2020.manager.FilterLocalDataManager$getChildComponents$1 r0 = new us.pinguo.repository2020.manager.FilterLocalDataManager$getChildComponents$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L32
            if (r2 != r4) goto L2a
            kotlin.j.b(r8)
            goto L4b
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L32:
            kotlin.j.b(r8)
            java.lang.String r6 = r5.k(r6, r7)
            if (r6 != 0) goto L3c
            goto L4f
        L3c:
            java.lang.String r7 = "/index.json"
            java.lang.String r6 = kotlin.jvm.internal.s.q(r6, r7)
            r0.label = r4
            java.lang.Object r8 = us.pinguo.util.FileIOUtils.g(r6, r0)
            if (r8 != r1) goto L4b
            return r1
        L4b:
            java.lang.String r8 = (java.lang.String) r8
            if (r8 != 0) goto L50
        L4f:
            return r3
        L50:
            com.google.gson.e r6 = com.pinguo.lib.GsonUtilKt.getCachedGson()
            java.lang.Class<us.pinguo.repository2020.entity.UnityFilterItemIndex> r7 = us.pinguo.repository2020.entity.UnityFilterItemIndex.class
            java.lang.Object r6 = r6.j(r8, r7)
            us.pinguo.repository2020.entity.UnityFilterItemIndex r6 = (us.pinguo.repository2020.entity.UnityFilterItemIndex) r6
            if (r6 != 0) goto L5f
            goto L63
        L5f:
            us.pinguo.repository2020.entity.ChildComponent[] r3 = r6.getChildComponents()
        L63:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.manager.FilterLocalDataManager.e(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final List<FilterPackage> h() {
        b(true);
        return this.f11906d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00cb  */
    /* JADX WARN: Type inference failed for: r13v20, types: [T, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r2v2, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v4, types: [T, java.lang.Integer] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(java.lang.String r11, java.lang.String r12, kotlin.coroutines.Continuation<? super java.lang.Integer> r13) {
        /*
            Method dump skipped, instructions count: 257
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.manager.FilterLocalDataManager.i(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final BaseFilter j(String filterId) {
        s.h(filterId, "filterId");
        c(this, false, 1, null);
        return this.b.get(filterId);
    }

    public final String k(String packagePath, String filterId) {
        s.h(packagePath, "packagePath");
        s.h(filterId, "filterId");
        return s.q(packagePath, filterId);
    }

    public final FilterPackage l(String packageId) {
        s.h(packageId, "packageId");
        c(this, false, 1, null);
        return this.a.get(packageId);
    }

    public final String m(String pkgId) {
        String packageMd5;
        s.h(pkgId, "pkgId");
        FilterPackage l2 = l(pkgId);
        if (l2 == null || (packageMd5 = l2.getPackageBean().getPackageMd5()) == null) {
            return null;
        }
        return us.pinguo.common.filter.util.a.a.d(packageMd5);
    }

    public final FilterParamsTable n(String filterId) {
        s.h(filterId, "filterId");
        c(this, false, 1, null);
        return this.f11907e.get(filterId);
    }

    public final List<FilterPackage> o() {
        c(this, false, 1, null);
        ArrayList arrayList = new ArrayList();
        Set<Map.Entry<String, FilterPackage>> entrySet = this.a.entrySet();
        s.g(entrySet, "packageMap.entries");
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            arrayList.add(((Map.Entry) it.next()).getValue());
        }
        y.p(arrayList, d.a);
        return arrayList;
    }

    public final List<String> q() {
        return this.f11909g;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object r(java.lang.String r5, kotlin.coroutines.Continuation<? super us.pinguo.repository2020.entity.SkyEffect[]> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof us.pinguo.repository2020.manager.FilterLocalDataManager$getSkyChangeParam$1
            if (r0 == 0) goto L13
            r0 = r6
            us.pinguo.repository2020.manager.FilterLocalDataManager$getSkyChangeParam$1 r0 = (us.pinguo.repository2020.manager.FilterLocalDataManager$getSkyChangeParam$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.repository2020.manager.FilterLocalDataManager$getSkyChangeParam$1 r0 = new us.pinguo.repository2020.manager.FilterLocalDataManager$getSkyChangeParam$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.j.b(r6)
            goto L3d
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.j.b(r6)
            r0.label = r3
            java.lang.Object r6 = us.pinguo.util.FileIOUtils.g(r5, r0)
            if (r6 != r1) goto L3d
            return r1
        L3d:
            java.lang.String r6 = (java.lang.String) r6
            r5 = 0
            if (r6 != 0) goto L43
            return r5
        L43:
            com.google.gson.e r0 = com.pinguo.lib.GsonUtilKt.getCachedGson()
            java.lang.Class<us.pinguo.repository2020.entity.UnityFilterItemSkyChangeIndex> r1 = us.pinguo.repository2020.entity.UnityFilterItemSkyChangeIndex.class
            java.lang.Object r6 = r0.j(r6, r1)
            us.pinguo.repository2020.entity.UnityFilterItemSkyChangeIndex r6 = (us.pinguo.repository2020.entity.UnityFilterItemSkyChangeIndex) r6
            if (r6 != 0) goto L52
            goto L56
        L52:
            us.pinguo.repository2020.entity.SkyEffect[] r5 = r6.getEffectList()
        L56:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.manager.FilterLocalDataManager.r(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0041 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object s(java.lang.String r5, kotlin.coroutines.Continuation<? super us.pinguo.repository2020.entity.UnityFilterItemTemplateIndex> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof us.pinguo.repository2020.manager.FilterLocalDataManager$getTemplateParam$1
            if (r0 == 0) goto L13
            r0 = r6
            us.pinguo.repository2020.manager.FilterLocalDataManager$getTemplateParam$1 r0 = (us.pinguo.repository2020.manager.FilterLocalDataManager$getTemplateParam$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.repository2020.manager.FilterLocalDataManager$getTemplateParam$1 r0 = new us.pinguo.repository2020.manager.FilterLocalDataManager$getTemplateParam$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.j.b(r6)
            goto L3d
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.j.b(r6)
            r0.label = r3
            java.lang.Object r6 = us.pinguo.util.FileIOUtils.g(r5, r0)
            if (r6 != r1) goto L3d
            return r1
        L3d:
            java.lang.String r6 = (java.lang.String) r6
            if (r6 != 0) goto L43
            r5 = 0
            return r5
        L43:
            com.google.gson.e r5 = com.pinguo.lib.GsonUtilKt.getCachedGson()
            java.lang.Class<us.pinguo.repository2020.entity.UnityFilterItemTemplateIndex> r0 = us.pinguo.repository2020.entity.UnityFilterItemTemplateIndex.class
            java.lang.Object r5 = r5.j(r6, r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.manager.FilterLocalDataManager.s(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final boolean t(String packageId) {
        s.h(packageId, "packageId");
        Object obj = null;
        c(this, false, 1, null);
        Iterator<T> it = this.f11906d.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (s.c(((FilterPackage) next).getKey(), packageId)) {
                obj = next;
                break;
            }
        }
        return obj != null;
    }

    public final boolean u(String packageId) {
        s.h(packageId, "packageId");
        b(false);
        return this.a.get(packageId) != null;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object v(java.lang.String r5, kotlin.coroutines.Continuation<? super java.lang.Boolean> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof us.pinguo.repository2020.manager.FilterLocalDataManager$isSkyChangeAdjustVisible$1
            if (r0 == 0) goto L13
            r0 = r6
            us.pinguo.repository2020.manager.FilterLocalDataManager$isSkyChangeAdjustVisible$1 r0 = (us.pinguo.repository2020.manager.FilterLocalDataManager$isSkyChangeAdjustVisible$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.repository2020.manager.FilterLocalDataManager$isSkyChangeAdjustVisible$1 r0 = new us.pinguo.repository2020.manager.FilterLocalDataManager$isSkyChangeAdjustVisible$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.j.b(r6)
            goto L3d
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.j.b(r6)
            r0.label = r3
            java.lang.Object r6 = us.pinguo.util.FileIOUtils.g(r5, r0)
            if (r6 != r1) goto L3d
            return r1
        L3d:
            java.lang.String r6 = (java.lang.String) r6
            r5 = 0
            if (r6 != 0) goto L47
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            return r5
        L47:
            com.google.gson.e r0 = com.pinguo.lib.GsonUtilKt.getCachedGson()
            java.lang.Class<us.pinguo.repository2020.entity.UnityFilterItemSkyChangeIndex> r1 = us.pinguo.repository2020.entity.UnityFilterItemSkyChangeIndex.class
            java.lang.Object r6 = r0.j(r6, r1)
            us.pinguo.repository2020.entity.UnityFilterItemSkyChangeIndex r6 = (us.pinguo.repository2020.entity.UnityFilterItemSkyChangeIndex) r6
            if (r6 != 0) goto L57
        L55:
            r3 = 0
            goto L64
        L57:
            java.lang.Integer r6 = r6.getRenderOrder()
            if (r6 != 0) goto L5e
            goto L55
        L5e:
            int r6 = r6.intValue()
            if (r6 != 0) goto L55
        L64:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.manager.FilterLocalDataManager.v(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0134, code lost:
        if ((r10 != null && r10.getTemplateOpacity() == r13.getTemplateOpacity()) == false) goto L98;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void z(boolean r17) {
        /*
            Method dump skipped, instructions count: 487
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.manager.FilterLocalDataManager.z(boolean):void");
    }
}
