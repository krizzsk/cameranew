package com.google.firebase.remoteconfig.ktx;

import com.google.firebase.FirebaseApp;
import com.google.firebase.ktx.Firebase;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigValue;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: RemoteConfig.kt */
/* loaded from: classes2.dex */
public final class RemoteConfigKt {
    public static final String LIBRARY_NAME = "fire-cfg-ktx";

    public static final FirebaseRemoteConfigValue get(FirebaseRemoteConfig receiver$0, String key) {
        s.i(receiver$0, "receiver$0");
        s.i(key, "key");
        FirebaseRemoteConfigValue value = receiver$0.getValue(key);
        s.d(value, "this.getValue(key)");
        return value;
    }

    public static final FirebaseRemoteConfig getRemoteConfig(Firebase receiver$0) {
        s.i(receiver$0, "receiver$0");
        FirebaseRemoteConfig firebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        s.d(firebaseRemoteConfig, "FirebaseRemoteConfig.getInstance()");
        return firebaseRemoteConfig;
    }

    public static final FirebaseRemoteConfig remoteConfig(Firebase receiver$0, FirebaseApp app) {
        s.i(receiver$0, "receiver$0");
        s.i(app, "app");
        FirebaseRemoteConfig firebaseRemoteConfig = FirebaseRemoteConfig.getInstance(app);
        s.d(firebaseRemoteConfig, "FirebaseRemoteConfig.getInstance(app)");
        return firebaseRemoteConfig;
    }

    public static final FirebaseRemoteConfigSettings remoteConfigSettings(l<? super FirebaseRemoteConfigSettings.Builder, u> init) {
        s.i(init, "init");
        FirebaseRemoteConfigSettings.Builder builder = new FirebaseRemoteConfigSettings.Builder();
        init.invoke(builder);
        FirebaseRemoteConfigSettings build = builder.build();
        s.d(build, "builder.build()");
        return build;
    }
}
