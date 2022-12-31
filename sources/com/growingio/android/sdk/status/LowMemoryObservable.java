package com.growingio.android.sdk.status;

import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import com.growingio.android.sdk.base.event.OnCloseBufferEvent;
import com.growingio.eventcenter.EventCenter;
/* loaded from: classes2.dex */
public class LowMemoryObservable implements ComponentCallbacks {
    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        EventCenter.getInstance().post(new OnCloseBufferEvent());
    }
}
