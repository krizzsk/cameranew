package com.growingio.android.sdk.monitor.connection;

import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.growingio.android.sdk.monitor.Monitor;
import com.growingio.android.sdk.monitor.connection.cache.DataHelper;
import com.growingio.android.sdk.monitor.dsn.Dsn;
import com.growingio.android.sdk.monitor.environment.MonitorEnvironment;
import com.growingio.android.sdk.monitor.event.Event;
import com.growingio.android.sdk.monitor.log.MLog;
import com.growingio.android.sdk.monitor.marshaller.json.JsonMarshaller;
import com.growingio.android.sdk.monitor.util.Util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.common.network.HttpRequest;
/* loaded from: classes2.dex */
public class HttpConnection implements Connection {
    private static final int DEFAULT_CONNECT_TIMEOUT = 5000;
    private static final int DEFAULT_READ_TIMEOUT = 10000;
    public static final int HTTP_TOO_MANY_REQUESTS = 429;
    private static final int MAX_SEND_EVENT_COUNT_DAILY = 20;
    private static final int MIN_AGE_MILLIS = 60000;
    private static final String SENTRY_AUTH = "X-Sentry-Auth";
    private static final String SENTRY_PROTOCOL_VERSION = "6";
    private static final int SYNC_CACHE_EVENT = 1;
    private static final String TAG = "HttpConnection";
    private static final String USER_AGENT = "User-Agent";
    private final String alias;
    private final String authHeader;
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();
    private final HandlerThread handlerThread;
    private final JsonMarshaller marshaller;
    private final String sentryApiUrl;
    private final WorkHandler workHandler;
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private static String CONTENT_TYPE = HttpRequest.HEADER_CONTENT_TYPE;
    private static String DEFAULT_CONTENT_TYPE = HttpRequest.CONTENT_TYPE_JSON;

    /* loaded from: classes2.dex */
    private class WorkHandler extends Handler {
        WorkHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                Event latelyEvent = DataHelper.getLatelyEvent(HttpConnection.this.alias);
                if (latelyEvent != null) {
                    HttpConnection.this.doSend(latelyEvent);
                    sendEmptyMessageDelayed(1, 60000L);
                    return;
                }
                MLog.d(HttpConnection.TAG, "event is NULL, end SYNC_CACHE_EVENT, alias is " + HttpConnection.this.alias);
            }
        }
    }

    public HttpConnection(String str, Dsn dsn, JsonMarshaller jsonMarshaller) {
        String str2;
        this.alias = str;
        this.marshaller = jsonMarshaller;
        this.sentryApiUrl = dsn.getUri().toString() + "api/" + dsn.getProjectId() + "/store/";
        StringBuilder sb = new StringBuilder();
        sb.append("Sentry sentry_version=6,sentry_client=");
        sb.append(MonitorEnvironment.getMonitorName());
        sb.append(",sentry_key=");
        sb.append(dsn.getPublicKey());
        if (Util.isNullOrEmpty(dsn.getSecretKey())) {
            str2 = "";
        } else {
            str2 = ",sentry_secret=" + dsn.getSecretKey();
        }
        sb.append(str2);
        this.authHeader = sb.toString();
        HandlerThread handlerThread = new HandlerThread("MonitorHandlerThread");
        this.handlerThread = handlerThread;
        handlerThread.start();
        WorkHandler workHandler = new WorkHandler(handlerThread.getLooper());
        this.workHandler = workHandler;
        Message.obtain(workHandler, 1).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doSend(final Event event) {
        if (!isWifiConnect() && DataHelper.getSendEventsCountDaily() >= 20) {
            MLog.e(TAG, "Today send too many events to monitor server using 4G");
            return;
        }
        try {
            final JSONObject marshall = this.marshaller.marshall(event);
            this.executorService.execute(new Runnable() { // from class: com.growingio.android.sdk.monitor.connection.HttpConnection.1
                /* JADX WARN: Removed duplicated region for block: B:22:0x006e A[Catch: all -> 0x003f, IOException -> 0x00a9, TRY_LEAVE, TryCatch #0 {IOException -> 0x00a9, blocks: (B:20:0x0066, B:22:0x006e, B:25:0x009a, B:27:0x00a2), top: B:44:0x0066 }] */
                /* JADX WARN: Removed duplicated region for block: B:25:0x009a A[Catch: all -> 0x003f, IOException -> 0x00a9, TRY_ENTER, TryCatch #0 {IOException -> 0x00a9, blocks: (B:20:0x0066, B:22:0x006e, B:25:0x009a, B:27:0x00a2), top: B:44:0x0066 }] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public void run() {
                    /*
                        r10 = this;
                        java.lang.String r0 = ", ResponseCode: "
                        java.lang.String r1 = "HttpConnection"
                        com.growingio.android.sdk.monitor.connection.HttpConnection r2 = com.growingio.android.sdk.monitor.connection.HttpConnection.this
                        java.net.HttpURLConnection r2 = r2.getConnection()
                        java.io.OutputStream r3 = r2.getOutputStream()     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L42
                        org.json.JSONObject r4 = r2     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L42
                        if (r4 == 0) goto L1d
                        java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L42
                        byte[] r4 = r4.getBytes()     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L42
                        r3.write(r4)     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L42
                    L1d:
                        r3.flush()     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L42
                        r3.close()     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L42
                        java.io.InputStream r3 = r2.getInputStream()     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L42
                        r3.close()     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L42
                        com.growingio.android.sdk.monitor.event.Event r3 = r3     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L42
                        com.growingio.android.sdk.monitor.connection.cache.DataHelper.deleteEvent(r3)     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L42
                        com.growingio.android.sdk.monitor.connection.HttpConnection r3 = com.growingio.android.sdk.monitor.connection.HttpConnection.this     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L42
                        boolean r3 = com.growingio.android.sdk.monitor.connection.HttpConnection.access$200(r3)     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L42
                        if (r3 != 0) goto L3a
                        com.growingio.android.sdk.monitor.connection.cache.DataHelper.addOneSendEventCount()     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L42
                    L3a:
                        r2.disconnect()
                        goto Lde
                    L3f:
                        r0 = move-exception
                        goto Ldf
                    L42:
                        r3 = move-exception
                        java.lang.String r4 = "Retry-After"
                        java.lang.String r4 = r2.getHeaderField(r4)     // Catch: java.lang.Throwable -> L3f
                        r5 = 0
                        if (r4 == 0) goto L5d
                        double r6 = java.lang.Double.parseDouble(r4)     // Catch: java.lang.Throwable -> L3f java.lang.NumberFormatException -> L5d
                        r8 = 4652007308841189376(0x408f400000000000, double:1000.0)
                        double r6 = r6 * r8
                        long r6 = (long) r6     // Catch: java.lang.Throwable -> L3f java.lang.NumberFormatException -> L5d
                        java.lang.Long r4 = java.lang.Long.valueOf(r6)     // Catch: java.lang.Throwable -> L3f java.lang.NumberFormatException -> L5d
                        goto L5e
                    L5d:
                        r4 = r5
                    L5e:
                        int r6 = r2.getResponseCode()     // Catch: java.lang.Throwable -> L3f java.io.IOException -> La8
                        java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> L3f java.io.IOException -> La8
                        int r7 = r6.intValue()     // Catch: java.lang.Throwable -> L3f java.io.IOException -> La9
                        r8 = 403(0x193, float:5.65E-43)
                        if (r7 != r8) goto L9a
                        java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3f java.io.IOException -> La9
                        r7.<init>()     // Catch: java.lang.Throwable -> L3f java.io.IOException -> La9
                        java.lang.String r8 = "Event '"
                        r7.append(r8)     // Catch: java.lang.Throwable -> L3f java.io.IOException -> La9
                        com.growingio.android.sdk.monitor.event.Event r8 = r3     // Catch: java.lang.Throwable -> L3f java.io.IOException -> La9
                        java.util.UUID r8 = r8.getId()     // Catch: java.lang.Throwable -> L3f java.io.IOException -> La9
                        r7.append(r8)     // Catch: java.lang.Throwable -> L3f java.io.IOException -> La9
                        java.lang.String r8 = "' was rejected by the Sentry server due to a filter, Retry-After: "
                        r7.append(r8)     // Catch: java.lang.Throwable -> L3f java.io.IOException -> La9
                        r7.append(r4)     // Catch: java.lang.Throwable -> L3f java.io.IOException -> La9
                        r7.append(r0)     // Catch: java.lang.Throwable -> L3f java.io.IOException -> La9
                        r7.append(r6)     // Catch: java.lang.Throwable -> L3f java.io.IOException -> La9
                        java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L3f java.io.IOException -> La9
                        com.growingio.android.sdk.monitor.log.MLog.d(r1, r7)     // Catch: java.lang.Throwable -> L3f java.io.IOException -> La9
                        r2.disconnect()
                        return
                    L9a:
                        int r7 = r6.intValue()     // Catch: java.lang.Throwable -> L3f java.io.IOException -> La9
                        r8 = 429(0x1ad, float:6.01E-43)
                        if (r7 != r8) goto La9
                        java.lang.String r7 = "Too many requests to Sentry: https://docs.sentry.io/learn/quotas/"
                        com.growingio.android.sdk.monitor.log.MLog.d(r1, r7, r3)     // Catch: java.lang.Throwable -> L3f java.io.IOException -> La9
                        goto La9
                    La8:
                        r6 = r5
                    La9:
                        java.io.InputStream r7 = r2.getErrorStream()     // Catch: java.lang.Throwable -> L3f
                        if (r7 == 0) goto Lb5
                        com.growingio.android.sdk.monitor.connection.HttpConnection r5 = com.growingio.android.sdk.monitor.connection.HttpConnection.this     // Catch: java.lang.Throwable -> L3f
                        java.lang.String r5 = com.growingio.android.sdk.monitor.connection.HttpConnection.access$300(r5, r7)     // Catch: java.lang.Throwable -> L3f
                    Lb5:
                        if (r5 == 0) goto Lbd
                        boolean r7 = r5.isEmpty()     // Catch: java.lang.Throwable -> L3f
                        if (r7 == 0) goto Lbf
                    Lbd:
                        java.lang.String r5 = "An exception occurred while submitting the event to the Sentry server."
                    Lbf:
                        java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3f
                        r7.<init>()     // Catch: java.lang.Throwable -> L3f
                        r7.append(r5)     // Catch: java.lang.Throwable -> L3f
                        java.lang.String r5 = ", Retry-After: "
                        r7.append(r5)     // Catch: java.lang.Throwable -> L3f
                        r7.append(r4)     // Catch: java.lang.Throwable -> L3f
                        r7.append(r0)     // Catch: java.lang.Throwable -> L3f
                        r7.append(r6)     // Catch: java.lang.Throwable -> L3f
                        java.lang.String r0 = r7.toString()     // Catch: java.lang.Throwable -> L3f
                        com.growingio.android.sdk.monitor.log.MLog.d(r1, r0, r3)     // Catch: java.lang.Throwable -> L3f
                        goto L3a
                    Lde:
                        return
                    Ldf:
                        r2.disconnect()
                        throw r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.growingio.android.sdk.monitor.connection.HttpConnection.AnonymousClass1.run():void");
                }
            });
        } catch (JSONException e2) {
            MLog.e(TAG, e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getErrorMessageFromStream(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, UTF_8));
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                if (!z) {
                    sb.append("\n");
                }
                sb.append(readLine);
                z = false;
            } catch (Exception e2) {
                MLog.d(TAG, "Exception while reading the error message from the connection.", e2);
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isWifiConnect() {
        return ((ConnectivityManager) Monitor.getAppContext().getSystemService("connectivity")).getNetworkInfo(1).isConnected();
    }

    protected HttpURLConnection getConnection() {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.sentryApiUrl).openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setRequestProperty("User-Agent", MonitorEnvironment.getMonitorName());
            httpURLConnection.setRequestProperty(SENTRY_AUTH, this.authHeader);
            httpURLConnection.setRequestProperty(CONTENT_TYPE, DEFAULT_CONTENT_TYPE);
            return httpURLConnection;
        } catch (IOException e2) {
            throw new IllegalStateException("Couldn't set up a connection to the Sentry server.", e2);
        }
    }

    @Override // com.growingio.android.sdk.monitor.connection.Connection
    public void send(Event event) {
        MLog.d(TAG, "send event");
        DataHelper.saveEvent(event);
        doSend(event);
    }

    @Override // com.growingio.android.sdk.monitor.connection.Connection
    public void stopSyncCachedEvent() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.handlerThread.quitSafely();
        } else {
            this.handlerThread.quit();
        }
    }
}
