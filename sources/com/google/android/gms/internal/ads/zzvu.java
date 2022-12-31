package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.firebase.analytics.FirebaseAnalytics;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzvu extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzvu> CREATOR = new zzvt();
    public final int type;
    public final int zzadc;
    public final String zzadd;
    public final long zzade;

    public zzvu(int i2, int i3, String str, long j2) {
        this.type = i2;
        this.zzadc = i3;
        this.zzadd = str;
        this.zzade = j2;
    }

    public static zzvu zza(JSONObject jSONObject) throws JSONException {
        return new zzvu(jSONObject.getInt("type_num"), jSONObject.getInt("precision_num"), jSONObject.getString(FirebaseAnalytics.Param.CURRENCY), jSONObject.getLong(FirebaseAnalytics.Param.VALUE));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = a.a(parcel);
        a.m(parcel, 1, this.type);
        a.m(parcel, 2, this.zzadc);
        a.v(parcel, 3, this.zzadd, false);
        a.q(parcel, 4, this.zzade);
        a.b(parcel, a);
    }
}
