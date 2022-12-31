package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import com.facebook.ads.internal.protocol.AdErrorType;
import java.util.Arrays;
import java.util.UUID;
/* renamed from: com.facebook.ads.redexgen.X.cG  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC1500cG implements AnonymousClass24 {
    public static byte[] A05;
    public final InterfaceC05171u A00;
    public final XT A01;
    public final String A02 = UUID.randomUUID().toString();
    public final Handler A03;
    public final InterfaceC05221z A04;

    static {
        A03();
    }

    public static String A02(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 36);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A05 = new byte[]{-65, -46, -53, -63, -55, -62, -36, -62, -43, -47, -49, -66, -48, -36, -56, -62, -42, -46, -41, -35, -24, -50, -37, -37, -40, -37, -24, -52, -40, -51, -50, -24, -44, -50, -30, -83, -82, -84, -71, -101, -98, -71, -93, -98, -71, -91, -97, -77, -24, -23, -25, -12, -38, -25, -25, -28, -25, -12, -30, -38, -24, -24, -42, -36, -38, -12, -32, -38, -18};
    }

    public abstract void A05();

    public AbstractC1500cG(XT xt, AnonymousClass20 anonymousClass20) {
        this.A01 = xt;
        DynamicLoaderFactory.makeLoader(this.A01).getInitApi().onAdLoadInvoked(this.A01);
        this.A00 = new C1502cJ(xt, this);
        this.A03 = new Handler(Looper.getMainLooper());
        this.A04 = anonymousClass20.A4K(this.A00, this);
    }

    public final void A04() {
        if (!JD.A0n(this.A01)) {
            return;
        }
        M1.A00(new C1501cH(this));
    }

    public final void A06(int i2, AdErrorType adErrorType, @Nullable String str) {
        Bundle bundle = new Bundle();
        String A02 = A02(48, 21, 113);
        if (str != null) {
            bundle.putString(A02, str);
        } else {
            bundle.putString(A02, adErrorType.getDefaultErrorMessage());
        }
        bundle.putInt(A02(17, 18, 101), adErrorType.getErrorCode());
        ABI(i2, this.A02, bundle);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass24
    public final void ABI(int i2, String str, @Nullable Bundle bundle) {
        Message obtain = Message.obtain((Handler) null, i2);
        obtain.getData().putString(A02(35, 13, 54), str);
        if (bundle != null) {
            obtain.getData().putBundle(A02(0, 17, 89), bundle);
        }
        this.A03.post(new cI(this, obtain));
    }
}
