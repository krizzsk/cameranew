package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;
/* compiled from: JobInfoSchedulerService.java */
/* loaded from: classes2.dex */
final /* synthetic */ class f implements Runnable {
    private final JobInfoSchedulerService a;
    private final JobParameters b;

    private f(JobInfoSchedulerService jobInfoSchedulerService, JobParameters jobParameters) {
        this.a = jobInfoSchedulerService;
        this.b = jobParameters;
    }

    public static Runnable a(JobInfoSchedulerService jobInfoSchedulerService, JobParameters jobParameters) {
        return new f(jobInfoSchedulerService, jobParameters);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.jobFinished(this.b, false);
    }
}
