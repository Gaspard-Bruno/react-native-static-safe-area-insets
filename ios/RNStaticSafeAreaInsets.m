#import "RNStaticSafeAreaInsets.h"
#import <UIKit/UIKit.h>

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
            @"safeAreaInsetsTop": self.getSafeAreaInsetsTop,
            @"safeAreaInsetsBottom": self.getSafeAreaInsetsBottom,
            @"safeAreaInsetsLeft": self.getSafeAreaInsetsLeft,
            @"safeAreaInsetsRight": self.getSafeAreaInsetsRight
            };
}

- (NSNumber *) getSafeAreaInsetsTop
{
    if (@available(iOS 11.0, *)) {
        return @(UIApplication.sharedApplication.keyWindow.safeAreaInsets.top);
    } else {
        return @(0);
    }
}

- (NSNumber *) getSafeAreaInsetsBottom
{
    if (@available(iOS 11.0, *)) {
        return @(UIApplication.sharedApplication.keyWindow.safeAreaInsets.bottom);
    } else {
        return @(0);
    }
}

- (NSNumber *) getSafeAreaInsetsLeft
{
    if (@available(iOS 11.0, *)) {
        return @(UIApplication.sharedApplication.keyWindow.safeAreaInsets.left);
    } else {
        return @(0);
    }
}

- (NSNumber *) getSafeAreaInsetsRight
{
    if (@available(iOS 11.0, *)) {
        return @(UIApplication.sharedApplication.keyWindow.safeAreaInsets.right);
    } else {
        return @(0);
    }
}

RCT_EXPORT_METHOD(getSafeAreaInsetsTop:(RCTResponseSenderBlock)callback){
    if (@available(iOS 11.0, *)) {
        callback(@[[NSNull null], @(UIApplication.sharedApplication.keyWindow.safeAreaInsets.top)]);
    } else {
        callback(@[[NSNull null], @(0)]);
    }
}

RCT_EXPORT_METHOD(getSafeAreaInsetsBottom:(RCTResponseSenderBlock)callback){
    if (@available(iOS 11.0, *)) {
        callback(@[[NSNull null], @(UIApplication.sharedApplication.keyWindow.safeAreaInsets.bottom)]);
    } else {
        callback(@[[NSNull null], @(0)]);
    }
}

RCT_EXPORT_METHOD(getSafeAreaInsetsLeft:(RCTResponseSenderBlock)callback){
    if (@available(iOS 11.0, *)) {
        callback(@[[NSNull null], @(UIApplication.sharedApplication.keyWindow.safeAreaInsets.left)]);
    } else {
        callback(@[[NSNull null], @(0)]);
    }
}

RCT_EXPORT_METHOD(getSafeAreaInsetsRight:(RCTResponseSenderBlock)callback){
    if (@available(iOS 11.0, *)) {
        callback(@[[NSNull null], @(UIApplication.sharedApplication.keyWindow.safeAreaInsets.right)]);
    } else {
        callback(@[[NSNull null], @(0)]);
    }
}

@end
