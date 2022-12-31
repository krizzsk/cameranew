package us.pinguo.edit2020.manager;

import com.pinguo.lib.download.Config;
import com.pinguo.lib.download.listener.DownloadListener;
import java.io.File;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.j;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.m0;
import us.pinguo.repository2020.utils.o;
import us.pinguo.util.FileUtils;
/* compiled from: TutorialDownloadManager.kt */
@DebugMetadata(c = "us.pinguo.edit2020.manager.TutorialDownloadManager$downloadTutorial$realDownloadListener$1$onComplete$1", f = "TutorialDownloadManager.kt", i = {}, l = {59}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class TutorialDownloadManager$downloadTutorial$realDownloadListener$1$onComplete$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ DownloadListener $downloadListener;
    final /* synthetic */ Config $p0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TutorialDownloadManager$downloadTutorial$realDownloadListener$1$onComplete$1(DownloadListener downloadListener, Config config, Continuation<? super TutorialDownloadManager$downloadTutorial$realDownloadListener$1$onComplete$1> continuation) {
        super(2, continuation);
        this.$downloadListener = downloadListener;
        this.$p0 = config;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new TutorialDownloadManager$downloadTutorial$realDownloadListener$1$onComplete$1(this.$downloadListener, this.$p0, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((TutorialDownloadManager$downloadTutorial$realDownloadListener$1$onComplete$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        String str;
        h hVar;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        try {
        } catch (Exception e2) {
            us.pinguo.common.log.a.e(s.q("文件解压失败===>", e2.getMessage()), new Object[0]);
            DownloadListener downloadListener = this.$downloadListener;
            if (downloadListener != null) {
                downloadListener.onFailed(null, e2);
            }
        }
        if (i2 == 0) {
            j.b(obj);
            StringBuilder sb = new StringBuilder();
            sb.append(TutorialDownloadManager.a.f());
            sb.append('/');
            str = TutorialDownloadManager.c;
            sb.append(str);
            String sb2 = sb.toString();
            File file = new File(s.q(sb2, "/"));
            if (!file.exists()) {
                file.mkdir();
            }
            String q = s.q(sb2, ".zip");
            if (new File(q).exists()) {
                us.pinguo.foundation.utils.m0.c(q, s.q(sb2, "/"));
                this.label = 1;
                if (FileUtils.l(q, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return u.a;
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            j.b(obj);
        }
        o oVar = o.a;
        hVar = TutorialDownloadManager.b;
        o.v(oVar, "tutorial_option4", hVar.a(), null, 4, null);
        DownloadListener downloadListener2 = this.$downloadListener;
        if (downloadListener2 != null) {
            downloadListener2.onComplete(this.$p0);
        }
        return u.a;
    }
}
