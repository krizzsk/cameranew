package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.SystemClock;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public class zziv {
    private int zzahp;
    protected AudioTrack zzakc;
    private boolean zzalx;
    private long zzaly;
    private long zzalz;
    private long zzama;
    private long zzamb;
    private long zzamc;
    private long zzamd;

    private zziv() {
    }

    public final void pause() {
        if (this.zzamb != -9223372036854775807L) {
            return;
        }
        this.zzakc.pause();
    }

    public void zza(AudioTrack audioTrack, boolean z) {
        this.zzakc = audioTrack;
        this.zzalx = z;
        this.zzamb = -9223372036854775807L;
        this.zzaly = 0L;
        this.zzalz = 0L;
        this.zzama = 0L;
        if (audioTrack != null) {
            this.zzahp = audioTrack.getSampleRate();
        }
    }

    public final void zzdy(long j2) {
        this.zzamc = zzgb();
        this.zzamb = SystemClock.elapsedRealtime() * 1000;
        this.zzamd = j2;
        this.zzakc.stop();
    }

    public boolean zzfy() {
        return false;
    }

    public long zzfz() {
        throw new UnsupportedOperationException();
    }

    public long zzga() {
        throw new UnsupportedOperationException();
    }

    public final long zzgb() {
        if (this.zzamb != -9223372036854775807L) {
            return Math.min(this.zzamd, this.zzamc + ((((SystemClock.elapsedRealtime() * 1000) - this.zzamb) * this.zzahp) / 1000000));
        }
        int playState = this.zzakc.getPlayState();
        if (playState == 1) {
            return 0L;
        }
        long playbackHeadPosition = 4294967295L & this.zzakc.getPlaybackHeadPosition();
        if (this.zzalx) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.zzama = this.zzaly;
            }
            playbackHeadPosition += this.zzama;
        }
        if (this.zzaly > playbackHeadPosition) {
            this.zzalz++;
        }
        this.zzaly = playbackHeadPosition;
        return playbackHeadPosition + (this.zzalz << 32);
    }

    public final long zzgc() {
        return (zzgb() * 1000000) / this.zzahp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zziv(zzis zzisVar) {
        this();
    }
}
