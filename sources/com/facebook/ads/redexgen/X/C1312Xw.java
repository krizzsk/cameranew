package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.TelephonyManager;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Xw  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1312Xw extends C06266b {
    public static byte[] A01;
    public final TelephonyManager A00;

    static {
        A05();
    }

    public static String A04(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 60);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A01 = new byte[]{15, 7, 14, Draft_75.CR, 4};
    }

    public C1312Xw(Context context, AnonymousClass61 anonymousClass61) {
        super(context, anonymousClass61);
        this.A00 = (TelephonyManager) context.getSystemService(A04(0, 5, 99));
    }

    public static int A01(CellInfo cellInfo) {
        if (cellInfo != null) {
            if (Build.VERSION.SDK_INT >= 18) {
                if (cellInfo instanceof CellInfoCdma) {
                    return ((CellInfoCdma) cellInfo).getCellSignalStrength().getLevel();
                }
                if (cellInfo instanceof CellInfoGsm) {
                    return ((CellInfoGsm) cellInfo).getCellSignalStrength().getLevel();
                }
                if (cellInfo instanceof CellInfoLte) {
                    return ((CellInfoLte) cellInfo).getCellSignalStrength().getLevel();
                }
                if (cellInfo instanceof CellInfoWcdma) {
                    return ((CellInfoWcdma) cellInfo).getCellSignalStrength().getLevel();
                }
                throw new UnsupportedOperationException(cellInfo.getClass().getSimpleName());
            }
            throw new UnsupportedOperationException();
        }
        throw new NullPointerException();
    }

    public final InterfaceC06356k A0G() {
        return new Y6(this);
    }

    @SuppressLint({"MissingPermission", "CatchGeneralException"})
    public final InterfaceC06356k A0H() {
        return new Y5(this);
    }

    public final InterfaceC06356k A0I() {
        return new Y1(this);
    }

    public final InterfaceC06356k A0J() {
        return new Y0(this);
    }

    public final InterfaceC06356k A0K() {
        return new Y2(this);
    }

    public final InterfaceC06356k A0L() {
        return new Y3(this);
    }

    public final InterfaceC06356k A0M() {
        return new C1313Xx(this);
    }

    public final InterfaceC06356k A0N() {
        return new Y9(this);
    }

    public final InterfaceC06356k A0O() {
        return new C1315Xz(this);
    }

    public final InterfaceC06356k A0P() {
        return new C1314Xy(this);
    }

    public final InterfaceC06356k A0Q() {
        return new Y8(this);
    }

    public final InterfaceC06356k A0R() {
        return new Y7(this);
    }

    @SuppressLint({"MissingPermission", "CatchGeneralException"})
    public final InterfaceC06356k A0S() {
        return new Y4(this);
    }
}
