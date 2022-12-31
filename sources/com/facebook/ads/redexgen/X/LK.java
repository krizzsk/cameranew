package com.facebook.ads.redexgen.X;

import com.facebook.ads.AdError;
import com.facebook.ads.internal.protocol.AdErrorType;
/* loaded from: assets/audience_network.dex */
public final class LK {
    public static AdError A00(K3 k3) {
        if (k3.A03().isPublicError()) {
            return new AdError(k3.A03().getErrorCode(), k3.A04());
        }
        return new AdError(AdErrorType.UNKNOWN_ERROR.getErrorCode(), AdErrorType.UNKNOWN_ERROR.getDefaultErrorMessage());
    }
}
