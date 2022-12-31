package cn.sharesdk.wechat.utils;

import android.graphics.Bitmap;
import android.os.Bundle;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.onekeyshare.OnekeyShare;
import cn.sharesdk.wechat.utils.WXMediaMessage;
import com.mob.tools.log.NLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
/* loaded from: classes.dex */
public class WXImageObject implements WXMediaMessage.IMediaObject {
    public byte[] imageData;
    public String imagePath;
    public String imageUrl;

    public WXImageObject() {
    }

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        String str;
        String str2;
        byte[] bArr = this.imageData;
        if ((bArr != null && bArr.length != 0) || (((str = this.imagePath) != null && str.length() != 0) || ((str2 = this.imageUrl) != null && str2.length() != 0))) {
            byte[] bArr2 = this.imageData;
            if (bArr2 != null && bArr2.length > 10485760) {
                SSDKLog.b().d("checkArgs fail, content is too large", new Object[0]);
                return false;
            }
            String str3 = this.imagePath;
            if (str3 != null && str3.length() > 10240) {
                SSDKLog.b().d("checkArgs fail, path is invalid", new Object[0]);
                return false;
            }
            if (this.imagePath != null) {
                try {
                    if (new File(this.imagePath).length() > 10485760) {
                        SSDKLog.b().d("checkArgs fail, image content is too large", new Object[0]);
                        return false;
                    }
                } catch (Throwable th) {
                    NLog b = SSDKLog.b();
                    b.d(OnekeyShare.SHARESDK_TAG, " WXImageObject catch don't worry will betwo style " + th);
                    int a = n.a().a(this.imagePath);
                    if (a != 0 && a > 10485760) {
                        return false;
                    }
                }
            }
            String str4 = this.imageUrl;
            if (str4 == null || str4.length() <= 10240) {
                return true;
            }
            SSDKLog.b().d("checkArgs fail, url is invalid", new Object[0]);
            return false;
        }
        SSDKLog.b().d("checkArgs fail, all arguments are null", new Object[0]);
        return false;
    }

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        bundle.putByteArray("_wximageobject_imageData", this.imageData);
        bundle.putString("_wximageobject_imagePath", this.imagePath);
        bundle.putString("_wximageobject_imageUrl", this.imageUrl);
    }

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public int type() {
        return 2;
    }

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        this.imageData = bundle.getByteArray("_wximageobject_imageData");
        this.imagePath = bundle.getString("_wximageobject_imagePath");
        this.imageUrl = bundle.getString("_wximageobject_imageUrl");
    }

    public WXImageObject(byte[] bArr) {
        this.imageData = bArr;
    }

    public WXImageObject(Bitmap bitmap) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
            this.imageData = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (Exception e2) {
            SSDKLog.b().d(e2);
        }
    }
}
