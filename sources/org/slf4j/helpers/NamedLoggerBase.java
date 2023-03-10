package org.slf4j.helpers;

import java.io.ObjectStreamException;
import java.io.Serializable;
import org.slf4j.Marker;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public abstract class NamedLoggerBase implements org.slf4j.b, Serializable {
    private static final long serialVersionUID = 7535258609338176893L;
    protected String name;

    @Override // org.slf4j.b
    public abstract /* synthetic */ void debug(String str);

    public abstract /* synthetic */ void debug(String str, Object obj);

    public abstract /* synthetic */ void debug(String str, Object obj, Object obj2);

    public abstract /* synthetic */ void debug(String str, Throwable th);

    public abstract /* synthetic */ void debug(String str, Object... objArr);

    public abstract /* synthetic */ void debug(Marker marker, String str);

    public abstract /* synthetic */ void debug(Marker marker, String str, Object obj);

    public abstract /* synthetic */ void debug(Marker marker, String str, Object obj, Object obj2);

    public abstract /* synthetic */ void debug(Marker marker, String str, Throwable th);

    public abstract /* synthetic */ void debug(Marker marker, String str, Object... objArr);

    @Override // org.slf4j.b
    public abstract /* synthetic */ void error(String str);

    public abstract /* synthetic */ void error(String str, Object obj);

    public abstract /* synthetic */ void error(String str, Object obj, Object obj2);

    @Override // org.slf4j.b
    public abstract /* synthetic */ void error(String str, Throwable th);

    public abstract /* synthetic */ void error(String str, Object... objArr);

    public abstract /* synthetic */ void error(Marker marker, String str);

    public abstract /* synthetic */ void error(Marker marker, String str, Object obj);

    public abstract /* synthetic */ void error(Marker marker, String str, Object obj, Object obj2);

    public abstract /* synthetic */ void error(Marker marker, String str, Throwable th);

    public abstract /* synthetic */ void error(Marker marker, String str, Object... objArr);

    public String getName() {
        return this.name;
    }

    @Override // org.slf4j.b
    public abstract /* synthetic */ void info(String str);

    public abstract /* synthetic */ void info(String str, Object obj);

    public abstract /* synthetic */ void info(String str, Object obj, Object obj2);

    public abstract /* synthetic */ void info(String str, Throwable th);

    public abstract /* synthetic */ void info(String str, Object... objArr);

    public abstract /* synthetic */ void info(Marker marker, String str);

    public abstract /* synthetic */ void info(Marker marker, String str, Object obj);

    public abstract /* synthetic */ void info(Marker marker, String str, Object obj, Object obj2);

    public abstract /* synthetic */ void info(Marker marker, String str, Throwable th);

    public abstract /* synthetic */ void info(Marker marker, String str, Object... objArr);

    public abstract /* synthetic */ boolean isDebugEnabled();

    public abstract /* synthetic */ boolean isDebugEnabled(Marker marker);

    public abstract /* synthetic */ boolean isErrorEnabled();

    public abstract /* synthetic */ boolean isErrorEnabled(Marker marker);

    public abstract /* synthetic */ boolean isInfoEnabled();

    public abstract /* synthetic */ boolean isInfoEnabled(Marker marker);

    public abstract /* synthetic */ boolean isTraceEnabled();

    public abstract /* synthetic */ boolean isTraceEnabled(Marker marker);

    public abstract /* synthetic */ boolean isWarnEnabled();

    public abstract /* synthetic */ boolean isWarnEnabled(Marker marker);

    protected Object readResolve() throws ObjectStreamException {
        return org.slf4j.c.i(getName());
    }

    public abstract /* synthetic */ void trace(String str);

    public abstract /* synthetic */ void trace(String str, Object obj);

    public abstract /* synthetic */ void trace(String str, Object obj, Object obj2);

    public abstract /* synthetic */ void trace(String str, Throwable th);

    public abstract /* synthetic */ void trace(String str, Object... objArr);

    public abstract /* synthetic */ void trace(Marker marker, String str);

    public abstract /* synthetic */ void trace(Marker marker, String str, Object obj);

    public abstract /* synthetic */ void trace(Marker marker, String str, Object obj, Object obj2);

    public abstract /* synthetic */ void trace(Marker marker, String str, Throwable th);

    public abstract /* synthetic */ void trace(Marker marker, String str, Object... objArr);

    @Override // org.slf4j.b
    public abstract /* synthetic */ void warn(String str);

    @Override // org.slf4j.b
    public abstract /* synthetic */ void warn(String str, Object obj);

    @Override // org.slf4j.b
    public abstract /* synthetic */ void warn(String str, Object obj, Object obj2);

    public abstract /* synthetic */ void warn(String str, Throwable th);

    public abstract /* synthetic */ void warn(String str, Object... objArr);

    public abstract /* synthetic */ void warn(Marker marker, String str);

    public abstract /* synthetic */ void warn(Marker marker, String str, Object obj);

    public abstract /* synthetic */ void warn(Marker marker, String str, Object obj, Object obj2);

    public abstract /* synthetic */ void warn(Marker marker, String str, Throwable th);

    public abstract /* synthetic */ void warn(Marker marker, String str, Object... objArr);
}
