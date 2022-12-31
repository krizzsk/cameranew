package com.growingio.android.sdk.monitor.event;

import com.growingio.android.sdk.monitor.event.interfaces.MonitorInterface;
import com.tapjoy.TJAdUnitConstants;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
/* loaded from: classes2.dex */
public class Event implements Serializable {
    private String alias;
    private String dist;
    private String environment;
    private final UUID id;
    private Level level;
    private String message;
    private String platform;
    private String release;
    private MonitorSdk sdk;
    private Date timestamp;
    private Map<String, String> tags = new HashMap();
    private List<Breadcrumb> breadcrumbs = new ArrayList();
    private Map<String, Map<String, Object>> contexts = new HashMap();
    private transient Map<String, Object> extra = new HashMap();
    private Map<String, MonitorInterface> monitorInterfaces = new HashMap();

    /* loaded from: classes2.dex */
    public enum Level {
        FATAL("fatal"),
        ERROR("error"),
        WARNING("warning"),
        INFO(TJAdUnitConstants.String.VIDEO_INFO),
        DEBUG("debug");
        
        private final String mName;

        Level(String str) {
            this.mName = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.mName;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Event(UUID uuid) {
        if (uuid != null) {
            this.id = uuid;
            return;
        }
        throw new IllegalArgumentException("The id can't be null");
    }

    private static HashMap<String, ? super Serializable> convertToSerializable(Map<String, Object> map) {
        HashMap<String, ? super Serializable> hashMap = new HashMap<>(map.size());
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getValue() == null) {
                hashMap.put(entry.getKey(), null);
            } else if (entry.getValue() instanceof Serializable) {
                hashMap.put(entry.getKey(), (Serializable) entry.getValue());
            } else {
                hashMap.put(entry.getKey(), entry.getValue().toString());
            }
        }
        return hashMap;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.extra = (Map) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(convertToSerializable(this.extra));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.id.equals(((Event) obj).id);
    }

    public String getAlias() {
        return this.alias;
    }

    public List<Breadcrumb> getBreadcrumbs() {
        return this.breadcrumbs;
    }

    public Map<String, Map<String, Object>> getContexts() {
        return this.contexts;
    }

    public String getDist() {
        return this.dist;
    }

    public String getEnvironment() {
        return this.environment;
    }

    public Map<String, Object> getExtra() {
        if (this.extra == null) {
            this.extra = new HashMap();
        }
        return this.extra;
    }

    public UUID getId() {
        return this.id;
    }

    public Level getLevel() {
        return this.level;
    }

    public String getMessage() {
        return this.message;
    }

    public Map<String, MonitorInterface> getMonitorInterfaces() {
        return this.monitorInterfaces;
    }

    public String getPlatform() {
        return this.platform;
    }

    public String getRelease() {
        return this.release;
    }

    public MonitorSdk getSdk() {
        return this.sdk;
    }

    public Map<String, String> getTags() {
        return this.tags;
    }

    public Date getTimestamp() {
        Date date = this.timestamp;
        if (date != null) {
            return (Date) date.clone();
        }
        return null;
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAlias(String str) {
        this.alias = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBreadcrumbs(List<Breadcrumb> list) {
        this.breadcrumbs = list;
    }

    public void setContexts(Map<String, Map<String, Object>> map) {
        this.contexts = map;
    }

    public void setDist(String str) {
        this.dist = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setEnvironment(String str) {
        this.environment = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setExtra(Map<String, Object> map) {
        this.extra = map;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setLevel(Level level) {
        this.level = level;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMessage(String str) {
        this.message = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMonitorInterfaces(Map<String, MonitorInterface> map) {
        this.monitorInterfaces = map;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPlatform(String str) {
        this.platform = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setRelease(String str) {
        this.release = str;
    }

    public void setSdk(MonitorSdk monitorSdk) {
        this.sdk = monitorSdk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setTags(Map<String, String> map) {
        this.tags = map;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setTimestamp(Date date) {
        this.timestamp = date;
    }

    public String toString() {
        return "Event{level=" + this.level + ", message='" + this.message + "'}";
    }
}
