package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.d;
import java.lang.ref.WeakReference;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzasq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzasq> CREATOR = new zzast();
    public final View zzaat;
    public final Map<String, WeakReference<View>> zzdto;

    public zzasq(IBinder iBinder, IBinder iBinder2) {
        this.zzaat = (View) d.y0(b.a.x0(iBinder));
        this.zzdto = (Map) d.y0(b.a.x0(iBinder2));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = a.a(parcel);
        a.l(parcel, 1, d.z0(this.zzaat).asBinder(), false);
        a.l(parcel, 2, d.z0(this.zzdto).asBinder(), false);
        a.b(parcel, a);
    }
}
