package com.tapjoy.internal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes3.dex */
public final class w {
    private static final ThreadLocal a = new ThreadLocal() { // from class: com.tapjoy.internal.w.1
        @Override // java.lang.ThreadLocal
        protected final /* synthetic */ Object initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ");
        }
    };
    private static final ThreadLocal b = new ThreadLocal() { // from class: com.tapjoy.internal.w.2
        @Override // java.lang.ThreadLocal
        protected final /* synthetic */ Object initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
        }
    };

    public static String a(Date date) {
        return ((DateFormat) a.get()).format(date);
    }
}
