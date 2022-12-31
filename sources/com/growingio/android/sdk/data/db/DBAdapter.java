package com.growingio.android.sdk.data.db;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Handler;
import android.util.Pair;
import com.growingio.android.sdk.base.event.OnCloseBufferEvent;
import com.growingio.android.sdk.collection.CoreAppState;
import com.growingio.android.sdk.collection.CoreInitialize;
import com.growingio.android.sdk.collection.CustomEvent;
import com.growingio.android.sdk.data.DataSubscriberInitialize;
import com.growingio.android.sdk.data.db.MessageUploader;
import com.growingio.android.sdk.message.HandleType;
import com.growingio.android.sdk.message.MessageHandler;
import com.growingio.android.sdk.models.ActionEvent;
import com.growingio.android.sdk.models.AppCloseEvent;
import com.growingio.android.sdk.models.ConversionEvent;
import com.growingio.android.sdk.models.PageEvent;
import com.growingio.android.sdk.models.PageVariableEvent;
import com.growingio.android.sdk.models.PeopleEvent;
import com.growingio.android.sdk.models.VisitEvent;
import com.growingio.android.sdk.models.VisitorVarEvent;
import com.growingio.android.sdk.models.ad.ReengageEvent;
import com.growingio.android.sdk.utils.Util;
import com.growingio.eventcenter.EventCenter;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class DBAdapter {
    private static final int CLOSE_DATABASE_DELAY = 20000;
    private static final String KEY_CREATED_AT = "createdAt";
    private static final String KEY_DATA = "data";
    private static final String KEY_EVENT_TYPE = "eventType";
    private static final String KEY_INSTANT = "instant";
    private static final String SQL_CREATE_EVENTS;
    private static final String SQL_DELETE_EVENTS;
    private static final String SQL_UPDATE_FROM_V2;
    private static final String SQL_UPDATE_FROM_V2_INSTANT;
    private static final String TAG = "GIO.DBAdapter";
    private static final Object mDbLocker = new Object();
    private static DBAdapter sInstance;
    private CoreAppState coreAppState;
    private Runnable mCloseDatabase = new Runnable() { // from class: com.growingio.android.sdk.data.db.DBAdapter.1
        @Override // java.lang.Runnable
        public void run() {
            try {
                synchronized (DBAdapter.mDbLocker) {
                    DBAdapter.this.mDbHelper.getReadableDatabase().close();
                }
                EventCenter.getInstance().post(new OnCloseBufferEvent());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    };
    private final DBHelper mDbHelper;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.growingio.android.sdk.data.db.DBAdapter$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$growingio$android$sdk$data$db$MessageUploader$UPLOAD_TYPE;

        static {
            int[] iArr = new int[MessageUploader.UPLOAD_TYPE.values().length];
            $SwitchMap$com$growingio$android$sdk$data$db$MessageUploader$UPLOAD_TYPE = iArr;
            try {
                iArr[MessageUploader.UPLOAD_TYPE.AD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$growingio$android$sdk$data$db$MessageUploader$UPLOAD_TYPE[MessageUploader.UPLOAD_TYPE.CUSTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$growingio$android$sdk$data$db$MessageUploader$UPLOAD_TYPE[MessageUploader.UPLOAD_TYPE.PV.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$growingio$android$sdk$data$db$MessageUploader$UPLOAD_TYPE[MessageUploader.UPLOAD_TYPE.OTHER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$growingio$android$sdk$data$db$MessageUploader$UPLOAD_TYPE[MessageUploader.UPLOAD_TYPE.INSTANT_IMP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$growingio$android$sdk$data$db$MessageUploader$UPLOAD_TYPE[MessageUploader.UPLOAD_TYPE.NON_INSTANT_IMP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$growingio$android$sdk$data$db$MessageUploader$UPLOAD_TYPE[MessageUploader.UPLOAD_TYPE.IMP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class DBHelper extends SQLiteOpenHelper {
        static final String DATABASE_NAME = "growing.db";
        static final int DATABASE_VERSION = 3;

        DBHelper(Context context) {
            super(context, Util.getProcessNameForDB(context) + DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 3);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        @SuppressLint({"SQLiteString"})
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(DBAdapter.SQL_CREATE_EVENTS);
            MessageHandler.handleMessage(HandleType.DB_CREATE_DB, new Object[0]);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            onUpgrade(sQLiteDatabase, i2, i3);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            if (i2 == 2) {
                sQLiteDatabase.execSQL(DBAdapter.SQL_UPDATE_FROM_V2);
                sQLiteDatabase.execSQL(DBAdapter.SQL_UPDATE_FROM_V2_INSTANT);
                MessageHandler.handleMessage(HandleType.DB_UPGRADE_DB, new Object[0]);
                return;
            }
            sQLiteDatabase.execSQL(DBAdapter.SQL_DELETE_EVENTS);
            onCreate(sQLiteDatabase);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum Table {
        EVENTS("events");
        
        private String mName;

        Table(String str) {
            this.mName = str;
        }

        public String getName() {
            return this.mName;
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE ");
        Table table = Table.EVENTS;
        sb.append(table.getName());
        sb.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT,");
        sb.append(KEY_EVENT_TYPE);
        sb.append(" STRING NOT NULL,");
        sb.append("data");
        sb.append(" STRING NOT NULL,");
        sb.append(KEY_CREATED_AT);
        sb.append(" INTEGER NOT NULL,");
        sb.append(KEY_INSTANT);
        sb.append(" INTEGER NOT NULL DEFAULT 0);CREATE INDEX IF NOT EXISTS instant_idx ON ");
        sb.append(table.getName());
        sb.append(" (");
        sb.append(KEY_INSTANT);
        sb.append(");CREATE INDEX IF NOT EXISTS time_idx ON ");
        sb.append(table.getName());
        sb.append(" (");
        sb.append(KEY_CREATED_AT);
        sb.append(");");
        SQL_CREATE_EVENTS = sb.toString();
        SQL_UPDATE_FROM_V2 = "ALTER TABLE " + table.getName() + " ADD COLUMN " + KEY_INSTANT + " BOOLEAN DEFAULT 0;CREATE INDEX IF NOT EXISTS instant_idx ON " + table + " (" + KEY_INSTANT + ");DROP INDEX time_idx;";
        StringBuilder sb2 = new StringBuilder();
        sb2.append("UPDATE ");
        sb2.append(table);
        sb2.append(" SET ");
        sb2.append(KEY_INSTANT);
        sb2.append(" = 1 WHERE ");
        sb2.append(KEY_EVENT_TYPE);
        sb2.append(" != 'imp';");
        SQL_UPDATE_FROM_V2_INSTANT = sb2.toString();
        SQL_DELETE_EVENTS = "DROP TABLE IF EXISTS " + table.getName();
    }

    DBAdapter(Context context) {
        this.mDbHelper = new DBHelper(context);
        CoreAppState coreAppState = CoreInitialize.coreAppState();
        this.coreAppState = coreAppState;
        coreAppState.networkState();
    }

    private void closeDatabaseDelayed() {
        Handler handler = DataSubscriberInitialize.messageUploader().getHandler();
        handler.removeCallbacks(this.mCloseDatabase);
        handler.postDelayed(this.mCloseDatabase, 20000L);
    }

    public static DBAdapter getsInstance() {
        return sInstance;
    }

    public static void initialize(Context context) {
        if (sInstance != null) {
            return;
        }
        synchronized (mDbLocker) {
            sInstance = new DBAdapter(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long cleanDataString(MessageUploader.UPLOAD_TYPE upload_type, String str) {
        MessageHandler.handleMessage(HandleType.DB_CLEAN_EVENT, upload_type.name(), str);
        switch (AnonymousClass2.$SwitchMap$com$growingio$android$sdk$data$db$MessageUploader$UPLOAD_TYPE[upload_type.ordinal()]) {
            case 1:
                return cleanupEvents(String.format("_id <= ? AND (%s = ? OR %s = ?)", KEY_EVENT_TYPE, KEY_EVENT_TYPE), str, "activate", ReengageEvent.TYPE_NAME);
            case 2:
                return cleanupEvents(String.format("_id <= ? AND (%s = ? OR %s = ? OR %s = ? OR %s = ? OR %s = ?)", KEY_EVENT_TYPE, KEY_EVENT_TYPE, KEY_EVENT_TYPE, KEY_EVENT_TYPE, KEY_EVENT_TYPE), str, CustomEvent.TYPE_NAME, PeopleEvent.TYPE_NAME, PageVariableEvent.TYPE_NAME, ConversionEvent.TYPE_NAME, VisitorVarEvent.TYPE_NAME);
            case 3:
                return cleanupEvents(String.format("_id <= ? AND (%s = ? OR %s = ? OR %s = ?)", KEY_EVENT_TYPE, KEY_EVENT_TYPE, KEY_EVENT_TYPE), str, PageEvent.TYPE_NAME, VisitEvent.TYPE_NAME, AppCloseEvent.TYPE_NAME);
            case 4:
                return cleanupEvents(String.format("_id <= ? AND (%s = ? OR %s = ?)", KEY_EVENT_TYPE, KEY_EVENT_TYPE), str, ActionEvent.CLICK_TYPE_NAME, ActionEvent.CHANGE_TYPE_NAME);
            case 5:
                return cleanupEvents(String.format("_id <= ? AND %s = 1 AND %s = ?", KEY_INSTANT, KEY_EVENT_TYPE), str, ActionEvent.IMP_TYPE_NAME);
            case 6:
                return cleanupEvents(String.format("_id <= ? AND %s = 0 AND %s = ?", KEY_INSTANT, KEY_EVENT_TYPE), str, ActionEvent.IMP_TYPE_NAME);
            case 7:
                return cleanupEvents(String.format("_id <= ? AND %s = ?", KEY_EVENT_TYPE), str, ActionEvent.IMP_TYPE_NAME);
            default:
                return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004e, code lost:
        if (r2 == null) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0033, code lost:
        if (r2 != null) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void cleanupEvents(long r7) {
        /*
            r6 = this;
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.Long r2 = java.lang.Long.valueOf(r7)
            r3 = 0
            r1[r3] = r2
            r2 = 2097156(0x200004, float:2.938741E-39)
            com.growingio.android.sdk.message.MessageHandler.handleMessage(r2, r1)
            java.lang.Object r1 = com.growingio.android.sdk.data.db.DBAdapter.mDbLocker
            monitor-enter(r1)
            r2 = 0
            com.growingio.android.sdk.data.db.DBAdapter$DBHelper r4 = r6.mDbHelper     // Catch: java.lang.Throwable -> L39 android.database.SQLException -> L41 android.database.sqlite.SQLiteDiskIOException -> L49
            android.database.sqlite.SQLiteDatabase r2 = r4.getWritableDatabase()     // Catch: java.lang.Throwable -> L39 android.database.SQLException -> L41 android.database.sqlite.SQLiteDiskIOException -> L49
            com.growingio.android.sdk.data.db.DBAdapter$Table r4 = com.growingio.android.sdk.data.db.DBAdapter.Table.EVENTS     // Catch: java.lang.Throwable -> L39 android.database.SQLException -> L41 android.database.sqlite.SQLiteDiskIOException -> L49
            java.lang.String r4 = r4.getName()     // Catch: java.lang.Throwable -> L39 android.database.SQLException -> L41 android.database.sqlite.SQLiteDiskIOException -> L49
            java.lang.String r5 = "createdAt <= ?"
            java.lang.String[] r0 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L39 android.database.SQLException -> L41 android.database.sqlite.SQLiteDiskIOException -> L49
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch: java.lang.Throwable -> L39 android.database.SQLException -> L41 android.database.sqlite.SQLiteDiskIOException -> L49
            r0[r3] = r7     // Catch: java.lang.Throwable -> L39 android.database.SQLException -> L41 android.database.sqlite.SQLiteDiskIOException -> L49
            int r7 = r2.delete(r4, r5, r0)     // Catch: java.lang.Throwable -> L39 android.database.SQLException -> L41 android.database.sqlite.SQLiteDiskIOException -> L49
            java.lang.String r8 = "delete"
            com.growingio.android.sdk.data.DiagnoseLog.saveLogIfEnabled(r8, r7)     // Catch: java.lang.Throwable -> L39 android.database.SQLException -> L41 android.database.sqlite.SQLiteDiskIOException -> L49
            if (r2 == 0) goto L51
        L35:
            r6.closeDatabaseDelayed()     // Catch: java.lang.Throwable -> L53
            goto L51
        L39:
            java.lang.String r7 = "throwable"
            com.growingio.android.sdk.data.DiagnoseLog.saveLogIfEnabled(r7)     // Catch: java.lang.Throwable -> L55
            if (r2 == 0) goto L51
            goto L35
        L41:
            java.lang.String r7 = "dbo"
            com.growingio.android.sdk.data.DiagnoseLog.saveLogIfEnabled(r7)     // Catch: java.lang.Throwable -> L55
            if (r2 == 0) goto L51
            goto L35
        L49:
            java.lang.String r7 = "dbioc"
            com.growingio.android.sdk.data.DiagnoseLog.saveLogIfEnabled(r7)     // Catch: java.lang.Throwable -> L55
            if (r2 == 0) goto L51
            goto L35
        L51:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L53
            return
        L53:
            r7 = move-exception
            goto L5c
        L55:
            r7 = move-exception
            if (r2 == 0) goto L5b
            r6.closeDatabaseDelayed()     // Catch: java.lang.Throwable -> L53
        L5b:
            throw r7     // Catch: java.lang.Throwable -> L53
        L5c:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L53
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.growingio.android.sdk.data.db.DBAdapter.cleanupEvents(long):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Pair<String, List<String>> generateDataString(MessageUploader.UPLOAD_TYPE upload_type) {
        MessageHandler.handleMessage(HandleType.DB_READ_DB, upload_type.name());
        switch (AnonymousClass2.$SwitchMap$com$growingio$android$sdk$data$db$MessageUploader$UPLOAD_TYPE[upload_type.ordinal()]) {
            case 1:
                return generateDataString(String.format("SELECT _id, %s FROM %s WHERE (%s = '%s' or %s = '%s') ORDER BY _id LIMIT 50", "data", Table.EVENTS, KEY_EVENT_TYPE, "activate", KEY_EVENT_TYPE, ReengageEvent.TYPE_NAME), null);
            case 2:
                return generateDataString(String.format("SELECT _id, %s FROM %s WHERE (%s = '%s' or %s = '%s' or %s = '%s' or %s = '%s' or %s = '%s') ORDER BY _id LIMIT 50", "data", Table.EVENTS, KEY_EVENT_TYPE, CustomEvent.TYPE_NAME, KEY_EVENT_TYPE, PageVariableEvent.TYPE_NAME, KEY_EVENT_TYPE, ConversionEvent.TYPE_NAME, KEY_EVENT_TYPE, PeopleEvent.TYPE_NAME, KEY_EVENT_TYPE, VisitorVarEvent.TYPE_NAME), null);
            case 3:
                return generateDataString(String.format("SELECT _id, %s FROM %s WHERE %s = '%s' OR %s = '%s'  OR %s = '%s' ORDER BY _id LIMIT 50", "data", Table.EVENTS, KEY_EVENT_TYPE, PageEvent.TYPE_NAME, KEY_EVENT_TYPE, VisitEvent.TYPE_NAME, KEY_EVENT_TYPE, AppCloseEvent.TYPE_NAME), null);
            case 4:
                return generateDataString(String.format("SELECT _id, %s FROM %s WHERE ( %s = '%s' OR %s = '%s') ORDER BY _id LIMIT 50", "data", Table.EVENTS, KEY_EVENT_TYPE, ActionEvent.CLICK_TYPE_NAME, KEY_EVENT_TYPE, ActionEvent.CHANGE_TYPE_NAME), null);
            case 5:
                return generateDataString(String.format("SELECT _id, %s FROM %s WHERE %s = 1 AND %s = '%s' ORDER BY _id LIMIT 50", "data", Table.EVENTS, KEY_INSTANT, KEY_EVENT_TYPE, ActionEvent.IMP_TYPE_NAME), null);
            case 6:
                return generateDataString(String.format("SELECT _id, %s FROM %s WHERE %s = 0 AND %s = '%s' ORDER BY _id LIMIT 50", "data", Table.EVENTS, KEY_INSTANT, KEY_EVENT_TYPE, ActionEvent.IMP_TYPE_NAME), null);
            case 7:
                return generateDataString(String.format("SELECT _id, %s FROM %s WHERE %s = '%s' ORDER BY _id LIMIT 50", "data", Table.EVENTS, KEY_EVENT_TYPE, ActionEvent.IMP_TYPE_NAME), null);
            default:
                return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0083, code lost:
        if (r2 != null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0085, code lost:
        closeDatabaseDelayed();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0095, code lost:
        if (r1 == null) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void saveEvent(java.lang.String r7, boolean r8, java.lang.String r9) {
        /*
            r6 = this;
            boolean r0 = com.growingio.android.sdk.collection.GConfig.DEBUG
            if (r0 == 0) goto L29
            java.lang.String r0 = "GIO.DBAdapter"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "save "
            r1.append(r2)
            if (r8 == 0) goto L15
            java.lang.String r2 = "instant"
            goto L17
        L15:
            java.lang.String r2 = "non-instant"
        L17:
            r1.append(r2)
            java.lang.String r2 = " Message: "
            r1.append(r2)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            android.util.Log.w(r0, r1)
        L29:
            r0 = 2097155(0x200003, float:2.93874E-39)
            r1 = 3
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r2 = 0
            r1[r2] = r7
            r2 = 1
            java.lang.String r3 = java.lang.String.valueOf(r8)
            r1[r2] = r3
            r2 = 2
            r1[r2] = r9
            com.growingio.android.sdk.message.MessageHandler.handleMessage(r0, r1)
            java.lang.Object r0 = com.growingio.android.sdk.data.db.DBAdapter.mDbLocker
            monitor-enter(r0)
            r1 = 0
            com.growingio.android.sdk.data.db.DBAdapter$DBHelper r2 = r6.mDbHelper     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L90
            android.database.sqlite.SQLiteDatabase r2 = r2.getWritableDatabase()     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L90
            android.content.ContentValues r3 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8c
            r3.<init>()     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8c
            java.lang.String r4 = "eventType"
            r3.put(r4, r7)     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8c
            java.lang.String r7 = "data"
            r3.put(r7, r9)     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8c
            java.lang.String r7 = "createdAt"
            long r4 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8c
            java.lang.Long r9 = java.lang.Long.valueOf(r4)     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8c
            r3.put(r7, r9)     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8c
            java.lang.String r7 = "instant"
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8c
            r3.put(r7, r8)     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8c
            r7 = -1
            com.growingio.android.sdk.data.db.DBAdapter$Table r9 = com.growingio.android.sdk.data.db.DBAdapter.Table.EVENTS     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8c
            java.lang.String r9 = r9.getName()     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8c
            long r3 = r2.insert(r9, r1, r3)     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8c
            int r9 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r9 != 0) goto L83
            java.lang.String r7 = "dbw"
            com.growingio.android.sdk.data.DiagnoseLog.saveLogIfEnabled(r7)     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8c
        L83:
            if (r2 == 0) goto L98
        L85:
            r6.closeDatabaseDelayed()     // Catch: java.lang.Throwable -> La0
            goto L98
        L89:
            r7 = move-exception
            r1 = r2
            goto L9a
        L8c:
            r1 = r2
            goto L90
        L8e:
            r7 = move-exception
            goto L9a
        L90:
            java.lang.String r7 = "dbo"
            com.growingio.android.sdk.data.DiagnoseLog.saveLogIfEnabled(r7)     // Catch: java.lang.Throwable -> L8e
            if (r1 == 0) goto L98
            goto L85
        L98:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> La0
            return
        L9a:
            if (r1 == 0) goto L9f
            r6.closeDatabaseDelayed()     // Catch: java.lang.Throwable -> La0
        L9f:
            throw r7     // Catch: java.lang.Throwable -> La0
        La0:
            r7 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> La0
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.growingio.android.sdk.data.db.DBAdapter.saveEvent(java.lang.String, boolean, java.lang.String):void");
    }

    private Pair<String, List<String>> generateDataString(String str, String[] strArr) {
        synchronized (mDbLocker) {
            Cursor rawQuery = this.mDbHelper.getReadableDatabase().rawQuery(str, strArr);
            LinkedList linkedList = new LinkedList();
            String str2 = null;
            while (rawQuery.moveToNext()) {
                if (rawQuery.isLast()) {
                    str2 = rawQuery.getString(rawQuery.getColumnIndex("_id"));
                }
                linkedList.add(rawQuery.getString(rawQuery.getColumnIndex("data")));
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            closeDatabaseDelayed();
            if (linkedList.size() <= 0 || str2 == null) {
                return null;
            }
            return new Pair<>(str2, linkedList);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x004e, code lost:
        if (r2 == null) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0023, code lost:
        if (r2 != null) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    long cleanupEvents(java.lang.String r5, java.lang.String... r6) {
        /*
            r4 = this;
            r0 = 2
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r1 = 0
            r0[r1] = r5
            r2 = 1
            r0[r2] = r6
            r2 = 2097156(0x200004, float:2.938741E-39)
            com.growingio.android.sdk.message.MessageHandler.handleMessage(r2, r0)
            java.lang.Object r0 = com.growingio.android.sdk.data.db.DBAdapter.mDbLocker
            monitor-enter(r0)
            r2 = 0
            com.growingio.android.sdk.data.db.DBAdapter$DBHelper r3 = r4.mDbHelper     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2b android.database.SQLException -> L41 android.database.sqlite.SQLiteDiskIOException -> L49
            android.database.sqlite.SQLiteDatabase r2 = r3.getWritableDatabase()     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2b android.database.SQLException -> L41 android.database.sqlite.SQLiteDiskIOException -> L49
            com.growingio.android.sdk.data.db.DBAdapter$Table r3 = com.growingio.android.sdk.data.db.DBAdapter.Table.EVENTS     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2b android.database.SQLException -> L41 android.database.sqlite.SQLiteDiskIOException -> L49
            java.lang.String r3 = r3.getName()     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2b android.database.SQLException -> L41 android.database.sqlite.SQLiteDiskIOException -> L49
            int r1 = r2.delete(r3, r5, r6)     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2b android.database.SQLException -> L41 android.database.sqlite.SQLiteDiskIOException -> L49
            if (r2 == 0) goto L51
        L25:
            r4.closeDatabaseDelayed()     // Catch: java.lang.Throwable -> L5a
            goto L51
        L29:
            r5 = move-exception
            goto L54
        L2b:
            r5 = move-exception
            java.lang.Class r6 = r5.getClass()     // Catch: java.lang.Throwable -> L29
            java.lang.String r6 = r6.getSimpleName()     // Catch: java.lang.Throwable -> L29
            com.growingio.android.sdk.data.DiagnoseLog.saveLogIfEnabled(r6)     // Catch: java.lang.Throwable -> L29
            boolean r6 = com.growingio.android.sdk.collection.GConfig.DEBUG     // Catch: java.lang.Throwable -> L29
            if (r6 == 0) goto L3e
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L29
        L3e:
            if (r2 == 0) goto L51
            goto L25
        L41:
            java.lang.String r5 = "dboc"
            com.growingio.android.sdk.data.DiagnoseLog.saveLogIfEnabled(r5)     // Catch: java.lang.Throwable -> L29
            if (r2 == 0) goto L51
            goto L25
        L49:
            java.lang.String r5 = "dbioc"
            com.growingio.android.sdk.data.DiagnoseLog.saveLogIfEnabled(r5)     // Catch: java.lang.Throwable -> L29
            if (r2 == 0) goto L51
            goto L25
        L51:
            long r5 = (long) r1
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L5a
            return r5
        L54:
            if (r2 == 0) goto L59
            r4.closeDatabaseDelayed()     // Catch: java.lang.Throwable -> L5a
        L59:
            throw r5     // Catch: java.lang.Throwable -> L5a
        L5a:
            r5 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L5a
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.growingio.android.sdk.data.db.DBAdapter.cleanupEvents(java.lang.String, java.lang.String[]):long");
    }
}
