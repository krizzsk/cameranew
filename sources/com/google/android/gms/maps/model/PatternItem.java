package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes2.dex */
public class PatternItem extends AbstractSafeParcelable {
    private final int type;
    @Nullable
    private final Float zzdv;
    private static final String TAG = PatternItem.class.getSimpleName();
    public static final Parcelable.Creator<PatternItem> CREATOR = new l();

    public PatternItem(int i2, @Nullable Float f2) {
        boolean z = true;
        if (i2 != 1 && (f2 == null || f2.floatValue() < 0.0f)) {
            z = false;
        }
        String valueOf = String.valueOf(f2);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 45);
        sb.append("Invalid PatternItem: type=");
        sb.append(i2);
        sb.append(" length=");
        sb.append(valueOf);
        com.google.android.gms.common.internal.q.b(z, sb.toString());
        this.type = i2;
        this.zzdv = f2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PatternItem) {
            PatternItem patternItem = (PatternItem) obj;
            return this.type == patternItem.type && com.google.android.gms.common.internal.p.a(this.zzdv, patternItem.zzdv);
        }
        return false;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.p.b(Integer.valueOf(this.type), this.zzdv);
    }

    public String toString() {
        int i2 = this.type;
        String valueOf = String.valueOf(this.zzdv);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 39);
        sb.append("[PatternItem: type=");
        sb.append(i2);
        sb.append(" length=");
        sb.append(valueOf);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 2, this.type);
        com.google.android.gms.common.internal.safeparcel.a.k(parcel, 3, this.zzdv, false);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }
}
