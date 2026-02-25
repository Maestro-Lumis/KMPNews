import SwiftUI
import shared

class NewsListVm: ObservableObject {
    @Published var news: [NewsItem] = []

    private lazy var vm: NewsViewModel = NewsViewModel()

    func getNews() {
        vm.observeNews { [weak self] items in
            DispatchQueue.main.async {
                self?.news = items
            }
        }
        vm.loadNews()
    }
}