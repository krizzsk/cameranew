package com.growingio.android.sdk.monitor.context;

import com.growingio.android.sdk.monitor.event.Breadcrumb;
import com.growingio.android.sdk.monitor.event.Sdk;
import com.growingio.android.sdk.monitor.event.User;
import com.growingio.android.sdk.monitor.util.CircularFifoQueue;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
/* loaded from: classes2.dex */
public class Context implements Serializable {
    private static final int DEFAULT_BREADCRUMB_LIMIT = 100;
    private final int breadcrumbLimit;
    private volatile CircularFifoQueue<Breadcrumb> breadcrumbs;
    private volatile Map<String, Object> extra;
    private final Set<Sdk> integrationSdk;
    private volatile UUID lastEventId;
    private volatile Map<String, String> tags;
    private volatile User user;

    public Context() {
        this(100);
    }

    public synchronized void addExtra(String str, Object obj) {
        if (this.extra == null) {
            this.extra = new HashMap();
        }
        this.extra.put(str, obj);
    }

    public void addIntegrationSdk(Sdk sdk) {
        this.integrationSdk.add(sdk);
    }

    public synchronized void addTag(String str, String str2) {
        if (this.tags == null) {
            this.tags = new HashMap();
        }
        this.tags.put(str, str2);
    }

    public synchronized void clear() {
        setLastEventId(null);
        clearBreadcrumbs();
        clearUser();
        clearTags();
        clearExtra();
    }

    public synchronized void clearBreadcrumbs() {
        this.breadcrumbs = null;
    }

    public synchronized void clearExtra() {
        this.extra = null;
    }

    public synchronized void clearTags() {
        this.tags = null;
    }

    public void clearUser() {
        setUser(null);
    }

    public synchronized List<Breadcrumb> getBreadcrumbs() {
        if (this.breadcrumbs != null && !this.breadcrumbs.isEmpty()) {
            ArrayList arrayList = new ArrayList(this.breadcrumbs.size());
            arrayList.addAll(this.breadcrumbs);
            return arrayList;
        }
        return Collections.emptyList();
    }

    public synchronized Map<String, Object> getExtra() {
        if (this.extra != null && !this.extra.isEmpty()) {
            return Collections.unmodifiableMap(this.extra);
        }
        return Collections.emptyMap();
    }

    public Set<Sdk> getIntegrationSdk() {
        return this.integrationSdk;
    }

    public UUID getLastEventId() {
        return this.lastEventId;
    }

    public synchronized Map<String, String> getTags() {
        if (this.tags != null && !this.tags.isEmpty()) {
            return Collections.unmodifiableMap(this.tags);
        }
        return Collections.emptyMap();
    }

    public User getUser() {
        return this.user;
    }

    public synchronized void recordBreadcrumb(Breadcrumb breadcrumb) {
        if (this.breadcrumbs == null) {
            this.breadcrumbs = new CircularFifoQueue<>(this.breadcrumbLimit);
        }
        this.breadcrumbs.add(breadcrumb);
    }

    public synchronized void removeExtra(String str) {
        if (this.extra == null) {
            return;
        }
        this.extra.remove(str);
    }

    public synchronized void removeTag(String str) {
        if (this.tags == null) {
            return;
        }
        this.tags.remove(str);
    }

    public void setLastEventId(UUID uuid) {
        this.lastEventId = uuid;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Context(int i2) {
        this.integrationSdk = new HashSet();
        this.breadcrumbLimit = i2;
    }
}
