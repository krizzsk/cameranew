package com.google.android.datatransport.runtime.w.j;

import javax.inject.Named;
/* compiled from: EventStoreModule.java */
/* loaded from: classes2.dex */
public abstract class e {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Named("SQLITE_DB_NAME")
    public static String a() {
        return "com.google.android.datatransport.events";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Named("SCHEMA_VERSION")
    public static int b() {
        return h0.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d c() {
        return d.a;
    }
}
