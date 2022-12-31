package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.CookieManager;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import us.pinguo.advconfigdata.Utils.AdvPrefUtil;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbjl implements zzbjf {
    private final CookieManager zzfra;

    public zzbjl(Context context) {
        this.zzfra = com.google.android.gms.ads.internal.zzr.zzkt().zzbf(context);
    }

    @Override // com.google.android.gms.internal.ads.zzbjf
    public final void zzm(Map<String, String> map) {
        Object next;
        if (this.zzfra == null) {
            return;
        }
        if (map.get("clear") != null) {
            String str = (String) zzwr.zzqr().zzd(zzabp.zzcpf);
            String cookie = this.zzfra.getCookie(str);
            if (cookie != null) {
                List<String> zzc = zzdwk.zza(zzdvu.zzb(';')).zzc(cookie);
                for (int i2 = 0; i2 < zzc.size(); i2++) {
                    CookieManager cookieManager = this.zzfra;
                    Iterable<String> zza = zzdwk.zza(zzdvu.zzb('=')).zza(zzc.get(i2));
                    zzdwl.checkNotNull(zza);
                    if (zza instanceof List) {
                        next = ((List) zza).get(0);
                    } else {
                        Iterator<String> it = zza.iterator();
                        zzdwl.checkNotNull(it);
                        zzdwl.checkArgument(true, "numberToAdvance must be nonnegative");
                        if (it.hasNext()) {
                            next = it.next();
                        } else {
                            StringBuilder sb = new StringBuilder(91);
                            sb.append("position (0) must be less than the number of elements that remained (0");
                            sb.append(")");
                            throw new IndexOutOfBoundsException(sb.toString());
                        }
                    }
                    String valueOf = String.valueOf((String) next);
                    String valueOf2 = String.valueOf((String) zzwr.zzqr().zzd(zzabp.zzcou));
                    cookieManager.setCookie(str, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
                }
                return;
            }
            return;
        }
        String str2 = map.get(AdvPrefUtil.COOKIE);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.zzfra.setCookie((String) zzwr.zzqr().zzd(zzabp.zzcpf), str2);
    }
}
