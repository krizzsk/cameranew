package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.e;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
/* loaded from: classes2.dex */
public final class zzbk {
    public final e<LocationSettingsResult> checkLocationSettings(GoogleApiClient googleApiClient, LocationSettingsRequest locationSettingsRequest) {
        return googleApiClient.a(new zzbl(this, googleApiClient, locationSettingsRequest, null));
    }
}
