package us.pinguo.repository2020.manager;

import com.pinguo.lib.GsonUtilKt;
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
import us.pinguo.repository2020.entity.BackgroundBlur;
import us.pinguo.repository2020.entity.BackgroundBlurMaterial;
import us.pinguo.repository2020.entity.BlurResponse;
import us.pinguo.repository2020.network.HttpBaseResponse;
import us.pinguo.repository2020.utils.RequestIntervalPref;
import us.pinguo.util.FileIOUtils;
import us.pinguo.util.FileUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackgroundBlurDataManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.manager.BackgroundBlurDataManager$fetchBlurFromServer$request$1$onResponse$1", f = "BackgroundBlurDataManager.kt", i = {0}, l = {150, 151}, m = "invokeSuspend", n = {"file"}, s = {"L$0"})
/* loaded from: classes6.dex */
public final class BackgroundBlurDataManager$fetchBlurFromServer$request$1$onResponse$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ String $response;
    Object L$0;
    int label;

    /* compiled from: BackgroundBlurDataManager.kt */
    /* loaded from: classes6.dex */
    public static final class a extends com.google.gson.t.a<HttpBaseResponse<BlurResponse>> {
        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundBlurDataManager$fetchBlurFromServer$request$1$onResponse$1(String str, Continuation<? super BackgroundBlurDataManager$fetchBlurFromServer$request$1$onResponse$1> continuation) {
        super(2, continuation);
        this.$response = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new BackgroundBlurDataManager$fetchBlurFromServer$request$1$onResponse$1(this.$response, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((BackgroundBlurDataManager$fetchBlurFromServer$request$1$onResponse$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Integer interval;
        File file;
        String str;
        String pid;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            try {
                HttpBaseResponse httpBaseResponse = (HttpBaseResponse) GsonUtilKt.getCachedGson().k(this.$response, new a().getType());
                if (httpBaseResponse == null) {
                    return u.a;
                }
                List<BackgroundBlur> packages = ((BlurResponse) httpBaseResponse.getData()).getPackages();
                if (packages == null || packages.isEmpty()) {
                    return u.a;
                }
                RequestIntervalPref requestIntervalPref = RequestIntervalPref.a;
                BlurResponse l2 = BackgroundBlurDataManager.a.l();
                requestIntervalPref.d("/api/product/unity-blur", ((l2 == null || (interval = l2.getInterval()) == null) ? 0 : interval.intValue()) * 1000, null);
                ArrayList arrayList = new ArrayList();
                List<BackgroundBlur> packages2 = ((BlurResponse) httpBaseResponse.getData()).getPackages();
                if (packages2 != null) {
                    for (BackgroundBlur backgroundBlur : packages2) {
                        BackgroundBlurDataManager backgroundBlurDataManager = BackgroundBlurDataManager.a;
                        BackgroundBlurMaterial backgroundBlurMaterial = backgroundBlurDataManager.k().get(backgroundBlur.getPid());
                        if (backgroundBlurDataManager.k().containsKey(backgroundBlur.getPid())) {
                            if ((backgroundBlurMaterial != null && backgroundBlurMaterial.isInstalled()) && !s.c(backgroundBlur.getDown_url(), backgroundBlurMaterial.getDown_url()) && (pid = backgroundBlur.getPid()) != null) {
                                Boxing.boxBoolean(arrayList.add(pid));
                            }
                        }
                    }
                }
                if (!arrayList.isEmpty()) {
                    us.pinguo.repository2020.database.a.a().u().b(arrayList);
                }
                str = BackgroundBlurDataManager.f11886d;
                file = new File(str);
                file.delete();
                this.L$0 = file;
                this.label = 1;
                if (FileUtils.g(file, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return u.a;
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
