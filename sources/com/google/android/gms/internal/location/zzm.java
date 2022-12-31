package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public final class zzm extends AbstractSafeParcelable {
    @Nullable
    private String tag;
    private com.google.android.gms.location.zzj zzcf;
    private List<ClientIdentity> zzm;
    static final List<ClientIdentity> zzcd = Collections.emptyList();
    static final com.google.android.gms.location.zzj zzce = new com.google.android.gms.location.zzj();
    public static final Parcelable.Creator<zzm> CREATOR = new zzn();

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzm(com.google.android.gms.location.zzj zzjVar, List<ClientIdentity> list, String str) {
        this.zzcf = zzjVar;
        this.zzm = list;
        this.tag = str;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzm) {
            zzm zzmVar = (zzm) obj;
            return p.a(this.zzcf, zzmVar.zzcf) && p.a(this.zzm, zzmVar.zzm) && p.a(this.tag, zzmVar.tag);
        }
        return false;
    }

    public final int hashCode() {
        return this.zzcf.hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = a.a(parcel);
        a.t(parcel, 1, this.zzcf, i2, false);
        a.z(parcel, 2, this.zzm, false);
        a.v(parcel, 3, this.tag, false);
        a.b(parcel, a);
    }
}
