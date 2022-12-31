package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzbct implements zzon {
    private Uri uri;
    private final zzon zzepf;
    private final long zzepg;
    private final zzon zzeph;
    private long zzepi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbct(zzon zzonVar, int i2, zzon zzonVar2) {
        this.zzepf = zzonVar;
        this.zzepg = i2;
        this.zzeph = zzonVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzon
    public final void close() throws IOException {
        this.zzepf.close();
        this.zzeph.close();
    }

    @Override // com.google.android.gms.internal.ads.zzon
    public final Uri getUri() {
        return this.uri;
    }

    @Override // com.google.android.gms.internal.ads.zzon
    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        long j2 = this.zzepi;
        long j3 = this.zzepg;
        if (j2 < j3) {
            i4 = this.zzepf.read(bArr, i2, (int) Math.min(i3, j3 - j2));
            this.zzepi += i4;
        } else {
            i4 = 0;
        }
        if (this.zzepi >= this.zzepg) {
            int read = this.zzeph.read(bArr, i2 + i4, i3 - i4);
            int i5 = i4 + read;
            this.zzepi += read;
            return i5;
        }
        return i4;
    }

    @Override // com.google.android.gms.internal.ads.zzon
    public final long zza(zzos zzosVar) throws IOException {
        zzos zzosVar2;
        this.uri = zzosVar.uri;
        long j2 = zzosVar.position;
        long j3 = this.zzepg;
        zzos zzosVar3 = null;
        if (j2 >= j3) {
            zzosVar2 = null;
        } else {
            long j4 = zzosVar.zzco;
            zzosVar2 = new zzos(zzosVar.uri, j2, j4 != -1 ? Math.min(j4, j3 - j2) : j3 - j2, null);
        }
        long j5 = zzosVar.zzco;
        if (j5 == -1 || zzosVar.position + j5 > this.zzepg) {
            long max = Math.max(this.zzepg, zzosVar.position);
            long j6 = zzosVar.zzco;
            zzosVar3 = new zzos(zzosVar.uri, max, j6 != -1 ? Math.min(j6, (zzosVar.position + j6) - this.zzepg) : -1L, null);
        }
        long zza = zzosVar2 != null ? this.zzepf.zza(zzosVar2) : 0L;
        long zza2 = zzosVar3 != null ? this.zzeph.zza(zzosVar3) : 0L;
        this.zzepi = zzosVar.position;
        if (zza == -1 || zza2 == -1) {
            return -1L;
        }
        return zza + zza2;
    }
}
