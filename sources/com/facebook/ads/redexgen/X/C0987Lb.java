package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import androidx.annotation.Nullable;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
/* renamed from: com.facebook.ads.redexgen.X.Lb  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0987Lb {
    public static byte[] A00;
    public static String[] A01 = {"IOEZorjxOvw6WLkUEnC6RZ8kEO9", "tHPeSZxRvwouZJrSTjrDS", "TwGUtlC7GZyiucHxYkx3tmK4C4H8dlEQ", "GjCU5mOPxx9IT2wExHvtqMTRFU0QzxAJ", "XmpOvjLSyfhgS8Wil7aGxd4h0rPRF491", "y4S9iPYd4rIMIRQ9MJO3pBhIPGP4T8Jh", "23Thg1fStvZGySLsE7bFCmDmP0GXJhTR", "jegZiJVYRtoFlccHEdL0d7ywmKE0efBM"};

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 5);
        }
        return new String(copyOfRange);
    }

    public static void A06() {
        A00 = new byte[]{-113, -46, -34, -35, -29, -48, -40, -35, -30, -113, -35, -34, -35, -100, -41, -44, -25, -113, -46, -41, -48, -31, -48, -46, -29, -44, -31, -30, -120, -123, -115, -121, -123, -119, -119, -120, -120, -123, -115, -121, -123, -120, -121, -73, -74, -123, -123, -120, -123, -121, -123, -122, -123, -121, -123, -121, -123, -114, -123, -123, -72, -121, -70, -123, -115, -116, -119, -117, -117, -119, -119, -74, -120, -123, -115, -71, -120, -123, -123, -71, -123, -117, -123, -114, -121, -74, -115, -117, -119, -115, -115, -117, -69, -116, -123, -71, -123, -122, -123, -122, -123, -119, -123, -118, -123, -123, -120, -123, -116, -119, -120, -122, -123, -73, -120, -123, -123, -114, -123, -117, -123, -120, -118, -118, -123, -119, -123, -117, -122, -120, -123, -121, -118, -118, -118, -120, -120, -122, -122, -120, -120, -123, -122, -122, -123, -117, -123, -120, -118, -118, -123, -119, -123, -115, -122, -120, -123, -74, -119, -120, -117, -122, -117, -72, -117, -114, -117, -117, -117, -69, -116, -121, -117, -70, -117, -114, -117, -122, -120, -122, -122, -117, -120, -123, -122, -119, -123, -117, -123, -120, -118, -118, -123, -119, -123, -116, -122, -120, -123, -71, -119, -71, -117, -69, -116, -118, -117, -70, -116, -119, -117, -122, -117, -114, -117, -70, -121, -123, -118, -117, -117, -114, -117, -118, -116, -116, -120, -122, -122, -119, -120, -123, -122, -121, -123, -117, -123, -120, -118, -118, -123, -119, -123, -74, -122, -120, -123, -73, -119, -116, -117, -69, -117, -69, -117, -116, -117, -72, -117, -118, -121, -123, -119, -114, -117, -70, -117, -120, -121, -70, -120, -122, -122, -123, -120, -123, -123, -70, -123, -117, -123, -120, -118, -118, -123, -119, -123, -73, -122, -120, -123, -116, -119, -122, -117, -70, -117, -119, -116, -121, -117, -69, -117, -114, -117, -119, -120, -122, -122, -123, -120, -123, -123, -70, -123, -117, -123, -120, -118, -118, -123, -119, -123, -120, -122, -120, -123, -116, -119, -122, -117, -70, -117, -119, -116, -121, -117, -69, -117, -114, -117, -119, -120, -123, -122, -70, -122, -116, -123, -71, -120, -123, -120, -115, -120, -123, -120, -115, -120, -121, -120, -122, -120, -121, -120, -120, -120, -122, -120, -120, -120, -120, -120, -119, -118, -74, -122, -116, -123, -71, -120, -120, -120, -117, -120, -123, -120, -122, -120, -123, -120, -116, -120, -121, -120, -120, -120, -122, -120, -120, -120, -120, -120, -119, -118, -74, -120, -123, -116, -119, -120, -122, -123, -73, -120, -123, -123, -114, -123, -117, -123, -120, -118, -118, -123, -119, -123, -117, -122, -120, -123, -121, -118, -118, -118, -120, -120, -122, -122, -120, -120, -123, -122, -122, -123, -117, -123, -120, -118, -118, -123, -119, -123, -115, -122, -120, -123, -74, -119, -120, -117, -122, -117, -72, -117, -114, -117, -117, -117, -69, -116, -121, -117, -70, -117, -114, -117, -122, -120, -122, -122, -117, -120, -123, -122, -119, -123, -117, -123, -120, -118, -118, -123, -119, -123, -116, -122, -120, -123, -71, -119, -71, -117, -69, -116, -118, -117, -70, -116, -119, -117, -122, -117, -114, -117, -70, -121, -123, -118, -117, -117, -114, -117, -118, -116, -116, -120, -122, -122, -119, -120, -123, -122, -121, -123, -117, -123, -120, -118, -118, -123, -119, -123, -74, -122, -120, -123, -73, -119, -116, -117, -69, -117, -69, -117, -116, -117, -72, -117, -118, -121, -123, -119, -114, -117, -70, -117, -120, -121, -70, -120, -122, -122, -123, -120, -123, -123, -70, -123, -117, -123, -120, -118, -118, -123, -119, -123, -73, -122, -120, -123, -116, -119, -122, -117, -70, -117, -119, -116, -121, -117, -69, -117, -114, -117, -119, -120, -122, -122, -123, -120, -123, -123, -70, -123, -117, -123, -120, -118, -118, -123, -119, -123, -120, -122, -120, -123, -116, -119, -122, -117, -70, -117, -119, -116, -121, -117, -69, -117, -114, -117, -119, -120, -123, -115, -121, -123, -122, -121, -123, -120, -123, -123, -71, -123, -117, -123, -114, -121, -74, -115, -117, -119, -115, -115, -117, -69, -116, -123, -71, -123, -122, -123, -122, -123, -122, -123, -118, -123, -123, -123, -120, -115, -121, -123, -122, -123, -71, -123, -123, -120, -123, -115, -121, -123, -122, -123, -115, -123, -121, -115, -121, -123, -122, -123, -122, -123, -123, -74, -73, -118, -117, -121, -70, -123, -123, -71, -115, -120, -73, -74, -121, -123, -115, -74, -70, -123, -74, -114, -117, -117, -69, -122, -121, -119, -70, -121, -114, -71, -74, -122, -122, -69, -121, -74, -73, -118, -117, -71, -123, -115, -69, -118, -115, -70, -121, -72, -72, -74, -114, -122, -120, -123, -120, -70, -114, -73, -116, -118, -119, -71, -120, -116, -121, -69, -117, -119, -123, -74, -116, -122, -73, -122, -71, -72, -73, -122, -120, -123, -114, -117, -116, -117, -121, -119, -70, -119, -117, -118, -117, -74, -116, -116, -116, -117, -74, -114, -121, -122, -114, -120, -71, -73, -121, -70, -118, -73, -69, -73, -116, -121, -119, -74, -114, -122, -70, -116, -116, -122, -115, -115, -73, -123, -70, -117, -74, -119, -116, -74, -119, -120, -73, -120, -120, -71, -114, -117, -123, -114, -73, -116, -116, -122, -115, -120, -122, -119, -118, -72, -72, -71, -69, -116, -73, -121, -70, -118, -115, -117, -117, -116, -119, -72, -114, -70, -122, -118, -117, -118, -73, -122, -69, -119, -72, -117, -74, -118, -114, -118, -118, -73, -69, -69, -121, -118, -122, -74, -117, -120, -71, -74, -73, -69, -114, -72, -118, -118, -72, -121, -116, -121, -121, -121, -121, -118, -121, -70, -115, -116, -118, -70, -119, -69, -115, -122, -118, -119, -74, -117, -119, -118, -69, -115, -114, -116, -122, -117, -115, -72, -123, -73, -122, -73, -69, -72, -117, -122, -121, -70, -74, -73, -69, -116, -115, -118, -116, -117, -114, -73, -73, -120, -119, -74, -74, -116, -114, -115, -119, -71, -72, -116, -70, -121, -70, -74, -121, -116, -117, -119, -72, -74, -70, -115, -120, -123, -116, -71, -115, -72, -122, -116, -122, -118, -119, -71, -116, -70, -70, -118, -69, 
        -117, -119, -74, -118, -122, -74, -119, -119, -74, -117, -123, -121, -72, -121, -119, -114, -123, -118, -119, -122, -118, -116, -71, -72, -123, -121, -72, -71, -118, -69, -118, -72, -123, -70, -118, -118, -69, -73, -70, -69, -115, -118, -122, -114, -69, -73, -70, -120, -121, -116, -69, -123, -73, -122, -118, -122, -122, -117, -114, -121, -72, -118, -74, -123, -117, -69, -122, -114, -71, -122, -115, -120, -115, -118, -69, -118, -72, -119, -71, -73, -72, -121, -71, -117, -73, -114, -120, -69, -117, -115, -72, -72, -121, -114, -116, -114, -72, -116, -123, -70, -122, -115, -74, -73, -114, -120, -115, -117, -117, -73, -120, -73, -71, -118, -71, -73, -115, -114, -114, -114, -118, -118, -121, -74, -123, -70, -120, -73, -119, -72, -114, -114, -71, -69, -118, -115, -69, -73, -114, -122, -115, -73, -70, -71, -72, -122, -115, -121, -73, -74, -120, -118, -70, -123, -123, -120, -72, -122, -73, -119, -73, -122, -123, -71, -71, -121, -119, -119, -74, -115, -70, -70, -121, -119, -69, -69, -69, -71, -120, -120, -120, -115, -116, -121, -74, -73, -118, -121, -121, -122, -114, -115, -118, -70, -71, -74, -73, -123, -69, -72, -123, -71, -123, -73, -122, -119, -118, -73, -117, -74, -74, -122, -114, -121, -115, -118, -115, -70, -116, -114, -123, -121, -123, -122, -123, -120, -74, -120, -115, -122, -71, -114, -120, -123, -115, -122, -71, -117, -120, -123, -122, -71, -123, -117, -123, -120, -118, -118, -122, -71, -123, -70, -123, -119, -122, -117, -123, -119, -122, -119, -72, -116, -116, -71, -115, -72, -72, -121, -121, -122, -122, -116, -118, -117, -121, -118, -114, -74, -116, -69, -71, -120, -115, -121, -71, -69, -117, -73, -70, -120, -114, -115, -70, -119, -71, -116, -115, -117, -74, -118, -120, -123, -115, -122, -74, -117, -123, -117, -123, -120, -118, -118, -122, -71, -121, -120, -123, -119, -115, -122, -114, -70, -120, -123, -115, -122, -114, -73, -115, -123, -122, -119, -72, -116, -116, -71, -115, -72, -72, -121, -121, -122, -122, -116, -118, -117, -121, -118, -114, -74, -116, -69, -71, -120, -115, -121, -71, -69, -117, -73, -70, -120, -114, -115, -70, -119, -71, -116, -115, -117, -74, -118, -74, -122, -116, -115, -74, -119, -116, -117, -120, -123, -116, -119, -120, -122, -123, -73, -120, -123, -123, -114, -123, -117, -123, -120, -118, -118, -123, -119, -123, -117, -122, -120, -123, -121, -118, -118, -118, -120, -120, -122, -122, -120, -120, -123, -122, -122, -123, -117, -123, -120, -118, -118, -123, -119, -123, -115, -122, -120, -123, -74, -119, -120, -117, -122, -117, -72, -117, -114, -117, -117, -117, -69, -116, -121, -117, -70, -117, -114, -117, -122, -120, -122, -122, -117, -120, -123, -122, -119, -123, -117, -123, -120, -118, -118, -123, -119, -123, -116, -122, -120, -123, -71, -119, -71, -117, -69, -116, -118, -117, -70, -116, -119, -117, -122, -117, -114, -117, -70, -121, -123, -118, -117, -117, -114, -117, -118, -116, -116, -120, -122, -122, -119, -120, -123, -122, -121, -123, -117, -123, -120, -118, -118, -123, -119, -123, -74, -122, -120, -123, -73, -119, -116, -117, -69, -117, -69, -117, -116, -117, -72, -117, -118, -121, -123, -119, -114, -117, -70, -117, -120, -121, -70, -120, -122, -122, -123, -120, -123, -123, -70, -123, -117, -123, -120, -118, -118, -123, -119, -123, -73, -122, -120, -123, -116, -119, -122, -117, -70, -117, -119, -116, -121, -117, -69, -117, -114, -117, -119, -120, -122, -122, -123, -120, -123, -123, -70, -123, -117, -123, -120, -118, -118, -123, -119, -123, -120, -122, -120, -123, -116, -119, -122, -117, -70, -117, -119, -116, -121, -117, -69, -117, -114, -117, -119, -115, -121, -123, -114, -123, -123, -72, -121, -70, -123, -115, -116, -119, -117, -117, -119, -119, -74, -120, -123, -115, -71, -120, -123, -123, -72, -123, -117, -123, -120, -118, -118, -122, -71, -122, -120, -123, -119, -123, -118, -120, -123, -123, -120, -123, -122, -123, -122, -69, -69, -120, -123, -123, -71, -123, -117, -123, -114, -121, -74, -115, -117, -119, -115, -115, -117, -69, -116, -123, -71, -123, -122, -123, -122, -123, -119, -123, -118, -123, -123, -123, -120, -115, -121, -123, -122, -123, -122, -123, -123, -117, -71, -71, -121, -118, -121, -72, -70, -70, -69, -115, -118, -120, -123, -121, -72, -120, -117, -123, -74, -74, -74, -72, -70, -114, -120, -114, -73, -72, -69, -69, -121, -72, -72, -74, -114, -123, -119, -73, -73, -118, -71, -116, -74, -122, -117, -117, -122, -69, -115, -74, -70, -119, -117, -73, -121, -114, -114, -119, -121, -123, -119, -71, -123, -69, -69, -119, -74, -117, -115, -72, -116, -70, -71, -122, -74, -118, -120, -122, -70, -72, -119, -118, -114, -118, -74, -117, -121, -120, -72, -70, -117, -123, -116, -117, -120, -73, -122, -117, -116, -121, -114, -116, -74, -116, -74, -70, -120, -118, -116, -122, -121, -72, -119, -123, -116, -69, -121, -123, -115, -69, -123, -72, -73, -122, -123, -114, -119, -121, -114, -122, -121, -119, -71, -116, -73, -122, -123, -117, -121, -122, -114, -72, -123, -115, -119, -72, -74, -120, -70, -73, -120, -69, -114, -74, -71, -118, -69, -73, -115, -116, -122, -70, -69, -114, -121, -121, -117, -114, -74, -115, -73, -70, -121, -115, -73, -69, -122, -117, -71, -119, -119, -72, -115, -71, -114, -74, -123, -115, -70, -117, -72, -73, -121, -69, -123, -123, -118, -73, -73, -120, -69, -70, -121, -72, -73, -114, -117, -119, -119, -116, -70, -115, -117, -115, -70, -116, -120, -122, -123, -116, -117, -74, -71, -119, -118, -73, -120, -120, -69, -117, -123, -123, -114, -70, -74, -122, -114, -72, -122, -117, -122, -70, -117, -121, -117, -119, -122, -74, -74, -114, -114, -121, -116, -122, -71, -69, -71, -118, -121, -121, -115, -72, -118, -72, -118, -115, -116, -115, -116, -118, -71, -71, -73, -116, -69, -119, -118, -121, -116, -118, -115, -71, -117, -117, -122, -69, -117, -72, -72, -123, -72, -72, -72, 
        -73, -116, -120, -118, -121, -70, -119, -121, -119, -72, -72, -119, -120, -117, -118, -72, -118, -121, -120, -118, -120, -121, -69, -116, -120, -121, -118, -122, -120, -116, -118, -114, -120, -72, -119, -74, -70, -120, -119, -122, -69, -119, -71, -73, -119, -122, -70, -71, -71, -74, -123, -71, -123, -73, -122, -123, -116, -122, -74, -116, -72, -119, -119, -123, -69, -123, -69, -70, -114, -70, -74, -123, -122, -72, -73, -117, -121, -116, -72, -74, -117, -116, -119, -120, -117, -114, -71, -123, -115, -119, -73, -71, -121, -69, -71, -114, -122, -122, -69, -69, -123, -117, -72, -71, -73, -69, -121, -72, -69, -74, -122, -123, -71, -72, -123, -69, -115, -114, -120, -74, -70, -120, -118, -116, -117, -121, -114, -122, -114, -123, -119, -115, -72, -116, -70, -69, -72, -117, -119, -72, -116, -122, -119, -119, -122, -116, -115, -120, -119, -121, -69, -116, -123, -118, -115, -122, -72, -114, -71, -70, -118, -116, -120, -74, -69, -118, -118, -73, -120, -114, -123, -71, -71, -116, -69, -71, -73, -114, -119, -122, -115, -117, -120, -122, -115, -114, -118, -71, -118, -69, -116, -118, -114, -69, -120, -123, -122, -122, -121, -117, -115, -116, -69, -69, -117, -121, -122, -119, -122, -123, -72, -123, -117, -114, -120, -123, -115, -74, -95, -98, -90, -96, -98, -94, -49, -90, -95, -98, -90, -96, -98, -95, -89, -98, -49, -98, -98, -95, -98, -96, -98, -97, -98, -96, -98, -96, -98, -89, -98, -98, -46, -93, -90, -93, -48, -90, -92, -47, -91, -46, -46, -95, -94, -45, -44, -93, -95, -98, -98, -46, -98, -92, -98, -89, -96, -49, -90, -92, -94, -90, -90, -92, -44, -91, -98, -46, -98, -97, -98, -97, -98, -94, -98, -93, -98, -98, -95, -98, -90, -97, -89, -94, -95, -97, -98, -48, -95, -98, -98, -89, -98, -92, -98, -95, -93, -93, -98, -94, -98, -92, -97, -95, -98, -96, -93, -93, -93, -95, -95, -97, -97, -95, -95, -98, -97, -97, -98, -92, -98, -95, -93, -93, -98, -94, -98, -90, -97, -95, -98, -49, -94, -95, -92, -97, -92, -47, -92, -89, -92, -92, -92, -44, -91, -96, -92, -45, -92, -89, -92, -97, -95, -97, -97, -92, -95, -98, -97, -94, -98, -92, -98, -95, -93, -93, -98, -94, -98, -91, -97, -95, -98, -46, -94, -46, -92, -44, -91, -93, -92, -45, -91, -94, -92, -97, -92, -89, -92, -45, -96, -98, -93, -92, -92, -89, -92, -93, -91, -91, -95, -97, -97, -98, -95, -98, -98, -45, -98, -92, -98, -95, -93, -93, -98, -94, -98, -49, -97, -95, -98, -91, -94, -97, -92, -45, -92, -94, -91, -96, -92, -44, -92, -89, -92, -94, -95, -97, -97, -98, -95, -98, -98, -45, -98, -92, -98, -95, -93, -93, -98, -94, -98, -48, -97, -95, -98, -91, -94, -97, -92, -45, -92, -94, -91, -96, -92, -44, -92, -89, -92, -94, -95, -97, -97, -98, -95, -98, -98, -45, -98, -92, -98, -95, -93, -93, -98, -94, -98, -95, -97, -95, -98, -91, -94, -97, -92, -45, -92, -94, -91, -96, -92, -44, -92, -89, -92, -94, -95, -97, -96, -96, -95, -98, -96, -98, -98, -92, -98, -89, -96, -49, -90, -92, -94, -90, -90, -92, -44, -91, -98, -46, -98, -97, -98, -89, -98, -97, -97, -92, -97, -95, -92, -97, -92, -45, -92, -94, -91, -96, -92, -44, -92, -89, -92, -94, -94, -98, -92, -97, -92, -45, -92, -94, -91, -96, -92, -44, -92, -89, -92, -94, -96, -45, -92, -95, -92, -44, -92, -46, -95, -98, -97, -45, -97, -91, -98, -46, -95, -98, -95, -90, -95, -98, -95, -94, -95, -97, -95, -93, -95, -96, -95, -95, -95, -95, -95, -92, -95, -93, -95, -92, -93, -49, -97, -91, -98, -46, -95, -95, -95, -93, -95, -98, -95, -89, -95, -98, -95, -97, -95, -96, -95, -95, -95, -95, -95, -92, -95, -93, -95, -92, -93, -49, -95, -98, -90, -97, -89, -94, -95, -97, -98, -48, -95, -98, -98, -89, -98, -92, -98, -95, -93, -93, -98, -94, -98, -92, -97, -95, -98, -96, -93, -93, -93, -95, -95, -97, -97, -95, -95, -98, -97, -97, -98, -92, -98, -95, -93, -93, -98, -94, -98, -90, -97, -95, -98, -49, -94, -95, -92, -97, -92, -47, -92, -89, -92, -92, -92, -44, -91, -96, -92, -45, -92, -89, -92, -97, -95, -97, -97, -92, -95, -98, -97, -94, -98, -92, -98, -95, -93, -93, -98, -94, -98, -91, -97, -95, -98, -46, -94, -46, -92, -44, -91, -93, -92, -45, -91, -94, -92, -97, -92, -89, -92, -45, -96, -98, -93, -92, -92, -89, -92, -93, -91, -91, -95, -97, -97, -98, -95, -98, -98, -45, -98, -92, -98, -95, -93, -93, -98, -94, -98, -49, -97, -95, -98, -91, -94, -97, -92, -45, -92, -94, -91, -96, -92, -44, -92, -89, -92, -94, -95, -97, -97, -98, -95, -98, -98, -45, -98, -92, -98, -95, -93, -93, -98, -94, -98, -48, -97, -95, -98, -91, -94, -97, -92, -45, -92, -94, -91, -96, -92, -44, -92, -89, -92, -94, -95, -97, -97, -98, -95, -98, -98, -45, -98, -92, -98, -95, -93, -93, -98, -94, -98, -95, -97, -95, -98, -91, -94, -97, -92, -45, -92, -94, -91, -96, -92, -44, -92, -89, -92, -94, -95, -97, -96, -96, -95, -98, -96, -98, -98, -92, -98, -89, -96, -49, -90, -92, -94, -90, -90, -92, -44, -91, -98, -46, -98, -97, -98, -89, -98, -97, -97, -92, -97, -95, -92, -97, -92, -45, -92, -94, -91, -96, -92, -44, -92, -89, -92, -94, -94, -98, -92, -97, -92, -45, -92, -94, -91, -96, -92, -44, -92, -89, -92, -94, -96, -45, -92, -95, -92, -44, -92, -46, -95, -98, -90, -96, -98, -97, -96, -98, -95, -98, -98, -46, -98, -92, -98, -89, -96, -49, -90, -92, -94, -90, -90, -92, -44, -91, -98, -46, -98, -97, -98, -97, -98, -97, -98, -93, 
        -98, -98, -98, -95, -90, -96, -98, -97, -98, -46, -98, -98, -95, -98, -90, -96, -98, -97, -98, -90, -98, -96, -90, -96, -98, -97, -98, -97, -98, -98, -46, -92, -47, -45, -96, -45, -98, -90, -98, -49, -48, -44, -45, -96, -95, -97, -94, -46, -46, -97, -90, -46, -48, -95, -47, -44, -46, -95, -97, -90, -93, -47, -48, -94, -95, -46, -95, -95, -44, -49, -98, -47, -91, -94, -45, -97, -48, -46, -48, -92, -46, -97, -46, -48, -90, -89, -97, -95, -44, -92, -96, -47, -93, -47, -95, -89, -46, -44, -93, -92, -44, -90, -94, -92, -90, -97, -95, -46, -92, -93, -48, -45, -47, -98, -44, -95, -47, -49, -94, -96, -92, -48, -98, -91, -47, -93, -49, -90, -45, -46, -93, -49, -95, -89, -89, -98, -47, -97, -92, -91, -45, -91, -92, -48, -47, -89, -89, -89, -48, -89, -96, -91, -90, -89, -94, -48, -90, -44, -98, -48, -96, -96, -98, -98, -97, -89, -89, -94, -49, -89, -96, -89, -97, -93, -45, -93, -91, -96, -47, -93, -92, -46, -96, -49, -95, -98, -97, -48, -49, -95, -92, -44, -47, -93, -44, -47, -97, -97, -95, -49, -46, -92, -47, -48, -89, -45, -91, -94, -95, -93, -49, -97, -92, -46, -96, -95, -49, -48, -91, -46, -44, -49, -45, -45, -45, -97, -92, -93, -45, -94, -46, -44, -97, -44, -98, -49, -90, -46, -48, -46, -49, -91, -98, -49, -90, -92, -89, -46, -93, -97, -92, -47, -94, -45, -89, -46, -98, -93, -97, -97, -89, -92, -47, -49, -91, -47, -98, -47, -93, -93, -91, -44, -97, -91, -93, -48, -47, -95, -91, -93, -44, -89, -94, -90, -47, -93, -92, -49, -49, -45, -90, -92, -98, -90, -89, -48, -49, -94, -94, -44, -90, -49, -49, -92, -49, -94, -46, -46, -89, -49, -91, -46, -48, -44, -96, -47, -98, -49, -95, -93, -96, -96, -90, -96, -49, -46, -98, -92, -48, -90, -47, -47, -97, -90, -93, -45, -48, -97, -93, -93, -91, -89, -45, -45, -44, -90, -92, -46, -98, -90, -98, -48, -97, -46, -92, -97, -90, -89, -47, -98, -44, -89, -49, -44, -89, -90, -48, -97, -47, -96, -45, -48, -46, -97, -98, -91, -45, -49, -94, -93, -49, -48, -46, -48, -92, -90, -49, -95, -47, -91, -90, -95, -90, -49, -93, -45, -93, -94, -90, -90, -47, -91, -92, -47, -93, -95, -46, -94, -98, -48, -97, -96, -97, -46, -45, -91, -48, -48, -46, -95, -98, -45, -92, -96, -98, -47, -97, -90, -90, -49, -45, -97, -49, -49, -92, -97, -46, -48, -48, -47, -90, -91, -46, -46, -95, -47, -92, -94, -93, -44, -96, -44, -93, -93, -44, -95, -46, -94, -47, -95, -91, -93, -45, -47, -94, -98, -91, -98, -49, -89, -95, -44, -91, -97, -93, -97, -46, -90, -95, -92, -91, -98, -47, -97, -92, -49, -89, -91, -97, -49, -48, -45, -93, -45, -44, -96, -46, -97, -97, -90, -89, -98, -45, -97, -48, -90, -49, -45, -44, -95, -96, -89, -90, -47, -44, -98, -92, -92, -48, -44, -89, -45, -92, -47, -45, -97, -94, -94, -49, -47, -89, -49, -45, -90, -92, -46, -97, -47, -97, -48, -98, -44, -98, -96, -98, -97, -98, -95, -49, -95, -90, -97, -44, -47, -95, -98, -90, -97, -44, -89, -95, -98, -97, -46, -98, -92, -98, -95, -93, -93, -97, -46, -98, -45, -98, -94, -97, -92, -98, -94, -97, -94, -90, -46, -97, -47, -47, -93, -48, -45, -89, -93, -94, -47, -94, -95, -95, -47, -92, -97, -90, -92, -95, -49, -97, -93, -48, -98, -94, -47, -48, -47, -98, -95, -44, -96, -94, -44, -45, -98, -48, -96, -95, -98, -90, -97, -47, -89, -98, -92, -98, -95, -93, -93, -97, -46, -96, -95, -98, -94, -90, -97, -47, -97, -95, -98, -90, -97, -48, -45, -90, -98, -97, -94, -90, -46, -97, -47, -47, -93, -48, -45, -89, -93, -94, -47, -94, -95, -95, -47, -92, -97, -90, -92, -95, -49, -97, -93, -48, -98, -94, -47, -48, -47, -98, -95, -44, -96, -94, -44, -45, -98, -48, -96, -49, -97, -90, -97, -89, -49, -49, -94, -90, -97, -89, -91, -95, -98, -90, -97, -89, -94, -95, -97, -98, -48, -95, -98, -98, -89, -98, -92, -98, -95, -93, -93, -98, -94, -98, -92, -97, -95, -98, -96, -93, -93, -93, -95, -95, -97, -97, -95, -95, -98, -97, -97, -98, -92, -98, -95, -93, -93, -98, -94, -98, -90, -97, -95, -98, -49, -94, -95, -92, -97, -92, -47, -92, -89, -92, -92, -92, -44, -91, -96, -92, -45, -92, -89, -92, -97, -95, -97, -97, -92, -95, -98, -97, -94, -98, -92, -98, -95, -93, -93, -98, -94, -98, -91, -97, -95, -98, -46, -94, -46, -92, -44, -91, -93, -92, -45, -91, -94, -92, -97, -92, -89, -92, -45, -96, -98, -93, -92, -92, -89, -92, -93, -91, -91, -95, -97, -97, -98, -95, -98, -98, -45, -98, -92, -98, -95, -93, -93, -98, -94, -98, -49, -97, -95, -98, -91, -94, -97, -92, -45, -92, -94, -91, -96, -92, -44, -92, -89, -92, -94, -95, -97, -97, -98, -95, -98, -98, -45, -98, -92, -98, -95, -93, -93, -98, -94, -98, -48, -97, -95, -98, -91, -94, -97, -92, -45, -92, -94, -91, -96, -92, -44, -92, -89, -92, -94, -95, -97, -97, -98, -95, -98, -98, -45, -98, -92, -98, -95, -93, -93, -98, -94, -98, -95, -97, -95, -98, -91, -94, -97, -92, -45, -92, -94, -91, -96, -92, -44, -92, -89, -92, -94, -95, -97, -96, -96, -95, -98, -96, -98, -98, -92, -98, -89, -96, -49, -90, -92, -94, -90, -90, -92, -44, -91, -98, -46, -98, -97, -98, -89, -98, -97, -97, -92, -97, -95, -92, -97, -92, -45, -92, -94, -91, -96, -92, -44, -92, -89, -92, -94, -94, -98, -92, -97, -92, -45, -92, -94, -91, -96, -92, -44, -92, -89, -92, -94, 
        -96, -45, -92, -95, -92, -44, -92, -46, -90, -96, -98, -89, -98, -98, -46, -93, -90, -93, -48, -90, -92, -47, -91, -46, -46, -95, -94, -45, -44, -93, -95, -98, -98, -47, -98, -92, -98, -95, -93, -93, -97, -46, -97, -95, -98, -94, -98, -93, -95, -98, -98, -95, -98, -97, -98, -97, -44, -44, -95, -98, -98, -46, -98, -92, -98, -89, -96, -49, -90, -92, -94, -90, -90, -92, -44, -91, -98, -46, -98, -97, -98, -97, -98, -94, -98, -93, -98, -98, -98, -95, -90, -96, -98, -97, -98, -97, -98, -98, -97, -89, -46, -95, -98, -47, -44, -97, -98, -93, -44, -48, -91, -90, -89, -96, -95, -44, -94, -47, -98, -46, -91, -46, -46, -96, -96, -95, -96, -95, -95, -46, -94, -98, -89, -92, -91, -49, -47, -44, -47, -45, -98, -98, -98, -90, -97, -46, -93, -48, -46, -91, -47, -92, -45, -89, -46, -92, -45, -46, -96, -98, -92, -48, -98, -45, -97, -97, -96, -98, -89, -93, -98, -92, -94, -97, -92, -47, -49, -96, -94, -94, -89, -95, -89, -89, -97, -95, -46, -96, -92, -48, -94, -49, -49, -98, -45, -98, -44, -93, -96, -94, -47, -49, -46, -96, -48, -48, -93, -47, -92, -45, -94, -47, -49, -97, -98, -97, -92, -49, -97, -93, -89, -97, -92, -45, -49, -97, -45, -47, -93, -46, -47, -89, -93, -49, -93, -45, -95, -49, -98, -97, -98, -98, -95, -92, -44, -94, -89, -96, -94, -90, -46, -93, -97, -98, -89, -48, -48, -44, -96, -45, -97, -45, -92, -97, -90, -97, -90, -92, -92, -91, -95, -49, -95, -48, -45, -93, -92, -46, -49, -44, -98, -48, -91, -91, -48, -97, -47, -96, -96, -89, -45, -95, -47, -96, -93, -93, -45, -95, -45, -90, -94, -47, -89, -98, -93, -46, -96, -95, -90, -91, -45, -44, -48, -49, -98, -89, -47, -48, -44, -97, -95, -48, -96, -98, -96, -48, -94, -45, -93, -49, -96, -96, -47, -89, -95, -96, -92, -95, -94, -90, -94, -49, -96, -95, -46, -96, -44, -47, -96, -89, -44, -49, -89, -44, -97, -89, -95, -89, -91, -93, -89, -91, -95, -95, -49, -44, -46, -90, -49, -49, -97, -92, -98, -44, -94, -96, -89, -92, -47, -96, -46, -98, -97, -92, -95, -45, -90, -97, -90, -96, -90, -93, -89, -47, -92, -92, -94, -95, -45, -89, -47, -97, -89, -92, -96, -44, -49, -98, -47, -97, -90, -95, -95, -95, -95, -95, -93, -48, -47, -98, -89, -98, -44, -44, -89, -49, -92, -48, -96, -96, -46, -45, -46, -97, -49, -46, -94, -94, -94, -96, -96, -89, -49, -93, -95, -89, -49, -89, -94, -45, -45, -44, -49, -46, -49, -48, -46, -98, -92, -93, -47, -45, -46, -96, -94, -48, -95, -45, -93, -97, -45, -93, -46, -46, -91, -48, -92, -92, -91, -90, -91, -48, -45, -44, -97, -96, -44, -45, -89, -91, -44, -48, -49, -94, -90, -94, -47, -94, -96, -95, -44, -48, -94, -44, -44, -90, -47, -47, -94, -89, -94, -47, -98, -96, -44, -98, -44, -93, -98, -93, -97, -92, -97, -96, -44, -44, -92, -93, -96, -89, -95, -89, -95, -45, -90, -45, -94, -92, -45, -49, -47, -93, -48, -48, -96, -97, -44, -96, -91, -91, -47, -97, -93, -97, -49, -49, -93, -44, -96, -49, -49, -92, -96, -91, -46, -97, -45, -90, -89, -46, -49, -91, -98, -49, -48, -92, -98, -95, -95, -93, -92, -89, -46, -45, -95, -48, -89, -90, -89, -91, -48, -44, -44, -44, -91, -47, -49, -89, -46, -49, -95, -45, -97, -96, -94, -95, -44, -92, -98, -48, -92, -57, -54, -61, 126, -52, -51, -46, 126, -60, -51, -45, -52, -62, 126, -51, -48, 126, -52, -51, -46, 126, -65, -63, -63, -61, -47, -47, -57, -64, -54, -61, -116, 117, 123, 76, -111, -92, -113, -111, -100, -96, -107, -101, -102, 90, -91, -100, -115, -48, -15, -94, -11, -9, -27, -22, -94, -29, -18, -23, -15, -12, -21, -10, -22, -17, -80, -117, -112, -121, 124, -106, -114, Byte.MAX_VALUE, -122, -125, 124, -106, -124, 123, 108, -90, 124, -125, 126, -121, -34, -21, -31, -17, -20, -26, -31, -85, -32, -20, -21, -15, -30, -21, -15, -85, -19, -22, -85, -64, -27, -30, -32, -24, -16, -14, -22, -94, -81, -91, -77, -80, -86, -91, 111, -92, -80, -81, -75, -90, -81, -75, 111, -79, -82, 111, -111, -94, -92, -84, -94, -88, -90, -114, -94, -81, -94, -88, -90, -77, 101, -112, -81, -124, -87, -90, -92, -84, -76, -74, -82, -76, -109, -90, -94, -91, -70, -115, -86, -76, -75, -90, -81, -90, -77, Byte.MAX_VALUE, -113, 60, -119, -111, -113, -112, 60, -124, 125, -110, -127, 60, 125, -118, 60, -127, -110, -127, -118, 60, -120, -127, -118, -125, -112, -124, -113, -115, -106, -115, -102, -111, -117, 121, 108, 120, 124, 108, 122, 123, 74, 111, 108, 106, 114, 122, 124, 116, 122};
    }

    static {
        A06();
    }

    @Nullable
    @SuppressLint({"CatchGeneralException"})
    public static String A01(C8J c8j) {
        try {
            Class<?> cls = Class.forName(A00(4696, 27, 120));
            LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
            int intValue = ((Integer) cls.getField(A00(4677, 14, 50)).get(null)).intValue();
            CertificateFactory certificateFactory = CertificateFactory.getInstance(A00(4691, 5, 73));
            ArrayList arrayList = new ArrayList();
            arrayList.add(certificateFactory.generateCertificate(new ByteArrayInputStream(A07(A00(28, 2190, 80)))));
            arrayList.add(certificateFactory.generateCertificate(new ByteArrayInputStream(A07(A00(2218, 2392, 105)))));
            Class<?> cls2 = Class.forName(A00(4723, 58, 60));
            try {
                Object newProxyInstance = Proxy.newProxyInstance(C0987Lb.class.getClassLoader(), new Class[]{cls2}, new C0986La(intValue, linkedBlockingQueue, c8j));
                Method method = PackageManager.class.getMethod(A00(4815, 16, 2), String.class, Boolean.TYPE, Integer.TYPE, List.class, cls2);
                Object listener = c8j.getPackageManager();
                method.invoke(listener, c8j.getPackageName(), false, Integer.valueOf(intValue), arrayList, newProxyInstance);
                byte[] bArr = (byte[]) linkedBlockingQueue.poll(3L, TimeUnit.SECONDS);
                if (bArr != null) {
                    return A05(bArr);
                }
            } catch (Throwable th) {
                th = th;
                c8j.A06().A8q(A00(4808, 7, 35), C06808m.A15, new C06818n(th));
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        return null;
    }

    @Nullable
    public static String A02(File file) throws Exception {
        FileInputStream fileInputStream;
        int numRead;
        try {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance(A00(4656, 3, 83));
                    byte[] buffer = new byte[1024];
                    do {
                        numRead = fileInputStream.read(buffer);
                        if (numRead > 0) {
                            messageDigest.update(buffer, 0, numRead);
                        }
                    } while (numRead != -1);
                    return A05(messageDigest.digest());
                } catch (IOException unused) {
                    throw new Exception(A00(4643, 13, 39));
                } catch (NoSuchAlgorithmException unused2) {
                    throw new Exception(A00(4659, 18, 125));
                }
            } catch (FileNotFoundException unused3) {
                throw new Exception(A00(4610, 33, 89));
            }
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException unused4) {
            }
        }
    }

    @Nullable
    public static String A03(String str) throws Exception {
        return A02(new File(str));
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0043, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0046 A[LOOP:1: B:5:0x0010->B:14:0x0046, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String A04(byte[] r10) {
        /*
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            int r5 = r10.length
            r4 = 0
        L7:
            if (r4 >= r5) goto L54
            r9 = r10[r4]
            int r0 = r9 >>> 4
            r7 = r0 & 15
            r3 = 0
        L10:
            if (r7 < 0) goto L48
            r8 = 9
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C0987Lb.A01
            r0 = 2
            r1 = r2[r0]
            r0 = 3
            r2 = r2[r0]
            r0 = 24
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L4e
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C0987Lb.A01
            java.lang.String r1 = "WYC0eM9KSy1kpGQhaCsWuh8F6Di5rl0B"
            r0 = 2
            r2[r0] = r1
            java.lang.String r1 = "cvJ0Eg1FAjPz1pwRpU9xefwXrHpQMXjt"
            r0 = 3
            r2[r0] = r1
            if (r7 > r8) goto L48
            int r0 = r7 + 48
            char r0 = (char) r0
        L39:
            r6.append(r0)
            r7 = r9 & 15
            int r1 = r3 + 1
            r0 = 1
            if (r3 < r0) goto L46
            int r4 = r4 + 1
            goto L7
        L46:
            r3 = r1
            goto L10
        L48:
            int r0 = r7 + (-10)
            int r0 = r0 + 97
            char r0 = (char) r0
            goto L39
        L4e:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L54:
            java.lang.String r0 = r6.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0987Lb.A04(byte[]):java.lang.String");
    }

    public static String A05(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            sb.append(Integer.toString((b & Draft_75.END_OF_FRAME) + 256, 16).substring(1));
        }
        return sb.toString();
    }

    public static byte[] A07(CharSequence charSequence) {
        int length = charSequence.length();
        if ((length & 1) == 0) {
            byte[] bArr = new byte[length >> 1];
            for (int i2 = 0; i2 < length; i2 += 2) {
                int digit = Character.digit(charSequence.charAt(i2), 16);
                int hi = i2 + 1;
                int digit2 = Character.digit(charSequence.charAt(hi), 16);
                int hi2 = digit | digit2;
                if (hi2 < 0) {
                    throw new IllegalArgumentException(((Object) charSequence) + A00(0, 28, 106));
                }
                int hi3 = digit << 4;
                bArr[i2 >> 1] = (byte) (hi3 | digit2);
            }
            return bArr;
        }
        throw new IllegalArgumentException(A00(4781, 27, 23));
    }
}
