package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.os.Process;
import androidx.annotation.Nullable;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Zd  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1345Zd extends C06266b {
    public static byte[] A01;
    @Nullable
    public final BluetoothAdapter A00;

    static {
        A03();
    }

    public static String A02(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 106);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A01 = new byte[]{-4, 9, -1, Draft_75.CR, 10, 4, -1, -55, 11, 0, Draft_75.CR, 8, 4, 14, 14, 4, 10, 9, -55, -35, -25, -16, -32, -17, -22, -22, -17, -29};
    }

    public C1345Zd(Context context, AnonymousClass61 anonymousClass61) {
        super(context, anonymousClass61);
        this.A00 = A04(context) ? BluetoothAdapter.getDefaultAdapter() : null;
    }

    public static boolean A04(Context context) {
        return context.checkPermission(A02(0, 28, 49), Process.myPid(), Process.myUid()) == 0;
    }

    @SuppressLint({"MissingPermission", "CatchGeneralException"})
    public final InterfaceC06356k A0G() {
        return new C1349Zh(this);
    }

    @SuppressLint({"MissingPermission", "CatchGeneralException"})
    public final InterfaceC06356k A0H() {
        return new C1348Zg(this);
    }

    @SuppressLint({"MissingPermission"})
    public final InterfaceC06356k A0I() {
        return new C1347Zf(this);
    }
}
