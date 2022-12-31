package com.google.firebase.installations;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.g;
import com.google.firebase.annotations.DeferredApi;
import com.google.firebase.installations.internal.FidListener;
import com.google.firebase.installations.internal.FidListenerHandle;
/* loaded from: classes2.dex */
public interface FirebaseInstallationsApi {
    @NonNull
    g<Void> delete();

    @NonNull
    g<String> getId();

    @NonNull
    g<InstallationTokenResult> getToken(boolean z);

    @DeferredApi
    FidListenerHandle registerFidListener(@NonNull FidListener fidListener);
}
