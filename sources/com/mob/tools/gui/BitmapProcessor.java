package com.mob.tools.gui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import com.mob.tools.MobHandlerThread;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.ResHelper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
/* loaded from: classes2.dex */
public class BitmapProcessor {
    private static final int CAPACITY = 3;
    private static final int MAX_CACHE_SIZE = 50;
    private static final int MAX_CACHE_TIME = 60000;
    private static final int MAX_REQ_TIME = 20000;
    private static final int MAX_SIZE = 100;
    private static final int OVERFLOW_SIZE = 120;
    private static final int SCAN_INTERVAL = 20000;
    private static File cacheDir;
    private static CachePool<String, SoftReference<Bitmap>> cachePool;
    private static ManagerThread manager;
    private static ArrayList<ImageReq> netReqTPS;
    private static ArrayList<ImageReq> reqList;
    private static NetworkHelper.NetworkTimeOut timeout;
    private static boolean work;
    private static WorkerThread[] workerList;

    /* loaded from: classes2.dex */
    public interface BitmapCallback {
        void onImageGot(String str, Bitmap bitmap);
    }

    /* loaded from: classes2.dex */
    public static class BitmapDesiredOptions {
        public int desiredWidth = 0;
        public int desiredHeight = 0;
        public long maxBytes = 0;
        public int quality = 0;

        public boolean equals(Object obj) {
            return super.equals(obj) || (obj != null && obj.toString().equals(toString()));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            int i2 = this.desiredWidth;
            if (i2 > 0) {
                sb.append(i2);
            }
            int i3 = this.desiredHeight;
            if (i3 > 0) {
                sb.append(i3);
            }
            long j2 = this.maxBytes;
            if (j2 > 0) {
                sb.append(j2);
            }
            int i4 = this.quality;
            if (i4 > 0) {
                sb.append(i4);
            }
            return sb.toString();
        }
    }

    /* loaded from: classes2.dex */
    public static class ImageReq {
        private BitmapDesiredOptions bitmapDesiredOptions;
        private String url;
        private WorkerThread worker;
        private boolean useRamCache = true;
        private boolean useDiskCache = true;
        private long diskCacheTime = 0;
        private long reqTime = System.currentTimeMillis();
        private ArrayList<BitmapCallback> callbacks = new ArrayList<>();

        /* JADX INFO: Access modifiers changed from: private */
        public void throwComplete(Bitmap bitmap) {
            Iterator<BitmapCallback> it = this.callbacks.iterator();
            while (it.hasNext()) {
                it.next().onImageGot(this.url, bitmap);
            }
            this.callbacks.clear();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void throwError() {
            Iterator<BitmapCallback> it = this.callbacks.iterator();
            while (it.hasNext()) {
                it.next().onImageGot(this.url, null);
            }
            this.callbacks.clear();
        }

        public String toString() {
            return "url=" + this.url + "time=" + this.reqTime + "worker=" + this.worker.getName() + " (" + this.worker.getId() + "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class ManagerThread implements Handler.Callback {
        private Handler handler;

        public ManagerThread() {
            Handler newHandler = MobHandlerThread.newHandler(new Runnable() { // from class: com.mob.tools.gui.BitmapProcessor.ManagerThread.1
                @Override // java.lang.Runnable
                public void run() {
                    int i2 = 0;
                    while (i2 < BitmapProcessor.workerList.length) {
                        if (BitmapProcessor.workerList[i2] == null) {
                            BitmapProcessor.workerList[i2] = new WorkerThread();
                            WorkerThread workerThread = BitmapProcessor.workerList[i2];
                            workerThread.setName("worker " + i2);
                            BitmapProcessor.workerList[i2].localType = i2 == 0;
                            BitmapProcessor.workerList[i2].start();
                        }
                        i2++;
                    }
                }
            }, this);
            this.handler = newHandler;
            newHandler.sendEmptyMessageDelayed(1, 20000L);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (BitmapProcessor.cachePool != null) {
                BitmapProcessor.cachePool.trimBeforeTime(System.currentTimeMillis() - 60000);
            }
            int size = BitmapProcessor.cachePool == null ? 0 : BitmapProcessor.cachePool.size();
            NLog mobLog = MobLog.getInstance();
            mobLog.d(">>>> BitmapProcessor.cachePool: " + size, new Object[0]);
            int size2 = BitmapProcessor.reqList == null ? 0 : BitmapProcessor.reqList.size();
            NLog mobLog2 = MobLog.getInstance();
            mobLog2.d(">>>> BitmapProcessor.reqList: " + size2, new Object[0]);
            if (BitmapProcessor.work) {
                this.handler.sendEmptyMessageDelayed(1, 20000L);
            }
            return false;
        }

        public void quit() {
            this.handler.removeMessages(1);
            this.handler.getLooper().quit();
            for (int i2 = 0; i2 < BitmapProcessor.workerList.length; i2++) {
                if (BitmapProcessor.workerList[i2] != null) {
                    BitmapProcessor.workerList[i2].interrupt();
                    BitmapProcessor.workerList[i2] = null;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    private static class PatchInputStream extends FilterInputStream {
        InputStream in;

        protected PatchInputStream(InputStream inputStream) {
            super(inputStream);
            this.in = inputStream;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j2) throws IOException {
            long j3 = 0;
            while (j3 < j2) {
                long skip = this.in.skip(j2 - j3);
                if (skip == 0) {
                    break;
                }
                j3 += skip;
            }
            return j3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class WorkerThread extends Thread {
        private ImageReq curReq;
        private boolean localType;

        private WorkerThread() {
        }

        private void doLocalTask() throws Throwable {
            Bitmap bitmap;
            ImageReq imageReq;
            SoftReference softReference;
            synchronized (BitmapProcessor.reqList) {
                bitmap = null;
                imageReq = BitmapProcessor.reqList.size() > 0 ? (ImageReq) BitmapProcessor.reqList.remove(0) : null;
            }
            if (imageReq != null) {
                if (imageReq.useRamCache && (softReference = (SoftReference) BitmapProcessor.cachePool.get(BitmapProcessor.getCacheKey(imageReq.url, imageReq.bitmapDesiredOptions))) != null) {
                    bitmap = (Bitmap) softReference.get();
                }
                if (bitmap == null) {
                    if (!imageReq.useDiskCache || BitmapProcessor.cacheDir == null || !new File(BitmapProcessor.cacheDir, Data.MD5(imageReq.url)).exists()) {
                        synchronized (BitmapProcessor.reqList) {
                            if (BitmapProcessor.netReqTPS.size() > 100) {
                                synchronized (BitmapProcessor.reqList) {
                                    while (BitmapProcessor.reqList.size() > 0) {
                                        BitmapProcessor.reqList.remove(0);
                                    }
                                }
                                BitmapProcessor.netReqTPS.remove(0);
                            }
                        }
                        BitmapProcessor.netReqTPS.add(imageReq);
                        return;
                    }
                    doTask(imageReq);
                    return;
                }
                this.curReq = imageReq;
                imageReq.worker = this;
                imageReq.throwComplete(bitmap);
                return;
            }
            try {
                Thread.sleep(30L);
            } catch (Throwable unused) {
            }
        }

        private void doNetworkTask() throws Throwable {
            Bitmap bitmap;
            ImageReq imageReq;
            SoftReference softReference;
            synchronized (BitmapProcessor.netReqTPS) {
                bitmap = null;
                imageReq = BitmapProcessor.netReqTPS.size() > 0 ? (ImageReq) BitmapProcessor.netReqTPS.remove(0) : null;
            }
            if (imageReq == null) {
                synchronized (BitmapProcessor.reqList) {
                    if (BitmapProcessor.reqList.size() > 0) {
                        imageReq = (ImageReq) BitmapProcessor.reqList.remove(0);
                    }
                }
            }
            if (imageReq != null) {
                if (imageReq.useRamCache && (softReference = (SoftReference) BitmapProcessor.cachePool.get(BitmapProcessor.getCacheKey(imageReq.url, imageReq.bitmapDesiredOptions))) != null) {
                    bitmap = (Bitmap) softReference.get();
                }
                if (bitmap != null) {
                    this.curReq = imageReq;
                    imageReq.worker = this;
                    imageReq.throwComplete(bitmap);
                    return;
                }
                doTask(imageReq);
                return;
            }
            try {
                Thread.sleep(30L);
            } catch (Throwable unused) {
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x009a A[Catch: all -> 0x00d8, TryCatch #0 {all -> 0x00d8, blocks: (B:3:0x0001, B:5:0x001d, B:7:0x0027, B:9:0x002d, B:11:0x003e, B:12:0x0041, B:14:0x0047, B:16:0x004d, B:18:0x0053, B:20:0x0059, B:23:0x0066, B:26:0x009a, B:28:0x00a0, B:29:0x00b8, B:31:0x00bf, B:30:0x00bc, B:24:0x0090, B:32:0x00c2), top: B:37:0x0001 }] */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00bc A[Catch: all -> 0x00d8, TryCatch #0 {all -> 0x00d8, blocks: (B:3:0x0001, B:5:0x001d, B:7:0x0027, B:9:0x002d, B:11:0x003e, B:12:0x0041, B:14:0x0047, B:16:0x004d, B:18:0x0053, B:20:0x0059, B:23:0x0066, B:26:0x009a, B:28:0x00a0, B:29:0x00b8, B:31:0x00bf, B:30:0x00bc, B:24:0x0090, B:32:0x00c2), top: B:37:0x0001 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private void doTask(final com.mob.tools.gui.BitmapProcessor.ImageReq r11) throws java.lang.Throwable {
            /*
                r10 = this;
                r0 = 0
                r10.curReq = r11     // Catch: java.lang.Throwable -> Ld8
                com.mob.tools.gui.BitmapProcessor.ImageReq.access$1402(r11, r10)     // Catch: java.lang.Throwable -> Ld8
                java.lang.String r1 = com.mob.tools.gui.BitmapProcessor.ImageReq.access$000(r11)     // Catch: java.lang.Throwable -> Ld8
                java.lang.String r1 = com.mob.tools.utils.Data.MD5(r1)     // Catch: java.lang.Throwable -> Ld8
                java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> Ld8
                java.io.File r3 = com.mob.tools.gui.BitmapProcessor.access$1600()     // Catch: java.lang.Throwable -> Ld8
                r2.<init>(r3, r1)     // Catch: java.lang.Throwable -> Ld8
                boolean r3 = com.mob.tools.gui.BitmapProcessor.ImageReq.access$500(r11)     // Catch: java.lang.Throwable -> Ld8
                if (r3 == 0) goto L41
                long r3 = com.mob.tools.gui.BitmapProcessor.ImageReq.access$400(r11)     // Catch: java.lang.Throwable -> Ld8
                r5 = 0
                int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r7 <= 0) goto L41
                boolean r3 = r2.exists()     // Catch: java.lang.Throwable -> Ld8
                if (r3 == 0) goto L41
                long r3 = r2.lastModified()     // Catch: java.lang.Throwable -> Ld8
                long r5 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> Ld8
                long r7 = com.mob.tools.gui.BitmapProcessor.ImageReq.access$400(r11)     // Catch: java.lang.Throwable -> Ld8
                long r3 = r3 + r7
                int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r7 >= 0) goto L41
                r2.delete()     // Catch: java.lang.Throwable -> Ld8
            L41:
                boolean r3 = com.mob.tools.gui.BitmapProcessor.ImageReq.access$500(r11)     // Catch: java.lang.Throwable -> Ld8
                if (r3 == 0) goto Lc2
                java.io.File r3 = com.mob.tools.gui.BitmapProcessor.access$1600()     // Catch: java.lang.Throwable -> Ld8
                if (r3 == 0) goto Lc2
                boolean r3 = r2.exists()     // Catch: java.lang.Throwable -> Ld8
                if (r3 == 0) goto Lc2
                com.mob.tools.gui.BitmapProcessor$BitmapDesiredOptions r3 = com.mob.tools.gui.BitmapProcessor.ImageReq.access$100(r11)     // Catch: java.lang.Throwable -> Ld8
                if (r3 == 0) goto L90
                com.mob.tools.gui.BitmapProcessor$BitmapDesiredOptions r3 = com.mob.tools.gui.BitmapProcessor.ImageReq.access$100(r11)     // Catch: java.lang.Throwable -> Ld8
                java.lang.String r4 = ""
                boolean r3 = r3.equals(r4)     // Catch: java.lang.Throwable -> Ld8
                if (r3 == 0) goto L66
                goto L90
            L66:
                java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> Ld8
                java.io.File r3 = com.mob.tools.gui.BitmapProcessor.access$1600()     // Catch: java.lang.Throwable -> Ld8
                r2.<init>(r3, r1)     // Catch: java.lang.Throwable -> Ld8
                java.lang.String r4 = r2.getAbsolutePath()     // Catch: java.lang.Throwable -> Ld8
                com.mob.tools.gui.BitmapProcessor$BitmapDesiredOptions r1 = com.mob.tools.gui.BitmapProcessor.ImageReq.access$100(r11)     // Catch: java.lang.Throwable -> Ld8
                int r5 = r1.desiredWidth     // Catch: java.lang.Throwable -> Ld8
                com.mob.tools.gui.BitmapProcessor$BitmapDesiredOptions r1 = com.mob.tools.gui.BitmapProcessor.ImageReq.access$100(r11)     // Catch: java.lang.Throwable -> Ld8
                int r6 = r1.desiredHeight     // Catch: java.lang.Throwable -> Ld8
                com.mob.tools.gui.BitmapProcessor$BitmapDesiredOptions r1 = com.mob.tools.gui.BitmapProcessor.ImageReq.access$100(r11)     // Catch: java.lang.Throwable -> Ld8
                int r7 = r1.quality     // Catch: java.lang.Throwable -> Ld8
                com.mob.tools.gui.BitmapProcessor$BitmapDesiredOptions r1 = com.mob.tools.gui.BitmapProcessor.ImageReq.access$100(r11)     // Catch: java.lang.Throwable -> Ld8
                long r8 = r1.maxBytes     // Catch: java.lang.Throwable -> Ld8
                android.graphics.Bitmap r1 = com.mob.tools.utils.BitmapHelper.getBitmapByCompressQuality(r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> Ld8
                goto L98
            L90:
                java.lang.String r1 = r2.getAbsolutePath()     // Catch: java.lang.Throwable -> Ld8
                android.graphics.Bitmap r1 = com.mob.tools.utils.BitmapHelper.getBitmap(r1)     // Catch: java.lang.Throwable -> Ld8
            L98:
                if (r1 == 0) goto Lbc
                boolean r2 = com.mob.tools.gui.BitmapProcessor.ImageReq.access$300(r11)     // Catch: java.lang.Throwable -> Ld8
                if (r2 == 0) goto Lb8
                com.mob.tools.gui.CachePool r2 = com.mob.tools.gui.BitmapProcessor.access$1000()     // Catch: java.lang.Throwable -> Ld8
                java.lang.String r3 = com.mob.tools.gui.BitmapProcessor.ImageReq.access$000(r11)     // Catch: java.lang.Throwable -> Ld8
                com.mob.tools.gui.BitmapProcessor$BitmapDesiredOptions r4 = com.mob.tools.gui.BitmapProcessor.ImageReq.access$100(r11)     // Catch: java.lang.Throwable -> Ld8
                java.lang.String r3 = com.mob.tools.gui.BitmapProcessor.access$1300(r3, r4)     // Catch: java.lang.Throwable -> Ld8
                java.lang.ref.SoftReference r4 = new java.lang.ref.SoftReference     // Catch: java.lang.Throwable -> Ld8
                r4.<init>(r1)     // Catch: java.lang.Throwable -> Ld8
                r2.put(r3, r4)     // Catch: java.lang.Throwable -> Ld8
            Lb8:
                com.mob.tools.gui.BitmapProcessor.ImageReq.access$1500(r11, r1)     // Catch: java.lang.Throwable -> Ld8
                goto Lbf
            Lbc:
                com.mob.tools.gui.BitmapProcessor.ImageReq.access$1800(r11)     // Catch: java.lang.Throwable -> Ld8
            Lbf:
                r10.curReq = r0     // Catch: java.lang.Throwable -> Ld8
                goto Le5
            Lc2:
                com.mob.tools.network.NetworkHelper r2 = new com.mob.tools.network.NetworkHelper     // Catch: java.lang.Throwable -> Ld8
                r2.<init>()     // Catch: java.lang.Throwable -> Ld8
                java.lang.String r3 = com.mob.tools.gui.BitmapProcessor.ImageReq.access$000(r11)     // Catch: java.lang.Throwable -> Ld8
                com.mob.tools.gui.BitmapProcessor$WorkerThread$1 r4 = new com.mob.tools.gui.BitmapProcessor$WorkerThread$1     // Catch: java.lang.Throwable -> Ld8
                r4.<init>()     // Catch: java.lang.Throwable -> Ld8
                com.mob.tools.network.NetworkHelper$NetworkTimeOut r1 = com.mob.tools.gui.BitmapProcessor.access$2100()     // Catch: java.lang.Throwable -> Ld8
                r2.rawGet(r3, r4, r1)     // Catch: java.lang.Throwable -> Ld8
                goto Le5
            Ld8:
                r1 = move-exception
                com.mob.tools.log.NLog r2 = com.mob.tools.MobLog.getInstance()
                r2.w(r1)
                com.mob.tools.gui.BitmapProcessor.ImageReq.access$1800(r11)
                r10.curReq = r0
            Le5:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.gui.BitmapProcessor.WorkerThread.doTask(com.mob.tools.gui.BitmapProcessor$ImageReq):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void saveFile(InputStream inputStream, File file) {
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    if (file.exists()) {
                        file.delete();
                    }
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                    file.createNewFile();
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        byte[] bArr = new byte[256];
                        int read = inputStream.read(bArr);
                        while (read > 0) {
                            fileOutputStream2.write(bArr, 0, read);
                            read = inputStream.read(bArr);
                        }
                        fileOutputStream2.flush();
                        fileOutputStream2.close();
                    } catch (Throwable unused) {
                        fileOutputStream = fileOutputStream2;
                        try {
                            if (file.exists()) {
                                file.delete();
                            }
                            fileOutputStream.close();
                            inputStream.close();
                        } catch (Throwable th) {
                            try {
                                fileOutputStream.close();
                                inputStream.close();
                            } catch (Throwable unused2) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable unused3) {
                }
                inputStream.close();
            } catch (Throwable unused4) {
            }
        }

        @Override // java.lang.Thread
        public void interrupt() {
            try {
                super.interrupt();
            } catch (Throwable unused) {
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (BitmapProcessor.work) {
                try {
                    if (this.localType) {
                        doLocalTask();
                    } else {
                        doNetworkTask();
                    }
                } catch (Throwable th) {
                    MobLog.getInstance().w(th);
                }
            }
        }
    }

    static {
        NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
        timeout = networkTimeOut;
        networkTimeOut.connectionTimeout = 5000;
        networkTimeOut.readTimout = 20000 - 5000;
        reqList = new ArrayList<>();
        netReqTPS = new ArrayList<>();
        workerList = new WorkerThread[3];
        cachePool = new CachePool<>(50);
    }

    public static void deleteCacheDir(boolean z) {
        if (z) {
            deleteCacheDir();
        } else {
            new Thread() { // from class: com.mob.tools.gui.BitmapProcessor.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    BitmapProcessor.deleteCacheDir();
                }
            }.start();
        }
    }

    public static void deleteCachedFile(String str, BitmapDesiredOptions bitmapDesiredOptions) {
        removeBitmapFromRamCache(str, bitmapDesiredOptions);
        try {
            new File(cacheDir, Data.MD5(str)).delete();
        } catch (Throwable unused) {
        }
    }

    public static Bitmap getBitmapFromCache(String str) {
        return getBitmapFromCache(str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getCacheKey(String str, BitmapDesiredOptions bitmapDesiredOptions) {
        if (bitmapDesiredOptions == null) {
            return str;
        }
        return str + bitmapDesiredOptions.toString();
    }

    public static long getCacheSizeInByte() {
        long j2 = 0;
        for (File file : new File(cacheDir.getPath()).listFiles()) {
            j2 += file.length();
        }
        return j2;
    }

    public static String getCacheSizeText() {
        float cacheSizeInByte = (float) getCacheSizeInByte();
        if (cacheSizeInByte < 1024.0f) {
            return String.format(Locale.CHINA, "%.02f", Float.valueOf(cacheSizeInByte)) + " B";
        }
        float f2 = cacheSizeInByte / 1024.0f;
        if (f2 < 1000.0f) {
            return String.format(Locale.CHINA, "%.02f", Float.valueOf(f2)) + " KB";
        }
        return String.format(Locale.CHINA, "%.02f", Float.valueOf(f2 / 1204.0f)) + " MB";
    }

    public static synchronized void prepare(Context context) {
        synchronized (BitmapProcessor.class) {
            cacheDir = new File(ResHelper.getImageCachePath(context));
        }
    }

    public static synchronized void process(String str, BitmapCallback bitmapCallback) {
        synchronized (BitmapProcessor.class) {
            process(str, null, bitmapCallback);
        }
    }

    public static void removeBitmapFromRamCache(String str, BitmapDesiredOptions bitmapDesiredOptions) {
        CachePool<String, SoftReference<Bitmap>> cachePool2 = cachePool;
        if (cachePool2 != null) {
            cachePool2.put(getCacheKey(str, bitmapDesiredOptions), null);
        }
    }

    public static synchronized void start() {
        synchronized (BitmapProcessor.class) {
            if (!work) {
                work = true;
                manager = new ManagerThread();
            }
        }
    }

    public static synchronized void stop() {
        synchronized (BitmapProcessor.class) {
            if (work) {
                work = false;
                synchronized (reqList) {
                    reqList.clear();
                    cachePool.clear();
                }
                manager.quit();
            }
        }
    }

    public static Bitmap getBitmapFromCache(String str, BitmapDesiredOptions bitmapDesiredOptions) {
        CachePool<String, SoftReference<Bitmap>> cachePool2 = cachePool;
        if (cachePool2 == null || str == null || cachePool2.get(getCacheKey(str, bitmapDesiredOptions)) == null) {
            return null;
        }
        return cachePool.get(getCacheKey(str, bitmapDesiredOptions)).get();
    }

    public static synchronized void process(String str, BitmapDesiredOptions bitmapDesiredOptions, BitmapCallback bitmapCallback) {
        synchronized (BitmapProcessor.class) {
            process(str, bitmapDesiredOptions, true, bitmapCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void deleteCacheDir() {
        synchronized (BitmapProcessor.class) {
            File file = new File(cacheDir.getPath());
            if (file.isDirectory()) {
                for (String str : file.list()) {
                    new File(file, str).delete();
                }
            }
        }
    }

    public static synchronized void process(String str, BitmapDesiredOptions bitmapDesiredOptions, boolean z, BitmapCallback bitmapCallback) {
        synchronized (BitmapProcessor.class) {
            process(str, bitmapDesiredOptions, z, true, bitmapCallback);
        }
    }

    public static synchronized void process(String str, BitmapDesiredOptions bitmapDesiredOptions, boolean z, boolean z2, BitmapCallback bitmapCallback) {
        synchronized (BitmapProcessor.class) {
            process(str, bitmapDesiredOptions, z, z2, 0L, bitmapCallback);
        }
    }

    public static synchronized void process(String str, BitmapDesiredOptions bitmapDesiredOptions, boolean z, boolean z2, long j2, BitmapCallback bitmapCallback) {
        synchronized (BitmapProcessor.class) {
            if (str == null) {
                return;
            }
            synchronized (reqList) {
                int size = reqList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ImageReq imageReq = reqList.get(i2);
                    boolean equals = imageReq.url.equals(str);
                    boolean z3 = (imageReq.bitmapDesiredOptions == null && bitmapDesiredOptions == null) || (imageReq.bitmapDesiredOptions != null && imageReq.bitmapDesiredOptions.equals(bitmapDesiredOptions));
                    if (equals && z3) {
                        if (bitmapCallback != null && imageReq.callbacks.indexOf(bitmapCallback) == -1) {
                            imageReq.callbacks.add(bitmapCallback);
                        }
                        start();
                        return;
                    }
                }
                ImageReq imageReq2 = new ImageReq();
                imageReq2.url = str;
                imageReq2.bitmapDesiredOptions = bitmapDesiredOptions;
                imageReq2.useRamCache = z;
                imageReq2.diskCacheTime = j2;
                imageReq2.useDiskCache = z2;
                if (bitmapCallback != null) {
                    imageReq2.callbacks.add(bitmapCallback);
                }
                synchronized (reqList) {
                    reqList.add(imageReq2);
                    if (reqList.size() > 120) {
                        while (reqList.size() > 100) {
                            reqList.remove(0);
                        }
                    }
                }
                start();
            }
        }
    }
}
