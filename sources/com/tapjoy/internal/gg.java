package com.tapjoy.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.tapjoy.TJAdUnitConstants;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import us.pinguo.advconfigdata.Utils.AdvTimeUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class gg extends gf {
    private final File b;
    private final gy c;

    /* renamed from: d  reason: collision with root package name */
    private volatile SQLiteDatabase f7573d;

    /* renamed from: e  reason: collision with root package name */
    private long f7574e;

    /* renamed from: f  reason: collision with root package name */
    private long f7575f;

    /* renamed from: g  reason: collision with root package name */
    private long f7576g;

    public gg(File file, gy gyVar) {
        this.b = file;
        this.c = gyVar;
    }

    private void b() {
        String str;
        HashMap hashMap;
        Set set = gf.a;
        Cursor rawQuery = this.f7573d.rawQuery("SELECT ROWID, * FROM UsageStats ORDER BY ROWID ASC", null);
        try {
            Cursor rawQuery2 = this.f7573d.rawQuery("SELECT * FROM UsageStatValues ORDER BY stat_id ASC", null);
            rawQuery2.moveToNext();
            while (rawQuery.moveToNext()) {
                int i2 = 0;
                long j2 = rawQuery.getLong(0);
                int i3 = 1;
                String string = rawQuery.getString(1);
                String string2 = rawQuery.getString(2);
                String str2 = string2.isEmpty() ? str : string2;
                int i4 = rawQuery.getInt(3);
                long j3 = rawQuery.getLong(4);
                long j4 = rawQuery.getLong(5);
                if (rawQuery2.isAfterLast()) {
                    hashMap = null;
                } else {
                    hashMap = null;
                    while (rawQuery2.getLong(i2) == j2) {
                        if (hashMap == null) {
                            hashMap = new HashMap();
                        }
                        String string3 = rawQuery2.getString(i3);
                        long j5 = rawQuery2.getLong(3);
                        long j6 = rawQuery2.getLong(4);
                        hashMap.put(string3, Long.valueOf(j5));
                        hashMap.put(string3 + "_max", Long.valueOf(j6));
                        if (!rawQuery2.moveToNext()) {
                            break;
                        }
                        i2 = 0;
                        i3 = 1;
                    }
                }
                str = (set != null && set.contains(string)) ? null : null;
                this.c.a(string, str2, i4, j3, j4, hashMap);
            }
            rawQuery2.close();
            rawQuery.close();
            this.f7573d.execSQL("DELETE FROM UsageStats");
            this.f7573d.execSQL("DELETE FROM UsageStatValues");
            this.f7576g = 0L;
            this.f7575f = 0L;
        } catch (Throwable th) {
            rawQuery.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tapjoy.internal.gf
    public void a(long j2) {
        if (this.f7573d != null) {
            return;
        }
        this.f7573d = SQLiteDatabase.openOrCreateDatabase(this.b, (SQLiteDatabase.CursorFactory) null);
        int version = this.f7573d.getVersion();
        if (version == 0) {
            this.f7573d.beginTransaction();
            try {
                this.f7573d.execSQL("CREATE TABLE IF NOT EXISTS UsageStats(name TEXT,dimensions TEXT,count INTEGER,first_time INTEGER,last_time INTEGER,PRIMARY KEY(name, dimensions))");
                this.f7573d.execSQL("CREATE TABLE IF NOT EXISTS UsageStatValues(stat_id LONG,name TEXT,count INTEGER,avg REAL,max INTEGER,PRIMARY KEY(stat_id, name))");
                this.f7573d.setVersion(1);
                this.f7573d.setTransactionSuccessful();
            } finally {
                this.f7573d.endTransaction();
            }
        } else if (version != 1) {
            throw new SQLException("Unknown database version: " + version);
        }
        Cursor rawQuery = this.f7573d.rawQuery("SELECT MIN(first_time), MAX(last_time) FROM UsageStats", null);
        try {
            if (rawQuery.moveToNext()) {
                this.f7575f = rawQuery.getLong(0);
                this.f7576g = rawQuery.getLong(1);
            }
            rawQuery.close();
            long j3 = this.f7575f;
            if (j3 <= 0 || j3 + AdvTimeUtils.MILLIS_OF_A_DAY > j2) {
                return;
            }
            b();
        } catch (Throwable th) {
            rawQuery.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void finalize() {
        if (this.f7573d != null) {
            jz.a(this.f7573d);
            this.f7573d = null;
        }
        super.finalize();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tapjoy.internal.gf
    public void a() {
        if (this.f7573d != null) {
            jz.a(this.f7573d);
            this.f7573d = null;
        }
        this.b.delete();
        this.f7576g = 0L;
        this.f7575f = 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tapjoy.internal.gf
    public void a(long j2, String str, @Nullable String str2, @Nullable Map map) {
        Cursor cursor;
        String str3;
        long insert;
        long j3;
        String str4;
        String str5;
        if (this.f7573d == null) {
            return;
        }
        long j4 = this.f7574e;
        if (j4 == 0) {
            this.f7576g = j2;
            this.f7574e = j2;
        } else if (j2 >= j4 && j2 < j4 + AdvTimeUtils.MILLIS_OF_A_DAY) {
            if (j2 > this.f7576g) {
                this.f7576g = j2;
            }
        } else if (j2 < j4 && this.f7576g - j2 < AdvTimeUtils.MILLIS_OF_A_DAY) {
            this.f7574e = j2;
        } else {
            b();
            this.f7576g = j2;
            this.f7574e = j2;
        }
        String str6 = str2 == null ? "" : str2;
        char c = 0;
        char c2 = 1;
        Cursor rawQuery = this.f7573d.rawQuery("SELECT ROWID,count,first_time,last_time FROM UsageStats WHERE name = ? AND dimensions = ?", new String[]{str, str6});
        try {
            ContentValues contentValues = new ContentValues();
            String str7 = "name";
            String str8 = "count";
            if (rawQuery.moveToNext()) {
                long j5 = rawQuery.getLong(0);
                int i2 = rawQuery.getInt(1);
                long j6 = rawQuery.getLong(2);
                long j7 = rawQuery.getLong(3);
                contentValues.put("count", Integer.valueOf(i2 + 1));
                if (j2 < j6) {
                    contentValues.put("first_time", Long.valueOf(j2));
                }
                if (j2 > j7) {
                    contentValues.put("last_time", Long.valueOf(j2));
                }
                SQLiteDatabase sQLiteDatabase = this.f7573d;
                sQLiteDatabase.update("UsageStats", contentValues, "ROWID = " + j5, null);
                str3 = "ROWID = ";
                insert = j5;
            } else {
                str3 = "ROWID = ";
                contentValues.put("name", str);
                contentValues.put(TJAdUnitConstants.String.USAGE_TRACKER_DIMENSIONS, str6);
                contentValues.put("count", (Integer) 1);
                contentValues.put("first_time", Long.valueOf(j2));
                contentValues.put("last_time", Long.valueOf(j2));
                insert = this.f7573d.insert("UsageStats", null, contentValues);
            }
            if (map != null && !map.isEmpty()) {
                Iterator it = map.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    if (entry.getValue() != null) {
                        String str9 = (String) entry.getKey();
                        long longValue = ((Long) entry.getValue()).longValue();
                        String[] strArr = new String[2];
                        strArr[c] = Long.toString(insert);
                        strArr[c2] = str9;
                        Cursor rawQuery2 = this.f7573d.rawQuery("SELECT ROWID, * FROM UsageStatValues WHERE stat_id = ? AND name = ?", strArr);
                        try {
                            Iterator it2 = it;
                            if (rawQuery2.moveToNext()) {
                                j3 = insert;
                                long j8 = rawQuery2.getLong(0);
                                int i3 = rawQuery2.getInt(3);
                                double d2 = rawQuery2.getDouble(4);
                                long j9 = rawQuery2.getLong(5);
                                contentValues.clear();
                                int i4 = i3 + 1;
                                contentValues.put(str8, Integer.valueOf(i4));
                                cursor = rawQuery;
                                String str10 = str8;
                                String str11 = str7;
                                try {
                                    contentValues.put("avg", Double.valueOf(d2 + ((longValue - d2) / i4)));
                                    if (longValue > j9) {
                                        contentValues.put("max", Long.valueOf(longValue));
                                    }
                                    SQLiteDatabase sQLiteDatabase2 = this.f7573d;
                                    sQLiteDatabase2.update("UsageStatValues", contentValues, str3 + j8, null);
                                    str5 = str10;
                                    str4 = str11;
                                } catch (Throwable th) {
                                    th = th;
                                    rawQuery2.close();
                                    throw th;
                                }
                            } else {
                                j3 = insert;
                                cursor = rawQuery;
                                contentValues.clear();
                                contentValues.put("stat_id", Long.valueOf(j3));
                                str4 = str7;
                                contentValues.put(str4, str9);
                                str5 = str8;
                                contentValues.put(str5, (Integer) 1);
                                contentValues.put("avg", Long.valueOf(longValue));
                                contentValues.put("max", Long.valueOf(longValue));
                                this.f7573d.insert("UsageStatValues", null, contentValues);
                            }
                            try {
                                rawQuery2.close();
                                it = it2;
                                insert = j3;
                                str7 = str4;
                                rawQuery = cursor;
                                str8 = str5;
                                c = 0;
                            } catch (Throwable th2) {
                                th = th2;
                                cursor.close();
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            cursor = rawQuery;
                        }
                    } else {
                        str8 = str8;
                    }
                    c2 = 1;
                }
            }
            rawQuery.close();
        } catch (Throwable th4) {
            th = th4;
            cursor = rawQuery;
        }
    }
}
