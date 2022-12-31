package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.internal.ads.zzbqx;
import com.google.android.gms.internal.ads.zzbwg;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdje implements zzczc<zzblv> {
    private final Executor zzfsj;
    private final ViewGroup zzfum;
    @GuardedBy("this")
    private final zzdnr zzgxu;
    private final zzcxy zzgxy;
    private final zzbgc zzgzs;
    private final Context zzhfk;
    private final zzcys zzhgg;
    @Nullable
    private zzacl zzhgh;
    private final zzbts zzhgi;
    @GuardedBy("this")
    private zzdzw<zzblv> zzhgj;

    public zzdje(Context context, Executor executor, zzvs zzvsVar, zzbgc zzbgcVar, zzcxy zzcxyVar, zzcys zzcysVar, zzdnr zzdnrVar) {
        this.zzhfk = context;
        this.zzfsj = executor;
        this.zzgzs = zzbgcVar;
        this.zzgxy = zzcxyVar;
        this.zzhgg = zzcysVar;
        this.zzgxu = zzdnrVar;
        this.zzhgi = zzbgcVar.zzafe();
        this.zzfum = new FrameLayout(context);
        zzdnrVar.zzg(zzvsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzczc
    public final boolean isLoading() {
        zzdzw<zzblv> zzdzwVar = this.zzhgj;
        return (zzdzwVar == null || zzdzwVar.isDone()) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzczc
    public final boolean zza(zzvl zzvlVar, String str, @Nullable zzczb zzczbVar, zzcze<? super zzblv> zzczeVar) throws RemoteException {
        zzbmr zzahk;
        if (str == null) {
            zzazk.zzev("Ad unit ID should not be null for banner ad.");
            this.zzfsj.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzdjh
                private final zzdje zzhgm;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzhgm = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzhgm.zzaum();
                }
            });
            return false;
        } else if (isLoading()) {
            return false;
        } else {
            zzdnp zzavh = this.zzgxu.zzgs(str).zzh(zzvlVar).zzavh();
            if (zzadn.zzdei.get().booleanValue() && this.zzgxu.zzkg().zzcik) {
                zzcxy zzcxyVar = this.zzgxy;
                if (zzcxyVar != null) {
                    zzcxyVar.zzc(zzdok.zza(zzdom.INVALID_AD_SIZE, null, null));
                }
                return false;
            }
            if (((Boolean) zzwr.zzqr().zzd(zzabp.zzczs)).booleanValue()) {
                zzahk = this.zzgzs.zzafh().zzd(new zzbqx.zza().zzcf(this.zzhfk).zza(zzavh).zzalo()).zzd(new zzbwg.zza().zza((zzbua) this.zzgxy, this.zzfsj).zza((AppEventListener) this.zzgxy, this.zzfsj).zzaml()).zza(new zzcxa(this.zzhgh)).zzb(new zzcaq(zzcco.zzgfe, null)).zza(new zzbnq(this.zzhgi)).zzd(new zzblu(this.zzfum)).zzahk();
            } else {
                zzahk = this.zzgzs.zzafh().zzd(new zzbqx.zza().zzcf(this.zzhfk).zza(zzavh).zzalo()).zzd(new zzbwg.zza().zza((zzbua) this.zzgxy, this.zzfsj).zza((zzvc) this.zzgxy, this.zzfsj).zza(this.zzhgg, this.zzfsj).zza((zzbse) this.zzgxy, this.zzfsj).zza((zzbrm) this.zzgxy, this.zzfsj).zza((zzbtb) this.zzgxy, this.zzfsj).zza((zzbrr) this.zzgxy, this.zzfsj).zza((AppEventListener) this.zzgxy, this.zzfsj).zza((zzbtt) this.zzgxy, this.zzfsj).zzaml()).zza(new zzcxa(this.zzhgh)).zzb(new zzcaq(zzcco.zzgfe, null)).zza(new zzbnq(this.zzhgi)).zzd(new zzblu(this.zzfum)).zzahk();
            }
            zzdzw<zzblv> zzalb = zzahk.zzagj().zzalb();
            this.zzhgj = zzalb;
            zzdzk.zza(zzalb, new zzdjg(this, zzczeVar, zzahk), this.zzfsj);
            return true;
        }
    }

    public final ViewGroup zzaui() {
        return this.zzfum;
    }

    public final zzdnr zzauj() {
        return this.zzgxu;
    }

    public final boolean zzauk() {
        ViewParent parent = this.zzfum.getParent();
        if (parent instanceof View) {
            View view = (View) parent;
            return com.google.android.gms.ads.internal.zzr.zzkr().zza(view, view.getContext());
        }
        return false;
    }

    public final void zzaul() {
        this.zzhgi.zzdx(60);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzaum() {
        this.zzgxy.zzc(zzdok.zza(zzdom.INVALID_AD_UNIT_ID, null, null));
    }

    public final void zza(zzacl zzaclVar) {
        this.zzhgh = zzaclVar;
    }

    public final void zza(zzww zzwwVar) {
        this.zzhgg.zzb(zzwwVar);
    }

    public final void zza(zzbtw zzbtwVar) {
        this.zzhgi.zza(zzbtwVar, this.zzfsj);
    }
}
