package com.google.android.gms.internal.ads;

import java.io.IOException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public interface zzjz {
    long getLength();

    long getPosition();

    int read(byte[] bArr, int i2, int i3) throws IOException, InterruptedException;

    void readFully(byte[] bArr, int i2, int i3) throws IOException, InterruptedException;

    void zza(byte[] bArr, int i2, int i3) throws IOException, InterruptedException;

    boolean zza(byte[] bArr, int i2, int i3, boolean z) throws IOException, InterruptedException;

    int zzaf(int i2) throws IOException, InterruptedException;

    void zzag(int i2) throws IOException, InterruptedException;

    void zzah(int i2) throws IOException, InterruptedException;

    void zzgq();
}
