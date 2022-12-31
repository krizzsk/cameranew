package com.unity3d.splash.services.core.log;
/* loaded from: classes3.dex */
class a {
    private b a;
    private String b;
    private StackTraceElement c;

    public a(b bVar, String str, StackTraceElement stackTraceElement) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.a = bVar;
        this.b = str;
        this.c = stackTraceElement;
    }

    public b a() {
        return this.a;
    }

    public String b() {
        String str;
        String str2;
        int i2;
        String str3 = this.b;
        StackTraceElement stackTraceElement = this.c;
        if (stackTraceElement != null) {
            str = stackTraceElement.getClassName();
            str2 = this.c.getMethodName();
            i2 = this.c.getLineNumber();
        } else {
            str = "UnknownClass";
            str2 = "unknownMethod";
            i2 = -1;
        }
        if (str3 != null && !str3.isEmpty()) {
            str3 = " :: " + str3;
        }
        if (str3 == null) {
            str3 = "";
        }
        return str + "." + str2 + "()" + (" (line:" + i2 + ")") + str3;
    }
}
