package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzdib implements zzcze<zzblg> {
    private final /* synthetic */ zzdhx zzhfi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdib(zzdhx zzdhxVar) {
        this.zzhfi = zzdhxVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0049, code lost:
        if (r0.zzehz < ((java.lang.Integer) com.google.android.gms.internal.ads.zzwr.zzqr().zzd(com.google.android.gms.internal.ads.zzabp.zzcvw)).intValue()) goto L11;
     */
    @Override // com.google.android.gms.internal.ads.zzcze
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final /* synthetic */ void onSuccess(com.google.android.gms.internal.ads.zzblg r4) {
        /*
            r3 = this;
            com.google.android.gms.internal.ads.zzblg r4 = (com.google.android.gms.internal.ads.zzblg) r4
            com.google.android.gms.internal.ads.zzdhx r0 = r3.zzhfi
            com.google.android.gms.internal.ads.zzblg r0 = r0.zzhfg
            if (r0 == 0) goto Lb
            r0.destroy()
        Lb:
            com.google.android.gms.internal.ads.zzdhx r0 = r3.zzhfi
            r0.zzhfg = r4
            android.view.ViewGroup r0 = com.google.android.gms.internal.ads.zzdhx.zza(r0)
            r0.removeAllViews()
            com.google.android.gms.internal.ads.zzdhx r0 = r3.zzhfi
            android.view.ViewGroup r0 = com.google.android.gms.internal.ads.zzdhx.zza(r0)
            android.view.View r1 = r4.zzajr()
            com.google.android.gms.ads.internal.util.zzr r2 = com.google.android.gms.ads.internal.zzr.zzkt()
            android.view.ViewGroup$LayoutParams r2 = r2.zzzd()
            r0.addView(r1, r2)
            boolean r0 = r4.zzaji()
            if (r0 != 0) goto L4b
            com.google.android.gms.internal.ads.zzdhx r0 = r3.zzhfi
            com.google.android.gms.internal.ads.zzazn r0 = com.google.android.gms.internal.ads.zzdhx.zzb(r0)
            int r0 = r0.zzehz
            com.google.android.gms.internal.ads.zzaba<java.lang.Integer> r1 = com.google.android.gms.internal.ads.zzabp.zzcvw
            com.google.android.gms.internal.ads.zzabl r2 = com.google.android.gms.internal.ads.zzwr.zzqr()
            java.lang.Object r1 = r2.zzd(r1)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            if (r0 >= r1) goto L70
        L4b:
            com.google.android.gms.internal.ads.zzdhx r0 = r3.zzhfi
            com.google.android.gms.ads.internal.overlay.zzp r0 = com.google.android.gms.internal.ads.zzdhx.zza(r0, r4)
            android.widget.RelativeLayout$LayoutParams r1 = com.google.android.gms.internal.ads.zzdhx.zzd(r4)
            boolean r2 = r4.zzajs()
            if (r2 == 0) goto L63
            boolean r2 = r4.zzajj()
            if (r2 != 0) goto L63
            r2 = 1
            goto L64
        L63:
            r2 = 0
        L64:
            r0.zzam(r2)
            com.google.android.gms.internal.ads.zzdhx r2 = r3.zzhfi
            android.view.ViewGroup r2 = com.google.android.gms.internal.ads.zzdhx.zza(r2)
            r2.addView(r0, r1)
        L70:
            com.google.android.gms.internal.ads.zzdhx r0 = r3.zzhfi
            com.google.android.gms.internal.ads.zzdhx.zzb(r0, r4)
            com.google.android.gms.internal.ads.zzdhx r0 = r3.zzhfi
            android.view.ViewGroup r0 = com.google.android.gms.internal.ads.zzdhx.zza(r0)
            com.google.android.gms.internal.ads.zzdhx r1 = r3.zzhfi
            com.google.android.gms.internal.ads.zzvs r1 = com.google.android.gms.internal.ads.zzdhx.zzc(r1)
            int r1 = r1.heightPixels
            r0.setMinimumHeight(r1)
            com.google.android.gms.internal.ads.zzdhx r0 = r3.zzhfi
            android.view.ViewGroup r0 = com.google.android.gms.internal.ads.zzdhx.zza(r0)
            com.google.android.gms.internal.ads.zzdhx r1 = r3.zzhfi
            com.google.android.gms.internal.ads.zzvs r1 = com.google.android.gms.internal.ads.zzdhx.zzc(r1)
            int r1 = r1.widthPixels
            r0.setMinimumWidth(r1)
            com.google.android.gms.internal.ads.zzdhx r0 = r3.zzhfi
            com.google.android.gms.internal.ads.zzdil r0 = com.google.android.gms.internal.ads.zzdhx.zzd(r0)
            com.google.android.gms.internal.ads.zzblr r1 = new com.google.android.gms.internal.ads.zzblr
            com.google.android.gms.internal.ads.zzdhx r2 = r3.zzhfi
            r1.<init>(r4, r2)
            r0.zzb(r1)
            r4.zzakb()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdib.onSuccess(java.lang.Object):void");
    }

    @Override // com.google.android.gms.internal.ads.zzcze
    public final void zzasi() {
        this.zzhfi.zzhfg = null;
    }
}
