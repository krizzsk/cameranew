package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.protocol.AdErrorType;
import java.util.Arrays;
import org.json.JSONException;
/* loaded from: assets/audience_network.dex */
public class TZ implements InterfaceC1117Qg {
    public static byte[] A03;
    public final /* synthetic */ long A00;
    public final /* synthetic */ KU A01;
    public final /* synthetic */ KX A02;

    static {
        A01();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 10);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{100, 105, 99, 51, 49, 52, 53, 50, 18, 68, 70, 21, 70, 19, 65, 17, 1, 24, 4, 5, 14, 51, 40, 46, 59, 63, 34, 36, 37, 113, 107, 108, 90, 77, 73, 90, 77, 31, 90, 77, 77, 80, 77, 31, 80, 92, 92, 74, 77, 77, 90, 91, 75, 125, 106, 110, 125, 106, 56, 106, 125, 104, 116, 113, 125, 124, 56, 107, 109, 123, 123, 125, 107, 107, 126, 109, 116, 116, 97, 75, 74, 103, 75, 73, 84, 72, 65, 80, 65, 95, 94, 117, 66, 66, 95, 66};
    }

    public TZ(KX kx, KU ku, long j2) {
        this.A02 = kx;
        this.A01 = ku;
        this.A00 = j2;
    }

    private final void A02(C1129Qs c1129Qs) {
        XT xt;
        long j2;
        XT xt2;
        long j3;
        KY ky;
        XT xt3;
        XT xt4;
        long j4;
        KT.A06(this.A01);
        try {
            InterfaceC1115Qe A00 = c1129Qs.A00();
            if (A00 != null) {
                String errorMsg = A00.A5m();
                ky = this.A02.A04;
                xt3 = this.A02.A03;
                C0962Ka A06 = ky.A06(xt3, errorMsg, this.A00);
                if (A06.A01() == KZ.A03) {
                    TV tv2 = (TV) A06;
                    String finalErrMessage = tv2.A04();
                    AdErrorType adErrorTypeFromCode = AdErrorType.adErrorTypeFromCode(tv2.A03(), AdErrorType.ERROR_MESSAGE);
                    if (finalErrMessage != null) {
                        errorMsg = finalErrMessage;
                    }
                    xt4 = this.A02.A03;
                    C0R A0D = xt4.A0D();
                    j4 = this.A02.A00;
                    A0D.A2j(C1008Ly.A01(j4), adErrorTypeFromCode.getErrorCode(), errorMsg, adErrorTypeFromCode.isPublicError());
                    this.A02.A0D(K3.A01(adErrorTypeFromCode, errorMsg));
                    return;
                }
            }
            AdErrorType adErrorType = AdErrorType.NETWORK_ERROR;
            String message = c1129Qs.getMessage();
            xt2 = this.A02.A03;
            C0R A0D2 = xt2.A0D();
            j3 = this.A02.A00;
            A0D2.A2j(C1008Ly.A01(j3), adErrorType.getErrorCode(), message, adErrorType.isPublicError());
            this.A02.A0D(K3.A01(adErrorType, message));
        } catch (JSONException e2) {
            AdErrorType adErrorType2 = AdErrorType.NETWORK_ERROR;
            String message2 = c1129Qs.getMessage();
            xt = this.A02.A03;
            C0R A0D3 = xt.A0D();
            j2 = this.A02.A00;
            long A01 = C1008Ly.A01(j2);
            int errorCode = adErrorType2.getErrorCode();
            StringBuilder sb = new StringBuilder();
            String errorMessage = A00(16, 15, 65);
            sb.append(errorMessage);
            String errorMessage2 = e2.getMessage();
            sb.append(errorMessage2);
            A0D3.A2j(A01, errorCode, sb.toString(), adErrorType2.isPublicError());
            this.A02.A0D(K3.A01(adErrorType2, message2));
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1117Qg
    public final void AAA(InterfaceC1115Qe interfaceC1115Qe) {
        KI.A05(A00(79, 10, 46), A00(52, 27, 18), A00(8, 8, 45));
        if (interfaceC1115Qe != null) {
            String A5m = interfaceC1115Qe.A5m();
            KT.A06(this.A01);
            this.A02.A0M(A5m, this.A00, this.A01);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1117Qg
    public final void AAX(Exception exc) {
        XT xt;
        long j2;
        KI.A05(A00(89, 7, 58), A00(31, 21, 53), A00(0, 8, 90));
        if (C1129Qs.class.equals(exc.getClass())) {
            A02((C1129Qs) exc);
            return;
        }
        AdErrorType adErrorType = AdErrorType.NETWORK_ERROR;
        String message = exc.getMessage();
        xt = this.A02.A03;
        C0R A0D = xt.A0D();
        j2 = this.A02.A00;
        A0D.A2j(C1008Ly.A01(j2), adErrorType.getErrorCode(), message, adErrorType.isPublicError());
        this.A02.A0D(K3.A01(adErrorType, message));
    }
}
