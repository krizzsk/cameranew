package com.android.pgvolley.toolbox;

import com.android.pgvolley.AuthFailureError;
import com.android.pgvolley.Request;
import java.io.IOException;
import java.util.Map;
import org.apache.http.HttpResponse;
/* loaded from: classes.dex */
public interface HttpStack {
    HttpResponse performRequest(Request<?> request, Map<String, String> map) throws IOException, AuthFailureError;
}
