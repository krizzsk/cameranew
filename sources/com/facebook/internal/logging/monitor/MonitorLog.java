package com.facebook.internal.logging.monitor;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.facebook.internal.logging.ExternalLog;
import com.facebook.internal.logging.LogCategory;
import com.facebook.internal.logging.LogEvent;
import com.tapjoy.TJAdUnitConstants;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class MonitorLog implements ExternalLog {
    private static final int INVALID_TIME = -1;
    private static final long serialVersionUID = 1;
    private static Set<String> validPerformanceEventNames = new HashSet();
    private int hashCode;
    private LogEvent logEvent;
    private int timeSpent;
    private long timeStart;

    /* loaded from: classes.dex */
    public static class a {
        private LogEvent a;
        private long b;
        private int c;
    }

    static {
        for (PerformanceEventName performanceEventName : PerformanceEventName.values()) {
            validPerformanceEventNames.add(performanceEventName.toString());
        }
    }

    public MonitorLog(a aVar) {
        this.logEvent = aVar.a;
        this.timeStart = aVar.b;
        this.timeSpent = aVar.c;
    }

    @Override // com.facebook.internal.logging.ExternalLog
    public JSONObject convertToJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(TJAdUnitConstants.PARAM_PLACEMENT_NAME, this.logEvent.getEventName());
            jSONObject.put("category", this.logEvent.getLogCategory());
            long j2 = this.timeStart;
            if (j2 != 0) {
                jSONObject.put("time_start", j2);
            }
            int i2 = this.timeSpent;
            if (i2 != 0) {
                jSONObject.put("time_spent", i2);
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MonitorLog monitorLog = (MonitorLog) obj;
        return this.logEvent.getEventName().equals(monitorLog.logEvent.getEventName()) && this.logEvent.getLogCategory().equals(monitorLog.logEvent.getLogCategory()) && this.timeStart == monitorLog.timeStart && this.timeSpent == monitorLog.timeSpent;
    }

    @Override // com.facebook.internal.logging.ExternalLog
    public String getEventName() {
        return this.logEvent.getEventName();
    }

    @Override // com.facebook.internal.logging.ExternalLog
    public LogCategory getLogCategory() {
        return this.logEvent.getLogCategory();
    }

    public int getTimeSpent() {
        return this.timeSpent;
    }

    public long getTimeStart() {
        return this.timeStart;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            long j2 = this.timeStart;
            int i2 = this.timeSpent;
            this.hashCode = ((((527 + this.logEvent.hashCode()) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + (i2 ^ (i2 >>> 32));
        }
        return this.hashCode;
    }

    public boolean isValid() {
        return this.timeStart >= 0 && this.timeSpent >= 0;
    }

    public String toString() {
        return String.format(TJAdUnitConstants.PARAM_PLACEMENT_NAME + ": %s, category: %s, time_start: %s, time_spent: %s", this.logEvent.getEventName(), this.logEvent.getLogCategory(), Long.valueOf(this.timeStart), Integer.valueOf(this.timeSpent));
    }
}
