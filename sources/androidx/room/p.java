package androidx.room;

import androidx.arch.core.util.Function;
import androidx.room.AutoClosingRoomOpenHelper;
import androidx.sqlite.db.SupportSQLiteDatabase;
/* compiled from: lambda */
/* loaded from: classes.dex */
public final /* synthetic */ class p implements Function {
    public static final /* synthetic */ p a = new p();

    private /* synthetic */ p() {
    }

    @Override // androidx.arch.core.util.Function
    public final Object apply(Object obj) {
        return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.i((SupportSQLiteDatabase) obj);
    }
}
