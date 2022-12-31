package com.growingio.android.sdk.monitor.marshaller.json;

import com.growingio.android.sdk.monitor.event.interfaces.UserInterface;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class UserInterfaceBinding implements InterfaceBinding<UserInterface> {
    private static final String DATA = "data";
    private static final String ID = "id";
    private static final String USERNAME = "username";

    @Override // com.growingio.android.sdk.monitor.marshaller.json.InterfaceBinding
    public void writeInterface(JSONObject jSONObject, UserInterface userInterface) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("id", userInterface.getId());
        jSONObject2.put(USERNAME, userInterface.getUsername());
        Map<String, Object> data = userInterface.getData();
        if (data != null && !data.isEmpty()) {
            jSONObject2.put("data", new JSONObject(userInterface.getData()));
        }
        jSONObject.put(userInterface.getInterfaceName(), jSONObject2);
    }
}
