package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.ConditionVariable;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzis extends Thread {
    private final /* synthetic */ AudioTrack zzajp;
    private final /* synthetic */ zzit zzajq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzis(zzit zzitVar, AudioTrack audioTrack) {
        this.zzajq = zzitVar;
        this.zzajp = audioTrack;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        ConditionVariable conditionVariable;
        try {
            this.zzajp.flush();
            this.zzajp.release();
        } finally {
            conditionVariable = this.zzajq.zzajy;
            conditionVariable.open();
        }
    }
}
