package us.pinguo.edit2020.fragment;

import android.widget.TextView;
import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.viewmodel.StaticStickerStoreViewModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StickerStoreDetailFragment.kt */
/* loaded from: classes4.dex */
public final class StickerStoreDetailFragment$initObserver$2$1$1 extends Lambda implements kotlin.jvm.b.l<Boolean, kotlin.u> {
    final /* synthetic */ StickerStoreDetailFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerStoreDetailFragment$initObserver$2$1$1(StickerStoreDetailFragment stickerStoreDetailFragment) {
        super(1);
        this.this$0 = stickerStoreDetailFragment;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return kotlin.u.a;
    }

    public final void invoke(boolean z) {
        StaticStickerStoreViewModel r0;
        if (z) {
            this.this$0.f10524j = true;
            r0 = this.this$0.r0();
            r0.w();
            this.this$0.f10519e = StickerDownloadType.Downloaded;
            ((TextView) this.this$0._$_findCachedViewById(R.id.tvStickerStatus)).setText(us.pinguo.edit2020.utils.d.k(R.string.str_use));
        }
        this.this$0.B0(-100);
        this.this$0.A0(null);
    }
}
