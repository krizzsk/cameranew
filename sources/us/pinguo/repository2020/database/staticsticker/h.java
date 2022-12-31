package us.pinguo.repository2020.database.staticsticker;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.growingio.android.sdk.monitor.marshaller.json.JsonMarshaller;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* compiled from: StaticStickerDao_Impl.java */
/* loaded from: classes6.dex */
public final class h implements g {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<StaticStickerTable> b;

    /* compiled from: StaticStickerDao_Impl.java */
    /* loaded from: classes6.dex */
    class a extends EntityInsertionAdapter<StaticStickerTable> {
        a(h hVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, StaticStickerTable staticStickerTable) {
            if (staticStickerTable.getSid() == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, staticStickerTable.getSid());
            }
            if (staticStickerTable.getName() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, staticStickerTable.getName());
            }
            if (staticStickerTable.getIcon() == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, staticStickerTable.getIcon());
            }
            if (staticStickerTable.getTags() == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, staticStickerTable.getTags());
            }
            if (staticStickerTable.getDisplay_md5() == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindString(5, staticStickerTable.getDisplay_md5());
            }
            if (staticStickerTable.getDown_url() == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindString(6, staticStickerTable.getDown_url());
            }
            supportSQLiteStatement.bindLong(7, staticStickerTable.getFromTemplate());
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `downloaded_static_sticker` (`sid`,`name`,`icon`,`tags`,`display_md5`,`down_url`,`fromTemplate`) VALUES (?,?,?,?,?,?,?)";
        }
    }

    /* compiled from: StaticStickerDao_Impl.java */
    /* loaded from: classes6.dex */
    class b extends EntityDeletionOrUpdateAdapter<StaticStickerTable> {
        b(h hVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, StaticStickerTable staticStickerTable) {
            if (staticStickerTable.getSid() == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, staticStickerTable.getSid());
            }
            if (staticStickerTable.getName() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, staticStickerTable.getName());
            }
            if (staticStickerTable.getIcon() == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, staticStickerTable.getIcon());
            }
            if (staticStickerTable.getTags() == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, staticStickerTable.getTags());
            }
            if (staticStickerTable.getDisplay_md5() == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindString(5, staticStickerTable.getDisplay_md5());
            }
            if (staticStickerTable.getDown_url() == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindString(6, staticStickerTable.getDown_url());
            }
            supportSQLiteStatement.bindLong(7, staticStickerTable.getFromTemplate());
            if (staticStickerTable.getSid() == null) {
                supportSQLiteStatement.bindNull(8);
            } else {
                supportSQLiteStatement.bindString(8, staticStickerTable.getSid());
            }
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE OR ABORT `downloaded_static_sticker` SET `sid` = ?,`name` = ?,`icon` = ?,`tags` = ?,`display_md5` = ?,`down_url` = ?,`fromTemplate` = ? WHERE `sid` = ?";
        }
    }

    /* compiled from: StaticStickerDao_Impl.java */
    /* loaded from: classes6.dex */
    class c extends SharedSQLiteStatement {
        c(h hVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM downloaded_static_sticker WHERE sid = ?";
        }
    }

    public h(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(this, roomDatabase);
        new b(this, roomDatabase);
        new c(this, roomDatabase);
    }

    public static List<Class<?>> c() {
        return Collections.emptyList();
    }

    @Override // us.pinguo.repository2020.database.staticsticker.g
    public void a(List<StaticStickerTable> list) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(list);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // us.pinguo.repository2020.database.staticsticker.g
    public void b(List<String> list) {
        this.a.assertNotSuspendingTransaction();
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("DELETE FROM downloaded_static_sticker WHERE sid IN (");
        StringUtil.appendPlaceholders(newStringBuilder, list.size());
        newStringBuilder.append(")");
        SupportSQLiteStatement compileStatement = this.a.compileStatement(newStringBuilder.toString());
        int i2 = 1;
        for (String str : list) {
            if (str == null) {
                compileStatement.bindNull(i2);
            } else {
                compileStatement.bindString(i2, str);
            }
            i2++;
        }
        this.a.beginTransaction();
        try {
            compileStatement.executeUpdateDelete();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // us.pinguo.repository2020.database.staticsticker.g
    public StaticStickerTable d(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM downloaded_static_sticker WHERE sid = ?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        StaticStickerTable staticStickerTable = null;
        Cursor query = DBUtil.query(this.a, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "sid");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "icon");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, JsonMarshaller.TAGS);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "display_md5");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "down_url");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "fromTemplate");
            if (query.moveToFirst()) {
                staticStickerTable = new StaticStickerTable(query.isNull(columnIndexOrThrow) ? null : query.getString(columnIndexOrThrow), query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2), query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3), query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4), query.isNull(columnIndexOrThrow5) ? null : query.getString(columnIndexOrThrow5), query.isNull(columnIndexOrThrow6) ? null : query.getString(columnIndexOrThrow6), query.getInt(columnIndexOrThrow7));
            }
            return staticStickerTable;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // us.pinguo.repository2020.database.staticsticker.g
    public List<StaticStickerTable> getAll() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM downloaded_static_sticker", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "sid");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "icon");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, JsonMarshaller.TAGS);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "display_md5");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "down_url");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "fromTemplate");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(new StaticStickerTable(query.isNull(columnIndexOrThrow) ? null : query.getString(columnIndexOrThrow), query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2), query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3), query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4), query.isNull(columnIndexOrThrow5) ? null : query.getString(columnIndexOrThrow5), query.isNull(columnIndexOrThrow6) ? null : query.getString(columnIndexOrThrow6), query.getInt(columnIndexOrThrow7)));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }
}
