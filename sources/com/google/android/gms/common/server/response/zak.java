package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public final class zak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zak> CREATOR = new d();
    final String a;
    final ArrayList<zan> b;
    private final int versionCode;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zak(int i2, String str, ArrayList<zan> arrayList) {
        this.versionCode = i2;
        this.a = str;
        this.b = arrayList;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 1, this.versionCode);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 2, this.a, false);
        com.google.android.gms.common.internal.safeparcel.a.z(parcel, 3, this.b, false);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zak(String str, Map<String, FastJsonResponse.Field<?, ?>> map) {
        ArrayList<zan> arrayList;
        this.versionCode = 1;
        this.a = str;
        if (map == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList<>();
            for (String str2 : map.keySet()) {
                arrayList.add(new zan(str2, map.get(str2)));
            }
        }
        this.b = arrayList;
    }
}
