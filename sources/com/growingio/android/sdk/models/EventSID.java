package com.growingio.android.sdk.models;

import java.io.Serializable;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class EventSID implements Serializable {
    private HashMap<String, Integer> data = new HashMap<>();

    public int getSid(String str) {
        Integer num = this.data.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public EventSID setSid(String str, int i2) {
        this.data.put(str, Integer.valueOf(i2));
        return this;
    }
}
