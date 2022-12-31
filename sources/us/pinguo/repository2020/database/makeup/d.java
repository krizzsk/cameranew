package us.pinguo.repository2020.database.makeup;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.tapjoy.TapjoyAuctionFlags;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* compiled from: MaterialItemDao_Impl.java */
/* loaded from: classes6.dex */
public final class d implements c {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<MaterialItemTable> b;

    /* compiled from: MaterialItemDao_Impl.java */
    /* loaded from: classes6.dex */
    class a extends EntityInsertionAdapter<MaterialItemTable> {
        a(d dVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, MaterialItemTable materialItemTable) {
            supportSQLiteStatement.bindLong(1, materialItemTable.get_aid());
            if (materialItemTable.getId() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, materialItemTable.getId());
            }
            if (materialItemTable.getNamejson() == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, materialItemTable.getNamejson());
            }
            if (materialItemTable.getIcon() == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, materialItemTable.getIcon());
            }
            if (materialItemTable.getSortInPackage() == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindLong(5, materialItemTable.getSortInPackage().intValue());
            }
            if (materialItemTable.getPackageId() == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindString(6, materialItemTable.getPackageId());
            }
            if (materialItemTable.getPackageMd5() == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindString(7, materialItemTable.getPackageMd5());
            }
            if (materialItemTable.isCollect() == null) {
                supportSQLiteStatement.bindNull(8);
            } else {
                supportSQLiteStatement.bindLong(8, materialItemTable.isCollect().intValue());
            }
            if (materialItemTable.getCollectTime() == null) {
                supportSQLiteStatement.bindNull(9);
            } else {
                supportSQLiteStatement.bindLong(9, materialItemTable.getCollectTime().longValue());
            }
            if (materialItemTable.getHasMusic() == null) {
                supportSQLiteStatement.bindNull(10);
            } else {
                supportSQLiteStatement.bindLong(10, materialItemTable.getHasMusic().intValue());
            }
            if (materialItemTable.getType() == null) {
                supportSQLiteStatement.bindNull(11);
            } else {
                supportSQLiteStatement.bindString(11, materialItemTable.getType());
            }
            if (materialItemTable.getTemp1() == null) {
                supportSQLiteStatement.bindNull(12);
            } else {
                supportSQLiteStatement.bindString(12, materialItemTable.getTemp1());
            }
            if (materialItemTable.getTemp2() == null) {
                supportSQLiteStatement.bindNull(13);
            } else {
                supportSQLiteStatement.bindString(13, materialItemTable.getTemp2());
            }
            if (materialItemTable.getTemp3() == null) {
                supportSQLiteStatement.bindNull(14);
            } else {
                supportSQLiteStatement.bindString(14, materialItemTable.getTemp3());
            }
            if (materialItemTable.getTemp4() == null) {
                supportSQLiteStatement.bindNull(15);
            } else {
                supportSQLiteStatement.bindString(15, materialItemTable.getTemp4());
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `material_item` (`_aid`,`id`,`namejson`,`icon`,`sortInPackage`,`packageId`,`packageMd5`,`isCollect`,`collectTime`,`hasMusic`,`type`,`temp1`,`temp2`,`temp3`,`temp4`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    public d(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(this, roomDatabase);
    }

    public static List<Class<?>> d() {
        return Collections.emptyList();
    }

    @Override // us.pinguo.repository2020.database.makeup.c
    public List<MaterialItemTable> a(String str) {
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
        String string;
        int i2;
        String string2;
        int i3;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("select * from material_item where packageId =?", 1);
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
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "type");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "temp1");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "temp2");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "temp3");
            roomSQLiteQuery = acquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = acquire;
        }
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
                arrayList.add(new MaterialItemTable(i5, string3, string4, string5, valueOf, string6, string7, valueOf2, valueOf3, valueOf4, string8, string9, string, string10, string2));
                columnIndexOrThrow = i7;
                columnIndexOrThrow15 = i3;
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

    @Override // us.pinguo.repository2020.database.makeup.c
    public void b(List<String> list) {
        this.a.assertNotSuspendingTransaction();
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("delete from material_item where packageId in (");
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

    @Override // us.pinguo.repository2020.database.makeup.c
    public void c(List<MaterialItemTable> list) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(list);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // us.pinguo.repository2020.database.makeup.c
    public List<MaterialItemTable> getAll() {
        RoomSQLiteQuery roomSQLiteQuery;
        String string;
        int i2;
        String string2;
        int i3;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("select * from material_item", 0);
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
                    arrayList.add(new MaterialItemTable(i5, string3, string4, string5, valueOf, string6, string7, valueOf2, valueOf3, valueOf4, string8, string9, string, string10, string2));
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
