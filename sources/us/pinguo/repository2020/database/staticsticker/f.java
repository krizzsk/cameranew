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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* compiled from: StaticStickerCategoryDao_Impl.java */
/* loaded from: classes6.dex */
public final class f implements e {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<StaticStickerCategoryTable> b;
    private final EntityDeletionOrUpdateAdapter<StaticStickerCategoryTable> c;

    /* renamed from: d  reason: collision with root package name */
    private final SharedSQLiteStatement f11853d;

    /* compiled from: StaticStickerCategoryDao_Impl.java */
    /* loaded from: classes6.dex */
    class a extends EntityInsertionAdapter<StaticStickerCategoryTable> {
        a(f fVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, StaticStickerCategoryTable staticStickerCategoryTable) {
            if (staticStickerCategoryTable.getPid() == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, staticStickerCategoryTable.getPid());
            }
            if (staticStickerCategoryTable.getName() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, staticStickerCategoryTable.getName());
            }
            if (staticStickerCategoryTable.getIcon() == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, staticStickerCategoryTable.getIcon());
            }
            if (staticStickerCategoryTable.getStore_icon() == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, staticStickerCategoryTable.getStore_icon());
            }
            if (staticStickerCategoryTable.getVip() == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindLong(5, staticStickerCategoryTable.getVip().intValue());
            }
            if (staticStickerCategoryTable.getCompleted() == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindLong(6, staticStickerCategoryTable.getCompleted().intValue());
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `downloaded_static_sticker_category` (`pid`,`name`,`icon`,`store_icon`,`vip`,`completed`) VALUES (?,?,?,?,?,?)";
        }
    }

    /* compiled from: StaticStickerCategoryDao_Impl.java */
    /* loaded from: classes6.dex */
    class b extends EntityDeletionOrUpdateAdapter<StaticStickerCategoryTable> {
        b(f fVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, StaticStickerCategoryTable staticStickerCategoryTable) {
            if (staticStickerCategoryTable.getPid() == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, staticStickerCategoryTable.getPid());
            }
            if (staticStickerCategoryTable.getName() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, staticStickerCategoryTable.getName());
            }
            if (staticStickerCategoryTable.getIcon() == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, staticStickerCategoryTable.getIcon());
            }
            if (staticStickerCategoryTable.getStore_icon() == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, staticStickerCategoryTable.getStore_icon());
            }
            if (staticStickerCategoryTable.getVip() == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindLong(5, staticStickerCategoryTable.getVip().intValue());
            }
            if (staticStickerCategoryTable.getCompleted() == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindLong(6, staticStickerCategoryTable.getCompleted().intValue());
            }
            if (staticStickerCategoryTable.getPid() == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindString(7, staticStickerCategoryTable.getPid());
            }
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE OR ABORT `downloaded_static_sticker_category` SET `pid` = ?,`name` = ?,`icon` = ?,`store_icon` = ?,`vip` = ?,`completed` = ? WHERE `pid` = ?";
        }
    }

    /* compiled from: StaticStickerCategoryDao_Impl.java */
    /* loaded from: classes6.dex */
    class c extends SharedSQLiteStatement {
        c(f fVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM downloaded_static_sticker_category WHERE pid = ?";
        }
    }

    public f(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(this, roomDatabase);
        this.c = new b(this, roomDatabase);
        this.f11853d = new c(this, roomDatabase);
    }

    public static List<Class<?>> f() {
        return Collections.emptyList();
    }

    @Override // us.pinguo.repository2020.database.staticsticker.e
    public void a(String str) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.f11853d.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.a.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
            this.f11853d.release(acquire);
        }
    }

    @Override // us.pinguo.repository2020.database.staticsticker.e
    public void b(List<String> list) {
        this.a.assertNotSuspendingTransaction();
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("DELETE FROM downloaded_static_sticker_category WHERE pid IN (");
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

    @Override // us.pinguo.repository2020.database.staticsticker.e
    public void c(List<StaticStickerCategoryTable> list) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.c.handleMultiple(list);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // us.pinguo.repository2020.database.staticsticker.e
    public void d(StaticStickerCategoryTable staticStickerCategoryTable) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert((EntityInsertionAdapter<StaticStickerCategoryTable>) staticStickerCategoryTable);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // us.pinguo.repository2020.database.staticsticker.e
    public void e(StaticStickerCategoryTable staticStickerCategoryTable) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.c.handle(staticStickerCategoryTable);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // us.pinguo.repository2020.database.staticsticker.e
    public List<StaticStickerCategoryTable> getAll() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM downloaded_static_sticker_category", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "pid");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "icon");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "store_icon");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "vip");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "completed");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(new StaticStickerCategoryTable(query.isNull(columnIndexOrThrow) ? null : query.getString(columnIndexOrThrow), query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2), query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3), query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4), query.isNull(columnIndexOrThrow5) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow5)), query.isNull(columnIndexOrThrow6) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow6))));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }
}
