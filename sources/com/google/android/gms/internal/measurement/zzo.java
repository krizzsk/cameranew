package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes2.dex */
public abstract class zzo extends zzb implements zzp {
    public zzo() {
        super("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    public static zzp asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
        if (queryLocalInterface instanceof zzp) {
            return (zzp) queryLocalInterface;
        }
        return new zzn(iBinder);
    }

    @Override // com.google.android.gms.internal.measurement.zzb
    protected final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        zzs zzqVar;
        zzs zzsVar;
        zzs zzsVar2 = null;
        zzs zzsVar3 = null;
        zzs zzsVar4 = null;
        zzv zzvVar = null;
        zzv zzvVar2 = null;
        zzv zzvVar3 = null;
        zzs zzsVar5 = null;
        zzs zzsVar6 = null;
        zzs zzsVar7 = null;
        zzs zzsVar8 = null;
        zzs zzsVar9 = null;
        zzs zzsVar10 = null;
        zzx zzxVar = null;
        zzs zzsVar11 = null;
        zzs zzsVar12 = null;
        zzs zzsVar13 = null;
        zzs zzsVar14 = null;
        switch (i2) {
            case 1:
                initialize(b.a.x0(parcel.readStrongBinder()), (zzy) zzc.zzc(parcel, zzy.CREATOR), parcel.readLong());
                break;
            case 2:
                logEvent(parcel.readString(), parcel.readString(), (Bundle) zzc.zzc(parcel, Bundle.CREATOR), zzc.zza(parcel), zzc.zza(parcel), parcel.readLong());
                break;
            case 3:
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                Bundle bundle = (Bundle) zzc.zzc(parcel, Bundle.CREATOR);
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzsVar = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface instanceof zzs) {
                        zzqVar = (zzs) queryLocalInterface;
                    } else {
                        zzqVar = new zzq(readStrongBinder);
                    }
                    zzsVar = zzqVar;
                }
                logEventAndBundle(readString, readString2, bundle, zzsVar, parcel.readLong());
                break;
            case 4:
                setUserProperty(parcel.readString(), parcel.readString(), b.a.x0(parcel.readStrongBinder()), zzc.zza(parcel), parcel.readLong());
                break;
            case 5:
                String readString3 = parcel.readString();
                String readString4 = parcel.readString();
                boolean zza = zzc.zza(parcel);
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface2 instanceof zzs) {
                        zzsVar2 = (zzs) queryLocalInterface2;
                    } else {
                        zzsVar2 = new zzq(readStrongBinder2);
                    }
                }
                getUserProperties(readString3, readString4, zza, zzsVar2);
                break;
            case 6:
                String readString5 = parcel.readString();
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface3 instanceof zzs) {
                        zzsVar14 = (zzs) queryLocalInterface3;
                    } else {
                        zzsVar14 = new zzq(readStrongBinder3);
                    }
                }
                getMaxUserProperties(readString5, zzsVar14);
                break;
            case 7:
                setUserId(parcel.readString(), parcel.readLong());
                break;
            case 8:
                setConditionalUserProperty((Bundle) zzc.zzc(parcel, Bundle.CREATOR), parcel.readLong());
                break;
            case 9:
                clearConditionalUserProperty(parcel.readString(), parcel.readString(), (Bundle) zzc.zzc(parcel, Bundle.CREATOR));
                break;
            case 10:
                String readString6 = parcel.readString();
                String readString7 = parcel.readString();
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 != null) {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface4 instanceof zzs) {
                        zzsVar13 = (zzs) queryLocalInterface4;
                    } else {
                        zzsVar13 = new zzq(readStrongBinder4);
                    }
                }
                getConditionalUserProperties(readString6, readString7, zzsVar13);
                break;
            case 11:
                setMeasurementEnabled(zzc.zza(parcel), parcel.readLong());
                break;
            case 12:
                resetAnalyticsData(parcel.readLong());
                break;
            case 13:
                setMinimumSessionDuration(parcel.readLong());
                break;
            case 14:
                setSessionTimeoutDuration(parcel.readLong());
                break;
            case 15:
                setCurrentScreen(b.a.x0(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readLong());
                break;
            case 16:
                IBinder readStrongBinder5 = parcel.readStrongBinder();
                if (readStrongBinder5 != null) {
                    IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface5 instanceof zzs) {
                        zzsVar12 = (zzs) queryLocalInterface5;
                    } else {
                        zzsVar12 = new zzq(readStrongBinder5);
                    }
                }
                getCurrentScreenName(zzsVar12);
                break;
            case 17:
                IBinder readStrongBinder6 = parcel.readStrongBinder();
                if (readStrongBinder6 != null) {
                    IInterface queryLocalInterface6 = readStrongBinder6.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface6 instanceof zzs) {
                        zzsVar11 = (zzs) queryLocalInterface6;
                    } else {
                        zzsVar11 = new zzq(readStrongBinder6);
                    }
                }
                getCurrentScreenClass(zzsVar11);
                break;
            case 18:
                IBinder readStrongBinder7 = parcel.readStrongBinder();
                if (readStrongBinder7 != null) {
                    IInterface queryLocalInterface7 = readStrongBinder7.queryLocalInterface("com.google.android.gms.measurement.api.internal.IStringProvider");
                    if (queryLocalInterface7 instanceof zzx) {
                        zzxVar = (zzx) queryLocalInterface7;
                    } else {
                        zzxVar = new zzw(readStrongBinder7);
                    }
                }
                setInstanceIdProvider(zzxVar);
                break;
            case 19:
                IBinder readStrongBinder8 = parcel.readStrongBinder();
                if (readStrongBinder8 != null) {
                    IInterface queryLocalInterface8 = readStrongBinder8.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface8 instanceof zzs) {
                        zzsVar10 = (zzs) queryLocalInterface8;
                    } else {
                        zzsVar10 = new zzq(readStrongBinder8);
                    }
                }
                getCachedAppInstanceId(zzsVar10);
                break;
            case 20:
                IBinder readStrongBinder9 = parcel.readStrongBinder();
                if (readStrongBinder9 != null) {
                    IInterface queryLocalInterface9 = readStrongBinder9.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface9 instanceof zzs) {
                        zzsVar9 = (zzs) queryLocalInterface9;
                    } else {
                        zzsVar9 = new zzq(readStrongBinder9);
                    }
                }
                getAppInstanceId(zzsVar9);
                break;
            case 21:
                IBinder readStrongBinder10 = parcel.readStrongBinder();
                if (readStrongBinder10 != null) {
                    IInterface queryLocalInterface10 = readStrongBinder10.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface10 instanceof zzs) {
                        zzsVar8 = (zzs) queryLocalInterface10;
                    } else {
                        zzsVar8 = new zzq(readStrongBinder10);
                    }
                }
                getGmpAppId(zzsVar8);
                break;
            case 22:
                IBinder readStrongBinder11 = parcel.readStrongBinder();
                if (readStrongBinder11 != null) {
                    IInterface queryLocalInterface11 = readStrongBinder11.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface11 instanceof zzs) {
                        zzsVar7 = (zzs) queryLocalInterface11;
                    } else {
                        zzsVar7 = new zzq(readStrongBinder11);
                    }
                }
                generateEventId(zzsVar7);
                break;
            case 23:
                beginAdUnitExposure(parcel.readString(), parcel.readLong());
                break;
            case 24:
                endAdUnitExposure(parcel.readString(), parcel.readLong());
                break;
            case 25:
                onActivityStarted(b.a.x0(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 26:
                onActivityStopped(b.a.x0(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 27:
                onActivityCreated(b.a.x0(parcel.readStrongBinder()), (Bundle) zzc.zzc(parcel, Bundle.CREATOR), parcel.readLong());
                break;
            case 28:
                onActivityDestroyed(b.a.x0(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 29:
                onActivityPaused(b.a.x0(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 30:
                onActivityResumed(b.a.x0(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 31:
                b x0 = b.a.x0(parcel.readStrongBinder());
                IBinder readStrongBinder12 = parcel.readStrongBinder();
                if (readStrongBinder12 != null) {
                    IInterface queryLocalInterface12 = readStrongBinder12.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface12 instanceof zzs) {
                        zzsVar6 = (zzs) queryLocalInterface12;
                    } else {
                        zzsVar6 = new zzq(readStrongBinder12);
                    }
                }
                onActivitySaveInstanceState(x0, zzsVar6, parcel.readLong());
                break;
            case 32:
                Bundle bundle2 = (Bundle) zzc.zzc(parcel, Bundle.CREATOR);
                IBinder readStrongBinder13 = parcel.readStrongBinder();
                if (readStrongBinder13 != null) {
                    IInterface queryLocalInterface13 = readStrongBinder13.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface13 instanceof zzs) {
                        zzsVar5 = (zzs) queryLocalInterface13;
                    } else {
                        zzsVar5 = new zzq(readStrongBinder13);
                    }
                }
                performAction(bundle2, zzsVar5, parcel.readLong());
                break;
            case 33:
                logHealthData(parcel.readInt(), parcel.readString(), b.a.x0(parcel.readStrongBinder()), b.a.x0(parcel.readStrongBinder()), b.a.x0(parcel.readStrongBinder()));
                break;
            case 34:
                IBinder readStrongBinder14 = parcel.readStrongBinder();
                if (readStrongBinder14 != null) {
                    IInterface queryLocalInterface14 = readStrongBinder14.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    if (queryLocalInterface14 instanceof zzv) {
                        zzvVar3 = (zzv) queryLocalInterface14;
                    } else {
                        zzvVar3 = new zzt(readStrongBinder14);
                    }
                }
                setEventInterceptor(zzvVar3);
                break;
            case 35:
                IBinder readStrongBinder15 = parcel.readStrongBinder();
                if (readStrongBinder15 != null) {
                    IInterface queryLocalInterface15 = readStrongBinder15.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    if (queryLocalInterface15 instanceof zzv) {
                        zzvVar2 = (zzv) queryLocalInterface15;
                    } else {
                        zzvVar2 = new zzt(readStrongBinder15);
                    }
                }
                registerOnMeasurementEventListener(zzvVar2);
                break;
            case 36:
                IBinder readStrongBinder16 = parcel.readStrongBinder();
                if (readStrongBinder16 != null) {
                    IInterface queryLocalInterface16 = readStrongBinder16.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    if (queryLocalInterface16 instanceof zzv) {
                        zzvVar = (zzv) queryLocalInterface16;
                    } else {
                        zzvVar = new zzt(readStrongBinder16);
                    }
                }
                unregisterOnMeasurementEventListener(zzvVar);
                break;
            case 37:
                initForTests(zzc.zzf(parcel));
                break;
            case 38:
                IBinder readStrongBinder17 = parcel.readStrongBinder();
                if (readStrongBinder17 != null) {
                    IInterface queryLocalInterface17 = readStrongBinder17.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface17 instanceof zzs) {
                        zzsVar4 = (zzs) queryLocalInterface17;
                    } else {
                        zzsVar4 = new zzq(readStrongBinder17);
                    }
                }
                getTestFlag(zzsVar4, parcel.readInt());
                break;
            case 39:
                setDataCollectionEnabled(zzc.zza(parcel));
                break;
            case 40:
                IBinder readStrongBinder18 = parcel.readStrongBinder();
                if (readStrongBinder18 != null) {
                    IInterface queryLocalInterface18 = readStrongBinder18.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface18 instanceof zzs) {
                        zzsVar3 = (zzs) queryLocalInterface18;
                    } else {
                        zzsVar3 = new zzq(readStrongBinder18);
                    }
                }
                isDataCollectionEnabled(zzsVar3);
                break;
            case 41:
            default:
                return false;
            case 42:
                setDefaultEventParameters((Bundle) zzc.zzc(parcel, Bundle.CREATOR));
                break;
            case 43:
                clearMeasurementEnabled(parcel.readLong());
                break;
            case 44:
                setConsent((Bundle) zzc.zzc(parcel, Bundle.CREATOR), parcel.readLong());
                break;
            case 45:
                setConsentThirdParty((Bundle) zzc.zzc(parcel, Bundle.CREATOR), parcel.readLong());
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
