package com.bytedance.sdk.openadsdk.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tapjoy.TapjoyAuctionFlags;
import com.tapjoy.TapjoyConstants;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: AdEventRepertoryImpl.java */
/* loaded from: classes.dex */
public class f implements e<a> {
    private final Context a;
    private final com.bytedance.sdk.openadsdk.core.d b = com.bytedance.sdk.openadsdk.core.d.a(c());

    public f(Context context) {
        this.a = context;
    }

    private synchronized void b(int i2, long j2) {
        long currentTimeMillis = System.currentTimeMillis() - j2;
        Context c = c();
        com.bytedance.sdk.openadsdk.multipro.a.a.a(c, "adevent", "gen_time <? AND retry >?", new String[]{currentTimeMillis + "", i2 + ""});
    }

    public static String d() {
        return "CREATE TABLE IF NOT EXISTS adevent (_id INTEGER PRIMARY KEY AUTOINCREMENT," + TapjoyAuctionFlags.AUCTION_ID + " TEXT UNIQUE," + FirebaseAnalytics.Param.VALUE + " TEXT ,gen_time TEXT , " + TapjoyConstants.TJC_RETRY + " INTEGER default 0)";
    }

    public Context c() {
        Context context = this.a;
        return context == null ? com.bytedance.sdk.openadsdk.core.o.a() : context;
    }

    @Override // com.bytedance.sdk.openadsdk.c.e
    public synchronized List<a> a(int i2, String str) {
        LinkedList linkedList;
        String str2 = null;
        if (i2 > 0) {
            if (!TextUtils.isEmpty(str)) {
                str2 = str + " DESC limit " + i2;
            }
        }
        linkedList = new LinkedList();
        Cursor a = com.bytedance.sdk.openadsdk.multipro.a.a.a(c(), "adevent", new String[]{TapjoyAuctionFlags.AUCTION_ID, FirebaseAnalytics.Param.VALUE}, null, null, null, null, str2);
        if (a != null) {
            while (a.moveToNext()) {
                try {
                    linkedList.add(new a(a.getString(a.getColumnIndex(TapjoyAuctionFlags.AUCTION_ID)), new JSONObject(a.getString(a.getColumnIndex(FirebaseAnalytics.Param.VALUE)))));
                } catch (JSONException unused) {
                }
            }
            if (a != null) {
                a.close();
            }
        }
        return linkedList;
    }

    @VisibleForTesting
    private synchronized void b(List<a> list) {
        LinkedList linkedList = new LinkedList();
        for (a aVar : list) {
            linkedList.add(aVar.a);
        }
        com.bytedance.sdk.openadsdk.multipro.a.a.a(c(), "UPDATE adevent SET " + TapjoyConstants.TJC_RETRY + " = " + TapjoyConstants.TJC_RETRY + "+1 WHERE " + a(TapjoyAuctionFlags.AUCTION_ID, linkedList, 1000, true));
    }

    @Override // com.bytedance.sdk.openadsdk.c.e
    public synchronized void a(a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(TapjoyAuctionFlags.AUCTION_ID, aVar.a);
        contentValues.put(FirebaseAnalytics.Param.VALUE, aVar.b.toString());
        contentValues.put("gen_time", Long.valueOf(System.currentTimeMillis()));
        contentValues.put(TapjoyConstants.TJC_RETRY, (Integer) 0);
        com.bytedance.sdk.openadsdk.multipro.a.a.a(c(), "adevent", contentValues);
    }

    @Override // com.bytedance.sdk.openadsdk.c.e
    public int b() {
        return this.b.b("serverbusy_retrycount", 0);
    }

    @Override // com.bytedance.sdk.openadsdk.c.e
    public synchronized void a(List<a> list) {
        if (com.bytedance.sdk.openadsdk.utils.m.a(list)) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        for (a aVar : list) {
            linkedList.add(aVar.a);
        }
        com.bytedance.sdk.openadsdk.multipro.a.a.a(c(), "DELETE FROM adevent WHERE " + a(TapjoyAuctionFlags.AUCTION_ID, linkedList, 1000, true));
    }

    @Override // com.bytedance.sdk.openadsdk.c.e
    public synchronized void a(int i2, long j2) {
        b(i2, j2);
    }

    @Override // com.bytedance.sdk.openadsdk.c.e
    public synchronized void a(List<a> list, int i2, long j2) {
        if (com.bytedance.sdk.openadsdk.utils.m.a(list)) {
            return;
        }
        try {
            b(list);
            b(i2, j2);
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.c.e
    public void a(boolean z) {
        this.b.a("serverbusy_flag", z);
    }

    @Override // com.bytedance.sdk.openadsdk.c.e
    public boolean a() {
        return this.b.b("serverbusy_flag", false);
    }

    @Override // com.bytedance.sdk.openadsdk.c.e
    public void a(int i2) {
        this.b.a("serverbusy_retrycount", i2);
    }

    private static String a(String str, List<?> list, int i2, boolean z) {
        int i3;
        String str2 = z ? " IN " : " NOT IN ";
        String str3 = z ? " OR " : " AND ";
        int min = Math.min(i2, 1000);
        int size = list.size();
        if (size % min == 0) {
            i3 = size / min;
        } else {
            i3 = (size / min) + 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = i4 * min;
            String a = a(TextUtils.join("','", list.subList(i5, Math.min(i5 + min, size))), "");
            if (i4 != 0) {
                sb.append(str3);
            }
            sb.append(str);
            sb.append(str2);
            sb.append("('");
            sb.append(a);
            sb.append("')");
        }
        String sb2 = sb.toString();
        return a(sb2, str + str2 + "('')");
    }

    private static String a(String str, String str2) {
        return !TextUtils.isEmpty(str) ? str : str2;
    }
}
