package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import androidx.annotation.Nullable;
import java.io.File;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: assets/audience_network.dex */
public class Z1 implements InterfaceC06426r<String> {
    public static byte[] A04;
    public static String[] A05 = {"6T4TfN9d93smpapPC7NPEvQWDZz", "wz9NXVQZVQaYwwlRa3NaAZc6LHoNdU30", "fnx8tXb47HvWFCwW5yhjIfQFoxtnUIQc", "G4THVOFWMbp9mJ5nlEieSYvLtIDTgl3R", "sX64T2TxVGN65WmSTioWL8lV1Wvmr5np", "uUcAhhBnqDd9NemnY1mmV8635HbWIwRZ", "chycLI4p4miw8vWmnJIeDCkDmR2uSv62", "9rtomFcZ9dWi2vFWEMHGPAm9jgP"};
    public final int A00;
    public final long A01;
    public final long A02;
    @Nullable
    public final File A03;

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 87);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A04 = new byte[]{8, 29, 29, 78, 71, 76, 42, 43, 50};
    }

    static {
        A03();
    }

    public Z1(@Nullable File file) {
        this.A03 = file;
        this.A01 = file != null ? file.lastModified() : 0L;
        this.A02 = file != null ? file.length() : 0L;
        this.A00 = A00(file);
    }

    public static int A00(@Nullable File file) {
        if (file == null || !file.exists()) {
            String[] strArr = A05;
            if (strArr[2].charAt(30) != strArr[4].charAt(30)) {
                String[] strArr2 = A05;
                strArr2[2] = "wc3nNJS5ppnny67u8HKUvYRr0GzlmmqW";
                strArr2[4] = "Z8l5li3UiIjyuK8KpEFCaPnNGNbl1bLY";
                return 0;
            }
            throw new RuntimeException();
        }
        int i2 = 0;
        if (file.isFile()) {
            i2 = 0 | 1;
        }
        if (file.isDirectory()) {
            i2 |= 2;
        }
        if (file.isAbsolute()) {
            i2 |= 4;
        }
        if (file.isHidden()) {
            return i2 | 8;
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.InterfaceC06426r
    /* renamed from: A02 */
    public final JSONObject AEz(String str, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(A01(0, 3, 62), this.A00);
        jSONObject2.put(A01(3, 3, 117), this.A02);
        jSONObject2.put(A01(6, 3, 17), this.A01);
        jSONObject.put(str, jSONObject2);
        return jSONObject;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06426r
    @SuppressLint({"BadMethodUse-java.io.File.getAbsolutePath"})
    public final boolean A8K(Object obj) {
        Z1 z1 = (Z1) obj;
        File file = this.A03;
        if (file == null || z1.A03 == null) {
            return false;
        }
        String absolutePath = file.getAbsolutePath();
        String absolutePath2 = z1.A03.getAbsolutePath();
        String[] strArr = A05;
        if (strArr[5].charAt(25) != strArr[1].charAt(25)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A05;
        strArr2[2] = "X3kNBIX1Z99NiqyAprs9ibiSMdwBku8V";
        strArr2[4] = "CI6kXko00kdVwKTWWoZ5nL7fIste75nZ";
        if (absolutePath.equals(absolutePath2) && this.A00 == z1.A00) {
            long j2 = this.A02;
            long j3 = z1.A02;
            String[] strArr3 = A05;
            if (strArr3[5].charAt(25) != strArr3[1].charAt(25)) {
                throw new RuntimeException();
            }
            String[] strArr4 = A05;
            strArr4[7] = "GYoIXwPodsztMnAFw2JgL9coQaW";
            strArr4[0] = "dJwXRm7Lc7INOyvryqQLdueNOGl";
            return j2 == j3 && this.A01 == z1.A01;
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06426r
    public final int AEd() {
        return A01(0, 3, 62).getBytes().length + A01(3, 3, 117).getBytes().length + A01(6, 3, 17).getBytes().length + 4 + 16;
    }
}
