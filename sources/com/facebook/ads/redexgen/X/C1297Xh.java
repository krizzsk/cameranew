package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.Xh  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1297Xh extends AbstractC06506z<Float> {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 83);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{75};
    }

    public C1297Xh(long j2, @Nullable C06486x c06486x, float f2) {
        super(j2, c06486x, Float.valueOf(f2), EnumC06496y.A05);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC06506z
    public final int A06() {
        return 4;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC06506z
    public final JSONObject A08(JSONObject jSONObject) throws JSONException {
        jSONObject.put(A00(0, 1, 110), A07());
        return jSONObject;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.6z != com.facebook.ads.internal.botdetection.signals.model.signal_value.SignalValueTypeDef<java.lang.Float> */
    @Override // com.facebook.ads.redexgen.X.AbstractC06506z
    public final boolean A0A(AbstractC06506z<Float> abstractC06506z) {
        return Math.abs(A07().floatValue() - abstractC06506z.A07().floatValue()) < AnonymousClass61.A01();
    }
}
