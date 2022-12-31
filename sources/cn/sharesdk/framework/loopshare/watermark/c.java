package cn.sharesdk.framework.loopshare.watermark;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import cn.sharesdk.framework.utils.QRCodeUtil.QRCodeListener;
import cn.sharesdk.framework.utils.QRCodeUtil.QRCodeService;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.onekeyshare.OnekeyShare;
import com.arthenica.mobileffmpeg.Config;
import com.arthenica.mobileffmpeg.FFmpeg;
import com.mob.MobSDK;
import com.mob.tools.log.NLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
/* compiled from: FfmpegCommandCentre.java */
/* loaded from: classes.dex */
public class c {
    public static String a = null;
    private static String b = "WMarkVideo";
    private static String c = "WMarkImage.jpg";

    /* renamed from: d  reason: collision with root package name */
    private static String f139d = "outputVideo";

    /* renamed from: e  reason: collision with root package name */
    private static String f140e = "textMark";

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str, Bitmap bitmap, Context context) {
        String str2 = context.getCacheDir() + "/images/";
        if (!a(str2)) {
            SSDKLog.b().e(OnekeyShare.SHARESDK_TAG, "TargetPath isn't exist");
            return null;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(str2, str));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            return str2;
        } catch (IOException e2) {
            SSDKLog.b().e(OnekeyShare.SHARESDK_TAG, "saveBitmap IOException: " + e2);
            return null;
        }
    }

    private static boolean a(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return true;
            }
            return file.mkdirs();
        } catch (Throwable th) {
            NLog b2 = SSDKLog.b();
            b2.e(OnekeyShare.SHARESDK_TAG, "fileIsExist Throwable: " + th);
            return false;
        }
    }

    public static String a(Context context, boolean z) {
        if (context != null && a == null) {
            String str = context.getCacheDir() + "/" + b;
            File file = new File(str);
            if (!file.exists()) {
                if (!file.mkdirs()) {
                    SSDKLog.b().e(OnekeyShare.SHARESDK_TAG, "getPathInPackage 在pakage目录创建CGE临时目录失败!");
                    return null;
                } else if (z) {
                    int i2 = Build.VERSION.SDK_INT;
                    if (i2 >= 9 && file.setExecutable(true, false)) {
                        SSDKLog.b().i(OnekeyShare.SHARESDK_TAG, "getPathInPackage Package folder is executable");
                    }
                    if (i2 >= 9 && file.setReadable(true, false)) {
                        SSDKLog.b().i(OnekeyShare.SHARESDK_TAG, "getPathInPackage Package folder is readable");
                    }
                    if (i2 >= 9 && file.setWritable(true, false)) {
                        SSDKLog.b().i(OnekeyShare.SHARESDK_TAG, "getPathInPackage Package folder is writable");
                    }
                }
            }
            a = str;
            return str;
        }
        return a;
    }

    public static void a(String str, String str2, String str3, final String str4, final WaterMarkListener waterMarkListener) {
        final String str5;
        if (Build.VERSION.SDK_INT <= 24) {
            if (waterMarkListener != null) {
                waterMarkListener.onFailed("The minimum version supported for this feature is 7.0", -2);
                return;
            }
            return;
        }
        try {
            Class.forName("com.arthenica.mobileffmpeg.FFmpeg");
            final String str6 = a(MobSDK.getContext(), true) + "/" + f139d + ".mp4";
            File file = new File(str6);
            if (file.exists()) {
                file.delete();
            }
            final boolean[] zArr = {false};
            final String[] strArr = {str2, str3};
            if (TextUtils.isEmpty(str2)) {
                str5 = "";
            } else {
                str5 = a(MobSDK.getContext(), true) + "/" + f140e + ".jpg";
                f.a(new Runnable() { // from class: cn.sharesdk.framework.loopshare.watermark.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        zArr[0] = a.a(str5, strArr);
                    }
                });
            }
            final String str7 = str5;
            QRCodeService qRCodeService = new QRCodeService();
            qRCodeService.setContent(str);
            qRCodeService.generateAsync(new QRCodeListener() { // from class: cn.sharesdk.framework.loopshare.watermark.c.2
                @Override // cn.sharesdk.framework.utils.QRCodeUtil.QRCodeListener
                public void onError(Throwable th) {
                    NLog b2 = SSDKLog.b();
                    b2.e(OnekeyShare.SHARESDK_TAG, "onError 二维码生成失败 " + th);
                    WaterMarkListener waterMarkListener2 = WaterMarkListener.this;
                    if (waterMarkListener2 != null) {
                        waterMarkListener2.onFailed("二维码生成失败", -5);
                    }
                }

                @Override // cn.sharesdk.framework.utils.QRCodeUtil.QRCodeListener
                public void onSuccess(Bitmap bitmap) {
                    String[] a2;
                    WaterMarkListener waterMarkListener2;
                    SSDKLog.b().d(OnekeyShare.SHARESDK_TAG, "onSuccess 二维码生成成功 ");
                    String str8 = c.b(c.c, bitmap, MobSDK.getContext()) + c.c;
                    if (TextUtils.isEmpty(str8) && (waterMarkListener2 = WaterMarkListener.this) != null) {
                        waterMarkListener2.onFailed("QR code image storage failed", -9);
                        return;
                    }
                    SSDKLog.b().d(OnekeyShare.SHARESDK_TAG, "图片保存的路径为: " + str8);
                    if (zArr[0]) {
                        SSDKLog.b().e(OnekeyShare.SHARESDK_TAG, "textMarkImage length: " + str7.length());
                        SSDKLog.b().e(OnekeyShare.SHARESDK_TAG, "imagePath length: " + str8.length());
                        a2 = c.a(str7, str8, "", str4, str6, 5);
                    } else {
                        a2 = c.a("", str8, "", str4, str6, 5);
                    }
                    int execute = FFmpeg.execute(a2);
                    if (execute == 0) {
                        SSDKLog.b().i("mobile-ffmpeg", "Async command execution completed successfully.");
                        SSDKLog.b().d(OnekeyShare.SHARESDK_TAG, " FFmpeg 命令行执行完成...onEnd ");
                        try {
                            if (!TextUtils.isEmpty(str6)) {
                                File file2 = new File(str6);
                                if (file2.length() >= 0) {
                                    d.a(file2);
                                    WaterMarkListener waterMarkListener3 = WaterMarkListener.this;
                                    if (waterMarkListener3 != null) {
                                        waterMarkListener3.onEnd(execute);
                                    }
                                } else {
                                    WaterMarkListener waterMarkListener4 = WaterMarkListener.this;
                                    if (waterMarkListener4 != null) {
                                        waterMarkListener4.onFailed("合成视频存储到本地异常", -8);
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            SSDKLog.b().e(OnekeyShare.SHARESDK_TAG, "onEnd catch: " + th);
                            WaterMarkListener waterMarkListener5 = WaterMarkListener.this;
                            if (waterMarkListener5 != null) {
                                waterMarkListener5.onFailed(th.getMessage(), -7);
                            }
                        }
                    } else {
                        SSDKLog.b().i("mobile-ffmpeg", String.format("Command execution failed with rc=%d and the output below.", Integer.valueOf(execute)));
                        Config.printLastCommandOutput(4);
                        WaterMarkListener waterMarkListener6 = WaterMarkListener.this;
                        if (waterMarkListener6 != null) {
                            waterMarkListener6.onFailed(String.format("Async command execution failed with rc=%d.", Integer.valueOf(execute)), -6);
                        }
                    }
                    f.a(new Runnable() { // from class: cn.sharesdk.framework.loopshare.watermark.c.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                        }
                    });
                }
            });
        } catch (ClassNotFoundException unused) {
            if (waterMarkListener != null) {
                waterMarkListener.onFailed("The specified package dependency does not exist, please make sure whether the related dependency package is pulled normally", -10);
            }
        }
    }

    public static String[] a(String str, String str2, String str3, String str4, String str5, int i2) {
        SSDKLog.b().d("LOGCAT", "ffmpeg params makeVideo: textIimageUrl: " + str + " imageUrl: " + str2 + " musicUrl: " + str3 + " videoUrl: " + str4 + " outputUrl: " + str5);
        ArrayList arrayList = new ArrayList();
        arrayList.add("-i");
        arrayList.add(str4);
        String str6 = "";
        if (!str.equals("") || !str2.equals("")) {
            if (!str2.equals("")) {
                arrayList.add("-loop");
                arrayList.add("0");
                arrayList.add("-i");
                arrayList.add(str2);
            }
            if (!str.equals("")) {
                arrayList.add("-i");
                arrayList.add(str);
            }
            arrayList.add("-filter_complex");
            if (str.equals("")) {
                arrayList.add("[1:v]scale=" + b.a + ":" + b.b + "[s];[0:v][s]overlay=0:0");
            } else if (str2.equals("")) {
                arrayList.add("overlay=x='if(lte(t," + g.c + "),(main_w-overlay_w)/2,NAN )':(main_h-overlay_h)/2");
            } else {
                arrayList.add("[1:v]scale=" + b.f137g + ":" + b.f138h + "[img1];[2:v]scale=" + g.a + ":" + g.b + "[img2];[0:v][img1]overlay=main_w-overlay_w-10:main_h-overlay_h-10[bkg];[bkg][img2]overlay=x='if(lte(t," + g.c + "),(main_w-overlay_w)/2,NAN )':(main_h-overlay_h)/2");
            }
        }
        if (!str3.equals("")) {
            arrayList.add("-i");
            arrayList.add(str3);
        }
        arrayList.add(str5);
        int size = arrayList.size();
        String[] strArr = new String[size];
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            strArr[i3] = (String) arrayList.get(i3);
            str6 = str6 + strArr[i3];
        }
        SSDKLog.b().d("LOGCAT", "ffmpeg command:" + str6 + size);
        return strArr;
    }
}
