package com.google.firebase.messaging.ktx;

import com.google.firebase.ktx.Firebase;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.RemoteMessage;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: Messaging.kt */
/* loaded from: classes2.dex */
public final class MessagingKt {
    public static final String LIBRARY_NAME = "fire-fcm-ktx";

    public static final FirebaseMessaging getMessaging(Firebase receiver$0) {
        s.i(receiver$0, "receiver$0");
        FirebaseMessaging firebaseMessaging = FirebaseMessaging.getInstance();
        s.d(firebaseMessaging, "FirebaseMessaging.getInstance()");
        return firebaseMessaging;
    }

    public static final RemoteMessage remoteMessage(String to, l<? super RemoteMessage.Builder, u> init) {
        s.i(to, "to");
        s.i(init, "init");
        RemoteMessage.Builder builder = new RemoteMessage.Builder(to);
        init.invoke(builder);
        RemoteMessage build = builder.build();
        s.d(build, "builder.build()");
        return build;
    }
}
