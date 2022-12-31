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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* compiled from: StickerItemTableDao_Impl.java */
/* loaded from: classes6.dex */
public final class c implements us.pinguo.repository2020.database.sticker.b {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<StickerItemTable> b;
    private final EntityDeletionOrUpdateAdapter<StickerItemTable> c;

    /* renamed from: d  reason: collision with root package name */
    private final SharedSQLiteStatement f11864d;

    /* compiled from: StickerItemTableDao_Impl.java */
    /* loaded from: classes6.dex */
    class a extends EntityInsertionAdapter<StickerItemTable> {
        a(c cVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, StickerItemTable stickerItemTable) {
            supportSQLiteStatement.bindLong(1, stickerItemTable.get_aid());
            if (stickerItemTable.getId() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, stickerItemTable.getId());
            }
            if (stickerItemTable.getNamejson() == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, stickerItemTable.getNamejson());
            }
            if (stickerItemTable.getIcon() == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, stickerItemTable.getIcon());
            }
            if (stickerItemTable.getSortInPackage() == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindLong(5, stickerItemTable.getSortInPackage().intValue());
            }
            if (stickerItemTable.getPackageId() == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindString(6, stickerItemTable.getPackageId());
            }
            if (stickerItemTable.getPackageMd5() == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindString(7, stickerItemTable.getPackageMd5());
            }
            if (stickerItemTable.isCollect() == null) {
                supportSQLiteStatement.bindNull(8);
            } else {
                supportSQLiteStatement.bindLong(8, stickerItemTable.isCollect().intValue());
            }
            if (stickerItemTable.getCollectTime() == null) {
                supportSQLiteStatement.bindNull(9);
            } else {
                supportSQLiteStatement.bindLong(9, stickerItemTable.getCollectTime().longValue());
            }
            if (stickerItemTable.getHasMusic() == null) {
                supportSQLiteStatement.bindNull(10);
            } else {
                supportSQLiteStatement.bindLong(10, stickerItemTable.getHasMusic().intValue());
            }
            if (stickerItemTable.getType() == null) {
                supportSQLiteStatement.bindNull(11);
            } else {
                supportSQLiteStatement.bindString(11, stickerItemTable.getType());
            }
            if (stickerItemTable.getTemp1() == null) {
                supportSQLiteStatement.bindNull(12);
            } else {
                supportSQLiteStatement.bindString(12, stickerItemTable.getTemp1());
            }
            if (stickerItemTable.getTemp2() == null) {
                supportSQLiteStatement.bindNull(13);
            } else {
                supportSQLiteStatement.bindString(13, stickerItemTable.getTemp2());
            }
            if (stickerItemTable.getTemp3() == null) {
                supportSQLiteStatement.bindNull(14);
            } else {
                supportSQLiteStatement.bindString(14, stickerItemTable.getTemp3());
            }
            if (stickerItemTable.getTemp4() == null) {
                supportSQLiteStatement.bindNull(15);
            } else {
                supportSQLiteStatement.bindString(15, stickerItemTable.getTemp4());
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `stickerItem` (`_aid`,`id`,`namejson`,`icon`,`sortInPackage`,`packageId`,`packageMd5`,`isCollect`,`collectTime`,`hasMusic`,`type`,`temp1`,`temp2`,`temp3`,`temp4`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    /* compiled from: StickerItemTableDao_Impl.java */
    /* loaded from: classes6.dex */
    class b extends EntityDeletionOrUpdateAdapter<StickerItemTable> {
        b(c cVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, StickerItemTable stickerItemTable) {
            supportSQLiteStatement.bindLong(1, stickerItemTable.get_aid());
            if (stickerItemTable.getId() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, stickerItemTable.getId());
            }
            if (stickerItemTable.getNamejson() == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, stickerItemTable.getNamejson());
            }
            if (stickerItemTable.getIcon() == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, stickerItemTable.getIcon());
            }
            if (stickerItemTable.getSortInPackage() == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindLong(5, stickerItemTable.getSortInPackage().intValue());
            }
            if (stickerItemTable.getPackageId() == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindString(6, stickerItemTable.getPackageId());
            }
            if (stickerItemTable.getPackageMd5() == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindString(7, stickerItemTable.getPackageMd5());
            }
            if (stickerItemTable.isCollect() == null) {
                supportSQLiteStatement.bindNull(8);
            } else {
                supportSQLiteStatement.bindLong(8, stickerItemTable.isCollect().intValue());
            }
            if (stickerItemTable.getCollectTime() == null) {
                supportSQLiteStatement.bindNull(9);
            } else {
                supportSQLiteStatement.bindLong(9, stickerItemTable.getCollectTime().longValue());
            }
            if (stickerItemTable.getHasMusic() == null) {
                supportSQLiteStatement.bindNull(10);
            } else {
                supportSQLiteStatement.bindLong(10, stickerItemTable.getHasMusic().intValue());
            }
            if (stickerItemTable.getType() == null) {
                supportSQLiteStatement.bindNull(11);
            } else {
                supportSQLiteStatement.bindString(11, stickerItemTable.getType());
            }
            if (stickerItemTable.getTemp1() == null) {
                supportSQLiteStatement.bindNull(12);
            } else {
                supportSQLiteStatement.bindString(12, stickerItemTable.getTemp1());
            }
            if (stickerItemTable.getTemp2() == null) {
                supportSQLiteStatement.bindNull(13);
            } else {
                supportSQLiteStatement.bindString(13, stickerItemTable.getTemp2());
            }
            if (stickerItemTable.getTemp3() == null) {
                supportSQLiteStatement.bindNull(14);
            } else {
                supportSQLiteStatement.bindString(14, stickerItemTable.getTemp3());
            }
            if (stickerItemTable.getTemp4() == null) {
                supportSQLiteStatement.bindNull(15);
            } else {
                supportSQLiteStatement.bindString(15, stickerItemTable.getTemp4());
            }
            supportSQLiteStatement.bindLong(16, stickerItemTable.get_aid());
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE OR ABORT `stickerItem` SET `_aid` = ?,`id` = ?,`namejson` = ?,`icon` = ?,`sortInPackage` = ?,`packageId` = ?,`packageMd5` = ?,`isCollect` = ?,`collectTime` = ?,`hasMusic` = ?,`type` = ?,`temp1` = ?,`temp2` = ?,`temp3` = ?,`temp4` = ? WHERE `_aid` = ?";
        }
    }

    /* compiled from: StickerItemTableDao_Impl.java */
    /* renamed from: us.pinguo.repository2020.database.sticker.c$c  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    class C0440c extends SharedSQLiteStatement {
        C0440c(c cVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM stickerItem WHERE id = ?";
        }
    }

    /* compiled from: StickerItemTableDao_Impl.java */
    /* loaded from: classes6.dex */
    class d extends SharedSQLiteStatement {
        d(c cVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM stickerItem WHERE packageId = ?";
        }
    }

    public c(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(this, roomDatabase);
        this.c = new b(this, roomDatabase);
        new C0440c(this, roomDatabase);
        this.f11864d = new d(this, roomDatabase);
    }

    public static List<Class<?>> g() {
        return Collections.emptyList();
    }

    @Override // us.pinguo.repository2020.database.sticker.b
    public void a(List<StickerItemTable> list) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(list);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // us.pinguo.repository2020.database.sticker.b
    public void b(List<String> list) {
        this.a.assertNotSuspendingTransaction();
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("DELETE FROM stickerItem WHERE packageId IN (");
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

    @Override // us.pinguo.repository2020.database.sticker.b
    public void c(List<StickerItemTable> list) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.c.handleMultiple(list);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // us.pinguo.repository2020.database.sticker.b
    public StickerItemTable d(String str) {
        RoomSQLiteQuery roomSQLiteQuery;
        StickerItemTable stickerItemTable;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM stickerItem WHERE id = ?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "_aid");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, TapjoyAuctionFlags.AUCTION_ID);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "namejson");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "icon");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "sortInPackage");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "packageId");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "packageMd5");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "isCollect");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "collectTime");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "hasMusic");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "type");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "temp1");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "temp2");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "temp3");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "temp4");
                if (query.moveToFirst()) {
                    stickerItemTable = new StickerItemTable(query.getInt(columnIndexOrThrow), query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2), query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3), query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4), query.isNull(columnIndexOrThrow5) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow5)), query.isNull(columnIndexOrThrow6) ? null : query.getString(columnIndexOrThrow6), query.isNull(columnIndexOrThrow7) ? null : query.getString(columnIndexOrThrow7), query.isNull(columnIndexOrThrow8) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow8)), query.isNull(columnIndexOrThrow9) ? null : Long.valueOf(query.getLong(columnIndexOrThrow9)), query.isNull(columnIndexOrThrow10) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow10)), query.isNull(columnIndexOrThrow11) ? null : query.getString(columnIndexOrThrow11), query.isNull(columnIndexOrThrow12) ? null : query.getString(columnIndexOrThrow12), query.isNull(columnIndexOrThrow13) ? null : query.getString(columnIndexOrThrow13), query.isNull(columnIndexOrThrow14) ? null : query.getString(columnIndexOrThrow14), query.isNull(columnIndexOrThrow15) ? null : query.getString(columnIndexOrThrow15));
                } else {
                    stickerItemTable = null;
                }
                query.close();
                roomSQLiteQuery.release();
                return stickerItemTable;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
        }
    }

    @Override // us.pinguo.repository2020.database.sticker.b
    public void e(StickerItemTable stickerItemTable) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert((EntityInsertionAdapter<StickerItemTable>) stickerItemTable);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // us.pinguo.repository2020.database.sticker.b
    public void f(String str) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.f11864d.acquire();
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
            this.f11864d.release(acquire);
        }
    }

    @Override // us.pinguo.repository2020.database.sticker.b
    public List<StickerItemTable> getAll() {
        RoomSQLiteQuery roomSQLiteQuery;
        String string;
        int i2;
        String string2;
        int i3;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM stickerItem", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "_aid");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, TapjoyAuctionFlags.AUCTION_ID);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "namejson");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "icon");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "sortInPackage");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "packageId");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "packageMd5");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "isCollect");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "collectTime");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "hasMusic");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "type");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "temp1");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "temp2");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "temp3");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "temp4");
                int i4 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    int i5 = query.getInt(columnIndexOrThrow);
                    String string3 = query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2);
                    String string4 = query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3);
                    String string5 = query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4);
                    Integer valueOf = query.isNull(columnIndexOrThrow5) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow5));
                    String string6 = query.isNull(columnIndexOrThrow6) ? null : query.getString(columnIndexOrThrow6);
                    String string7 = query.isNull(columnIndexOrThrow7) ? null : query.getString(columnIndexOrThrow7);
                    Integer valueOf2 = query.isNull(columnIndexOrThrow8) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow8));
                    Long valueOf3 = query.isNull(columnIndexOrThrow9) ? null : Long.valueOf(query.getLong(columnIndexOrThrow9));
                    Integer valueOf4 = query.isNull(columnIndexOrThrow10) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow10));
                    String string8 = query.isNull(columnIndexOrThrow11) ? null : query.getString(columnIndexOrThrow11);
                    String string9 = query.isNull(columnIndexOrThrow12) ? null : query.getString(columnIndexOrThrow12);
                    if (query.isNull(columnIndexOrThrow13)) {
                        i2 = i4;
                        string = null;
                    } else {
                        string = query.getString(columnIndexOrThrow13);
                        i2 = i4;
                    }
                    String string10 = query.isNull(i2) ? null : query.getString(i2);
                    int i6 = columnIndexOrThrow15;
                    int i7 = columnIndexOrThrow;
                    if (query.isNull(i6)) {
                        i3 = i6;
                        string2 = null;
                    } else {
                        string2 = query.getString(i6);
                        i3 = i6;
                    }
                    arrayList.add(new StickerItemTable(i5, string3, string4, string5, valueOf, string6, string7, valueOf2, valueOf3, valueOf4, string8, string9, string, string10, string2));
                    columnIndexOrThrow = i7;
                    columnIndexOrThrow15 = i3;
                    i4 = i2;
                }
                query.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
        }
    }
}
