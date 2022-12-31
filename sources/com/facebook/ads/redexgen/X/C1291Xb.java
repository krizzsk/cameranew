package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.Xb  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1291Xb extends AbstractC06506z<C6T> {
    public C1291Xb(long j2, @Nullable C06486x c06486x, C6T c6t) {
        super(j2, c06486x, c6t, EnumC06496y.A0B);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC06506z
    public final int A06() {
        return A07().A03();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC06506z
    public final JSONObject A08(JSONObject jSONObject) throws JSONException {
        return A07().A04(jSONObject);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.6z != com.facebook.ads.internal.botdetection.signals.model.signal_value.SignalValueTypeDef<com.facebook.ads.internal.botdetection.signals.biometric.model.SensorSignalRawValue> */
    @Override // com.facebook.ads.redexgen.X.AbstractC06506z
    public final boolean A0A(AbstractC06506z<C6T> abstractC06506z) {
        return A07().A05(abstractC06506z.A07());
    }
}
