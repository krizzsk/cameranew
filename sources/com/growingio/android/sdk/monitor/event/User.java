package com.growingio.android.sdk.monitor.event;

import java.io.Serializable;
import java.util.Map;
/* loaded from: classes2.dex */
public class User implements Serializable {
    private final Map<String, Object> data;
    private final String id;
    private final String username;

    public User(String str, String str2, Map<String, Object> map) {
        this.id = str;
        this.username = str2;
        this.data = map;
    }

    public Map<String, Object> getData() {
        return this.data;
    }

    public String getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public User(String str, String str2) {
        this(str, str2, null);
    }
}
