package us.pinguo.repository2020.abtest;

import android.util.Log;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Properties;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.m0;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ABTestManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.abtest.ABTestManager$loadProperties$1", f = "ABTestManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class ABTestManager$loadProperties$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ABTestManager$loadProperties$1(Continuation<? super ABTestManager$loadProperties$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new ABTestManager$loadProperties$1(continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((ABTestManager$loadProperties$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        Properties properties;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            kotlin.j.b(obj);
            try {
                str = ABTestManager.c;
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
                properties = ABTestManager.f11810f;
                properties.load(bufferedInputStream);
                u uVar = u.a;
                kotlin.io.b.a(bufferedInputStream, null);
            } catch (Exception e2) {
                Log.e("ABTestManager", s.q("读取property 失败==>", e2.getMessage()));
            }
            return u.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
