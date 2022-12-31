package com.google.firebase.crashlytics.internal.model.serialization;

import android.util.JsonReader;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;
/* loaded from: classes2.dex */
public final /* synthetic */ class CrashlyticsReportJsonTransform$$Lambda$2 implements CrashlyticsReportJsonTransform.ObjectParser {
    private static final CrashlyticsReportJsonTransform$$Lambda$2 instance = new CrashlyticsReportJsonTransform$$Lambda$2();

    private CrashlyticsReportJsonTransform$$Lambda$2() {
    }

    public static CrashlyticsReportJsonTransform.ObjectParser lambdaFactory$() {
        return instance;
    }

    @Override // com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform.ObjectParser
    public Object parse(JsonReader jsonReader) {
        CrashlyticsReport.FilesPayload.File parseFile;
        parseFile = CrashlyticsReportJsonTransform.parseFile(jsonReader);
        return parseFile;
    }
}
