package com.growingio.android.sdk.monitor.analysis;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class StackGroup {
    public static final StackGroup NOT_FIND_GROUP = new StackGroup(-1, "not_find_group");
    private final List<StackTraceElement> mElements = new ArrayList();
    private final Integer mId;
    private final String mName;

    public StackGroup(Integer num, String str) {
        this.mId = num;
        this.mName = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addElement(StackTraceElement stackTraceElement) {
        this.mElements.add(stackTraceElement);
    }

    public List<StackTraceElement> getElements() {
        return this.mElements;
    }

    public Integer getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }
}
