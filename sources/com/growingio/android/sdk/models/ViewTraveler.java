package com.growingio.android.sdk.models;
/* loaded from: classes2.dex */
public abstract class ViewTraveler {
    public boolean needTraverse(ViewNode viewNode) {
        return viewNode.isNeedTrack();
    }

    public abstract void traverseCallBack(ViewNode viewNode);
}
