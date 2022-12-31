package us.pinguo.advsdk.manager;

import android.content.Context;
import android.text.TextUtils;
import com.tapjoy.TJAdUnitConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import us.pinguo.advsdk.bean.AdsItem;
import us.pinguo.advsdk.bean.ImageBean;
import us.pinguo.advsdk.bean.SingleAdConfigData;
import us.pinguo.advsdk.statistic.StatisticNetWorkHelper;
import us.pinguo.advstrategy.PgAdvStrategyManager;
import us.pinguo.advstrategy.strategybean.StrategyItem;
/* compiled from: PgAdvLoadEngin.java */
/* loaded from: classes3.dex */
public class f implements us.pinguo.advsdk.a.k, us.pinguo.advsdk.a.j {
    private Context a;
    private int b;
    private us.pinguo.advsdk.a.l c;

    /* renamed from: h  reason: collision with root package name */
    private us.pinguo.advsdk.c.d f9070h;

    /* renamed from: j  reason: collision with root package name */
    private StrategyItem f9072j;

    /* renamed from: i  reason: collision with root package name */
    private boolean f9071i = false;

    /* renamed from: k  reason: collision with root package name */
    private long f9073k = 0;

    /* renamed from: e  reason: collision with root package name */
    private us.pinguo.advsdk.bean.b f9067e = new us.pinguo.advsdk.bean.b();

    /* renamed from: d  reason: collision with root package name */
    private AtomicBoolean f9066d = new AtomicBoolean(false);

    /* renamed from: f  reason: collision with root package name */
    private j f9068f = new j();

    /* renamed from: g  reason: collision with root package name */
    private Map<String, us.pinguo.advsdk.a.a> f9069g = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PgAdvLoadEngin.java */
    /* loaded from: classes3.dex */
    public class a extends us.pinguo.advsdk.network.a<SingleAdConfigData> {
        final /* synthetic */ long b;
        final /* synthetic */ Context c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Class cls, long j2, Context context) {
            super(cls);
            this.b = j2;
            this.c = context;
        }

        @Override // us.pinguo.advsdk.network.a
        public void b(int i2, String str) {
            us.pinguo.advsdk.utils.b.a("get ads failed:" + str);
            us.pinguo.advsdk.statistic.b.a.a("getads_req_failed", f.this.f9067e.c);
            us.pinguo.advsdk.statistic.a.a.c("getads_count_failed", "", f.this.f9067e.c);
            f.this.f9066d.set(false);
            if (f.this.f9068f.e()) {
                f.this.s(103, str);
            } else {
                f.this.q(this.c);
            }
            us.pinguo.advsdk.statistic.a.a.a("getads_count_failed_info", f.this.f9067e.c + ":" + str);
            us.pinguo.advsdk.statistic.b.a.b("getads_req_error_msg", f.this.f9067e.c + ":" + str);
        }

        @Override // us.pinguo.advsdk.network.a
        /* renamed from: d */
        public void c(SingleAdConfigData singleAdConfigData) {
            us.pinguo.advsdk.utils.b.a("get ads success");
            f.this.f9067e.f9044e = singleAdConfigData.pullTimeout;
            String str = singleAdConfigData.request;
            f.this.f9066d.set(false);
            us.pinguo.advsdk.statistic.b.a.a("getads_req_success", f.this.f9067e.c);
            us.pinguo.advsdk.statistic.a.a.c("getads_count_success", "", f.this.f9067e.c);
            us.pinguo.advsdk.statistic.b.a.a("getads_req_consume", "" + ((System.currentTimeMillis() - this.b) / 1000));
            if (singleAdConfigData == null || singleAdConfigData.ads.size() == 0) {
                f.this.s(102, "data is empty");
                return;
            }
            f.this.w(singleAdConfigData.ads, false);
            String d2 = f.this.f9068f.d();
            us.pinguo.advsdk.statistic.a.a.e(f.this.f9067e.c, d2);
            us.pinguo.advsdk.statistic.b.a.a("waterfall_order", f.this.f9067e.c + ":" + d2);
            us.pinguo.advsdk.network.g.k().q(str, null);
            f.this.q(this.c);
        }
    }

    public f(Context context, Map<String, String> map) {
        this.b = 1;
        if (map.containsKey("pg_unit_id")) {
            this.f9067e.c = map.get("pg_unit_id");
        }
        if (TextUtils.isEmpty(this.f9067e.c)) {
            us.pinguo.advsdk.utils.b.a("PGNativeLoadEngin mUnit_id = is null ");
            return;
        }
        us.pinguo.advsdk.utils.b.a("PGNativeLoadEngin mUnit_id = " + this.f9067e.c);
        this.a = context.getApplicationContext();
        if (map == null || map.size() == 0) {
            return;
        }
        if (map.containsKey("cache_num")) {
            try {
                int intValue = Integer.valueOf(map.get("cache_num")).intValue();
                if (intValue >= 1) {
                    this.b = intValue;
                }
            } catch (NumberFormatException unused) {
            }
        }
        z();
    }

    private void A(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("unitId", str);
        hashMap.put("waterfall", str2);
        us.pinguo.advsdk.network.g.k().p(m() + "/api/adRequest?", hashMap, null);
    }

    private String m() {
        String appHost = PgAdvStrategyManager.getInstance().getStrategyKeeper(this.a).getAppHost();
        if (TextUtils.isEmpty(appHost) || appHost.length() < 5) {
            appHost = PgAdvManager.getInstance().h();
        }
        String trim = appHost.trim();
        return trim.charAt(trim.length() + (-1)) == '/' ? trim.substring(0, trim.length() - 1) : trim;
    }

    private Map<String, String> n(us.pinguo.advsdk.bean.b bVar) {
        if (this.a == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("limit", String.valueOf(this.b));
        hashMap.put("unitId", bVar.c);
        hashMap.put("expVersion", TextUtils.isEmpty(bVar.a) ? "" : bVar.a);
        hashMap.put("expTag", TextUtils.isEmpty(bVar.b) ? "" : bVar.b);
        hashMap.put("localExist", us.pinguo.advsdk.utils.e.d(this.a));
        hashMap.put("launchCount", String.valueOf(PgAdvManager.getInstance().i().e()));
        hashMap.put("density", us.pinguo.advsdk.utils.d.c(this.a));
        hashMap.put("vendor", us.pinguo.advsdk.utils.d.g());
        hashMap.put("mac", "");
        long h2 = PgAdvManager.getInstance().i().h();
        StringBuilder sb = new StringBuilder();
        sb.append(h2 > 0 ? h2 : 1L);
        sb.append("");
        hashMap.put("lastcall", sb.toString());
        us.pinguo.advsdk.utils.b.a("read lastcall：" + h2);
        return hashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean o() {
        /*
            r5 = this;
            us.pinguo.advsdk.manager.j r0 = r5.f9068f
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            java.util.List r0 = r0.a()
            if (r0 == 0) goto L43
            int r2 = r0.size()
            if (r2 > 0) goto L13
            goto L43
        L13:
            java.util.Iterator r0 = r0.iterator()
        L17:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L43
            java.lang.Object r2 = r0.next()
            us.pinguo.advsdk.bean.AdsItem r2 = (us.pinguo.advsdk.bean.AdsItem) r2
            java.lang.String r3 = r2.displayFormat
            java.lang.String r4 = "interstitial"
            boolean r3 = r4.equals(r3)
            if (r3 != 0) goto L41
            java.lang.String r3 = r2.displayFormat
            java.lang.String r4 = "interstitial_appwall"
            boolean r3 = r4.equals(r3)
            if (r3 != 0) goto L41
            java.lang.String r2 = r2.displayFormat
            java.lang.String r3 = "interstitial_video"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L17
        L41:
            r0 = 1
            return r0
        L43:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.advsdk.manager.f.o():boolean");
    }

    private void p(Context context) {
        if (TextUtils.isEmpty(this.f9067e.c)) {
            us.pinguo.advsdk.utils.b.a("unit_id is null");
            s(101, "unit_id is null");
            return;
        }
        z();
        StrategyItem strategyItem = this.f9072j;
        if (strategyItem != null && strategyItem.getadInterval > 0) {
            us.pinguo.advsdk.a.e i2 = PgAdvManager.getInstance().i();
            if ((System.currentTimeMillis() - i2.i("last_ad_show_time" + this.f9067e.c)) / 1000 < this.f9072j.getadInterval) {
                us.pinguo.advsdk.utils.b.b(TJAdUnitConstants.String.VIDEO_INFO, "interval not available");
                s(101, "interval not available");
                return;
            }
        }
        us.pinguo.advsdk.statistic.b.a.a("getads_req_all_count", this.f9067e.c);
        us.pinguo.advsdk.statistic.a.a.c("getads_count_all", "", this.f9067e.c);
        StrategyItem strategyItem2 = this.f9072j;
        if (strategyItem2 != null && !strategyItem2.isContaninAlliance() && !this.f9072j.isWaterfallEmpty()) {
            w(this.f9072j.waterfall, true);
            A(this.f9072j.unit_id, this.f9068f.d());
            us.pinguo.advsdk.statistic.b.a.a("waterfall_order", this.f9067e.c + ":" + this.f9068f.c());
            us.pinguo.advsdk.statistic.a.a.e(this.f9067e.c, this.f9068f.c());
            us.pinguo.advsdk.statistic.b.a.a("getads_req_local", this.f9067e.c);
            us.pinguo.advsdk.statistic.a.a.c("getads_count_local", "", this.f9067e.c);
            q(context);
        } else if (!StatisticNetWorkHelper.getInstance().e()) {
            s(103, "no network");
            us.pinguo.advsdk.statistic.b.a.a("getads_req_nonetwork", this.f9067e.c);
            us.pinguo.advsdk.statistic.a.a.c("getads_nonetwork", "", this.f9067e.c);
        } else {
            this.f9066d.set(true);
            us.pinguo.advsdk.utils.b.a("startGetAd is mUnit_id = " + this.f9067e.c);
            us.pinguo.advsdk.statistic.b.a.a("getads_req_count", this.f9067e.c);
            us.pinguo.advsdk.statistic.a.a.c("getads_count_server", "", this.f9067e.c);
            long currentTimeMillis = System.currentTimeMillis();
            us.pinguo.advsdk.network.g k2 = us.pinguo.advsdk.network.g.k();
            k2.p(PgAdvManager.getInstance().h() + "/api/v1/getAds", n(this.f9067e), new a(SingleAdConfigData.class, currentTimeMillis, context));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(Context context) {
        if (!o() && !this.f9071i) {
            us.pinguo.advsdk.utils.b.a("request mode:parallel");
            d dVar = new d(this, this);
            if (context == null) {
                context = this.a;
            }
            dVar.i(context, this.f9068f.a(), this.f9067e);
            return;
        }
        us.pinguo.advsdk.utils.b.a("request mode:serial");
        l lVar = new l(this, this);
        if (context == null) {
            context = this.a;
        }
        lVar.i(context, this.f9068f.a(), this.f9067e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(int i2, String str) {
        this.f9068f.p();
        if (this.c == null || this.f9068f.h()) {
            return;
        }
        this.c.onPGNativeFailed(i2, str);
    }

    private void t(int i2, String str) {
        this.f9068f.p();
        if (this.c == null || !this.f9068f.h()) {
            return;
        }
        this.c.onPreloadFailed(i2, str);
    }

    private void u(us.pinguo.advsdk.a.b bVar) {
        if (this.c == null || !this.f9068f.h()) {
            return;
        }
        this.c.onPreloadSuccess(bVar);
    }

    private void v(us.pinguo.advsdk.a.b bVar) {
        if (this.c == null || this.f9068f.h()) {
            return;
        }
        this.c.onPGNativeSuccess(bVar);
        this.f9068f.k(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(List<AdsItem> list, boolean z) {
        if (list != null && list.size() != 0) {
            ArrayList arrayList = new ArrayList();
            us.pinguo.advsdk.utils.b.a("parseAds.ads.size = " + list.size());
            String str = "";
            String str2 = "";
            for (int i2 = 0; i2 < list.size(); i2++) {
                AdsItem adsItem = list.get(i2);
                if (TextUtils.isEmpty(str)) {
                    str = str + String.valueOf(adsItem.loadSDK);
                    str2 = str2 + adsItem.source;
                } else {
                    str = (str + ",") + String.valueOf(adsItem.loadSDK);
                    str2 = (str2 + "/") + adsItem.source;
                }
                if (z) {
                    adsItem.bLocal = true;
                    String m = m();
                    us.pinguo.advsdk.utils.b.a("report host is :" + m);
                    if (!TextUtils.isEmpty(m)) {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(m);
                        adsItem.impression = arrayList2;
                        ArrayList arrayList3 = new ArrayList();
                        arrayList3.add(m);
                        adsItem.click = arrayList3;
                        adsItem.stat = m;
                    } else {
                        us.pinguo.advsdk.utils.b.a("report host is null");
                    }
                }
                if (!PgAdvManager.getInstance().q().c(adsItem.b())) {
                    us.pinguo.advsdk.utils.b.a(adsItem.source + " is not  registed , type = " + adsItem.b());
                } else if (!adsItem.c() && TextUtils.isEmpty(adsItem.placementId)) {
                    us.pinguo.advsdk.utils.b.a("type:" + adsItem.source + " placement id is null");
                } else {
                    arrayList.add(adsItem);
                }
            }
            this.f9067e.f9043d = str;
            this.f9068f.j(arrayList);
            us.pinguo.advsdk.utils.b.a(this.f9067e.c + ":waterfall:" + str2);
            return;
        }
        s(102, "data is empty");
    }

    private void x(AdsItem adsItem, us.pinguo.advsdk.a.b bVar) {
        if (!"launchScreen".equals(adsItem.displayFormat) || adsItem == null || bVar == null) {
            return;
        }
        if ("dsp".equals(adsItem.deliverType)) {
            if (adsItem.cacheTime > 0) {
                ImageBean imageBean = adsItem.image;
                if (imageBean != null && !TextUtils.isEmpty(imageBean.url)) {
                    PgAdvManager.getInstance().n().a(adsItem.image.url);
                } else if (adsItem.image == null || TextUtils.isEmpty(adsItem.video.url)) {
                    return;
                } else {
                    PgAdvManager.getInstance().n().a(adsItem.video.url);
                }
                if (!TextUtils.isEmpty(adsItem.iconUrl)) {
                    PgAdvManager.getInstance().n().a(adsItem.iconUrl);
                }
                LaunchScreenManager.getInstance().d(adsItem, bVar);
            }
        } else if ("third_sdk".equals(adsItem.deliverType)) {
            LaunchScreenManager.getInstance().d(adsItem, bVar);
        }
    }

    private void y(us.pinguo.advsdk.a.b bVar) {
        if (bVar == null) {
            return;
        }
        String g2 = bVar.g();
        String e2 = bVar.e();
        us.pinguo.advsdk.utils.b.a("start preload imgurl:" + g2 + "     iconurl:" + e2);
        if (!TextUtils.isEmpty(g2)) {
            PgAdvManager.getInstance().n().a(bVar.g());
        }
        if (TextUtils.isEmpty(e2)) {
            return;
        }
        PgAdvManager.getInstance().n().a(bVar.e());
    }

    private void z() {
        if (System.currentTimeMillis() - this.f9073k <= 3600000) {
            return;
        }
        this.f9073k = System.currentTimeMillis();
        PgAdvStrategyManager.getInstance().refresh(false);
        if (this.a == null) {
            return;
        }
        this.f9067e.a = PgAdvStrategyManager.getInstance().getStrategyKeeper(this.a).getStrategyDataVersion();
        StrategyItem strategyItem = PgAdvStrategyManager.getInstance().getStrategyKeeper(this.a).getStrategyItem(this.f9067e.c);
        this.f9072j = strategyItem;
        if (strategyItem != null) {
            this.f9067e.b = strategyItem.getTag();
            this.f9067e.f9044e = this.f9072j.getPullTimeOut();
        }
    }

    public void B(us.pinguo.advsdk.a.l lVar) {
        this.c = lVar;
    }

    @Override // us.pinguo.advsdk.a.k
    public void a(us.pinguo.advsdk.a.b bVar) {
        us.pinguo.advsdk.a.l lVar = this.c;
        if (lVar != null) {
            lVar.onPGRewardVideoSuccess(bVar);
        }
    }

    @Override // us.pinguo.advsdk.a.k
    public void b(AdsItem adsItem, us.pinguo.advsdk.a.b bVar) {
        this.f9068f.p();
        us.pinguo.advsdk.utils.b.a(this.f9067e.c + ":onSuccess:" + bVar.l() + ":" + bVar.k());
        StringBuilder sb = new StringBuilder();
        sb.append("current mode is preload:");
        sb.append(this.f9068f.h());
        us.pinguo.advsdk.utils.b.a(sb.toString());
        if (this.f9068f.h()) {
            this.f9068f.l(bVar);
            y(bVar);
            u(bVar);
            return;
        }
        x(adsItem, bVar);
        v(bVar);
    }

    @Override // us.pinguo.advsdk.a.j
    public us.pinguo.advsdk.a.a c(AdsItem adsItem) {
        if (adsItem == null) {
            return null;
        }
        String a2 = adsItem.a();
        if (this.f9069g.containsKey(a2)) {
            us.pinguo.advsdk.utils.b.a("mMapRequestList.containsKey(key)");
            return this.f9069g.get(a2);
        }
        us.pinguo.advsdk.a.a g2 = PgAdvManager.getInstance().q().g(adsItem);
        us.pinguo.advsdk.utils.b.a("createRequestObject.AbsNativeRequest = " + g2);
        if (g2 != null) {
            this.f9069g.put(a2, g2);
            if (this.f9070h != null && g2.h() == 14) {
                g2.j("key_view_binder", this.f9070h);
            }
        }
        return g2;
    }

    @Override // us.pinguo.advsdk.a.k
    public void d(us.pinguo.advsdk.a.b bVar) {
        us.pinguo.advsdk.a.l lVar = this.c;
        if (lVar == null) {
            return;
        }
        lVar.onPGNativeClick(bVar);
    }

    @Override // us.pinguo.advsdk.a.k
    public void e(AdsItem adsItem, String str) {
        us.pinguo.advsdk.utils.b.a(this.f9067e.c + ":all Failed: errmsg:" + str);
        s(101, str);
        t(101, str);
    }

    @Override // us.pinguo.advsdk.a.k
    public void f(us.pinguo.advsdk.a.b bVar) {
        us.pinguo.advsdk.a.l lVar = this.c;
        if (lVar != null) {
            lVar.onPGRewardVideoFailed(bVar);
        }
    }

    @Override // us.pinguo.advsdk.a.k
    public void onAdDestroy(us.pinguo.advsdk.a.b bVar) {
        us.pinguo.advsdk.a.l lVar = this.c;
        if (lVar == null) {
            return;
        }
        lVar.onAdDestroy(bVar);
    }

    @Override // us.pinguo.advsdk.a.k
    public void onRewardVideoClose(us.pinguo.advsdk.a.b bVar) {
        us.pinguo.advsdk.a.l lVar = this.c;
        if (lVar != null) {
            lVar.onPGRewardVideoClose(bVar);
        }
    }

    public void r(Context context, boolean z) {
        if (!PgAdvManager.getInstance().v()) {
            s(103, "advSystem is closed!");
            return;
        }
        us.pinguo.advsdk.utils.b.a("PGEngin:loadPGAD");
        if (this.f9066d.get()) {
            us.pinguo.advsdk.utils.b.a("get ads is loading,not finish");
        } else if (this.f9068f.f() && !this.f9068f.i()) {
            us.pinguo.advsdk.utils.b.a("load third sdk is loading,not finish");
        } else {
            this.f9068f.m(z);
            if (this.f9068f.g()) {
                if (this.f9068f.h()) {
                    return;
                }
                v(this.f9068f.b());
                return;
            }
            us.pinguo.advsdk.utils.b.a("PGEngin:startGetAd");
            this.f9068f.n(System.currentTimeMillis());
            this.f9068f.o();
            p(context);
        }
    }
}
