package us.pinguo.repository2020.manager;

import java.io.File;
import java.util.ArrayList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.m0;
import us.pinguo.repository2020.entity.SelfDefMakeup;
import us.pinguo.repository2020.entity.SelfDefMakeupResponse;
import us.pinguo.repository2020.network.HttpBaseResponse;
import us.pinguo.repository2020.utils.RequestIntervalPref;
import us.pinguo.util.FileIOUtils;
import us.pinguo.util.FileUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BeautyDataManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.manager.BeautyDataManager$loadSelfDefMakeupData$request$1$onResponse$1", f = "BeautyDataManager.kt", i = {0}, l = {282, 283}, m = "invokeSuspend", n = {"file"}, s = {"L$0"})
/* loaded from: classes6.dex */
public final class BeautyDataManager$loadSelfDefMakeupData$request$1$onResponse$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ HttpBaseResponse<SelfDefMakeupResponse> $httpBaseResponse;
    final /* synthetic */ boolean $isEnterCamera;
    final /* synthetic */ String $response;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BeautyDataManager$loadSelfDefMakeupData$request$1$onResponse$1(HttpBaseResponse<SelfDefMakeupResponse> httpBaseResponse, boolean z, String str, Continuation<? super BeautyDataManager$loadSelfDefMakeupData$request$1$onResponse$1> continuation) {
        super(2, continuation);
        this.$httpBaseResponse = httpBaseResponse;
        this.$isEnterCamera = z;
        this.$response = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new BeautyDataManager$loadSelfDefMakeupData$request$1$onResponse$1(this.$httpBaseResponse, this.$isEnterCamera, this.$response, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((BeautyDataManager$loadSelfDefMakeupData$request$1$onResponse$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        File file;
        Integer interval;
        String pid;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            ArrayList arrayList = new ArrayList();
            ArrayList<SelfDefMakeup> packages = this.$httpBaseResponse.getData().getPackages();
            int i3 = 0;
            if (packages != null) {
                for (SelfDefMakeup selfDefMakeup : packages) {
                    BeautyDataManager beautyDataManager = BeautyDataManager.a;
                    SelfDefMakeup selfDefMakeup2 = beautyDataManager.n().get(selfDefMakeup.getPid());
                    if (beautyDataManager.n().containsKey(selfDefMakeup.getPid())) {
                        if ((selfDefMakeup2 != null && selfDefMakeup2.isInstalled()) && !s.c(selfDefMakeup.getDown_url(), selfDefMakeup2.getDown_url()) && (pid = selfDefMakeup.getPid()) != null) {
                            Boxing.boxBoolean(arrayList.add(pid));
                        }
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                us.pinguo.repository2020.database.a.a().z().c(arrayList);
            }
            RequestIntervalPref requestIntervalPref = RequestIntervalPref.a;
            boolean z = this.$isEnterCamera;
            SelfDefMakeupResponse o = BeautyDataManager.a.o();
            if (o != null && (interval = o.getInterval()) != null) {
                i3 = interval.intValue();
            }
            requestIntervalPref.d("/api/product/unity-makeup", i3 * 1000, null);
            file = new File(this.$isEnterCamera ? BeautyDataManager.f11899j : BeautyDataManager.f11901l);
            file.delete();
            this.L$0 = file;
            this.label = 1;
            if (FileUtils.g(file, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 == 1) {
            file = (File) this.L$0;
            kotlin.j.b(obj);
        } else {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.j.b(obj);
            return u.a;
        }
        String str = this.$response;
        this.L$0 = null;
        this.label = 2;
        if (FileIOUtils.o(file, str, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return u.a;
    }
}
