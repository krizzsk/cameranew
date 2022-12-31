package com.tapjoy.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
/* loaded from: classes3.dex */
public final class g extends at implements ax, Closeable {
    private SQLiteDatabase a;
    private final bd b;
    private int c;

    public g(File file, bd bdVar) {
        SQLiteDatabase openOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(file, (SQLiteDatabase.CursorFactory) null);
        this.a = openOrCreateDatabase;
        this.b = bdVar;
        if (openOrCreateDatabase.getVersion() != 1) {
            this.a.beginTransaction();
            try {
                this.a.execSQL("CREATE TABLE IF NOT EXISTS List(value BLOB)");
                this.a.setVersion(1);
                this.a.setTransactionSuccessful();
            } finally {
                this.a.endTransaction();
            }
        }
        this.c = a();
    }

    private int a() {
        Cursor cursor = null;
        try {
            cursor = this.a.rawQuery("SELECT COUNT(1) FROM List", null);
            if (cursor.moveToNext()) {
                return cursor.getInt(0);
            }
            return 0;
        } finally {
            a(cursor);
        }
    }

    @Override // com.tapjoy.internal.ax
    public final void b(int i2) {
        int i3;
        if (i2 <= 0 || i2 > (i3 = this.c)) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 == i3) {
            clear();
            return;
        }
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase = this.a;
            StringBuilder sb = new StringBuilder("SELECT rowid FROM List ORDER BY rowid LIMIT ");
            sb.append(i2 - 1);
            sb.append(",1");
            Cursor rawQuery = sQLiteDatabase.rawQuery(sb.toString(), null);
            try {
                if (rawQuery.moveToNext()) {
                    long j2 = rawQuery.getLong(0);
                    rawQuery.close();
                    SQLiteDatabase sQLiteDatabase2 = this.a;
                    int delete = sQLiteDatabase2.delete("List", "rowid <= " + j2, null);
                    this.c = this.c - delete;
                    if (delete == i2) {
                        a((Cursor) null);
                        return;
                    }
                    throw new IllegalStateException("Try to delete " + i2 + ", but deleted " + delete);
                }
                throw new IllegalStateException();
            } catch (Throwable th) {
                th = th;
                cursor = rawQuery;
                a(cursor);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.a.delete("List", "1", null);
        this.c = 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        SQLiteDatabase sQLiteDatabase = this.a;
        if (sQLiteDatabase != null) {
            sQLiteDatabase.close();
            this.a = null;
        }
    }

    protected final void finalize() {
        close();
        super.finalize();
    }

    @Override // java.util.Queue
    public final boolean offer(Object obj) {
        jp.a(obj);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                this.b.a(byteArrayOutputStream, obj);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                jz.a(byteArrayOutputStream);
                ContentValues contentValues = new ContentValues();
                contentValues.put(FirebaseAnalytics.Param.VALUE, byteArray);
                if (this.a.insert("List", null, contentValues) == -1) {
                    return false;
                }
                this.c++;
                return true;
            } catch (IOException e2) {
                throw new IllegalArgumentException(e2);
            }
        } catch (Throwable th) {
            jz.a(byteArrayOutputStream);
            throw th;
        }
    }

    @Override // java.util.Queue
    public final Object peek() {
        if (this.c > 0) {
            return a(0);
        }
        return null;
    }

    @Override // java.util.Queue
    public final Object poll() {
        if (this.c > 0) {
            Object peek = peek();
            b(1);
            return peek;
        }
        return null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.c;
    }

    @Override // com.tapjoy.internal.ax
    public final Object a(int i2) {
        if (i2 >= 0 && i2 < this.c) {
            try {
                SQLiteDatabase sQLiteDatabase = this.a;
                Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT value FROM List ORDER BY rowid LIMIT " + i2 + ",1", null);
                if (rawQuery.moveToNext()) {
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(rawQuery.getBlob(0));
                    try {
                        Object b = this.b.b(byteArrayInputStream);
                        jz.a(byteArrayInputStream);
                        a(rawQuery);
                        return b;
                    } catch (IOException e2) {
                        throw new IllegalStateException(e2);
                    }
                }
                throw new NoSuchElementException();
            } catch (Throwable th) {
                a((Cursor) null);
                throw th;
            }
        }
        throw new IndexOutOfBoundsException();
    }

    private static Cursor a(Cursor cursor) {
        if (cursor != null) {
            cursor.close();
            return null;
        }
        return null;
    }
}
