package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.internal.c;
import com.google.android.gms.common.internal.q;
import java.util.Set;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public final class a<O extends d> {
    private final AbstractC0134a<?, O> a;
    private final g<?> b;
    private final String c;

    /* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
    /* renamed from: com.google.android.gms.common.api.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static abstract class AbstractC0134a<T extends f, O> extends e<T, O> {
        @Deprecated
        public T a(Context context, Looper looper, com.google.android.gms.common.internal.d dVar, O o, GoogleApiClient.a aVar, GoogleApiClient.b bVar) {
            throw null;
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
    /* loaded from: classes2.dex */
    public interface b {
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
    /* loaded from: classes2.dex */
    public static class c<C extends b> {
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
    /* loaded from: classes2.dex */
    public interface d {

        /* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
        /* renamed from: com.google.android.gms.common.api.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public interface InterfaceC0135a extends d {
            Account y();
        }

        /* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
        /* loaded from: classes2.dex */
        public interface b extends d {
            GoogleSignInAccount x();
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
    /* loaded from: classes2.dex */
    public static abstract class e<T extends b, O> {
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
    /* loaded from: classes2.dex */
    public interface f extends b {
        void connect(c.InterfaceC0137c interfaceC0137c);

        void disconnect();

        Feature[] getAvailableFeatures();

        String getEndpointPackageName();

        int getMinApkVersion();

        void getRemoteService(com.google.android.gms.common.internal.j jVar, Set<Scope> set);

        @NonNull
        Set<Scope> getScopesForConnectionlessNonSignIn();

        boolean isConnected();

        boolean isConnecting();

        void onUserSignOut(c.e eVar);

        boolean requiresGooglePlayServices();

        boolean requiresSignIn();
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
    /* loaded from: classes2.dex */
    public static final class g<C extends f> extends c<C> {
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
    /* loaded from: classes2.dex */
    public interface h<T extends IInterface> extends b {
        void b(int i2, T t);

        T createServiceInterface(IBinder iBinder);

        String getServiceDescriptor();

        String getStartServiceAction();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <C extends f> a(String str, AbstractC0134a<C, O> abstractC0134a, g<C> gVar) {
        q.k(abstractC0134a, "Cannot construct an Api with a null ClientBuilder");
        q.k(gVar, "Cannot construct an Api with a null ClientKey");
        this.c = str;
        this.a = abstractC0134a;
        this.b = gVar;
    }

    public final c<?> a() {
        g<?> gVar = this.b;
        if (gVar != null) {
            return gVar;
        }
        throw new IllegalStateException("This API was constructed with null client keys. This should not be possible.");
    }

    public final String b() {
        return this.c;
    }

    public final AbstractC0134a<?, O> c() {
        q.n(this.a != null, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return this.a;
    }
}
