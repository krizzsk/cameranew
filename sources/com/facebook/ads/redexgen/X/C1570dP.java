package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.dP  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1570dP implements AnonymousClass03<Bitmap> {
    public static byte[] A06;
    public static String[] A07 = {"O8BWLXPdzHA", "6sEzkrKiC7tSlAyzako7Jr1QeLTjq7r7", "buIAODYM5Oo034kKCIV4I7ZzRqvLqiIh", "ENOGp8Grp5cb6hByXNSQMpF2JyONyocp", "tnh", "2Zn0DxkDz4CuR43sN", "3j1ga9q4MlHQ2cRzMN", "NuleDR7CXAFlpWhCDunnHJWIhrQ2pSEs"};
    public final int A00;
    public final int A01;
    public final String A02 = C1570dP.class.getSimpleName();
    public final boolean A03;
    public final boolean A04;
    public final boolean A05;

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A06, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            byte b = (byte) ((copyOfRange[i5] ^ i4) ^ 8);
            if (A07[7].charAt(0) == 'p') {
                throw new RuntimeException();
            }
            A07[6] = "rTtdlTA5qc3UePbll3p";
            copyOfRange[i5] = b;
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        if (A07[4].length() != 3) {
            throw new RuntimeException();
        }
        A07[6] = "j2OKbozXXbIBudrsn6AX9zPsXXh";
        A06 = new byte[]{1, 91, 66, 95, 7, 44, 49, 40, 36, 53, 101, 44, 54, 101, 43, 48, 41, 41, 124, 65, 90, 92, 73, 77, 80, 86, 87, 25, 93, 76, 75, 80, 87, 94, 25, 95, 80, 85, 92, 25, 90, 86, 84, 73, 75, 92, 74, 74, 80, 86, 87};
    }

    static {
        A02();
    }

    public C1570dP(int i2, int i3, boolean z, boolean z2, boolean z3) {
        this.A01 = i2;
        this.A00 = i3;
        this.A05 = z;
        this.A03 = z2;
        this.A04 = z3;
    }

    public static AnonymousClass02<Bitmap> A00(Throwable th) {
        return new AnonymousClass02<>(false, null, th);
    }

    private void A03(File file, @Nullable Bitmap bitmap) throws IOException {
        if (bitmap == null) {
            return;
        }
        ByteArrayOutputStream byteArrayOutputStream = null;
        FileOutputStream fileOutputStream = null;
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            if (byteArrayOutputStream.size() >= 3145728) {
                return;
            }
            String str = file.getCanonicalPath() + A01(0, 4, 39);
            File file2 = new File(str);
            file2.createNewFile();
            fileOutputStream = new FileOutputStream(str);
            byteArrayOutputStream.writeTo(fileOutputStream);
            fileOutputStream.flush();
            fileInputStream = new FileInputStream(str);
            fileOutputStream2 = new FileOutputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    fileOutputStream2.write(bArr, 0, read);
                } else {
                    file2.delete();
                    return;
                }
            }
        } finally {
            C0M.A07(byteArrayOutputStream);
            C0M.A07(fileOutputStream);
            C0M.A07(fileInputStream);
            C0M.A07(fileOutputStream2);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass03
    @SuppressLint({"CatchGeneralException"})
    public final AnonymousClass02<Bitmap> A39(File file, C0L c0l) {
        if (!this.A04) {
            return new AnonymousClass02<>(true, null);
        }
        try {
            Bitmap A03 = C0M.A03(file.getCanonicalPath(), this.A01, this.A00, this.A05);
            if (A03 != null) {
                return new AnonymousClass02<>(true, A03);
            }
            c0l.A8j(new C1564dJ(A01(4, 14, 77)));
            return A00(null);
        } catch (Throwable th) {
            if (A07[6].length() != 26) {
                String[] strArr = A07;
                strArr[2] = "Rre6UfQ4j0qmCPYEhTx2DnaeM5gEursB";
                strArr[1] = "Gg2NoIsyPtMRdLQD2TdVPdh2XNeZHi6S";
                file.delete();
                c0l.A8j(th);
                return A00(th);
            }
            throw new RuntimeException();
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass03
    @SuppressLint({"CatchGeneralException"})
    public final void A49(File file, C0L c0l) throws C1564dJ {
        if (this.A03) {
            try {
                Bitmap A03 = C0M.A03(file.getCanonicalPath(), this.A01, this.A00, this.A05);
                if (A03 != null) {
                    A03(file, A03);
                } else {
                    file.delete();
                    throw new C1564dJ(A01(4, 14, 77));
                }
            } catch (C1564dJ e2) {
                c0l.A8u(e2);
                throw e2;
            } catch (Throwable th) {
                c0l.A8u(th);
                throw new C1564dJ(A01(18, 33, 49), th);
            }
        }
    }
}
