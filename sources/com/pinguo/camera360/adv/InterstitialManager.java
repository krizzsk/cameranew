package com.pinguo.camera360.adv;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tapjoy.TJAdUnitConstants;
import com.tencent.open.SocialConstants;
import java.util.HashMap;
import us.pinguo.admobvista.AdvPGManager;
import us.pinguo.admobvista.StaticsAdv.IADStatisticBase;
import us.pinguo.advconfigdata.Utils.AdvLog;
import us.pinguo.advconfigdata.Utils.AdvPrefUtil;
import us.pinguo.advsdk.a.l;
import us.pinguo.advsdk.manager.f;
import us.pinguo.advsdk.network.ExpNetWorkUtils;
import us.pinguo.advstrategy.strategybean.StrategyItem;
import us.pinguo.androidsdk.PGImageSDK;
import us.pinguo.foundation.e;
import us.pinguo.foundation.statistics.h;
import us.pinguo.foundation.utils.n;
/* loaded from: classes3.dex */
public class InterstitialManager implements l {

    /* renamed from: d  reason: collision with root package name */
    private static InterstitialManager f6146d;
    private long a = 28800000;
    private long c = 0;
    private HashMap<String, us.pinguo.advsdk.a.b> b = new HashMap<>();

    private InterstitialManager() {
    }

    private void a(String str, String str2) {
        String str3;
        if (str.equals(IADStatisticBase.UNIT_ID_INTERSTITIAL_HOME)) {
            str3 = "home_page";
        } else if (str.equals(IADStatisticBase.UNIT_ID_INTERSTITIAL_ALBUM)) {
            str3 = "album_page";
        } else {
            str3 = str.equals(IADStatisticBase.UNIT_ID_INTERSTITIAL_RESULT) ? "result_page" : "";
        }
        h.b.f0(str3, "interstitial_ads", str2);
    }

    private boolean c(String str) {
        if (IADStatisticBase.UNIT_ID_INTERSTITIAL_HOME_BACKUP.equals(str) || IADStatisticBase.UNIT_ID_INTERSTITIAL_HOME.equals(str)) {
            long j2 = AdvPrefUtil.getInstance().getLong("home_interstitial_show", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - j2 > this.a) {
                AdvPrefUtil.getInstance().putLong("home_interstitial_show", currentTimeMillis);
                return false;
            }
            return true;
        }
        return false;
    }

    private void d(Context context) {
        StrategyItem a = ExpNetWorkUtils.getInstance().a(context, IADStatisticBase.UNIT_ID_INTERSTITIAL_HOME);
        if (a != null) {
            long j2 = a.getadInterval;
            if (j2 > 0) {
                this.a = j2 * 1000;
            }
        }
    }

    public static synchronized InterstitialManager getInstance() {
        InterstitialManager interstitialManager;
        synchronized (InterstitialManager.class) {
            if (f6146d == null) {
                f6146d = new InterstitialManager();
            }
            interstitialManager = f6146d;
        }
        return interstitialManager;
    }

    public us.pinguo.advsdk.a.b b(String str) {
        if (this.b.containsKey(str)) {
            return this.b.get(str);
        }
        return null;
    }

    public void e(String str, Activity activity) {
        if (a.a) {
            return;
        }
        if (this.b.containsKey(str)) {
            AdvLog.Log(TJAdUnitConstants.String.VIDEO_INFO, "================already have a cache ad,stop preload");
            return;
        }
        f loadEngin = AdvPGManager.getInstance().getLoadEngin(e.b(), str);
        if (loadEngin == null || this.b.containsKey(str)) {
            return;
        }
        loadEngin.B(this);
        loadEngin.r(activity, false);
        a(str, SocialConstants.TYPE_REQUEST);
    }

    public void f(String str) {
        if (this.b.containsKey(str)) {
            this.b.remove(str);
        }
    }

    public boolean g(Activity activity, String str) {
        int i2;
        Context applicationContext = activity.getApplicationContext();
        if (a.a) {
            return false;
        }
        int i3 = 10;
        StrategyItem a = ExpNetWorkUtils.getInstance().a(applicationContext, IADStatisticBase.UNIT_ID_GLOBAL);
        if (a != null && (i2 = a.interstitialInterval) > 0) {
            i3 = i2;
        }
        if ((System.currentTimeMillis() / 1000) - this.c < i3) {
            return false;
        }
        ExpNetWorkUtils.getInstance().d(applicationContext, str);
        d(applicationContext);
        if (!this.b.containsKey(str)) {
            AdvLog.Log(TJAdUnitConstants.String.VIDEO_INFO, "================cache not ready");
            return false;
        } else if (IADStatisticBase.UNIT_ID_INTERSTITIAL_PHOTO_PREVIEW.equals(str) && AdvPrefUtil.getInstance().getLong("interstitial_first_show", 0L) == 0) {
            AdvPrefUtil.getInstance().putLong("interstitial_first_show", 1L);
            return false;
        } else if (c(str)) {
            return false;
        } else {
            us.pinguo.advsdk.a.b bVar = this.b.get(str);
            if ("interstitial".equals(bVar.d())) {
                try {
                    bVar.s(activity);
                    a(str, "play");
                } catch (IllegalStateException e2) {
                    e2.printStackTrace();
                }
                this.b.remove(str);
                AdvLog.Log(TJAdUnitConstants.String.VIDEO_INFO, "================show interstitial origin");
            } else {
                Intent intent = new Intent(applicationContext, CommonInterstitialActivity.class);
                intent.putExtra("unit_id", bVar.m());
                intent.addFlags(PGImageSDK.SDK_STATUS_CREATE);
                applicationContext.startActivity(intent);
                AdvLog.Log(TJAdUnitConstants.String.VIDEO_INFO, "================show interstitial native");
            }
            this.c = System.currentTimeMillis() / 1000;
            return true;
        }
    }

    @Override // us.pinguo.advsdk.a.l
    public void onAdDestroy(us.pinguo.advsdk.a.b bVar) {
    }

    @Override // us.pinguo.advsdk.a.l
    public void onPGNativeClick(us.pinguo.advsdk.a.b bVar) {
    }

    @Override // us.pinguo.advsdk.a.l
    public void onPGNativeFailed(int i2, String str) {
        a("", "fail_to_load");
    }

    @Override // us.pinguo.advsdk.a.l
    public void onPGNativeSuccess(us.pinguo.advsdk.a.b bVar) {
        String m = bVar.m();
        this.b.put(m, bVar);
        if (!TextUtils.isEmpty(bVar.g())) {
            n.a.d(Uri.parse(bVar.g()));
        }
        a(m, "success_loaded");
    }

    @Override // us.pinguo.advsdk.a.l
    public void onPGRewardVideoClose(us.pinguo.advsdk.a.b bVar) {
    }

    @Override // us.pinguo.advsdk.a.l
    public void onPGRewardVideoFailed(us.pinguo.advsdk.a.b bVar) {
    }

    @Override // us.pinguo.advsdk.a.l
    public void onPGRewardVideoSuccess(us.pinguo.advsdk.a.b bVar) {
    }

    @Override // us.pinguo.advsdk.a.l
    public void onPreloadFailed(int i2, String str) {
    }

    @Override // us.pinguo.advsdk.a.l
    public void onPreloadSuccess(us.pinguo.advsdk.a.b bVar) {
    }
}
