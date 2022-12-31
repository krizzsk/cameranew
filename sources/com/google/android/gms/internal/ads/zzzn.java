package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.AdapterStatus;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.dynamic.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public class zzzn {
    @GuardedBy("InternalMobileAds.class")
    private static zzzn zzckt;
    @GuardedBy("lock")
    private zzyg zzcku;
    private RewardedVideoAd zzckw;
    private InitializationStatus zzcky;
    private final Object lock = new Object();
    private boolean zzckv = false;
    private boolean zzzl = false;
    @NonNull
    private RequestConfiguration zzckx = new RequestConfiguration.Builder().build();
    private ArrayList<OnInitializationCompleteListener> zzcks = new ArrayList<>();

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
    /* loaded from: classes2.dex */
    private class zza extends zzajn {
        private zza() {
        }

        @Override // com.google.android.gms.internal.ads.zzajk
        public final void zze(List<zzajh> list) throws RemoteException {
            int i2 = 0;
            zzzn.this.zzckv = false;
            zzzn.this.zzzl = true;
            zzzn zzznVar = zzzn.this;
            InitializationStatus zzd = zzzn.zzd(list);
            ArrayList arrayList = zzzn.zzrs().zzcks;
            int size = arrayList.size();
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                ((OnInitializationCompleteListener) obj).onInitializationComplete(zzd);
            }
            zzzn.zzrs().zzcks.clear();
        }

        /* synthetic */ zza(zzzn zzznVar, zzzr zzzrVar) {
            this();
        }
    }

    private zzzn() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static InitializationStatus zzd(List<zzajh> list) {
        HashMap hashMap = new HashMap();
        for (zzajh zzajhVar : list) {
            hashMap.put(zzajhVar.zzdit, new zzajp(zzajhVar.zzdiu ? AdapterStatus.State.READY : AdapterStatus.State.NOT_READY, zzajhVar.description, zzajhVar.zzdiv));
        }
        return new zzajo(hashMap);
    }

    @GuardedBy("lock")
    private final void zzg(Context context) {
        if (this.zzcku == null) {
            this.zzcku = new zzwo(zzwr.zzqo(), context).zzd(context, false);
        }
    }

    public static zzzn zzrs() {
        zzzn zzznVar;
        synchronized (zzzn.class) {
            if (zzckt == null) {
                zzckt = new zzzn();
            }
            zzznVar = zzckt;
        }
        return zzznVar;
    }

    public final void disableMediationAdapterInitialization(Context context) {
        synchronized (this.lock) {
            zzg(context);
            try {
                this.zzcku.zzrd();
            } catch (RemoteException unused) {
                zzazk.zzev("Unable to disable mediation adapter initialization.");
            }
        }
    }

    public final InitializationStatus getInitializationStatus() {
        synchronized (this.lock) {
            q.n(this.zzcku != null, "MobileAds.initialize() must be called prior to getting initialization status.");
            try {
                InitializationStatus initializationStatus = this.zzcky;
                if (initializationStatus != null) {
                    return initializationStatus;
                }
                return zzd(this.zzcku.zzrc());
            } catch (RemoteException unused) {
                zzazk.zzev("Unable to get Initialization status.");
                return null;
            }
        }
    }

    @NonNull
    public final RequestConfiguration getRequestConfiguration() {
        return this.zzckx;
    }

    public final RewardedVideoAd getRewardedVideoAdInstance(Context context) {
        synchronized (this.lock) {
            RewardedVideoAd rewardedVideoAd = this.zzckw;
            if (rewardedVideoAd != null) {
                return rewardedVideoAd;
            }
            zzavc zzavcVar = new zzavc(context, new zzwp(zzwr.zzqo(), context, new zzanf()).zzd(context, false));
            this.zzckw = zzavcVar;
            return zzavcVar;
        }
    }

    public final String getVersionString() {
        String zzhm;
        synchronized (this.lock) {
            q.n(this.zzcku != null, "MobileAds.initialize() must be called prior to getting version string.");
            try {
                zzhm = zzdwt.zzhm(this.zzcku.getVersionString());
            } catch (RemoteException e2) {
                zzazk.zzc("Unable to get version string.", e2);
                return "";
            }
        }
        return zzhm;
    }

    public final void openDebugMenu(Context context, String str) {
        synchronized (this.lock) {
            q.n(this.zzcku != null, "MobileAds.initialize() must be called prior to opening debug menu.");
            try {
                this.zzcku.zzb(d.z0(context), str);
            } catch (RemoteException e2) {
                zzazk.zzc("Unable to open debug menu.", e2);
            }
        }
    }

    public final void registerRtbAdapter(Class<? extends RtbAdapter> cls) {
        synchronized (this.lock) {
            try {
                this.zzcku.zzce(cls.getCanonicalName());
            } catch (RemoteException e2) {
                zzazk.zzc("Unable to register RtbAdapter", e2);
            }
        }
    }

    public final void setAppMuted(boolean z) {
        synchronized (this.lock) {
            q.n(this.zzcku != null, "MobileAds.initialize() must be called prior to setting app muted state.");
            try {
                this.zzcku.setAppMuted(z);
            } catch (RemoteException e2) {
                zzazk.zzc("Unable to set app mute state.", e2);
            }
        }
    }

    public final void setAppVolume(float f2) {
        boolean z = true;
        q.b(0.0f <= f2 && f2 <= 1.0f, "The app volume must be a value between 0 and 1 inclusive.");
        synchronized (this.lock) {
            if (this.zzcku == null) {
                z = false;
            }
            q.n(z, "MobileAds.initialize() must be called prior to setting the app volume.");
            try {
                this.zzcku.setAppVolume(f2);
            } catch (RemoteException e2) {
                zzazk.zzc("Unable to set app volume.", e2);
            }
        }
    }

    public final void setRequestConfiguration(@NonNull RequestConfiguration requestConfiguration) {
        q.b(requestConfiguration != null, "Null passed to setRequestConfiguration.");
        synchronized (this.lock) {
            RequestConfiguration requestConfiguration2 = this.zzckx;
            this.zzckx = requestConfiguration;
            if (this.zzcku == null) {
                return;
            }
            if (requestConfiguration2.getTagForChildDirectedTreatment() != requestConfiguration.getTagForChildDirectedTreatment() || requestConfiguration2.getTagForUnderAgeOfConsent() != requestConfiguration.getTagForUnderAgeOfConsent()) {
                zza(requestConfiguration);
            }
        }
    }

    public final void zza(final Context context, String str, final OnInitializationCompleteListener onInitializationCompleteListener) {
        synchronized (this.lock) {
            if (this.zzckv) {
                if (onInitializationCompleteListener != null) {
                    zzrs().zzcks.add(onInitializationCompleteListener);
                }
            } else if (this.zzzl) {
                if (onInitializationCompleteListener != null) {
                    onInitializationCompleteListener.onInitializationComplete(getInitializationStatus());
                }
            } else {
                this.zzckv = true;
                if (onInitializationCompleteListener != null) {
                    zzrs().zzcks.add(onInitializationCompleteListener);
                }
                if (context != null) {
                    try {
                        zzamz.zzut().zzc(context, str);
                        zzg(context);
                        if (onInitializationCompleteListener != null) {
                            this.zzcku.zza(new zza(this, null));
                        }
                        this.zzcku.zza(new zzanf());
                        this.zzcku.initialize();
                        this.zzcku.zza(str, d.z0(new Runnable(this, context) { // from class: com.google.android.gms.internal.ads.zzzq
                            private final zzzn zzclc;
                            private final Context zzcle;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                this.zzclc = this;
                                this.zzcle = context;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                this.zzclc.getRewardedVideoAdInstance(this.zzcle);
                            }
                        }));
                        if (this.zzckx.getTagForChildDirectedTreatment() != -1 || this.zzckx.getTagForUnderAgeOfConsent() != -1) {
                            zza(this.zzckx);
                        }
                        zzabp.initialize(context);
                        if (!((Boolean) zzwr.zzqr().zzd(zzabp.zzcwc)).booleanValue() && !getVersionString().endsWith("0")) {
                            zzazk.zzev("Google Mobile Ads SDK initialization functionality unavailable for this session. Ad requests can be made at any time.");
                            this.zzcky = new InitializationStatus(this) { // from class: com.google.android.gms.internal.ads.zzzs
                                private final zzzn zzclc;

                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    this.zzclc = this;
                                }

                                @Override // com.google.android.gms.ads.initialization.InitializationStatus
                                public final Map getAdapterStatusMap() {
                                    zzzn zzznVar = this.zzclc;
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("com.google.android.gms.ads.MobileAds", new zzzr(zzznVar));
                                    return hashMap;
                                }
                            };
                            if (onInitializationCompleteListener != null) {
                                zzaza.zzaac.post(new Runnable(this, onInitializationCompleteListener) { // from class: com.google.android.gms.internal.ads.zzzp
                                    private final zzzn zzclc;
                                    private final OnInitializationCompleteListener zzcld;

                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    {
                                        this.zzclc = this;
                                        this.zzcld = onInitializationCompleteListener;
                                    }

                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        this.zzclc.zza(this.zzcld);
                                    }
                                });
                            }
                        }
                    } catch (RemoteException e2) {
                        zzazk.zzd("MobileAdsSettingManager initialization failed", e2);
                    }
                    return;
                }
                throw new IllegalArgumentException("Context cannot be null.");
            }
        }
    }

    public final float zzra() {
        synchronized (this.lock) {
            zzyg zzygVar = this.zzcku;
            float f2 = 1.0f;
            if (zzygVar == null) {
                return 1.0f;
            }
            try {
                f2 = zzygVar.zzra();
            } catch (RemoteException e2) {
                zzazk.zzc("Unable to get app volume.", e2);
            }
            return f2;
        }
    }

    public final boolean zzrb() {
        synchronized (this.lock) {
            zzyg zzygVar = this.zzcku;
            boolean z = false;
            if (zzygVar == null) {
                return false;
            }
            try {
                z = zzygVar.zzrb();
            } catch (RemoteException e2) {
                zzazk.zzc("Unable to get app mute state.", e2);
            }
            return z;
        }
    }

    @GuardedBy("lock")
    private final void zza(@NonNull RequestConfiguration requestConfiguration) {
        try {
            this.zzcku.zza(new zzaao(requestConfiguration));
        } catch (RemoteException e2) {
            zzazk.zzc("Unable to set request configuration parcel.", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(OnInitializationCompleteListener onInitializationCompleteListener) {
        onInitializationCompleteListener.onInitializationComplete(this.zzcky);
    }
}
