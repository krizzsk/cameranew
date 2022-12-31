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
import com.tencent.matrix.trace.config.SharePluginInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* compiled from: MaterialDetailDao_Impl.java */
/* loaded from: classes6.dex */
public final class b implements us.pinguo.repository2020.database.makeup.a {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<MaterialDetailTable> b;

    /* compiled from: MaterialDetailDao_Impl.java */
    /* loaded from: classes6.dex */
    class a extends EntityInsertionAdapter<MaterialDetailTable> {
        a(b bVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, MaterialDetailTable materialDetailTable) {
            if (materialDetailTable.getId() == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, materialDetailTable.getId());
            }
            if (materialDetailTable.getNamejson() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, materialDetailTable.getNamejson());
            }
            if (materialDetailTable.getPackageMd5() == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, materialDetailTable.getPackageMd5());
            }
            if (materialDetailTable.getSubType() == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, materialDetailTable.getSubType());
            }
            if (materialDetailTable.getIcon() == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindString(5, materialDetailTable.getIcon());
            }
            supportSQLiteStatement.bindLong(6, materialDetailTable.getSort());
            if (materialDetailTable.getDisplayMd5() == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindString(7, materialDetailTable.getDisplayMd5());
            }
            if (materialDetailTable.getFilterType() == null) {
                supportSQLiteStatement.bindNull(8);
            } else {
                supportSQLiteStatement.bindString(8, materialDetailTable.getFilterType());
            }
            if (materialDetailTable.getTemp1() == null) {
                supportSQLiteStatement.bindNull(9);
            } else {
                supportSQLiteStatement.bindString(9, materialDetailTable.getTemp1());
            }
            if (materialDetailTable.getTemp2() == null) {
                supportSQLiteStatement.bindNull(10);
            } else {
                supportSQLiteStatement.bindString(10, materialDetailTable.getTemp2());
            }
            if (materialDetailTable.getTemp3() == null) {
                supportSQLiteStatement.bindNull(11);
            } else {
                supportSQLiteStatement.bindString(11, materialDetailTable.getTemp3());
            }
            if (materialDetailTable.getTemp4() == null) {
                supportSQLiteStatement.bindNull(12);
            } else {
                supportSQLiteStatement.bindString(12, materialDetailTable.getTemp4());
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `material_detail` (`id`,`namejson`,`packageMd5`,`subType`,`icon`,`sort`,`displayMd5`,`filterType`,`temp1`,`temp2`,`temp3`,`temp4`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    public b(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(this, roomDatabase);
    }

    public static List<Class<?>> d() {
        return Collections.emptyList();
    }

    @Override // us.pinguo.repository2020.database.makeup.a
    public void a(MaterialDetailTable... materialDetailTableArr) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(materialDetailTableArr);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // us.pinguo.repository2020.database.makeup.a
    public MaterialDetailTable b(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("select * from material_detail where id =?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        MaterialDetailTable materialDetailTable = null;
        Cursor query = DBUtil.query(this.a, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, TapjoyAuctionFlags.AUCTION_ID);
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "namejson");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "packageMd5");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, SharePluginInfo.ISSUE_SUB_TYPE);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "icon");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "sort");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "displayMd5");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "filterType");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "temp1");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "temp2");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "temp3");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "temp4");
            if (query.moveToFirst()) {
                materialDetailTable = new MaterialDetailTable(query.isNull(columnIndexOrThrow) ? null : query.getString(columnIndexOrThrow), query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2), query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3), query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4), query.isNull(columnIndexOrThrow5) ? null : query.getString(columnIndexOrThrow5), query.getLong(columnIndexOrThrow6), query.isNull(columnIndexOrThrow7) ? null : query.getString(columnIndexOrThrow7), query.isNull(columnIndexOrThrow8) ? null : query.getString(columnIndexOrThrow8), query.isNull(columnIndexOrThrow9) ? null : query.getString(columnIndexOrThrow9), query.isNull(columnIndexOrThrow10) ? null : query.getString(columnIndexOrThrow10), query.isNull(columnIndexOrThrow11) ? null : query.getString(columnIndexOrThrow11), query.isNull(columnIndexOrThrow12) ? null : query.getString(columnIndexOrThrow12));
            }
            return materialDetailTable;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // us.pinguo.repository2020.database.makeup.a
    public void c(List<String> list) {
        this.a.assertNotSuspendingTransaction();
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("delete from material_detail where id in (");
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

    @Override // us.pinguo.repository2020.database.makeup.a
    public List<MaterialDetailTable> getAll() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("select * from material_detail", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, TapjoyAuctionFlags.AUCTION_ID);
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "namejson");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "packageMd5");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, SharePluginInfo.ISSUE_SUB_TYPE);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "icon");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "sort");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "displayMd5");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "filterType");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "temp1");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "temp2");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "temp3");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "temp4");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(new MaterialDetailTable(query.isNull(columnIndexOrThrow) ? null : query.getString(columnIndexOrThrow), query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2), query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3), query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4), query.isNull(columnIndexOrThrow5) ? null : query.getString(columnIndexOrThrow5), query.getLong(columnIndexOrThrow6), query.isNull(columnIndexOrThrow7) ? null : query.getString(columnIndexOrThrow7), query.isNull(columnIndexOrThrow8) ? null : query.getString(columnIndexOrThrow8), query.isNull(columnIndexOrThrow9) ? null : query.getString(columnIndexOrThrow9), query.isNull(columnIndexOrThrow10) ? null : query.getString(columnIndexOrThrow10), query.isNull(columnIndexOrThrow11) ? null : query.getString(columnIndexOrThrow11), query.isNull(columnIndexOrThrow12) ? null : query.getString(columnIndexOrThrow12)));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }
}
