package us.pinguo.inspire.module.publish;

import rx.functions.Func1;
import us.pinguo.inspire.module.comment.InspireComment;
/* compiled from: lambda */
/* loaded from: classes4.dex */
public final /* synthetic */ class w0 implements Func1 {
    public static final /* synthetic */ w0 a = new w0();

    private /* synthetic */ w0() {
    }

    @Override // rx.functions.Func1
    public final Object call(Object obj) {
        InspireComment inspireComment = (InspireComment) obj;
        InspirePublishTask.b(inspireComment);
        return inspireComment;
    }
}
