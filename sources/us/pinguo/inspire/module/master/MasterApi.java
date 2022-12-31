package us.pinguo.inspire.module.master;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import us.pinguo.common.network.BaseResponse;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.api.Payload;
import us.pinguo.inspire.module.profile.activity.GuestProfileFragment;
/* loaded from: classes9.dex */
public class MasterApi {
    public static final int NOT = 0;
    public static final int PASS = 3;
    public static final int RESUSE = 2;
    private static final String URL_CHECK_APPLY;
    private static final String URL_CHECK_EXPERT;
    public static final int WAIT = 1;

    static {
        StringBuilder sb = new StringBuilder();
        String str = Inspire.f11203d;
        sb.append(str);
        sb.append("/user/expert/check");
        URL_CHECK_EXPERT = sb.toString();
        URL_CHECK_APPLY = str + "/user/expert/apply";
    }

    public static Observable<Boolean> apply(String str, String str2, String str3) {
        return us.pinguo.foundation.m.f.a(new Inspire.d<BaseResponse<Boolean>>() { // from class: us.pinguo.inspire.module.master.MasterApi.2
        }.url(URL_CHECK_APPLY).put(GuestProfileFragment.USER_ID, str).put("contact", str2).put("recommend", str3).build()).map(new Payload()).observeOn(AndroidSchedulers.mainThread());
    }

    public static Observable<Integer> checkExpert(String str) {
        return us.pinguo.foundation.m.f.a(new Inspire.d<BaseResponse<Integer>>() { // from class: us.pinguo.inspire.module.master.MasterApi.1
        }.url(URL_CHECK_EXPERT).put(GuestProfileFragment.USER_ID, str).build()).map(new Payload()).observeOn(AndroidSchedulers.mainThread());
    }
}
