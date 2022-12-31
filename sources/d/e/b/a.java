package d.e.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.List;
/* compiled from: DataBaseEventsStorage.java */
/* loaded from: classes2.dex */
public class a extends SQLiteOpenHelper {
    private static a a;

    public a(Context context, String str, int i2) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i2);
    }

    private ContentValues d(b bVar, String str) {
        if (bVar != null) {
            ContentValues contentValues = new ContentValues(4);
            contentValues.put("eventid", Integer.valueOf(bVar.d()));
            contentValues.put("timestamp", Long.valueOf(bVar.e()));
            contentValues.put("type", str);
            contentValues.put("data", bVar.b());
            return contentValues;
        }
        return null;
    }

    private synchronized SQLiteDatabase e(boolean z) throws Throwable {
        int i2 = 0;
        while (true) {
            try {
                if (z) {
                    return getWritableDatabase();
                }
                return getReadableDatabase();
            } finally {
            }
        }
    }

    public static synchronized a h(Context context, String str, int i2) {
        a aVar;
        synchronized (a.class) {
            if (a == null) {
                a = new a(context, str, i2);
            }
            aVar = a;
        }
        return aVar;
    }

    public synchronized void a(String str) {
        String[] strArr = {str};
        SQLiteDatabase e2 = e(true);
        e2.delete("events", "type = ?", strArr);
        if (e2 != null && e2.isOpen()) {
            e2.close();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0071, code lost:
        if (r11.isOpen() != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0073, code lost:
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0093, code lost:
        if (r11.isOpen() != false) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized java.util.ArrayList<d.e.b.b> i(java.lang.String r13) {
        /*
            r12 = this;
            monitor-enter(r12)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Lb0
            r0.<init>()     // Catch: java.lang.Throwable -> Lb0
            r1 = 0
            r2 = 0
            android.database.sqlite.SQLiteDatabase r11 = r12.e(r1)     // Catch: java.lang.Throwable -> L79
            java.lang.String r6 = "type = ?"
            r3 = 1
            java.lang.String[] r7 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L77
            r7[r1] = r13     // Catch: java.lang.Throwable -> L77
            java.lang.String r10 = "timestamp ASC"
            java.lang.String r4 = "events"
            r5 = 0
            r8 = 0
            r9 = 0
            r3 = r11
            android.database.Cursor r2 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L77
            int r13 = r2.getCount()     // Catch: java.lang.Throwable -> L77
            if (r13 <= 0) goto L60
            r2.moveToFirst()     // Catch: java.lang.Throwable -> L77
        L28:
            boolean r13 = r2.isAfterLast()     // Catch: java.lang.Throwable -> L77
            if (r13 != 0) goto L5d
            java.lang.String r13 = "eventid"
            int r13 = r2.getColumnIndex(r13)     // Catch: java.lang.Throwable -> L77
            int r13 = r2.getInt(r13)     // Catch: java.lang.Throwable -> L77
            java.lang.String r1 = "timestamp"
            int r1 = r2.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L77
            long r3 = r2.getLong(r1)     // Catch: java.lang.Throwable -> L77
            java.lang.String r1 = "data"
            int r1 = r2.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L77
            java.lang.String r1 = r2.getString(r1)     // Catch: java.lang.Throwable -> L77
            d.e.b.b r5 = new d.e.b.b     // Catch: java.lang.Throwable -> L77
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L77
            r6.<init>(r1)     // Catch: java.lang.Throwable -> L77
            r5.<init>(r13, r3, r6)     // Catch: java.lang.Throwable -> L77
            r0.add(r5)     // Catch: java.lang.Throwable -> L77
            r2.moveToNext()     // Catch: java.lang.Throwable -> L77
            goto L28
        L5d:
            r2.close()     // Catch: java.lang.Throwable -> L77
        L60:
            if (r2 == 0) goto L6b
            boolean r13 = r2.isClosed()     // Catch: java.lang.Throwable -> Lb0
            if (r13 != 0) goto L6b
            r2.close()     // Catch: java.lang.Throwable -> Lb0
        L6b:
            if (r11 == 0) goto L96
            boolean r13 = r11.isOpen()     // Catch: java.lang.Throwable -> Lb0
            if (r13 == 0) goto L96
        L73:
            r11.close()     // Catch: java.lang.Throwable -> Lb0
            goto L96
        L77:
            r13 = move-exception
            goto L7b
        L79:
            r13 = move-exception
            r11 = r2
        L7b:
            java.lang.String r1 = "IronSource"
            java.lang.String r3 = "Exception while loading events: "
            android.util.Log.e(r1, r3, r13)     // Catch: java.lang.Throwable -> L98
            if (r2 == 0) goto L8d
            boolean r13 = r2.isClosed()     // Catch: java.lang.Throwable -> Lb0
            if (r13 != 0) goto L8d
            r2.close()     // Catch: java.lang.Throwable -> Lb0
        L8d:
            if (r11 == 0) goto L96
            boolean r13 = r11.isOpen()     // Catch: java.lang.Throwable -> Lb0
            if (r13 == 0) goto L96
            goto L73
        L96:
            monitor-exit(r12)
            return r0
        L98:
            r13 = move-exception
            if (r2 == 0) goto La4
            boolean r0 = r2.isClosed()     // Catch: java.lang.Throwable -> Lb0
            if (r0 != 0) goto La4
            r2.close()     // Catch: java.lang.Throwable -> Lb0
        La4:
            if (r11 == 0) goto Laf
            boolean r0 = r11.isOpen()     // Catch: java.lang.Throwable -> Lb0
            if (r0 == 0) goto Laf
            r11.close()     // Catch: java.lang.Throwable -> Lb0
        Laf:
            throw r13     // Catch: java.lang.Throwable -> Lb0
        Lb0:
            r13 = move-exception
            monitor-exit(r12)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: d.e.b.a.i(java.lang.String):java.util.ArrayList");
    }

    public synchronized void j(List<b> list, String str) {
        if (list != null) {
            if (!list.isEmpty()) {
                SQLiteDatabase sQLiteDatabase = null;
                try {
                    SQLiteDatabase e2 = e(true);
                    try {
                        for (b bVar : list) {
                            ContentValues d2 = d(bVar, str);
                            if (e2 != null && d2 != null) {
                                e2.insert("events", null, d2);
                            }
                        }
                        if (e2 != null && e2.isOpen()) {
                            e2.close();
                        }
                    } catch (Throwable th) {
                        th = th;
                        sQLiteDatabase = e2;
                        Log.e("IronSource", "Exception while saving events: ", th);
                        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                            sQLiteDatabase.close();
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE events (_id INTEGER PRIMARY KEY,eventid INTEGER,timestamp INTEGER,type TEXT,data TEXT )");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS events");
        onCreate(sQLiteDatabase);
    }
}
