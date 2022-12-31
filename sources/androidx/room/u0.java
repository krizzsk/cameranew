package androidx.room;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteStatement;
/* compiled from: lambda */
/* loaded from: classes.dex */
public final /* synthetic */ class u0 implements Function {
    public static final /* synthetic */ u0 a = new u0();

    private /* synthetic */ u0() {
    }

    @Override // androidx.arch.core.util.Function
    public final Object apply(Object obj) {
        return Long.valueOf(((SupportSQLiteStatement) obj).executeInsert());
    }
}
