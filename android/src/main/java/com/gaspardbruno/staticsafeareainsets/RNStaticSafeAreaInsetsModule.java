package com.gaspardbruno.staticsafeareainsets;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

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

    @ReactMethod
    public void sampleMethod(String stringArgument, int numberArgument, Callback callback) {
        // TODO: Implement
    }
}