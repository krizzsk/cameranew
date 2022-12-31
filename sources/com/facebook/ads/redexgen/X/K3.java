package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.protocol.AdErrorType;
/* loaded from: assets/audience_network.dex */
public final class K3 {
    public final AdErrorType A00;
    public final String A01;

    public K3(int i2, String str) {
        this(AdErrorType.adErrorTypeFromCode(i2), str);
    }

    public K3(AdErrorType adErrorType, @Nullable String str) {
        str = TextUtils.isEmpty(str) ? adErrorType.getDefaultErrorMessage() : str;
        this.A00 = adErrorType;
        this.A01 = str;
    }

    public static K3 A00(AdErrorType adErrorType) {
        return new K3(adErrorType, (String) null);
    }

    public static K3 A01(AdErrorType adErrorType, @Nullable String str) {
        return new K3(adErrorType, str);
    }

    public static K3 A02(K4 k4) {
        return new K3(k4.A00(), k4.A01());
    }

    public final AdErrorType A03() {
        return this.A00;
    }

    public final String A04() {
        return this.A01;
    }
}
