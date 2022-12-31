package com.mob.tools.utils;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class BHelper {
    private static final String TAG = "BHelper";
    private static BHelper instance;
    private Context context;

    /* loaded from: classes3.dex */
    public static class BOperationCallback {
        protected void onConnectionChanged(boolean z, HashMap<String, Object> hashMap) {
        }

        protected void onDeviceConnected(HashMap<String, Object> hashMap) {
        }

        protected void onDeviceDisconnected(HashMap<String, Object> hashMap) {
        }

        protected void onDisabled() {
        }

        protected void onEnabled() {
        }
    }

    /* loaded from: classes3.dex */
    public interface BScanCallback {
        void onScan(ArrayList<HashMap<String, Object>> arrayList);
    }

    private BHelper(Context context) {
        this.context = context.getApplicationContext();
    }

    public static BHelper getInstance(Context context) {
        if (instance == null) {
            synchronized (BHelper.class) {
                if (instance == null) {
                    instance = new BHelper(context);
                }
            }
        }
        return instance;
    }

    @SuppressLint({"MissingPermission"})
    public void findLE(int i2, BluetoothAdapter bluetoothAdapter, BScanCallback bScanCallback) {
        if (bScanCallback != null) {
            bScanCallback.onScan(new ArrayList<>());
        }
    }

    @SuppressLint({"MissingPermission"})
    public void findLEAndClassic(int i2, BScanCallback bScanCallback) {
        if (bScanCallback != null) {
            bScanCallback.onScan(new ArrayList<>());
        }
    }

    @SuppressLint({"MissingPermission"})
    public ArrayList<HashMap<String, Object>> getBondedDevice() {
        return new ArrayList<>();
    }

    public boolean isConnectedDevice(BluetoothDevice bluetoothDevice) {
        return false;
    }

    @SuppressLint({"MissingPermission"})
    public boolean isEnabled() {
        return false;
    }

    @SuppressLint({"MissingPermission"})
    public void open() {
    }

    public void registerBOperationReceiver(String str, BOperationCallback bOperationCallback) {
    }

    public void unRegisterBOperationReceiver(String str) {
    }

    public void unRegisterBScanReceiver() {
    }
}
