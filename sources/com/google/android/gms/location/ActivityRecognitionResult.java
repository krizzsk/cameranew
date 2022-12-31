package com.google.android.gms.location;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;
/* loaded from: classes2.dex */
public class ActivityRecognitionResult extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<ActivityRecognitionResult> CREATOR = new s();
    private Bundle extras;
    private List<DetectedActivity> zze;
    private long zzf;
    private long zzg;
    private int zzh;

    public ActivityRecognitionResult(List<DetectedActivity> list, long j2, long j3, int i2, Bundle bundle) {
        boolean z = true;
        com.google.android.gms.common.internal.q.b(list != null && list.size() > 0, "Must have at least 1 detected activity");
        com.google.android.gms.common.internal.q.b((j2 <= 0 || j3 <= 0) ? false : false, "Must set times");
        this.zze = list;
        this.zzf = j2;
        this.zzg = j3;
        this.zzh = i2;
        this.extras = bundle;
    }

    private static boolean h(Bundle bundle, Bundle bundle2) {
        if (bundle == null && bundle2 == null) {
            return true;
        }
        if ((bundle != null || bundle2 == null) && ((bundle == null || bundle2 != null) && bundle.size() == bundle2.size())) {
            for (String str : bundle.keySet()) {
                if (!bundle2.containsKey(str)) {
                    return false;
                }
                if (bundle.get(str) == null) {
                    if (bundle2.get(str) != null) {
                        return false;
                    }
                } else if (bundle.get(str) instanceof Bundle) {
                    if (!h(bundle.getBundle(str), bundle2.getBundle(str))) {
                        return false;
                    }
                } else if (!bundle.get(str).equals(bundle2.get(str))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ActivityRecognitionResult activityRecognitionResult = (ActivityRecognitionResult) obj;
            if (this.zzf == activityRecognitionResult.zzf && this.zzg == activityRecognitionResult.zzg && this.zzh == activityRecognitionResult.zzh && com.google.android.gms.common.internal.p.a(this.zze, activityRecognitionResult.zze) && h(this.extras, activityRecognitionResult.extras)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.p.b(Long.valueOf(this.zzf), Long.valueOf(this.zzg), Integer.valueOf(this.zzh), this.zze, this.extras);
    }

    public String toString() {
        String valueOf = String.valueOf(this.zze);
        long j2 = this.zzf;
        long j3 = this.zzg;
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 124);
        sb.append("ActivityRecognitionResult [probableActivities=");
        sb.append(valueOf);
        sb.append(", timeMillis=");
        sb.append(j2);
        sb.append(", elapsedRealtimeMillis=");
        sb.append(j3);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.z(parcel, 1, this.zze, false);
        com.google.android.gms.common.internal.safeparcel.a.q(parcel, 2, this.zzf);
        com.google.android.gms.common.internal.safeparcel.a.q(parcel, 3, this.zzg);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 4, this.zzh);
        com.google.android.gms.common.internal.safeparcel.a.e(parcel, 5, this.extras, false);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }
}
