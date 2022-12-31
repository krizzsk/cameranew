package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import org.json.JSONArray;
import org.json.JSONException;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzavj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzavj> CREATOR = new zzavi();
    public final String type;
    public final int zzdzc;

    public zzavj(RewardItem rewardItem) {
        this(rewardItem.getType(), rewardItem.getAmount());
    }

    @Nullable
    public static zzavj zza(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        return new zzavj(jSONArray.getJSONObject(0).optString("rb_type"), jSONArray.getJSONObject(0).optInt("rb_amount"));
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zzavj)) {
            zzavj zzavjVar = (zzavj) obj;
            if (p.a(this.type, zzavjVar.type) && p.a(Integer.valueOf(this.zzdzc), Integer.valueOf(zzavjVar.zzdzc))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return p.b(this.type, Integer.valueOf(this.zzdzc));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = a.a(parcel);
        a.v(parcel, 2, this.type, false);
        a.m(parcel, 3, this.zzdzc);
        a.b(parcel, a);
    }

    public zzavj(String str, int i2) {
        this.type = str;
        this.zzdzc = i2;
    }
}
