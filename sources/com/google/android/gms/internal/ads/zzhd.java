package com.google.android.gms.internal.ads;

import androidx.core.location.LocationRequestCompat;
import java.io.IOException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzhd implements zzhy, zzib {
    private int index;
    private int state;
    private final int zzaed;
    private zzia zzaee;
    private zznn zzaef;
    private long zzaeg;
    private boolean zzaeh = true;
    private boolean zzaei;

    public zzhd(int i2) {
        this.zzaed = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final void disable() {
        zzpg.checkState(this.state == 1);
        this.state = 0;
        this.zzaef = null;
        this.zzaei = false;
        zzeh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getIndex() {
        return this.index;
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final int getState() {
        return this.state;
    }

    @Override // com.google.android.gms.internal.ads.zzhy, com.google.android.gms.internal.ads.zzib
    public final int getTrackType() {
        return this.zzaed;
    }

    protected void onStarted() throws zzhe {
    }

    protected void onStopped() throws zzhe {
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final void setIndex(int i2) {
        this.index = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final void start() throws zzhe {
        zzpg.checkState(this.state == 1);
        this.state = 2;
        onStarted();
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final void stop() throws zzhe {
        zzpg.checkState(this.state == 2);
        this.state = 1;
        onStopped();
    }

    @Override // com.google.android.gms.internal.ads.zzhj
    public void zza(int i2, Object obj) throws zzhe {
    }

    protected void zza(long j2, boolean z) throws zzhe {
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final void zza(zzia zziaVar, zzht[] zzhtVarArr, zznn zznnVar, long j2, boolean z, long j3) throws zzhe {
        zzpg.checkState(this.state == 0);
        this.zzaee = zziaVar;
        this.state = 1;
        zze(z);
        zza(zzhtVarArr, zznnVar, j3);
        zza(j2, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zza(zzht[] zzhtVarArr, long j2) throws zzhe {
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final void zzdm(long j2) throws zzhe {
        this.zzaei = false;
        this.zzaeh = false;
        zza(j2, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzdn(long j2) {
        this.zzaef.zzeh(j2 - this.zzaeg);
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final zzib zzdz() {
        return this;
    }

    protected void zze(boolean z) throws zzhe {
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public zzpk zzea() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final zznn zzeb() {
        return this.zzaef;
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final boolean zzec() {
        return this.zzaeh;
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final void zzed() {
        this.zzaei = true;
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final boolean zzee() {
        return this.zzaei;
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final void zzef() throws IOException {
        this.zzaef.zzhs();
    }

    @Override // com.google.android.gms.internal.ads.zzib
    public int zzeg() throws zzhe {
        return 0;
    }

    protected void zzeh() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzia zzei() {
        return this.zzaee;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean zzej() {
        return this.zzaeh ? this.zzaei : this.zzaef.isReady();
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final void zza(zzht[] zzhtVarArr, zznn zznnVar, long j2) throws zzhe {
        zzpg.checkState(!this.zzaei);
        this.zzaef = zznnVar;
        this.zzaeh = false;
        this.zzaeg = j2;
        zza(zzhtVarArr, j2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int zza(zzhv zzhvVar, zzjp zzjpVar, boolean z) {
        int zzb = this.zzaef.zzb(zzhvVar, zzjpVar, z);
        if (zzb == -4) {
            if (zzjpVar.zzgi()) {
                this.zzaeh = true;
                return this.zzaei ? -4 : -3;
            }
            zzjpVar.zzaol += this.zzaeg;
        } else if (zzb == -5) {
            zzht zzhtVar = zzhvVar.zzahz;
            long j2 = zzhtVar.zzaht;
            if (j2 != LocationRequestCompat.PASSIVE_INTERVAL) {
                zzhvVar.zzahz = zzhtVar.zzds(j2 + this.zzaeg);
            }
        }
        return zzb;
    }
}
