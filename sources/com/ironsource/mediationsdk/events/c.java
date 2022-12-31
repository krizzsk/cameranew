package com.ironsource.mediationsdk.events;

import com.ironsource.mediationsdk.logger.IronSourceLogger;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EventsFormatterFactory.java */
/* loaded from: classes2.dex */
public class c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static a a(String str, int i2) {
        if ("ironbeast".equals(str)) {
            return new d(i2);
        }
        if ("outcome".equals(str)) {
            return new e(i2);
        }
        if (i2 == 2) {
            return new d(i2);
        }
        if (i2 == 3) {
            return new e(i2);
        }
        com.ironsource.mediationsdk.logger.c i3 = com.ironsource.mediationsdk.logger.c.i();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
        i3.d(ironSourceTag, "EventsFormatterFactory failed to instantiate a formatter (type: " + str + ", adUnit: " + i2 + ")", 2);
        return null;
    }
}
