package us.pinguo.edit2020.activity;

import androidx.fragment.app.FragmentTransaction;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.tapjoy.TapjoyConstants;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.fragment.StickerStoreListFragment;
/* compiled from: StickerStoreActivity.kt */
/* loaded from: classes4.dex */
final class StickerStoreActivity$onCreate$1 extends Lambda implements l<FragmentTransaction, u> {
    final /* synthetic */ StickerStoreActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerStoreActivity$onCreate$1(StickerStoreActivity stickerStoreActivity) {
        super(1);
        this.this$0 = stickerStoreActivity;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ u invoke(FragmentTransaction fragmentTransaction) {
        invoke2(fragmentTransaction);
        return u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(FragmentTransaction it) {
        StickerStoreListFragment stickerStoreListFragment;
        StickerStoreListFragment stickerStoreListFragment2;
        s.h(it, "it");
        StickerStoreActivity stickerStoreActivity = this.this$0;
        stickerStoreActivity.b = (StickerStoreListFragment) stickerStoreActivity.getSupportFragmentManager().findFragmentByTag(TapjoyConstants.TJC_STORE);
        stickerStoreListFragment = this.this$0.b;
        if (stickerStoreListFragment == null) {
            this.this$0.b = new StickerStoreListFragment();
        }
        int i2 = R.id.flContainer;
        stickerStoreListFragment2 = this.this$0.b;
        s.e(stickerStoreListFragment2);
        VdsAgent.onFragmentTransactionAdd(it, i2, stickerStoreListFragment2, it.add(i2, stickerStoreListFragment2));
    }
}
