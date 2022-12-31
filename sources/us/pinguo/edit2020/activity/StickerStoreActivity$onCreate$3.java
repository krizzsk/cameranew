package us.pinguo.edit2020.activity;

import androidx.fragment.app.FragmentTransaction;
import com.growingio.android.sdk.autoburry.VdsAgent;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.fragment.StickerStoreDetailFragment;
/* compiled from: StickerStoreActivity.kt */
/* loaded from: classes4.dex */
final class StickerStoreActivity$onCreate$3 extends Lambda implements l<FragmentTransaction, u> {
    final /* synthetic */ String $pid;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerStoreActivity$onCreate$3(String str) {
        super(1);
        this.$pid = str;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ u invoke(FragmentTransaction fragmentTransaction) {
        invoke2(fragmentTransaction);
        return u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(FragmentTransaction it) {
        s.h(it, "it");
        it.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        int i2 = R.id.flContainer;
        StickerStoreDetailFragment a = StickerStoreDetailFragment.f10517k.a(this.$pid);
        VdsAgent.onFragmentTransactionAdd(it, i2, a, it.add(i2, a));
    }
}
