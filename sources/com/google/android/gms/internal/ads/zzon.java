package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public interface zzon {
    void close() throws IOException;

    Uri getUri();

    int read(byte[] bArr, int i2, int i3) throws IOException;

    long zza(zzos zzosVar) throws IOException;
}
