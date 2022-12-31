package com.growingio.eventcenter;

import android.app.Application;
import com.growingio.eventcenter.bus.EventBus;
import com.growingio.eventcenter.bus.EventCenterException;
import com.growingio.eventcenter.bus.meta.StaticSubscriberCenter;
/* loaded from: classes2.dex */
public class EventCenter {
    private static final String TAG = "EventCenter";
    private volatile boolean initStart;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class SingletonHolder {
        private static final EventCenter singleton = new EventCenter();

        private SingletonHolder() {
        }
    }

    public static EventCenter getInstance() {
        return SingletonHolder.singleton;
    }

    public void init(Application application) {
        synchronized (this) {
            this.initStart = true;
            EventBus.builder().installDefaultEventBus();
            EventBus.getDefault().register(new StaticSubscriberCenter());
        }
    }

    public void post(Object obj) {
        if (this.initStart) {
            EventBus.getDefault().post(obj);
            return;
        }
        throw new EventCenterException("Please init EventCenter first!");
    }

    public void register(Object obj) {
        EventBus.getDefault().register(obj);
    }

    public void registerFilter(EventFilter eventFilter) {
        EventBus.getDefault().registerFilter(eventFilter);
    }

    public void unregisterFilter(EventFilter eventFilter) {
        EventBus.getDefault().unRegisterFilter(eventFilter);
    }

    private EventCenter() {
        this.initStart = false;
    }
}
