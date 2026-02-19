import SwiftUI
import shared

@main
struct iOSApp: App {
    @UIApplicationDelegateAdaptor(AppDelegate.self) var appDelegate

    var body: some Scene {
        WindowGroup {
            NewsListView()
        }
    }
}

class AppDelegate: NSObject, UIApplicationDelegate {
    var notificationManager: NotificationManagerImpl?

    func application(
        _ application: UIApplication,
        didFinishLaunchingWithOptions launchOptions:
            [UIApplication.LaunchOptionsKey: Any]? = nil
    ) -> Bool {
        notificationManager = NotificationManagerImpl(
            platformNotifier: PlatformNotifierIOS()
        )
        notificationManager?.setNotificationHandler { payload in
            // Обработка уведомлений
        }
        return true
    }
}