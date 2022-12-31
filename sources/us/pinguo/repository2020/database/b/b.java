package us.pinguo.repository2020.database.b;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* compiled from: FilterHistoryDao_Impl.java */
/* loaded from: classes6.dex */
public final class b implements us.pinguo.repository2020.database.b.a {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<us.pinguo.repository2020.database.b.c> b;
    private final EntityDeletionOrUpdateAdapter<us.pinguo.repository2020.database.b.c> c;

    /* compiled from: FilterHistoryDao_Impl.java */
    /* loaded from: classes6.dex */
    class a extends EntityInsertionAdapter<us.pinguo.repository2020.database.b.c> {
        a(b bVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, us.pinguo.repository2020.database.b.c cVar) {
            supportSQLiteStatement.bindLong(1, cVar.e());
            if (cVar.a() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, cVar.a());
            }
            if (cVar.c() == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, cVar.c());
            }
            if (cVar.d() == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, cVar.d());
            }
            supportSQLiteStatement.bindLong(5, cVar.b());
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `filter_history` (`_aid`,`filterId`,`packageId`,`position`,`number`) VALUES (nullif(?, 0),?,?,?,?)";
        }
    }

    /* compiled from: FilterHistoryDao_Impl.java */
    /* renamed from: us.pinguo.repository2020.database.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    class C0433b extends EntityDeletionOrUpdateAdapter<us.pinguo.repository2020.database.b.c> {
        C0433b(b bVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, us.pinguo.repository2020.database.b.c cVar) {
            supportSQLiteStatement.bindLong(1, cVar.e());
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM `filter_history` WHERE `_aid` = ?";
        }
    }

    /* compiled from: FilterHistoryDao_Impl.java */
    /* loaded from: classes6.dex */
    class c extends EntityDeletionOrUpdateAdapter<us.pinguo.repository2020.database.b.c> {
        c(b bVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, us.pinguo.repository2020.database.b.c cVar) {
            supportSQLiteStatement.bindLong(1, cVar.e());
            if (cVar.a() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, cVar.a());
            }
            if (cVar.c() == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, cVar.c());
            }
            if (cVar.d() == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, cVar.d());
            }
            supportSQLiteStatement.bindLong(5, cVar.b());
            supportSQLiteStatement.bindLong(6, cVar.e());
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE OR ABORT `filter_history` SET `_aid` = ?,`filterId` = ?,`packageId` = ?,`position` = ?,`number` = ? WHERE `_aid` = ?";
        }
    }

    public b(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(this, roomDatabase);
        new C0433b(this, roomDatabase);
        this.c = new c(this, roomDatabase);
    }

    public static List<Class<?>> e() {
        return Collections.emptyList();
    }

    @Override // us.pinguo.repository2020.database.b.a
    public List<us.pinguo.repository2020.database.b.c> a() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM filter_history", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "_aid");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "filterId");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "packageId");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "position");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "number");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(new us.pinguo.repository2020.database.b.c(query.getInt(columnIndexOrThrow), query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2), query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3), query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4), query.getInt(columnIndexOrThrow5)));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // us.pinguo.repository2020.database.b.a
    public void b(us.pinguo.repository2020.database.b.c cVar) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert((EntityInsertionAdapter<us.pinguo.repository2020.database.b.c>) cVar);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // us.pinguo.repository2020.database.b.a
    public us.pinguo.repository2020.database.b.c c(String str, String str2) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM filter_history WHERE position=? And filterId=?", 2);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        if (str2 == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str2);
        }
        this.a.assertNotSuspendingTransaction();
        us.pinguo.repository2020.database.b.c cVar = null;
        Cursor query = DBUtil.query(this.a, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "_aid");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "filterId");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "packageId");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "position");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "number");
            if (query.moveToFirst()) {
                cVar = new us.pinguo.repository2020.database.b.c(query.getInt(columnIndexOrThrow), query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2), query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3), query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4), query.getInt(columnIndexOrThrow5));
            }
            return cVar;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // us.pinguo.repository2020.database.b.a
    public void d(us.pinguo.repository2020.database.b.c cVar) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.c.handle(cVar);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }
}
