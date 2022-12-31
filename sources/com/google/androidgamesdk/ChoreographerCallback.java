package com.google.androidgamesdk;

import android.view.Choreographer;
/* loaded from: classes2.dex */
public class ChoreographerCallback implements Choreographer.FrameCallback {
    private long a;

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j2) {
        nOnChoreographer(this.a, j2);
    }

    public native void nOnChoreographer(long j2, long j3);
}
