package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.datatransport.f;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.tasks.e;
import com.google.android.gms.tasks.g;
import com.google.android.gms.tasks.h;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.events.Subscriber;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.Metadata;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.platforminfo.UserAgentPublisher;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: com.google.firebase:firebase-messaging@@21.0.1 */
/* loaded from: classes2.dex */
public class FirebaseMessaging {
    @Deprecated
    public static final String INSTANCE_ID_SCOPE = "FCM";
    @Nullable
    @SuppressLint({"FirebaseUnknownNullness"})
    @VisibleForTesting
    static f transportFactory;
    private final AutoInit autoInit;
    private final Context context;
    private final Executor fileIoExecutor;
    private final FirebaseApp firebaseApp;
    private final FirebaseInstanceId iid;
    private final g<TopicsSubscriber> topicsSubscriberTask;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.firebase:firebase-messaging@@21.0.1 */
    /* loaded from: classes2.dex */
    public class AutoInit {
        @Nullable
        @GuardedBy("this")
        private Boolean autoInitEnabled;
        @Nullable
        @GuardedBy("this")
        private EventHandler<DataCollectionDefaultChange> dataCollectionDefaultChangeEventHandler;
        @GuardedBy("this")
        private boolean initialized;
        private final Subscriber subscriber;

        AutoInit(Subscriber subscriber) {
            this.subscriber = subscriber;
        }

        @Nullable
        private Boolean readEnabled() {
            ApplicationInfo applicationInfo;
            Bundle bundle;
            Context applicationContext = FirebaseMessaging.this.firebaseApp.getApplicationContext();
            SharedPreferences sharedPreferences = applicationContext.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains("auto_init")) {
                return Boolean.valueOf(sharedPreferences.getBoolean("auto_init", false));
            }
            try {
                PackageManager packageManager = applicationContext.getPackageManager();
                if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(applicationContext.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_messaging_auto_init_enabled")) {
                    return null;
                }
                return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled"));
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }

        synchronized void initialize() {
            if (this.initialized) {
                return;
            }
            Boolean readEnabled = readEnabled();
            this.autoInitEnabled = readEnabled;
            if (readEnabled == null) {
                EventHandler<DataCollectionDefaultChange> eventHandler = new EventHandler(this) { // from class: com.google.firebase.messaging.FirebaseMessaging$AutoInit$$Lambda$0
                    private final FirebaseMessaging.AutoInit arg$1;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.arg$1 = this;
                    }

                    @Override // com.google.firebase.events.EventHandler
                    public void handle(Event event) {
                        this.arg$1.lambda$initialize$1$FirebaseMessaging$AutoInit(event);
                    }
                };
                this.dataCollectionDefaultChangeEventHandler = eventHandler;
                this.subscriber.subscribe(DataCollectionDefaultChange.class, eventHandler);
            }
            this.initialized = true;
        }

        synchronized boolean isEnabled() {
            boolean isDataCollectionDefaultEnabled;
            initialize();
            Boolean bool = this.autoInitEnabled;
            if (bool != null) {
                isDataCollectionDefaultEnabled = bool.booleanValue();
            } else {
                isDataCollectionDefaultEnabled = FirebaseMessaging.this.firebaseApp.isDataCollectionDefaultEnabled();
            }
            return isDataCollectionDefaultEnabled;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final /* synthetic */ void lambda$initialize$0$FirebaseMessaging$AutoInit() {
            FirebaseMessaging.this.iid.getToken();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final /* synthetic */ void lambda$initialize$1$FirebaseMessaging$AutoInit(Event event) {
            if (isEnabled()) {
                FirebaseMessaging.this.fileIoExecutor.execute(new Runnable(this) { // from class: com.google.firebase.messaging.FirebaseMessaging$AutoInit$$Lambda$2
                    private final FirebaseMessaging.AutoInit arg$1;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.arg$1 = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        this.arg$1.lambda$initialize$0$FirebaseMessaging$AutoInit();
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final /* synthetic */ void lambda$setEnabled$2$FirebaseMessaging$AutoInit() {
            FirebaseMessaging.this.iid.getToken();
        }

        synchronized void setEnabled(boolean z) {
            initialize();
            EventHandler<DataCollectionDefaultChange> eventHandler = this.dataCollectionDefaultChangeEventHandler;
            if (eventHandler != null) {
                this.subscriber.unsubscribe(DataCollectionDefaultChange.class, eventHandler);
                this.dataCollectionDefaultChangeEventHandler = null;
            }
            SharedPreferences.Editor edit = FirebaseMessaging.this.firebaseApp.getApplicationContext().getSharedPreferences("com.google.firebase.messaging", 0).edit();
            edit.putBoolean("auto_init", z);
            edit.apply();
            if (z) {
                FirebaseMessaging.this.fileIoExecutor.execute(new Runnable(this) { // from class: com.google.firebase.messaging.FirebaseMessaging$AutoInit$$Lambda$1
                    private final FirebaseMessaging.AutoInit arg$1;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.arg$1 = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        this.arg$1.lambda$setEnabled$2$FirebaseMessaging$AutoInit();
                    }
                });
            }
            this.autoInitEnabled = Boolean.valueOf(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirebaseMessaging(FirebaseApp firebaseApp, final FirebaseInstanceId firebaseInstanceId, Provider<UserAgentPublisher> provider, Provider<HeartBeatInfo> provider2, FirebaseInstallationsApi firebaseInstallationsApi, @Nullable f fVar, Subscriber subscriber) {
        try {
            Class.forName("com.google.firebase.iid.FirebaseInstanceIdReceiver");
            transportFactory = fVar;
            this.firebaseApp = firebaseApp;
            this.iid = firebaseInstanceId;
            this.autoInit = new AutoInit(subscriber);
            Context applicationContext = firebaseApp.getApplicationContext();
            this.context = applicationContext;
            ScheduledExecutorService newInitExecutor = FcmExecutors.newInitExecutor();
            this.fileIoExecutor = newInitExecutor;
            newInitExecutor.execute(new Runnable(this, firebaseInstanceId) { // from class: com.google.firebase.messaging.FirebaseMessaging$$Lambda$0
                private final FirebaseMessaging arg$1;
                private final FirebaseInstanceId arg$2;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.arg$1 = this;
                    this.arg$2 = firebaseInstanceId;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.arg$1.lambda$new$0$FirebaseMessaging(this.arg$2);
                }
            });
            g<TopicsSubscriber> createInstance = TopicsSubscriber.createInstance(firebaseApp, firebaseInstanceId, new Metadata(applicationContext), provider, provider2, firebaseInstallationsApi, applicationContext, FcmExecutors.newTopicsSyncExecutor());
            this.topicsSubscriberTask = createInstance;
            createInstance.d(FcmExecutors.newTopicsSyncTriggerExecutor(), new e(this) { // from class: com.google.firebase.messaging.FirebaseMessaging$$Lambda$1
                private final FirebaseMessaging arg$1;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.arg$1 = this;
                }

                @Override // com.google.android.gms.tasks.e
                public void onSuccess(Object obj) {
                    this.arg$1.lambda$new$1$FirebaseMessaging((TopicsSubscriber) obj);
                }
            });
        } catch (ClassNotFoundException unused) {
            throw new IllegalStateException("FirebaseMessaging and FirebaseInstanceId versions not compatible. Update to latest version of firebase-messaging.");
        }
    }

    @NonNull
    public static synchronized FirebaseMessaging getInstance() {
        FirebaseMessaging firebaseMessaging;
        synchronized (FirebaseMessaging.class) {
            firebaseMessaging = getInstance(FirebaseApp.getInstance());
        }
        return firebaseMessaging;
    }

    @Nullable
    public static f getTransportFactory() {
        return transportFactory;
    }

    @NonNull
    public g<Void> deleteToken() {
        final h hVar = new h();
        FcmExecutors.newNetworkIOExecutor().execute(new Runnable(this, hVar) { // from class: com.google.firebase.messaging.FirebaseMessaging$$Lambda$3
            private final FirebaseMessaging arg$1;
            private final h arg$2;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.arg$1 = this;
                this.arg$2 = hVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.arg$1.lambda$deleteToken$3$FirebaseMessaging(this.arg$2);
            }
        });
        return hVar.a();
    }

    @NonNull
    public boolean deliveryMetricsExportToBigQueryEnabled() {
        return MessagingAnalytics.deliveryMetricsExportToBigQueryEnabled();
    }

    @NonNull
    public g<String> getToken() {
        return this.iid.getInstanceId().e(FirebaseMessaging$$Lambda$2.$instance);
    }

    public boolean isAutoInitEnabled() {
        return this.autoInit.isEnabled();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void lambda$deleteToken$3$FirebaseMessaging(h hVar) {
        try {
            this.iid.deleteToken(Metadata.getDefaultSenderId(this.firebaseApp), INSTANCE_ID_SCOPE);
            hVar.c(null);
        } catch (Exception e2) {
            hVar.b(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void lambda$new$0$FirebaseMessaging(FirebaseInstanceId firebaseInstanceId) {
        if (this.autoInit.isEnabled()) {
            firebaseInstanceId.getToken();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void lambda$new$1$FirebaseMessaging(TopicsSubscriber topicsSubscriber) {
        if (isAutoInitEnabled()) {
            topicsSubscriber.startTopicsSyncIfNecessary();
        }
    }

    public void send(@NonNull RemoteMessage remoteMessage) {
        if (!TextUtils.isEmpty(remoteMessage.getTo())) {
            Intent intent = new Intent("com.google.android.gcm.intent.SEND");
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            Context context = this.context;
            VdsAgent.onPendingIntentGetBroadcastBefore(context, 0, intent2, 0);
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent2, 0);
            VdsAgent.onPendingIntentGetBroadcastAfter(context, 0, intent2, 0, broadcast);
            intent.putExtra("app", broadcast);
            intent.setPackage("com.google.android.gms");
            remoteMessage.populateSendMessageIntent(intent);
            this.context.sendOrderedBroadcast(intent, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
            return;
        }
        throw new IllegalArgumentException("Missing 'to'");
    }

    public void setAutoInitEnabled(boolean z) {
        this.autoInit.setEnabled(z);
    }

    public void setDeliveryMetricsExportToBigQuery(boolean z) {
        MessagingAnalytics.setDeliveryMetricsExportToBigQuery(z);
    }

    @NonNull
    public g<Void> subscribeToTopic(@NonNull final String str) {
        return this.topicsSubscriberTask.o(new com.google.android.gms.tasks.f(str) { // from class: com.google.firebase.messaging.FirebaseMessaging$$Lambda$4
            private final String arg$1;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.arg$1 = str;
            }

            @Override // com.google.android.gms.tasks.f
            public g then(Object obj) {
                g subscribeToTopic;
                subscribeToTopic = ((TopicsSubscriber) obj).subscribeToTopic(this.arg$1);
                return subscribeToTopic;
            }
        });
    }

    @NonNull
    public g<Void> unsubscribeFromTopic(@NonNull final String str) {
        return this.topicsSubscriberTask.o(new com.google.android.gms.tasks.f(str) { // from class: com.google.firebase.messaging.FirebaseMessaging$$Lambda$5
            private final String arg$1;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.arg$1 = str;
            }

            @Override // com.google.android.gms.tasks.f
            public g then(Object obj) {
                g unsubscribeFromTopic;
                unsubscribeFromTopic = ((TopicsSubscriber) obj).unsubscribeFromTopic(this.arg$1);
                return unsubscribeFromTopic;
            }
        });
    }

    @NonNull
    @Keep
    static synchronized FirebaseMessaging getInstance(@NonNull FirebaseApp firebaseApp) {
        FirebaseMessaging firebaseMessaging;
        synchronized (FirebaseMessaging.class) {
            firebaseMessaging = (FirebaseMessaging) firebaseApp.get(FirebaseMessaging.class);
            q.k(firebaseMessaging, "Firebase Messaging component is not present");
        }
        return firebaseMessaging;
    }
}
