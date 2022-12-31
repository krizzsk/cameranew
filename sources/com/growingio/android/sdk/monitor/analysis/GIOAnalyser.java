package com.growingio.android.sdk.monitor.analysis;

import com.growingio.android.sdk.monitor.analysis.Analyser;
/* loaded from: classes2.dex */
public class GIOAnalyser {
    private Analyser mAnalyser = new Analyser.Builder().useDefaultLibraries(true).addTargetGroupName("com.growingio").build();

    /* loaded from: classes2.dex */
    private static class SingleInstance {
        private static final GIOAnalyser INSTANCE = new GIOAnalyser();

        private SingleInstance() {
        }
    }

    public static GIOAnalyser getInstance() {
        return SingleInstance.INSTANCE;
    }

    public Analyser getAnalyser() {
        return this.mAnalyser;
    }
}
