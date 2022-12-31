package us.pinguo.edit2020.fragment;

import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.viewmodel.StaticStickerStoreViewModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StickerStoreDetailFragment.kt */
/* loaded from: classes4.dex */
public final class StickerStoreDetailFragment$initObserver$2$1$2 extends Lambda implements kotlin.jvm.b.a<kotlin.u> {
    final /* synthetic */ StickerStoreDetailFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerStoreDetailFragment$initObserver$2$1$2(StickerStoreDetailFragment stickerStoreDetailFragment) {
        super(0);
        this.this$0 = stickerStoreDetailFragment;
    }

    @Override // kotlin.jvm.b.a
    public /* bridge */ /* synthetic */ kotlin.u invoke() {
        invoke2();
        return kotlin.u.a;
    }

    @Override // kotlin.jvm.b.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StaticStickerStoreViewModel r0;
        StaticStickerStoreViewModel r02;
        String str;
        r0 = this.this$0.r0();
        r0.x(true);
        r02 = this.this$0.r0();
        str = this.this$0.b;
        r02.g(str);
    }
}
