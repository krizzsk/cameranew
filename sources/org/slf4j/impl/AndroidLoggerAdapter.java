package org.slf4j.impl;

import android.util.Log;
import org.slf4j.helpers.MarkerIgnoringBase;
/* loaded from: classes3.dex */
class AndroidLoggerAdapter extends MarkerIgnoringBase {
    private static final long serialVersionUID = -1227274521521287937L;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AndroidLoggerAdapter(String str) {
        this.name = str;
    }

    private void formatAndLog(int i2, String str, Object... objArr) {
        if (isLoggable(i2)) {
            org.slf4j.helpers.a a = org.slf4j.helpers.b.a(str, objArr);
            logInternal(i2, a.a(), a.b());
        }
    }

    private boolean isLoggable(int i2) {
        return Log.isLoggable(this.name, i2);
    }

    private void log(int i2, String str, Throwable th) {
        if (isLoggable(i2)) {
            logInternal(i2, str, th);
        }
    }

    private void logInternal(int i2, String str, Throwable th) {
        if (th != null) {
            str = str + '\n' + Log.getStackTraceString(th);
        }
        Log.println(i2, this.name, str);
    }

    @Override // org.slf4j.helpers.MarkerIgnoringBase, org.slf4j.helpers.NamedLoggerBase, org.slf4j.b
    public void debug(String str) {
        log(3, str, null);
    }

    @Override // org.slf4j.helpers.MarkerIgnoringBase, org.slf4j.helpers.NamedLoggerBase, org.slf4j.b
    public void error(String str) {
        log(6, str, null);
    }

    @Override // org.slf4j.helpers.MarkerIgnoringBase, org.slf4j.helpers.NamedLoggerBase, org.slf4j.b
    public void info(String str) {
        log(4, str, null);
    }

    @Override // org.slf4j.helpers.MarkerIgnoringBase, org.slf4j.helpers.NamedLoggerBase
    public boolean isDebugEnabled() {
        return isLoggable(3);
    }

    @Override // org.slf4j.helpers.MarkerIgnoringBase, org.slf4j.helpers.NamedLoggerBase
    public boolean isErrorEnabled() {
        return isLoggable(6);
    }

    @Override // org.slf4j.helpers.MarkerIgnoringBase, org.slf4j.helpers.NamedLoggerBase
    public boolean isInfoEnabled() {
        return isLoggable(4);
    }

    @Override // org.slf4j.helpers.MarkerIgnoringBase, org.slf4j.helpers.NamedLoggerBase
    public boolean isTraceEnabled() {
        return isLoggable(2);
    }

    @Override // org.slf4j.helpers.MarkerIgnoringBase, org.slf4j.helpers.NamedLoggerBase
    public boolean isWarnEnabled() {
        return isLoggable(5);
    }

    @Override // org.slf4j.helpers.MarkerIgnoringBase, org.slf4j.helpers.NamedLoggerBase
    public void trace(String str) {
        log(2, str, null);
    }

    @Override // org.slf4j.helpers.MarkerIgnoringBase, org.slf4j.helpers.NamedLoggerBase, org.slf4j.b
    public void warn(String str) {
        log(5, str, null);
    }

    @Override // org.slf4j.helpers.MarkerIgnoringBase, org.slf4j.helpers.NamedLoggerBase
    public void debug(String str, Object obj) {
        formatAndLog(3, str, obj);
    }

    @Override // org.slf4j.helpers.MarkerIgnoringBase, org.slf4j.helpers.NamedLoggerBase
    public void error(String str, Object obj) {
        formatAndLog(6, str, obj);
    }

    @Override // org.slf4j.helpers.MarkerIgnoringBase, org.slf4j.helpers.NamedLoggerBase
    public void info(String str, Object obj) {
        formatAndLog(4, str, obj);
    }

    @Override // org.slf4j.helpers.MarkerIgnoringBase, org.slf4j.helpers.NamedLoggerBase
    public void trace(String str, Object obj) {
        formatAndLog(2, str, obj);
    }

    @Override // org.slf4j.helpers.MarkerIgnoringBase, org.slf4j.helpers.NamedLoggerBase, org.slf4j.b
    public void warn(String str, Object obj) {
        formatAndLog(5, str, obj);
    }

    @Override // org.slf4j.helpers.MarkerIgnoringBase, org.slf4j.helpers.NamedLoggerBase
    public void debug(String str, Object obj, Object obj2) {
        formatAndLog(3, str, obj, obj2);
    }

    @Override // org.slf4j.helpers.MarkerIgnoringBase, org.slf4j.helpers.NamedLoggerBase
    public void error(String str, Object obj, Object obj2) {
        formatAndLog(6, str, obj, obj2);
    }

    @Override // org.slf4j.helpers.MarkerIgnoringBase, org.slf4j.helpers.NamedLoggerBase
    public void info(String str, Object obj, Object obj2) {
        formatAndLog(4, str, obj, obj2);
    }

    @Override // org.slf4j.helpers.MarkerIgnoringBase, org.slf4j.helpers.NamedLoggerBase
    public void trace(String str, Object obj, Object obj2) {
        formatAndLog(2, str, obj, obj2);
    }

    @Override // org.slf4j.helpers.MarkerIgnoringBase, org.slf4j.helpers.NamedLoggerBase, org.slf4j.b
    public void warn(String str, Object obj, Object obj2) {
        formatAndLog(5, str, obj, obj2);
    }

    @Override // org.slf4j.helpers.MarkerIgnoringBase, org.slf4j.helpers.NamedLoggerBase
    public void debug(String str, Object... objArr) {
        formatAndLog(3, str, objArr);
    }

    @Override // org.slf4j.helpers.MarkerIgnoringBase, org.slf4j.helpers.NamedLoggerBase
    public void error(String str, Object... objArr) {
        formatAndLog(6, str, objArr);
    }

    @Override // org.slf4j.helpers.MarkerIgnoringBase, org.slf4j.helpers.NamedLoggerBase
    public void info(String str, Object... objArr) {
        formatAndLog(4, str, objArr);
    }

    @Override // org.slf4j.helpers.MarkerIgnoringBase, org.slf4j.helpers.NamedLoggerBase
    public void trace(String str, Object... objArr) {
        formatAndLog(2, str, objArr);
    }

    @Override // org.slf4j.helpers.MarkerIgnoringBase, org.slf4j.helpers.NamedLoggerBase
    public void warn(String str, Object... objArr) {
        formatAndLog(5, str, objArr);
    }

    @Override // org.slf4j.helpers.MarkerIgnoringBase, org.slf4j.helpers.NamedLoggerBase
    public void debug(String str, Throwable th) {
        log(2, str, th);
    }

    @Override // org.slf4j.helpers.MarkerIgnoringBase, org.slf4j.helpers.NamedLoggerBase, org.slf4j.b
    public void error(String str, Throwable th) {
        log(6, str, th);
    }

    @Override // org.slf4j.helpers.MarkerIgnoringBase, org.slf4j.helpers.NamedLoggerBase
    public void info(String str, Throwable th) {
        log(4, str, th);
    }

    @Override // org.slf4j.helpers.MarkerIgnoringBase, org.slf4j.helpers.NamedLoggerBase
    public void trace(String str, Throwable th) {
        log(2, str, th);
    }

    @Override // org.slf4j.helpers.MarkerIgnoringBase, org.slf4j.helpers.NamedLoggerBase
    public void warn(String str, Throwable th) {
        log(5, str, th);
    }
}
