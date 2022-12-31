package com.bumptech.glide.load.model;

import android.net.Uri;
/* compiled from: AssetUriParser.java */
/* loaded from: classes.dex */
final class a {
    private static final int a = 22;

    public static boolean a(Uri uri) {
        return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
    }

    public static String b(Uri uri) {
        return uri.toString().substring(a);
    }
}
