package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import androidx.annotation.Nullable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Ot  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1078Ot extends InputStream {
    public static byte[] A04;
    public static String[] A05 = {"5FxkjmViipfuOEmeGZRh1rWuAhi58BIY", "P0uDFh8HOwAWvDVGkGeATzc", "FQ2HPVuJ9Fju5P7EfteSFhbDkCSiUGCr", "lMnDCDrcSzZtU6RMhKfYe1rO633Hkzz8", "BZaCeAJ4mpNw1z6aTzzGkvXJAvKgKDg7", "gl5vlYV0aCgrCc0s0sEnhviYHRKbo8Yg", "Tgc0UJMQxUN8PgOF6KJ9ZKrej2a3tpw", "OSPCme8ftb56UzOVrw2bgiBSvmZFYlRk"};
    @Nullable
    public MessageDigest A00;
    public final XS A01;
    public final InterfaceC1077Os A02;
    public final FileInputStream A03;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i2, i2 + i3);
        int i5 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A05[7].charAt(24) == 'i') {
                break;
            }
            A05[7] = "wkBtkBfOXubsKwfKzYpxBJzZI93GSJMw";
            if (i5 >= length) {
                return new String(copyOfRange);
            }
            byte b = copyOfRange[i5];
            String[] strArr = A05;
            if (strArr[0].charAt(11) == strArr[3].charAt(11)) {
                break;
            }
            String[] strArr2 = A05;
            strArr2[1] = "6MRboz4pfSS0DylRcsmX7nz";
            strArr2[6] = "Z3yJOYkAPU5AGas9ZlGFYfEzislvm9u";
            copyOfRange[i5] = (byte) ((b - i4) - 45);
            i5++;
        }
        throw new RuntimeException();
    }

    public static void A01() {
        A04 = new byte[]{-104, -113, Byte.MIN_VALUE, 11, 26, 19};
    }

    static {
        A01();
    }

    public C1078Ot(XS xs, FileInputStream fileInputStream, InterfaceC1077Os interfaceC1077Os) {
        this.A03 = fileInputStream;
        this.A02 = interfaceC1077Os;
        this.A01 = xs;
        try {
            this.A00 = MessageDigest.getInstance(A00(0, 3, 30));
        } catch (NoSuchAlgorithmException unused) {
            this.A00 = null;
        }
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        return this.A03.available();
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        return read(new byte[1]);
    }

    @Override // java.io.InputStream
    @SuppressLint({"CatchGeneralException"})
    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        int read = this.A03.read(bArr, i2, i3);
        MessageDigest messageDigest = this.A00;
        if (messageDigest != null) {
            if (A05[7].charAt(24) == 'i') {
                throw new RuntimeException();
            }
            A05[2] = "wFnf9K6AarqF2rYbRIkm3wGElU25UaCd";
            try {
                if (read > 0) {
                    messageDigest.update(bArr, i2, read);
                } else if (read == -1) {
                    this.A02.A7z(C0987Lb.A05(messageDigest.digest()));
                    this.A00 = null;
                }
            } catch (Exception e2) {
                this.A00 = null;
                this.A01.A06().A98(A00(3, 3, 122), C06808m.A0t, new C06818n(e2));
            }
        }
        return read;
    }

    @Override // java.io.InputStream
    public final long skip(long j2) throws IOException {
        int i2 = (int) j2;
        byte[] bArr = new byte[1024];
        long j3 = 0;
        while (i2 > 0) {
            int read = read(bArr, 0, Math.min(i2, 1024));
            if (read <= 0) {
                break;
            }
            i2 -= read;
            j3 += read;
        }
        return j3;
    }
}
