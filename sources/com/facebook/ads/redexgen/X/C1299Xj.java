package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.Xj  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1299Xj<T> extends AbstractC06506z<InterfaceC06416q> {
    public static byte[] A00;
    public static String[] A01 = {"FFbUiuFwozfA0TvCJPANz8giqJj3Ey6e", "FdrdBbAzaIA4fvIQziUETi0i5pzm7d41", "y8Q9G33rxS5LLrNXiYcm9QLiBdw97p1I", "zt8", "kKbJCUSdm2baWh6S7cWsva6nWBGnb0Bq", "lZC5QmFNV9qqPs7G4jyYJaaKbEwmE4", "OkQ3tI89WJ1Nk7Gpl9REz34W9wj5LbGl", "vzboBPdl2BbWH2MdrrRCAvv17E0LNPzE"};

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 40);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        byte[] bArr = {-73};
        String[] strArr = A01;
        if (strArr[0].charAt(26) != strArr[6].charAt(26)) {
            throw new RuntimeException();
        }
        A01[2] = "4uyIqP7n4WtKVi9Rm5fO0ecCuIXu1zOj";
        A00 = bArr;
    }

    static {
        A01();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Xj != com.facebook.ads.internal.botdetection.signals.model.signal_value.CustomObjectSignalValueType<T> */
    public C1299Xj(long j2, @Nullable C06486x c06486x, InterfaceC06416q interfaceC06416q) {
        super(j2, c06486x, interfaceC06416q, EnumC06496y.A03);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Xj != com.facebook.ads.internal.botdetection.signals.model.signal_value.CustomObjectSignalValueType<T> */
    @Override // com.facebook.ads.redexgen.X.AbstractC06506z
    public final int A06() {
        return ((InterfaceC06416q) A07()).AEd();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Xj != com.facebook.ads.internal.botdetection.signals.model.signal_value.CustomObjectSignalValueType<T> */
    @Override // com.facebook.ads.redexgen.X.AbstractC06506z
    public final JSONObject A08(JSONObject jSONObject) throws JSONException {
        return jSONObject.put(A00(0, 1, 25), ((InterfaceC06416q) A07()).AEy());
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.6z != com.facebook.ads.internal.botdetection.signals.model.signal_value.SignalValueTypeDef<com.facebook.ads.internal.botdetection.signals.model.signal_value.ICustomObjectSignalValueDef> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Xj != com.facebook.ads.internal.botdetection.signals.model.signal_value.CustomObjectSignalValueType<T> */
    @Override // com.facebook.ads.redexgen.X.AbstractC06506z
    public final boolean A0A(AbstractC06506z<InterfaceC06416q> abstractC06506z) {
        if (A07() == null || abstractC06506z.A07() == null) {
            return A07() == null && abstractC06506z.A07() == null;
        }
        return ((InterfaceC06416q) A07()).A8K(abstractC06506z.A07());
    }
}
