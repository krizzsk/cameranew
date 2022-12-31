package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbb {
    private final int zzcq;
    private final List<zzv> zzcr;
    private final int zzcs;
    @Nullable
    private final InputStream zzct;
    @Nullable
    private final byte[] zzcu;

    public zzbb(int i2, List<zzv> list) {
        this(i2, list, -1, null);
    }

    @Nullable
    public final InputStream getContent() {
        InputStream inputStream = this.zzct;
        if (inputStream != null) {
            return inputStream;
        }
        return null;
    }

    public final int getContentLength() {
        return this.zzcs;
    }

    public final int getStatusCode() {
        return this.zzcq;
    }

    public final List<zzv> zzq() {
        return Collections.unmodifiableList(this.zzcr);
    }

    public zzbb(int i2, List<zzv> list, int i3, InputStream inputStream) {
        this.zzcq = i2;
        this.zzcr = list;
        this.zzcs = i3;
        this.zzct = inputStream;
        this.zzcu = null;
    }
}
