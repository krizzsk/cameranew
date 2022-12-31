package com.google.android.gms.ads.mediation;

import android.os.Bundle;
import com.google.android.gms.ads.AdFormat;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public class MediationConfiguration {
    private final AdFormat a;
    private final Bundle b;

    public MediationConfiguration(AdFormat adFormat, Bundle bundle) {
        this.a = adFormat;
        this.b = bundle;
    }

    public AdFormat getFormat() {
        return this.a;
    }

    public Bundle getServerParameters() {
        return this.b;
    }
}
