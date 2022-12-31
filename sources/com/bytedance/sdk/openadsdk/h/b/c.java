package com.bytedance.sdk.openadsdk.h.b;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.SparseArray;
import com.growingio.android.sdk.monitor.marshaller.json.JsonMarshaller;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import tv.danmaku.ijk.media.player.misc.IMediaFormat;
/* compiled from: VideoProxyDB.java */
/* loaded from: classes.dex */
public class c {
    private static volatile c b;
    private final SparseArray<Map<String, a>> a;
    private final d c;

    /* renamed from: d  reason: collision with root package name */
    private final Executor f2019d;

    /* renamed from: e  reason: collision with root package name */
    private volatile SQLiteStatement f2020e;

    private c(Context context) {
        SparseArray<Map<String, a>> sparseArray = new SparseArray<>(2);
        this.a = sparseArray;
        this.f2019d = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque());
        this.c = new d(context.getApplicationContext());
        sparseArray.put(0, new ConcurrentHashMap());
        sparseArray.put(1, new ConcurrentHashMap());
    }

    private String b(int i2) {
        if (i2 <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(i2 << 1);
        sb.append("?");
        for (int i3 = 1; i3 < i2; i3++) {
            sb.append(",?");
        }
        return sb.toString();
    }

    public static c a(Context context) {
        if (b == null) {
            synchronized (c.class) {
                if (b == null) {
                    b = new c(context);
                }
            }
        }
        return b;
    }

    public a a(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map<String, a> map = this.a.get(i2);
        a aVar = map == null ? null : map.get(str);
        if (aVar != null) {
            return aVar;
        }
        try {
            Cursor query = this.c.getReadableDatabase().query("video_http_header_t", null, "key=? AND flag=?", new String[]{str, String.valueOf(i2)}, null, null, null, "1");
            if (query != null) {
                if (query.getCount() > 0 && query.moveToNext()) {
                    aVar = new a(query.getString(query.getColumnIndex("key")), query.getString(query.getColumnIndex(IMediaFormat.KEY_MIME)), query.getInt(query.getColumnIndex("contentLength")), i2, query.getString(query.getColumnIndex(JsonMarshaller.EXTRA)));
                }
                query.close();
            }
            if (aVar != null && map != null) {
                map.put(str, aVar);
            }
            return aVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void a(final a aVar) {
        if (aVar != null) {
            Map<String, a> map = this.a.get(aVar.f2010d);
            if (map != null) {
                map.put(aVar.a, aVar);
            }
            this.f2019d.execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.h.b.c.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (c.this.f2020e != null) {
                            c.this.f2020e.clearBindings();
                        } else {
                            c cVar = c.this;
                            cVar.f2020e = cVar.c.getWritableDatabase().compileStatement("INSERT INTO video_http_header_t (key,mime,contentLength,flag,extra) VALUES(?,?,?,?,?)");
                        }
                        c.this.f2020e.bindString(1, aVar.a);
                        c.this.f2020e.bindString(2, aVar.b);
                        c.this.f2020e.bindLong(3, aVar.c);
                        c.this.f2020e.bindLong(4, aVar.f2010d);
                        c.this.f2020e.bindString(5, aVar.f2011e);
                        c.this.f2020e.executeInsert();
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    public void a(Collection<String> collection, int i2) {
        if (collection == null || collection.isEmpty()) {
            return;
        }
        int size = collection.size() + 1;
        String[] strArr = new String[size];
        int i3 = -1;
        Map<String, a> map = this.a.get(i2);
        for (String str : collection) {
            if (map != null) {
                map.remove(str);
            }
            i3++;
            strArr[i3] = str;
        }
        strArr[i3 + 1] = String.valueOf(i2);
        try {
            SQLiteDatabase writableDatabase = this.c.getWritableDatabase();
            writableDatabase.delete("video_http_header_t", "key IN(" + b(size) + ") AND flag=?", strArr);
        } catch (Throwable unused) {
        }
    }

    public void a(final int i2) {
        Map<String, a> map = this.a.get(i2);
        if (map != null) {
            map.clear();
        }
        this.f2019d.execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.h.b.c.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    c.this.c.getWritableDatabase().delete("video_http_header_t", "flag=?", new String[]{String.valueOf(i2)});
                } catch (Throwable unused) {
                }
            }
        });
    }
}
