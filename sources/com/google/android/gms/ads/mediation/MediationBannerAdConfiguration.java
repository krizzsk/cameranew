package com.google.android.gms.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdSize;
import javax.annotation.ParametersAreNonnullByDefault;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public class MediationBannerAdConfiguration extends MediationAdConfiguration {

    /* renamed from: k  reason: collision with root package name */
    private final AdSize f3532k;

    public MediationBannerAdConfiguration(Context context, String str, Bundle bundle, Bundle bundle2, boolean z, @Nullable Location location, int i2, int i3, String str2, @Nullable AdSize adSize, String str3) {
        super(context, str, bundle, bundle2, z, location, i2, i3, str2, str3);
        this.f3532k = adSize;
    }

    public AdSize getAdSize() {
        return this.f3532k;
    }
}
