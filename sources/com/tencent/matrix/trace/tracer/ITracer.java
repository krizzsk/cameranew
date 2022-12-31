package com.tencent.matrix.trace.tracer;

import com.tencent.matrix.listeners.IAppForeground;
/* loaded from: classes3.dex */
public interface ITracer extends IAppForeground {
    boolean isAlive();

    void onCloseTrace();

    void onStartTrace();
}
