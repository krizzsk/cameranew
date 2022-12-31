package com.google.android.gms.internal.ads;

import com.coremedia.iso.boxes.MovieBox;
import com.coremedia.iso.boxes.MovieHeaderBox;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzbcx extends zzbl {
    static final zzbcx zzepj = new zzbcx();

    zzbcx() {
    }

    @Override // com.google.android.gms.internal.ads.zzbl
    public final zzbs zza(String str, byte[] bArr, String str2) {
        if (MovieBox.TYPE.equals(str)) {
            return new zzbu();
        }
        if (MovieHeaderBox.TYPE.equals(str)) {
            return new zzbt();
        }
        return new zzbv(str);
    }
}
