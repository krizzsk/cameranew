package us.pinguo.advconfigdata.DownLoadImage;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import us.pinguo.advconfigdata.Interface.AdvDownLoadLisenter;
import us.pinguo.advconfigdata.Utils.AdvFileUtils;
import us.pinguo.advconfigdata.Utils.AdvLog;
import us.pinguo.advconfigdata.Utils.AdvSystemUtils;
import us.pinguo.advconfigdata.Utils.AdvUtils;
/* loaded from: classes3.dex */
public class AdvImageDownloader {
    private static final int MAX_CACHE_SIZE = 35;
    private static final int MSG_ON_ERROR_RESPONSE = 1;
    private static final int MSG_ON_SUCCESS_RESPONSE = 2;
    private Context mContext;
    public final Executor mDownloadTaskExecutor;
    private final List<String> mDownloadingUrlList = new ArrayList();
    private final SSLSocketFactory mSslSocketFactory;
    private Handler mUiHandler;

    /* loaded from: classes3.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            int i2 = message.what;
            if (i2 == 2) {
                AdvImageDownloader.this.onResponse((c) message.obj);
            } else if (i2 == 1) {
                AdvImageDownloader.this.onErrorResponse((c) message.obj);
            }
        }
    }

    /* loaded from: classes3.dex */
    private class b implements Runnable {

        /* loaded from: classes3.dex */
        class a implements Comparator<File> {
            a(b bVar) {
            }

            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(File file, File file2) {
                int i2;
                if (file == null) {
                    return file2 == null ? 0 : -1;
                } else if (file2 != null && file.lastModified() <= file2.lastModified()) {
                    return i2 < 0 ? -1 : 0;
                } else {
                    return 1;
                }
            }
        }

        private b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            File[] listFiles;
            String advImageCacheDir = AdvUtils.getAdvImageCacheDir(AdvImageDownloader.this.mContext);
            if (advImageCacheDir == null) {
                return;
            }
            File file = new File(advImageCacheDir);
            if (!file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null || listFiles.length <= 35) {
                return;
            }
            int length = listFiles.length - 26;
            Arrays.sort(listFiles, new a(this));
            for (int i2 = 0; i2 < length; i2++) {
                listFiles[i2].delete();
            }
        }

        /* synthetic */ b(AdvImageDownloader advImageDownloader, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c implements Runnable {
        private final AtomicBoolean a = new AtomicBoolean();
        private String b;
        private String c;

        /* renamed from: d  reason: collision with root package name */
        private String f9022d;

        /* renamed from: e  reason: collision with root package name */
        public AdvDownLoadLisenter f9023e;

        public c(String str, String str2, String str3, AdvDownLoadLisenter advDownLoadLisenter) {
            this.b = str;
            this.c = str2;
            this.f9022d = str3;
            this.f9023e = advDownLoadLisenter;
        }

        private String a(String str, String str2, String str3) throws Exception {
            AdvLog.Log("start down url:" + str + "," + str2 + "," + str3);
            if (AdvFileUtils.checkFolder(str2)) {
                if (AdvSystemUtils.hasNet(AdvImageDownloader.this.mContext)) {
                    URL url = new URL(str);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    us.pinguo.advconfigdata.a.a.d(httpURLConnection, str);
                    if ("https".equals(url.getProtocol()) && AdvImageDownloader.this.mSslSocketFactory != null) {
                        ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(AdvImageDownloader.this.mSslSocketFactory);
                    }
                    try {
                        HttpURLConnection.setFollowRedirects(true);
                        int responseCode = httpURLConnection.getResponseCode();
                        if (responseCode == 200) {
                            if (str3 == null || str3.isEmpty()) {
                                str3 = str.substring(str.lastIndexOf("/") + 1);
                            }
                            b(str2 + File.separator + str3, httpURLConnection);
                            return str3;
                        }
                        throw new IOException("Http connect error,status code =" + responseCode);
                    } finally {
                        httpURLConnection.disconnect();
                    }
                }
                throw new IOException("no internet");
            }
            throw new IOException("Create folder(" + str2 + ") failed!");
        }

        /* JADX WARN: Not initialized variable reg: 1, insn: 0x0051: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:27:0x0051 */
        private void b(String str, HttpURLConnection httpURLConnection) throws Exception {
            FileOutputStream fileOutputStream;
            int read;
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                    try {
                        File file = new File(str);
                        FileOutputStream fileOutputStream3 = new FileOutputStream(str);
                        try {
                            byte[] bArr = new byte[8192];
                            while (true) {
                                read = bufferedInputStream.read(bArr);
                                if (read == -1 || this.a.get()) {
                                    break;
                                }
                                fileOutputStream3.write(bArr, 0, read);
                            }
                            if (this.a.get()) {
                                if (read != -1) {
                                    file.delete();
                                }
                                throw new Exception("task be canceled");
                            }
                            AdvUtils.close(fileOutputStream3);
                            AdvUtils.close(bufferedInputStream);
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream2 = fileOutputStream3;
                            AdvUtils.close(fileOutputStream2);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream2 = fileOutputStream;
                    AdvUtils.close(fileOutputStream2);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                AdvUtils.close(fileOutputStream2);
                throw th;
            }
        }

        public String c() {
            return this.c + File.separator + this.f9022d;
        }

        public String d() {
            return this.b;
        }

        @Override // java.lang.Runnable
        public void run() {
            Message message = new Message();
            try {
                a(this.b, this.c, this.f9022d);
                message.what = 2;
                message.obj = this;
                AdvImageDownloader.this.mUiHandler.sendMessage(message);
            } catch (Exception e2) {
                AdvLog.Log("down error url:" + this.b + "," + e2.toString());
                message.what = 1;
                message.obj = this;
                AdvImageDownloader.this.mUiHandler.sendMessage(message);
            }
        }
    }

    public AdvImageDownloader(Context context) {
        this.mContext = context;
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(3);
        this.mDownloadTaskExecutor = newFixedThreadPool;
        this.mSslSocketFactory = AdvUtils.getTrustAllSocketFactory();
        this.mUiHandler = new a(Looper.getMainLooper());
        newFixedThreadPool.execute(new b(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onErrorResponse(c cVar) {
        AdvLog.Log("url:" + cVar.d());
        synchronized (this.mDownloadingUrlList) {
            this.mDownloadingUrlList.remove(cVar.d());
        }
        AdvDownLoadLisenter advDownLoadLisenter = cVar.f9023e;
        if (advDownLoadLisenter != null) {
            advDownLoadLisenter.onLoadFailed(cVar.d(), 5, "download failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onResponse(c cVar) {
        AdvLog.Log("url:" + cVar.d());
        synchronized (this.mDownloadingUrlList) {
            this.mDownloadingUrlList.remove(cVar.d());
        }
        File file = new File(cVar.c());
        String absolutePath = file.getAbsolutePath();
        if (file.exists() && absolutePath.endsWith(".tmp")) {
            File file2 = new File(absolutePath.substring(0, absolutePath.length() - 4));
            file.renameTo(file2);
            AdvDownLoadLisenter advDownLoadLisenter = cVar.f9023e;
            if (advDownLoadLisenter != null) {
                advDownLoadLisenter.onLoadSuccess(cVar.d(), file2.getAbsolutePath());
                return;
            }
            return;
        }
        AdvDownLoadLisenter advDownLoadLisenter2 = cVar.f9023e;
        if (advDownLoadLisenter2 != null) {
            advDownLoadLisenter2.onLoadFailed(cVar.d(), 4, "file no exist");
        }
    }

    public void download(String str, String str2, AdvDownLoadLisenter advDownLoadLisenter) {
        if (!AdvSystemUtils.hasNet(this.mContext)) {
            if (advDownLoadLisenter != null) {
                advDownLoadLisenter.onLoadFailed(str, 1, "no net");
            }
        } else if (TextUtils.isEmpty(str2)) {
            if (advDownLoadLisenter != null) {
                advDownLoadLisenter.onLoadFailed(str, 2, "path is empty");
            }
        } else {
            synchronized (this.mDownloadingUrlList) {
                if (this.mDownloadingUrlList.contains(str)) {
                    if (advDownLoadLisenter != null) {
                        advDownLoadLisenter.onLoadFailed(str, 3, "is already loading");
                    }
                    return;
                }
                this.mDownloadingUrlList.add(str);
                if (new File(str2).exists()) {
                    if (advDownLoadLisenter != null) {
                        advDownLoadLisenter.onLoadSuccess(str, str2);
                        return;
                    }
                    return;
                }
                File file = new File(str2 + ".tmp");
                if (file.getParentFile() == null) {
                    return;
                }
                this.mDownloadTaskExecutor.execute(new c(str, file.getParentFile().getAbsolutePath(), file.getName(), advDownLoadLisenter));
            }
        }
    }

    public void downloadsync(String str, String str2) {
        if (AdvSystemUtils.hasNet(this.mContext) && !TextUtils.isEmpty(str2)) {
            synchronized (this.mDownloadingUrlList) {
                if (this.mDownloadingUrlList.contains(str)) {
                    return;
                }
                this.mDownloadingUrlList.add(str);
                File file = new File(str2 + ".tmp");
                new c(str, file.getParentFile().getAbsolutePath(), file.getName(), null).run();
            }
        }
    }

    public String getDownloadedImageCachePath(Context context, String str) {
        String advImageCacheDir;
        if (str == null || !str.contains("/") || (advImageCacheDir = AdvUtils.getAdvImageCacheDir(context)) == null) {
            return null;
        }
        String generateName = AdvUtils.generateName(str);
        return advImageCacheDir + generateName;
    }
}
