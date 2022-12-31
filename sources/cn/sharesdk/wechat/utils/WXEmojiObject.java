package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.wechat.utils.WXMediaMessage;
import com.mob.tools.log.NLog;
import java.io.File;
/* loaded from: classes.dex */
public class WXEmojiObject implements WXMediaMessage.IMediaObject {
    public byte[] emojiData;
    public String emojiPath;

    public WXEmojiObject() {
    }

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        byte[] bArr = this.emojiData;
        if ((bArr == null || bArr.length == 0) && TextUtils.isEmpty(this.emojiPath)) {
            SSDKLog.b().d("MicroMsg.SDK.WXEmojiObject", "checkArgs fail, both arguments is null");
            return false;
        }
        byte[] bArr2 = this.emojiData;
        if (bArr2 != null && bArr2.length > 10485760) {
            SSDKLog.b().d("MicroMsg.SDK.WXEmojiObject", "checkArgs fail, emojiData is too large");
            return false;
        }
        if (this.emojiPath != null) {
            try {
                File file = new File(this.emojiPath);
                if (!file.exists()) {
                    SSDKLog.b().d("MicroMsg.SDK.WXEmojiObject", "checkArgs fail, emojiPath not found");
                    return false;
                } else if (file.length() > 10485760) {
                    SSDKLog.b().d("MicroMsg.SDK.WXEmojiObject", "checkArgs fail, emojiSize is too large");
                    return false;
                }
            } catch (Throwable th) {
                NLog b = SSDKLog.b();
                b.d("ShareSDk", " WXEmojiObject catch don't worry will be two style " + th);
                int a = n.a().a(this.emojiPath);
                if (a != 0 && a > 10485760) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        bundle.putByteArray("_wxemojiobject_emojiData", this.emojiData);
        bundle.putString("_wxemojiobject_emojiPath", this.emojiPath);
    }

    public void setEmojiData(byte[] bArr) {
        this.emojiData = bArr;
    }

    public void setEmojiPath(String str) {
        this.emojiPath = str;
    }

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public int type() {
        return 8;
    }

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        this.emojiData = bundle.getByteArray("_wxemojiobject_emojiData");
        this.emojiPath = bundle.getString("_wxemojiobject_emojiPath");
    }

    public WXEmojiObject(byte[] bArr) {
        this.emojiData = bArr;
    }

    public WXEmojiObject(String str) {
        this.emojiPath = str;
    }
}
