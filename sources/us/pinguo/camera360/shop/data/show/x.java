package us.pinguo.camera360.shop.data.show;

import android.os.Handler;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.JsonSyntaxException;
import com.pinguo.camera360.vip.VipManager;
import com.pinguo.lib.GsonUtilKt;
import com.tencent.open.SocialConstants;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.CountDownLatch;
import rx.Subscription;
import rx.functions.Action1;
import us.pinguo.camera360.shop.bean.Package;
import us.pinguo.camera360.shop.bean.PayInfo;
import us.pinguo.camera360.shop.bean.Scene;
import us.pinguo.camera360.shop.bean.ShopData;
import us.pinguo.camera360.shop.bean.ShopJson;
import us.pinguo.camera360.shop.bean.Topic;
import us.pinguo.camera360.shop.data.FilterType;
import us.pinguo.camera360.shop.data.show.UnlockManager;
import us.pinguo.camera360.shop.download.BaseDownloader;
import us.pinguo.camera360.shop.download.RequestIntervalPref;
import us.pinguo.camera360.shop.manager.ExceptionStatManager;
import us.pinguo.common.network.RxVolley;
import us.pinguo.common.network.common.PGNetworkConfig;
import us.pinguo.common.network.pgrequest.PGRequest;
import us.pinguo.common.network.request.VolleyBaseRequest;
import us.pinguo.inspire.module.profile.InspireLocationManager;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
import us.pinguo.librouter.application.BaseApplication;
import us.pinguo.user.User;
import us.pinguo.user.u0;
import vStudio.Android.Camera360.Conditions;
/* compiled from: ShowSceneCache.java */
/* loaded from: classes4.dex */
public class x {
    private static final byte[] n = new byte[0];

    /* renamed from: g  reason: collision with root package name */
    private final String f9653g;

    /* renamed from: h  reason: collision with root package name */
    private final Handler f9654h;

    /* renamed from: i  reason: collision with root package name */
    private UnlockManager f9655i;

    /* renamed from: j  reason: collision with root package name */
    private Subscription f9656j;
    private boolean a = false;
    private boolean b = true;
    private volatile ShopData c = null;

    /* renamed from: d  reason: collision with root package name */
    private volatile Map<String, ShowPkg> f9650d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private volatile Map<String, ShowPkg> f9651e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    private volatile Map<String, ShowTopic> f9652f = new HashMap();

    /* renamed from: k  reason: collision with root package name */
    private List<s> f9657k = new ArrayList(5);

    /* renamed from: l  reason: collision with root package name */
    private boolean f9658l = false;
    private boolean m = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ShowSceneCache.java */
    /* loaded from: classes4.dex */
    public class a implements UnlockManager.g {
        final /* synthetic */ CountDownLatch a;
        final /* synthetic */ boolean b;
        final /* synthetic */ s c;

        a(CountDownLatch countDownLatch, boolean z, s sVar) {
            this.a = countDownLatch;
            this.b = z;
            this.c = sVar;
        }

        @Override // us.pinguo.camera360.shop.data.show.UnlockManager.g
        public void R(String str) {
            RequestIntervalPref.a.g(u0.f12384f, 0L, null);
            this.a.countDown();
            us.pinguo.common.log.a.m("chenxiaokai", "==========>order success", new Object[0]);
            if (this.b || this.c == null) {
                return;
            }
            try {
                List<ShowScene> k2 = x.this.k(false);
                x xVar = x.this;
                xVar.v(xVar.f9657k, k2);
            } catch (Exception e2) {
                us.pinguo.common.log.a.f(e2);
                x xVar2 = x.this;
                xVar2.u(xVar2.f9657k);
            }
        }

        @Override // us.pinguo.camera360.shop.data.show.UnlockManager.g
        public void b0() {
            RequestIntervalPref.a.g(u0.f12384f, 0L, null);
            this.a.countDown();
            us.pinguo.common.log.a.m("chenxiaokai", "==========>order no update", new Object[0]);
            if (this.b || this.c == null) {
                return;
            }
            x xVar = x.this;
            xVar.u(xVar.f9657k);
        }

        @Override // us.pinguo.camera360.shop.data.show.UnlockManager.g
        public void h0() {
            this.a.countDown();
            us.pinguo.common.log.a.m("chenxiaokai", "==========>order failed", new Object[0]);
            if (this.b || this.c == null) {
                return;
            }
            x xVar = x.this;
            xVar.u(xVar.f9657k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(String str, UnlockManager unlockManager, Handler handler) {
        this.f9653g = str;
        this.f9654h = handler;
        this.f9655i = unlockManager;
    }

    private void d(s sVar) {
        if (sVar != null && this.f9657k.indexOf(sVar) < 0) {
            this.f9657k.add(sVar);
        }
    }

    private ShopData e() {
        ShopJson shopJson;
        String str = this.f9653g + "shop.json";
        if (new File(str).exists()) {
            synchronized (n) {
                try {
                    shopJson = h(InspirePublishFragment.FILE_HEADER + str, null);
                } catch (Exception e2) {
                    us.pinguo.common.log.a.f(e2);
                    shopJson = null;
                }
            }
        } else {
            shopJson = null;
        }
        if (shopJson == null) {
            return null;
        }
        return shopJson.data;
    }

    private String g() {
        Locale a2 = us.pinguo.foundation.utils.v.a();
        String language = a2.getLanguage();
        String lowerCase = a2.getCountry().toLowerCase(Locale.ENGLISH);
        StringBuilder sb = new StringBuilder();
        sb.append(language);
        sb.append("_");
        sb.append(lowerCase);
        return sb.toString().equals(InspireLocationManager.ZH_CN) ? "assets://shop/shop_zh_cn.json" : "assets://shop/shop_en.json";
    }

    private ShopJson h(String str, Object obj) throws Exception {
        Reader reader = null;
        try {
            reader = new BaseDownloader(BaseApplication.d()).c(str, obj);
            ShopJson shopJson = (ShopJson) GsonUtilKt.getCachedGson().h(reader, ShopJson.class);
            us.pinguo.util.f.a(reader);
            return shopJson;
        } catch (Throwable th) {
            us.pinguo.util.f.a(reader);
            throw th;
        }
    }

    private synchronized List<ShowScene> j(ShopData shopData, boolean z, boolean z2) {
        Scene[] sceneArr;
        ArrayList arrayList;
        PayInfo payInfo;
        Package[] packageArr = shopData.packages;
        if (packageArr != null && (sceneArr = shopData.scenes) != null && packageArr.length != 0 && sceneArr.length != 0) {
            long currentTimeMillis = (System.currentTimeMillis() + TimeZone.getDefault().getRawOffset()) - 28800000;
            if (z) {
                currentTimeMillis = 0;
            }
            boolean z3 = this.a && this.f9655i.p() != null;
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            Package[] packageArr2 = shopData.packages;
            int length = packageArr2.length;
            int i2 = 0;
            while (i2 < length) {
                Package r7 = packageArr2[i2];
                int i3 = i2;
                ShowPkg showPkg = r7.toShowPkg(z3, this.b, currentTimeMillis, false);
                if ((Conditions.d() || Conditions.e() || Conditions.c()) && (payInfo = r7.pay_info) != null) {
                    if (payInfo.price.contains("1.99")) {
                        r7.pay_info.price = VipManager.a.r("urban_night");
                    } else if (r7.pay_info.price.contains("0.99")) {
                        r7.pay_info.price = VipManager.a.r("c_7_2");
                    }
                }
                if (showPkg != null) {
                    if (showPkg.getPackageType() == FilterType.Loc && !us.pinguo.camera360.loc.c.f()) {
                        hashMap2.put(r7.pid, showPkg);
                    } else {
                        hashMap.put(r7.pid, showPkg);
                    }
                }
                i2 = i3 + 1;
            }
            if (!hashMap.isEmpty()) {
                HashMap hashMap3 = new HashMap();
                Topic[] topicArr = shopData.topics;
                if (topicArr != null) {
                    for (Topic topic : topicArr) {
                        ShowTopic showTopicForPkg = topic.toShowTopicForPkg(currentTimeMillis, hashMap);
                        if (showTopicForPkg != null) {
                            hashMap3.put(topic.topic_id, showTopicForPkg);
                        }
                    }
                }
                arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                Scene[] sceneArr2 = shopData.scenes;
                List<Scene> asList = Arrays.asList((Scene[]) Arrays.copyOf(sceneArr2, sceneArr2.length));
                if (z2) {
                    Collections.sort(asList, h.a);
                }
                for (Scene scene : asList) {
                    ShowScene l2 = l(scene, hashMap, hashMap3);
                    if (l2 != null) {
                        arrayList.add(l2);
                    }
                }
                for (Scene scene2 : shopData.scenes) {
                    ShowScene l3 = l(scene2, hashMap, hashMap3);
                    if (l3 != null) {
                        arrayList2.add(l3);
                    }
                }
                if (!arrayList.isEmpty()) {
                    if (z) {
                        t.f().q(hashMap.values(), hashMap3.values(), arrayList2, false);
                    } else if (t.f().r(hashMap.values(), hashMap3.values(), arrayList2)) {
                        us.pinguo.foundation.q.a.g(BaseApplication.d());
                    }
                    this.f9650d = hashMap;
                    this.f9651e = hashMap2;
                    this.f9652f = hashMap3;
                } else {
                    throw new IllegalArgumentException("error, empty scenes");
                }
            } else {
                throw new IllegalArgumentException("error, empty package");
            }
        } else {
            throw new IllegalArgumentException("error");
        }
        return arrayList;
    }

    private ShowScene l(Scene scene, Map<String, ShowPkg> map, Map<String, ShowTopic> map2) {
        if (scene == null) {
            return null;
        }
        ShowScene showPage = scene.getShowPage();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (showPage != null) {
            String[] strArr = scene.package_ids;
            if (strArr != null) {
                for (String str : strArr) {
                    ShowPkg showPkg = map.get(str);
                    if (showPkg != null) {
                        showPkg.setCategoryId(scene.id);
                        arrayList.add(showPkg);
                    }
                }
            }
            String[] strArr2 = scene.topic_group_ids;
            if (strArr2 != null) {
                for (String str2 : strArr2) {
                    ShowTopic showTopic = map2.get(str2);
                    if (showTopic != null) {
                        arrayList2.add(showTopic);
                    }
                }
            }
            showPage.set(arrayList, arrayList2);
            if (scene.show_in_camera == 1) {
                ArrayList arrayList3 = new ArrayList();
                String[] strArr3 = scene.products_in_camera;
                if (strArr3 != null) {
                    for (String str3 : strArr3) {
                        ShowPkg showPkg2 = map.get(str3);
                        if (showPkg2 != null) {
                            showPkg2.setCategoryId(scene.id);
                            arrayList3.add(showPkg2);
                        }
                    }
                }
                showPage.setShowPkgListInCamera(arrayList3);
            }
            if (showPage.isOk()) {
                return showPage;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int m(Scene scene, Scene scene2) {
        return scene2.editPriority - scene.editPriority;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public /* synthetic */ void q(long j2, VolleyBaseRequest volleyBaseRequest, CountDownLatch countDownLatch, String str) {
        int i2;
        us.pinguo.foundation.statistics.i iVar = us.pinguo.foundation.statistics.h.b;
        iVar.n((System.currentTimeMillis() - j2) + "", "/api/product/query", FirebaseAnalytics.Param.SUCCESS);
        us.pinguo.common.log.a.m("chenxiaokai", "==========>11", new Object[0]);
        try {
            ShopJson shopJson = (ShopJson) GsonUtilKt.getCachedGson().j(str, ShopJson.class);
            if (shopJson == null || !((i2 = shopJson.status) == 200 || i2 == 420 || i2 == 10220)) {
                ExceptionStatManager.getInstance().g(volleyBaseRequest, Integer.valueOf(shopJson != null ? shopJson.status : 0));
                t(this.f9657k, new IOException("error data"));
                us.pinguo.common.log.a.m("chenxiaokai", "==========>error data1", new Object[0]);
            } else if (i2 == 420) {
                t(this.f9657k, new IOException("user time out"));
                us.pinguo.common.log.a.m("chenxiaokai", "==========>user time out", new Object[0]);
                User.E();
            } else if (i2 == 10220) {
                u(this.f9657k);
                us.pinguo.common.log.a.m("chenxiaokai", "==========>onNoUpdate", new Object[0]);
                RequestIntervalPref.a.g(us.pinguo.camera360.shop.download.a.b, -1L, null);
            } else if (!shopJson.isOk()) {
                t(this.f9657k, new IOException("error data"));
                us.pinguo.common.log.a.m("chenxiaokai", "==========>error data2", new Object[0]);
            } else {
                us.pinguo.common.log.a.m("chenxiaokai", "==========>12", new Object[0]);
                synchronized (n) {
                    try {
                        us.pinguo.util.k.i(this.f9653g + "shop.json", str.getBytes("utf-8"));
                    } catch (Exception e2) {
                        t(this.f9657k, e2);
                        us.pinguo.common.log.a.m("chenxiaokai", "==========>exception2", new Object[0]);
                        return;
                    }
                }
                us.pinguo.common.log.a.m("chenxiaokai", "==========>13", new Object[0]);
                try {
                    countDownLatch.await();
                    us.pinguo.common.log.a.m("chenxiaokai", "==========>count=" + countDownLatch.getCount(), new Object[0]);
                } catch (InterruptedException unused) {
                }
                ShopData shopData = shopJson.data;
                if (shopData == null) {
                    return;
                }
                RequestIntervalPref.a.g(us.pinguo.camera360.shop.download.a.b, shopData.interval * 1000, null);
                this.c = shopData;
                try {
                    this.f9658l = false;
                    v(this.f9657k, j(this.c, this.f9658l, this.m));
                } catch (Exception e3) {
                    t(this.f9657k, e3);
                }
                us.pinguo.common.log.a.m("chenxiaokai", "==========>onUpdated", new Object[0]);
            }
        } catch (Exception e4) {
            if (e4 instanceof JsonSyntaxException) {
                ExceptionStatManager.getInstance().f(volleyBaseRequest, e4.getMessage());
            }
            t(this.f9657k, e4);
            us.pinguo.common.log.a.m("chenxiaokai", "==========>exception1", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public /* synthetic */ void s(long j2, VolleyBaseRequest volleyBaseRequest, Throwable th) {
        us.pinguo.foundation.statistics.i iVar = us.pinguo.foundation.statistics.h.b;
        iVar.n((System.currentTimeMillis() - j2) + "", "/api/product/query", "failed");
        ExceptionStatManager.getInstance().h(volleyBaseRequest, th);
        us.pinguo.foundation.e.e(th);
        us.pinguo.common.log.a.f(th);
        t(this.f9657k, new Exception(th));
    }

    private void t(List<s> list, final Exception exc) {
        for (final s sVar : list) {
            if (sVar != null) {
                this.f9654h.post(new Runnable() { // from class: us.pinguo.camera360.shop.data.show.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        s.this.c(exc);
                    }
                });
            }
        }
        list.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(List<s> list) {
        for (final s sVar : list) {
            if (sVar != null) {
                Handler handler = this.f9654h;
                Objects.requireNonNull(sVar);
                handler.post(new Runnable() { // from class: us.pinguo.camera360.shop.data.show.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        s.this.a();
                    }
                });
            }
        }
        list.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(List<s> list, final List<ShowScene> list2) {
        for (final s sVar : list) {
            if (sVar != null) {
                this.f9654h.post(new Runnable() { // from class: us.pinguo.camera360.shop.data.show.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        s.this.b(list2);
                    }
                });
            }
        }
        list.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShowTopic f(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.c == null) {
            try {
                k(this.m);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return this.f9652f.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShowPkg i(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.c == null) {
            try {
                k(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (z) {
            return this.f9651e.get(str);
        }
        return this.f9650d.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized List<ShowScene> k(boolean z) throws Exception {
        if (this.c == null) {
            ShopData e2 = e();
            if (e2 == null) {
                this.f9658l = true;
                this.c = h(g(), null).data;
                return j(this.c, this.f9658l, z);
            }
            this.c = e2;
            this.f9658l = false;
        }
        try {
            return j(this.c, this.f9658l, z);
        } catch (Exception e3) {
            us.pinguo.common.log.a.f(e3);
            this.f9658l = true;
            this.c = h(g(), null).data;
            return j(this.c, this.f9658l, z);
        }
    }

    public void w() {
        this.f9657k.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(boolean z) {
        this.a = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(boolean z) {
        this.b = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean z(s sVar, boolean z) {
        CountDownLatch countDownLatch;
        d(sVar);
        Subscription subscription = this.f9656j;
        if (subscription == null || subscription.isUnsubscribed()) {
            if (us.pinguo.util.q.f(BaseApplication.d())) {
                RequestIntervalPref requestIntervalPref = RequestIntervalPref.a;
                String str = us.pinguo.camera360.shop.download.a.b;
                RequestIntervalPref.RefreshType e2 = requestIntervalPref.e(str, -1L, null);
                RequestIntervalPref.RefreshType e3 = requestIntervalPref.e(u0.f12384f, requestIntervalPref.c(str, null), null);
                int b = us.pinguo.foundation.base.e.b(BaseApplication.d(), "pref_key_newshop_order_version");
                boolean z2 = z || e2 != RequestIntervalPref.RefreshType.NONE_REFRESH;
                boolean z3 = (z || e3 != RequestIntervalPref.RefreshType.NONE_REFRESH) && b == 0;
                if (z2 || z3) {
                    if (z3) {
                        countDownLatch = new CountDownLatch(1);
                        this.f9655i.N(b, new a(countDownLatch, z2, sVar));
                    } else {
                        countDownLatch = new CountDownLatch(0);
                        if (!z2) {
                            return false;
                        }
                    }
                    final CountDownLatch countDownLatch2 = countDownLatch;
                    us.pinguo.common.log.a.m("chenxiaokai", "==========>1", new Object[0]);
                    if (z2) {
                        us.pinguo.common.log.a.m("chenxiaokai", "==========>2", new Object[0]);
                        if (this.c == null) {
                            this.c = e();
                        }
                        PGRequest.Builder builder = new PGRequest.Builder(String.class);
                        builder.withMethod(1).withDomain(us.pinguo.camera360.shop.download.a.a).withUriPath("/api/product/query");
                        if (User.d().n()) {
                            builder.withUid(User.d().h().userId);
                        }
                        if (e2 == RequestIntervalPref.RefreshType.RESET_REFRESH) {
                            Locale a2 = us.pinguo.foundation.utils.v.a();
                            String language = a2.getLanguage();
                            String country = a2.getCountry();
                            if (country == null) {
                                country = "";
                            }
                            PGNetworkConfig.getInstance().resetLocale(language, country);
                            builder.addParam("version", String.valueOf(0));
                        } else {
                            builder.addParam("version", String.valueOf(this.c == null ? 0 : this.c.version));
                        }
                        us.pinguo.foundation.statistics.h.b.n("", "/api/product/query", SocialConstants.TYPE_REQUEST);
                        final long currentTimeMillis = System.currentTimeMillis();
                        final PGRequest build = builder.build();
                        this.f9656j = RxVolley.create(build).subscribe(new Action1() { // from class: us.pinguo.camera360.shop.data.show.j
                            @Override // rx.functions.Action1
                            public final void call(Object obj) {
                                x.this.q(currentTimeMillis, build, countDownLatch2, (String) obj);
                            }
                        }, new Action1() { // from class: us.pinguo.camera360.shop.data.show.i
                            @Override // rx.functions.Action1
                            public final void call(Object obj) {
                                x.this.s(currentTimeMillis, build, (Throwable) obj);
                            }
                        });
                        us.pinguo.common.log.a.m("chenxiaokai", "==========>3", new Object[0]);
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
        return true;
    }
}
