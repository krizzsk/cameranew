package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzait extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzait> CREATOR = new zzais();
    private final String url;
    private final String[] zzdin;
    private final String[] zzdio;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzait(String str, String[] strArr, String[] strArr2) {
        this.url = str;
        this.zzdin = strArr;
        this.zzdio = strArr2;
    }

    public static zzait zzh(zzab<?> zzabVar) throws zzl {
        Map<String, String> headers = zzabVar.getHeaders();
        int size = headers.size();
        String[] strArr = new String[size];
        String[] strArr2 = new String[size];
        int i2 = 0;
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            strArr[i2] = entry.getKey();
            strArr2[i2] = entry.getValue();
            i2++;
        }
        return new zzait(zzabVar.getUrl(), strArr, strArr2);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = a.a(parcel);
        a.v(parcel, 1, this.url, false);
        a.w(parcel, 2, this.zzdin, false);
        a.w(parcel, 3, this.zzdio, false);
        a.b(parcel, a);
    }
}
