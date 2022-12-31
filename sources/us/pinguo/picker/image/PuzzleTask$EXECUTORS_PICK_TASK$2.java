package us.pinguo.picker.image;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Lambda;
/* compiled from: PuzzleTask.kt */
/* loaded from: classes5.dex */
final class PuzzleTask$EXECUTORS_PICK_TASK$2 extends Lambda implements kotlin.jvm.b.a<ThreadPoolExecutor> {
    public static final PuzzleTask$EXECUTORS_PICK_TASK$2 INSTANCE = new PuzzleTask$EXECUTORS_PICK_TASK$2();

    PuzzleTask$EXECUTORS_PICK_TASK$2() {
        super(0);
    }

    @Override // kotlin.jvm.b.a
    public final ThreadPoolExecutor invoke() {
        return new ThreadPoolExecutor(3, 10, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    }
}
