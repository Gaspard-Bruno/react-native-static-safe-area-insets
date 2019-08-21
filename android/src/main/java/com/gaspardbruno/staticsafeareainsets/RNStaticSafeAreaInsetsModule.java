package com.gaspardbruno.staticsafeareainsets;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.util.Map;
import java.util.HashMap;

import android.view.WindowInsets;
import android.view.View;
import android.os.Build;
import android.app.Activity;

public class RNStaticSafeAreaInsetsModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNStaticSafeAreaInsetsModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNStaticSafeAreaInsets";
  }

  @Override
  public Map<String, Object> getConstants() {
    return this._getSafeAreaInsets();
  }

  private Map<String, Object> _getSafeAreaInsets() {
    final Map<String, Object> constants = new HashMap<>();

    if (getCurrentActivity() != null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
      final Activity activity = getCurrentActivity();
      final View view = activity.getWindow().getDecorView();
      final WindowInsets insets = view.getRootWindowInsets();

      constants.put("safeAreaInsetsTop", insets.getSystemWindowInsetTop());
      constants.put("safeAreaInsetsBottom", insets.getSystemWindowInsetBottom());
      constants.put("safeAreaInsetsLeft", insets.getSystemWindowInsetLeft());
      constants.put("safeAreaInsetsRight", insets.getSystemWindowInsetRight());
    } else {
      constants.put("safeAreaInsetsTop", 0);
      constants.put("safeAreaInsetsBottom", 0);
      constants.put("safeAreaInsetsLeft", 0);
      constants.put("safeAreaInsetsRight", 0);
    }

    return constants;
  }

  @ReactMethod
  public Map<String, Object> getSafeAreaInsets(Callback cb) {
    cb.invoke(this._getSafeAreaInsets());
  }
}
