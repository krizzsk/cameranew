package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Nullable;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.HashMap;
@SuppressLint({"StringFormatUse", "SharedPreferencesUse"})
/* renamed from: com.facebook.ads.redexgen.X.74  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class AnonymousClass74 {
    public static AnonymousClass74 A01;
    public static byte[] A02;
    public static String[] A03 = {"rLDjBgKz63Bn2bjdq5T9imrieVp5PIBM", "m8wp0Vw9GL6Om21Qq8m8Tj5zfu0l", "YgqNWwRBt3ccTC8L8vt9EnrOaTNX", "Ji4mlDElrKKLO0fU8k8hI0n9H2FXwyxW", "wf5MYK5ehGzLy7SkBsWbSYGwiXhb8bxZ", "VWIuBm7xkqaJ1AqGCIKfvhlqUEnKMMIs", "Q1uyQO5SpdafJkDIvdpZDIFmVDRWB0Ou", "30w5jfTvH5e90EUSXrOKs1RMT2PDXB24"};
    public final HashMap<Integer, String> A00 = new HashMap<>();

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 4);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A02 = new byte[]{103, 114, 116, -70};
    }

    static {
        A03();
    }

    @SuppressLint({"CatchGeneralException"})
    public AnonymousClass74(Context context, EnumC06396o enumC06396o, @Nullable String str) {
        try {
            A04(context);
            if (enumC06396o.A04() == EnumC06396o.A0G.A04()) {
                A05(context, str);
            }
        } catch (Throwable th) {
            C6D.A03(th);
        }
    }

    public static AnonymousClass74 A00(Context context, EnumC06396o enumC06396o, @Nullable String str) {
        if (A01 == null) {
            A01 = new AnonymousClass74(context, enumC06396o, str);
        }
        return A01;
    }

    public static String A02(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        int length = bArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            sb.append(String.format(A01(0, 4, 62), Byte.valueOf(bArr[i2])));
        }
        String sb2 = sb.toString();
        String[] strArr = A03;
        if (strArr[5].charAt(8) != strArr[6].charAt(8)) {
            A03[0] = "YeSBMNELIt08AqlHIfsrA8EpBPFL6cGm";
            return sb2;
        }
        throw new RuntimeException();
    }

    private void A04(Context context) throws Exception {
        int read;
        BufferedInputStream bufferedInputStream = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(new File(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.publicSourceDir)), 1024);
            MessageDigest messageDigest = MessageDigest.getInstance(AnonymousClass77.A04.A02());
            MessageDigest messageDigest2 = MessageDigest.getInstance(AnonymousClass77.A05.A02());
            MessageDigest messageDigest3 = MessageDigest.getInstance(AnonymousClass77.A06.A02());
            byte[] bArr = new byte[1024];
            do {
                read = bufferedInputStream.read(bArr);
                if (read > 0) {
                    messageDigest.update(bArr, 0, read);
                    messageDigest2.update(bArr, 0, read);
                    messageDigest3.update(bArr, 0, read);
                }
                if (A03[7].charAt(26) != 'P') {
                    throw new RuntimeException();
                }
                A03[7] = "sHaOy6LtIlfUQKDjNh2L68IGHQPvVrDu";
            } while (read != -1);
            this.A00.put(10003, A02(messageDigest.digest()));
            this.A00.put(10004, A02(messageDigest2.digest()));
            this.A00.put(10005, A02(messageDigest3.digest()));
            bufferedInputStream.close();
        } catch (Throwable th) {
            String[] strArr = A03;
            if (strArr[4].charAt(30) != strArr[3].charAt(30)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A03;
            strArr2[5] = "XS9zpWe4kggJPLQjl3jzxSvjjqaK1CvG";
            strArr2[6] = "1gkHVsehFegipbXpJD0YhFUDmEZYz3Bw";
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            throw th;
        }
    }

    private void A05(Context context, @Nullable String str) throws Throwable {
        int read;
        if (str == null || str.isEmpty()) {
            return;
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(context.getAssets().open(str), 1024);
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(AnonymousClass77.A04.A02());
            byte[] bArr = new byte[1024];
            do {
                read = bufferedInputStream.read(bArr);
                if (read > 0) {
                    messageDigest.update(bArr, 0, read);
                }
            } while (read != -1);
            this.A00.put(10010, A02(messageDigest.digest()));
            bufferedInputStream.close();
        } catch (Throwable th) {
            try {
                bufferedInputStream.close();
            } catch (Throwable unused) {
            }
            throw th;
        }
    }

    @Nullable
    public final String A06(int i2) {
        String str = this.A00.get(Integer.valueOf(i2));
        if (str != null) {
            return str;
        }
        return null;
    }
}
