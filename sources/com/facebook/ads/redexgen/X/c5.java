package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.PointerIconCompat;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdExtendedListener;
import com.facebook.ads.InterstitialAdListener;
import com.facebook.ads.RewardedAdListener;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class c5 implements InterfaceC05221z {
    public static byte[] A04;
    public static String[] A05 = {"PyT2XUnl", "3EmvKqRjFYzRkizxlD8eotggUBC8U5J9", "Ib6uyfMRsh5ysHZ3i8ryXk3sO16qq9Ys", "q2kkzr74cnXMazMYxmC9c", "9U931lGThJH7Qz6wctlm6EKEWHFtvDAV", "f15MquYM06llw3BWZWASFwAp5egI2HKX", "yMUgiPhi", "t3xZZPMR"};
    public final AbstractC1500cG A00;
    public final InterfaceC05171u A01;
    public final C05201x A02;
    public final XT A03;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 57);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{-77, -42, -110, -31, -44, -36, -41, -43, -26, -110, -37, -27, -110, -32, -25, -34, -34, -115, -96, -103, -113, -105, -112, -86, -112, -93, -97, -99, -116, -98, -86, -106, -112, -92, -74, -78, -79, -27, -44, -39, -43, -34, -45, -43, -66, -43, -28, -25, -33, -30, -37, -87, -82, -76, -65, -91, -78, -78, -81, -78, -65, -93, -81, -92, -91, -65, -85, -91, -71, 4, 7, 6, -1, 23, 1, 6, 14, -7, 4, 1, -4, -7, 12, 1, 7, 6, 23, 12, 1, 5, -3, 23, 3, -3, 17, -61, -37, -23, -23, -41, -35, -37, -80, -106, -66, -38, -28, -28, -38, -33, -40, -111, -45, -26, -33, -43, -35, -42, -111, -41, -32, -29, -111, -34, -42, -28, -28, -46, -40, -42, -97, -95, -94, -96, -83, -109, -96, -96, -99, -96, -83, -101, -109, -95, -95, -113, -107, -109, -83, -103, -109, -89, 4, 19, 12};
    }

    static {
        A01();
    }

    public c5(XT xt, C05201x c05201x, InterfaceC05171u interfaceC05171u, AbstractC1500cG abstractC1500cG) {
        this.A03 = xt;
        this.A02 = c05201x;
        this.A01 = interfaceC05171u;
        this.A00 = abstractC1500cG;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.facebook.ads.redexgen.X.InterfaceC05221z
    public final void A7r(Message message) {
        InterstitialAd A01 = this.A02.A01();
        String A00 = A00(152, 3, 106);
        if (A01 == null) {
            this.A03.A06().A8q(A00, C06808m.A0C, new C06818n(A00(0, 17, 57)));
            return;
        }
        int i2 = message.what;
        String A002 = A00(95, 9, 61);
        String A003 = A00(104, 27, 56);
        String A004 = A00(17, 17, 18);
        if (i2 != 10) {
            if (i2 != 1020) {
                if (A05[4].charAt(15) != 'R') {
                    A05[2] = "aJfdsH08DFQiAUsDka0Nh1fTZA9JZGsz";
                    if (i2 == 1022) {
                        this.A01.AEW();
                    } else if (i2 != 1023) {
                        switch (i2) {
                        }
                    }
                }
                throw new RuntimeException();
            }
            this.A01.AEQ();
            Bundle bundle = message.getData().getBundle(A004);
            if (bundle != null) {
                this.A02.A0B(bundle.getLong(A00(69, 26, 127)));
            } else {
                InterfaceC06798l A06 = this.A03.A06();
                int i3 = C06808m.A0N;
                A06.A8q(A00, i3, new C06818n(A003, A002 + message));
            }
            this.A02.A0C(null);
            if (this.A02.A02() == null) {
                return;
            }
            switch (message.what) {
                case PointerIconCompat.TYPE_GRAB /* 1020 */:
                    this.A02.A02().onAdLoaded(A01);
                    return;
                case PointerIconCompat.TYPE_GRABBING /* 1021 */:
                    this.A02.A02().onInterstitialDisplayed(A01);
                    return;
                case 1022:
                    this.A02.A02().onInterstitialDismissed(A01);
                    return;
                case 1024:
                    this.A02.A02().onAdClicked(A01);
                    return;
                case InputDeviceCompat.SOURCE_GAMEPAD /* 1025 */:
                    this.A02.A02().onLoggingImpression(A01);
                    return;
                case 1026:
                    if (this.A02.A02() instanceof InterstitialAdExtendedListener) {
                        InterstitialAdListener A02 = this.A02.A02();
                        if (A05[2].charAt(18) == 'n') {
                            ((InterstitialAdExtendedListener) A02).onInterstitialActivityDestroyed();
                            break;
                        } else {
                            String[] strArr = A05;
                            strArr[1] = "4ubpoteMIucGsWyTMsTtOH4ZOdBl9bHr";
                            strArr[5] = "Xxx4qDjyhZoijrhiIp4u1mFMOEMCLZoL";
                            ((InterstitialAdExtendedListener) A02).onInterstitialActivityDestroyed();
                            break;
                        }
                    }
                    break;
            }
            RewardedAdListener A042 = this.A02.A04();
            String[] strArr2 = A05;
            if (strArr2[3].length() != strArr2[7].length()) {
                A05[4] = "YO9dGq40ZDljeOjTjHA4uB3VVKU9R56I";
                if (A042 == null) {
                    return;
                }
                switch (message.what) {
                    case PathInterpolatorCompat.MAX_NUM_POINTS /* 3000 */:
                        this.A02.A04().onRewardedAdCompleted();
                        if (A05[2].charAt(18) != 'n') {
                            String[] strArr3 = A05;
                            strArr3[1] = "IMuRostxJ5htnzhiOcsxYcu1iidsGUgj";
                            strArr3[5] = "ubJ4M5GxN6FfPval4rtOnbhl8vPUgGKC";
                            return;
                        }
                        break;
                    case AdError.MEDIATION_ERROR_CODE /* 3001 */:
                        this.A02.A04().onRewardedAdServerSucceeded();
                        return;
                    case 3002:
                        this.A02.A04().onRewardedAdServerFailed();
                        return;
                    default:
                        return;
                }
            }
            throw new RuntimeException();
        }
        Bundle bundle2 = message.getData();
        Bundle bundle3 = bundle2.getBundle(A004);
        if (bundle3 != null) {
            int i4 = bundle3.getInt(A00(51, 18, 39));
            String string = bundle3.getString(A00(131, 21, 21));
            AdError error = new AdError(i4, string);
            this.A01.AEM(error);
            if (this.A02.A02() != null) {
                this.A02.A02().onError(A01, error);
            } else {
                Log.e(A00(34, 17, 55), string);
            }
        } else {
            this.A01.AEJ(EnumC05161t.A05);
            InterfaceC06798l A062 = this.A03.A06();
            int i5 = C06808m.A0N;
            A062.A8q(A00, i5, new C06818n(A003, A002 + message));
        }
        this.A02.A0C(null);
    }
}
