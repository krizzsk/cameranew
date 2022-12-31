package com.google.firebase.messaging;

import androidx.annotation.Keep;
import androidx.annotation.VisibleForTesting;
import com.google.android.datatransport.b;
import com.google.android.datatransport.c;
import com.google.android.datatransport.d;
import com.google.android.datatransport.e;
import com.google.android.datatransport.f;
import com.google.android.datatransport.g;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.events.Subscriber;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.util.Arrays;
import java.util.List;
/* compiled from: com.google.firebase:firebase-messaging@@21.0.1 */
@Keep
/* loaded from: classes2.dex */
public class FirebaseMessagingRegistrar implements ComponentRegistrar {

    /* compiled from: com.google.firebase:firebase-messaging@@21.0.1 */
    /* loaded from: classes2.dex */
    private static class DevNullTransport<T> implements e<T> {
        private DevNullTransport() {
        }

        @Override // com.google.android.datatransport.e
        public void schedule(c<T> cVar, g gVar) {
            gVar.onSchedule(null);
        }

        @Override // com.google.android.datatransport.e
        public void send(c<T> cVar) {
        }
    }

    /* compiled from: com.google.firebase:firebase-messaging@@21.0.1 */
    @VisibleForTesting
    /* loaded from: classes2.dex */
    public static class DevNullTransportFactory implements f {
        @Override // com.google.android.datatransport.f
        public <T> e<T> getTransport(String str, Class<T> cls, b bVar, d<T, byte[]> dVar) {
            return new DevNullTransport();
        }

        public <T> e<T> getTransport(String str, Class<T> cls, d<T, byte[]> dVar) {
            return new DevNullTransport();
        }
    }

    @VisibleForTesting
    static f determineFactory(f fVar) {
        if (fVar == null) {
            return new DevNullTransportFactory();
        }
        try {
            fVar.getTransport("test", String.class, b.b("json"), FirebaseMessagingRegistrar$$Lambda$1.$instance);
            return fVar;
        } catch (IllegalArgumentException unused) {
            return new DevNullTransportFactory();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ FirebaseMessaging lambda$getComponents$0$FirebaseMessagingRegistrar(ComponentContainer componentContainer) {
        return new FirebaseMessaging((FirebaseApp) componentContainer.get(FirebaseApp.class), (FirebaseInstanceId) componentContainer.get(FirebaseInstanceId.class), componentContainer.getProvider(UserAgentPublisher.class), componentContainer.getProvider(HeartBeatInfo.class), (FirebaseInstallationsApi) componentContainer.get(FirebaseInstallationsApi.class), determineFactory((f) componentContainer.get(f.class)), (Subscriber) componentContainer.get(Subscriber.class));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    @Keep
    public List<Component<?>> getComponents() {
        return Arrays.asList(Component.builder(FirebaseMessaging.class).add(Dependency.required(FirebaseApp.class)).add(Dependency.required(FirebaseInstanceId.class)).add(Dependency.optionalProvider(UserAgentPublisher.class)).add(Dependency.optionalProvider(HeartBeatInfo.class)).add(Dependency.optional(f.class)).add(Dependency.required(FirebaseInstallationsApi.class)).add(Dependency.required(Subscriber.class)).factory(FirebaseMessagingRegistrar$$Lambda$0.$instance).alwaysEager().build(), LibraryVersionComponent.create("fire-fcm", BuildConfig.VERSION_NAME));
    }
}
