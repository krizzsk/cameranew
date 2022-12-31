package com.growingio.android.sdk.monitor.event.interfaces;

import com.growingio.android.sdk.monitor.jvmti.Frame;
import java.io.Serializable;
import java.util.Map;
/* loaded from: classes2.dex */
public class MonitorStackTraceElement implements Serializable {
    private final String absPath;
    private final Integer colno;
    private final String fileName;
    private final String function;
    private final int lineno;
    private final Map<String, Object> locals;
    private final String module;
    private final String platform;

    public MonitorStackTraceElement(String str, String str2, String str3, int i2, Integer num, String str4, String str5) {
        this(str, str2, str3, i2, num, str4, str5, null);
    }

    public static MonitorStackTraceElement fromStackTraceElement(StackTraceElement stackTraceElement) {
        return fromStackTraceElement(stackTraceElement, null);
    }

    public static MonitorStackTraceElement[] fromStackTraceElements(StackTraceElement[] stackTraceElementArr) {
        return fromStackTraceElements(stackTraceElementArr, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MonitorStackTraceElement monitorStackTraceElement = (MonitorStackTraceElement) obj;
        if (this.lineno != monitorStackTraceElement.lineno) {
            return false;
        }
        String str = this.module;
        if (str == null ? monitorStackTraceElement.module == null : str.equals(monitorStackTraceElement.module)) {
            String str2 = this.function;
            if (str2 == null ? monitorStackTraceElement.function == null : str2.equals(monitorStackTraceElement.function)) {
                String str3 = this.fileName;
                if (str3 == null ? monitorStackTraceElement.fileName == null : str3.equals(monitorStackTraceElement.fileName)) {
                    Integer num = this.colno;
                    if (num == null ? monitorStackTraceElement.colno == null : num.equals(monitorStackTraceElement.colno)) {
                        String str4 = this.absPath;
                        if (str4 == null ? monitorStackTraceElement.absPath == null : str4.equals(monitorStackTraceElement.absPath)) {
                            String str5 = this.platform;
                            if (str5 == null ? monitorStackTraceElement.platform == null : str5.equals(monitorStackTraceElement.platform)) {
                                Map<String, Object> map = this.locals;
                                Map<String, Object> map2 = monitorStackTraceElement.locals;
                                return map != null ? map.equals(map2) : map2 == null;
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public String getAbsPath() {
        return this.absPath;
    }

    public Integer getColno() {
        return this.colno;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getFunction() {
        return this.function;
    }

    public int getLineno() {
        return this.lineno;
    }

    public Map<String, Object> getLocals() {
        return this.locals;
    }

    public String getModule() {
        return this.module;
    }

    public String getPlatform() {
        return this.platform;
    }

    public int hashCode() {
        String str = this.module;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.function;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.fileName;
        int hashCode3 = (((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.lineno) * 31;
        Integer num = this.colno;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 31;
        String str4 = this.absPath;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.platform;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        Map<String, Object> map = this.locals;
        return hashCode6 + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        return "MonitorStackTraceElement{module='" + this.module + "', function='" + this.function + "', fileName='" + this.fileName + "', lineno=" + this.lineno + ", colno=" + this.colno + ", absPath='" + this.absPath + "', platform='" + this.platform + "', locals='" + this.locals + "'}";
    }

    public MonitorStackTraceElement(String str, String str2, String str3, int i2, Integer num, String str4, String str5, Map<String, Object> map) {
        this.module = str;
        this.function = str2;
        this.fileName = str3;
        this.lineno = i2;
        this.colno = num;
        this.absPath = str4;
        this.platform = str5;
        this.locals = map;
    }

    private static MonitorStackTraceElement fromStackTraceElement(StackTraceElement stackTraceElement, Map<String, Object> map) {
        return new MonitorStackTraceElement(stackTraceElement.getClassName(), stackTraceElement.getMethodName(), stackTraceElement.getFileName(), stackTraceElement.getLineNumber(), null, null, null, map);
    }

    public static MonitorStackTraceElement[] fromStackTraceElements(StackTraceElement[] stackTraceElementArr, Frame[] frameArr) {
        MonitorStackTraceElement[] monitorStackTraceElementArr = new MonitorStackTraceElement[stackTraceElementArr.length];
        int i2 = 0;
        int i3 = 0;
        while (i2 < stackTraceElementArr.length) {
            StackTraceElement stackTraceElement = stackTraceElementArr[i2];
            Map<String, Object> map = null;
            if (frameArr != null) {
                while (i3 < frameArr.length && !frameArr[i3].getMethod().getName().equals(stackTraceElement.getMethodName())) {
                    i3++;
                }
                if (i3 < frameArr.length) {
                    map = frameArr[i3].getLocals();
                }
            }
            monitorStackTraceElementArr[i2] = fromStackTraceElement(stackTraceElement, map);
            i2++;
            i3++;
        }
        return monitorStackTraceElementArr;
    }
}
