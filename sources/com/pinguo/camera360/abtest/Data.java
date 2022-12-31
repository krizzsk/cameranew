package com.pinguo.camera360.abtest;

import java.util.List;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: ABTestDataModel.kt */
/* loaded from: classes3.dex */
public final class Data implements NoProguard {
    private final List<Instance> instance;
    private final List<Level> level;

    public Data(List<Level> list, List<Instance> list2) {
        this.level = list;
        this.instance = list2;
    }

    public final List<Instance> getInstance() {
        return this.instance;
    }

    public final List<Level> getLevel() {
        return this.level;
    }
}
