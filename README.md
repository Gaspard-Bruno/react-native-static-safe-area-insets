# React Native Static Safe Area Insets

[![MIT License](https://img.shields.io/apm/l/atomic-design-ui)](https://github.com/Gaspard-Bruno/react-native-static-safe-area-insets/blob/main/LICENSE)
[![GitHub last commit](https://img.shields.io/github/last-commit/Gaspard-Bruno/react-native-static-safe-area-insets)](https://github.com/Gaspard-Bruno/react-native-static-safe-area-insets/graphs/commit-activity)

React Native package that exposes the Safe Area insets as constants (iOS and Android notch are supported).

## Getting Started

### Install
```sh
yarn add react-native-static-safe-area-insets
cd ios && pod install # for iOS
```

### Usage

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

## Roadmap
- Continue to support iOS & Android API updates

## Contributing
Pull requests are welcome! Feel free to open issues and submit PRs, we will review them and answer back as fast as possible.

## 🚀 Authors

- [@jpamarohorta](https://www.github.com/jpamarohorta)
- [@CarlosUvaSilva](https://www.github.com/CarlosUvaSilva)
