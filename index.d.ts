declare module 'react-native-static-safe-area-insets' {
  class StaticSafeAreaInsets {
    public static safeAreaInsetsTop: number;
    public static safeAreaInsetsBottom: number;
    public static safeAreaInsetsLeft: number;
    public static safeAreaInsetsRight: number;
    public static getSafeAreaInsets(callback:(insets:{
      safeAreaInsetsTop: number;
      safeAreaInsetsBottom: number;
      safeAreaInsetsLeft: number;
      safeAreaInsetsRight: number;
    }) => void): void;
  }

  export default StaticSafeAreaInsets;
}
