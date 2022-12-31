package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.internal.ads.zzab;
import com.google.android.gms.internal.ads.zzabp;
import com.google.android.gms.internal.ads.zzaf;
import com.google.android.gms.internal.ads.zzajb;
import com.google.android.gms.internal.ads.zzaza;
import com.google.android.gms.internal.ads.zzbd;
import com.google.android.gms.internal.ads.zzwr;
import java.io.File;
import java.util.regex.Pattern;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzan extends com.google.android.gms.internal.ads.zzau {
    private final Context a;

    private zzan(Context context, com.google.android.gms.internal.ads.zzar zzarVar) {
        super(zzarVar);
        this.a = context;
    }

    public static zzaf zzbi(Context context) {
        zzaf zzafVar = new zzaf(new com.google.android.gms.internal.ads.zzav(new File(context.getCacheDir(), "admob_volley"), 20971520), new zzan(context, new zzbd()));
        zzafVar.start();
        return zzafVar;
    }

    @Override // com.google.android.gms.internal.ads.zzau, com.google.android.gms.internal.ads.zzu
    public final com.google.android.gms.internal.ads.zzz zza(zzab<?> zzabVar) throws com.google.android.gms.internal.ads.zzap {
        if (zzabVar.zzh() && zzabVar.getMethod() == 0) {
            if (Pattern.matches((String) zzwr.zzqr().zzd(zzabp.zzcun), zzabVar.getUrl())) {
                zzwr.zzqn();
                if (zzaza.zzf(this.a, 13400000)) {
                    com.google.android.gms.internal.ads.zzz zza = new zzajb(this.a).zza(zzabVar);
                    if (zza != null) {
                        String valueOf = String.valueOf(zzabVar.getUrl());
                        zzd.zzeb(valueOf.length() != 0 ? "Got gmscore asset response: ".concat(valueOf) : new String("Got gmscore asset response: "));
                        return zza;
                    }
                    String valueOf2 = String.valueOf(zzabVar.getUrl());
                    zzd.zzeb(valueOf2.length() != 0 ? "Failed to get gmscore asset response: ".concat(valueOf2) : new String("Failed to get gmscore asset response: "));
                }
            }
        }
        return super.zza(zzabVar);
    }
}
