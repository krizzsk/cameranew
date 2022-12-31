package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import androidx.core.location.LocationRequestCompat;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes2.dex */
public final class zzj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzj> CREATOR = new a0();
    private boolean zzt;
    private long zzu;
    private float zzv;
    private long zzw;
    private int zzx;

    public zzj() {
        this(true, 50L, 0.0f, LocationRequestCompat.PASSIVE_INTERVAL, Integer.MAX_VALUE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzj(boolean z, long j2, float f2, long j3, int i2) {
        this.zzt = z;
        this.zzu = j2;
        this.zzv = f2;
        this.zzw = j3;
        this.zzx = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzj) {
            zzj zzjVar = (zzj) obj;
            return this.zzt == zzjVar.zzt && this.zzu == zzjVar.zzu && Float.compare(this.zzv, zzjVar.zzv) == 0 && this.zzw == zzjVar.zzw && this.zzx == zzjVar.zzx;
        }
        return false;
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.p.b(Boolean.valueOf(this.zzt), Long.valueOf(this.zzu), Float.valueOf(this.zzv), Long.valueOf(this.zzw), Integer.valueOf(this.zzx));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DeviceOrientationRequest[mShouldUseMag=");
        sb.append(this.zzt);
        sb.append(" mMinimumSamplingPeriodMs=");
        sb.append(this.zzu);
        sb.append(" mSmallestAngleChangeRadians=");
        sb.append(this.zzv);
        long j2 = this.zzw;
        if (j2 != LocationRequestCompat.PASSIVE_INTERVAL) {
            sb.append(" expireIn=");
            sb.append(j2 - SystemClock.elapsedRealtime());
            sb.append("ms");
        }
        if (this.zzx != Integer.MAX_VALUE) {
            sb.append(" num=");
            sb.append(this.zzx);
        }
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.c(parcel, 1, this.zzt);
        com.google.android.gms.common.internal.safeparcel.a.q(parcel, 2, this.zzu);
        com.google.android.gms.common.internal.safeparcel.a.j(parcel, 3, this.zzv);
        com.google.android.gms.common.internal.safeparcel.a.q(parcel, 4, this.zzw);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 5, this.zzx);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }
}
