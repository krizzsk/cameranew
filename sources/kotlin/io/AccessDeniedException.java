package kotlin.io;

import java.io.File;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
/* compiled from: Exceptions.kt */
/* loaded from: classes3.dex */
public final class AccessDeniedException extends FileSystemException {
    public /* synthetic */ AccessDeniedException(File file, File file2, String str, int i2, o oVar) {
        this(file, (i2 & 2) != 0 ? null : file2, (i2 & 4) != 0 ? null : str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccessDeniedException(File file, File file2, String str) {
        super(file, file2, str);
        s.h(file, "file");
    }
}
