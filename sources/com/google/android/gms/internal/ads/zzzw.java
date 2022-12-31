package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.d;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzzw implements MediaContent {
    private final VideoController zzckl = new VideoController();
    private final zzaem zzclh;

    public zzzw(zzaem zzaemVar) {
        this.zzclh = zzaemVar;
    }

    @Override // com.google.android.gms.ads.MediaContent
    public final float getAspectRatio() {
        try {
            return this.zzclh.getAspectRatio();
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
            return 0.0f;
        }
    }

    @Override // com.google.android.gms.ads.MediaContent
    public final float getCurrentTime() {
        try {
            return this.zzclh.getCurrentTime();
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
            return 0.0f;
        }
    }

    @Override // com.google.android.gms.ads.MediaContent
    public final float getDuration() {
        try {
            return this.zzclh.getDuration();
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
            return 0.0f;
        }
    }

    @Override // com.google.android.gms.ads.MediaContent
    public final Drawable getMainImage() {
        try {
            b zztl = this.zzclh.zztl();
            if (zztl != null) {
                return (Drawable) d.y0(zztl);
            }
            return null;
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.MediaContent
    public final VideoController getVideoController() {
        try {
            if (this.zzclh.getVideoController() != null) {
                this.zzckl.zza(this.zzclh.getVideoController());
            }
        } catch (RemoteException e2) {
            zzazk.zzc("Exception occurred while getting video controller", e2);
        }
        return this.zzckl;
    }

    @Override // com.google.android.gms.ads.MediaContent
    public final boolean hasVideoContent() {
        try {
            return this.zzclh.hasVideoContent();
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
            return false;
        }
    }

    @Override // com.google.android.gms.ads.MediaContent
    public final void setMainImage(Drawable drawable) {
        try {
            this.zzclh.zzo(d.z0(drawable));
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
        }
    }

    public final zzaem zzrt() {
        return this.zzclh;
    }
}
