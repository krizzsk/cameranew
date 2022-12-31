package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzqh implements Handler.Callback, Choreographer.FrameCallback {
    private static final zzqh zzbmk = new zzqh();
    private final Handler handler;
    public volatile long zzbmj;
    private final HandlerThread zzbml;
    private Choreographer zzbmm;
    private int zzbmn;

    private zzqh() {
        HandlerThread handlerThread = new HandlerThread("ChoreographerOwner:Handler");
        this.zzbml = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper(), this);
        this.handler = handler;
        handler.sendEmptyMessage(0);
    }

    public static zzqh zzjp() {
        return zzbmk;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j2) {
        this.zzbmj = j2;
        this.zzbmm.postFrameCallbackDelayed(this, 500L);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 0) {
            this.zzbmm = Choreographer.getInstance();
            return true;
        } else if (i2 == 1) {
            int i3 = this.zzbmn + 1;
            this.zzbmn = i3;
            if (i3 == 1) {
                this.zzbmm.postFrameCallback(this);
            }
            return true;
        } else if (i2 != 2) {
            return false;
        } else {
            int i4 = this.zzbmn - 1;
            this.zzbmn = i4;
            if (i4 == 0) {
                this.zzbmm.removeFrameCallback(this);
                this.zzbmj = 0L;
            }
            return true;
        }
    }

    public final void removeObserver() {
        this.handler.sendEmptyMessage(2);
    }

    public final void zzjq() {
        this.handler.sendEmptyMessage(1);
    }
}
