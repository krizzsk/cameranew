package us.pinguo.advstrategy;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.adjust.sdk.Constants;
import java.util.HashMap;
import java.util.Map;
import us.pinguo.advsdk.PgAdvConstants$Mode;
import us.pinguo.advsdk.a.s;
import us.pinguo.advsdk.a.t;
import us.pinguo.advsdk.manager.PgAdvManager;
import us.pinguo.advsdk.network.ExpNetWorkUtils;
import us.pinguo.advsdk.network.g;
import us.pinguo.advsdk.statistic.StatisticNetWorkHelper;
import us.pinguo.advsdk.statistic.b.a;
import us.pinguo.advsdk.utils.b;
import us.pinguo.advstrategy.strategybean.StrategyItem;
import us.pinguo.bigalbum.db.BigAlbumStore;
/* loaded from: classes3.dex */
public class PgAdvStrategyManager {
    public static final String BroadCast_Data_Change = "pgadv.strategy.data.change";
    private static PgAdvStrategyManager mInstance;
    private s mCallback;
    Context mContext;
    private t mDataKeeper;
    private boolean mbInit = false;
    private final int ONE_HOUR = Constants.ONE_HOUR;
    private boolean mbDisable = false;
    private boolean mbUserAgentInit = false;
    private boolean mbVolleryInit = false;

    PgAdvStrategyManager() {
    }

    public static PgAdvStrategyManager getInstance() {
        if (mInstance == null) {
            mInstance = new PgAdvStrategyManager();
        }
        return mInstance;
    }

    private boolean isStrategyNeedRefresh() {
        if (this.mDataKeeper == null) {
            return false;
        }
        long i2 = PgAdvManager.getInstance().i().i("strategy_refresh");
        int strategyDataInterval = this.mDataKeeper.getStrategyDataInterval();
        if (strategyDataInterval <= 0) {
            strategyDataInterval = Constants.ONE_HOUR;
        }
        if (System.currentTimeMillis() - i2 < strategyDataInterval) {
            b.a("strategy data interval time is not timeout ");
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStrategyFailed(int i2, String str) {
        s sVar = this.mCallback;
        if (sVar != null) {
            sVar.b(i2, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStrategySuccess() {
        s sVar = this.mCallback;
        if (sVar != null) {
            sVar.a();
        }
        Intent intent = new Intent();
        intent.setAction(BroadCast_Data_Change);
        Context context = this.mContext;
        if (context != null) {
            context.sendBroadcast(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportProductTag() {
        Map<String, StrategyItem> strategyItems;
        t tVar = this.mDataKeeper;
        if (tVar == null || this.mContext == null || (strategyItems = tVar.getStrategyItems()) == null || strategyItems.size() == 0) {
            return;
        }
        for (String str : strategyItems.keySet()) {
            ExpNetWorkUtils.getInstance().f(this.mContext, strategyItems.get(str), "overlapping_experiment_prod");
        }
    }

    private void startGetStrategyTask() {
        b.a("PgAdvStrategyManager startGetStrategy");
        if (this.mbInit && this.mDataKeeper != null && !this.mbDisable) {
            HashMap hashMap = new HashMap();
            t tVar = this.mDataKeeper;
            if (tVar != null && !TextUtils.isEmpty(tVar.getStrategyEtag())) {
                hashMap.put(BigAlbumStore.PhotoColumns.ETAG, this.mDataKeeper.getStrategyEtag());
            }
            a.a("exp_req_count", "v");
            us.pinguo.advsdk.statistic.a.a.a("getparam_count", "v");
            if (!StatisticNetWorkHelper.getInstance().e()) {
                onStrategyFailed(1003, "no network");
                a.a("exp_req_nonetwork", "v");
                us.pinguo.advsdk.statistic.a.a.a("getparam_nonetwork", "v");
                return;
            }
            long h2 = PgAdvManager.getInstance().i().h();
            StringBuilder sb = new StringBuilder();
            sb.append(h2 > 0 ? h2 : 1L);
            sb.append("");
            hashMap.put("lastcall", sb.toString());
            b.a("read lastcall：" + h2);
            final long currentTimeMillis = System.currentTimeMillis();
            g k2 = g.k();
            k2.r(PgAdvManager.getInstance().l() + "/api/getParameters/v1", hashMap, new us.pinguo.advsdk.network.b() { // from class: us.pinguo.advstrategy.PgAdvStrategyManager.1
                @Override // us.pinguo.advsdk.network.b
                public void onFailed(int i2, String str) {
                    if (i2 == 304) {
                        PgAdvManager.getInstance().i().c("strategy_refresh", System.currentTimeMillis());
                        a.a("exp_req_304", "v");
                        us.pinguo.advsdk.statistic.a.a.a("getparam_304", "v");
                        return;
                    }
                    a.b("exp_req_fail", str);
                    us.pinguo.advsdk.statistic.a.a.a("getparam_failed", "v");
                    us.pinguo.advsdk.statistic.a.a.a("getparam_failed_info", str);
                    PgAdvStrategyManager.this.onStrategyFailed(1003, str);
                    b.a("strategy load failed:" + str);
                    PgAdvManager.getInstance().i().c("strategy_refresh", 0L);
                }

                @Override // us.pinguo.advsdk.network.b
                public void onSuccess(String str) {
                    a.a("exp_req_consume", "" + (System.currentTimeMillis() - currentTimeMillis));
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    b.a("strategy:" + str);
                    try {
                        PgAdvStrategyManager.this.mDataKeeper.saveAdvData(str.getBytes());
                        PgAdvManager.getInstance().i().c("strategy_refresh", System.currentTimeMillis());
                        PgAdvStrategyManager.this.reportProductTag();
                        PgAdvStrategyManager.this.onStrategySuccess();
                    } catch (Exception e2) {
                        PgAdvStrategyManager.this.onStrategyFailed(1003, e2.getMessage());
                        a.b("exp_req_fail", e2.getMessage());
                        us.pinguo.advsdk.statistic.a.a.a("getparam_failed", "v");
                        us.pinguo.advsdk.statistic.a.a.a("getparam_failed_info", e2.getMessage());
                        b.a("strategy: json error:" + e2.getMessage());
                    }
                    a.a("exp_req_success", "v");
                    us.pinguo.advsdk.statistic.a.a.a("getparam_success", "v");
                }
            });
            return;
        }
        b.a("strategy not inited!");
        onStrategyFailed(1003, "strategy not inited!");
    }

    public t getStrategyKeeper(Context context) {
        if (this.mDataKeeper == null) {
            Context context2 = this.mContext;
            if (context2 != null) {
                context = context2;
            }
            this.mDataKeeper = new AdvStrategyKeeper(context);
        }
        return this.mDataKeeper;
    }

    public PgAdvStrategyManager init(Context context, s sVar) {
        if (this.mContext != null) {
            return this;
        }
        this.mContext = context;
        this.mbInit = true;
        this.mCallback = sVar;
        this.mDataKeeper = new AdvStrategyKeeper(context);
        b.a("PgAdvStrategyManager init() = ");
        return this;
    }

    public void refresh(boolean z) {
        if (!this.mbVolleryInit) {
            b.a("PgAdvStrategyManager mBUserAgentInit = " + this.mbUserAgentInit + " , mVolleryInit = " + this.mbVolleryInit);
            return;
        }
        boolean isStrategyNeedRefresh = isStrategyNeedRefresh();
        boolean z2 = PgAdvManager.getInstance().j() == PgAdvConstants$Mode.MODE_RELEASE;
        b.a("PgAdvStrategyManager isNeedRefresh() = " + isStrategyNeedRefresh);
        if (!z && !isStrategyNeedRefresh && z2) {
            onStrategySuccess();
        } else {
            startGetStrategyTask();
        }
    }

    public void setUserAgentInit(boolean z) {
        b.a("PgAdvStrategyManager setUserAgentInit");
        this.mbUserAgentInit = true;
    }

    public void setVolleryInit(boolean z) {
        b.a("PgAdvStrategyManager setVolleryInit");
        this.mbVolleryInit = true;
        getInstance().refresh(z);
    }
}
