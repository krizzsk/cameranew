package com.growingio.android.sdk.base.event;

import com.growingio.android.sdk.models.ViewNode;
import java.util.List;
/* loaded from: classes2.dex */
public class CircleGotWebSnapshotNodeEvent {
    private final String host;
    private final List<ViewNode> nodes;
    private final String path;

    public CircleGotWebSnapshotNodeEvent(List<ViewNode> list, String str, String str2) {
        this.nodes = list;
        this.host = str;
        this.path = str2;
    }

    public String getHost() {
        return this.host;
    }

    public List<ViewNode> getNodes() {
        return this.nodes;
    }

    public String getPath() {
        return this.path;
    }
}
