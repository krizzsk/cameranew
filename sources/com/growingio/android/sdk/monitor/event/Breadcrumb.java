package com.growingio.android.sdk.monitor.event;

import androidx.core.app.NotificationCompat;
import com.tapjoy.TJAdUnitConstants;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import us.pinguo.admobvista.StaticsAdv.IADStatisticBase;
/* loaded from: classes2.dex */
public class Breadcrumb implements Serializable {
    private final String category;
    private final Map<String, String> data;
    private final Level level;
    private final String message;
    private final Date timestamp;
    private final Type type;

    /* loaded from: classes2.dex */
    public enum Level {
        DEBUG("debug"),
        INFO(TJAdUnitConstants.String.VIDEO_INFO),
        WARNING("warning"),
        ERROR("error"),
        CRITICAL("critical");
        
        private final String value;

        Level(String str) {
            this.value = str;
        }

        public String getValue() {
            return this.value;
        }
    }

    /* loaded from: classes2.dex */
    public enum Type {
        DEFAULT(IADStatisticBase.VARCHAR_DEFALUT_VALUE),
        HTTP("http"),
        NAVIGATION(NotificationCompat.CATEGORY_NAVIGATION),
        USER("user");
        
        private final String value;

        Type(String str) {
            this.value = str;
        }

        public String getValue() {
            return this.value;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Breadcrumb(Type type, Date date, Level level, String str, String str2, Map<String, String> map) {
        date = date == null ? new Date() : date;
        if (str == null && (map == null || map.size() < 1)) {
            throw new IllegalArgumentException("one of 'message' or 'data' must be set");
        }
        this.type = type;
        this.timestamp = date;
        this.level = level;
        this.message = str;
        this.category = str2;
        this.data = map;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Breadcrumb breadcrumb = (Breadcrumb) obj;
        if (this.type != breadcrumb.type) {
            return false;
        }
        Date date = this.timestamp;
        if (date == null ? breadcrumb.timestamp == null : date.equals(breadcrumb.timestamp)) {
            if (this.level != breadcrumb.level) {
                return false;
            }
            String str = this.message;
            if (str == null ? breadcrumb.message == null : str.equals(breadcrumb.message)) {
                String str2 = this.category;
                if (str2 == null ? breadcrumb.category == null : str2.equals(breadcrumb.category)) {
                    Map<String, String> map = this.data;
                    Map<String, String> map2 = breadcrumb.data;
                    return map != null ? map.equals(map2) : map2 == null;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public String getCategory() {
        return this.category;
    }

    public Map<String, String> getData() {
        return this.data;
    }

    public Level getLevel() {
        return this.level;
    }

    public String getMessage() {
        return this.message;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public Type getType() {
        return this.type;
    }

    public int hashCode() {
        Type type = this.type;
        int hashCode = (type != null ? type.hashCode() : 0) * 31;
        Date date = this.timestamp;
        int hashCode2 = (hashCode + (date != null ? date.hashCode() : 0)) * 31;
        Level level = this.level;
        int hashCode3 = (hashCode2 + (level != null ? level.hashCode() : 0)) * 31;
        String str = this.message;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.category;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Map<String, String> map = this.data;
        return hashCode5 + (map != null ? map.hashCode() : 0);
    }
}
