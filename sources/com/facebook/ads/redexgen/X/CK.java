package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.util.UUID;
/* loaded from: assets/audience_network.dex */
public interface CK {
    byte[] executeKeyRequest(UUID uuid, CB cb, @Nullable String str) throws Exception;

    byte[] executeProvisionRequest(UUID uuid, CF cf) throws Exception;
}
