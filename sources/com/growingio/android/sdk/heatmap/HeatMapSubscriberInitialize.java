package com.growingio.android.sdk.heatmap;

import com.growingio.android.sdk.base.event.BgInitializeSDKEvent;
import com.growingio.cp_annotation.Subscribe;
import com.growingio.eventcenter.EventCenter;
/* loaded from: classes2.dex */
public class HeatMapSubscriberInitialize {
    @Subscribe
    public static void onSDKInitialize(BgInitializeSDKEvent bgInitializeSDKEvent) {
        EventCenter.getInstance().register(new HeatMapSubscriber());
    }
}
