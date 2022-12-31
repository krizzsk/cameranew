package us.pinguo.repository2020.database.sticker;

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
import com.tapjoy.TapjoyAuctionFlags;
import com.tencent.matrix.trace.config.SharePluginInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* compiled from: StickerTableDao_Impl.java */
/* loaded from: classes6.dex */
public final class f implements e {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<StickerTable> b;
    private final EntityDeletionOrUpdateAdapter<StickerTable> c;

    /* renamed from: d  reason: collision with root package name */
    private final SharedSQLiteStatement f11865d;

    /* compiled from: StickerTableDao_Impl.java */
    /* loaded from: classes6.dex */
    class a extends EntityInsertionAdapter<StickerTable> {
        a(f fVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, StickerTable stickerTable) {
            if (stickerTable.getId() == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, stickerTable.getId());
            }
            if (stickerTable.getNamejson() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, stickerTable.getNamejson());
            }
            if (stickerTable.getFilterType() == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, stickerTable.getFilterType());
            }
            if (stickerTable.getSubType() == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, stickerTable.getSubType());
            }
            if (stickerTable.getIcon() == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindString(5, stickerTable.getIcon());
            }
            supportSQLiteStatement.bindLong(6, stickerTable.getSort());
            if (stickerTable.getDisplayMd5() == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindString(7, stickerTable.getDisplayMd5());
            }
            if (stickerTable.getPackageMd5() == null) {
                supportSQLiteStatement.bindNull(8);
            } else {
                supportSQLiteStatement.bindString(8, stickerTable.getPackageMd5());
            }
            if (stickerTable.getTemp1() == null) {
                supportSQLiteStatement.bindNull(9);
            } else {
                supportSQLiteStatement.bindString(9, stickerTable.getTemp1());
            }
            if (stickerTable.getTemp2() == null) {
                supportSQLiteStatement.bindNull(10);
            } else {
                supportSQLiteStatement.bindString(10, stickerTable.getTemp2());
            }
            if (stickerTable.getTemp3() == null) {
                supportSQLiteStatement.bindNull(11);
            } else {
                supportSQLiteStatement.bindString(11, stickerTable.getTemp3());
            }
            if (stickerTable.getTemp4() == null) {
                supportSQLiteStatement.bindNull(12);
            } else {
                supportSQLiteStatement.bindString(12, stickerTable.getTemp4());
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `stickerPackage` (`id`,`namejson`,`filterType`,`subType`,`icon`,`sort`,`displayMd5`,`packageMd5`,`temp1`,`temp2`,`temp3`,`temp4`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    /* compiled from: StickerTableDao_Impl.java */
    /* loaded from: classes6.dex */
    class b extends EntityDeletionOrUpdateAdapter<StickerTable> {
        b(f fVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, StickerTable stickerTable) {
            if (stickerTable.getId() == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, stickerTable.getId());
            }
            if (stickerTable.getNamejson() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, stickerTable.getNamejson());
            }
            if (stickerTable.getFilterType() == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, stickerTable.getFilterType());
            }
            if (stickerTable.getSubType() == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, stickerTable.getSubType());
            }
            if (stickerTable.getIcon() == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindString(5, stickerTable.getIcon());
            }
            supportSQLiteStatement.bindLong(6, stickerTable.getSort());
            if (stickerTable.getDisplayMd5() == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindString(7, stickerTable.getDisplayMd5());
            }
            if (stickerTable.getPackageMd5() == null) {
                supportSQLiteStatement.bindNull(8);
            } else {
                supportSQLiteStatement.bindString(8, stickerTable.getPackageMd5());
            }
            if (stickerTable.getTemp1() == null) {
                supportSQLiteStatement.bindNull(9);
            } else {
                supportSQLiteStatement.bindString(9, stickerTable.getTemp1());
            }
            if (stickerTable.getTemp2() == null) {
                supportSQLiteStatement.bindNull(10);
            } else {
                supportSQLiteStatement.bindString(10, stickerTable.getTemp2());
            }
            if (stickerTable.getTemp3() == null) {
                supportSQLiteStatement.bindNull(11);
            } else {
                supportSQLiteStatement.bindString(11, stickerTable.getTemp3());
            }
            if (stickerTable.getTemp4() == null) {
                supportSQLiteStatement.bindNull(12);
            } else {
                supportSQLiteStatement.bindString(12, stickerTable.getTemp4());
            }
            if (stickerTable.getId() == null) {
                supportSQLiteStatement.bindNull(13);
            } else {
                supportSQLiteStatement.bindString(13, stickerTable.getId());
            }
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE OR ABORT `stickerPackage` SET `id` = ?,`namejson` = ?,`filterType` = ?,`subType` = ?,`icon` = ?,`sort` = ?,`displayMd5` = ?,`packageMd5` = ?,`temp1` = ?,`temp2` = ?,`temp3` = ?,`temp4` = ? WHERE `id` = ?";
        }
    }

    /* compiled from: StickerTableDao_Impl.java */
    /* loaded from: classes6.dex */
    class c extends SharedSQLiteStatement {
        c(f fVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM stickerPackage WHERE id = ?";
        }
    }

    public f(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(this, roomDatabase);
        this.c = new b(this, roomDatabase);
        this.f11865d = new c(this, roomDatabase);
    }

    public static List<Class<?>> e() {
        return Collections.emptyList();
    }

    @Override // us.pinguo.repository2020.database.sticker.e
    public void a(String str) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.f11865d.acquire();
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
            this.f11865d.release(acquire);
        }
    }

    @Override // us.pinguo.repository2020.database.sticker.e
    public void b(List<String> list) {
        this.a.assertNotSuspendingTransaction();
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("DELETE FROM stickerPackage WHERE id IN (");
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

    @Override // us.pinguo.repository2020.database.sticker.e
    public void c(StickerTable stickerTable) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert((EntityInsertionAdapter<StickerTable>) stickerTable);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // us.pinguo.repository2020.database.sticker.e
    public void d(StickerTable stickerTable) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.c.handle(stickerTable);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // us.pinguo.repository2020.database.sticker.e
    public List<StickerTable> getAll() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM stickerPackage", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, TapjoyAuctionFlags.AUCTION_ID);
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "namejson");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "filterType");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, SharePluginInfo.ISSUE_SUB_TYPE);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "icon");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "sort");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "displayMd5");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "packageMd5");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "temp1");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "temp2");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "temp3");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "temp4");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(new StickerTable(query.isNull(columnIndexOrThrow) ? null : query.getString(columnIndexOrThrow), query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2), query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3), query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4), query.isNull(columnIndexOrThrow5) ? null : query.getString(columnIndexOrThrow5), query.getLong(columnIndexOrThrow6), query.isNull(columnIndexOrThrow7) ? null : query.getString(columnIndexOrThrow7), query.isNull(columnIndexOrThrow8) ? null : query.getString(columnIndexOrThrow8), query.isNull(columnIndexOrThrow9) ? null : query.getString(columnIndexOrThrow9), query.isNull(columnIndexOrThrow10) ? null : query.getString(columnIndexOrThrow10), query.isNull(columnIndexOrThrow11) ? null : query.getString(columnIndexOrThrow11), query.isNull(columnIndexOrThrow12) ? null : query.getString(columnIndexOrThrow12)));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }
}
