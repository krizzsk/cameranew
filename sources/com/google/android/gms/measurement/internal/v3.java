package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.WorkerThread;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class v3 {
    private final String a;
    private final Bundle b;
    private Bundle c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ z3 f3951d;

    public v3(z3 z3Var, String str, Bundle bundle) {
        this.f3951d = z3Var;
        com.google.android.gms.common.internal.q.f("default_event_parameters");
        this.a = "default_event_parameters";
        this.b = new Bundle();
    }

    @WorkerThread
    public final Bundle a() {
        char c;
        if (this.c == null) {
            String string = this.f3951d.n().getString(this.a, null);
            if (string != null) {
                try {
                    Bundle bundle = new Bundle();
                    JSONArray jSONArray = new JSONArray(string);
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        try {
                            JSONObject jSONObject = jSONArray.getJSONObject(i2);
                            String string2 = jSONObject.getString("n");
                            String string3 = jSONObject.getString("t");
                            int hashCode = string3.hashCode();
                            if (hashCode == 100) {
                                if (string3.equals("d")) {
                                    c = 1;
                                }
                                c = 65535;
                            } else if (hashCode != 108) {
                                if (hashCode == 115 && string3.equals("s")) {
                                    c = 0;
                                }
                                c = 65535;
                            } else {
                                if (string3.equals("l")) {
                                    c = 2;
                                }
                                c = 65535;
                            }
                            if (c == 0) {
                                bundle.putString(string2, jSONObject.getString("v"));
                            } else if (c == 1) {
                                bundle.putDouble(string2, Double.parseDouble(jSONObject.getString("v")));
                            } else if (c != 2) {
                                this.f3951d.a.a().m().b("Unrecognized persisted bundle type. Type", string3);
                            } else {
                                bundle.putLong(string2, Long.parseLong(jSONObject.getString("v")));
                            }
                        } catch (NumberFormatException | JSONException unused) {
                            this.f3951d.a.a().m().a("Error reading value from SharedPreferences. Value dropped");
                        }
                    }
                    this.c = bundle;
                } catch (JSONException unused2) {
                    this.f3951d.a.a().m().a("Error loading bundle from SharedPreferences. Values will be lost");
                }
            }
            if (this.c == null) {
                this.c = this.b;
            }
        }
        return this.c;
    }

    @WorkerThread
    public final void b(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        SharedPreferences.Editor edit = this.f3951d.n().edit();
        if (bundle.size() == 0) {
            edit.remove(this.a);
        } else {
            String str = this.a;
            JSONArray jSONArray = new JSONArray();
            for (String str2 : bundle.keySet()) {
                Object obj = bundle.get(str2);
                if (obj != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("n", str2);
                        jSONObject.put("v", String.valueOf(obj));
                        if (obj instanceof String) {
                            jSONObject.put("t", "s");
                        } else if (obj instanceof Long) {
                            jSONObject.put("t", "l");
                        } else if (obj instanceof Double) {
                            jSONObject.put("t", "d");
                        } else {
                            this.f3951d.a.a().m().b("Cannot serialize bundle value to SharedPreferences. Type", obj.getClass());
                        }
                        jSONArray.put(jSONObject);
                    } catch (JSONException e2) {
                        this.f3951d.a.a().m().b("Cannot serialize bundle value to SharedPreferences", e2);
                    }
                }
            }
            edit.putString(str, jSONArray.toString());
        }
        edit.apply();
        this.c = bundle;
    }
}
