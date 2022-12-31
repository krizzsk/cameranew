package com.google.android.gms.ads.mediation.admob;

import android.os.Bundle;
import com.google.ads.mediation.e;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
@Deprecated
/* loaded from: classes2.dex */
public final class AdMobExtras implements e {
    private final Bundle a;

    public AdMobExtras(Bundle bundle) {
        this.a = bundle != null ? new Bundle(bundle) : null;
    }

    public final Bundle getExtras() {
        return this.a;
    }
}
