package com.growingio.android.sdk.monitor.marshaller.json;

import com.growingio.android.sdk.monitor.event.interfaces.MonitorInterface;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public interface InterfaceBinding<T extends MonitorInterface> {
    void writeInterface(JSONObject jSONObject, T t) throws JSONException;
}
