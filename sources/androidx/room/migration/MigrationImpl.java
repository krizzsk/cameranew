package androidx.room.migration;

import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: Migration.kt */
/* loaded from: classes.dex */
final class MigrationImpl extends Migration {
    private final l<SupportSQLiteDatabase, u> migrateCallback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MigrationImpl(int i2, int i3, l<? super SupportSQLiteDatabase, u> migrateCallback) {
        super(i2, i3);
        s.h(migrateCallback, "migrateCallback");
        this.migrateCallback = migrateCallback;
    }

    public final l<SupportSQLiteDatabase, u> getMigrateCallback() {
        return this.migrateCallback;
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase database) {
        s.h(database, "database");
        this.migrateCallback.invoke(database);
    }
}
