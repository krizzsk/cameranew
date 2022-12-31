package us.pinguo.camera360.shop.data.install;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import us.pinguo.camera360.shop.data.FilterType;
import us.pinguo.camera360.shop.data.show.ShowPkg;
import us.pinguo.librouter.application.BaseApplication;
/* loaded from: classes3.dex */
public class FilterOperateManager {

    /* renamed from: f  reason: collision with root package name */
    private static final FilterOperateManager f9596f = new FilterOperateManager();

    /* renamed from: g  reason: collision with root package name */
    private static final ThreadFactory f9597g;

    /* renamed from: h  reason: collision with root package name */
    public static final Executor f9598h;
    private Hashtable<String, e> a = new Hashtable<>();
    private Hashtable<String, p> b = new Hashtable<>();
    private Vector<String> c = new Vector<>();

    /* renamed from: d  reason: collision with root package name */
    private List<k> f9599d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private y f9600e;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public enum InstallType {
        install,
        normalUpdate,
        effectUpdate
    }

    /* loaded from: classes3.dex */
    class a implements ThreadFactory {
        private final AtomicInteger a = new AtomicInteger(1);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "FilterPackage download AsyncTask #" + this.a.getAndIncrement());
        }
    }

    /* loaded from: classes3.dex */
    class b implements w {
        final /* synthetic */ w a;

        b(FilterOperateManager filterOperateManager, w wVar) {
            this.a = wVar;
        }

        @Override // us.pinguo.camera360.shop.data.install.w
        public void a(int i2) {
            us.pinguo.camera360.shop.data.i.e().u();
            w wVar = this.a;
            if (wVar != null) {
                wVar.a(i2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements p {
        c() {
        }

        @Override // us.pinguo.camera360.shop.data.install.p
        public void a(q qVar) {
            p pVar = (p) FilterOperateManager.this.b.get(qVar.c());
            us.pinguo.common.log.a.c("install finished id:" + qVar.c() + ",success" + qVar.d() + ",reslultCode:" + qVar.a(), new Object[0]);
            if (qVar.b() != null) {
                qVar.b().printStackTrace();
            }
            e eVar = (e) FilterOperateManager.this.a.get(qVar.c());
            FilterOperateManager.this.a.remove(qVar.c());
            if (us.pinguo.camera360.shop.data.show.u.b().h(qVar.c()) != null) {
                if (qVar.d()) {
                    FilterOperateManager.this.c.remove(qVar.c());
                } else {
                    FilterOperateManager.this.c.add(qVar.c());
                }
            }
            if (pVar != null) {
                pVar.a(qVar);
            }
            FilterOperateManager.this.f9600e = null;
            qVar.d();
        }

        @Override // us.pinguo.camera360.shop.data.install.p
        public void b(String str) {
            p pVar = (p) FilterOperateManager.this.b.get(str);
            if (pVar != null) {
                pVar.b(str);
            }
        }

        @Override // us.pinguo.camera360.shop.data.install.p
        public void c(String str, int i2) {
            p pVar = (p) FilterOperateManager.this.b.get(str);
            if (pVar != null) {
                pVar.c(str, i2);
            }
        }
    }

    static {
        a aVar = new a();
        f9597g = aVar;
        f9598h = new ThreadPoolExecutor(5, 10, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), aVar, new ThreadPoolExecutor.DiscardOldestPolicy());
    }

    private FilterOperateManager() {
    }

    @NonNull
    private l g(ShowPkg showPkg, InstallType installType, c cVar) {
        if (installType == InstallType.normalUpdate) {
            return new m(new k(showPkg), cVar);
        }
        if (installType == InstallType.effectUpdate) {
            return new j(new k(showPkg), cVar);
        }
        return new l(new k(showPkg), cVar);
    }

    public static FilterOperateManager h() {
        return f9596f;
    }

    private boolean l(us.pinguo.camera360.shop.data.h hVar) {
        return hVar != null;
    }

    private synchronized void n(k kVar, InstallType installType) {
        p pVar = this.b.get(kVar.b());
        if (installType == InstallType.install && k(kVar.b())) {
            if (pVar != null) {
                pVar.a(new q(kVar.b(), false, 8, null));
            }
        } else if (!us.pinguo.util.q.f(BaseApplication.d())) {
            if (pVar != null) {
                pVar.a(new q(kVar.b(), false, 2, null));
            }
        } else if (this.a.get(kVar.b()) != null) {
            us.pinguo.common.log.a.c("already downloading", new Object[0]);
        } else {
            l g2 = g(kVar.c(), installType, new c());
            this.a.put(kVar.b(), g2);
            this.c.remove(kVar.b());
            g2.executeOnExecutor(f9598h, new String[0]);
        }
    }

    private synchronized void o(ShowPkg showPkg, InstallType installType) {
        n(new k(showPkg), installType);
    }

    private void r(List<us.pinguo.camera360.shop.data.h> list) {
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            List<us.pinguo.camera360.shop.data.g> c2 = list.get(i2).c(new FilterType[0]);
            if (c2 != null) {
                ArrayList<us.pinguo.camera360.shop.data.g> arrayList2 = new ArrayList();
                for (us.pinguo.camera360.shop.data.g gVar : c2) {
                    if (gVar.isCollect()) {
                        arrayList2.add(gVar);
                    }
                }
                long j2 = currentTimeMillis - i2;
                for (us.pinguo.camera360.shop.data.g gVar2 : arrayList2) {
                    gVar2.setCollectTime(j2);
                    arrayList.add(gVar2.getItemBean());
                }
            }
        }
        us.pinguo.repository2020.database.a.a.w().f(arrayList);
        us.pinguo.camera360.shop.data.i.e().u();
    }

    public void e() {
        for (Map.Entry<String, e> entry : this.a.entrySet()) {
            entry.getValue().cancel(true);
        }
        this.a.clear();
    }

    public void f(String str) {
        e eVar = this.a.get(str);
        if (eVar != null) {
            eVar.cancel(true);
        }
        this.a.remove(str);
    }

    public Set<String> i() {
        return this.a.keySet();
    }

    public ShowPkg.Status j(String str) {
        us.pinguo.camera360.shop.data.h k2 = us.pinguo.camera360.shop.data.i.e().k(str, FilterType.Combin);
        if (l(k2)) {
            if (k2.k()) {
                if (p(str)) {
                    return ShowPkg.Status.installing;
                }
                return ShowPkg.Status.update;
            }
            return ShowPkg.Status.installed;
        } else if (p(str)) {
            return ShowPkg.Status.installing;
        } else {
            if (this.c.contains(str)) {
                return ShowPkg.Status.failed;
            }
            return ShowPkg.Status.uninstalled;
        }
    }

    public boolean k(String str) {
        return l(us.pinguo.camera360.shop.data.i.e().k(str, FilterType.Combin));
    }

    public synchronized void m(ShowPkg showPkg) {
        o(showPkg, InstallType.install);
    }

    public boolean p(String str) {
        e eVar = this.a.get(str);
        return (eVar == null || eVar.isCancelled()) ? false : true;
    }

    public void q(String str, p pVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.b.put(str, pVar);
    }

    public boolean s(List<us.pinguo.camera360.shop.data.h> list) {
        if (list == null) {
            us.pinguo.common.log.a.e("sort failed,the list is null", new Object[0]);
            return false;
        }
        us.pinguo.common.log.a.c("sortpackage:" + list, new Object[0]);
        r(list);
        return true;
    }

    public void t(us.pinguo.camera360.shop.data.h hVar, w wVar) {
        new n(hVar, new b(this, wVar)).execute(new String[0]);
    }

    public void u(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.b.remove(str);
    }
}
