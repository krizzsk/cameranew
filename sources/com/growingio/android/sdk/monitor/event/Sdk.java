package com.growingio.android.sdk.monitor.event;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class Sdk implements Serializable {
    private String name;
    private String version;

    public Sdk(String str, String str2) {
        this.name = str;
        this.version = str2;
    }

    public String getName() {
        return this.name;
    }

    public String getVersion() {
        return this.version;
    }
}
