package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.onekeyshare.OnekeyShare;
import cn.sharesdk.wechat.utils.WXMediaMessage;
import com.mob.tools.log.NLog;
import java.io.File;
/* loaded from: classes.dex */
public class WXAppExtendObject implements WXMediaMessage.IMediaObject {
    public String extInfo;
    public byte[] fileData;
    public String filePath;

    public WXAppExtendObject() {
    }

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        String str;
        byte[] bArr;
        String str2 = this.extInfo;
        if ((str2 != null && str2.length() != 0) || (((str = this.filePath) != null && str.length() != 0) || ((bArr = this.fileData) != null && bArr.length != 0))) {
            String str3 = this.extInfo;
            if (str3 != null && str3.length() > 2048) {
                SSDKLog.b().d("checkArgs fail, extInfo is invalid", new Object[0]);
                return false;
            }
            String str4 = this.filePath;
            if (str4 != null && str4.length() > 10240) {
                SSDKLog.b().d("checkArgs fail, filePath is invalid", new Object[0]);
                return false;
            }
            if (this.filePath != null) {
                try {
                    if (new File(this.filePath).length() > 10485760) {
                        SSDKLog.b().d("checkArgs fail, fileSize is too large", new Object[0]);
                        return false;
                    }
                } catch (Throwable th) {
                    NLog b = SSDKLog.b();
                    b.d(OnekeyShare.SHARESDK_TAG, " WXAppExendObject catch don't worry will be two style " + th);
                    int a = n.a().a(this.filePath);
                    if (a != 0 && a > 10485760) {
                        return false;
                    }
                }
            }
            byte[] bArr2 = this.fileData;
            if (bArr2 == null || bArr2.length <= 10485760) {
                return true;
            }
            SSDKLog.b().d("checkArgs fail, fileData is too large", new Object[0]);
            return false;
        }
        SSDKLog.b().d("checkArgs fail, all arguments is null", new Object[0]);
        return false;
    }

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        bundle.putString("_wxappextendobject_extInfo", this.extInfo);
        bundle.putByteArray("_wxappextendobject_fileData", this.fileData);
        bundle.putString("_wxappextendobject_filePath", this.filePath);
    }

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public int type() {
        return 7;
    }

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        this.extInfo = bundle.getString("_wxappextendobject_extInfo");
        this.fileData = bundle.getByteArray("_wxappextendobject_fileData");
        this.filePath = bundle.getString("_wxappextendobject_filePath");
    }

    public WXAppExtendObject(String str, byte[] bArr) {
        this.extInfo = str;
        this.fileData = bArr;
    }

    public WXAppExtendObject(String str, String str2) {
        this.extInfo = str;
        this.filePath = str2;
    }
}
