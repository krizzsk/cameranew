package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.d;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcbs extends zzaep {
    private final zzccd zzgch;
    private b zzgdf;

    public zzcbs(zzccd zzccdVar) {
        this.zzgch = zzccdVar;
    }

    private final float zzano() {
        try {
            return this.zzgch.getVideoController().getAspectRatio();
        } catch (RemoteException e2) {
            zzazk.zzc("Remote exception getting video controller aspect ratio.", e2);
            return 0.0f;
        }
    }

    private static float zzas(b bVar) {
        Drawable drawable;
        if (bVar == null || (drawable = (Drawable) d.y0(bVar)) == null || drawable.getIntrinsicWidth() == -1 || drawable.getIntrinsicHeight() == -1) {
            return 0.0f;
        }
        return drawable.getIntrinsicWidth() / drawable.getIntrinsicHeight();
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final float getAspectRatio() throws RemoteException {
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcyb)).booleanValue()) {
            if (this.zzgch.getMediaContentAspectRatio() != 0.0f) {
                return this.zzgch.getMediaContentAspectRatio();
            }
            if (this.zzgch.getVideoController() != null) {
                return zzano();
            }
            b bVar = this.zzgdf;
            if (bVar != null) {
                return zzas(bVar);
            }
            zzaer zzanw = this.zzgch.zzanw();
            if (zzanw == null) {
                return 0.0f;
            }
            float width = (zzanw == null || zzanw.getWidth() == -1 || zzanw.getHeight() == -1) ? 0.0f : zzanw.getWidth() / zzanw.getHeight();
            return width != 0.0f ? width : zzas(zzanw.zzti());
        }
        return 0.0f;
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final float getCurrentTime() throws RemoteException {
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcyc)).booleanValue() && this.zzgch.getVideoController() != null) {
            return this.zzgch.getVideoController().getCurrentTime();
        }
        return 0.0f;
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final float getDuration() throws RemoteException {
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcyc)).booleanValue() && this.zzgch.getVideoController() != null) {
            return this.zzgch.getVideoController().getDuration();
        }
        return 0.0f;
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final zzzc getVideoController() throws RemoteException {
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcyc)).booleanValue()) {
            return this.zzgch.getVideoController();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final boolean hasVideoContent() throws RemoteException {
        return ((Boolean) zzwr.zzqr().zzd(zzabp.zzcyc)).booleanValue() && this.zzgch.getVideoController() != null;
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final void zza(zzagd zzagdVar) {
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcyc)).booleanValue() && (this.zzgch.getVideoController() instanceof zzbev)) {
            ((zzbev) this.zzgch.getVideoController()).zza(zzagdVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final void zzo(b bVar) {
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcte)).booleanValue()) {
            this.zzgdf = bVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final b zztl() throws RemoteException {
        b bVar = this.zzgdf;
        if (bVar != null) {
            return bVar;
        }
        zzaer zzanw = this.zzgch.zzanw();
        if (zzanw == null) {
            return null;
        }
        return zzanw.zzti();
    }
}
