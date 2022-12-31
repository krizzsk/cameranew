package us.pinguo.repository2020.database.filter;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.tapjoy.TapjoyAuctionFlags;
import com.tencent.matrix.trace.config.SharePluginInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* compiled from: FilterPackageDao_Impl.java */
/* loaded from: classes6.dex */
public final class d implements us.pinguo.repository2020.database.filter.c {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<FilterPackageTable> b;
    private final EntityDeletionOrUpdateAdapter<FilterPackageTable> c;

    /* renamed from: d  reason: collision with root package name */
    private final SharedSQLiteStatement f11841d;

    /* compiled from: FilterPackageDao_Impl.java */
    /* loaded from: classes6.dex */
    class a extends EntityInsertionAdapter<FilterPackageTable> {
        a(d dVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, FilterPackageTable filterPackageTable) {
            if (filterPackageTable.getCategoryId() == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, filterPackageTable.getCategoryId());
            }
            if (filterPackageTable.getId() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, filterPackageTable.getId());
            }
            if (filterPackageTable.getNamejson() == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, filterPackageTable.getNamejson());
            }
            if (filterPackageTable.getFilterType() == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, filterPackageTable.getFilterType());
            }
            if (filterPackageTable.getSubType() == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindString(5, filterPackageTable.getSubType());
            }
            if (filterPackageTable.getIcon() == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindString(6, filterPackageTable.getIcon());
            }
            supportSQLiteStatement.bindLong(7, filterPackageTable.getSort());
            if (filterPackageTable.getDisplayMd5() == null) {
                supportSQLiteStatement.bindNull(8);
            } else {
                supportSQLiteStatement.bindString(8, filterPackageTable.getDisplayMd5());
            }
            if (filterPackageTable.getPackageMd5() == null) {
                supportSQLiteStatement.bindNull(9);
            } else {
                supportSQLiteStatement.bindString(9, filterPackageTable.getPackageMd5());
            }
            if (filterPackageTable.getVip() == null) {
                supportSQLiteStatement.bindNull(10);
            } else {
                supportSQLiteStatement.bindLong(10, filterPackageTable.getVip().intValue());
            }
            if (filterPackageTable.getUnity_engine_filter() == null) {
                supportSQLiteStatement.bindNull(11);
            } else {
                supportSQLiteStatement.bindLong(11, filterPackageTable.getUnity_engine_filter().intValue());
            }
            if (filterPackageTable.getCamera_support() == null) {
                supportSQLiteStatement.bindNull(12);
            } else {
                supportSQLiteStatement.bindLong(12, filterPackageTable.getCamera_support().intValue());
            }
            if (filterPackageTable.getTagContent() == null) {
                supportSQLiteStatement.bindNull(13);
            } else {
                supportSQLiteStatement.bindLong(13, filterPackageTable.getTagContent().intValue());
            }
            if (filterPackageTable.getTagOnTime() == null) {
                supportSQLiteStatement.bindNull(14);
            } else {
                supportSQLiteStatement.bindLong(14, filterPackageTable.getTagOnTime().longValue());
            }
            if (filterPackageTable.getTagOffTime() == null) {
                supportSQLiteStatement.bindNull(15);
            } else {
                supportSQLiteStatement.bindLong(15, filterPackageTable.getTagOffTime().longValue());
            }
            if (filterPackageTable.getTemp1() == null) {
                supportSQLiteStatement.bindNull(16);
            } else {
                supportSQLiteStatement.bindString(16, filterPackageTable.getTemp1());
            }
            if (filterPackageTable.getTemp2() == null) {
                supportSQLiteStatement.bindNull(17);
            } else {
                supportSQLiteStatement.bindString(17, filterPackageTable.getTemp2());
            }
            if (filterPackageTable.getTemp3() == null) {
                supportSQLiteStatement.bindNull(18);
            } else {
                supportSQLiteStatement.bindString(18, filterPackageTable.getTemp3());
            }
            if (filterPackageTable.getTemp4() == null) {
                supportSQLiteStatement.bindNull(19);
            } else {
                supportSQLiteStatement.bindString(19, filterPackageTable.getTemp4());
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `category` (`categoryId`,`id`,`namejson`,`filterType`,`subType`,`icon`,`sort`,`displayMd5`,`packageMd5`,`vip`,`unity_engine_filter`,`camera_support`,`tagContent`,`tagOnTime`,`tagOffTime`,`temp1`,`temp2`,`temp3`,`temp4`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    /* compiled from: FilterPackageDao_Impl.java */
    /* loaded from: classes6.dex */
    class b extends EntityDeletionOrUpdateAdapter<FilterPackageTable> {
        b(d dVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, FilterPackageTable filterPackageTable) {
            if (filterPackageTable.getId() == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, filterPackageTable.getId());
            }
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM `category` WHERE `id` = ?";
        }
    }

    /* compiled from: FilterPackageDao_Impl.java */
    /* loaded from: classes6.dex */
    class c extends EntityDeletionOrUpdateAdapter<FilterPackageTable> {
        c(d dVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, FilterPackageTable filterPackageTable) {
            if (filterPackageTable.getCategoryId() == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, filterPackageTable.getCategoryId());
            }
            if (filterPackageTable.getId() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, filterPackageTable.getId());
            }
            if (filterPackageTable.getNamejson() == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, filterPackageTable.getNamejson());
            }
            if (filterPackageTable.getFilterType() == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, filterPackageTable.getFilterType());
            }
            if (filterPackageTable.getSubType() == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindString(5, filterPackageTable.getSubType());
            }
            if (filterPackageTable.getIcon() == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindString(6, filterPackageTable.getIcon());
            }
            supportSQLiteStatement.bindLong(7, filterPackageTable.getSort());
            if (filterPackageTable.getDisplayMd5() == null) {
                supportSQLiteStatement.bindNull(8);
            } else {
                supportSQLiteStatement.bindString(8, filterPackageTable.getDisplayMd5());
            }
            if (filterPackageTable.getPackageMd5() == null) {
                supportSQLiteStatement.bindNull(9);
            } else {
                supportSQLiteStatement.bindString(9, filterPackageTable.getPackageMd5());
            }
            if (filterPackageTable.getVip() == null) {
                supportSQLiteStatement.bindNull(10);
            } else {
                supportSQLiteStatement.bindLong(10, filterPackageTable.getVip().intValue());
            }
            if (filterPackageTable.getUnity_engine_filter() == null) {
                supportSQLiteStatement.bindNull(11);
            } else {
                supportSQLiteStatement.bindLong(11, filterPackageTable.getUnity_engine_filter().intValue());
            }
            if (filterPackageTable.getCamera_support() == null) {
                supportSQLiteStatement.bindNull(12);
            } else {
                supportSQLiteStatement.bindLong(12, filterPackageTable.getCamera_support().intValue());
            }
            if (filterPackageTable.getTagContent() == null) {
                supportSQLiteStatement.bindNull(13);
            } else {
                supportSQLiteStatement.bindLong(13, filterPackageTable.getTagContent().intValue());
            }
            if (filterPackageTable.getTagOnTime() == null) {
                supportSQLiteStatement.bindNull(14);
            } else {
                supportSQLiteStatement.bindLong(14, filterPackageTable.getTagOnTime().longValue());
            }
            if (filterPackageTable.getTagOffTime() == null) {
                supportSQLiteStatement.bindNull(15);
            } else {
                supportSQLiteStatement.bindLong(15, filterPackageTable.getTagOffTime().longValue());
            }
            if (filterPackageTable.getTemp1() == null) {
                supportSQLiteStatement.bindNull(16);
            } else {
                supportSQLiteStatement.bindString(16, filterPackageTable.getTemp1());
            }
            if (filterPackageTable.getTemp2() == null) {
                supportSQLiteStatement.bindNull(17);
            } else {
                supportSQLiteStatement.bindString(17, filterPackageTable.getTemp2());
            }
            if (filterPackageTable.getTemp3() == null) {
                supportSQLiteStatement.bindNull(18);
            } else {
                supportSQLiteStatement.bindString(18, filterPackageTable.getTemp3());
            }
            if (filterPackageTable.getTemp4() == null) {
                supportSQLiteStatement.bindNull(19);
            } else {
                supportSQLiteStatement.bindString(19, filterPackageTable.getTemp4());
            }
            if (filterPackageTable.getId() == null) {
                supportSQLiteStatement.bindNull(20);
            } else {
                supportSQLiteStatement.bindString(20, filterPackageTable.getId());
            }
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE OR ABORT `category` SET `categoryId` = ?,`id` = ?,`namejson` = ?,`filterType` = ?,`subType` = ?,`icon` = ?,`sort` = ?,`displayMd5` = ?,`packageMd5` = ?,`vip` = ?,`unity_engine_filter` = ?,`camera_support` = ?,`tagContent` = ?,`tagOnTime` = ?,`tagOffTime` = ?,`temp1` = ?,`temp2` = ?,`temp3` = ?,`temp4` = ? WHERE `id` = ?";
        }
    }

    /* compiled from: FilterPackageDao_Impl.java */
    /* renamed from: us.pinguo.repository2020.database.filter.d$d  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    class C0435d extends SharedSQLiteStatement {
        C0435d(d dVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM category WHERE id = ?";
        }
    }

    public d(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(this, roomDatabase);
        this.c = new b(this, roomDatabase);
        new c(this, roomDatabase);
        this.f11841d = new C0435d(this, roomDatabase);
    }

    public static List<Class<?>> f() {
        return Collections.emptyList();
    }

    @Override // us.pinguo.repository2020.database.filter.c
    public List<FilterPackageTable> a() {
        RoomSQLiteQuery roomSQLiteQuery;
        Integer valueOf;
        int i2;
        String string;
        int i3;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM category ORDER BY sort DESC", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "categoryId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, TapjoyAuctionFlags.AUCTION_ID);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "namejson");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "filterType");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, SharePluginInfo.ISSUE_SUB_TYPE);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "icon");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "sort");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "displayMd5");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "packageMd5");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "vip");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "unity_engine_filter");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "camera_support");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "tagContent");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "tagOnTime");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "tagOffTime");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "temp1");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "temp2");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "temp3");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "temp4");
                int i4 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string2 = query.isNull(columnIndexOrThrow) ? null : query.getString(columnIndexOrThrow);
                    String string3 = query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2);
                    String string4 = query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3);
                    String string5 = query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4);
                    String string6 = query.isNull(columnIndexOrThrow5) ? null : query.getString(columnIndexOrThrow5);
                    String string7 = query.isNull(columnIndexOrThrow6) ? null : query.getString(columnIndexOrThrow6);
                    long j2 = query.getLong(columnIndexOrThrow7);
                    String string8 = query.isNull(columnIndexOrThrow8) ? null : query.getString(columnIndexOrThrow8);
                    String string9 = query.isNull(columnIndexOrThrow9) ? null : query.getString(columnIndexOrThrow9);
                    Integer valueOf2 = query.isNull(columnIndexOrThrow10) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow10));
                    Integer valueOf3 = query.isNull(columnIndexOrThrow11) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow11));
                    Integer valueOf4 = query.isNull(columnIndexOrThrow12) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow12));
                    if (query.isNull(columnIndexOrThrow13)) {
                        i2 = i4;
                        valueOf = null;
                    } else {
                        valueOf = Integer.valueOf(query.getInt(columnIndexOrThrow13));
                        i2 = i4;
                    }
                    Long valueOf5 = query.isNull(i2) ? null : Long.valueOf(query.getLong(i2));
                    int i5 = columnIndexOrThrow15;
                    int i6 = columnIndexOrThrow;
                    Long valueOf6 = query.isNull(i5) ? null : Long.valueOf(query.getLong(i5));
                    int i7 = columnIndexOrThrow16;
                    String string10 = query.isNull(i7) ? null : query.getString(i7);
                    int i8 = columnIndexOrThrow17;
                    String string11 = query.isNull(i8) ? null : query.getString(i8);
                    int i9 = columnIndexOrThrow18;
                    String string12 = query.isNull(i9) ? null : query.getString(i9);
                    int i10 = columnIndexOrThrow19;
                    if (query.isNull(i10)) {
                        i3 = i10;
                        string = null;
                    } else {
                        string = query.getString(i10);
                        i3 = i10;
                    }
                    arrayList.add(new FilterPackageTable(string2, string3, string4, string5, string6, string7, j2, string8, string9, valueOf2, valueOf3, valueOf4, valueOf, valueOf5, valueOf6, string10, string11, string12, string));
                    columnIndexOrThrow = i6;
                    columnIndexOrThrow15 = i5;
                    columnIndexOrThrow16 = i7;
                    columnIndexOrThrow17 = i8;
                    columnIndexOrThrow18 = i9;
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

    @Override // us.pinguo.repository2020.database.filter.c
    public void b(List<FilterPackageTable> list) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(list);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // us.pinguo.repository2020.database.filter.c
    public void c(FilterPackageTable filterPackageTable) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.c.handle(filterPackageTable);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // us.pinguo.repository2020.database.filter.c
    public void d(FilterPackageTable filterPackageTable) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert((EntityInsertionAdapter<FilterPackageTable>) filterPackageTable);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // us.pinguo.repository2020.database.filter.c
    public void e(String str) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.f11841d.acquire();
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
            this.f11841d.release(acquire);
        }
    }
}
