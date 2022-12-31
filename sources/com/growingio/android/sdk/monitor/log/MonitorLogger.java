package com.growingio.android.sdk.monitor.log;

import com.growingio.android.sdk.monitor.Monitor;
import com.growingio.android.sdk.monitor.context.Context;
import com.growingio.android.sdk.monitor.event.Breadcrumb;
import com.growingio.android.sdk.monitor.event.BreadcrumbBuilder;
/* loaded from: classes2.dex */
public class MonitorLogger {
    public static void d(String str, String str2, Object... objArr) {
        if (!Monitor.isContainsClient(str) || objArr == null || objArr.length == 0) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer(objArr[0].toString());
        for (int i2 = 1; i2 < objArr.length; i2++) {
            stringBuffer.append(", " + objArr[i2]);
        }
        Context context = Monitor.getContext(str);
        BreadcrumbBuilder breadcrumbBuilder = new BreadcrumbBuilder();
        context.recordBreadcrumb(breadcrumbBuilder.setMessage(str2 + ": " + stringBuffer.toString()).setLevel(Breadcrumb.Level.DEBUG).build());
    }

    public static void e(String str, String str2, String str3) {
        if (Monitor.isContainsClient(str)) {
            Context context = Monitor.getContext(str);
            BreadcrumbBuilder breadcrumbBuilder = new BreadcrumbBuilder();
            context.recordBreadcrumb(breadcrumbBuilder.setMessage(str2 + ": " + str3).setLevel(Breadcrumb.Level.ERROR).build());
        }
    }

    public static void i(String str, String str2, String str3) {
        if (Monitor.isContainsClient(str)) {
            Context context = Monitor.getContext(str);
            BreadcrumbBuilder breadcrumbBuilder = new BreadcrumbBuilder();
            context.recordBreadcrumb(breadcrumbBuilder.setMessage(str2 + ": " + str3).setLevel(Breadcrumb.Level.INFO).build());
        }
    }

    public static void v(String str, String str2, String str3) {
        if (Monitor.isContainsClient(str)) {
            Context context = Monitor.getContext(str);
            BreadcrumbBuilder breadcrumbBuilder = new BreadcrumbBuilder();
            context.recordBreadcrumb(breadcrumbBuilder.setMessage(str2 + ": " + str3).setLevel(Breadcrumb.Level.INFO).build());
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (Monitor.isContainsClient(str)) {
            Context context = Monitor.getContext(str);
            BreadcrumbBuilder breadcrumbBuilder = new BreadcrumbBuilder();
            context.recordBreadcrumb(breadcrumbBuilder.setMessage(str2 + ": " + th).setLevel(Breadcrumb.Level.ERROR).build());
        }
    }

    public static void d(String str, String str2, String str3, Throwable th) {
        if (Monitor.isContainsClient(str)) {
            Context context = Monitor.getContext(str);
            BreadcrumbBuilder breadcrumbBuilder = new BreadcrumbBuilder();
            context.recordBreadcrumb(breadcrumbBuilder.setMessage(str2 + ": " + str3 + ", " + th).setLevel(Breadcrumb.Level.DEBUG).build());
        }
    }

    public static void e(String str, String str2, String str3, Throwable th) {
        if (Monitor.isContainsClient(str)) {
            Context context = Monitor.getContext(str);
            BreadcrumbBuilder breadcrumbBuilder = new BreadcrumbBuilder();
            context.recordBreadcrumb(breadcrumbBuilder.setMessage(str2 + ": " + str3 + ", " + th).setLevel(Breadcrumb.Level.ERROR).build());
        }
    }

    public static void d(String str, Throwable th) {
        if (Monitor.isContainsClient(str)) {
            Monitor.getContext(str).recordBreadcrumb(new BreadcrumbBuilder().setMessage(th.toString()).setLevel(Breadcrumb.Level.DEBUG).build());
        }
    }
}
