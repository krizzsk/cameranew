package com.android.pgvolley.toolbox;

import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;
import us.pinguo.common.network.HttpRequest;
/* loaded from: classes.dex */
public class MultipartEntity implements HttpEntity {
    private static final char[] MULTIPART_CHARS = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private String mBoundary;
    private final String NEW_LINE_STR = "\r\n";
    private final String CONTENT_TYPE = "Content-Type: ";
    private final String CONTENT_DISPOSITION = "Content-Disposition: ";
    private final String TYPE_TEXT_CHARSET = "text/plain; charset=UTF-8";
    private final String TYPE_OCTET_STREAM = "application/octet-stream";
    private final byte[] BINARY_ENCODING = "Content-Transfer-Encoding: binary\r\n\r\n".getBytes();
    private final byte[] BIT_ENCODING = "Content-Transfer-Encoding: 8bit\r\n\r\n".getBytes();
    ByteArrayOutputStream mOutputStream = new ByteArrayOutputStream();

    public MultipartEntity() {
        this.mBoundary = null;
        this.mBoundary = generateBoundary();
    }

    private void closeSilently(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    private final String generateBoundary() {
        StringBuffer stringBuffer = new StringBuffer();
        Random random = new Random();
        for (int i2 = 0; i2 < 30; i2++) {
            char[] cArr = MULTIPART_CHARS;
            stringBuffer.append(cArr[random.nextInt(cArr.length)]);
        }
        return stringBuffer.toString();
    }

    private byte[] getContentDispositionBytes(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("Content-Disposition: form-data; name=\"" + str + "\"");
        if (!TextUtils.isEmpty(str2)) {
            sb.append("; filename=\"" + str2 + "\"");
        }
        sb.append("\r\n");
        return sb.toString().getBytes();
    }

    private void writeFirstBoundary() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = this.mOutputStream;
        byteArrayOutputStream.write(("--" + this.mBoundary + "\r\n").getBytes());
    }

    private void writeToOutputStream(String str, byte[] bArr, String str2, byte[] bArr2, String str3) {
        try {
            writeFirstBoundary();
            this.mOutputStream.write(getContentDispositionBytes(str, str3));
            this.mOutputStream.write(bArr2);
            this.mOutputStream.write(bArr);
            this.mOutputStream.write("\r\n".getBytes());
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void addBinaryPart(String str, byte[] bArr) {
        writeToOutputStream(str, bArr, "application/octet-stream", this.BINARY_ENCODING, "no-file");
    }

    public void addFilePart(String str, File file) {
        FileInputStream fileInputStream;
        Closeable closeable = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e2) {
            e = e2;
        }
        try {
            writeFirstBoundary();
            this.mOutputStream.write(getContentDispositionBytes(str, file.getName()));
            this.mOutputStream.write("Content-Type: application/octet-stream\r\n".getBytes());
            this.mOutputStream.write(this.BINARY_ENCODING);
            byte[] bArr = new byte[4096];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    this.mOutputStream.write(bArr, 0, read);
                } else {
                    this.mOutputStream.flush();
                    closeSilently(fileInputStream);
                    return;
                }
            }
        } catch (IOException e3) {
            e = e3;
            closeable = fileInputStream;
            e.printStackTrace();
            closeSilently(closeable);
        } catch (Throwable th2) {
            th = th2;
            closeable = fileInputStream;
            closeSilently(closeable);
            throw th;
        }
    }

    public void addStringPart(String str, String str2) {
        writeToOutputStream(str, str2.getBytes(), "text/plain; charset=UTF-8", this.BIT_ENCODING, "");
    }

    public void consumeContent() throws IOException, UnsupportedOperationException {
        if (isStreaming()) {
            throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
        }
    }

    public InputStream getContent() {
        return new ByteArrayInputStream(this.mOutputStream.toByteArray());
    }

    public Header getContentEncoding() {
        return null;
    }

    public long getContentLength() {
        return this.mOutputStream.toByteArray().length;
    }

    public Header getContentType() {
        return new BasicHeader(HttpRequest.HEADER_CONTENT_TYPE, "multipart/form-data; boundary=" + this.mBoundary);
    }

    public boolean isChunked() {
        return false;
    }

    public boolean isRepeatable() {
        return false;
    }

    public boolean isStreaming() {
        return false;
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        this.mOutputStream.write(("\r\n--" + this.mBoundary + "--").getBytes());
        outputStream.write(this.mOutputStream.toByteArray());
    }
}
