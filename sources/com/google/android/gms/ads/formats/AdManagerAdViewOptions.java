package com.google.android.gms.ads.formats;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.ads.zzaas;
import com.google.android.gms.internal.ads.zzagk;
import com.google.android.gms.internal.ads.zzagl;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class AdManagerAdViewOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AdManagerAdViewOptions> CREATOR = new zzb();
    private final boolean zzbni;
    @Nullable
    private final IBinder zzbnj;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class Builder {
        private boolean a = false;
        @Nullable
        private ShouldDelayBannerRenderingListener b;

        public final AdManagerAdViewOptions build() {
            return new AdManagerAdViewOptions(this);
        }

        public final Builder setManualImpressionsEnabled(boolean z) {
            this.a = z;
            return this;
        }

        public final Builder setShouldDelayBannerRenderingListener(ShouldDelayBannerRenderingListener shouldDelayBannerRenderingListener) {
            this.b = shouldDelayBannerRenderingListener;
            return this;
        }
    }

    private AdManagerAdViewOptions(Builder builder) {
        this.zzbni = builder.a;
        this.zzbnj = builder.b != null ? new zzaas(builder.b) : null;
    }

    public final boolean getManualImpressionsEnabled() {
        return this.zzbni;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.c(parcel, 1, getManualImpressionsEnabled());
        com.google.android.gms.common.internal.safeparcel.a.l(parcel, 2, this.zzbnj, false);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }

    @Nullable
    public final zzagl zzjr() {
        return zzagk.zzy(this.zzbnj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdManagerAdViewOptions(boolean z, @Nullable IBinder iBinder) {
        this.zzbni = z;
        this.zzbnj = iBinder;
    }
}
