

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1197_prim {
	static int V, E;
	static long min;

	static class Edge implements Comparable<Edge> {
		int v;
		int w;


		public Edge(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}


		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}

	}

	static PriorityQueue<Edge> points;
	
	static List<Edge>[] adj;
	// kruskal
	static int[] p;
	static int[] r;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		points = new PriorityQueue<>();
		
		adj = new ArrayList[V+1];
		for (int i = 0; i < V+1; i++) {
			adj[i] = new ArrayList();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj[s].add(new Edge(e,w));
			adj[e].add(new Edge(s,w));
//			points.offer(new Edge(s, e, w));
		}
//		p = new int[V + 1];
//		r = new int[V + 1];
//		makeSet();
//		int cnt = 0;
//		min = 0;
//		while (cnt != V-1) {
//			Edge edge = points.poll();
//			if (union(edge.s, edge.e)) {
//				cnt++;
//				min += edge.w;
//			}
//
//		}
		System.out.println(prim());
	}
	private static long prim() {
		min = 0L;
		boolean[] visited = new boolean[V+1];   
		points.offer(new Edge(1,0)); // 임의 접점 시작 가능
		int cnt=0;
		while(!points.isEmpty()) {
			Edge edge=points.poll();
			if(visited[edge.v]) continue;
			min+=edge.w;
			visited[edge.v]=true;
			if(++cnt==V) return min; // V-1 모두 찾으면
			for (int i = 0; i < adj[edge.v].size(); i++) {
				Edge next=adj[edge.v].get(i);
				if(visited[next.v]) continue;
				points.offer(next);
			}
		}
		return min;
	}
	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x == y)
			return false; // Cycle 발생 false
		if (r[x] < r[y]) {
			r[y] += r[x];
			p[x] = y;
		} else {
			r[x] += r[y];
			p[y] = y;
		}
		return true;
	}

	private static int find(int x) {
		if (x == p[x])
			return p[x];
		else
			return p[x] = find(p[x]);
	}

	private static void makeSet() {
		for (int i = 0; i < V + 1; i++) {
			p[i] = i;

		}
		for (int i = 0; i < V + 1; i++) {
			r[i] = 1;
		}

	}
}
