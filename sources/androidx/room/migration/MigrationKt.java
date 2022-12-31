package androidx.room.migration;

import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: Migration.kt */
/* loaded from: classes.dex */
public final class MigrationKt {
    public static final Migration Migration(int i2, int i3, l<? super SupportSQLiteDatabase, u> migrate) {
        s.h(migrate, "migrate");
        return new MigrationImpl(i2, i3, migrate);
    }
}
