package com.facebook.ads.redexgen.X;

import android.os.AsyncTask;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.Executor;
/* loaded from: assets/audience_network.dex */
public final class HA extends AsyncTask<AbstractC1128Qr, Void, InterfaceC1115Qe> implements InterfaceC1125Qo {
    public static byte[] A04;
    public static String[] A05 = {"ISBjHjbUPhJT7DGB2JvjH8pRJ4THrNWM", "OPg7gsPnZP3QsQWue6lzrISH1J86h", "XeTxlXzdRCOD7SBCy0O7kO4k", "wF1PTlVBDnka4lPn0WIHxf3evs", "myOhX4xCY5Mi9IbsU0pUOVW5bZkAtWyQ", "1AepsAli0TWWKf1w83zMf6wttDUWZa9Z", "XTBsgsEzxuO7TTQvYMtR1VxTZpUl2a6R", "C8VCTESPpZtI8Zr0pzMJK5rADprlDNCz"};
    public InterfaceC1117Qg A00;
    public C0877Gr A01;
    public Exception A02;
    public Executor A03;

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 101);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A04 = new byte[]{-18, 25, -14, 30, 30, 26, -4, 15, 27, 31, 15, 29, 30, -2, 11, 29, 21, -54, 30, 11, 21, 15, 29, -54, 15, 34, 11, Draft_75.CR, 30, 22, 35, -54, 25, 24, 15, -54, 11, 28, 17, 31, 23, 15, 24, 30, -54, 25, 16, -54, 30, 35, 26, 15, -54, -14, 30, 30, 26, -4, 15, 27, 31, 15, 29, 30, 15, 27, 27, 23, -25, 57, 44, 56, 60, 44, 58, 59, -25, 45, 40, 48, 51, 44, 43, 1, -25, -20, 58, 36, 80, 80, 76, -4, 78, 65, 79, 76, 75, 74, 79, 65, -4, 69, 79, -4, 74, 81, 72, 72, -67, -48, -34, -37, -38, -39, -34, -48, -91, -117, -112, -49, -117, -109, -112, -34, -108, -91, 117, -112, -34};
    }

    static {
        A02();
    }

    public HA(C0877Gr c0877Gr, InterfaceC1117Qg interfaceC1117Qg, Executor executor) {
        this.A01 = c0877Gr;
        this.A00 = interfaceC1117Qg;
        this.A03 = executor;
    }

    private final InterfaceC1115Qe A00(AbstractC1128Qr... abstractC1128QrArr) {
        if (C0974Kn.A02(this)) {
            return null;
        }
        try {
            if (abstractC1128QrArr != null) {
                try {
                    if (abstractC1128QrArr.length > 0) {
                        InterfaceC1115Qe A0J = this.A01.A0J(abstractC1128QrArr[0]);
                        if (A0J != null) {
                            String.format(Locale.US, A01(108, 21, 6), Integer.valueOf(A0J.A7U()), A0J.getUrl(), A0J.A5m());
                        }
                        if (A0J != null) {
                            return A0J;
                        }
                        throw new IllegalStateException(A01(87, 21, 119));
                    }
                } catch (Exception e2) {
                    this.A02 = e2;
                    String.format(Locale.US, A01(64, 23, 98), e2.getMessage());
                    cancel(true);
                    return null;
                }
            }
            throw new IllegalArgumentException(A01(0, 64, 69));
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
            String[] strArr = A05;
            if (strArr[6].charAt(29) != strArr[5].charAt(29)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A05;
            strArr2[6] = "7Z9SEUfEEdRKQwGPWQmPRdvkxtWIqa6k";
            strArr2[5] = "25jJFjyuRcytvXC4wurkJewgVtIZaaql";
            return null;
        }
    }

    private final void A03(InterfaceC1115Qe interfaceC1115Qe) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            this.A00.AAA(interfaceC1115Qe);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1125Qo
    public final void A5E(AbstractC1128Qr abstractC1128Qr) {
        super.executeOnExecutor(this.A03, abstractC1128Qr);
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ InterfaceC1115Qe doInBackground(AbstractC1128Qr[] abstractC1128QrArr) {
        if (C0974Kn.A02(this)) {
            return null;
        }
        try {
            return A00(abstractC1128QrArr);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public final void onCancelled() {
        this.A00.AAX(this.A02);
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ void onPostExecute(InterfaceC1115Qe interfaceC1115Qe) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A03(interfaceC1115Qe);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }
}
