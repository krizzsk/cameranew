package com.growingio.android.sdk.base.event;

import android.app.Application;
import com.growingio.android.sdk.collection.Configuration;
/* loaded from: classes2.dex */
public class InitializeSDKEvent {
    private Application application;
    private final Configuration configuration;

    public InitializeSDKEvent(Application application, Configuration configuration) {
        this.application = application;
        this.configuration = configuration;
    }

    public Application getApplication() {
        return this.application;
    }

    public Configuration getConfiguration() {
        return this.configuration;
    }
}
