package org.apache.http.entity.mime.g;

import java.io.IOException;
import java.io.OutputStream;
/* compiled from: ContentBody.java */
/* loaded from: classes3.dex */
public interface b extends c {
    String getFilename();

    void writeTo(OutputStream outputStream) throws IOException;
}
