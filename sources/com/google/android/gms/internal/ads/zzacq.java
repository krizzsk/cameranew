package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzacq {
    private MotionEvent zzdbt = MotionEvent.obtain(0, 0, 1, 0.0f, 0.0f, 0);
    private MotionEvent zzdbu = MotionEvent.obtain(0, 0, 0, 0.0f, 0.0f, 0);

    public final void zza(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 && motionEvent.getEventTime() > this.zzdbt.getEventTime()) {
            this.zzdbt = MotionEvent.obtain(motionEvent);
        } else if (motionEvent.getAction() != 0 || motionEvent.getEventTime() <= this.zzdbu.getEventTime()) {
        } else {
            this.zzdbu = MotionEvent.obtain(motionEvent);
        }
    }

    public final MotionEvent zzsx() {
        return this.zzdbt;
    }

    public final MotionEvent zzsy() {
        return this.zzdbu;
    }
}
