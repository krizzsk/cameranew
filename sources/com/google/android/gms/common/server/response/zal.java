package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public final class zal extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zal> CREATOR = new c();
    private final int zalk;
    private final HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> zarm;
    private final ArrayList<zak> zarn = null;
    private final String zaro;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zal(int i2, ArrayList<zak> arrayList, String str) {
        this.zalk = i2;
        HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> hashMap = new HashMap<>();
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            zak zakVar = arrayList.get(i3);
            String str2 = zakVar.a;
            HashMap hashMap2 = new HashMap();
            int size2 = zakVar.b.size();
            for (int i4 = 0; i4 < size2; i4++) {
                zan zanVar = zakVar.b.get(i4);
                hashMap2.put(zanVar.a, zanVar.b);
            }
            hashMap.put(str2, hashMap2);
        }
        this.zarm = hashMap;
        q.j(str);
        this.zaro = str;
        Q();
    }

    public final void Q() {
        for (String str : this.zarm.keySet()) {
            Map<String, FastJsonResponse.Field<?, ?>> map = this.zarm.get(str);
            for (String str2 : map.keySet()) {
                map.get(str2).S(this);
            }
        }
    }

    public final String R() {
        return this.zaro;
    }

    public final Map<String, FastJsonResponse.Field<?, ?>> S(String str) {
        return this.zarm.get(str);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        for (String str : this.zarm.keySet()) {
            sb.append(str);
            sb.append(":\n");
            Map<String, FastJsonResponse.Field<?, ?>> map = this.zarm.get(str);
            for (String str2 : map.keySet()) {
                sb.append("  ");
                sb.append(str2);
                sb.append(": ");
                sb.append(map.get(str2));
            }
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 1, this.zalk);
        ArrayList arrayList = new ArrayList();
        for (String str : this.zarm.keySet()) {
            arrayList.add(new zak(str, this.zarm.get(str)));
        }
        com.google.android.gms.common.internal.safeparcel.a.z(parcel, 2, arrayList, false);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 3, this.zaro, false);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }
}
