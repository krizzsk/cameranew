package com.growingio.android.sdk.monitor.marshaller.json;

import com.growingio.android.sdk.monitor.event.interfaces.MessageInterface;
import com.growingio.android.sdk.monitor.util.Util;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class MessageInterfaceBinding implements InterfaceBinding<MessageInterface> {
    public static final int DEFAULT_MAX_MESSAGE_LENGTH = 1000;
    private static final String FORMATTED_PARAMETER = "formatted";
    private static final String MESSAGE_PARAMETER = "message";
    private static final String PARAMS_PARAMETER = "params";
    private final int maxMessageLength;

    public MessageInterfaceBinding() {
        this.maxMessageLength = 1000;
    }

    @Override // com.growingio.android.sdk.monitor.marshaller.json.InterfaceBinding
    public void writeInterface(JSONObject jSONObject, MessageInterface messageInterface) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("message", Util.trimString(messageInterface.getMessage(), this.maxMessageLength));
        JSONArray jSONArray = new JSONArray();
        for (String str : messageInterface.getParameters()) {
            jSONArray.put(str);
        }
        jSONObject2.put(PARAMS_PARAMETER, jSONArray);
        if (messageInterface.getFormatted() != null) {
            jSONObject2.put(FORMATTED_PARAMETER, Util.trimString(messageInterface.getFormatted(), this.maxMessageLength));
        }
        jSONObject.put(messageInterface.getInterfaceName(), jSONObject2);
    }

    public MessageInterfaceBinding(int i2) {
        this.maxMessageLength = i2;
    }
}
