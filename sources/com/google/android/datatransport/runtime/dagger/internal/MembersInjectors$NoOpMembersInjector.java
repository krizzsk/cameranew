package com.google.android.datatransport.runtime.dagger.internal;
/* loaded from: classes2.dex */
enum MembersInjectors$NoOpMembersInjector {
    INSTANCE;

    public void injectMembers(Object obj) {
        d.c(obj, "Cannot inject members into a null reference");
    }
}
