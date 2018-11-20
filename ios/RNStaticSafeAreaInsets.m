#import "RNStaticSafeAreaInsets.h"

@implementation RNStaticSafeAreaInsets

RCT_EXPORT_MODULE()

- (dispatch_queue_t)methodQueue
{
  return dispatch_get_main_queue();
}

+ (BOOL)requiresMainQueueSetup
{
  return YES;
}

- (NSDictionary *)constantsToExport
{
  return @{
    @"safeAreaInsetsTop": @(UIApplication.sharedApplication.keyWindow.safeAreaInsets.top),
    @"safeAreaInsetsBottom": @(UIApplication.sharedApplication.keyWindow.safeAreaInsets.bottom)
  };
}

@end
