package com.growingio.android.sdk.data.net;

import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import com.growingio.android.sdk.data.net.DNSService;
import com.growingio.android.sdk.utils.LogUtil;
import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import us.pinguo.inspire.cell.recycler.a;
/* loaded from: classes2.dex */
public class HttpService {
    private static final String GZIP_ENCODING = "gzip";
    private static final String TAG = "GIO.HttpService";
    private static final int THREAD_STATS_TAG = 1900407258;
    private static final AsyncTimeout sAsyncTimeout = new AsyncTimeout();
    public static SSLSocketFactory sSystemDefaultFactory;
    private byte[] mData;
    private Map<String, String> mHeaders;
    private long mIfModifiedSince;
    private long mLastModified;
    private String mRequestMethod;
    private Map<String, List<String>> mResponseHeaders;
    private String mUrl;

    /* loaded from: classes2.dex */
    public static class Builder {
        private String mNestedUri;
        private String mNestedRequestMethod = "GET";
        private Map<String, String> mNestedHeaders = new HashMap();
        private byte[] mNestedData = new byte[0];
        private long mSinceModified = 0;

        public Builder body(byte[] bArr) {
            this.mNestedData = bArr;
            return this;
        }

        public HttpService build() {
            return new HttpService(this.mNestedUri, this.mNestedRequestMethod, this.mNestedHeaders, this.mNestedData, this.mSinceModified);
        }

        public Builder headers(Map<String, String> map) {
            this.mNestedHeaders = map;
            return this;
        }

        public Builder ifModifiedSince(long j2) {
            this.mSinceModified = j2;
            return this;
        }

        public Builder requestMethod(String str) {
            this.mNestedRequestMethod = str;
            return this;
        }

        public Builder uri(String str) {
            this.mNestedUri = str;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class GIOHttpException extends IOException {
        GIOHttpException(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class GIOSSLSocketFilterFactory extends SSLSocketFactory {
        private static Field sDescriptorField;
        private static Field sFdField;
        private static volatile Boolean sQuestionOkHttp;
        private static Field sSocketField;
        private static Field sSocketImplField;
        private final SSLSocketFactory delegate;

        public GIOSSLSocketFilterFactory(SSLSocketFactory sSLSocketFactory) {
            this.delegate = sSLSocketFactory;
        }

        private Socket checkFdSetSize(Socket socket) throws GIOHttpException {
            int intValue;
            if (Build.VERSION.SDK_INT >= 24) {
                return socket;
            }
            if (sQuestionOkHttp == null) {
                synchronized (HttpService.class) {
                    if (sSocketImplField == null) {
                        Field declaredField = Class.forName("com.android.org.conscrypt.OpenSSLSocketImplWrapper").getDeclaredField("socket");
                        sSocketField = declaredField;
                        declaredField.setAccessible(true);
                        Field declaredField2 = Socket.class.getDeclaredField("impl");
                        sSocketImplField = declaredField2;
                        declaredField2.setAccessible(true);
                        Field declaredField3 = Class.forName("java.net.SocketImpl").getDeclaredField(IjkMediaPlayer.OnNativeInvokeListener.ARG_FD);
                        sFdField = declaredField3;
                        declaredField3.setAccessible(true);
                        Field declaredField4 = FileDescriptor.class.getDeclaredField("descriptor");
                        sDescriptorField = declaredField4;
                        declaredField4.setAccessible(true);
                        sQuestionOkHttp = Boolean.TRUE;
                    }
                }
            }
            if (sQuestionOkHttp.booleanValue()) {
                try {
                    intValue = ((Integer) sDescriptorField.get((FileDescriptor) sFdField.get(sSocketImplField.get(sSocketField.get(socket))))).intValue();
                } catch (Throwable th) {
                    if (!(th instanceof GIOHttpException)) {
                        LogUtil.e(HttpService.TAG, th.getMessage(), th);
                    } else {
                        throw th;
                    }
                }
                if (intValue < 1024) {
                    return socket;
                }
                throw new GIOHttpException("current https socketWrapper's fd > 1024, wrong state, throw HttpException, and fd=" + intValue);
            }
            return socket;
        }

        @Override // javax.net.ssl.SSLSocketFactory
        public Socket createSocket(Socket socket, String str, int i2, boolean z) throws IOException {
            return checkFdSetSize(this.delegate.createSocket(socket, str, i2, z));
        }

        @Override // javax.net.ssl.SSLSocketFactory
        public String[] getDefaultCipherSuites() {
            return this.delegate.getDefaultCipherSuites();
        }

        @Override // javax.net.ssl.SSLSocketFactory
        public String[] getSupportedCipherSuites() {
            return this.delegate.getSupportedCipherSuites();
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket(String str, int i2) throws IOException, UnknownHostException {
            return checkFdSetSize(this.delegate.createSocket(str, i2));
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket(String str, int i2, InetAddress inetAddress, int i3) throws IOException, UnknownHostException {
            return checkFdSetSize(this.delegate.createSocket(str, i2, inetAddress, i3));
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket(InetAddress inetAddress, int i2) throws IOException {
            return checkFdSetSize(this.delegate.createSocket(inetAddress, i2));
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket(InetAddress inetAddress, int i2, InetAddress inetAddress2, int i3) throws IOException {
            return checkFdSetSize(this.delegate.createSocket(inetAddress, i2, inetAddress2, i3));
        }
    }

    private void completeHttpsRequestOption(HttpsURLConnection httpsURLConnection, final DNSService.HostInformation hostInformation) {
        if (sSystemDefaultFactory != null) {
            httpsURLConnection.setSSLSocketFactory(new GIOSSLSocketFilterFactory(sSystemDefaultFactory));
        }
        if (hostInformation != null) {
            final String hostName = hostInformation.getHostName();
            httpsURLConnection.setRequestProperty("Host", hostName);
            httpsURLConnection.setHostnameVerifier(new HostnameVerifier() { // from class: com.growingio.android.sdk.data.net.HttpService.1
                @Override // javax.net.ssl.HostnameVerifier
                public boolean verify(String str, SSLSession sSLSession) {
                    boolean verify = HttpsURLConnection.getDefaultHostnameVerifier().verify(hostName, sSLSession);
                    if (!verify) {
                        DNSService.getInstance().verifyFail(hostInformation);
                    }
                    return verify;
                }
            });
        }
    }

    private String getExceptionMessage(Throwable th) {
        if (th instanceof UnknownHostException) {
            return "uh";
        }
        if (th instanceof SocketTimeoutException) {
            return "timeout";
        }
        if (th instanceof SSLException) {
            return "ssl";
        }
        if (th instanceof IOException) {
            return "io";
        }
        if (th instanceof ArrayIndexOutOfBoundsException) {
            LogUtil.e(TAG, "performRequest: bad response");
            return "aioob";
        }
        LogUtil.e(TAG, "performRequest: unknown exception");
        th.printStackTrace();
        return a.PAGE_TYPE_OTHER;
    }

    private boolean replaceHostNameWithIP(DNSService.HostInformation hostInformation) {
        if (hostInformation != null) {
            String ip = hostInformation.getIp();
            if (TextUtils.isEmpty(ip)) {
                return false;
            }
            this.mUrl = this.mUrl.replaceFirst(hostInformation.getHostName(), ip);
            return true;
        }
        return false;
    }

    private static byte[] slurp(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr, 0, 8192);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public long getLastModified() {
        return this.mLastModified;
    }

    public Map<String, List<String>> getResponseHeaders() {
        return this.mResponseHeaders;
    }

    @WorkerThread
    public Pair<Integer, byte[]> performRequest() {
        return performRequest(null);
    }

    private HttpService(String str, String str2, Map<String, String> map, byte[] bArr, long j2) {
        this.mUrl = str;
        this.mRequestMethod = str2;
        this.mHeaders = map;
        this.mData = bArr;
        this.mIfModifiedSince = j2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01a3 A[Catch: all -> 0x0223, TRY_ENTER, TryCatch #2 {all -> 0x0223, blocks: (B:84:0x0160, B:86:0x0164, B:88:0x0176, B:109:0x01ae, B:106:0x01a3, B:108:0x01a7), top: B:156:0x0160 }] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0215 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x01c7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x01c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x015e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0164 A[Catch: all -> 0x0223, TryCatch #2 {all -> 0x0223, blocks: (B:84:0x0160, B:86:0x0164, B:88:0x0176, B:109:0x01ae, B:106:0x01a3, B:108:0x01a7), top: B:156:0x0160 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private android.util.Pair<java.lang.Integer, byte[]> performRequest(com.growingio.android.sdk.data.net.DNSService.HostInformation r15) {
        /*
            Method dump skipped, instructions count: 582
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.growingio.android.sdk.data.net.HttpService.performRequest(com.growingio.android.sdk.data.net.DNSService$HostInformation):android.util.Pair");
    }
}
