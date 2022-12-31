package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public class GoogleSignInOptions extends AbstractSafeParcelable implements a.d, ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR;
    public static final GoogleSignInOptions DEFAULT_GAMES_SIGN_IN;
    public static final GoogleSignInOptions DEFAULT_SIGN_IN;
    private static Comparator<Scope> zaag;
    public static final Scope zar = new Scope("profile");
    public static final Scope zas = new Scope(NotificationCompat.CATEGORY_EMAIL);
    public static final Scope zat = new Scope("openid");
    public static final Scope zau;
    public static final Scope zav;
    private final int versionCode;
    private final boolean zaaa;
    private String zaab;
    private String zaac;
    private ArrayList<GoogleSignInOptionsExtensionParcelable> zaad;
    private String zaae;
    private Map<Integer, GoogleSignInOptionsExtensionParcelable> zaaf;
    private final ArrayList<Scope> zaw;
    private Account zax;
    private boolean zay;
    private final boolean zaz;

    /* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
    /* loaded from: classes2.dex */
    public static final class a {
        private boolean b;
        private boolean c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f3568d;

        /* renamed from: e  reason: collision with root package name */
        private String f3569e;

        /* renamed from: f  reason: collision with root package name */
        private Account f3570f;

        /* renamed from: g  reason: collision with root package name */
        private String f3571g;

        /* renamed from: i  reason: collision with root package name */
        private String f3573i;
        private Set<Scope> a = new HashSet();

        /* renamed from: h  reason: collision with root package name */
        private Map<Integer, GoogleSignInOptionsExtensionParcelable> f3572h = new HashMap();

        public final GoogleSignInOptions a() {
            if (this.a.contains(GoogleSignInOptions.zav)) {
                Set<Scope> set = this.a;
                Scope scope = GoogleSignInOptions.zau;
                if (set.contains(scope)) {
                    this.a.remove(scope);
                }
            }
            if (this.f3568d && (this.f3570f == null || !this.a.isEmpty())) {
                b();
            }
            return new GoogleSignInOptions(3, new ArrayList(this.a), this.f3570f, this.f3568d, this.b, this.c, this.f3569e, this.f3571g, this.f3572h, this.f3573i, null);
        }

        public final a b() {
            this.a.add(GoogleSignInOptions.zat);
            return this;
        }

        public final a c() {
            this.a.add(GoogleSignInOptions.zar);
            return this;
        }

        public final a d(Scope scope, Scope... scopeArr) {
            this.a.add(scope);
            this.a.addAll(Arrays.asList(scopeArr));
            return this;
        }
    }

    static {
        Scope scope = new Scope("https://www.googleapis.com/auth/games_lite");
        zau = scope;
        zav = new Scope("https://www.googleapis.com/auth/games");
        a aVar = new a();
        aVar.b();
        aVar.c();
        DEFAULT_SIGN_IN = aVar.a();
        a aVar2 = new a();
        aVar2.d(scope, new Scope[0]);
        DEFAULT_GAMES_SIGN_IN = aVar2.a();
        CREATOR = new c();
        zaag = new b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GoogleSignInOptions(int i2, ArrayList<Scope> arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, ArrayList<GoogleSignInOptionsExtensionParcelable> arrayList2, String str3) {
        this(i2, arrayList, account, z, z2, z3, str, str2, X(arrayList2), str3);
    }

    private static Map<Integer, GoogleSignInOptionsExtensionParcelable> X(@Nullable List<GoogleSignInOptionsExtensionParcelable> list) {
        HashMap hashMap = new HashMap();
        if (list == null) {
            return hashMap;
        }
        for (GoogleSignInOptionsExtensionParcelable googleSignInOptionsExtensionParcelable : list) {
            hashMap.put(Integer.valueOf(googleSignInOptionsExtensionParcelable.Q()), googleSignInOptionsExtensionParcelable);
        }
        return hashMap;
    }

    public ArrayList<GoogleSignInOptionsExtensionParcelable> Q() {
        return this.zaad;
    }

    @Nullable
    public String R() {
        return this.zaae;
    }

    public ArrayList<Scope> S() {
        return new ArrayList<>(this.zaw);
    }

    public String T() {
        return this.zaab;
    }

    public boolean U() {
        return this.zaaa;
    }

    public boolean V() {
        return this.zay;
    }

    public boolean W() {
        return this.zaz;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0048, code lost:
        if (r1.equals(r4.y()) != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0067, code lost:
        if (r3.zaab.equals(r4.T()) != false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            com.google.android.gms.auth.api.signin.GoogleSignInOptions r4 = (com.google.android.gms.auth.api.signin.GoogleSignInOptions) r4     // Catch: java.lang.ClassCastException -> L8f
            java.util.ArrayList<com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable> r1 = r3.zaad     // Catch: java.lang.ClassCastException -> L8f
            int r1 = r1.size()     // Catch: java.lang.ClassCastException -> L8f
            if (r1 > 0) goto L8f
            java.util.ArrayList<com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable> r1 = r4.zaad     // Catch: java.lang.ClassCastException -> L8f
            int r1 = r1.size()     // Catch: java.lang.ClassCastException -> L8f
            if (r1 <= 0) goto L18
            goto L8f
        L18:
            java.util.ArrayList<com.google.android.gms.common.api.Scope> r1 = r3.zaw     // Catch: java.lang.ClassCastException -> L8f
            int r1 = r1.size()     // Catch: java.lang.ClassCastException -> L8f
            java.util.ArrayList r2 = r4.S()     // Catch: java.lang.ClassCastException -> L8f
            int r2 = r2.size()     // Catch: java.lang.ClassCastException -> L8f
            if (r1 != r2) goto L8f
            java.util.ArrayList<com.google.android.gms.common.api.Scope> r1 = r3.zaw     // Catch: java.lang.ClassCastException -> L8f
            java.util.ArrayList r2 = r4.S()     // Catch: java.lang.ClassCastException -> L8f
            boolean r1 = r1.containsAll(r2)     // Catch: java.lang.ClassCastException -> L8f
            if (r1 != 0) goto L35
            goto L8f
        L35:
            android.accounts.Account r1 = r3.zax     // Catch: java.lang.ClassCastException -> L8f
            if (r1 != 0) goto L40
            android.accounts.Account r1 = r4.y()     // Catch: java.lang.ClassCastException -> L8f
            if (r1 != 0) goto L8f
            goto L4a
        L40:
            android.accounts.Account r2 = r4.y()     // Catch: java.lang.ClassCastException -> L8f
            boolean r1 = r1.equals(r2)     // Catch: java.lang.ClassCastException -> L8f
            if (r1 == 0) goto L8f
        L4a:
            java.lang.String r1 = r3.zaab     // Catch: java.lang.ClassCastException -> L8f
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.ClassCastException -> L8f
            if (r1 == 0) goto L5d
            java.lang.String r1 = r4.T()     // Catch: java.lang.ClassCastException -> L8f
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.ClassCastException -> L8f
            if (r1 == 0) goto L8f
            goto L69
        L5d:
            java.lang.String r1 = r3.zaab     // Catch: java.lang.ClassCastException -> L8f
            java.lang.String r2 = r4.T()     // Catch: java.lang.ClassCastException -> L8f
            boolean r1 = r1.equals(r2)     // Catch: java.lang.ClassCastException -> L8f
            if (r1 == 0) goto L8f
        L69:
            boolean r1 = r3.zaaa     // Catch: java.lang.ClassCastException -> L8f
            boolean r2 = r4.U()     // Catch: java.lang.ClassCastException -> L8f
            if (r1 != r2) goto L8f
            boolean r1 = r3.zay     // Catch: java.lang.ClassCastException -> L8f
            boolean r2 = r4.V()     // Catch: java.lang.ClassCastException -> L8f
            if (r1 != r2) goto L8f
            boolean r1 = r3.zaz     // Catch: java.lang.ClassCastException -> L8f
            boolean r2 = r4.W()     // Catch: java.lang.ClassCastException -> L8f
            if (r1 != r2) goto L8f
            java.lang.String r1 = r3.zaae     // Catch: java.lang.ClassCastException -> L8f
            java.lang.String r4 = r4.R()     // Catch: java.lang.ClassCastException -> L8f
            boolean r4 = android.text.TextUtils.equals(r1, r4)     // Catch: java.lang.ClassCastException -> L8f
            if (r4 == 0) goto L8f
            r4 = 1
            return r4
        L8f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.GoogleSignInOptions.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        ArrayList arrayList = new ArrayList();
        ArrayList<Scope> arrayList2 = this.zaw;
        int size = arrayList2.size();
        int i2 = 0;
        while (i2 < size) {
            Scope scope = arrayList2.get(i2);
            i2++;
            arrayList.add(scope.Q());
        }
        Collections.sort(arrayList);
        com.google.android.gms.auth.api.signin.internal.a aVar = new com.google.android.gms.auth.api.signin.internal.a();
        aVar.a(arrayList);
        aVar.a(this.zax);
        aVar.a(this.zaab);
        aVar.c(this.zaaa);
        aVar.c(this.zay);
        aVar.c(this.zaz);
        aVar.a(this.zaae);
        return aVar.b();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 1, this.versionCode);
        com.google.android.gms.common.internal.safeparcel.a.z(parcel, 2, S(), false);
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 3, y(), i2, false);
        com.google.android.gms.common.internal.safeparcel.a.c(parcel, 4, V());
        com.google.android.gms.common.internal.safeparcel.a.c(parcel, 5, W());
        com.google.android.gms.common.internal.safeparcel.a.c(parcel, 6, U());
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 7, T(), false);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 8, this.zaac, false);
        com.google.android.gms.common.internal.safeparcel.a.z(parcel, 9, Q(), false);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 10, R(), false);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a2);
    }

    public Account y() {
        return this.zax;
    }

    private GoogleSignInOptions(int i2, ArrayList<Scope> arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, Map<Integer, GoogleSignInOptionsExtensionParcelable> map, String str3) {
        this.versionCode = i2;
        this.zaw = arrayList;
        this.zax = account;
        this.zay = z;
        this.zaz = z2;
        this.zaaa = z3;
        this.zaab = str;
        this.zaac = str2;
        this.zaad = new ArrayList<>(map.values());
        this.zaaf = map;
        this.zaae = str3;
    }

    /* synthetic */ GoogleSignInOptions(int i2, ArrayList arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, Map map, String str3, b bVar) {
        this(3, arrayList, account, z, z2, z3, str, str2, map, str3);
    }
}
