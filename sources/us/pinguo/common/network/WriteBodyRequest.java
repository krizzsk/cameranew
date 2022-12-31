package us.pinguo.common.network;

import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes4.dex */
public interface WriteBodyRequest {
    void writeToBody(OutputStream outputStream) throws IOException;
}
