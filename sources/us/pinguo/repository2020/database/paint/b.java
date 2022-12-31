package us.pinguo.repository2020.database.paint;

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
/* compiled from: PaintMaterialDao_Impl.java */
/* loaded from: classes6.dex */
public final class b implements us.pinguo.repository2020.database.paint.a {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<PaintMaterialTable> b;

    /* compiled from: PaintMaterialDao_Impl.java */
    /* loaded from: classes6.dex */
    class a extends EntityInsertionAdapter<PaintMaterialTable> {
        a(b bVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, PaintMaterialTable paintMaterialTable) {
            if (paintMaterialTable.getId() == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, paintMaterialTable.getId());
            }
            if (paintMaterialTable.getIcon() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, paintMaterialTable.getIcon());
            }
            if (paintMaterialTable.getResourceFolderPath() == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, paintMaterialTable.getResourceFolderPath());
            }
            if (paintMaterialTable.getResourceChildPath() == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, paintMaterialTable.getResourceChildPath());
            }
            if (paintMaterialTable.getResourceChildBlendMode() == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindString(5, paintMaterialTable.getResourceChildBlendMode());
            }
            if (paintMaterialTable.getAutoAdjustPaintInterval() == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindLong(6, paintMaterialTable.getAutoAdjustPaintInterval().intValue());
            }
            if (paintMaterialTable.getBrushSizeCalculateMode() == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindLong(7, paintMaterialTable.getBrushSizeCalculateMode().intValue());
            }
            if (paintMaterialTable.getBrushSourceType() == null) {
                supportSQLiteStatement.bindNull(8);
            } else {
                supportSQLiteStatement.bindLong(8, paintMaterialTable.getBrushSourceType().intValue());
            }
            if (paintMaterialTable.getEnableRandomSpriteIndex() == null) {
                supportSQLiteStatement.bindNull(9);
            } else {
                supportSQLiteStatement.bindLong(9, paintMaterialTable.getEnableRandomSpriteIndex().intValue());
            }
            if (paintMaterialTable.getEnableRotate() == null) {
                supportSQLiteStatement.bindNull(10);
            } else {
                supportSQLiteStatement.bindLong(10, paintMaterialTable.getEnableRotate().intValue());
            }
            if (paintMaterialTable.getPaintIntervalRatio() == null) {
                supportSQLiteStatement.bindNull(11);
            } else {
                supportSQLiteStatement.bindDouble(11, paintMaterialTable.getPaintIntervalRatio().floatValue());
            }
            if (paintMaterialTable.getBrushDefaultEffectIntensity() == null) {
                supportSQLiteStatement.bindNull(12);
            } else {
                supportSQLiteStatement.bindDouble(12, paintMaterialTable.getBrushDefaultEffectIntensity().floatValue());
            }
            if (paintMaterialTable.getBrushEffectIntensity() == null) {
                supportSQLiteStatement.bindNull(13);
            } else {
                supportSQLiteStatement.bindDouble(13, paintMaterialTable.getBrushEffectIntensity().floatValue());
            }
            if (paintMaterialTable.getBrushSizeRatio() == null) {
                supportSQLiteStatement.bindNull(14);
            } else {
                supportSQLiteStatement.bindDouble(14, paintMaterialTable.getBrushSizeRatio().floatValue());
            }
            if (paintMaterialTable.getBrushDisplaySizeRatio() == null) {
                supportSQLiteStatement.bindNull(15);
            } else {
                supportSQLiteStatement.bindDouble(15, paintMaterialTable.getBrushDisplaySizeRatio().floatValue());
            }
            if (paintMaterialTable.getBrushColor() == null) {
                supportSQLiteStatement.bindNull(16);
            } else {
                supportSQLiteStatement.bindString(16, paintMaterialTable.getBrushColor());
            }
            if (paintMaterialTable.getEnableFlow() == null) {
                supportSQLiteStatement.bindNull(17);
            } else {
                supportSQLiteStatement.bindLong(17, paintMaterialTable.getEnableFlow().intValue());
            }
            if (paintMaterialTable.getBrushBlendMode() == null) {
                supportSQLiteStatement.bindNull(18);
            } else {
                supportSQLiteStatement.bindLong(18, paintMaterialTable.getBrushBlendMode().intValue());
            }
            if (paintMaterialTable.getSupportChangeColor() == null) {
                supportSQLiteStatement.bindNull(19);
            } else {
                supportSQLiteStatement.bindLong(19, paintMaterialTable.getSupportChangeColor().intValue());
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `paint_material` (`id`,`icon`,`resourceFolderPath`,`resourceChildPath`,`resourceChildBlendMode`,`autoAdjustPaintInterval`,`brushSizeCalculateMode`,`brushSourceType`,`enableRandomSpriteIndex`,`enableRotate`,`paintIntervalRatio`,`brushDefaultEffectIntensity`,`brushEffectIntensity`,`brushSizeRatio`,`brushDisplaySizeRatio`,`brushColor`,`enableFlow`,`brushBlendMode`,`supportChangeColor`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    public b(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(this, roomDatabase);
    }

    public static List<Class<?>> c() {
        return Collections.emptyList();
    }

    @Override // us.pinguo.repository2020.database.paint.a
    public void a(List<String> list) {
        this.a.assertNotSuspendingTransaction();
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("delete from paint_material where id in (");
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

    @Override // us.pinguo.repository2020.database.paint.a
    public void b(PaintMaterialTable... paintMaterialTableArr) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(paintMaterialTableArr);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // us.pinguo.repository2020.database.paint.a
    public List<PaintMaterialTable> getAll() {
        RoomSQLiteQuery roomSQLiteQuery;
        Float valueOf;
        int i2;
        Integer valueOf2;
        int i3;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("select * from paint_material", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, TapjoyAuctionFlags.AUCTION_ID);
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "icon");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "resourceFolderPath");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "resourceChildPath");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "resourceChildBlendMode");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "autoAdjustPaintInterval");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "brushSizeCalculateMode");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "brushSourceType");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "enableRandomSpriteIndex");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "enableRotate");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "paintIntervalRatio");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "brushDefaultEffectIntensity");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "brushEffectIntensity");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "brushSizeRatio");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "brushDisplaySizeRatio");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "brushColor");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "enableFlow");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "brushBlendMode");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "supportChangeColor");
                int i4 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.isNull(columnIndexOrThrow) ? null : query.getString(columnIndexOrThrow);
                    String string2 = query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2);
                    String string3 = query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3);
                    String string4 = query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4);
                    String string5 = query.isNull(columnIndexOrThrow5) ? null : query.getString(columnIndexOrThrow5);
                    Integer valueOf3 = query.isNull(columnIndexOrThrow6) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow6));
                    Integer valueOf4 = query.isNull(columnIndexOrThrow7) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow7));
                    Integer valueOf5 = query.isNull(columnIndexOrThrow8) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow8));
                    Integer valueOf6 = query.isNull(columnIndexOrThrow9) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow9));
                    Integer valueOf7 = query.isNull(columnIndexOrThrow10) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow10));
                    Float valueOf8 = query.isNull(columnIndexOrThrow11) ? null : Float.valueOf(query.getFloat(columnIndexOrThrow11));
                    Float valueOf9 = query.isNull(columnIndexOrThrow12) ? null : Float.valueOf(query.getFloat(columnIndexOrThrow12));
                    if (query.isNull(columnIndexOrThrow13)) {
                        i2 = i4;
                        valueOf = null;
                    } else {
                        valueOf = Float.valueOf(query.getFloat(columnIndexOrThrow13));
                        i2 = i4;
                    }
                    Float valueOf10 = query.isNull(i2) ? null : Float.valueOf(query.getFloat(i2));
                    int i5 = columnIndexOrThrow15;
                    int i6 = columnIndexOrThrow;
                    Float valueOf11 = query.isNull(i5) ? null : Float.valueOf(query.getFloat(i5));
                    int i7 = columnIndexOrThrow16;
                    String string6 = query.isNull(i7) ? null : query.getString(i7);
                    int i8 = columnIndexOrThrow17;
                    Integer valueOf12 = query.isNull(i8) ? null : Integer.valueOf(query.getInt(i8));
                    int i9 = columnIndexOrThrow18;
                    Integer valueOf13 = query.isNull(i9) ? null : Integer.valueOf(query.getInt(i9));
                    int i10 = columnIndexOrThrow19;
                    if (query.isNull(i10)) {
                        i3 = i10;
                        valueOf2 = null;
                    } else {
                        valueOf2 = Integer.valueOf(query.getInt(i10));
                        i3 = i10;
                    }
                    arrayList.add(new PaintMaterialTable(string, string2, string3, string4, string5, valueOf3, valueOf4, valueOf5, valueOf6, valueOf7, valueOf8, valueOf9, valueOf, valueOf10, valueOf11, string6, valueOf12, valueOf13, valueOf2));
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
}
