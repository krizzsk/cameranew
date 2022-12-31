package us.pinguo.common.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/* compiled from: DbDataBase.java */
/* loaded from: classes4.dex */
public class b extends e implements ReadWriteLock {
    c dbDefinition;
    ReadWriteLock readWriteLock;

    public b(String str, c cVar) {
        super(str, cVar.b, (SQLiteDatabase.CursorFactory) null, cVar.a);
        this.dbDefinition = cVar;
        this.readWriteLock = new ReentrantReadWriteLock();
    }

    public boolean beginTransactionLocked() {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            writeLock().lock();
            sQLiteDatabase = getWritableDatabase();
            sQLiteDatabase.beginTransaction();
            return true;
        } catch (Exception unused) {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception unused2) {
                }
            }
            writeLock().unlock();
            return false;
        }
    }

    public void endTransactionUnlocked() {
        try {
            getWritableDatabase().endTransaction();
        } catch (Exception unused) {
        } catch (Throwable th) {
            writeLock().unlock();
            throw th;
        }
        writeLock().unlock();
    }

    public void init() {
        getWritableDatabase();
    }

    @Override // us.pinguo.common.db.e
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        for (String str : this.dbDefinition.a()) {
            sQLiteDatabase.execSQL(str);
        }
    }

    @Override // us.pinguo.common.db.e
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }

    @Override // us.pinguo.common.db.e
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        sQLiteDatabase.setVersion(i3);
        List<String> c = this.dbDefinition.c(i2);
        ArrayList arrayList = new ArrayList();
        for (String str : c) {
            if (str != null) {
                if (str.startsWith("CREATE TABLE ")) {
                    int indexOf = str.indexOf("(");
                    if (indexOf > 13) {
                        arrayList.add(str.substring(13, indexOf).trim());
                    }
                    sQLiteDatabase.execSQL(str);
                } else {
                    boolean z = false;
                    if (!arrayList.isEmpty()) {
                        Iterator it = arrayList.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (str.contains((String) it.next())) {
                                    z = true;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    if (z) {
                        try {
                            sQLiteDatabase.execSQL(str);
                        } catch (Throwable th) {
                            Log.w("db-common", th);
                        }
                    } else {
                        sQLiteDatabase.execSQL(str);
                    }
                }
            }
        }
    }

    @Override // java.util.concurrent.locks.ReadWriteLock
    public Lock readLock() {
        return this.readWriteLock.readLock();
    }

    public void setTransactionSuccessful() {
        try {
            getWritableDatabase().setTransactionSuccessful();
        } catch (Exception unused) {
        }
    }

    @Override // java.util.concurrent.locks.ReadWriteLock
    public Lock writeLock() {
        return this.readWriteLock.writeLock();
    }

    public b(Context context, c cVar) {
        super(context.getApplicationContext(), cVar.b, (SQLiteDatabase.CursorFactory) null, cVar.a);
        this.dbDefinition = cVar;
        this.readWriteLock = new ReentrantReadWriteLock();
    }
}
