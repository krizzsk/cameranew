package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Set;
/* loaded from: classes2.dex */
public final class zzp extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzp> CREATOR;
    private static final zzp zzaw;
    private static final zzp zzax;
    private static final zzp zzay;
    private static final Set<zzp> zzaz;
    private final String type;
    private final int zzba;

    static {
        zzp h2 = h("test_type", 1);
        zzaw = h2;
        zzp h3 = h("labeled_place", 6);
        zzax = h3;
        zzp h4 = h("here_content", 7);
        zzay = h4;
        zzaz = com.google.android.gms.common.util.f.f(h2, h3, h4);
        CREATOR = new k();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzp(String str, int i2) {
        q.f(str);
        this.type = str;
        this.zzba = i2;
    }

    private static zzp h(String str, int i2) {
        return new zzp(str, i2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzp) {
            zzp zzpVar = (zzp) obj;
            return this.type.equals(zzpVar.type) && this.zzba == zzpVar.zzba;
        }
        return false;
    }

    public final int hashCode() {
        return this.type.hashCode();
    }

    public final String toString() {
        return this.type;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 1, this.type, false);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 2, this.zzba);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }
}
