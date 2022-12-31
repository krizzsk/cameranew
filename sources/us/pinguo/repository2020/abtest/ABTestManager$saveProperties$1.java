package us.pinguo.repository2020.abtest;

import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.m0;
import us.pinguo.util.FileUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ABTestManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.abtest.ABTestManager$saveProperties$1", f = "ABTestManager.kt", i = {}, l = {379, 380}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class ABTestManager$saveProperties$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ABTestManager$saveProperties$1(Continuation<? super ABTestManager$saveProperties$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new ABTestManager$saveProperties$1(continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((ABTestManager$saveProperties$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        String str;
        String str2;
        String str3;
        Properties properties;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        try {
        } catch (Exception e2) {
            Log.e("ABTestManager", s.q("save property failed==>", e2.getMessage()));
        }
        if (i2 == 0) {
            kotlin.j.b(obj);
            str = ABTestManager.b;
            this.label = 1;
            obj = FileUtils.o(str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 != 1) {
            if (i2 == 2) {
                kotlin.j.b(obj);
                str3 = ABTestManager.c;
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str3));
                properties = ABTestManager.f11810f;
                properties.store(bufferedOutputStream, "");
                u uVar = u.a;
                kotlin.io.b.a(bufferedOutputStream, null);
                return u.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            kotlin.j.b(obj);
        }
        if (!((Boolean) obj).booleanValue()) {
            str2 = ABTestManager.b;
            this.label = 2;
            if (FileUtils.f(str2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        str3 = ABTestManager.c;
        BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(str3));
        properties = ABTestManager.f11810f;
        properties.store(bufferedOutputStream2, "");
        u uVar2 = u.a;
        kotlin.io.b.a(bufferedOutputStream2, null);
        return u.a;
    }
}
