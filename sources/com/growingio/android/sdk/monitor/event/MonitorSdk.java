package com.growingio.android.sdk.monitor.event;

import java.util.Set;
/* loaded from: classes2.dex */
public class MonitorSdk extends Sdk {
    private Set<String> integrations;

    public MonitorSdk(String str, String str2, Set<String> set) {
        super(str, str2);
        this.integrations = set;
    }

    public Set<String> getIntegrations() {
        return this.integrations;
    }
}
