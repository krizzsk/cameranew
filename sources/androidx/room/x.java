package androidx.room;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteStatement;
/* compiled from: lambda */
/* loaded from: classes.dex */
public final /* synthetic */ class x implements Function {
    public static final /* synthetic */ x a = new x();

    private /* synthetic */ x() {
    }

    @Override // androidx.arch.core.util.Function
    public final Object apply(Object obj) {
        return ((SupportSQLiteStatement) obj).simpleQueryForString();
    }
}
