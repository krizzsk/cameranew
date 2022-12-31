package com.ironsource.mediationsdk.metadata;
/* compiled from: MetaDataUtils.java */
/* loaded from: classes2.dex */
public class a {
    public static String a(String str, MetaData$MetaDataValueTypes metaData$MetaDataValueTypes) {
        return metaData$MetaDataValueTypes == MetaData$MetaDataValueTypes.META_DATA_VALUE_BOOLEAN ? (str.equalsIgnoreCase("true") || str.equalsIgnoreCase("yes")) ? "true" : (str.equalsIgnoreCase("false") || str.equalsIgnoreCase("no")) ? "false" : "" : str;
    }

    public static boolean b(String str) {
        return !str.equals("false");
    }

    public static boolean c(String str, String str2) {
        return str.equals("do_not_sell") && str2.length() > 0;
    }
}
