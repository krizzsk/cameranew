package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import javax.annotation.ParametersAreNonnullByDefault;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzaye extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaye> CREATOR = new zzayh();
    public final String zzbrm;
    @Deprecated
    public final String zzbut;
    @Deprecated
    public final zzvs zzebq;
    public final zzvl zzebr;

    public zzaye(String str, String str2, zzvs zzvsVar, zzvl zzvlVar) {
        this.zzbut = str;
        this.zzbrm = str2;
        this.zzebq = zzvsVar;
        this.zzebr = zzvlVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = a.a(parcel);
        a.v(parcel, 1, this.zzbut, false);
        a.v(parcel, 2, this.zzbrm, false);
        a.t(parcel, 3, this.zzebq, i2, false);
        a.t(parcel, 4, this.zzebr, i2, false);
        a.b(parcel, a);
    }
}
