package us.pinguo.repository2020.manager;

import android.os.Handler;
import android.os.Looper;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.pinguo.lib.GsonUtilKt;
import com.tencent.open.SocialConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.z0;
import rx.functions.Action1;
import us.pinguo.common.network.RxVolley;
import us.pinguo.common.network.pgrequest.PGRequest;
import us.pinguo.repository2020.entity.FilterPackage;
import us.pinguo.repository2020.entity.OnUpdateDetailListener;
import us.pinguo.repository2020.entity.Package;
import us.pinguo.repository2020.entity.PkgDetailUpdateData;
import us.pinguo.repository2020.entity.PkgDetailUpdateJson;
import us.pinguo.repository2020.utils.n;
import us.pinguo.user.User;
import us.pinguo.util.q;
import us.pinguo.util.v;
/* compiled from: FilterUpdateManager.kt */
/* loaded from: classes6.dex */
public final class FilterUpdateManager {
    public static final FilterUpdateManager a = new FilterUpdateManager();
    private static final Handler b;
    private static final ArrayList<OnUpdateDetailListener> c;

    static {
        s.g(FilterUpdateManager.class.getSimpleName(), "FilterUpdateManager::class.java.simpleName");
        b = new Handler(Looper.getMainLooper());
        c = new ArrayList<>(5);
    }

    private FilterUpdateManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(OnUpdateDetailListener onUpdateDetailListener, Exception e2) {
        s.h(e2, "$e");
        onUpdateDetailListener.onDetailUpdateError(e2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(OnUpdateDetailListener onUpdateDetailListener) {
        onUpdateDetailListener.onDetailUpdated();
    }

    private final void j(List<FilterPackage> list, PkgDetailUpdateData[] pkgDetailUpdateDataArr, kotlin.jvm.b.a<u> aVar) throws Exception {
        if (pkgDetailUpdateDataArr == null) {
            aVar.invoke();
            return;
        }
        ArrayList arrayList = new ArrayList(pkgDetailUpdateDataArr.length);
        Iterator a2 = kotlin.jvm.internal.h.a(pkgDetailUpdateDataArr);
        while (a2.hasNext()) {
            PkgDetailUpdateData pkgDetailUpdateData = (PkgDetailUpdateData) a2.next();
            Iterator<FilterPackage> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    FilterPackage next = it.next();
                    if (s.c(next.getKey(), pkgDetailUpdateData.getPid())) {
                        if (!s.c(next.getPackageBean().getDisplayMd5(), pkgDetailUpdateData.getDisplay_zip_md5()) || !s.c(next.getPackageBean().getPackageMd5(), pkgDetailUpdateData.getPackage_zip_md5())) {
                            arrayList.add(next);
                        }
                    }
                }
            }
        }
        if (arrayList.size() > 0) {
            kotlinx.coroutines.l.d(n0.a(z0.b()), null, null, new FilterUpdateManager$processUpdatedDetail$1(arrayList, null), 3, null);
        } else {
            aVar.invoke();
        }
    }

    private final boolean l(final ArrayList<FilterPackage> arrayList) {
        if (arrayList == null || arrayList.isEmpty() || !q.f(v.a())) {
            return false;
        }
        PGRequest.Builder builder = new PGRequest.Builder(String.class);
        builder.withMethod(1).withDomain(n.a.a()).withUriPath("/api/product/check-update");
        if (User.d().n()) {
            builder.withUid(User.d().h().userId);
        }
        StringBuilder sb = new StringBuilder();
        Iterator<FilterPackage> it = arrayList.iterator();
        while (it.hasNext()) {
            sb.append(it.next().getKey());
            sb.append(",");
        }
        builder.addParam("pids", sb.substring(0, sb.length() - 1));
        us.pinguo.foundation.statistics.h.b.n("", "/api/product/check-update", SocialConstants.TYPE_REQUEST);
        final long currentTimeMillis = System.currentTimeMillis();
        RxVolley.create(builder.build()).subscribe(new Action1() { // from class: us.pinguo.repository2020.manager.g
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                FilterUpdateManager.m(currentTimeMillis, arrayList, (String) obj);
            }
        }, new Action1() { // from class: us.pinguo.repository2020.manager.f
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                FilterUpdateManager.n(currentTimeMillis, (Throwable) obj);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(long j2, ArrayList arrayList, String str) {
        Integer status;
        Integer status2;
        Integer status3;
        us.pinguo.foundation.statistics.i iVar = us.pinguo.foundation.statistics.h.b;
        iVar.n((System.currentTimeMillis() - j2) + "", "/api/product/check-update", FirebaseAnalytics.Param.SUCCESS);
        try {
            PkgDetailUpdateJson pkgDetailUpdateJson = (PkgDetailUpdateJson) GsonUtilKt.getCachedGson().j(str, PkgDetailUpdateJson.class);
            if (pkgDetailUpdateJson != null && (((status = pkgDetailUpdateJson.getStatus()) != null && status.intValue() == 200) || (((status2 = pkgDetailUpdateJson.getStatus()) != null && status2.intValue() == 420) || ((status3 = pkgDetailUpdateJson.getStatus()) != null && status3.intValue() == 10220)))) {
                Integer status4 = pkgDetailUpdateJson.getStatus();
                if (status4 != null && status4.intValue() == 420) {
                    a.f(c, new IOException("user time out"));
                    User.E();
                    return;
                }
                Integer status5 = pkgDetailUpdateJson.getStatus();
                if (status5 != null && status5.intValue() == 10220) {
                    a.h(c);
                    return;
                }
                if (us.pinguo.foundation.d.f10987f) {
                    try {
                        s.e(str);
                        us.pinguo.util.k.n("/sdcard/Camera360/update.json", str);
                    } catch (Exception unused) {
                    }
                }
                PkgDetailUpdateData[] data = pkgDetailUpdateJson.getData();
                if (data != null) {
                    if (!(data.length == 0)) {
                        try {
                            a.j(arrayList, data, FilterUpdateManager$updateInstalledPkgToLocal$1$1.INSTANCE);
                            return;
                        } catch (Exception e2) {
                            a.f(c, e2);
                            return;
                        }
                    }
                }
                a.h(c);
                return;
            }
            a.f(c, new IOException("error data"));
        } catch (Exception e3) {
            a.f(c, e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(long j2, Throwable th) {
        us.pinguo.foundation.statistics.i iVar = us.pinguo.foundation.statistics.h.b;
        iVar.n((System.currentTimeMillis() - j2) + "", "/api/product/check-update", "failed");
        us.pinguo.foundation.e.e(th);
        us.pinguo.common.log.a.f(th);
        a.f(c, new Exception(th));
    }

    public final void f(ArrayList<OnUpdateDetailListener> listeners, final Exception e2) {
        s.h(listeners, "listeners");
        s.h(e2, "e");
        Iterator<OnUpdateDetailListener> it = listeners.iterator();
        while (it.hasNext()) {
            final OnUpdateDetailListener next = it.next();
            if (next != null) {
                b.post(new Runnable() { // from class: us.pinguo.repository2020.manager.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        FilterUpdateManager.g(OnUpdateDetailListener.this, e2);
                    }
                });
            }
        }
        listeners.clear();
    }

    public final void h(ArrayList<OnUpdateDetailListener> listeners) {
        s.h(listeners, "listeners");
        Iterator<OnUpdateDetailListener> it = listeners.iterator();
        while (it.hasNext()) {
            final OnUpdateDetailListener next = it.next();
            if (next != null) {
                b.post(new Runnable() { // from class: us.pinguo.repository2020.manager.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        FilterUpdateManager.i(OnUpdateDetailListener.this);
                    }
                });
            }
        }
        listeners.clear();
    }

    public final void k(ArrayList<Package> serverPackages) {
        Object obj;
        s.h(serverPackages, "serverPackages");
        List<FilterPackage> o = new FilterLocalDataManager().o();
        ArrayList<FilterPackage> arrayList = new ArrayList<>();
        for (Package r2 : serverPackages) {
            Iterator<T> it = o.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (s.c(((FilterPackage) obj).getKey(), r2.getPid())) {
                    break;
                }
            }
            FilterPackage filterPackage = (FilterPackage) obj;
            if (filterPackage != null) {
                filterPackage.getPackageBean().setTagContent(r2.getTagContent());
                filterPackage.getPackageBean().setTagOnTime(r2.getTagOnTime());
                filterPackage.getPackageBean().setTagOffTime(r2.getTagOffTime());
                arrayList.add(filterPackage);
            }
        }
        if (!arrayList.isEmpty()) {
            l(arrayList);
        }
    }
}
