package us.pinguo.inspire.util;

import rx.Observable;
import us.pinguo.bigalbum.db.BigAlbumStore;
import us.pinguo.common.network.BaseResponse;
import us.pinguo.foundation.m.f;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.api.Payload;
import us.pinguo.inspire.module.publish.vo.SelectLocResp;
/* loaded from: classes9.dex */
public class InspireLocationManager {
    public static InspireLocationManager a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class a extends Inspire.d<BaseResponse<SelectLocResp>> {
        a(InspireLocationManager inspireLocationManager) {
        }
    }

    private InspireLocationManager() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ SelectLocResp b(SelectLocResp selectLocResp) {
        if (selectLocResp != null) {
            return selectLocResp;
        }
        throw new RuntimeException("InspireGeo is unavailable.");
    }

    public static InspireLocationManager getInstance() {
        if (a == null) {
            a = new InspireLocationManager();
        }
        return a;
    }

    public Observable<SelectLocResp> a(String str, String str2) {
        f.a<BaseResponse<SelectLocResp>> url = new a(this).url("/task/getGeo/poi");
        f.a<BaseResponse<SelectLocResp>> put = url.put(BigAlbumStore.PhotoColumns.LATITUDE, str + "");
        return us.pinguo.foundation.m.f.f(put.put(BigAlbumStore.PhotoColumns.LONGITUDE, str2 + "").build()).map(new Payload()).map(e.a);
    }
}
