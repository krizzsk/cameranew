package com.google.android.gms.internal.ads;

import com.growingio.android.sdk.monitor.marshaller.json.JsonMarshaller;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzail implements com.google.android.gms.ads.internal.overlay.zzt {
    private boolean zzdig = false;
    private final /* synthetic */ Map zzdih;
    private final /* synthetic */ Map zzdii;
    private final /* synthetic */ zzvc zzdij;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzail(zzaij zzaijVar, Map map, Map map2, zzvc zzvcVar) {
        this.zzdih = map;
        this.zzdii = map2;
        this.zzdij = zzvcVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzt
    public final void zza(zzacr zzacrVar) {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzt
    public final void zzab(boolean z) {
        if (this.zzdig) {
            return;
        }
        this.zzdig = true;
        this.zzdih.put((String) this.zzdii.get(JsonMarshaller.EVENT_ID), Boolean.valueOf(z));
        ((zzaki) this.zzdij).zza("openIntentAsync", this.zzdih);
    }
}
