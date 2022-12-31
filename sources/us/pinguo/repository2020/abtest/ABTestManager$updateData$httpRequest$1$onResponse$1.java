package us.pinguo.repository2020.abtest;

import java.nio.charset.Charset;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.m0;
import org.json.JSONObject;
import us.pinguo.repository2020.utils.RequestIntervalPref;
import us.pinguo.user.u0;
import us.pinguo.util.FileIOUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ABTestManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.abtest.ABTestManager$updateData$httpRequest$1$onResponse$1", f = "ABTestManager.kt", i = {}, l = {200}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class ABTestManager$updateData$httpRequest$1$onResponse$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ String $response;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ABTestManager$updateData$httpRequest$1$onResponse$1(String str, Continuation<? super ABTestManager$updateData$httpRequest$1$onResponse$1> continuation) {
        super(2, continuation);
        this.$response = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new ABTestManager$updateData$httpRequest$1$onResponse$1(this.$response, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((ABTestManager$updateData$httpRequest$1$onResponse$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        String str;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            if (new JSONObject(this.$response).getInt("status") == 200) {
                ABTestManager.a.y(this.$response, true);
                str = ABTestManager.f11808d;
                String str2 = this.$response;
                Charset forName = Charset.forName("utf-8");
                s.g(forName, "forName(charsetName)");
                byte[] bytes = str2.getBytes(forName);
                s.g(bytes, "this as java.lang.String).getBytes(charset)");
                this.label = 1;
                if (FileIOUtils.i(str, bytes, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return u.a;
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            kotlin.j.b(obj);
        }
        RequestIntervalPref requestIntervalPref = RequestIntervalPref.a;
        String HOST_AB_TEST = u0.f12385g;
        s.g(HOST_AB_TEST, "HOST_AB_TEST");
        requestIntervalPref.d(HOST_AB_TEST, -1L, null);
        return u.a;
    }
}
