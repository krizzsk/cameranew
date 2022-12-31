package com.tencent.stat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteException;
import android.os.Handler;
import android.os.HandlerThread;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.growingio.android.sdk.monitor.marshaller.json.JsonMarshaller;
import com.tencent.stat.common.StatLogger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class n {

    /* renamed from: e  reason: collision with root package name */
    private static StatLogger f8308e = com.tencent.stat.common.k.b();

    /* renamed from: f  reason: collision with root package name */
    private static n f8309f = null;
    Handler a;

    /* renamed from: d  reason: collision with root package name */
    private w f8310d;
    volatile int b = 0;
    DeviceInfo c = null;

    /* renamed from: g  reason: collision with root package name */
    private HashMap<String, String> f8311g = new HashMap<>();

    private n(Context context) {
        this.a = null;
        try {
            HandlerThread handlerThread = new HandlerThread("StatStore");
            handlerThread.start();
            StatLogger statLogger = f8308e;
            statLogger.w("Launch store thread:" + handlerThread);
            this.a = new Handler(handlerThread.getLooper());
            Context applicationContext = context.getApplicationContext();
            w wVar = new w(applicationContext);
            this.f8310d = wVar;
            wVar.getWritableDatabase();
            this.f8310d.getReadableDatabase();
            b(applicationContext);
            c();
            f();
            this.a.post(new o(this));
        } catch (Throwable th) {
            f8308e.e(th);
        }
    }

    public static synchronized n a(Context context) {
        n nVar;
        synchronized (n.class) {
            if (f8309f == null) {
                f8309f = new n(context);
            }
            nVar = f8309f;
        }
        return nVar;
    }

    public static n b() {
        return f8309f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(int i2) {
        try {
        } finally {
        }
        if (this.b > 0 && i2 > 0) {
            f8308e.i("Load " + Integer.toString(this.b) + " unsent events");
            ArrayList arrayList = new ArrayList();
            ArrayList<x> arrayList2 = new ArrayList();
            if (i2 == -1 || i2 > StatConfig.a()) {
                i2 = StatConfig.a();
            }
            this.b -= i2;
            c(arrayList2, i2);
            f8308e.i("Peek " + Integer.toString(arrayList2.size()) + " unsent events.");
            if (!arrayList2.isEmpty()) {
                b(arrayList2, 2);
                for (x xVar : arrayList2) {
                    arrayList.add(xVar.b);
                }
                d.e().f(arrayList, new u(this, arrayList2, i2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(com.tencent.stat.a.e eVar, c cVar) {
        if (StatConfig.getMaxStoreEventCount() <= 0) {
            return;
        }
        this.f8310d.getWritableDatabase().beginTransaction();
        if (this.b > StatConfig.getMaxStoreEventCount()) {
            f8308e.warn("Too many events stored in db.");
            this.b -= this.f8310d.getWritableDatabase().delete("events", "event_id in (select event_id from events where timestamp in (select min(timestamp) from events) limit 1)", null);
        }
        ContentValues contentValues = new ContentValues();
        String c = com.tencent.stat.common.k.c(eVar.d());
        contentValues.put(FirebaseAnalytics.Param.CONTENT, c);
        contentValues.put("send_count", "0");
        contentValues.put("status", Integer.toString(1));
        contentValues.put("timestamp", Long.valueOf(eVar.b()));
        if (this.f8310d.getWritableDatabase().insert("events", null, contentValues) == -1) {
            f8308e.error("Failed to store event:" + c);
        } else {
            this.b++;
            this.f8310d.getWritableDatabase().setTransactionSuccessful();
            if (cVar != null) {
                cVar.a();
            }
        }
        try {
            this.f8310d.getWritableDatabase().endTransaction();
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(b bVar) {
        Cursor query;
        boolean z;
        long insert;
        Cursor cursor = null;
        try {
            String a = bVar.a();
            String a2 = com.tencent.stat.common.k.a(a);
            ContentValues contentValues = new ContentValues();
            contentValues.put(FirebaseAnalytics.Param.CONTENT, bVar.b.toString());
            contentValues.put("md5sum", a2);
            bVar.c = a2;
            contentValues.put("version", Integer.valueOf(bVar.f8273d));
            query = this.f8310d.getReadableDatabase().query("config", null, null, null, null, null, null);
            while (true) {
                try {
                    if (!query.moveToNext()) {
                        z = false;
                        break;
                    } else if (query.getInt(0) == bVar.a) {
                        z = true;
                        break;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = query;
                    f8308e.e(th);
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
            if (true == z) {
                insert = this.f8310d.getWritableDatabase().update("config", contentValues, "type=?", new String[]{Integer.toString(bVar.a)});
            } else {
                contentValues.put("type", Integer.valueOf(bVar.a));
                insert = this.f8310d.getWritableDatabase().insert("config", null, contentValues);
            }
            if (insert == -1) {
                f8308e.e("Failed to store cfg:" + a);
            } else {
                f8308e.d("Sucessed to store cfg:" + a);
            }
        } catch (Throwable th2) {
            th = th2;
        }
        if (query != null) {
            query.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(List<x> list) {
        f8308e.i("Delete " + list.size() + " sent events in thread:" + Thread.currentThread());
        this.f8310d.getWritableDatabase().beginTransaction();
        Iterator<x> it = list.iterator();
        while (it.hasNext()) {
            this.b -= this.f8310d.getWritableDatabase().delete("events", "event_id = ?", new String[]{Long.toString(it.next().a)});
        }
        this.f8310d.getWritableDatabase().setTransactionSuccessful();
        this.b = (int) DatabaseUtils.queryNumEntries(this.f8310d.getReadableDatabase(), "events");
        try {
            this.f8310d.getWritableDatabase().endTransaction();
        } catch (SQLiteException e2) {
            f8308e.e((Exception) e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(List<x> list, int i2) {
        int update;
        f8308e.i("Update " + list.size() + " sending events to status:" + i2 + " in thread:" + Thread.currentThread());
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", Integer.toString(i2));
        this.f8310d.getWritableDatabase().beginTransaction();
        for (x xVar : list) {
            if (xVar.c + 1 > StatConfig.getMaxSendRetryCount()) {
                this.b -= this.f8310d.getWritableDatabase().delete("events", "event_id=?", new String[]{Long.toString(xVar.a)});
            } else {
                contentValues.put("send_count", Integer.valueOf(xVar.c + 1));
                f8308e.i("Update event:" + xVar.a + " for content:" + contentValues);
                if (this.f8310d.getWritableDatabase().update("events", contentValues, "event_id=?", new String[]{Long.toString(xVar.a)}) <= 0) {
                    f8308e.e("Failed to update db, error code:" + Integer.toString(update));
                }
            }
        }
        this.f8310d.getWritableDatabase().setTransactionSuccessful();
        this.b = (int) DatabaseUtils.queryNumEntries(this.f8310d.getReadableDatabase(), "events");
        try {
            this.f8310d.getWritableDatabase().endTransaction();
        } catch (SQLiteException e2) {
            f8308e.e((Exception) e2);
        }
    }

    private void c(List<x> list, int i2) {
        Cursor cursor = null;
        try {
            cursor = this.f8310d.getReadableDatabase().query("events", null, "status=?", new String[]{Integer.toString(1)}, null, null, JsonMarshaller.EVENT_ID, Integer.toString(i2));
            while (cursor.moveToNext()) {
                list.add(new x(cursor.getLong(0), com.tencent.stat.common.k.d(cursor.getString(1)), cursor.getInt(2), cursor.getInt(3)));
            }
            if (cursor == null) {
            }
        } catch (Throwable th) {
            try {
                f8308e.e(th);
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", (Integer) 1);
            this.f8310d.getWritableDatabase().update("events", contentValues, "status=?", new String[]{Long.toString(2L)});
            this.b = (int) DatabaseUtils.queryNumEntries(this.f8310d.getReadableDatabase(), "events");
            StatLogger statLogger = f8308e;
            statLogger.i("Total " + this.b + " unsent events.");
        } catch (Throwable th) {
            f8308e.e(th);
        }
    }

    private void f() {
        Cursor cursor = null;
        try {
            cursor = this.f8310d.getReadableDatabase().query("keyvalues", null, null, null, null, null, null);
            while (cursor.moveToNext()) {
                this.f8311g.put(cursor.getString(0), cursor.getString(1));
            }
            if (cursor == null) {
            }
        } catch (Throwable th) {
            try {
                f8308e.e(th);
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
    }

    public int a() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i2) {
        this.a.post(new v(this, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.tencent.stat.a.e eVar, c cVar) {
        if (StatConfig.isEnableStatService()) {
            try {
                if (Thread.currentThread().getId() == this.a.getLooper().getThread().getId()) {
                    b(eVar, cVar);
                } else {
                    this.a.post(new r(this, eVar, cVar));
                }
            } catch (Throwable th) {
                f8308e.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        if (bVar == null) {
            return;
        }
        this.a.post(new s(this, bVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(List<x> list) {
        try {
            if (Thread.currentThread().getId() == this.a.getLooper().getThread().getId()) {
                b(list);
            } else {
                this.a.post(new q(this, list));
            }
        } catch (SQLiteException e2) {
            f8308e.e((Exception) e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(List<x> list, int i2) {
        try {
            if (Thread.currentThread().getId() == this.a.getLooper().getThread().getId()) {
                b(list, i2);
            } else {
                this.a.post(new p(this, list, i2));
            }
        } catch (Throwable th) {
            f8308e.e(th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0096 A[Catch: all -> 0x0195, TryCatch #1 {all -> 0x0195, blocks: (B:9:0x001c, B:11:0x0026, B:13:0x0043, B:17:0x0058, B:19:0x0062, B:20:0x0064, B:22:0x006c, B:24:0x006f, B:26:0x0073, B:38:0x0096, B:40:0x0099, B:46:0x00d1, B:48:0x0103, B:50:0x0116, B:53:0x0126, B:55:0x0130, B:57:0x0136, B:59:0x014c, B:41:0x00b0, B:43:0x00b6, B:45:0x00bc, B:30:0x007e, B:32:0x0084, B:35:0x008e), top: B:80:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b6 A[Catch: all -> 0x0195, TryCatch #1 {all -> 0x0195, blocks: (B:9:0x001c, B:11:0x0026, B:13:0x0043, B:17:0x0058, B:19:0x0062, B:20:0x0064, B:22:0x006c, B:24:0x006f, B:26:0x0073, B:38:0x0096, B:40:0x0099, B:46:0x00d1, B:48:0x0103, B:50:0x0116, B:53:0x0126, B:55:0x0130, B:57:0x0136, B:59:0x014c, B:41:0x00b0, B:43:0x00b6, B:45:0x00bc, B:30:0x007e, B:32:0x0084, B:35:0x008e), top: B:80:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0103 A[Catch: all -> 0x0195, TryCatch #1 {all -> 0x0195, blocks: (B:9:0x001c, B:11:0x0026, B:13:0x0043, B:17:0x0058, B:19:0x0062, B:20:0x0064, B:22:0x006c, B:24:0x006f, B:26:0x0073, B:38:0x0096, B:40:0x0099, B:46:0x00d1, B:48:0x0103, B:50:0x0116, B:53:0x0126, B:55:0x0130, B:57:0x0136, B:59:0x014c, B:41:0x00b0, B:43:0x00b6, B:45:0x00bc, B:30:0x007e, B:32:0x0084, B:35:0x008e), top: B:80:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0116 A[Catch: all -> 0x0195, TryCatch #1 {all -> 0x0195, blocks: (B:9:0x001c, B:11:0x0026, B:13:0x0043, B:17:0x0058, B:19:0x0062, B:20:0x0064, B:22:0x006c, B:24:0x006f, B:26:0x0073, B:38:0x0096, B:40:0x0099, B:46:0x00d1, B:48:0x0103, B:50:0x0116, B:53:0x0126, B:55:0x0130, B:57:0x0136, B:59:0x014c, B:41:0x00b0, B:43:0x00b6, B:45:0x00bc, B:30:0x007e, B:32:0x0084, B:35:0x008e), top: B:80:0x001c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized com.tencent.stat.DeviceInfo b(android.content.Context r19) {
        /*
            Method dump skipped, instructions count: 435
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.n.b(android.content.Context):com.tencent.stat.DeviceInfo");
    }

    void c() {
        this.a.post(new t(this));
    }
}
