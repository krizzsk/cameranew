package com.google.firebase.ktx;

import android.content.Context;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import kotlin.jvm.internal.s;
/* compiled from: Firebase.kt */
/* loaded from: classes2.dex */
public final class FirebaseKt {
    public static final String LIBRARY_NAME = "fire-core-ktx";

    public static final FirebaseApp app(Firebase receiver$0, String name) {
        s.i(receiver$0, "receiver$0");
        s.i(name, "name");
        FirebaseApp firebaseApp = FirebaseApp.getInstance(name);
        s.d(firebaseApp, "FirebaseApp.getInstance(name)");
        return firebaseApp;
    }

    public static final FirebaseApp getApp(Firebase receiver$0) {
        s.i(receiver$0, "receiver$0");
        FirebaseApp firebaseApp = FirebaseApp.getInstance();
        s.d(firebaseApp, "FirebaseApp.getInstance()");
        return firebaseApp;
    }

    public static final FirebaseOptions getOptions(Firebase receiver$0) {
        s.i(receiver$0, "receiver$0");
        FirebaseOptions options = getApp(Firebase.INSTANCE).getOptions();
        s.d(options, "Firebase.app.options");
        return options;
    }

    public static final FirebaseApp initialize(Firebase receiver$0, Context context) {
        s.i(receiver$0, "receiver$0");
        s.i(context, "context");
        return FirebaseApp.initializeApp(context);
    }

    public static final FirebaseApp initialize(Firebase receiver$0, Context context, FirebaseOptions options) {
        s.i(receiver$0, "receiver$0");
        s.i(context, "context");
        s.i(options, "options");
        FirebaseApp initializeApp = FirebaseApp.initializeApp(context, options);
        s.d(initializeApp, "FirebaseApp.initializeApp(context, options)");
        return initializeApp;
    }

    public static final FirebaseApp initialize(Firebase receiver$0, Context context, FirebaseOptions options, String name) {
        s.i(receiver$0, "receiver$0");
        s.i(context, "context");
        s.i(options, "options");
        s.i(name, "name");
        FirebaseApp initializeApp = FirebaseApp.initializeApp(context, options, name);
        s.d(initializeApp, "FirebaseApp.initializeApp(context, options, name)");
        return initializeApp;
    }
}
