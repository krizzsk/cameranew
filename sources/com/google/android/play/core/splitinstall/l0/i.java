package com.google.android.play.core.splitinstall.l0;

import com.google.android.play.core.splitinstall.v;
import java.util.List;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class i implements v {
    final /* synthetic */ List a;
    final /* synthetic */ List b;
    final /* synthetic */ long c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ boolean f4904d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ List f4905e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ a f4906f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar, List list, List list2, long j2, boolean z, List list3) {
        this.f4906f = aVar;
        this.a = list;
        this.b = list2;
        this.c = j2;
        this.f4904d = z;
        this.f4905e = list3;
    }

    @Override // com.google.android.play.core.splitinstall.v
    public final void a() {
        Set set;
        Set set2;
        set = this.f4906f.f4893j;
        set.addAll(this.a);
        set2 = this.f4906f.f4894k;
        set2.addAll(this.b);
        this.f4906f.q(5, 0, Long.valueOf(this.c), Long.valueOf(this.c), null, null, null);
    }

    @Override // com.google.android.play.core.splitinstall.v
    public final void a(int i2) {
        this.f4906f.p(i2);
    }

    @Override // com.google.android.play.core.splitinstall.v
    public final void b() {
        if (this.f4904d) {
            return;
        }
        this.f4906f.o(this.f4905e, this.a, this.b, this.c, true);
    }
}
