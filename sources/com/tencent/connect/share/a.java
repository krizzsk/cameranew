package com.tencent.connect.share;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.d;
import com.tencent.open.utils.f;
import com.tencent.open.utils.l;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
/* compiled from: ProGuard */
/* loaded from: classes3.dex */
public class a {

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.connect.share.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    static class HandlerC0271a extends Handler {
        final /* synthetic */ d a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        HandlerC0271a(Looper looper, d dVar) {
            super(looper);
            this.a = dVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 101) {
                this.a.a(0, (ArrayList) message.obj);
            } else if (i2 != 102) {
                super.handleMessage(message);
            } else {
                this.a.a(message.arg1, (String) null);
            }
        }
    }

    /* compiled from: ProGuard */
    /* loaded from: classes3.dex */
    static class b implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ Handler b;
        final /* synthetic */ Context c;

        b(String str, Handler handler, Context context) {
            this.a = str;
            this.b = handler;
            this.c = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            String str2;
            try {
                Bitmap a = a.a(this.a, 840);
                if (a != null) {
                    File a2 = f.a("Images");
                    String str3 = null;
                    if (a2 != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(a2.getAbsolutePath());
                        String str4 = File.separator;
                        sb.append(str4);
                        sb.append(Constants.QQ_SHARE_TEMP_DIR);
                        sb.append(str4);
                        str2 = sb.toString();
                        str = null;
                    } else {
                        File d2 = f.d();
                        if (d2 == null) {
                            SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() getCacheDir = null,return error");
                            Message obtainMessage = this.b.obtainMessage();
                            obtainMessage.arg1 = 102;
                            this.b.sendMessage(obtainMessage);
                            return;
                        }
                        String absolutePath = d2.getAbsolutePath();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(absolutePath);
                        String str5 = File.separator;
                        sb2.append(str5);
                        sb2.append(Constants.QQ_SHARE_TEMP_DIR);
                        sb2.append(str5);
                        String sb3 = sb2.toString();
                        SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() use cache dir=" + sb3);
                        str = absolutePath;
                        str2 = sb3;
                    }
                    String str6 = "share2qq_temp" + l.f(this.a) + ".jpg";
                    String str7 = this.a;
                    if (!a.b(str7, 840, 840)) {
                        SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() not out of bound,not compress!");
                    } else {
                        SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() out of bound,compress!");
                        String a3 = a.a(a, str2, str6);
                        if (!TextUtils.isEmpty(a3)) {
                            str7 = a3;
                        }
                    }
                    boolean n = l.n(str7);
                    SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() check file isAppSpecificDir=" + n);
                    ArrayList arrayList = new ArrayList(2);
                    if (n) {
                        str3 = str7;
                    } else if (TextUtils.isEmpty(str)) {
                        String str8 = str2 + str6;
                        boolean a4 = l.a(this.c, str7, str8);
                        SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() sd permission not denied. copy to app sepcific:" + str8 + ",isSuccess=" + a4);
                        if (a4) {
                            str3 = str8;
                        }
                    }
                    arrayList.add(str7);
                    arrayList.add(str3);
                    if (arrayList.size() >= 2 && (arrayList.get(0) != null || arrayList.get(1) != null)) {
                        SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() return success ! destFilePath=[" + ((String) arrayList.get(0)) + "," + ((String) arrayList.get(1)) + "]");
                        Message obtainMessage2 = this.b.obtainMessage(101);
                        obtainMessage2.obj = arrayList;
                        this.b.sendMessage(obtainMessage2);
                        return;
                    }
                }
            } catch (Exception e2) {
                SLog.e("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage runnable exception e:", e2);
            }
            SLog.d("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() return failed!");
            Message obtainMessage3 = this.b.obtainMessage(102);
            obtainMessage3.arg1 = 3;
            this.b.sendMessage(obtainMessage3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b(String str, int i2, int i3) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError e2) {
            SLog.e("openSDK_LOG.AsynScaleCompressImage", "isBitMapNeedToCompress exception:", e2);
        }
        int i4 = options.outWidth;
        int i5 = options.outHeight;
        if (options.mCancel || i4 == -1 || i5 == -1) {
            return false;
        }
        int i6 = i4 > i5 ? i4 : i5;
        if (i4 >= i5) {
            i4 = i5;
        }
        SLog.d("openSDK_LOG.AsynScaleCompressImage", "longSide=" + i6 + "shortSide=" + i4);
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        return i6 > i3 || i4 > i2;
    }

    public static final void a(Context context, String str, d dVar) {
        SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage()");
        if (TextUtils.isEmpty(str)) {
            dVar.a(1, (String) null);
        } else if (!l.a()) {
            dVar.a(2, (String) null);
        } else {
            new Thread(new b(str, new HandlerC0271a(context.getMainLooper(), dVar), context)).start();
        }
    }

    private static Bitmap a(Bitmap bitmap, int i2) {
        Matrix matrix = new Matrix();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= height) {
            width = height;
        }
        float f2 = i2 / width;
        matrix.postScale(f2, f2);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    private static int b(BitmapFactory.Options options, int i2, int i3) {
        int min;
        double d2 = options.outWidth;
        double d3 = options.outHeight;
        int ceil = i3 == -1 ? 1 : (int) Math.ceil(Math.sqrt((d2 * d3) / i3));
        if (i2 == -1) {
            min = 128;
        } else {
            double d4 = i2;
            min = (int) Math.min(Math.floor(d2 / d4), Math.floor(d3 / d4));
        }
        if (min < ceil) {
            return ceil;
        }
        if (i3 == -1 && i2 == -1) {
            return 1;
        }
        return i2 == -1 ? ceil : min;
    }

    protected static final String a(Bitmap bitmap, String str, String str2) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        StringBuffer stringBuffer = new StringBuffer(str);
        stringBuffer.append(str2);
        String stringBuffer2 = stringBuffer.toString();
        File file2 = new File(stringBuffer2);
        if (file2.exists()) {
            file2.delete();
        }
        if (bitmap != null) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                bitmap.recycle();
                return stringBuffer2;
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
                return null;
            } catch (IOException e3) {
                e3.printStackTrace();
                return null;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final android.graphics.Bitmap a(java.lang.String r6, int r7) {
        /*
            java.lang.String r0 = "openSDK_LOG.AsynScaleCompressImage"
            boolean r1 = android.text.TextUtils.isEmpty(r6)
            r2 = 0
            if (r1 == 0) goto La
            return r2
        La:
            android.graphics.BitmapFactory$Options r1 = new android.graphics.BitmapFactory$Options
            r1.<init>()
            r3 = 1
            r1.inJustDecodeBounds = r3
            android.graphics.BitmapFactory.decodeFile(r6, r1)     // Catch: java.lang.OutOfMemoryError -> L16
            goto L1c
        L16:
            r3 = move-exception
            java.lang.String r4 = "scaleBitmap exception1:"
            com.tencent.open.log.SLog.e(r0, r4, r3)
        L1c:
            int r3 = r1.outWidth
            int r4 = r1.outHeight
            boolean r5 = r1.mCancel
            if (r5 != 0) goto L69
            r5 = -1
            if (r3 == r5) goto L69
            if (r4 != r5) goto L2a
            goto L69
        L2a:
            if (r3 <= r4) goto L2d
            goto L2e
        L2d:
            r3 = r4
        L2e:
            android.graphics.Bitmap$Config r4 = android.graphics.Bitmap.Config.RGB_565
            r1.inPreferredConfig = r4
            if (r3 <= r7) goto L3c
            int r3 = r7 * r7
            int r3 = a(r1, r5, r3)
            r1.inSampleSize = r3
        L3c:
            r3 = 0
            r1.inJustDecodeBounds = r3
            android.graphics.Bitmap r6 = android.graphics.BitmapFactory.decodeFile(r6, r1)     // Catch: java.lang.OutOfMemoryError -> L44 java.lang.Exception -> L4b
            goto L52
        L44:
            r6 = move-exception
            java.lang.String r3 = "scaleBitmap OutOfMemoryError:"
            com.tencent.open.log.SLog.e(r0, r3, r6)
            goto L51
        L4b:
            r6 = move-exception
            java.lang.String r3 = "scaleBitmap exception2:"
            com.tencent.open.log.SLog.e(r0, r3, r6)
        L51:
            r6 = r2
        L52:
            if (r6 != 0) goto L5a
            java.lang.String r6 = "scaleBitmap return null"
            com.tencent.open.log.SLog.e(r0, r6)
            return r2
        L5a:
            int r0 = r1.outWidth
            int r1 = r1.outHeight
            if (r0 <= r1) goto L61
            goto L62
        L61:
            r0 = r1
        L62:
            if (r0 <= r7) goto L68
            android.graphics.Bitmap r6 = a(r6, r7)
        L68:
            return r6
        L69:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.connect.share.a.a(java.lang.String, int):android.graphics.Bitmap");
    }

    public static final int a(BitmapFactory.Options options, int i2, int i3) {
        int b2 = b(options, i2, i3);
        if (b2 <= 8) {
            int i4 = 1;
            while (i4 < b2) {
                i4 <<= 1;
            }
            return i4;
        }
        return ((b2 + 7) / 8) * 8;
    }
}
