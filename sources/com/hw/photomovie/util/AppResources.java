package com.hw.photomovie.util;

import android.content.res.Resources;
/* loaded from: classes2.dex */
public class AppResources {
    private Resources a;

    /* loaded from: classes2.dex */
    private static final class b {
        private static AppResources a = new AppResources();
    }

    public static AppResources getInstance() {
        return b.a;
    }

    public Resources a() {
        Resources resources = this.a;
        if (resources != null) {
            return resources;
        }
        throw new RuntimeException("ApplicationResource never inited.");
    }

    public void b(Resources resources) {
        this.a = resources;
    }

    private AppResources() {
    }
}
