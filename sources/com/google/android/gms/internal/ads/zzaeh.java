package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaeh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaeh> CREATOR = new zzaeg();
    public final int versionCode;
    public final int zzbns;
    public final int zzbnt;
    public final boolean zzbnu;
    public final int zzbnv;
    public final boolean zzbnx;
    public final boolean zzdft;
    @Nullable
    public final zzaau zzdfu;

    public zzaeh(NativeAdOptions nativeAdOptions) {
        this(4, nativeAdOptions.shouldReturnUrlsForImageAssets(), nativeAdOptions.getImageOrientation(), nativeAdOptions.shouldRequestMultipleImages(), nativeAdOptions.getAdChoicesPlacement(), nativeAdOptions.getVideoOptions() != null ? new zzaau(nativeAdOptions.getVideoOptions()) : null, nativeAdOptions.zzjt(), nativeAdOptions.getMediaAspectRatio());
    }

    @NonNull
    public static com.google.android.gms.ads.nativead.NativeAdOptions zzb(zzaeh zzaehVar) {
        NativeAdOptions.Builder builder = new NativeAdOptions.Builder();
        if (zzaehVar == null) {
            return builder.build();
        }
        int i2 = zzaehVar.versionCode;
        if (i2 != 2) {
            if (i2 != 3) {
                if (i2 == 4) {
                    builder.setRequestCustomMuteThisAd(zzaehVar.zzbnx).setMediaAspectRatio(zzaehVar.zzbnt);
                }
                builder.setReturnUrlsForImageAssets(zzaehVar.zzdft).setRequestMultipleImages(zzaehVar.zzbnu);
                return builder.build();
            }
            zzaau zzaauVar = zzaehVar.zzdfu;
            if (zzaauVar != null) {
                builder.setVideoOptions(new VideoOptions(zzaauVar));
            }
        }
        builder.setAdChoicesPlacement(zzaehVar.zzbnv);
        builder.setReturnUrlsForImageAssets(zzaehVar.zzdft).setRequestMultipleImages(zzaehVar.zzbnu);
        return builder.build();
    }

    @NonNull
    public static com.google.android.gms.ads.formats.NativeAdOptions zzc(zzaeh zzaehVar) {
        NativeAdOptions.Builder builder = new NativeAdOptions.Builder();
        if (zzaehVar == null) {
            return builder.build();
        }
        int i2 = zzaehVar.versionCode;
        if (i2 != 2) {
            if (i2 != 3) {
                if (i2 == 4) {
                    builder.setRequestCustomMuteThisAd(zzaehVar.zzbnx).setMediaAspectRatio(zzaehVar.zzbnt);
                }
                builder.setReturnUrlsForImageAssets(zzaehVar.zzdft).setImageOrientation(zzaehVar.zzbns).setRequestMultipleImages(zzaehVar.zzbnu);
                return builder.build();
            }
            zzaau zzaauVar = zzaehVar.zzdfu;
            if (zzaauVar != null) {
                builder.setVideoOptions(new VideoOptions(zzaauVar));
            }
        }
        builder.setAdChoicesPlacement(zzaehVar.zzbnv);
        builder.setReturnUrlsForImageAssets(zzaehVar.zzdft).setImageOrientation(zzaehVar.zzbns).setRequestMultipleImages(zzaehVar.zzbnu);
        return builder.build();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = a.a(parcel);
        a.m(parcel, 1, this.versionCode);
        a.c(parcel, 2, this.zzdft);
        a.m(parcel, 3, this.zzbns);
        a.c(parcel, 4, this.zzbnu);
        a.m(parcel, 5, this.zzbnv);
        a.t(parcel, 6, this.zzdfu, i2, false);
        a.c(parcel, 7, this.zzbnx);
        a.m(parcel, 8, this.zzbnt);
        a.b(parcel, a);
    }

    public zzaeh(com.google.android.gms.ads.nativead.NativeAdOptions nativeAdOptions) {
        this(4, nativeAdOptions.shouldReturnUrlsForImageAssets(), -1, nativeAdOptions.shouldRequestMultipleImages(), nativeAdOptions.getAdChoicesPlacement(), nativeAdOptions.getVideoOptions() != null ? new zzaau(nativeAdOptions.getVideoOptions()) : null, nativeAdOptions.zzjt(), nativeAdOptions.getMediaAspectRatio());
    }

    public zzaeh(int i2, boolean z, int i3, boolean z2, int i4, zzaau zzaauVar, boolean z3, int i5) {
        this.versionCode = i2;
        this.zzdft = z;
        this.zzbns = i3;
        this.zzbnu = z2;
        this.zzbnv = i4;
        this.zzdfu = zzaauVar;
        this.zzbnx = z3;
        this.zzbnt = i5;
    }
}
