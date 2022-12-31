package com.growingio.android.sdk.models;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AppCloseEvent extends VPAEvent {
    public static final String TYPE_NAME = "cls";

    public AppCloseEvent(PageEvent pageEvent, long j2) {
        super(j2);
        this.mPageName = pageEvent.mPageName;
    }

    @Override // com.growingio.android.sdk.models.VPAEvent
    public String getType() {
        return TYPE_NAME;
    }

    @Override // com.growingio.android.sdk.models.VPAEvent
    public JSONObject toJson() {
        try {
            JSONObject commonProperty = getCommonProperty();
            patchNetworkState(commonProperty);
            return commonProperty;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
