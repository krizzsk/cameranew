package com.facebook.ads.redexgen.X;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.7k  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C06597k extends AbstractC0976Kq {
    public static byte[] A01;
    public final /* synthetic */ C06587j A00;

    static {
        A01();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 118);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-7, Draft_75.CR, -4, 1, 7};
    }

    public C06597k(C06587j c06587j) {
        this.A00 = c06587j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0012, code lost:
        if (r0.get() == null) goto L8;
     */
    @Override // com.facebook.ads.redexgen.X.C9P
    /* renamed from: A02 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A03(com.facebook.ads.redexgen.X.C0977Kr r5) {
        /*
            r4 = this;
            com.facebook.ads.redexgen.X.7j r0 = r4.A00
            java.lang.ref.WeakReference r0 = com.facebook.ads.redexgen.X.C06587j.A03(r0)
            if (r0 == 0) goto L14
            com.facebook.ads.redexgen.X.7j r0 = r4.A00
            java.lang.ref.WeakReference r0 = com.facebook.ads.redexgen.X.C06587j.A03(r0)
            java.lang.Object r0 = r0.get()
            if (r0 != 0) goto L23
        L14:
            com.facebook.ads.redexgen.X.7j r2 = r4.A00
            com.facebook.ads.redexgen.X.Pt r1 = new com.facebook.ads.redexgen.X.Pt
            r1.<init>(r4)
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference
            r0.<init>(r1)
            com.facebook.ads.redexgen.X.C06587j.A04(r2, r0)
        L23:
            com.facebook.ads.redexgen.X.7j r0 = r4.A00
            android.content.Context r0 = r0.getContext()
            android.content.Context r3 = r0.getApplicationContext()
            r2 = 0
            r1 = 5
            r0 = 34
            java.lang.String r0 = A00(r2, r1, r0)
            java.lang.Object r3 = r3.getSystemService(r0)
            android.media.AudioManager r3 = (android.media.AudioManager) r3
            com.facebook.ads.redexgen.X.7j r0 = r4.A00
            java.lang.ref.WeakReference r0 = com.facebook.ads.redexgen.X.C06587j.A03(r0)
            java.lang.Object r2 = r0.get()
            android.media.AudioManager$OnAudioFocusChangeListener r2 = (android.media.AudioManager.OnAudioFocusChangeListener) r2
            r1 = 3
            r0 = 1
            r3.requestAudioFocus(r2, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C06597k.A03(com.facebook.ads.redexgen.X.Kr):void");
    }
}
