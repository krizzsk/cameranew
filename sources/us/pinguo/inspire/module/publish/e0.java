package us.pinguo.inspire.module.publish;

import rx.functions.Func1;
import us.pinguo.inspire.module.comment.InspireComment;
/* compiled from: lambda */
/* loaded from: classes4.dex */
public final /* synthetic */ class e0 implements Func1 {
    public static final /* synthetic */ e0 a = new e0();

    private /* synthetic */ e0() {
    }

    @Override // rx.functions.Func1
    public final Object call(Object obj) {
        InspireComment inspireComment = (InspireComment) obj;
        InspirePublishTask.M(inspireComment);
        return inspireComment;
    }
}
