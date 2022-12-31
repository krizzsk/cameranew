package com.facebook.imageformat;

import com.rockerhieu.emoji.model.Emoticon;
/* compiled from: DefaultImageFormats.java */
/* loaded from: classes.dex */
public final class b {
    public static final c a = new c("JPEG", "jpeg");
    public static final c b = new c("PNG", Emoticon.TYPE_PNG);
    public static final c c = new c("GIF", Emoticon.TYPE_GIF);

    /* renamed from: d  reason: collision with root package name */
    public static final c f2651d = new c("BMP", "bmp");

    /* renamed from: e  reason: collision with root package name */
    public static final c f2652e = new c("ICO", "ico");

    /* renamed from: f  reason: collision with root package name */
    public static final c f2653f = new c("WEBP_SIMPLE", "webp");

    /* renamed from: g  reason: collision with root package name */
    public static final c f2654g = new c("WEBP_LOSSLESS", "webp");

    /* renamed from: h  reason: collision with root package name */
    public static final c f2655h = new c("WEBP_EXTENDED", "webp");

    /* renamed from: i  reason: collision with root package name */
    public static final c f2656i = new c("WEBP_EXTENDED_WITH_ALPHA", "webp");

    /* renamed from: j  reason: collision with root package name */
    public static final c f2657j = new c("WEBP_ANIMATED", "webp");

    /* renamed from: k  reason: collision with root package name */
    public static final c f2658k = new c("HEIF", "heif");

    /* renamed from: l  reason: collision with root package name */
    public static final c f2659l = new c("DNG", "dng");

    public static boolean a(c cVar) {
        return cVar == f2653f || cVar == f2654g || cVar == f2655h || cVar == f2656i;
    }

    public static boolean b(c cVar) {
        return a(cVar) || cVar == f2657j;
    }
}
