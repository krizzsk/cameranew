package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes2.dex */
public class ActivityTransition extends AbstractSafeParcelable {
    public static final int ACTIVITY_TRANSITION_ENTER = 0;
    public static final int ACTIVITY_TRANSITION_EXIT = 1;
    public static final Parcelable.Creator<ActivityTransition> CREATOR = new t();
    private final int zzi;
    private final int zzj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ActivityTransition(int i2, int i3) {
        this.zzi = i2;
        this.zzj = i3;
    }

    public static void S(int i2) {
        boolean z = true;
        z = (i2 < 0 || i2 > 1) ? false : false;
        StringBuilder sb = new StringBuilder(41);
        sb.append("Transition type ");
        sb.append(i2);
        sb.append(" is not valid.");
        com.google.android.gms.common.internal.q.b(z, sb.toString());
    }

    public int Q() {
        return this.zzi;
    }

    public int R() {
        return this.zzj;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ActivityTransition) {
            ActivityTransition activityTransition = (ActivityTransition) obj;
            return this.zzi == activityTransition.zzi && this.zzj == activityTransition.zzj;
        }
        return false;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.p.b(Integer.valueOf(this.zzi), Integer.valueOf(this.zzj));
    }

    public String toString() {
        int i2 = this.zzi;
        int i3 = this.zzj;
        StringBuilder sb = new StringBuilder(75);
        sb.append("ActivityTransition [mActivityType=");
        sb.append(i2);
        sb.append(", mTransitionType=");
        sb.append(i3);
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 1, Q());
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 2, R());
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }
}
