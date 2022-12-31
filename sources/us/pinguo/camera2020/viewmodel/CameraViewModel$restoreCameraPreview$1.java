package us.pinguo.camera2020.viewmodel;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.j;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.m0;
import us.pinguo.common.filter.CameraFilterModule;
import us.pinguo.repository2020.entity.FilterEntry;
import us.pinguo.repository2020.manager.FilterRepository;
import us.pinguo.u3dengine.api.UnityMethodCaller;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CameraViewModel.kt */
@DebugMetadata(c = "us.pinguo.camera2020.viewmodel.CameraViewModel$restoreCameraPreview$1", f = "CameraViewModel.kt", i = {}, l = {470}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class CameraViewModel$restoreCameraPreview$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ FilterEntry $filterEntry;
    int label;
    final /* synthetic */ CameraViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraViewModel$restoreCameraPreview$1(FilterEntry filterEntry, CameraViewModel cameraViewModel, Continuation<? super CameraViewModel$restoreCameraPreview$1> continuation) {
        super(2, continuation);
        this.$filterEntry = filterEntry;
        this.this$0 = cameraViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new CameraViewModel$restoreCameraPreview$1(this.$filterEntry, this.this$0, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((CameraViewModel$restoreCameraPreview$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            j.b(obj);
            if (FilterRepository.a.u(this.$filterEntry.getPkgId()) == 1) {
                CameraFilterModule cameraFilterModule = this.this$0.getCameraFilterModule();
                FilterEntry filterEntry = this.$filterEntry;
                this.label = 1;
                obj = cameraFilterModule.W(filterEntry, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            UnityMethodCaller.setFilterInfo$default(UnityMethodCaller.FilterType.Local, null, 2, null);
            return u.a;
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            j.b(obj);
        }
        if (!s.c(obj, Boxing.boxBoolean(true))) {
            this.this$0.doUnityFilterRender(this.$filterEntry);
            return u.a;
        }
        UnityMethodCaller.setFilterInfo$default(UnityMethodCaller.FilterType.Local, null, 2, null);
        return u.a;
    }
}
