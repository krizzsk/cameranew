package us.pinguo.advstrategy;

import android.content.Context;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import us.pinguo.advsdk.a.t;
import us.pinguo.advsdk.manager.PgAdvManager;
import us.pinguo.advsdk.utils.a;
import us.pinguo.advsdk.utils.b;
import us.pinguo.advstrategy.strategybean.StrategyData;
import us.pinguo.advstrategy.strategybean.StrategyItem;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class AdvStrategyKeeper extends t {
    private Context mContext;
    private StrategyData mStrategyData;
    private Map<String, StrategyItem> mStrategys;
    private final String LOCAL_RELATIVE_PATH = "/pgsdk/strategy.json";
    private AtomicBoolean mCacheDirty = new AtomicBoolean(true);
    private long mLastTimeUpdate = 0;
    private String mCacheJsonData = "";
    private StrategyConfig mStrategyConfig = new StrategyConfig();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class StrategyConfig {
        private String mCountryCode;
        private String mEtag;
        private String mExpVersion;
        private int mInterval;
        private String mReportHost;

        private StrategyConfig() {
        }

        public String getCountryCode() {
            return this.mCountryCode;
        }

        public String getEtag() {
            return this.mEtag;
        }

        public String getExpVersion() {
            return this.mExpVersion;
        }

        public int getInterval() {
            return this.mInterval;
        }

        public String getReportHost() {
            return this.mReportHost;
        }

        public void setCountryCode(String str) {
            this.mCountryCode = str;
        }

        public void setEtag(String str) {
            this.mEtag = str;
        }

        public void setExpVersion(String str) {
            this.mExpVersion = str;
        }

        public void setInterval(int i2) {
            this.mInterval = i2;
        }

        public void setReportHost(String str) {
            this.mReportHost = str;
        }
    }

    public AdvStrategyKeeper(Context context) {
        this.mContext = context;
    }

    private String getAdvDir(Context context) {
        File filesDir;
        if (context == null || (filesDir = context.getFilesDir()) == null) {
            return null;
        }
        return filesDir.getAbsolutePath();
    }

    private synchronized StrategyData getStrategyData() {
        String str;
        StrategyData strategyData;
        String advDir = getAdvDir(this.mContext);
        if (TextUtils.isEmpty(advDir)) {
            b.a("dirpath is null");
            return null;
        }
        String str2 = advDir + "/pgsdk/strategy.json";
        try {
            str = new String(a.e(str2));
        } catch (Exception unused) {
            str = "";
            if (new File(str2).exists()) {
                b.a("advdata file is read error");
            }
        }
        b.a("getStrategyData data:" + str);
        if (TextUtils.isEmpty(str) || !str.equals(this.mCacheJsonData) || (strategyData = this.mStrategyData) == null) {
            this.mCacheJsonData = str;
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.mStrategyData = (StrategyData) PgAdvManager.getInstance().m().j(str, StrategyData.class);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (this.mStrategyData == null) {
                this.mStrategyData = getDefaultData();
            }
            return this.mStrategyData;
        }
        return strategyData;
    }

    private synchronized void updateData() {
        if (this.mCacheDirty.compareAndSet(true, false) || System.currentTimeMillis() - this.mLastTimeUpdate > 3600000) {
            this.mLastTimeUpdate = System.currentTimeMillis();
            StrategyData strategyData = getStrategyData();
            if (strategyData != null && strategyData.parameters != null) {
                if (this.mStrategys == null) {
                    this.mStrategys = new HashMap();
                }
                this.mStrategys.clear();
                this.mStrategyConfig.setExpVersion(strategyData.exp_version);
                this.mStrategyConfig.setInterval(strategyData.interval);
                this.mStrategyConfig.setCountryCode(strategyData.country_code);
                this.mStrategyConfig.setEtag(strategyData.etag);
                this.mStrategyConfig.setReportHost(strategyData.adhost);
                Iterator<StrategyItem> it = strategyData.parameters.iterator();
                while (it.hasNext()) {
                    StrategyItem next = it.next();
                    if (!TextUtils.isEmpty(next.unit_id) && !this.mStrategys.containsKey(next.unit_id)) {
                        this.mStrategys.put(next.unit_id, next);
                    }
                }
            }
        }
    }

    synchronized void clearAdvData() {
        String advDir = getAdvDir(this.mContext);
        if (TextUtils.isEmpty(advDir)) {
            return;
        }
        try {
            new File(advDir + "/pgsdk/strategy.json").delete();
            this.mCacheDirty.set(true);
        } catch (Exception unused) {
        }
    }

    @Override // us.pinguo.advsdk.a.t
    public String getAppHost() {
        updateData();
        return this.mStrategyConfig.getReportHost();
    }

    @Override // us.pinguo.advsdk.a.t
    public String getCountryCode() {
        updateData();
        return this.mStrategyConfig.getCountryCode();
    }

    public StrategyData getDefaultData() {
        String fromAssets = getFromAssets("StrategyDataJson.txt");
        b.a("getDefaultData\u3000json = " + fromAssets);
        try {
            return (StrategyData) PgAdvManager.getInstance().m().j(fromAssets, StrategyData.class);
        } catch (Exception e2) {
            b.a("getDefaultStrategyData\u3000fromJson error= " + e2);
            return null;
        }
    }

    public String getFromAssets(String str) {
        String str2 = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.mContext.getResources().getAssets().open(str)));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return str2;
                }
                str2 = str2 + readLine;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return str2;
        }
    }

    @Override // us.pinguo.advsdk.a.t
    public boolean getGlobleOpenKey(String str, String str2) {
        ArrayList<String> arrayList;
        StrategyItem strategyItem = getStrategyItem(str);
        return (strategyItem == null || (arrayList = strategyItem.open_key) == null || arrayList.isEmpty() || !arrayList.contains(str2)) ? false : true;
    }

    @Override // us.pinguo.advsdk.a.t
    public int getStrategyDataInterval() {
        updateData();
        return this.mStrategyConfig.getInterval() * 1000;
    }

    @Override // us.pinguo.advsdk.a.t
    public synchronized String getStrategyDataVersion() {
        updateData();
        return this.mStrategyConfig.getExpVersion();
    }

    @Override // us.pinguo.advsdk.a.t
    public String getStrategyEtag() {
        updateData();
        return this.mStrategyConfig.getEtag();
    }

    @Override // us.pinguo.advsdk.a.t
    public StrategyItem getStrategyItem(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        updateData();
        Map<String, StrategyItem> map = this.mStrategys;
        if (map != null && map.containsKey(str)) {
            return this.mStrategys.get(str);
        }
        return null;
    }

    @Override // us.pinguo.advsdk.a.t
    public Map<String, StrategyItem> getStrategyItems() {
        updateData();
        return this.mStrategys;
    }

    @Override // us.pinguo.advsdk.a.t
    public String getUpdateInfo(String str) {
        updateData();
        StrategyItem strategyItem = getStrategyItem(str);
        if (strategyItem == null) {
            return null;
        }
        return strategyItem.getUpdateInfo();
    }

    @Override // us.pinguo.advsdk.a.t
    public synchronized boolean saveAdvData(byte[] bArr) {
        clearAdvData();
        String advDir = getAdvDir(this.mContext);
        if (TextUtils.isEmpty(advDir)) {
            b.a("dirpath is null");
            return false;
        }
        String str = advDir + "/pgsdk/strategy.json";
        try {
            b.a("saveAdvData data:" + new String(bArr));
            a.g(bArr, str);
            this.mCacheDirty.set(true);
            b.a("saveAdvData sendBroadcast");
            updateData();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }
}
