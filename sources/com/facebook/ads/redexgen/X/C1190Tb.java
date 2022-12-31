package com.facebook.ads.redexgen.X;

import android.content.pm.PackageManager;
import android.util.Base64;
import com.facebook.ads.internal.protocol.AdErrorType;
import java.util.Arrays;
import java.util.Map;
/* renamed from: com.facebook.ads.redexgen.X.Tb  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1190Tb extends AbstractRunnableC0981Kv {
    public static byte[] A02;
    public final /* synthetic */ KU A00;
    public final /* synthetic */ KX A01;

    static {
        A02();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 119);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{10, 75, 89, 68, 71, 72, 72, 67, 84, 89, 77, 67, 95};
    }

    public C1190Tb(KX kx, KU ku) {
        this.A01 = kx;
        this.A00 = ku;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0981Kv
    public final void A06() {
        XT xt;
        XT xt2;
        XT xt3;
        XT xt4;
        long j2;
        XT xt5;
        String str;
        Map<? extends String, ? extends String> map;
        InterfaceC1117Qg A03;
        XT xt6;
        XT xt7;
        XT xt8;
        xt = this.A01.A03;
        C06898v.A08(xt);
        xt2 = this.A01.A03;
        C06075h.A07(xt2);
        KU ku = this.A00;
        C9H A00 = C9H.A00();
        xt3 = this.A01.A03;
        boolean z = true;
        Map<String, String> A08 = ku.A08(A00.A01(xt3, true).A6S());
        this.A01.A02 = A08;
        try {
            xt6 = this.A01.A03;
            PackageManager packageManager = xt6.getPackageManager();
            if (packageManager != null) {
                String A002 = A00(1, 12, 113);
                StringBuilder sb = new StringBuilder();
                xt7 = this.A01.A03;
                sb.append(xt7.getPackageName());
                sb.append(A00(0, 1, 93));
                xt8 = this.A01.A03;
                sb.append(packageManager.getInstallerPackageName(xt8.getPackageName()));
                A08.put(A002, new String(Base64.encode(sb.toString().getBytes(), 2)));
            }
        } catch (Exception unused) {
        }
        try {
            if (this.A00.A05() != K9.A03 && this.A00.A05() != K9.A05 && this.A00.A05() != K9.A04 && this.A00.A05() != null) {
                z = false;
            }
            xt5 = this.A01.A03;
            InterfaceC1116Qf A022 = C1134Qx.A02(z, xt5);
            str = this.A01.A05;
            C1130Qt c1130Qt = new C1130Qt();
            map = this.A01.A02;
            byte[] A082 = c1130Qt.A05(map).A08();
            A03 = this.A01.A03(C1008Ly.A00(), this.A00);
            A022.ACu(str, A082, A03);
        } catch (Exception e2) {
            AdErrorType adErrorType = AdErrorType.AD_REQUEST_FAILED;
            String message = e2.getMessage();
            xt4 = this.A01.A03;
            C0R A0D = xt4.A0D();
            j2 = this.A01.A00;
            A0D.A2j(C1008Ly.A01(j2), adErrorType.getErrorCode(), message, adErrorType.isPublicError());
            this.A01.A0D(K3.A01(adErrorType, message));
        }
    }
}
