package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.internal.ads.zzazo;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbq extends zza {
    private final zzazo a;
    private final String b;

    public zzbq(Context context, String str, String str2) {
        this(str2, com.google.android.gms.ads.internal.zzr.zzkr().zzq(context, str));
    }

    @Override // com.google.android.gms.ads.internal.util.zza
    public final void zzwe() {
        this.a.zzel(this.b);
    }

    private zzbq(String str, String str2) {
        this.a = new zzazo(str2);
        this.b = str;
    }
}
