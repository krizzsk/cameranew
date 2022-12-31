package kotlin.io;

import java.io.File;
import java.io.IOException;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: Utils.kt */
/* loaded from: classes3.dex */
final class FilesKt__UtilsKt$copyRecursively$2 extends Lambda implements p<File, IOException, u> {
    final /* synthetic */ p<File, IOException, OnErrorAction> $onError;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    FilesKt__UtilsKt$copyRecursively$2(p<? super File, ? super IOException, ? extends OnErrorAction> pVar) {
        super(2);
        this.$onError = pVar;
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ u invoke(File file, IOException iOException) {
        invoke2(file, iOException);
        return u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(File f2, IOException e2) {
        s.h(f2, "f");
        s.h(e2, "e");
        if (this.$onError.invoke(f2, e2) == OnErrorAction.TERMINATE) {
            throw new TerminateException(f2);
        }
    }
}
