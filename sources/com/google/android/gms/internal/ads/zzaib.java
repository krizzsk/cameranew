package com.google.android.gms.internal.ads;

import com.tencent.tauth.AuthActivity;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzaib implements zzaif<zzbeb> {
    @Override // com.google.android.gms.internal.ads.zzaif
    public final /* synthetic */ void zza(zzbeb zzbebVar, Map map) {
        zzbeb zzbebVar2 = zzbebVar;
        String str = (String) map.get(AuthActivity.ACTION_KEY);
        if ("pause".equals(str)) {
            zzbebVar2.zzkn();
        } else if ("resume".equals(str)) {
            zzbebVar2.zzko();
        }
    }
}
