package com.pinguo.lib.network;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.io.File;
import java.io.IOException;
import us.pinguo.common.log.a;
import us.pinguo.common.network.HttpRequest;
import us.pinguo.util.l;
/* loaded from: classes3.dex */
public abstract class HttpFileRequest {
    private static final int MSG_ON_ERROR_RESPONSE = 1;
    private static final int MSG_ON_PROGRESS = 3;
    private static final int MSG_ON_SUCCESS_RESPONSE = 2;
    private static final String TAG = "HttpFileRequest";
    private String mFileName;
    private String mFilePath;
    private Handler mInternalHandler;
    private long mLastProgressTime;
    private String mUrl;
    private boolean mOverridable = true;
    private boolean mIsCanceled = false;
    private int mProgressInterval = 0;

    public HttpFileRequest(String str, String str2) {
        this.mUrl = str;
        this.mFilePath = str2;
        this.mFileName = str.substring(str.lastIndexOf("/") + 1);
    }

    private Handler createHandler(Looper looper) {
        if (looper != null) {
            return new Handler(looper) { // from class: com.pinguo.lib.network.HttpFileRequest.3
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    HttpFileRequest.this.deliverMessage(message);
                }
            };
        }
        return new Handler() { // from class: com.pinguo.lib.network.HttpFileRequest.4
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                HttpFileRequest.this.deliverMessage(message);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deliverMessage(Message message) {
        int i2 = message.what;
        if (i2 == 2) {
            onResponse(new File(getAbsolutePath()));
        } else if (i2 == 1) {
            onErrorResponse((Exception) message.obj);
        } else if (i2 == 3) {
            onProgress(((Integer) message.obj).intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String download(String str, String str2, String str3) throws IOException {
        if (l.f(str2)) {
            if (str3 == null || str3.isEmpty()) {
                str3 = str.substring(str.lastIndexOf("/") + 1);
            }
            File file = new File(str2 + File.separator + str3);
            if (!file.exists() || this.mOverridable) {
                HttpRequest httpRequest = HttpRequest.get(str);
                httpRequest.trustAllCerts();
                httpRequest.followRedirects(true);
                int code = httpRequest.code();
                if (code == 200) {
                    httpRequest.receive(file);
                    a.m(TAG, "download downFile = " + file, new Object[0]);
                    return str3;
                }
                a.m(TAG, "download code = " + code, new Object[0]);
                throw new IOException("Http connect error,status code =" + code);
            }
            return str3;
        }
        throw new IOException("Create folder(" + str2 + ") failed!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadWithProgress(String str, String str2, String str3) throws IOException {
        if (l.f(str2)) {
            if (str3 == null || str3.isEmpty()) {
                str3 = str.substring(str.lastIndexOf("/") + 1);
            }
            HttpRequest httpRequest = HttpRequest.get(str);
            httpRequest.trustAllCerts();
            httpRequest.followRedirects(true);
            int code = httpRequest.code();
            if (code == 200) {
                long contentLength = httpRequest.contentLength();
                if (contentLength >= 0) {
                    File file = new File(str2 + File.separator + str3);
                    if (file.exists() && !this.mOverridable && file.length() == contentLength) {
                        return;
                    }
                    this.mLastProgressTime = SystemClock.uptimeMillis();
                    httpRequest.receive(file);
                    httpRequest.progress(new HttpRequest.HttpProgress() { // from class: com.pinguo.lib.network.HttpFileRequest.2
                        @Override // us.pinguo.common.network.HttpRequest.HttpProgress
                        public void onProgress(long j2, long j3) {
                            long j4 = HttpFileRequest.this.mLastProgressTime;
                            if (HttpFileRequest.this.mProgressInterval > 0) {
                                long uptimeMillis = SystemClock.uptimeMillis();
                                if (uptimeMillis - j4 > HttpFileRequest.this.mProgressInterval) {
                                    int i2 = (int) ((j2 * 100) / j3);
                                    Message message = new Message();
                                    message.what = 3;
                                    message.obj = Integer.valueOf(i2);
                                    HttpFileRequest.this.mInternalHandler.sendMessage(message);
                                    HttpFileRequest.this.mLastProgressTime = uptimeMillis;
                                }
                            }
                        }
                    });
                    return;
                }
                throw new IOException("Unknown file size!");
            }
            throw new IOException("Http connect error,status code =" + code);
        }
        throw new IOException("Create folder(" + str2 + ") failed!");
    }

    public void cancel() {
        this.mIsCanceled = true;
    }

    public void execute() {
        execute(null);
    }

    public String getAbsolutePath() {
        return this.mFilePath + File.separator + this.mFileName;
    }

    public String getFileName() {
        return this.mFileName;
    }

    public String getFilePath() {
        return this.mFilePath;
    }

    protected abstract void onErrorResponse(Exception exc);

    protected void onProgress(int i2) {
    }

    protected abstract void onResponse(File file);

    public void setOverridable(boolean z) {
        this.mOverridable = z;
    }

    public void setProgressInterval(int i2) {
        this.mProgressInterval = i2;
    }

    public void execute(Looper looper) {
        if (this.mInternalHandler == null) {
            this.mInternalHandler = createHandler(looper);
        }
        new Thread(new Runnable() { // from class: com.pinguo.lib.network.HttpFileRequest.1
            @Override // java.lang.Runnable
            public void run() {
                Message message = new Message();
                try {
                    if (HttpFileRequest.this.mProgressInterval > 0) {
                        HttpFileRequest httpFileRequest = HttpFileRequest.this;
                        httpFileRequest.downloadWithProgress(httpFileRequest.mUrl, HttpFileRequest.this.mFilePath, HttpFileRequest.this.mFileName);
                    } else {
                        HttpFileRequest httpFileRequest2 = HttpFileRequest.this;
                        httpFileRequest2.download(httpFileRequest2.mUrl, HttpFileRequest.this.mFilePath, HttpFileRequest.this.mFileName);
                    }
                    message.what = 2;
                    HttpFileRequest.this.mInternalHandler.sendMessage(message);
                } catch (Exception e2) {
                    message.what = 1;
                    message.obj = e2;
                    HttpFileRequest.this.mInternalHandler.sendMessage(message);
                }
            }
        }).start();
    }

    public HttpFileRequest(String str, String str2, String str3) {
        this.mUrl = str;
        this.mFilePath = str2;
        this.mFileName = str3;
    }
}
