package us.pinguo.edit2020.fragment;

import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.facebook.appevents.AppEventsLogger;
import com.growingio.android.sdk.autoburry.VdsAgent;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AIEditFragment.kt */
/* loaded from: classes4.dex */
public final class AIEditFragment$doSaveAction$1 extends Lambda implements kotlin.jvm.b.l<String, kotlin.u> {
    final /* synthetic */ kotlin.jvm.b.l<String, kotlin.u> $save;
    final /* synthetic */ AIEditFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AIEditFragment.kt */
    @DebugMetadata(c = "us.pinguo.edit2020.fragment.AIEditFragment$doSaveAction$1$1", f = "AIEditFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.edit2020.fragment.AIEditFragment$doSaveAction$1$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
        int label;
        final /* synthetic */ AIEditFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(AIEditFragment aIEditFragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = aIEditFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
            return ((AnonymousClass1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            boolean z;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                kotlin.j.b(obj);
                this.this$0.q0();
                z = this.this$0.f10508d;
                if (z) {
                    boolean z2 = false;
                    Toast makeText = Toast.makeText(us.pinguo.util.v.a(), R.string.pic_save_success, 0);
                    makeText.show();
                    VdsAgent.showToast(makeText);
                    FragmentActivity activity = this.this$0.getActivity();
                    if (activity != null && !activity.isFinishing()) {
                        z2 = true;
                    }
                    if (z2) {
                        this.this$0.l0();
                    }
                }
                return kotlin.u.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AIEditFragment$doSaveAction$1(AIEditFragment aIEditFragment, kotlin.jvm.b.l<? super String, kotlin.u> lVar) {
        super(1);
        this.this$0 = aIEditFragment;
        this.$save = lVar;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(String str) {
        invoke2(str);
        return kotlin.u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        LifecycleCoroutineScope j0;
        j0 = this.this$0.j0();
        if (j0 != null) {
            kotlinx.coroutines.l.d(j0, kotlinx.coroutines.z0.c(), null, new AnonymousClass1(this.this$0, null), 2, null);
        }
        us.pinguo.foundation.statistics.h.a.h("save");
        AppEventsLogger.i(us.pinguo.foundation.e.b()).g("active");
        kotlin.jvm.b.l<String, kotlin.u> lVar = this.$save;
        if (lVar == null) {
            return;
        }
        lVar.invoke(str);
    }
}
