package us.pinguo.repository2020.manager;

import com.pinguo.lib.GsonUtilKt;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.m0;
import us.pinguo.repository2020.entity.BackgroundBlur;
import us.pinguo.repository2020.entity.BlurResponse;
import us.pinguo.repository2020.entity.Material;
import us.pinguo.util.FileIOUtils;
import us.pinguo.util.FileUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackgroundBlurDataManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.manager.BackgroundBlurDataManager$writeBackgroundBlurCustomizeDataToFile$1", f = "BackgroundBlurDataManager.kt", i = {0, 0}, l = {165, 166}, m = "invokeSuspend", n = {"response", "file"}, s = {"L$0", "L$1"})
/* loaded from: classes6.dex */
public final class BackgroundBlurDataManager$writeBackgroundBlurCustomizeDataToFile$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BackgroundBlurDataManager$writeBackgroundBlurCustomizeDataToFile$1(Continuation<? super BackgroundBlurDataManager$writeBackgroundBlurCustomizeDataToFile$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new BackgroundBlurDataManager$writeBackgroundBlurCustomizeDataToFile$1(continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((BackgroundBlurDataManager$writeBackgroundBlurCustomizeDataToFile$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        List<BackgroundBlur> packages;
        ArrayList arrayList;
        File file;
        String str;
        String response;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            BlurResponse l2 = BackgroundBlurDataManager.a.l();
            if (l2 == null || (packages = l2.getPackages()) == null) {
                arrayList = null;
            } else {
                arrayList = new ArrayList();
                for (Object obj2 : packages) {
                    BackgroundBlur backgroundBlur = (BackgroundBlur) obj2;
                    if (!s.c(backgroundBlur.getPid(), Material.MATERIAL_CUSTOMIZATION) && backgroundBlur.isCustomizeItem()) {
                        arrayList.add(obj2);
                    }
                }
            }
            String s = GsonUtilKt.getCachedGson().s(arrayList);
            str = BackgroundBlurDataManager.f11887e;
            file = new File(str);
            file.delete();
            this.L$0 = s;
            this.L$1 = file;
            this.label = 1;
            if (FileUtils.g(file, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            response = s;
        } else if (i2 == 1) {
            file = (File) this.L$1;
            response = (String) this.L$0;
            kotlin.j.b(obj);
        } else {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.j.b(obj);
            return u.a;
        }
        s.g(response, "response");
        this.L$0 = null;
        this.L$1 = null;
        this.label = 2;
        if (FileIOUtils.o(file, response, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return u.a;
    }
}
