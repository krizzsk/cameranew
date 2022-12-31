package com.ironsource.sdk.controller;

import android.os.Build;
import android.webkit.JavascriptInterface;
import com.ironsource.sdk.controller.WebController;
import java.lang.reflect.Method;
import java.security.AccessControlException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ControllerAdapter.java */
/* loaded from: classes2.dex */
public class d {
    private static final String b = "d";
    private final WebController.r a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(WebController.r rVar) {
        this.a = rVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(String str, String str2) throws Exception {
        if (this.a == null) {
            com.ironsource.sdk.utils.d.b(b, "!!! nativeAPI == null !!!");
            return;
        }
        Method declaredMethod = WebController.r.class.getDeclaredMethod(str, String.class);
        if (Build.VERSION.SDK_INT >= 17 && !declaredMethod.isAnnotationPresent(JavascriptInterface.class)) {
            throw new AccessControlException("Trying to access a private function: " + str);
        }
        declaredMethod.invoke(this.a, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str) {
        WebController.r rVar = this.a;
        if (rVar != null) {
            rVar.h(str);
        }
    }
}
