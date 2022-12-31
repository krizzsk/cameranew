package us.pinguo.repository2020;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.m0;
import us.pinguo.performance.entity.GpuLadderInfo;
import us.pinguo.performance.manager.PerformanceLevelManager;
import us.pinguo.repository2020.entity.GpuLadderResponse;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ServiceControlRepository.kt */
@DebugMetadata(c = "us.pinguo.repository2020.ServiceControlRepository$initServiceControlSwitch$2$onSuccess$1", f = "ServiceControlRepository.kt", i = {}, l = {98}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class ServiceControlRepository$initServiceControlSwitch$2$onSuccess$1 extends SuspendLambda implements kotlin.jvm.b.p<m0, Continuation<? super kotlin.u>, Object> {
    final /* synthetic */ GpuLadderResponse $gpuLadderResponse;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServiceControlRepository$initServiceControlSwitch$2$onSuccess$1(GpuLadderResponse gpuLadderResponse, Continuation<? super ServiceControlRepository$initServiceControlSwitch$2$onSuccess$1> continuation) {
        super(2, continuation);
        this.$gpuLadderResponse = gpuLadderResponse;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new ServiceControlRepository$initServiceControlSwitch$2$onSuccess$1(this.$gpuLadderResponse, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((ServiceControlRepository$initServiceControlSwitch$2$onSuccess$1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            PerformanceLevelManager performanceLevelManager = PerformanceLevelManager.a;
            GpuLadderResponse gpuLadderResponse = this.$gpuLadderResponse;
            GpuLadderInfo gpuLadderData = gpuLadderResponse == null ? null : gpuLadderResponse.getGpuLadderData();
            this.label = 1;
            obj = performanceLevelManager.l(gpuLadderData, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            kotlin.j.b(obj);
        }
        if (((Boolean) obj).booleanValue()) {
            us.pinguo.repository2020.utils.o.n(us.pinguo.repository2020.utils.o.a, "gpu_ladder_report_flag", false, null, 4, null);
        }
        return kotlin.u.a;
    }
}
