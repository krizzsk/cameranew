package us.pinguo.advsdk.manager;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import us.pinguo.advsdk.a.m;
import us.pinguo.advsdk.a.n;
import us.pinguo.advsdk.a.p;
import us.pinguo.advsdk.a.q;
import us.pinguo.advsdk.a.r;
import us.pinguo.advsdk.bean.AdsItem;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PgAdvSdkRegisterManager.java */
/* loaded from: classes3.dex */
public class g implements n, p, q {
    private Map<String, m> a;
    private Map<String, m> b;
    private Map<String, m> c;

    /* renamed from: d  reason: collision with root package name */
    private Handler f9075d;

    /* renamed from: e  reason: collision with root package name */
    private Map<String, ArrayList<r>> f9076e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PgAdvSdkRegisterManager.java */
    /* loaded from: classes3.dex */
    public class a implements Runnable {
        final /* synthetic */ m a;

        a(m mVar) {
            this.a = mVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.d(g.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PgAdvSdkRegisterManager.java */
    /* loaded from: classes3.dex */
    public class b implements Runnable {
        final /* synthetic */ ArrayList a;
        final /* synthetic */ boolean b;

        b(g gVar, ArrayList arrayList, boolean z) {
            this.a = arrayList;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                r rVar = (r) it.next();
                if (this.b) {
                    rVar.a();
                } else {
                    rVar.b();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g() {
        try {
            this.f9075d = new Handler(Looper.getMainLooper());
            this.f9076e = new HashMap();
        } catch (Exception unused) {
            us.pinguo.advsdk.utils.b.a("register sdk is not looper");
        }
    }

    private void j(m mVar) {
        if (mVar == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            mVar.d(this);
            return;
        }
        Handler handler = this.f9075d;
        if (handler == null) {
            return;
        }
        handler.post(new a(mVar));
    }

    private void k() {
        if (this.a == null) {
            this.a = new ConcurrentHashMap();
        }
        if (this.b == null) {
            this.b = new ConcurrentHashMap();
        }
        if (this.c == null) {
            this.c = new ConcurrentHashMap();
        }
    }

    private void l(boolean z, String str) {
        if (this.f9076e.containsKey(str)) {
            ArrayList<r> remove = this.f9076e.remove(str);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                Iterator<r> it = remove.iterator();
                while (it.hasNext()) {
                    r next = it.next();
                    if (z) {
                        next.a();
                    } else {
                        next.b();
                    }
                }
                return;
            }
            Handler handler = this.f9075d;
            if (handler == null) {
                return;
            }
            handler.post(new b(this, remove, z));
        }
    }

    private void m(boolean z) {
        Map<String, m> map = this.b;
        if (map == null || map.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, m> entry : this.b.entrySet()) {
            if (!c(entry.getKey()) && (!z || entry.getValue().f())) {
                if (!this.c.containsKey(entry.getKey())) {
                    this.c.put(entry.getKey(), entry.getValue());
                }
                if (entry.getValue().e()) {
                    arrayList.add(entry.getValue());
                } else {
                    j(entry.getValue());
                }
            }
        }
        n();
        if (arrayList.size() > 0) {
            new us.pinguo.advsdk.manager.b(arrayList, this, this).start();
        }
    }

    private void n() {
        k();
        for (Map.Entry<String, m> entry : this.c.entrySet()) {
            this.b.remove(entry.getKey());
        }
    }

    @Override // us.pinguo.advsdk.a.p
    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        k();
        m remove = this.c.remove(str);
        if (remove == null || this.b.containsKey(remove.b())) {
            return;
        }
        this.b.put(remove.b(), remove);
        us.pinguo.advsdk.utils.b.a("type:" + str + "init failed");
        l(true, str);
    }

    @Override // us.pinguo.advsdk.a.p
    public void b(String str) {
        Map<String, m> map;
        m remove;
        if (c(str) || (map = this.c) == null || this.b == null || (remove = map.remove(str)) == null) {
            return;
        }
        this.b.remove(str);
        if (this.a.containsKey(str)) {
            this.a.remove(str);
        }
        this.a.put(str, remove);
        l(true, str);
    }

    @Override // us.pinguo.advsdk.a.n
    public boolean c(String str) {
        Map<String, m> map = this.a;
        return (map == null || map.size() == 0 || !this.a.containsKey(str)) ? false : true;
    }

    @Override // us.pinguo.advsdk.a.n
    public void d(int i2, Context context, Map<String, Object> map) {
        Map<String, m> map2 = this.a;
        if (map2.containsKey("" + i2)) {
            Map<String, m> map3 = this.a;
            map3.get("" + i2).c(context, map);
        }
    }

    @Override // us.pinguo.advsdk.a.n
    public void e(m mVar) {
        if (mVar == null) {
            return;
        }
        k();
        us.pinguo.advsdk.utils.b.a("mSdkInitedList.containsKey(sdkcontrol.getSDKType() = " + this.a.containsKey(mVar.b()) + " , sdk = " + mVar.b());
        if (this.a.containsKey(mVar.b()) || this.b.containsKey(mVar.b()) || this.c.containsKey(mVar.b())) {
            return;
        }
        if (mVar.b().equals("0")) {
            this.a.put(mVar.b(), mVar);
            this.a.put(Constants.VIA_SHARE_TYPE_INFO, mVar);
        } else {
            this.b.put(mVar.b(), mVar);
        }
        us.pinguo.advsdk.utils.b.a("mSdkInitedList registerSDK = " + mVar.b());
        m(true);
    }

    @Override // us.pinguo.advsdk.a.n
    public void f() {
        Map<String, m> map = this.b;
        if (map == null || map.size() == 0) {
            return;
        }
        m(false);
    }

    @Override // us.pinguo.advsdk.a.n
    public us.pinguo.advsdk.a.a g(AdsItem adsItem) {
        Map<String, m> map;
        m mVar;
        us.pinguo.advsdk.utils.b.a("createRequestObject key = " + adsItem.b());
        if (c(adsItem.b()) && (map = this.a) != null && map.containsKey(adsItem.b()) && (mVar = this.a.get(adsItem.b())) != null) {
            return mVar.a(adsItem);
        }
        return null;
    }

    @Override // us.pinguo.advsdk.a.q
    public void h() {
    }

    @Override // us.pinguo.advsdk.a.q
    public void i() {
    }
}
