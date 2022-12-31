package com.growingio.android.sdk.monitor.event;

import com.growingio.android.sdk.monitor.environment.MonitorEnvironment;
import com.growingio.android.sdk.monitor.event.Event;
import com.growingio.android.sdk.monitor.event.interfaces.MonitorInterface;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
/* loaded from: classes2.dex */
public class EventBuilder {
    public static final String DEFAULT_PLATFORM = "java";
    private boolean alreadyBuilt;
    private final Event event;
    private Set<String> sdkIntegrations;

    public EventBuilder() {
        this(UUID.randomUUID());
    }

    private void autoSetMissingValues() {
        if (this.event.getTimestamp() == null) {
            this.event.setTimestamp(new Date());
        }
        if (this.event.getPlatform() == null) {
            this.event.setPlatform(DEFAULT_PLATFORM);
        }
        if (this.event.getSdk() == null) {
            this.event.setSdk(new MonitorSdk(MonitorEnvironment.SDK_NAME, MonitorEnvironment.SDK_VERSION, this.sdkIntegrations));
        }
    }

    private void makeImmutable() {
        Event event = this.event;
        event.setTags(Collections.unmodifiableMap(event.getTags()));
        Event event2 = this.event;
        event2.setBreadcrumbs(Collections.unmodifiableList(event2.getBreadcrumbs()));
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, Map<String, Object>> entry : this.event.getContexts().entrySet()) {
            hashMap.put(entry.getKey(), Collections.unmodifiableMap(entry.getValue()));
        }
        this.event.setContexts(Collections.unmodifiableMap(hashMap));
        Event event3 = this.event;
        event3.setExtra(Collections.unmodifiableMap(event3.getExtra()));
        Event event4 = this.event;
        event4.setMonitorInterfaces(Collections.unmodifiableMap(event4.getMonitorInterfaces()));
    }

    public synchronized Event build() {
        if (!this.alreadyBuilt) {
            autoSetMissingValues();
            makeImmutable();
            this.alreadyBuilt = true;
        } else {
            throw new IllegalStateException("A message can't be built twice");
        }
        return this.event;
    }

    public Event getEvent() {
        return this.event;
    }

    public String toString() {
        return "EventBuilder{event=" + this.event + ", alreadyBuilt=" + this.alreadyBuilt + '}';
    }

    public EventBuilder withAlias(String str) {
        this.event.setAlias(str);
        return this;
    }

    public EventBuilder withBreadcrumbs(List<Breadcrumb> list) {
        this.event.setBreadcrumbs(list);
        return this;
    }

    public EventBuilder withContexts(Map<String, Map<String, Object>> map) {
        this.event.setContexts(map);
        return this;
    }

    public EventBuilder withDist(String str) {
        this.event.setDist(str);
        return this;
    }

    public EventBuilder withEnvironment(String str) {
        this.event.setEnvironment(str);
        return this;
    }

    public EventBuilder withExtra(String str, Object obj) {
        this.event.getExtra().put(str, obj);
        return this;
    }

    public EventBuilder withLevel(Event.Level level) {
        this.event.setLevel(level);
        return this;
    }

    public EventBuilder withMessage(String str) {
        this.event.setMessage(str);
        return this;
    }

    public EventBuilder withMonitorInterface(MonitorInterface monitorInterface) {
        return withMonitorInterface(monitorInterface, true);
    }

    public EventBuilder withPlatform(String str) {
        this.event.setPlatform(str);
        return this;
    }

    public EventBuilder withRelease(String str) {
        this.event.setRelease(str);
        return this;
    }

    public EventBuilder withSdkIntegration(String str) {
        this.sdkIntegrations.add(str);
        return this;
    }

    public EventBuilder withTag(String str, String str2) {
        this.event.getTags().put(str, str2);
        return this;
    }

    public EventBuilder withTimestamp(Date date) {
        this.event.setTimestamp(date);
        return this;
    }

    public EventBuilder(UUID uuid) {
        this.alreadyBuilt = false;
        this.sdkIntegrations = new HashSet();
        this.event = new Event(uuid);
    }

    public EventBuilder withMonitorInterface(MonitorInterface monitorInterface, boolean z) {
        if (z || !this.event.getMonitorInterfaces().containsKey(monitorInterface.getInterfaceName())) {
            this.event.getMonitorInterfaces().put(monitorInterface.getInterfaceName(), monitorInterface);
        }
        return this;
    }
}
