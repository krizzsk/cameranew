package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.MimeTypeMap;
import androidx.annotation.Nullable;
import java.io.Closeable;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Locale;
/* renamed from: com.facebook.ads.redexgen.X.0I  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C0I {
    public static byte[] A00;
    public static String[] A01 = {"QXuoBnzEZEqlDLe5TpAidegf9xy2rJp2", "7apJybU8hnrRo", "EvQoHUlErOdPjfZNSaWf5ex2DDXDJXA1", "LIt45BVzQE0lSVvxtilRjadurhGFSSrG", "9jmWu3moBjPGR65ZxocrWcXRtVvlqMhB", "hX1BVtAkwY1", "CWSYCufe5irzp", "Wu9WCcWe3gi"};
    public static final String A02;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        int i5 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A01;
            if (strArr[6].length() != strArr[1].length()) {
                throw new RuntimeException();
            }
            A01[4] = "LolPYNkjpkoFXTyLy0qz6zydFiEDgDZo";
            if (i5 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 57);
            i5++;
        }
    }

    public static void A04() {
        A00 = new byte[]{118, -127, -125, -55, -71, -26, -26, -29, -26, -108, -41, -32, -29, -25, -35, -30, -37, -108, -26, -39, -25, -29, -23, -26, -41, -39, -49, -58, -73};
    }

    static {
        A04();
        A02 = C0I.class.getSimpleName();
    }

    @Nullable
    public static String A01(String str) {
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if (TextUtils.isEmpty(fileExtensionFromUrl)) {
            return null;
        }
        return singleton.getMimeTypeFromExtension(fileExtensionFromUrl);
    }

    public static String A02(String str) {
        try {
            return A03(MessageDigest.getInstance(A00(26, 3, 73)).digest(str.getBytes()));
        } catch (NoSuchAlgorithmException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static String A03(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            stringBuffer.append(String.format(Locale.US, A00(0, 4, 24), Byte.valueOf(b)));
        }
        return stringBuffer.toString();
    }

    public static void A05(@Nullable Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
                String str = A02;
                String A002 = A00(4, 22, 59);
                if (A01[4].charAt(22) == 'e') {
                    throw new RuntimeException();
                }
                String[] strArr = A01;
                strArr[6] = "hmoa1I9H2M6aQ";
                strArr[1] = "N2TaSuAno7v4j";
                Log.e(str, A002, e2);
            }
        }
    }
}
