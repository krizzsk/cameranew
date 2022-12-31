package com.mob.tools.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class SQLiteHelper {

    /* loaded from: classes3.dex */
    public static class SingleTableDB {
        private SQLiteDatabase db;
        private HashMap<String, Boolean> fieldLimits;
        private LinkedHashMap<String, String> fieldTypes;
        private String name;
        private String path;
        private String primary;
        private boolean primaryAutoincrement;

        /* JADX INFO: Access modifiers changed from: private */
        public void close() {
            SQLiteDatabase sQLiteDatabase = this.db;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
                this.db = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String getName() {
            return this.name;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void open() {
            boolean z;
            File file = new File(this.path);
            if (this.db != null && !file.exists()) {
                this.db.close();
                File parentFile = file.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                this.db = null;
            }
            if (this.db == null) {
                SQLiteDatabase openOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(file, (SQLiteDatabase.CursorFactory) null);
                this.db = openOrCreateDatabase;
                Cursor query = openOrCreateDatabase.query("sqlite_master", null, "type=? and name=?", new String[]{"table", this.name}, null, null, null);
                if (query != null) {
                    z = query.getCount() <= 0;
                    query.close();
                } else {
                    z = true;
                }
                if (z) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("create table  ");
                    sb.append(this.name);
                    sb.append("(");
                    for (Map.Entry<String, String> entry : this.fieldTypes.entrySet()) {
                        String key = entry.getKey();
                        String value = entry.getValue();
                        boolean booleanValue = this.fieldLimits.get(key).booleanValue();
                        boolean equals = key.equals(this.primary);
                        boolean z2 = equals ? this.primaryAutoincrement : false;
                        sb.append(key);
                        sb.append(" ");
                        sb.append(value);
                        sb.append(booleanValue ? " not null" : "");
                        sb.append(equals ? " primary key" : "");
                        sb.append(z2 ? " autoincrement," : ",");
                    }
                    sb.replace(sb.length() - 1, sb.length(), ");");
                    this.db.execSQL(sb.toString());
                }
            }
        }

        public void addField(String str, String str2, boolean z) {
            if (this.db == null) {
                this.fieldTypes.put(str, str2);
                this.fieldLimits.put(str, Boolean.valueOf(z));
            }
        }

        public void setPrimary(String str, boolean z) {
            this.primary = str;
            this.primaryAutoincrement = z;
        }

        private SingleTableDB(String str, String str2) {
            this.path = str;
            this.name = str2;
            this.fieldTypes = new LinkedHashMap<>();
            this.fieldLimits = new HashMap<>();
        }
    }

    public static void close(SingleTableDB singleTableDB) {
        singleTableDB.close();
    }

    public static int delete(SingleTableDB singleTableDB, String str, String[] strArr) throws Throwable {
        singleTableDB.open();
        return singleTableDB.db.delete(singleTableDB.getName(), str, strArr);
    }

    public static void execSQL(SingleTableDB singleTableDB, String str) throws Throwable {
        singleTableDB.open();
        singleTableDB.db.beginTransaction();
        try {
            singleTableDB.db.execSQL(str);
            singleTableDB.db.setTransactionSuccessful();
        } finally {
        }
    }

    public static SingleTableDB getDatabase(Context context, String str) {
        return getDatabase(context.getDatabasePath(str).getPath(), str);
    }

    public static int getSize(SingleTableDB singleTableDB) throws Throwable {
        singleTableDB.open();
        Cursor cursor = null;
        try {
            cursor = singleTableDB.db.query(singleTableDB.getName(), null, null, null, null, null, null);
            return cursor == null ? 0 : cursor.getCount();
        } catch (Throwable th) {
            try {
                throw th;
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
    }

    public static long insert(SingleTableDB singleTableDB, ContentValues contentValues) throws Throwable {
        singleTableDB.open();
        return singleTableDB.db.replace(singleTableDB.getName(), null, contentValues);
    }

    public static Cursor query(SingleTableDB singleTableDB, String[] strArr, String str, String[] strArr2, String str2) throws Throwable {
        singleTableDB.open();
        return singleTableDB.db.query(singleTableDB.getName(), strArr, str, strArr2, null, null, str2);
    }

    public static Cursor rawQuery(SingleTableDB singleTableDB, String str, String[] strArr) throws Throwable {
        singleTableDB.open();
        return singleTableDB.db.rawQuery(str, strArr);
    }

    public static int update(SingleTableDB singleTableDB, ContentValues contentValues, String str, String[] strArr) throws Throwable {
        singleTableDB.open();
        return singleTableDB.db.update(singleTableDB.getName(), contentValues, str, strArr);
    }

    public static SingleTableDB getDatabase(String str, String str2) {
        return new SingleTableDB(str, str2);
    }
}
