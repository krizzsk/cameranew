package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import javax.annotation.ParametersAreNonnullByDefault;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzawh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzawh> CREATOR = new zzawg();
    public final String zzdzh;
    public final String zzdzi;

    public zzawh(ServerSideVerificationOptions serverSideVerificationOptions) {
        this(serverSideVerificationOptions.getUserId(), serverSideVerificationOptions.getCustomData());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = a.a(parcel);
        a.v(parcel, 1, this.zzdzh, false);
        a.v(parcel, 2, this.zzdzi, false);
        a.b(parcel, a);
    }

    public zzawh(String str, String str2) {
        this.zzdzh = str;
        this.zzdzi = str2;
    }
}
