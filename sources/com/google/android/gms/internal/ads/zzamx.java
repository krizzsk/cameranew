package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzamx implements zzaip {
    private final zzbaa<O> zzdlg;
    private final /* synthetic */ zzamv zzdlm;

    public zzamx(zzamv zzamvVar, zzbaa<O> zzbaaVar) {
        this.zzdlm = zzamvVar;
        this.zzdlg = zzbaaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaip
    public final void onFailure(@Nullable String str) {
        try {
            if (str == null) {
                this.zzdlg.setException(new zzaly());
            } else {
                this.zzdlg.setException(new zzaly(str));
            }
        } catch (IllegalStateException unused) {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaip
    public final void zzc(JSONObject jSONObject) {
        zzamd zzamdVar;
        try {
            zzbaa<O> zzbaaVar = this.zzdlg;
            zzamdVar = this.zzdlm.zzdky;
            zzbaaVar.set(zzamdVar.zzd(jSONObject));
        } catch (IllegalStateException unused) {
        } catch (JSONException e2) {
            this.zzdlg.setException(e2);
        }
    }
}
