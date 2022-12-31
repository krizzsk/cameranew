package com.tencent.matrix.trace.tracer;

import androidx.annotation.CallSuper;
import com.tencent.matrix.AppActiveMatrixDelegate;
import com.tencent.matrix.trace.listeners.LooperObserver;
import com.tencent.matrix.util.MatrixLog;
/* loaded from: classes3.dex */
public abstract class Tracer extends LooperObserver implements ITracer {
    private static final String TAG = "Matrix.Tracer";
    private volatile boolean isAlive = false;

    @Override // com.tencent.matrix.trace.tracer.ITracer
    public boolean isAlive() {
        return this.isAlive;
    }

    public boolean isForeground() {
        return AppActiveMatrixDelegate.INSTANCE.isAppForeground();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public void onAlive() {
        MatrixLog.i(TAG, "[onAlive] %s", getClass().getName());
    }

    @Override // com.tencent.matrix.trace.tracer.ITracer
    public final synchronized void onCloseTrace() {
        if (this.isAlive) {
            this.isAlive = false;
            onDead();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public void onDead() {
        MatrixLog.i(TAG, "[onDead] %s", getClass().getName());
    }

    public void onForeground(boolean z) {
    }

    @Override // com.tencent.matrix.trace.tracer.ITracer
    public final synchronized void onStartTrace() {
        if (!this.isAlive) {
            this.isAlive = true;
            onAlive();
        }
    }
}
