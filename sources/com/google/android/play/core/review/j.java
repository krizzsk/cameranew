package com.google.android.play.core.review;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.tasks.p;
/* loaded from: classes2.dex */
final class j extends i<ReviewInfo> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar, p pVar) {
        super(hVar, new com.google.android.play.core.internal.j("OnRequestInstallCallback"), pVar);
    }

    @Override // com.google.android.play.core.review.i, com.google.android.play.core.internal.h
    public final void a(Bundle bundle) throws RemoteException {
        super.a(bundle);
        this.b.e(ReviewInfo.b((PendingIntent) bundle.get("confirmation_intent")));
    }
}
