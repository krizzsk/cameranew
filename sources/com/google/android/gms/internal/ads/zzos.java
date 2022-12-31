package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Arrays;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzos {
    public final int flags;
    public final long position;
    public final Uri uri;
    public final byte[] zzbil;
    public final long zzbim;
    public final String zzcm;
    public final long zzco;

    public zzos(Uri uri) {
        this(uri, 0);
    }

    public final boolean isFlagSet(int i2) {
        return (this.flags & 1) == 1;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.uri);
        String arrays = Arrays.toString(this.zzbil);
        long j2 = this.zzbim;
        long j3 = this.position;
        long j4 = this.zzco;
        String str = this.zzcm;
        int i2 = this.flags;
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 93 + String.valueOf(arrays).length() + String.valueOf(str).length());
        sb.append("DataSpec[");
        sb.append(valueOf);
        sb.append(", ");
        sb.append(arrays);
        sb.append(", ");
        sb.append(j2);
        sb.append(", ");
        sb.append(j3);
        sb.append(", ");
        sb.append(j4);
        sb.append(", ");
        sb.append(str);
        sb.append(", ");
        sb.append(i2);
        sb.append("]");
        return sb.toString();
    }

    private zzos(Uri uri, int i2) {
        this(uri, 0L, -1L, null, 0);
    }

    public zzos(Uri uri, long j2, long j3, String str) {
        this(uri, j2, j2, j3, str, 0);
    }

    private zzos(Uri uri, long j2, long j3, String str, int i2) {
        this(uri, 0L, 0L, -1L, null, 0);
    }

    private zzos(Uri uri, long j2, long j3, long j4, String str, int i2) {
        this(uri, null, j2, j3, j4, str, 0);
    }

    public zzos(Uri uri, byte[] bArr, long j2, long j3, long j4, String str, int i2) {
        boolean z = true;
        zzpg.checkArgument(j2 >= 0);
        zzpg.checkArgument(j3 >= 0);
        if (j4 <= 0 && j4 != -1) {
            z = false;
        }
        zzpg.checkArgument(z);
        this.uri = uri;
        this.zzbil = bArr;
        this.zzbim = j2;
        this.position = j3;
        this.zzco = j4;
        this.zzcm = str;
        this.flags = i2;
    }
}
