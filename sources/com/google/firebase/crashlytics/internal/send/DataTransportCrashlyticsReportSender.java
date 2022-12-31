package com.google.firebase.crashlytics.internal.send;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.datatransport.b;
import com.google.android.datatransport.c;
import com.google.android.datatransport.cct.a;
import com.google.android.datatransport.d;
import com.google.android.datatransport.e;
import com.google.android.datatransport.f;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.gms.tasks.g;
import com.google.android.gms.tasks.h;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;
/* loaded from: classes2.dex */
public class DataTransportCrashlyticsReportSender {
    private static final String CRASHLYTICS_TRANSPORT_NAME = "FIREBASE_CRASHLYTICS_REPORT";
    private final e<CrashlyticsReport> transport;
    private final d<CrashlyticsReport, byte[]> transportTransform;
    private static final CrashlyticsReportJsonTransform TRANSFORM = new CrashlyticsReportJsonTransform();
    private static final String CRASHLYTICS_ENDPOINT = mergeStrings("hts/cahyiseot-agolai.o/1frlglgc/aclg", "tp:/rsltcrprsp.ogepscmv/ieo/eaybtho");
    private static final String CRASHLYTICS_API_KEY = mergeStrings("AzSBpY4F0rHiHFdinTvM", "IayrSTFL9eJ69YeSUO2");
    private static final d<CrashlyticsReport, byte[]> DEFAULT_TRANSFORM = DataTransportCrashlyticsReportSender$$Lambda$2.lambdaFactory$();

    DataTransportCrashlyticsReportSender(e<CrashlyticsReport> eVar, d<CrashlyticsReport, byte[]> dVar) {
        this.transport = eVar;
        this.transportTransform = dVar;
    }

    public static DataTransportCrashlyticsReportSender create(Context context) {
        TransportRuntime.e(context);
        f f2 = TransportRuntime.getInstance().f(new a(CRASHLYTICS_ENDPOINT, CRASHLYTICS_API_KEY));
        b b = b.b("json");
        d<CrashlyticsReport, byte[]> dVar = DEFAULT_TRANSFORM;
        return new DataTransportCrashlyticsReportSender(f2.getTransport(CRASHLYTICS_TRANSPORT_NAME, CrashlyticsReport.class, b, dVar), dVar);
    }

    public static /* synthetic */ void lambda$sendReport$1(h hVar, CrashlyticsReportWithSessionId crashlyticsReportWithSessionId, Exception exc) {
        if (exc != null) {
            hVar.d(exc);
        } else {
            hVar.e(crashlyticsReportWithSessionId);
        }
    }

    private static String mergeStrings(String str, String str2) {
        int length = str.length() - str2.length();
        if (length >= 0 && length <= 1) {
            StringBuilder sb = new StringBuilder(str.length() + str2.length());
            for (int i2 = 0; i2 < str.length(); i2++) {
                sb.append(str.charAt(i2));
                if (str2.length() > i2) {
                    sb.append(str2.charAt(i2));
                }
            }
            return sb.toString();
        }
        throw new IllegalArgumentException("Invalid input received");
    }

    @NonNull
    public g<CrashlyticsReportWithSessionId> sendReport(@NonNull CrashlyticsReportWithSessionId crashlyticsReportWithSessionId) {
        CrashlyticsReport report = crashlyticsReportWithSessionId.getReport();
        h hVar = new h();
        this.transport.schedule(c.e(report), DataTransportCrashlyticsReportSender$$Lambda$1.lambdaFactory$(hVar, crashlyticsReportWithSessionId));
        return hVar.a();
    }
}
