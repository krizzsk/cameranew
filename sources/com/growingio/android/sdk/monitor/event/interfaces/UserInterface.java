package com.growingio.android.sdk.monitor.event.interfaces;

import java.util.Map;
/* loaded from: classes2.dex */
public class UserInterface implements MonitorInterface {
    public static final String USER_INTERFACE = "sentry.interfaces.User";
    private final Map<String, Object> data;
    private final String id;
    private final String username;

    public UserInterface(String str, String str2, Map<String, Object> map) {
        this.id = str;
        this.username = str2;
        this.data = map;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        UserInterface userInterface = (UserInterface) obj;
        String str = this.id;
        if (str == null ? userInterface.id == null : str.equals(userInterface.id)) {
            String str2 = this.username;
            if (str2 == null ? userInterface.username == null : str2.equals(userInterface.username)) {
                Map<String, Object> map = this.data;
                Map<String, Object> map2 = userInterface.data;
                return map != null ? map.equals(map2) : map2 == null;
            }
            return false;
        }
        return false;
    }

    public Map<String, Object> getData() {
        return this.data;
    }

    public String getId() {
        return this.id;
    }

    @Override // com.growingio.android.sdk.monitor.event.interfaces.MonitorInterface
    public String getInterfaceName() {
        return USER_INTERFACE;
    }

    public String getUsername() {
        return this.username;
    }

    public int hashCode() {
        String str = this.id;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.username;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Map<String, Object> map = this.data;
        return hashCode2 + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        return "UserInterface{id='" + this.id + "', username='" + this.username + "', data=" + this.data + '}';
    }

    public UserInterface(String str, String str2) {
        this(str, str2, null);
    }
}
