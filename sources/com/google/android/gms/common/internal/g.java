package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.IInterface;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.c;
import java.util.Collections;
import java.util.Set;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public abstract class g<T extends IInterface> extends c<T> implements a.f {
    private final Set<Scope> mScopes;
    private final d zaex;
    private final Account zax;

    protected g(Context context, Handler handler, int i2, d dVar) {
        this(context, handler, h.b(context), GoogleApiAvailability.getInstance(), i2, dVar, (GoogleApiClient.a) null, (GoogleApiClient.b) null);
    }

    private final Set<Scope> zaa(@NonNull Set<Scope> set) {
        Set<Scope> validateScopes = validateScopes(set);
        for (Scope scope : validateScopes) {
            if (!set.contains(scope)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return validateScopes;
    }

    @Override // com.google.android.gms.common.internal.c
    public final Account getAccount() {
        return this.zax;
    }

    protected final d getClientSettings() {
        return this.zaex;
    }

    @Override // com.google.android.gms.common.internal.c, com.google.android.gms.common.api.a.f
    public int getMinApkVersion() {
        return super.getMinApkVersion();
    }

    public Feature[] getRequiredFeatures() {
        return new Feature[0];
    }

    @Override // com.google.android.gms.common.internal.c
    protected final Set<Scope> getScopes() {
        return this.mScopes;
    }

    @Override // com.google.android.gms.common.api.a.f
    @NonNull
    public Set<Scope> getScopesForConnectionlessNonSignIn() {
        return requiresSignIn() ? this.mScopes : Collections.emptySet();
    }

    @NonNull
    protected Set<Scope> validateScopes(@NonNull Set<Scope> set) {
        return set;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected g(android.content.Context r10, android.os.Looper r11, int r12, com.google.android.gms.common.internal.d r13, com.google.android.gms.common.api.internal.e r14, com.google.android.gms.common.api.internal.l r15) {
        /*
            r9 = this;
            com.google.android.gms.common.internal.h r3 = com.google.android.gms.common.internal.h.b(r10)
            com.google.android.gms.common.GoogleApiAvailability r4 = com.google.android.gms.common.GoogleApiAvailability.getInstance()
            com.google.android.gms.common.internal.q.j(r14)
            r7 = r14
            com.google.android.gms.common.api.internal.e r7 = (com.google.android.gms.common.api.internal.e) r7
            com.google.android.gms.common.internal.q.j(r15)
            r8 = r15
            com.google.android.gms.common.api.internal.l r8 = (com.google.android.gms.common.api.internal.l) r8
            r0 = r9
            r1 = r10
            r2 = r11
            r5 = r12
            r6 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.g.<init>(android.content.Context, android.os.Looper, int, com.google.android.gms.common.internal.d, com.google.android.gms.common.api.internal.e, com.google.android.gms.common.api.internal.l):void");
    }

    @Nullable
    private static c.a zaa(com.google.android.gms.common.api.internal.e eVar) {
        if (eVar == null) {
            return null;
        }
        return new x(eVar);
    }

    @Nullable
    private static c.b zaa(com.google.android.gms.common.api.internal.l lVar) {
        if (lVar == null) {
            return null;
        }
        return new w(lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Deprecated
    public g(Context context, Looper looper, int i2, d dVar, GoogleApiClient.a aVar, GoogleApiClient.b bVar) {
        this(context, looper, i2, dVar, (com.google.android.gms.common.api.internal.e) aVar, (com.google.android.gms.common.api.internal.l) bVar);
    }

    protected g(Context context, Looper looper, int i2, d dVar) {
        this(context, looper, h.b(context), GoogleApiAvailability.getInstance(), i2, dVar, (GoogleApiClient.a) null, (GoogleApiClient.b) null);
    }

    protected g(Context context, Looper looper, h hVar, GoogleApiAvailability googleApiAvailability, int i2, d dVar, com.google.android.gms.common.api.internal.e eVar, com.google.android.gms.common.api.internal.l lVar) {
        super(context, looper, hVar, googleApiAvailability, i2, zaa(eVar), zaa(lVar), dVar.f());
        this.zaex = dVar;
        this.zax = dVar.b();
        this.mScopes = zaa(dVar.d());
    }

    protected g(Context context, Looper looper, h hVar, GoogleApiAvailability googleApiAvailability, int i2, d dVar, GoogleApiClient.a aVar, GoogleApiClient.b bVar) {
        this(context, looper, hVar, googleApiAvailability, i2, dVar, (com.google.android.gms.common.api.internal.e) aVar, (com.google.android.gms.common.api.internal.l) bVar);
    }

    protected g(Context context, Handler handler, h hVar, GoogleApiAvailability googleApiAvailability, int i2, d dVar, com.google.android.gms.common.api.internal.e eVar, com.google.android.gms.common.api.internal.l lVar) {
        super(context, handler, hVar, googleApiAvailability, i2, zaa(eVar), zaa(lVar));
        q.j(dVar);
        this.zaex = dVar;
        this.zax = dVar.b();
        this.mScopes = zaa(dVar.d());
    }

    @Deprecated
    protected g(Context context, Handler handler, h hVar, GoogleApiAvailability googleApiAvailability, int i2, d dVar, GoogleApiClient.a aVar, GoogleApiClient.b bVar) {
        this(context, handler, hVar, googleApiAvailability, i2, dVar, (com.google.android.gms.common.api.internal.e) aVar, (com.google.android.gms.common.api.internal.l) bVar);
    }
}
