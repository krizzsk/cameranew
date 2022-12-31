package com.growingio.android.sdk.monitor.marshaller.json;

import com.growingio.android.sdk.monitor.event.interfaces.ExceptionInterface;
import com.growingio.android.sdk.monitor.event.interfaces.MonitorException;
import com.growingio.android.sdk.monitor.event.interfaces.StackTraceInterface;
import java.util.Deque;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ExceptionInterfaceBinding implements InterfaceBinding<ExceptionInterface> {
    private static final String MODULE_PARAMETER = "module";
    private static final String TYPE_PARAMETER = "type";
    private static final String VALUE_PARAMETER = "value";
    private final InterfaceBinding<StackTraceInterface> stackTraceInterfaceBinding;

    public ExceptionInterfaceBinding(InterfaceBinding<StackTraceInterface> interfaceBinding) {
        this.stackTraceInterfaceBinding = interfaceBinding;
    }

    private JSONObject getExceptionJsonObject(MonitorException monitorException) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", monitorException.getExceptionClassName());
        jSONObject.put("value", monitorException.getExceptionMessage());
        jSONObject.put(MODULE_PARAMETER, monitorException.getExceptionPackageName());
        this.stackTraceInterfaceBinding.writeInterface(jSONObject, monitorException.getStackTraceInterface());
        return jSONObject;
    }

    @Override // com.growingio.android.sdk.monitor.marshaller.json.InterfaceBinding
    public void writeInterface(JSONObject jSONObject, ExceptionInterface exceptionInterface) throws JSONException {
        Deque<MonitorException> exceptions = exceptionInterface.getExceptions();
        JSONArray jSONArray = new JSONArray();
        Iterator<MonitorException> descendingIterator = exceptions.descendingIterator();
        while (descendingIterator.hasNext()) {
            jSONArray.put(getExceptionJsonObject(descendingIterator.next()));
        }
        jSONObject.put(exceptionInterface.getInterfaceName(), jSONArray);
    }
}
