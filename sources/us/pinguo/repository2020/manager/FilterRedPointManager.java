package us.pinguo.repository2020.manager;

import com.pinguo.camera360.effect.model.entity.Effect;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.c0;
import kotlin.jvm.internal.s;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.z0;
import us.pinguo.repository2020.entity.Package;
import us.pinguo.repository2020.entity.Scene;
import us.pinguo.repository2020.p;
import us.pinguo.repository2020.t;
import us.pinguo.repository2020.utils.o;
/* compiled from: FilterRedPointManager.kt */
/* loaded from: classes6.dex */
public final class FilterRedPointManager implements t.a {
    public static final FilterRedPointManager a;
    private static final CopyOnWriteArrayList<String> b;
    private static final CopyOnWriteArrayList<String> c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f11911d;

    static {
        FilterRedPointManager filterRedPointManager = new FilterRedPointManager();
        a = filterRedPointManager;
        b = new CopyOnWriteArrayList<>();
        c = new CopyOnWriteArrayList<>();
        f11911d = o.a.a("sp_key_init_first_server_data", false, "filterRedPointManagerFile");
        filterRedPointManager.j();
        t.a.a(filterRedPointManager);
    }

    private FilterRedPointManager() {
    }

    private final void f(List<Scene> list, List<Package> list2) {
        String str;
        boolean z;
        String pid;
        List<String> g2 = g();
        if (g2 == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Package r3 : list2) {
            z = c0.z(g2, r3.getPid());
            if (!z && (pid = r3.getPid()) != null) {
                arrayList.add(pid);
            }
        }
        if (!arrayList.isEmpty()) {
            for (Scene scene : list) {
                String[] products_in_camera = scene.getProducts_in_camera();
                if (products_in_camera != null) {
                    int i2 = 0;
                    int length = products_in_camera.length;
                    while (true) {
                        if (i2 >= length) {
                            str = null;
                            break;
                        }
                        str = products_in_camera[i2];
                        i2++;
                        if (arrayList.contains(str)) {
                            break;
                        }
                    }
                    if (str != null) {
                        b.remove(scene.getId());
                    }
                }
            }
            o();
            n(list2);
        }
    }

    private final List<String> g() {
        List<String> p0;
        String i2 = o.a.i("sp_key_local_all_package_id_list", null, "filterRedPointManagerFile");
        if (i2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        p0 = StringsKt__StringsKt.p0(i2, new String[]{Effect.DIVIDER}, false, 0, 6, null);
        for (String str : p0) {
            arrayList.add(str);
        }
        return arrayList;
    }

    private final void j() {
        kotlinx.coroutines.j.d(n0.a(z0.a()), null, null, new FilterRedPointManager$initLocalToMemory$1(null), 3, null);
    }

    private final void n(List<Package> list) {
        String i0;
        String str = "";
        for (Package r1 : list) {
            str = s.q(s.q(str, r1.getPid()), Effect.DIVIDER);
        }
        o oVar = o.a;
        i0 = StringsKt__StringsKt.i0(str, Effect.DIVIDER);
        oVar.u("sp_key_local_all_package_id_list", i0, "filterRedPointManagerFile");
    }

    private final void o() {
        String i0;
        String str = "";
        for (String str2 : b) {
            str = s.q(s.q(str, str2), Effect.DIVIDER);
        }
        o oVar = o.a;
        i0 = StringsKt__StringsKt.i0(str, Effect.DIVIDER);
        oVar.u("sp_key_local_category", i0, "filterRedPointManagerFile");
    }

    private final void p() {
        String i0;
        String str = "";
        for (String str2 : c) {
            str = s.q(s.q(str, str2), Effect.DIVIDER);
        }
        o oVar = o.a;
        i0 = StringsKt__StringsKt.i0(str, Effect.DIVIDER);
        oVar.u("sp_key_local_package", i0, "filterRedPointManagerFile");
    }

    @Override // us.pinguo.repository2020.t.a
    public void a(String categoryId) {
        s.h(categoryId, "categoryId");
        CopyOnWriteArrayList<String> copyOnWriteArrayList = b;
        if (copyOnWriteArrayList.contains(categoryId)) {
            return;
        }
        copyOnWriteArrayList.add(categoryId);
        o();
    }

    @Override // us.pinguo.repository2020.t.a
    public void b(String packageId) {
        s.h(packageId, "packageId");
        CopyOnWriteArrayList<String> copyOnWriteArrayList = c;
        if (copyOnWriteArrayList.contains(packageId)) {
            return;
        }
        copyOnWriteArrayList.add(packageId);
        p();
    }

    public final boolean h(String str) {
        if (f11911d && !s.c(str, "category_collect")) {
            CopyOnWriteArrayList<String> copyOnWriteArrayList = b;
            return (copyOnWriteArrayList.isEmpty() ^ true) && !copyOnWriteArrayList.contains(str);
        }
        return false;
    }

    public final boolean i(String str) {
        if (!f11911d || p.a.b().containsKey(str) || s.c(str, "collect_filter_package")) {
            return false;
        }
        CopyOnWriteArrayList<String> copyOnWriteArrayList = c;
        return (copyOnWriteArrayList.isEmpty() ^ true) && !copyOnWriteArrayList.contains(str);
    }

    public final void k(String categoryId) {
        s.h(categoryId, "categoryId");
        a(categoryId);
        t.a.b(this, categoryId);
    }

    public final void l(String packageId) {
        s.h(packageId, "packageId");
        b(packageId);
        t.a.c(this, packageId);
    }

    public final void m(List<Scene> categories, List<Package> packages) {
        s.h(categories, "categories");
        s.h(packages, "packages");
        if (f11911d) {
            f(categories, packages);
            return;
        }
        ArrayList<Scene> arrayList = new ArrayList();
        Iterator<T> it = categories.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((Scene) next).getId() != null) {
                arrayList.add(next);
            }
        }
        for (Scene scene : arrayList) {
            CopyOnWriteArrayList<String> copyOnWriteArrayList = b;
            String id = scene.getId();
            s.e(id);
            copyOnWriteArrayList.add(id);
        }
        ArrayList<Package> arrayList2 = new ArrayList();
        for (Object obj : packages) {
            if (((Package) obj).getPid() != null) {
                arrayList2.add(obj);
            }
        }
        for (Package r0 : arrayList2) {
            CopyOnWriteArrayList<String> copyOnWriteArrayList2 = c;
            String pid = r0.getPid();
            s.e(pid);
            copyOnWriteArrayList2.add(pid);
        }
        o();
        p();
        n(packages);
        f11911d = true;
        o.a.m("sp_key_init_first_server_data", f11911d, "filterRedPointManagerFile");
    }
}
