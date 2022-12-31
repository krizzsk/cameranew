package us.pinguo.camera2020.viewmodel;

import androidx.core.view.InputDeviceCompat;
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
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CameraViewModel.kt */
@DebugMetadata(c = "us.pinguo.camera2020.viewmodel.CameraViewModel$doUnityFilterRender$1$1", f = "CameraViewModel.kt", i = {}, l = {InputDeviceCompat.SOURCE_DPAD}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class CameraViewModel$doUnityFilterRender$1$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ FilterEntry $filterEntry;
    final /* synthetic */ String $filterPath;
    int label;
    final /* synthetic */ CameraViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraViewModel$doUnityFilterRender$1$1(CameraViewModel cameraViewModel, FilterEntry filterEntry, String str, Continuation<? super CameraViewModel$doUnityFilterRender$1$1> continuation) {
        super(2, continuation);
        this.this$0 = cameraViewModel;
        this.$filterEntry = filterEntry;
        this.$filterPath = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new CameraViewModel$doUnityFilterRender$1$1(this.this$0, this.$filterEntry, this.$filterPath, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((CameraViewModel$doUnityFilterRender$1$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            j.b(obj);
            CameraFilterModule cameraFilterModule = this.this$0.getCameraFilterModule();
            FilterEntry filterEntry = this.$filterEntry;
            this.label = 1;
            obj = cameraFilterModule.W(filterEntry, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            j.b(obj);
        }
        if (s.c(obj, Boxing.boxBoolean(true))) {
            this.this$0.unityRender.K(this.$filterPath);
        } else {
            this.this$0.unityRender.I(this.$filterPath);
        }
        return u.a;
    }
}
