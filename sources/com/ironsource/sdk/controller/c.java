package com.ironsource.sdk.controller;

import android.app.Activity;
import android.content.MutableContextWrapper;
/* compiled from: ContextProvider.java */
/* loaded from: classes2.dex */
public class c {
    MutableContextWrapper a;

    public Activity a() {
        return (Activity) this.a.getBaseContext();
    }

    public synchronized void b(Activity activity) {
        if (this.a == null) {
            this.a = new MutableContextWrapper(activity);
        }
        this.a.setBaseContext(activity);
    }
}
