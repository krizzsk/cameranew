package androidx.room;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteStatement;
/* compiled from: lambda */
/* loaded from: classes.dex */
public final /* synthetic */ class y0 implements Function {
    public static final /* synthetic */ y0 a = new y0();

    private /* synthetic */ y0() {
    }

    @Override // androidx.arch.core.util.Function
    public final Object apply(Object obj) {
        return Integer.valueOf(((SupportSQLiteStatement) obj).executeUpdateDelete());
    }
}
