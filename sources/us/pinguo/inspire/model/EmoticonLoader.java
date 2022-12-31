package us.pinguo.inspire.model;

import com.rockerhieu.emoji.model.EmoticonPkg;
import java.util.List;
import rx.Observable;
import us.pinguo.common.network.BaseResponse;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.api.Payload;
/* loaded from: classes9.dex */
public class EmoticonLoader {
    public static final String URL = "/emotion/emoticonPkg/getByIds";

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class EmoticonData {
        List<EmoticonPkg> list;

        private EmoticonData() {
        }
    }

    public Observable<List<EmoticonPkg>> loadEmoticonPkgs(String str) {
        return us.pinguo.foundation.m.f.f(new Inspire.d<BaseResponse<EmoticonData>>() { // from class: us.pinguo.inspire.model.EmoticonLoader.1
        }.url(URL).put("ids", str).build()).map(new Payload()).flatMap(a.a);
    }

    public Observable<List<EmoticonPkg>> loadEmoticonPkgs(String[] strArr) {
        String str = "";
        if (strArr != null && strArr.length > 0) {
            for (String str2 : strArr) {
                str = str + strArr + ",";
            }
            str = str.substring(0, str.length() - 1);
        }
        return us.pinguo.foundation.m.f.f(new Inspire.d<BaseResponse<List<EmoticonPkg>>>() { // from class: us.pinguo.inspire.model.EmoticonLoader.2
        }.url(URL).put("ids", str).build()).map(new Payload());
    }
}
