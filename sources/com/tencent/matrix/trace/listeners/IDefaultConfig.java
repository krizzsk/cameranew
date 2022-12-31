package com.tencent.matrix.trace.listeners;
/* loaded from: classes3.dex */
public interface IDefaultConfig {
    String getAnrTraceFilePath();

    int getLooperPrinterStackStyle();

    String getPrintTraceFilePath();

    boolean isAnrTraceEnable();

    boolean isAppMethodBeatEnable();

    boolean isDebug();

    boolean isDevEnv();

    boolean isEvilMethodTraceEnable();

    boolean isFPSEnable();

    boolean isIdleHandlerEnable();

    boolean isMainThreadPriorityTraceEnable();

    boolean isSignalAnrTraceEnable();
}
