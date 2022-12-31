package androidx.room;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteStatement;
/* compiled from: lambda */
/* loaded from: classes.dex */
public final /* synthetic */ class u implements Function {
    public static final /* synthetic */ u a = new u();

    private /* synthetic */ u() {
    }

    @Override // androidx.arch.core.util.Function
    public final Object apply(Object obj) {
        return ((SupportSQLiteStatement) obj).execute();
    }
}
