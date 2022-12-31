package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaim implements zzaip {
    private final /* synthetic */ zzbaa zzdik;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaim(zzain zzainVar, zzbaa zzbaaVar) {
        this.zzdik = zzbaaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaip
    public final void onFailure(@Nullable String str) {
        this.zzdik.setException(new zzaly(str));
    }

    @Override // com.google.android.gms.internal.ads.zzaip
    public final void zzc(JSONObject jSONObject) {
        this.zzdik.set(jSONObject);
    }
}
