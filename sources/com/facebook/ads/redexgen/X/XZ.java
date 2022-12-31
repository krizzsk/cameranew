package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: assets/audience_network.dex */
public final class XZ extends AbstractC06506z<C6V> {
    public XZ(long j2, @Nullable C06486x c06486x, C6V c6v) {
        super(j2, c06486x, c6v, EnumC06496y.A0D);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC06506z
    public final int A06() {
        return A07().A09();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC06506z
    public final JSONObject A08(JSONObject jSONObject) throws JSONException {
        return A07().A0A(jSONObject);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.6z != com.facebook.ads.internal.botdetection.signals.model.signal_value.SignalValueTypeDef<com.facebook.ads.internal.botdetection.signals.biometric.model.TouchSignalRawValue> */
    @Override // com.facebook.ads.redexgen.X.AbstractC06506z
    public final boolean A0A(AbstractC06506z<C6V> abstractC06506z) {
        return A07().A0B(abstractC06506z.A07());
    }
}
