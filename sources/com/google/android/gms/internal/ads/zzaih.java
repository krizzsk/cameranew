package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaih implements zzaif<Object> {
    private final Context context;

    public zzaih(Context context) {
        this.context = context;
    }

    @Override // com.google.android.gms.internal.ads.zzaif
    public final void zza(Object obj, Map<String, String> map) {
        if (com.google.android.gms.ads.internal.zzr.zzlp().zzy(this.context)) {
            String str = map.get("eventName");
            String str2 = map.get("eventId");
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case 94399:
                    if (str.equals("_aa")) {
                        c = 0;
                        break;
                    }
                    break;
                case 94401:
                    if (str.equals("_ac")) {
                        c = 1;
                        break;
                    }
                    break;
                case 94407:
                    if (str.equals("_ai")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    com.google.android.gms.ads.internal.zzr.zzlp().zzj(this.context, str2);
                    return;
                case 1:
                    com.google.android.gms.ads.internal.zzr.zzlp().zzg(this.context, str2);
                    return;
                case 2:
                    com.google.android.gms.ads.internal.zzr.zzlp().zzh(this.context, str2);
                    return;
                default:
                    zzazk.zzev("logScionEvent gmsg contained unsupported eventName");
                    return;
            }
        }
    }
}
