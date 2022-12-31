package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.o0;
import com.google.android.gms.common.internal.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
@Deprecated
/* loaded from: classes2.dex */
public abstract class GoogleApiClient {

    /* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
    @Deprecated
    /* loaded from: classes2.dex */
    public static final class Builder {
        private Account a;
        private final Set<Scope> b = new HashSet();
        private int c;

        /* renamed from: d  reason: collision with root package name */
        private View f3594d;

        /* renamed from: e  reason: collision with root package name */
        private String f3595e;

        /* renamed from: f  reason: collision with root package name */
        private String f3596f;

        /* renamed from: g  reason: collision with root package name */
        private final Map<com.google.android.gms.common.api.a<?>, d.b> f3597g;

        /* renamed from: h  reason: collision with root package name */
        private final Context f3598h;

        /* renamed from: i  reason: collision with root package name */
        private final Map<com.google.android.gms.common.api.a<?>, a.d> f3599i;

        public Builder(@NonNull Context context) {
            new HashSet();
            this.f3597g = new ArrayMap();
            this.f3599i = new ArrayMap();
            GoogleApiAvailability.getInstance();
            a.AbstractC0134a<com.google.android.gms.signin.internal.a, d.c.a.c.a.a> abstractC0134a = d.c.a.c.a.b.c;
            new ArrayList();
            new ArrayList();
            this.f3598h = context;
            context.getMainLooper();
            this.f3595e = context.getPackageName();
            this.f3596f = context.getClass().getName();
        }

        public final com.google.android.gms.common.internal.d a() {
            d.c.a.c.a.a aVar = d.c.a.c.a.a.f8500j;
            Map<com.google.android.gms.common.api.a<?>, a.d> map = this.f3599i;
            com.google.android.gms.common.api.a<d.c.a.c.a.a> aVar2 = d.c.a.c.a.b.f8508e;
            if (map.containsKey(aVar2)) {
                aVar = (d.c.a.c.a.a) this.f3599i.get(aVar2);
            }
            return new com.google.android.gms.common.internal.d(this.a, this.b, this.f3597g, this.c, this.f3594d, this.f3595e, this.f3596f, aVar, false);
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
    @Deprecated
    /* loaded from: classes2.dex */
    public interface a extends com.google.android.gms.common.api.internal.e {
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
    @Deprecated
    /* loaded from: classes2.dex */
    public interface b extends com.google.android.gms.common.api.internal.l {
    }

    static {
        Collections.newSetFromMap(new WeakHashMap());
    }

    public <A extends a.b, R extends g, T extends com.google.android.gms.common.api.internal.c<R, A>> T a(@NonNull T t) {
        throw new UnsupportedOperationException();
    }

    public <A extends a.b, T extends com.google.android.gms.common.api.internal.c<? extends g, A>> T b(@NonNull T t) {
        throw new UnsupportedOperationException();
    }

    @NonNull
    public <C extends a.f> C c(@NonNull a.c<C> cVar) {
        throw new UnsupportedOperationException();
    }

    public Looper d() {
        throw new UnsupportedOperationException();
    }

    public void e(o0 o0Var) {
        throw new UnsupportedOperationException();
    }

    public void f(o0 o0Var) {
        throw new UnsupportedOperationException();
    }
}
