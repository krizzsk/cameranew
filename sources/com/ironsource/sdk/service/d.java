package com.ironsource.sdk.service;

import android.util.Base64;
/* compiled from: Gibberish.java */
/* loaded from: classes2.dex */
public class d {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str) {
        return Base64.encodeToString(str.getBytes(), 10);
    }
}
