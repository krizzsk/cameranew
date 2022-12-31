package com.facebook.ads.redexgen.X;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Rm  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1149Rm extends AbstractRunnableC0981Kv {
    public static byte[] A01;
    public static String[] A02 = {"aQtlI1Us5cYHMsIV", "ql6TdDFLVKaOF", "ILd0cBh", "B0sTrIURZDTgtQOqZ9wP44Me", "PUGSIMdaF2lm0BEktB", "ig45kctSq2tkP", "eb7l2wEenDPHh06UHeaR81tCSX", "F61vU5UciYvMkd8uRJU0Fm"};
    public final /* synthetic */ AnonymousClass87 A00;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        int i5 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A02;
            if (strArr[3].length() == strArr[4].length()) {
                throw new RuntimeException();
            }
            A02[7] = "csAIefbP6dEHufce3C5MSz";
            if (i5 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 117);
            i5++;
        }
    }

    public static void A02() {
        A01 = new byte[]{67, 86, 81, 82, 92, Draft_75.CR, 91, 82, 99, 82, 95, Draft_75.CR, 96, 97, 78, 95, 97, 82, 81, Draft_75.CR, 93, 89, 78, 102, 86, 91, 84};
    }

    static {
        A02();
    }

    public C1149Rm(AnonymousClass87 anonymousClass87) {
        this.A00 = anonymousClass87;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0981Kv
    public final void A06() {
        boolean z;
        z = this.A00.A08;
        if (!z) {
            this.A00.A0G(A00(0, 27, 120));
        }
    }
}
