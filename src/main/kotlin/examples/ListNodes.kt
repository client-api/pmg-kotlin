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

import com.clientapi.pmg.Pve
import com.clientapi.pmg.infrastructure.ApiClient

fun main() {
    val host = System.getenv("PMG_HOST") ?: "https://localhost:8006"
    ApiClient.apiKey["Authorization"] = System.getenv("PMG_TOKEN") ?: ""

    val pmg = Pve(basePath = "$host/api2/json")
    val response = pmg.nodes().nodesGetNodes()
    val nodes = response.data ?: emptyList()
    println("Found ${nodes.size} node(s):")
    for (n in nodes) {
        println("  - ${n.node} (status=${n.status}, cpu=${n.cpu}, mem=${n.mem}/${n.maxmem})")
    }
}
