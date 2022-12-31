package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import com.growingio.android.sdk.deeplink.DeeplinkCallback;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.j;
import kotlin.jvm.b.p;
import kotlin.sequences.g;
import kotlin.u;
/* compiled from: View.kt */
@DebugMetadata(c = "androidx.core.view.ViewKt$allViews$1", f = "View.kt", i = {0}, l = {DeeplinkCallback.ERROR_APP_NOT_ACCEPT, DeeplinkCallback.ERROR_TIMEOUT}, m = "invokeSuspend", n = {"$this$sequence"}, s = {"L$0"})
/* loaded from: classes.dex */
final class ViewKt$allViews$1 extends RestrictedSuspendLambda implements p<g<? super View>, Continuation<? super u>, Object> {
    final /* synthetic */ View $this_allViews;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewKt$allViews$1(View view, Continuation<? super ViewKt$allViews$1> continuation) {
        super(2, continuation);
        this.$this_allViews = view;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        ViewKt$allViews$1 viewKt$allViews$1 = new ViewKt$allViews$1(this.$this_allViews, continuation);
        viewKt$allViews$1.L$0 = obj;
        return viewKt$allViews$1;
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(g<? super View> gVar, Continuation<? super u> continuation) {
        return ((ViewKt$allViews$1) create(gVar, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        g gVar;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            j.b(obj);
            gVar = (g) this.L$0;
            View view = this.$this_allViews;
            this.L$0 = gVar;
            this.label = 1;
            if (gVar.a(view, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j.b(obj);
            return u.a;
        } else {
            gVar = (g) this.L$0;
            j.b(obj);
        }
        View view2 = this.$this_allViews;
        if (view2 instanceof ViewGroup) {
            kotlin.sequences.e<View> descendants = ViewGroupKt.getDescendants((ViewGroup) view2);
            this.L$0 = null;
            this.label = 2;
            if (gVar.d(descendants, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return u.a;
    }
}
