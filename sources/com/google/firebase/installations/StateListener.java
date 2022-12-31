package com.google.firebase.installations;

import com.google.firebase.installations.local.PersistedInstallationEntry;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public interface StateListener {
    boolean onException(Exception exc);

    boolean onStateReached(PersistedInstallationEntry persistedInstallationEntry);
}
