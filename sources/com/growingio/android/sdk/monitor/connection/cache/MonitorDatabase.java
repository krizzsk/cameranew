package com.growingio.android.sdk.monitor.connection.cache;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.growingio.android.sdk.monitor.event.Event;
import com.growingio.android.sdk.monitor.log.MLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/* loaded from: classes2.dex */
public class MonitorDatabase extends SQLiteOpenHelper {
    private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS monitor_event (_id INTEGER PRIMARY KEY AUTOINCREMENT, event_id TEXT NOT NULL, alias TEXT NOT NULL, event blob)";
    private static final String DATABASE_NAME = "GrowingioMonitor.db";
    private static final int DATABASE_VERSION = 2;
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS monitor_event";
    private static final String KEY_ALIAS = "alias";
    private static final String KEY_EVENT = "event";
    private static final String KEY_EVENT_ID = "event_id";
    private static final String TABLE_NAME = "monitor_event";
    private static final String TAG = "MonitorDatabase";

    /* JADX INFO: Access modifiers changed from: package-private */
    public MonitorDatabase(Context context) {
        super(context, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 2);
    }

    private Event bytes2Event(byte[] bArr) {
        try {
            return (Event) new ObjectInputStream(new ByteArrayInputStream(bArr)).readObject();
        } catch (Exception e2) {
            MLog.e(TAG, e2);
            return null;
        }
    }

    private byte[] event2Bytes(Event event) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new ObjectOutputStream(byteArrayOutputStream).writeObject(event);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e2) {
            MLog.e(TAG, e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void deleteEvent(Event event) {
        try {
            getReadableDatabase().delete(TABLE_NAME, "event_id = ?", new String[]{event.getId().toString()});
        } catch (Exception e2) {
            MLog.e(TAG, e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Event getLatelyEvent(String str) {
        try {
            Cursor query = getReadableDatabase().query(TABLE_NAME, null, "alias = ? ", new String[]{str}, null, null, "_id desc", "1");
            Event bytes2Event = query.moveToNext() ? bytes2Event(query.getBlob(query.getColumnIndex("event"))) : null;
            query.close();
            return bytes2Event;
        } catch (Exception e2) {
            MLog.e(TAG, e2);
            return null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        if (i2 == 1) {
            try {
                sQLiteDatabase.execSQL(DROP_TABLE);
                onCreate(sQLiteDatabase);
            } catch (SQLException e2) {
                MLog.e(TAG, "database upgrade failed", e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void saveEvent(Event event) {
        try {
            String uuid = event.getId().toString();
            String alias = event.getAlias();
            SQLiteDatabase readableDatabase = getReadableDatabase();
            byte[] event2Bytes = event2Bytes(event);
            if (event2Bytes == null) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("event_id", uuid);
            contentValues.put(KEY_ALIAS, alias);
            contentValues.put("event", event2Bytes);
            readableDatabase.insert(TABLE_NAME, null, contentValues);
            MLog.d(TAG, "Save Event " + uuid + " successfully");
        } catch (Exception e2) {
            MLog.e(TAG, e2);
        }
    }
}
