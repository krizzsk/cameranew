package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.0u  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C04910u {
    public static C04900t A00;
    public static C8J A01;
    @Nullable
    public static String A02;
    public static CountDownLatch A03;
    public static CountDownLatch A04;
    public static boolean A05;
    public static byte[] A06;
    public static String[] A07 = {"TOlR5WIHpQxnCrBDCJGIvboS5c1GP2eb", "1A072KPTjzB", "BhIKZU0mEosMUOfZes2VT64q11XJ2Uhn", "3eQHzZddeWPmYl0bNsvnb2WjxREMTE8a", "x", "3ukMDhdDleVgfGP2GHVzNRiRwZbG92ZS", "tXOxwX9vQ8QECIpzr41AiGeD6LbiHgO3", "feL0RS1gsJrC9VyxtC"};
    public static final String A08;

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A06, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 69);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        byte[] bArr = {114, 115, 97, 10, 31, 123, 125, 3, 6, 17, 33, 3, 18, 18, 11, 12, 5, 43, 12, 4, Draft_75.CR, 76, 22, 26, 22, 32, 34, 51, 51, 38, 39, 2, 39, 48, 109, 55, 59, 55, Draft_75.CR, 25, 14, 26, 30, 14, 5, 8, 18, 52, 8, 10, 27, 27, 2, 5, 12};
        if (A07[0].charAt(25) == 's') {
            throw new RuntimeException();
        }
        A07[6] = "ekiMbk44dvQ4iEpOly1MsU0Tkyq5eij5";
        A06 = bArr;
    }

    static {
        A04();
        A08 = C04910u.class.getSimpleName();
        A03 = new CountDownLatch(1);
        A04 = new CountDownLatch(1);
    }

    public static String A00() {
        C04900t c04900t = A00;
        return c04900t != null ? c04900t.A02() : A01(5, 2, 101);
    }

    public static String A02(String str) {
        String A012 = A01(38, 17, 46);
        File file = new File(A01.getFilesDir(), str);
        String A013 = A01(0, 0, 103);
        if (file.exists() && file.length() > 0) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[(int) file.length()];
                fileInputStream.read(bArr);
                fileInputStream.close();
                String fileContent = A01(0, 5, 98);
                return new String(bArr, fileContent);
            } catch (FileNotFoundException e2) {
                A01.A06().A8q(A012, C06808m.A0x, new C06818n(e2));
                return A013;
            } catch (IOException e3) {
                A01.A06().A8q(A012, C06808m.A0y, new C06818n(e3));
                return A013;
            }
        }
        return A013;
    }

    public static void A03() {
        if (!A0H() || A02 == null) {
            return;
        }
        MA.A06.execute(new C1548d3(A02));
    }

    public static synchronized void A07() {
        synchronized (C04910u.class) {
            A0E(A01(7, 18, 39));
            A0E(A01(25, 13, 6));
        }
    }

    public static synchronized void A08() {
        synchronized (C04910u.class) {
            try {
                A00.A07(A02(A01(25, 13, 6)));
                A00.A05(A02(A01(7, 18, 39)));
            } catch (JSONException e2) {
                A07();
                A01.A06().A8q(A01(38, 17, 46), C06808m.A0z, new C06818n(e2));
            }
        }
    }

    public static synchronized void A09() {
        synchronized (C04910u.class) {
            A0F(A01(25, 13, 6), A00().getBytes());
            A0F(A01(7, 18, 39), A00.A03().toString().getBytes());
        }
    }

    public static synchronized void A0B(C1M c1m, String str, boolean z) {
        synchronized (C04910u.class) {
            c1m.A07(z);
            if (c1m.A08() || c1m.A09()) {
                A00.A06(str);
            } else {
                A00.A08(str);
            }
        }
    }

    public static synchronized void A0C(C8J c8j) {
        synchronized (C04910u.class) {
            A01 = c8j;
            A02 = null;
            MA.A06.execute(new C1551d6());
        }
    }

    public static void A0D(String str) {
        if (!A0H()) {
            return;
        }
        A02 = str;
        MA.A06.execute(new C1549d4(str));
    }

    public static void A0E(String str) {
        File file = new File(A01.getFilesDir(), str);
        if (file.exists()) {
            file.delete();
        }
    }

    public static synchronized void A0F(String str, byte[] bArr) {
        synchronized (C04910u.class) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(new File(A01.getFilesDir(), str));
                fileOutputStream.write(bArr);
                fileOutputStream.close();
            } catch (FileNotFoundException e2) {
                A01.A06().A8q(A01(38, 17, 46), C06808m.A0x, new C06818n(e2));
            } catch (IOException e3) {
                A01.A06().A8q(A01(38, 17, 46), C06808m.A0y, new C06818n(e3));
            }
        }
    }

    public static void A0G(JSONObject jSONObject) {
        A05 = JD.A0v(A01);
        if (!A05) {
            return;
        }
        MA.A06.execute(new C1550d5(jSONObject));
    }

    public static boolean A0H() {
        return A05;
    }

    public static boolean A0I(String str) {
        boolean z = false;
        try {
            z = A00.A03().get(str) instanceof C1M;
            return z;
        } catch (JSONException e2) {
            A01.A06().A8q(A01(38, 17, 46), C06808m.A0z, new C06818n(e2));
            return z;
        }
    }
}
