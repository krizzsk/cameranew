package com.google.android.play.core.missingsplits;

import android.app.Application;
/* loaded from: classes2.dex */
public class MissingSplitsDetectingApplication extends Application {
    private boolean a = false;

    public void a() {
    }

    @Override // android.app.Application
    public final void onCreate() {
        if (this.a) {
            throw new IllegalStateException("The onCreate method must be invoked at most once.");
        }
        this.a = true;
        if (b.a(this).a()) {
            return;
        }
        super.onCreate();
        a();
    }
}
