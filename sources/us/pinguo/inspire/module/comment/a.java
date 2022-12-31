package us.pinguo.inspire.module.comment;

import rx.functions.Func1;
import us.pinguo.inspire.api.EmptyResponse;
/* compiled from: lambda */
/* loaded from: classes4.dex */
public final /* synthetic */ class a implements Func1 {
    public static final /* synthetic */ a a = new a();

    private /* synthetic */ a() {
    }

    @Override // rx.functions.Func1
    public final Object call(Object obj) {
        return CommentLoader.e((EmptyResponse.Data) obj);
    }
}
