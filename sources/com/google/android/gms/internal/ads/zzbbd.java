package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.q;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbbd {
    private final Context zzcmf;
    private final zzbbo zzeix;
    private final ViewGroup zzekq;
    private zzbax zzekr;

    public zzbbd(Context context, ViewGroup viewGroup, zzbeb zzbebVar) {
        this(context, viewGroup, zzbebVar, null);
    }

    public final void onDestroy() {
        q.e("onDestroy must be called from the UI thread.");
        zzbax zzbaxVar = this.zzekr;
        if (zzbaxVar != null) {
            zzbaxVar.destroy();
            this.zzekq.removeView(this.zzekr);
            this.zzekr = null;
        }
    }

    public final void onPause() {
        q.e("onPause must be called from the UI thread.");
        zzbax zzbaxVar = this.zzekr;
        if (zzbaxVar != null) {
            zzbaxVar.pause();
        }
    }

    public final void zza(int i2, int i3, int i4, int i5, int i6, boolean z, zzbbl zzbblVar) {
        if (this.zzekr != null) {
            return;
        }
        zzabx.zza(this.zzeix.zzabi().zzsp(), this.zzeix.zzabd(), "vpr2");
        Context context = this.zzcmf;
        zzbbo zzbboVar = this.zzeix;
        zzbax zzbaxVar = new zzbax(context, zzbboVar, i6, z, zzbboVar.zzabi().zzsp(), zzbblVar);
        this.zzekr = zzbaxVar;
        this.zzekq.addView(zzbaxVar, 0, new ViewGroup.LayoutParams(-1, -1));
        this.zzekr.zzd(i2, i3, i4, i5);
        this.zzeix.zzaw(false);
    }

    public final zzbax zzaav() {
        q.e("getAdVideoUnderlay must be called from the UI thread.");
        return this.zzekr;
    }

    public final void zze(int i2, int i3, int i4, int i5) {
        q.e("The underlay may only be modified from the UI thread.");
        zzbax zzbaxVar = this.zzekr;
        if (zzbaxVar != null) {
            zzbaxVar.zzd(i2, i3, i4, i5);
        }
    }

    private zzbbd(Context context, ViewGroup viewGroup, zzbbo zzbboVar, zzbax zzbaxVar) {
        this.zzcmf = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzekq = viewGroup;
        this.zzeix = zzbboVar;
        this.zzekr = null;
    }
}
