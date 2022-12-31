package com.facebook.ads.redexgen.X;

import android.util.Log;
import androidx.annotation.NonNull;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class I7 extends OutputStream {
    public static byte[] A02;
    public boolean A00 = false;
    public final FileOutputStream A01;

    static {
        A01();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 68);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{-66, -15, -20, -22, -26, -32, -61, -26, -23, -30, -59, -32, -24, -21, -28, -29, -97, -13, -18, -97, -14, -8, -19, -30, -97, -27, -24, -21, -28, -97, -29, -28, -14, -30, -15, -24, -17, -13, -18, -15, -71};
    }

    public I7(File file) throws FileNotFoundException {
        this.A01 = new FileOutputStream(file);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.A00) {
            return;
        }
        this.A00 = true;
        flush();
        try {
            this.A01.getFD().sync();
        } catch (IOException e2) {
            Log.w(A00(0, 10, 57), A00(10, 31, 59), e2);
        }
        this.A01.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() throws IOException {
        this.A01.flush();
    }

    @Override // java.io.OutputStream
    public final void write(int i2) throws IOException {
        this.A01.write(i2);
    }

    @Override // java.io.OutputStream
    public final void write(@NonNull byte[] bArr) throws IOException {
        this.A01.write(bArr);
    }

    @Override // java.io.OutputStream
    public final void write(@NonNull byte[] bArr, int i2, int i3) throws IOException {
        this.A01.write(bArr, i2, i3);
    }
}
