package com.google.firebase.crashlytics.internal.model.serialization;

import android.util.JsonReader;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;
/* loaded from: classes2.dex */
public final /* synthetic */ class CrashlyticsReportJsonTransform$$Lambda$4 implements CrashlyticsReportJsonTransform.ObjectParser {
    private static final CrashlyticsReportJsonTransform$$Lambda$4 instance = new CrashlyticsReportJsonTransform$$Lambda$4();

    private CrashlyticsReportJsonTransform$$Lambda$4() {
    }

    public static CrashlyticsReportJsonTransform.ObjectParser lambdaFactory$() {
        return instance;
    }

    @Override // com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform.ObjectParser
    public Object parse(JsonReader jsonReader) {
        CrashlyticsReport.Session.Event.Application.Execution.Thread parseEventThread;
        parseEventThread = CrashlyticsReportJsonTransform.parseEventThread(jsonReader);
        return parseEventThread;
    }
}
