package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public class ActivityTransitionResult extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ActivityTransitionResult> CREATOR = new x();
    private final List<ActivityTransitionEvent> zzn;

    public ActivityTransitionResult(List<ActivityTransitionEvent> list) {
        com.google.android.gms.common.internal.q.k(list, "transitionEvents list can't be null.");
        if (!list.isEmpty()) {
            for (int i2 = 1; i2 < list.size(); i2++) {
                com.google.android.gms.common.internal.q.a(list.get(i2).R() >= list.get(i2 + (-1)).R());
            }
        }
        this.zzn = Collections.unmodifiableList(list);
    }

    public List<ActivityTransitionEvent> Q() {
        return this.zzn;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.zzn.equals(((ActivityTransitionResult) obj).zzn);
    }

    public int hashCode() {
        return this.zzn.hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.z(parcel, 1, Q(), false);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }
}
