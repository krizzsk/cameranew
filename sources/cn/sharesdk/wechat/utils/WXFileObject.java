package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.onekeyshare.OnekeyShare;
import cn.sharesdk.wechat.utils.WXMediaMessage;
import com.mob.tools.log.NLog;
import java.io.File;
/* loaded from: classes.dex */
public class WXFileObject implements WXMediaMessage.IMediaObject {
    public byte[] fileData;
    public String filePath;

    public WXFileObject() {
        this.fileData = null;
        this.filePath = null;
    }

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        String str;
        byte[] bArr = this.fileData;
        if ((bArr != null && bArr.length != 0) || ((str = this.filePath) != null && str.length() != 0)) {
            byte[] bArr2 = this.fileData;
            if (bArr2 != null && bArr2.length > 10485760) {
                SSDKLog.b().d("checkArgs fail, fileData is too large", new Object[0]);
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
            return true;
        }
        SSDKLog.b().d("checkArgs fail, both arguments is null", new Object[0]);
        return false;
    }

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        bundle.putByteArray("_wxfileobject_fileData", this.fileData);
        bundle.putString("_wxfileobject_filePath", this.filePath);
    }

    public void setFileData(byte[] bArr) {
        this.fileData = bArr;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public int type() {
        return 6;
    }

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        this.fileData = bundle.getByteArray("_wxfileobject_fileData");
        this.filePath = bundle.getString("_wxfileobject_filePath");
    }

    public WXFileObject(byte[] bArr) {
        this.fileData = bArr;
    }

    public WXFileObject(String str) {
        this.filePath = str;
    }
}
