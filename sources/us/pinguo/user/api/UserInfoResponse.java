package us.pinguo.user.api;

import androidx.core.app.NotificationCompat;
import com.tapjoy.TapjoyConstants;
import com.tencent.open.SocialConstants;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import us.pinguo.bigalbum.db.BigAlbumStore;
import us.pinguo.common.network.BaseResponse;
import us.pinguo.inspire.module.profile.activity.GuestProfileFragment;
import us.pinguo.user.User;
import us.pinguo.user.y0;
/* loaded from: classes6.dex */
public class UserInfoResponse extends BaseResponse<User.Info> {
    public long tokenEnd;
    public long tokenExpire;

    /* JADX WARN: Type inference failed for: r3v6, types: [T, us.pinguo.user.User$Info] */
    public UserInfoResponse(String str, String str2) throws JSONException {
        this.tokenExpire = -1L;
        this.tokenEnd = -1L;
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next.equals("status")) {
                    this.status = jSONObject.getInt(next);
                } else if (next.equals("message")) {
                    this.message = jSONObject.getString(next);
                } else if (next.equals("data")) {
                    ?? info = new User.Info();
                    this.data = info;
                    ((User.Info) info).loginmode = str2;
                    try {
                        JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                        Iterator<String> keys2 = jSONObject2.keys();
                        while (keys2.hasNext()) {
                            String next2 = keys2.next();
                            if (next2.equals(GuestProfileFragment.USER_ID)) {
                                ((User.Info) this.data).userId = jSONObject2.getString(next2);
                            } else if (next2.equals(NotificationCompat.CATEGORY_EMAIL)) {
                                ((User.Info) this.data).email = jSONObject2.getString(next2);
                            } else if (next2.equals("avatar")) {
                                ((User.Info) this.data).avatar = jSONObject2.getString(next2);
                            } else if (next2.equals("lastLoginTime")) {
                                ((User.Info) this.data).lastLoginTime = jSONObject2.getLong(next2);
                            } else if (next2.equals("nickname")) {
                                ((User.Info) this.data).nickname = jSONObject2.getString(next2);
                            } else if (next2.equals(SocialConstants.PARAM_COMMENT)) {
                                ((User.Info) this.data).description = jSONObject2.getString(next2);
                            } else if (next2.equals("gender")) {
                                ((User.Info) this.data).gender = jSONObject2.getString(next2);
                            } else if (next2.equals("birthday")) {
                                ((User.Info) this.data).birthday = jSONObject2.getString(next2);
                            } else if (next2.equals("certificated")) {
                                ((User.Info) this.data).certificated = jSONObject2.getInt(next2);
                            } else if (next2.equals("regDateTime")) {
                                ((User.Info) this.data).regDateTime = jSONObject2.getLong(next2);
                            } else if (next2.equals(IjkMediaMeta.IJKM_KEY_LANGUAGE)) {
                                ((User.Info) this.data).language = jSONObject2.getString(next2);
                            } else if (next2.equals("token")) {
                                ((User.Info) this.data).token = jSONObject2.getString(next2);
                            } else if (next2.equals("third")) {
                                try {
                                    User.Info.ThirdSites thirdSites = (User.Info.ThirdSites) new com.google.gson.e().j(jSONObject2.getJSONObject(next2).toString(), User.Info.ThirdSites.class);
                                    if (thirdSites != null) {
                                        ((User.Info) this.data).third = thirdSites;
                                    }
                                } catch (JSONException unused) {
                                }
                            } else if (next2.equals("vipInfo")) {
                                try {
                                    JSONObject jSONObject3 = jSONObject2.getJSONObject(next2);
                                    y0.c cVar = new y0.c(String.valueOf(jSONObject3.get("isVip")), String.valueOf(jSONObject3.get("expires")));
                                    ((User.Info) this.data).vipInfo = cVar;
                                    y0.o(us.pinguo.foundation.e.b(), cVar.a, cVar.b);
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            } else if (next2.equals("forgetPass")) {
                                ((User.Info) this.data).forgetPass = jSONObject2.getInt(next2);
                            } else if (next2.equals("setPass")) {
                                ((User.Info) this.data).setPass = jSONObject2.getInt(next2);
                            } else if (next2.equals(TapjoyConstants.TJC_CONNECTION_TYPE_MOBILE)) {
                                ((User.Info) this.data).mobile = jSONObject2.getString(next2);
                            } else if (next2.equals("tokenExpire")) {
                                this.tokenExpire = jSONObject2.getLong(next2);
                            } else if (next2.equals("tokenEnd")) {
                                this.tokenEnd = jSONObject2.getLong(next2);
                            } else if (next2.equals("backgroundPic")) {
                                ((User.Info) this.data).backgroundPic = jSONObject2.getString(next2);
                            } else if (next2.equals("firstLogin")) {
                                ((User.Info) this.data).firstLogin = jSONObject2.getBoolean(next2);
                            } else if (next2.equals(BigAlbumStore.PhotoAddressColumns.COUNTRY)) {
                                ((User.Info) this.data).country = jSONObject2.getString(next2);
                            } else if (next2.equals(BigAlbumStore.PhotoAddressColumns.COUNTRY)) {
                                ((User.Info) this.data).country = jSONObject2.getString(next2);
                            } else if (next2.equals(BigAlbumStore.PhotoAddressColumns.PROVINCE)) {
                                ((User.Info) this.data).province = jSONObject2.getString(next2);
                            } else if (next2.equals(BigAlbumStore.PhotoAddressColumns.CITY)) {
                                ((User.Info) this.data).city = jSONObject2.getString(next2);
                            }
                        }
                    } catch (JSONException unused2) {
                    }
                }
            }
        } catch (JSONException e3) {
            throw e3;
        }
    }
}
