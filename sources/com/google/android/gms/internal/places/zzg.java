package com.google.android.gms.internal.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
@Deprecated
/* loaded from: classes2.dex */
public final class zzg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzg> CREATOR = new zzf();
    private static final zzg zzda = new zzg("Home");
    private static final zzg zzdb = new zzg("Work");
    private final String zzdc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzg(String str) {
        this.zzdc = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzg) {
            return p.a(this.zzdc, ((zzg) obj).zzdc);
        }
        return false;
    }

    public final int hashCode() {
        return p.b(this.zzdc);
    }

    public final String toString() {
        p.a c = p.c(this);
        c.a("alias", this.zzdc);
        return c.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = a.a(parcel);
        a.v(parcel, 1, this.zzdc, false);
        a.b(parcel, a);
    }
}
