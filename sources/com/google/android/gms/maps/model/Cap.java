package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.dynamic.b;
/* loaded from: classes2.dex */
public class Cap extends AbstractSafeParcelable {
    @Nullable
    private final a bitmapDescriptor;
    private final int type;
    @Nullable
    private final Float zzcn;
    private static final String TAG = Cap.class.getSimpleName();
    public static final Parcelable.Creator<Cap> CREATOR = new e();

    private Cap(int i2, @Nullable a aVar, @Nullable Float f2) {
        com.google.android.gms.common.internal.q.b(i2 != 3 || (aVar != null && (f2 != null && (f2.floatValue() > 0.0f ? 1 : (f2.floatValue() == 0.0f ? 0 : -1)) > 0)), String.format("Invalid Cap: type=%s bitmapDescriptor=%s bitmapRefWidth=%s", Integer.valueOf(i2), aVar, f2));
        this.type = i2;
        this.bitmapDescriptor = aVar;
        this.zzcn = f2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Cap) {
            Cap cap = (Cap) obj;
            return this.type == cap.type && com.google.android.gms.common.internal.p.a(this.bitmapDescriptor, cap.bitmapDescriptor) && com.google.android.gms.common.internal.p.a(this.zzcn, cap.zzcn);
        }
        return false;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.p.b(Integer.valueOf(this.type), this.bitmapDescriptor, this.zzcn);
    }

    public String toString() {
        int i2 = this.type;
        StringBuilder sb = new StringBuilder(23);
        sb.append("[Cap: type=");
        sb.append(i2);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 2, this.type);
        a aVar = this.bitmapDescriptor;
        com.google.android.gms.common.internal.safeparcel.a.l(parcel, 3, aVar == null ? null : aVar.a().asBinder(), false);
        com.google.android.gms.common.internal.safeparcel.a.k(parcel, 4, this.zzcn, false);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Cap(int i2, @Nullable IBinder iBinder, @Nullable Float f2) {
        this(i2, iBinder == null ? null : new a(b.a.x0(iBinder)), f2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Cap(int i2) {
        this(i2, (a) null, (Float) null);
    }
}
