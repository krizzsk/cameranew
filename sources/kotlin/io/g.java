package kotlin.io;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import kotlin.collections.m;
import kotlin.jvm.internal.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FileReadWrite.kt */
/* loaded from: classes3.dex */
public class g extends f {
    public static byte[] a(File file) {
        s.h(file, "<this>");
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            long length = file.length();
            if (length <= 2147483647L) {
                int i2 = (int) length;
                byte[] bArr = new byte[i2];
                int i3 = i2;
                int i4 = 0;
                while (i3 > 0) {
                    int read = fileInputStream.read(bArr, i4, i3);
                    if (read < 0) {
                        break;
                    }
                    i3 -= read;
                    i4 += read;
                }
                if (i3 > 0) {
                    bArr = Arrays.copyOf(bArr, i4);
                    s.g(bArr, "copyOf(this, newSize)");
                } else {
                    int read2 = fileInputStream.read();
                    if (read2 != -1) {
                        d dVar = new d(8193);
                        dVar.write(read2);
                        a.b(fileInputStream, dVar, 0, 2, null);
                        int size = dVar.size() + i2;
                        if (size >= 0) {
                            byte[] d2 = dVar.d();
                            bArr = Arrays.copyOf(bArr, size);
                            s.g(bArr, "copyOf(this, newSize)");
                            m.c(d2, bArr, i2, 0, dVar.size());
                        } else {
                            throw new OutOfMemoryError("File " + file + " is too big to fit in memory.");
                        }
                    }
                }
                b.a(fileInputStream, null);
                return bArr;
            }
            throw new OutOfMemoryError("File " + file + " is too big (" + length + " bytes) to fit in memory.");
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                b.a(fileInputStream, th);
                throw th2;
            }
        }
    }
}
