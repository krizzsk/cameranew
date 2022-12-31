package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.mediation.VersionInfo;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.Arrays;
import javax.annotation.ParametersAreNonnullByDefault;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzapy extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzapy> CREATOR = new zzaqb();
    private final int major;
    private final int minor;
    private final int zzdow;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzapy(int i2, int i3, int i4) {
        this.major = i2;
        this.minor = i3;
        this.zzdow = i4;
    }

    public static zzapy zza(VersionInfo versionInfo) {
        return new zzapy(versionInfo.getMajorVersion(), versionInfo.getMinorVersion(), versionInfo.getMicroVersion());
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zzapy)) {
            zzapy zzapyVar = (zzapy) obj;
            if (zzapyVar.zzdow == this.zzdow && zzapyVar.minor == this.minor && zzapyVar.major == this.major) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new int[]{this.major, this.minor, this.zzdow});
    }

    public final String toString() {
        int i2 = this.major;
        int i3 = this.minor;
        int i4 = this.zzdow;
        StringBuilder sb = new StringBuilder(35);
        sb.append(i2);
        sb.append(".");
        sb.append(i3);
        sb.append(".");
        sb.append(i4);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = a.a(parcel);
        a.m(parcel, 1, this.major);
        a.m(parcel, 2, this.minor);
        a.m(parcel, 3, this.zzdow);
        a.b(parcel, a);
    }
}
