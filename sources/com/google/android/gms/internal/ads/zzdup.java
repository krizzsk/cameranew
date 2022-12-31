package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import java.io.File;
import java.util.Arrays;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdup {
    private final zzgv zzhuc;
    private final File zzhud;
    private final File zzhue;
    private final File zzhuf;
    private byte[] zzhug;

    public zzdup(@NonNull zzgv zzgvVar, @NonNull File file, @NonNull File file2, @NonNull File file3) {
        this.zzhuc = zzgvVar;
        this.zzhud = file;
        this.zzhue = file3;
        this.zzhuf = file2;
    }

    public final zzgv zzayk() {
        return this.zzhuc;
    }

    public final File zzayl() {
        return this.zzhud;
    }

    public final File zzaym() {
        return this.zzhue;
    }

    public final byte[] zzayn() {
        if (this.zzhug == null) {
            this.zzhug = zzdur.zzf(this.zzhuf);
        }
        byte[] bArr = this.zzhug;
        if (bArr == null) {
            return null;
        }
        return Arrays.copyOf(bArr, bArr.length);
    }

    public final boolean zzff(long j2) {
        return this.zzhuc.zzdi() - (System.currentTimeMillis() / 1000) < 3600;
    }
}
