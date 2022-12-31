package us.pinguo.common.helper;

import kotlin.jvm.b.r;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.z0;
import us.pinguo.util.l;
/* compiled from: SegmentationHelper.kt */
/* loaded from: classes4.dex */
public final class SegmentationHelper {
    private volatile SegmentationTask a;

    /* JADX WARN: Type inference failed for: r1v0, types: [us.pinguo.common.helper.SegmentationTask, T] */
    /* JADX WARN: Type inference failed for: r1v6, types: [us.pinguo.common.helper.SegmentationTask, T] */
    public final void a(String srcPath, r<? super String, ? super Boolean, ? super String, ? super Integer, u> rVar) {
        s.h(srcPath, "srcPath");
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ?? r1 = this.a;
        ref$ObjectRef.element = r1;
        SegmentationTask segmentationTask = (SegmentationTask) r1;
        if ((segmentationTask == null ? null : segmentationTask.d()) != null && s.c(((SegmentationTask) ref$ObjectRef.element).d(), srcPath)) {
            if (((SegmentationTask) ref$ObjectRef.element).c() != null) {
                String c = ((SegmentationTask) ref$ObjectRef.element).c();
                if (c == null) {
                    c = "";
                }
                if (!l.m(c) || rVar == null) {
                    return;
                }
                Boolean bool = Boolean.TRUE;
                String c2 = ((SegmentationTask) ref$ObjectRef.element).c();
                s.e(c2);
                rVar.invoke(srcPath, bool, c2, Integer.valueOf(((SegmentationTask) ref$ObjectRef.element).b()));
                return;
            }
            return;
        }
        SegmentationTask segmentationTask2 = (SegmentationTask) ref$ObjectRef.element;
        if (segmentationTask2 != null) {
            segmentationTask2.a();
        }
        ?? segmentationTask3 = new SegmentationTask(srcPath, rVar);
        ref$ObjectRef.element = segmentationTask3;
        this.a = (SegmentationTask) segmentationTask3;
        kotlinx.coroutines.l.d(n0.a(z0.b()), null, null, new SegmentationHelper$segment$1(ref$ObjectRef, null), 3, null);
    }
}
