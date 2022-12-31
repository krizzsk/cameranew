package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.util.Base64;
import java.io.File;
import java.security.spec.InvalidParameterSpecException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* renamed from: com.facebook.ads.redexgen.X.76  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class AnonymousClass76 {
    public static byte[] A00;
    public static String[] A01 = {"eFrFuMkSf6MHcof7LOi6YZLllbM352nJ", "mAvGXXYFupd5OuM4XCWCl6Ymf1L0CYcu", "NOO30l6olRO1IZ4LfmYkunta1od", "bvzGMF7Q1FtgEXIkORXr7PxZ7BJPLsgM", "hXdYhHbEFyr1sbwxo", "3nkhTPKg5suoqFFED69qNRFImDpUoi1X", "AqSvMoRqc6BrPHC1U9YSDW7FElWr0vU0", "cACdptFygePFXCUb5rEKoIEmqMGQ4nRx"};

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            byte b = (byte) ((copyOfRange[i5] ^ i4) ^ 80);
            if (A01[6].charAt(16) != 'U') {
                throw new RuntimeException();
            }
            A01[7] = "4KTBK77LN1KTDos5IeArWQYcubpfVnlF";
            copyOfRange[i5] = b;
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{75, 101, 102, 126, 111, 96, 122, 97, 115, 114, 115, 26, 61, 37, 50, 63, 58, 55, 115, 26, 5, 98, 69, 93, 74, 71, 66, 79, 11, 98, 69, 91, 94, 95, 71, 96, 120, 111, 98, 103, 106, 46, 66, 107, 96, 105, 122, 102, 17, 42, 51, 51, Byte.MAX_VALUE, 29, 27, Byte.MAX_VALUE, 12, 58, 44, 44, 54, 48, 49, Byte.MAX_VALUE, 22, 59, 33, 58, 50, 34, 68, 33, 16, 21, 21, 24, 31, 22, 69, 101, 92, 90};
    }

    static {
        A03();
    }

    @SuppressLint({"CatchGeneralException", "BadMethodUse-java.lang.String.length"})
    public static String A01(String str, String str2) {
        try {
            String[] split = str2.split(A00(78, 2, 73));
            if (split != null && split.length != 0) {
                String str3 = split[split.length - 1];
                if (str3.length() == 16) {
                    return A02(str, str3);
                }
                throw new InvalidParameterSpecException(A00(34, 14, 94));
            }
            throw new IllegalArgumentException(A00(48, 18, 15));
        } catch (Throwable th) {
            C6D.A03(th);
            String A002 = A00(80, 2, 119);
            String[] strArr = A01;
            if (strArr[4].length() != strArr[2].length()) {
                String[] strArr2 = A01;
                strArr2[0] = "q1rcyONSgbGNz9bqB8WSs99USD9RjoFj";
                strArr2[5] = "jIC3cCNXapYytCTk8CpXHStINYfHDphY";
                return A002;
            }
            throw new RuntimeException();
        }
    }

    @SuppressLint({"TrulyRandom", "BadMethodUse-java.lang.String.length"})
    public static String A02(String str, String str2) throws Throwable {
        if (str != null && str2 != null && !str.isEmpty() && !str2.isEmpty()) {
            int length = str2.length();
            StringBuilder sb = new StringBuilder();
            String A002 = A00(0, 8, 89);
            sb.append(A002);
            sb.append(File.separatorChar);
            sb.append(A00(8, 3, 96));
            sb.append(File.separatorChar);
            sb.append(A00(66, 12, 33));
            Cipher cipher = Cipher.getInstance(sb.toString());
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), A002);
            byte[] ivBytes = A04(str2.substring(0, length / 2).getBytes(), str2.substring(length / 2, length).getBytes());
            cipher.init(1, secretKeySpec, new IvParameterSpec(ivBytes));
            byte[] ivBytes2 = str.getBytes();
            return Base64.encodeToString(cipher.doFinal(ivBytes2), 0);
        }
        throw new IllegalArgumentException(A00(21, 13, 123));
    }

    public static byte[] A04(byte[] result, byte[] bArr) throws NullPointerException {
        if (result != null && bArr != null && result.length == bArr.length) {
            byte[] bArr2 = new byte[result.length];
            for (int i2 = 0; i2 < result.length; i2++) {
                bArr2[i2] = (byte) (result[i2] ^ bArr[i2]);
            }
            return bArr2;
        }
        throw new NullPointerException(A00(11, 10, 3));
    }
}
