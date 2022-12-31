package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.location.zzbh;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class GeofencingRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GeofencingRequest> CREATOR = new b0();
    public static final int INITIAL_TRIGGER_DWELL = 4;
    public static final int INITIAL_TRIGGER_ENTER = 1;
    public static final int INITIAL_TRIGGER_EXIT = 2;
    private final String tag;
    private final List<zzbh> zzap;
    private final int zzaq;

    /* loaded from: classes2.dex */
    public static final class a {
        private final List<zzbh> a = new ArrayList();
        private int b = 5;
        private String c = "";

        public final a a(b bVar) {
            com.google.android.gms.common.internal.q.k(bVar, "geofence can't be null.");
            com.google.android.gms.common.internal.q.b(bVar instanceof zzbh, "Geofence must be created using Geofence.Builder.");
            this.a.add((zzbh) bVar);
            return this;
        }

        public final a b(List<b> list) {
            if (list != null && !list.isEmpty()) {
                for (b bVar : list) {
                    if (bVar != null) {
                        a(bVar);
                    }
                }
            }
            return this;
        }

        public final GeofencingRequest c() {
            com.google.android.gms.common.internal.q.b(!this.a.isEmpty(), "No geofence has been added to this request.");
            return new GeofencingRequest(this.a, this.b, this.c);
        }

        public final a d(int i2) {
            this.b = i2 & 7;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GeofencingRequest(List<zzbh> list, int i2, String str) {
        this.zzap = list;
        this.zzaq = i2;
        this.tag = str;
    }

    public int Q() {
        return this.zzaq;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GeofencingRequest[");
        sb.append("geofences=");
        sb.append(this.zzap);
        int i2 = this.zzaq;
        StringBuilder sb2 = new StringBuilder(30);
        sb2.append(", initialTrigger=");
        sb2.append(i2);
        sb2.append(", ");
        sb.append(sb2.toString());
        String valueOf = String.valueOf(this.tag);
        sb.append(valueOf.length() != 0 ? "tag=".concat(valueOf) : new String("tag="));
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.z(parcel, 1, this.zzap, false);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 2, Q());
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 3, this.tag, false);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a2);
    }
}
