package us.pinguo.admobvista;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.HashMap;
import us.pinguo.admobvista.StaticsAdv.IADStatisticBase;
import us.pinguo.advconfigdata.AdvConfigManager;
import us.pinguo.advconfigdata.Utils.SPUtils;
import us.pinguo.advsdk.PgAdvConstants$Mode;
import us.pinguo.advsdk.manager.PgAdvManager;
import us.pinguo.advsdk.manager.f;
import us.pinguo.advsdk.network.ExpNetWorkUtils;
import us.pinguo.advstrategy.PgAdvStrategyManager;
import us.pinguo.inspire.module.feeds.model.PortalFollowFeeds;
/* loaded from: classes3.dex */
public class AdvPGManager {
    private static final String ADMOB_META_KEY = "com.google.android.gms.ads.APPLICATION_ID";
    private static final String APP_ID = "Camera360";
    private static final String APP_SECRET = "49BC34172930E461AFA65C3C7ACFCEC2";
    private static AdvPGManager mAdvPGManager;
    private boolean bHuaWeiChannel;
    private boolean bOppoChannel;
    private boolean bXiaomiChannel;
    private final String ADMOB_APP_ID = "ca-app-pub-4517126100878162~5457598336";
    private HashMap<String, f> mLoadEnginCacheMap = new HashMap<>();

    private AdvPGManager() {
    }

    public static synchronized AdvPGManager getInstance() {
        AdvPGManager advPGManager;
        synchronized (AdvPGManager.class) {
            if (mAdvPGManager == null) {
                mAdvPGManager = new AdvPGManager();
            }
            advPGManager = mAdvPGManager;
        }
        return advPGManager;
    }

    private long getStampTime() {
        String initStamp = AdvConfigManager.getInstance().getInitStamp();
        if (TextUtils.isEmpty(initStamp)) {
            return 0L;
        }
        try {
            return Long.parseLong(initStamp);
        } catch (Exception unused) {
            return 0L;
        }
    }

    private void initIronSource(Context context) {
        if (PgAdvStrategyManager.getInstance().getStrategyKeeper(context).getGlobleOpenKey(IADStatisticBase.UNIT_ID_GLOBAL, "init_ironsource_c360")) {
            PgAdvManager.getInstance().q().e(new com.pgadv.ironsource.a(context, false, "7f08e335"));
        }
    }

    private void initPangle(Application application) {
        if (PgAdvStrategyManager.getInstance().getStrategyKeeper(application).getGlobleOpenKey(IADStatisticBase.UNIT_ID_GLOBAL, "init_pangle")) {
            PgAdvManager.getInstance().q().e(new com.pgadv.pangle.a(application, false, "5117939", "CAMERA360"));
        }
    }

    private void initSmaato(Context context) {
        if (PgAdvStrategyManager.getInstance().getStrategyKeeper(context).getGlobleOpenKey(IADStatisticBase.UNIT_ID_GLOBAL, "init_smaato_c360")) {
            PgAdvManager.getInstance().q().e(new us.pinguo.smaato.a(context, false, "1100045358"));
        }
    }

    private void updateAdvData(Context context) {
        if (System.currentTimeMillis() - ((Long) SPUtils.get(context, "adv_data_last_update_time", 0L)).longValue() <= 10000) {
            return;
        }
        AdvConfigManager.getInstance().forceUpdate(false);
        SPUtils.put(context, "adv_data_last_update_time", Long.valueOf(System.currentTimeMillis()));
    }

    public f getLoadEngin(Context context, String str) {
        if (ExpNetWorkUtils.getInstance().b(context, str)) {
            if (this.mLoadEnginCacheMap.containsKey(str)) {
                return this.mLoadEnginCacheMap.get(str);
            }
            HashMap hashMap = new HashMap();
            hashMap.put("cache_num", "1");
            hashMap.put("pg_unit_id", str);
            f fVar = new f(context, hashMap);
            this.mLoadEnginCacheMap.put(str, fVar);
            return fVar;
        }
        return null;
    }

    public void huaweiReportRegister(Context context, String str) {
        if (context != null && e.b.d(context).f()) {
            e.b.d(context).i(str);
        }
    }

    public void initSDK(Application application, PgAdvConstants$Mode pgAdvConstants$Mode, String str, String str2) {
        String str3;
        this.bHuaWeiChannel = e.b.d(application).f();
        this.bOppoChannel = g.a.a(application);
        boolean a = l.a.a(application);
        this.bXiaomiChannel = a;
        if (this.bHuaWeiChannel) {
            str3 = e.b.d(application).c();
        } else {
            str3 = this.bOppoChannel ? "ca-app-pub-7896437770268086~1143787094" : a ? "ca-app-pub-4876024679786892~5826901354" : "ca-app-pub-4517126100878162~5457598336";
        }
        try {
            application.getPackageManager().getApplicationInfo(application.getPackageName(), 128).metaData.putString(ADMOB_META_KEY, str3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        PgAdvManager.getInstance().q().e(new com.pgadv.admob.a(application, true, str3));
        if (this.bHuaWeiChannel) {
            Log.i("HuaweiPreInstall", "=============Channel is  huawei");
        } else {
            Log.i("HuaweiPreInstall", "=============Channel is not huawei");
        }
        if (this.bXiaomiChannel) {
            Log.i("XiaomiPreInstall", "=============Channel is xiaomi");
        } else {
            Log.i("XiaomiPreInstall", "=============Channel is not xiaomi");
        }
        if (!this.bHuaWeiChannel && !this.bOppoChannel && !this.bXiaomiChannel) {
            PgAdvManager.getInstance().q().e(new com.pgadv.facebook.a(application, false));
            initSmaato(application);
            initIronSource(application);
            initPangle(application);
        }
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(application);
        PgAdvManager.getInstance().z(pgAdvConstants$Mode);
        if (this.bHuaWeiChannel) {
            PgAdvManager.getInstance().B(e.b.b);
            firebaseAnalytics.setUserProperty("pre_install_type", e.b.f8628d);
            e.b.d(application).h(application);
        } else if (this.bOppoChannel) {
            PgAdvManager.getInstance().B("oppo");
            firebaseAnalytics.setUserProperty("pre_install_type", "OppoPreInstall");
        } else if (this.bXiaomiChannel) {
            PgAdvManager.getInstance().B("xiaomi");
            firebaseAnalytics.setUserProperty("pre_install_type", "XiaomiPreInstall");
        } else {
            firebaseAnalytics.setUserProperty("pre_install_type", PortalFollowFeeds.TYPE_NONE);
        }
        PgAdvManager.getInstance().A(str2);
        PgAdvManager.getInstance().s(application, getStampTime(), new e(), new PGAdvStatitics(application));
        PgAdvManager pgAdvManager = PgAdvManager.getInstance();
        if (TextUtils.isEmpty(str)) {
            str = "GoogleMarket";
        }
        pgAdvManager.u(application, APP_ID, APP_SECRET, str);
        updateAdvData(application);
    }
}
