package com.growingio.android.sdk.models;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PeopleEvent extends ConversionEvent {
    public static final String TYPE_NAME = "ppl";

    public PeopleEvent(JSONObject jSONObject, long j2) {
        super(jSONObject, j2);
    }

    @Override // com.growingio.android.sdk.models.ConversionEvent, com.growingio.android.sdk.models.VPAEvent
    public String getType() {
        return TYPE_NAME;
    }

    public PeopleEvent(JSONObject jSONObject) throws Throwable {
        super(jSONObject);
        this.mWebEvent = jSONObject;
    }
}
