package us.pinguo.advsdk.manager;

import android.app.Activity;
import android.text.TextUtils;
import java.util.HashMap;
import us.pinguo.advsdk.a.b;
import us.pinguo.advsdk.bean.AdsItem;
import us.pinguo.advsdk.utils.AdvPrefUtil;
/* loaded from: classes3.dex */
public class LaunchScreenManager {

    /* renamed from: d  reason: collision with root package name */
    private static LaunchScreenManager f9049d;
    private HashMap<String, us.pinguo.advsdk.a.b> a = new HashMap<>();
    private boolean c = false;
    private com.google.gson.e b = PgAdvManager.getInstance().m();

    private LaunchScreenManager() {
    }

    public static LaunchScreenManager getInstance() {
        if (f9049d == null) {
            f9049d = new LaunchScreenManager();
        }
        return f9049d;
    }

    public void a(String str) {
        AdvPrefUtil advPrefUtil = AdvPrefUtil.getInstance();
        advPrefUtil.h("cache_header" + str, "");
        this.a.clear();
    }

    public AdsItem b(String str) {
        AdsItem adsItem;
        String e2 = AdvPrefUtil.getInstance().e("cache_header" + str, "");
        if (TextUtils.isEmpty(e2)) {
            return null;
        }
        String[] split = e2.split(";");
        if (split.length != 2) {
            return null;
        }
        String str2 = split[0];
        String str3 = split[1];
        try {
            adsItem = (AdsItem) this.b.j(str2, AdsItem.class);
        } catch (Exception e3) {
            e3.printStackTrace();
            adsItem = null;
        }
        if (adsItem == null) {
            return null;
        }
        if (adsItem.cacheTime < (System.currentTimeMillis() - Long.valueOf(str3).longValue()) / 1000) {
            AdvPrefUtil.getInstance().h("cache_header" + str, "");
            return null;
        } else if (TextUtils.isEmpty(adsItem.video.url) && TextUtils.isEmpty(adsItem.image.url)) {
            return null;
        } else {
            boolean d2 = PgAdvManager.getInstance().n().d(adsItem.video.url);
            if (TextUtils.isEmpty(adsItem.video.url) || d2) {
                boolean d3 = PgAdvManager.getInstance().n().d(adsItem.image.url);
                if (TextUtils.isEmpty(adsItem.image.url) || d3) {
                    if (TextUtils.isEmpty(adsItem.iconUrl) || PgAdvManager.getInstance().n().d(adsItem.iconUrl)) {
                        return adsItem;
                    }
                    return null;
                }
                return null;
            }
            return null;
        }
    }

    public boolean c() {
        return this.c;
    }

    public void d(AdsItem adsItem, us.pinguo.advsdk.a.b bVar) {
        if ("third_sdk".equals(adsItem.deliverType)) {
            if (!this.a.containsKey(bVar.m())) {
                this.c = false;
                this.a.put(bVar.m(), bVar);
                return;
            }
            us.pinguo.advsdk.utils.b.a("already have a cache ad,stop preload !!!!!!");
        } else if ("dsp".equals(adsItem.deliverType)) {
            this.c = true;
            String str = this.b.s(adsItem) + ";" + System.currentTimeMillis();
            AdvPrefUtil.getInstance().h("cache_header" + bVar.m(), str);
        }
    }

    public void e(boolean z) {
    }

    public void f(Activity activity, String str, b.InterfaceC0356b interfaceC0356b) {
        if (this.a.containsKey(str)) {
            try {
                this.a.get(str).t(activity, interfaceC0356b);
            } catch (IllegalStateException e2) {
                e2.printStackTrace();
            }
            this.a.remove(str);
            return;
        }
        us.pinguo.advsdk.utils.b.a("launchScreen ad no cache !!!!!!");
    }

    public boolean g(String str) {
        return this.a.containsKey(str);
    }
}
