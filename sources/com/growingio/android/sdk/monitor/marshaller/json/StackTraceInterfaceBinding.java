package com.growingio.android.sdk.monitor.marshaller.json;

import com.growingio.android.sdk.monitor.event.interfaces.MonitorStackTraceElement;
import com.growingio.android.sdk.monitor.event.interfaces.StackTraceInterface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class StackTraceInterfaceBinding implements InterfaceBinding<StackTraceInterface> {
    private static final String FILENAME_PARAMETER = "filename";
    private static final String FRAMES_PARAMETER = "frames";
    private static final String FUNCTION_PARAMETER = "function";
    private static final String IN_APP_PARAMETER = "in_app";
    private static final String LINE_NO_PARAMETER = "lineno";
    private static final String MODULE_PARAMETER = "module";
    private static final String STACKTRACE_PARAMETER = "stacktrace";
    private static List<Pattern> inAppBlacklistRegexps;
    private Collection<String> inAppFrames = Collections.emptyList();
    private boolean removeCommonFramesWithEnclosing = true;

    static {
        ArrayList arrayList = new ArrayList();
        inAppBlacklistRegexps = arrayList;
        arrayList.add(Pattern.compile("\\$\\$FastClass[a-zA-Z]*CGLIB\\$\\$"));
        inAppBlacklistRegexps.add(Pattern.compile("\\$\\$Enhancer[a-zA-Z]*CGLIB\\$\\$"));
    }

    private JSONObject getFrameJsonObject(MonitorStackTraceElement monitorStackTraceElement, boolean z) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(FILENAME_PARAMETER, monitorStackTraceElement.getFileName());
        jSONObject.put(MODULE_PARAMETER, monitorStackTraceElement.getModule());
        jSONObject.put(IN_APP_PARAMETER, !(this.removeCommonFramesWithEnclosing && z) && isFrameInApp(monitorStackTraceElement));
        jSONObject.put(FUNCTION_PARAMETER, monitorStackTraceElement.getFunction());
        jSONObject.put(LINE_NO_PARAMETER, monitorStackTraceElement.getLineno());
        return jSONObject;
    }

    private boolean isBlacklistedFromInApp(String str) {
        for (Pattern pattern : inAppBlacklistRegexps) {
            if (pattern.matcher(str).find()) {
                return true;
            }
        }
        return false;
    }

    private boolean isFrameInApp(MonitorStackTraceElement monitorStackTraceElement) {
        for (String str : this.inAppFrames) {
            String module = monitorStackTraceElement.getModule();
            if (module.startsWith(str) && !isBlacklistedFromInApp(module)) {
                return true;
            }
        }
        return false;
    }

    public void setInAppFrames(Collection<String> collection) {
        this.inAppFrames = collection;
    }

    public void setRemoveCommonFramesWithEnclosing(boolean z) {
        this.removeCommonFramesWithEnclosing = z;
    }

    @Override // com.growingio.android.sdk.monitor.marshaller.json.InterfaceBinding
    public void writeInterface(JSONObject jSONObject, StackTraceInterface stackTraceInterface) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        MonitorStackTraceElement[] stackTrace = stackTraceInterface.getStackTrace();
        int framesCommonWithEnclosing = stackTraceInterface.getFramesCommonWithEnclosing();
        int length = stackTrace.length - 1;
        while (length >= 0) {
            int i2 = framesCommonWithEnclosing - 1;
            jSONArray.put(getFrameJsonObject(stackTrace[length], framesCommonWithEnclosing > 0));
            length--;
            framesCommonWithEnclosing = i2;
        }
        jSONObject.put(STACKTRACE_PARAMETER, new JSONObject().put(FRAMES_PARAMETER, jSONArray));
    }
}
