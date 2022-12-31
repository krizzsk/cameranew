package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.TextureView;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@TargetApi(14)
/* loaded from: classes2.dex */
public abstract class zzbav extends TextureView implements zzbbs {
    protected final zzbbf zzeju;
    protected final zzbbp zzejv;

    public zzbav(Context context) {
        super(context);
        this.zzeju = new zzbbf();
        this.zzejv = new zzbbp(context, this);
    }

    public abstract int getCurrentPosition();

    public abstract int getDuration();

    public abstract long getTotalBytes();

    public abstract int getVideoHeight();

    public abstract int getVideoWidth();

    public abstract void pause();

    public abstract void play();

    public abstract void seekTo(int i2);

    public abstract void setVideoPath(String str);

    public abstract void stop();

    public abstract void zza(float f2, float f3);

    public abstract void zza(zzbaw zzbawVar);

    public abstract String zzaad();

    public abstract long zzaah();

    public abstract int zzaai();

    public abstract void zzaaj();

    public void zzb(String str, String[] strArr) {
        setVideoPath(str);
    }

    public void zzdk(int i2) {
    }

    public void zzdl(int i2) {
    }

    public void zzdm(int i2) {
    }

    public void zzdn(int i2) {
    }

    public void zzdo(int i2) {
    }

    public abstract long zznb();
}
