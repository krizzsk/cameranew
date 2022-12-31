package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Base64;
import androidx.annotation.RequiresApi;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.datatransport.runtime.m;
import com.google.firebase.messaging.Constants;
@RequiresApi(api = 21)
/* loaded from: classes2.dex */
public class JobInfoSchedulerService extends JobService {
    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("backendName");
        String string2 = jobParameters.getExtras().getString("extras");
        int i2 = jobParameters.getExtras().getInt(Constants.FirelogAnalytics.PARAM_PRIORITY);
        int i3 = jobParameters.getExtras().getInt("attemptNumber");
        TransportRuntime.e(getApplicationContext());
        m.a a = com.google.android.datatransport.runtime.m.a();
        a.b(string);
        a.d(com.google.android.datatransport.runtime.y.a.b(i2));
        if (string2 != null) {
            a.c(Base64.decode(string2, 0));
        }
        TransportRuntime.getInstance().d().g(a.a(), i3, f.a(this, jobParameters));
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
