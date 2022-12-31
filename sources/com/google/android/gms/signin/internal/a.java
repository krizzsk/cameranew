package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.c;
import com.google.android.gms.common.internal.q;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public class a extends com.google.android.gms.common.internal.g<e> implements d.c.a.c.a.e {
    private final boolean a;
    private final com.google.android.gms.common.internal.d b;
    private final Bundle c;

    /* renamed from: d  reason: collision with root package name */
    private Integer f4014d;

    private a(Context context, Looper looper, boolean z, com.google.android.gms.common.internal.d dVar, Bundle bundle, GoogleApiClient.a aVar, GoogleApiClient.b bVar) {
        super(context, looper, 44, dVar, aVar, bVar);
        this.a = true;
        this.b = dVar;
        this.c = bundle;
        this.f4014d = dVar.e();
    }

    public static Bundle c(com.google.android.gms.common.internal.d dVar) {
        d.c.a.c.a.a i2 = dVar.i();
        Integer e2 = dVar.e();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", dVar.b());
        if (e2 != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", e2.intValue());
        }
        if (i2 != null) {
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", i2.h());
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", i2.g());
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", i2.e());
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", i2.f());
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", i2.b());
            bundle.putString("com.google.android.gms.signin.internal.logSessionId", i2.c());
            bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", i2.i());
            if (i2.a() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.authApiSignInModuleVersion", i2.a().longValue());
            }
            if (i2.d() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.realClientLibraryVersion", i2.d().longValue());
            }
        }
        return bundle;
    }

    @Override // d.c.a.c.a.e
    public final void a(c cVar) {
        q.k(cVar, "Expecting a valid ISignInCallbacks");
        try {
            Account c = this.b.c();
            ((e) getService()).n0(new zak(new ResolveAccountRequest(c, this.f4014d.intValue(), com.google.android.gms.common.internal.c.DEFAULT_ACCOUNT.equals(c.name) ? com.google.android.gms.auth.api.signin.internal.b.a(getContext()).b() : null)), cVar);
        } catch (RemoteException e2) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                cVar.D(new zam(8));
            } catch (RemoteException unused) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e2);
            }
        }
    }

    @Override // d.c.a.c.a.e
    public final void connect() {
        connect(new c.d());
    }

    @Override // com.google.android.gms.common.internal.c
    protected /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        if (queryLocalInterface instanceof e) {
            return (e) queryLocalInterface;
        }
        return new g(iBinder);
    }

    @Override // com.google.android.gms.common.internal.c
    protected Bundle getGetServiceRequestExtraArgs() {
        if (!getContext().getPackageName().equals(this.b.g())) {
            this.c.putString("com.google.android.gms.signin.internal.realClientPackageName", this.b.g());
        }
        return this.c;
    }

    @Override // com.google.android.gms.common.internal.g, com.google.android.gms.common.internal.c, com.google.android.gms.common.api.a.f
    public int getMinApkVersion() {
        return com.google.android.gms.common.c.a;
    }

    @Override // com.google.android.gms.common.internal.c
    protected String getServiceDescriptor() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override // com.google.android.gms.common.internal.c
    protected String getStartServiceAction() {
        return "com.google.android.gms.signin.service.START";
    }

    @Override // com.google.android.gms.common.internal.c, com.google.android.gms.common.api.a.f
    public boolean requiresSignIn() {
        return this.a;
    }

    public a(Context context, Looper looper, boolean z, com.google.android.gms.common.internal.d dVar, d.c.a.c.a.a aVar, GoogleApiClient.a aVar2, GoogleApiClient.b bVar) {
        this(context, looper, true, dVar, c(dVar), aVar2, bVar);
    }
}
