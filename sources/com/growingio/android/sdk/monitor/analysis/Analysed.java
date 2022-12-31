package com.growingio.android.sdk.monitor.analysis;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class Analysed {
    public static final Analysed EMPTY_ANALYSED = new Analysed(null);
    private StackTraceElement mFirstTargetElement;
    private final Throwable mThrowable;
    private final List<StackGroup> mGroups = new ArrayList();
    private boolean mFindTarget = false;

    public Analysed(Throwable th) {
        this.mThrowable = th;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addGroup(StackGroup stackGroup) {
        this.mGroups.add(stackGroup);
    }

    public List<StackTraceElement> getElements(int i2) {
        if (i2 >= 1 && i2 <= this.mGroups.size()) {
            for (StackGroup stackGroup : this.mGroups) {
                if (stackGroup.getId().intValue() == i2) {
                    return stackGroup.getElements();
                }
            }
            return new ArrayList();
        }
        return new ArrayList();
    }

    public StackTraceElement getFirstTargetElement() {
        return this.mFirstTargetElement;
    }

    public StackGroup getGroup(int i2) {
        if (i2 >= 1 && i2 <= this.mGroups.size()) {
            for (StackGroup stackGroup : this.mGroups) {
                if (stackGroup.getId().intValue() == i2) {
                    return stackGroup;
                }
            }
            return StackGroup.NOT_FIND_GROUP;
        }
        return StackGroup.NOT_FIND_GROUP;
    }

    public List<StackGroup> getGroups() {
        return this.mGroups;
    }

    public Throwable getThrowable() {
        return this.mThrowable;
    }

    public boolean isFindTarget() {
        return this.mFindTarget;
    }

    public void setFirstTargetElement(StackTraceElement stackTraceElement) {
        this.mFirstTargetElement = stackTraceElement;
    }

    public void setIsFindTarget(boolean z) {
        this.mFindTarget = z;
    }

    public List<StackGroup> getGroups(String str) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        for (StackGroup stackGroup : this.mGroups) {
            if (str.equals(stackGroup.getName())) {
                arrayList.add(stackGroup);
            }
        }
        return arrayList;
    }
}
