package d.c.a.c.a;

import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public final class b {
    private static final a.g<com.google.android.gms.signin.internal.a> a;
    private static final a.g<com.google.android.gms.signin.internal.a> b;
    public static final a.AbstractC0134a<com.google.android.gms.signin.internal.a, a> c;

    /* renamed from: d  reason: collision with root package name */
    private static final a.AbstractC0134a<com.google.android.gms.signin.internal.a, f> f8507d;

    /* renamed from: e  reason: collision with root package name */
    public static final com.google.android.gms.common.api.a<a> f8508e;

    static {
        a.g<com.google.android.gms.signin.internal.a> gVar = new a.g<>();
        a = gVar;
        a.g<com.google.android.gms.signin.internal.a> gVar2 = new a.g<>();
        b = gVar2;
        d dVar = new d();
        c = dVar;
        c cVar = new c();
        f8507d = cVar;
        new Scope("profile");
        new Scope(NotificationCompat.CATEGORY_EMAIL);
        f8508e = new com.google.android.gms.common.api.a<>("SignIn.API", dVar, gVar);
        new com.google.android.gms.common.api.a("SignIn.INTERNAL_API", cVar, gVar2);
    }
}
