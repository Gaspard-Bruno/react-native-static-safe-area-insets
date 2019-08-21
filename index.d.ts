declare module 'react-native-static-safe-area-insets' {
  class StaticSafeAreaInsets {
    public static safeAreaInsetsTop: number;
    public static safeAreaInsetsBottom: number;
    public static safeAreaInsetsLeft: number;
    public static safeAreaInsetsRight: number;
    public static getSafeAreaInsetsTop(): number;
    public static getSafeAreaInsetsBottom(): number;
    public static getSafeAreaInsetsLeft(): number;
    public static getSafeAreaInsetsRight(): number;
  }

  export default StaticSafeAreaInsets;
}
