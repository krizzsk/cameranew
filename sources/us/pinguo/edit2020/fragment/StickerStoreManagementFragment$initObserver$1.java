package us.pinguo.edit2020.fragment;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import us.pinguo.edit2020.R;
import us.pinguo.repository2020.database.staticsticker.StaticSticker;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StickerStoreManagementFragment.kt */
@DebugMetadata(c = "us.pinguo.edit2020.fragment.StickerStoreManagementFragment$initObserver$1", f = "StickerStoreManagementFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class StickerStoreManagementFragment$initObserver$1 extends SuspendLambda implements kotlin.jvm.b.p<List<StaticSticker>, Continuation<? super kotlin.u>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ StickerStoreManagementFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerStoreManagementFragment$initObserver$1(StickerStoreManagementFragment stickerStoreManagementFragment, Continuation<? super StickerStoreManagementFragment$initObserver$1> continuation) {
        super(2, continuation);
        this.this$0 = stickerStoreManagementFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        StickerStoreManagementFragment$initObserver$1 stickerStoreManagementFragment$initObserver$1 = new StickerStoreManagementFragment$initObserver$1(this.this$0, continuation);
        stickerStoreManagementFragment$initObserver$1.L$0 = obj;
        return stickerStoreManagementFragment$initObserver$1;
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(List<StaticSticker> list, Continuation<? super kotlin.u> continuation) {
        return ((StickerStoreManagementFragment$initObserver$1) create(list, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        us.pinguo.edit2020.adapter.q0 q0Var;
        us.pinguo.edit2020.adapter.q0 q0Var2;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            kotlin.j.b(obj);
            List list = (List) this.L$0;
            RecyclerView recyclerView = (RecyclerView) this.this$0._$_findCachedViewById(R.id.recyclerView);
            StickerStoreManagementFragment stickerStoreManagementFragment = this.this$0;
            recyclerView.setLayoutManager(new GridLayoutManager(stickerStoreManagementFragment.requireContext(), 4));
            us.pinguo.edit2020.utils.e eVar = new us.pinguo.edit2020.utils.e(us.pinguo.common.widget.i.a.a(Boxing.boxInt(4)), true);
            eVar.a(0);
            recyclerView.addItemDecoration(eVar);
            stickerStoreManagementFragment.f10527d = new us.pinguo.edit2020.adapter.q0(new StickerStoreManagementFragment$initObserver$1$1$2(stickerStoreManagementFragment));
            q0Var = stickerStoreManagementFragment.f10527d;
            if (q0Var != null) {
                q0Var.submitList(list);
                q0Var2 = stickerStoreManagementFragment.f10527d;
                if (q0Var2 != null) {
                    recyclerView.setAdapter(q0Var2);
                    return kotlin.u.a;
                }
                kotlin.jvm.internal.s.z("stickerAdapter");
                throw null;
            }
            kotlin.jvm.internal.s.z("stickerAdapter");
            throw null;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
