package com.bytedance.sdk.openadsdk.core;

import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DBHelper.java */
/* loaded from: classes.dex */
public class f {
    private static final Object c = new Object();
    private c a;
    private Context b;

    /* compiled from: DBHelper.java */
    /* loaded from: classes.dex */
    private class b extends AbstractCursor {
        private b() {
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public String[] getColumnNames() {
            return new String[0];
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public int getCount() {
            return 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public double getDouble(int i2) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public float getFloat(int i2) {
            return 0.0f;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public int getInt(int i2) {
            return 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public long getLong(int i2) {
            return 0L;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public short getShort(int i2) {
            return (short) 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public String getString(int i2) {
            return null;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public boolean isNull(int i2) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Context context) {
        try {
            this.b = context == null ? o.a() : context.getApplicationContext();
            if (this.a == null) {
                this.a = new c();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context c() {
        Context context = this.b;
        return context == null ? o.a() : context;
    }

    public c a() {
        return this.a;
    }

    /* compiled from: DBHelper.java */
    /* loaded from: classes.dex */
    public class c {
        private SQLiteDatabase b = null;

        public c() {
        }

        private synchronized void d() {
            try {
                synchronized (f.c) {
                    SQLiteDatabase sQLiteDatabase = this.b;
                    if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                        f fVar = f.this;
                        SQLiteDatabase writableDatabase = new a(fVar.c()).getWritableDatabase();
                        this.b = writableDatabase;
                        writableDatabase.setLockingEnabled(false);
                    }
                }
            } finally {
            }
        }

        private synchronized boolean e() {
            boolean z;
            SQLiteDatabase sQLiteDatabase = this.b;
            if (sQLiteDatabase != null) {
                z = sQLiteDatabase.inTransaction();
            }
            return z;
        }

        public synchronized void a(String str) throws SQLException {
            try {
                d();
                this.b.execSQL(str);
            } catch (Throwable th) {
                if (e()) {
                    throw th;
                }
            }
        }

        public synchronized void b() {
            d();
            SQLiteDatabase sQLiteDatabase = this.b;
            if (sQLiteDatabase == null) {
                return;
            }
            sQLiteDatabase.setTransactionSuccessful();
        }

        public synchronized void c() {
            d();
            SQLiteDatabase sQLiteDatabase = this.b;
            if (sQLiteDatabase == null) {
                return;
            }
            sQLiteDatabase.endTransaction();
        }

        public synchronized Cursor a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
            Cursor cursor;
            try {
                d();
                cursor = this.b.query(str, strArr, str2, strArr2, str3, str4, str5);
            } catch (Throwable th) {
                th.printStackTrace();
                b bVar = new b();
                if (e()) {
                    throw th;
                }
                cursor = bVar;
            }
            return cursor;
        }

        public synchronized int a(String str, ContentValues contentValues, String str2, String[] strArr) {
            int i2;
            try {
                d();
                i2 = this.b.update(str, contentValues, str2, strArr);
            } catch (Exception e2) {
                e2.printStackTrace();
                if (e()) {
                    throw e2;
                }
                i2 = 0;
            }
            return i2;
        }

        public synchronized long a(String str, String str2, ContentValues contentValues) {
            long j2;
            try {
                d();
                j2 = this.b.insert(str, str2, contentValues);
            } catch (Exception e2) {
                e2.printStackTrace();
                if (e()) {
                    throw e2;
                }
                j2 = -1;
            }
            return j2;
        }

        public synchronized int a(String str, String str2, String[] strArr) {
            int i2;
            try {
                d();
                i2 = this.b.delete(str, str2, strArr);
            } catch (Exception e2) {
                e2.printStackTrace();
                if (e()) {
                    throw e2;
                }
                i2 = 0;
            }
            return i2;
        }

        public synchronized void a() {
            d();
            SQLiteDatabase sQLiteDatabase = this.b;
            if (sQLiteDatabase == null) {
                return;
            }
            sQLiteDatabase.beginTransaction();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DBHelper.java */
    /* loaded from: classes.dex */
    public class a extends SQLiteOpenHelper {
        final Context a;

        public a(Context context) {
            super(context, "ttopensdk.db", (SQLiteDatabase.CursorFactory) null, 4);
            this.a = context;
        }

        private void a(SQLiteDatabase sQLiteDatabase, Context context) {
            com.bytedance.sdk.openadsdk.utils.o.b("DBHelper", "initDB........");
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.c.f.d());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.c.n.f());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.c.l.d());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.j.h.b());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.core.widget.webview.a.a.d());
        }

        private ArrayList<String> b(SQLiteDatabase sQLiteDatabase) {
            ArrayList<String> arrayList = new ArrayList<>();
            try {
                Cursor rawQuery = sQLiteDatabase.rawQuery("select name from sqlite_master where type='table' order by name", null);
                if (rawQuery != null) {
                    while (rawQuery.moveToNext()) {
                        String string = rawQuery.getString(0);
                        if (!string.equals("android_metadata") && !string.equals("sqlite_sequence")) {
                            arrayList.add(string);
                        }
                    }
                    rawQuery.close();
                }
            } catch (Exception unused) {
            }
            return arrayList;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                a(sQLiteDatabase, this.a);
            } catch (Throwable unused) {
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            try {
                com.bytedance.sdk.openadsdk.utils.o.b("DBHelper", "onUpgrade....数据库版本升级.....old:" + i2 + ",new:" + i3);
                if (i2 <= i3) {
                    a(sQLiteDatabase, f.this.b);
                } else {
                    a(sQLiteDatabase);
                    a(sQLiteDatabase, f.this.b);
                    com.bytedance.sdk.openadsdk.utils.o.b("DBHelper", "onUpgrade...逆向安装.数据库重置-创建表.....");
                }
                if (i2 == 1) {
                    com.bytedance.sdk.openadsdk.utils.o.b("DBHelper", "onUpgrade.....执行表创建.....");
                } else if (i2 == 2) {
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'ad_video_info';");
                } else if (i2 == 3) {
                    sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.c.n.f());
                } else if (i2 == 4) {
                    sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.core.widget.webview.a.a.d());
                } else if (i2 != 5) {
                } else {
                    sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.c.l.d());
                }
            } catch (Throwable unused) {
            }
        }

        private void a(SQLiteDatabase sQLiteDatabase) {
            ArrayList<String> b = b(sQLiteDatabase);
            if (b == null || b.size() <= 0) {
                return;
            }
            Iterator<String> it = b.iterator();
            while (it.hasNext()) {
                sQLiteDatabase.execSQL(String.format("DROP TABLE IF EXISTS %s ;", it.next()));
            }
        }
    }
}
