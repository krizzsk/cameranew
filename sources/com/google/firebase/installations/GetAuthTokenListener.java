package com.google.firebase.installations;

import com.google.android.gms.tasks.h;
import com.google.firebase.installations.local.PersistedInstallationEntry;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class GetAuthTokenListener implements StateListener {
    private final h<InstallationTokenResult> resultTaskCompletionSource;
    private final Utils utils;

    public GetAuthTokenListener(Utils utils, h<InstallationTokenResult> hVar) {
        this.utils = utils;
        this.resultTaskCompletionSource = hVar;
    }

    @Override // com.google.firebase.installations.StateListener
    public boolean onException(Exception exc) {
        this.resultTaskCompletionSource.d(exc);
        return true;
    }

    @Override // com.google.firebase.installations.StateListener
    public boolean onStateReached(PersistedInstallationEntry persistedInstallationEntry) {
        if (!persistedInstallationEntry.isRegistered() || this.utils.isAuthTokenExpired(persistedInstallationEntry)) {
            return false;
        }
        this.resultTaskCompletionSource.c(InstallationTokenResult.builder().setToken(persistedInstallationEntry.getAuthToken()).setTokenExpirationTimestamp(persistedInstallationEntry.getExpiresInSecs()).setTokenCreationTimestamp(persistedInstallationEntry.getTokenCreationEpochInSecs()).build());
        return true;
    }
}
