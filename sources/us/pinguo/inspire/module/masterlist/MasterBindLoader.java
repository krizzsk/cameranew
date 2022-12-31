package us.pinguo.inspire.module.masterlist;

import rx.Observable;
import us.pinguo.common.network.BaseResponse;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.api.Payload;
import us.pinguo.inspire.module.profile.activity.GuestProfileFragment;
/* loaded from: classes9.dex */
public class MasterBindLoader {
    public static final int NOT = 0;
    public static final int PASS = 3;
    public static final int RESUSE = 2;
    public static final int WAIT = 1;
    private String isMasterUrl;
    private String topListUrl;

    public MasterBindLoader() {
        StringBuilder sb = new StringBuilder();
        String str = Inspire.f11203d;
        sb.append(str);
        sb.append("/user/expert/topList");
        this.topListUrl = sb.toString();
        this.isMasterUrl = str + "/user/expert/checkV2";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ MasterCheckData a(MasterCheckData masterCheckData) {
        return masterCheckData;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ MasterListData b(MasterListData masterListData) {
        return masterListData;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ MasterListData c(MasterListData masterListData) {
        return masterListData;
    }

    public Observable<MasterCheckData> checkMasterList(String str) {
        return us.pinguo.foundation.m.f.f(new Inspire.d<BaseResponse<MasterCheckData>>() { // from class: us.pinguo.inspire.module.masterlist.MasterBindLoader.3
        }.url(this.isMasterUrl).put(GuestProfileFragment.USER_ID, str).build()).map(new Payload()).map(a.a);
    }

    public Observable<MasterListData> getMasterList(String str, int i2) {
        return us.pinguo.foundation.m.f.f(new Inspire.d<BaseResponse<MasterListData>>() { // from class: us.pinguo.inspire.module.masterlist.MasterBindLoader.1
        }.url(this.topListUrl).put("sp", str).put("type", i2).build()).map(new Payload()).map(b.a);
    }

    public Observable<MasterListData> getMasterList() {
        return us.pinguo.foundation.m.f.f(new Inspire.d<BaseResponse<MasterListData>>() { // from class: us.pinguo.inspire.module.masterlist.MasterBindLoader.2
        }.url(this.topListUrl).build()).map(new Payload()).map(c.a);
    }
}
