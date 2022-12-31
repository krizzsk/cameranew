package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.d;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaed extends zzaeq {
    private final int height;
    private final Uri uri;
    private final int width;
    private final Drawable zzdfr;
    private final double zzdfs;

    public zzaed(Drawable drawable, Uri uri, double d2, int i2, int i3) {
        this.zzdfr = drawable;
        this.uri = uri;
        this.zzdfs = d2;
        this.width = i2;
        this.height = i3;
    }

    @Override // com.google.android.gms.internal.ads.zzaer
    public final int getHeight() {
        return this.height;
    }

    @Override // com.google.android.gms.internal.ads.zzaer
    public final double getScale() {
        return this.zzdfs;
    }

    @Override // com.google.android.gms.internal.ads.zzaer
    public final Uri getUri() throws RemoteException {
        return this.uri;
    }

    @Override // com.google.android.gms.internal.ads.zzaer
    public final int getWidth() {
        return this.width;
    }

    @Override // com.google.android.gms.internal.ads.zzaer
    public final b zzti() throws RemoteException {
        return d.z0(this.zzdfr);
    }
}
