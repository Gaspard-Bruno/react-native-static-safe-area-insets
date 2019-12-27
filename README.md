# React Native Static Safe Area Insets

React Native package that exposes the Safe Area insets as constants (iOS and Android notch are supported).

## Getting started

### React Native 0.60 or above
```sh
yarn add react-native-static-safe-area-insets
cd ios && pod install # for iOS
```

### React Native 0.59

```sh
yarn add react-native-static-safe-area-insets
react-native link react-native-static-safe-area-insets
```

## Usage

### Constants
```javascript
import StaticSafeAreaInsets from 'react-native-static-safe-area-insets';

console.log('SafeArea insets top:', StaticSafeAreaInsets.safeAreaInsetsTop)
// SafeArea insets top: 44

console.log('SafeArea insets bottom:', StaticSafeAreaInsets.safeAreaInsetsBottom)
// SafeArea insets bottom: 34

console.log('SafeArea insets left:', StaticSafeAreaInsets.safeAreaInsetsLeft)
// SafeArea insets left: 44

console.log('SafeArea insets right:', StaticSafeAreaInsets.safeAreaInsetsRight)
// SafeArea insets right: 44
```

### Current Insets
```javascript
import StaticSafeAreaInsets from 'react-native-static-safe-area-insets';

StaticSafeAreaInsets.getSafeAreaInsets((values) => {
  console.log('SafeArea insets top:', values.safeAreaInsetsTop)
  // SafeArea insets top: 44

  console.log('SafeArea insets bottom:', values.safeAreaInsetsBottom)
  // SafeArea insets bottom: 34

  console.log('SafeArea insets left:', values.safeAreaInsetsLeft)
  // SafeArea insets left: 44

  console.log('SafeArea insets right:', values.safeAreaInsetsRight)
  // SafeArea insets right: 44
})
```

This method is usefull for cases when you want to get the new insets when the device orientation changes.
