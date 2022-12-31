package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioManager;
import android.os.SystemClock;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.Zw  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1364Zw extends C06266b {
    public static byte[] A01;
    public final AudioManager A00;

    static {
        A05();
    }

    public static String A04(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 33);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A01 = new byte[]{-22, -2, -19, -14, -8};
    }

    public C1364Zw(Context context, AnonymousClass61 anonymousClass61) {
        super(context, anonymousClass61);
        this.A00 = (AudioManager) context.getSystemService(A04(0, 5, 104));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"Nullable Dereference"})
    public AbstractC06506z A03(HashMap<Integer, C1365Zx> hashMap) {
        return new C1292Xc(SystemClock.elapsedRealtime(), A02(), hashMap, EnumC06496y.A06);
    }

    public final InterfaceC06356k A0G() {
        return new C1367Zz(this);
    }

    public final InterfaceC06356k A0H() {
        return new C1370a2(this);
    }

    public final InterfaceC06356k A0I() {
        return new C1369a1(this);
    }

    public final InterfaceC06356k A0J() {
        return new C1368a0(this);
    }

    public final InterfaceC06356k A0K(List<C06346j> list) {
        return new C1366Zy(this, list);
    }
}
