package us.pinguo.edit2020.activity;

import androidx.fragment.app.FragmentTransaction;
import com.growingio.android.sdk.autoburry.VdsAgent;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.fragment.StickerStoreManagementFragment;
/* compiled from: StickerStoreActivity.kt */
/* loaded from: classes4.dex */
final class StickerStoreActivity$onCreate$2 extends Lambda implements l<FragmentTransaction, u> {
    public static final StickerStoreActivity$onCreate$2 INSTANCE = new StickerStoreActivity$onCreate$2();

    StickerStoreActivity$onCreate$2() {
        super(1);
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
        StickerStoreManagementFragment stickerStoreManagementFragment = new StickerStoreManagementFragment();
        VdsAgent.onFragmentTransactionAdd(it, i2, stickerStoreManagementFragment, it.add(i2, stickerStoreManagementFragment));
    }
}
