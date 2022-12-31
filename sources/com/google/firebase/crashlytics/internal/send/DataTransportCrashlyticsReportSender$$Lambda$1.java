package com.google.firebase.crashlytics.internal.send;

import com.google.android.datatransport.g;
import com.google.android.gms.tasks.h;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;
/* loaded from: classes2.dex */
final /* synthetic */ class DataTransportCrashlyticsReportSender$$Lambda$1 implements g {
    private final h arg$1;
    private final CrashlyticsReportWithSessionId arg$2;

    private DataTransportCrashlyticsReportSender$$Lambda$1(h hVar, CrashlyticsReportWithSessionId crashlyticsReportWithSessionId) {
        this.arg$1 = hVar;
        this.arg$2 = crashlyticsReportWithSessionId;
    }

    public static g lambdaFactory$(h hVar, CrashlyticsReportWithSessionId crashlyticsReportWithSessionId) {
        return new DataTransportCrashlyticsReportSender$$Lambda$1(hVar, crashlyticsReportWithSessionId);
    }

    @Override // com.google.android.datatransport.g
    public void onSchedule(Exception exc) {
        DataTransportCrashlyticsReportSender.lambda$sendReport$1(this.arg$1, this.arg$2, exc);
    }
}
