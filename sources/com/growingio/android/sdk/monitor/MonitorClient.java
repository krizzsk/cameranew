package com.growingio.android.sdk.monitor;

import androidx.annotation.NonNull;
import com.growingio.android.sdk.monitor.connection.Connection;
import com.growingio.android.sdk.monitor.context.Context;
import com.growingio.android.sdk.monitor.context.ContextManager;
import com.growingio.android.sdk.monitor.event.Event;
import com.growingio.android.sdk.monitor.event.EventBuilder;
import com.growingio.android.sdk.monitor.event.helper.EventBuilderHelper;
import com.growingio.android.sdk.monitor.event.helper.ShouldSendEventCallback;
import com.growingio.android.sdk.monitor.event.interfaces.ExceptionInterface;
import com.growingio.android.sdk.monitor.log.MLog;
import com.growingio.android.sdk.monitor.util.Util;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes2.dex */
public class MonitorClient {
    private static final String TAG = "MonitorClient";
    protected String alias;
    private final List<EventBuilderHelper> builderHelpers;
    private final Connection connection;
    private final ContextManager contextManager;
    protected String dist;
    protected String environment;
    protected Map<String, Object> extra;
    private FilterThrowableRule filterThrowableRule;
    private boolean isClosed;
    protected int priority;
    protected String release;
    private final Set<ShouldSendEventCallback> shouldSendEventCallbacks;
    protected Map<String, String> tags;

    /* loaded from: classes2.dex */
    public interface FilterThrowableRule {
        boolean filterThrowable(Throwable th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MonitorClient() {
        this.priority = 0;
        this.tags = new HashMap();
        this.extra = new HashMap();
        this.shouldSendEventCallbacks = new HashSet();
        this.builderHelpers = new CopyOnWriteArrayList();
        this.filterThrowableRule = new FilterThrowableRule() { // from class: com.growingio.android.sdk.monitor.MonitorClient.1
            @Override // com.growingio.android.sdk.monitor.MonitorClient.FilterThrowableRule
            public boolean filterThrowable(Throwable th) {
                return true;
            }
        };
        this.isClosed = false;
        this.alias = null;
        this.connection = null;
        this.contextManager = null;
    }

    private void runBuilderHelpers(EventBuilder eventBuilder) {
        for (EventBuilderHelper eventBuilderHelper : this.builderHelpers) {
            eventBuilderHelper.helpBuildingEvent(eventBuilder);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addBuilderHelper(EventBuilderHelper eventBuilderHelper) {
        MLog.d(TAG, "Adding " + eventBuilderHelper + " to the list of builder helpers.");
        this.builderHelpers.add(eventBuilderHelper);
    }

    public void addExtra(String str, Object obj) {
        this.extra.put(str, obj);
    }

    public void addTag(String str, String str2) {
        this.tags.put(str, str2);
    }

    public void clearContext() {
        this.contextManager.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void closeConnection() {
        this.isClosed = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean filterThrowable(Throwable th) {
        if (this.isClosed) {
            return false;
        }
        return this.filterThrowableRule.filterThrowable(th);
    }

    public String getAlias() {
        return this.alias;
    }

    List<EventBuilderHelper> getBuilderHelpers() {
        return Collections.unmodifiableList(this.builderHelpers);
    }

    public Context getContext() {
        return this.contextManager.getContext();
    }

    public String getDist() {
        return this.dist;
    }

    public String getEnvironment() {
        return this.environment;
    }

    public Map<String, Object> getExtra() {
        return this.extra;
    }

    public String getRelease() {
        return this.release;
    }

    public Map<String, String> getTags() {
        return Collections.unmodifiableMap(this.tags);
    }

    void removeBuilderHelper(EventBuilderHelper eventBuilderHelper) {
        MLog.d(TAG, "Removing " + eventBuilderHelper + " from the list of builder helpers.");
        this.builderHelpers.remove(eventBuilderHelper);
    }

    public void sendEvent(@NonNull EventBuilder eventBuilder) {
        eventBuilder.withAlias(this.alias);
        if (!Util.isNullOrEmpty(this.release)) {
            eventBuilder.withRelease(this.release.trim());
            if (!Util.isNullOrEmpty(this.dist)) {
                eventBuilder.withDist(this.dist.trim());
            }
        }
        if (!Util.isNullOrEmpty(this.environment)) {
            eventBuilder.withEnvironment(this.environment.trim());
        }
        for (Map.Entry<String, String> entry : this.tags.entrySet()) {
            eventBuilder.withTag(entry.getKey(), entry.getValue());
        }
        for (Map.Entry<String, Object> entry2 : this.extra.entrySet()) {
            eventBuilder.withExtra(entry2.getKey(), entry2.getValue());
        }
        runBuilderHelpers(eventBuilder);
        sendEvent(eventBuilder.build());
    }

    public void sendException(@NonNull Throwable th) {
        sendEvent(new EventBuilder().withMessage(th.getMessage()).withLevel(Event.Level.ERROR).withMonitorInterface(new ExceptionInterface(th)));
    }

    public void sendMessage(String str) {
        sendEvent(new EventBuilder().withMessage(str).withLevel(Event.Level.INFO));
    }

    public void setDist(String str) {
        this.dist = str;
    }

    public void setEnvironment(String str) {
        this.environment = str;
    }

    public void setExtra(Map<String, Object> map) {
        if (map == null) {
            this.extra = new HashMap();
        } else {
            this.extra = map;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setFilterThrowable(FilterThrowableRule filterThrowableRule) {
        if (filterThrowableRule != null) {
            this.filterThrowableRule = filterThrowableRule;
        }
    }

    public void setPriority(int i2) {
        this.priority = i2;
    }

    public void setRelease(String str) {
        this.release = str;
    }

    public void setTags(Map<String, String> map) {
        if (map == null) {
            this.tags = new HashMap();
        } else {
            this.tags = map;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stopSyncCachedEvent() {
        this.connection.stopSyncCachedEvent();
    }

    public String toString() {
        return "MonitorClient{release='" + this.release + "', dist='" + this.dist + "', environment='" + this.environment + "', tags=" + this.tags + ", extra=" + this.extra + ", connection=" + this.connection + ", builderHelpers=" + this.builderHelpers + ", contextManager=" + this.contextManager + '}';
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MonitorClient(String str, Connection connection, ContextManager contextManager) {
        this.priority = 0;
        this.tags = new HashMap();
        this.extra = new HashMap();
        this.shouldSendEventCallbacks = new HashSet();
        this.builderHelpers = new CopyOnWriteArrayList();
        this.filterThrowableRule = new FilterThrowableRule() { // from class: com.growingio.android.sdk.monitor.MonitorClient.1
            @Override // com.growingio.android.sdk.monitor.MonitorClient.FilterThrowableRule
            public boolean filterThrowable(Throwable th) {
                return true;
            }
        };
        this.isClosed = false;
        this.alias = str;
        this.connection = connection;
        this.contextManager = contextManager;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.util.UUID] */
    private void sendEvent(@NonNull Event event) {
        ShouldSendEventCallback next;
        Iterator<ShouldSendEventCallback> it = this.shouldSendEventCallbacks.iterator();
        do {
            try {
                if (!it.hasNext()) {
                    try {
                        this.connection.send(event);
                    } catch (Exception e2) {
                        MLog.e(TAG, "An exception occurred while sending the event to Monitor.", e2);
                    }
                    return;
                }
                next = it.next();
            } finally {
                getContext().setLastEventId(event.getId());
            }
        } while (next.shouldSend(event));
        MLog.d(TAG, "Not sending Event because of ShouldSendEventCallback: " + next);
    }
}
