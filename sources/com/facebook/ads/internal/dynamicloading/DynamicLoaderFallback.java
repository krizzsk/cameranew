package com.facebook.ads.internal.dynamicloading;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.RewardedVideoAd;
import com.facebook.ads.internal.api.AdViewApi;
import com.facebook.ads.internal.api.AdViewParentApi;
import com.facebook.ads.internal.api.InterstitialAdApi;
import com.facebook.ads.internal.api.NativeAdBaseApi;
import com.facebook.ads.internal.api.RewardedVideoAdApi;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
@Keep
/* loaded from: classes.dex */
public class DynamicLoaderFallback {
    private static final WeakHashMap<Object, AdListener> sApiProxyToAdListenersMap = new WeakHashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class SimpleMethodCaptor {
        private final InvocationHandler mInvocationHandler;
        @Nullable
        private Method mLastInvokedMethod;

        private SimpleMethodCaptor() {
            this.mInvocationHandler = new InvocationHandler() { // from class: com.facebook.ads.internal.dynamicloading.DynamicLoaderFallback.SimpleMethodCaptor.1
                @Override // java.lang.reflect.InvocationHandler
                @Nullable
                public Object invoke(Object obj, Method method, Object[] objArr) {
                    if ("toString".equals(method.getName())) {
                        return null;
                    }
                    SimpleMethodCaptor.this.mLastInvokedMethod = method;
                    return null;
                }
            };
        }

        @Nullable
        Method getLastMethod() {
            return this.mLastInvokedMethod;
        }

        public <T> T mock(Class<T> cls) {
            return cls.cast(Proxy.newProxyInstance(DynamicLoaderFallback.class.getClassLoader(), new Class[]{cls}, this.mInvocationHandler));
        }
    }

    DynamicLoaderFallback() {
    }

    private static boolean equalsMethodParams(Method method, Method method2) {
        return Arrays.equals(method.getParameterTypes(), method2.getParameterTypes());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean equalsMethods(Method method, Method method2) {
        return method != null && method2 != null && method.getDeclaringClass().equals(method2.getDeclaringClass()) && method.getName().equals(method2.getName()) && equalsMethodParams(method, method2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"Parameter Not Nullable", "CatchGeneralException"})
    public static DynamicLoader makeFallbackLoader() {
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        final ArrayList arrayList3 = new ArrayList();
        final ArrayList arrayList4 = new ArrayList();
        final ArrayList arrayList5 = new ArrayList();
        final HashMap hashMap = new HashMap();
        final HashMap hashMap2 = new HashMap();
        SimpleMethodCaptor simpleMethodCaptor = new SimpleMethodCaptor();
        DynamicLoader dynamicLoader = (DynamicLoader) simpleMethodCaptor.mock(DynamicLoader.class);
        dynamicLoader.createInterstitialAd(null, null, null);
        arrayList5.add(simpleMethodCaptor.getLastMethod());
        dynamicLoader.createRewardedVideoAd(null, null, null);
        arrayList5.add(simpleMethodCaptor.getLastMethod());
        dynamicLoader.createAdViewApi((Context) null, (String) null, (AdSize) null, (AdViewParentApi) null, (AdView) null);
        arrayList5.add(simpleMethodCaptor.getLastMethod());
        try {
            dynamicLoader.createAdViewApi((Context) null, (String) null, (String) null, (AdViewParentApi) null, (AdView) null);
        } catch (Exception unused) {
        }
        arrayList5.add(simpleMethodCaptor.getLastMethod());
        dynamicLoader.createNativeAdApi(null, null);
        final Method lastMethod = simpleMethodCaptor.getLastMethod();
        dynamicLoader.createNativeBannerAdApi(null, null);
        final Method lastMethod2 = simpleMethodCaptor.getLastMethod();
        NativeAdBaseApi nativeAdBaseApi = (NativeAdBaseApi) simpleMethodCaptor.mock(NativeAdBaseApi.class);
        nativeAdBaseApi.loadAd();
        arrayList.add(simpleMethodCaptor.getLastMethod());
        nativeAdBaseApi.loadAd(null);
        arrayList2.add(simpleMethodCaptor.getLastMethod());
        nativeAdBaseApi.buildLoadAdConfig(null);
        arrayList4.add(simpleMethodCaptor.getLastMethod());
        InterstitialAdApi interstitialAdApi = (InterstitialAdApi) simpleMethodCaptor.mock(InterstitialAdApi.class);
        interstitialAdApi.loadAd();
        arrayList.add(simpleMethodCaptor.getLastMethod());
        interstitialAdApi.loadAd(null);
        arrayList2.add(simpleMethodCaptor.getLastMethod());
        interstitialAdApi.buildLoadAdConfig();
        arrayList4.add(simpleMethodCaptor.getLastMethod());
        RewardedVideoAdApi rewardedVideoAdApi = (RewardedVideoAdApi) simpleMethodCaptor.mock(RewardedVideoAdApi.class);
        rewardedVideoAdApi.loadAd();
        arrayList.add(simpleMethodCaptor.getLastMethod());
        rewardedVideoAdApi.loadAd(null);
        arrayList2.add(simpleMethodCaptor.getLastMethod());
        rewardedVideoAdApi.buildLoadAdConfig();
        arrayList4.add(simpleMethodCaptor.getLastMethod());
        AdViewApi adViewApi = (AdViewApi) simpleMethodCaptor.mock(AdViewApi.class);
        adViewApi.loadAd();
        arrayList.add(simpleMethodCaptor.getLastMethod());
        adViewApi.loadAd(null);
        arrayList2.add(simpleMethodCaptor.getLastMethod());
        adViewApi.buildLoadAdConfig();
        arrayList4.add(simpleMethodCaptor.getLastMethod());
        ((AdView.AdViewLoadConfigBuilder) simpleMethodCaptor.mock(AdView.AdViewLoadConfigBuilder.class)).withAdListener(null);
        arrayList3.add(simpleMethodCaptor.getLastMethod());
        ((NativeAdBase.NativeAdLoadConfigBuilder) simpleMethodCaptor.mock(NativeAdBase.NativeAdLoadConfigBuilder.class)).withAdListener(null);
        arrayList3.add(simpleMethodCaptor.getLastMethod());
        ((InterstitialAd.InterstitialAdLoadConfigBuilder) simpleMethodCaptor.mock(InterstitialAd.InterstitialAdLoadConfigBuilder.class)).withAdListener(null);
        arrayList3.add(simpleMethodCaptor.getLastMethod());
        ((RewardedVideoAd.RewardedVideoAdLoadConfigBuilder) simpleMethodCaptor.mock(RewardedVideoAd.RewardedVideoAdLoadConfigBuilder.class)).withAdListener(null);
        arrayList3.add(simpleMethodCaptor.getLastMethod());
        return (DynamicLoader) Proxy.newProxyInstance(DynamicLoaderFallback.class.getClassLoader(), new Class[]{DynamicLoader.class}, new InvocationHandler() { // from class: com.facebook.ads.internal.dynamicloading.DynamicLoaderFallback.1
            @Override // java.lang.reflect.InvocationHandler
            @Nullable
            public Object invoke(Object obj, Method method, Object[] objArr) {
                if (method.getReturnType().isPrimitive()) {
                    if (method.getReturnType().equals(Void.TYPE)) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext() && (!DynamicLoaderFallback.equalsMethods(method, (Method) it.next()) || !DynamicLoaderFallback.reportError(obj, hashMap))) {
                        }
                        for (Method method2 : arrayList2) {
                            if (DynamicLoaderFallback.equalsMethods(method, method2) && DynamicLoaderFallback.reportError(obj, hashMap)) {
                                return null;
                            }
                        }
                        return null;
                    }
                    return Array.get(Array.newInstance(method.getReturnType(), 1), 0);
                } else if (method.getReturnType().equals(String.class)) {
                    return "";
                } else {
                    Object newProxyInstance = method.getReturnType().equals(obj.getClass().getInterfaces()[0]) ? obj : Proxy.newProxyInstance(DynamicLoaderFallback.class.getClassLoader(), new Class[]{method.getReturnType()}, this);
                    Iterator it2 = arrayList3.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (DynamicLoaderFallback.equalsMethods(method, (Method) it2.next())) {
                                DynamicLoaderFallback.sApiProxyToAdListenersMap.put(hashMap2.get(obj), (AdListener) objArr[0]);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    for (Method method3 : arrayList4) {
                        if (DynamicLoaderFallback.equalsMethods(method, method3)) {
                            hashMap2.put(newProxyInstance, obj);
                        }
                    }
                    for (Method method4 : arrayList5) {
                        if (DynamicLoaderFallback.equalsMethods(method, method4)) {
                            for (Object obj2 : objArr) {
                                if (obj2 instanceof Ad) {
                                    hashMap.put(newProxyInstance, (Ad) obj2);
                                }
                            }
                        }
                    }
                    if (DynamicLoaderFallback.equalsMethods(method, lastMethod)) {
                        hashMap.put(objArr[1], (Ad) objArr[0]);
                    }
                    if (DynamicLoaderFallback.equalsMethods(method, lastMethod2)) {
                        hashMap.put(objArr[1], (Ad) objArr[0]);
                    }
                    return newProxyInstance;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean reportError(@Nullable Object obj, Map<Object, Ad> map) {
        if (obj == null) {
            return false;
        }
        final AdListener adListener = sApiProxyToAdListenersMap.get(obj);
        final Ad ad = map.get(obj);
        if (adListener != null) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.facebook.ads.internal.dynamicloading.DynamicLoaderFallback.2
                @Override // java.lang.Runnable
                public void run() {
                    AdListener.this.onError(ad, new AdError(-1, "Can't load Audience Network Dex. Please, check that audience_network.dex is inside of assets folder."));
                }
            }, 500L);
            return true;
        }
        return false;
    }
}
