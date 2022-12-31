package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.Xa  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1290Xa extends AbstractC06506z<String> {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 123);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{55};
    }

    public C1290Xa(long j2, @Nullable C06486x c06486x, String str) {
        super(j2, c06486x, str, EnumC06496y.A0C);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC06506z
    public final int A06() {
        return A07().getBytes().length;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC06506z
    public final JSONObject A08(JSONObject jSONObject) throws JSONException {
        jSONObject.put(A00(0, 1, 58), A07());
        return jSONObject;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.6z != com.facebook.ads.internal.botdetection.signals.model.signal_value.SignalValueTypeDef<java.lang.String> */
    @Override // com.facebook.ads.redexgen.X.AbstractC06506z
    public final boolean A0A(AbstractC06506z<String> abstractC06506z) {
        return A07().equals(abstractC06506z.A07());
    }
}
