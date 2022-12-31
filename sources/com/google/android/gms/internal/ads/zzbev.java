package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.f;
import com.tencent.tauth.AuthActivity;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbev extends zzzb {
    @GuardedBy("lock")
    private boolean zzady;
    @GuardedBy("lock")
    private boolean zzadz;
    @GuardedBy("lock")
    private int zzafa;
    @GuardedBy("lock")
    private zzzd zzdnk;
    private final zzbbo zzeix;
    private final boolean zzety;
    private final boolean zzetz;
    @GuardedBy("lock")
    private boolean zzeua;
    @GuardedBy("lock")
    private float zzeuc;
    @GuardedBy("lock")
    private float zzeud;
    @GuardedBy("lock")
    private float zzeue;
    @GuardedBy("lock")
    private zzagd zzeuf;
    private final Object lock = new Object();
    @GuardedBy("lock")
    private boolean zzeub = true;

    public zzbev(zzbbo zzbboVar, float f2, boolean z, boolean z2) {
        this.zzeix = zzbboVar;
        this.zzeuc = f2;
        this.zzety = z;
        this.zzetz = z2;
    }

    private final void zze(String str, @Nullable Map<String, String> map) {
        final HashMap hashMap = map == null ? new HashMap() : new HashMap(map);
        hashMap.put(AuthActivity.ACTION_KEY, str);
        zzazp.zzeig.execute(new Runnable(this, hashMap) { // from class: com.google.android.gms.internal.ads.zzbey
            private final Map zzehx;
            private final zzbev zzeug;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzeug = this;
                this.zzehx = hashMap;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzeug.zzl(this.zzehx);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final float getAspectRatio() {
        float f2;
        synchronized (this.lock) {
            f2 = this.zzeue;
        }
        return f2;
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final float getCurrentTime() {
        float f2;
        synchronized (this.lock) {
            f2 = this.zzeud;
        }
        return f2;
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final float getDuration() {
        float f2;
        synchronized (this.lock) {
            f2 = this.zzeuc;
        }
        return f2;
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final int getPlaybackState() {
        int i2;
        synchronized (this.lock) {
            i2 = this.zzafa;
        }
        return i2;
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final boolean isClickToExpandEnabled() {
        boolean z;
        boolean isCustomControlsEnabled = isCustomControlsEnabled();
        synchronized (this.lock) {
            if (!isCustomControlsEnabled) {
                try {
                    z = (this.zzadz && this.zzetz) ? true : true;
                } finally {
                }
            }
            z = false;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final boolean isCustomControlsEnabled() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzety && this.zzady;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final boolean isMuted() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzeub;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final void mute(boolean z) {
        zze(z ? "mute" : "unmute", null);
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final void pause() {
        zze("pause", null);
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final void play() {
        zze("play", null);
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final void stop() {
        zze("stop", null);
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final void zza(zzzd zzzdVar) {
        synchronized (this.lock) {
            this.zzdnk = zzzdVar;
        }
    }

    public final void zzaej() {
        boolean z;
        int i2;
        synchronized (this.lock) {
            z = this.zzeub;
            i2 = this.zzafa;
            this.zzafa = 3;
        }
        zza(i2, 3, z, z);
    }

    public final void zzb(zzaau zzaauVar) {
        boolean z = zzaauVar.zzadx;
        boolean z2 = zzaauVar.zzady;
        boolean z3 = zzaauVar.zzadz;
        synchronized (this.lock) {
            this.zzady = z2;
            this.zzadz = z3;
        }
        zze("initialState", f.d("muteStart", z ? "1" : "0", "customControlsRequested", z2 ? "1" : "0", "clickToExpandRequested", z3 ? "1" : "0"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzl(Map map) {
        this.zzeix.zza("pubVideoCmd", map);
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final zzzd zzrg() throws RemoteException {
        zzzd zzzdVar;
        synchronized (this.lock) {
            zzzdVar = this.zzdnk;
        }
        return zzzdVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002f A[Catch: all -> 0x004d, TryCatch #1 {, blocks: (B:4:0x0003, B:6:0x0009, B:11:0x0013, B:13:0x002f, B:14:0x0038), top: B:29:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(float r4, float r5, int r6, boolean r7, float r8) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.lock
            monitor-enter(r0)
            float r1 = r3.zzeuc     // Catch: java.lang.Throwable -> L4d
            int r1 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r1 != 0) goto L12
            float r1 = r3.zzeue     // Catch: java.lang.Throwable -> L4d
            int r1 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r1 == 0) goto L10
            goto L12
        L10:
            r1 = 0
            goto L13
        L12:
            r1 = 1
        L13:
            r3.zzeuc = r5     // Catch: java.lang.Throwable -> L4d
            r3.zzeud = r4     // Catch: java.lang.Throwable -> L4d
            boolean r4 = r3.zzeub     // Catch: java.lang.Throwable -> L4d
            r3.zzeub = r7     // Catch: java.lang.Throwable -> L4d
            int r5 = r3.zzafa     // Catch: java.lang.Throwable -> L4d
            r3.zzafa = r6     // Catch: java.lang.Throwable -> L4d
            float r2 = r3.zzeue     // Catch: java.lang.Throwable -> L4d
            r3.zzeue = r8     // Catch: java.lang.Throwable -> L4d
            float r8 = r8 - r2
            float r8 = java.lang.Math.abs(r8)     // Catch: java.lang.Throwable -> L4d
            r2 = 953267991(0x38d1b717, float:1.0E-4)
            int r8 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r8 <= 0) goto L38
            com.google.android.gms.internal.ads.zzbbo r8 = r3.zzeix     // Catch: java.lang.Throwable -> L4d
            android.view.View r8 = r8.getView()     // Catch: java.lang.Throwable -> L4d
            r8.invalidate()     // Catch: java.lang.Throwable -> L4d
        L38:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L4d
            if (r1 == 0) goto L49
            com.google.android.gms.internal.ads.zzagd r8 = r3.zzeuf     // Catch: android.os.RemoteException -> L43
            if (r8 == 0) goto L49
            r8.zztw()     // Catch: android.os.RemoteException -> L43
            goto L49
        L43:
            r8 = move-exception
            java.lang.String r0 = "#007 Could not call remote method."
            com.google.android.gms.internal.ads.zzazk.zze(r0, r8)
        L49:
            r3.zza(r5, r6, r4, r7)
            return
        L4d:
            r4 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L4d
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbev.zza(float, float, int, boolean, float):void");
    }

    public final void zze(float f2) {
        synchronized (this.lock) {
            this.zzeud = f2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(int i2, int i3, boolean z, boolean z2) {
        zzzd zzzdVar;
        zzzd zzzdVar2;
        zzzd zzzdVar3;
        synchronized (this.lock) {
            boolean z3 = false;
            boolean z4 = i2 != i3;
            boolean z5 = this.zzeua;
            boolean z6 = !z5 && i3 == 1;
            boolean z7 = z4 && i3 == 1;
            boolean z8 = z4 && i3 == 2;
            boolean z9 = z4 && i3 == 3;
            boolean z10 = z != z2;
            this.zzeua = (z5 || z6) ? true : true;
            if (z6) {
                try {
                    zzzd zzzdVar4 = this.zzdnk;
                    if (zzzdVar4 != null) {
                        zzzdVar4.onVideoStart();
                    }
                } catch (RemoteException e2) {
                    zzazk.zze("#007 Could not call remote method.", e2);
                }
            }
            if (z7 && (zzzdVar3 = this.zzdnk) != null) {
                zzzdVar3.onVideoPlay();
            }
            if (z8 && (zzzdVar2 = this.zzdnk) != null) {
                zzzdVar2.onVideoPause();
            }
            if (z9) {
                zzzd zzzdVar5 = this.zzdnk;
                if (zzzdVar5 != null) {
                    zzzdVar5.onVideoEnd();
                }
                this.zzeix.zzabm();
            }
            if (z10 && (zzzdVar = this.zzdnk) != null) {
                zzzdVar.onVideoMute(z2);
            }
        }
    }

    public final void zza(zzagd zzagdVar) {
        synchronized (this.lock) {
            this.zzeuf = zzagdVar;
        }
    }

    private final void zza(final int i2, final int i3, final boolean z, final boolean z2) {
        zzazp.zzeig.execute(new Runnable(this, i2, i3, z, z2) { // from class: com.google.android.gms.internal.ads.zzbex
            private final int zzefe;
            private final int zzeff;
            private final boolean zzers;
            private final boolean zzert;
            private final zzbev zzeug;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzeug = this;
                this.zzefe = i2;
                this.zzeff = i3;
                this.zzers = z;
                this.zzert = z2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzeug.zzb(this.zzefe, this.zzeff, this.zzers, this.zzert);
            }
        });
    }
}
