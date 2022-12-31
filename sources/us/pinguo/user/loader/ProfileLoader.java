package us.pinguo.user.loader;

import rx.Observable;
import rx.functions.Func1;
import us.pinguo.common.network.BaseResponse;
import us.pinguo.foundation.m.f;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.api.Payload;
import us.pinguo.user.model.PersonalInfoCache;
import us.pinguo.user.model.ProfileEntry;
import us.pinguo.user.s0;
/* loaded from: classes6.dex */
public class ProfileLoader {
    private PersonalInfoCache a = new PersonalInfoCache(s0.getInstance().getUserId());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a extends Inspire.d<BaseResponse<ProfileEntry>> {
        a(ProfileLoader profileLoader) {
        }
    }

    /* loaded from: classes6.dex */
    private static final class b {
        private static final ProfileLoader a = new ProfileLoader();
    }

    private /* synthetic */ ProfileEntry b(ProfileEntry profileEntry) {
        this.a.wrap().b(profileEntry);
        return profileEntry;
    }

    public static ProfileLoader getInstance() {
        return b.a;
    }

    public Observable<ProfileEntry> a(String str) {
        return f.f(new a(this).url(us.pinguo.inspire.module.profile.ProfileLoader.PERSONAL_PROFILE_URL).put("authorId", str).build()).map(new Payload()).map(new Func1() { // from class: us.pinguo.user.loader.a
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                ProfileEntry profileEntry = (ProfileEntry) obj;
                ProfileLoader.this.c(profileEntry);
                return profileEntry;
            }
        });
    }

    public /* synthetic */ ProfileEntry c(ProfileEntry profileEntry) {
        b(profileEntry);
        return profileEntry;
    }
}
