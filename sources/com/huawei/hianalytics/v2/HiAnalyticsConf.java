package com.huawei.hianalytics.v2;

import android.content.Context;
import com.huawei.hianalytics.a.b;
import com.huawei.hianalytics.v2.a.b.h;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class HiAnalyticsConf {
    private static HashMap<Object, String> a;
    private static b b;

    /* loaded from: classes2.dex */
    public static class Builder {
        private Context context;

        public Builder(Context context) {
            b unused = HiAnalyticsConf.b = new b();
            this.context = context;
        }

        public void create() {
            com.huawei.hianalytics.b.b.b("HiAnalytics", "Builder.create() is execute.");
            h.a(HiAnalyticsConf.b, this.context);
        }

        public void refresh(boolean z) {
            com.huawei.hianalytics.b.b.b("HiAnalytics", "Builder.refresh(boolean enableCleanData) is execute.");
            h.a(HiAnalyticsConf.b, z);
        }

        public Builder setAndroidId(String str) {
            com.huawei.hianalytics.b.b.b("HiAnalytics", "setAndroidId(String androidId) is execute.");
            HiAnalyticsConf.b.c(str);
            return this;
        }

        public Builder setAppID(String str) {
            com.huawei.hianalytics.b.b.b("HiAnalytics", "Builder.setAppID is execute");
            HiAnalyticsConf.b.b(str);
            return this;
        }

        public Builder setChannel(String str) {
            com.huawei.hianalytics.b.b.b("HiAnalytics", "Builder.setChannel(String channel) is execute.");
            HiAnalyticsConf.b.a(str);
            return this;
        }

        public Builder setCollectURL(int i2, String str) {
            HashMap hashMap;
            String str2;
            if (HiAnalyticsConf.a == null) {
                HashMap unused = HiAnalyticsConf.a = new HashMap();
            }
            com.huawei.hianalytics.b.b.b("HiAnalytics", "Builder.setCollectURL(int type,String collectURL) is execute.");
            if (str != null) {
                str = str.trim();
            }
            if (i2 != 0) {
                if (i2 == 1) {
                    hashMap = HiAnalyticsConf.a;
                    str2 = "maint";
                }
                HiAnalyticsConf.b.a(HiAnalyticsConf.a);
                return this;
            }
            hashMap = HiAnalyticsConf.a;
            str2 = "oper";
            hashMap.put(str2, str);
            HiAnalyticsConf.b.a(HiAnalyticsConf.a);
            return this;
        }

        public Builder setEnableAndroidID(boolean z) {
            com.huawei.hianalytics.b.b.b("HiAnalytics", "Builder.setEnableAndroidID(boolean reportAndroidID) is execute.");
            HiAnalyticsConf.b.a(z);
            return this;
        }

        public Builder setEnableImei(boolean z) {
            com.huawei.hianalytics.b.b.b("HiAnalytics", "Builder.setEnableImei(boolean isReportAndroidImei) is execute.");
            HiAnalyticsConf.b.b(z);
            return this;
        }

        public Builder setEnableSerialNoNumber(boolean z) {
            com.huawei.hianalytics.b.b.b("HiAnalytics", "Builder.setEnableSerialNoNumber(boolean isReportSN) is execute.");
            HiAnalyticsConf.b.d(z);
            return this;
        }

        public Builder setEnableUDID(boolean z) {
            com.huawei.hianalytics.b.b.b("HiAnalytics", "Builder.setEnableUDID(boolean isReportUDID) is execute.");
            HiAnalyticsConf.b.c(z);
            return this;
        }

        public Builder setIMEI(String str) {
            com.huawei.hianalytics.b.b.b("HiAnalytics", "setIMEI(String imei) is execute.");
            HiAnalyticsConf.b.d(str);
            return this;
        }

        public Builder setUDID(String str) {
            com.huawei.hianalytics.b.b.b("HiAnalytics", "setUDID(String udid) is execute.");
            HiAnalyticsConf.b.e(str);
            return this;
        }
    }
}
