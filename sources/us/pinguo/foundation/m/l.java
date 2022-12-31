package us.pinguo.foundation.m;

import com.android.volley.AuthFailureError;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;
import us.pinguo.common.network.HttpRequest;
import us.pinguo.foundation.m.e;
/* compiled from: VolleyStreamRequest.java */
/* loaded from: classes4.dex */
public class l<T> extends i {

    /* renamed from: g  reason: collision with root package name */
    private long f11033g;

    /* renamed from: h  reason: collision with root package name */
    private String f11034h;

    /* renamed from: i  reason: collision with root package name */
    private File f11035i;

    /* renamed from: j  reason: collision with root package name */
    private long f11036j;

    /* renamed from: k  reason: collision with root package name */
    private e.a f11037k;

    public l(File file, long j2, long j3, String str, int i2, String str2, e.a aVar) {
        super(i2, str2, aVar);
        this.f11033g = j3;
        this.f11034h = str;
        this.f11035i = file;
        this.f11036j = j2;
        this.f11037k = aVar;
    }

    @Override // us.pinguo.foundation.m.i, com.android.volley.Request
    public String getBodyContentType() {
        return "application/octet-stream";
    }

    @Override // us.pinguo.foundation.m.i, us.pinguo.foundation.m.j
    public long getContentLength() {
        return this.f11033g;
    }

    @Override // com.android.volley.Request
    public Map<String, String> getHeaders() throws AuthFailureError {
        HashMap hashMap = new HashMap();
        hashMap.put(HttpRequest.HEADER_CONTENT_LENGTH, String.valueOf(this.f11033g));
        hashMap.put(HttpRequest.HEADER_CONTENT_TYPE, "application/octet-stream");
        hashMap.put(HttpRequest.HEADER_AUTHORIZATION, "UpToken " + this.f11034h);
        return hashMap;
    }

    @Override // us.pinguo.foundation.m.i, us.pinguo.common.network.WriteBodyRequest
    public void writeToBody(OutputStream outputStream) throws IOException {
        long j2;
        long j3;
        try {
            byte[] bArr = new byte[4096];
            RandomAccessFile randomAccessFile = new RandomAccessFile(this.f11035i, "r");
            randomAccessFile.seek(this.f11036j);
            int i2 = 0;
            while (true) {
                int read = randomAccessFile.read(bArr);
                if (read == -1) {
                    break;
                }
                long j4 = this.f11033g;
                long j5 = i2;
                long j6 = read;
                if (j4 - j5 <= j6) {
                    outputStream.write(bArr, 0, (int) (j4 - j5));
                    i2 = (int) this.f11033g;
                    e.a aVar = this.f11037k;
                    if (aVar != null) {
                        aVar.transferred(i2, (int) (j2 - j3));
                    }
                } else {
                    outputStream.write(bArr, 0, read);
                    i2 += read;
                    e.a aVar2 = this.f11037k;
                    if (aVar2 != null) {
                        aVar2.transferred(i2, j6);
                    }
                }
            }
            us.pinguo.common.log.a.k("StreamByteSum" + i2, new Object[0]);
            try {
                outputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        } catch (Throwable th) {
            try {
                outputStream.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            throw th;
        }
    }
}
