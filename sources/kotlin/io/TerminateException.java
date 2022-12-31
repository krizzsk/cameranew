package kotlin.io;

import java.io.File;
import kotlin.jvm.internal.s;
/* compiled from: Utils.kt */
/* loaded from: classes3.dex */
final class TerminateException extends FileSystemException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TerminateException(File file) {
        super(file, null, null, 6, null);
        s.h(file, "file");
    }
}
