package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzamp implements zzaip {
    private final /* synthetic */ zzamk zzdlc;
    private final zzalm zzdlf;
    private final zzbaa<O> zzdlg;

    public zzamp(zzamk zzamkVar, zzalm zzalmVar, zzbaa<O> zzbaaVar) {
        this.zzdlc = zzamkVar;
        this.zzdlf = zzalmVar;
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
        } finally {
            this.zzdlf.release();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaip
    public final void zzc(JSONObject jSONObject) {
        zzamd zzamdVar;
        try {
            try {
                zzbaa<O> zzbaaVar = this.zzdlg;
                zzamdVar = this.zzdlc.zzdky;
                zzbaaVar.set(zzamdVar.zzd(jSONObject));
                this.zzdlf.release();
            } catch (IllegalStateException unused) {
                this.zzdlf.release();
            } catch (JSONException e2) {
                this.zzdlg.setException(e2);
                this.zzdlf.release();
            }
        } catch (Throwable th) {
            this.zzdlf.release();
            throw th;
        }
    }
}
