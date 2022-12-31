package us.pinguo.edit2020.fragment;

import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.viewmodel.StaticStickerStoreViewModel;
import us.pinguo.edit2020.viewmodel.d;
import us.pinguo.repository2020.database.staticsticker.StaticStickerCategory;
/* compiled from: StickerStoreFragment.kt */
/* loaded from: classes4.dex */
final class StickerStoreFragment$onViewCreated$1 extends Lambda implements kotlin.jvm.b.l<StaticStickerCategory, kotlin.u> {
    final /* synthetic */ StickerStoreFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerStoreFragment$onViewCreated$1(StickerStoreFragment stickerStoreFragment) {
        super(1);
        this.this$0 = stickerStoreFragment;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(StaticStickerCategory staticStickerCategory) {
        invoke2(staticStickerCategory);
        return kotlin.u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(StaticStickerCategory staticStickerCategory) {
        StaticStickerStoreViewModel f0;
        kotlin.jvm.internal.s.h(staticStickerCategory, "staticStickerCategory");
        us.pinguo.foundation.statistics.i iVar = us.pinguo.foundation.statistics.h.b;
        String pid = staticStickerCategory.getPid();
        if (pid == null) {
            pid = "";
        }
        iVar.P("sticker_package", pid, "click");
        f0 = this.this$0.f0();
        f0.v(new d.b(staticStickerCategory));
    }
}
