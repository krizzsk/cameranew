package us.pinguo.repository2020.database.filter;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.tapjoy.TapjoyAuctionFlags;
import com.tencent.matrix.trace.config.SharePluginInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* compiled from: FilterParamsDao_Impl.java */
/* loaded from: classes6.dex */
public final class f implements e {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<FilterParamsTable> b;
    private final EntityDeletionOrUpdateAdapter<FilterParamsTable> c;

    /* compiled from: FilterParamsDao_Impl.java */
    /* loaded from: classes6.dex */
    class a extends EntityInsertionAdapter<FilterParamsTable> {
        a(f fVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, FilterParamsTable filterParamsTable) {
            supportSQLiteStatement.bindLong(1, filterParamsTable.get_aid());
            if (filterParamsTable.getId() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, filterParamsTable.getId());
            }
            if (filterParamsTable.getPackageId() == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, filterParamsTable.getPackageId());
            }
            if (filterParamsTable.getKey() == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, filterParamsTable.getKey());
            }
            if (filterParamsTable.getPreCmd() == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindString(5, filterParamsTable.getPreCmd());
            }
            if (filterParamsTable.getGpuCmd() == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindString(6, filterParamsTable.getGpuCmd());
            }
            if (filterParamsTable.getTextureStr() == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindString(7, filterParamsTable.getTextureStr());
            }
            if (filterParamsTable.getParamStr() == null) {
                supportSQLiteStatement.bindNull(8);
            } else {
                supportSQLiteStatement.bindString(8, filterParamsTable.getParamStr());
            }
            if (filterParamsTable.getSubType() == null) {
                supportSQLiteStatement.bindNull(9);
            } else {
                supportSQLiteStatement.bindString(9, filterParamsTable.getSubType());
            }
            if (filterParamsTable.getSupportPreview() == null) {
                supportSQLiteStatement.bindNull(10);
            } else {
                supportSQLiteStatement.bindLong(10, filterParamsTable.getSupportPreview().intValue());
            }
            if (filterParamsTable.getVersion() == null) {
                supportSQLiteStatement.bindNull(11);
            } else {
                supportSQLiteStatement.bindLong(11, filterParamsTable.getVersion().intValue());
            }
            if (filterParamsTable.getSkinParam() == null) {
                supportSQLiteStatement.bindNull(12);
            } else {
                supportSQLiteStatement.bindString(12, filterParamsTable.getSkinParam());
            }
            if (filterParamsTable.getVersionDir() == null) {
                supportSQLiteStatement.bindNull(13);
            } else {
                supportSQLiteStatement.bindString(13, filterParamsTable.getVersionDir());
            }
            if (filterParamsTable.getOnlineParam() == null) {
                supportSQLiteStatement.bindNull(14);
            } else {
                supportSQLiteStatement.bindString(14, filterParamsTable.getOnlineParam());
            }
            if (filterParamsTable.getTemp1() == null) {
                supportSQLiteStatement.bindNull(15);
            } else {
                supportSQLiteStatement.bindString(15, filterParamsTable.getTemp1());
            }
            if (filterParamsTable.getTemp2() == null) {
                supportSQLiteStatement.bindNull(16);
            } else {
                supportSQLiteStatement.bindString(16, filterParamsTable.getTemp2());
            }
            if (filterParamsTable.getTemp3() == null) {
                supportSQLiteStatement.bindNull(17);
            } else {
                supportSQLiteStatement.bindString(17, filterParamsTable.getTemp3());
            }
            if (filterParamsTable.getTemp4() == null) {
                supportSQLiteStatement.bindNull(18);
            } else {
                supportSQLiteStatement.bindString(18, filterParamsTable.getTemp4());
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `effect` (`_aid`,`id`,`packageId`,`key`,`preCmd`,`gpuCmd`,`textureStr`,`paramStr`,`subType`,`supportPreview`,`version`,`skinParam`,`versionDir`,`onlineParam`,`temp1`,`temp2`,`temp3`,`temp4`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    /* compiled from: FilterParamsDao_Impl.java */
    /* loaded from: classes6.dex */
    class b extends EntityDeletionOrUpdateAdapter<FilterParamsTable> {
        b(f fVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, FilterParamsTable filterParamsTable) {
            supportSQLiteStatement.bindLong(1, filterParamsTable.get_aid());
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM `effect` WHERE `_aid` = ?";
        }
    }

    /* compiled from: FilterParamsDao_Impl.java */
    /* loaded from: classes6.dex */
    class c extends EntityDeletionOrUpdateAdapter<FilterParamsTable> {
        c(f fVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, FilterParamsTable filterParamsTable) {
            supportSQLiteStatement.bindLong(1, filterParamsTable.get_aid());
            if (filterParamsTable.getId() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, filterParamsTable.getId());
            }
            if (filterParamsTable.getPackageId() == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, filterParamsTable.getPackageId());
            }
            if (filterParamsTable.getKey() == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, filterParamsTable.getKey());
            }
            if (filterParamsTable.getPreCmd() == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindString(5, filterParamsTable.getPreCmd());
            }
            if (filterParamsTable.getGpuCmd() == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindString(6, filterParamsTable.getGpuCmd());
            }
            if (filterParamsTable.getTextureStr() == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindString(7, filterParamsTable.getTextureStr());
            }
            if (filterParamsTable.getParamStr() == null) {
                supportSQLiteStatement.bindNull(8);
            } else {
                supportSQLiteStatement.bindString(8, filterParamsTable.getParamStr());
            }
            if (filterParamsTable.getSubType() == null) {
                supportSQLiteStatement.bindNull(9);
            } else {
                supportSQLiteStatement.bindString(9, filterParamsTable.getSubType());
            }
            if (filterParamsTable.getSupportPreview() == null) {
                supportSQLiteStatement.bindNull(10);
            } else {
                supportSQLiteStatement.bindLong(10, filterParamsTable.getSupportPreview().intValue());
            }
            if (filterParamsTable.getVersion() == null) {
                supportSQLiteStatement.bindNull(11);
            } else {
                supportSQLiteStatement.bindLong(11, filterParamsTable.getVersion().intValue());
            }
            if (filterParamsTable.getSkinParam() == null) {
                supportSQLiteStatement.bindNull(12);
            } else {
                supportSQLiteStatement.bindString(12, filterParamsTable.getSkinParam());
            }
            if (filterParamsTable.getVersionDir() == null) {
                supportSQLiteStatement.bindNull(13);
            } else {
                supportSQLiteStatement.bindString(13, filterParamsTable.getVersionDir());
            }
            if (filterParamsTable.getOnlineParam() == null) {
                supportSQLiteStatement.bindNull(14);
            } else {
                supportSQLiteStatement.bindString(14, filterParamsTable.getOnlineParam());
            }
            if (filterParamsTable.getTemp1() == null) {
                supportSQLiteStatement.bindNull(15);
            } else {
                supportSQLiteStatement.bindString(15, filterParamsTable.getTemp1());
            }
            if (filterParamsTable.getTemp2() == null) {
                supportSQLiteStatement.bindNull(16);
            } else {
                supportSQLiteStatement.bindString(16, filterParamsTable.getTemp2());
            }
            if (filterParamsTable.getTemp3() == null) {
                supportSQLiteStatement.bindNull(17);
            } else {
                supportSQLiteStatement.bindString(17, filterParamsTable.getTemp3());
            }
            if (filterParamsTable.getTemp4() == null) {
                supportSQLiteStatement.bindNull(18);
            } else {
                supportSQLiteStatement.bindString(18, filterParamsTable.getTemp4());
            }
            supportSQLiteStatement.bindLong(19, filterParamsTable.get_aid());
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE OR ABORT `effect` SET `_aid` = ?,`id` = ?,`packageId` = ?,`key` = ?,`preCmd` = ?,`gpuCmd` = ?,`textureStr` = ?,`paramStr` = ?,`subType` = ?,`supportPreview` = ?,`version` = ?,`skinParam` = ?,`versionDir` = ?,`onlineParam` = ?,`temp1` = ?,`temp2` = ?,`temp3` = ?,`temp4` = ? WHERE `_aid` = ?";
        }
    }

    public f(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(this, roomDatabase);
        this.c = new b(this, roomDatabase);
        new c(this, roomDatabase);
    }

    public static List<Class<?>> e() {
        return Collections.emptyList();
    }

    @Override // us.pinguo.repository2020.database.filter.e
    public List<FilterParamsTable> a() {
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
        int i2;
        String string;
        int i3;
        String string2;
        String string3;
        String string4;
        String string5;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM effect", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "_aid");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, TapjoyAuctionFlags.AUCTION_ID);
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "packageId");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "key");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "preCmd");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "gpuCmd");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "textureStr");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "paramStr");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, SharePluginInfo.ISSUE_SUB_TYPE);
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "supportPreview");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "version");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "skinParam");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "versionDir");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "onlineParam");
            roomSQLiteQuery = acquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = acquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "temp1");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "temp2");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "temp3");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "temp4");
            int i4 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                FilterParamsTable filterParamsTable = new FilterParamsTable();
                ArrayList arrayList2 = arrayList;
                filterParamsTable.set_aid(query.getInt(columnIndexOrThrow));
                filterParamsTable.setId(query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2));
                filterParamsTable.setPackageId(query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3));
                filterParamsTable.setKey(query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4));
                filterParamsTable.setPreCmd(query.isNull(columnIndexOrThrow5) ? null : query.getString(columnIndexOrThrow5));
                filterParamsTable.setGpuCmd(query.isNull(columnIndexOrThrow6) ? null : query.getString(columnIndexOrThrow6));
                filterParamsTable.setTextureStr(query.isNull(columnIndexOrThrow7) ? null : query.getString(columnIndexOrThrow7));
                filterParamsTable.setParamStr(query.isNull(columnIndexOrThrow8) ? null : query.getString(columnIndexOrThrow8));
                filterParamsTable.setSubType(query.isNull(columnIndexOrThrow9) ? null : query.getString(columnIndexOrThrow9));
                filterParamsTable.setSupportPreview(query.isNull(columnIndexOrThrow10) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow10)));
                filterParamsTable.setVersion(query.isNull(columnIndexOrThrow11) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow11)));
                filterParamsTable.setSkinParam(query.isNull(columnIndexOrThrow12) ? null : query.getString(columnIndexOrThrow12));
                filterParamsTable.setVersionDir(query.isNull(columnIndexOrThrow13) ? null : query.getString(columnIndexOrThrow13));
                int i5 = i4;
                if (query.isNull(i5)) {
                    i2 = columnIndexOrThrow;
                    string = null;
                } else {
                    i2 = columnIndexOrThrow;
                    string = query.getString(i5);
                }
                filterParamsTable.setOnlineParam(string);
                int i6 = columnIndexOrThrow15;
                if (query.isNull(i6)) {
                    i3 = i6;
                    string2 = null;
                } else {
                    i3 = i6;
                    string2 = query.getString(i6);
                }
                filterParamsTable.setTemp1(string2);
                int i7 = columnIndexOrThrow16;
                if (query.isNull(i7)) {
                    columnIndexOrThrow16 = i7;
                    string3 = null;
                } else {
                    columnIndexOrThrow16 = i7;
                    string3 = query.getString(i7);
                }
                filterParamsTable.setTemp2(string3);
                int i8 = columnIndexOrThrow17;
                if (query.isNull(i8)) {
                    columnIndexOrThrow17 = i8;
                    string4 = null;
                } else {
                    columnIndexOrThrow17 = i8;
                    string4 = query.getString(i8);
                }
                filterParamsTable.setTemp3(string4);
                int i9 = columnIndexOrThrow18;
                if (query.isNull(i9)) {
                    columnIndexOrThrow18 = i9;
                    string5 = null;
                } else {
                    columnIndexOrThrow18 = i9;
                    string5 = query.getString(i9);
                }
                filterParamsTable.setTemp4(string5);
                arrayList2.add(filterParamsTable);
                columnIndexOrThrow15 = i3;
                i4 = i5;
                arrayList = arrayList2;
                columnIndexOrThrow = i2;
            }
            ArrayList arrayList3 = arrayList;
            query.close();
            roomSQLiteQuery.release();
            return arrayList3;
        } catch (Throwable th2) {
            th = th2;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // us.pinguo.repository2020.database.filter.e
    public void b(List<FilterParamsTable> list) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(list);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // us.pinguo.repository2020.database.filter.e
    public void c(List<FilterParamsTable> list) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.c.handleMultiple(list);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // us.pinguo.repository2020.database.filter.e
    public List<FilterParamsTable> d(String str) {
        RoomSQLiteQuery roomSQLiteQuery;
        int i2;
        String string;
        int i3;
        String string2;
        String string3;
        String string4;
        String string5;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM effect WHERE packageId=?", 1);
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
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "packageId");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "key");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "preCmd");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "gpuCmd");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "textureStr");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "paramStr");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, SharePluginInfo.ISSUE_SUB_TYPE);
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "supportPreview");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "version");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "skinParam");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "versionDir");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "onlineParam");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "temp1");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "temp2");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "temp3");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "temp4");
                int i4 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    FilterParamsTable filterParamsTable = new FilterParamsTable();
                    ArrayList arrayList2 = arrayList;
                    filterParamsTable.set_aid(query.getInt(columnIndexOrThrow));
                    filterParamsTable.setId(query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2));
                    filterParamsTable.setPackageId(query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3));
                    filterParamsTable.setKey(query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4));
                    filterParamsTable.setPreCmd(query.isNull(columnIndexOrThrow5) ? null : query.getString(columnIndexOrThrow5));
                    filterParamsTable.setGpuCmd(query.isNull(columnIndexOrThrow6) ? null : query.getString(columnIndexOrThrow6));
                    filterParamsTable.setTextureStr(query.isNull(columnIndexOrThrow7) ? null : query.getString(columnIndexOrThrow7));
                    filterParamsTable.setParamStr(query.isNull(columnIndexOrThrow8) ? null : query.getString(columnIndexOrThrow8));
                    filterParamsTable.setSubType(query.isNull(columnIndexOrThrow9) ? null : query.getString(columnIndexOrThrow9));
                    filterParamsTable.setSupportPreview(query.isNull(columnIndexOrThrow10) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow10)));
                    filterParamsTable.setVersion(query.isNull(columnIndexOrThrow11) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow11)));
                    filterParamsTable.setSkinParam(query.isNull(columnIndexOrThrow12) ? null : query.getString(columnIndexOrThrow12));
                    filterParamsTable.setVersionDir(query.isNull(columnIndexOrThrow13) ? null : query.getString(columnIndexOrThrow13));
                    int i5 = i4;
                    if (query.isNull(i5)) {
                        i2 = columnIndexOrThrow;
                        string = null;
                    } else {
                        i2 = columnIndexOrThrow;
                        string = query.getString(i5);
                    }
                    filterParamsTable.setOnlineParam(string);
                    int i6 = columnIndexOrThrow15;
                    if (query.isNull(i6)) {
                        i3 = i6;
                        string2 = null;
                    } else {
                        i3 = i6;
                        string2 = query.getString(i6);
                    }
                    filterParamsTable.setTemp1(string2);
                    int i7 = columnIndexOrThrow16;
                    if (query.isNull(i7)) {
                        columnIndexOrThrow16 = i7;
                        string3 = null;
                    } else {
                        columnIndexOrThrow16 = i7;
                        string3 = query.getString(i7);
                    }
                    filterParamsTable.setTemp2(string3);
                    int i8 = columnIndexOrThrow17;
                    if (query.isNull(i8)) {
                        columnIndexOrThrow17 = i8;
                        string4 = null;
                    } else {
                        columnIndexOrThrow17 = i8;
                        string4 = query.getString(i8);
                    }
                    filterParamsTable.setTemp3(string4);
                    int i9 = columnIndexOrThrow18;
                    if (query.isNull(i9)) {
                        columnIndexOrThrow18 = i9;
                        string5 = null;
                    } else {
                        columnIndexOrThrow18 = i9;
                        string5 = query.getString(i9);
                    }
                    filterParamsTable.setTemp4(string5);
                    arrayList2.add(filterParamsTable);
                    columnIndexOrThrow15 = i3;
                    i4 = i5;
                    arrayList = arrayList2;
                    columnIndexOrThrow = i2;
                }
                ArrayList arrayList3 = arrayList;
                query.close();
                roomSQLiteQuery.release();
                return arrayList3;
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
