package com.pinguo.camera360.abtest;

import java.util.List;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: ABTestDataModel.kt */
/* loaded from: classes3.dex */
public final class Level implements NoProguard {
    private final List<String> instance_ids;
    private final String lid;
    private final String lname;

    public Level(String str, String str2, List<String> list) {
        this.lid = str;
        this.lname = str2;
        this.instance_ids = list;
    }

    public final List<String> getInstance_ids() {
        return this.instance_ids;
    }

    public final String getLid() {
        return this.lid;
    }

    public final String getLname() {
        return this.lname;
    }

    public final boolean isOK() {
        return (this.lid == null || this.instance_ids == null) ? false : true;
    }
}
