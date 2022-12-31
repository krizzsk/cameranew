package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public final class zzbd extends AbstractSafeParcelable {
    @Nullable
    private String moduleId;
    @Nullable
    private String tag;
    private LocationRequest zzdg;
    private boolean zzdh;
    private boolean zzdi;
    private boolean zzdj;
    private boolean zzdk = true;
    private List<ClientIdentity> zzm;
    static final List<ClientIdentity> zzcd = Collections.emptyList();
    public static final Parcelable.Creator<zzbd> CREATOR = new zzbe();

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbd(LocationRequest locationRequest, List<ClientIdentity> list, @Nullable String str, boolean z, boolean z2, boolean z3, String str2) {
        this.zzdg = locationRequest;
        this.zzm = list;
        this.tag = str;
        this.zzdh = z;
        this.zzdi = z2;
        this.zzdj = z3;
        this.moduleId = str2;
    }

    @Deprecated
    public static zzbd zza(LocationRequest locationRequest) {
        return new zzbd(locationRequest, zzcd, null, false, false, false, null);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzbd) {
            zzbd zzbdVar = (zzbd) obj;
            return p.a(this.zzdg, zzbdVar.zzdg) && p.a(this.zzm, zzbdVar.zzm) && p.a(this.tag, zzbdVar.tag) && this.zzdh == zzbdVar.zzdh && this.zzdi == zzbdVar.zzdi && this.zzdj == zzbdVar.zzdj && p.a(this.moduleId, zzbdVar.moduleId);
        }
        return false;
    }

    public final int hashCode() {
        return this.zzdg.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.zzdg);
        if (this.tag != null) {
            sb.append(" tag=");
            sb.append(this.tag);
        }
        if (this.moduleId != null) {
            sb.append(" moduleId=");
            sb.append(this.moduleId);
        }
        sb.append(" hideAppOps=");
        sb.append(this.zzdh);
        sb.append(" clients=");
        sb.append(this.zzm);
        sb.append(" forceCoarseLocation=");
        sb.append(this.zzdi);
        if (this.zzdj) {
            sb.append(" exemptFromBackgroundThrottle");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = a.a(parcel);
        a.t(parcel, 1, this.zzdg, i2, false);
        a.z(parcel, 5, this.zzm, false);
        a.v(parcel, 6, this.tag, false);
        a.c(parcel, 7, this.zzdh);
        a.c(parcel, 8, this.zzdi);
        a.c(parcel, 9, this.zzdj);
        a.v(parcel, 10, this.moduleId, false);
        a.b(parcel, a);
    }
}
