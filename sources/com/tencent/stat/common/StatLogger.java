package com.tencent.stat.common;

import android.util.Log;
import us.pinguo.admobvista.StaticsAdv.IADStatisticBase;
/* loaded from: classes3.dex */
public final class StatLogger {
    private String a;
    private boolean b;
    private int c;

    public StatLogger() {
        this.a = IADStatisticBase.VARCHAR_DEFALUT_VALUE;
        this.b = true;
        this.c = 2;
    }

    public StatLogger(String str) {
        this.a = IADStatisticBase.VARCHAR_DEFALUT_VALUE;
        this.b = true;
        this.c = 2;
        this.a = str;
    }

    private String a() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null) {
            return null;
        }
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (!stackTraceElement.isNativeMethod() && !stackTraceElement.getClassName().equals(Thread.class.getName()) && !stackTraceElement.getClassName().equals(StatLogger.class.getName())) {
                return "[" + Thread.currentThread().getName() + "(" + Thread.currentThread().getId() + "): " + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + "]";
            }
        }
        return null;
    }

    public void d(Object obj) {
        if (isDebugEnable()) {
            debug(obj);
        }
    }

    public void debug(Object obj) {
        String str;
        if (this.c <= 3) {
            String a = a();
            if (a == null) {
                str = obj.toString();
            } else {
                str = a + " - " + obj;
            }
            Log.d(this.a, str);
        }
    }

    public void e(Exception exc) {
        if (isDebugEnable()) {
            error(exc);
        }
    }

    public void e(Object obj) {
        if (isDebugEnable()) {
            error(obj);
        }
    }

    public void error(Exception exc) {
        if (this.c <= 6) {
            StringBuffer stringBuffer = new StringBuffer();
            String a = a();
            StackTraceElement[] stackTrace = exc.getStackTrace();
            stringBuffer.append(a != null ? a + " - " + exc + "\r\n" : exc + "\r\n");
            if (stackTrace != null && stackTrace.length > 0) {
                for (StackTraceElement stackTraceElement : stackTrace) {
                    if (stackTraceElement != null) {
                        stringBuffer.append("[ " + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + " ]\r\n");
                    }
                }
            }
            Log.e(this.a, stringBuffer.toString());
        }
    }

    public void error(Object obj) {
        String str;
        if (this.c <= 6) {
            String a = a();
            if (a == null) {
                str = obj.toString();
            } else {
                str = a + " - " + obj;
            }
            Log.e(this.a, str);
        }
    }

    public int getLogLevel() {
        return this.c;
    }

    public void i(Object obj) {
        if (isDebugEnable()) {
            info(obj);
        }
    }

    public void info(Object obj) {
        String str;
        if (this.c <= 4) {
            String a = a();
            if (a == null) {
                str = obj.toString();
            } else {
                str = a + " - " + obj;
            }
            Log.i(this.a, str);
        }
    }

    public boolean isDebugEnable() {
        return this.b;
    }

    public void setDebugEnable(boolean z) {
        this.b = z;
    }

    public void setLogLevel(int i2) {
        this.c = i2;
    }

    public void setTag(String str) {
        this.a = str;
    }

    public void v(Object obj) {
        if (isDebugEnable()) {
            verbose(obj);
        }
    }

    public void verbose(Object obj) {
        String str;
        if (this.c <= 2) {
            String a = a();
            if (a == null) {
                str = obj.toString();
            } else {
                str = a + " - " + obj;
            }
            Log.v(this.a, str);
        }
    }

    public void w(Object obj) {
        if (isDebugEnable()) {
            warn(obj);
        }
    }

    public void warn(Object obj) {
        String str;
        if (this.c <= 5) {
            String a = a();
            if (a == null) {
                str = obj.toString();
            } else {
                str = a + " - " + obj;
            }
            Log.w(this.a, str);
        }
    }
}
