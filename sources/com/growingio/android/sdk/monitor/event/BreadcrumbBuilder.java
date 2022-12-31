package com.growingio.android.sdk.monitor.event;

import com.growingio.android.sdk.monitor.event.Breadcrumb;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class BreadcrumbBuilder {
    private String category;
    private Map<String, String> data;
    private Breadcrumb.Level level;
    private String message;
    private Date timestamp;
    private Breadcrumb.Type type;

    public Breadcrumb build() {
        return new Breadcrumb(this.type, this.timestamp, this.level, this.message, this.category, this.data);
    }

    public BreadcrumbBuilder setCategory(String str) {
        this.category = str;
        return this;
    }

    public BreadcrumbBuilder setData(Map<String, String> map) {
        this.data = map;
        return this;
    }

    public BreadcrumbBuilder setLevel(Breadcrumb.Level level) {
        this.level = level;
        return this;
    }

    public BreadcrumbBuilder setMessage(String str) {
        this.message = str;
        return this;
    }

    public BreadcrumbBuilder setTimestamp(Date date) {
        this.timestamp = new Date(date.getTime());
        return this;
    }

    public BreadcrumbBuilder setType(Breadcrumb.Type type) {
        this.type = type;
        return this;
    }

    public BreadcrumbBuilder withData(String str, String str2) {
        if (this.data == null) {
            this.data = new HashMap();
        }
        this.data.put(str, str2);
        return this;
    }
}
