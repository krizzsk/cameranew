package com.facebook.ads.redexgen.X;

import android.view.View;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.cU  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1513cU implements InterfaceC04920v {
    public static byte[] A02;
    public static String[] A03 = {"7FIKHU9lgq27", "AgQqvAltXhi1bYF8zppFCZ", "CRAmwsbXNtyv0vmCJJ9qOPCwxUiND3E6", "ItQqdqoRYHMWKQzbVRTeHzNwEAi", "W2szVhKnaW", "HNVKE5hkEvipBMdeuLWXlSQ07SgK2Jmi", "9NOG2BA2dnlUEqMWgY53wMXC47FXKBrl", "EneshuO9jiHnlHF2bjWwp7WA0EKVaMOF"};
    public final /* synthetic */ F8 A00;
    public final /* synthetic */ Runnable A01;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            byte b = (byte) ((copyOfRange[i5] - i4) - 16);
            if (A03[2].charAt(4) == 'y') {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[5] = "2VG06oAYTcRzKBDE7gWFCU36hzL5px1b";
            strArr[7] = "j1xG2z3v9jq0UO66H2WqYNbpklLAu6IG";
            copyOfRange[i5] = b;
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{119, 115, 117, 110, -93, -97, -95, -124, -93, -80, -80, -89, -76, 98, -85, -81, -78, -76, -89, -75, -75, -85, -79, -80, 98, -88, -85, -76, -89, -90, -118, -119, 93, 124, -119, -119, Byte.MIN_VALUE, -115, 103, -118, -126, -126, -124, -119, -126, 100, -120, -117, -115, Byte.MIN_VALUE, -114, -114, -124, -118, -119};
    }

    static {
        A01();
    }

    public C1513cU(F8 f8, Runnable runnable) {
        this.A00 = f8;
        this.A01 = runnable;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC04920v
    public final void AA0(C1546d1 c1546d1) {
        C0803Dr c0803Dr;
        c0803Dr = this.A00.A01;
        c0803Dr.A0D().A3h();
        this.A00.A06.A0C();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC04920v
    public final void AA1(C1546d1 c1546d1, View view) {
        C0803Dr c0803Dr;
        c0803Dr = this.A00.A01;
        c0803Dr.A0D().A3g(c1546d1 == ((AbstractC1511cS) this.A00).A00);
        if (c1546d1 != ((AbstractC1511cS) this.A00).A00) {
            return;
        }
        this.A00.A0C().removeCallbacks(this.A01);
        InterfaceC04840n interfaceC04840n = ((AbstractC1511cS) this.A00).A01;
        F8 f8 = this.A00;
        ((AbstractC1511cS) f8).A01 = c1546d1;
        f8.A00 = view;
        if (!this.A00.A0C) {
            this.A00.A06.A0F(c1546d1);
            return;
        }
        this.A00.A06.A0E(view);
        this.A00.A0K(interfaceC04840n);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC04920v
    public final void AA2(C1546d1 c1546d1) {
        C0803Dr c0803Dr;
        KI.A05(A00(30, 25, 11), A00(7, 23, 50), A00(0, 7, 46));
        c0803Dr = this.A00.A01;
        c0803Dr.A0D().A3j();
        this.A00.A06.A0D();
        this.A00.A0I();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC04920v
    public final void AAx(C1546d1 c1546d1, K3 k3) {
        C0803Dr c0803Dr;
        c0803Dr = this.A00.A01;
        c0803Dr.A0D().A3i(c1546d1 == ((AbstractC1511cS) this.A00).A00, k3.A03().getErrorCode());
        if (c1546d1 != ((AbstractC1511cS) this.A00).A00) {
            return;
        }
        this.A00.A0C().removeCallbacks(this.A01);
        this.A00.A0K(c1546d1);
        this.A00.AAW(k3);
    }
}
