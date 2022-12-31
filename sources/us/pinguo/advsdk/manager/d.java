package us.pinguo.advsdk.manager;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import us.pinguo.advsdk.bean.AdsItem;
/* compiled from: ParallelRequestControler.java */
/* loaded from: classes3.dex */
class d extends us.pinguo.advsdk.a.c {

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<String> f9059g;

    /* renamed from: h  reason: collision with root package name */
    private ArrayList<Integer> f9060h;

    /* renamed from: i  reason: collision with root package name */
    private Map<String, Integer> f9061i;

    /* renamed from: j  reason: collision with root package name */
    private HashMap<String, us.pinguo.advsdk.a.b> f9062j;

    /* renamed from: k  reason: collision with root package name */
    private Handler f9063k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f9064l;
    private int m;
    private k n;
    private us.pinguo.advsdk.a.k o;

    /* compiled from: ParallelRequestControler.java */
    /* loaded from: classes3.dex */
    class a implements us.pinguo.advsdk.a.k {
        a() {
        }

        @Override // us.pinguo.advsdk.a.k
        public void a(us.pinguo.advsdk.a.b bVar) {
            d.this.o(bVar, true);
        }

        @Override // us.pinguo.advsdk.a.k
        public void b(AdsItem adsItem, us.pinguo.advsdk.a.b bVar) {
            if (!((us.pinguo.advsdk.a.c) d.this).f9036d.get()) {
                us.pinguo.advsdk.utils.b.a(((us.pinguo.advsdk.a.c) d.this).f9037e.c + ":=over=" + adsItem.b());
            } else if (d.this.g(adsItem)) {
                d.this.G(adsItem, true);
                us.pinguo.advsdk.utils.b.a(((us.pinguo.advsdk.a.c) d.this).f9037e.c + ":onSuccess:" + adsItem.b() + ":request only ,but not show");
                if (d.this.H()) {
                    d.this.l(adsItem, "all failed or allads is not show");
                }
            } else {
                us.pinguo.advsdk.utils.b.a(((us.pinguo.advsdk.a.c) d.this).f9037e.c + ":onSuccess:" + adsItem.source);
                String c = d.this.c(adsItem);
                d.this.f9062j.put(c, bVar);
                int indexOf = d.this.f9059g.indexOf(c);
                d.this.f9060h.set(indexOf, 1);
                if (d.this.K(indexOf)) {
                    d.this.p(adsItem, bVar);
                }
            }
        }

        @Override // us.pinguo.advsdk.a.k
        public void d(us.pinguo.advsdk.a.b bVar) {
            d.this.j(bVar);
        }

        @Override // us.pinguo.advsdk.a.k
        public void e(AdsItem adsItem, String str) {
            if (((us.pinguo.advsdk.a.c) d.this).f9036d.get()) {
                if (d.this.g(adsItem)) {
                    us.pinguo.advsdk.utils.b.a(((us.pinguo.advsdk.a.c) d.this).f9037e.c + ": type=" + adsItem.source + ":request only ,but not show");
                    d.this.G(adsItem, false);
                    if (d.this.H()) {
                        d.this.l(adsItem, "all failed or allads is not show");
                        return;
                    }
                    return;
                }
                String c = d.this.c(adsItem);
                us.pinguo.advsdk.utils.b.a(((us.pinguo.advsdk.a.c) d.this).f9037e.c + ": type=" + adsItem.source + " failed");
                d.this.f9060h.set(d.this.f9059g.indexOf(c), -1);
                d.this.J(adsItem);
            }
        }

        @Override // us.pinguo.advsdk.a.k
        public void f(us.pinguo.advsdk.a.b bVar) {
            d.this.n(bVar);
        }

        @Override // us.pinguo.advsdk.a.k
        public void onAdDestroy(us.pinguo.advsdk.a.b bVar) {
            d.this.k(bVar);
        }

        @Override // us.pinguo.advsdk.a.k
        public void onRewardVideoClose(us.pinguo.advsdk.a.b bVar) {
            d.this.m(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ParallelRequestControler.java */
    /* loaded from: classes3.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            for (int i2 = 0; i2 < d.this.f9060h.size(); i2++) {
                if (((Integer) d.this.f9060h.get(i2)).intValue() == 1) {
                    us.pinguo.advsdk.a.b bVar = (us.pinguo.advsdk.a.b) d.this.f9062j.get((String) d.this.f9059g.get(i2));
                    us.pinguo.advsdk.utils.b.a(((us.pinguo.advsdk.a.c) d.this).f9037e.c + ":time out");
                    d.this.p(bVar.a(), bVar);
                    return;
                }
            }
            d.this.f9064l = true;
        }
    }

    public d(us.pinguo.advsdk.a.j jVar, us.pinguo.advsdk.a.k kVar) {
        super(jVar, kVar);
        this.f9064l = false;
        this.m = 1;
        this.o = new a();
        this.f9063k = new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(AdsItem adsItem, boolean z) {
        if (adsItem == null) {
            return;
        }
        String c = c(adsItem);
        if (this.f9061i.containsKey(c)) {
            this.f9061i.remove(c);
            this.f9061i.put(c, Integer.valueOf(z ? 1 : -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean H() {
        boolean z;
        if (this.f9061i.size() > 0 && this.f9060h.size() < 0) {
            Iterator<String> it = this.f9061i.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                }
                if (this.f9061i.get(it.next()).intValue() == 0) {
                    z = false;
                    break;
                }
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    private void I() {
        long j2 = this.f9037e.f9044e;
        if (j2 == 0) {
            j2 = 3;
        } else if (j2 >= 100) {
            this.m = 2;
            us.pinguo.advsdk.utils.b.a(this.f9037e.c + ":mode:type_failed");
            return;
        }
        this.f9063k.postDelayed(new b(), j2 * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(AdsItem adsItem) {
        us.pinguo.advsdk.utils.b.a(this.f9037e.c + ":拉取失败，开始查找命中");
        for (int i2 = 0; i2 < this.f9060h.size(); i2++) {
            int intValue = this.f9060h.get(i2).intValue();
            if (intValue == 0) {
                return;
            }
            if (intValue == 1) {
                us.pinguo.advsdk.a.b bVar = this.f9062j.get(this.f9059g.get(i2));
                us.pinguo.advsdk.utils.b.a(this.f9037e.c + ":拉取失败后查找替补命中：");
                p(bVar.a(), bVar);
                return;
            }
        }
        us.pinguo.advsdk.utils.b.a(this.f9037e.c + ":查找命中失败");
        l(adsItem, "all ad failed");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean K(int i2) {
        if (!this.f9064l && i2 != 0) {
            if (this.m == 2 && this.f9060h.get(0).intValue() == -1) {
                us.pinguo.advsdk.utils.b.a(this.f9037e.c + ":命中");
                return true;
            }
            for (int i3 = i2 - 1; i3 >= 0; i3--) {
                if (this.f9060h.get(i3).intValue() != -1) {
                    us.pinguo.advsdk.utils.b.a(this.f9037e.c + ":没有命中");
                    return false;
                }
            }
            us.pinguo.advsdk.utils.b.a(this.f9037e.c + ":命中");
            return true;
        }
        us.pinguo.advsdk.utils.b.a(this.f9037e.c + ":命中");
        return true;
    }

    @Override // us.pinguo.advsdk.a.c
    public void i(Context context, List<AdsItem> list, us.pinguo.advsdk.bean.b bVar) {
        super.i(context, list, bVar);
        List<AdsItem> list2 = this.a;
        if (list2 != null && list2.size() != 0) {
            this.f9059g = new ArrayList<>();
            this.f9060h = new ArrayList<>();
            this.f9061i = new HashMap();
            this.f9062j = new HashMap<>();
            if (this.n == null) {
                this.n = new k();
            }
            List<AdsItem> b2 = this.n.b(this.a, bVar.c);
            if (b2 != null && b2.size() != 0) {
                for (AdsItem adsItem : b2) {
                    if (g(adsItem)) {
                        if (!this.f9061i.containsKey(c(adsItem))) {
                            this.f9061i.put(c(adsItem), 0);
                        }
                    } else {
                        this.f9059g.add(c(adsItem));
                        this.f9060h.add(0);
                        us.pinguo.advsdk.utils.b.a(this.f9037e.c + ":=====prioity=" + c(adsItem));
                    }
                }
                I();
                us.pinguo.advsdk.utils.b.a(this.f9037e.c + ":=====AdsItemList.size =" + b2.size());
                for (AdsItem adsItem2 : b2) {
                    us.pinguo.advsdk.a.a c = this.b.c(adsItem2);
                    if (c == null) {
                        us.pinguo.advsdk.utils.b.a(this.f9037e.c + ":currentRequest == null");
                    } else {
                        c.k(context, this.o, bVar, adsItem2);
                        c.i();
                        us.pinguo.advsdk.utils.b.a(this.f9037e.c + ":currentRequest.loadAD()");
                    }
                }
                return;
            }
            l(null, "waterfall is empty");
            return;
        }
        l(null, "no ads");
    }

    @Override // us.pinguo.advsdk.a.c
    public void l(AdsItem adsItem, String str) {
        this.f9063k.removeCallbacksAndMessages(null);
        super.l(adsItem, str);
    }

    @Override // us.pinguo.advsdk.a.c
    public void p(AdsItem adsItem, us.pinguo.advsdk.a.b bVar) {
        this.f9063k.removeCallbacksAndMessages(null);
        super.p(adsItem, bVar);
        us.pinguo.advsdk.utils.b.a(this.f9037e.c + ":====hit type=" + adsItem.loadSDK);
    }
}
