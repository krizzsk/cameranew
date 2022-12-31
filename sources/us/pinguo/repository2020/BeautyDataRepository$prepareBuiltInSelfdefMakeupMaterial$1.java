package us.pinguo.repository2020;

import android.content.Context;
import java.io.File;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.m0;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BeautyDataRepository.kt */
@DebugMetadata(c = "us.pinguo.repository2020.BeautyDataRepository$prepareBuiltInSelfdefMakeupMaterial$1", f = "BeautyDataRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class BeautyDataRepository$prepareBuiltInSelfdefMakeupMaterial$1 extends SuspendLambda implements kotlin.jvm.b.p<m0, Continuation<? super kotlin.u>, Object> {
    int label;
    final /* synthetic */ BeautyDataRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BeautyDataRepository$prepareBuiltInSelfdefMakeupMaterial$1(BeautyDataRepository beautyDataRepository, Continuation<? super BeautyDataRepository$prepareBuiltInSelfdefMakeupMaterial$1> continuation) {
        super(2, continuation);
        this.this$0 = beautyDataRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new BeautyDataRepository$prepareBuiltInSelfdefMakeupMaterial$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((BeautyDataRepository$prepareBuiltInSelfdefMakeupMaterial$1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        String str2;
        String str3;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            kotlin.j.b(obj);
            str = this.this$0.a;
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            str2 = this.this$0.a;
            String q = kotlin.jvm.internal.s.q(str2, "makeup.zip");
            us.pinguo.repository2020.utils.f fVar = us.pinguo.repository2020.utils.f.a;
            Context b = us.pinguo.foundation.e.b();
            kotlin.jvm.internal.s.g(b, "getAppContext()");
            if (fVar.a(b, "builtin_data/beauty/makeup.zip", q)) {
                try {
                    str3 = this.this$0.a;
                    us.pinguo.foundation.utils.m0.c(q, str3);
                    us.pinguo.repository2020.utils.o.n(us.pinguo.repository2020.utils.o.a, "is_selfdef_makeup_material_ready", true, null, 4, null);
                } catch (Exception unused) {
                    us.pinguo.repository2020.utils.o.n(us.pinguo.repository2020.utils.o.a, "is_selfdef_makeup_material_ready", false, null, 4, null);
                }
            }
            return kotlin.u.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
