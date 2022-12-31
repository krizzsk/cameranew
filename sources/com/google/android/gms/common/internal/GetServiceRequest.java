package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.j;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public class GetServiceRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GetServiceRequest> CREATOR = new e0();
    String a;
    IBinder b;
    Scope[] c;

    /* renamed from: d  reason: collision with root package name */
    Bundle f3653d;

    /* renamed from: e  reason: collision with root package name */
    Account f3654e;

    /* renamed from: f  reason: collision with root package name */
    Feature[] f3655f;

    /* renamed from: g  reason: collision with root package name */
    Feature[] f3656g;
    private final int zzh;
    private final int zzi;
    private int zzj;
    private boolean zzk;
    private int zzl;

    public GetServiceRequest(int i2) {
        this.zzh = 4;
        this.zzj = GoogleApiAvailabilityLight.a;
        this.zzi = i2;
        this.zzk = true;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 1, this.zzh);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 2, this.zzi);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 3, this.zzj);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 4, this.a, false);
        com.google.android.gms.common.internal.safeparcel.a.l(parcel, 5, this.b, false);
        com.google.android.gms.common.internal.safeparcel.a.y(parcel, 6, this.c, i2, false);
        com.google.android.gms.common.internal.safeparcel.a.e(parcel, 7, this.f3653d, false);
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 8, this.f3654e, i2, false);
        com.google.android.gms.common.internal.safeparcel.a.y(parcel, 10, this.f3655f, i2, false);
        com.google.android.gms.common.internal.safeparcel.a.y(parcel, 11, this.f3656g, i2, false);
        com.google.android.gms.common.internal.safeparcel.a.c(parcel, 12, this.zzk);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 13, this.zzl);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GetServiceRequest(int i2, int i3, int i4, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, Feature[] featureArr, Feature[] featureArr2, boolean z, int i5) {
        this.zzh = i2;
        this.zzi = i3;
        this.zzj = i4;
        if ("com.google.android.gms".equals(str)) {
            this.a = "com.google.android.gms";
        } else {
            this.a = str;
        }
        if (i2 < 2) {
            this.f3654e = iBinder != null ? a.y0(j.a.x0(iBinder)) : null;
        } else {
            this.b = iBinder;
            this.f3654e = account;
        }
        this.c = scopeArr;
        this.f3653d = bundle;
        this.f3655f = featureArr;
        this.f3656g = featureArr2;
        this.zzk = z;
        this.zzl = i5;
    }
}
