package us.pinguo.repository2020.database.filter;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.pinguo.camera360.effect.model.entity.type.Frame;
import com.tapjoy.TapjoyAuctionFlags;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* compiled from: FilterItemDao_Impl.java */
/* loaded from: classes6.dex */
public final class b implements us.pinguo.repository2020.database.filter.a {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<FilterItemTable> b;
    private final EntityDeletionOrUpdateAdapter<FilterItemTable> c;

    /* renamed from: d  reason: collision with root package name */
    private final EntityDeletionOrUpdateAdapter<FilterItemTable> f11840d;

    /* compiled from: FilterItemDao_Impl.java */
    /* loaded from: classes6.dex */
    class a extends EntityInsertionAdapter<FilterItemTable> {
        a(b bVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, FilterItemTable filterItemTable) {
            supportSQLiteStatement.bindLong(1, filterItemTable.get_aid());
            if (filterItemTable.getId() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, filterItemTable.getId());
            }
            if (filterItemTable.getNamejson() == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, filterItemTable.getNamejson());
            }
            if (filterItemTable.getIcon() == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, filterItemTable.getIcon());
            }
            if (filterItemTable.getSortInPackage() == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindLong(5, filterItemTable.getSortInPackage().intValue());
            }
            if (filterItemTable.getPackageId() == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindString(6, filterItemTable.getPackageId());
            }
            if (filterItemTable.getPackageMd5() == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindString(7, filterItemTable.getPackageMd5());
            }
            if (filterItemTable.isCollect() == null) {
                supportSQLiteStatement.bindNull(8);
            } else {
                supportSQLiteStatement.bindLong(8, filterItemTable.isCollect().intValue());
            }
            if (filterItemTable.getCollectTime() == null) {
                supportSQLiteStatement.bindNull(9);
            } else {
                supportSQLiteStatement.bindLong(9, filterItemTable.getCollectTime().longValue());
            }
            if (filterItemTable.getHasMusic() == null) {
                supportSQLiteStatement.bindNull(10);
            } else {
                supportSQLiteStatement.bindLong(10, filterItemTable.getHasMusic().intValue());
            }
            supportSQLiteStatement.bindLong(11, filterItemTable.getOpacity());
            if (filterItemTable.getType() == null) {
                supportSQLiteStatement.bindNull(12);
            } else {
                supportSQLiteStatement.bindString(12, filterItemTable.getType());
            }
            if (filterItemTable.getUnity_engine_filter() == null) {
                supportSQLiteStatement.bindNull(13);
            } else {
                supportSQLiteStatement.bindLong(13, filterItemTable.getUnity_engine_filter().intValue());
            }
            if (filterItemTable.getCamera_support() == null) {
                supportSQLiteStatement.bindNull(14);
            } else {
                supportSQLiteStatement.bindLong(14, filterItemTable.getCamera_support().intValue());
            }
            if (filterItemTable.getEnableGesture() == null) {
                supportSQLiteStatement.bindNull(15);
            } else {
                supportSQLiteStatement.bindLong(15, filterItemTable.getEnableGesture().intValue());
            }
            if (filterItemTable.getTemp1() == null) {
                supportSQLiteStatement.bindNull(16);
            } else {
                supportSQLiteStatement.bindString(16, filterItemTable.getTemp1());
            }
            if (filterItemTable.getTemp2() == null) {
                supportSQLiteStatement.bindNull(17);
            } else {
                supportSQLiteStatement.bindString(17, filterItemTable.getTemp2());
            }
            if (filterItemTable.getTemp3() == null) {
                supportSQLiteStatement.bindNull(18);
            } else {
                supportSQLiteStatement.bindString(18, filterItemTable.getTemp3());
            }
            if (filterItemTable.getTemp4() == null) {
                supportSQLiteStatement.bindNull(19);
            } else {
                supportSQLiteStatement.bindString(19, filterItemTable.getTemp4());
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `item` (`_aid`,`id`,`namejson`,`icon`,`sortInPackage`,`packageId`,`packageMd5`,`isCollect`,`collectTime`,`hasMusic`,`opacity`,`type`,`unity_engine_filter`,`camera_support`,`enableGesture`,`temp1`,`temp2`,`temp3`,`temp4`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    /* compiled from: FilterItemDao_Impl.java */
    /* renamed from: us.pinguo.repository2020.database.filter.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    class C0434b extends EntityDeletionOrUpdateAdapter<FilterItemTable> {
        C0434b(b bVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, FilterItemTable filterItemTable) {
            supportSQLiteStatement.bindLong(1, filterItemTable.get_aid());
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM `item` WHERE `_aid` = ?";
        }
    }

    /* compiled from: FilterItemDao_Impl.java */
    /* loaded from: classes6.dex */
    class c extends EntityDeletionOrUpdateAdapter<FilterItemTable> {
        c(b bVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, FilterItemTable filterItemTable) {
            supportSQLiteStatement.bindLong(1, filterItemTable.get_aid());
            if (filterItemTable.getId() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, filterItemTable.getId());
            }
            if (filterItemTable.getNamejson() == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, filterItemTable.getNamejson());
            }
            if (filterItemTable.getIcon() == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, filterItemTable.getIcon());
            }
            if (filterItemTable.getSortInPackage() == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindLong(5, filterItemTable.getSortInPackage().intValue());
            }
            if (filterItemTable.getPackageId() == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindString(6, filterItemTable.getPackageId());
            }
            if (filterItemTable.getPackageMd5() == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindString(7, filterItemTable.getPackageMd5());
            }
            if (filterItemTable.isCollect() == null) {
                supportSQLiteStatement.bindNull(8);
            } else {
                supportSQLiteStatement.bindLong(8, filterItemTable.isCollect().intValue());
            }
            if (filterItemTable.getCollectTime() == null) {
                supportSQLiteStatement.bindNull(9);
            } else {
                supportSQLiteStatement.bindLong(9, filterItemTable.getCollectTime().longValue());
            }
            if (filterItemTable.getHasMusic() == null) {
                supportSQLiteStatement.bindNull(10);
            } else {
                supportSQLiteStatement.bindLong(10, filterItemTable.getHasMusic().intValue());
            }
            supportSQLiteStatement.bindLong(11, filterItemTable.getOpacity());
            if (filterItemTable.getType() == null) {
                supportSQLiteStatement.bindNull(12);
            } else {
                supportSQLiteStatement.bindString(12, filterItemTable.getType());
            }
            if (filterItemTable.getUnity_engine_filter() == null) {
                supportSQLiteStatement.bindNull(13);
            } else {
                supportSQLiteStatement.bindLong(13, filterItemTable.getUnity_engine_filter().intValue());
            }
            if (filterItemTable.getCamera_support() == null) {
                supportSQLiteStatement.bindNull(14);
            } else {
                supportSQLiteStatement.bindLong(14, filterItemTable.getCamera_support().intValue());
            }
            if (filterItemTable.getEnableGesture() == null) {
                supportSQLiteStatement.bindNull(15);
            } else {
                supportSQLiteStatement.bindLong(15, filterItemTable.getEnableGesture().intValue());
            }
            if (filterItemTable.getTemp1() == null) {
                supportSQLiteStatement.bindNull(16);
            } else {
                supportSQLiteStatement.bindString(16, filterItemTable.getTemp1());
            }
            if (filterItemTable.getTemp2() == null) {
                supportSQLiteStatement.bindNull(17);
            } else {
                supportSQLiteStatement.bindString(17, filterItemTable.getTemp2());
            }
            if (filterItemTable.getTemp3() == null) {
                supportSQLiteStatement.bindNull(18);
            } else {
                supportSQLiteStatement.bindString(18, filterItemTable.getTemp3());
            }
            if (filterItemTable.getTemp4() == null) {
                supportSQLiteStatement.bindNull(19);
            } else {
                supportSQLiteStatement.bindString(19, filterItemTable.getTemp4());
            }
            supportSQLiteStatement.bindLong(20, filterItemTable.get_aid());
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE OR ABORT `item` SET `_aid` = ?,`id` = ?,`namejson` = ?,`icon` = ?,`sortInPackage` = ?,`packageId` = ?,`packageMd5` = ?,`isCollect` = ?,`collectTime` = ?,`hasMusic` = ?,`opacity` = ?,`type` = ?,`unity_engine_filter` = ?,`camera_support` = ?,`enableGesture` = ?,`temp1` = ?,`temp2` = ?,`temp3` = ?,`temp4` = ? WHERE `_aid` = ?";
        }
    }

    public b(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(this, roomDatabase);
        this.c = new C0434b(this, roomDatabase);
        this.f11840d = new c(this, roomDatabase);
    }

    public static List<Class<?>> h() {
        return Collections.emptyList();
    }

    @Override // us.pinguo.repository2020.database.filter.a
    public List<FilterItemTable> a() {
        RoomSQLiteQuery roomSQLiteQuery;
        Integer valueOf;
        int i2;
        String string;
        int i3;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM item", 0);
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
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, Frame.PARAM_KEY_OPACITY);
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "type");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "unity_engine_filter");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "camera_support");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "enableGesture");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "temp1");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "temp2");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "temp3");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "temp4");
                int i4 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    int i5 = query.getInt(columnIndexOrThrow);
                    String string2 = query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2);
                    String string3 = query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3);
                    String string4 = query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4);
                    Integer valueOf2 = query.isNull(columnIndexOrThrow5) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow5));
                    String string5 = query.isNull(columnIndexOrThrow6) ? null : query.getString(columnIndexOrThrow6);
                    String string6 = query.isNull(columnIndexOrThrow7) ? null : query.getString(columnIndexOrThrow7);
                    Integer valueOf3 = query.isNull(columnIndexOrThrow8) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow8));
                    Long valueOf4 = query.isNull(columnIndexOrThrow9) ? null : Long.valueOf(query.getLong(columnIndexOrThrow9));
                    Integer valueOf5 = query.isNull(columnIndexOrThrow10) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow10));
                    int i6 = query.getInt(columnIndexOrThrow11);
                    String string7 = query.isNull(columnIndexOrThrow12) ? null : query.getString(columnIndexOrThrow12);
                    if (query.isNull(columnIndexOrThrow13)) {
                        i2 = i4;
                        valueOf = null;
                    } else {
                        valueOf = Integer.valueOf(query.getInt(columnIndexOrThrow13));
                        i2 = i4;
                    }
                    Integer valueOf6 = query.isNull(i2) ? null : Integer.valueOf(query.getInt(i2));
                    int i7 = columnIndexOrThrow15;
                    int i8 = columnIndexOrThrow;
                    Integer valueOf7 = query.isNull(i7) ? null : Integer.valueOf(query.getInt(i7));
                    int i9 = columnIndexOrThrow16;
                    String string8 = query.isNull(i9) ? null : query.getString(i9);
                    int i10 = columnIndexOrThrow17;
                    String string9 = query.isNull(i10) ? null : query.getString(i10);
                    int i11 = columnIndexOrThrow18;
                    String string10 = query.isNull(i11) ? null : query.getString(i11);
                    int i12 = columnIndexOrThrow19;
                    if (query.isNull(i12)) {
                        i3 = i12;
                        string = null;
                    } else {
                        string = query.getString(i12);
                        i3 = i12;
                    }
                    arrayList.add(new FilterItemTable(i5, string2, string3, string4, valueOf2, string5, string6, valueOf3, valueOf4, valueOf5, i6, string7, valueOf, valueOf6, valueOf7, string8, string9, string10, string));
                    columnIndexOrThrow = i8;
                    columnIndexOrThrow15 = i7;
                    columnIndexOrThrow16 = i9;
                    columnIndexOrThrow17 = i10;
                    columnIndexOrThrow18 = i11;
                    columnIndexOrThrow19 = i3;
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

    @Override // us.pinguo.repository2020.database.filter.a
    public void b(List<FilterItemTable> list) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(list);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // us.pinguo.repository2020.database.filter.a
    public void c(List<FilterItemTable> list) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.c.handleMultiple(list);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // us.pinguo.repository2020.database.filter.a
    public List<FilterItemTable> d(String str) {
        RoomSQLiteQuery roomSQLiteQuery;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        int columnIndexOrThrow14;
        Integer valueOf;
        int i2;
        String string;
        int i3;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM item WHERE packageId=?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "_aid");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, TapjoyAuctionFlags.AUCTION_ID);
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "namejson");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "icon");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "sortInPackage");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "packageId");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "packageMd5");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "isCollect");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "collectTime");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "hasMusic");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, Frame.PARAM_KEY_OPACITY);
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "type");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "unity_engine_filter");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "camera_support");
            roomSQLiteQuery = acquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = acquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "enableGesture");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "temp1");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "temp2");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "temp3");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "temp4");
            int i4 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                int i5 = query.getInt(columnIndexOrThrow);
                String string2 = query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2);
                String string3 = query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3);
                String string4 = query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4);
                Integer valueOf2 = query.isNull(columnIndexOrThrow5) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow5));
                String string5 = query.isNull(columnIndexOrThrow6) ? null : query.getString(columnIndexOrThrow6);
                String string6 = query.isNull(columnIndexOrThrow7) ? null : query.getString(columnIndexOrThrow7);
                Integer valueOf3 = query.isNull(columnIndexOrThrow8) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow8));
                Long valueOf4 = query.isNull(columnIndexOrThrow9) ? null : Long.valueOf(query.getLong(columnIndexOrThrow9));
                Integer valueOf5 = query.isNull(columnIndexOrThrow10) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow10));
                int i6 = query.getInt(columnIndexOrThrow11);
                String string7 = query.isNull(columnIndexOrThrow12) ? null : query.getString(columnIndexOrThrow12);
                if (query.isNull(columnIndexOrThrow13)) {
                    i2 = i4;
                    valueOf = null;
                } else {
                    valueOf = Integer.valueOf(query.getInt(columnIndexOrThrow13));
                    i2 = i4;
                }
                Integer valueOf6 = query.isNull(i2) ? null : Integer.valueOf(query.getInt(i2));
                int i7 = columnIndexOrThrow15;
                int i8 = columnIndexOrThrow;
                Integer valueOf7 = query.isNull(i7) ? null : Integer.valueOf(query.getInt(i7));
                int i9 = columnIndexOrThrow16;
                String string8 = query.isNull(i9) ? null : query.getString(i9);
                int i10 = columnIndexOrThrow17;
                String string9 = query.isNull(i10) ? null : query.getString(i10);
                int i11 = columnIndexOrThrow18;
                String string10 = query.isNull(i11) ? null : query.getString(i11);
                int i12 = columnIndexOrThrow19;
                if (query.isNull(i12)) {
                    i3 = i12;
                    string = null;
                } else {
                    string = query.getString(i12);
                    i3 = i12;
                }
                arrayList.add(new FilterItemTable(i5, string2, string3, string4, valueOf2, string5, string6, valueOf3, valueOf4, valueOf5, i6, string7, valueOf, valueOf6, valueOf7, string8, string9, string10, string));
                columnIndexOrThrow = i8;
                columnIndexOrThrow15 = i7;
                columnIndexOrThrow16 = i9;
                columnIndexOrThrow17 = i10;
                columnIndexOrThrow18 = i11;
                columnIndexOrThrow19 = i3;
                i4 = i2;
            }
            query.close();
            roomSQLiteQuery.release();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // us.pinguo.repository2020.database.filter.a
    public void e(FilterItemTable filterItemTable) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.f11840d.handle(filterItemTable);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // us.pinguo.repository2020.database.filter.a
    public void f(List<FilterItemTable> list) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.f11840d.handleMultiple(list);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // us.pinguo.repository2020.database.filter.a
    public void g(FilterItemTable filterItemTable) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert((EntityInsertionAdapter<FilterItemTable>) filterItemTable);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }
}
