package us.pinguo.bigdata.d.b;

import com.tencent.bugly.BuglyStrategy;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPOutputStream;
import us.pinguo.bigdata.network.basic.NetworkException;
/* compiled from: BDNetworkCore.java */
/* loaded from: classes3.dex */
public class a {
    private void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    private String d(String str, String str2, SequenceInputStream sequenceInputStream) throws IOException, NetworkException {
        ByteArrayOutputStream byteArrayOutputStream;
        long currentTimeMillis = System.currentTimeMillis();
        us.pinguo.common.log.a.d("zcm", "------------> request ", new Object[0]);
        Closeable closeable = null;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
            httpURLConnection.setRequestMethod(str);
            httpURLConnection.setConnectTimeout(20000);
            httpURLConnection.setReadTimeout(BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH);
            if (str.equals("POST")) {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new GZIPOutputStream(httpURLConnection.getOutputStream()));
                while (true) {
                    int read = sequenceInputStream.read();
                    if (read == -1) {
                        break;
                    }
                    bufferedOutputStream.write(read);
                }
                bufferedOutputStream.close();
            }
            int responseCode = httpURLConnection.getResponseCode();
            us.pinguo.common.log.a.d("zcm", "------------>connect time: " + String.valueOf(System.currentTimeMillis() - currentTimeMillis), new Object[0]);
            if (responseCode == 200) {
                InputStream inputStream = httpURLConnection.getInputStream();
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int read2 = inputStream.read(bArr);
                            if (read2 <= 0) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read2);
                        }
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        if (byteArray != null) {
                            String str3 = new String(byteArray, "UTF-8");
                            a(inputStream);
                            a(byteArrayOutputStream);
                            a(sequenceInputStream);
                            return str3;
                        }
                        a(inputStream);
                        a(byteArrayOutputStream);
                        a(sequenceInputStream);
                        return null;
                    } catch (Throwable th) {
                        closeable = inputStream;
                        th = th;
                        a(closeable);
                        a(byteArrayOutputStream);
                        a(sequenceInputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    closeable = inputStream;
                    th = th2;
                    byteArrayOutputStream = null;
                }
            } else {
                throw new NetworkException(responseCode, "Status code is not 200");
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
        }
    }

    public String b(String str) throws IOException, NetworkException {
        return d("GET", str, null);
    }

    public String c(String str, SequenceInputStream sequenceInputStream) throws IOException, NetworkException {
        return d("POST", str, sequenceInputStream);
    }
}
