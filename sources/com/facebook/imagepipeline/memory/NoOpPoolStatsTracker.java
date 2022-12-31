package com.facebook.imagepipeline.memory;

import javax.annotation.Nullable;
/* loaded from: classes.dex */
public class NoOpPoolStatsTracker implements d0 {
    @Nullable
    private static NoOpPoolStatsTracker a;

    private NoOpPoolStatsTracker() {
    }

    public static synchronized NoOpPoolStatsTracker getInstance() {
        NoOpPoolStatsTracker noOpPoolStatsTracker;
        synchronized (NoOpPoolStatsTracker.class) {
            if (a == null) {
                a = new NoOpPoolStatsTracker();
            }
            noOpPoolStatsTracker = a;
        }
        return noOpPoolStatsTracker;
    }

    @Override // com.facebook.imagepipeline.memory.d0
    public void a() {
    }

    @Override // com.facebook.imagepipeline.memory.d0
    public void b(int i2) {
    }

    @Override // com.facebook.imagepipeline.memory.d0
    public void c(int i2) {
    }

    @Override // com.facebook.imagepipeline.memory.d0
    public void d(int i2) {
    }

    @Override // com.facebook.imagepipeline.memory.d0
    public void e(int i2) {
    }

    @Override // com.facebook.imagepipeline.memory.d0
    public void f(BasePool basePool) {
    }

    @Override // com.facebook.imagepipeline.memory.d0
    public void g() {
    }
}
