package com.bytedance.sdk.openadsdk.c;

import android.content.Context;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tapjoy.TapjoyAuctionFlags;
import com.tapjoy.TapjoyConstants;
/* compiled from: StatsBatchEventRepertoryImpl.java */
/* loaded from: classes.dex */
public class l extends n {
    public l(Context context) {
        super(context);
    }

    public static String d() {
        return "CREATE TABLE IF NOT EXISTS logstatsbatch (_id INTEGER PRIMARY KEY AUTOINCREMENT," + TapjoyAuctionFlags.AUCTION_ID + " TEXT UNIQUE," + FirebaseAnalytics.Param.VALUE + " TEXT ,gen_time TEXT , " + TapjoyConstants.TJC_RETRY + " INTEGER default 0)";
    }

    @Override // com.bytedance.sdk.openadsdk.c.n, com.bytedance.sdk.openadsdk.c.e
    public void a(int i2) {
        this.a.a("stats_serverbusy_retrycount", i2);
    }

    @Override // com.bytedance.sdk.openadsdk.c.n, com.bytedance.sdk.openadsdk.c.e
    public int b() {
        return this.a.b("stats_serverbusy_retrycount", 0);
    }

    @Override // com.bytedance.sdk.openadsdk.c.n
    public String c() {
        return "logstatsbatch";
    }
}
