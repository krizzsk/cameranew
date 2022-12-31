package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzatq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzatq> CREATOR = new zzatt();
    private final ApplicationInfo applicationInfo;
    public final String packageName;
    public final zzazn zzdtx;
    @Nullable
    public final PackageInfo zzdue;
    public final List<String> zzduo;
    public final String zzdux;
    public final Bundle zzdxi;
    public final String zzdxj;
    @Nullable
    public zzdpf zzdxk;
    @Nullable
    public String zzdxl;

    public zzatq(Bundle bundle, zzazn zzaznVar, ApplicationInfo applicationInfo, String str, List<String> list, @Nullable PackageInfo packageInfo, String str2, String str3, zzdpf zzdpfVar, String str4) {
        this.zzdxi = bundle;
        this.zzdtx = zzaznVar;
        this.packageName = str;
        this.applicationInfo = applicationInfo;
        this.zzduo = list;
        this.zzdue = packageInfo;
        this.zzdux = str2;
        this.zzdxj = str3;
        this.zzdxk = zzdpfVar;
        this.zzdxl = str4;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = a.a(parcel);
        a.e(parcel, 1, this.zzdxi, false);
        a.t(parcel, 2, this.zzdtx, i2, false);
        a.t(parcel, 3, this.applicationInfo, i2, false);
        a.v(parcel, 4, this.packageName, false);
        a.x(parcel, 5, this.zzduo, false);
        a.t(parcel, 6, this.zzdue, i2, false);
        a.v(parcel, 7, this.zzdux, false);
        a.v(parcel, 9, this.zzdxj, false);
        a.t(parcel, 10, this.zzdxk, i2, false);
        a.v(parcel, 11, this.zzdxl, false);
        a.b(parcel, a);
    }
}
