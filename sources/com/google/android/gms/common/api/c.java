package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.api.internal.f;
import com.google.android.gms.common.api.internal.j0;
import com.google.android.gms.common.api.internal.o;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.q;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Set;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public class c<O extends a.d> implements d<O> {
    private final Context a;
    private final com.google.android.gms.common.api.a<O> b;
    private final O c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.android.gms.common.api.internal.b<O> f3600d;

    /* renamed from: e  reason: collision with root package name */
    private final Looper f3601e;

    /* renamed from: f  reason: collision with root package name */
    private final int f3602f;

    /* renamed from: g  reason: collision with root package name */
    protected final com.google.android.gms.common.api.internal.f f3603g;

    /* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
    /* loaded from: classes2.dex */
    public static class a {
        public final o a;
        public final Looper b;

        /* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
        /* renamed from: com.google.android.gms.common.api.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0136a {
            private o a;
            private Looper b;

            public a a() {
                if (this.a == null) {
                    this.a = new com.google.android.gms.common.api.internal.a();
                }
                if (this.b == null) {
                    this.b = Looper.getMainLooper();
                }
                return new a(this.a, this.b);
            }

            public C0136a b(o oVar) {
                q.k(oVar, "StatusExceptionMapper must not be null.");
                this.a = oVar;
                return this;
            }
        }

        static {
            new C0136a().a();
        }

        private a(o oVar, Account account, Looper looper) {
            this.a = oVar;
            this.b = looper;
        }
    }

    public c(@NonNull Context context, com.google.android.gms.common.api.a<O> aVar, @Nullable O o, a aVar2) {
        q.k(context, "Null context is not permitted.");
        q.k(aVar, "Api must not be null.");
        q.k(aVar2, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        j(context);
        this.b = aVar;
        this.c = o;
        this.f3601e = aVar2.b;
        this.f3600d = com.google.android.gms.common.api.internal.b.b(aVar, o);
        com.google.android.gms.common.api.internal.f f2 = com.google.android.gms.common.api.internal.f.f(applicationContext);
        this.f3603g = f2;
        this.f3602f = f2.h();
        o oVar = aVar2.a;
        f2.c(this);
    }

    private final <A extends a.b, T extends com.google.android.gms.common.api.internal.c<? extends g, A>> T h(int i2, @NonNull T t) {
        t.zas();
        this.f3603g.d(this, i2, t);
        return t;
    }

    private static String j(Object obj) {
        if (com.google.android.gms.common.util.o.n()) {
            try {
                return (String) Context.class.getMethod("getFeatureId", new Class[0]).invoke(obj, new Object[0]);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return null;
            }
        }
        return null;
    }

    @Override // com.google.android.gms.common.api.d
    public com.google.android.gms.common.api.internal.b<O> a() {
        return this.f3600d;
    }

    protected d.a b() {
        Account y;
        Set<Scope> emptySet;
        GoogleSignInAccount x;
        GoogleSignInAccount x2;
        d.a aVar = new d.a();
        O o = this.c;
        if ((o instanceof a.d.b) && (x2 = ((a.d.b) o).x()) != null) {
            y = x2.y();
        } else {
            O o2 = this.c;
            y = o2 instanceof a.d.InterfaceC0135a ? ((a.d.InterfaceC0135a) o2).y() : null;
        }
        aVar.c(y);
        O o3 = this.c;
        if ((o3 instanceof a.d.b) && (x = ((a.d.b) o3).x()) != null) {
            emptySet = x.X();
        } else {
            emptySet = Collections.emptySet();
        }
        aVar.a(emptySet);
        aVar.d(this.a.getClass().getName());
        aVar.e(this.a.getPackageName());
        return aVar;
    }

    public <A extends a.b, T extends com.google.android.gms.common.api.internal.c<? extends g, A>> T c(@NonNull T t) {
        h(0, t);
        return t;
    }

    public <A extends a.b, T extends com.google.android.gms.common.api.internal.c<? extends g, A>> T d(@NonNull T t) {
        h(1, t);
        return t;
    }

    public final int e() {
        return this.f3602f;
    }

    public Looper f() {
        return this.f3601e;
    }

    /* JADX WARN: Type inference failed for: r9v1, types: [com.google.android.gms.common.api.a$f] */
    @WorkerThread
    public a.f g(Looper looper, f.a<O> aVar) {
        return this.b.c().a(this.a, looper, b().b(), this.c, aVar, aVar);
    }

    public j0 i(Context context, Handler handler) {
        return new j0(context, handler, b().b());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public c(@androidx.annotation.NonNull android.content.Context r2, com.google.android.gms.common.api.a<O> r3, @androidx.annotation.Nullable O r4, com.google.android.gms.common.api.internal.o r5) {
        /*
            r1 = this;
            com.google.android.gms.common.api.c$a$a r0 = new com.google.android.gms.common.api.c$a$a
            r0.<init>()
            r0.b(r5)
            com.google.android.gms.common.api.c$a r5 = r0.a()
            r1.<init>(r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.c.<init>(android.content.Context, com.google.android.gms.common.api.a, com.google.android.gms.common.api.a$d, com.google.android.gms.common.api.internal.o):void");
    }
}
