package com.facebook.imagepipeline.producers;

import android.net.Uri;
import android.util.Base64;
import androidx.annotation.VisibleForTesting;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
/* compiled from: DataFetchProducer.java */
/* loaded from: classes.dex */
public class m extends d0 {
    public m(com.facebook.common.memory.f fVar) {
        super(CallerThreadExecutor.getInstance(), fVar);
    }

    @VisibleForTesting
    static byte[] g(String str) {
        com.facebook.common.internal.h.b(Boolean.valueOf(str.substring(0, 5).equals("data:")));
        int indexOf = str.indexOf(44);
        String substring = str.substring(indexOf + 1, str.length());
        if (h(str.substring(0, indexOf))) {
            return Base64.decode(substring, 0);
        }
        String decode = Uri.decode(substring);
        com.facebook.common.internal.h.g(decode);
        return decode.getBytes();
    }

    @VisibleForTesting
    static boolean h(String str) {
        if (str.contains(";")) {
            String[] split = str.split(";");
            return split[split.length - 1].equals("base64");
        }
        return false;
    }

    @Override // com.facebook.imagepipeline.producers.d0
    protected com.facebook.imagepipeline.image.e d(ImageRequest imageRequest) throws IOException {
        byte[] g2 = g(imageRequest.s().toString());
        return c(new ByteArrayInputStream(g2), g2.length);
    }

    @Override // com.facebook.imagepipeline.producers.d0
    protected String f() {
        return "DataFetchProducer";
    }
}
