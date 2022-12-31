package com.growingio.android.sdk.monitor.event.interfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public class MessageInterface implements MonitorInterface {
    public static final String MESSAGE_INTERFACE = "sentry.interfaces.Message";
    private final String formatted;
    private final String message;
    private final List<String> parameters;

    public MessageInterface(String str) {
        this(str, Collections.emptyList());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MessageInterface messageInterface = (MessageInterface) obj;
        String str = this.message;
        if (str == null ? messageInterface.message == null : str.equals(messageInterface.message)) {
            List<String> list = this.parameters;
            if (list == null ? messageInterface.parameters == null : list.equals(messageInterface.parameters)) {
                String str2 = this.formatted;
                String str3 = messageInterface.formatted;
                return str2 != null ? str2.equals(str3) : str3 == null;
            }
            return false;
        }
        return false;
    }

    public String getFormatted() {
        return this.formatted;
    }

    @Override // com.growingio.android.sdk.monitor.event.interfaces.MonitorInterface
    public String getInterfaceName() {
        return MESSAGE_INTERFACE;
    }

    public String getMessage() {
        return this.message;
    }

    public List<String> getParameters() {
        return this.parameters;
    }

    public int hashCode() {
        String str = this.message;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<String> list = this.parameters;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        String str2 = this.formatted;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "MessageInterface{message='" + this.message + "', parameters=" + this.parameters + ", formatted=" + this.formatted + '}';
    }

    public MessageInterface(String str, String... strArr) {
        this(str, Arrays.asList(strArr));
    }

    public MessageInterface(String str, List<String> list) {
        this(str, list, null);
    }

    public MessageInterface(String str, List<String> list, String str2) {
        this.message = str;
        this.parameters = Collections.unmodifiableList(new ArrayList(list));
        this.formatted = str2;
    }
}
