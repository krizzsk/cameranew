package us.pinguo.picker.image;

import java.util.concurrent.ThreadPoolExecutor;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.foundation.utils.AsyncTask;
/* compiled from: PuzzleTask.kt */
/* loaded from: classes5.dex */
public final class PuzzleTask {
    public static final PuzzleTask a = new PuzzleTask();
    private static final kotlin.f b;

    /* compiled from: PuzzleTask.kt */
    /* loaded from: classes5.dex */
    public static final class a extends AsyncTask<u, u, T> {
        final /* synthetic */ kotlin.jvm.b.a<T> a;
        final /* synthetic */ l<T, u> b;

        /* JADX WARN: Multi-variable type inference failed */
        a(kotlin.jvm.b.a<? extends T> aVar, l<? super T, u> lVar) {
            this.a = aVar;
            this.b = lVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v2, types: [T, java.lang.Object] */
        @Override // us.pinguo.foundation.utils.AsyncTask
        /* renamed from: a */
        public T doInBackground(u... params) {
            s.h(params, "params");
            return this.a.invoke();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // us.pinguo.foundation.utils.AsyncTask
        public void onPostExecute(T t) {
            this.b.invoke(t);
        }
    }

    static {
        kotlin.f b2;
        b2 = kotlin.h.b(PuzzleTask$EXECUTORS_PICK_TASK$2.INSTANCE);
        b = b2;
    }

    private PuzzleTask() {
    }

    public final <T> void a(kotlin.jvm.b.a<? extends T> background, l<? super T, u> post) {
        s.h(background, "background");
        s.h(post, "post");
        new a(background, post).executeOnExecutor(b(), new u[0]);
    }

    public final ThreadPoolExecutor b() {
        return (ThreadPoolExecutor) b.getValue();
    }
}
