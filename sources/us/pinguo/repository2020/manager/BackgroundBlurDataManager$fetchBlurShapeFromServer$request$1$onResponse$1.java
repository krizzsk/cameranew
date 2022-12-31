package us.pinguo.repository2020.manager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.m0;
import us.pinguo.repository2020.entity.BackgroundBlurMaterial;
import us.pinguo.repository2020.entity.BackgroundBlurShape;
import us.pinguo.repository2020.entity.BlurShapeResponse;
import us.pinguo.repository2020.network.HttpBaseResponse;
import us.pinguo.repository2020.utils.RequestIntervalPref;
import us.pinguo.util.FileIOUtils;
import us.pinguo.util.FileUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackgroundBlurDataManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.manager.BackgroundBlurDataManager$fetchBlurShapeFromServer$request$1$onResponse$1", f = "BackgroundBlurDataManager.kt", i = {0}, l = {261, 262}, m = "invokeSuspend", n = {"file"}, s = {"L$0"})
/* loaded from: classes6.dex */
public final class BackgroundBlurDataManager$fetchBlurShapeFromServer$request$1$onResponse$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ HttpBaseResponse<BlurShapeResponse> $httpBaseResponse;
    final /* synthetic */ String $response;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundBlurDataManager$fetchBlurShapeFromServer$request$1$onResponse$1(HttpBaseResponse<BlurShapeResponse> httpBaseResponse, String str, Continuation<? super BackgroundBlurDataManager$fetchBlurShapeFromServer$request$1$onResponse$1> continuation) {
        super(2, continuation);
        this.$httpBaseResponse = httpBaseResponse;
        this.$response = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new BackgroundBlurDataManager$fetchBlurShapeFromServer$request$1$onResponse$1(this.$httpBaseResponse, this.$response, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((BackgroundBlurDataManager$fetchBlurShapeFromServer$request$1$onResponse$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        File file;
        String str;
        Integer interval;
        String pid;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            ArrayList arrayList = new ArrayList();
            List<BackgroundBlurShape> packages = this.$httpBaseResponse.getData().getPackages();
            int i3 = 0;
            if (packages != null) {
                for (BackgroundBlurShape backgroundBlurShape : packages) {
                    BackgroundBlurDataManager backgroundBlurDataManager = BackgroundBlurDataManager.a;
                    BackgroundBlurMaterial backgroundBlurMaterial = backgroundBlurDataManager.k().get(backgroundBlurShape.getPid());
                    if (backgroundBlurDataManager.k().containsKey(backgroundBlurShape.getPid())) {
                        if ((backgroundBlurMaterial != null && backgroundBlurMaterial.isInstalled()) && !s.c(backgroundBlurShape.getDown_url(), backgroundBlurMaterial.getDown_url()) && (pid = backgroundBlurShape.getPid()) != null) {
                            Boxing.boxBoolean(arrayList.add(pid));
                        }
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                us.pinguo.repository2020.database.a.a().u().b(arrayList);
            }
            RequestIntervalPref requestIntervalPref = RequestIntervalPref.a;
            BlurShapeResponse m = BackgroundBlurDataManager.a.m();
            if (m != null && (interval = m.getInterval()) != null) {
                i3 = interval.intValue();
            }
            requestIntervalPref.d("/api/product/unity-light", i3 * 1000, null);
            str = BackgroundBlurDataManager.f11888f;
            file = new File(str);
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
        String str2 = this.$response;
        this.L$0 = null;
        this.label = 2;
        if (FileIOUtils.o(file, str2, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return u.a;
    }
}
