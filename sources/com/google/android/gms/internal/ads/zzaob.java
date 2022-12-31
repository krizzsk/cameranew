package com.google.android.gms.internal.ads;

import android.location.Location;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.Set;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaob implements MediationAdRequest {
    private final String zzadq;
    private final int zzcho;
    private final boolean zzchz;
    private final int zzdnq;
    private final int zzdnr;
    private final Date zzmx;
    private final Set<String> zzmz;
    private final boolean zzna;
    private final Location zznb;

    public zzaob(@Nullable Date date, int i2, @Nullable Set<String> set, @Nullable Location location, boolean z, int i3, boolean z2, int i4, String str) {
        this.zzmx = date;
        this.zzcho = i2;
        this.zzmz = set;
        this.zznb = location;
        this.zzna = z;
        this.zzdnq = i3;
        this.zzchz = z2;
        this.zzdnr = i4;
        this.zzadq = str;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    @Deprecated
    public final Date getBirthday() {
        return this.zzmx;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    @Deprecated
    public final int getGender() {
        return this.zzcho;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final Set<String> getKeywords() {
        return this.zzmz;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final Location getLocation() {
        return this.zznb;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    @Deprecated
    public final boolean isDesignedForFamilies() {
        return this.zzchz;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final boolean isTesting() {
        return this.zzna;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final int taggedForChildDirectedTreatment() {
        return this.zzdnq;
    }
}
