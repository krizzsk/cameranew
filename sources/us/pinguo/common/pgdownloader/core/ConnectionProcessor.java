package us.pinguo.common.pgdownloader.core;

import android.net.Uri;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import kotlin.collections.c0;
import kotlin.collections.u;
import kotlin.jvm.internal.s;
import kotlin.text.Regex;
import us.pinguo.common.network.HttpRequest;
import us.pinguo.common.pgdownloader.download.ConnectInfo;
import us.pinguo.common.pgdownloader.download.DownloadBlock;
import us.pinguo.common.pgdownloader.exception.NetworkException;
import us.pinguo.common.pgdownloader.util.FileDownloadUtils;
/* compiled from: ConnectionProcessor.kt */
/* loaded from: classes4.dex */
public final class ConnectionProcessor {
    private static final String ALLOWED_URI_CHARS = "@#&=*+-_.,:!?()/~'%";
    private static final int BUFFER_SIZE = 8192;
    private static final int DEFAULT_HTTP_CONNECT_TIMEOUT = 10000;
    private static final int DEFAULT_HTTP_READ_TIMEOUT = 100000;
    public static final ConnectionProcessor INSTANCE = new ConnectionProcessor();
    private static final int MAX_REDIRECT_COUNT = 5;

    private ConnectionProcessor() {
    }

    private final int convertContentLengthString(String str) {
        if (str == null) {
            return -1;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    private final HttpURLConnection createConnection(String str) {
        URLConnection openConnection = new URL(Uri.encode(str, ALLOWED_URI_CHARS)).openConnection();
        Objects.requireNonNull(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(DEFAULT_HTTP_READ_TIMEOUT);
        return httpURLConnection;
    }

    private final HttpURLConnection handleRedirect(HttpURLConnection httpURLConnection) {
        int responseCode = httpURLConnection.getResponseCode();
        HttpURLConnection httpURLConnection2 = httpURLConnection;
        for (int i2 = 0; responseCode / 100 == 3 && i2 < 5; i2++) {
            String headerField = httpURLConnection.getHeaderField(HttpRequest.HEADER_LOCATION);
            s.g(headerField, "targetConnection.getHeaderField(\"Location\")");
            httpURLConnection2 = createConnection(headerField);
        }
        return httpURLConnection2;
    }

    private final int parseContentRangeFoInstanceLength(String str) {
        List h2;
        boolean z;
        if (str == null) {
            return -1;
        }
        List<String> split = new Regex("/").split(str, 0);
        if (!split.isEmpty()) {
            ListIterator<String> listIterator = split.listIterator(split.size());
            while (listIterator.hasPrevious()) {
                if (listIterator.previous().length() == 0) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (!z) {
                    h2 = c0.S(split, listIterator.nextIndex() + 1);
                    break;
                }
            }
        }
        h2 = u.h();
        Object[] array = h2.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        String[] strArr = (String[]) array;
        if (strArr.length >= 2) {
            try {
                return Integer.parseInt(strArr[1]);
            } catch (NumberFormatException unused) {
            }
        }
        return -1;
    }

    public final InputStreamWithLength getStreamFromNetwork$pgdownloader2_release(DownloadBlock block) {
        s.h(block, "block");
        HttpURLConnection createConnection = createConnection(block.getUrl());
        int start = block.getStart();
        int end = block.getEnd();
        if (start > 0 || end > 0) {
            if (end > start) {
                createConnection.setRequestProperty("Range", "bytes=" + start + '-' + end);
            } else {
                createConnection.setRequestProperty("Range", "bytes=" + start + '-');
            }
        }
        HttpURLConnection handleRedirect = handleRedirect(createConnection);
        int responseCode = handleRedirect.getResponseCode();
        block.setMethod(handleRedirect.getRequestMethod());
        block.setCode(Integer.valueOf(handleRedirect.getResponseCode()));
        block.setMessage(handleRedirect.getResponseMessage());
        if (responseCode < 400) {
            InputStream inputStream = handleRedirect.getInputStream();
            s.g(inputStream, "conn.inputStream");
            return new InputStreamWithLength(new BufferedInputStream(inputStream, 8192), handleRedirect.getContentLength());
        }
        throw new NetworkException(responseCode);
    }

    public final ConnectInfo trailConnect(String url) {
        s.h(url, "url");
        HttpURLConnection handleRedirect = handleRedirect(createConnection(url));
        int parseContentRangeFoInstanceLength = parseContentRangeFoInstanceLength(handleRedirect.getHeaderField("Content-Range"));
        if (parseContentRangeFoInstanceLength < 0) {
            parseContentRangeFoInstanceLength = convertContentLengthString(handleRedirect.getHeaderField(HttpRequest.HEADER_CONTENT_LENGTH));
        }
        String parseContentDisposition = FileDownloadUtils.INSTANCE.parseContentDisposition(handleRedirect.getHeaderField("Content-Disposition"));
        if (TextUtils.isEmpty(parseContentDisposition)) {
            parseContentDisposition = FileDownloadUtils.generateFileName(url);
        }
        s.e(parseContentDisposition);
        return new ConnectInfo(parseContentRangeFoInstanceLength, parseContentDisposition);
    }
}
