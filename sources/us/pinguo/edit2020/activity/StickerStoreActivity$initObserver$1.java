package us.pinguo.edit2020.activity;

import androidx.fragment.app.FragmentTransaction;
import com.growingio.android.sdk.autoburry.VdsAgent;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.j;
import kotlin.jvm.b.l;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.fragment.StickerStoreDetailFragment;
import us.pinguo.edit2020.fragment.StickerStoreManagementFragment;
import us.pinguo.edit2020.viewmodel.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StickerStoreActivity.kt */
@DebugMetadata(c = "us.pinguo.edit2020.activity.StickerStoreActivity$initObserver$1", f = "StickerStoreActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class StickerStoreActivity$initObserver$1 extends SuspendLambda implements p<d, Continuation<? super u>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ StickerStoreActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StickerStoreActivity.kt */
    /* renamed from: us.pinguo.edit2020.activity.StickerStoreActivity$initObserver$1$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends Lambda implements l<FragmentTransaction, u> {
        final /* synthetic */ d $it;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(d dVar) {
            super(1);
            this.$it = dVar;
        }

        @Override // kotlin.jvm.b.l
        public /* bridge */ /* synthetic */ u invoke(FragmentTransaction fragmentTransaction) {
            invoke2(fragmentTransaction);
            return u.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(FragmentTransaction transition) {
            s.h(transition, "transition");
            transition.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            transition.addToBackStack("");
            int i2 = R.id.flContainer;
            StickerStoreDetailFragment.a aVar = StickerStoreDetailFragment.f10517k;
            String pid = ((d.b) this.$it).a().getPid();
            StickerStoreDetailFragment a = aVar.a(pid != null ? pid : "");
            VdsAgent.onFragmentTransactionAdd(transition, i2, a, transition.add(i2, a));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StickerStoreActivity.kt */
    /* renamed from: us.pinguo.edit2020.activity.StickerStoreActivity$initObserver$1$2  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass2 extends Lambda implements l<FragmentTransaction, u> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.b.l
        public /* bridge */ /* synthetic */ u invoke(FragmentTransaction fragmentTransaction) {
            invoke2(fragmentTransaction);
            return u.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(FragmentTransaction transition) {
            s.h(transition, "transition");
            transition.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            transition.addToBackStack("");
            int i2 = R.id.flContainer;
            StickerStoreManagementFragment stickerStoreManagementFragment = new StickerStoreManagementFragment();
            VdsAgent.onFragmentTransactionAdd(transition, i2, stickerStoreManagementFragment, transition.add(i2, stickerStoreManagementFragment));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerStoreActivity$initObserver$1(StickerStoreActivity stickerStoreActivity, Continuation<? super StickerStoreActivity$initObserver$1> continuation) {
        super(2, continuation);
        this.this$0 = stickerStoreActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        StickerStoreActivity$initObserver$1 stickerStoreActivity$initObserver$1 = new StickerStoreActivity$initObserver$1(this.this$0, continuation);
        stickerStoreActivity$initObserver$1.L$0 = obj;
        return stickerStoreActivity$initObserver$1;
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(d dVar, Continuation<? super u> continuation) {
        return ((StickerStoreActivity$initObserver$1) create(dVar, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            j.b(obj);
            d dVar = (d) this.L$0;
            if (dVar instanceof d.b) {
                this.this$0.t0(new AnonymousClass1(dVar));
            } else if (dVar instanceof d.a) {
                this.this$0.t0(AnonymousClass2.INSTANCE);
            } else if (dVar instanceof d.c) {
                if (this.this$0.getSupportFragmentManager().getBackStackEntryCount() >= 1) {
                    this.this$0.getSupportFragmentManager().popBackStack();
                } else {
                    this.this$0.finish();
                }
            }
            return u.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
