package us.pinguo.repository2020.manager;

import java.io.File;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.m0;
import us.pinguo.common.pgdownloader.download.DownloadListener;
import us.pinguo.common.pgdownloader.download.IDownloadTask;
import us.pinguo.common.pgdownloader.download.PGDownloadManger;
import us.pinguo.repository2020.q;
import us.pinguo.util.FileUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FilterInstallManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.manager.FilterInstallManager$executeDownLoad$2$1", f = "FilterInstallManager.kt", i = {}, l = {411}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class FilterInstallManager$executeDownLoad$2$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ Continuation<Boolean> $con;
    final /* synthetic */ String $fileDownloadAddress;
    final /* synthetic */ q $listener;
    final /* synthetic */ String $savePath;
    int label;

    /* compiled from: FilterInstallManager.kt */
    /* loaded from: classes6.dex */
    public static final class a implements DownloadListener {
        final /* synthetic */ Ref$BooleanRef a;
        final /* synthetic */ Continuation<Boolean> b;
        final /* synthetic */ q c;

        /* JADX WARN: Multi-variable type inference failed */
        a(Ref$BooleanRef ref$BooleanRef, Continuation<? super Boolean> continuation, q qVar) {
            this.a = ref$BooleanRef;
            this.b = continuation;
            this.c = qVar;
        }

        @Override // us.pinguo.common.pgdownloader.download.DownloadListener
        public void onComplete(IDownloadTask task) {
            s.h(task, "task");
            Ref$BooleanRef ref$BooleanRef = this.a;
            if (ref$BooleanRef.element) {
                return;
            }
            ref$BooleanRef.element = true;
            Continuation<Boolean> continuation = this.b;
            Result.a aVar = Result.Companion;
            continuation.resumeWith(Result.m41constructorimpl(Boolean.TRUE));
        }

        @Override // us.pinguo.common.pgdownloader.download.DownloadListener
        public void onError(IDownloadTask task, int i2) {
            s.h(task, "task");
            this.c.i(q.b.a());
            Ref$BooleanRef ref$BooleanRef = this.a;
            if (ref$BooleanRef.element) {
                return;
            }
            ref$BooleanRef.element = true;
            Continuation<Boolean> continuation = this.b;
            Result.a aVar = Result.Companion;
            continuation.resumeWith(Result.m41constructorimpl(Boolean.FALSE));
        }

        @Override // us.pinguo.common.pgdownloader.download.DownloadListener
        public void onPause(IDownloadTask task) {
            s.h(task, "task");
            this.c.i(q.b.a());
            Ref$BooleanRef ref$BooleanRef = this.a;
            if (ref$BooleanRef.element) {
                return;
            }
            ref$BooleanRef.element = true;
            Continuation<Boolean> continuation = this.b;
            Result.a aVar = Result.Companion;
            continuation.resumeWith(Result.m41constructorimpl(Boolean.FALSE));
        }

        @Override // us.pinguo.common.pgdownloader.download.DownloadListener
        public void onProgress(IDownloadTask task, int i2, int i3, int i4) {
            s.h(task, "task");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FilterInstallManager$executeDownLoad$2$1(String str, String str2, Continuation<? super Boolean> continuation, q qVar, Continuation<? super FilterInstallManager$executeDownLoad$2$1> continuation2) {
        super(2, continuation2);
        this.$savePath = str;
        this.$fileDownloadAddress = str2;
        this.$con = continuation;
        this.$listener = qVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new FilterInstallManager$executeDownLoad$2$1(this.$savePath, this.$fileDownloadAddress, this.$con, this.$listener, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((FilterInstallManager$executeDownLoad$2$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            String parent = new File(this.$savePath).getParent();
            this.label = 1;
            if (FileUtils.f(parent, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            kotlin.j.b(obj);
        }
        IDownloadTask create = PGDownloadManger.Companion.getInstance().create(this.$fileDownloadAddress, this.$savePath);
        create.setListener(new a(new Ref$BooleanRef(), this.$con, this.$listener));
        create.start();
        return u.a;
    }
}
