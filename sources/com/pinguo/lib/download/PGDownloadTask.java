package com.pinguo.lib.download;

import android.os.Handler;
import android.os.SystemClock;
import com.pinguo.lib.download.exception.HttpCodeException;
import com.pinguo.lib.download.exception.Md5CheckException;
import com.pinguo.lib.download.exception.RenameException;
import com.pinguo.lib.download.listener.DownloadCancelListener;
import com.pinguo.lib.download.listener.DownloadListener;
import com.pinguo.lib.download.listener.DownloadProcessListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import us.pinguo.common.network.common.header.PGTransHeader;
import us.pinguo.util.i;
import us.pinguo.util.v;
/* loaded from: classes3.dex */
public final class PGDownloadTask implements Runnable {
    private static final int BUFFER_SIZE = 8192;
    private static final int CONNECT_TIMEOUT = 45000;
    private static final int MAX_FILE_LENGTH = 1073741824;
    public static final int STATUS_CANCEL = 3;
    public static final int STATUS_DOING = 2;
    public static final int STATUS_ERROR = 4;
    public static final int STATUS_PAUSE = 5;
    public static final int STATUS_SUCCESS = 1;
    public static final int STATUS_UNDO = 0;
    private static final String TAG = "PGDownloadTask";
    private int downloadStatus;
    private boolean isRange;
    private Config mConfig;
    private DownloadCancelListener mDownloadCancelListener;
    private DownloadListener mDownloadListener;
    private DownloadProcessListener mDownloadProcessListener;
    private Handler mHandler;
    private File mPrefTempFile;
    private File mSaveFile;
    private File mSaveTempFile;
    private boolean mStop;
    private TaskFinishListener mTaskFinishListener;

    /* loaded from: classes3.dex */
    public interface TaskFinishListener {
        void finish(Config config);
    }

    public PGDownloadTask(Config config) {
        this(config, null, null, null, null);
    }

    private void checkDownloadingFile(long j2) throws IOException {
        if (j2 > 512000 && !this.mSaveTempFile.exists()) {
            throw new IOException("delete downloading file!");
        }
    }

    private boolean checkMd5(String str, File file) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        String a = i.a(file);
        if (str.equals(a)) {
            return true;
        }
        us.pinguo.common.log.a.g(TAG, "Md5 check failed, file=(" + file + ")'s md5 is '" + a + "',check md5 is '" + str + "'", new Object[0]);
        return false;
    }

    private void close(InputStream inputStream) throws IOException {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception e2) {
                us.pinguo.common.log.a.f(e2);
            }
        }
    }

    private void createPrefFile(boolean z) {
        if (z) {
            if (this.mPrefTempFile.exists()) {
                return;
            }
            try {
                PGDownloadUtils.createOrExistsDir(this.mPrefTempFile.getParentFile());
                if (this.mPrefTempFile.createNewFile()) {
                    return;
                }
                us.pinguo.common.log.a.g(TAG, "create file failed, file=" + this.mPrefTempFile.getAbsolutePath(), new Object[0]);
                return;
            } catch (IOException unused) {
                us.pinguo.common.log.a.g(TAG, "create file error, file=" + this.mPrefTempFile.getAbsolutePath(), new Object[0]);
                return;
            }
        }
        deleteFile(this.mPrefTempFile);
    }

    private void deleteFile(File file) {
        if (!file.exists() || file.delete()) {
            return;
        }
        us.pinguo.common.log.a.g(TAG, "delete " + file.getAbsolutePath() + " failed!", new Object[0]);
    }

    private void download2Tmp() throws IOException {
        if (PGDownloadUtils.createOrExistsDir(new File(this.mConfig.getSaveFolder()))) {
            boolean z = this.mPrefTempFile.exists() && this.mSaveTempFile.exists();
            this.isRange = z;
            if (z) {
                downloadRange();
                return;
            }
            deleteFile(this.mSaveTempFile);
            downloadFirst();
            return;
        }
        throw new IOException("Folder not exist!");
    }

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0076: MOVE  (r2 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:29:0x0076 */
    private void downloadFile(HttpURLConnection httpURLConnection, File file) throws IOException {
        BufferedOutputStream bufferedOutputStream;
        if (isCancel()) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                try {
                    BufferedOutputStream bufferedOutputStream3 = new BufferedOutputStream(new FileOutputStream(file));
                    try {
                        byte[] bArr = new byte[8192];
                        int i2 = 0;
                        do {
                            int read = bufferedInputStream.read(bArr);
                            if (read != -1) {
                                bufferedOutputStream3.write(bArr, 0, read);
                                i2 += read;
                                long uptimeMillis2 = SystemClock.uptimeMillis();
                                if (uptimeMillis2 - uptimeMillis > 1000) {
                                    bufferedOutputStream3.flush();
                                    checkDownloadingFile(i2);
                                    uptimeMillis = uptimeMillis2;
                                }
                            } else {
                                PGDownloadUtils.closeIO(bufferedOutputStream3);
                                PGDownloadUtils.closeIO(bufferedInputStream);
                                return;
                            }
                        } while (!isCancel());
                        PGDownloadUtils.closeIO(bufferedOutputStream3);
                        PGDownloadUtils.closeIO(bufferedInputStream);
                    } catch (Throwable th) {
                        th = th;
                        bufferedOutputStream2 = bufferedOutputStream3;
                        PGDownloadUtils.closeIO(bufferedOutputStream2);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream2 = bufferedOutputStream;
                PGDownloadUtils.closeIO(bufferedOutputStream2);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            PGDownloadUtils.closeIO(bufferedOutputStream2);
            throw th;
        }
    }

    private boolean downloadFinish() {
        return this.mSaveFile.exists();
    }

    private void downloadFirst() throws IOException {
        Throwable th;
        HttpURLConnection httpURLConnection;
        try {
            httpURLConnection = (HttpURLConnection) new URL(URLDecoder.decode(this.mConfig.mDownloadUrl, "UTF-8")).openConnection();
            try {
                httpURLConnection.setConnectTimeout(CONNECT_TIMEOUT);
                boolean z = true;
                HttpURLConnection.setFollowRedirects(true);
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode == 200) {
                    if (isCancel()) {
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                            return;
                        }
                        return;
                    }
                    int contentLength = httpURLConnection.getContentLength();
                    boolean z2 = contentLength > 0 && contentLength < 1073741824;
                    String headerField = httpURLConnection.getHeaderField("Accept-Ranges");
                    if (!z2 || headerField == null || !"bytes".equals(headerField.trim())) {
                        z = false;
                    }
                    this.isRange = z;
                    createPrefFile(z);
                    if (z2) {
                        downloadFile(httpURLConnection, this.mSaveTempFile, contentLength);
                        if (contentLength != this.mSaveTempFile.length()) {
                            if (!this.mSaveTempFile.delete()) {
                                us.pinguo.common.log.a.g(TAG, "delete file(" + this.mSaveTempFile.getAbsolutePath() + ") failed!", new Object[0]);
                            }
                            throw new IOException("download file error!");
                        }
                    } else {
                        downloadFile(httpURLConnection, this.mSaveTempFile);
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        return;
                    }
                    return;
                }
                throw new HttpCodeException("Http Response Code Error:" + responseCode);
            } catch (Throwable th2) {
                th = th2;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
        }
    }

    private void downloadRange() throws IOException {
        long length = this.mSaveTempFile.length();
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(this.mConfig.getDownloadUrl()).openConnection();
            try {
                httpURLConnection2.setConnectTimeout(CONNECT_TIMEOUT);
                HttpURLConnection.setFollowRedirects(true);
                httpURLConnection2.setRequestProperty("Range", "bytes=" + length + PGTransHeader.CONNECTOR);
                int responseCode = httpURLConnection2.getResponseCode();
                if (responseCode != 206 && responseCode != 200) {
                    throw new HttpCodeException("Http Response Code Error:" + responseCode);
                }
                int rangeFileLen = rangeFileLen(httpURLConnection2);
                if (rangeFileLen == -1) {
                    if (length != httpURLConnection2.getContentLength()) {
                        deleteFile(this.mSaveTempFile);
                        throw new IOException("File Length Error, delete tmp file");
                    }
                } else {
                    downloadRangeFile(httpURLConnection2, this.mSaveTempFile, (int) length, rangeFileLen);
                    if (rangeFileLen != this.mSaveTempFile.length()) {
                        if (!this.mSaveTempFile.delete()) {
                            us.pinguo.common.log.a.g(TAG, "delete file(" + this.mSaveTempFile.getAbsolutePath() + ") failed!", new Object[0]);
                        }
                        throw new IOException("download file error!");
                    }
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
            } catch (Throwable th) {
                th = th;
                httpURLConnection = httpURLConnection2;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x006f: MOVE  (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:30:0x006f */
    private void downloadRangeFile(HttpURLConnection httpURLConnection, File file, int i2, int i3) throws IOException {
        InputStream inputStream;
        if (isCancel()) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        InputStream inputStream2 = null;
        OutputStream outputStream = null;
        try {
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                try {
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file, true));
                    try {
                        byte[] bArr = new byte[8192];
                        do {
                            int read = bufferedInputStream.read(bArr);
                            if (read != -1) {
                                bufferedOutputStream.write(bArr, 0, read);
                                i2 += read;
                                long uptimeMillis2 = SystemClock.uptimeMillis();
                                if (uptimeMillis2 - uptimeMillis > 1000) {
                                    bufferedOutputStream.flush();
                                    checkDownloadingFile(i2);
                                    handlerOnProcess(this.mConfig, this.mDownloadProcessListener, i2, i3);
                                    uptimeMillis = uptimeMillis2;
                                }
                            } else {
                                handlerOnProcess(this.mConfig, this.mDownloadProcessListener, i2, i3);
                                close(bufferedOutputStream);
                                close(bufferedInputStream);
                                return;
                            }
                        } while (!isCancel());
                        close(bufferedOutputStream);
                        close(bufferedInputStream);
                    } catch (Throwable th) {
                        th = th;
                        outputStream = bufferedOutputStream;
                        close(outputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                close(inputStream2);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            inputStream2 = inputStream;
            close(inputStream2);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public /* synthetic */ void g() {
        this.mDownloadCancelListener.onCancelled(this.mConfig);
    }

    private void handlerOnComplete(final Config config, final DownloadListener downloadListener) {
        this.downloadStatus = 1;
        if (downloadListener == null) {
            return;
        }
        Handler handler = this.mHandler;
        if (handler == null) {
            downloadListener.onComplete(config);
        } else {
            handler.post(new Runnable() { // from class: com.pinguo.lib.download.f
                @Override // java.lang.Runnable
                public final void run() {
                    DownloadListener.this.onComplete(config);
                }
            });
        }
    }

    private void handlerOnFailed(final Config config, final DownloadListener downloadListener, final Throwable th) {
        this.downloadStatus = 4;
        if (downloadListener == null) {
            return;
        }
        Handler handler = this.mHandler;
        if (handler == null) {
            downloadListener.onFailed(config, th);
        } else {
            handler.post(new Runnable() { // from class: com.pinguo.lib.download.a
                @Override // java.lang.Runnable
                public final void run() {
                    DownloadListener.this.onFailed(config, th);
                }
            });
        }
    }

    private void handlerOnPause(final Config config, final DownloadListener downloadListener, final Throwable th) {
        this.downloadStatus = 5;
        if (downloadListener == null) {
            return;
        }
        Handler handler = this.mHandler;
        if (handler == null) {
            downloadListener.onPause(config, th);
        } else {
            handler.post(new Runnable() { // from class: com.pinguo.lib.download.e
                @Override // java.lang.Runnable
                public final void run() {
                    DownloadListener.this.onPause(config, th);
                }
            });
        }
    }

    private void handlerOnProcess(final Config config, final DownloadProcessListener downloadProcessListener, final int i2, final int i3) {
        if (downloadProcessListener == null) {
            return;
        }
        Handler handler = this.mHandler;
        if (handler == null) {
            downloadProcessListener.onProgressUpdate(config, i2, i3);
        } else {
            handler.post(new Runnable() { // from class: com.pinguo.lib.download.b
                @Override // java.lang.Runnable
                public final void run() {
                    DownloadProcessListener.this.onProgressUpdate(config, i2, i3);
                }
            });
        }
    }

    private void handlerOnStart(final Config config, final DownloadListener downloadListener) {
        this.downloadStatus = 2;
        if (downloadListener == null) {
            return;
        }
        Handler handler = this.mHandler;
        if (handler == null) {
            downloadListener.onStart(config);
        } else {
            handler.post(new Runnable() { // from class: com.pinguo.lib.download.d
                @Override // java.lang.Runnable
                public final void run() {
                    DownloadListener.this.onStart(config);
                }
            });
        }
    }

    private boolean isCancel() {
        if (this.mStop) {
            this.downloadStatus = 3;
            DownloadCancelListener downloadCancelListener = this.mDownloadCancelListener;
            if (downloadCancelListener == null) {
                return true;
            }
            Handler handler = this.mHandler;
            if (handler == null) {
                downloadCancelListener.onCancelled(this.mConfig);
                return true;
            }
            handler.post(new Runnable() { // from class: com.pinguo.lib.download.c
                @Override // java.lang.Runnable
                public final void run() {
                    PGDownloadTask.this.g();
                }
            });
            return true;
        }
        return false;
    }

    private static int rangeFileLen(HttpURLConnection httpURLConnection) throws IOException {
        String headerField = httpURLConnection.getHeaderField("Content-Range");
        if (headerField == null) {
            return -1;
        }
        String[] split = headerField.trim().split(" ");
        if (split.length >= 2) {
            if ("bytes".equals(split[0])) {
                String[] split2 = split[1].split("/");
                if (split2.length >= 2) {
                    try {
                        int intValue = Integer.valueOf(split2[1]).intValue();
                        if (intValue < 0 || intValue >= 1073741824) {
                            throw new IOException("Content-Range Error:" + headerField);
                        }
                        return intValue;
                    } catch (Exception unused) {
                        throw new IOException("Content-Range Error:" + headerField);
                    }
                }
                throw new IOException("Content-Range Error:" + headerField);
            }
            throw new IOException("Content-Range Error:" + headerField);
        }
        throw new IOException("Content-Range Error:" + headerField);
    }

    public void cancel(DownloadCancelListener downloadCancelListener) {
        this.mDownloadCancelListener = downloadCancelListener;
        this.mStop = true;
    }

    public int getDownloadStatus() {
        return this.downloadStatus;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.downloadStatus = 2;
            if (isCancel()) {
                return;
            }
            if (!downloadFinish()) {
                if (isCancel()) {
                    return;
                }
                handlerOnStart(this.mConfig, this.mDownloadListener);
                download2Tmp();
                if (isCancel()) {
                    return;
                }
                if (checkMd5(this.mConfig.md5, this.mSaveTempFile)) {
                    if (!this.mSaveTempFile.renameTo(this.mSaveFile)) {
                        throw new RenameException(this.mSaveTempFile.getAbsolutePath() + " rename to " + this.mSaveFile.getAbsolutePath() + " Failed");
                    }
                } else {
                    deleteFile(this.mSaveTempFile);
                    deleteFile(this.mPrefTempFile);
                    throw new Md5CheckException("md5 check Failed");
                }
            } else if (!checkMd5(this.mConfig.md5, this.mSaveFile)) {
                deleteFile(this.mSaveFile);
                throw new Md5CheckException("md5 check Failed");
            }
            TaskFinishListener taskFinishListener = this.mTaskFinishListener;
            if (taskFinishListener != null) {
                taskFinishListener.finish(this.mConfig);
            }
            handlerOnComplete(this.mConfig, this.mDownloadListener);
        } catch (Exception e2) {
            us.pinguo.common.log.a.f(e2);
            TaskFinishListener taskFinishListener2 = this.mTaskFinishListener;
            if (taskFinishListener2 != null) {
                taskFinishListener2.finish(this.mConfig);
            }
            if (this.isRange) {
                handlerOnPause(this.mConfig, this.mDownloadListener, e2);
            } else {
                handlerOnFailed(this.mConfig, this.mDownloadListener, e2);
            }
        }
    }

    public void setDownloadListener(DownloadListener downloadListener) {
        this.mDownloadListener = downloadListener;
    }

    public void setProcessListener(DownloadProcessListener downloadProcessListener) {
        this.mDownloadProcessListener = downloadProcessListener;
    }

    public PGDownloadTask(Config config, DownloadListener downloadListener, Handler handler, TaskFinishListener taskFinishListener, DownloadProcessListener downloadProcessListener) {
        this.mHandler = null;
        this.mStop = false;
        this.mSaveFile = null;
        this.mSaveTempFile = null;
        this.mPrefTempFile = null;
        this.isRange = false;
        this.mTaskFinishListener = null;
        this.mDownloadProcessListener = null;
        this.mDownloadCancelListener = null;
        this.downloadStatus = 0;
        this.mConfig = config;
        this.mHandler = handler;
        this.mTaskFinishListener = taskFinishListener;
        this.mDownloadListener = downloadListener;
        this.mDownloadProcessListener = downloadProcessListener;
        this.mStop = false;
        this.mSaveFile = new File(config.getSavePath());
        this.mSaveTempFile = new File(config.getSaveTmpPath());
        String downloadPrefPath = PGDownloadUtils.getDownloadPrefPath();
        downloadPrefPath = downloadPrefPath == null ? v.d() : downloadPrefPath;
        this.mPrefTempFile = new File(downloadPrefPath + File.separator + config.mFileName + ".download");
    }

    private void close(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (Exception e2) {
                us.pinguo.common.log.a.f(e2);
            }
        }
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0076: MOVE  (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:30:0x0076 */
    private void downloadFile(HttpURLConnection httpURLConnection, File file, int i2) throws IOException {
        InputStream inputStream;
        BufferedOutputStream bufferedOutputStream;
        if (isCancel()) {
            return;
        }
        PGDownloadUtils.createOrExistsDir(file.getParentFile());
        long uptimeMillis = SystemClock.uptimeMillis();
        InputStream inputStream2 = null;
        OutputStream outputStream = null;
        try {
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    byte[] bArr = new byte[8192];
                    int i3 = 0;
                    do {
                        int read = bufferedInputStream.read(bArr);
                        if (read != -1) {
                            bufferedOutputStream.write(bArr, 0, read);
                            i3 += read;
                            long uptimeMillis2 = SystemClock.uptimeMillis();
                            if (uptimeMillis2 - uptimeMillis > 300) {
                                bufferedOutputStream.flush();
                                checkDownloadingFile(i3);
                                handlerOnProcess(this.mConfig, this.mDownloadProcessListener, i3, i2);
                                uptimeMillis = uptimeMillis2;
                            }
                        } else {
                            handlerOnProcess(this.mConfig, this.mDownloadProcessListener, i3, i2);
                            close(bufferedOutputStream);
                            close(bufferedInputStream);
                            return;
                        }
                    } while (!isCancel());
                    close(bufferedOutputStream);
                    close(bufferedInputStream);
                } catch (Throwable th2) {
                    th = th2;
                    outputStream = bufferedOutputStream;
                    close(outputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStream2 = inputStream;
                close(inputStream2);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            close(inputStream2);
            throw th;
        }
    }
}
