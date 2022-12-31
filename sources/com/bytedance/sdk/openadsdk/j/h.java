package com.bytedance.sdk.openadsdk.j;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.tapjoy.TapjoyAuctionFlags;
import com.tapjoy.TapjoyConstants;
import java.util.LinkedList;
import java.util.List;
/* compiled from: TrackRetryRepertoryImpl.java */
/* loaded from: classes.dex */
public class h implements g {
    private Context a;

    public h(Context context) {
        this.a = context;
    }

    @Override // com.bytedance.sdk.openadsdk.j.g
    public synchronized List<f> a() {
        LinkedList linkedList;
        linkedList = new LinkedList();
        Cursor a = com.bytedance.sdk.openadsdk.multipro.a.a.a(this.a, "trackurl", null, null, null, null, null, null);
        if (a != null) {
            while (a.moveToNext()) {
                linkedList.add(new f(a.getString(a.getColumnIndex(TapjoyAuctionFlags.AUCTION_ID)), a.getString(a.getColumnIndex("url")), a.getInt(a.getColumnIndex(TapjoyConstants.TJC_RETRY))));
            }
            if (a != null) {
                a.close();
            }
        }
        return linkedList;
    }

    @Override // com.bytedance.sdk.openadsdk.j.g
    public synchronized void b(f fVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(TapjoyAuctionFlags.AUCTION_ID, fVar.a());
        contentValues.put("url", fVar.b());
        contentValues.put("replaceholder", (Integer) 1);
        contentValues.put(TapjoyConstants.TJC_RETRY, Integer.valueOf(fVar.c()));
        com.bytedance.sdk.openadsdk.multipro.a.a.a(this.a, "trackurl", contentValues, "id=?", new String[]{fVar.a()});
    }

    @Override // com.bytedance.sdk.openadsdk.j.g
    public synchronized void c(f fVar) {
        com.bytedance.sdk.openadsdk.multipro.a.a.a(this.a, "trackurl", "id=?", new String[]{fVar.a()});
    }

    public static String b() {
        return "CREATE TABLE IF NOT EXISTS trackurl (_id INTEGER PRIMARY KEY AUTOINCREMENT," + TapjoyAuctionFlags.AUCTION_ID + " TEXT UNIQUE,url TEXT ,replaceholder INTEGER default 0, " + TapjoyConstants.TJC_RETRY + " INTEGER default 0)";
    }

    @Override // com.bytedance.sdk.openadsdk.j.g
    public synchronized void a(f fVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(TapjoyAuctionFlags.AUCTION_ID, fVar.a());
        contentValues.put("url", fVar.b());
        contentValues.put("replaceholder", (Integer) 1);
        contentValues.put(TapjoyConstants.TJC_RETRY, Integer.valueOf(fVar.c()));
        com.bytedance.sdk.openadsdk.multipro.a.a.a(this.a, "trackurl", contentValues);
    }
}
