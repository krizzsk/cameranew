package us.pinguo.camera360.shop.data;

import com.pinguo.camera360.effect.model.entity.type.Filter;
import com.pinguo.camera360.sticker.StickerItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import us.pinguo.librouter.application.BaseApplication;
import us.pinguo.repository2020.database.filter.FilterItemTable;
import us.pinguo.repository2020.database.filter.FilterPackageTable;
import us.pinguo.repository2020.database.filter.FilterParamsTable;
import us.pinguo.repository2020.manager.FilterInstallManager;
import us.pinguo.repository2020.manager.FilterRepository;
import vStudio.Android.Camera360.R;
/* compiled from: FilterReadManager.java */
/* loaded from: classes2.dex */
public class i {

    /* renamed from: d  reason: collision with root package name */
    private static final i f9595d = new i();
    private HashMap<String, h> a = null;
    private HashMap<String, g> b = null;
    private HashMap<String, g> c = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FilterReadManager.java */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[FilterType.values().length];
            a = iArr;
            try {
                iArr[FilterType.Loc.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[FilterType.Effect.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[FilterType.Scene.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[FilterType.Sticker.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        new HashMap();
    }

    private i() {
        FilterRepository.a.M(new FilterInstallManager.a() { // from class: us.pinguo.camera360.shop.data.f
            @Override // us.pinguo.repository2020.manager.FilterInstallManager.a
            public final void a() {
                i.this.u();
            }
        });
    }

    private void a() {
    }

    private synchronized void b() {
        if (this.a == null || this.b == null || this.c == null) {
            r();
        }
    }

    private h d() {
        h hVar = new h(new FilterPackageTable("category_collect", "collect_filter_package", BaseApplication.d().getString(R.string.filter_collect), null, null, "assets://builtin_data/filters/favorite.png", 0L, null, null, 0, 0, 1, 0, 0L, 0L, null, null, null, null));
        hVar.l(h());
        return hVar;
    }

    public static i e() {
        return f9595d;
    }

    private List<g> h() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (g gVar : this.b.values()) {
            if (gVar.isCollect()) {
                arrayList2.add(gVar);
            }
        }
        Collections.sort(arrayList2, d.a);
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int m(g gVar, g gVar2) {
        int i2 = ((gVar.getCollectTime() - gVar2.getCollectTime()) > 0L ? 1 : ((gVar.getCollectTime() - gVar2.getCollectTime()) == 0L ? 0 : -1));
        if (i2 > 0) {
            return -1;
        }
        return i2 < 0 ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int n(g gVar, g gVar2) {
        int i2 = ((gVar.getCollectTime() - gVar2.getCollectTime()) > 0L ? 1 : ((gVar.getCollectTime() - gVar2.getCollectTime()) == 0L ? 0 : -1));
        if (i2 > 0) {
            return -1;
        }
        return i2 < 0 ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int o(h hVar, h hVar2) {
        int i2 = ((hVar.i().getSort() - hVar2.i().getSort()) > 0L ? 1 : ((hVar.i().getSort() - hVar2.i().getSort()) == 0L ? 0 : -1));
        if (i2 > 0) {
            return -1;
        }
        return i2 == 0 ? 0 : 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int p(FilterParamsTable filterParamsTable, FilterParamsTable filterParamsTable2) {
        int i2 = ((((filterParamsTable == null || filterParamsTable.getVersion() == null) ? 0 : filterParamsTable.getVersion().intValue()) - ((filterParamsTable2 == null || filterParamsTable2.getVersion() == null) ? 0 : filterParamsTable2.getVersion().intValue())) > 0L ? 1 : ((((filterParamsTable == null || filterParamsTable.getVersion() == null) ? 0 : filterParamsTable.getVersion().intValue()) - ((filterParamsTable2 == null || filterParamsTable2.getVersion() == null) ? 0 : filterParamsTable2.getVersion().intValue())) == 0L ? 0 : -1));
        if (i2 > 0) {
            return 1;
        }
        return i2 == 0 ? 0 : -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int q(g gVar, g gVar2) {
        int i2 = ((gVar.getSortInPackage() - gVar2.getSortInPackage()) > 0L ? 1 : ((gVar.getSortInPackage() - gVar2.getSortInPackage()) == 0L ? 0 : -1));
        if (i2 > 0) {
            return 1;
        }
        return i2 == 0 ? 0 : -1;
    }

    private synchronized void r() {
        this.b = new HashMap<>();
        this.a = new HashMap<>();
        this.c = new HashMap<>();
        a();
        List<FilterPackageTable> a2 = us.pinguo.repository2020.database.a.a.x().a();
        List<FilterItemTable> a3 = us.pinguo.repository2020.database.a.a.w().a();
        List<FilterParamsTable> a4 = us.pinguo.repository2020.database.a.a.y().a();
        for (FilterPackageTable filterPackageTable : a2) {
            h hVar = new h(filterPackageTable);
            this.a.put(filterPackageTable.getId(), hVar);
            ArrayList arrayList = new ArrayList();
            hVar.l(arrayList);
            for (FilterItemTable filterItemTable : a3) {
                if (filterItemTable.getPackageId().equals(hVar.f())) {
                    int i2 = a.a[FilterType.getFliterTypeBySubt(filterItemTable.getType()).ordinal()];
                    if (i2 == 1 || i2 == 2) {
                        ArrayList arrayList2 = new ArrayList();
                        Filter filter = new Filter(filterItemTable, arrayList2);
                        arrayList.add(filter);
                        for (FilterParamsTable filterParamsTable : a4) {
                            if (filterParamsTable.getId().equals(filterItemTable.getId()) && filterParamsTable.getPackageId().equals(filterItemTable.getPackageId())) {
                                arrayList2.add(filterParamsTable);
                            }
                        }
                        Collections.sort(arrayList2, c.a);
                        this.b.put(filter.getFilterId(), filter);
                        this.c.put(filter.getKey(), filter);
                    } else if (i2 == 4) {
                        StickerItem stickerItem = new StickerItem(filterItemTable);
                        this.b.put(stickerItem.getFilterId(), stickerItem);
                        arrayList.add(stickerItem);
                    }
                }
            }
            Collections.sort(arrayList, e.a);
        }
        h d2 = d();
        this.a.put(d2.f(), d2);
        t();
    }

    private void t() {
        List<g> i2 = i();
        List<h> l2 = l(FilterType.Effect);
        if (i2 != null) {
            us.pinguo.foundation.base.e.f(BaseApplication.d(), "filter_fav", i2.size());
        }
        if (l2 != null) {
            us.pinguo.foundation.base.e.f(BaseApplication.d(), "filter_installed", l2.size());
        }
    }

    private List<FilterItemTable> v(String str, boolean z, long j2) {
        List<g> c;
        ArrayList arrayList = new ArrayList();
        for (h hVar : this.a.values()) {
            if (!hVar.f().equals("collect_filter_package") && (c = hVar.c(FilterType.Combin)) != null) {
                for (g gVar : c) {
                    if (gVar.getFilterId().equals(str)) {
                        gVar.collect(z);
                        if (z) {
                            gVar.setCollectTime(j2);
                        }
                        arrayList.add(gVar.getItemBean());
                        w(z, gVar);
                    }
                }
            }
        }
        return arrayList;
    }

    private void w(boolean z, g gVar) {
        HashMap<String, h> hashMap = this.a;
        if (hashMap == null) {
            return;
        }
        List<g> c = hashMap.get("collect_filter_package").c(FilterType.Combin);
        if (z) {
            if (c.contains(gVar)) {
                return;
            }
            c.add(2, gVar);
        } else if (c.contains(gVar)) {
            c.remove(gVar);
        }
    }

    public boolean c(boolean z, g gVar) {
        if (z || g().size() > 0) {
            b();
            long currentTimeMillis = System.currentTimeMillis();
            gVar.collect(z);
            if (z) {
                gVar.setCollectTime(currentTimeMillis);
            }
            us.pinguo.repository2020.database.a.a.w().f(v(gVar.getFilterId(), z, currentTimeMillis));
            return true;
        }
        return false;
    }

    public List<h> f(FilterType... filterTypeArr) {
        List<g> c;
        b();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, h> entry : this.a.entrySet()) {
            h value = entry.getValue();
            if (value.j() && !value.f().equals("collect_filter_package") && (c = value.c(filterTypeArr)) != null && c.size() > 0) {
                h hVar = new h(value.i());
                hVar.l(c);
                arrayList.add(hVar);
            }
        }
        j.a(arrayList);
        return arrayList;
    }

    public List<g> g() {
        ArrayList arrayList = new ArrayList();
        for (g gVar : this.b.values()) {
            if (gVar.isCollect()) {
                arrayList.add(gVar);
            }
        }
        Collections.sort(arrayList, us.pinguo.camera360.shop.data.a.a);
        return new ArrayList(arrayList);
    }

    public List<g> i() {
        FilterType filterType = FilterType.Combin;
        List<g> c = k("collect_filter_package", filterType).c(filterType);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(c);
        return arrayList;
    }

    public g j(String str) {
        b();
        HashMap<String, g> hashMap = this.b;
        if (hashMap == null) {
            return null;
        }
        return hashMap.get(str);
    }

    public h k(String str, FilterType... filterTypeArr) {
        h hVar;
        b();
        HashMap<String, h> hashMap = this.a;
        if (hashMap == null || (hVar = hashMap.get(str)) == null) {
            return null;
        }
        return hVar.b(filterTypeArr);
    }

    public List<h> l(FilterType... filterTypeArr) {
        List<g> c;
        b();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, h> entry : this.a.entrySet()) {
            h value = entry.getValue();
            if (!value.f().equals("collect_filter_package") && (c = value.c(filterTypeArr)) != null && c.size() > 0) {
                h hVar = new h(value.i());
                hVar.l(c);
                arrayList.add(hVar);
            }
        }
        Collections.sort(arrayList, b.a);
        return arrayList;
    }

    public void s() {
        r();
    }

    public synchronized void u() {
        this.a = null;
        this.b = null;
        this.c = null;
    }
}
