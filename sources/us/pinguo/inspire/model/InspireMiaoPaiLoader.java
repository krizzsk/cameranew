package us.pinguo.inspire.model;

import rx.Observable;
import us.pinguo.common.network.BaseResponse;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.api.Payload;
/* loaded from: classes9.dex */
public class InspireMiaoPaiLoader {
    public static final String URL = "/share/shareJump";

    public static Observable<MiaoPaiDownLoad> getMpSwitch() {
        return us.pinguo.foundation.m.f.f(new Inspire.d<BaseResponse<MiaoPaiDownLoad>>() { // from class: us.pinguo.inspire.model.InspireMiaoPaiLoader.1
        }.url(URL).build()).map(new Payload());
    }
}
