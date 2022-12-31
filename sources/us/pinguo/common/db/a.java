package us.pinguo.common.db;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
/* compiled from: DbBaseTableModel.java */
/* loaded from: classes4.dex */
public abstract class a extends g {
    protected final f dbTableDefinition;

    public a(f fVar, b bVar) {
        super(bVar);
        this.dbTableDefinition = fVar;
    }

    public List<Integer> bulkInsert(ContentValues[] contentValuesArr) {
        SQLiteDatabase writableDatabase;
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                try {
                    this.dbDataBase.writeLock().lock();
                    writableDatabase = this.dbDataBase.getWritableDatabase();
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception unused) {
        }
        if (writableDatabase == null) {
            if (writableDatabase != null) {
                try {
                    writableDatabase.endTransaction();
                } catch (Exception unused2) {
                }
            }
            this.dbDataBase.writeLock().unlock();
            return arrayList;
        }
        try {
            writableDatabase.beginTransaction();
            for (ContentValues contentValues : contentValuesArr) {
                arrayList.add(Integer.valueOf(Long.valueOf(writableDatabase.insert(this.dbTableDefinition.a, null, contentValues)).intValue()));
            }
            writableDatabase.setTransactionSuccessful();
        } catch (Exception e3) {
            e = e3;
            sQLiteDatabase = writableDatabase;
            e.printStackTrace();
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
            this.dbDataBase.writeLock().unlock();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            sQLiteDatabase = writableDatabase;
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception unused3) {
                }
            }
            this.dbDataBase.writeLock().unlock();
            throw th;
        }
        if (writableDatabase != null) {
            writableDatabase.endTransaction();
        }
        this.dbDataBase.writeLock().unlock();
        return arrayList;
    }

    public List<Integer> bulkInsertInTransaction(ContentValues[] contentValuesArr) {
        SQLiteDatabase writableDatabase;
        ArrayList arrayList = new ArrayList();
        try {
            writableDatabase = this.dbDataBase.getWritableDatabase();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (writableDatabase == null) {
            return arrayList;
        }
        for (ContentValues contentValues : contentValuesArr) {
            arrayList.add(Integer.valueOf(Long.valueOf(writableDatabase.insert(this.dbTableDefinition.a, null, contentValues)).intValue()));
        }
        return arrayList;
    }

    public boolean bulkUpdate(ContentValues[] contentValuesArr, String[] strArr, List<String[]> list) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                this.dbDataBase.writeLock().lock();
                SQLiteDatabase writableDatabase = this.dbDataBase.getWritableDatabase();
                if (writableDatabase == null) {
                    if (writableDatabase != null) {
                        try {
                            writableDatabase.endTransaction();
                        } catch (Exception unused) {
                        }
                    }
                    this.dbDataBase.writeLock().unlock();
                    return false;
                }
                writableDatabase.beginTransaction();
                for (int i2 = 0; i2 < contentValuesArr.length; i2++) {
                    writableDatabase.update(this.dbTableDefinition.a, contentValuesArr[i2], strArr[i2], list.get(i2));
                }
                writableDatabase.setTransactionSuccessful();
                if (writableDatabase != null) {
                    try {
                        writableDatabase.endTransaction();
                    } catch (Exception unused2) {
                    }
                }
                this.dbDataBase.writeLock().unlock();
                return true;
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception unused3) {
                    }
                }
                this.dbDataBase.writeLock().unlock();
                throw th;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (0 != 0) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception unused4) {
                }
            }
            this.dbDataBase.writeLock().unlock();
            return false;
        }
    }

    public boolean bulkUpdateInTransaction(ContentValues[] contentValuesArr, String[] strArr, List<String[]> list) {
        try {
            SQLiteDatabase writableDatabase = this.dbDataBase.getWritableDatabase();
            if (writableDatabase == null) {
                return false;
            }
            for (int i2 = 0; i2 < contentValuesArr.length; i2++) {
                writableDatabase.update(this.dbTableDefinition.a, contentValuesArr[i2], strArr[i2], list.get(i2));
            }
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public List<Integer> clearThenBulkInsert(ContentValues[] contentValuesArr) {
        SQLiteDatabase writableDatabase;
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                try {
                    this.dbDataBase.writeLock().lock();
                    writableDatabase = this.dbDataBase.getWritableDatabase();
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception unused) {
        }
        if (writableDatabase == null) {
            if (writableDatabase != null) {
                try {
                    writableDatabase.endTransaction();
                } catch (Exception unused2) {
                }
            }
            this.dbDataBase.writeLock().unlock();
            return arrayList;
        }
        try {
            writableDatabase.beginTransaction();
            writableDatabase.delete(this.dbTableDefinition.a, null, new String[0]);
            for (ContentValues contentValues : contentValuesArr) {
                arrayList.add(Integer.valueOf(Long.valueOf(writableDatabase.insert(this.dbTableDefinition.a, null, contentValues)).intValue()));
            }
            writableDatabase.setTransactionSuccessful();
            if (writableDatabase != null) {
                writableDatabase.endTransaction();
            }
        } catch (Exception e3) {
            e = e3;
            sQLiteDatabase = writableDatabase;
            e.printStackTrace();
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
            this.dbDataBase.writeLock().unlock();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            sQLiteDatabase = writableDatabase;
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception unused3) {
                }
            }
            this.dbDataBase.writeLock().unlock();
            throw th;
        }
        this.dbDataBase.writeLock().unlock();
        return arrayList;
    }

    public List<Integer> clearThenBulkInsertInTransaction(ContentValues[] contentValuesArr) {
        SQLiteDatabase writableDatabase;
        ArrayList arrayList = new ArrayList();
        try {
            writableDatabase = this.dbDataBase.getWritableDatabase();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (writableDatabase == null) {
            return arrayList;
        }
        writableDatabase.delete(this.dbTableDefinition.a, null, new String[0]);
        for (ContentValues contentValues : contentValuesArr) {
            arrayList.add(Integer.valueOf(Long.valueOf(writableDatabase.insert(this.dbTableDefinition.a, null, contentValues)).intValue()));
        }
        return arrayList;
    }

    public boolean delete(String str, String[] strArr) {
        try {
            this.dbDataBase.writeLock().lock();
            SQLiteDatabase writableDatabase = this.dbDataBase.getWritableDatabase();
            if (writableDatabase == null) {
                return false;
            }
            writableDatabase.delete(this.dbTableDefinition.a, str, strArr);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        } finally {
            this.dbDataBase.writeLock().unlock();
        }
    }

    public boolean deleteAll() {
        return delete(null, new String[0]);
    }

    public int insert(ContentValues contentValues) {
        try {
            this.dbDataBase.writeLock().lock();
            SQLiteDatabase writableDatabase = this.dbDataBase.getWritableDatabase();
            if (writableDatabase == null) {
                return -1;
            }
            return Long.valueOf(writableDatabase.insert(this.dbTableDefinition.a, null, contentValues)).intValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        } finally {
            this.dbDataBase.writeLock().unlock();
        }
    }

    public boolean update(ContentValues contentValues, String str, String[] strArr) {
        try {
            this.dbDataBase.writeLock().lock();
            SQLiteDatabase writableDatabase = this.dbDataBase.getWritableDatabase();
            if (writableDatabase == null) {
                return false;
            }
            writableDatabase.update(this.dbTableDefinition.a, contentValues, str, strArr);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        } finally {
            this.dbDataBase.writeLock().unlock();
        }
    }
}
