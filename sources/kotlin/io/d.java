package kotlin.io;

import java.io.ByteArrayOutputStream;
import kotlin.jvm.internal.s;
/* compiled from: FileReadWrite.kt */
/* loaded from: classes3.dex */
final class d extends ByteArrayOutputStream {
    public d(int i2) {
        super(i2);
    }

    public final byte[] d() {
        byte[] buf = ((ByteArrayOutputStream) this).buf;
        s.g(buf, "buf");
        return buf;
    }
}
