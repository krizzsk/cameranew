package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzbet implements zzaif<zzbeb> {
    private final /* synthetic */ zzber zzetw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbet(zzber zzberVar) {
        this.zzetw = zzberVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaif
    public final /* synthetic */ void zza(zzbeb zzbebVar, Map map) {
        int i2;
        if (map != null) {
            String str = (String) map.get("height");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                int parseInt = Integer.parseInt(str);
                synchronized (this.zzetw) {
                    i2 = this.zzetw.zzetm;
                    if (i2 != parseInt) {
                        this.zzetw.zzetm = parseInt;
                        this.zzetw.requestLayout();
                    }
                }
            } catch (Exception e2) {
                zzazk.zzd("Exception occurred while getting webview content height", e2);
            }
        }
    }
}
