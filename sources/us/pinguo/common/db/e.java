package us.pinguo.common.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.util.Log;
/* compiled from: DbSQLiteOpenHelper.java */
/* loaded from: classes4.dex */
public abstract class e {
    private static final String TAG = SQLiteOpenHelper.class.getSimpleName();
    private Context mContext;
    private final SQLiteDatabase.CursorFactory mFactory;
    private final String mFilePath;
    private final int mNewVersion;
    private SQLiteDatabase mDatabase = null;
    private boolean mIsInitializing = false;

    public e(String str, String str2, SQLiteDatabase.CursorFactory cursorFactory, int i2) {
        if (i2 >= 1) {
            this.mFilePath = str + str2;
            this.mFactory = cursorFactory;
            this.mNewVersion = i2;
            return;
        }
        throw new IllegalArgumentException("Version must be >= 1, was " + i2);
    }

    public synchronized void close() {
        if (!this.mIsInitializing) {
            SQLiteDatabase sQLiteDatabase = this.mDatabase;
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                this.mDatabase.close();
                this.mDatabase = null;
            }
        } else {
            throw new IllegalStateException("Closed during initialization");
        }
    }

    public synchronized SQLiteDatabase getReadableDatabase() {
        SQLiteDatabase sQLiteDatabase = this.mDatabase;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
            return this.mDatabase;
        } else if (!this.mIsInitializing) {
            if (Environment.getExternalStorageState().equals("mounted")) {
                try {
                    return getWritableDatabase();
                } catch (SQLiteException e2) {
                    if (this.mFilePath != null) {
                        String str = TAG;
                        Log.e(str, "Couldn't open " + this.mFilePath + " for writing (will try read-only):", e2);
                        this.mIsInitializing = true;
                        SQLiteDatabase openDatabase = SQLiteDatabase.openDatabase(this.mFilePath, this.mFactory, 1);
                        if (openDatabase.getVersion() == this.mNewVersion) {
                            onOpen(openDatabase);
                            Log.w(str, "Opened " + this.mFilePath + " in read-only mode");
                            this.mDatabase = openDatabase;
                            this.mIsInitializing = false;
                            if (openDatabase != null && openDatabase != openDatabase) {
                                openDatabase.close();
                            }
                            return openDatabase;
                        }
                        throw new SQLiteException("Can't upgrade read-only database from version " + openDatabase.getVersion() + " to " + this.mNewVersion + ": " + this.mFilePath);
                    }
                    throw e2;
                }
            }
            return null;
        } else {
            throw new IllegalStateException("getReadableDatabase called recursively");
        }
    }

    public synchronized SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase openOrCreateDatabase;
        SQLiteDatabase sQLiteDatabase = this.mDatabase;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen() && !this.mDatabase.isReadOnly()) {
            return this.mDatabase;
        } else if (!this.mIsInitializing) {
            SQLiteDatabase sQLiteDatabase2 = null;
            if (this.mContext == null && !Environment.getExternalStorageState().equals("mounted")) {
                return null;
            }
            try {
                this.mIsInitializing = true;
                Context context = this.mContext;
                if (context == null) {
                    openOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(this.mFilePath, this.mFactory);
                } else {
                    openOrCreateDatabase = context.openOrCreateDatabase(this.mFilePath, 0, this.mFactory);
                }
                if (openOrCreateDatabase == null) {
                    this.mIsInitializing = false;
                    if (openOrCreateDatabase != null) {
                        openOrCreateDatabase.close();
                    }
                    return null;
                }
                try {
                    int version = openOrCreateDatabase.getVersion();
                    if (version != this.mNewVersion) {
                        openOrCreateDatabase.beginTransaction();
                        if (version == 0) {
                            onCreate(openOrCreateDatabase);
                            openOrCreateDatabase.setVersion(this.mNewVersion);
                        } else {
                            int i2 = this.mNewVersion;
                            if (version > i2) {
                                onDowngrade(openOrCreateDatabase, version, i2);
                            } else {
                                onUpgrade(openOrCreateDatabase, version, i2);
                            }
                        }
                        openOrCreateDatabase.setTransactionSuccessful();
                        openOrCreateDatabase.endTransaction();
                    }
                    onOpen(openOrCreateDatabase);
                    this.mIsInitializing = false;
                    SQLiteDatabase sQLiteDatabase3 = this.mDatabase;
                    if (sQLiteDatabase3 != null) {
                        try {
                            sQLiteDatabase3.close();
                        } catch (Exception unused) {
                        }
                    }
                    this.mDatabase = openOrCreateDatabase;
                    return openOrCreateDatabase;
                } catch (Throwable th) {
                    sQLiteDatabase2 = openOrCreateDatabase;
                    th = th;
                    this.mIsInitializing = false;
                    if (sQLiteDatabase2 != null) {
                        sQLiteDatabase2.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            throw new IllegalStateException("getWritableDatabase called recursively");
        }
    }

    public abstract void onCreate(SQLiteDatabase sQLiteDatabase);

    public abstract void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3);

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
    }

    public abstract void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3);

    public e(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i2) {
        if (i2 < 1) {
            throw new IllegalArgumentException("Version must be >= 1, was " + i2);
        } else if (context != null) {
            this.mContext = context;
            this.mFilePath = str;
            this.mFactory = cursorFactory;
            this.mNewVersion = i2;
        } else {
            throw new IllegalArgumentException("database with context,context should not be null!");
        }
    }
}
