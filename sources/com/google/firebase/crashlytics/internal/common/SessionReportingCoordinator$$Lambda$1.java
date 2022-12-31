package com.google.firebase.crashlytics.internal.common;

import com.google.android.gms.tasks.a;
import com.google.android.gms.tasks.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final /* synthetic */ class SessionReportingCoordinator$$Lambda$1 implements a {
    private final SessionReportingCoordinator arg$1;

    private SessionReportingCoordinator$$Lambda$1(SessionReportingCoordinator sessionReportingCoordinator) {
        this.arg$1 = sessionReportingCoordinator;
    }

    public static a lambdaFactory$(SessionReportingCoordinator sessionReportingCoordinator) {
        return new SessionReportingCoordinator$$Lambda$1(sessionReportingCoordinator);
    }

    @Override // com.google.android.gms.tasks.a
    public Object then(g gVar) {
        return Boolean.valueOf(SessionReportingCoordinator.access$lambda$0(this.arg$1, gVar));
    }
}
