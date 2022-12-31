package com.growingio.android.sdk.monitor;

import com.growingio.android.sdk.monitor.MonitorClient;
import com.growingio.android.sdk.monitor.context.Context;
import com.growingio.android.sdk.monitor.event.EventBuilder;
import com.growingio.android.sdk.monitor.event.helper.EventBuilderHelper;
import java.util.Collections;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class EmptyMonitorClient extends MonitorClient {
    static final EmptyMonitorClient EMPTY_MONITOR_CLIENT = new EmptyMonitorClient();
    static final Context EMPTY_CONTEXT = new Context(1);

    private EmptyMonitorClient() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.growingio.android.sdk.monitor.MonitorClient
    public void addBuilderHelper(EventBuilderHelper eventBuilderHelper) {
    }

    @Override // com.growingio.android.sdk.monitor.MonitorClient
    public void addExtra(String str, Object obj) {
    }

    @Override // com.growingio.android.sdk.monitor.MonitorClient
    public void addTag(String str, String str2) {
    }

    @Override // com.growingio.android.sdk.monitor.MonitorClient
    public void clearContext() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.growingio.android.sdk.monitor.MonitorClient
    public void closeConnection() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.growingio.android.sdk.monitor.MonitorClient
    public boolean filterThrowable(Throwable th) {
        return false;
    }

    @Override // com.growingio.android.sdk.monitor.MonitorClient
    public String getAlias() {
        return "EmptyMonitorClient getAlias";
    }

    @Override // com.growingio.android.sdk.monitor.MonitorClient
    List<EventBuilderHelper> getBuilderHelpers() {
        return Collections.emptyList();
    }

    @Override // com.growingio.android.sdk.monitor.MonitorClient
    public Context getContext() {
        return EMPTY_CONTEXT;
    }

    @Override // com.growingio.android.sdk.monitor.MonitorClient
    public String getDist() {
        return "EmptyMonitorClient getDist";
    }

    @Override // com.growingio.android.sdk.monitor.MonitorClient
    public String getEnvironment() {
        return "EmptyMonitorClient getEnvironment";
    }

    @Override // com.growingio.android.sdk.monitor.MonitorClient
    public Map<String, Object> getExtra() {
        return Collections.emptyMap();
    }

    @Override // com.growingio.android.sdk.monitor.MonitorClient
    public String getRelease() {
        return "EmptyMonitorClient getRelease";
    }

    @Override // com.growingio.android.sdk.monitor.MonitorClient
    public Map<String, String> getTags() {
        return Collections.emptyMap();
    }

    @Override // com.growingio.android.sdk.monitor.MonitorClient
    void removeBuilderHelper(EventBuilderHelper eventBuilderHelper) {
    }

    @Override // com.growingio.android.sdk.monitor.MonitorClient
    public void sendEvent(EventBuilder eventBuilder) {
    }

    @Override // com.growingio.android.sdk.monitor.MonitorClient
    public void sendException(Throwable th) {
    }

    @Override // com.growingio.android.sdk.monitor.MonitorClient
    public void sendMessage(String str) {
    }

    @Override // com.growingio.android.sdk.monitor.MonitorClient
    public void setDist(String str) {
    }

    @Override // com.growingio.android.sdk.monitor.MonitorClient
    public void setEnvironment(String str) {
    }

    @Override // com.growingio.android.sdk.monitor.MonitorClient
    public void setExtra(Map<String, Object> map) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.growingio.android.sdk.monitor.MonitorClient
    public void setFilterThrowable(MonitorClient.FilterThrowableRule filterThrowableRule) {
    }

    @Override // com.growingio.android.sdk.monitor.MonitorClient
    public void setPriority(int i2) {
    }

    @Override // com.growingio.android.sdk.monitor.MonitorClient
    public void setRelease(String str) {
    }

    @Override // com.growingio.android.sdk.monitor.MonitorClient
    public void setTags(Map<String, String> map) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.growingio.android.sdk.monitor.MonitorClient
    public void stopSyncCachedEvent() {
    }

    @Override // com.growingio.android.sdk.monitor.MonitorClient
    public String toString() {
        return "EmptyMonitorClient";
    }
}
