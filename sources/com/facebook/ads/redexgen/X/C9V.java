package com.facebook.ads.redexgen.X;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Locale;
/* renamed from: com.facebook.ads.redexgen.X.9V  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C9V implements Closeable {
    public static byte[] A03;
    public static String[] A04 = {"SDO1JVQRVztc05U6wH4HJTiF5V86WLZV", "JUkWBi3mNnUEcI1zFAO0icxdG8wRWdD7", "QP9Vd5zf9OYRCERvVtyUemXpYBL6EKiE", "xOOYiIXMxQksUvny4QEKcKXl4UDniIsU", "x87Ktc1IWjLpjjicmuhI7Z2IzrOHGBC3", "WGZ", "wfI1QUU7hCcnQ3hBelCxr5juQnjBiotI", "E2gfbhu1TU9ChELgnqQ3ne7CNBbav8TU"};
    public C9W A00;
    public boolean A01;
    public final RandomAccessFile A02;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            byte b = copyOfRange[i5];
            if (A04[5].length() != 3) {
                throw new RuntimeException();
            }
            A04[6] = "pH7cradwiFTKLrbheOx3UovjSmwH9sX8";
            copyOfRange[i5] = (byte) ((b ^ i4) ^ 38);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{95, 105, 110, 111, 115, 110, 90, 117, 112, 121, 60, 117, 111, 60, 125, 112, 110, 121, 125, 120, 101, 60, Byte.MAX_VALUE, 112, 115, 111, 121, 120, 15, 40, 48, 39, 42, 47, 34, 102, 54, 41, 53, 47, 50, 47, 41, 40, 124, 102, 110, 99, 34, 106, 99, 34, 111, 94, 91, 95};
    }

    static {
        A02();
    }

    public C9V(File file) throws IOException {
        this.A02 = new RandomAccessFile(file, A00(53, 3, 10));
        if (this.A02.length() != 8) {
            this.A02.setLength(8L);
            this.A00 = new C9W(0, 0);
            A01();
            return;
        }
        int readInt = this.A02.readInt();
        int readInt2 = this.A02.readInt();
        if (readInt < 0 || readInt2 < 0) {
            readInt = 0;
            readInt2 = 0;
        }
        this.A00 = new C9W(readInt, readInt2);
    }

    private void A01() throws IOException {
        this.A02.seek(0L);
        this.A02.writeInt(this.A00.A02());
        this.A02.writeInt(this.A00.A03());
        this.A02.getFD().sync();
    }

    public final C9W A03() throws IOException {
        if (!this.A01) {
            return this.A00;
        }
        throw new IOException(A00(0, 28, 58));
    }

    public final void A04(C9W c9w) throws IOException {
        if (!this.A01) {
            if (c9w.A02() >= 0 && c9w.A03() >= 0) {
                this.A00 = c9w;
                A01();
                return;
            }
            throw new IOException(String.format(Locale.US, A00(28, 25, 96), Integer.valueOf(c9w.A02()), Integer.valueOf(c9w.A03())));
        }
        throw new IOException(A00(0, 28, 58));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.A01) {
            return;
        }
        this.A01 = true;
        this.A02.close();
    }
}
