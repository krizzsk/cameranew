package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import androidx.collection.ArraySet;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public final class d {
    private final Account a;
    private final Set<Scope> b;
    private final Set<Scope> c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<com.google.android.gms.common.api.a<?>, b> f3663d;

    /* renamed from: e  reason: collision with root package name */
    private final View f3664e;

    /* renamed from: f  reason: collision with root package name */
    private final String f3665f;

    /* renamed from: g  reason: collision with root package name */
    private final String f3666g;

    /* renamed from: h  reason: collision with root package name */
    private final d.c.a.c.a.a f3667h;

    /* renamed from: i  reason: collision with root package name */
    private Integer f3668i;

    /* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
    /* loaded from: classes2.dex */
    public static final class a {
        private Account a;
        private ArraySet<Scope> b;
        private Map<com.google.android.gms.common.api.a<?>, b> c;

        /* renamed from: e  reason: collision with root package name */
        private View f3670e;

        /* renamed from: f  reason: collision with root package name */
        private String f3671f;

        /* renamed from: g  reason: collision with root package name */
        private String f3672g;

        /* renamed from: i  reason: collision with root package name */
        private boolean f3674i;

        /* renamed from: d  reason: collision with root package name */
        private int f3669d = 0;

        /* renamed from: h  reason: collision with root package name */
        private d.c.a.c.a.a f3673h = d.c.a.c.a.a.f8500j;

        public final a a(Collection<Scope> collection) {
            if (this.b == null) {
                this.b = new ArraySet<>();
            }
            this.b.addAll(collection);
            return this;
        }

        public final d b() {
            return new d(this.a, this.b, this.c, this.f3669d, this.f3670e, this.f3671f, this.f3672g, this.f3673h, this.f3674i);
        }

        public final a c(Account account) {
            this.a = account;
            return this;
        }

        public final a d(String str) {
            this.f3672g = str;
            return this;
        }

        public final a e(String str) {
            this.f3671f = str;
            return this;
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
    /* loaded from: classes2.dex */
    public static final class b {
        public final Set<Scope> a;
    }

    public d(Account account, Set<Scope> set, Map<com.google.android.gms.common.api.a<?>, b> map, int i2, View view, String str, String str2, d.c.a.c.a.a aVar, boolean z) {
        this.a = account;
        Set<Scope> emptySet = set == null ? Collections.emptySet() : Collections.unmodifiableSet(set);
        this.b = emptySet;
        map = map == null ? Collections.emptyMap() : map;
        this.f3663d = map;
        this.f3664e = view;
        this.f3665f = str;
        this.f3666g = str2;
        this.f3667h = aVar;
        HashSet hashSet = new HashSet(emptySet);
        for (b bVar : map.values()) {
            hashSet.addAll(bVar.a);
        }
        this.c = Collections.unmodifiableSet(hashSet);
    }

    public static d a(Context context) {
        return new GoogleApiClient.Builder(context).a();
    }

    @Nullable
    public final Account b() {
        return this.a;
    }

    public final Account c() {
        Account account = this.a;
        return account != null ? account : new Account(c.DEFAULT_ACCOUNT, "com.google");
    }

    public final Set<Scope> d() {
        return this.c;
    }

    @Nullable
    public final Integer e() {
        return this.f3668i;
    }

    @Nullable
    public final String f() {
        return this.f3666g;
    }

    @Nullable
    public final String g() {
        return this.f3665f;
    }

    public final Set<Scope> h() {
        return this.b;
    }

    @Nullable
    public final d.c.a.c.a.a i() {
        return this.f3667h;
    }

    public final void j(Integer num) {
        this.f3668i = num;
    }
}
