package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import android.util.Base64;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.messaging.Constants;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.zip.Adler32;
/* compiled from: JobInfoScheduler.java */
@RequiresApi(api = 21)
/* loaded from: classes2.dex */
public class e implements r {
    private final Context a;
    private final com.google.android.datatransport.runtime.w.j.c b;
    private final SchedulerConfig c;

    public e(Context context, com.google.android.datatransport.runtime.w.j.c cVar, SchedulerConfig schedulerConfig) {
        this.a = context;
        this.b = cVar;
        this.c = schedulerConfig;
    }

    private boolean d(JobScheduler jobScheduler, int i2, int i3) {
        for (JobInfo jobInfo : jobScheduler.getAllPendingJobs()) {
            int i4 = jobInfo.getExtras().getInt("attemptNumber");
            if (jobInfo.getId() == i2) {
                return i4 >= i3;
            }
        }
        return false;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.r
    public void a(com.google.android.datatransport.runtime.m mVar, int i2) {
        b(mVar, i2, false);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.r
    public void b(com.google.android.datatransport.runtime.m mVar, int i2, boolean z) {
        ComponentName componentName = new ComponentName(this.a, JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) this.a.getSystemService("jobscheduler");
        int c = c(mVar);
        if (!z && d(jobScheduler, c, i2)) {
            com.google.android.datatransport.runtime.u.a.a("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", mVar);
            return;
        }
        long I = this.b.I(mVar);
        SchedulerConfig schedulerConfig = this.c;
        JobInfo.Builder builder = new JobInfo.Builder(c, componentName);
        schedulerConfig.c(builder, mVar.d(), I, i2);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putInt("attemptNumber", i2);
        persistableBundle.putString("backendName", mVar.b());
        persistableBundle.putInt(Constants.FirelogAnalytics.PARAM_PRIORITY, com.google.android.datatransport.runtime.y.a.a(mVar.d()));
        if (mVar.c() != null) {
            persistableBundle.putString("extras", Base64.encodeToString(mVar.c(), 0));
        }
        builder.setExtras(persistableBundle);
        com.google.android.datatransport.runtime.u.a.b("JobInfoScheduler", "Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", mVar, Integer.valueOf(c), Long.valueOf(this.c.g(mVar.d(), I, i2)), Long.valueOf(I), Integer.valueOf(i2));
        jobScheduler.schedule(builder.build());
    }

    @VisibleForTesting
    int c(com.google.android.datatransport.runtime.m mVar) {
        Adler32 adler32 = new Adler32();
        adler32.update(this.a.getPackageName().getBytes(Charset.forName("UTF-8")));
        adler32.update(mVar.b().getBytes(Charset.forName("UTF-8")));
        adler32.update(ByteBuffer.allocate(4).putInt(com.google.android.datatransport.runtime.y.a.a(mVar.d())).array());
        if (mVar.c() != null) {
            adler32.update(mVar.c());
        }
        return (int) adler32.getValue();
    }
}
