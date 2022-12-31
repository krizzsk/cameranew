package cn.sharesdk.framework.loopshare.watermark;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.onekeyshare.OnekeyShare;
import com.mob.MobSDK;
import com.mob.tools.log.NLog;
import com.tencent.open.SocialConstants;
import com.zhy.android.percent.support.PercentLayoutHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/* compiled from: ImageCopyAlbum.java */
/* loaded from: classes.dex */
public class d {
    private static final String a = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM) + "/watermark";

    public static void a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            SSDKLog.b().e(OnekeyShare.SHARESDK_TAG, " 拷贝文件的目标路径为空 ");
            return;
        }
        File file = new File(str);
        if (!file.exists()) {
            SSDKLog.b().e(OnekeyShare.SHARESDK_TAG, " 拷贝文件不存在 ");
            return;
        }
        a();
        File file2 = new File(a + "/" + file.getName());
        a(file, file2);
        MediaScannerConnection.scanFile(context, new String[]{file2.getPath()}, null, null);
    }

    private static void a() {
        File file = new File(a);
        if (file.exists()) {
            return;
        }
        try {
            file.mkdirs();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static void a(File file, File file2) {
        if (file.getAbsolutePath().equals(file2.getAbsolutePath())) {
            return;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read >= 0) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    fileOutputStream.close();
                    NLog b = SSDKLog.b();
                    b.d(OnekeyShare.SHARESDK_TAG, "copyFile 执行完毕, src " + file.length() + " dest: " + file2.length());
                    return;
                }
            }
        } catch (IOException e2) {
            NLog b2 = SSDKLog.b();
            b2.e(OnekeyShare.SHARESDK_TAG, "拷贝文件到相册失败: " + e2);
        }
    }

    public static void a(File file) {
        ContentResolver contentResolver = MobSDK.getContext().getContentResolver();
        try {
            Uri insert = contentResolver.insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, a(file, System.currentTimeMillis()));
            if (insert != null) {
                byte[] bArr = new byte[1024];
                FileOutputStream fileOutputStream = new FileOutputStream(contentResolver.openFileDescriptor(insert, PercentLayoutHelper.PercentLayoutInfo.BASEMODE.W).getFileDescriptor());
                FileInputStream fileInputStream = new FileInputStream(file);
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        fileInputStream.close();
                        fileOutputStream.flush();
                        Intent intent = new Intent();
                        intent.setAction("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                        intent.setData(insert);
                        MobSDK.getContext().sendBroadcast(intent);
                        SSDKLog.b().d(OnekeyShare.SHARESDK_TAG, "视频拷贝到相册完成");
                        return;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
            } else {
                SSDKLog.b().e(OnekeyShare.SHARESDK_TAG, "此款机型拷贝到相册失败，localUri is null, insert MediaStore failed， 将会再次尝试一下别的路径");
                a(MobSDK.getContext(), file.getAbsolutePath());
                SSDKLog.b().d(OnekeyShare.SHARESDK_TAG, "别的路径尝试拷贝完成");
            }
        } catch (Throwable th) {
            try {
                a(MobSDK.getContext(), file.getAbsolutePath());
            } catch (Throwable th2) {
                NLog b = SSDKLog.b();
                b.e(OnekeyShare.SHARESDK_TAG, "异常处理下再次执行拷贝依然失败" + th2);
            }
            NLog b2 = SSDKLog.b();
            b2.e(OnekeyShare.SHARESDK_TAG, "Failed to insert media file " + th);
        }
    }

    public static ContentValues a(File file, long j2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", file.getName());
        contentValues.put(SocialConstants.PARAM_COMMENT, "water mark video");
        contentValues.put("title", file.getName());
        contentValues.put("_display_name", file.getName());
        contentValues.put("mime_type", "video/*");
        contentValues.put("datetaken", Long.valueOf(j2));
        contentValues.put("date_modified", Long.valueOf(j2));
        contentValues.put("date_added", Long.valueOf(j2));
        contentValues.put("_data", file.getAbsolutePath());
        contentValues.put("_size", Long.valueOf(file.length()));
        return contentValues;
    }
}
