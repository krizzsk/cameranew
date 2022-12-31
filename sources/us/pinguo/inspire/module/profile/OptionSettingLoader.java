package us.pinguo.inspire.module.profile;

import rx.Observable;
import us.pinguo.common.network.BaseResponse;
import us.pinguo.foundation.domain.OptionsSettingEntry;
import us.pinguo.foundation.m.f;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.api.Payload;
import us.pinguo.inspire.module.message.category.entity.InspireMsg;
import us.pinguo.inspire.module.profile.activity.GuestProfileFragment;
/* loaded from: classes9.dex */
public class OptionSettingLoader {
    public static final String OPTION_GET_URL = "/user/noticeConf/get";
    public static final String OPTION_SET_URL = "/user/noticeConf/set";

    public static Observable<OptionsSettingEntry> fetchOptionConfig(String str) {
        return us.pinguo.foundation.m.f.f(new Inspire.d<BaseResponse<OptionsSettingEntry>>() { // from class: us.pinguo.inspire.module.profile.OptionSettingLoader.1
        }.url(OPTION_GET_URL).put(GuestProfileFragment.USER_ID, str).build()).map(new Payload());
    }

    public static Observable<OptionsSettingEntry> setOptionConfig(String str, OptionsSettingEntry optionsSettingEntry) {
        f.a<BaseResponse<OptionsSettingEntry>> put = new Inspire.d<BaseResponse<OptionsSettingEntry>>() { // from class: us.pinguo.inspire.module.profile.OptionSettingLoader.2
        }.url(OPTION_SET_URL).put(GuestProfileFragment.USER_ID, str);
        f.a<BaseResponse<OptionsSettingEntry>> put2 = put.put("atMe", optionsSettingEntry.atMe + "");
        f.a<BaseResponse<OptionsSettingEntry>> put3 = put2.put("comment", optionsSettingEntry.comment + "");
        f.a<BaseResponse<OptionsSettingEntry>> put4 = put3.put("favour", optionsSettingEntry.favour + "");
        f.a<BaseResponse<OptionsSettingEntry>> put5 = put4.put("newFans", optionsSettingEntry.newFans + "");
        f.a<BaseResponse<OptionsSettingEntry>> put6 = put5.put(InspireMsg.TYPE_VOTE, optionsSettingEntry.vote + "");
        return us.pinguo.foundation.m.f.f(put6.put("winPrize", optionsSettingEntry.winPrize + "").build()).map(new Payload());
    }
}
