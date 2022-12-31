package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzcgd implements zzaef {
    private final /* synthetic */ zzcge zzgis;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcgd(zzcge zzcgeVar) {
        this.zzgis = zzcgeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaef
    public final void zzc(MotionEvent motionEvent) {
    }

    @Override // com.google.android.gms.internal.ads.zzaef
    public final void zztj() {
        zzcbu zzcbuVar;
        zzcbu zzcbuVar2;
        zzcbuVar = this.zzgis.zzgfm;
        if (zzcbuVar != null) {
            zzcbuVar2 = this.zzgis.zzgfm;
            zzcbuVar2.zzfw("_videoMediaView");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaef
    public final JSONObject zztk() {
        return null;
    }
}
