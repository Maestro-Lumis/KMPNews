import SwiftUI
import shared

struct NewsListView: SwiftUI.View {
    @ObservedObject var model = NewsListVm()

    var body: some SwiftUI.View {
        NavigationView {
            List(Array(model.news.enumerated()), id: \.offset) { _, item in
                NavigationLink(
                    destination: NewsItemDetailView(item: item)
                ) {
                    NewsItemRow(item: item)
                }
            }
            .navigationTitle("News")
        }
        .onAppear {
            model.getNews()
        }
    }
}

struct NewsItemRow: SwiftUI.View {
    let item: NewsItem

    var body: some SwiftUI.View {
        VStack(alignment: .leading, spacing: 7) {
            Text(item.title)
                .lineLimit(4)
                .bold()
            Text(item.description ?? "")
                .lineLimit(4)
                .font(.subheadline)
            Text(item.publishedAt ?? "")
                .font(.caption)
        }
        .padding(.vertical, 4)
    }
}

struct NewsItemDetailView: SwiftUI.View {
    let item: NewsItem

    var body: some SwiftUI.View {
        VStack(alignment: .leading, spacing: 16) {
            Text(item.title)
                .font(.title2)
                .bold()
            Text(item.description ?? "")
                .font(.body)
            Text(item.publishedAt ?? "")
                .font(.caption)
            Spacer()
        }
        .padding()
        .navigationTitle("News")
    }
}