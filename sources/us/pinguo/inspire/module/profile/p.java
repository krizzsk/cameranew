package us.pinguo.inspire.module.profile;

import rx.functions.Action1;
/* compiled from: lambda */
/* loaded from: classes4.dex */
public final /* synthetic */ class p implements Action1 {
    public static final /* synthetic */ p a = new p();

    private /* synthetic */ p() {
    }

    @Override // rx.functions.Action1
    public final void call(Object obj) {
        ProfileLoader.j((us.pinguo.user.model.ProfileEntry) obj);
    }
}
