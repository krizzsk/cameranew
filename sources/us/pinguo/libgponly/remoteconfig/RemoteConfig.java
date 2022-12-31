package us.pinguo.libgponly.remoteconfig;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: RemoteConfig.kt */
/* loaded from: classes5.dex */
public final class RemoteConfig implements NoProguard {
    public static final RemoteConfig INSTANCE = new RemoteConfig();
    private static final FirebaseRemoteConfig config;

    static {
        FirebaseRemoteConfig firebaseRemoteConfig;
        try {
            firebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        } catch (Throwable unused) {
            firebaseRemoteConfig = null;
        }
        config = firebaseRemoteConfig;
    }

    private RemoteConfig() {
    }

    public final void init() {
    }
}
