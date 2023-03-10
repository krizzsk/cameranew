package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.AnyThread;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.google.android.gms.dynamic.b;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcbu extends zzbnt {
    private final Context context;
    private final zzazn zzbpn;
    private final zzei zzesm;
    private final Executor zzfsj;
    private final zzcco zzfup;
    private final zzaxd zzfwd;
    private final zzccd zzgch;
    private final zzccl zzgdh;
    private final zzccz zzgdi;
    private final zzcch zzgdj;
    private final zzepv<zzcgc> zzgdk;
    private final zzepv<zzcga> zzgdl;
    private final zzepv<zzcgf> zzgdm;
    private final zzepv<zzcfw> zzgdn;
    private final zzepv<zzcge> zzgdo;
    private zzcdx zzgdp;
    private boolean zzgdq;
    private boolean zzgdr;
    private final zzccc zzgds;
    private final zzcyq zzgdt;

    public zzcbu(zzbnw zzbnwVar, Executor executor, zzccd zzccdVar, zzccl zzcclVar, zzccz zzcczVar, zzcch zzcchVar, zzcco zzccoVar, zzepv<zzcgc> zzepvVar, zzepv<zzcga> zzepvVar2, zzepv<zzcgf> zzepvVar3, zzepv<zzcfw> zzepvVar4, zzepv<zzcge> zzepvVar5, zzaxd zzaxdVar, zzei zzeiVar, zzazn zzaznVar, Context context, zzccc zzcccVar, zzcyq zzcyqVar) {
        super(zzbnwVar);
        this.zzgdr = false;
        this.zzfsj = executor;
        this.zzgch = zzccdVar;
        this.zzgdh = zzcclVar;
        this.zzgdi = zzcczVar;
        this.zzgdj = zzcchVar;
        this.zzfup = zzccoVar;
        this.zzgdk = zzepvVar;
        this.zzgdl = zzepvVar2;
        this.zzgdm = zzepvVar3;
        this.zzgdn = zzepvVar4;
        this.zzgdo = zzepvVar5;
        this.zzfwd = zzaxdVar;
        this.zzesm = zzeiVar;
        this.zzbpn = zzaznVar;
        this.context = context;
        this.zzgds = zzcccVar;
        this.zzgdt = zzcyqVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzb */
    public final void zzf(zzcdx zzcdxVar) {
        zzdy zzca;
        this.zzgdp = zzcdxVar;
        this.zzgdi.zza(zzcdxVar);
        this.zzgdh.zza(zzcdxVar.zzajr(), zzcdxVar.zzaow(), zzcdxVar.zzaox(), zzcdxVar, zzcdxVar);
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcsb)).booleanValue() && (zzca = this.zzesm.zzca()) != null) {
            zzca.zzb(zzcdxVar.zzajr());
        }
        if (zzcdxVar.zzapa() != null) {
            zzcdxVar.zzapa().zza(this.zzfwd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzd */
    public final void zze(zzcdx zzcdxVar) {
        this.zzgdh.zza(zzcdxVar.zzajr(), zzcdxVar.zzaov());
        if (zzcdxVar.zzaoz() != null) {
            zzcdxVar.zzaoz().setClickable(false);
            zzcdxVar.zzaoz().removeAllViews();
        }
        if (zzcdxVar.zzapa() != null) {
            zzcdxVar.zzapa().zzb(this.zzfwd);
        }
        this.zzgdp = null;
    }

    public static boolean zzz(View view) {
        return view.isShown() && view.getGlobalVisibleRect(new Rect(), null);
    }

    public final synchronized void cancelUnconfirmedClick() {
        this.zzgdh.cancelUnconfirmedClick();
    }

    @Override // com.google.android.gms.internal.ads.zzbnt
    public final synchronized void destroy() {
        this.zzfsj.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcbv
            private final zzcbu zzgdg;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgdg = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzgdg.zzans();
            }
        });
        super.destroy();
    }

    public final synchronized boolean isCustomClickGestureEnabled() {
        return this.zzgdh.isCustomClickGestureEnabled();
    }

    public final synchronized void recordCustomClickGesture() {
        zzcdx zzcdxVar = this.zzgdp;
        if (zzcdxVar == null) {
            zzazk.zzdy("Ad should be associated with an ad view before calling recordCustomClickGesture()");
            return;
        }
        final boolean z = zzcdxVar instanceof zzccy;
        this.zzfsj.execute(new Runnable(this, z) { // from class: com.google.android.gms.internal.ads.zzcca
            private final boolean zzekn;
            private final zzcbu zzgdg;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgdg = this;
                this.zzekn = z;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzgdg.zzbi(this.zzekn);
            }
        });
    }

    public final synchronized void setClickConfirmingView(View view) {
        this.zzgdh.setClickConfirmingView(view);
    }

    public final synchronized void zza(final zzcdx zzcdxVar) {
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcrh)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zzj.zzeen.post(new Runnable(this, zzcdxVar) { // from class: com.google.android.gms.internal.ads.zzcby
                private final zzcbu zzgdg;
                private final zzcdx zzgdv;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzgdg = this;
                    this.zzgdv = zzcdxVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzgdg.zzf(this.zzgdv);
                }
            });
        } else {
            zzf(zzcdxVar);
        }
    }

    public final void zzaa(View view) {
        b zzaob = this.zzgch.zzaob();
        boolean z = this.zzgch.zzaoa() != null;
        if (!this.zzgdj.zzanq() || zzaob == null || !z || view == null) {
            return;
        }
        com.google.android.gms.ads.internal.zzr.zzlg().zza(zzaob, view);
    }

    public final void zzab(View view) {
        b zzaob = this.zzgch.zzaob();
        if (!this.zzgdj.zzanq() || zzaob == null || view == null) {
            return;
        }
        com.google.android.gms.ads.internal.zzr.zzlg().zzb(zzaob, view);
    }

    @Override // com.google.android.gms.internal.ads.zzbnt
    @AnyThread
    public final void zzakb() {
        this.zzfsj.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcbt
            private final zzcbu zzgdg;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgdg = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzgdg.zzant();
            }
        });
        if (this.zzgch.zzanu() != 7) {
            Executor executor = this.zzfsj;
            zzccl zzcclVar = this.zzgdh;
            zzcclVar.getClass();
            executor.execute(zzcbw.zza(zzcclVar));
        }
        super.zzakb();
    }

    public final synchronized void zzanj() {
        if (this.zzgdq) {
            return;
        }
        this.zzgdh.zzanj();
    }

    public final boolean zzanp() {
        return this.zzgdj.zzaoh();
    }

    public final boolean zzanq() {
        return this.zzgdj.zzanq();
    }

    public final zzccc zzanr() {
        return this.zzgds;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzans() {
        this.zzgdh.destroy();
        this.zzgch.destroy();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzant() {
        try {
            int zzanu = this.zzgch.zzanu();
            if (zzanu == 1) {
                if (this.zzfup.zzaoj() != null) {
                    zzi("Google", true);
                    this.zzfup.zzaoj().zza(this.zzgdk.get());
                }
            } else if (zzanu == 2) {
                if (this.zzfup.zzaok() != null) {
                    zzi("Google", true);
                    this.zzfup.zzaok().zza(this.zzgdl.get());
                }
            } else if (zzanu == 3) {
                if (this.zzfup.zzga(this.zzgch.getCustomTemplateId()) != null) {
                    if (this.zzgch.zzanz() != null) {
                        zzi("Google", true);
                    }
                    this.zzfup.zzga(this.zzgch.getCustomTemplateId()).zza(this.zzgdo.get());
                }
            } else if (zzanu == 6) {
                if (this.zzfup.zzaol() != null) {
                    zzi("Google", true);
                    this.zzfup.zzaol().zza(this.zzgdm.get());
                }
            } else if (zzanu != 7) {
                zzazk.zzev("Wrong native template id!");
            } else if (this.zzfup.zzaon() != null) {
                this.zzfup.zzaon().zza(this.zzgdn.get());
            }
        } catch (RemoteException e2) {
            zzazk.zzc("RemoteException when notifyAdLoad is called", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzbi(boolean z) {
        this.zzgdh.zza(this.zzgdp.zzajr(), this.zzgdp.zzaov(), this.zzgdp.zzaow(), z);
    }

    public final synchronized void zzc(final zzcdx zzcdxVar) {
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcrh)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zzj.zzeen.post(new Runnable(this, zzcdxVar) { // from class: com.google.android.gms.internal.ads.zzcbx
                private final zzcbu zzgdg;
                private final zzcdx zzgdv;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzgdg = this;
                    this.zzgdv = zzcdxVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzgdg.zze(this.zzgdv);
                }
            });
        } else {
            zze(zzcdxVar);
        }
    }

    public final synchronized void zzf(Bundle bundle) {
        this.zzgdh.zzf(bundle);
    }

    public final synchronized void zzfw(String str) {
        this.zzgdh.zzfw(str);
    }

    public final synchronized void zzg(Bundle bundle) {
        this.zzgdh.zzg(bundle);
    }

    public final synchronized boolean zzh(Bundle bundle) {
        if (this.zzgdq) {
            return true;
        }
        boolean zzh = this.zzgdh.zzh(bundle);
        this.zzgdq = zzh;
        return zzh;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzi(java.lang.String r16, boolean r17) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcbu.zzi(java.lang.String, boolean):void");
    }

    public final synchronized void zztx() {
        this.zzgdh.zztx();
    }

    public final synchronized void zza(View view, View view2, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        this.zzgdi.zzg(this.zzgdp);
        this.zzgdh.zza(view, view2, map, map2, z);
        if (this.zzgdr) {
            if (((Boolean) zzwr.zzqr().zzd(zzabp.zzctc)).booleanValue() && this.zzgch.zzanz() != null) {
                this.zzgch.zzanz().zza("onSdkAdUserInteractionClick", new ArrayMap());
            }
        }
    }

    public final synchronized void zzb(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        if (this.zzgdq) {
            return;
        }
        if (z) {
            this.zzgdi.zzh(this.zzgdp);
            this.zzgdh.zzb(view, map, map2);
            this.zzgdq = true;
            return;
        }
        if (!z) {
            if (((Boolean) zzwr.zzqr().zzd(zzabp.zzctj)).booleanValue() && map != null) {
                for (Map.Entry<String, WeakReference<View>> entry : map.entrySet()) {
                    View view2 = entry.getValue().get();
                    if (view2 != null && zzz(view2)) {
                        this.zzgdi.zzh(this.zzgdp);
                        this.zzgdh.zzb(view, map, map2);
                        this.zzgdq = true;
                        return;
                    }
                }
            }
        }
    }

    public final synchronized void zza(View view, MotionEvent motionEvent, View view2) {
        this.zzgdh.zza(view, motionEvent, view2);
    }

    public final synchronized JSONObject zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2) {
        return this.zzgdh.zza(view, map, map2);
    }

    public final synchronized void zza(zzagm zzagmVar) {
        this.zzgdh.zza(zzagmVar);
    }

    public final synchronized void zza(@Nullable zzyn zzynVar) {
        this.zzgdh.zza(zzynVar);
    }

    public final synchronized void zza(zzyj zzyjVar) {
        this.zzgdh.zza(zzyjVar);
    }

    public final synchronized void zza(zzyw zzywVar) {
        this.zzgdt.zzc(zzywVar);
    }
}
