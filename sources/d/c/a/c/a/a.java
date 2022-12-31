package d.c.a.c.a;

import androidx.annotation.Nullable;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.p;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public final class a implements a.d {

    /* renamed from: j  reason: collision with root package name */
    public static final a f8500j = new a(false, false, null, false, null, null, false, null, null);
    private final boolean a = false;
    private final boolean b = false;
    private final String c = null;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f8501d = false;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f8504g = false;

    /* renamed from: e  reason: collision with root package name */
    private final String f8502e = null;

    /* renamed from: f  reason: collision with root package name */
    private final String f8503f = null;

    /* renamed from: h  reason: collision with root package name */
    private final Long f8505h = null;

    /* renamed from: i  reason: collision with root package name */
    private final Long f8506i = null;

    private a(boolean z, boolean z2, String str, boolean z3, String str2, String str3, boolean z4, Long l2, Long l3) {
    }

    @Nullable
    public final Long a() {
        return this.f8505h;
    }

    @Nullable
    public final String b() {
        return this.f8502e;
    }

    @Nullable
    public final String c() {
        return this.f8503f;
    }

    @Nullable
    public final Long d() {
        return this.f8506i;
    }

    public final String e() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return this.a == aVar.a && this.b == aVar.b && p.a(this.c, aVar.c) && this.f8501d == aVar.f8501d && this.f8504g == aVar.f8504g && p.a(this.f8502e, aVar.f8502e) && p.a(this.f8503f, aVar.f8503f) && p.a(this.f8505h, aVar.f8505h) && p.a(this.f8506i, aVar.f8506i);
        }
        return false;
    }

    public final boolean f() {
        return this.f8501d;
    }

    public final boolean g() {
        return this.b;
    }

    public final boolean h() {
        return this.a;
    }

    public final int hashCode() {
        return p.b(Boolean.valueOf(this.a), Boolean.valueOf(this.b), this.c, Boolean.valueOf(this.f8501d), Boolean.valueOf(this.f8504g), this.f8502e, this.f8503f, this.f8505h, this.f8506i);
    }

    public final boolean i() {
        return this.f8504g;
    }
}
