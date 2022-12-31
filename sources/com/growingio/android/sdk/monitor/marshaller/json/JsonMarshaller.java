package com.growingio.android.sdk.monitor.marshaller.json;

import com.growingio.android.sdk.monitor.event.Breadcrumb;
import com.growingio.android.sdk.monitor.event.Event;
import com.growingio.android.sdk.monitor.event.MonitorSdk;
import com.growingio.android.sdk.monitor.event.interfaces.MonitorInterface;
import com.growingio.android.sdk.monitor.log.MLog;
import com.growingio.android.sdk.monitor.util.Util;
import com.tapjoy.TJAdUnitConstants;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.common.network.common.header.PGTransHeader;
/* loaded from: classes2.dex */
public class JsonMarshaller {
    public static final String BREADCRUMBS = "breadcrumbs";
    public static final String CONTEXTS = "contexts";
    public static final int DEFAULT_MAX_MESSAGE_LENGTH = 1000;
    public static final String DIST = "dist";
    public static final String ENVIRONMENT = "environment";
    public static final String EVENT_ID = "event_id";
    public static final String EXTRA = "extra";
    private static final ThreadLocal<DateFormat> ISO_FORMAT = new ThreadLocal<DateFormat>() { // from class: com.growingio.android.sdk.monitor.marshaller.json.JsonMarshaller.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public DateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            return simpleDateFormat;
        }
    };
    public static final String LEVEL = "level";
    public static final String MESSAGE = "message";
    public static final String PLATFORM = "platform";
    public static final String RELEASE = "release";
    public static final String SDK = "sdk";
    private static final String TAG = "JsonMarshaller";
    public static final String TAGS = "tags";
    public static final String TIMESTAMP = "timestamp";
    private final Map<Class<? extends MonitorInterface>, InterfaceBinding<?>> interfaceBindings;
    private final int maxMessageLength;

    public JsonMarshaller() {
        this(1000);
    }

    private String formatId(UUID uuid) {
        return uuid.toString().replaceAll(PGTransHeader.CONNECTOR, "");
    }

    private <T extends MonitorInterface> InterfaceBinding<? super T> getInterfaceBinding(T t) {
        return (InterfaceBinding<? super T>) this.interfaceBindings.get(t.getClass());
    }

    private void writeBreadcumbs(JSONObject jSONObject, List<Breadcrumb> list) throws JSONException {
        if (list == null || list.isEmpty()) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        for (Breadcrumb breadcrumb : list) {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("timestamp", breadcrumb.getTimestamp().getTime() / 1000);
            if (breadcrumb.getType() != null) {
                jSONObject3.put("type", breadcrumb.getType().getValue());
            }
            if (breadcrumb.getLevel() != null) {
                jSONObject3.put("level", breadcrumb.getLevel().getValue());
            }
            if (breadcrumb.getMessage() != null) {
                jSONObject3.put("message", breadcrumb.getMessage());
            }
            if (breadcrumb.getCategory() != null) {
                jSONObject3.put("category", breadcrumb.getCategory());
            }
            if (breadcrumb.getData() != null && !breadcrumb.getData().isEmpty()) {
                jSONObject3.put("data", new JSONObject(breadcrumb.getData()));
            }
            jSONArray.put(jSONObject3);
        }
        jSONObject2.put(TJAdUnitConstants.String.USAGE_TRACKER_VALUES, jSONArray);
        jSONObject.put(BREADCRUMBS, jSONObject2);
    }

    private void writeContent(JSONObject jSONObject, Event event) throws JSONException {
        jSONObject.put(EVENT_ID, formatId(event.getId()));
        jSONObject.put("message", Util.trimString(event.getMessage(), this.maxMessageLength));
        jSONObject.put("timestamp", ISO_FORMAT.get().format(event.getTimestamp()));
        jSONObject.put("level", event.getLevel().toString());
        jSONObject.put("platform", event.getPlatform());
        writeSdk(jSONObject, event.getSdk());
        writeTags(jSONObject, event.getTags());
        writeBreadcumbs(jSONObject, event.getBreadcrumbs());
        writeContexts(jSONObject, event.getContexts());
        jSONObject.put("release", event.getRelease());
        jSONObject.put(DIST, event.getDist());
        jSONObject.put(ENVIRONMENT, event.getEnvironment());
        writeExtras(jSONObject, event.getExtra());
        writeInterfaces(jSONObject, event.getMonitorInterfaces());
    }

    private void writeContexts(JSONObject jSONObject, Map<String, Map<String, Object>> map) throws JSONException {
        if (map.isEmpty()) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        for (Map.Entry<String, Map<String, Object>> entry : map.entrySet()) {
            jSONObject2.put(entry.getKey(), new JSONObject(entry.getValue()));
        }
        jSONObject.put(CONTEXTS, jSONObject2);
    }

    private void writeExtras(JSONObject jSONObject, Map<String, Object> map) throws JSONException {
        jSONObject.put(EXTRA, new JSONObject(map));
    }

    private void writeInterfaces(JSONObject jSONObject, Map<String, MonitorInterface> map) throws JSONException {
        for (Map.Entry<String, MonitorInterface> entry : map.entrySet()) {
            MonitorInterface value = entry.getValue();
            if (this.interfaceBindings.containsKey(value.getClass())) {
                getInterfaceBinding(value).writeInterface(jSONObject, entry.getValue());
            } else {
                MLog.e(TAG, "Couldn't parse the content of " + entry.getKey() + " provided in " + value);
            }
        }
    }

    private void writeSdk(JSONObject jSONObject, MonitorSdk monitorSdk) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("name", monitorSdk.getName());
        jSONObject2.put("version", monitorSdk.getVersion());
        if (monitorSdk.getIntegrations() != null && !monitorSdk.getIntegrations().isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            for (String str : monitorSdk.getIntegrations()) {
                jSONArray.put(str);
            }
            jSONObject2.put("integrations", jSONArray);
        }
        jSONObject.put("sdk", jSONObject2);
    }

    private void writeTags(JSONObject jSONObject, Map<String, String> map) throws JSONException {
        jSONObject.put(TAGS, new JSONObject(map));
    }

    public <T extends MonitorInterface, F extends T> void addInterfaceBinding(Class<F> cls, InterfaceBinding<T> interfaceBinding) {
        this.interfaceBindings.put(cls, interfaceBinding);
    }

    public JSONObject marshall(Event event) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        writeContent(jSONObject, event);
        return jSONObject;
    }

    public JsonMarshaller(int i2) {
        this.interfaceBindings = new HashMap();
        this.maxMessageLength = i2;
    }
}
