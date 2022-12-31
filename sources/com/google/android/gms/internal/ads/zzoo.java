package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzoo implements zzon {
    private final byte[] data;
    private Uri uri;
    private int zzbib;
    private int zzbic;

    public zzoo(byte[] bArr) {
        zzpg.checkNotNull(bArr);
        zzpg.checkArgument(bArr.length > 0);
        this.data = bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzon
    public final void close() throws IOException {
        this.uri = null;
    }

    @Override // com.google.android.gms.internal.ads.zzon
    public final Uri getUri() {
        return this.uri;
    }

    @Override // com.google.android.gms.internal.ads.zzon
    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        if (i3 == 0) {
            return 0;
        }
        int i4 = this.zzbic;
        if (i4 == 0) {
            return -1;
        }
        int min = Math.min(i3, i4);
        System.arraycopy(this.data, this.zzbib, bArr, i2, min);
        this.zzbib += min;
        this.zzbic -= min;
        return min;
    }

    @Override // com.google.android.gms.internal.ads.zzon
    public final long zza(zzos zzosVar) throws IOException {
        this.uri = zzosVar.uri;
        long j2 = zzosVar.position;
        int i2 = (int) j2;
        this.zzbib = i2;
        long j3 = zzosVar.zzco;
        if (j3 == -1) {
            j3 = this.data.length - j2;
        }
        int i3 = (int) j3;
        this.zzbic = i3;
        if (i3 <= 0 || i2 + i3 > this.data.length) {
            int i4 = this.zzbib;
            long j4 = zzosVar.zzco;
            int length = this.data.length;
            StringBuilder sb = new StringBuilder(77);
            sb.append("Unsatisfiable range: [");
            sb.append(i4);
            sb.append(", ");
            sb.append(j4);
            sb.append("], length: ");
            sb.append(length);
            throw new IOException(sb.toString());
        }
        return i3;
    }
}
