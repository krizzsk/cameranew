package androidx.core.util;

import androidx.annotation.RequiresApi;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import kotlin.text.d;
import kotlin.u;
/* compiled from: AtomicFile.kt */
/* loaded from: classes.dex */
public final class AtomicFileKt {
    @RequiresApi(17)
    public static final byte[] readBytes(android.util.AtomicFile atomicFile) {
        s.h(atomicFile, "<this>");
        byte[] readFully = atomicFile.readFully();
        s.g(readFully, "readFully()");
        return readFully;
    }

    @RequiresApi(17)
    public static final String readText(android.util.AtomicFile atomicFile, Charset charset) {
        s.h(atomicFile, "<this>");
        s.h(charset, "charset");
        byte[] readFully = atomicFile.readFully();
        s.g(readFully, "readFully()");
        return new String(readFully, charset);
    }

    public static /* synthetic */ String readText$default(android.util.AtomicFile atomicFile, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = d.a;
        }
        return readText(atomicFile, charset);
    }

    @RequiresApi(17)
    public static final void tryWrite(android.util.AtomicFile atomicFile, l<? super FileOutputStream, u> block) {
        s.h(atomicFile, "<this>");
        s.h(block, "block");
        FileOutputStream stream = atomicFile.startWrite();
        try {
            s.g(stream, "stream");
            block.invoke(stream);
            r.b(1);
            atomicFile.finishWrite(stream);
            r.a(1);
        } catch (Throwable th) {
            r.b(1);
            atomicFile.failWrite(stream);
            r.a(1);
            throw th;
        }
    }

    @RequiresApi(17)
    public static final void writeBytes(android.util.AtomicFile atomicFile, byte[] array) {
        s.h(atomicFile, "<this>");
        s.h(array, "array");
        FileOutputStream stream = atomicFile.startWrite();
        try {
            s.g(stream, "stream");
            stream.write(array);
            atomicFile.finishWrite(stream);
        } catch (Throwable th) {
            atomicFile.failWrite(stream);
            throw th;
        }
    }

    @RequiresApi(17)
    public static final void writeText(android.util.AtomicFile atomicFile, String text, Charset charset) {
        s.h(atomicFile, "<this>");
        s.h(text, "text");
        s.h(charset, "charset");
        byte[] bytes = text.getBytes(charset);
        s.g(bytes, "(this as java.lang.String).getBytes(charset)");
        writeBytes(atomicFile, bytes);
    }

    public static /* synthetic */ void writeText$default(android.util.AtomicFile atomicFile, String str, Charset charset, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            charset = d.a;
        }
        writeText(atomicFile, str, charset);
    }
}
