package kotlin.io;

import java.io.File;
import java.io.IOException;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
/* compiled from: Utils.kt */
/* loaded from: classes3.dex */
final class FilesKt__UtilsKt$copyRecursively$1 extends Lambda implements p {
    public static final FilesKt__UtilsKt$copyRecursively$1 INSTANCE = new FilesKt__UtilsKt$copyRecursively$1();

    FilesKt__UtilsKt$copyRecursively$1() {
        super(2);
    }

    @Override // kotlin.jvm.b.p
    public final Void invoke(File file, IOException exception) {
        s.h(file, "<anonymous parameter 0>");
        s.h(exception, "exception");
        throw exception;
    }
}
