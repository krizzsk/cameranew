package com.google.android.gms.internal.ads;

import java.io.IOException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public interface zzhy extends zzhj {
    void disable();

    int getState();

    int getTrackType();

    boolean isReady();

    void setIndex(int i2);

    void start() throws zzhe;

    void stop() throws zzhe;

    void zza(zzia zziaVar, zzht[] zzhtVarArr, zznn zznnVar, long j2, boolean z, long j3) throws zzhe;

    void zza(zzht[] zzhtVarArr, zznn zznnVar, long j2) throws zzhe;

    void zzb(long j2, long j3) throws zzhe;

    void zzdm(long j2) throws zzhe;

    zzib zzdz();

    zzpk zzea();

    zznn zzeb();

    boolean zzec();

    void zzed();

    boolean zzee();

    void zzef() throws IOException;

    boolean zzfe();
}
