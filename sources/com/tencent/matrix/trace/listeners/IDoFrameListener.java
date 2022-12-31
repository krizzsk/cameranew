package com.tencent.matrix.trace.listeners;

import androidx.annotation.CallSuper;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;
/* loaded from: classes3.dex */
public class IDoFrameListener {
    private static final LinkedList<FrameReplay> sPool = new LinkedList<>();
    private Executor executor;
    private int intervalFrame;
    private final List<FrameReplay> list;
    public long time;

    /* loaded from: classes3.dex */
    public static final class FrameReplay {
        public long animationCostNs;
        public int dropFrame;
        public long endNs;
        public String focusedActivity;
        public long inputCostNs;
        public long intendedFrameTimeNs;
        public boolean isVsyncFrame;
        public long startNs;
        public long traversalCostNs;

        public static FrameReplay create() {
            FrameReplay frameReplay;
            synchronized (IDoFrameListener.sPool) {
                frameReplay = (FrameReplay) IDoFrameListener.sPool.poll();
            }
            return frameReplay == null ? new FrameReplay() : frameReplay;
        }

        public void recycle() {
            if (IDoFrameListener.sPool.size() <= 1000) {
                this.focusedActivity = "";
                this.startNs = 0L;
                this.endNs = 0L;
                this.dropFrame = 0;
                this.isVsyncFrame = false;
                this.intendedFrameTimeNs = 0L;
                this.inputCostNs = 0L;
                this.animationCostNs = 0L;
                this.traversalCostNs = 0L;
                synchronized (IDoFrameListener.sPool) {
                    IDoFrameListener.sPool.add(this);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    class a implements Runnable {
        final /* synthetic */ List a;

        a(List list) {
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            IDoFrameListener.this.doReplay(this.a);
            for (FrameReplay frameReplay : this.a) {
                frameReplay.recycle();
            }
        }
    }

    public IDoFrameListener() {
        this.intervalFrame = 0;
        this.list = new LinkedList();
        this.intervalFrame = getIntervalFrameReplay();
    }

    @CallSuper
    public void collect(String str, long j2, long j3, int i2, boolean z, long j4, long j5, long j6, long j7) {
        FrameReplay create = FrameReplay.create();
        create.focusedActivity = str;
        create.startNs = j2;
        create.endNs = j3;
        create.dropFrame = i2;
        create.isVsyncFrame = z;
        create.intendedFrameTimeNs = j4;
        create.inputCostNs = j5;
        create.animationCostNs = j6;
        create.traversalCostNs = j7;
        this.list.add(create);
        if (this.list.size() < this.intervalFrame || getExecutor() == null) {
            return;
        }
        LinkedList linkedList = new LinkedList(this.list);
        this.list.clear();
        getExecutor().execute(new a(linkedList));
    }

    @Deprecated
    public void doFrameAsync(String str, long j2, long j3, int i2, boolean z) {
    }

    @CallSuper
    public void doFrameAsync(String str, long j2, long j3, int i2, boolean z, long j4, long j5, long j6, long j7) {
        long j8 = (j3 - j4) / 1000000;
        doFrameAsync(str, j8, j8, i2, z);
    }

    @Deprecated
    public void doFrameSync(String str, long j2, long j3, int i2, boolean z) {
    }

    @CallSuper
    public void doFrameSync(String str, long j2, long j3, int i2, boolean z, long j4, long j5, long j6, long j7) {
        long j8 = (j3 - j4) / 1000000;
        doFrameSync(str, j8, j8, i2, z);
    }

    public void doReplay(List<FrameReplay> list) {
    }

    public Executor getExecutor() {
        return this.executor;
    }

    public int getIntervalFrameReplay() {
        return 0;
    }

    public IDoFrameListener(Executor executor) {
        this.intervalFrame = 0;
        this.list = new LinkedList();
        this.executor = executor;
    }
}
