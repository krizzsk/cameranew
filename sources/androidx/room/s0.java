package androidx.room;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteDatabase;
/* compiled from: lambda */
/* loaded from: classes.dex */
public final /* synthetic */ class s0 implements Function {
    public static final /* synthetic */ s0 a = new s0();

    private /* synthetic */ s0() {
    }

    @Override // androidx.arch.core.util.Function
    public final Object apply(Object obj) {
        return Long.valueOf(((SupportSQLiteDatabase) obj).getPageSize());
    }
}
