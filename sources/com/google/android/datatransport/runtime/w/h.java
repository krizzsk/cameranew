package com.google.android.datatransport.runtime.w;

import android.content.Context;
import android.os.Build;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.r;
/* compiled from: SchedulingModule.java */
/* loaded from: classes2.dex */
public abstract class h {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static r a(Context context, com.google.android.datatransport.runtime.w.j.c cVar, SchedulerConfig schedulerConfig, com.google.android.datatransport.runtime.x.a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new com.google.android.datatransport.runtime.scheduling.jobscheduling.e(context, cVar, schedulerConfig);
        }
        return new com.google.android.datatransport.runtime.scheduling.jobscheduling.a(context, cVar, aVar, schedulerConfig);
    }
}
