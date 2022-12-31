package com.google.firebase.crashlytics.internal.send;

import com.google.android.datatransport.d;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.nio.charset.Charset;
/* loaded from: classes2.dex */
final /* synthetic */ class DataTransportCrashlyticsReportSender$$Lambda$2 implements d {
    private static final DataTransportCrashlyticsReportSender$$Lambda$2 instance = new DataTransportCrashlyticsReportSender$$Lambda$2();

    private DataTransportCrashlyticsReportSender$$Lambda$2() {
    }

    public static d lambdaFactory$() {
        return instance;
    }

    @Override // com.google.android.datatransport.d
    public Object apply(Object obj) {
        byte[] bytes;
        bytes = DataTransportCrashlyticsReportSender.TRANSFORM.reportToJson((CrashlyticsReport) obj).getBytes(Charset.forName("UTF-8"));
        return bytes;
    }
}
