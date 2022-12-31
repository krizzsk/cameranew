package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import androidx.core.location.LocationRequestCompat;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes2.dex */
public final class LocationRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<LocationRequest> CREATOR = new i();
    public static final int PRIORITY_BALANCED_POWER_ACCURACY = 102;
    public static final int PRIORITY_HIGH_ACCURACY = 100;
    public static final int PRIORITY_LOW_POWER = 104;
    public static final int PRIORITY_NO_POWER = 105;
    private int priority;
    private long zzaf;
    private long zzaw;
    private long zzax;
    private boolean zzay;
    private float zzaz;
    private long zzba;
    private int zzx;

    public LocationRequest() {
        this.priority = 102;
        this.zzaw = 3600000L;
        this.zzax = 600000L;
        this.zzay = false;
        this.zzaf = LocationRequestCompat.PASSIVE_INTERVAL;
        this.zzx = Integer.MAX_VALUE;
        this.zzaz = 0.0f;
        this.zzba = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocationRequest(int i2, long j2, long j3, boolean z, long j4, int i3, float f2, long j5) {
        this.priority = i2;
        this.zzaw = j2;
        this.zzax = j3;
        this.zzay = z;
        this.zzaf = j4;
        this.zzx = i3;
        this.zzaz = f2;
        this.zzba = j5;
    }

    public final long Q() {
        long j2 = this.zzba;
        long j3 = this.zzaw;
        return j2 < j3 ? j3 : j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LocationRequest) {
            LocationRequest locationRequest = (LocationRequest) obj;
            return this.priority == locationRequest.priority && this.zzaw == locationRequest.zzaw && this.zzax == locationRequest.zzax && this.zzay == locationRequest.zzay && this.zzaf == locationRequest.zzaf && this.zzx == locationRequest.zzx && this.zzaz == locationRequest.zzaz && Q() == locationRequest.Q();
        }
        return false;
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.p.b(Integer.valueOf(this.priority), Long.valueOf(this.zzaw), Float.valueOf(this.zzaz), Long.valueOf(this.zzba));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request[");
        int i2 = this.priority;
        sb.append(i2 != 100 ? i2 != 102 ? i2 != 104 ? i2 != 105 ? "???" : "PRIORITY_NO_POWER" : "PRIORITY_LOW_POWER" : "PRIORITY_BALANCED_POWER_ACCURACY" : "PRIORITY_HIGH_ACCURACY");
        if (this.priority != 105) {
            sb.append(" requested=");
            sb.append(this.zzaw);
            sb.append("ms");
        }
        sb.append(" fastest=");
        sb.append(this.zzax);
        sb.append("ms");
        if (this.zzba > this.zzaw) {
            sb.append(" maxWait=");
            sb.append(this.zzba);
            sb.append("ms");
        }
        if (this.zzaz > 0.0f) {
            sb.append(" smallestDisplacement=");
            sb.append(this.zzaz);
            sb.append("m");
        }
        long j2 = this.zzaf;
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
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 1, this.priority);
        com.google.android.gms.common.internal.safeparcel.a.q(parcel, 2, this.zzaw);
        com.google.android.gms.common.internal.safeparcel.a.q(parcel, 3, this.zzax);
        com.google.android.gms.common.internal.safeparcel.a.c(parcel, 4, this.zzay);
        com.google.android.gms.common.internal.safeparcel.a.q(parcel, 5, this.zzaf);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 6, this.zzx);
        com.google.android.gms.common.internal.safeparcel.a.j(parcel, 7, this.zzaz);
        com.google.android.gms.common.internal.safeparcel.a.q(parcel, 8, this.zzba);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }
}
