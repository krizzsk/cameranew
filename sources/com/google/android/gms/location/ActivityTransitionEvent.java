package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes2.dex */
public class ActivityTransitionEvent extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ActivityTransitionEvent> CREATOR = new u();
    private final int zzi;
    private final int zzj;
    private final long zzk;

    public ActivityTransitionEvent(int i2, int i3, long j2) {
        DetectedActivity.S(i2);
        ActivityTransition.S(i3);
        this.zzi = i2;
        this.zzj = i3;
        this.zzk = j2;
    }

    public int Q() {
        return this.zzi;
    }

    public long R() {
        return this.zzk;
    }

    public int S() {
        return this.zzj;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ActivityTransitionEvent) {
            ActivityTransitionEvent activityTransitionEvent = (ActivityTransitionEvent) obj;
            return this.zzi == activityTransitionEvent.zzi && this.zzj == activityTransitionEvent.zzj && this.zzk == activityTransitionEvent.zzk;
        }
        return false;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.p.b(Integer.valueOf(this.zzi), Integer.valueOf(this.zzj), Long.valueOf(this.zzk));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i2 = this.zzi;
        StringBuilder sb2 = new StringBuilder(24);
        sb2.append("ActivityType ");
        sb2.append(i2);
        sb.append(sb2.toString());
        sb.append(" ");
        int i3 = this.zzj;
        StringBuilder sb3 = new StringBuilder(26);
        sb3.append("TransitionType ");
        sb3.append(i3);
        sb.append(sb3.toString());
        sb.append(" ");
        long j2 = this.zzk;
        StringBuilder sb4 = new StringBuilder(41);
        sb4.append("ElapsedRealTimeNanos ");
        sb4.append(j2);
        sb.append(sb4.toString());
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 1, Q());
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 2, S());
        com.google.android.gms.common.internal.safeparcel.a.q(parcel, 3, R());
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }
}
