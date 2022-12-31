package us.pinguo.edit2020.fragment;

import java.util.List;
import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.viewmodel.StaticStickerStoreViewModel;
/* compiled from: StickerStoreManagementFragment.kt */
/* loaded from: classes4.dex */
final class StickerStoreManagementFragment$initObserver$1$1$2 extends Lambda implements kotlin.jvm.b.p<String, Integer, kotlin.u> {
    final /* synthetic */ StickerStoreManagementFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerStoreManagementFragment$initObserver$1$1$2(StickerStoreManagementFragment stickerStoreManagementFragment) {
        super(2);
        this.this$0 = stickerStoreManagementFragment;
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ kotlin.u invoke(String str, Integer num) {
        invoke(str, num.intValue());
        return kotlin.u.a;
    }

    public final void invoke(String pid, int i2) {
        StaticStickerStoreViewModel g0;
        List<String> e2;
        us.pinguo.edit2020.adapter.q0 q0Var;
        kotlin.jvm.internal.s.h(pid, "pid");
        this.this$0.c.add(pid);
        g0 = this.this$0.g0();
        e2 = kotlin.collections.t.e(pid);
        g0.h(e2);
        q0Var = this.this$0.f10527d;
        if (q0Var != null) {
            q0Var.g(i2);
        } else {
            kotlin.jvm.internal.s.z("stickerAdapter");
            throw null;
        }
    }
}
