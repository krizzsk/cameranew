package androidx.room;

import androidx.arch.core.util.Function;
import androidx.room.AutoClosingRoomOpenHelper;
import androidx.sqlite.db.SupportSQLiteDatabase;
/* compiled from: lambda */
/* loaded from: classes.dex */
public final /* synthetic */ class s implements Function {
    public static final /* synthetic */ s a = new s();

    private /* synthetic */ s() {
    }

    @Override // androidx.arch.core.util.Function
    public final Object apply(Object obj) {
        return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.m((SupportSQLiteDatabase) obj);
    }
}
