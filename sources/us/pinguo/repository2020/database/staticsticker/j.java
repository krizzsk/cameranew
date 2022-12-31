package us.pinguo.repository2020.database.staticsticker;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* compiled from: StickerTemplateCollectionDao_Impl.java */
/* loaded from: classes6.dex */
public final class j implements i {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<k> b;
    private final SharedSQLiteStatement c;

    /* compiled from: StickerTemplateCollectionDao_Impl.java */
    /* loaded from: classes6.dex */
    class a extends EntityInsertionAdapter<k> {
        a(j jVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, k kVar) {
            if (kVar.a() == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, kVar.a());
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `sticker_template_collection` (`tid`) VALUES (?)";
        }
    }

    /* compiled from: StickerTemplateCollectionDao_Impl.java */
    /* loaded from: classes6.dex */
    class b extends EntityDeletionOrUpdateAdapter<k> {
        b(j jVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, k kVar) {
            if (kVar.a() == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, kVar.a());
            }
            if (kVar.a() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, kVar.a());
            }
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE OR ABORT `sticker_template_collection` SET `tid` = ? WHERE `tid` = ?";
        }
    }

    /* compiled from: StickerTemplateCollectionDao_Impl.java */
    /* loaded from: classes6.dex */
    class c extends SharedSQLiteStatement {
        c(j jVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM sticker_template_collection WHERE tid = ?";
        }
    }

    public j(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(this, roomDatabase);
        new b(this, roomDatabase);
        this.c = new c(this, roomDatabase);
    }

    public static List<Class<?>> c() {
        return Collections.emptyList();
    }

    @Override // us.pinguo.repository2020.database.staticsticker.i
    public void a(String str) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.c.acquire();
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
            this.c.release(acquire);
        }
    }

    @Override // us.pinguo.repository2020.database.staticsticker.i
    public void b(k kVar) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert((EntityInsertionAdapter<k>) kVar);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // us.pinguo.repository2020.database.staticsticker.i
    public List<k> getAll() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM sticker_template_collection", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "tid");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(new k(query.isNull(columnIndexOrThrow) ? null : query.getString(columnIndexOrThrow)));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }
}
