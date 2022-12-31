package us.pinguo.common.network;

import android.util.Base64;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.security.AccessController;
import java.security.GeneralSecurityException;
import java.security.PrivilegedAction;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes4.dex */
public class HttpRequest {
    private static final String BOUNDARY = "00content0boundary00";
    public static final String CHARSET_UTF8 = "UTF-8";
    public static final String CONTENT_TYPE_FORM = "application/x-www-form-urlencoded";
    public static final String CONTENT_TYPE_JSON = "application/json";
    private static final String CONTENT_TYPE_MULTIPART = "multipart/form-data; boundary=00content0boundary00";
    private static final String CRLF = "\r\n";
    public static final String ENCODING_GZIP = "gzip";
    public static final String HEADER_ACCEPT = "Accept";
    public static final String HEADER_ACCEPT_CHARSET = "Accept-Charset";
    public static final String HEADER_ACCEPT_ENCODING = "Accept-Encoding";
    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String HEADER_CACHE_CONTROL = "Cache-Control";
    public static final String HEADER_CONTENT_ENCODING = "Content-Encoding";
    public static final String HEADER_CONTENT_LENGTH = "Content-Length";
    public static final String HEADER_CONTENT_TYPE = "Content-Type";
    public static final String HEADER_DATE = "Date";
    public static final String HEADER_ETAG = "ETag";
    public static final String HEADER_EXPIRES = "Expires";
    public static final String HEADER_IF_NONE_MATCH = "If-None-Match";
    public static final String HEADER_LAST_MODIFIED = "Last-Modified";
    public static final String HEADER_LOCATION = "Location";
    public static final String HEADER_SERVER = "Server";
    public static final String HEADER_USER_AGENT = "User-Agent";
    public static final String METHOD_GET = "GET";
    public static final String METHOD_POST = "POST";
    public static final String PARAM_CHARSET = "charset";
    private static volatile SSLSocketFactory TRUSTED_FACTORY;
    private static volatile HostnameVerifier TRUSTED_VERIFIER;
    private final HttpURLConnection connection;
    private boolean form;
    private boolean multipart;
    private RequestOutputStream output;
    private static final String[] EMPTY_STRINGS = new String[0];
    private static final byte[] LOCK = new byte[0];
    private boolean ignoreCloseExceptions = true;
    private boolean uncompress = false;
    private int bufferSize = 8192;
    private long totalSize = -1;
    private long totalWritten = 0;
    private HttpProgress progress = HttpProgress.DEFAULT;

    /* loaded from: classes4.dex */
    protected static abstract class CloseOperation<V> extends Operation<V> {
        private final Closeable closeable;
        private final boolean ignoreCloseExceptions;

        protected CloseOperation(Closeable closeable, boolean z) {
            this.closeable = closeable;
            this.ignoreCloseExceptions = z;
        }

        @Override // us.pinguo.common.network.HttpRequest.Operation
        protected void done() throws IOException {
            Closeable closeable = this.closeable;
            if (closeable instanceof Flushable) {
                ((Flushable) closeable).flush();
            }
            if (this.ignoreCloseExceptions) {
                try {
                    this.closeable.close();
                    return;
                } catch (IOException unused) {
                    return;
                }
            }
            this.closeable.close();
        }
    }

    /* loaded from: classes4.dex */
    protected static abstract class FlushOperation<V> extends Operation<V> {
        private final Flushable flushable;

        protected FlushOperation(Flushable flushable) {
            this.flushable = flushable;
        }

        @Override // us.pinguo.common.network.HttpRequest.Operation
        protected void done() throws IOException {
            this.flushable.flush();
        }
    }

    /* loaded from: classes4.dex */
    public interface HttpProgress {
        public static final HttpProgress DEFAULT = new HttpProgress() { // from class: us.pinguo.common.network.HttpRequest.HttpProgress.1
            @Override // us.pinguo.common.network.HttpRequest.HttpProgress
            public void onProgress(long j2, long j3) {
            }
        };

        void onProgress(long j2, long j3);
    }

    /* loaded from: classes4.dex */
    public static class HttpRequestException extends IOException {
        private static final long serialVersionUID = -1170466989781746231L;

        protected HttpRequestException(IOException iOException) {
            super(iOException);
        }

        @Override // java.lang.Throwable
        public IOException getCause() {
            return (IOException) super.getCause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes4.dex */
    public static abstract class Operation<V> implements Callable<V> {
        protected Operation() {
        }

        @Override // java.util.concurrent.Callable
        public V call() throws HttpRequestException {
            boolean z;
            try {
                try {
                    V run = run();
                    try {
                        done();
                        return run;
                    } catch (IOException e2) {
                        throw new HttpRequestException(e2);
                    }
                } catch (Throwable th) {
                    th = th;
                    z = true;
                    try {
                        done();
                    } catch (IOException e3) {
                        if (!z) {
                            throw new HttpRequestException(e3);
                        }
                    }
                    throw th;
                }
            } catch (HttpRequestException e4) {
                throw e4;
            } catch (IOException e5) {
                throw new HttpRequestException(e5);
            } catch (Throwable th2) {
                th = th2;
                z = false;
                done();
                throw th;
            }
        }

        protected abstract void done() throws IOException;

        protected abstract V run() throws HttpRequestException, IOException;
    }

    /* loaded from: classes4.dex */
    public static class RequestOutputStream extends BufferedOutputStream {
        private final CharsetEncoder encoder;

        public RequestOutputStream(OutputStream outputStream, String str, int i2) {
            super(outputStream, i2);
            this.encoder = Charset.forName(HttpRequest.getValidCharset(str)).newEncoder();
        }

        public RequestOutputStream write(String str) throws IOException {
            ByteBuffer encode = this.encoder.encode(CharBuffer.wrap(str));
            super.write(encode.array(), 0, encode.limit());
            return this;
        }
    }

    public HttpRequest(CharSequence charSequence, String str) throws HttpRequestException {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(charSequence.toString()).openConnection();
            this.connection = httpURLConnection;
            httpURLConnection.setRequestMethod(str);
        } catch (IOException e2) {
            throw new HttpRequestException(e2);
        }
    }

    static /* synthetic */ long access$214(HttpRequest httpRequest, long j2) {
        long j3 = httpRequest.totalWritten + j2;
        httpRequest.totalWritten = j3;
        return j3;
    }

    private static StringBuilder addParamPrefix(String str, StringBuilder sb) {
        int indexOf = str.indexOf(63);
        int length = sb.length() - 1;
        if (indexOf == -1) {
            sb.append('?');
        } else if (indexOf < length && str.charAt(length) != '&') {
            sb.append('&');
        }
        return sb;
    }

    private static StringBuilder addPathSeparator(String str, StringBuilder sb) {
        if (str.indexOf(58) + 2 == str.lastIndexOf(47)) {
            sb.append('/');
        }
        return sb;
    }

    public static String append(CharSequence charSequence, Map<?, ?> map) {
        String charSequence2 = charSequence.toString();
        if (map == null || map.isEmpty()) {
            return charSequence2;
        }
        StringBuilder sb = new StringBuilder(charSequence2);
        addPathSeparator(charSequence2, sb);
        addParamPrefix(charSequence2, sb);
        Iterator<Map.Entry<?, ?>> it = map.entrySet().iterator();
        Map.Entry<?, ?> next = it.next();
        sb.append(next.getKey().toString());
        sb.append('=');
        Object value = next.getValue();
        if (value != null) {
            sb.append(value);
        }
        while (it.hasNext()) {
            sb.append('&');
            Map.Entry<?, ?> next2 = it.next();
            sb.append(next2.getKey().toString());
            sb.append('=');
            Object value2 = next2.getValue();
            if (value2 != null) {
                sb.append(value2);
            }
        }
        return sb.toString();
    }

    public static String encode(CharSequence charSequence) throws HttpRequestException {
        int port;
        try {
            URL url = new URL(charSequence.toString());
            String host = url.getHost();
            if (url.getPort() != -1) {
                host = host + ':' + Integer.toString(port);
            }
            try {
                return new URI(url.getProtocol(), host, url.getPath(), url.getQuery(), null).toASCIIString();
            } catch (URISyntaxException e2) {
                IOException iOException = new IOException("Parsing URI failed");
                iOException.initCause(e2);
                throw new HttpRequestException(iOException);
            }
        } catch (IOException e3) {
            throw new HttpRequestException(e3);
        }
    }

    public static HttpRequest get(CharSequence charSequence) throws HttpRequestException {
        return new HttpRequest(charSequence, "GET");
    }

    public static SSLSocketFactory getTrustedFactory() throws HttpRequestException {
        if (TRUSTED_FACTORY == null) {
            synchronized (LOCK) {
                if (TRUSTED_FACTORY == null) {
                    try {
                        SSLContext sSLContext = SSLContext.getInstance("TLS");
                        sSLContext.init(null, new TrustManager[]{new EasyX509TrustManager(null)}, new SecureRandom());
                        TRUSTED_FACTORY = sSLContext.getSocketFactory();
                    } catch (GeneralSecurityException e2) {
                        IOException iOException = new IOException("Security exception configuring SSL context");
                        iOException.initCause(e2);
                        throw new HttpRequestException(iOException);
                    }
                }
            }
        }
        return TRUSTED_FACTORY;
    }

    public static HostnameVerifier getTrustedVerifier() {
        if (TRUSTED_VERIFIER == null) {
            synchronized (LOCK) {
                if (TRUSTED_VERIFIER == null) {
                    TRUSTED_VERIFIER = new HostnameVerifier() { // from class: us.pinguo.common.network.HttpRequest.1
                        @Override // javax.net.ssl.HostnameVerifier
                        public boolean verify(String str, SSLSession sSLSession) {
                            return true;
                        }
                    };
                }
            }
        }
        return TRUSTED_VERIFIER;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getValidCharset(String str) {
        return (str == null || str.length() <= 0) ? "UTF-8" : str;
    }

    public static void keepAlive(boolean z) {
        setProperty("http.keepAlive", Boolean.toString(z));
    }

    public static void nonProxyHosts(String... strArr) {
        if (strArr != null && strArr.length > 0) {
            StringBuilder sb = new StringBuilder();
            int length = strArr.length - 1;
            for (int i2 = 0; i2 < length; i2++) {
                sb.append(strArr[i2]);
                sb.append('|');
            }
            sb.append(strArr[length]);
            setProperty("http.nonProxyHosts", sb.toString());
            return;
        }
        setProperty("http.nonProxyHosts", null);
    }

    public static HttpRequest post(CharSequence charSequence) throws HttpRequestException {
        return new HttpRequest(charSequence, "POST");
    }

    public static void proxyHost(String str) {
        setProperty("http.proxyHost", str);
        setProperty("https.proxyHost", str);
    }

    public static void proxyPort(int i2) {
        String num = Integer.toString(i2);
        setProperty("http.proxyPort", num);
        setProperty("https.proxyPort", num);
    }

    private static String setProperty(final String str, final String str2) {
        PrivilegedAction<String> privilegedAction;
        if (str2 != null) {
            privilegedAction = new PrivilegedAction<String>() { // from class: us.pinguo.common.network.HttpRequest.2
                @Override // java.security.PrivilegedAction
                public String run() {
                    return System.setProperty(str, str2);
                }
            };
        } else {
            privilegedAction = new PrivilegedAction<String>() { // from class: us.pinguo.common.network.HttpRequest.3
                @Override // java.security.PrivilegedAction
                public String run() {
                    return System.clearProperty(str);
                }
            };
        }
        return (String) AccessController.doPrivileged(privilegedAction);
    }

    public HttpRequest accept(String str) {
        return header(HEADER_ACCEPT, str);
    }

    public HttpRequest acceptCharset(String str) {
        return header(HEADER_ACCEPT_CHARSET, str);
    }

    public HttpRequest acceptEncoding(String str) {
        return header(HEADER_ACCEPT_ENCODING, str);
    }

    public HttpRequest acceptGzipEncoding() {
        return acceptEncoding(ENCODING_GZIP);
    }

    public HttpRequest acceptJson() {
        return accept(CONTENT_TYPE_JSON);
    }

    public HttpRequest authorization(String str) {
        return header(HEADER_AUTHORIZATION, str);
    }

    public boolean badRequest() throws HttpRequestException {
        return 400 == code();
    }

    public HttpRequest basic(String str, String str2) {
        byte[] bytes;
        String str3 = str + ':' + str2;
        try {
            bytes = str3.getBytes("US-ASCII");
        } catch (UnsupportedEncodingException unused) {
            bytes = str3.getBytes();
        }
        return authorization("Basic " + Base64.encodeToString(bytes, 0));
    }

    public String body(String str) throws HttpRequestException {
        ByteArrayOutputStream byteStream = byteStream();
        try {
            copy(buffer(), byteStream);
            return byteStream.toString(getValidCharset(str));
        } catch (IOException e2) {
            throw new HttpRequestException(e2);
        }
    }

    public BufferedInputStream buffer() throws HttpRequestException {
        return new BufferedInputStream(stream(), this.bufferSize);
    }

    public HttpRequest bufferSize(int i2) {
        if (i2 >= 1) {
            this.bufferSize = i2;
            return this;
        }
        throw new IllegalArgumentException("Size must be greater than zero");
    }

    public BufferedReader bufferedReader(String str) throws HttpRequestException {
        return new BufferedReader(reader(str), this.bufferSize);
    }

    protected ByteArrayOutputStream byteStream() throws HttpRequestException {
        int contentLength = contentLength();
        if (contentLength > 0) {
            return new ByteArrayOutputStream(contentLength);
        }
        return new ByteArrayOutputStream();
    }

    public byte[] bytes() throws HttpRequestException {
        ByteArrayOutputStream byteStream = byteStream();
        try {
            copy(buffer(), byteStream);
            return byteStream.toByteArray();
        } catch (IOException e2) {
            throw new HttpRequestException(e2);
        }
    }

    public String cacheControl() throws HttpRequestException {
        return header(HEADER_CACHE_CONTROL);
    }

    public String charset() throws HttpRequestException {
        return parameter(HEADER_CONTENT_TYPE, PARAM_CHARSET);
    }

    public HttpRequest chunk(int i2) {
        this.connection.setChunkedStreamingMode(i2);
        return this;
    }

    protected HttpRequest closeOutput() throws IOException {
        RequestOutputStream requestOutputStream = this.output;
        if (requestOutputStream == null) {
            return this;
        }
        if (this.multipart) {
            requestOutputStream.write("\r\n--00content0boundary00--\r\n");
        }
        if (this.ignoreCloseExceptions) {
            try {
                this.output.close();
            } catch (IOException unused) {
            }
        } else {
            this.output.close();
        }
        this.output = null;
        return this;
    }

    protected HttpRequest closeOutputQuietly() throws HttpRequestException {
        try {
            return closeOutput();
        } catch (IOException e2) {
            throw new HttpRequestException(e2);
        }
    }

    public int code() throws HttpRequestException {
        try {
            closeOutput();
            return this.connection.getResponseCode();
        } catch (IOException e2) {
            throw new HttpRequestException(e2);
        }
    }

    public HttpRequest connectTimeout(int i2) {
        this.connection.setConnectTimeout(i2);
        return this;
    }

    public String contentEncoding() throws HttpRequestException {
        return header(HEADER_CONTENT_ENCODING);
    }

    public int contentLength() throws HttpRequestException {
        return intHeader(HEADER_CONTENT_LENGTH);
    }

    public HttpRequest contentType(String str) {
        return contentType(str, null);
    }

    protected HttpRequest copy(final InputStream inputStream, final OutputStream outputStream) throws IOException {
        return new CloseOperation<HttpRequest>(inputStream, this.ignoreCloseExceptions) { // from class: us.pinguo.common.network.HttpRequest.7
            @Override // us.pinguo.common.network.HttpRequest.Operation
            public HttpRequest run() throws IOException {
                byte[] bArr = new byte[HttpRequest.this.bufferSize];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        outputStream.write(bArr, 0, read);
                        HttpRequest.access$214(HttpRequest.this, read);
                        HttpRequest.this.progress.onProgress(HttpRequest.this.totalWritten, HttpRequest.this.totalSize);
                    } else {
                        return HttpRequest.this;
                    }
                }
            }
        }.call();
    }

    public boolean created() throws HttpRequestException {
        return 201 == code();
    }

    public long date() throws HttpRequestException {
        return dateHeader(HEADER_DATE);
    }

    public long dateHeader(String str) throws HttpRequestException {
        return dateHeader(str, -1L);
    }

    public HttpRequest disconnect() {
        this.connection.disconnect();
        return this;
    }

    public String eTag() throws HttpRequestException {
        return header(HEADER_ETAG);
    }

    public long expires() throws HttpRequestException {
        return dateHeader(HEADER_EXPIRES);
    }

    public HttpRequest followRedirects(boolean z) {
        getConnection().setInstanceFollowRedirects(z);
        return this;
    }

    public HttpRequest form(Map<?, ?> map) throws HttpRequestException {
        return form(map, "UTF-8");
    }

    public HttpURLConnection getConnection() {
        return this.connection;
    }

    protected String getParam(String str, String str2) {
        String trim;
        int length;
        if (str != null && str.length() != 0) {
            int length2 = str.length();
            int indexOf = str.indexOf(59) + 1;
            if (indexOf != 0 && indexOf != length2) {
                int indexOf2 = str.indexOf(59, indexOf);
                if (indexOf2 == -1) {
                    indexOf2 = length2;
                }
                while (indexOf < indexOf2) {
                    int indexOf3 = str.indexOf(61, indexOf);
                    if (indexOf3 != -1 && indexOf3 < indexOf2 && str2.equals(str.substring(indexOf, indexOf3).trim()) && (length = (trim = str.substring(indexOf3 + 1, indexOf2).trim()).length()) != 0) {
                        if (length > 2 && '\"' == trim.charAt(0)) {
                            int i2 = length - 1;
                            if ('\"' == trim.charAt(i2)) {
                                return trim.substring(1, i2);
                            }
                        }
                        return trim;
                    }
                    indexOf = indexOf2 + 1;
                    indexOf2 = str.indexOf(59, indexOf);
                    if (indexOf2 == -1) {
                        indexOf2 = length2;
                    }
                }
            }
        }
        return null;
    }

    protected Map<String, String> getParams(String str) {
        String trim;
        int length;
        if (str != null && str.length() != 0) {
            int length2 = str.length();
            int indexOf = str.indexOf(59) + 1;
            if (indexOf != 0 && indexOf != length2) {
                int indexOf2 = str.indexOf(59, indexOf);
                if (indexOf2 == -1) {
                    indexOf2 = length2;
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                while (indexOf < indexOf2) {
                    int indexOf3 = str.indexOf(61, indexOf);
                    if (indexOf3 != -1 && indexOf3 < indexOf2) {
                        String trim2 = str.substring(indexOf, indexOf3).trim();
                        if (trim2.length() > 0 && (length = (trim = str.substring(indexOf3 + 1, indexOf2).trim()).length()) != 0) {
                            if (length > 2 && '\"' == trim.charAt(0)) {
                                int i2 = length - 1;
                                if ('\"' == trim.charAt(i2)) {
                                    linkedHashMap.put(trim2, trim.substring(1, i2));
                                }
                            }
                            linkedHashMap.put(trim2, trim);
                        }
                    }
                    indexOf = indexOf2 + 1;
                    indexOf2 = str.indexOf(59, indexOf);
                    if (indexOf2 == -1) {
                        indexOf2 = length2;
                    }
                }
                return linkedHashMap;
            }
            return Collections.emptyMap();
        }
        return Collections.emptyMap();
    }

    public HttpRequest header(String str, String str2) {
        this.connection.setRequestProperty(str, str2);
        return this;
    }

    public HttpRequest headers(Map<String, String> map) {
        if (!map.isEmpty()) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                header(entry);
            }
        }
        return this;
    }

    public HttpRequest ifModifiedSince(long j2) {
        this.connection.setIfModifiedSince(j2);
        return this;
    }

    public HttpRequest ifNoneMatch(String str) {
        return header(HEADER_IF_NONE_MATCH, str);
    }

    public HttpRequest ignoreCloseExceptions(boolean z) {
        this.ignoreCloseExceptions = z;
        return this;
    }

    public int intHeader(String str) throws HttpRequestException {
        return intHeader(str, -1);
    }

    public boolean isBodyEmpty() throws HttpRequestException {
        return contentLength() == 0;
    }

    public long lastModified() throws HttpRequestException {
        return dateHeader(HEADER_LAST_MODIFIED);
    }

    public String location() throws HttpRequestException {
        return header(HEADER_LOCATION);
    }

    public String message() throws HttpRequestException {
        try {
            closeOutput();
            return this.connection.getResponseMessage();
        } catch (IOException e2) {
            throw new HttpRequestException(e2);
        }
    }

    public String method() {
        return this.connection.getRequestMethod();
    }

    public boolean notFound() throws HttpRequestException {
        return 404 == code();
    }

    public boolean notModified() throws HttpRequestException {
        return 304 == code();
    }

    public boolean ok() throws HttpRequestException {
        return 200 == code();
    }

    protected HttpRequest openOutput() throws IOException {
        if (this.output != null) {
            return this;
        }
        this.connection.setDoOutput(true);
        this.output = new RequestOutputStream(this.connection.getOutputStream(), getParam(this.connection.getRequestProperty(HEADER_CONTENT_TYPE), PARAM_CHARSET), this.bufferSize);
        return this;
    }

    public String parameter(String str, String str2) throws HttpRequestException {
        return getParam(header(str), str2);
    }

    public Map<String, String> parameters(String str) throws HttpRequestException {
        return getParams(header(str));
    }

    public HttpRequest part(String str, String str2) throws HttpRequestException {
        return part(str, (String) null, str2);
    }

    public HttpRequest partHeader(String str, String str2) throws HttpRequestException {
        return send(str).send(": ").send(str2).send(CRLF);
    }

    public HttpRequest progress(HttpProgress httpProgress) {
        if (httpProgress == null) {
            this.progress = HttpProgress.DEFAULT;
        } else {
            this.progress = httpProgress;
        }
        return this;
    }

    public HttpRequest readTimeout(int i2) {
        this.connection.setReadTimeout(i2);
        return this;
    }

    public InputStreamReader reader(String str) throws HttpRequestException {
        try {
            return new InputStreamReader(stream(), getValidCharset(str));
        } catch (UnsupportedEncodingException e2) {
            throw new HttpRequestException(e2);
        }
    }

    public HttpRequest receive(File file) throws HttpRequestException {
        try {
            final BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file), this.bufferSize);
            return new CloseOperation<HttpRequest>(bufferedOutputStream, this.ignoreCloseExceptions) { // from class: us.pinguo.common.network.HttpRequest.4
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // us.pinguo.common.network.HttpRequest.Operation
                public HttpRequest run() throws HttpRequestException, IOException {
                    return HttpRequest.this.receive(bufferedOutputStream);
                }
            }.call();
        } catch (FileNotFoundException e2) {
            throw new HttpRequestException(e2);
        }
    }

    public HttpRequest send(File file) throws HttpRequestException {
        try {
            return send(new BufferedInputStream(new FileInputStream(file)));
        } catch (FileNotFoundException e2) {
            throw new HttpRequestException(e2);
        }
    }

    public String server() throws HttpRequestException {
        return header(HEADER_SERVER);
    }

    public boolean serverError() throws HttpRequestException {
        return 500 == code();
    }

    protected HttpRequest startPart() throws IOException {
        if (!this.multipart) {
            this.multipart = true;
            contentType(CONTENT_TYPE_MULTIPART).openOutput();
            this.output.write("--00content0boundary00\r\n");
        } else {
            this.output.write("\r\n--00content0boundary00\r\n");
        }
        return this;
    }

    public InputStream stream() throws HttpRequestException {
        InputStream inputStream;
        if (code() < 400) {
            try {
                inputStream = this.connection.getInputStream();
            } catch (IOException e2) {
                throw new HttpRequestException(e2);
            }
        } else {
            inputStream = this.connection.getErrorStream();
            if (inputStream == null) {
                try {
                    inputStream = this.connection.getInputStream();
                } catch (IOException e3) {
                    throw new HttpRequestException(e3);
                }
            }
        }
        if (this.uncompress && ENCODING_GZIP.equals(contentEncoding())) {
            try {
                return new GZIPInputStream(inputStream);
            } catch (IOException e4) {
                throw new HttpRequestException(e4);
            }
        }
        return inputStream;
    }

    public String toString() {
        return method() + ' ' + url();
    }

    public HttpRequest trustAllCerts() throws HttpRequestException {
        HttpURLConnection httpURLConnection = this.connection;
        if (httpURLConnection instanceof HttpsURLConnection) {
            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(getTrustedFactory());
        }
        return this;
    }

    public HttpRequest trustAllHosts() {
        HttpURLConnection httpURLConnection = this.connection;
        if (httpURLConnection instanceof HttpsURLConnection) {
            ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(getTrustedVerifier());
        }
        return this;
    }

    public HttpRequest uncompress(boolean z) {
        this.uncompress = z;
        return this;
    }

    public URL url() {
        return this.connection.getURL();
    }

    public HttpRequest useCaches(boolean z) {
        this.connection.setUseCaches(z);
        return this;
    }

    public HttpRequest userAgent(String str) {
        return header(HEADER_USER_AGENT, str);
    }

    protected HttpRequest writePartHeader(String str, String str2) throws IOException {
        return writePartHeader(str, str2, null);
    }

    public OutputStreamWriter writer() throws HttpRequestException {
        try {
            openOutput();
            RequestOutputStream requestOutputStream = this.output;
            return new OutputStreamWriter(requestOutputStream, requestOutputStream.encoder.charset());
        } catch (IOException e2) {
            throw new HttpRequestException(e2);
        }
    }

    public static HttpRequest get(URL url) throws HttpRequestException {
        return new HttpRequest(url, "GET");
    }

    public static HttpRequest post(URL url) throws HttpRequestException {
        return new HttpRequest(url, "POST");
    }

    public BufferedReader bufferedReader() throws HttpRequestException {
        return bufferedReader(charset());
    }

    public HttpRequest contentLength(String str) {
        return contentLength(Integer.parseInt(str));
    }

    public HttpRequest contentType(String str, String str2) {
        if (str2 != null && str2.length() > 0) {
            return header(HEADER_CONTENT_TYPE, str + "; charset=" + str2);
        }
        return header(HEADER_CONTENT_TYPE, str);
    }

    public long dateHeader(String str, long j2) throws HttpRequestException {
        closeOutputQuietly();
        return this.connection.getHeaderFieldDate(str, j2);
    }

    public HttpRequest form(Map.Entry<?, ?> entry) throws HttpRequestException {
        return form(entry, "UTF-8");
    }

    public HttpRequest header(String str, Number number) {
        return header(str, number != null ? number.toString() : null);
    }

    public boolean ignoreCloseExceptions() {
        return this.ignoreCloseExceptions;
    }

    public int intHeader(String str, int i2) throws HttpRequestException {
        closeOutputQuietly();
        return this.connection.getHeaderFieldInt(str, i2);
    }

    public HttpRequest part(String str, String str2, String str3) throws HttpRequestException {
        return part(str, str2, (String) null, str3);
    }

    protected HttpRequest writePartHeader(String str, String str2, String str3) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("form-data; name=\"");
        sb.append(str);
        if (str2 != null) {
            sb.append("\"; filename=\"");
            sb.append(str2);
        }
        sb.append('\"');
        partHeader("Content-Disposition", sb.toString());
        if (str3 != null) {
            partHeader(HEADER_CONTENT_TYPE, str3);
        }
        return send(CRLF);
    }

    public static HttpRequest get(CharSequence charSequence, Map<?, ?> map, boolean z) throws HttpRequestException {
        String append = append(charSequence, map);
        if (z) {
            append = encode(append);
        }
        return get(append);
    }

    public static HttpRequest post(CharSequence charSequence, Map<?, ?> map, boolean z) throws HttpRequestException {
        String append = append(charSequence, map);
        if (z) {
            append = encode(append);
        }
        return post(append);
    }

    public int bufferSize() {
        return this.bufferSize;
    }

    public HttpRequest contentLength(int i2) {
        this.connection.setFixedLengthStreamingMode(i2);
        return this;
    }

    protected HttpRequest copy(final Reader reader, final Writer writer) throws IOException {
        return new CloseOperation<HttpRequest>(reader, this.ignoreCloseExceptions) { // from class: us.pinguo.common.network.HttpRequest.8
            @Override // us.pinguo.common.network.HttpRequest.Operation
            public HttpRequest run() throws IOException {
                char[] cArr = new char[HttpRequest.this.bufferSize];
                while (true) {
                    int read = reader.read(cArr);
                    if (read != -1) {
                        writer.write(cArr, 0, read);
                        HttpRequest.access$214(HttpRequest.this, read);
                        HttpRequest.this.progress.onProgress(HttpRequest.this.totalWritten, -1L);
                    } else {
                        return HttpRequest.this;
                    }
                }
            }
        }.call();
    }

    public HttpRequest form(Map.Entry<?, ?> entry, String str) throws HttpRequestException {
        try {
            JSONArray jSONArray = new JSONArray(entry.getValue().toString());
            HttpRequest httpRequest = null;
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                httpRequest = form(entry.getKey() + "[]", jSONArray.getString(i2), str);
            }
            return httpRequest;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return form(entry.getKey(), entry.getValue(), str);
        }
    }

    public HttpRequest header(Map.Entry<String, String> entry) {
        return header(entry.getKey(), entry.getValue());
    }

    public HttpRequest part(String str, String str2, String str3, String str4) throws HttpRequestException {
        try {
            startPart();
            writePartHeader(str, str2, str3);
            this.output.write(str4);
            return this;
        } catch (IOException e2) {
            throw new HttpRequestException(e2);
        }
    }

    public InputStreamReader reader() throws HttpRequestException {
        return reader(charset());
    }

    public HttpRequest code(AtomicInteger atomicInteger) throws HttpRequestException {
        atomicInteger.set(code());
        return this;
    }

    public String header(String str) throws HttpRequestException {
        closeOutputQuietly();
        return this.connection.getHeaderField(str);
    }

    public Map<String, List<String>> headers() throws HttpRequestException {
        closeOutputQuietly();
        return this.connection.getHeaderFields();
    }

    public HttpRequest send(byte[] bArr) throws HttpRequestException {
        return send(new ByteArrayInputStream(bArr));
    }

    public static HttpRequest get(CharSequence charSequence, boolean z, Object... objArr) throws HttpRequestException {
        String append = append(charSequence, objArr);
        if (z) {
            append = encode(append);
        }
        return get(append);
    }

    public static HttpRequest post(CharSequence charSequence, boolean z, Object... objArr) throws HttpRequestException {
        String append = append(charSequence, objArr);
        if (z) {
            append = encode(append);
        }
        return post(append);
    }

    public String body() throws HttpRequestException {
        return body(charset());
    }

    public String contentType() throws HttpRequestException {
        return header(HEADER_CONTENT_TYPE);
    }

    public HttpRequest receive(OutputStream outputStream) throws HttpRequestException {
        try {
            return copy(buffer(), outputStream);
        } catch (IOException e2) {
            throw new HttpRequestException(e2);
        }
    }

    public HttpRequest send(InputStream inputStream) throws HttpRequestException {
        try {
            openOutput();
            copy(inputStream, this.output);
            return this;
        } catch (IOException e2) {
            throw new HttpRequestException(e2);
        }
    }

    public String[] headers(String str) throws HttpRequestException {
        Map<String, List<String>> headers = headers();
        if (headers != null && !headers.isEmpty()) {
            List<String> list = headers.get(str);
            if (list != null && !list.isEmpty()) {
                return (String[]) list.toArray(new String[list.size()]);
            }
            return EMPTY_STRINGS;
        }
        return EMPTY_STRINGS;
    }

    public HttpRequest part(String str, Number number) throws HttpRequestException {
        return part(str, (String) null, number);
    }

    public HttpRequest receive(PrintStream printStream) throws HttpRequestException {
        return receive((OutputStream) printStream);
    }

    public HttpRequest form(Object obj, Object obj2) throws HttpRequestException {
        return form(obj, obj2, "UTF-8");
    }

    public HttpRequest part(String str, String str2, Number number) throws HttpRequestException {
        return part(str, str2, number != null ? number.toString() : null);
    }

    public HttpRequest receive(final Appendable appendable) throws HttpRequestException {
        final BufferedReader bufferedReader = bufferedReader();
        return new CloseOperation<HttpRequest>(bufferedReader, this.ignoreCloseExceptions) { // from class: us.pinguo.common.network.HttpRequest.5
            @Override // us.pinguo.common.network.HttpRequest.Operation
            public HttpRequest run() throws IOException {
                CharBuffer allocate = CharBuffer.allocate(HttpRequest.this.bufferSize);
                while (true) {
                    int read = bufferedReader.read(allocate);
                    if (read != -1) {
                        allocate.rewind();
                        appendable.append(allocate, 0, read);
                        allocate.rewind();
                    } else {
                        return HttpRequest.this;
                    }
                }
            }
        }.call();
    }

    public HttpRequest send(final Reader reader) throws HttpRequestException {
        try {
            openOutput();
            RequestOutputStream requestOutputStream = this.output;
            final OutputStreamWriter outputStreamWriter = new OutputStreamWriter(requestOutputStream, requestOutputStream.encoder.charset());
            return new FlushOperation<HttpRequest>(outputStreamWriter) { // from class: us.pinguo.common.network.HttpRequest.9
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // us.pinguo.common.network.HttpRequest.Operation
                public HttpRequest run() throws IOException {
                    return HttpRequest.this.copy(reader, outputStreamWriter);
                }
            }.call();
        } catch (IOException e2) {
            throw new HttpRequestException(e2);
        }
    }

    public HttpRequest form(Object obj, Object obj2, String str) throws HttpRequestException {
        boolean z = !this.form;
        if (z) {
            contentType(CONTENT_TYPE_FORM, str);
            this.form = true;
        }
        String validCharset = getValidCharset(str);
        try {
            openOutput();
            if (!z) {
                this.output.write(38);
            }
            this.output.write(URLEncoder.encode(obj.toString(), validCharset));
            this.output.write(61);
            if (obj2 != null) {
                this.output.write(URLEncoder.encode(obj2.toString(), validCharset));
            }
            return this;
        } catch (IOException e2) {
            throw new HttpRequestException(e2);
        }
    }

    public HttpRequest part(String str, File file) throws HttpRequestException {
        return part(str, (String) null, file);
    }

    public HttpRequest part(String str, String str2, File file) throws HttpRequestException {
        return part(str, str2, (String) null, file);
    }

    public HttpRequest(URL url, String str) throws HttpRequestException {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            this.connection = httpURLConnection;
            httpURLConnection.setRequestMethod(str);
        } catch (IOException e2) {
            throw new HttpRequestException(e2);
        }
    }

    public HttpRequest part(String str, String str2, String str3, File file) throws HttpRequestException {
        try {
            return part(str, str2, str3, new BufferedInputStream(new FileInputStream(file)));
        } catch (IOException e2) {
            throw new HttpRequestException(e2);
        }
    }

    public HttpRequest receive(final Writer writer) throws HttpRequestException {
        final BufferedReader bufferedReader = bufferedReader();
        return new CloseOperation<HttpRequest>(bufferedReader, this.ignoreCloseExceptions) { // from class: us.pinguo.common.network.HttpRequest.6
            @Override // us.pinguo.common.network.HttpRequest.Operation
            public HttpRequest run() throws IOException {
                return HttpRequest.this.copy(bufferedReader, writer);
            }
        }.call();
    }

    public HttpRequest part(String str, InputStream inputStream) throws HttpRequestException {
        return part(str, (String) null, (String) null, inputStream);
    }

    public HttpRequest send(CharSequence charSequence) throws HttpRequestException {
        try {
            openOutput();
            this.output.write(charSequence.toString());
            return this;
        } catch (IOException e2) {
            throw new HttpRequestException(e2);
        }
    }

    public HttpRequest part(String str, String str2, String str3, InputStream inputStream) throws HttpRequestException {
        try {
            startPart();
            writePartHeader(str, str2, str3);
            copy(inputStream, this.output);
            return this;
        } catch (IOException e2) {
            throw new HttpRequestException(e2);
        }
    }

    public HttpRequest form(Map<?, ?> map, String str) throws HttpRequestException {
        if (!map.isEmpty()) {
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                form(entry, str);
            }
        }
        return this;
    }

    public static String append(CharSequence charSequence, Object... objArr) {
        String charSequence2 = charSequence.toString();
        if (objArr == null || objArr.length == 0) {
            return charSequence2;
        }
        if (objArr.length % 2 == 0) {
            StringBuilder sb = new StringBuilder(charSequence2);
            addPathSeparator(charSequence2, sb);
            addParamPrefix(charSequence2, sb);
            sb.append(objArr[0]);
            sb.append('=');
            Object obj = objArr[1];
            if (obj != null) {
                sb.append(obj);
            }
            for (int i2 = 2; i2 < objArr.length; i2 += 2) {
                sb.append('&');
                sb.append(objArr[i2]);
                sb.append('=');
                Object obj2 = objArr[i2 + 1];
                if (obj2 != null) {
                    sb.append(obj2);
                }
            }
            return sb.toString();
        }
        throw new IllegalArgumentException("Must specify an even number of parameter names/values");
    }
}
