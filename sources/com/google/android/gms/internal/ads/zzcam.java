package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzug;
import javax.annotation.ParametersAreNonnullByDefault;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcam implements zzbrm, zzbxp {
    private final Context context;
    @Nullable
    private final View view;
    private final zzaxc zzbqv;
    private final zzaxd zzfwd;
    private final zzug.zza.EnumC0160zza zzgbp;
    private String zzgbr;

    public zzcam(zzaxd zzaxdVar, Context context, zzaxc zzaxcVar, @Nullable View view, zzug.zza.EnumC0160zza enumC0160zza) {
        this.zzfwd = zzaxdVar;
        this.context = context;
        this.zzbqv = zzaxcVar;
        this.view = view;
        this.zzgbp = enumC0160zza;
    }

    @Override // com.google.android.gms.internal.ads.zzbrm
    public final void onAdClosed() {
        this.zzfwd.zzan(false);
    }

    @Override // com.google.android.gms.internal.ads.zzbrm
    public final void onAdLeftApplication() {
    }

    @Override // com.google.android.gms.internal.ads.zzbrm
    public final void onAdOpened() {
        View view = this.view;
        if (view != null && this.zzgbr != null) {
            this.zzbqv.zzf(view.getContext(), this.zzgbr);
        }
        this.zzfwd.zzan(true);
    }

    @Override // com.google.android.gms.internal.ads.zzbrm
    public final void onRewardedVideoCompleted() {
    }

    @Override // com.google.android.gms.internal.ads.zzbrm
    public final void onRewardedVideoStarted() {
    }

    @Override // com.google.android.gms.internal.ads.zzbxp
    public final void zzald() {
    }

    @Override // com.google.android.gms.internal.ads.zzbxp
    public final void zzalf() {
        String zzaa = this.zzbqv.zzaa(this.context);
        this.zzgbr = zzaa;
        String valueOf = String.valueOf(zzaa);
        String str = this.zzgbp == zzug.zza.EnumC0160zza.REWARD_BASED_VIDEO_AD ? "/Rewarded" : "/Interstitial";
        this.zzgbr = str.length() != 0 ? valueOf.concat(str) : new String(valueOf);
    }

    @Override // com.google.android.gms.internal.ads.zzbrm
    @ParametersAreNonnullByDefault
    public final void zzb(zzauk zzaukVar, String str, String str2) {
        if (this.zzbqv.zzy(this.context)) {
            try {
                zzaxc zzaxcVar = this.zzbqv;
                Context context = this.context;
                zzaxcVar.zza(context, zzaxcVar.zzad(context), this.zzfwd.getAdUnitId(), zzaukVar.getType(), zzaukVar.getAmount());
            } catch (RemoteException e2) {
                zzazk.zzd("Remote Exception to get reward item.", e2);
            }
        }
    }
}
