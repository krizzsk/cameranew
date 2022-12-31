package com.bytedance.sdk.openadsdk.f.b;

import android.content.Context;
import android.database.Cursor;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.f.b.c;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tapjoy.TapjoyAuctionFlags;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* compiled from: LogStatsCache.java */
/* loaded from: classes.dex */
public class b {
    private static volatile b a;
    private Context b;
    private AtomicBoolean c = new AtomicBoolean(false);

    private b() {
        b();
    }

    public static b a() {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b();
                }
            }
        }
        return a;
    }

    public void b() {
        if (this.c.get() || o.a() == null) {
            return;
        }
        this.b = o.a();
        this.c.set(true);
    }

    public synchronized void c() {
        if (!this.c.get()) {
            b();
        } else {
            try {
                com.bytedance.sdk.openadsdk.multipro.a.a.a(this.b, "logstats", "retry >=?", new String[]{String.valueOf(5)});
            } catch (Throwable unused) {
            }
        }
    }

    public synchronized List<c.a> d() {
        LinkedList linkedList = new LinkedList();
        if (!this.c.get()) {
            b();
            return linkedList;
        }
        Cursor a2 = com.bytedance.sdk.openadsdk.multipro.a.a.a(this.b, "logstats", new String[]{TapjoyAuctionFlags.AUCTION_ID, FirebaseAnalytics.Param.VALUE}, "retry <?", new String[]{String.valueOf(5)}, null, null, null);
        if (a2 != null) {
            while (a2.moveToNext()) {
                try {
                    linkedList.add(new c.a(a2.getString(a2.getColumnIndex(TapjoyAuctionFlags.AUCTION_ID)), new JSONObject(a2.getString(a2.getColumnIndex(FirebaseAnalytics.Param.VALUE)))));
                } catch (Exception unused) {
                }
            }
            if (a2 != null) {
                a2.close();
            }
        }
        return linkedList;
    }
}
