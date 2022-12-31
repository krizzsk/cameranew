package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.growingio.android.sdk.utils.NetworkUtil;
import java.util.Comparator;
/* loaded from: classes2.dex */
public class DetectedActivity extends AbstractSafeParcelable {
    public static final int IN_VEHICLE = 0;
    public static final int ON_BICYCLE = 1;
    public static final int ON_FOOT = 2;
    public static final int RUNNING = 8;
    public static final int STILL = 3;
    public static final int TILTING = 5;
    public static final int UNKNOWN = 4;
    public static final int WALKING = 7;
    private int zzi;
    private int zzs;
    private static final Comparator<DetectedActivity> zzo = new y();
    private static final int[] zzp = {9, 10};
    private static final int[] zzq = {0, 1, 2, 4, 5, 6, 7, 8, 10, 11, 12, 13, 14, 16, 17, 18, 19};
    private static final int[] zzr = {0, 1, 2, 3, 7, 8, 16, 17};
    public static final Parcelable.Creator<DetectedActivity> CREATOR = new z();

    public DetectedActivity(int i2, int i3) {
        this.zzi = i2;
        this.zzs = i3;
    }

    public static void S(int i2) {
        boolean z = false;
        for (int i3 : zzr) {
            if (i3 == i2) {
                z = true;
            }
        }
        if (z) {
            return;
        }
        StringBuilder sb = new StringBuilder(81);
        sb.append(i2);
        sb.append(" is not a valid DetectedActivity supported by Activity Transition API.");
        Log.w("DetectedActivity", sb.toString());
    }

    public int Q() {
        return this.zzs;
    }

    public int R() {
        int i2 = this.zzi;
        if (i2 > 19 || i2 < 0) {
            return 4;
        }
        return i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            DetectedActivity detectedActivity = (DetectedActivity) obj;
            if (this.zzi == detectedActivity.zzi && this.zzs == detectedActivity.zzs) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.p.b(Integer.valueOf(this.zzi), Integer.valueOf(this.zzs));
    }

    public String toString() {
        String str;
        int R = R();
        if (R == 0) {
            str = "IN_VEHICLE";
        } else if (R == 1) {
            str = "ON_BICYCLE";
        } else if (R == 2) {
            str = "ON_FOOT";
        } else if (R == 3) {
            str = "STILL";
        } else if (R == 4) {
            str = NetworkUtil.NETWORK_UNKNOWN;
        } else if (R == 5) {
            str = "TILTING";
        } else if (R == 7) {
            str = "WALKING";
        } else if (R != 8) {
            switch (R) {
                case 16:
                    str = "IN_ROAD_VEHICLE";
                    break;
                case 17:
                    str = "IN_RAIL_VEHICLE";
                    break;
                case 18:
                    str = "IN_TWO_WHEELER_VEHICLE";
                    break;
                case 19:
                    str = "IN_FOUR_WHEELER_VEHICLE";
                    break;
                default:
                    str = Integer.toString(R);
                    break;
            }
        } else {
            str = "RUNNING";
        }
        int i2 = this.zzs;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 48);
        sb.append("DetectedActivity [type=");
        sb.append(str);
        sb.append(", confidence=");
        sb.append(i2);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 1, this.zzi);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 2, this.zzs);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }
}
