package androidx.room;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteDatabase;
/* compiled from: lambda */
/* loaded from: classes.dex */
public final /* synthetic */ class e implements Function {
    public static final /* synthetic */ e a = new e();

    private /* synthetic */ e() {
    }

    @Override // androidx.arch.core.util.Function
    public final Object apply(Object obj) {
        return ((SupportSQLiteDatabase) obj).getPath();
    }
}
