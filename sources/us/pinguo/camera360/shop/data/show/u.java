package us.pinguo.camera360.shop.data.show;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.pinguo.camera360.newShop.model.StoreHistoryNew;
import java.util.LinkedList;
import java.util.List;
import us.pinguo.camera360.shop.data.show.UnlockManager;
import us.pinguo.librouter.application.BaseApplication;
/* compiled from: ShopDataManager.java */
/* loaded from: classes4.dex */
public class u {

    /* renamed from: g  reason: collision with root package name */
    private static final u f9645g = new u();
    private x a;
    private w b;
    private UnlockManager c;

    /* renamed from: d  reason: collision with root package name */
    private String f9646d;

    /* renamed from: e  reason: collision with root package name */
    private y f9647e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f9648f;

    private u() {
        new LinkedList();
        this.f9646d = BaseApplication.d().getFilesDir().getAbsolutePath() + "/shop/";
        Handler handler = new Handler(Looper.getMainLooper());
        this.c = UnlockManager.getInstance();
        this.a = new x(this.f9646d, this.c, handler);
        this.b = new w(handler);
        this.f9647e = new y(this.f9646d, this.c);
    }

    public static u b() {
        return f9645g;
    }

    public void a() {
        this.f9647e.a(null);
    }

    public synchronized StoreHistoryNew c() {
        return this.c.p();
    }

    public synchronized List<ShowScene> d(boolean z) throws Exception {
        return this.a.k(z);
    }

    public ShowTopic e(String str) {
        return this.a.f(str);
    }

    public ShowDetail f(String str) throws Exception {
        return this.b.m(str);
    }

    public ShowDetail g(String str) throws Exception {
        return this.b.n(str);
    }

    public ShowPkg h(String str) {
        return this.a.i(str, false);
    }

    public ShowPkg i(String str) {
        return this.a.i(str, true);
    }

    public boolean j(BaseShow baseShow) {
        if (baseShow == null) {
            return false;
        }
        return this.c.x(baseShow);
    }

    public void k() {
        this.c.D();
    }

    public void l() {
        this.a.w();
    }

    public void m(String str, q qVar) {
        this.b.E(str, qVar, true);
    }

    public ShowDetail n(String str) {
        return this.b.F(str);
    }

    public void o(boolean z, boolean z2) {
        this.a.x(z);
        this.a.y(z2);
        this.f9647e.d(z);
    }

    public void p(ShowPkg showPkg, UnlockManager.h hVar, Activity activity) {
        this.c.K(showPkg, hVar, activity);
    }

    public void q(int i2, UnlockManager.g gVar) {
        this.c.N(i2, gVar);
    }

    public boolean r(s sVar, boolean z) {
        return this.a.z(sVar, z);
    }

    public void s(s sVar, boolean z) {
        boolean r = r(sVar, z);
        us.pinguo.common.log.a.m("ShopDataManager", "updateShowPagesOrCheckRedPoint isUpdating=" + r, new Object[0]);
        if (r) {
            return;
        }
        try {
            this.a.k(this.f9648f);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
