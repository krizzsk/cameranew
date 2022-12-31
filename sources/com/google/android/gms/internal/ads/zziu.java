package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.AudioTimestamp;
import android.media.AudioTrack;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@TargetApi(19)
/* loaded from: classes2.dex */
public final class zziu extends zziv {
    private final AudioTimestamp zzalt;
    private long zzalu;
    private long zzalv;
    private long zzalw;

    public zziu() {
        super(null);
        this.zzalt = new AudioTimestamp();
    }

    @Override // com.google.android.gms.internal.ads.zziv
    public final void zza(AudioTrack audioTrack, boolean z) {
        super.zza(audioTrack, z);
        this.zzalu = 0L;
        this.zzalv = 0L;
        this.zzalw = 0L;
    }

    @Override // com.google.android.gms.internal.ads.zziv
    public final boolean zzfy() {
        boolean timestamp = this.zzakc.getTimestamp(this.zzalt);
        if (timestamp) {
            long j2 = this.zzalt.framePosition;
            if (this.zzalv > j2) {
                this.zzalu++;
            }
            this.zzalv = j2;
            this.zzalw = j2 + (this.zzalu << 32);
        }
        return timestamp;
    }

    @Override // com.google.android.gms.internal.ads.zziv
    public final long zzfz() {
        return this.zzalt.nanoTime;
    }

    @Override // com.google.android.gms.internal.ads.zziv
    public final long zzga() {
        return this.zzalw;
    }
}
