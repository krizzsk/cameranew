package com.facebook.ads.redexgen.X;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import androidx.annotation.Nullable;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.aO  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1392aO extends C06266b {
    public static byte[] A04;
    @Nullable
    public ConfigurationInfo A00;
    public final ActivityManager.RunningAppProcessInfo A01;
    public final ActivityManager A02;
    public final Context A03;

    static {
        A05();
    }

    public static String A04(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 6);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A04 = new byte[]{Draft_75.CR, 15, 24, 5, 26, 5, 24, 21};
    }

    public C1392aO(Context context, AnonymousClass61 anonymousClass61) {
        super(context, anonymousClass61);
        this.A03 = context;
        this.A02 = (ActivityManager) this.A03.getSystemService(A04(0, 8, 106));
        ActivityManager activityManager = this.A02;
        if (activityManager != null) {
            this.A00 = activityManager.getDeviceConfigurationInfo();
        }
        this.A01 = new ActivityManager.RunningAppProcessInfo();
    }

    public final InterfaceC06356k A0G() {
        return new C1395aR(this);
    }

    public final InterfaceC06356k A0H() {
        return new C1394aQ(this);
    }

    public final InterfaceC06356k A0I() {
        return new C1399aV(this);
    }

    public final InterfaceC06356k A0J() {
        return new C1398aU(this);
    }

    public final InterfaceC06356k A0K() {
        return new C1397aT(this);
    }

    public final InterfaceC06356k A0L() {
        return new C1400aW(this);
    }

    public final InterfaceC06356k A0M() {
        return new C1396aS(this);
    }

    public final InterfaceC06356k A0N() {
        return new C1401aX(this);
    }

    public final InterfaceC06356k A0O() {
        return new C1393aP(this);
    }

    public final InterfaceC06356k A0P() {
        return new C1403aZ(this);
    }

    public final InterfaceC06356k A0Q() {
        return new C1402aY(this);
    }
}
