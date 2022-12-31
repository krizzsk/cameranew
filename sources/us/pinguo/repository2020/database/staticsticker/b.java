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
/* compiled from: BackgroundBlurMaterialDao_Impl.java */
/* loaded from: classes6.dex */
public final class b implements us.pinguo.repository2020.database.staticsticker.a {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<BackgroundBlurMaterialTable> b;
    private final EntityDeletionOrUpdateAdapter<BackgroundBlurMaterialTable> c;

    /* renamed from: d  reason: collision with root package name */
    private final SharedSQLiteStatement f11852d;

    /* compiled from: BackgroundBlurMaterialDao_Impl.java */
    /* loaded from: classes6.dex */
    class a extends EntityInsertionAdapter<BackgroundBlurMaterialTable> {
        a(b bVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, BackgroundBlurMaterialTable backgroundBlurMaterialTable) {
            if (backgroundBlurMaterialTable.getPid() == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, backgroundBlurMaterialTable.getPid());
            }
            if (backgroundBlurMaterialTable.getSid() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, backgroundBlurMaterialTable.getSid());
            }
            if (backgroundBlurMaterialTable.getName() == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, backgroundBlurMaterialTable.getName());
            }
            if (backgroundBlurMaterialTable.getIcon() == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, backgroundBlurMaterialTable.getIcon());
            }
            if (backgroundBlurMaterialTable.getShape() == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindString(5, backgroundBlurMaterialTable.getShape());
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `background_blur_material` (`pid`,`sid`,`name`,`icon`,`shape`) VALUES (?,?,?,?,?)";
        }
    }

    /* compiled from: BackgroundBlurMaterialDao_Impl.java */
    /* renamed from: us.pinguo.repository2020.database.staticsticker.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    class C0437b extends EntityDeletionOrUpdateAdapter<BackgroundBlurMaterialTable> {
        C0437b(b bVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, BackgroundBlurMaterialTable backgroundBlurMaterialTable) {
            if (backgroundBlurMaterialTable.getPid() == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, backgroundBlurMaterialTable.getPid());
            }
            if (backgroundBlurMaterialTable.getSid() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, backgroundBlurMaterialTable.getSid());
            }
            if (backgroundBlurMaterialTable.getName() == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, backgroundBlurMaterialTable.getName());
            }
            if (backgroundBlurMaterialTable.getIcon() == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, backgroundBlurMaterialTable.getIcon());
            }
            if (backgroundBlurMaterialTable.getShape() == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindString(5, backgroundBlurMaterialTable.getShape());
            }
            if (backgroundBlurMaterialTable.getPid() == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindString(6, backgroundBlurMaterialTable.getPid());
            }
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE OR ABORT `background_blur_material` SET `pid` = ?,`sid` = ?,`name` = ?,`icon` = ?,`shape` = ? WHERE `pid` = ?";
        }
    }

    /* compiled from: BackgroundBlurMaterialDao_Impl.java */
    /* loaded from: classes6.dex */
    class c extends SharedSQLiteStatement {
        c(b bVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM background_blur_material WHERE sid = ?";
        }
    }

    public b(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(this, roomDatabase);
        this.c = new C0437b(this, roomDatabase);
        this.f11852d = new c(this, roomDatabase);
    }

    public static List<Class<?>> e() {
        return Collections.emptyList();
    }

    @Override // us.pinguo.repository2020.database.staticsticker.a
    public void a(String str) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.f11852d.acquire();
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
            this.f11852d.release(acquire);
        }
    }

    @Override // us.pinguo.repository2020.database.staticsticker.a
    public void b(List<String> list) {
        this.a.assertNotSuspendingTransaction();
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("DELETE FROM background_blur_material WHERE sid IN (");
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

    @Override // us.pinguo.repository2020.database.staticsticker.a
    public void c(BackgroundBlurMaterialTable backgroundBlurMaterialTable) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert((EntityInsertionAdapter<BackgroundBlurMaterialTable>) backgroundBlurMaterialTable);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // us.pinguo.repository2020.database.staticsticker.a
    public void d(BackgroundBlurMaterialTable backgroundBlurMaterialTable) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.c.handle(backgroundBlurMaterialTable);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // us.pinguo.repository2020.database.staticsticker.a
    public List<BackgroundBlurMaterialTable> getAll() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM background_blur_material", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "pid");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "sid");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "icon");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "shape");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(new BackgroundBlurMaterialTable(query.isNull(columnIndexOrThrow) ? null : query.getString(columnIndexOrThrow), query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2), query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3), query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4), query.isNull(columnIndexOrThrow5) ? null : query.getString(columnIndexOrThrow5)));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }
}
