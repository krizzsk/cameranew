package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.HashMap;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public final class StringToIntConverter extends AbstractSafeParcelable implements FastJsonResponse.a<String, Integer> {
    public static final Parcelable.Creator<StringToIntConverter> CREATOR = new b();
    private final int zalk;
    private final HashMap<String, Integer> zaqc;
    private final SparseArray<String> zaqd;
    private final ArrayList<zaa> zaqe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StringToIntConverter(int i2, ArrayList<zaa> arrayList) {
        this.zalk = i2;
        this.zaqc = new HashMap<>();
        this.zaqd = new SparseArray<>();
        this.zaqe = null;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            zaa zaaVar = arrayList.get(i3);
            i3++;
            zaa zaaVar2 = zaaVar;
            h(zaaVar2.a, zaaVar2.b);
        }
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse.a
    public final /* synthetic */ String a(Integer num) {
        String str = this.zaqd.get(num.intValue());
        return (str == null && this.zaqc.containsKey("gms_unknown")) ? "gms_unknown" : str;
    }

    public final StringToIntConverter h(String str, int i2) {
        this.zaqc.put(str, Integer.valueOf(i2));
        this.zaqd.put(i2, str);
        return this;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 1, this.zalk);
        ArrayList arrayList = new ArrayList();
        for (String str : this.zaqc.keySet()) {
            arrayList.add(new zaa(str, this.zaqc.get(str).intValue()));
        }
        com.google.android.gms.common.internal.safeparcel.a.z(parcel, 2, arrayList, false);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
    /* loaded from: classes2.dex */
    public static final class zaa extends AbstractSafeParcelable {
        public static final Parcelable.Creator<zaa> CREATOR = new c();
        final String a;
        final int b;
        private final int versionCode;

        /* JADX INFO: Access modifiers changed from: package-private */
        public zaa(int i2, String str, int i3) {
            this.versionCode = i2;
            this.a = str;
            this.b = i3;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            com.google.android.gms.common.internal.safeparcel.a.m(parcel, 1, this.versionCode);
            com.google.android.gms.common.internal.safeparcel.a.v(parcel, 2, this.a, false);
            com.google.android.gms.common.internal.safeparcel.a.m(parcel, 3, this.b);
            com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
        }

        zaa(String str, int i2) {
            this.versionCode = 1;
            this.a = str;
            this.b = i2;
        }
    }

    public StringToIntConverter() {
        this.zalk = 1;
        this.zaqc = new HashMap<>();
        this.zaqd = new SparseArray<>();
        this.zaqe = null;
    }
}
