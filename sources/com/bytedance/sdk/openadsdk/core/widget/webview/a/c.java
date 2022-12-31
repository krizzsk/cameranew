package com.bytedance.sdk.openadsdk.core.widget.webview.a;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.LruCache;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.o;
import com.tapjoy.TapjoyAuctionFlags;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TmplDbHelper.java */
/* loaded from: classes.dex */
public class c {
    private static volatile c a;
    private LruCache<String, l> c = new LruCache<String, l>(524288) { // from class: com.bytedance.sdk.openadsdk.core.widget.webview.a.c.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* renamed from: a */
        public int sizeOf(String str, l lVar) {
            int i2 = 0;
            if (lVar != null) {
                if (!TextUtils.isEmpty(lVar.b())) {
                    try {
                        i2 = 0 + lVar.b().getBytes().length;
                    } catch (Throwable unused) {
                    }
                }
                if (!TextUtils.isEmpty(lVar.c())) {
                    try {
                        i2 += lVar.c().getBytes().length;
                    } catch (Throwable unused2) {
                    }
                }
                if (!TextUtils.isEmpty(lVar.a())) {
                    try {
                        i2 += lVar.a().getBytes().length;
                    } catch (Throwable unused3) {
                    }
                }
                if (!TextUtils.isEmpty(lVar.d())) {
                    try {
                        i2 += lVar.d().getBytes().length;
                    } catch (Throwable unused4) {
                    }
                }
                if (!TextUtils.isEmpty(lVar.f())) {
                    try {
                        i2 += lVar.f().getBytes().length;
                    } catch (Throwable unused5) {
                    }
                }
                if (!TextUtils.isEmpty(lVar.e())) {
                    try {
                        i2 += lVar.e().getBytes().length;
                    } catch (Throwable unused6) {
                    }
                }
            }
            return i2 > 0 ? i2 : super.sizeOf(str, lVar);
        }
    };
    private Set<String> b = Collections.synchronizedSet(new HashSet());

    private c() {
    }

    public static c a() {
        if (a == null) {
            synchronized (c.class) {
                if (a == null) {
                    a = new c();
                }
            }
        }
        return a;
    }

    public static String c() {
        return "CREATE TABLE IF NOT EXISTS template_diff (_id INTEGER PRIMARY KEY AUTOINCREMENT,rit TEXT ," + TapjoyAuctionFlags.AUCTION_ID + " TEXT UNIQUE,md5 TEXT ,url TEXT , data TEXT , version TEXT)";
    }

    private boolean d() {
        Long valueOf;
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            valueOf = Long.valueOf(com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_template_delete", "delete_time", 0L));
        } else {
            valueOf = Long.valueOf(e().getLong("delete_time", 0L));
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - valueOf.longValue() < 604800000) {
            return false;
        }
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_template_delete", "delete_time", Long.valueOf(currentTimeMillis));
            return true;
        }
        e().edit().putLong("delete_time", currentTimeMillis);
        return true;
    }

    private SharedPreferences e() {
        return o.a().getSharedPreferences("sp_template_delete", 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public List<l> b() {
        ArrayList arrayList = new ArrayList();
        Cursor a2 = com.bytedance.sdk.openadsdk.multipro.a.a.a(o.a(), "template_diff", null, null, null, null, null, null);
        if (a2 != null) {
            while (a2.moveToNext()) {
                try {
                    String string = a2.getString(a2.getColumnIndex("rit"));
                    String string2 = a2.getString(a2.getColumnIndex(TapjoyAuctionFlags.AUCTION_ID));
                    String string3 = a2.getString(a2.getColumnIndex("md5"));
                    String string4 = a2.getString(a2.getColumnIndex("url"));
                    String string5 = a2.getString(a2.getColumnIndex("data"));
                    arrayList.add(new l().a(string).b(string2).c(string3).d(string4).e(string5).f(a2.getString(a2.getColumnIndex("version"))));
                    this.c.put(string2, arrayList.get(arrayList.size() - 1));
                    this.b.add(string2);
                } finally {
                    if (a2 != null) {
                        a2.close();
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        l lVar = this.c.get(String.valueOf(str));
        if (lVar != null) {
            return lVar;
        }
        Cursor a2 = com.bytedance.sdk.openadsdk.multipro.a.a.a(o.a(), "template_diff", null, "id=?", new String[]{str}, null, null, null);
        if (a2 != null) {
            try {
                if (a2.moveToNext()) {
                    String string = a2.getString(a2.getColumnIndex("rit"));
                    String string2 = a2.getString(a2.getColumnIndex(TapjoyAuctionFlags.AUCTION_ID));
                    String string3 = a2.getString(a2.getColumnIndex("md5"));
                    String string4 = a2.getString(a2.getColumnIndex("url"));
                    l f2 = new l().a(string).b(string2).c(string3).d(string4).e(a2.getString(a2.getColumnIndex("data"))).f(a2.getString(a2.getColumnIndex("version")));
                    this.c.put(string2, f2);
                    this.b.add(string2);
                    return f2;
                } else if (a2 != null) {
                    a2.close();
                }
            } finally {
                if (a2 != null) {
                    a2.close();
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(l lVar) {
        if (TextUtils.isEmpty(lVar.b())) {
            return;
        }
        Cursor a2 = com.bytedance.sdk.openadsdk.multipro.a.a.a(o.a(), "template_diff", null, "id=?", new String[]{lVar.b()}, null, null, null);
        boolean z = a2 != null && a2.getCount() > 0;
        if (a2 != null) {
            try {
                a2.close();
            } catch (Throwable unused) {
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("rit", lVar.a());
        contentValues.put(TapjoyAuctionFlags.AUCTION_ID, lVar.b());
        contentValues.put("md5", lVar.c());
        contentValues.put("url", lVar.d());
        contentValues.put("data", lVar.e());
        contentValues.put("version", lVar.f());
        if (z) {
            com.bytedance.sdk.openadsdk.multipro.a.a.a(o.a(), "template_diff", contentValues, "id=?", new String[]{lVar.b()});
        } else {
            com.bytedance.sdk.openadsdk.multipro.a.a.a(o.a(), "template_diff", contentValues);
        }
        this.c.put(lVar.b(), lVar);
        this.b.add(lVar.b());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Set<String> set) {
        if (set == null || set.isEmpty() || !d()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : this.b) {
            if (!set.contains(str)) {
                arrayList.add(str);
            }
        }
        String[] strArr = new String[0];
        if (arrayList.size() > 0) {
            com.bytedance.sdk.openadsdk.multipro.a.a.a(o.a(), "template_diff", "id=?", (String[]) arrayList.toArray(strArr));
        }
    }
}
