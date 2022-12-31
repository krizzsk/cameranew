package com.growingio.android.sdk.data;

import androidx.annotation.NonNull;
import com.growingio.android.sdk.base.event.BgInitializeSDKEvent;
import com.growingio.android.sdk.collection.CoreInitialize;
import com.growingio.android.sdk.data.db.MessageUploader;
import com.growingio.cp_annotation.Subscribe;
import com.growingio.eventcenter.EventCenter;
/* loaded from: classes2.dex */
public class DataSubscriberInitialize {
    private static volatile DataSubscriber dataSubscriber;
    private static volatile MessageUploader messageUploader;

    @NonNull
    public static MessageUploader messageUploader() {
        return messageUploader;
    }

    @Subscribe
    public static void onSDKInitialize(BgInitializeSDKEvent bgInitializeSDKEvent) {
        messageUploader = new MessageUploader(bgInitializeSDKEvent.application);
        messageUploader.afterInit();
        dataSubscriber = new DataSubscriber(bgInitializeSDKEvent.application, CoreInitialize.config(), CoreInitialize.coreAppState(), CoreInitialize.deviceUUIDFactory(), messageUploader);
        EventCenter.getInstance().register(dataSubscriber);
    }
}
