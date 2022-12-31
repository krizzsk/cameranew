package d.f.a.b;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* compiled from: IoUtils.java */
/* loaded from: classes3.dex */
public final class c {

    /* compiled from: IoUtils.java */
    /* loaded from: classes3.dex */
    public interface a {
        boolean a(int i2, int i3);
    }

    public static void a(Closeable closeable) {
        try {
            closeable.close();
        } catch (Exception unused) {
        }
    }

    public static boolean b(InputStream inputStream, OutputStream outputStream, a aVar) throws IOException {
        return c(inputStream, outputStream, aVar, 32768);
    }

    public static boolean c(InputStream inputStream, OutputStream outputStream, a aVar, int i2) throws IOException {
        int available = inputStream.available();
        if (available <= 0) {
            available = 512000;
        }
        byte[] bArr = new byte[i2];
        if (e(aVar, 0, available)) {
            return false;
        }
        int i3 = 0;
        do {
            int read = inputStream.read(bArr, 0, i2);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
                i3 += read;
            } else {
                outputStream.flush();
                return true;
            }
        } while (!e(aVar, i3, available));
        return false;
    }

    public static void d(InputStream inputStream) {
        do {
            try {
            } catch (IOException unused) {
            } catch (Throwable th) {
                a(inputStream);
                throw th;
            }
        } while (inputStream.read(new byte[32768], 0, 32768) != -1);
        a(inputStream);
    }

    private static boolean e(a aVar, int i2, int i3) {
        return (aVar == null || aVar.a(i2, i3) || (i2 * 100) / i3 >= 75) ? false : true;
    }
}
