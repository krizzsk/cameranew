package com.pinguo.camera360.effect.model;

import android.content.Context;
import com.pinguo.camera360.effect.model.entity.Effect;
import com.pinguo.camera360.effect.model.entity.EffectBean;
import com.pinguo.camera360.effect.model.entity.EffectType;
import com.pinguo.camera360.effect.model.entity.EffectTypeBean;
import com.pinguo.camera360.effect.model.entity.type.CameraFilter;
import com.pinguo.camera360.effect.model.entity.type.Filter;
import com.pinguo.camera360.effect.model.entity.type.Frame;
import com.pinguo.camera360.effect.model.entity.type.Lighting;
import com.pinguo.lib.GsonUtilKt;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import us.pinguo.blockbuster.lib.domain.Input;
import us.pinguo.common.log.a;
import us.pinguo.foundation.utils.c0;
import us.pinguo.foundation.utils.e;
import us.pinguo.foundation.utils.m0;
import us.pinguo.util.k;
import us.pinguo.util.l;
/* loaded from: classes3.dex */
public class ResourceManagerUtils {
    private static final String TAG = "ResourceManagerUtils";
    private static Map<String, Type> typeMapper = new HashMap();
    private static Map<String, Class> effectClassMapper = new HashMap();

    static {
        initTypeMapper();
        initEffectClassMapper();
    }

    public static boolean copyResource(File file, File file2) {
        a.d(TAG, "Copy shader and texture to installed dir", new Object[0]);
        StringBuilder sb = new StringBuilder();
        sb.append(file2.getAbsolutePath());
        String str = File.separator;
        sb.append(str);
        sb.append(Input.INPUT_TYPE_TEXTURE);
        sb.append(str);
        String sb2 = sb.toString();
        String str2 = file.getAbsolutePath() + str + Input.INPUT_TYPE_TEXTURE + str;
        if (new File(sb2).exists() && !l.b(sb2, str2)) {
            a.e("Copy texture fail", new Object[0]);
            return false;
        }
        String str3 = file2.getAbsolutePath() + str + "icon" + str;
        String str4 = file.getAbsolutePath() + str + "icon" + str;
        if (!new File(str3).exists() || l.b(str3, str4)) {
            return true;
        }
        a.e("Copy icon fail", new Object[0]);
        return false;
    }

    public static boolean download(Context context, String str, String str2, boolean z) {
        File cacheDir;
        if (z) {
            cacheDir = c0.b(context, "download");
        } else {
            cacheDir = context.getCacheDir();
        }
        File file = new File(cacheDir.getPath() + File.separator + str2);
        String str3 = TAG;
        a.d(str3, "Download zip: " + str, new Object[0]);
        String[] split = str.split("://");
        if (split.length < 1) {
            a.g(str3, "Param error, url:" + str, new Object[0]);
            return false;
        }
        String str4 = split[0];
        a.d(str3, "Download file from " + str + " to " + file.getAbsolutePath(), new Object[0]);
        if (file.exists()) {
            long currentTimeMillis = System.currentTimeMillis() - file.lastModified();
            if (currentTimeMillis > 0 && currentTimeMillis < 2000) {
                a.d(str3, file.getAbsolutePath() + " exist for " + currentTimeMillis + " ms, reuse it", new Object[0]);
                return true;
            }
            l.i(file);
            a.d(str3, file.getAbsolutePath() + " exist, delete first", new Object[0]);
        }
        try {
            if (str4.equals("assets")) {
                e.a(context, split[1], file);
            } else if (str4.equals("http")) {
                com.pinguo.camera360.h.a.a(str, file, cacheDir);
            }
            return true;
        } catch (Exception e2) {
            a.f(e2);
            return false;
        }
    }

    public static Effect getEffectSubObjectByTypeKey(String str, EffectBean effectBean) {
        Class cls = effectClassMapper.get(str);
        if (cls != null) {
            try {
                return (Effect) cls.getConstructor(EffectBean.class).newInstance(effectBean);
            } catch (IllegalAccessException e2) {
                a.g(TAG, "New effect object according to class failed!", new Object[0]);
                e2.printStackTrace();
            } catch (InstantiationException e3) {
                a.g(TAG, "New effect object according to class failed!", new Object[0]);
                e3.printStackTrace();
            } catch (NoSuchMethodException e4) {
                a.g(TAG, "New effect object according to class failed!", new Object[0]);
                e4.printStackTrace();
            } catch (InvocationTargetException e5) {
                a.g(TAG, "New effect object according to class failed!", new Object[0]);
                e5.printStackTrace();
            }
        }
        return null;
    }

    public static Type getEffectSubTypeByTypeKey(String str) {
        return typeMapper.get(str);
    }

    public static String getIconPathByType(File file) {
        StringBuilder sb = new StringBuilder();
        sb.append(file.getAbsolutePath());
        String str = File.separator;
        sb.append(str);
        sb.append("icon");
        sb.append(str);
        return new File(sb.toString()).getAbsolutePath();
    }

    public static String getZipFileName(String str) {
        if (str != null && !str.isEmpty()) {
            String[] split = str.split("/");
            if (split.length < 1) {
                String str2 = TAG;
                a.g(str2, "Install unzip fail! Bad download url: " + str, new Object[0]);
                return "";
            }
            String str3 = split[split.length - 1];
            String[] split2 = str3.split("\\?");
            if (split2.length > 0) {
                str3 = split2[0];
            }
            return !str3.toLowerCase(Locale.ENGLISH).endsWith(".zip") ? "" : str3;
        }
        String str4 = TAG;
        a.g(str4, "Bad url: " + str, new Object[0]);
        return "";
    }

    private static void initEffectClassMapper() {
        String name = CameraFilter.class.getPackage().getName();
        try {
            for (Effect.Type type : Effect.Type.values()) {
                String name2 = type.name();
                effectClassMapper.put(name2, Class.forName(name + "." + name2));
            }
        } catch (ClassNotFoundException e2) {
            a.g(TAG, "Init effect class mapper failed!", new Object[0]);
            a.f(e2);
        }
    }

    private static void initTypeMapper() {
        typeMapper.put(Effect.Type.Filter.name(), new com.google.gson.t.a<Filter>() { // from class: com.pinguo.camera360.effect.model.ResourceManagerUtils.1
        }.getType());
        typeMapper.put(Effect.Type.CameraFilter.name(), new com.google.gson.t.a<Filter>() { // from class: com.pinguo.camera360.effect.model.ResourceManagerUtils.2
        }.getType());
        typeMapper.put(Effect.Type.Lighting.name(), new com.google.gson.t.a<Lighting>() { // from class: com.pinguo.camera360.effect.model.ResourceManagerUtils.3
        }.getType());
        typeMapper.put(Effect.Type.Frame.name(), new com.google.gson.t.a<Frame>() { // from class: com.pinguo.camera360.effect.model.ResourceManagerUtils.4
        }.getType());
    }

    public static boolean isSDCardAvalable(Context context) {
        return c0.b(context, "download") != null;
    }

    private static EffectBean parseEffect(File file, String str, String str2, int i2) throws Exception {
        String str3 = TAG;
        a.d(str3, "Parse effect json: " + file.getAbsolutePath(), new Object[0]);
        try {
            EffectBean effectBean = (EffectBean) GsonUtilKt.getCachedGson().k(k.d(file), new com.google.gson.t.a<EffectBean>() { // from class: com.pinguo.camera360.effect.model.ResourceManagerUtils.6
            }.getType());
            effectBean.packKey = str2;
            effectBean.idxInPack = i2;
            return effectBean;
        } catch (RuntimeException e2) {
            a.g(TAG, "Parse effect json fail!", new Object[0]);
            a.f(e2);
            throw e2;
        }
    }

    private static EffectType parseEffectMeta(EffectTypeBean effectTypeBean, String str, File file) throws Exception {
        return new EffectType(effectTypeBean);
    }

    private static EffectTypeBean parseEffectType(File file) throws Exception {
        String str = TAG;
        a.d(str, "Parse effect type json: " + file.getAbsolutePath(), new Object[0]);
        try {
            EffectTypeBean effectTypeBean = (EffectTypeBean) GsonUtilKt.getCachedGson().k(k.d(file), new com.google.gson.t.a<EffectTypeBean>() { // from class: com.pinguo.camera360.effect.model.ResourceManagerUtils.5
            }.getType());
            try {
                new EffectType(effectTypeBean).getName();
                return effectTypeBean;
            } catch (Exception unused) {
                throw new Exception("Check effect package fail!");
            }
        } catch (Exception e2) {
            a.g(TAG, "Parse effect type json fail!", new Object[0]);
            a.f(e2);
            throw e2;
        }
    }

    public static EffectType parseMetaJson(String str, File file) throws Exception {
        return parseEffectMeta(parseEffectType(file), str, file);
    }

    public static File unzip(Context context, String str, boolean z) {
        File cacheDir;
        File cacheDir2;
        if (z) {
            cacheDir = c0.b(context, "download");
            cacheDir2 = c0.b(context, "unzipped");
        } else {
            cacheDir = context.getCacheDir();
            cacheDir2 = context.getCacheDir();
        }
        String[] split = str.split("\\.");
        if (split.length < 1) {
            String str2 = TAG;
            a.g(str2, "Unzip fail, bad effect pack file name: " + str, new Object[0]);
            return null;
        }
        String str3 = split[0];
        StringBuilder sb = new StringBuilder();
        sb.append(cacheDir2.getAbsolutePath());
        String str4 = File.separator;
        sb.append(str4);
        sb.append(str3);
        sb.append(str4);
        File file = new File(sb.toString());
        if (file.exists() && file.isDirectory()) {
            l.i(file);
            String str5 = TAG;
            a.d(str5, "Target dir: " + file.getAbsolutePath() + " exists, delete it before unzipping", new Object[0]);
        }
        try {
            String absolutePath = new File(cacheDir.getPath() + str4 + str).getAbsolutePath();
            m0.c(absolutePath, cacheDir2.getAbsolutePath() + str4);
            return file;
        } catch (IOException unused) {
            return null;
        }
    }
}
