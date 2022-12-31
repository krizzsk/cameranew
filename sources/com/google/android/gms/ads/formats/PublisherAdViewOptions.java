package com.google.android.gms.ads.formats;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.ads.zzaas;
import com.google.android.gms.internal.ads.zzagk;
import com.google.android.gms.internal.ads.zzagl;
import com.google.android.gms.internal.ads.zzvy;
import com.google.android.gms.internal.ads.zzxt;
import com.google.android.gms.internal.ads.zzxw;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
@Deprecated
/* loaded from: classes2.dex */
public final class PublisherAdViewOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PublisherAdViewOptions> CREATOR = new zze();
    private final boolean zzbni;
    @Nullable
    private final IBinder zzbnj;
    @Nullable
    private final zzxt zzbod;
    @Nullable
    private AppEventListener zzboe;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
    @Deprecated
    /* loaded from: classes2.dex */
    public static final class Builder {
        private boolean a = false;
        @Nullable
        private AppEventListener b;
        @Nullable
        private ShouldDelayBannerRenderingListener c;

        public final PublisherAdViewOptions build() {
            return new PublisherAdViewOptions(this);
        }

        public final Builder setAppEventListener(AppEventListener appEventListener) {
            this.b = appEventListener;
            return this;
        }

        public final Builder setManualImpressionsEnabled(boolean z) {
            this.a = z;
            return this;
        }

        public final Builder setShouldDelayBannerRenderingListener(ShouldDelayBannerRenderingListener shouldDelayBannerRenderingListener) {
            this.c = shouldDelayBannerRenderingListener;
            return this;
        }
    }

    private PublisherAdViewOptions(Builder builder) {
        this.zzbni = builder.a;
        AppEventListener appEventListener = builder.b;
        this.zzboe = appEventListener;
        this.zzbod = appEventListener != null ? new zzvy(this.zzboe) : null;
        this.zzbnj = builder.c != null ? new zzaas(builder.c) : null;
    }

    @Nullable
    public final AppEventListener getAppEventListener() {
        return this.zzboe;
    }

    public final boolean getManualImpressionsEnabled() {
        return this.zzbni;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.c(parcel, 1, getManualImpressionsEnabled());
        zzxt zzxtVar = this.zzbod;
        com.google.android.gms.common.internal.safeparcel.a.l(parcel, 2, zzxtVar == null ? null : zzxtVar.asBinder(), false);
        com.google.android.gms.common.internal.safeparcel.a.l(parcel, 3, this.zzbnj, false);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }

    @Nullable
    public final zzagl zzjr() {
        return zzagk.zzy(this.zzbnj);
    }

    @Nullable
    public final zzxt zzjv() {
        return this.zzbod;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PublisherAdViewOptions(boolean z, @Nullable IBinder iBinder, @Nullable IBinder iBinder2) {
        this.zzbni = z;
        this.zzbod = iBinder != null ? zzxw.zze(iBinder) : null;
        this.zzbnj = iBinder2;
    }
}
