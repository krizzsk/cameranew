package cn.sharesdk.wechat.utils;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.tools.log.NLog;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.ByteArrayOutputStream;
/* loaded from: classes.dex */
public final class WXMediaMessage {
    public static final String ACTION_WXAPPMESSAGE = "com.tencent.mm.sdk.openapi.Intent.ACTION_WXAPPMESSAGE";
    public static final int MESSAGE_ACTION_LENGTH_LIMIT = 2048;
    public static final int MESSAGE_EXT_LENGTH_LIMIT = 2048;
    public String description;
    public IMediaObject mediaObject;
    public String mediaTagName;
    public String messageAction;
    public String messageExt;
    public String openId;
    public int sdkVer;
    public byte[] thumbData;
    public String title;
    public String wxminiprogram_ext_msg;

    /* loaded from: classes.dex */
    public interface IMediaObject {
        public static final int TYPE_APPDATA = 7;
        public static final int TYPE_EMOJI = 8;
        public static final int TYPE_FILE = 6;
        public static final int TYPE_IMAGE = 2;
        public static final int TYPE_MINIPROGRAM = 9;
        public static final int TYPE_MUSIC = 3;
        public static final int TYPE_TEXT = 1;
        public static final int TYPE_UNKNOWN = 0;
        public static final int TYPE_URL = 5;
        public static final int TYPE_VIDEO = 4;

        boolean checkArgs();

        void serialize(Bundle bundle);

        int type();

        void unserialize(Bundle bundle);
    }

    public WXMediaMessage() {
        this(null);
    }

    public final int getType() {
        IMediaObject iMediaObject = this.mediaObject;
        if (iMediaObject == null) {
            return 0;
        }
        return iMediaObject.type();
    }

    public final void setThumbImage(Bitmap bitmap) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
            this.thumbData = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (Exception e2) {
            SSDKLog.b().d(e2);
            SSDKLog.b().d("put thumb failed", new Object[0]);
        }
    }

    public WXMediaMessage(IMediaObject iMediaObject) {
        this.mediaObject = iMediaObject;
    }

    /* loaded from: classes.dex */
    public static class a {
        public static Bundle a(WXMediaMessage wXMediaMessage) {
            Bundle bundle = new Bundle();
            bundle.putInt("_wxobject_sdkVer", wXMediaMessage.sdkVer);
            bundle.putString("_wxobject_title", wXMediaMessage.title);
            bundle.putString("_wxobject_description", wXMediaMessage.description);
            bundle.putByteArray("_wxobject_thumbdata", wXMediaMessage.thumbData);
            if (wXMediaMessage.mediaObject != null) {
                bundle.putString(WXMediaMessage.Builder.KEY_IDENTIFIER, "com.tencent.mm.sdk.openapi." + wXMediaMessage.mediaObject.getClass().getSimpleName());
                wXMediaMessage.mediaObject.serialize(bundle);
            }
            bundle.putString("_wxobject_mediatagname", wXMediaMessage.mediaTagName);
            bundle.putString("_wxobject_message_action", wXMediaMessage.messageAction);
            bundle.putString("_wxobject_message_ext", wXMediaMessage.messageExt);
            if (!TextUtils.isEmpty(wXMediaMessage.wxminiprogram_ext_msg)) {
                bundle.putString("_launch_wxminiprogram_ext_msg", wXMediaMessage.wxminiprogram_ext_msg);
            } else {
                SSDKLog.b().d("WechatResp toBundle that _launch_wxminiprogram_ext_msg is null", new Object[0]);
            }
            return bundle;
        }

        public static WXMediaMessage a(Bundle bundle) {
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.sdkVer = bundle.getInt("_wxobject_sdkVer");
            wXMediaMessage.title = bundle.getString("_wxobject_title");
            wXMediaMessage.description = bundle.getString("_wxobject_description");
            wXMediaMessage.thumbData = bundle.getByteArray("_wxobject_thumbdata");
            wXMediaMessage.mediaTagName = bundle.getString("_wxobject_mediatagname");
            wXMediaMessage.messageAction = bundle.getString("_wxobject_message_action");
            wXMediaMessage.messageExt = bundle.getString("_wxobject_message_ext");
            try {
                wXMediaMessage.wxminiprogram_ext_msg = bundle.getString("_launch_wxminiprogram_ext_msg");
            } catch (Throwable th) {
                NLog b = SSDKLog.b();
                b.d(" WechatResp get _launch_wxminiprogram_ext_msg error " + th, new Object[0]);
            }
            wXMediaMessage.openId = bundle.getString(TextUtils.isEmpty(bundle.getString("_wxapi_basereq_openid")) ? "_wxapi_baseresp_openId" : "_wxapi_basereq_openid");
            String string = bundle.getString(WXMediaMessage.Builder.KEY_IDENTIFIER);
            if (string != null && string.length() > 0) {
                try {
                    string = string.replace("com.tencent.mm.sdk.openapi", "cn.sharesdk.wechat.utils");
                    IMediaObject iMediaObject = (IMediaObject) Class.forName(string).newInstance();
                    wXMediaMessage.mediaObject = iMediaObject;
                    iMediaObject.unserialize(bundle);
                    return wXMediaMessage;
                } catch (Exception e2) {
                    SSDKLog.b().d(e2);
                    NLog b2 = SSDKLog.b();
                    b2.d("get media object from bundle failed: unknown ident " + string, new Object[0]);
                }
            }
            return wXMediaMessage;
        }
    }
}
