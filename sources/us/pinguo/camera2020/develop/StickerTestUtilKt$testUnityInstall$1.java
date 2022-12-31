package us.pinguo.camera2020.develop;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.i;
import kotlin.j;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.m0;
import us.pinguo.util.FileUtils;
/* compiled from: StickerTestUtil.kt */
@DebugMetadata(c = "us.pinguo.camera2020.develop.StickerTestUtilKt$testUnityInstall$1", f = "StickerTestUtil.kt", i = {0}, l = {276}, m = "invokeSuspend", n = {"stickerDir"}, s = {"L$0"})
/* loaded from: classes2.dex */
final class StickerTestUtilKt$testUnityInstall$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ String $path;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StickerTestUtilKt$testUnityInstall$1(String str, Continuation<? super StickerTestUtilKt$testUnityInstall$1> continuation) {
        super(2, continuation);
        this.$path = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new StickerTestUtilKt$testUnityInstall$1(this.$path, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((StickerTestUtilKt$testUnityInstall$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        File file;
        File[] listFiles;
        List<d> g2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            j.b(obj);
            String str = this.$path;
            if (str == null) {
                str = StickerTestUtilKt.h();
            }
            File file2 = new File(s.q(str, "sticker/"));
            this.L$0 = file2;
            this.label = 1;
            obj = FileUtils.n(file2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            file = file2;
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            file = (File) this.L$0;
            j.b(obj);
        }
        if (((Boolean) obj).booleanValue() && (listFiles = file.listFiles()) != null) {
            if (listFiles.length == 0) {
                return u.a;
            }
            StickerTestUtilKt.i().clear();
            StickerTestUtilKt.e().clear();
            StickerTestUtilKt.f().clear();
            int length = listFiles.length;
            for (int i3 = 0; i3 < length; i3++) {
                File file3 = listFiles[i3];
                ArrayList<String> i4 = StickerTestUtilKt.i();
                String c = file3 == null ? null : i.c(file3);
                if (c != null) {
                    i4.add(c);
                    ArrayList<String> e2 = StickerTestUtilKt.e();
                    String absolutePath = file3.getAbsolutePath();
                    if (absolutePath != null) {
                        e2.add(absolutePath);
                        StickerTestUtilKt.f().add(Boxing.boxBoolean(true));
                    }
                }
            }
            g2 = StickerTestUtilKt.g(StickerTestUtilKt.i(), StickerTestUtilKt.e(), StickerTestUtilKt.f());
            for (d dVar : g2) {
                StickerTestUtilKt.j(dVar);
            }
            return u.a;
        }
        return u.a;
    }
}
