// Example: list cluster nodes.
//
// Run with:
//
//   PMG_HOST=https://pmg.example.com:8006 \
//   PMG_TOKEN='PMGAPIToken=root@pam!auto=...' \
//   ./gradlew run -PmainClass=examples.ListNodesKt
//
// Or compile + run with kotlin CLI directly.
package examples

import com.clientapi.pmg.apis.NodesApi
import com.clientapi.pmg.infrastructure.ApiClient

fun main() {
    val host = System.getenv("PMG_HOST") ?: "https://localhost:8006"
    ApiClient.apiKey["Authorization"] = System.getenv("PMG_TOKEN") ?: ""

    // Non-PVE products: the upstream apidoc declares this endpoint
    // `returns: { type: null }`, so `response.data` is untyped. Print
    // the whole response and let the user see what came back.
    val response = NodesApi(basePath = "$host/api2/json").nodesGetNodes()
    println("Response: $response")
}
