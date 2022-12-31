package com.google.firebase.installations;

import com.google.android.gms.tasks.h;
import com.google.firebase.installations.local.PersistedInstallationEntry;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class GetIdListener implements StateListener {
    final h<String> taskCompletionSource;

    public GetIdListener(h<String> hVar) {
        this.taskCompletionSource = hVar;
    }

    @Override // com.google.firebase.installations.StateListener
    public boolean onException(Exception exc) {
        return false;
    }

    @Override // com.google.firebase.installations.StateListener
    public boolean onStateReached(PersistedInstallationEntry persistedInstallationEntry) {
        if (persistedInstallationEntry.isUnregistered() || persistedInstallationEntry.isRegistered() || persistedInstallationEntry.isErrored()) {
            this.taskCompletionSource.e(persistedInstallationEntry.getFirebaseInstallationId());
            return true;
        }
        return false;
    }
}
