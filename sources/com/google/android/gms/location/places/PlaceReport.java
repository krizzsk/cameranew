package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.tencent.matrix.report.Issue;
/* loaded from: classes2.dex */
public class PlaceReport extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<PlaceReport> CREATOR = new e();
    private final String tag;
    private final int versionCode;
    private final String zza;
    private final String zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PlaceReport(int i2, String str, String str2, String str3) {
        this.versionCode = i2;
        this.zza = str;
        this.tag = str2;
        this.zzb = str3;
    }

    public String Q() {
        return this.zza;
    }

    public String R() {
        return this.tag;
    }

    public boolean equals(Object obj) {
        if (obj instanceof PlaceReport) {
            PlaceReport placeReport = (PlaceReport) obj;
            return p.a(this.zza, placeReport.zza) && p.a(this.tag, placeReport.tag) && p.a(this.zzb, placeReport.zzb);
        }
        return false;
    }

    public int hashCode() {
        return p.b(this.zza, this.tag, this.zzb);
    }

    public String toString() {
        p.a c = p.c(this);
        c.a("placeId", this.zza);
        c.a(Issue.ISSUE_REPORT_TAG, this.tag);
        if (!"unknown".equals(this.zzb)) {
            c.a("source", this.zzb);
        }
        return c.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 1, this.versionCode);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 2, Q(), false);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 3, R(), false);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 4, this.zzb, false);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }
}
