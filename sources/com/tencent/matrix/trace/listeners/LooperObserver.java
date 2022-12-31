package com.tencent.matrix.trace.listeners;

import androidx.annotation.CallSuper;
/* loaded from: classes3.dex */
public abstract class LooperObserver {
    private boolean isDispatchBegin = false;

    @CallSuper
    public void dispatchBegin(long j2, long j3, long j4) {
        this.isDispatchBegin = true;
    }

    @CallSuper
    public void dispatchEnd(long j2, long j3, long j4, long j5, long j6, boolean z) {
        this.isDispatchBegin = false;
    }

    public void doFrame(String str, long j2, long j3, boolean z, long j4, long j5, long j6, long j7) {
    }

    public boolean isDispatchBegin() {
        return this.isDispatchBegin;
    }
}
