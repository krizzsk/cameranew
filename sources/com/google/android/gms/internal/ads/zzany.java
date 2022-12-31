package com.google.android.gms.internal.ads;

import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzany extends zzzb {
    private final Object lock = new Object();
    private volatile zzzd zzdnk;

    @Override // com.google.android.gms.internal.ads.zzzc
    public final float getAspectRatio() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final float getCurrentTime() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final float getDuration() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final int getPlaybackState() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final boolean isClickToExpandEnabled() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final boolean isCustomControlsEnabled() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final boolean isMuted() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final void mute(boolean z) throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final void pause() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final void play() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final void stop() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final void zza(zzzd zzzdVar) throws RemoteException {
        synchronized (this.lock) {
            this.zzdnk = zzzdVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final zzzd zzrg() throws RemoteException {
        zzzd zzzdVar;
        synchronized (this.lock) {
            zzzdVar = this.zzdnk;
        }
        return zzzdVar;
    }
}
