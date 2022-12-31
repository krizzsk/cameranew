package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.ads.formats.NativeAd;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaes extends NativeAd.Image {
    private final int height;
    private final Uri uri;
    private final int width;
    private final double zzdfs;
    private final zzaer zzdfx;
    private final Drawable zzdfy;

    /* JADX WARN: Can't wrap try/catch for region: R(18:1|(2:2|3)|(15:5|6|7|8|9|10|11|12|13|14|15|16|17|18|19)|34|6|7|8|9|10|11|12|13|14|15|16|17|18|19) */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0024, code lost:
        com.google.android.gms.internal.ads.zzazk.zzc("", r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0032, code lost:
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0033, code lost:
        com.google.android.gms.internal.ads.zzazk.zzc("", r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0040, code lost:
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0041, code lost:
        com.google.android.gms.internal.ads.zzazk.zzc("", r1);
        r1 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004e, code lost:
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004f, code lost:
        com.google.android.gms.internal.ads.zzazk.zzc("", r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public zzaes(com.google.android.gms.internal.ads.zzaer r4) {
        /*
            r3 = this;
            java.lang.String r0 = ""
            r3.<init>()
            r3.zzdfx = r4
            r1 = 0
            com.google.android.gms.dynamic.b r4 = r4.zzti()     // Catch: android.os.RemoteException -> L15
            if (r4 == 0) goto L19
            java.lang.Object r4 = com.google.android.gms.dynamic.d.y0(r4)     // Catch: android.os.RemoteException -> L15
            android.graphics.drawable.Drawable r4 = (android.graphics.drawable.Drawable) r4     // Catch: android.os.RemoteException -> L15
            goto L1a
        L15:
            r4 = move-exception
            com.google.android.gms.internal.ads.zzazk.zzc(r0, r4)
        L19:
            r4 = r1
        L1a:
            r3.zzdfy = r4
            com.google.android.gms.internal.ads.zzaer r4 = r3.zzdfx     // Catch: android.os.RemoteException -> L23
            android.net.Uri r1 = r4.getUri()     // Catch: android.os.RemoteException -> L23
            goto L27
        L23:
            r4 = move-exception
            com.google.android.gms.internal.ads.zzazk.zzc(r0, r4)
        L27:
            r3.uri = r1
            r1 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            com.google.android.gms.internal.ads.zzaer r4 = r3.zzdfx     // Catch: android.os.RemoteException -> L32
            double r1 = r4.getScale()     // Catch: android.os.RemoteException -> L32
            goto L36
        L32:
            r4 = move-exception
            com.google.android.gms.internal.ads.zzazk.zzc(r0, r4)
        L36:
            r3.zzdfs = r1
            r4 = -1
            com.google.android.gms.internal.ads.zzaer r1 = r3.zzdfx     // Catch: android.os.RemoteException -> L40
            int r1 = r1.getWidth()     // Catch: android.os.RemoteException -> L40
            goto L45
        L40:
            r1 = move-exception
            com.google.android.gms.internal.ads.zzazk.zzc(r0, r1)
            r1 = -1
        L45:
            r3.width = r1
            com.google.android.gms.internal.ads.zzaer r1 = r3.zzdfx     // Catch: android.os.RemoteException -> L4e
            int r4 = r1.getHeight()     // Catch: android.os.RemoteException -> L4e
            goto L52
        L4e:
            r1 = move-exception
            com.google.android.gms.internal.ads.zzazk.zzc(r0, r1)
        L52:
            r3.height = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaes.<init>(com.google.android.gms.internal.ads.zzaer):void");
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public final Drawable getDrawable() {
        return this.zzdfy;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public final int getHeight() {
        return this.height;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public final double getScale() {
        return this.zzdfs;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public final Uri getUri() {
        return this.uri;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public final int getWidth() {
        return this.width;
    }
}
