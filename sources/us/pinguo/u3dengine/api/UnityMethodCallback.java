package us.pinguo.u3dengine.api;

import us.pinguo.common.log.a;
/* loaded from: classes6.dex */
public class UnityMethodCallback {
    private static UnityCallbackApi mImpl;

    public UnityMethodCallback() {
        a.c("UnityMethodCallback constructor", new Object[0]);
    }

    public static boolean ChangeFilter(String str) {
        a.q("ChangeFilter, " + str, new Object[0]);
        UnityCallbackApi unityCallbackApi = mImpl;
        if (unityCallbackApi != null) {
            return unityCallbackApi.changeFilter(str);
        }
        return false;
    }

    public static boolean ChangeMakeUp(String str) {
        a.q("ChangeMakeUp, " + str, new Object[0]);
        UnityCallbackApi unityCallbackApi = mImpl;
        if (unityCallbackApi != null) {
            return unityCallbackApi.changeMakeUp(str);
        }
        return false;
    }

    public static DefaultBaseConfig GetDefaultConfig() {
        a.q("GetDefaultConfig", new Object[0]);
        UnityCallbackApi unityCallbackApi = mImpl;
        if (unityCallbackApi != null) {
            return unityCallbackApi.getDefaultConfig();
        }
        return new DefaultBaseConfig();
    }

    public static FilterInfo GetFilterInfo() {
        a.q("GetFilterInfo", new Object[0]);
        UnityCallbackApi unityCallbackApi = mImpl;
        if (unityCallbackApi != null) {
            return unityCallbackApi.getFilterInfo();
        }
        return null;
    }

    public static HDCameraSessionResult GetHDCameraSessionResult() {
        a.q("GetHDCameraSessionResult", new Object[0]);
        UnityCallbackApi unityCallbackApi = mImpl;
        if (unityCallbackApi != null) {
            return unityCallbackApi.getCameraSessionResult();
        }
        return null;
    }

    public static HDCameraSessionResult GetHDCaptureSessionResult() {
        a.q("GetHDCaptureSessionResult", new Object[0]);
        UnityCallbackApi unityCallbackApi = mImpl;
        if (unityCallbackApi != null) {
            return unityCallbackApi.getCaptureSessionResult();
        }
        return null;
    }

    public static int GetImageSaveQuality() {
        a.q("GetImageSaveQuality", new Object[0]);
        UnityCallbackApi unityCallbackApi = mImpl;
        if (unityCallbackApi != null) {
            return unityCallbackApi.getImageSaveQuality();
        }
        return 98;
    }

    public static NativeFacesData GetNativeFaceData() {
        a.q("GetNativeFaceData", new Object[0]);
        UnityCallbackApi unityCallbackApi = mImpl;
        if (unityCallbackApi != null) {
            return unityCallbackApi.getNativeFaceData();
        }
        return null;
    }

    public static int GetSubsticker() {
        a.q("GetSubsticker", new Object[0]);
        UnityCallbackApi unityCallbackApi = mImpl;
        if (unityCallbackApi != null) {
            return unityCallbackApi.getSubSticker();
        }
        return 0;
    }

    public static void OnAssetBundleStatusChanged(int i2, String str) {
        BundleLoadStatus bundleLoadStatus;
        a.q("OnAssetBundleStatusChanged, statusCode=" + i2 + ", path=" + str, new Object[0]);
        if (mImpl != null) {
            if (i2 == 1) {
                bundleLoadStatus = BundleLoadStatus.FILE_LOAD_SUCCESS;
            } else if (i2 == 2) {
                bundleLoadStatus = BundleLoadStatus.SCRIPT_LOAD_SUCCESS;
            } else if (i2 == 3) {
                bundleLoadStatus = BundleLoadStatus.FILE_LOAD_FAILED;
            } else if (i2 != 4) {
                bundleLoadStatus = BundleLoadStatus.UNKNOWN;
            } else {
                bundleLoadStatus = BundleLoadStatus.SCRIPT_LOAD_FAILED;
            }
            mImpl.onBundleLoadStatusChanged(bundleLoadStatus, str);
        }
    }

    public static void OnCaptureEnd(HDCameraSessionResult hDCameraSessionResult) {
        a.q("OnCaptureEnd", new Object[0]);
        UnityCallbackApi unityCallbackApi = mImpl;
        if (unityCallbackApi != null) {
            unityCallbackApi.onCaptureEnd(hDCameraSessionResult);
        }
    }

    public static void OnCaptureStart() {
        a.q("OnCaptureStart", new Object[0]);
        UnityCallbackApi unityCallbackApi = mImpl;
        if (unityCallbackApi != null) {
            unityCallbackApi.onCaptureStart();
        }
    }

    public static void OnImageSaved(String str, int i2) {
        CaptureModel captureModel;
        if (mImpl != null) {
            if (i2 == 1) {
                captureModel = CaptureModel.SCREEN_IMAGE;
            } else {
                captureModel = CaptureModel.HD_IMAGE;
            }
            mImpl.onImageSaved(str, captureModel);
        }
    }

    public static void OnRenderImageEnd(int i2) {
        CaptureModel captureModel;
        a.q("OnRenderImageEnd:" + i2, new Object[0]);
        if (mImpl != null) {
            if (i2 == 1) {
                captureModel = CaptureModel.SCREEN_IMAGE;
            } else {
                captureModel = CaptureModel.HD_IMAGE;
            }
            mImpl.onRenderImageEnd(captureModel);
        }
    }

    public static void OnRenderWithWatermarkEnd(HDCameraSessionResult hDCameraSessionResult) {
        a.q("OnRenderWithWatermarkEnd, output=" + hDCameraSessionResult.getOutPutTextureID(), new Object[0]);
    }

    public static void OnRenderWithoutFilterEnd(HDCameraSessionResult hDCameraSessionResult) {
        a.q("OnRenderWithoutFilterEnd, output=" + hDCameraSessionResult.getOutPutTextureID(), new Object[0]);
    }

    public static void OnSubstickerSelect(int i2) {
        a.q("OnSubstickerSelect, subIndex=" + i2, new Object[0]);
        UnityCallbackApi unityCallbackApi = mImpl;
        if (unityCallbackApi != null) {
            unityCallbackApi.onSubStickerSelect(i2);
        }
    }

    public static void OnUnityRenderEnd() {
        UnityCallbackApi unityCallbackApi = mImpl;
        if (unityCallbackApi != null) {
            unityCallbackApi.onUnityRenderEnd();
        }
    }

    public static void OnUnityRenderStart() {
        a.q("OnUnityRenderStart", new Object[0]);
        UnityCallbackApi unityCallbackApi = mImpl;
        if (unityCallbackApi != null) {
            unityCallbackApi.onUnityRenderStart();
        }
    }

    public static void OnVideoRecordPrepared(int i2) {
        a.q("OnVideoRecordPrepared, videoTextureId=", new Object[0]);
        UnityCallbackApi unityCallbackApi = mImpl;
        if (unityCallbackApi != null) {
            unityCallbackApi.onVideoRecordPrepared(i2);
        }
    }

    public static void PreGetHDCameraSessionResult() {
        a.q("PreGetHDCameraSessionResult", new Object[0]);
        UnityCallbackApi unityCallbackApi = mImpl;
        if (unityCallbackApi != null) {
            unityCallbackApi.preCameraSessionResult();
        }
    }

    public static void PreGetHDCaptureSessionResult() {
        a.q("PreGetHDCaptureSessionResult", new Object[0]);
        UnityCallbackApi unityCallbackApi = mImpl;
        if (unityCallbackApi != null) {
            unityCallbackApi.preCaptureSessionResult();
        }
    }

    public static void SetCurrentUnityVersion(int i2, String str) {
        a.q("SetCurrentUnityVersion, version=" + i2 + ", versionCode=" + str, new Object[0]);
        UnityCallbackApi unityCallbackApi = mImpl;
        if (unityCallbackApi != null) {
            unityCallbackApi.setCurrentUnityVersion(i2, str);
        }
    }

    public static void registerImpl(UnityCallbackApi unityCallbackApi) {
        mImpl = unityCallbackApi;
    }

    public static void unregister(UnityCallbackApi unityCallbackApi) {
        if (mImpl == unityCallbackApi) {
            a.c("unregister UnityCallbackApi", new Object[0]);
            mImpl = null;
        }
    }
}
