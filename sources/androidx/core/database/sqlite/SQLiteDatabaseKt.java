package androidx.core.database.sqlite;

import android.database.sqlite.SQLiteDatabase;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
/* compiled from: SQLiteDatabase.kt */
/* loaded from: classes.dex */
public final class SQLiteDatabaseKt {
    public static final <T> T transaction(SQLiteDatabase sQLiteDatabase, boolean z, l<? super SQLiteDatabase, ? extends T> body) {
        s.h(sQLiteDatabase, "<this>");
        s.h(body, "body");
        if (z) {
            sQLiteDatabase.beginTransaction();
        } else {
            sQLiteDatabase.beginTransactionNonExclusive();
        }
        try {
            T invoke = body.invoke(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
            return invoke;
        } finally {
            r.b(1);
            sQLiteDatabase.endTransaction();
            r.a(1);
        }
    }

    public static /* synthetic */ Object transaction$default(SQLiteDatabase sQLiteDatabase, boolean z, l body, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        s.h(sQLiteDatabase, "<this>");
        s.h(body, "body");
        if (z) {
            sQLiteDatabase.beginTransaction();
        } else {
            sQLiteDatabase.beginTransactionNonExclusive();
        }
        try {
            Object invoke = body.invoke(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
            return invoke;
        } finally {
            r.b(1);
            sQLiteDatabase.endTransaction();
            r.a(1);
        }
    }
}
