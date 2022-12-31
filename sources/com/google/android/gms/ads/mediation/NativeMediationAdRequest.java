package com.google.android.gms.ads.mediation;

import androidx.annotation.NonNull;
import com.google.android.gms.ads.formats.NativeAdOptions;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public interface NativeMediationAdRequest extends MediationAdRequest {
    float getAdVolume();

    @Deprecated
    NativeAdOptions getNativeAdOptions();

    @NonNull
    com.google.android.gms.ads.nativead.NativeAdOptions getNativeAdRequestOptions();

    boolean isAdMuted();

    boolean isAppInstallAdRequested();

    boolean isContentAdRequested();

    boolean isUnifiedNativeAdRequested();

    boolean zzvl();

    Map<String, Boolean> zzvm();
}
