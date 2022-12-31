package com.growingio.android.sdk.base.event;

import android.app.Application;
import com.growingio.android.sdk.collection.Configuration;
/* loaded from: classes2.dex */
public class BgInitializeSDKEvent {
    public final Application application;
    public final Configuration configuration;

    public BgInitializeSDKEvent(Application application, Configuration configuration) {
        this.application = application;
        this.configuration = configuration;
    }
}
