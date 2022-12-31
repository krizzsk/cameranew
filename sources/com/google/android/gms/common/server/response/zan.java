package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public final class zan extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zan> CREATOR = new a();
    final String a;
    final FastJsonResponse.Field<?, ?> b;
    private final int versionCode;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zan(int i2, String str, FastJsonResponse.Field<?, ?> field) {
        this.versionCode = i2;
        this.a = str;
        this.b = field;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 1, this.versionCode);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 2, this.a, false);
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 3, this.b, i2, false);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zan(String str, FastJsonResponse.Field<?, ?> field) {
        this.versionCode = 1;
        this.a = str;
        this.b = field;
    }
}
